package com.larus.avlink.gallery;

import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1", f = "GalleryDirConnectEnsurer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1(Continuation<? super GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r10);
        e.a.getClass();
        e.a();
        if (e.i() == true) goto L28;
    L24:
        FLogger.a.i("GalleryDirConnectEnsurer", "gallery directories ensured on device connected");
        return Unit.INSTANCE;
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        File r4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);     // Catch: Throwable -> L19
        PolarisFileWrapper r5 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), e.k());     // Catch: Throwable -> L19
        if (StringsKt.startsWith$default(r5.getCanonicalPath(), r4.getCanonicalPath() + File.separator, false, 2, null) == true) goto L11;
        FLogger.a.w("GalleryPaths", "public album dir escapes pictures root, skip");     // Catch: Throwable -> L19
    L17:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L24;
        FLogger.a.w("GalleryPaths", "public album dir create error: " + r1.getMessage());
        goto L24
    L11:
        if (r5.exists() == false) goto L14;
        FLogger.a.i("GalleryPaths", "public album dir already exists: " + r5.getPath());     // Catch: Throwable -> L19
        goto L17
    L14:
        if (r5.mkdirs() == false) goto L16;
        FLogger.a.i("GalleryPaths", "public album dir created: " + r5.getPath());     // Catch: Throwable -> L19
        goto L17
    L16:
        FLogger.a.w("GalleryPaths", "public album dir create failed: " + r5.getPath());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
