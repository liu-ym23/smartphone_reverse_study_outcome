package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
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
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static int getAlphabeticModifiers(MenuItem r5) {
            return r5.getAlphabeticModifiers();
        }

        @DoNotInline
        public static CharSequence getContentDescription(MenuItem r5) {
            return r5.getContentDescription();
        }

        @DoNotInline
        public static ColorStateList getIconTintList(MenuItem r5) {
            return r5.getIconTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode getIconTintMode(MenuItem r5) {
            return r5.getIconTintMode();
        }

        @DoNotInline
        public static int getNumericModifiers(MenuItem r5) {
            return r5.getNumericModifiers();
        }

        @DoNotInline
        public static CharSequence getTooltipText(MenuItem r5) {
            return r5.getTooltipText();
        }

        @DoNotInline
        public static MenuItem setAlphabeticShortcut(MenuItem r5, char r10, int r11) {
            return r5.setAlphabeticShortcut(r10, r11);
        }

        @DoNotInline
        public static MenuItem setContentDescription(MenuItem r5, CharSequence r10) {
            return r5.setContentDescription(r10);
        }

        @DoNotInline
        public static MenuItem setIconTintList(MenuItem r5, ColorStateList r10) {
            return r5.setIconTintList(r10);
        }

        @DoNotInline
        public static MenuItem setIconTintMode(MenuItem r5, PorterDuff.Mode r10) {
            return r5.setIconTintMode(r10);
        }

        @DoNotInline
        public static MenuItem setNumericShortcut(MenuItem r5, char r10, int r11) {
            return r5.setNumericShortcut(r10, r11);
        }

        @DoNotInline
        public static MenuItem setShortcut(MenuItem r5, char r10, char r11, int r12, int r13) {
            return r5.setShortcut(r10, r11, r12, r13);
        }

        @DoNotInline
        public static MenuItem setTooltipText(MenuItem r5, CharSequence r10) {
            return r5.setTooltipText(r10);
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r5);

        boolean onMenuItemActionExpand(MenuItem r5);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem r5) {
        return r5.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem r5) {
        return r5.expandActionView();
    }

    @Nullable
    public static ActionProvider getActionProvider(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    L5:
        return ((SupportMenuItem) r5).getSupportActionProvider();
    }

    @Deprecated
    public static View getActionView(MenuItem r5) {
        return r5.getActionView();
    }

    public static int getAlphabeticModifiers(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r5).getAlphabeticModifiers();
    L7:
        return Api26Impl.getAlphabeticModifiers(r5);
    }

    @Nullable
    public static CharSequence getContentDescription(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r5).getContentDescription();
    L7:
        return Api26Impl.getContentDescription(r5);
    }

    @Nullable
    public static ColorStateList getIconTintList(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r5).getIconTintList();
    L7:
        return Api26Impl.getIconTintList(r5);
    }

    @Nullable
    public static PorterDuff.Mode getIconTintMode(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r5).getIconTintMode();
    L7:
        return Api26Impl.getIconTintMode(r5);
    }

    public static int getNumericModifiers(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r5).getNumericModifiers();
    L7:
        return Api26Impl.getNumericModifiers(r5);
    }

    @Nullable
    public static CharSequence getTooltipText(@NonNull MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r5).getTooltipText();
    L7:
        return Api26Impl.getTooltipText(r5);
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem r5) {
        return r5.isActionViewExpanded();
    }

    @Nullable
    public static MenuItem setActionProvider(@NonNull MenuItem r5, @Nullable ActionProvider r10) {
        if ((r5 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r5;
    L5:
        return ((SupportMenuItem) r5).setSupportActionProvider(r10);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r5, View r10) {
        return r5.setActionView(r10);
    }

    public static void setAlphabeticShortcut(@NonNull MenuItem r5, char r10, int r11) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setAlphabeticShortcut(r10, r11);
        return;
    L5:
        Api26Impl.setAlphabeticShortcut(r5, r10, r11);
    }

    public static void setContentDescription(@NonNull MenuItem r5, @Nullable CharSequence r10) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setContentDescription(r10);
        return;
    L5:
        Api26Impl.setContentDescription(r5, r10);
    }

    public static void setIconTintList(@NonNull MenuItem r5, @Nullable ColorStateList r10) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setIconTintList(r10);
        return;
    L5:
        Api26Impl.setIconTintList(r5, r10);
    }

    public static void setIconTintMode(@NonNull MenuItem r5, @Nullable PorterDuff.Mode r10) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setIconTintMode(r10);
        return;
    L5:
        Api26Impl.setIconTintMode(r5, r10);
    }

    public static void setNumericShortcut(@NonNull MenuItem r5, char r10, int r11) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setNumericShortcut(r10, r11);
        return;
    L5:
        Api26Impl.setNumericShortcut(r5, r10, r11);
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem r5, final OnActionExpandListener r10) {
        return r5.setOnActionExpandListener(new AnonymousClass1(r10));
    }

    public static void setShortcut(@NonNull MenuItem r5, char r10, char r11, int r12, int r13) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setShortcut(r10, r11, r12, r13);
        return;
    L5:
        Api26Impl.setShortcut(r5, r10, r11, r12, r13);
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r5, int r10) {
        r5.setShowAsAction(r10);
    }

    public static void setTooltipText(@NonNull MenuItem r5, @Nullable CharSequence r10) {
        if ((r5 instanceof SupportMenuItem) == false) goto L5;
        ((SupportMenuItem) r5).setTooltipText(r10);
        return;
    L5:
        Api26Impl.setTooltipText(r5, r10);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r5, int r10) {
        return r5.setActionView(r10);
    }
}
