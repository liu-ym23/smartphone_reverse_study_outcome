package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ToolbarUtils {
    private static final Comparator<View> VIEW_TOP_COMPARATOR = null;

    static {
        VIEW_TOP_COMPARATOR = new AnonymousClass1();
    }

    private ToolbarUtils() {
    }

    @Nullable
    public static ActionMenuItemView getActionMenuItemView(@NonNull Toolbar r5, @IdRes int r10) {
        ActionMenuView r11 = getActionMenuView(r5);
        if (r11 == null) goto L13;
        int r12 = 0;
    L6:
        if (r12 >= r11.getChildCount()) goto L19;
        View r13 = r11.getChildAt(r12);
        if ((r13 instanceof ActionMenuItemView) == false) goto L12;
        ActionMenuItemView r14 = (ActionMenuItemView) r13;
        if (r14.getItemData().getItemId() != r10) goto L12;
        return r14;
    L12:
        r12 = r12 + 1;
        goto L6
    L19:
        return null;
    L13:
        return null;
    }

    @Nullable
    public static ActionMenuView getActionMenuView(@NonNull Toolbar r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.getChildCount()) goto L10;
        View r11 = r5.getChildAt(r10);
        if ((r11 instanceof ActionMenuView) == true) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return (ActionMenuView) r11;
    L10:
        return null;
    }

    @Nullable
    private static ImageView getImageView(@NonNull Toolbar r5, @Nullable Drawable r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r5.getChildCount()) goto L18;
        View r12 = r5.getChildAt(r11);
        if ((r12 instanceof ImageView) == false) goto L17;
        ImageView r13 = (ImageView) r12;
        Drawable r14 = r13.getDrawable();
        if (r14 == null) goto L17;
        if (r14.getConstantState() == null) goto L17;
        if (r14.getConstantState().equals(r10.getConstantState()) == false) goto L17;
        return r13;
    L17:
        r11 = r11 + 1;
        goto L7
    L18:
        return null;
    }

    @Nullable
    public static ImageView getLogoImageView(@NonNull Toolbar r5) {
        return getImageView(r5, r5.getLogo());
    }

    @Nullable
    public static ImageButton getNavigationIconButton(@NonNull Toolbar r5) {
        Drawable r10 = r5.getNavigationIcon();
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r5.getChildCount()) goto L14;
        View r12 = r5.getChildAt(r11);
        if ((r12 instanceof ImageButton) == false) goto L13;
        ImageButton r13 = (ImageButton) r12;
        if (r13.getDrawable() != r10) goto L13;
        return r13;
    L13:
        r11 = r11 + 1;
        goto L7
    L14:
        return null;
    }

    @Nullable
    public static View getSecondaryActionMenuItemView(@NonNull Toolbar r5) {
        ActionMenuView r10 = getActionMenuView(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getChildCount() > 1) goto L7;
        return null;
    L7:
        return r10.getChildAt(0);
    }

    @Nullable
    public static TextView getSubtitleTextView(@NonNull Toolbar r5) {
        List<TextView> r10 = getTextViewsWithText(r5, r5.getSubtitle());
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return (TextView) Collections.max(r10, VIEW_TOP_COMPARATOR);
    }

    private static List<TextView> getTextViewsWithText(@NonNull Toolbar r5, CharSequence r10) {
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= r5.getChildCount()) goto L11;
        View r13 = r5.getChildAt(r12);
        if ((r13 instanceof TextView) == false) goto L10;
        TextView r14 = (TextView) r13;
        if (TextUtils.equals(r14.getText(), r10) == false) goto L10;
        r11.add(r14);
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        return r11;
    }

    @Nullable
    public static TextView getTitleTextView(@NonNull Toolbar r5) {
        List<TextView> r10 = getTextViewsWithText(r5, r5.getTitle());
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return (TextView) Collections.min(r10, VIEW_TOP_COMPARATOR);
    }
}
