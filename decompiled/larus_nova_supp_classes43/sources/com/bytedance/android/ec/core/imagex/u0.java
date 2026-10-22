package com.bytedance.android.ec.core.imagex;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.utility.Logger;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class u0 extends BaseDataSubscriber<Void> {
    public final ImageRequest a;
    public final r b;

    public static final class a {
    }

    static {
    }

    public abstract void a(File r1);

    public final void onFailureImpl(DataSource<Void> r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Boolean r1 = null;
        a(null);     // Catch: Throwable -> L7
        if (r10 == null) goto L5;
        r1 = Boolean.valueOf(r10.close());     // Catch: Throwable -> L7
    L5:
        Result.constructor-impl(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onNewResultImpl(DataSource<Void> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isFinished() == false) goto L70;
        Lazy r0 = ImageSettings.a;
        int r1 = ((Number) ImageSettings.o.getValue()).intValue();
        if (r1 == 1) goto L57;
        if (r1 != 2) goto L11;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L34
        CacheKey r12 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(this.a, this.b);     // Catch: Throwable -> L34
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L34
        int r14 = 0;
        BinaryResource r15 = null;
    L18:
        if (r15 != null) goto L23;
        r15 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r12);     // Catch: Throwable -> L34
        if (r15 != null) goto L22;
        r15 = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(r12);     // Catch: Throwable -> L34
    L22:
        r14 = r14 + 1;     // Catch: Throwable -> L34
        goto L18
    L23:
        Logger.d("SimpleDiskCachedFileDataSubscriber", "waiting file write to disk cache done, loop_count = " + r14 + ", duration = " + (System.currentTimeMillis() - r13));     // Catch: Throwable -> L34
        if ((r15 instanceof FileBinaryResource) == false) goto L31;
        File r16 = ((FileBinaryResource) r15).getFile();     // Catch: Throwable -> L34
        if (r16 != null) goto L28;
    L30:
        a(null);     // Catch: Throwable -> L34
    L32:
        Result.constructor-impl(Boolean.valueOf(r10.close()));     // Catch: Throwable -> L34
        return;
    L28:
        if (r16.exists() == false) goto L30;
        a(r16);     // Catch: Throwable -> L34
        goto L32
    L31:
        a(null);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L11:
        if (r1 != 3) goto L59;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SimpleDiskCachedFileDataSubscriber$handleResultWithCoroutine$1(this, r10, null), 2, null);
        return;
    L59:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L14
        Logger.d("SimpleDiskCachedFileDataSubscriber", "fetch image to disk is disabled");     // Catch: Throwable -> L14
        a(null);     // Catch: Throwable -> L14
        Result.constructor-impl(Boolean.valueOf(r10.close()));     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L57:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L54
        long r21 = System.currentTimeMillis();     // Catch: Throwable -> L54
        CacheKey r22 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(this.a, this.b);     // Catch: Throwable -> L54
        BinaryResource r23 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r22);     // Catch: Throwable -> L54
        if (r23 != null) goto L40;
        r23 = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(r22);     // Catch: Throwable -> L54
    L40:
        if (r23 == null) goto L42;
        String r24 = "success";
    L43:
        Logger.d("SimpleDiskCachedFileDataSubscriber", "get disk cache " + r24 + ", duration = " + (System.currentTimeMillis() - r21));     // Catch: Throwable -> L54
        if ((r23 instanceof FileBinaryResource) == false) goto L51;
        File r25 = ((FileBinaryResource) r23).getFile();     // Catch: Throwable -> L54
        if (r25 != null) goto L48;
    L50:
        a(null);     // Catch: Throwable -> L54
    L52:
        Result.constructor-impl(Boolean.valueOf(r10.close()));     // Catch: Throwable -> L54
        return;
    L48:
        if (r25.exists() == false) goto L50;
        a(r25);     // Catch: Throwable -> L54
        goto L52
    L51:
        a(null);     // Catch: Throwable -> L54
        goto L52
    L42:
        r24 = MessageIndication.STATUS_FAILED;
    L54:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public u0(ImageRequest r10, r r11) {
        Intrinsics.checkNotNullParameter(r10, "imageRequest");
        this.a = r10;
        this.b = r11;
    }
}
