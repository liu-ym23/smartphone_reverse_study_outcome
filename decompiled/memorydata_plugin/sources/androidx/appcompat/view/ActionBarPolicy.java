package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static ActionBarPolicy get(Context r2) {
        return new ActionBarPolicy((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public boolean enableHomeButtonByDefault() {
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) goto L5;
        return true;
    L5:
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration r3 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getConfiguration();
        int r0 = r3.screenWidthDp;
        int r1 = r3.screenHeightDp;
        if (r3.smallestScreenWidthDp > 600) goto L27;
        if (r0 <= 600) goto L6;
        return 5;
    L6:
        if (r0 <= 960) goto L8;
        if (r1 <= 720) goto L8;
        return 5;
    L8:
        if (r0 <= 720) goto L12;
        if (r1 <= 960) goto L12;
        return 5;
    L12:
        if (r0 < 500) goto L14;
        return 4;
    L14:
        if (r0 <= 640) goto L16;
        if (r1 <= 480) goto L16;
        return 4;
    L16:
        if (r0 <= 480) goto L20;
        if (r1 <= 640) goto L20;
        return 4;
    L20:
        if (r0 < 360) goto L23;
        return 3;
    L23:
        return 2;
    L27:
        return 5;
    }

    public int getStackedTabMaxWidth() {
        return ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_action_bar_stacked_tab_max_width, "dimen", "abc_action_bar_stacked_tab_max_width"));
    }

    public int getTabContainerHeight() {
        TypedArray r0 = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, ZeusTransformUtils.mapRes(R.attr.actionBarStyle, "attr", "actionBarStyle"), 0);
        int r1 = r0.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.ActionBar_height, "styleable", "ActionBar_height"), 0);
        Resources r2 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin");
        if (hasEmbeddedTabs() == true) goto L5;
        r1 = Math.min(r1, r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_action_bar_stacked_max_height, "dimen", "abc_action_bar_stacked_max_height")));
    L5:
        r0.recycle();
        return r1;
    }

    public boolean hasEmbeddedTabs() {
        return ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getBoolean(ZeusTransformUtils.mapRes(R.bool.abc_action_bar_embed_tabs, "bool", "abc_action_bar_embed_tabs"));
    }

    public boolean showsOverflowMenuButton() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        return true;
    L6:
        return !ViewConfiguration.get(this.mContext).hasPermanentMenuKey();
    }
}
