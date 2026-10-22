package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<View> f3982a = null;

    static {
        f3982a = new AnonymousClass1();
    }

    private static ImageView a(Toolbar r5, Drawable r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r5.getChildCount()) goto L18;
        View r2 = r5.getChildAt(r1);
        if (ZeusTransformUtils.instanceOf(r2, ImageView.class) == false) goto L17;
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.memorydata.plugin");
        Drawable r4 = r3.getDrawable();
        if (r4 == null) goto L17;
        if (r4.getConstantState() == null) goto L17;
        if (r4.getConstantState().equals(r6.getConstantState()) == false) goto L17;
        return r3;
    L17:
        r1 = r1 + 1;
        goto L7
    L18:
        return null;
    }

    public static TextView a(Toolbar r2) {
        List<TextView> r3 = a(r2, r2.getTitle());
        if (r3.isEmpty() == false) goto L6;
        return null;
    L6:
        return (TextView) ZeusTransformUtils.preCheckCast(Collections.min(r3, f3982a), TextView.class, "com.obric.memorydata.plugin");
    }

    private static List<TextView> a(Toolbar r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= r5.getChildCount()) goto L11;
        View r3 = r5.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r3, TextView.class) == false) goto L10;
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r4.getText(), r7) == false) goto L10;
        r0.add(r4);
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        return r0;
    }

    public static TextView b(Toolbar r2) {
        List<TextView> r3 = a(r2, r2.getSubtitle());
        if (r3.isEmpty() == false) goto L6;
        return null;
    L6:
        return (TextView) ZeusTransformUtils.preCheckCast(Collections.max(r3, f3982a), TextView.class, "com.obric.memorydata.plugin");
    }

    public static ImageView c(Toolbar r1) {
        return a(r1, r1.getLogo());
    }
}
