package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
        boolean onShareTargetSelected(ShareActionProvider r5, Intent r10);
    }

    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        final /* synthetic */ ShareActionProvider this$0;

        public ShareActivityChooserModelPolicy(ShareActionProvider r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel r5, Intent r10) {
            ShareActionProvider r11 = this.this$0;
            OnShareTargetSelectedListener r12 = r11.mOnShareTargetSelectedListener;
            if (r12 == null) goto L7;
            r12.onShareTargetSelected(r11, r10);
            return false;
        L7:
            return false;
        }
    }

    public class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShareActionProvider this$0;

        public ShareMenuItemOnMenuItemClickListener(ShareActionProvider r5) {
            this.this$0 = r5;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r5) {
            ShareActionProvider r10 = this.this$0;
            Intent r11 = ActivityChooserModel.get(r10.mContext, r10.mShareHistoryFileName).chooseActivity(r5.getItemId());
            if (r11 == null) goto L12;
            String r12 = r11.getAction();
            if ("android.intent.action.SEND".equals(r12) == false) goto L7;
        L8:
            this.this$0.updateIntent(r11);
        L9:
            this.this$0.mContext.startActivity(r11);
            return true;
        L7:
            if ("android.intent.action.SEND_MULTIPLE".equals(r12) == false) goto L9;
        L12:
            return true;
        }
    }

    public ShareActionProvider(Context r5) {
        super(r5);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = r5;
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
        ActivityChooserView r5 = new ActivityChooserView(this.mContext);
        if (r5.isInEditMode() == true) goto L5;
        r5.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
    L5:
        TypedValue r10 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, r10, true);
        r5.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, r10.resourceId));
        r5.setProvider(this);
        r5.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        r5.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return r5;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu r10) {
        r10.clear();
        ActivityChooserModel r5 = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        PackageManager r11 = this.mContext.getPackageManager();
        int r12 = r5.getActivityCount();
        int r13 = Math.min(r12, this.mMaxShownActivityCount);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        ResolveInfo r15 = r5.getActivity(r14);
        r10.add(0, r14, r14, r15.loadLabel(r11)).setIcon(r15.loadIcon(r11)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r14 = r14 + 1;
        goto L3
    L5:
        if (r13 >= r12) goto L9;
        SubMenu r16 = r10.addSubMenu(0, r13, r13, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
        int r17 = 0;
    L7:
        if (r17 >= r12) goto L12;
        ResolveInfo r18 = r5.getActivity(r17);
        r16.add(0, r17, r17, r18.loadLabel(r11)).setIcon(r18.loadIcon(r11)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r17 = r17 + 1;
        goto L7
    L12:
        return;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener r5) {
        this.mOnShareTargetSelectedListener = r5;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String r5) {
        this.mShareHistoryFileName = r5;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent r5) {
        if (r5 == null) goto L8;
        String r10 = r5.getAction();
        if ("android.intent.action.SEND".equals(r10) == false) goto L6;
    L7:
        updateIntent(r5);
        goto L8
    L6:
        if ("android.intent.action.SEND_MULTIPLE".equals(r10) == true) goto L7;
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(r5);
    }

    public void updateIntent(Intent r5) {
        r5.addFlags(134742016);
    }
}
