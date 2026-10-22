package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$copyRecordingDirToMeetingId$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$copyRecordingDirToMeetingId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fromSessionKey;
    final /* synthetic */ String $toMeetingId;
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$copyRecordingDirToMeetingId$2(String r1, String r2, String r3, Continuation<? super MmRecordFileHelper$copyRecordingDirToMeetingId$2> r4) {
        this.$userId = r1;
        this.$fromSessionKey = r2;
        this.$toMeetingId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordFileHelper$copyRecordingDirToMeetingId$2(this.$userId, this.$fromSessionKey, this.$toMeetingId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r15);
        boolean r16 = false;
        MmRecordFileHelper r3 = MmRecordFileHelper.a;     // Catch: Throwable -> L26
        String r4 = this.$userId;     // Catch: Throwable -> L26
        r3.getClass();     // Catch: Throwable -> L26
        VFSFile r5 = MmRecordFileHelper.g(r4);     // Catch: Throwable -> L26
        h r6 = a.a;     // Catch: Throwable -> L26
        VFSFile r7 = a.b(r5, this.$fromSessionKey);     // Catch: Throwable -> L26
        VFSFile r8 = a.b(r5, this.$toMeetingId);     // Catch: Throwable -> L26
        if (r7.exists() == true) goto L9;
        lvb.a.h("MmRecordFileHelper", "[copyRecordingDirToMeetingId] fromDir not exists: " + r7.getPath());     // Catch: Throwable -> L26
    L29:
        return Boxing.boxBoolean(r16);
    L9:
        if (r8.exists() == false) goto L11;
    L13:
        Ref.IntRef r1 = new Ref.IntRef();     // Catch: Throwable -> L26
        Ref.IntRef r2 = new Ref.IntRef();     // Catch: Throwable -> L26
        File[] r9 = r7.listFiles();     // Catch: Throwable -> L26
        if (r9 == null) goto L24;
        int r10 = r9.length;     // Catch: Throwable -> L26
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L24;
        File r12 = r9[r11];     // Catch: Throwable -> L26
        if (r12.isFile() == false) goto L23;
        h r13 = a.a;     // Catch: Throwable -> L26
        VFSFile r14 = a.b(r8, r12.getName());     // Catch: Throwable -> L26
        if (r14.exists() == false) goto L22;
        r2.element++;     // Catch: Throwable -> L26
        goto L23
    L22:
        FilesKt.copyTo$default(r12, r14, false, 0, 4, null);     // Catch: Throwable -> L26
        r1.element++;     // Catch: Throwable -> L26
    L23:
        r11 = r11 + 1;     // Catch: Throwable -> L26
    L24:
        lvb.a.e("MmRecordFileHelper", "[copyRecordingDirToMeetingId] success: " + this.$fromSessionKey + " -> " + this.$toMeetingId + ", copiedCount=" + r1.element + ", skippedCount=" + r2.element);     // Catch: Throwable -> L26
        r16 = true;
        goto L29
    L11:
        if (r8.mkdirs() == true) goto L13;
        lvb.a.b("MmRecordFileHelper", "[copyRecordingDirToMeetingId] mkdir toDir failed: " + r8.getPath());     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        lvb.a.b("MmRecordFileHelper", "[copyRecordingDirToMeetingId] error: " + th);
        goto L29
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
