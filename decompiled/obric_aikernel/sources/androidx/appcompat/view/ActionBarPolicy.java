package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context r10) {
        this.mContext = r10;
    }

    public static ActionBarPolicy get(Context r10) {
        return new ActionBarPolicy(r10);
    }

    public boolean enableHomeButtonByDefault() {
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) goto L5;
        return true;
    L5:
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration r10 = this.mContext.getResources().getConfiguration();
        int r11 = r10.screenWidthDp;
        int r12 = r10.screenHeightDp;
        if (r10.smallestScreenWidthDp > 600) goto L27;
        if (r11 <= 600) goto L6;
        return 5;
    L6:
        if (r11 <= 960) goto L8;
        if (r12 <= 720) goto L8;
        return 5;
    L8:
        if (r11 <= 720) goto L12;
        if (r12 <= 960) goto L12;
        return 5;
    L12:
        if (r11 < 500) goto L14;
        return 4;
    L14:
        if (r11 <= 640) goto L16;
        if (r12 <= 480) goto L16;
        return 4;
    L16:
        if (r11 <= 480) goto L20;
        if (r12 <= 640) goto L20;
        return 4;
    L20:
        if (r11 < 360) goto L23;
        return 3;
    L23:
        return 2;
    L27:
        return 5;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray r10 = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int r11 = r10.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources r12 = this.mContext.getResources();
        if (hasEmbeddedTabs() == true) goto L5;
        r11 = Math.min(r11, r12.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    L5:
        r10.recycle();
        return r11;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        return true;
    L6:
        return !ViewConfiguration.get(this.mContext).hasPermanentMenuKey();
    }
}
