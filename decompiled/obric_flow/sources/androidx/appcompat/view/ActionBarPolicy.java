package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context r5) {
        this.mContext = r5;
    }

    public static ActionBarPolicy get(Context r5) {
        return new ActionBarPolicy(r5);
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
        Configuration r5 = this.mContext.getResources().getConfiguration();
        int r10 = r5.screenWidthDp;
        int r11 = r5.screenHeightDp;
        if (r5.smallestScreenWidthDp > 600) goto L27;
        if (r10 <= 600) goto L6;
        return 5;
    L6:
        if (r10 <= 960) goto L8;
        if (r11 <= 720) goto L8;
        return 5;
    L8:
        if (r10 <= 720) goto L12;
        if (r11 <= 960) goto L12;
        return 5;
    L12:
        if (r10 < 500) goto L14;
        return 4;
    L14:
        if (r10 <= 640) goto L16;
        if (r11 <= 480) goto L16;
        return 4;
    L16:
        if (r10 <= 480) goto L20;
        if (r11 <= 640) goto L20;
        return 4;
    L20:
        if (r10 < 360) goto L23;
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
        TypedArray r5 = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int r10 = r5.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources r11 = this.mContext.getResources();
        if (hasEmbeddedTabs() == true) goto L5;
        r10 = Math.min(r10, r11.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    L5:
        r5.recycle();
        return r10;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
