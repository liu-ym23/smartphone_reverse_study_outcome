package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getAlphabeticModifiers(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getAlphabeticModifiers();
        }

        static CharSequence getContentDescription(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getContentDescription();
        }

        static ColorStateList getIconTintList(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getIconTintList();
        }

        static PorterDuff.Mode getIconTintMode(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getIconTintMode();
        }

        static int getNumericModifiers(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getNumericModifiers();
        }

        static CharSequence getTooltipText(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getTooltipText();
        }

        static MenuItem setAlphabeticShortcut(MenuItem r2, char r3, int r4) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setAlphabeticShortcut(r3, r4);
        }

        static MenuItem setContentDescription(MenuItem r2, CharSequence r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setContentDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static MenuItem setIconTintList(MenuItem r2, ColorStateList r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setIconTintList(r3);
        }

        static MenuItem setIconTintMode(MenuItem r2, PorterDuff.Mode r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setIconTintMode(r3);
        }

        static MenuItem setNumericShortcut(MenuItem r2, char r3, int r4) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setNumericShortcut(r3, r4);
        }

        static MenuItem setShortcut(MenuItem r2, char r3, char r4, int r5, int r6) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setShortcut(r3, r4, r5, r6);
        }

        static MenuItem setTooltipText(MenuItem r2, CharSequence r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setTooltipText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r1);

        boolean onMenuItemActionExpand(MenuItem r1);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem r2) {
        return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem r2) {
        return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == true) goto L5;
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    L5:
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getSupportActionProvider();
    }

    @Deprecated
    public static View getActionView(MenuItem r2) {
        return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == false) goto L7;
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getAlphabeticModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getAlphabeticModifiers(r3);
    }

    public static CharSequence getContentDescription(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == false) goto L7;
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getContentDescription();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getContentDescription(r3);
    }

    public static ColorStateList getIconTintList(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == false) goto L7;
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getIconTintList();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintList(r3);
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == false) goto L7;
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getIconTintMode();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintMode(r3);
    }

    public static int getNumericModifiers(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == false) goto L7;
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getNumericModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getNumericModifiers(r3);
    }

    public static CharSequence getTooltipText(MenuItem r2) {
        MenuItem r3 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportMenuItem.class) == false) goto L7;
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r3, SupportMenuItem.class, "com.obric.memorydata.plugin")).getTooltipText();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getTooltipText(r3);
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem r2) {
        return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem r2, ActionProvider r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == true) goto L5;
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r4;
    L5:
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.memorydata.plugin")).setSupportActionProvider(r3);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r2, int r3) {
        return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setActionView(r3);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r2, View r3) {
        return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setActionView(r3);
    }

    public static void setAlphabeticShortcut(MenuItem r2, char r3, int r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r5, SupportMenuItem.class, "com.obric.memorydata.plugin")).setAlphabeticShortcut(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setAlphabeticShortcut(r5, r3, r4);
        return;
    }

    public static void setContentDescription(MenuItem r2, CharSequence r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.memorydata.plugin")).setContentDescription(r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setContentDescription(r4, r5);
        return;
    }

    public static void setIconTintList(MenuItem r2, ColorStateList r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.memorydata.plugin")).setIconTintList(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintList(r4, r3);
        return;
    }

    public static void setIconTintMode(MenuItem r2, PorterDuff.Mode r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.memorydata.plugin")).setIconTintMode(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintMode(r4, r3);
        return;
    }

    public static void setNumericShortcut(MenuItem r2, char r3, int r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r5, SupportMenuItem.class, "com.obric.memorydata.plugin")).setNumericShortcut(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setNumericShortcut(r5, r3, r4);
        return;
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem r2, OnActionExpandListener r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        final OnActionExpandListener r5 = (OnActionExpandListener) ZeusTransformUtils.wrapperContextForParams(r3, OnActionExpandListener.class, "com.obric.memorydata.plugin");
        return r4.setOnActionExpandListener(new AnonymousClass1(r5));
    }

    public static void setShortcut(MenuItem r2, char r3, char r4, int r5, int r6) {
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r7, SupportMenuItem.class, "com.obric.memorydata.plugin")).setShortcut(r3, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setShortcut(r7, r3, r4, r5, r6);
        return;
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r2, int r3) {
        ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setShowAsAction(r3);
    }

    public static void setTooltipText(MenuItem r2, CharSequence r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.memorydata.plugin")).setTooltipText(r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setTooltipText(r4, r5);
        return;
    }
}
