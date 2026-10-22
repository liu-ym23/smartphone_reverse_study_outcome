package com.larus.bmhome.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import by7.h;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.auth.ConvRecommendBotConf;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ConversationFragmentViewModel;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.trace.appreciable.ConversationPageTrace;
import com.larus.bmhome.databinding.LarusPageConversationListBinding;
import com.larus.bmhome.double_post.adapter.AwemeRecommendAdapter;
import com.larus.bmhome.double_post.conv.AwemeConversationListDelegate;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.view.ChatConversationList;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.AccountService;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0002\u0013_\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00100\u001a\u00020'H\u0016J\u001a\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020%H\u0014J\u0016\u00105\u001a\u00020'2\f\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\b\u00109\u001a\u00020'H\u0002J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0016J\b\u0010<\u001a\u00020'H\u0002J\u0010\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u0016H\u0014J\b\u0010?\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020'H\u0014J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020'H\u0002J\b\u0010D\u001a\u00020'H\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u0007H\u0016J\u0010\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\u0016H\u0016J\b\u0010I\u001a\u00020'H\u0016J\u0016\u0010J\u001a\u00020'2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u000208072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\b\u0010M\u001a\u00020\u0016H\u0002J\u0012\u0010N\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020807H\u0002J\b\u0010O\u001a\u00020\u0007H\u0016J\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020%H\u0016J\b\u0010R\u001a\u00020SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010U\u001a\u0004\u0018\u00010SH\u0016J\b\u0010V\u001a\u00020'H\u0016J\b\u0010W\u001a\u00020'H\u0016J\b\u0010X\u001a\u00020'H\u0016J\b\u0010Y\u001a\u00020'H\u0016J\u001a\u0010Z\u001a\u0004\u0018\u0001082\u0006\u0010[\u001a\u00020\u00162\u0006\u0010\\\u001a\u00020\u0016H\u0002J\u0012\u0010]\u001a\u00020%2\b\u0010K\u001a\u0004\u0018\u000108H\u0002J\u0014\u0010a\u001a\u0004\u0018\u00010\u00072\b\u0010b\u001a\u0004\u0018\u000108H\u0016J\u0016\u0010c\u001a\u00020'2\f\u00106\u001a\b\u0012\u0004\u0012\u00020d07H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`¨\u0006e"}, d2 = {"Lcom/larus/bmhome/chat/ConversationFragment;", "Lcom/larus/bmhome/chat/CommonChatListFragment;", "Lcom/larus/bmhome/setting/IConversationFragment;", "Lcom/larus/platform/api/IRecommendCaseChangeListener;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "binding", "Lcom/larus/bmhome/databinding/LarusPageConversationListBinding;", "conversationDataModelActivityLevel", "Lcom/larus/bmhome/chat/model/ConversationFragmentViewModel;", "getConversationDataModelActivityLevel", "()Lcom/larus/bmhome/chat/model/ConversationFragmentViewModel;", "conversationDataModelActivityLevel$delegate", "Lkotlin/Lazy;", "conversationListObserver", "com/larus/bmhome/chat/ConversationFragment$conversationListObserver$1", "Lcom/larus/bmhome/chat/ConversationFragment$conversationListObserver$1;", "resumedCounts", "", "scene", "conversationFragmentAbility", "Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "getConversationFragmentAbility", "()Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "conversationFragmentAbility$delegate", "doubaoFeedMonitor", "Lcom/larus/bmhome/chat/api/DouBaoConversationFeedMonitor;", "getDoubaoFeedMonitor", "()Lcom/larus/bmhome/chat/api/DouBaoConversationFeedMonitor;", "doubaoFeedMonitor$delegate", "awemeDelegate", "Lcom/larus/bmhome/double_post/conv/AwemeConversationListDelegate;", "hasReportSLO", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "setupListener", "isStick", "onCvsListChangeEvent", "list", "", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "observeAudioConfig", "attachFpsTracer", "onResume", "reportConvListSLO", "onConversationItemVisible", "index", "checkChatListEmpty", "setupModel", "getChatListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initRecommendTagBot", "startCreateConversation", "startCreateBot", "enterMethod", "updateConversationListBottomPadding", "bottomPadding", "initData", "submitDataInner", "data", "processConversationData", "getCurrentConversationSize", "getValidConversationSize", "getCurrentPageName", "getPageName", "autoLogEnterPage", "getTraceNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPreviousPage", "parentTrackNode", "onTabSingleClick", "onTabDoubleClick", "onEnterTab", "onLeaveTab", "findUnreadItem", "pos", "size", "hasUnreadMsg", "appBackGroundListener", "com/larus/bmhome/chat/ConversationFragment$appBackGroundListener$1", "Lcom/larus/bmhome/chat/ConversationFragment$appBackGroundListener$1;", "getRecommendFromString", "conversationData", "onRecommendCaseListChange", "Lcom/larus/platform/model/showcase/Case;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationFragment extends CommonChatListFragment implements com.larus.bmhome.setting.d, com.larus.platform.api.j1 {
    public static final /* synthetic */ int B = 0;
    public final a A;
    public final String q;
    public LarusPageConversationListBinding r;
    public final Lazy s;
    public final b t;
    public int u;
    public final String v;
    public final Lazy w;
    public final Lazy x;
    public AwemeConversationListDelegate y;
    public boolean z;

    public static final class a implements f09.a.b {
        public final /* synthetic */ ConversationFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            AwemeConversationListDelegate r0 = this.a.y;
            if (r0 == null) goto L12;
            long r1 = System.currentTimeMillis();
            r0.j = r1;
            com.larus.bmhome.double_post.utils.e r3 = com.larus.bmhome.double_post.utils.e.a;
            long r2 = r1 - r0.m;
            AwemeRecommendAdapter r4 = r0.f;
            Content r5 = (Content) r4.A2(r4.getItemCount() - 1);
            if (r5 == null) goto L9;
            Integer r6 = r5.getImprIndex();
            if (r6 == null) goto L9;
            int r7 = r6.intValue();
        L10:
            r3.b("switch_background", r2, Integer.valueOf(r7));
            return;
        L9:
            r7 = 0;
            goto L10
        }

        public final void onAppForeground() {
            FLogger.a.i(this.a.q, "onAppForeground");
            if (com.larus.bmhome.chat.model.f1.a() == false) goto L5;
            ConversationListModel r0 = ConversationListModel.a;
            DowngradeSource r1 = DowngradeSource.HOT_LAUNCH;
            r0.getClass();
            ConversationListModel.E(r1);
        L5:
            AwemeConversationListDelegate r2 = this.a.y;
            if (r2 == null) goto L9;
            r2.m = System.currentTimeMillis();
            r2.e();
            return;
        }

        public a(ConversationFragment r1) {
            this.a = r1;
        }
    }

    public static final class b implements ji8.b {
        public final /* synthetic */ ConversationFragment a;

        public b(ConversationFragment r1) {
            this.a = r1;
        }

        @Override // ji8.b
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "conversationId");
            FLogger.a.i(this.a.q, "onUpdateConversation: ".concat(r4));
            this.a.j.z2(r4);
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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

    /* JADX INFO: renamed from: com.larus.bmhome.chat.ConversationFragment$initData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.ConversationFragment$initData$2", f = "ConversationFragment.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, s = {})
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
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r5 == null) goto L14;
            r5.h0();
            com.larus.home.impl.sdk.h1 r6 = com.larus.home.impl.sdk.h1.a;
            this.label = 1;
            if (r6.e(this) != r0) goto L14;
            return r0;
        }
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final by7.e ba0() {
        return this;
    }

    public final String getPageName() {
        return "bot_list";
    }

    public final String k() {
        return "chat_list";
    }

    public final void PU() {
        com.larus.bmhome.chat.api.v r0 = (com.larus.bmhome.chat.api.v) this.w.getValue();
        if (r0 == null) goto L6;
        r0.c(this, this, "chat_list");
        return;
    }

    public final void Tu() {
        LarusPageConversationListBinding r0 = this.r;
        Integer r1 = null;
        if (r0 == null) goto L7;
        ChatConversationList r2 = r0.b;
        if (r2 == null) goto L7;
        RecyclerView.LayoutManager r3 = r2.getLayoutManager();
    L8:
        boolean r4 = r3 instanceof LinearLayoutManager;
        if (r4 == false) goto L12;
        int r5 = ((LinearLayoutManager) r3).findFirstCompletelyVisibleItemPosition();
    L15:
        if (r5 != (-1)) goto L17;
        return;
    L17:
        boolean r6 = true;
        if (r5 >= 0) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L25;
        wh8.a r8 = (wh8.a) ListProtector.get(this.j.getCurrentList(), r5);
    L26:
        boolean r9 = ia0(r8);
        int r10 = this.j.getCurrentList().size();
        if (r9 == false) goto L29;
        r5 = r5 + 1;
    L29:
        wh8.a r11 = ga0(r5, r10);
        if (r11 != null) goto L32;
        r11 = ga0(0, r10);
    L32:
        if (r11 == null) goto L47;
        Integer r12 = Integer.valueOf(this.j.getCurrentList().indexOf(r11));
        if (r12.intValue() != (-1)) goto L37;
        r6 = false;
    L37:
        if (r6 == false) goto L39;
        r1 = r12;
    L39:
        if (r1 == null) goto L48;
        int r13 = r1.intValue();
        if (r4 == false) goto L44;
        ((LinearLayoutManager) r3).scrollToPositionWithOffset(r13, 0);
        return;
    L44:
        if ((r3 instanceof StaggeredGridLayoutManager) == false) goto L50;
        ((StaggeredGridLayoutManager) r3).scrollToPositionWithOffset(r13, 0);
        return;
    L50:
        return;
    L48:
        return;
    L47:
        return;
    L25:
        r8 = null;
        goto L26
    L20:
        if (r5 >= this.j.getCurrentList().size()) goto L22;
        r7 = true;
        goto L23
    L12:
        if ((r3 instanceof StaggeredGridLayoutManager) == false) goto L14;
        r5 = ((StaggeredGridLayoutManager) r3).findFirstVisibleItemPositions(null)[0];
        goto L15
    L14:
        r5 = -1;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final ChatConversationList Y90() {
        LarusPageConversationListBinding r0 = this.r;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final String b() {
        if (this.u != 1) goto L8;
        if (com.larus.platform.service.z2.a.enableChatWithTab() == false) goto L8;
        return "chat";
    L8:
        return TrackParams.optString$default(h.a(this), "previous_page", null, 2, null);
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void ca0() {
        ((com.larus.bmhome.chat.api.o) this.x.getValue()).h(ha0(this.j.getCurrentList()));
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void initData() {
        if (this.y == null) goto L11;
        AwemeConversationListDelegate r0 = this.y;
        if (r0 == null) goto L16;
        LarusPageConversationListBinding r2 = this.r;
        if (r2 == null) goto L9;
        ChatConversationList r3 = r2.b;
    L10:
        r0.b(r3);
        goto L16
    L9:
        r3 = null;
    L16:
        FLogger.a.i(this.q, "need request conversation source=" + ((ConversationFragmentViewModel) this.s.getValue()).getNeedConversationRequest());
        if (((ConversationFragmentViewModel) this.s.getValue()).getNeedConversationRequest() == false) goto L20;
        ConversationListModel.a.getClass();
        ConversationListModel.r("CvsFgt#initData");
    L20:
        if (com.larus.platform.service.z2.a.c3() == true) goto L22;
    L24:
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r4 = false;
        if (r1 == null) goto L29;
        r1.h0();
        if (com.larus.home.impl.sdk.h1.a.c() != true) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L43;
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L34;
        r6.h0();
        List r7 = com.larus.home.impl.sdk.h1.a.i();
    L35:
        List r8 = r7;
        if (r8 != null) goto L38;
    L39:
        r4 = true;
    L40:
        if (r4 == false) goto L44;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(null), 3, null);
        return;
    L44:
        return;
    L38:
        if (r8.isEmpty() == false) goto L40;
    L34:
        r7 = null;
        goto L35
    L43:
        return;
    L29:
        r5 = false;
        goto L30
    L22:
        if (com.larus.bmhome.social.userchat.model.e0.a == true) goto L24;
        Z90().getConversationListLivedata().observe(getViewLifecycleOwner(), new c(new i2(this)));
        goto L24
    L11:
        LarusPageConversationListBinding r9 = this.r;
        if (r9 == null) goto L16;
        ChatConversationList r10 = r9.b;
        if (r10 == null) goto L16;
        r10.setAdapter(this.j);
        goto L16
    }

    public final void nm() {
        LarusPageConversationListBinding r0 = this.r;
        if (r0 == null) goto L8;
        ChatConversationList r1 = r0.b;
        if (r1 == null) goto L9;
        r1.postDelayed(new o2(this), 2000);
        return;
    L9:
        return;
    }

    public final void se() {
        LarusPageConversationListBinding r0 = this.r;
        if (r0 == null) goto L8;
        ChatConversationList r1 = r0.b;
        if (r1 == null) goto L9;
        r1.scrollToPosition(0);
        return;
    L9:
        return;
    }

    public final void t1() {
        LarusPageConversationListBinding r0 = this.r;
        if (r0 == null) goto L7;
        ChatConversationList r1 = r0.b;
        if (r1 == null) goto L7;
        y6.i(r1);
    L7:
        AwemeConversationListDelegate r2 = this.y;
        if (r2 == null) goto L11;
        r2.c(false);
        return;
    }

    public final void vY() {
        AwemeConversationListDelegate r0 = this.y;
        if (r0 == null) goto L6;
        r0.c(true);
        return;
    }

    public ConversationFragment() {
        this.q = "ConversationFragment";
        this.s = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConversationFragmentViewModel.class), new ConversationFragment$special$$inlined$activityViewModels$default$1(this), new ConversationFragment$special$$inlined$activityViewModels$default$2(this));
        this.t = new b(this);
        this.u = -1;
        this.v = "ChatConvList";
        this.w = LazyKt.lazy(new g2());
        this.x = LazyKt.lazy(new j2(this));
        this.A = new a(this);
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void fa0() {
        super.fa0();
        ((ConversationChangeModel) this.l.getValue()).getNewChat().observe(getViewLifecycleOwner(), new c(new n2(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ConversationFragment$setupModel$2(this, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void onDestroyView() {
        super.onDestroyView();
        LarusPageConversationListBinding r0 = this.r;
        if (r0 == null) goto L5;
        r0.b.setAdapter(null);
    L5:
        ji8.d.a.e(this.t);
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L10;
        r1.h0();
        boolean r2 = true;
        if (com.larus.home.impl.sdk.h1.a.c() != true) goto L10;
    L11:
        if (r2 == false) goto L15;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L15;
        r3.h0();
        com.larus.home.impl.sdk.h1.a.k(this);
    L15:
        AppHost.a.a().c(this.A);
        AudioServiceDelegate r4 = AudioServiceDelegate.a;
        r4.getAudioConfig().s().removeObservers(getViewLifecycleOwner());
        r4.getAudioConfig().p().removeObservers(getViewLifecycleOwner());
        AuthModelDelegate.b.e().removeObservers(getViewLifecycleOwner());
        ((com.larus.bmhome.chat.api.o) this.x.getValue()).b();
        this.r = null;
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // com.larus.bmhome.BaseHomeTabFragment
    public final void onResume() {
        super.onResume();
        boolean r1 = true;
        this.u++;
        if (getUserVisibleHint() == false) goto L19;
        FLogger r0 = FLogger.a;
        r0.i(this.q, "onResume, userVisibleHint(true)");
        ConversationPageTrace.ConversationPageRecord r2 = ConversationPageTrace.a;
        ConversationPageTrace.e(com.larus.bmhome.social.userchat.model.e0.a, ((ConversationFragmentViewModel) this.s.getValue()).getNeedConversationRequest());
        SafeExtKt.c(this, new k2(this), 1000);
        Lazy r3 = com.larus.bmhome.chat.model.f1.a;
        ((Keva) com.larus.bmhome.chat.model.f1.a.getValue()).storeBoolean(AccountService.a.getUserId() + '-' + com.larus.bmhome.chat.model.f1.c, true);
        r0.i("ConversationListModel-RecommendTagBot", "updateAlreadyEnteredCvsListPage, alreadyEnteredCvsListPage(true)");
        com.larus.bmhome.chat.api.e0 r4 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r4 == null) goto L9;
        LaunchInfo r5 = r4.a;
        if (r5 == null) goto L9;
        ConvRecommendBotConf r6 = r5.J();
    L10:
        if (r6 != null) goto L12;
    L14:
        r1 = false;
    L15:
        r0.i("ConversationListModel-RecommendTagBot", "isRealtimeRequireMode(" + r1 + "), config:" + r6);
        if (r1 == false) goto L20;
        ConversationListModel r7 = ConversationListModel.a;
        DowngradeSource r8 = DowngradeSource.ENTER_PAGE;
        r7.getClass();
        ConversationListModel.E(r8);
        return;
    L20:
        return;
    L12:
        if (r6.c() != 2) goto L14;
    L9:
        r6 = null;
        goto L10
    }

    public final by7.e parentTrackNode() {
        by7.e r0 = getParentFragment();
        if ((r0 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public static int ha0(List r3) {
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
        int r0 = 0;
    L9:
        if (r5.hasNext() == false) goto L21;
        wc9.e r2 = ((wh8.a) r5.next()).a;
        if (r2 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        if (ic8.n.r(r2) == true) goto L15;
        r6 = true;
        goto L16
    L21:
        return r0;
    L5:
        if (r4.isEmpty() == false) goto L7;
        return 0;
    }

    public static boolean ia0(wh8.a r2) {
        if (r2 == null) goto L9;
        wc9.e r1 = r2.a;
        if (r1 == null) goto L9;
        Integer r3 = r1.l;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        if (r2 == null) goto L16;
        wc9.e r5 = r2.a;
        if (r5 == null) goto L16;
        Integer r6 = r5.m;
        if (r6 == null) goto L16;
        int r7 = r6.intValue();
    L18:
        if ((r4 - r7) <= 0) goto L21;
        return true;
    L21:
        return false;
    L16:
        r7 = 0;
    L9:
        r4 = 0;
        goto L10
    }

    public final void Kk(int r5) {
        LarusPageConversationListBinding r0 = this.r;
        if (r0 == null) goto L8;
        ChatConversationList r1 = r0.b;
        if (r1 == null) goto L9;
        r1.setPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), r5);
        r1.setClipToPadding(false);
        return;
    L9:
        return;
    }

    public final void X3(String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        com.larus.bmhome.chat.api.v r0 = (com.larus.bmhome.chat.api.v) this.w.getValue();
        if (r0 == null) goto L6;
        r0.a(getContext(), r3, this);
        return;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final String aa0(wh8.a r4) {
        boolean r0 = false;
        if (r4 == null) goto L11;
        RecommendFrom r1 = r4.f;
        if (r1 == null) goto L11;
        String r2 = r1.a;
        if (r2 == null) goto L11;
        if (com.larus.utils.o0.d(r2) != true) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L16;
        RecommendFrom r5 = r4.f;
        if (r5 != null) goto L18;
        return null;
    L18:
        return r5.a;
    L16:
        return "chat_list";
    }

    public final void av(List<Case> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        List<wh8.a> r3 = Z90().getLatestConversationData();
        if (r3 == null) goto L6;
        ja0(r3);
        return;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void da0(List<wh8.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        ArrayList r0 = new ArrayList(r5);
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r6.add(wh8.a.a((wh8.a) r1.next(), null, null, 4095));
        goto L4
    L6:
        ArrayList r2 = new ArrayList();
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L18;
        Object r3 = r7.next();
        wh8.a r4 = (wh8.a) r3;
        if (ic8.n.l(r4.a) == false) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L8;
        r2.add(r3);
        goto L8
    L12:
        if (ic8.n.y(r4.a) == true) goto L15;
        r8 = false;
        goto L16
    L18:
        ((com.larus.bmhome.chat.api.o) this.x.getValue()).g(ha0(r2));
        com.larus.platform.service.z2 r9 = com.larus.platform.service.z2.a;
        if (r9.c3() == true) goto L21;
    L25:
        ja0(r2);
        return;
    L21:
        if (com.larus.bmhome.social.userchat.model.e0.a == true) goto L25;
        if (r9.isLazyMainComponentEnable() == true) goto L25;
        Z90().getConversationListLivedata().postValue(r2);
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void ea0(boolean r6) {
        boolean r0 = true;
        super.ea0(!((ConversationFragmentViewModel) this.s.getValue()).getNeedConversationRequest());
        ji8.d.a.d(this.t);
        AudioServiceDelegate r7 = AudioServiceDelegate.a;
        r7.getAudioConfig().s().observe(getViewLifecycleOwner(), new c(new l2(this)));
        r7.getAudioConfig().p().observe(getViewLifecycleOwner(), new c(new m2(this)));
        com.larus.bmhome.chat.api.v r8 = (com.larus.bmhome.chat.api.v) this.w.getValue();
        if (r8 == null) goto L9;
        LarusPageConversationListBinding r1 = this.r;
        if (r1 == null) goto L7;
        ChatConversationList r2 = r1.b;
    L8:
        r8.b(r2, this.v);
        goto L9
    L7:
        r2 = null;
    L9:
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L14;
        r9.h0();
        if (com.larus.home.impl.sdk.h1.a.c() != true) goto L14;
    L15:
        if (r0 == false) goto L20;
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L21;
        r10.h0();
        com.larus.home.impl.sdk.h1.a.j(this);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        r0 = false;
        goto L15
    }

    public final void ja0(List<wh8.a> r27) {
        List<wh8.a> r1 = r27;
        Z90().setLatestConversationData(r1);
        AwemeConversationListDelegate r2 = this.y;
        if (r2 == null) goto L5;
        r2.d(r1);
        return;
    L5:
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L10;
        r3.h0();
        if (com.larus.home.impl.sdk.h1.a.c() != true) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L83;
        ArrayList r5 = new ArrayList();
        List<wh8.a> r6 = r1;
        Iterator r7 = r6.iterator();
    L14:
        Object r8 = null;
        if (r7.hasNext() == false) goto L19;
        Object r9 = r7.next();
        if (ic8.n.u(((wh8.a) r9).a) == false) goto L14;
    L20:
        wh8.a r10 = (wh8.a) r9;
        if (r10 == null) goto L23;
        r5.add(r10);
    L23:
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L26;
        r11.h0();
        List r12 = com.larus.home.impl.sdk.h1.a.i();
    L28:
        if (r12 == null) goto L44;
        Iterator r13 = r12.iterator();
    L31:
        if (r13.hasNext() == false) goto L44;
        Case r23 = (Case) r13.next();
        Long r14 = r23.getCreateTime();
        if (r14 == null) goto L35;
        long r15 = r14.longValue();
    L37:
        if (r15 > 0) goto L31;
        Integer r16 = r23.getStatus();
        if (r16 == null) goto L43;
        if (r16.intValue() == 2) goto L31;
    L43:
        r5.add(new wh8.a(null, null, null, null, null, null, null, null, null, null, r23, false, 3070));
        goto L31
    L35:
        r15 = 0;
    L44:
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L49;
        r17.h0();
        if (com.larus.home.impl.sdk.h1.a.d() != true) goto L49;
        boolean r18 = true;
    L50:
        if (r18 == true) goto L73;
        if (r12 == null) goto L71;
        Iterator r19 = r12.iterator();
    L54:
        if (r19.hasNext() == false) goto L70;
        Object r110 = r19.next();
        Case r111 = (Case) r110;
        Long r112 = r111.getCreateTime();
        if (r112 == null) goto L58;
        long r113 = r112.longValue();
    L60:
        if (r113 > 0) goto L67;
        Integer r114 = r111.getStatus();
        if (r114 != null) goto L65;
    L66:
        boolean r115 = true;
    L68:
        if (r115 == false) goto L54;
        r8 = r110;
        goto L70
    L65:
        if (r114.intValue() != 2) goto L66;
    L67:
        r115 = false;
        goto L68
    L58:
        r113 = 0;
    L70:
        r8 = (Case) r8;
    L71:
        if (r8 == null) goto L73;
        r5.add(new wh8.a(null, null, null, null, null, null, null, null, null, null, null, false, 4094));
    L73:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r6.iterator();
    L75:
        if (r21.hasNext() == false) goto L79;
        Object r22 = r21.next();
        if (ic8.n.u(((wh8.a) r22).a) == true) goto L75;
        r20.add(r22);
        goto L75
    L79:
        r5.addAll(r20);
        ConversationListModel.a.getClass();
        if (ConversationListModel.v == true) goto L82;
        r5.add(new wh8.a(null, null, null, null, null, null, null, null, null, null, null, true, 2046));
    L82:
        r1 = r5;
    L49:
        r18 = false;
        goto L50
    L26:
        r12 = null;
        goto L28
    L19:
        r9 = null;
    L83:
        this.j.E2(r1);
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        ConversationPageTrace.b();
        ((com.larus.bmhome.chat.api.o) this.x.getValue()).d(LifecycleOwnerKt.getLifecycleScope(this));
        Lazy r3 = com.larus.bmhome.video.b.a;
        if (com.larus.bmhome.video.b.g() == false) goto L6;
        this.y = new AwemeConversationListDelegate(this, this.j);
        return;
    }

    public final wh8.a ga0(int r3, int r4) {
        Object r0 = null;
        if (r3 < r4) goto L5;
        return null;
    L5:
        Iterator<T> r5 = this.j.getCurrentList().subList(r3, r4).iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (ia0((wh8.a) r6) == false) goto L7;
        r0 = r6;
    L12:
        return (wh8.a) r0;
    }

    @Override // com.larus.bmhome.chat.CommonChatListFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        Lazy r5 = com.larus.bmhome.chat.model.f1.a;
        com.larus.bmhome.chat.model.f1.b = ((Keva) com.larus.bmhome.chat.model.f1.a.getValue()).getBoolean(AccountService.a.getUserId() + '-' + com.larus.bmhome.chat.model.f1.c, false);
        FLogger.a.i("ConversationListModel-RecommendTagBot", "refreshAlreadyEnteredCvsListPage, alreadyEnteredCvsListPage(" + com.larus.bmhome.chat.model.f1.b + ')');
        AuthModelDelegate.b.e().observe(getViewLifecycleOwner(), new c(new p2(this)));
        AppHost.a.a().j(this.A);
        ConversationPageTrace.g();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ChatConversationList r5 = r2.inflate(2131563028, r3, false);
        if (r5 == null) goto L7;
        ChatConversationList r6 = r5;
        this.r = new LarusPageConversationListBinding(r6, r6);
        r6.setTag(2131377847, this);
        return r6;
    L7:
        throw new NullPointerException("rootView");
    }
}
