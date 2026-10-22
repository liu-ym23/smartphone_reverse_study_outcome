package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.migration.sdk.z;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1", f = "AutoMemoryCollectionListActivity.kt", i = {}, l = {UploadKeys.KeyIsSkipMeta}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends File>>, Object> {
    final /* synthetic */ y $item;
    int label;

    AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1(y r3, Continuation<? super AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$item = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1(this.$item, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends File>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends File>> r4) {
        return ((AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionListActivity$exportAutoMemoryBuildPackage$2$exportResult$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        long r3 = this.$item.a();
        File r5 = com.obric.memorydata.datatransport.api.d.f9726a.c();
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r11 = h.a(r3, r5, null, r7, 4, null);
        if (r11 != r0) goto L11;
        return r0;
    }
}
