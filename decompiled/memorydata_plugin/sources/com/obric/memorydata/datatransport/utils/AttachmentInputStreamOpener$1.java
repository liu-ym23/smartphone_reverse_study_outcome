package com.obric.memorydata.datatransport.utils;

import android.net.Uri;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006H\n"}, d2 = {"<anonymous>", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "uri", "consume", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.utils.AttachmentInputStreamOpener$1", f = "AttachmentInputStreamOpener.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentInputStreamOpener$1 extends SuspendLambda implements Function4<String, String, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Integer>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    AttachmentInputStreamOpener$1(Continuation<? super AttachmentInputStreamOpener$1> r3) {
        super(4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function4
    public /* synthetic */ Object invoke(String r3, String r4, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Integer> r6) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(r5, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r2, String r3, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Integer> r5) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        AttachmentInputStreamOpener$1 r6 = new AttachmentInputStreamOpener$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
        r6.L$0 = r2;
        r6.L$1 = r3;
        r6.L$2 = r1;
        return r6.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        String r9 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4 = (Function2) ZeusTransformUtils.preCheckCast(this.L$2, Function2.class, "com.obric.memorydata.plugin");
        AtomicCapabilitySdk r5 = AtomicCapabilitySdk.INSTANCE;
        Uri r3 = Uri.parse(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "parse(...)");
        Continuation<? super Integer> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.L$1 = null;
        this.label = 1;
        r8 = r5.openInputStreamPrivileged(r9, r3, r4, r6);
        if (r8 != r0) goto L11;
        return r0;
    }
}
