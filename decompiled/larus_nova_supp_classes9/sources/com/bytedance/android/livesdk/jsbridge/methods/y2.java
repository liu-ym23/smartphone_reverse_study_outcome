package com.bytedance.android.livesdk.jsbridge.methods;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.bpea.cert.token.TokenCert;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y2<V> implements Callable {
    public final /* synthetic */ w2 a;
    public final /* synthetic */ List b;

    public y2(w2 r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final List<OpenMultiSelectPhotoLibraryResultModel.b> call() {
        w2 r0 = this.a;
        List r1 = this.b;
        TokenCert r2 = w2.c;
        r0.getClass();
        ArrayList r3 = new ArrayList();
        if (r1 == null) goto L24;
        Iterator r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L24;
        LinkMediaModel r5 = (LinkMediaModel) r4.next();
        String r6 = r5.getFileLocalUriPath();
        if (r6 == null) goto L6;
        int r7 = com.bytedance.android.livesdk.utils.h2.a;
        long r8 = r5.getFileSize();
        long r9 = r0.a;
        Intrinsics.checkNotNullParameter(r6, "imageFilePath");
        BitmapFactory.Options r10 = new BitmapFactory.Options();
        int r11 = 1;
        r10.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r6, r10);
        int r13 = r10.outWidth;
        int r14 = r10.outHeight;
        if (r13 > 1080) goto L12;
        if (r14 > 1920) goto L12;
    L13:
        r10.inSampleSize = r11;
        r10.inJustDecodeBounds = false;
        Bitmap r15 = BitmapFactory.decodeFile(r6, r10);
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();
        long r17 = r9 * ((long) 1024);
        if (r8 <= 20971520) goto L17;
        int r18 = 60;
    L23:
        r15.compress(Bitmap.CompressFormat.JPEG, r18, r16);
        byte[] r19 = r16.toByteArray();
        int r20 = r19.length;
        String r21 = Base64.encodeToString(r19, 2);
        OpenMultiSelectPhotoLibraryResultModel.b r23 = new OpenMultiSelectPhotoLibraryResultModel.b();
        r23.b(r21);
        r23.c(r21);
        Unit r24 = Unit.INSTANCE;
        r3.add(r23);
        goto L6
    L17:
        if (r8 <= 15728640) goto L20;
        r18 = 70;
        goto L23
    L20:
        if (r8 <= r17) goto L22;
        r18 = 80;
        goto L23
    L22:
        r18 = 85;
    L12:
        r11 = Math.min(Math.round(r13 / 1080), Math.round(r14 / 1920));
    L24:
        return r3;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
