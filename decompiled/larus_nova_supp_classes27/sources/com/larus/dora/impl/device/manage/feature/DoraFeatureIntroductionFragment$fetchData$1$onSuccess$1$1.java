package com.larus.dora.impl.device.manage.feature;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import c59.c0;
import c59.i;
import c59.j;
import c59.p;
import c59.s;
import c59.t;
import c59.u;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraFeatureIntroductionFragmentBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.feature.DoraFeatureIntroductionFragment$fetchData$1$onSuccess$1$1", f = "DoraFeatureIntroductionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFeatureIntroductionFragment$fetchData$1$onSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c0 $pageInfo;
    int label;
    final /* synthetic */ DoraFeatureIntroductionFragment this$0;

    public DoraFeatureIntroductionFragment$fetchData$1$onSuccess$1$1(DoraFeatureIntroductionFragment r1, c0 r2, Continuation<? super DoraFeatureIntroductionFragment$fetchData$1$onSuccess$1$1> r3) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFeatureIntroductionFragment$fetchData$1$onSuccess$1$1(this.this$0, this.$pageInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L132;
        ResultKt.throwOnFailure(r15);
        final DoraFeatureIntroductionFragment r16 = this.this$0;
        c0 r0 = this.$pageInfo;
        int r1 = DoraFeatureIntroductionFragment.j;
        r16.getClass();
        i r2 = r0.a;
        if (r2 == null) goto L130;
        Lazy r3 = s.a;
        DoraFeatureIntroductionFragment.c r4 = (DoraFeatureIntroductionFragment.c) s.c(r2.b, DoraFeatureIntroductionFragment.c.class);
        if (r4 == null) goto L130;
        final Context r5 = r16.getContext();
        if (r5 == null) goto L130;
        LarusDoraFeatureIntroductionFragmentBinding r6 = r16.f;
        if (r6 == null) goto L130;
        LinearLayout r7 = r6.b;
        if (r7 == null) goto L130;
        StringBuilder r8 = new StringBuilder("generateFuncIntroSetView items=");
        List<DoraFeatureIntroductionFragment.b> r9 = r4.a();
        if (r9 == null) goto L19;
        Integer r10 = Integer.valueOf(r9.size());
    L20:
        r8.append(r10);
        g49.d.d("DoraFunctionIntroductionSetFragment", r8.toString());
        r7.removeAllViews();
        LarusDoraFeatureIntroductionFragmentBinding r11 = r16.f;
        if (r11 == null) goto L25;
        AppCompatTextView r12 = r11.e;
        if (r12 == null) goto L25;
        int r13 = j0.a;
        r12.setText(j0.d(2131902658));
    L25:
        z49.b r14 = r16.i;
        List<DoraFeatureIntroductionFragment.b> r17 = r4.a();
        if (r17 != null) goto L28;
        r17 = CollectionsKt.emptyList();
    L28:
        List r18 = CollectionsKt.filterNotNull(r17);
        ArrayList r20 = new ArrayList();
        Iterator r21 = r18.iterator();
    L30:
        if (r21.hasNext() == false) goto L47;
        Object r22 = r21.next();
        j r23 = ((DoraFeatureIntroductionFragment.b) r22).b();
        if (r14 == null) goto L34;
        String r110 = r14.h();
    L35:
        if (r14 == null) goto L37;
        Integer r111 = r14.f();
    L38:
        if (r14 == null) goto L40;
        String r112 = r14.c();
    L41:
        if (r14 == null) goto L43;
        String r113 = r14.b();
    L45:
        if (p.c(r23, r110, r111, r112, r113) == false) goto L30;
        r20.add(r22);
        goto L30
    L43:
        r113 = null;
        goto L45
    L40:
        r112 = null;
        goto L41
    L37:
        r111 = null;
        goto L38
    L34:
        r110 = null;
        goto L35
    L47:
        StringBuilder r24 = new StringBuilder("generateFuncIntroSetView totalItems=");
        List<DoraFeatureIntroductionFragment.b> r25 = r4.a();
        if (r25 == null) goto L50;
        int r26 = r25.size();
    L51:
        r24.append(r26);
        r24.append(", filteredItems=");
        r24.append(r20.size());
        r24.append(", mac=");
        if (r14 == null) goto L54;
        String r27 = r14.c();
    L55:
        r24.append(r27);
        r24.append(", productId=");
        if (r14 == null) goto L58;
        Integer r28 = r14.f();
    L59:
        r24.append(r28);
        g49.d.d("DoraFunctionIntroductionSetFragment", r24.toString());
        if (r20.isEmpty() == false) goto L66;
        StringBuilder r30 = new StringBuilder("No feature introduction items after filtering, pageKey: g_feature_intro_v1, mac: ");
        if (r14 == null) goto L64;
        String r31 = r14.c();
    L65:
        r30.append(r31);
        g49.d.b("DoraFunctionIntroductionSetFragment", r30.toString());
        goto L66
    L64:
        r31 = null;
    L66:
        Iterator r32 = r20.iterator();
    L68:
        if (r32.hasNext() == false) goto L119;
        final DoraFeatureIntroductionFragment.b r33 = (DoraFeatureIntroductionFragment.b) r32.next();
        ConstraintLayout r34 = LayoutInflater.from(r5).inflate(2131562151, r7, false);
        if ((r34 instanceof RoundConstraintLayout) == false) goto L72;
        ConstraintLayout r35 = (RoundConstraintLayout) r34;
    L73:
        if (r35 == null) goto L68;
        Boolean r36 = r33.f();
        if (r36 == null) goto L78;
        boolean r37 = r36.booleanValue();
    L79:
        ImageView r38 = (ImageView) r35.findViewById(2131377266);
        if (r38 == null) goto L84;
        if (r37 == false) goto L83;
        e1.x(r38);
        goto L84
    L83:
        e1.o(r38);
    L84:
        SimpleDraweeView r40 = r35.findViewById(2131377265);
        if (r40 == null) goto L91;
        u r41 = r33.c();
        z49.b r42 = r16.i;
        if (r42 == null) goto L89;
        Integer r43 = r42.f();
    L90:
        p.e(r40, r41, null, r43, 2);
        goto L91
    L89:
        r43 = null;
    L91:
        AppCompatTextView r44 = (DoraTextView) r35.findViewById(2131373374);
        AppCompatTextView r45 = (DoraTextView) r35.findViewById(2131373373);
        String r46 = "";
        if (r44 == null) goto L100;
        t r114 = r33.g();
        if (r114 == null) goto L98;
        CharSequence r115 = p.b(r114);
        if (r115 == null) goto L98;
    L99:
        r44.setText(r115);
    L98:
        r115 = "";
    L100:
        if (r45 == null) goto L108;
        t r47 = r33.e();
        if (r47 == null) goto L106;
        CharSequence r48 = p.b(r47);
        if (r48 == null) goto L106;
    L107:
        r45.setText(r48);
    L106:
        r48 = "";
    L108:
        c59.b r50 = r33.a();
        if (r50 == null) goto L114;
        String r51 = r50.e();
        if (r51 == null) goto L114;
        r46 = r51;
    L114:
        final String r52 = r16.X90(r46);
        c59.b r53 = r33.a();
        if (r53 == null) goto L117;
        Object r54 = r53.e();
    L118:
        r35.setTag(r54);
        e1.d(r35, new d(r52, r33, r5, r16));
        r7.addView(r35);
        goto L68
    L117:
        r54 = null;
        goto L118
    L78:
        r37 = false;
        goto L79
    L72:
        r35 = null;
        goto L73
    L119:
        LarusDoraFeatureIntroductionFragmentBinding r55 = r16.f;
        if (r55 == null) goto L124;
        NestedScrollView r56 = r55.c;
        if (r56 == null) goto L124;
        r56.setOnScrollChangeListener(new a(r16));
    L124:
        LarusDoraFeatureIntroductionFragmentBinding r57 = r16.f;
        if (r57 == null) goto L130;
        NestedScrollView r58 = r57.c;
        if (r58 == null) goto L130;
        r58.post(new b(r16));
        goto L130
    L58:
        r28 = null;
        goto L59
    L54:
        r27 = null;
        goto L55
    L50:
        r26 = 0;
        goto L51
    L19:
        r10 = null;
    L130:
        return Unit.INSTANCE;
    L132:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
