package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider r10, Intent r11);
    }

    private class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        final /* synthetic */ ShareActionProvider this$0;

        ShareActivityChooserModelPolicy(ShareActionProvider r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel r10, Intent r11) {
            ShareActionProvider r12 = this.this$0;
            OnShareTargetSelectedListener r13 = r12.mOnShareTargetSelectedListener;
            if (r13 == null) goto L7;
            r13.onShareTargetSelected(r12, r11);
            return false;
        L7:
            return false;
        }
    }

    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShareActionProvider this$0;

        ShareMenuItemOnMenuItemClickListener(ShareActionProvider r10) {
            this.this$0 = r10;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r10) {
            ShareActionProvider r11 = this.this$0;
            Intent r12 = ActivityChooserModel.get(r11.mContext, r11.mShareHistoryFileName).chooseActivity(r10.getItemId());
            if (r12 == null) goto L12;
            String r13 = r12.getAction();
            if ("android.intent.action.SEND".equals(r13) == false) goto L7;
        L8:
            this.this$0.updateIntent(r12);
        L9:
            this.this$0.mContext.startActivity(r12);
            return true;
        L7:
            if ("android.intent.action.SEND_MULTIPLE".equals(r13) == false) goto L9;
        L12:
            return true;
        }
    }

    public ShareActionProvider(Context r10) {
        super(r10);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = r10;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener != null) goto L6;
        return;
    L6:
        if (this.mOnChooseActivityListener != null) goto L8;
        this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView r10 = new ActivityChooserView(this.mContext);
        if (r10.isInEditMode() == true) goto L5;
        r10.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
    L5:
        TypedValue r11 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, r11, true);
        r10.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, r11.resourceId));
        r10.setProvider(this);
        r10.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        r10.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return r10;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu r10) {
        r10.clear();
        ActivityChooserModel r11 = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        PackageManager r12 = this.mContext.getPackageManager();
        int r13 = r11.getActivityCount();
        int r14 = Math.min(r13, this.mMaxShownActivityCount);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        ResolveInfo r16 = r11.getActivity(r15);
        r10.add(0, r15, r15, r16.loadLabel(r12)).setIcon(r16.loadIcon(r12)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r15 = r15 + 1;
        goto L3
    L5:
        if (r14 >= r13) goto L9;
        SubMenu r17 = r10.addSubMenu(0, r14, r14, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
        int r18 = 0;
    L7:
        if (r18 >= r13) goto L12;
        ResolveInfo r19 = r11.getActivity(r18);
        r17.add(0, r18, r18, r19.loadLabel(r12)).setIcon(r19.loadIcon(r12)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r18 = r18 + 1;
        goto L7
    L12:
        return;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener r10) {
        this.mOnShareTargetSelectedListener = r10;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String r10) {
        this.mShareHistoryFileName = r10;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent r10) {
        if (r10 == null) goto L8;
        String r11 = r10.getAction();
        if ("android.intent.action.SEND".equals(r11) == false) goto L6;
    L7:
        updateIntent(r10);
        goto L8
    L6:
        if ("android.intent.action.SEND_MULTIPLE".equals(r11) == true) goto L7;
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(r10);
    }

    void updateIntent(Intent r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        int r11 = 134742016;
    L6:
        r10.addFlags(r11);
        return;
    L5:
        r11 = 524288;
        goto L6
    }
}
