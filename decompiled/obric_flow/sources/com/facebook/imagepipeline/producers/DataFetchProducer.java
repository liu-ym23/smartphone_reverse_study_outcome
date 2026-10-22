package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class DataFetchProducer extends LocalFetchProducer {
    public DataFetchProducer(PooledByteBufferFactory r5) {
        super(CallerThreadExecutor.f7644a, r5);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "DataFetchProducer";
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r5) {
        String r10 = r5.f8415b.toString();
        if (r10.substring(0, 5).equals("data:") == false) goto L14;
        int r11 = r10.indexOf(44);
        String r12 = r10.substring(r11 + 1, r10.length());
        String r13 = r10.substring(0, r11);
        if (r13.contains(";") == true) goto L7;
        boolean r14 = false;
    L8:
        if (r14 == false) goto L10;
        byte[] r15 = Base64.decode(r12, 0);
    L12:
        return a(new ByteArrayInputStream(r15), r15.length);
    L10:
        r15 = Uri.decode(r12).getBytes();
        goto L12
    L7:
        String[] r16 = r13.split(";");
        r14 = r16[r16.length - 1].equals("base64");
        goto L8
    L14:
        throw new IllegalArgumentException();
    }
}
