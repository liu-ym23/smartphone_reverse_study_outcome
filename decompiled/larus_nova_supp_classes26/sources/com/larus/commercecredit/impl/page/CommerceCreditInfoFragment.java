package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.impl.databinding.LarusFragmentCommerceCreditInfoBinding;
import com.larus.commercecredit.impl.page.adapter.CommerceCreditTaskAdapter;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import com.larus.home.impl.sdk.c1;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J$\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/larus/commercecredit/impl/page/CommerceCreditInfoFragment;", "Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "Lcom/larus/commercecredit/impl/databinding/LarusFragmentCommerceCreditInfoBinding;", "<init>", "()V", "creditTaskAdapter", "Lcom/larus/commercecredit/impl/page/adapter/CommerceCreditTaskAdapter;", "getCreditTaskAdapter", "()Lcom/larus/commercecredit/impl/page/adapter/CommerceCreditTaskAdapter;", "creditTaskAdapter$delegate", "Lkotlin/Lazy;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "initViews", "", "setupAccessibility", "adapterPadConfig", "updateViews", "localCreditConfig", "Lcom/larus/commercecredit/impl/entity/CreditInfoAndTasks;", "remoteCreditConfig", "isFromLocal", "", "updateCreditTasksHeight", "creditTasks", "", "Lcom/larus/commercecredit/impl/entity/CreditTask;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceCreditInfoFragment extends BaseCommerceCreditFragment<LarusFragmentCommerceCreditInfoBinding> {
    public static final /* synthetic */ int g = 0;
    public final Lazy f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$initViews$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceCreditInfoFragment$initViews$1", f = "CommerceCreditInfoFragment.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CommerceCreditInfoFragment this$0;

        public AnonymousClass1(CommerceCreditInfoFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            CommerceCreditConfigManager r13 = CommerceCreditConfigManager.a;
            CreditInfoScene r3 = CreditInfoScene.COMMERCE_CREDIT_INFO_PANEL;
            int r14 = com.larus.commercecredit.impl.utils.k.a;
            String r6 = com.larus.commercecredit.impl.utils.k.a(this.this$0.getArguments(), "previous_page");
            String r7 = com.larus.commercecredit.impl.utils.k.a(this.this$0.getArguments(), "enter_method");
            final CommerceCreditInfoFragment r15 = this.this$0;
            Function3 r8 = new p(r15);
            this.label = 1;
            if (CommerceCreditConfigManager.b(r3, false, true, r6, r7, r8, this, 2) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void initViews() {
        boolean r1 = false;
        if (e2.a.isPad() == false) goto L14;
        int r0 = i5.Q();
        LarusFragmentCommerceCreditInfoBinding r2 = (LarusFragmentCommerceCreditInfoBinding) this.d;
        if (r2 == null) goto L9;
        LinearLayout r3 = r2.e;
        if (r3 == null) goto L9;
        r3.setPadding(r0, 0, 0, 0);
    L9:
        LarusFragmentCommerceCreditInfoBinding r4 = (LarusFragmentCommerceCreditInfoBinding) this.d;
        if (r4 == null) goto L14;
        RecyclerView r5 = r4.f;
        if (r5 == null) goto L14;
        r5.setPadding(r0, 0, r0, 0);
    L14:
        LarusFragmentCommerceCreditInfoBinding r6 = (LarusFragmentCommerceCreditInfoBinding) this.d;
        if (r6 == null) goto L19;
        RecyclerView r7 = r6.f;
        if (r7 == null) goto L19;
        r7.setLayoutManager(new LinearLayoutManager(getContext()));
    L19:
        LarusFragmentCommerceCreditInfoBinding r8 = (LarusFragmentCommerceCreditInfoBinding) this.d;
        if (r8 == null) goto L24;
        RecyclerView r9 = r8.f;
        if (r9 == null) goto L24;
        r9.setAdapter((CommerceCreditTaskAdapter) this.f.getValue());
    L24:
        LarusFragmentCommerceCreditInfoBinding r10 = (LarusFragmentCommerceCreditInfoBinding) this.d;
        if (r10 == null) goto L29;
        RecyclerView r11 = r10.f;
        if (r11 == null) goto L29;
        r11.setItemAnimator(null);
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L34;
        r12.S();
        if (c1.a.a() != true) goto L34;
        r1 = true;
    L34:
        if (r1 == false) goto L44;
        Dialog r13 = getDialog();
        if (r13 == null) goto L43;
        View r14 = r13.findViewById(2131392603);
        if (r14 == null) goto L45;
        e1.x(r14);
        e1.d(r14, new h(this));
        return;
    L45:
        return;
    L43:
        return;
    }

    public CommerceCreditInfoFragment() {
        this.f = LazyKt.lazy(new g(this));
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final Class<? extends Activity> T90() {
        return CommerceCreditInfoActivity.class;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final ViewBinding S90(LayoutInflater r17, ViewGroup r18) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131562361, r18, false);
        int r1 = 2131376159;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r0, 2131376159);
        if (r5 == null) goto L27;
        r1 = 2131377468;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131377468);
        if (r6 == null) goto L27;
        r1 = 2131377491;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131377491);
        if (r7 == null) goto L27;
        r1 = 2131377661;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131377661);
        if (r8 == null) goto L27;
        r1 = 2131384940;
        RecyclerView r9 = ViewBindings.findChildViewById(r0, 2131384940);
        if (r9 == null) goto L27;
        r1 = 2131390461;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131390461);
        if (r10 == null) goto L27;
        r1 = 2131390462;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131390462);
        if (r11 == null) goto L27;
        r1 = 2131390465;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131390465);
        if (r12 == null) goto L27;
        r1 = 2131390852;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r0, 2131390852);
        if (r13 == null) goto L27;
        r1 = 2131392493;
        View r14 = ViewBindings.findChildViewById(r0, 2131392493);
        if (r14 == null) goto L27;
        r1 = 2131392603;
        View r15 = ViewBindings.findChildViewById(r0, 2131392603);
        if (r15 == null) goto L27;
        return new LarusFragmentCommerceCreditInfoBinding(r0, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public static final void X90(final CommerceCreditInfoFragment r8, qz8.g r9, qz8.g r10, boolean r11) {
        r8.getClass();
        ViewGroup.MarginLayoutParams r0 = null;
        if (r9 == null) goto L7;
        qz8.f r1 = r9.a();
        if (r1 == null) goto L7;
        Long r2 = r1.f();
    L8:
        if (r2 != null) goto L10;
    L11:
        if (r10 == null) goto L15;
        qz8.f r3 = r10.a();
        if (r3 == null) goto L15;
        Long r4 = r3.f();
    L16:
        if (r4 != null) goto L18;
    L34:
        if (r11 == true) goto L50;
        LarusFragmentCommerceCreditInfoBinding r5 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r5 == null) goto L40;
        LinearLayout r6 = r5.d;
        if (r6 == null) goto L40;
        e1.d(r6, new j(r8));
    L40:
        LarusFragmentCommerceCreditInfoBinding r7 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r7 == null) goto L45;
        LinearLayout r12 = r7.c;
        if (r12 == null) goto L45;
        e1.o(r12);
    L45:
        LarusFragmentCommerceCreditInfoBinding r13 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r13 == null) goto L65;
        LinearLayout r14 = r13.d;
        if (r14 == null) goto L65;
        e1.x(r14);
    L65:
        if (r11 == true) goto L68;
        r9 = r10;
    L68:
        if (r9 == null) goto L70;
        qz8.f r15 = r9.a();
    L71:
        if (r9 == null) goto L73;
        final qz8.i r16 = r9.b();
    L74:
        if (r9 == null) goto L78;
        List<qz8.j> r17 = r9.c();
        if (r17 == null) goto L78;
        final List r18 = CollectionsKt.filterNotNull(r17);
    L79:
        String r19 = "";
        if (r15 == null) goto L174;
        String r20 = String.valueOf(r15.f());
        int r21 = r20.length();
        boolean r22 = true;
        if (r21 < 11) goto L89;
        LarusFragmentCommerceCreditInfoBinding r23 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r23 == null) goto L110;
        TextView r24 = r23.i;
        if (r24 == null) goto L110;
        r24.setTextSize(0, i5.S());
    L110:
        int r25 = 0;
    L117:
        LarusFragmentCommerceCreditInfoBinding r26 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r26 == null) goto L122;
        TextView r27 = r26.i;
        if (r27 == null) goto L122;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
    L124:
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == false) goto L126;
        r0 = (ViewGroup.MarginLayoutParams) r28;
    L126:
        if (r0 == null) goto L128;
        r0.topMargin = r25;
    L128:
        LarusFragmentCommerceCreditInfoBinding r29 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r29 == null) goto L133;
        TextView r30 = r29.i;
        if (r30 == null) goto L133;
        r30.setLayoutParams(r0);
    L133:
        LarusFragmentCommerceCreditInfoBinding r31 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r31 == null) goto L138;
        TextView r32 = r31.i;
        if (r32 == null) goto L138;
        r32.setText(r20);
    L138:
        LarusFragmentCommerceCreditInfoBinding r33 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r33 == null) goto L143;
        SimpleDraweeView r34 = r33.b;
        if (r34 == null) goto L143;
        ImageLoaderKt.u(r34, qz8.h.a(r15.e(), r15.d()), "commerce_credit_info");
    L143:
        LarusFragmentCommerceCreditInfoBinding r35 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r35 == null) goto L152;
        TextView r36 = r35.h;
        if (r36 == null) goto L152;
        String r37 = r15.c();
        if (r37 != null) goto L151;
        r37 = "";
    L151:
        r36.setText(r37);
    L152:
        String r38 = r15.b();
        if (r38 != null) goto L155;
    L158:
        if (r22 == false) goto L164;
        LarusFragmentCommerceCreditInfoBinding r110 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r110 == null) goto L174;
        TextView r111 = r110.g;
        if (r111 == null) goto L174;
        e1.o(r111);
        goto L174
    L164:
        LarusFragmentCommerceCreditInfoBinding r39 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r39 == null) goto L169;
        TextView r40 = r39.g;
        if (r40 == null) goto L169;
        r40.setText(r15.b());
    L169:
        LarusFragmentCommerceCreditInfoBinding r112 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r112 == null) goto L174;
        TextView r113 = r112.g;
        if (r113 == null) goto L174;
        e1.x(r113);
        goto L174
    L155:
        if (r38.length() == 0) goto L158;
        r22 = false;
    L122:
        r28 = null;
        goto L124
    L89:
        if (9 > r21) goto L92;
        if (r21 >= 11) goto L92;
        boolean r41 = true;
    L93:
        if (r41 == false) goto L100;
        LarusFragmentCommerceCreditInfoBinding r42 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r42 == null) goto L110;
        TextView r43 = r42.i;
        if (r43 == null) goto L110;
        r43.setTextSize(0, i5.W());
        goto L110
    L100:
        if (6 > r21) goto L103;
        if (r21 >= 9) goto L103;
        boolean r44 = true;
    L104:
        if (r44 == false) goto L111;
        LarusFragmentCommerceCreditInfoBinding r45 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r45 == null) goto L110;
        TextView r46 = r45.i;
        if (r46 == null) goto L110;
        r46.setTextSize(0, i5.c0());
        goto L110
    L111:
        LarusFragmentCommerceCreditInfoBinding r47 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r47 == null) goto L116;
        TextView r48 = r47.i;
        if (r48 == null) goto L116;
        r48.setTextSize(0, i5.k0());
    L116:
        r25 = i5.e0();
    L103:
        r44 = false;
    L92:
        r41 = false;
    L174:
        if (r16 == null) goto L193;
        LarusFragmentCommerceCreditInfoBinding r114 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r114 == null) goto L183;
        TextView r115 = r114.j;
        if (r115 == null) goto L183;
        String r49 = r16.b();
        if (r49 == null) goto L182;
        r19 = r49;
    L182:
        r115.setText(r19);
    L183:
        LarusFragmentCommerceCreditInfoBinding r116 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r116 == null) goto L188;
        TextView r117 = r116.j;
        if (r117 == null) goto L188;
        e1.d(r117, new k(r16, r8));
    L188:
        LarusFragmentCommerceCreditInfoBinding r118 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r118 == null) goto L193;
        LinearLayout r119 = r118.e;
        if (r119 == null) goto L193;
        e1.d(r119, new l(r8));
    L193:
        if (r18 == null) goto L202;
        ((CommerceCreditTaskAdapter) r8.f.getValue()).submitList(r18);
        View r120 = r8.getView();
        if (r120 == null) goto L197;
        r120.post(new n(r8, r18));
    L197:
        LarusFragmentCommerceCreditInfoBinding r50 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r50 == null) goto L202;
        RecyclerView r51 = r50.f;
        if (r51 == null) goto L202;
        r51.post(new m(r8));
    L202:
        View r52 = r8.getView();
        if (r52 == null) goto L206;
        r52.post(new b(r8));
        return;
    L206:
        return;
    L78:
        r18 = null;
        goto L79
    L73:
        r16 = null;
        goto L74
    L70:
        r15 = null;
        goto L71
    L50:
        LarusFragmentCommerceCreditInfoBinding r53 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r53 == null) goto L55;
        LinearLayout r54 = r53.d;
        if (r54 == null) goto L55;
        r54.setOnClickListener(null);
    L55:
        LarusFragmentCommerceCreditInfoBinding r55 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r55 == null) goto L60;
        LinearLayout r56 = r55.c;
        if (r56 == null) goto L60;
        e1.q(r56);
    L60:
        LarusFragmentCommerceCreditInfoBinding r57 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r57 == null) goto L65;
        LinearLayout r58 = r57.d;
        if (r58 == null) goto L65;
        e1.o(r58);
        goto L65
    L18:
        if (r10.a().c() == null) goto L34;
    L19:
        LarusFragmentCommerceCreditInfoBinding r59 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r59 == null) goto L24;
        LinearLayout r60 = r59.d;
        if (r60 == null) goto L24;
        r60.setOnClickListener(null);
    L24:
        LarusFragmentCommerceCreditInfoBinding r61 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r61 == null) goto L29;
        LinearLayout r62 = r61.c;
        if (r62 == null) goto L29;
        e1.x(r62);
    L29:
        LarusFragmentCommerceCreditInfoBinding r63 = (LarusFragmentCommerceCreditInfoBinding) r8.d;
        if (r63 == null) goto L65;
        LinearLayout r64 = r63.d;
        if (r64 == null) goto L65;
        e1.o(r64);
    L15:
        r4 = null;
        goto L16
    L10:
        if (r9.a().c() != null) goto L19;
    L7:
        r2 = null;
        goto L8
    }
}
