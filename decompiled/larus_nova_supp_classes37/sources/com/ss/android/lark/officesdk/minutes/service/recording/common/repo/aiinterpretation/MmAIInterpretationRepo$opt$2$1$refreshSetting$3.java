package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$refreshSetting$3", f = "MmAIInterpretationRepo.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_AI_KNOWLEDGE, 56}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$refreshSetting$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $result;
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;
    final /* synthetic */ MmAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmAIInterpretationRepo$opt$2$1$refreshSetting$3(Object r1, MmAIInterpretationRepo r2, MmAIInterpretationRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmAIInterpretationRepo$opt$2$1$refreshSetting$3> r4) {
        this.$result = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmAIInterpretationRepo$opt$2$1$refreshSetting$3(this.$result, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
    L77:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r18);
        Object r3 = this.$result;
        MmAIInterpretationRepo r5 = this.this$0;
        MmAIInterpretationRepo$opt$2.AnonymousClass1 r6 = this.this$1;
        Throwable r7 = Result.exceptionOrNull-impl(r3);
        if (r7 != null) goto L73;
        List r10 = (List) r3;
        b r4 = r5.k;
        MmRecordingSource r8 = (MmRecordingSource) r5.m.invoke();
        boolean r9 = r4.a.getFeatureService().h(MmOfficeSdkFeature.RecordingAIInterpreter);
        boolean r11 = DeviceUtils.isPad();
        int r12 = e.a;
        boolean r13 = false;
        if (r11 == true) goto L18;
        if (r9 == false) goto L18;
        if (r8 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L18;
        boolean r14 = true;
    L19:
        lvb.a.e("MmAIInterpretationAudioController", "[isEntryEnabled] isPadDevice=" + r11 + ", featureEnabled=" + r9 + ", recordingSource=" + r8 + ", enabled=" + r14);
        if (r14 == true) goto L22;
    L24:
        boolean r15 = false;
    L25:
        lvb.a.e(r5.n, "[refreshSetting] success, languageSize=" + r10.size() + ", entryVisible=" + r15);
        String r16 = null;
        if (r10.isEmpty() == false) goto L28;
        g r17 = null;
    L70:
        d r19 = d.a((d) r6.m(), false, r10, r17, null, false, r15, null, 73);
        this.label = 1;
        if (r5.b(r19, this) != r1) goto L77;
        return r1;
    L28:
        String r20 = r5.l.getString("minutes_ai_interpretation_last_selected_language", null);
        if (r20 != null) goto L31;
        r20 = "";
    L31:
        List r21 = r10;
        Iterator r22 = r21.iterator();
    L33:
        if (r22.hasNext() == false) goto L37;
        Object r110 = r22.next();
        if (Intrinsics.areEqual(((g) r110).a, r20) == false) goto L33;
    L38:
        r17 = (g) r110;
        g r23 = r5.h().c;
        if (r23 != null) goto L41;
    L53:
        r23 = null;
    L54:
        String r24 = r5.n;
        StringBuilder r25 = new StringBuilder("[resolveSelectedLanguage] saved=");
        r25.append(r20);
        r25.append(", selected=");
        if (r17 == null) goto L60;
        String r26 = r17.a;
        if (r26 == null) goto L60;
        r16 = r26;
    L65:
        r25.append(r16);
        lvb.a.e(r24, r25.toString());
        if (r17 != null) goto L70;
        if (r23 != null) goto L69;
        r17 = (g) CollectionsKt.firstOrNull(r10);
        goto L70
    L69:
        r17 = r23;
    L60:
        if (r23 == null) goto L62;
        r16 = r23.a;
        goto L65
    L62:
        g r27 = (g) CollectionsKt.firstOrNull(r10);
        if (r27 == null) goto L65;
        r16 = r27.a;
        goto L65
    L41:
        if ((r21 instanceof Collection) == true) goto L43;
    L45:
        Iterator r28 = r21.iterator();
    L47:
        if (r28.hasNext() == false) goto L51;
        if (Intrinsics.areEqual(((g) r28.next()).a, r23.a) == false) goto L47;
        r13 = true;
    L51:
        if (r13 == false) goto L53;
    L43:
        if (r21.isEmpty() == false) goto L45;
    L37:
        r110 = null;
        goto L38
    L22:
        if ((!r10.isEmpty()) == false) goto L24;
        r15 = true;
    L18:
        r14 = false;
        goto L19
    L73:
        lvb.a.b(r5.n, "[refreshSetting] failed: " + r7);
        d r29 = d.a((d) r6.m(), false, null, null, null, false, false, "get_setting_failed", 15);
        this.label = 2;
        if (r5.b(r29, this) != r1) goto L77;
        return r1;
    }
}
