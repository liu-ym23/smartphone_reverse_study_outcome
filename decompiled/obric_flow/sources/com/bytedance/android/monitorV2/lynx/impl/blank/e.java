package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.ui.image.FlattenUIImage;
import com.lynx.tasm.ui.image.FrescoFilterImageView;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIFilterImage;
import com.lynx.tasm.ui.image.UIImage;
import java.lang.reflect.Field;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3671b = null;

    static {
        f3670a = LazyKt.lazy(BlankViewDetector$xVideoPro$2.f3661a);
        f3671b = LazyKt.lazy(BlankViewDetector$xAlphaVideo$2.f3660a);
    }

    public static int a(Drawable r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        a r10 = new a();
        Intrinsics.checkNotNullParameter(r5, "drawer");
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r10, "canvas");     // Catch: Throwable -> L10
        r5.draw(r10);     // Catch: Throwable -> L10
        boolean r11 = r10.f3662a;     // Catch: Throwable -> L10
        r10.f3662a = false;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return r11 ? 1 : 0;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(LynxBaseUI r5) {
        Class r10 = (Class) f3670a.getValue();
        Class r11 = null;
        if (r10 != null) goto L5;
    L12:
        Class r12 = (Class) f3671b.getValue();
        if (r12 != null) goto L15;
        return 0;
    L15:
        if (r12.isAssignableFrom(r5.getClass()) == false) goto L17;
        r11 = r12;
    L17:
        if (r11 == null) goto L21;
        Field r13 = r5.getClass().getDeclaredField("mResourceURL");
        r13.setAccessible(true);
        boolean r14 = TextUtils.isEmpty((String) r13.get(r5));
    L11:
        return !r14;
    L21:
        return 0;
    L5:
        if (r10.isAssignableFrom(r5.getClass()) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L12;
        Field r15 = r5.getClass().getDeclaredField("mSrc");
        r15.setAccessible(true);
        r14 = TextUtils.isEmpty((String) r15.get(r5));
        goto L11
    }

    public static void c(View r10, Rect r11, HashSet r12, Function2 r13) {
        if (r10.getVisibility() == 0) goto L5;
        return;
    L5:
        if (r12.contains(r10) == true) goto L26;
        r12.add(r10);
        int r5 = 0;
        if ((r10 instanceof LynxView) == false) goto L15;
        int[] r14 = new int[2];
        r10.getLocationInWindow(r14);
        int r15 = r14[0];
        int r16 = r14[1];
        int r17 = r10.getWidth() + r15;
        int r18 = r14[1];
        Rect r19 = new Rect(r15, r16, r17, r10.getHeight() + r18);
        if (Rect.intersects(r11, r19) == false) goto L12;
    L13:
        ((BlankViewDetector$detect$1$1) r13).mo2invoke(r10, r19);
        goto L15
    L12:
        if (r11.contains(r19) == true) goto L13;
    L15:
        if ((r10 instanceof ViewGroup) == false) goto L19;
        ViewGroup r20 = (ViewGroup) r10;
        int r21 = r20.getChildCount();
    L17:
        if (r5 >= r21) goto L19;
        c(r20.getChildAt(r5), r11, r12, r13);
        r5 = r5 + 1;
    L19:
        Object r22 = r10.getParent();
        if ((r22 instanceof ViewGroup) == false) goto L25;
        c((View) r22, r11, r12, r13);
        return;
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(g r23, LynxBaseUI r24, int r25, int r26, int r27, int r28, int r29, int r30) {
        if ((r24 instanceof LynxUI) == false) goto L14;
        View r5 = ((LynxUI) r24).getView();
        if (r5.getVisibility() == 0) goto L7;
        return;
    L7:
        if (r5.getAlpha() >= 0.05d) goto L9;
        return;
    L9:
        if (r5.getScaleX() >= 0.01d) goto L11;
        return;
    L11:
        if (r5.getScaleY() < 0.01d) goto L125;
    L18:
        int r14 = 0;
        if (r24.getChildren().size() <= 0) goto L39;
        r23.a(r27, r28, r29, r30, a((BackgroundDrawable) r24.getLynxBackground().f10750b), r24.getClass().getSimpleName(), false);
        int r10 = r24.getChildren().size();
    L21:
        if (r14 >= r10) goto L127;
        LynxBaseUI r16 = r24.getChildAt(r14);
        if (r16 == null) goto L37;
        int r11 = r16.getLeft();
        int r12 = r16.getTop();
        if (((k5.g) com.bytedance.android.monitorV2.lynx.impl.c.f3682c.getValue()).a() == null) goto L28;
        r11 = r16.getOriginLeft();
        r12 = r16.getOriginTop();
    L28:
        int r13 = r25 + r11;
        int r15 = (r13 - r24.getScrollX()) + ((int) r16.getTranslationX());
        int r17 = r26 + r12;
        int r18 = (r17 - r24.getScrollY()) + ((int) r16.getTranslationY());
        int r19 = ((r16.getWidth() + r13) - r24.getScrollX()) + ((int) r16.getTranslationX());
        int r20 = ((r16.getHeight() + r17) - r24.getScrollY()) + ((int) r16.getTranslationY());
        if (r15 >= r29) goto L37;
        if (r18 >= r30) goto L37;
        if (r19 <= r27) goto L37;
        if (r20 <= r28) goto L37;
        if (r15 >= r19) goto L37;
        if (r18 >= r20) goto L37;
        d(r23, r16, r15, r18, Math.max(r27, r15), Math.max(r28, r18), Math.min(r29, r19), Math.min(r30, r20));
    L37:
        r14 = r14 + 1;
        goto L21
    L127:
        return;
    L39:
        if ((r24 instanceof UIText) == false) goto L44;
        if (((AndroidText) ((UIText) r24).getView()).getText().length() > 0) goto L87;
    L88:
        int r21 = 2;
    L54:
        int r22 = r21;
    L103:
        r23.a(r27, r28, r29, r30, r22, r24.getClass().getSimpleName(), true);
        return;
    L87:
        r22 = 1;
        goto L103
    L44:
        if ((r24 instanceof FlattenUIText) == false) goto L49;
        if (((FlattenUIText) r24).k().length() <= 0) goto L88;
    L49:
        if ((r24 instanceof UIFilterImage) == false) goto L56;
        UIFilterImage r31 = (UIFilterImage) r24;
        if (TextUtils.isEmpty(((FrescoFilterImageView) r31.getView()).getSrc()) == false) goto L87;
        r21 = a((BackgroundDrawable) r31.getLynxBackground().f10750b);
        goto L54
    L56:
        if ((r24 instanceof UIImage) == false) goto L62;
        UIImage r32 = (UIImage) r24;
        if (TextUtils.isEmpty(((FrescoImageView) r32.getView()).getSrc()) == false) goto L87;
        r21 = a((BackgroundDrawable) r32.getLynxBackground().f10750b);
        goto L54
    L62:
        if ((r24 instanceof FlattenUIImage) == false) goto L71;
        Field r33 = FlattenUIImage.class.getDeclaredField("mSources");     // Catch: Exception -> L65
        r33.setAccessible(true);     // Catch: Exception -> L65
        String r34 = (String) r33.get(r24);     // Catch: Exception -> L65
    L67:
        if (TextUtils.isEmpty(r34) == true) goto L69;
        r21 = a(((FlattenUIImage) r24).getImageDrawable());
        goto L54
    L69:
        r21 = a((BackgroundDrawable) ((FlattenUIImage) r24).getLynxBackground().f10750b);
    L65:
        r34 = null;
        goto L67
    L71:
        if ((r24 instanceof LynxUI) == false) goto L98;
        LynxUI r35 = (LynxUI) r24;
        if ((r35.getView() instanceof ImageView) == false) goto L76;
        View r36 = r35.getView();
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type android.widget.ImageView");
        r21 = a(((ImageView) r36).getDrawable());
        goto L54
    L76:
        if ((r35.getView() instanceof TextView) == false) goto L81;
        View r37 = r35.getView();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type android.widget.TextView");
        if (((TextView) r37).getText().length() <= 0) goto L88;
    L81:
        if ((r35.getView() instanceof TextureView) == false) goto L93;
        a r38 = new a();
        View r39 = r35.getView();
        Intrinsics.checkNotNullParameter(r39, "drawer");
        monitor-enter(r38);
        Intrinsics.checkNotNullParameter(r38, "canvas");     // Catch: Throwable -> L89
        r39.draw(r38);     // Catch: Throwable -> L89
        boolean r40 = r38.f3662a;     // Catch: Throwable -> L89
        r38.f3662a = false;     // Catch: Throwable -> L89
        monitor-exit(r38);
        if (r40 == false) goto L88;
    L89:
        th = move-exception;
        throw th;
    L93:
        if (r35.getView().getBackground() == null) goto L106;
        r21 = a(r35.getView().getBackground());
        goto L54
    L106:
        r21 = b(r24);     // Catch: Throwable -> L105
    L102:
        r22 = 0;
        goto L103
    L98:
        if ((r24 instanceof LynxFlattenUI) == false) goto L102;
        LynxFlattenUI r41 = (LynxFlattenUI) r24;
        if (r41.getLynxBackground() == null) goto L102;
        r21 = a((BackgroundDrawable) r41.getLynxBackground().f10750b);
        goto L54
    L125:
        return;
    L14:
        if ((r24 instanceof LynxFlattenUI) == true) goto L16;
        return;
    L16:
        if (((LynxFlattenUI) r24).getAlpha() >= 0.05d) goto L18;
    }
}
