package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "supportSpokenLanguages", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "spokenLanguage", "targetLanguage", "languageLoading", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationTopBarView$bind$8", f = "MmStandaloneAIInterpretationTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationTopBarView$bind$8 extends SuspendLambda implements Function5<List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c>, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationTopBarView this$0;

    public MmStandaloneAIInterpretationTopBarView$bind$8(MmStandaloneAIInterpretationTopBarView r1, Continuation<? super MmStandaloneAIInterpretationTopBarView$bind$8> r2) {
        this.this$0 = r1;
        super(5, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        return invoke((List) r7, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r8, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r9, ((Boolean) r10).booleanValue(), (Continuation) r11);
    }

    public final Object invoke(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r5, boolean r6, Continuation<? super Unit> r7) {
        MmStandaloneAIInterpretationTopBarView$bind$8 r0 = new MmStandaloneAIInterpretationTopBarView$bind$8(this.this$0, r7);
        r0.L$0 = r3;
        r0.L$1 = r4;
        r0.L$2 = r5;
        r0.Z$0 = r6;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r8);
        List r9 = (List) this.L$0;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r0 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) this.L$1;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r1 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) this.L$2;
        boolean r2 = this.Z$0;
        String r3 = null;
        if (r1 == null) goto L7;
        String r4 = r1.a;
    L9:
        if (b.a(r4) == false) goto L11;
        String r5 = UIHelper.getString(2131894007);
    L12:
        TextView r6 = this.this$0.a.g;
        if (r5 == null) goto L15;
        String r10 = r5;
    L25:
        r6.setText(r10);
        TextView r11 = this.this$0.a.i;
        if (r5 != null) goto L35;
        if (r1 == null) goto L34;
        String r7 = r1.b;
        if (r7 == null) goto L34;
        if ((!StringsKt.isBlank(r7)) == false) goto L34;
        r3 = r7;
    L34:
        r5 = r3;
    L35:
        r11.setText(r5);
        LinearLayout r12 = this.this$0.a.d;
        int r13 = 8;
        if (r2 == false) goto L38;
        int r14 = 8;
    L39:
        r12.setVisibility(r14);
        FrameLayout r15 = this.this$0.a.e;
        if (r2 == false) goto L42;
        r13 = 0;
    L42:
        r15.setVisibility(r13);
        return Unit.INSTANCE;
    L38:
        r14 = 0;
        goto L39
    L15:
        if (r0 != null) goto L17;
        r0 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) CollectionsKt.firstOrNull(r9);
    L17:
        if (r0 == null) goto L24;
        this.this$0.getClass();
        r10 = r0.b;
        if ((!StringsKt.isBlank(r10)) == true) goto L22;
        r10 = null;
    L22:
        if (r10 != null) goto L25;
        r10 = r0.a;
        goto L25
    L24:
        r10 = null;
        goto L25
    L11:
        r5 = null;
        goto L12
    L7:
        r4 = null;
        goto L9
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
