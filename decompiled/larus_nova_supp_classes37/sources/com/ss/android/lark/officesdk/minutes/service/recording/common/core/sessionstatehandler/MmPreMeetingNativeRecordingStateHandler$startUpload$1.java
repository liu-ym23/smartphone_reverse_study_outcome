package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import iub.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$startUpload$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {0, 0, 0, 1, 1, 1}, l = {1150, 1168}, m = "invokeSuspend", n = {"audioService", "enqueuedSegmentPaths", "segDurationInMills", "enqueuedSegmentPaths", "source", "segDurationInMills"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
final class MmPreMeetingNativeRecordingStateHandler$startUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uploadIdentity;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$startUpload$1(MmPreMeetingNativeRecordingStateHandler r1, String r2, Continuation<? super MmPreMeetingNativeRecordingStateHandler$startUpload$1> r3) {
        this.this$0 = r1;
        this.$uploadIdentity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmPreMeetingNativeRecordingStateHandler$startUpload$1(this.this$0, this.$uploadIdentity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x024a -> B:75:0x024d). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r29) {
        MmPreMeetingNativeRecordingStateHandler$startUpload$1 r1 = this;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = r1.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        int r3 = r1.I$0;
        ChannelIterator r5 = (ChannelIterator) r1.L$2;
        MmRecordingSource r6 = (MmRecordingSource) r1.L$1;
        Set r7 = (Set) r1.L$0;
        ResultKt.throwOnFailure(r29);
        Object r8 = r29;
    L76:
        if (((Boolean) r8).booleanValue() == false) goto L79;
        ovb.a r9 = (ovb.a) r5.next();
        MmPreMeetingNativeRecordingStateHandler r15 = r1.this$0;
        int r10 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.b.a;
        String r12 = r1.$uploadIdentity;
        boolean r16 = r15.a.v();
        Intrinsics.checkNotNullParameter(r9, "metaInfo");
        Intrinsics.checkNotNullParameter(r12, "uploadIdentity");
        String r11 = r9.a;
        int r13 = r9.b;
        MmPreMeetingNativeRecordingStateHandler.e(r15, new MmRecordingUploadTask(r11, r13, r12, String.valueOf((r13 - 1) * r3), r3, r6, r16), r7, "realtime_meta");
    L72:
        r1.L$0 = r7;
        r1.L$1 = r6;
        r1.L$2 = r5;
        r1.I$0 = r3;
        r1.label = 2;
        r8 = r5.hasNext(r1);
        if (r8 != r2) goto L76;
        return r2;
    L79:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        int r4 = r1.I$0;
        Set r14 = (Set) r1.L$1;
        MmRecordingAudioService r17 = (MmRecordingAudioService) r1.L$0;
        ResultKt.throwOnFailure(r29);
        Object r18 = r29;
    L17:
        MmRecordingAudioService r19 = r17;
        r7 = r14;
        int r20 = r4;
        ovb.b r21 = (ovb.b) r18;
        List r22 = CollectionsKt.listOf(new String[]{r21.g, r21.a});
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L19:
        if (r24.hasNext() == false) goto L23;
        Object r110 = r24.next();
        if ((!StringsKt.isBlank((String) r110)) == false) goto L19;
        r23.add(r110);
        goto L19
    L23:
        List r25 = CollectionsKt.distinct(r23);
        MmPreMeetingNativeRecordingStateHandler r26 = r1.this$0;
        k r27 = r26.a.f;
        if (r27 == null) goto L26;
        MmRecordingSource r28 = r27.a;
    L27:
        String r111 = r1.$uploadIdentity;
        Iterator r210 = r25.iterator();
    L29:
        if (r210.hasNext() == false) goto L71;
        String r112 = (String) r210.next();
        int r30 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.b.a;
        String r31 = r26.d.getCurrentUserId();
        boolean r211 = r26.a.v();
        Intrinsics.checkNotNullParameter(r31, "userId");
        Intrinsics.checkNotNullParameter(r112, "recordingDirId");
        Intrinsics.checkNotNullParameter(r111, "uploadIdentity");
        if (StringsKt.isBlank(r112) == false) goto L33;
        List r32 = CollectionsKt.emptyList();
        String r33 = r112;
        String r212 = r111;
    L66:
        lvb.a.e(r26.c, "[startUpload] scan local ogg, recordingDirId:" + r33 + ", count:" + r32.size());
        Iterator r34 = r32.iterator();
    L68:
        if (r34.hasNext() == false) goto L70;
        MmPreMeetingNativeRecordingStateHandler.e(r26, (MmRecordingUploadTask) r34.next(), r7, "local_scan");
        goto L68
    L70:
        r111 = r212;
        goto L29
    L33:
        MmRecordFileHelper.a.getClass();
        VFSFile[] r35 = MmRecordFileHelper.f(r31, r112).listFiles();
        if (r35 == null) goto L65;
        ArrayList r113 = new ArrayList();
        int r114 = r35.length;
        int r115 = 0;
    L36:
        if (r115 >= r114) goto L41;
        VFSFile r116 = r35[r115];
        VFSFile[] r117 = r35;
        if (Intrinsics.areEqual(FilesKt.getExtension(r116), "ogg") == false) goto L40;
        r113.add(r116);
    L40:
        r115 = r115 + 1;
        r35 = r117;
        goto L36
    L41:
        ArrayList r36 = new ArrayList();
        Iterator r118 = r113.iterator();
    L43:
        if (r118.hasNext() == false) goto L64;
        VFSFile r119 = (VFSFile) r118.next();
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L51
        List r38 = StringsKt.split$default(FilesKt.getNameWithoutExtension(r119), new String[]{"_"}, false, 0, 6, null);     // Catch: Throwable -> L51
        int r120 = CastIntegerProtector.parseInt((String) CollectionsKt.first(r38));     // Catch: Throwable -> L51
        int r121 = CastIntegerProtector.parseInt((String) CollectionsKt.last(r38));     // Catch: Throwable -> L51
        String r39 = r112;
        String r213 = r111;
        Object r40 = Result.constructor-impl(new MmRecordingUploadTask(r119.getAbsolutePath(), r120, r111, String.valueOf((r120 - 1) * r121), r121, r28, r211));     // Catch: Throwable -> L49
    L54:
        Throwable r122 = Result.exceptionOrNull-impl(r40);
        if (r122 == null) goto L58;
        lvb.a.b("MmRecordingUploadTaskFactory", "createExistingSegmentTasks failed, file:" + r119.getName() + ", error:" + r122);
    L58:
        if (Result.isFailure-impl(r40) == false) goto L60;
        r40 = null;
    L60:
        MmRecordingUploadTask r41 = (MmRecordingUploadTask) r40;
        if (r41 == null) goto L63;
        r36.add(r41);
    L63:
        r112 = r39;
        r111 = r213;
    L49:
        th = th;
    L53:
        Result.Companion r123 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
    L51:
        th = th;
        r39 = r112;
        r213 = r111;
        goto L53
    L64:
        r33 = r112;
        r212 = r111;
        r32 = CollectionsKt.sortedWith(r36, new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.a());
        goto L66
    L65:
        r33 = r112;
        r212 = r111;
        r32 = CollectionsKt.emptyList();
        goto L66
    L71:
        r1 = this;
        r5 = r19.j.iterator();
        r3 = r20;
        r6 = r28;
        goto L72
    L26:
        r28 = null;
        goto L27
    L10:
        ResultKt.throwOnFailure(r29);
        r17 = r1.this$0.k("startUpload");
        if (r17 == null) goto L13;
        r4 = r1.this$0.d.getSettingsService().h.getSliceDurationInSec() * 1000;
        r14 = new LinkedHashSet();
        MmRecordingSession r42 = r1.this$0.a;
        r1.L$0 = r17;
        r1.L$1 = r14;
        r1.I$0 = r4;
        r1.label = 1;
        r18 = r42.r(r1);
        if (r18 != r2) goto L17;
        return r2;
    L13:
        return Unit.INSTANCE;
    }
}
