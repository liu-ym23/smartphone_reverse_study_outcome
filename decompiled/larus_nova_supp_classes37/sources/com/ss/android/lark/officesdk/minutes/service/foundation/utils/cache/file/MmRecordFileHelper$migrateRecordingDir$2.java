package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$migrateRecordingDir$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordFileHelper$migrateRecordingDir$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fromSessionKey;
    final /* synthetic */ String $toMeetingId;
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$migrateRecordingDir$2(String r1, String r2, String r3, Continuation<? super MmRecordFileHelper$migrateRecordingDir$2> r4) {
        this.$userId = r1;
        this.$fromSessionKey = r2;
        this.$toMeetingId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordFileHelper$migrateRecordingDir$2(this.$userId, this.$fromSessionKey, this.$toMeetingId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r9);
        boolean r10 = false;
        MmRecordFileHelper r5 = MmRecordFileHelper.a;     // Catch: Throwable -> L19
        String r6 = this.$userId;     // Catch: Throwable -> L19
        r5.getClass();     // Catch: Throwable -> L19
        VFSFile r7 = MmRecordFileHelper.g(r6);     // Catch: Throwable -> L19
        h r8 = a.a;     // Catch: Throwable -> L19
        VFSFile r11 = a.b(r7, this.$fromSessionKey);     // Catch: Throwable -> L19
        VFSFile r12 = a.b(r7, this.$toMeetingId);     // Catch: Throwable -> L19
        if (r11.exists() == true) goto L10;
        lvb.a.h("MmRecordFileHelper", "[migrateRecordingDir] fromDir not exists: " + r11.getPath());     // Catch: Throwable -> L19
        return Boxing.boxBoolean(false);
    L10:
        if (r12.exists() == false) goto L13;
        lvb.a.h("MmRecordFileHelper", "[migrateRecordingDir] toDir already exists: " + r12.getPath());     // Catch: Throwable -> L19
        FilesKt.deleteRecursively(r11);     // Catch: Throwable -> L19
        return Boxing.boxBoolean(true);
    L13:
        boolean r3 = r11.renameTo(r12);     // Catch: Throwable -> L19
        if (r3 == false) goto L17;
        lvb.a.e("MmRecordFileHelper", "[migrateRecordingDir] success: " + this.$fromSessionKey + " -> " + this.$toMeetingId);     // Catch: Throwable -> L19
    L18:
        r10 = r3;
    L22:
        return Boxing.boxBoolean(r10);
    L17:
        lvb.a.b("MmRecordFileHelper", "[migrateRecordingDir] rename failed: " + this.$fromSessionKey + " -> " + this.$toMeetingId);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        lvb.a.b("MmRecordFileHelper", "[migrateRecordingDir] error: " + th);
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
