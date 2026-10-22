package com.obric.memorydata.middleware.impl.image;

import android.net.Uri;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.middleware.impl.image.GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1", f = "GlobalImageManager.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
final class GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1 extends SuspendLambda implements Function2<al, Continuation<? super UriFileAccessSession>, Object> {
    final /* synthetic */ ImageUploadEntity $entity;
    int label;

    GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1(ImageUploadEntity r3, Continuation<? super GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$entity = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1(this.$entity, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super UriFileAccessSession> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super UriFileAccessSession> r4) {
        return ((GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        AtomicCapabilitySdk r8 = AtomicCapabilitySdk.INSTANCE;
        String r2 = this.$entity.getPackageName();
        Uri r3 = Uri.parse(this.$entity.getUri());
        Intrinsics.checkNotNullExpressionValue(r3, "parse(...)");
        Continuation<? super UriFileAccessSession> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = r8.openFileDescriptorPrivileged(r2, r3, r4);
        if (r7 != r0) goto L11;
        return r0;
    }
}
