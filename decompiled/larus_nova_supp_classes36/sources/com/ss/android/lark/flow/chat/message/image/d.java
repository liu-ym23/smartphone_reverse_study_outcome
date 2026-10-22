package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Function1<Continuation<? super Bitmap>, Object>, SuspendFunction {
    public final /* synthetic */ Context a;
    public final /* synthetic */ PhotoItem b;

    public final Object invoke(Object r6) {
        f r0 = f.a;
        Context r1 = this.a;
        PhotoItem r2 = this.b;
        CoroutineDispatcher r3 = Dispatchers.getIO();
        FlowImageLoaderUtils$loadCover$2 r4 = new FlowImageLoaderUtils$loadCover$2(r2, r1, null);
        return BuildersKt.withContext(r3, r4, (Continuation) r6);
    }

    public d(Context r1, PhotoItem r2) {
        this.a = r1;
        this.b = r2;
    }
}
