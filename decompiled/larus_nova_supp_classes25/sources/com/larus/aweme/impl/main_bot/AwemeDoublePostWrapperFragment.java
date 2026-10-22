package com.larus.aweme.impl.main_bot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.aweme.impl.databinding.LarusAwemeDoublePostWrapperFragmentBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.IAwemeDoublePostService;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.common.apphost.AppHost;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f*\u0001\u0016\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020!H\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020%H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010)\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020!H\u0002J\u0018\u0010,\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0018\u0010.\u001a\u00020!2\u0006\u0010)\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0006H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u00061"}, d2 = {"Lcom/larus/aweme/impl/main_bot/AwemeDoublePostWrapperFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/chat/multi_tab/IChatMultiTabChildFragment;", "<init>", "()V", "autoRefreshInterval", "", "getAutoRefreshInterval", "()I", "autoRefreshInterval$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/aweme/impl/databinding/LarusAwemeDoublePostWrapperFragmentBinding;", "fragment", "Lcom/larus/bmhome/video/IAwemeDoublePostFragment;", "pageSelected", "", "isLandingTab", "visibleTimestamp", "", "lastLeavePageTimestamp", "appBackGroundListener", "com/larus/aweme/impl/main_bot/AwemeDoublePostWrapperFragment$appBackGroundListener$1", "Lcom/larus/aweme/impl/main_bot/AwemeDoublePostWrapperFragment$appBackGroundListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "addFragment", "enterMethod", "", "onDestroy", "enterPage", "leavePage", "leaveMethod", "reportLeavePage", "tryAutoRefresh", "onChatTabSelected", "position", "onChatTabUnselected", "onChatTabReselected", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AwemeDoublePostWrapperFragment extends Fragment implements ci8.c {
    public static final /* synthetic */ int l = 0;
    public final Lazy d;
    public LarusAwemeDoublePostWrapperFragmentBinding e;
    public com.larus.bmhome.video.c f;
    public boolean g;
    public boolean h;
    public long i;
    public long j;
    public final b k;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ AwemeDoublePostWrapperFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            AwemeDoublePostWrapperFragment r0 = this.a;
            if (r0.g == false) goto L5;
            r0.T90("switch_background");
            this.a.j = System.currentTimeMillis();
        L5:
            FLogger.a.i("AwemeDoublePostWrapperFragment", "onAppBackground: pageSelected(" + this.a.g + ')');
        }

        public final void onAppForeground() {
            AwemeDoublePostWrapperFragment r0 = this.a;
            if (r0.g == false) goto L5;
            r0.i = System.currentTimeMillis();
            this.a.U90();
        L5:
            FLogger.a.i("AwemeDoublePostWrapperFragment", "onAppForeground: pageSelected(" + this.a.g + ')');
        }

        public b(AwemeDoublePostWrapperFragment r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.aweme.impl.main_bot.AwemeDoublePostWrapperFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.aweme.impl.main_bot.AwemeDoublePostWrapperFragment$onViewCreated$2", f = "AwemeDoublePostWrapperFragment.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RecommendVideoApi r5 = RecommendVideoApi.a;
            this.label = 1;
            if (RecommendVideoApi.a.c(SortScene.PreFetch, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    @Override // ci8.c
    public final void SL() {
        com.larus.bmhome.video.c r0 = this.f;
        if (r0 == null) goto L6;
        r0.Ko(SortRequestType.UserClickTabRefresh);
        return;
    }

    public final void U90() {
        if (((Number) this.d.getValue()).intValue() > 0) goto L5;
        return;
    L5:
        if (this.j <= 0) goto L13;
        long r0 = System.currentTimeMillis();
        FLogger.a.i("AwemeDoublePostWrapperFragment", "tryAutoRefresh: currentTimestamp = " + r0 + ", lastLeavePageTimestamp = " + this.j + ", interval = " + ((Number) this.d.getValue()).intValue());
        if ((r0 - this.j) < (((long) ((Number) this.d.getValue()).intValue()) * ((long) 1000))) goto L14;
        com.larus.bmhome.video.c r1 = this.f;
        if (r1 == null) goto L15;
        r1.Ko(SortRequestType.AutoRefresh);
        return;
    L15:
        return;
    L14:
        return;
    }

    public AwemeDoublePostWrapperFragment() {
        this.d = LazyKt.lazy(new com.larus.aweme.impl.main_bot.a());
        this.k = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        zW("system_back_button");
        if (this.f == null) goto L5;
        RecommendVideoApi r0 = RecommendVideoApi.a;
        RecommendVideoApi.a();
    L5:
        AppHost.a.a().c(this.k);
    }

    @Override // ci8.c
    public final void LY(String r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveMethod");
        zW(r2);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.aweme.impl.main_bot.b, java.lang.Object] */
    public final void S90(final String r7) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (isDetached() == true) goto L27;
        FLogger.a.i("AwemeDoublePostWrapperFragment", "addFragment");
        IAwemeDoublePostService r0 = (IAwemeDoublePostService) ServiceManager.get().getService(IAwemeDoublePostService.class);
        if (r0 == null) goto L10;
        final AwemeDoublePostFragment r1 = r0.a();
    L11:
        this.f = r1;
        if ((r1 instanceof Fragment) == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L25;
        r1.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("argument_multi_tab_child_is_landing_tab", Boolean.valueOf(this.h))}));
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L20;
        r2.replace(2131373275, r1);
    L20:
        r2.commit();
        if (r7 == null) goto L26;
        FragmentManager r3 = getChildFragmentManager();
        ?? r4 = new com.larus.aweme.impl.main_bot.b(r1, r7);
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r4, "block");
        r3.registerFragmentLifecycleCallbacks(new FragmentExtKt.onViewCreatedCallBack.callBack.1(r1, r4, r3), false);
        return;
    L26:
        return;
    L25:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final void T90(String r9) {
        if (this.i > 0) goto L5;
        return;
    L5:
        IAwemeDoublePostService r0 = (IAwemeDoublePostService) ServiceManager.get().getService(IAwemeDoublePostService.class);
        if (r0 == null) goto L14;
        r0.b();
        com.larus.bmhome.double_post.utils.e r1 = com.larus.bmhome.double_post.utils.e.a;
        long r4 = System.currentTimeMillis() - this.i;
        com.larus.bmhome.video.c r2 = this.f;
        if (r2 == null) goto L12;
        Content r3 = r2.iy();
        if (r3 == null) goto L12;
        Integer r5 = r3.getImprIndex();
    L13:
        r1.b(r9, r4, r5);
    L12:
        r5 = null;
    L14:
        this.i = 0;
    }

    @Override // ci8.c
    public final void jv(String r4) {
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        this.g = true;
        FLogger.a.i("AwemeDoublePostWrapperFragment", "enterPage: enterMethod = ".concat(r4));
        this.i = System.currentTimeMillis();
        com.larus.bmhome.video.c r0 = this.f;
        if (r0 != null) goto L5;
        S90(r4);
    L6:
        U90();
        return;
    L5:
        r0.vq(r4);
        goto L6
    }

    public final void zW(String r4) {
        this.g = false;
        FLogger.a.i("AwemeDoublePostWrapperFragment", "leavePage: leaveMethod = ".concat(r4));
        if (Intrinsics.areEqual(r4, "click_back_button") == false) goto L6;
        r4 = "click_close";
    L8:
        com.larus.bmhome.video.c r0 = this.f;
        if (r0 == null) goto L11;
        r0.zW(r4);
    L11:
        T90(r4);
        this.j = System.currentTimeMillis();
        return;
    L6:
        if (Intrinsics.areEqual(r4, "system_back_button") == false) goto L8;
        r4 = "slide_back";
        goto L8
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusAwemeDoublePostWrapperFragmentBinding r9 = this.e;
        if (r9 == null) goto L13;
        FragmentActivity r10 = getActivity();
        int r0 = 0;
        if (r10 == null) goto L7;
        int r11 = u.c(r10);
    L8:
        int r12 = r11 + i5.k0();
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L11;
        r0 = u.b(r1);
    L11:
        FrameLayout r13 = r9.a;
        r13.setPaddingRelative(r13.getPaddingStart(), r12, r13.getPaddingEnd(), r0);
        goto L13
    L7:
        r11 = 0;
    L13:
        if (this.h == false) goto L15;
        S90(null);
    L16:
        AppHost.a.a().j(this.k);
        return;
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(null), 3, null);
        goto L16
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        boolean r7 = r6.getBoolean("argument_multi_tab_child_is_landing_tab", false);
    L6:
        this.h = r7;
        View r8 = r3.inflate(2131561817, r4, false);
        if (r8 == null) goto L11;
        FrameLayout r9 = (FrameLayout) r8;
        this.e = new LarusAwemeDoublePostWrapperFragmentBinding(r9, r9);
        return g.a(r9);
    L11:
        throw new NullPointerException("rootView");
    L5:
        r7 = false;
        goto L6
    }
}
