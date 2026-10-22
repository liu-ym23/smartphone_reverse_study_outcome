package com.bytedance.android.live.profile.ui.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(TextView r2) {
        if (r2 == null) goto L16;
        Context r0 = r2.getContext();
        if (r0 == null) goto L17;
        AssetManager r1 = r0.getAssets();
        if (r1 == null) goto L18;
        Typeface r3 = Typeface.createFromAsset(r1, "fonts/clarity_mono_bold.otf");     // Catch: Exception -> L11
        if (r3 == null) goto L19;
        r2.setTypeface(r3);     // Catch: Exception -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L11
        return;
    L19:
        return;
    L11:
        e = move-exception;
        ALogger.i(NewProfileInfoViewModel.TAG, "load font error!-" + e);
        Unit r5 = Unit.INSTANCE;
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void b(HSImageView r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$nullUrl");
        r1.setImageURI(null);
    }

    public static void c(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
    L10:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewBorderColor error: " + e.getMessage());
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        Drawable r3 = r1.getBackground();     // Catch: Exception -> L10
        if ((r3 instanceof GradientDrawable) == false) goto L15;
        r3.mutate();     // Catch: Exception -> L10
        ((GradientDrawable) r3).setStroke(s1.f(0.5f), Color.parseColor(r2));     // Catch: Exception -> L10
        return;
    }

    public static void d(View r3, int r4) {
        if ((r3 instanceof TextView) == false) goto L6;
        ((TextView) r3).setTextColor(r4);
        return;
    L6:
        if ((r3 instanceof ImageView) == false) goto L11;
        if ((r3 instanceof HSImageView) == true) goto L22;
        ((ImageView) r3).setColorFilter(r4);
        return;
    L22:
        return;
    L11:
        if ((r3 instanceof ViewGroup) == false) goto L24;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L13:
        if (r1 >= r0) goto L25;
        View r2 = r5.getChildAt(r1);
        if (r2 == null) goto L17;
        d(r2, r4);
    L17:
        r1 = r1 + 1;
        goto L13
    L25:
        return;
    }

    public static void e(View r1, String r2) {
    L11:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewColor error: " + e.getMessage());
        return;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (r1 == null) goto L16;
        if (r2 == null) goto L8;
        String r3 = StringsKt.trim(r2).toString();     // Catch: Exception -> L11
    L9:
        d(r1, Color.parseColor(r3));     // Catch: Exception -> L11
        return;
    L8:
        r3 = null;
        goto L9
    }

    public static void f(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
    L20:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewDrawableColor error: " + e.getMessage());
        return;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        Drawable r5 = r3.getBackground();     // Catch: Exception -> L20
        String r1 = null;
        if ((r5 instanceof GradientDrawable) == false) goto L14;
        r5.mutate();     // Catch: Exception -> L20
        GradientDrawable r0 = (GradientDrawable) r5;     // Catch: Exception -> L20
        if (r4 == null) goto L11;
        String r2 = StringsKt.trim(r4).toString();     // Catch: Exception -> L20
    L12:
        r0.setColor(Color.parseColor(r2));     // Catch: Exception -> L20
        goto L14
    L11:
        r2 = null;
    L14:
        if ((r5 instanceof ColorDrawable) == false) goto L25;
        r5.mutate();     // Catch: Exception -> L20
        ColorDrawable r6 = (ColorDrawable) r5;     // Catch: Exception -> L20
        if (r4 == null) goto L18;
        r1 = StringsKt.trim(r4).toString();     // Catch: Exception -> L20
    L18:
        r6.setColor(Color.parseColor(r1));     // Catch: Exception -> L20
        return;
    }

    public static void g(List r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "views");
        Iterator r3 = r1.iterator();     // Catch: Exception -> L11
    L5:
        if (r3.hasNext() == false) goto L22;
        View r0 = (View) r3.next();     // Catch: Exception -> L11
        if (r0 == null) goto L5;
        d(r0, r2);     // Catch: Exception -> L11
        goto L5
    L22:
        return;
    L11:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewsColor error: " + e.getMessage());
    }

    public static void h(List r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "views");
        if (TextUtils.isEmpty(r2) == false) goto L16;
        return;
    L16:
        int r3 = Color.parseColor(r2);     // Catch: Exception -> L13
        Iterator r4 = r1.iterator();     // Catch: Exception -> L13
    L7:
        if (r4.hasNext() == false) goto L24;
        View r0 = (View) r4.next();     // Catch: Exception -> L13
        if (r0 == null) goto L7;
        d(r0, r3);     // Catch: Exception -> L13
        goto L7
    L24:
        return;
    L13:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewsColor error: " + e.getMessage());
    }
}
