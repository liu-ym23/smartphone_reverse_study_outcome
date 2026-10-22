package com.obric.memorydata.datatransport.utils;

import android.content.Context;
import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\n"}, d2 = {"<anonymous>", "", "uri", "", "consume", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.utils.AttachmentInputStreamOpener$2", f = "AttachmentInputStreamOpener.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentInputStreamOpener$2 extends SuspendLambda implements Function3<String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    AttachmentInputStreamOpener$2(Continuation<? super AttachmentInputStreamOpener$2> r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(String r3, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Unit> r5) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(r4, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r2, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super Unit> r4) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        AttachmentInputStreamOpener$2 r5 = new AttachmentInputStreamOpener$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        r5.L$0 = r2;
        r5.L$1 = r1;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(this.L$0, Closeable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8
    L20:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r7, null);
        return Unit.INSTANCE;
    L8:
        Throwable th = th;
    L33:
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        String r9 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(this.L$1, Function2.class, "com.obric.memorydata.plugin");
        InputStream r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().openInputStream(Uri.parse(r9));
        if (r4 == null) goto L30;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin");
        InputStream r5 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        this.L$0 = r10;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        if (r3.invoke(r5, this) != r0) goto L18;
        return r0;
    L18:
        r7 = r10;
    L23:
        th = move-exception;
        th = th;
        r7 = r10;
        goto L33
    L30:
        throw new FileNotFoundException("ContentResolver returned null for " + r9);
    }
}
