package com.larus.bmhome.chat.layout.item;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.GestureCardView;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.item.LynxBox$initAppletLynxView$1", f = "LynxBox.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class LynxBox$initAppletLynxView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ e1 $lynxBoxConfig;
    final /* synthetic */ Message $message;
    Object L$0;
    int label;
    final /* synthetic */ LynxBox this$0;

    public LynxBox$initAppletLynxView$1(LynxBox r1, e1 r2, Message r3, Fragment r4, Continuation<? super LynxBox$initAppletLynxView$1> r5) {
        this.this$0 = r1;
        this.$lynxBoxConfig = r2;
        this.$message = r3;
        this.$fragment = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LynxBox$initAppletLynxView$1(this.this$0, this.$lynxBoxConfig, this.$message, this.$fragment, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r28) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        LynxBox r1 = (LynxBox) this.L$0;
        ResultKt.throwOnFailure(r28);
        Object r3 = r28;
    L45:
        com.larus.bmhome.chat.api.r r4 = (com.larus.bmhome.chat.api.r) r3;
        if (r4 == null) goto L48;
        WidgetBoxView r5 = r4.a();
    L49:
        r1.setAppletLynxView(r5);
        if (this.this$0.getAppletLynxView() == null) goto L52;
        View r6 = this.this$0.getAppletLynxView();
        if (r6 == null) goto L56;
        ViewParent r7 = r6.getParent();
    L58:
        if ((r7 instanceof ViewGroup) == false) goto L60;
        ViewGroup r8 = (ViewGroup) r7;
    L61:
        if (r8 == null) goto L64;
        r8.removeView(this.this$0.getAppletLynxView());
    L64:
        if (this.this$0.getTemplateInfo().getCardType() != 1) goto L66;
    L69:
        AttributeSet r9 = null;
        float r10 = this.this$0.getResources().getDimension(v19.c.b(2130971546, null, 2131167462));
    L70:
        CardView r11 = new GestureCardView(this.this$0.getContext(), r9, 6, 0);
        LynxBox r12 = this.this$0;
        e1 r13 = this.$lynxBoxConfig;
        r11.setLayoutParams(new LinearLayout.LayoutParams(r12.getMaxWidth(), -1));
        if (r13.b == true) goto L73;
        r11.setCardBackgroundColor(ContextCompat.getColor(r11.getContext(), 2131102529));
    L73:
        r11.setRadius(r10);
        r11.setElevation(0.0f);
        if (r13.e == false) goto L76;
        pt8.a r14 = new pt8.a(r11.getContext(), r10);
        r14.addView(r12.getAppletLynxView(), new ViewGroup.LayoutParams(r12.getMaxWidth(), -1));
        r11.addView(r14, new ViewGroup.LayoutParams(-1, -1));
    L77:
        r11.setStrokeColor(ContextCompat.getColor(r11.getContext(), 2131103162));
        r11.setStrokeWidth(r13.f ? 1 : 0);
        if (r12.getTemplateInfo().getCardType() == 1) goto L80;
    L82:
        LynxBox r15 = this.this$0;
        r15.F = r11;
        View.OnLongClickListener r16 = r15.G;
        if (r16 == null) goto L85;
        r15.w(r16);
    L85:
        this.this$0.addView(r11, new ViewGroup.LayoutParams(-1, -1));
        LynxBox r17 = this.this$0;
        List<Runnable> r18 = r17.C;
        monitor-enter(r18);
        Iterator r19 = ((ArrayList) r17.C).iterator();     // Catch: Throwable -> L95
    L89:
        if (r19.hasNext() == false) goto L91;
        ((Runnable) r19.next()).run();     // Catch: Throwable -> L95
        goto L89
    L91:
        ((ArrayList) r17.C).clear();     // Catch: Throwable -> L95
        monitor-exit(r18);
        return Unit.INSTANCE;
    L95:
        th = move-exception;
        throw th;
    L80:
        if (r13.b == true) goto L82;
        View r20 = new View(r11.getContext());
        r20.setBackgroundResource(2131242973);
        r20.setLayoutParams(new LinearLayout.LayoutParams(r12.getMaxWidth(), -1));
        r11.addView(r20, new FrameLayout.LayoutParams(-1, -1));
        goto L82
    L76:
        r11.addView(r12.getAppletLynxView(), new ViewGroup.LayoutParams(r12.getMaxWidth(), -1));
        goto L77
    L66:
        if (this.$lynxBoxConfig.d == true) goto L69;
        r10 = 0.0f;
        r9 = null;
        goto L70
    L60:
        r8 = null;
        goto L61
    L56:
        r7 = null;
        goto L58
    L52:
        return Unit.INSTANCE;
    L48:
        r5 = null;
        goto L49
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        LynxBox r21 = this.this$0;
        String r22 = this.$lynxBoxConfig.g;
        int r23 = LynxBox.M;
        String r110 = r21.r(r22);
        String r24 = this.this$0.I;
        String r25 = this.$message.getMessageId();
        if (r25 != null) goto L11;
        r25 = "";
    L11:
        String r26 = r25;
        String r111 = this.$message.getSenderId();
        String r112 = this.$message.getConversationId();
        String r113 = this.$message.getSectionId();
        String r114 = this.$message.getReplyId();
        LynxBox r27 = this.this$0;
        b1 r29 = r27.L;
        int r115 = r27.getMaxWidth();
        Message r30 = this.$message;
        Map r31 = MapsKt.createMapBuilder();
        Map r116 = r30.getExt();
        if (r116 == null) goto L16;
        String r32 = (String) r116.get("fpa_common_param");
        if (r32 == null) goto L16;
        String r33 = (String) r31.put("fpa_common_param", r32);
    L16:
        Map r34 = r30.getExt();
        if (r34 == null) goto L21;
        String r35 = (String) r34.get("doubaoapp_da_params");
        if (r35 == null) goto L21;
        r31.put("doubaoapp_da_params", r35);
    L21:
        Map r36 = MapsKt.build(r31);
        if ((!r36.isEmpty()) == false) goto L24;
        Map r117 = r36;
    L25:
        boolean r37 = this.$lynxBoxConfig.k;
        Pair[] r38 = new Pair[5];
        r38[0] = TuplesKt.to("createTime", Boxing.boxLong(this.$message.getCreateTime()));
        IFlowSdkDepend r39 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r39 == null) goto L28;
        r39.r();
        Boolean r40 = Boxing.boxBoolean(mc9.a.a.h());
    L29:
        r38[1] = TuplesKt.to("hasFirstFeedShow", r40);
        IFlowSdkDepend r41 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r41 == null) goto L32;
        r41.r();
        Long r42 = Boxing.boxLong(mc9.a.a.g());
    L33:
        r38[2] = TuplesKt.to("coldStartTime", r42);
        va8.x r43 = LynxBox.o(this.this$0);
        if (r43 == null) goto L36;
        Boolean r44 = Boxing.boxBoolean(r43.W());
    L37:
        r38[3] = TuplesKt.to("hasPageFirstFeedShow", r44);
        va8.x r45 = LynxBox.o(this.this$0);
        if (r45 == null) goto L40;
        Long r46 = Boxing.boxLong(r45.O());
    L41:
        r38[4] = TuplesKt.to("openPageTime", r46);
        com.larus.bmhome.chat.api.v0 r47 = new com.larus.bmhome.chat.api.v0(r26, r111, r112, r113, r114, r110, null, r29, 0, r115, r117, MapsKt.mapOf(r38), r37, false, r24, null, null, 106496);
        LynxBox r48 = this.this$0;
        r48.H = r47;
        WidgetRenderDelegate r49 = WidgetRenderDelegate.a;
        Fragment r50 = this.$fragment;
        this.L$0 = r48;
        this.label = 1;
        r3 = r49.m(r50, r47, this);
        if (r3 != r0) goto L44;
        return r0;
    L44:
        r1 = r48;
        goto L45
    L40:
        r46 = null;
        goto L41
    L36:
        r44 = null;
        goto L37
    L32:
        r42 = null;
        goto L33
    L28:
        r40 = null;
        goto L29
    L24:
        r117 = null;
        goto L25
    }
}
