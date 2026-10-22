package com.lynx.tasm.behavior.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Base64;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f10588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f10589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f10590c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Callback e;

    public m(float r5, Bitmap r10, Bitmap.CompressFormat r11, String r12, Callback r13) {
        this.f10588a = r5;
        this.f10589b = r10;
        this.f10590c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r5 = this.f10588a;
        Bitmap r10 = this.f10589b;
        if (r5 == 1.0f) goto L5;
        Matrix r11 = new Matrix();
        r11.setScale(r5, r5);
        Bitmap r12 = Bitmap.createBitmap(r10, 0, 0, r10.getWidth(), r10.getHeight(), r11, true);
        r10.recycle();
        r10 = r12;
    L5:
        Bitmap.CompressFormat r13 = this.f10590c;
        ByteArrayOutputStream r14 = null;
        String r15 = null;
        r15 = null;
        r15 = null;
        ByteArrayOutputStream r16 = null;
        if (r10 != null) goto L53;
        String r17 = null;
    L35:
        if (r16 != null) goto L47;
    L40:
        r15 = r17;
    L41:
        JavaOnlyMap r18 = new JavaOnlyMap();
        r18.putInt("width", r10.getWidth());
        r18.putInt("height", r10.getHeight());
        r18.putString("data", this.d + r15);
        this.e.invoke(new Object[]{0, r18});
        r10.recycle();
        return;
    L47:
        r16.flush();     // Catch: IOException -> L38
        r16.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L53:
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();     // Catch: Throwable -> L15 IOException -> L17
    L51:
        r10.compress(r13, 100, r19);     // Catch: Throwable -> L11 IOException -> L13
        r19.flush();     // Catch: Throwable -> L11 IOException -> L13
        r19.close();     // Catch: Throwable -> L11 IOException -> L13
        r17 = Base64.encodeToString(r19.toByteArray(), 2);     // Catch: Throwable -> L11 IOException -> L13
        r16 = r19;
        goto L35
    L13:
        e = e;
    L43:
        e.printStackTrace();     // Catch: Throwable -> L25
        if (r19 == null) goto L41;
        r19.flush();     // Catch: IOException -> L23
        r19.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
        r14 = r19;
    L27:
        r19 = r14;
    L28:
        if (r19 != null) goto L49;
    L33:
        throw th;
    L49:
        r19.flush();     // Catch: IOException -> L31
        r19.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L11:
        th = th;
    L17:
        e = e;
        r19 = null;
    L15:
        th = th;
        goto L27
    }
}
