package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1", f = "GenImagePlannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    public GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1(Uri r1, Continuation<? super GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1> r2) {
        this.$uri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1(this.$uri, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r4);
        Uri r5 = this.$uri;
        Intrinsics.checkNotNullParameter(r5, "uri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        ParcelFileDescriptor r6 = com.larus.canvas.feature.component.logic.helper.g.a(AppHost.a.getApplication().getContentResolver(), r5);     // Catch: Throwable -> L23
        boolean r1 = true;
        if (r6 != null) goto L34;
    L21:
        Object r7 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L23
    L25:
        Boolean r2 = Boolean.TRUE;
        if (Result.isFailure-impl(r7) == false) goto L29;
        r7 = r2;
    L29:
        return Boxing.boxBoolean(((Boolean) r7).booleanValue());
    L34:
        int r3 = new ExifInterface(r6.getFileDescriptor()).getAttributeInt("Orientation", 1);     // Catch: Throwable -> L16
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L12;
    L14:
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L23
    L12:
        r1 = false;
        goto L14
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
