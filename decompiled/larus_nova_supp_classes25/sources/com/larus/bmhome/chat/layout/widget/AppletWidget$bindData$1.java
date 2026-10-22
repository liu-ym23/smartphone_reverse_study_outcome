package com.larus.bmhome.chat.layout.widget;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.AppletWidget$bindData$1", f = "AppletWidget.kt", i = {0}, l = {358}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AppletWidget$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $hostFragment;
    final /* synthetic */ com.larus.bmhome.chat.api.v0 $widgetRenderData;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletWidget this$0;

    public AppletWidget$bindData$1(Fragment r1, com.larus.bmhome.chat.api.v0 r2, AppletWidget r3, Continuation<? super AppletWidget$bindData$1> r4) {
        this.$hostFragment = r1;
        this.$widgetRenderData = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppletWidget$bindData$1 r0 = new AppletWidget$bindData$1(this.$hostFragment, this.$widgetRenderData, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        com.larus.bmhome.chat.api.r r8 = (com.larus.bmhome.chat.api.r) r7;
        JobKt.ensureActive(r3.getCoroutineContext());
        this.this$0.setWidgetContainer(r8);
        if (r8 != null) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L20;
        this.this$0.j(Boxing.boxFloat(0.0f), Boxing.boxFloat(0.0f), Boxing.boxFloat(0.0f), Boxing.boxFloat(0.0f));
    L20:
        AppletWidget r4 = this.this$0;
        com.larus.bmhome.chat.api.v0 r5 = r4.l;
        if (r5 == null) goto L23;
        Fragment r6 = this.$hostFragment;
        r4.l = null;
        WidgetRenderDelegate.a.e(r6, r5);
    L23:
        if (r8 == null) goto L25;
        WidgetBoxView r9 = r8.a();
    L26:
        this.this$0.n.a("bindData: bindingJob is completed, widgetContainer = " + this.this$0.getWidgetContainer() + ", widgetView = " + r9);
        if (r9 == null) goto L45;
        AppletWidget r10 = this.this$0;
        kc8.e0 r11 = r10.p;
        r10.p = r11;
        int r12 = kc8.z0.a;
        com.larus.bmhome.chat.api.r r13 = r10.f;
        if (r13 == null) goto L31;
        WidgetBoxView r14 = r13.a();
    L32:
        if (r14 == null) goto L34;
        r14.setTag(2131377375, r11);
    L34:
        AppletWidget r15 = this.this$0;
        r15.i(r15.q);
        if (Intrinsics.areEqual(r9.getParent(), this.this$0) == true) goto L43;
        ViewParent r16 = r9.getParent();
        if ((r16 instanceof ViewGroup) == false) goto L39;
        ViewGroup r17 = (ViewGroup) r16;
    L40:
        if (r17 == null) goto L42;
        this.this$0.n.b("bindData: removeView from parent", null);
        r17.removeView(r9);
    L42:
        this.this$0.addView(r9, 0, new FrameLayout.LayoutParams(AppletWidget.a(this.this$0), -2));
    L44:
        this.this$0.f();
    L47:
        return Unit.INSTANCE;
    L39:
        r17 = null;
        goto L40
    L43:
        this.this$0.n.b("bindData: widgetView is already added", null);
        goto L44
    L31:
        r14 = null;
        goto L32
    L45:
        this.this$0.n.b("bindData: widgetView is NULL", null);
        this.this$0.k(AppletWidget.WidgetShowState.FAIL, false);
        goto L47
    L25:
        r9 = null;
        goto L26
    L15:
        if (r8.getBoxType() != 4) goto L17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        WidgetRenderDelegate r19 = WidgetRenderDelegate.a;
        Fragment r20 = this.$hostFragment;
        com.larus.bmhome.chat.api.v0 r21 = this.$widgetRenderData;
        this.L$0 = r18;
        this.label = 1;
        Object r22 = r19.m(r20, r21, this);
        if (r22 != r0) goto L11;
        return r0;
    L11:
        r3 = r18;
        r7 = r22;
        goto L12
    }
}
