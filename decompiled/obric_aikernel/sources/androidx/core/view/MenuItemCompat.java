package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenuItem;

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

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAlphabeticModifiers(MenuItem r10) {
            return r10.getAlphabeticModifiers();
        }

        @DoNotInline
        static CharSequence getContentDescription(MenuItem r10) {
            return r10.getContentDescription();
        }

        @DoNotInline
        static ColorStateList getIconTintList(MenuItem r10) {
            return r10.getIconTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getIconTintMode(MenuItem r10) {
            return r10.getIconTintMode();
        }

        @DoNotInline
        static int getNumericModifiers(MenuItem r10) {
            return r10.getNumericModifiers();
        }

        @DoNotInline
        static CharSequence getTooltipText(MenuItem r10) {
            return r10.getTooltipText();
        }

        @DoNotInline
        static MenuItem setAlphabeticShortcut(MenuItem r10, char r11, int r12) {
            return r10.setAlphabeticShortcut(r11, r12);
        }

        @DoNotInline
        static MenuItem setContentDescription(MenuItem r10, CharSequence r11) {
            return r10.setContentDescription(r11);
        }

        @DoNotInline
        static MenuItem setIconTintList(MenuItem r10, ColorStateList r11) {
            return r10.setIconTintList(r11);
        }

        @DoNotInline
        static MenuItem setIconTintMode(MenuItem r10, PorterDuff.Mode r11) {
            return r10.setIconTintMode(r11);
        }

        @DoNotInline
        static MenuItem setNumericShortcut(MenuItem r10, char r11, int r12) {
            return r10.setNumericShortcut(r11, r12);
        }

        @DoNotInline
        static MenuItem setShortcut(MenuItem r10, char r11, char r12, int r13, int r14) {
            return r10.setShortcut(r11, r12, r13, r14);
        }

        @DoNotInline
        static MenuItem setTooltipText(MenuItem r10, CharSequence r11) {
            return r10.setTooltipText(r11);
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r10);

        boolean onMenuItemActionExpand(MenuItem r10);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem r10) {
        return r10.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem r10) {
        return r10.expandActionView();
    }

    @Nullable
    public static ActionProvider getActionProvider(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    L5:
        return ((SupportMenuItem) r10).getSupportActionProvider();
    }

    @Deprecated
    public static View getActionView(MenuItem r10) {
        return r10.getActionView();
    }

    public static int getAlphabeticModifiers(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r10).getAlphabeticModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getAlphabeticModifiers(r10);
    }

    @Nullable
    public static CharSequence getContentDescription(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r10).getContentDescription();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getContentDescription(r10);
    }

    @Nullable
    public static ColorStateList getIconTintList(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r10).getIconTintList();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintList(r10);
    }

    @Nullable
    public static PorterDuff.Mode getIconTintMode(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r10).getIconTintMode();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintMode(r10);
    }

    public static int getNumericModifiers(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r10).getNumericModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getNumericModifiers(r10);
    }

    @Nullable
    public static CharSequence getTooltipText(@NonNull MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r10).getTooltipText();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getTooltipText(r10);
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem r10) {
        return r10.isActionViewExpanded();
    }

    @Nullable
    public static MenuItem setActionProvider(@NonNull MenuItem r10, @Nullable ActionProvider r11) {
        if ((r10 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r10;
    L5:
        return ((SupportMenuItem) r10).setSupportActionProvider(r11);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r10, int r11) {
        return r10.setActionView(r11);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r10, View r11) {
        return r10.setActionView(r11);
    }

    public static void setAlphabeticShortcut(@NonNull MenuItem r10, char r11, int r12) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setAlphabeticShortcut(r11, r12);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setAlphabeticShortcut(r10, r11, r12);
        return;
    }

    public static void setContentDescription(@NonNull MenuItem r10, @Nullable CharSequence r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setContentDescription(r11);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setContentDescription(r10, r11);
        return;
    }

    public static void setIconTintList(@NonNull MenuItem r10, @Nullable ColorStateList r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setIconTintList(r11);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintList(r10, r11);
        return;
    }

    public static void setIconTintMode(@NonNull MenuItem r10, @Nullable PorterDuff.Mode r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setIconTintMode(r11);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintMode(r10, r11);
        return;
    }

    public static void setNumericShortcut(@NonNull MenuItem r10, char r11, int r12) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setNumericShortcut(r11, r12);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setNumericShortcut(r10, r11, r12);
        return;
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem r10, final OnActionExpandListener r11) {
        return r10.setOnActionExpandListener(new AnonymousClass1(r11));
    }

    public static void setShortcut(@NonNull MenuItem r10, char r11, char r12, int r13, int r14) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setShortcut(r11, r12, r13, r14);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setShortcut(r10, r11, r12, r13, r14);
        return;
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r10, int r11) {
        r10.setShowAsAction(r11);
    }

    public static void setTooltipText(@NonNull MenuItem r10, @Nullable CharSequence r11) {
        if ((r10 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r10).setTooltipText(r11);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setTooltipText(r10, r11);
        return;
    }
}
