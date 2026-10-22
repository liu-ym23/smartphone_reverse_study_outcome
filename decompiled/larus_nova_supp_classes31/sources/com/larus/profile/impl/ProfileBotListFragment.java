package com.larus.profile.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ImmersConfig;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.profile.impl.databinding.LarusFragmentMineBotListBinding;
import com.larus.profile.impl.databinding.LarusItemProfileBotListEmptyBinding;
import com.larus.profile.impl.databinding.LarusItemProfileUserBannedBinding;
import com.larus.profile.impl.mine.MineTabViewModel;
import com.larus.profile.impl.viewmodel.ProfileInfoViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.tencent.open.log.TraceLevel;
import fs9.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.s6;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001(\u0018\u0000 g2\u00020\u0001:\u0001gB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00106\u001a\u00020\u0019H\u0002J\u001a\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00109\u001a\u00020\u0019H\u0016J\b\u0010:\u001a\u00020\u0019H\u0002J\b\u0010;\u001a\u00020\u0019H\u0002J\b\u0010<\u001a\u00020\u0019H\u0002J\u0014\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0>H\u0002J\u0014\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0?0>H\u0002J\u0012\u0010C\u001a\u00020\u00192\b\u0010D\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010E\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010F\u001a\u00020\u0019H\u0016J \u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010KJ0\u0010L\u001a\u00020\u00192\u0006\u0010H\u001a\u00020I2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\tH\u0002J@\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00102\u0006\u0010H\u001a\u00020I2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010U\u001a\u00020\u0019*\u00020,2\u0006\u0010V\u001a\u00020\u00102\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u0010H\u0002J\f\u0010Y\u001a\u00020\u0010*\u00020IH\u0002J\u0014\u0010Z\u001a\u00020\u0019*\u00020,2\u0006\u0010X\u001a\u00020\u0010H\u0002J\b\u0010[\u001a\u00020\u0010H\u0002J\u0010\u0010\\\u001a\u00020\u00192\u0006\u0010]\u001a\u00020IH\u0002J\u0010\u0010^\u001a\u00020\u00192\u0006\u0010_\u001a\u00020`H\u0002J\n\u0010a\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020IH\u0002J\b\u0010d\u001a\u00020\u0010H\u0002J\n\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006h"}, d2 = {"Lcom/larus/profile/impl/ProfileBotListFragment;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusFragmentMineBotListBinding;", "adapter", "Lcom/larus/profile/impl/ProfileBotListAdapter;", "mobPageName", "", "enterFrom", "tracePageName", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "tag", "isSelf", "", "mineBotViewModel", "Lkotlin/Lazy;", "Lcom/larus/profile/impl/mine/MineTabViewModel;", "otherBotViewModel", "Lcom/larus/profile/impl/viewmodel/ProfileInfoViewModel;", "hasReportEnterPage", "checkItemShow", "Lkotlin/Function0;", "", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "recommendFrom$delegate", "Lkotlin/Lazy;", "observeBotChangeJob", "Lkotlinx/coroutines/Job;", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "botUpdateListener", "com/larus/profile/impl/ProfileBotListFragment$botUpdateListener$1", "Lcom/larus/profile/impl/ProfileBotListFragment$botUpdateListener$1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initLoadMoreManager", "onViewCreated", "view", "onDestroyView", "initGeneralObservers", "initProfileBotObserver", "showUserBannedStatus", "getUserInfoState", "Landroidx/lifecycle/LiveData;", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "getLoadMoreState", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "onEnterMineTab", "previousPage", "initRecyclerView", "onLeaveMineTab", "checkAndCreateConversation", "profileBot", "Lcom/larus/profile/api/bean/ProfileBot;", "isDeleted", "(Lcom/larus/profile/api/bean/ProfileBot;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChatFragment", "existConv", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "clickEnterFrom", "openProfileBotChat", "routeContext", "Landroid/content/Context;", "useNoAnim", "putProfileBotRouteModeParams", "routeBelowAICreationApplet", "getProfileBotChatRoute", "openImmersiveChat", "shouldOpenImmersiveChat", "putProfileBotImmersiveParamsIfNeeded", "shouldRouteNativeBelowHostAfterOpenBot", "observeBotChange", "bot", "reportItemShow", "index", "", "getListAdapter", "getChatType", "data", "needRefreshBotList", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileBotListFragment extends ProfileInfoBaseFragment {
    public static final /* synthetic */ int y = 0;
    public LarusFragmentMineBotListBinding j;
    public ProfileBotListAdapter k;
    public String l;
    public String m;
    public String n;
    public LoadMoreManager o;
    public final String p;
    public boolean q;
    public final Lazy<MineTabViewModel> r;
    public final Lazy<ProfileInfoViewModel> s;
    public s6 t;
    public final Lazy u;
    public Job v;
    public final Lazy w;
    public final ProfileBotListFragment$botUpdateListener$1 x;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final void T90() {
        LarusFragmentMineBotListBinding r0 = this.j;
        if (r0 == null) goto L8;
        RecyclerView r1 = r0.c;
        if (r1 == null) goto L9;
        y6.i(r1);
        return;
    L9:
        return;
    }

    public final void ea0() {
        LarusFragmentMineBotListBinding r0 = this.j;
        if (r0 == null) goto L11;
        r0.d.a.setVisibility(0);
        r0.b.a.setVisibility(8);
        r0.c.setVisibility(8);
        com.larus.voice_setting.voice.base.a r1 = getParentFragment();
        if ((r1 instanceof com.larus.voice_setting.voice.base.a) == false) goto L7;
        com.larus.voice_setting.voice.base.a r2 = r1;
    L8:
        if (r2 == null) goto L12;
        r2.Ym(ProfileBotListFragment.class.getName(), true);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final RecyclerView getRecyclerView() {
        LarusFragmentMineBotListBinding r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final void onDestroyView() {
        com.larus.im.service.o r0 = (com.larus.im.service.o) this.w.getValue();
        ProfileBotListFragment$botUpdateListener$1 r1 = this.x;
        r0.unregisterBotChangeListener(r1.a, r1);
        Job r2 = this.v;
        if (r2 == null) goto L5;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L5:
        this.v = null;
        LarusFragmentMineBotListBinding r3 = this.j;
        if (r3 == null) goto L10;
        RecyclerView r4 = r3.c;
        if (r4 == null) goto L10;
        r4.setAdapter(null);
    L10:
        this.k = null;
        this.o = null;
        this.t = null;
        this.j = null;
        super.onDestroyView();
    }

    public ProfileBotListFragment() {
        this.l = "bot_list_profile";
        this.m = "bot_list_profile";
        this.n = "";
        this.p = "MineBotListFragment" + hashCode();
        this.q = true;
        this.r = FragmentViewModelLazyKt.createViewModelLazy$default(this, Reflection.getOrCreateKotlinClass(MineTabViewModel.class), new e(this), null, 4, null);
        this.s = FragmentViewModelLazyKt.createViewModelLazy$default(this, Reflection.getOrCreateKotlinClass(ProfileInfoViewModel.class), new k(this), null, 4, null);
        this.u = LazyKt.lazy(new l(this));
        this.w = LazyKt.lazy(new m());
        this.x = new ProfileBotListFragment$botUpdateListener$1(this);
    }

    public final ProfileBotListAdapter ba0() {
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        RecyclerView.Adapter r1 = r0.getAdapter();
    L7:
        if ((r1 instanceof ConcatAdapter) == false) goto L9;
        ConcatAdapter r2 = (ConcatAdapter) r1;
    L10:
        if (r2 == null) goto L20;
        List r3 = r2.getAdapters();
        if (r3 == null) goto L20;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L20;
        RecyclerView.Adapter r5 = (RecyclerView.Adapter) r4.next();
        if ((r5 instanceof ProfileBotListAdapter) == false) goto L15;
        return (ProfileBotListAdapter) r5;
    L20:
        return null;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final String tag() {
        return this.p;
    }

    public final void S90(String r57) {
        if (r57 != null) goto L4;
        String r0 = "";
    L6:
        if (com.larus.utils.o0.d(r0) == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r0, "unknown") == true) goto L12;
        tx9.a1.c(null, null, null, null, null, "self_bot_list", null, null, null, null, null, null, null, null, null, null, r0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048705, -1, 7);
        return;
    L12:
        return;
    L4:
        r0 = r57;
        goto L6
    }

    public final String aa0(fs9.n r2) {
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

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (isResumed() == false) goto L10;
        LarusFragmentMineBotListBinding r3 = this.j;
        if (r3 == null) goto L11;
        RecyclerView r4 = r3.c;
        if (r4 == null) goto L12;
        r4.post(new n(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.l = r4.getString("bot_mob_page_name", "bot_list_profile");
        this.m = r4.getString("bot_enter_from", "bot_list_profile");
        this.n = r4.getString("bot_trace_page", "");
        this.q = r4.getBoolean("bot_is_self", true);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.profile.impl.ProfileBotListFragment$initRecyclerView$1$1] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        LarusFragmentMineBotListBinding r11 = this.j;
        if (r11 == null) goto L5;
        com.larus.utils.e1.d(r11.b.b, new p(this));
    L5:
        Context r12 = getContext();
        if (r12 == null) goto L9;
        this.o = new LoadMoreManager(r12, new f(this), null);
    L9:
        LarusFragmentMineBotListBinding r13 = this.j;
        if (r13 == null) goto L18;
        r13.c.setLayoutManager(new LinearLayoutManager(getContext()));
        ProfileBotListAdapter r14 = new ProfileBotListAdapter(new ArrayList(), new ProfileBotListFragment$initRecyclerView$1$1(this));
        this.k = r14;
        r13.c.setAdapter(r14);
        r13.c.setItemViewCacheSize(20);
        ProfileBotListAdapter r15 = this.k;
        if (r15 == null) goto L16;
        LoadMoreManager r0 = this.o;
        if (r0 == null) goto L16;
        r0.d(r13.c, r15);
    L16:
        this.t = y6.f(r13.c, new q(this), new s(), 0.1f, new t(this), 49);
        X90();
    L18:
        if (this.q == false) goto L20;
        LiveData<com.larus.network.http.a<fs9.u>> r16 = ((MineTabViewModel) this.r.getValue()).getUserInfoState();
    L21:
        r16.observe(getViewLifecycleOwner(), new b(new i(this)));
        if (this.q == false) goto L24;
        LiveData<com.larus.network.http.a<r>> r17 = ((MineTabViewModel) this.r.getValue()).getLoadMoreState();
    L25:
        r17.observe(getViewLifecycleOwner(), new b(new j(this)));
        if (this.q == false) goto L28;
        ((MineTabViewModel) this.r.getValue()).getProfileBotsLive().observe(getViewLifecycleOwner(), new b(new g(this)));
        return;
    L28:
        final ProfileInfoViewModel r18 = (ProfileInfoViewModel) this.s.getValue();
        r18.getProfileBotsLive().observe(getViewLifecycleOwner(), new b(new h(this, r18)));
        return;
    L24:
        r17 = ((ProfileInfoViewModel) this.s.getValue()).getLoadMoreState();
        goto L25
    L20:
        r16 = ((ProfileInfoViewModel) this.s.getValue()).getUserInfoState();
        goto L21
    }

    public final void da0(Bundle r4, boolean r5, Context r6) {
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

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        FLogger.a.i(this.p, "[onCreateView]");
        ConstraintLayout r6 = r3.inflate(2131562405, r4, false);
        int r7 = 2131364361;
        View r8 = ViewBindings.findChildViewById(r6, 2131364361);
        if (r8 == null) goto L13;
        LarusItemProfileBotListEmptyBinding r9 = LarusItemProfileBotListEmptyBinding.a(r8);
        RecyclerView r0 = ViewBindings.findChildViewById(r6, 2131384070);
        if (r0 == null) goto L11;
        View r1 = ViewBindings.findChildViewById(r6, 2131392004);
        if (r1 == null) goto L10;
        ConstraintLayout r10 = r6;
        this.j = new LarusFragmentMineBotListBinding(r10, r9, r0, LarusItemProfileUserBannedBinding.a(r1));
        return r10;
    L10:
        r7 = 2131392004;
        goto L13
    L11:
        r7 = 2131384070;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public static final Object Z90(ProfileBotListFragment r5, fs9.n r6, boolean r7, Continuation r8) {
        r5.getClass();
        if ((r8 instanceof ProfileBotListFragment$checkAndCreateConversation$1) == false) goto L7;
        ProfileBotListFragment$checkAndCreateConversation$1 r0 = (ProfileBotListFragment$checkAndCreateConversation$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L32:
        String r10 = (String) r9;
    L34:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L27:
        r10 = (String) r9;
        goto L34
    L16:
        ResultKt.throwOnFailure(r9);
        if (com.larus.utils.o0.d(r6.i()) == false) goto L23;
        if (Intrinsics.areEqual(r6.i(), "0") == true) goto L23;
        if (r7 == true) goto L23;
        return r6.i();
    L23:
        if (r5.q == false) goto L29;
        MineTabViewModel r11 = (MineTabViewModel) r5.r.getValue();
        r0.label = 1;
        r9 = r11.createLocalConversation(r6, r0);
        if (r9 != r2) goto L27;
        return r2;
    L29:
        ProfileInfoViewModel r12 = (ProfileInfoViewModel) r5.s.getValue();
        r0.label = 2;
        r9 = r12.createLocalConversation(r6, r0);
        if (r9 != r2) goto L32;
        return r2;
    L7:
        r0 = new ProfileBotListFragment$checkAndCreateConversation$1(r5, r8);
        goto L8
    }

    public final void ca0(Context r25, boolean r26, fs9.n r27, wc9.e r28, String r29, String r30) {
        String r6 = r27.e();
        if (r28 == null) goto L5;
        ConversationPage r3 = r28.g;
    L6:
        if (r26 == false) goto L8;
        int r8 = 2130772399;
    L77:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L71
        if (r3 == null) goto L12;
        List r10 = r3.getPageList();     // Catch: Throwable -> L71
    L15:
        if (ic8.l0.b(r10) == false) goto L27;
        int r11 = f5.a;     // Catch: Throwable -> L71
        if (r3 == null) goto L19;
        Integer r12 = r3.getDefaultStatus();     // Catch: Throwable -> L71
    L20:
        int r13 = f5.a(r12);     // Catch: Throwable -> L71
        com.bytedance.router.i r14 = SmartRouter.buildRoute(r25, "//flow/chat_page_double_tab");     // Catch: Throwable -> L71
        int r21 = r8;
        Bundle r4 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("argPreviousPage", this.l), TuplesKt.to("argConversationId", r29), TuplesKt.to("argClickEnterFrom", r30), TuplesKt.to("is_create_sub_conversation", Boolean.FALSE), TuplesKt.to("default_tab", Integer.valueOf(r13 - 1)), TuplesKt.to("conversation_page", r3), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("argBotId", r6)});     // Catch: Throwable -> L71
        da0(r4, r26, r25);     // Catch: Throwable -> L71
        by7.e r0 = getParentFragment();     // Catch: Throwable -> L71
        if ((r0 instanceof by7.e) == false) goto L23;
        by7.e r1 = r0;     // Catch: Throwable -> L71
    L24:
        if (r1 == null) goto L26;
        by7.h.k(r4, r1);     // Catch: Throwable -> L71
    L26:
        r14.c.putExtras(r4);     // Catch: Throwable -> L71
        r14.d = r21;     // Catch: Throwable -> L71
        r14.e = 2130772399;     // Catch: Throwable -> L71
        r14.d();     // Catch: Throwable -> L71
    L65:
        Job r2 = this.v;     // Catch: Throwable -> L71
        if (r2 == null) goto L68;
        Job r5 = null;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L71
    L69:
        this.v = r5;     // Catch: Throwable -> L71
        com.larus.im.service.o r7 = (com.larus.im.service.o) this.w.getValue();     // Catch: Throwable -> L71
        ProfileBotListFragment$botUpdateListener$1 r15 = this.x;     // Catch: Throwable -> L71
        r7.unregisterBotChangeListener(r15.a, r15);     // Catch: Throwable -> L71
        this.v = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProfileBotListFragment$observeBotChange$1(r27, this, null), 3, null);     // Catch: Throwable -> L71
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L79;
        FLogger.a.e("ProfileBotListFragment", "open profile bot failed in AI creation applet", r17);
        return;
    L79:
        return;
    L68:
        r5 = null;
        goto L69
    L23:
        r1 = null;
        goto L24
    L19:
        r12 = null;
        goto L20
    L27:
        if (r26 == true) goto L29;
    L40:
        boolean r18 = false;
    L41:
        if (r18 == false) goto L43;
        String r19 = "//flow/chat_page_immers";
    L44:
        com.bytedance.router.i r110 = SmartRouter.buildRoute(r25, r19);     // Catch: Throwable -> L71
        int r22 = r8;
        Bundle r20 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("landing_channel", ChatLandingChannel.PROFILE_BOT_LIST.getChannel()), TuplesKt.to("argPreviousPage", this.l), TuplesKt.to("argConversationId", r29), TuplesKt.to("argClickEnterFrom", r30), TuplesKt.to("argCvsBgImgUrl", r27.c()), TuplesKt.to("argCvsBgImgColor", r27.a()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r27.b())), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("navigate_up_from", this.m), TuplesKt.to("argBotId", r6)});     // Catch: Throwable -> L71
        da0(r20, r26, r25);     // Catch: Throwable -> L71
        if (r18 == true) goto L48;
    L58:
        by7.e r23 = getParentFragment();     // Catch: Throwable -> L71
        if ((r23 instanceof by7.e) == false) goto L61;
        by7.e r24 = r23;     // Catch: Throwable -> L71
    L62:
        if (r24 == null) goto L64;
        by7.h.k(r20, r24);     // Catch: Throwable -> L71
    L64:
        r110.c.putExtras(r20);     // Catch: Throwable -> L71
        r110.d = r22;     // Catch: Throwable -> L71
        r110.e = 2130772399;     // Catch: Throwable -> L71
        r110.d();     // Catch: Throwable -> L71
        goto L65
    L61:
        r24 = null;
        goto L62
    L48:
        if (r20.getBoolean("is_single_mode", false) == true) goto L56;
        LaunchInfo r31 = LaunchCacheDelegate.b.c();     // Catch: Throwable -> L71
        if (r31 == null) goto L52;
        ImmersConfig r32 = r31.L0();     // Catch: Throwable -> L71
    L53:
        if (r32 == null) goto L56;
        boolean r111 = false;
    L57:
        r20.putBoolean("is_single_mode", r111);     // Catch: Throwable -> L71
        goto L58
    L52:
        r32 = null;
    L56:
        r111 = true;
        goto L57
    L43:
        r19 = "//flow/chat_page";
        goto L44
    L29:
        if (z2.a.chatImmerseEnable() == true) goto L31;
    L37:
        boolean r33 = false;
    L38:
        if (r33 == false) goto L40;
        r18 = true;
        goto L41
    L31:
        if (r27.b() == false) goto L37;
        if (com.larus.utils.o0.d(r27.c()) == false) goto L37;
        if (com.larus.utils.o0.d(r27.a()) == false) goto L37;
        r33 = true;
        goto L38
    L12:
        r10 = null;
    L71:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L8:
        r8 = 2130772401;
        goto L77
    L5:
        r3 = r27.j();
        goto L6
    }
}
