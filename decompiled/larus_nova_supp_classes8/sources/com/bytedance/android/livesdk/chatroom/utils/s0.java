package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class s0 implements ObservableOnSubscribe {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ py.k b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ s0(py.k r2, int r3, int r4) {
        this.a = false;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter r10) {
        boolean r0 = this.a;
        py.k r1 = this.b;
        int r2 = this.c;
        int r3 = this.d;
        DataSource<CloseableReference<CloseableImage>> r4 = null;
        if (r0 == false) goto L5;
        DataSource<CloseableReference<CloseableImage>> r5 = a1.a(r1, r2, r3, r0, null);
    L22:
        if (r5 != null) goto L28;
        StringBuilder r6 = new StringBuilder("Cannot build requests from imageModel: ");
        if (r1 == null) goto L26;
        String r7 = r1.toString();
    L27:
        r6.append(r7);
        r10.onError(new IllegalArgumentException(r6.toString()));
        return;
    L26:
        r7 = "";
        goto L27
    L28:
        r5.subscribe(new v0(r10, r1), TTExecutors.getNormalExecutor());
        return;
    L5:
        ImageRequest[] r8 = a1.c(r1, r2, r3, Bitmap.Config.ARGB_8888, null);
        if (r8 != null) goto L8;
    L21:
        r5 = r4;
        goto L22
    L8:
        if (r8.length == 0) goto L21;
        ArrayList r9 = new ArrayList();
        int r11 = r8.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L18;
        ImageRequest r13 = r8[r12];
        if (r13 == null) goto L16;
        r9.add(Fresco.getImagePipeline().getDataSourceSupplier(r13, null, ImageRequest.RequestLevel.FULL_FETCH));
    L16:
        r12 = r12 + 1;
        goto L11
    L18:
        if (r9.isEmpty() == true) goto L21;
        r4 = FirstAvailableDataSourceSupplier.create(r9).get();
        goto L21
    }
}
