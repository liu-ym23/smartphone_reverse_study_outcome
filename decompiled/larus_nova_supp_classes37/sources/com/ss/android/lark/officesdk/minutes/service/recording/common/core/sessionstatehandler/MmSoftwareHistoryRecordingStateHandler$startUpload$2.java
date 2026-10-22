package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$startUpload$2", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {})
final class MmSoftwareHistoryRecordingStateHandler$startUpload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    public MmSoftwareHistoryRecordingStateHandler$startUpload$2(MmSoftwareHistoryRecordingStateHandler r1, Continuation<? super MmSoftwareHistoryRecordingStateHandler$startUpload$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareHistoryRecordingStateHandler$startUpload$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r24) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r24);
        Object r3 = r24;
    L11:
        ovb.b r4 = (ovb.b) r3;
        String r5 = r4.a;
        MmSoftwareHistoryRecordingStateHandler r1 = this.this$0;
        MmSoftwareHistoryRecordingStateHandler.Companion r6 = MmSoftwareHistoryRecordingStateHandler.h;
        MmRecordingSource r13 = r1.d().q(r5);
        if (this.this$0.a.v() == false) goto L14;
        String r7 = r4.c;
    L15:
        String r8 = r7;
        String r9 = this.this$0.a.b.getCurrentUserId();
        MmSoftwareHistoryRecordingStateHandler r10 = this.this$0;
        r10.getClass();
        MmRecordFileHelper.a.getClass();
        File[] r11 = MmRecordFileHelper.f(r9, r5).listFiles();
        ArrayList r12 = new ArrayList();
        int r14 = r11.length;
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L21;
        File r16 = r11[r15];
        if (Intrinsics.areEqual(FilesKt.getExtension(r16), "pcm") == false) goto L20;
        r12.add(r16);
    L20:
        r15 = r15 + 1;
        goto L16
    L21:
        Iterator r17 = r12.iterator();
    L23:
        if (r17.hasNext() == false) goto L53;
        VFSFile r18 = (VFSFile) r17.next();
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L46
        List r20 = StringsKt.split$default(FilesKt.getNameWithoutExtension(r18), new String[]{"_"}, false, 0, 6, null);     // Catch: Throwable -> L46
        int r21 = CastIntegerProtector.parseInt((String) CollectionsKt.first(r20));     // Catch: Throwable -> L46
        int r22 = CastIntegerProtector.parseInt((String) CollectionsKt.last(r20));     // Catch: Throwable -> L46
        String r110 = r5;
        MmRecordingSource r25 = r13;
        byte[] r23 = Oggopus_rustKt.encodeDataToOpus(r18.readBytes(), new OggOpusEncoderInputInfo(16000, 1), null);     // Catch: Throwable -> L43
        if (r23.length != 0) goto L30;
        boolean r111 = true;
    L32:
        if ((!r111) == true) goto L106;
        String r112 = r110;
    L41:
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L49:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L52;
        lvb.a.b(r10.b, "Encode pcm failed: " + r18.getName() + ", error: " + r27);
    L52:
        r13 = r25;
        r5 = r112;
        goto L23
    L106:
        MmRecordFileHelper.a.getClass();     // Catch: Throwable -> L38
        r112 = r110;
        VFSFile r113 = MmRecordFileHelper.f(r9, r112);     // Catch: Throwable -> L36
        com.ss.android.lark.vfs.h r114 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L36
        VFSFile r28 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r113, r21 + '_' + r22 + ".ogg");     // Catch: Throwable -> L36
        r28.writeBytes(r23);     // Catch: Throwable -> L36
        r18.delete();     // Catch: Throwable -> L36
        lvb.a.e(r10.b, "Encoded pcm to ogg: " + r28.getName());     // Catch: Throwable -> L36
    L36:
        th = th;
    L48:
        Result.Companion r29 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        th = th;
        r112 = r110;
        goto L48
    L30:
        r111 = false;
    L43:
        th = th;
        r112 = r110;
    L46:
        th = th;
        r112 = r5;
        r25 = r13;
        goto L48
    L53:
        MmRecordingSource r210 = r13;
        MmSoftwareHistoryRecordingStateHandler r30 = this.this$0;
        r30.getClass();
        MmRecordFileHelper.a.getClass();
        File[] r31 = MmRecordFileHelper.f(r9, r5).listFiles();
        if (r31 == null) goto L61;
        ArrayList r32 = new ArrayList();
        int r33 = r31.length;
        int r34 = 0;
    L56:
        if (r34 >= r33) goto L62;
        File r35 = r31[r34];
        if (Intrinsics.areEqual(FilesKt.getExtension(r35), "ogg") == false) goto L60;
        r32.add(r35);
    L60:
        r34 = r34 + 1;
    L62:
        if (r32 == null) goto L80;
        ?? r115 = new ArrayList();
        Iterator r36 = r32.iterator();
    L65:
        if (r36.hasNext() == false) goto L81;
        VFSFile r37 = (VFSFile) r36.next();
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L69
        List r39 = StringsKt.split$default(FilesKt.getNameWithoutExtension(r37), new String[]{"_"}, false, 0, 6, null);     // Catch: Throwable -> L69
        int r40 = CastIntegerProtector.parseInt((String) CollectionsKt.first(r39));     // Catch: Throwable -> L69
        int r116 = CastIntegerProtector.parseInt((String) CollectionsKt.last(r39));     // Catch: Throwable -> L69
        Object r41 = Result.constructor-impl(new MmRecordingUploadTask(r37.getAbsolutePath(), r40, r8, String.valueOf((r40 - 1) * r116), r116, r210, r30.a.v()));     // Catch: Throwable -> L69
    L71:
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 == null) goto L75;
        lvb.a.b(r30.b, "mapUploadTask error:" + r42);
    L75:
        if (Result.isFailure-impl(r41) == false) goto L77;
        r41 = null;
    L77:
        MmRecordingUploadTask r43 = (MmRecordingUploadTask) r41;
        if (r43 == null) goto L65;
        r115.add(r43);
    L69:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
    L81:
        List r45 = CollectionsKt.sortedWith((Iterable) r115, new h());
        if (r45.isEmpty() == false) goto L84;
        ((MmRecordingUploadService) this.this$0.f.getValue()).d();
    L99:
        return Unit.INSTANCE;
    L84:
        MmRecordingUploadService r46 = this.this$0.a.k();
        r46.getClass();
        Intrinsics.checkNotNullParameter(r45, "tasks");
        if (r45.isEmpty() == true) goto L94;
        List r47 = r45;
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator r49 = r47.iterator();
    L89:
        if (r49.hasNext() == false) goto L91;
        r48.add(Integer.valueOf(((MmRecordingUploadTask) r49.next()).b));
        goto L89
    L91:
        List r50 = CollectionsKt.distinct(r48);
        Integer r51 = (Integer) CollectionsKt.maxOrNull(r50);
        if (r51 == null) goto L94;
        int r52 = r51.intValue();
        int r53 = RangesKt.coerceAtLeast(r52 - r50.size(), 0);
        AtomicInteger r54 = r46.o;
        r54.set(Math.max(r54.get(), r52));
        AtomicInteger r55 = r46.n;
        r55.set(Math.max(r55.get(), r53));
        lvb.a.e(r46.c, "[restoreUploadProgressFromRemainingTasks] remainingSegIds=" + r50 + ", restoredUploaded=" + r53 + ", restoredTotal=" + r52);
    L94:
        Iterator r56 = r45.iterator();
    L96:
        if (r56.hasNext() == false) goto L99;
        this.this$0.a.k().c((MmRecordingUploadTask) r56.next());
        goto L96
    L80:
        r115 = CollectionsKt.emptyList();
        goto L81
    L61:
        r32 = null;
        goto L62
    L14:
        r7 = r4.d;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        MmRecordingSession r57 = this.this$0.a;
        this.label = 1;
        r3 = r57.r(this);
        if (r3 != r0) goto L11;
        return r0;
    }
}
