package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.commercecredit.impl.databinding.LarusFragmentCommerceInviteFriendsBinding;
import com.larus.commercecredit.impl.page.adapter.CommerceInviteInfoAdapter;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import com.larus.home.impl.sdk.c1;
import com.larus.home.impl.sdk.h2;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0014J&\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\f2\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020$0#H\u0002J&\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u001b0#H\u0002J\b\u0010(\u001a\u00020)H\u0002J$\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020)H\u0002J\u0012\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0002J*\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u00109\u001a\u00020\u001b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002J\u0018\u0010=\u001a\u00020\u001b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/commercecredit/impl/page/CommerceInviteFriendsFragment;", "Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "Lcom/larus/commercecredit/impl/databinding/LarusFragmentCommerceInviteFriendsBinding;", "<init>", "()V", "inviteInfoAdapter", "Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter;", "getInviteInfoAdapter", "()Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter;", "inviteInfoAdapter$delegate", "Lkotlin/Lazy;", "campaignKey", "", "getCampaignKey", "()Ljava/lang/String;", "campaignKey$delegate", "invitationInfo", "Lcom/larus/commercecredit/impl/entity/GroupInvitationInfo;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "initViews", "", "setupAccessibility", "adapterNightMode", "adapterPadConfig", "initEvents", "handleShareAction", "shareChannel", "createShareContent", "Lkotlin/Function1;", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "getGroupInvitationInfo", "scene", "inviteAction", "checkSecurityMode", "", "updateCampaignInfo", "localCampaignInfo", "Lcom/larus/commercecredit/impl/entity/CampaignInfo;", "remoteCampaignInfo", "isFromLocal", "setupBasicInfo", "basicInfo", "Lcom/larus/commercecredit/impl/entity/BasicInfo;", "setupDescriptionText", "setupClickableDescription", "fullText", "startIndex", "", "endIndex", "schema", "setupStepList", "stepList", "", "Lcom/larus/commercecredit/impl/entity/Step;", "updateInviteInfoHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceInviteFriendsFragment extends BaseCommerceCreditFragment<LarusFragmentCommerceInviteFriendsBinding> {
    public static final /* synthetic */ int i = 0;
    public final Lazy f;
    public final Lazy g;
    public qz8.l h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.page.CommerceInviteFriendsFragment$initViews$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceInviteFriendsFragment$initViews$1", f = "CommerceInviteFriendsFragment.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CommerceInviteFriendsFragment this$0;

        public AnonymousClass1(CommerceInviteFriendsFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CommerceCreditConfigManager r6 = CommerceCreditConfigManager.a;
            CommerceInviteFriendsFragment r7 = this.this$0;
            int r2 = CommerceInviteFriendsFragment.i;
            String r8 = (String) r7.g.getValue();
            final CommerceInviteFriendsFragment r3 = this.this$0;
            Function3 r4 = new j0(r3);
            this.label = 1;
            if (CommerceCreditConfigManager.c("CommerceInviteFriendsFragment_initViews", r8, true, r4, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public CommerceInviteFriendsFragment() {
        this.f = LazyKt.lazy(new c0());
        this.g = LazyKt.lazy(new d0(this));
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void V90() {
        super.V90();
        LarusFragmentCommerceInviteFriendsBinding r0 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r0 == null) goto L7;
        LinearLayout r1 = r0.b;
        if (r1 == null) goto L7;
        e1.d(r1, new w(this));
    L7:
        LarusFragmentCommerceInviteFriendsBinding r2 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r2 == null) goto L12;
        LinearLayout r3 = r2.c;
        if (r3 == null) goto L12;
        e1.d(r3, new z(this));
    L12:
        LarusFragmentCommerceInviteFriendsBinding r4 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r4 == null) goto L18;
        TextView r5 = r4.l;
        if (r5 == null) goto L19;
        e1.d(r5, new a0(this));
        return;
    L19:
        return;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void initViews() {
        Context r0 = getContext();
        if (r0 == null) goto L26;
        boolean r1 = v19.h.a;
        if (v19.h.b(r0) == false) goto L16;
        LarusFragmentCommerceInviteFriendsBinding r2 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r2 == null) goto L11;
        SimpleDraweeView r3 = r2.e;
        if (r3 == null) goto L11;
        r3.setActualImageResource(2131241074);
    L11:
        LarusFragmentCommerceInviteFriendsBinding r4 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r4 == null) goto L26;
        SimpleDraweeView r5 = r4.g;
        if (r5 == null) goto L26;
        r5.setActualImageResource(2131241076);
        goto L26
    L16:
        LarusFragmentCommerceInviteFriendsBinding r6 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r6 == null) goto L21;
        SimpleDraweeView r7 = r6.e;
        if (r7 == null) goto L21;
        r7.setActualImageResource(2131241073);
    L21:
        LarusFragmentCommerceInviteFriendsBinding r8 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r8 == null) goto L26;
        SimpleDraweeView r9 = r8.g;
        if (r9 == null) goto L26;
        r9.setActualImageResource(2131241075);
    L26:
        boolean r10 = false;
        if (e2.a.isPad() == false) goto L53;
        int r11 = i5.Q();
        LarusFragmentCommerceInviteFriendsBinding r12 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r12 == null) goto L33;
        LinearLayout r13 = r12.i;
        if (r13 == null) goto L33;
        r13.setPadding(r11, 0, r11, 0);
    L33:
        LarusFragmentCommerceInviteFriendsBinding r14 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r14 == null) goto L38;
        TextView r15 = r14.m;
        if (r15 == null) goto L38;
        r15.setPadding(r11, 0, r11, 0);
    L38:
        LarusFragmentCommerceInviteFriendsBinding r16 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r16 == null) goto L43;
        TextView r17 = r16.m;
        if (r17 == null) goto L43;
        r17.setMaxWidth(Integer.MAX_VALUE);
    L43:
        LarusFragmentCommerceInviteFriendsBinding r18 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r18 == null) goto L48;
        RecyclerView r19 = r18.k;
        if (r19 == null) goto L48;
        r19.setPadding(r11, 0, r11, 0);
    L48:
        LarusFragmentCommerceInviteFriendsBinding r20 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r20 == null) goto L53;
        LinearLayout r21 = r20.d;
        if (r21 == null) goto L53;
        r21.setPadding(r11, 0, r11, 0);
    L53:
        LarusFragmentCommerceInviteFriendsBinding r22 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r22 == null) goto L58;
        RecyclerView r23 = r22.k;
        if (r23 == null) goto L58;
        r23.setLayoutManager(new LinearLayoutManager(getContext()));
    L58:
        LarusFragmentCommerceInviteFriendsBinding r24 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r24 == null) goto L63;
        RecyclerView r25 = r24.k;
        if (r25 == null) goto L63;
        r25.setAdapter((CommerceInviteInfoAdapter) this.f.getValue());
    L63:
        LarusFragmentCommerceInviteFriendsBinding r26 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r26 == null) goto L68;
        RecyclerView r27 = r26.k;
        if (r27 == null) goto L68;
        r27.setItemAnimator(null);
    L68:
        ShareServiceDelegate r28 = ShareServiceDelegate.b;
        if (r28.a(ShareChannel.DOUYIN) == false) goto L75;
        LarusFragmentCommerceInviteFriendsBinding r29 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r29 == null) goto L81;
        LinearLayout r30 = r29.b;
        if (r30 == null) goto L81;
        e1.x(r30);
    L81:
        if (r28.a(ShareChannel.WECHAT) == false) goto L87;
        LarusFragmentCommerceInviteFriendsBinding r31 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r31 == null) goto L92;
        LinearLayout r32 = r31.c;
        if (r32 == null) goto L92;
        e1.x(r32);
    L92:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        IFlowSdkDepend r33 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r33 == null) goto L97;
        r33.S();
        if (c1.a.a() != true) goto L97;
        r10 = true;
    L97:
        if (r10 == false) goto L107;
        Dialog r34 = getDialog();
        if (r34 == null) goto L106;
        View r35 = r34.findViewById(2131392603);
        if (r35 == null) goto L108;
        e1.x(r35);
        e1.d(r35, new b0(this));
        return;
    L108:
        return;
    L106:
        return;
    L107:
        return;
    L87:
        LarusFragmentCommerceInviteFriendsBinding r36 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r36 == null) goto L92;
        LinearLayout r37 = r36.c;
        if (r37 == null) goto L92;
        e1.o(r37);
        goto L92
    L75:
        LarusFragmentCommerceInviteFriendsBinding r38 = (LarusFragmentCommerceInviteFriendsBinding) this.d;
        if (r38 == null) goto L81;
        LinearLayout r39 = r38.b;
        if (r39 == null) goto L81;
        e1.o(r39);
        goto L81
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final Class<? extends Activity> T90() {
        return CommerceInviteFriendsActivity.class;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final ViewBinding S90(LayoutInflater r24, ViewGroup r25) {
        Intrinsics.checkNotNullParameter(r24, "inflater");
        View r0 = r24.inflate(2131562363, r25, false);
        int r1 = 2131364728;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131364728);
        if (r5 == null) goto L41;
        r1 = 2131364824;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131364824);
        if (r6 == null) goto L41;
        r1 = 2131365064;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131365064);
        if (r7 == null) goto L41;
        r1 = 2131376247;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r0, 2131376247);
        if (r8 == null) goto L41;
        r1 = 2131376328;
        SimpleDraweeView r9 = ViewBindings.findChildViewById(r0, 2131376328);
        if (r9 == null) goto L41;
        r1 = 2131376589;
        SimpleDraweeView r10 = ViewBindings.findChildViewById(r0, 2131376589);
        if (r10 == null) goto L41;
        r1 = 2131377469;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131377469);
        if (r11 == null) goto L41;
        r1 = 2131377470;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131377470);
        if (r12 == null) goto L41;
        r1 = 2131377491;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131377491);
        if (r13 == null) goto L41;
        r1 = 2131384969;
        RecyclerView r14 = ViewBindings.findChildViewById(r0, 2131384969);
        if (r14 == null) goto L41;
        r1 = 2131390407;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131390407);
        if (r15 == null) goto L41;
        r1 = 2131390487;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r0, 2131390487);
        if (r16 == null) goto L41;
        r1 = 2131390634;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r0, 2131390634);
        if (r17 == null) goto L41;
        r1 = 2131390860;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r0, 2131390860);
        if (r18 == null) goto L41;
        r1 = 2131391316;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r0, 2131391316);
        if (r19 == null) goto L41;
        r1 = 2131391370;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r0, 2131391370);
        if (r20 == null) goto L41;
        r1 = 2131392493;
        View r21 = ViewBindings.findChildViewById(r0, 2131392493);
        if (r21 == null) goto L41;
        r1 = 2131392603;
        View r22 = ViewBindings.findChildViewById(r0, 2131392603);
        if (r22 == null) goto L41;
        return new LarusFragmentCommerceInviteFriendsBinding((FrameLayout) r0, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.commercecredit.impl.page.x, kotlin.jvm.functions.Function1] */
    public final void Y90(final String r10, final Function1<? super qz8.l, com.larus.bmhome.share.panel.b> r11) {
        Context r0 = getContext();
        boolean r2 = true;
        if (r0 == null) goto L16;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L7;
        r3.T();
        h2 r4 = h2.a;
    L9:
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L16;
        r4.d(r0);
        r2 = false;
        goto L16
    L11:
        if (r4.isBasicMode() != true) goto L13;
        r5 = true;
        goto L14
    L7:
        r4 = null;
    L16:
        if (r2 == true) goto L18;
        return;
    L18:
        String r1 = "CommerceInviteFriendsFragment_handleShareAction_".concat(r10);
        ?? r6 = new x(r11, this, r10);
        qz8.l r12 = this.h;
        if (r12 == null) goto L21;
        String r13 = r12.c();
    L23:
        if (o0.d(r13) == false) goto L31;
        qz8.l r14 = this.h;
        if (r14 == null) goto L27;
        String r15 = r14.d();
    L29:
        if (o0.d(r15) == false) goto L31;
        r6.invoke(this.h);
        return;
    L27:
        r15 = null;
    L31:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommerceInviteFriendsFragment$getGroupInvitationInfo$1(r1, this, r6, null), 3, null);
        return;
    L21:
        r13 = null;
        goto L23
    }

    public static final void X90(final CommerceInviteFriendsFragment r9, qz8.d r10, qz8.d r11, boolean r12) {
        r9.getClass();
        if (r12 == false) goto L5;
        qz8.d r0 = r10;
    L6:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("loadCampaignInfo campaignKey=");
        r2.append((String) r9.g.getValue());
        r2.append(" isFromLocal=");
        r2.append(r12);
        r2.append(" campaignInfo=");
        if (r0 == null) goto L13;
        qz8.b r4 = r0.a();
        if (r4 == null) goto L13;
        List<qz8.o> r5 = r4.g();
        if (r5 == null) goto L13;
        Integer r6 = Integer.valueOf(r5.size());
    L14:
        r2.append(r6);
        r1.i("CommerceInviteFriendsFragment", r2.toString());
        if (r0 == null) goto L17;
        qz8.b r3 = r0.a();
    L18:
        if (r3 != null) goto L21;
    L109:
        if (r0 == null) goto L115;
        qz8.b r7 = r0.a();
        if (r7 == null) goto L115;
        List<qz8.o> r8 = r7.g();
        if (r8 == null) goto L115;
        List r13 = CollectionsKt.filterNotNull(r8);
    L116:
        if (r13 == null) goto L135;
        ((CommerceInviteInfoAdapter) r9.f.getValue()).submitList(r13);
        int r14 = Math.min(r13.size() * i5.m0(), ((Number) i5.I1.getValue()).intValue());
        LarusFragmentCommerceInviteFriendsBinding r15 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r15 == null) goto L122;
        RecyclerView r16 = r15.k;
        if (r16 == null) goto L122;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L123:
        if (r17 == null) goto L125;
        r17.height = r14;
    L125:
        LarusFragmentCommerceInviteFriendsBinding r18 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r18 == null) goto L130;
        RecyclerView r19 = r18.k;
        if (r19 == null) goto L130;
        r19.setLayoutParams(r17);
    L130:
        LarusFragmentCommerceInviteFriendsBinding r20 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r20 == null) goto L135;
        RecyclerView r21 = r20.k;
        if (r21 == null) goto L135;
        r21.post(new y(r9));
    L122:
        r17 = null;
    L135:
        View r22 = r9.getView();
        if (r22 == null) goto L138;
        r22.post(new b(r9));
    L138:
        if (r10 != null) goto L172;
        if (r11 != null) goto L172;
        if (r12 == true) goto L157;
        LarusFragmentCommerceInviteFriendsBinding r110 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r110 == null) goto L147;
        LinearLayout r111 = r110.j;
        if (r111 == null) goto L147;
        e1.d(r111, new e0(r9));
    L147:
        LarusFragmentCommerceInviteFriendsBinding r112 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r112 == null) goto L152;
        LinearLayout r113 = r112.h;
        if (r113 == null) goto L152;
        e1.q(r113);
    L152:
        LarusFragmentCommerceInviteFriendsBinding r23 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r23 == null) goto L188;
        LinearLayout r24 = r23.j;
        if (r24 == null) goto L189;
        e1.x(r24);
        return;
    L189:
        return;
    L188:
        return;
    L157:
        LarusFragmentCommerceInviteFriendsBinding r114 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r114 == null) goto L162;
        LinearLayout r115 = r114.j;
        if (r115 == null) goto L162;
        r115.setOnClickListener(null);
    L162:
        LarusFragmentCommerceInviteFriendsBinding r116 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r116 == null) goto L167;
        LinearLayout r117 = r116.h;
        if (r117 == null) goto L167;
        e1.q(r117);
    L167:
        LarusFragmentCommerceInviteFriendsBinding r25 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r25 == null) goto L191;
        LinearLayout r26 = r25.j;
        if (r26 == null) goto L192;
        e1.o(r26);
        return;
    L192:
        return;
    L191:
        return;
    L172:
        LarusFragmentCommerceInviteFriendsBinding r118 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r118 == null) goto L177;
        LinearLayout r119 = r118.j;
        if (r119 == null) goto L177;
        r119.setOnClickListener(null);
    L177:
        LarusFragmentCommerceInviteFriendsBinding r120 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r120 == null) goto L182;
        LinearLayout r121 = r120.h;
        if (r121 == null) goto L182;
        e1.x(r121);
    L182:
        LarusFragmentCommerceInviteFriendsBinding r27 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r27 == null) goto L194;
        LinearLayout r28 = r27.j;
        if (r28 == null) goto L195;
        e1.o(r28);
        return;
    L195:
        return;
    L194:
        return;
    L115:
        r13 = null;
        goto L116
    L21:
        if (e2.a.isPad() == false) goto L23;
        String r29 = null;
    L24:
        if (r29 == null) goto L30;
        LarusFragmentCommerceInviteFriendsBinding r30 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r30 == null) goto L30;
        SimpleDraweeView r31 = r30.f;
        if (r31 == null) goto L30;
        ImageLoaderKt.u(r31, r29, "commerce_invite_friends_bg");
    L30:
        LarusFragmentCommerceInviteFriendsBinding r32 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        String r33 = "";
        if (r32 == null) goto L39;
        TextView r34 = r32.o;
        if (r34 == null) goto L39;
        String r35 = r3.h();
        if (r35 != null) goto L38;
        r35 = "";
    L38:
        r34.setText(r35);
    L39:
        LarusFragmentCommerceInviteFriendsBinding r36 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r36 == null) goto L48;
        TextView r37 = r36.p;
        if (r37 == null) goto L48;
        String r38 = r3.i();
        if (r38 != null) goto L47;
        r38 = "";
    L47:
        r37.setText(r38);
    L48:
        String r39 = r3.e();
        if (r39 != null) goto L51;
        r39 = "";
    L51:
        String r40 = r3.d();
        if (r40 != null) goto L54;
        r40 = "";
    L54:
        boolean r41 = true;
        if (r40.length() <= 0) goto L57;
        boolean r42 = true;
    L58:
        if (r42 == false) goto L60;
        String r43 = r39.concat(r40);
    L62:
        if (r40.length() > 0) goto L65;
        r41 = false;
    L65:
        if (r41 == true) goto L67;
    L78:
        LarusFragmentCommerceInviteFriendsBinding r44 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r44 == null) goto L83;
        TextView r45 = r44.m;
        if (r45 == null) goto L83;
        r45.setText(r43);
    L83:
        LarusFragmentCommerceInviteFriendsBinding r46 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r46 == null) goto L92;
        TextView r47 = r46.n;
        if (r47 == null) goto L92;
        String r48 = r3.f();
        if (r48 != null) goto L91;
        r48 = "";
    L91:
        r47.setText(r48);
    L92:
        LarusFragmentCommerceInviteFriendsBinding r49 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r49 == null) goto L101;
        TextView r50 = r49.q;
        if (r50 == null) goto L101;
        String r51 = r3.j();
        if (r51 != null) goto L100;
        r51 = "";
    L100:
        r50.setText(r51);
    L101:
        LarusFragmentCommerceInviteFriendsBinding r52 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r52 == null) goto L109;
        TextView r53 = r52.l;
        if (r53 == null) goto L109;
        String r54 = r3.b();
        if (r54 == null) goto L108;
        r33 = r54;
    L108:
        r53.setText(r33);
        goto L109
    L67:
        if (r3.c() == null) goto L78;
        int r55 = r39.length();
        int r56 = r43.length();
        String r57 = r3.c();
        SpannableString r58 = new SpannableString(r43);
        r58.setSpan(new k0(r57, r9), r55, r56, 33);
        LarusFragmentCommerceInviteFriendsBinding r59 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r59 == null) goto L73;
        TextView r60 = r59.m;
        if (r60 == null) goto L73;
        r60.setText(r58);
    L73:
        LarusFragmentCommerceInviteFriendsBinding r61 = (LarusFragmentCommerceInviteFriendsBinding) r9.d;
        if (r61 == null) goto L83;
        TextView r62 = r61.m;
        if (r62 == null) goto L83;
        r62.setMovementMethod(LinkMovementMethod.getInstance());
        goto L83
    L60:
        r43 = r39;
        goto L62
    L57:
        r42 = false;
        goto L58
    L23:
        r29 = r3.a();
        goto L24
    L17:
        r3 = null;
    L13:
        r6 = null;
        goto L14
    L5:
        r0 = r11;
        goto L6
    }
}
