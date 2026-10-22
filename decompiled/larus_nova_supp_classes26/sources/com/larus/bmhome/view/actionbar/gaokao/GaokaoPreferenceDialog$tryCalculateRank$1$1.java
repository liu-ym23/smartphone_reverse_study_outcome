package com.larus.bmhome.view.actionbar.gaokao;

import android.content.Context;
import android.widget.EditText;
import com.larus.bmhome.databinding.LarusDialogGaokaoPreferenceBinding;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoPreferenceAdapter;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoProvinceAdapter;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoProvince;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoPreferenceDialog$tryCalculateRank$1$1", f = "GaokaoPreferenceDialog.kt", i = {0}, l = {459}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class GaokaoPreferenceDialog$tryCalculateRank$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $score;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GaokaoPreferenceDialog this$0;

    public GaokaoPreferenceDialog$tryCalculateRank$1$1(GaokaoPreferenceDialog r1, Context r2, String r3, Continuation<? super GaokaoPreferenceDialog$tryCalculateRank$1$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$score = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        GaokaoPreferenceDialog$tryCalculateRank$1$1 r0 = new GaokaoPreferenceDialog$tryCalculateRank$1$1(this.this$0, this.$context, this.$score, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L48:
        final String r15 = (String) r14;
        final GaokaoPreferenceDialog r3 = this.this$0;
        LarusDialogGaokaoPreferenceBinding r4 = r3.d;
        if (r4 == null) goto L54;
        EditText r5 = r4.q;
        if (r5 == null) goto L54;
        Boxing.boxBoolean(r5.post(new u(r15, r3)));
    L54:
        if (Intrinsics.areEqual(this.this$0.n, r2) == false) goto L57;
        this.this$0.n = null;
    L57:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        GaokaoPreferenceDialog r6 = this.this$0;
        GaokaoRankCalculator r7 = r6.p;
        Context r8 = this.$context;
        String r9 = this.$score;
        GaokaoProvinceAdapter r10 = r6.h;
        String r11 = "";
        if (r10 == null) goto L14;
        GaokaoProvince r12 = r10.g;
        if (r12 == null) goto L14;
        String r13 = r12.getProvince();
        if (r13 == null) goto L14;
    L15:
        GaokaoPreferenceDialog r17 = this.this$0;
        GaokaoPreferenceAdapter r18 = r17.i;
        if (r18 == null) goto L18;
        List<String> r19 = r18.y2();
    L19:
        GaokaoProvinceAdapter r110 = r17.h;
        if (r110 == null) goto L43;
        GaokaoProvince r111 = r110.g;
        if (r111 == null) goto L43;
        if (Intrinsics.areEqual(r111.getDisableRank(), "1") == true) goto L43;
        String r112 = r111.getKey();
        if (r112 == null) goto L43;
        GaokaoType r20 = r17.U90(r112);
        if (Intrinsics.areEqual(r20.getCode(), "1") == false) goto L41;
        String r21 = (String) CollectionsKt.firstOrNull(r19);
        if (r21 == null) goto L36;
        r11 = r21;
    L36:
        Map<String, String> r22 = r20.getSelectedMajorRankTypeMap();
        if (r22 == null) goto L40;
        String r23 = r22.get(r11);
        if (r23 == null) goto L40;
    L42:
        String r24 = r23;
    L44:
        this.L$0 = r16;
        this.label = 1;
        Object r25 = r7.a(r8, r9, r13, r24, this);
        if (r25 != r0) goto L47;
        return r0;
    L47:
        r2 = r16;
        r14 = r25;
    L40:
        r23 = r20.getDefaultRankType();
        goto L42
    L41:
        r23 = r20.getDefaultRankType();
    L43:
        r24 = null;
        goto L44
    L18:
        r19 = CollectionsKt.emptyList();
    L14:
        r13 = "";
        goto L15
    }
}
