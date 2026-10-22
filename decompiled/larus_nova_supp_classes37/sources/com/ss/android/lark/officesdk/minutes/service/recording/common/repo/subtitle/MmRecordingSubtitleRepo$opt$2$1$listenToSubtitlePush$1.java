package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.pb.minutes.v1.ByteviewUser;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitlePush$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {746}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$listenToSubtitlePush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 a;

        public a(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1) {
            this.a = r1;
        }

        public final Object emit(Object r17, Continuation r18) {
            RecordingSubtitleData r0 = (RecordingSubtitleData) r17;
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2 = this.a;
            String r3 = r2.s.k.o();
            RecordingSubtitleData.Subtitle r4 = r0.target;
            if (r4 == null) goto L5;
            String r5 = r4.language;
        L7:
            if (r5 != null) goto L9;
            r5 = "";
        L9:
            String r7 = r2.b;
            if (r0.is_seg_final.booleanValue() == false) goto L25;
            String r8 = r2.s.m;
            StringBuilder r9 = new StringBuilder("[onPushSubtitle] final, segId=");
            r9.append(r0.seg_id);
            r9.append(", sliceId=");
            r9.append(r0.slice_id);
            r9.append(", currentLanguage=");
            r9.append(r3);
            r9.append(", expectedLanguage=");
            r9.append(r7);
            r9.append(", targetLanguage=");
            r9.append(r5);
            r9.append(", sourceLen=");
            RecordingSubtitleData.Subtitle r10 = r0.source;
            if (r10 == null) goto L16;
            String r11 = r10.content;
            if (r11 == null) goto L16;
            Integer r12 = Integer.valueOf(r11.length());
        L17:
            r9.append(r12);
            r9.append(", targetLen=");
            RecordingSubtitleData.Subtitle r13 = r0.target;
            if (r13 == null) goto L22;
            String r14 = r13.content;
            if (r14 == null) goto L22;
            Integer r15 = Integer.valueOf(r14.length());
        L23:
            r9.append(r15);
            r9.append(", showBilingual=");
            r9.append(((d) r2.m()).e);
            lvb.a.e(r8, r9.toString());
        L22:
            r15 = null;
        L16:
            r12 = null;
        L25:
            if (Intrinsics.areEqual(r3, "source") == false) goto L51;
            RecordingSubtitleData.Subtitle r16 = r0.source;
            RecordingSubtitleData.Subtitle r19 = r0.target;
            if (r16 == null) goto L29;
            String r110 = r16.content;
        L30:
            if (r110 != null) goto L32;
        L34:
            if (r19 == null) goto L36;
            String r111 = r19.content;
        L37:
            if (r111 != null) goto L39;
        L42:
            boolean r112 = true;
        L43:
            if (r112 == false) goto L45;
        L47:
            if (r16 != null) goto L56;
            if (r19 == null) goto L142;
        L50:
            r16 = r19;
        L142:
            return Unit.INSTANCE;
        L56:
            if (r16 == null) goto L58;
            ByteviewUser r113 = r16.speaker;
        L59:
            if (r113 != null) goto L61;
        L140:
            lvb.a.b(r2.s.m, "[onPushSubtitle] not valid, data=" + r0);
            goto L142
        L61:
            if (r16.content == null) goto L140;
            long r114 = SystemClock.elapsedRealtime();
            long r115 = r2.d.get();
            Intrinsics.checkNotNullParameter(r5, "pushedLanguage");
            Intrinsics.checkNotNullParameter(r7, "expectedLanguage");
            if (r114 < r115) goto L66;
        L80:
            boolean r20 = false;
        L82:
            if (r20 == false) goto L85;
            lvb.a.h(r2.s.m, "[onPushSubtitle] drop mismatched language during transition, target=" + r5 + ", expected=" + r7 + ", remainingMs=" + (r115 - r114) + ", revision=" + r2.c.get() + ", segId=" + r0.seg_id);
            goto L142
        L85:
            if (Intrinsics.areEqual(r3, "source") == true) goto L87;
        L89:
            String r6 = r0.seg_id + "";
            Long r21 = r2.r.get(r6);
            if (r21 != null) goto L92;
        L94:
            r2.r.put(r6, r0.slice_id);
            if (Intrinsics.areEqual(r3, "source") == true) goto L97;
            r2.X0(r0);
        L97:
            RecordingSubtitleData.Subtitle r22 = r0.target;
            if (r22 == null) goto L106;
            RecordingSubtitleData.Subtitle.Punctuation r23 = r22.punctuation;
            if (r23 == null) goto L106;
            List<Long> r24 = r23.word_ends;
            if (r24 == null) goto L106;
            if ((!r24.isEmpty()) != true) goto L106;
            boolean r25 = true;
        L108:
            if (r25 == true) goto L110;
        L117:
            r2.a1(r0, null, null);
        L118:
            RecordingSubtitleData.Subtitle r26 = r0.source;
            if (r26 == null) goto L127;
            RecordingSubtitleData.Subtitle.Punctuation r27 = r26.punctuation;
            if (r27 == null) goto L127;
            List<Long> r28 = r27.word_ends;
            if (r28 == null) goto L127;
            if ((!r28.isEmpty()) != true) goto L127;
            boolean r116 = true;
        L129:
            if (((d) r2.m()).e == false) goto L142;
            if (r116 == true) goto L132;
        L139:
            r2.a1(r0, null, null);
            goto L142
        L132:
            if (r2.f == true) goto L139;
            rvb.a r29 = r2.c1();
            r29.getClass();
            Intrinsics.checkNotNullParameter(r0, "subtitleData");
            if (r29.g != null) goto L136;
            PthreadHandlerThreadV2 r30 = new PthreadHandlerThreadV2("mmSubtitleSmoothThread");
            ThreadMethodProxy.start(r30);
            r29.g = new rvb.b(r29, r30.getLooper());
        L136:
            Handler r31 = r29.g;
            if (r31 == null) goto L142;
            r31.post(new rvb.c(r0, r29));
        L127:
            r116 = false;
            goto L129
        L110:
            if (r2.f == true) goto L117;
            rvb.a r32 = (rvb.a) r2.n.getValue();
            r32.getClass();
            Intrinsics.checkNotNullParameter(r0, "subtitleData");
            if (r32.g != null) goto L114;
            PthreadHandlerThreadV2 r33 = new PthreadHandlerThreadV2("mmSubtitleSmoothThread");
            ThreadMethodProxy.start(r33);
            r32.g = new rvb.b(r32, r33.getLooper());
        L114:
            Handler r34 = r32.g;
            if (r34 == null) goto L118;
            r34.post(new rvb.c(r0, r32));
        L106:
            r25 = false;
            goto L108
        L92:
            if (r0.slice_id.longValue() >= r21.longValue()) goto L94;
            lvb.a.b(r2.s.m, "[onPushSubtitle] out order seqId: " + r6 + ", lastSliceId: " + r21 + ", currentSliceId: " + r0.slice_id);
            goto L142
        L87:
            if (r2.e1(r0) == false) goto L89;
            lvb.a.h(r2.s.m, "[onPushSubtitle] drop source-incompatible target, target=" + r5 + ", segId=" + r0.seg_id);
            goto L142
        L66:
            if (r5.length() <= 0) goto L68;
            boolean r35 = true;
        L69:
            if (r35 == false) goto L80;
            if (r7.length() <= 0) goto L73;
            boolean r36 = true;
        L74:
            if (r36 == false) goto L80;
            if (Intrinsics.areEqual(r7, "source") == true) goto L80;
            if (Intrinsics.areEqual(r5, r7) == true) goto L80;
            r20 = true;
            goto L82
        L73:
            r36 = false;
            goto L74
        L68:
            r35 = false;
            goto L69
        L58:
            r113 = null;
            goto L59
        L45:
            if (r2.e1(r0) == true) goto L47;
        L39:
            if (r111.length() == 0) goto L42;
            r112 = false;
            goto L43
        L36:
            r111 = null;
            goto L37
        L32:
            if (r16.speaker == null) goto L34;
        L29:
            r110 = null;
            goto L30
        L51:
            r16 = r0.target;
            if (r16 != null) goto L56;
            r16 = r0.source;
            if (r16 != null) goto L56;
        L5:
            r5 = null;
            goto L7
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$listenToSubtitlePush$1(MmRecordingSubtitleRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$listenToSubtitlePush$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSubtitleRepo$opt$2$1$listenToSubtitlePush$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1 r6 = this.this$0.l.Q().b(Command.MINUTES_RECORDING_PUSH_SUBTITLE, RecordingSubtitleData.class);
        a r2 = new a(this.this$1);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
