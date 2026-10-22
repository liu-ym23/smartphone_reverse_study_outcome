package com.obric.assistant.tipoff;

import android.content.Context;
import android.text.Editable;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.IObricFeedbackService;
import com.obric.assistant.impl.databinding.ObricDialogfragTipOffBinding;
import com.obric.assistant.view.ObricFlowTagLayout;
import com.obric.oui.checkbox.OCheckBoxLayout;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.tipoff.ObricTipOffDialogFragment$doSubmit$1", f = "ObricTipOffDialogFragment.kt", i = {}, l = {812}, m = "invokeSuspend", n = {}, s = {})
public final class ObricTipOffDialogFragment$doSubmit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $withGuiImage;
    int label;
    final /* synthetic */ ObricTipOffDialogFragment this$0;

    public ObricTipOffDialogFragment$doSubmit$1(ObricTipOffDialogFragment r1, boolean r2, Continuation<? super ObricTipOffDialogFragment$doSubmit$1> r3) {
        this.this$0 = r1;
        this.$withGuiImage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricTipOffDialogFragment$doSubmit$1(this.this$0, this.$withGuiImage, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r32);
        Object r3 = r32;
    L125:
        if (((Boolean) r3).booleanValue() == true) goto L128;
        FLogger.a.i("ObricTipOffDialogFragment", "reportToObric failed");
        ObricTipOffDialogFragment r4 = this.this$0;
        int r5 = ObricTipOffDialogFragment.Q;
        r4.ga0().getSubmitEnable().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L128:
        final ObricTipOffDialogFragment r6 = this.this$0;
        if (r6.B == true) goto L131;
        FLogger r7 = FLogger.a;
        r7.i("ObricTipOffDialogFragment", "submit");
        final Context r8 = r6.getContext();
        if (r8 != null) goto L154;
    L199:
        r7.i("ObricTipOffDialogFragment", "ctx = " + r8);
        t19.s.a.getClass();
        t19.s.s(r8, 2131908080);
    L201:
        return Unit.INSTANCE;
    L154:
        if (NetworkUtils.isNetworkAvailable(r8) == false) goto L199;
        if (r6.O == false) goto L159;
        int r9 = 1;
    L162:
        Integer[] r10 = new Integer[r9];
        ObricDialogfragTipOffBinding r11 = r6.f;
        if (r11 == null) goto L169;
        ObricFlowTagLayout r12 = r11.o;
        if (r12 == null) goto L169;
        ObricFlowTagLayout.a r13 = r12.getCurSelectedTagBean();
        if (r13 == null) goto L169;
        int r14 = r13.b;
    L170:
        r10[0] = Integer.valueOf(r14);
        CollectionsKt.arrayListOf(r10);
        ObricDialogfragTipOffBinding r15 = r6.f;
        if (r15 == null) goto L177;
        NestedScrollEditText r16 = r15.h;
        if (r16 == null) goto L177;
        Editable r17 = r16.getText();
        if (r17 == null) goto L177;
        String r18 = r17.toString();
    L178:
        if (r18 != null) goto L180;
        String r19 = "";
    L181:
        int r20 = r6.i;
        if (r20 != 14) goto L184;
    L187:
        final boolean r21 = true;
    L188:
        r6.ga0().requireTipOff(r6.i, r6.j, CollectionsKt.arrayListOf(new Integer[]{16}), r19, r6.n, r6.o, r6.p, r6.u, r6.v, new h(r6, r8, r21));
        if (r21 == true) goto L193;
        com.larus.bmhome.tipoff.a r22 = r6.w;
        if (r22 == null) goto L193;
        r22.a(true);
    L193:
        FragmentActivity r23 = r6.getActivity();
        if (r23 == null) goto L198;
        LifecycleCoroutineScope r24 = LifecycleOwnerKt.getLifecycleScope(r23);
        if (r24 == null) goto L198;
        BuildersKt.launch$default(r24, null, null, new ObricTipOffDialogFragment$submit$2(r6, null), 3, null);
    L198:
        ObricTipOffDialogFragment.aa0(r6);
        goto L201
    L184:
        if (r20 == 19) goto L187;
        r21 = false;
        goto L188
    L180:
        r19 = r18;
    L177:
        r18 = null;
    L169:
        r14 = 0;
        goto L170
    L159:
        r9 = 1;
        r6.O = true;
        nga.a r25 = r6.N;
        if (r25 == null) goto L162;
        r25.b();
        goto L162
    L131:
        if (r6.O == true) goto L136;
        r6.O = true;
        nga.a r26 = r6.N;
        if (r26 == null) goto L136;
        r26.b();
    L136:
        ObricDialogfragTipOffBinding r27 = r6.f;
        if (r27 == null) goto L141;
        ObricFlowTagLayout r28 = r27.o;
        if (r28 == null) goto L141;
        ObricFlowTagLayout.a r29 = r28.getCurSelectedTagBean();
    L142:
        ObricDialogfragTipOffBinding r30 = r6.f;
        if (r30 == null) goto L149;
        NestedScrollEditText r31 = r30.h;
        if (r31 == null) goto L149;
        Editable r33 = r31.getText();
        if (r33 == null) goto L149;
        String r34 = r33.toString();
    L150:
        r6.na0(true, true, r29, r34);
    L149:
        r34 = null;
    L141:
        r29 = null;
        goto L142
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        ObricTipOffDialogFragment r35 = this.this$0;
        int r36 = ObricTipOffDialogFragment.Q;
        r35.ga0().getSubmitEnable().setValue(Boxing.boxBoolean(false));
        ObricTipOffDialogFragment r110 = this.this$0;
        boolean r37 = this.$withGuiImage;
        this.label = 1;
        String r38 = r110.j;
        List<String> r39 = r110.u;
        IObricFeedbackService.a r111 = IObricFeedbackService.a;
        String r112 = r110.H;
        r111.getClass();
        boolean r113 = IObricFeedbackService.a.b(r112);
        if (r113 == false) goto L11;
        com.obric.assistant.util.a.b r114 = null;
    L12:
        if (r113 == false) goto L14;
        boolean r115 = false;
    L15:
        if (r113 == true) goto L19;
        if (r37 == true) goto L18;
        if (r115 == false) goto L19;
    L18:
        boolean r210 = true;
    L20:
        if (r113 == true) goto L46;
        List<String> r116 = r110.D;
        if (r116 != null) goto L25;
    L28:
        boolean r117 = true;
    L29:
        if (r117 == true) goto L46;
        if (r114 != null) goto L33;
    L35:
        boolean r118 = false;
    L36:
        if (r118 == true) goto L38;
        List<String> r119 = r110.D;
    L45:
        List<String> r211 = r119;
    L47:
        FLogger r120 = FLogger.a;
        StringBuilder r121 = new StringBuilder("reportToObric: feedbackBizType=");
        String r122 = r110.H;
        if (r122 != null) goto L50;
        r122 = "";
    L50:
        r121.append(r122);
        r121.append(", withGuiImage=");
        r121.append(r37);
        r121.append(", autoDrainInternalEnabled=");
        r121.append(r115);
        r121.append(", rawPathCount=");
        List<String> r40 = r110.D;
        if (r40 != null) goto L53;
        r40 = CollectionsKt.emptyList();
    L53:
        r121.append(r40.size());
        r121.append(", imagePathCount=");
        if (r114 == null) goto L56;
        List<String> r41 = r114.a;
    L57:
        if (r41 != null) goto L59;
        r41 = CollectionsKt.emptyList();
    L59:
        r121.append(r41.size());
        r121.append(", otherPathCount=");
        if (r114 == null) goto L62;
        List<String> r42 = r114.b;
    L63:
        if (r42 != null) goto L65;
        r42 = CollectionsKt.emptyList();
    L65:
        r121.append(r42.size());
        r121.append(", finalUploadPathCount=");
        if (r211 != null) goto L68;
        List<String> r43 = CollectionsKt.emptyList();
    L69:
        r121.append(r43.size());
        r120.i("ObricTipOffDialogFragment", r121.toString());
        ObricDialogfragTipOffBinding r44 = r110.f;
        if (r44 == null) goto L76;
        ObricFlowTagLayout r45 = r44.o;
        if (r45 == null) goto L76;
        ObricFlowTagLayout.a r46 = r45.getCurSelectedTagBean();
        if (r46 == null) goto L76;
        String r47 = r46.a;
    L77:
        if (r47 != null) goto L79;
        r47 = "";
    L79:
        List r48 = CollectionsKt.listOf(r47);
        ObricDialogfragTipOffBinding r123 = r110.f;
        if (r123 == null) goto L86;
        NestedScrollEditText r124 = r123.h;
        if (r124 == null) goto L86;
        Editable r125 = r124.getText();
        if (r125 == null) goto L86;
        String r126 = r125.toString();
    L87:
        if (r126 != null) goto L89;
        r126 = "";
    L89:
        ObricDialogfragTipOffBinding r127 = r110.f;
        if (r127 == null) goto L110;
        RelativeLayout r128 = r127.q;
        if (r128 == null) goto L110;
        if (r128.getVisibility() != 0) goto L96;
        boolean r129 = true;
    L97:
        if (r129 == true) goto L100;
        r128 = null;
    L100:
        if (r128 == null) goto L110;
        ObricDialogfragTipOffBinding r130 = r110.f;
        if (r130 == null) goto L108;
        OCheckBoxLayout r131 = r130.p;
        if (r131 == null) goto L108;
        if (r131.isChecked() != true) goto L108;
        boolean r132 = true;
    L109:
        Boolean r133 = Boxing.boxBoolean(r132);
    L111:
        List<String> r134 = r39;
        if (r134 != null) goto L114;
    L117:
        boolean r135 = true;
    L118:
        if (r135 == false) goto L120;
        List<String> r136 = CollectionsKt.listOf(r38);
    L121:
        String r49 = r110.E;
        String r137 = r110.F;
        String r138 = r110.G;
        String r50 = r110.H;
        String r51 = r110.I;
        Integer r52 = r110.M;
        r120.i(r110.e, "reportToObric");
        r3 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new BaseObricTipOffDialogFragment$reportFeedbackToObric$2(r110, r48, r126, r136, r137, r138, r50, r51, r133, r52, r210, r211, r49, null), 3, null).await(this);
        if (r3 != r1) goto L125;
        return r1;
    L120:
        r136 = r39;
        goto L121
    L114:
        if (r134.isEmpty() == true) goto L117;
        r135 = false;
    L108:
        r132 = false;
        goto L109
    L96:
        r129 = false;
    L110:
        r133 = null;
    L86:
        r126 = null;
    L76:
        r47 = null;
        goto L77
    L68:
        r43 = r211;
        goto L69
    L62:
        r42 = null;
        goto L63
    L56:
        r41 = null;
        goto L57
    L38:
        if (r210 == false) goto L40;
        r119 = r110.D;
        goto L45
    L40:
        if (r114 == null) goto L46;
        r119 = r114.b;
        if (r119 == null) goto L46;
        if ((!r119.isEmpty()) == false) goto L46;
    L33:
        if ((!r114.a.isEmpty()) != true) goto L35;
        r118 = true;
        goto L36
    L25:
        if (r116.isEmpty() == true) goto L28;
        r117 = false;
    L46:
        r211 = null;
    L19:
        r210 = false;
        goto L20
    L14:
        r115 = ObricTipOffDialogFragment.ia0();
        goto L15
    L11:
        r114 = r110.fa0();
        goto L12
    }
}
