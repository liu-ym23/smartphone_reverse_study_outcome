package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$deleteFile$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$deleteFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    int label;

    public MmRecordFileHelper$deleteFile$2(String r1, Continuation<? super MmRecordFileHelper$deleteFile$2> r2) {
        this.$filePath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordFileHelper$deleteFile$2(this.$filePath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        h r4 = a.a;     // Catch: Throwable -> L9
        VFSFile r5 = a.c(this.$filePath);     // Catch: Throwable -> L9
        if (r5.exists() == false) goto L12;
        FilesKt.deleteRecursively(r5);     // Catch: Throwable -> L9
    L12:
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        lvb.a.b("MmRecordFileHelper", "[deleteFile] error:" + th);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
