package com.larus.profile.impl.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.list.ListAdapter;
import com.larus.bmhome.auth.ImmersConfig;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.profile.impl.databinding.LarusPageProfileInfoSkeletonBinding;
import com.larus.profile.impl.databinding.LarusProfileInfoViewBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import ic8.l0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 e2\u00020\u0001:\u0002efB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010*\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0014\u0010-\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0014\u0010/\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0010\u00100\u001a\u00020\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u00101\u001a\u0004\u0018\u000102J\u000f\u00103\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J \u0010:\u001a\u0004\u0018\u00010\u001d2\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020,H\u0082@¢\u0006\u0002\u0010=J0\u0010>\u001a\u00020\"2\u0006\u0010;\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001dH\u0002J@\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020,2\u0006\u0010;\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010F\u001a\u00020\"*\u00020G2\u0006\u0010H\u001a\u00020,2\u0006\u0010D\u001a\u00020\u0003H\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020,H\u0002J\f\u0010K\u001a\u00020,*\u000209H\u0002J\u0014\u0010L\u001a\u00020\"*\u00020G2\u0006\u0010J\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020\"H\u0002J\u0006\u0010N\u001a\u00020,J\r\u0010O\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u00104J\u001f\u0010P\u001a\u0004\u0018\u00010\"2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020,¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020\"2\u0006\u0010Q\u001a\u00020VJ\u0006\u0010W\u001a\u00020\"J\u0014\u0010X\u001a\u00020\"2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZJ\r\u0010\\\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u00104J\u000f\u0010]\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00104J\u000e\u0010^\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u001dJ\u000e\u0010`\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u001dJ\u000e\u0010a\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010d\u001a\u00020\"2\u0006\u0010b\u001a\u00020cR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larus/profile/impl/view/ProfileInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "parentFragment", "Landroidx/fragment/app/Fragment;", "getParentFragment", "()Landroidx/fragment/app/Fragment;", "parentFragment$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/profile/impl/databinding/LarusProfileInfoViewBinding;", "adapter", "Lcom/ixigua/lib/list/ListAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "tracePageName", "", "mobPageName", "enterFrom", "navigateToEditProfile", "Lkotlin/Function0;", "", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setRecommendFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "navigateToQrCode", "init", "initViewLifecycle", "", "openEditProfile", "action", "setQrCodeAction", "bindLoadMoreManager", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initRecyclerView", "()Lkotlin/Unit;", "reportItemShow", "index", "getChatType", "data", "Lcom/larus/profile/api/bean/ProfileBot;", "checkAndCreateConversation", "profileBot", "isDeleted", "(Lcom/larus/profile/api/bean/ProfileBot;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChatFragment", "existConv", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "clickEnterFrom", "openProfileBotChat", "routeContext", "useNoAnim", "putProfileBotRouteModeParams", "Landroid/os/Bundle;", "routeBelowAICreationApplet", "getProfileBotChatRoute", "openImmersiveChat", "shouldOpenImmersiveChat", "putProfileBotImmersiveParamsIfNeeded", "checkTitleVisibility", "needTitleVisible", "onLoading", "onSuccess", "response", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "isFirstPageChanged", "(Lcom/larus/profile/api/bean/ProfileOverviewResponse;Z)Lkotlin/Unit;", "onLoadMoreSuccess", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "loadMoreFail", "replaceItems", "list", "", "", "onFail", "dismissFailView", "setMobPageName", "pageName", "setTracePageName", "setEnterFrom", "callback", "Lcom/larus/profile/impl/view/ProfileInfoView$ViewUpdateCallback;", "setViewUpdateCallback", "Companion", "ViewUpdateCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileInfoView extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public LifecycleOwner a;
    public final Lazy b;
    public LarusProfileInfoViewBinding c;
    public ListAdapter d;
    public LinearLayoutManager e;
    public LoadMoreManager f;
    public String g;
    public String h;
    public String i;
    public Function0<Unit> j;
    public RecommendFrom k;
    public Function0<Unit> l;
    public b m;

    public static final class a {
    }

    public interface b {
        Unit a(fs9.n r1);

        void b(boolean r1);

        void c();

        Object d(fs9.n r1, Continuation<? super String> r2);

        void e(r38.b r1);

        Unit f(String r1, String r2);

        Unit g(fs9.n r1);

        void h();
    }

    static {
    }

    private final Fragment getParentFragment() {
        return (Fragment) this.b.getValue();
    }

    public final void V5() {
        LarusProfileInfoViewBinding r0 = this.c;
        if (r0 == null) goto L21;
        ListAdapter r1 = this.d;
        if (r1 == null) goto L13;
        com.ixigua.lib.list.e r2 = r1.b;
        if (r2 == null) goto L13;
        List r3 = r2.getItems();
        if (r3 == null) goto L13;
        boolean r4 = true;
        if ((!r3.isEmpty()) != true) goto L13;
    L14:
        if (r4 == true) goto L19;
        r0.d.a.setVisibility(8);
        r0.b.setVisibility(0);
        View r5 = r0.a.findViewById(2131383235);
        if (r5 == null) goto L19;
        e1.d(r5, new w(this));
    L19:
        Unit r6 = Unit.INSTANCE;
        return;
    L13:
        r4 = false;
        goto L14
    }

    public final RecyclerView getRecyclerView() {
        LarusProfileInfoViewBinding r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final RecommendFrom getRecommendFrom() {
        return this.k;
    }

    public ProfileInfoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = LazyKt.lazy(new r(this));
        this.g = "";
        this.h = "other";
        this.i = "other";
        U5(r2, null);
    }

    public static final /* synthetic */ Fragment S5(ProfileInfoView r0) {
        return r0.getParentFragment();
    }

    public final String T5(fs9.n r2) {
        int r0 = r2.h();
        if (r0 != 0) goto L5;
        BotCreatorInfo r3 = r2.k();
        if (r3 == null) goto L14;
        String r4 = r3.getId();
    L16:
        if (Intrinsics.areEqual(r4, AccountService.a.getUserId()) == false) goto L18;
        return "self_created";
    L18:
        return "others_created";
    L14:
        r4 = null;
        goto L16
    L5:
        if (r0 != 1) goto L7;
        return "default";
    L7:
        if (r0 == 4) goto L9;
        return "other_default";
    L9:
        return "notice";
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        this.i = r2;
    }

    public final void setMobPageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.h = r2;
    }

    public final void setQrCodeAction(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.l = r2;
    }

    public final void setRecommendFrom(RecommendFrom r1) {
        this.k = r1;
    }

    public final void setTracePageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.g = r2;
    }

    public final void setViewUpdateCallback(b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.m = r2;
    }

    public ProfileInfoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = LazyKt.lazy(new r(this));
        this.g = "";
        this.h = "other";
        this.i = "other";
        U5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(Context r12, AttributeSet r13) {
        ConstraintLayout r14 = LayoutInflater.from(r12).inflate(2131563093, this, false);
        addView(r14);
        int r15 = 2131383233;
        ViewStub r1 = (ViewStub) ViewBindings.findChildViewById(r14, 2131383233);
        if (r1 == null) goto L25;
        r15 = 2131383241;
        RecyclerView r4 = ViewBindings.findChildViewById(r14, 2131383241);
        if (r4 == null) goto L25;
        r15 = 2131383242;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r14, 2131383242);
        if (r3 == null) goto L25;
        int r16 = 2131383243;
        View r7 = ViewBindings.findChildViewById(r3, 2131383243);
        if (r7 == null) goto L23;
        r16 = 2131383244;
        View r8 = ViewBindings.findChildViewById(r3, 2131383244);
        if (r8 == null) goto L23;
        r16 = 2131383245;
        View r9 = ViewBindings.findChildViewById(r3, 2131383245);
        if (r9 == null) goto L23;
        r16 = 2131383246;
        View r10 = ViewBindings.findChildViewById(r3, 2131383246);
        if (r10 == null) goto L23;
        this.c = new LarusProfileInfoViewBinding(r14, r1, r4, new LarusPageProfileInfoSkeletonBinding(r3, r7, r8, r9, r10));
        Context r17 = getContext();
        if (r17 == null) goto L20;
        LinearLayoutManager r18 = new LinearLayoutManager(r17);
        this.e = r18;
        r4.setLayoutManager(r18);
        ListAdapter r19 = new ListAdapter(new ay7.b(r17), CollectionsKt.listOf(new ay7.a[]{new x(), new com.larus.profile.impl.b(), new g(), new f()}));
        r19.c = new ProfileInfoView$initRecyclerView$1$1$1(this);
        this.d = r19;
        r4.addOnScrollListener(new ProfileInfoView$initRecyclerView$1$2(this));
        r4.setItemAnimator(null);
        y6.f(r4, new s(this), new t(), 0.1f, new u(this), 49);
    L20:
        Unit r110 = Unit.INSTANCE;
        post(new v(this));
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r16)));
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public ProfileInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new r(this));
        this.g = "";
        this.h = "other";
        this.i = "other";
        U5(r2, r3);
    }

    public final void Z5(Bundle r4, boolean r5, Context r6) {
        if (r5 == false) goto L10;
        r4.putBoolean("disable_activity_transition", true);
        if ((r6 instanceof j4) == false) goto L9;
        r4.putBoolean("route_native_below_ai_creation_applet", true);
        if (((j4) r6).B0() == false) goto L12;
        r4.putString("is_side_bar", "1");
        return;
    L12:
        return;
    L9:
        r4.putString("ignore_side_bar", "1");
        return;
    L10:
        r4.putString("ignore_side_bar", "1");
    }

    public static final Object R5(ProfileInfoView r4, fs9.n r5, boolean r6, Continuation r7) {
        r4.getClass();
        if ((r7 instanceof ProfileInfoView$checkAndCreateConversation$1) == false) goto L7;
        ProfileInfoView$checkAndCreateConversation$1 r0 = (ProfileInfoView$checkAndCreateConversation$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L29:
        return (String) r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (o0.d(r5.i()) == true) goto L17;
    L20:
        b r9 = r4.m;
        if (r9 == null) goto L26;
        r0.label = 1;
        r8 = r9.d(r5, r0);
        if (r8 != r2) goto L29;
        return r2;
    L26:
        String r10 = null;
    L28:
        return r10;
    L17:
        if (Intrinsics.areEqual(r5.i(), "0") == true) goto L20;
        if (r6 == true) goto L20;
        r10 = r5.i();
    L7:
        r0 = new ProfileInfoView$checkAndCreateConversation$1(r4, r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5(Context r23, boolean r24, fs9.n r25, wc9.e r26, String r27, String r28) {
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L55
        String r7 = r25.e();     // Catch: Throwable -> L55
        if (r26 == null) goto L6;
        ConversationPage r3 = r26.g;     // Catch: Throwable -> L55
    L7:
        if (r24 == false) goto L9;
        int r8 = 2130772399;
    L10:
        if (r3 == null) goto L12;
        List r10 = r3.getPageList();     // Catch: Throwable -> L55
    L15:
        if (l0.b(r10) == false) goto L21;
        int r11 = f5.a;     // Catch: Throwable -> L55
        if (r3 == null) goto L19;
        Integer r12 = r3.getDefaultStatus();     // Catch: Throwable -> L55
    L20:
        int r13 = f5.a(r12);     // Catch: Throwable -> L55
        com.bytedance.router.i r14 = SmartRouter.buildRoute(r23, "//flow/chat_page_double_tab");     // Catch: Throwable -> L55
        int r19 = r8;
        Bundle r4 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", this.h), TuplesKt.to("argConversationId", r27), TuplesKt.to("argClickEnterFrom", r28), TuplesKt.to("argBotId", r7), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("is_create_sub_conversation", Boolean.FALSE), TuplesKt.to("default_tab", Integer.valueOf(r13)), TuplesKt.to("conversation_page", r3)});     // Catch: Throwable -> L55
        Z5(r4, r24, r23);     // Catch: Throwable -> L55
        by7.h.j(r4, this);     // Catch: Throwable -> L55
        r14.c.putExtras(r4);     // Catch: Throwable -> L55
        r14.d = r19;     // Catch: Throwable -> L55
        r14.e = 2130772399;     // Catch: Throwable -> L55
        r14.d();     // Catch: Throwable -> L55
    L53:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
        return;
    L19:
        r12 = null;
        goto L20
    L21:
        if (r24 == true) goto L23;
    L34:
        boolean r15 = false;
    L35:
        if (r15 == false) goto L37;
        String r5 = "//flow/chat_page_immers";
    L38:
        com.bytedance.router.i r9 = SmartRouter.buildRoute(r23, r5);     // Catch: Throwable -> L55
        int r110 = r8;
        Bundle r16 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("landing_channel", ChatLandingChannel.PROFILE_INFO_VIEW.getChannel()), TuplesKt.to("argPreviousPage", this.h), TuplesKt.to("argClickEnterFrom", r28), TuplesKt.to("argCvsBgImgUrl", r25.c()), TuplesKt.to("argCvsBgImgColor", r25.a()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r25.b())), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("argConversationId", r27), TuplesKt.to("argBotId", r7), TuplesKt.to("navigate_up_from", this.i)});     // Catch: Throwable -> L55
        Z5(r16, r24, r23);     // Catch: Throwable -> L55
        if (r15 == true) goto L42;
    L52:
        by7.h.j(r16, this);     // Catch: Throwable -> L55
        r9.c.putExtras(r16);     // Catch: Throwable -> L55
        r9.d = r110;     // Catch: Throwable -> L55
        r9.e = 2130772399;     // Catch: Throwable -> L55
        r9.d();     // Catch: Throwable -> L55
        goto L53
    L42:
        if (r16.getBoolean("is_single_mode", false) == true) goto L50;
        LaunchInfo r17 = LaunchCacheDelegate.b.c();     // Catch: Throwable -> L55
        if (r17 == null) goto L46;
        ImmersConfig r18 = r17.L0();     // Catch: Throwable -> L55
    L47:
        if (r18 == null) goto L50;
        boolean r111 = false;
    L51:
        r16.putBoolean("is_single_mode", r111);     // Catch: Throwable -> L55
        goto L52
    L46:
        r18 = null;
    L50:
        r111 = true;
        goto L51
    L37:
        r5 = "//flow/chat_page";
        goto L38
    L23:
        if (z2.a.chatImmerseEnable() == true) goto L25;
    L31:
        boolean r20 = false;
    L32:
        if (r20 == false) goto L34;
        r15 = true;
        goto L35
    L25:
        if (r25.b() == false) goto L31;
        if (o0.d(r25.c()) == false) goto L31;
        if (o0.d(r25.a()) == false) goto L31;
        r20 = true;
        goto L32
    L12:
        r10 = null;
        goto L15
    L9:
        r8 = 2130772401;
        goto L10
    L6:
        r3 = r25.j();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
