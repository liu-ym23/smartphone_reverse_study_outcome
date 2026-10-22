package com.obric.miniapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Drawable a(Context r4, Drawable r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 != null) goto L9;
        return null;
    L9:
        Bitmap r1 = Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L8
        Canvas r2 = new Canvas(r1);     // Catch: Exception -> L8
        r5.setBounds(0, 0, r6, r7);     // Catch: Exception -> L8
        r5.draw(r2);     // Catch: Exception -> L8
        RenderScript r8 = RenderScript.create(r4);     // Catch: Exception -> L8
        Allocation r9 = Allocation.createFromBitmap(r8, r1);     // Catch: Exception -> L8
        Allocation r10 = Allocation.createTyped(r8, r9.getType());     // Catch: Exception -> L8
        ScriptIntrinsicBlur r3 = ScriptIntrinsicBlur.create(r8, Element.U8_4(r8));     // Catch: Exception -> L8
        r3.setRadius(4.0f);     // Catch: Exception -> L8
        r3.setInput(r9);     // Catch: Exception -> L8
        r3.forEach(r10);     // Catch: Exception -> L8
        r10.copyTo(r1);     // Catch: Exception -> L8
        BitmapDrawable r11 = new BitmapDrawable(r4.getResources(), r1);     // Catch: Exception -> L8
        r9.destroy();     // Catch: Exception -> L8
        r10.destroy();     // Catch: Exception -> L8
        r3.destroy();     // Catch: Exception -> L8
        r8.destroy();     // Catch: Exception -> L8
        return r11;
    L11:
        return null;
    }
}
