package com.suite.lark.platform.component.cta;

import android.app.Activity;
import android.content.Intent;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.suite.lark.platform.component.cta.newstyle.CTAContainerActivity;
import com.suite.lark.platform.component.cta.newstyle.entity.CTAParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.component.cta.CTADialogPresenter$fetchStuckSpotAndShowDialog$1", f = "CTADialogPresenter.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class CTADialogPresenter$fetchStuckSpotAndShowDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ goc.a $callback;
    final /* synthetic */ Activity $context;
    int label;
    final /* synthetic */ b this$0;

    public CTADialogPresenter$fetchStuckSpotAndShowDialog$1(b r1, goc.a r2, Activity r3, Continuation<? super CTADialogPresenter$fetchStuckSpotAndShowDialog$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CTADialogPresenter$fetchStuckSpotAndShowDialog$1(this.this$0, this.$callback, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r8 = true;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L11:
        com.larksuite.rucket.job.base.b.c r2 = (com.larksuite.rucket.job.base.b) r1;
        int r3 = hoc.a.a;
        boolean r4 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.purchase_cta.version_info");
        if ((r2 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L15;
        goc.b r5 = (goc.b) r2.b;
    L21:
        if (r4 == false) goto L23;
        com.suite.lark.platform.component.cta.newstyle.h.a = r5;
        goc.a r6 = CTAContainerActivity.b;
        Activity r9 = this.$context;
        b r10 = this.this$0;
        CTAParams r11 = new CTAParams(r10.a, r10.b, r10.c, r10.d);
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "ctaParams");
        Intent r12 = new Intent(r9, CTAContainerActivity.class);
        r12.putExtra("intent_cta_params", r11);
        r9.startActivity(r12);
        CTAContainerActivity.b = this.$callback;
    L96:
        return Unit.INSTANCE;
    L23:
        b r13 = this.this$0;
        Activity r14 = this.$context;
        goc.a r15 = this.$callback;
        int r16 = b.f;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r14, "context");
        goc.b.g r18 = r5.b();
        UDBaseDialogBuilder r19 = null;
        if (r18 == null) goto L93;
        goc.b.f r110 = r18.a();
        if (r110 == null) goto L93;
        goc.b.c r111 = r110.a();
        if (r110.c() != null) goto L41;
        if (r111 != null) goto L41;
        List<goc.b.d> r112 = r110.b();
        if (r112 != null) goto L35;
    L38:
        boolean r113 = true;
    L39:
        if (r113 == false) goto L41;
    L35:
        if (r112.isEmpty() == true) goto L38;
        r113 = false;
    L41:
        foc.a r114 = new foc.a(r14);
        r114.cancelOnTouchOutside(false);
        goc.b.l r115 = r110.c();
        if (r115 == null) goto L54;
        String r116 = r115.a();
        if (r116 == null) goto L54;
        if (r116.length() <= 0) goto L48;
        boolean r117 = true;
    L49:
        if (r117 == true) goto L52;
        r116 = null;
    L52:
        if (r116 == null) goto L54;
        foc.a r118 = (foc.a) r114.title(r116);
        goto L54
    L48:
        r117 = false;
    L54:
        if (r111 == null) goto L75;
        goc.b.j r119 = r111.b();
        if (r119 == null) goto L67;
        UDBaseDialogBuilder r120 = r119.a();
        if (r120 == null) goto L67;
        if (r120.length() > 0) goto L63;
        r8 = false;
    L63:
        if (r8 == false) goto L65;
        r19 = r120;
    L65:
        if (r19 == null) goto L67;
        Intrinsics.checkNotNullParameter(r19, "imageUrl");
        r114.a = r19;
    L67:
        List<goc.b.l> r20 = r111.c();
        if (r20 != null) goto L70;
        r20 = CollectionsKt.emptyList();
    L70:
        Iterator r21 = CollectionsKt.filterNotNull(r20).iterator();
    L72:
        if (r21.hasNext() == false) goto L74;
        goc.b.l r22 = (goc.b.l) r21.next();
        Intrinsics.checkNotNullParameter(r22, INotificationHitPoint.NoticeType.MESSAGE);
        ((ArrayList) r114.b).add(r22);
        goto L72
    L74:
        c r23 = new c(r14, r18, r13);
        Intrinsics.checkNotNullParameter(r23, "listener");
        r114.c = r23;
    L75:
        List<goc.b.d> r24 = r110.b();
        if (r24 != null) goto L78;
        r24 = CollectionsKt.emptyList();
    L78:
        Iterator r25 = CollectionsKt.filterNotNull(r24).iterator();
    L80:
        if (r25.hasNext() == false) goto L92;
        goc.b.d r121 = (goc.b.d) r25.next();
        if (Intrinsics.areEqual(r121.d(), "primary") == false) goto L87;
        String r26 = r121.b();
        if (r26 != null) goto L86;
        r26 = "";
    L86:
        UDBaseDialogBuilder r27 = r114.addActionButton(2131391777, r26, new d(r13, r14, r5, r121, r15));
    L91:
        foc.a r28 = (foc.a) r27;
        r25 = r25;
        goto L80
    L87:
        String r29 = r121.b();
        if (r29 != null) goto L90;
        r29 = "";
    L90:
        r27 = r114.addActionButton(2131391778, r29, new e(r13, r14, r5, r121, r15));
        goto L91
    L92:
        r114.lifecycleCallback(new f(r15, r18, r13));
        r114.onCancelListener(new g(r18, r13));
        r114.onDismissListener(new h(r15));
        r19 = r114;
    L93:
        if (r19 == null) goto L96;
        r19.show();
        goto L96
    L15:
        if ((r2 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L98;
        StringBuilder r30 = new StringBuilder("fetch stuck spot error: ");
        com.larksuite.rucket.job.base.b.b r31 = (com.larksuite.rucket.job.base.b.b) r2;
        r30.append(r31.b.getDebugMsg());
        Log.w("CTADialog", r30.toString());
        goc.a r32 = this.$callback;
        if (r32 == null) goto L19;
        r32.onError(r31.b);
    L19:
        b r33 = this.this$0;
        Activity r34 = this.$context;
        int r35 = b.f;
        r33.getClass();
        r5 = new goc.b(new goc.b.g(new goc.b.f(new goc.b.l(r34.getString(2131890624), 2), new goc.b.c(CollectionsKt.listOf(new goc.b.l[]{new goc.b.l(r34.getString(2131890622), 2), new goc.b.l(r34.getString(2131890621), 2)}), 5), CollectionsKt.listOf(new goc.b.d(r34.getString(2131890623), new goc.b.a(""))), 1), 1), 3);
        goto L21
    L98:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        b r36 = this.this$0;
        com.suite.lark.platform.component.cta.model.a r37 = r36.e;
        String r38 = r36.a;
        String r39 = r36.b;
        String r40 = r36.c;
        String r41 = r36.d;
        this.label = 1;
        r1 = r37.a(r38, r39, r40, r41, this);
        if (r1 != r7) goto L11;
        return r7;
    }
}
