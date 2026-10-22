package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Function1<Continuation<? super String>, Object>, SuspendFunction {
    public final /* synthetic */ Context a;
    public final /* synthetic */ PhotoItem b;

    public final Object invoke(Object r6) {
        Continuation r7 = (Continuation) r6;
        f r0 = f.a;
        Context r1 = this.a;
        PhotoItem r2 = this.b;
        StringBuilder r3 = new StringBuilder("downloadVideo, photoItem: ");
        MediaExtra r4 = r2.getMediaExtra();
        if (r4 == null) goto L7;
        String r5 = r4.getUrl();
        if (r5 == null) goto L7;
        Integer r8 = Boxing.boxInt(r5.hashCode());
    L8:
        r3.append(r8);
        r3.append(", key: ");
        MediaExtra r9 = r2.getMediaExtra();
        if (r9 == null) goto L13;
        String r10 = r9.getKey();
        if (r10 == null) goto L13;
        Integer r11 = Boxing.boxInt(r10.hashCode());
    L14:
        r3.append(r11);
        Log.i("FlowImageLoaderUtils", r3.toString());
        return BuildersKt.withContext(Dispatchers.getIO(), new FlowImageLoaderUtils$downloadVideo$2(r2, r1, null), r7);
    L13:
        r11 = null;
    L7:
        r8 = null;
        goto L8
    }

    public c(Context r1, PhotoItem r2) {
        this.a = r1;
        this.b = r2;
    }
}
