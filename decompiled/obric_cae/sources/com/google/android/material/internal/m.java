package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4888a = null;

    public class a implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View r8, View r10) {
            return r8.getTop() - r10.getTop();
        }
    }

    static {
        f4888a = new a();
    }

    public static ImageButton a(Toolbar r8) {
        Drawable r10 = r8.getNavigationIcon();
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r8.getChildCount()) goto L14;
        View r12 = r8.getChildAt(r11);
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

    public static ArrayList b(Toolbar r8, CharSequence r10) {
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= r8.getChildCount()) goto L11;
        View r13 = r8.getChildAt(r12);
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
}
