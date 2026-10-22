package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<View> f3451a = null;

    class a implements Comparator<View> {
        a() {
        }

        public int a(View r10, View r11) {
            return r10.getTop() - r11.getTop();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r10, View r11) {
            return a(r10, r11);
        }
    }

    static {
        f3451a = new a();
    }

    @Nullable
    private static ImageView a(@NonNull Toolbar r10, @Nullable Drawable r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.getChildCount()) goto L13;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof ImageView) == false) goto L12;
        ImageView r14 = (ImageView) r13;
        if (r11 == null) goto L12;
        if (r14.getDrawable().getConstantState().equals(r11.getConstantState()) == false) goto L12;
        return r14;
    L12:
        r12 = r12 + 1;
        goto L4
    L13:
        return null;
    }

    @Nullable
    public static ImageView b(@NonNull Toolbar r10) {
        return a(r10, r10.getLogo());
    }

    @Nullable
    public static TextView c(@NonNull Toolbar r10) {
        List<TextView> r11 = d(r10, r10.getSubtitle());
        if (r11.isEmpty() == false) goto L6;
        return null;
    L6:
        return (TextView) Collections.max(r11, f3451a);
    }

    private static List<TextView> d(@NonNull Toolbar r10, CharSequence r11) {
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L4:
        if (r13 >= r10.getChildCount()) goto L11;
        View r14 = r10.getChildAt(r13);
        if ((r14 instanceof TextView) == false) goto L10;
        TextView r15 = (TextView) r14;
        if (TextUtils.equals(r15.getText(), r11) == false) goto L10;
        r12.add(r15);
    L10:
        r13 = r13 + 1;
        goto L4
    L11:
        return r12;
    }

    @Nullable
    public static TextView e(@NonNull Toolbar r10) {
        List<TextView> r11 = d(r10, r10.getTitle());
        if (r11.isEmpty() == false) goto L6;
        return null;
    L6:
        return (TextView) Collections.min(r11, f3451a);
    }
}
