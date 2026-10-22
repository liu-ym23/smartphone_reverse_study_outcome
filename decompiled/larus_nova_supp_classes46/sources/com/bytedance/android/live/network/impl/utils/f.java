package com.bytedance.android.live.network.impl.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Runnable c;

    public f(boolean r1, View r2, Runnable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        Bitmap r2 = (Bitmap) r8;
        int r9 = h.a;
        Rect r10 = null;
        if (r2 == null) goto L5;
        byte[] r0 = r2.getNinePatchChunk();
    L6:
        if (r0 == null) goto L12;
        ByteBuffer r1 = ByteBuffer.wrap(r0).order(ByteOrder.nativeOrder());
        if (r1.get() == 0) goto L12;
        r1.get();
        r1.get();
        r1.get();
        r1.getInt();
        r1.getInt();
        r10 = new Rect();
        r10.left = r1.getInt();
        r10.right = r1.getInt();
        r10.top = r1.getInt();
        r10.bottom = r1.getInt();
    L12:
        if (r2 == null) goto L26;
        if (r2.getNinePatchChunk() == null) goto L26;
        if (r10 == null) goto L26;
        NinePatchDrawable r6 = new NinePatchDrawable(s1.getResources(), r2, r2.getNinePatchChunk(), r10, null);
        r6.setAutoMirrored(this.a);
        this.b.setBackgroundDrawable(r6);
        if (this.a == true) goto L19;
    L21:
        this.b.setPadding(r10.left, r10.top, r10.right, r10.bottom);
    L22:
        Runnable r11 = this.c;
        if (r11 == null) goto L30;
        r11.run();
        return;
    L30:
        return;
    L19:
        if (RTLUtil.isAppRTL(s1.getContext()) == false) goto L21;
        this.b.setPadding(r10.right, r10.top, r10.left, r10.bottom);
    L26:
        if (r2 == null) goto L28;
        ALogger.e("NinePatchUtil", "downloaded bitmap is null.");
        return;
    L28:
        ALogger.e("NinePatchUtil", "no ninepatch chunk found in bitmap.");
        return;
    L5:
        r0 = null;
        goto L6
    }
}
