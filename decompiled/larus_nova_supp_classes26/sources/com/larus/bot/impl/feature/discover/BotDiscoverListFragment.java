package com.larus.bot.impl.feature.discover;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.common.view.BlockBringChildSwipeRefreshLayout;
import com.larus.bot.impl.common.view.FastScrollGridLayoutManager;
import com.larus.bot.impl.common.view.FastScrollLayoutManager;
import com.larus.bot.impl.databinding.LarusPageBotDiscoverListBinding;
import com.larus.bot.impl.feature.discover.adapter.BotDiscoverListAdapter;
import com.larus.bot.impl.feature.discover.adapter.BotDiscoverListHeaderAdapter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.d1;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.e1;
import tx9.w3;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u00017\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u0002:\u0002\u0088\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0.2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\u0012\u0010I\u001a\u00020:2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J&\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020M2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010T\u001a\u00020:H\u0016J\b\u0010U\u001a\u00020/H\u0016J\u000f\u0010V\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020:H\u0002J\u0018\u0010Y\u001a\u0004\u0018\u00010/2\u0006\u0010Z\u001a\u00020<H\u0082@¢\u0006\u0002\u0010[J&\u0010\\\u001a\u00020:2\u0006\u0010Z\u001a\u00020<2\b\u0010]\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010/H\u0002J&\u0010_\u001a\u00020:2\u0006\u0010Z\u001a\u00020<2\b\u0010]\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010/H\u0002J\b\u0010c\u001a\u00020:H\u0002J\u0010\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020fH\u0003J\u0014\u0010g\u001a\u00020:2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010/H\u0002J$\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020C2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010p\u001a\u00020:2\u0006\u0010@\u001a\u000201H\u0002J\u0016\u0010q\u001a\u00020:2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020/0>H\u0002J\b\u0010s\u001a\u00020:H\u0016J\b\u0010t\u001a\u00020:H\u0016J\u0010\u0010u\u001a\u00020:2\u0006\u00105\u001a\u00020)H\u0016J\u0006\u0010v\u001a\u00020:J\u0006\u0010w\u001a\u00020:J\b\u0010x\u001a\u00020:H\u0002J\u0018\u0010y\u001a\u00020:2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010>H\u0002J\u0010\u0010|\u001a\u00020:2\u0006\u0010Z\u001a\u00020<H\u0002J \u0010}\u001a\u00020:2\u0006\u0010Z\u001a\u00020<2\u0006\u0010k\u001a\u00020)2\u0006\u0010l\u001a\u00020CH\u0002J\u0010\u0010~\u001a\u00020:2\u0006\u0010Z\u001a\u00020<H\u0002J\u0010\u0010\u007f\u001a\u00020:2\u0006\u0010Z\u001a\u00020<H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020:2\u0007\u0010\u0081\u0001\u001a\u000201H\u0002J\u0011\u0010\u0082\u0001\u001a\u00020/2\u0006\u0010Z\u001a\u00020<H\u0002J\t\u0010\u0083\u0001\u001a\u00020:H\u0002J\u001a\u0010\u0084\u0001\u001a\u00020)2\u000f\u0010\u0085\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0>H\u0002J\f\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u000e\u0010@\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0>0bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010o\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/larus/bot/impl/feature/discover/BotDiscoverListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "<init>", "()V", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotDiscoverListBinding;", "model", "Lcom/larus/bot/impl/feature/discover/BotDiscoverListModel;", "getModel", "()Lcom/larus/bot/impl/feature/discover/BotDiscoverListModel;", "model$delegate", "Lkotlin/Lazy;", "conversationChangeModel", "Lcom/larus/bmhome/ConversationChangeModel;", "getConversationChangeModel", "()Lcom/larus/bmhome/ConversationChangeModel;", "conversationChangeModel$delegate", "parentModel", "Lcom/larus/bot/impl/feature/discover/BotDiscoverModel;", "getParentModel", "()Lcom/larus/bot/impl/feature/discover/BotDiscoverModel;", "parentModel$delegate", "viewAdapter", "Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter;", "getViewAdapter", "()Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter;", "viewAdapter$delegate", "headerAdapter", "Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListHeaderAdapter;", "getHeaderAdapter", "()Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListHeaderAdapter;", "headerAdapter$delegate", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "enableBannerOpt", "", "getEnableBannerOpt", "()Z", "enableBannerOpt$delegate", "deleteConversationList", "", "", "botListRefreshInterval", "", "getBotListRefreshInterval", "()I", "botListRefreshInterval$delegate", "isVisibleToUser", "botStatusObserver", "com/larus/bot/impl/feature/discover/BotDiscoverListFragment$botStatusObserver$1", "Lcom/larus/bot/impl/feature/discover/BotDiscoverListFragment$botStatusObserver$1;", "handleChange", "", "allBot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "newConversations", "", "Lcom/larus/im/bean/conversation/Conversation;", "status", "isFirst", "enterTime", "", "itemShowCount", "hasReportScroll", "position", "lastExitTime", "hasBotCreationButton", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "getCurrentPageName", "initView", "()Lkotlin/Unit;", "setupRecyclerView", "checkAndCreateConversation", "data", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "directToRealtimeCall", "conversationId", "argPosition", "toChatFragment", "clickEnterFrom", "blockObserver", "Landroidx/lifecycle/Observer;", "initViewModel", "checkConversationRemoved", "event", "Lcom/larus/bmhome/chat/event/ConversationIdChangeEvent;", "refresh", "triggerType", "botDiscoverPageEvent", "Lcom/larus/ugc/perf/impl/mob/BaseUgcPerfEvent;", "success", "duration", "scene", "startTime", "cachedData", "updateStatus", "deleteRecommendBotConversation", "botIdList", "onPause", "onDestroyView", "setUserVisibleHint", "onTabClick", "onLeaveTab", "scroolToTopAndRefresh", "updateBotTag", "tagList", "Lcom/larus/platform/api/creation/TabTag;", "reportBotAdd", "reportBotAddResult", "reportBotRemove", "reportConfirmUnfollowBot", "reportItemShow", "index", "getChatType", "reportScroll", "isContainBotIds", "botIds", "parentTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverListFragment extends Fragment implements com.larus.trace.tracknode.a {
    public static final /* synthetic */ int A = 0;
    public final et3.c d;
    public LarusPageBotDiscoverListBinding e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final List<String> m;
    public final Lazy n;
    public boolean o;
    public final b p;
    public int q;
    public boolean r;
    public long s;
    public int t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public final m0 y;
    public long z;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.z<List<? extends wc9.e>> {
        public final /* synthetic */ BotDiscoverListFragment a;

        public b(BotDiscoverListFragment r1) {
            this.a = r1;
        }

        public final void c(Object r9) {
            List r10 = (List) r9;
            Intrinsics.checkNotNullParameter(r10, "conversation");
            if (r10.isEmpty() == true) goto L30;
            BotDiscoverListFragment r0 = this.a;
            int r1 = BotDiscoverListFragment.A;
            List r2 = CollectionsKt.toMutableList(((FPagingAdapter) r0.Z90()).b);
            if (r2.isEmpty() == true) goto L31;
            ArrayList r3 = new ArrayList();
            Iterator r11 = r10.iterator();
        L10:
            if (r11.hasNext() == false) goto L21;
            Object r4 = r11.next();
            Integer r5 = ((wc9.e) r4).f;
            if (r5 == null) goto L17;
            boolean r6 = true;
            if (r5.intValue() != 1) goto L17;
        L18:
            if (r6 == true) goto L10;
            r3.add(r4);
        L17:
            r6 = false;
            goto L18
        L21:
            if (r3.isEmpty() == true) goto L32;
            BotDiscoverListFragment r12 = this.a;
            r12.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new BotDiscoverListFragment$handleChange$1(r3, r2, r12, null), 3, null);
            return;
        L32:
            return;
        L31:
            return;
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

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListFragment$onCreate$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$onCreate$7", f = "BotDiscoverListFragment.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotDiscoverListFragment this$0;

        /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListFragment$onCreate$7$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ BotDiscoverListFragment a;

            public a(BotDiscoverListFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                String r4 = (String) r2;
                if (this.a.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
                BotDiscoverListFragment r5 = this.a;
                List<String> r6 = CollectionsKt.listOf(r4);
                int r0 = BotDiscoverListFragment.A;
                r5.V90(r6);
            L7:
                return Unit.INSTANCE;
            L5:
                Boxing.boxBoolean(((ArrayList) this.a.m).add(r4));
                goto L7
            }
        }

        public AnonymousClass7(BotDiscoverListFragment r1, Continuation<? super AnonymousClass7> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass7(this.this$0, r3);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            d1 r6 = ((ConversationChangeModel) this.this$0.g.getValue()).getBotListSharedFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final boolean et() {
        return false;
    }

    public final String k() {
        return "bot_list_discover";
    }

    public final void te() {
    }

    public final BotDiscoverListHeaderAdapter X90() {
        return (BotDiscoverListHeaderAdapter) this.j.getValue();
    }

    public final BotDiscoverListModel Y90() {
        return (BotDiscoverListModel) this.f.getValue();
    }

    public final BotDiscoverListAdapter Z90() {
        return (BotDiscoverListAdapter) this.i.getValue();
    }

    public final void ba0() {
        LarusPageBotDiscoverListBinding r0 = this.e;
        if (r0 == null) goto L16;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L18;
        if (r0 == null) goto L17;
        BlockBringChildSwipeRefreshLayout r2 = r0.d;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.isRefreshing() == false) goto L14;
        return;
    L14:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BotDiscoverListFragment$scroolToTopAndRefresh$1(r1, r2, this, null), 3, null);
        return;
    L17:
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [com.larus.bot.impl.feature.discover.m0] */
    public BotDiscoverListFragment() {
        et3.c r0 = new et3.c("bot_list_discover", false, null);
        r0.b(new x());
        this.d = r0;
        final Function0<Fragment> r1 = new BotDiscoverListFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotDiscoverListModel.class), new BotDiscoverListFragment$special$$inlined$viewModels$default$2(r1), new BotDiscoverListFragment$special$$inlined$viewModels$default$3(r1, this));
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConversationChangeModel.class), new BotDiscoverListFragment$special$$inlined$activityViewModels$default$1(this), new BotDiscoverListFragment$special$$inlined$activityViewModels$default$2(this));
        final Function0 r2 = new g0(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotDiscoverModel.class), new BotDiscoverListFragment$special$$inlined$viewModels$default$4(r2), new BotDiscoverListFragment$special$$inlined$viewModels$default$5(r2, this));
        this.i = LazyKt.lazy(new h0(this));
        this.j = LazyKt.lazy(new i0(this));
        this.k = LazyKt.lazy(new j0());
        this.l = LazyKt.lazy(new k0());
        this.m = new ArrayList();
        this.n = LazyKt.lazy(new l0());
        this.p = new b(this);
        this.r = true;
        this.y = new m0(this);
        this.z = System.currentTimeMillis();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e = null;
        ((com.larus.im.service.q) this.k.getValue()).unRegisterConversationChangeListener(this.p);
        AccountService.a.A().removeObserver(this.y);
    }

    public final void onPause() {
        super.onPause();
        long r0 = AppHost.a.getAppClock().currentTimeMillis() - this.s;
        String r2 = String.valueOf(this.t);
        String r1 = String.valueOf(r0);
        zp9.w r3 = Y90().getTabTag();
        if (r3 == null) goto L5;
        String r4 = r3.b;
    L6:
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r2 != null) goto L19;
    L11:
        if (r1 == null) goto L13;
        r5.put("tab_duration", r1);     // Catch: JSONException -> L9
    L13:
        if (r4 == null) goto L17;
        r5.put("tab_name", r4);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.a.e("LeaveEventHelper", "error in LeaveEventHelper leaveDiscoverTab " + e.getLocalizedMessage());
    L17:
        TrackParams r6 = new TrackParams().merge(r5);
        by7.a r7 = new by7.a("leave_discover_tab");
        r7.a.merge(r6);
        r7.b();
        this.o = false;
        return;
    L19:
        r5.put("bot_cnt", r2);     // Catch: JSONException -> L9
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        if (this.q != 1) goto L9;
        if (com.larus.bot.impl.common.util.d.a == false) goto L7;
        com.larus.bot.impl.common.util.d.a = false;
    L7:
        aa0("refresh");
    L11:
        Y90().requestBannerData(DowngradeSource.ENTER_PAGE);
        V90(this.m);
        this.s = AppHost.a.getAppClock().currentTimeMillis();
        this.t = 0;
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        TrackParams r1 = new TrackParams().merge(r0);
        by7.a r2 = new by7.a("bot_list_discover_pv");
        r2.b = this;
        r2.a.merge(r1);
        r2.b();
        this.o = true;
        return;
    L9:
        if (com.larus.bot.impl.common.util.d.a == false) goto L11;
        com.larus.bot.impl.common.util.d.a = false;
        Z90().notifyDataSetChanged();
        goto L11
    }

    public final by7.e parentTrackNode() {
        by7.e r0 = getParentFragment();
        if ((r0 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final void V90(List<String> r5) {
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L16;
        String r0 = (String) r6.next();
        Iterator r1 = ((FPagingAdapter) Z90()).b.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((RecommendBot) r2).o(), r0) == false) goto L7;
    L12:
        RecommendBot r3 = (RecommendBot) r2;
        if (r3 == null) goto L4;
        BotStatusCacheDelegate.b.a(r0, false);
        r3.G0("");
        Z90().H2(r0);
        goto L4
    L11:
        r2 = null;
        goto L12
    L16:
        ((ArrayList) this.m).clear();
    }

    public final String W90(RecommendBot r4) {
        Integer r0 = r4.r();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L20:
        return "other_default";
    L11:
        if (r0.intValue() != 0) goto L20;
        BotCreatorInfo r5 = r4.j();
        if (r5 == null) goto L15;
        String r6 = r5.getId();
    L17:
        if (Intrinsics.areEqual(r6, AccountService.a.getUserId()) == false) goto L19;
        return "self_created";
    L19:
        return "others_created";
    L15:
        r6 = null;
        goto L17
    L6:
        if (r0.intValue() != 1) goto L8;
        return "default";
    }

    public final void aa0(String r8) {
        da0(1);
        if (((BotDiscoverModel) this.h.getValue()).getRefreshData().getValue() == null) goto L5;
    L6:
        BotDiscoverListModel.refreshData$default(Y90(), null, r8, null, 5, null);
        return;
    L5:
        if (Y90().getTabTag() != null) goto L6;
    }

    public final void ca0(List<zp9.w> r5) {
        List<zp9.w> r0 = r5;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        int r2 = r0.size();
        int r4 = this.v;
        if (r4 < 0) goto L15;
        if (r4 >= r2) goto L15;
    L16:
        if (r1 == false) goto L19;
        Y90().setTabTag((zp9.w) ListProtector.get(r5, this.v));
        return;
    L19:
        return;
    L15:
        r1 = false;
        goto L16
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void da0(int r50) {
        this.q = r50;
        LarusPageBotDiscoverListBinding r2 = this.e;
        if (r2 == null) goto L95;
        LinearLayout r3 = r2.c;
        if (r3 == null) goto L100;
        boolean r4 = true;
        int r5 = 0;
        long r9 = 0;
        if (r50 == 0) goto L69;
        if (r50 != 1) goto L11;
        this.z = System.currentTimeMillis();
        if (((ArrayList) ((FPagingAdapter) Z90()).b).isEmpty() == false) goto L56;
        r3.setVisibility(8);
        BotDiscoverListAdapter r1 = Z90();
        RecommendBot[] r6 = new RecommendBot[20];
    L53:
        if (r5 >= 20) goto L55;
        r6[r5] = new RecommendBot(null, null, null, null, null, 0, 0, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, null, -1, 7935);
        r5 = r5 + 1;
        goto L53
    L55:
        r1.E2(ArraysKt.toList(r6));
        BotDiscoverListHeaderAdapter r7 = X90();
        r7.c = null;
        r7.notifyDataSetChanged();
        return;
    L56:
        List r8 = ((FPagingAdapter) Z90()).b;
        if ((r8 instanceof Collection) == true) goto L59;
    L61:
        Iterator r10 = ((ArrayList) r8).iterator();
    L63:
        if (r10.hasNext() == false) goto L67;
        if (((RecommendBot) r10.next()).p0() == true) goto L63;
        r4 = false;
    L67:
        if (r4 == false) goto L98;
        r3.setVisibility(8);
        BotDiscoverListHeaderAdapter r11 = X90();
        r11.c = null;
        r11.notifyDataSetChanged();
        return;
    L98:
        return;
    L59:
        if (((ArrayList) r8).isEmpty() == false) goto L61;
    L11:
        if (r50 == 2) goto L14;
        return;
    L14:
        if ((!((ArrayList) ((FPagingAdapter) Z90()).b).isEmpty()) == false) goto L31;
        List r12 = ((FPagingAdapter) Z90()).b;
        if ((r12 instanceof Collection) == true) goto L18;
    L20:
        Iterator r13 = ((ArrayList) r12).iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        if (((RecommendBot) r13.next()).p0() == true) goto L22;
        boolean r14 = false;
    L27:
        if (r14 == true) goto L31;
        if (getUserVisibleHint() == false) goto L32;
        t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
    L32:
        LarusPageBotDiscoverListBinding r15 = this.e;
        if (r15 == null) goto L38;
        BlockBringChildSwipeRefreshLayout r16 = r15.d;
        if (r16 == null) goto L38;
        r16.setRefreshing(false);
    L38:
        if (this.o == false) goto L40;
        r9 = System.currentTimeMillis() - this.z;
    L40:
        zp9.w r17 = Y90().getTabTag();
        if (r17 != null) goto L43;
    L45:
        r4 = false;
    L46:
        if (r4 == false) goto L48;
        String r18 = "load_recommend_tab";
    L49:
        new h1a.a(r18, null, TriggerSendLoading.NO_LOADING, null, Long.valueOf(r9), null, null, null, 234).b();
        return;
    L48:
        r18 = "load_other_tab";
        goto L49
    L43:
        if (r17.a != 1) goto L45;
    L26:
        r14 = true;
        goto L27
    L18:
        if (((ArrayList) r12).isEmpty() == false) goto L20;
    L31:
        r3.setVisibility(0);
        goto L32
    L69:
        r3.setVisibility(8);
        LarusPageBotDiscoverListBinding r19 = this.e;
        if (r19 == null) goto L74;
        BlockBringChildSwipeRefreshLayout r20 = r19.d;
        if (r20 == null) goto L74;
        r20.setRefreshing(false);
    L74:
        BotDiscoverListHeaderAdapter r21 = X90();
        r21.c = (List) Y90().getBannerData().getValue();
        r21.notifyDataSetChanged();
        if (this.o == false) goto L77;
        r9 = System.currentTimeMillis() - this.z;
    L77:
        zp9.w r22 = Y90().getTabTag();
        if (r22 != null) goto L80;
    L82:
        r4 = false;
    L83:
        if (r4 == false) goto L85;
        String r110 = "load_recommend_tab";
    L86:
        new h1a.a(r110, null, "1", null, Long.valueOf(r9), null, null, null, 234).b();
        return;
    L85:
        r110 = "load_other_tab";
        goto L86
    L80:
        if (r22.a != 1) goto L82;
    L100:
        return;
    }

    public final void fillTrackParams(TrackParams r1) {
        com.larus.trace.tracknode.a.a.a(this, r1);
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        if (((Boolean) this.l.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r10 = false;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        Bundle r1 = getArguments();     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        int r2 = r1.getInt("position");     // Catch: Throwable -> L14
    L12:
        this.v = r2;     // Catch: Throwable -> L14
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L19;
        com.larus.platform.service.g.a.ensureNotReachHere(r4, "position: " + this.v);
    L19:
        Bundle r5 = getArguments();
        if (r5 == null) goto L22;
        r10 = r5.getBoolean("has_creation_button", false);
    L22:
        this.x = r10;
        Y90().getRefreshData().observe(this, new c(new o0(this)));
        Y90().getLoadMoreData().observe(this, new c(new y(this)));
        Y90().getBannerData().observe(this, new c(new z(this)));
        ((BotDiscoverModel) this.h.getValue()).getRefreshData().observe(this, new c(new a0(this)));
        List<zp9.w> r11 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass7(this, null), 2, null);
        ic8.o0 r6 = (ic8.o0) ((BotDiscoverModel) this.h.getValue()).getRefreshData().getValue();
        if (r6 == null) goto L25;
        r11 = r6.e();
    L25:
        ca0(r11);
        return;
    L11:
        r2 = 0;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (Intrinsics.areEqual(X90().a, getLifecycle()) == true) goto L7;
        BotDiscoverListHeaderAdapter r12 = X90();
        Lifecycle r8 = getLifecycle();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r12.a = r8;
        goto L7
    }

    public final void setUserVisibleHint(boolean r6) {
        boolean r0 = getUserVisibleHint();
        super.setUserVisibleHint(r6);
        if (r0 != getUserVisibleHint()) goto L6;
        return;
    L6:
        if (getUserVisibleHint() == false) goto L10;
        long r1 = SystemClock.elapsedRealtime() - this.w;
        FLogger r7 = FLogger.a;
        StringBuilder r2 = new StringBuilder("back to discover fragment, interval = ");
        long r3 = r1 / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        r2.append(r3);
        r2.append('s');
        r7.d("BotDiscoveryListFragment", r2.toString());
        if (r3 <= ((Number) this.n.getValue()).intValue()) goto L12;
        ba0();
        return;
    L12:
        return;
    L10:
        this.w = SystemClock.elapsedRealtime();
    }

    public static final void T90(BotDiscoverListFragment r23, RecommendBot r24) {
        Bundle r1 = r23.getArguments();
        if (r1 == null) goto L5;
        String r2 = r1.getString("previous_page", "");
    L6:
        JSONObject r3 = IAIChatControlTraceService.a.Xb(r24.a);
        r24.I0(String.valueOf(r23.v)).a(r3);
        String r5 = r24.o();
        String r19 = r24.o();
        String r6 = r23.W90(r24);
        String r10 = IAIChatService.a.j8().a(r24);
        zp9.w r0 = r23.Y90().getTabTag();
        if (r0 == null) goto L9;
        String r8 = r0.b;
    L11:
        if (com.larus.utils.o0.d(r2) == false) goto L13;
        String r11 = r2;
    L14:
        e1.a(r5, r6, "bot_discover", r8, "click_plus", r10, r11, null, null, null, null, null, null, "private", r19, r3, r23, 523793);
        return;
    L13:
        r11 = null;
        goto L14
    L9:
        r8 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static final void U90(BotDiscoverListFragment r18, RecommendBot r19) {
        if (AudioServiceDelegate.a.B(r19.o(), r19.r(), r19.c0()) == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        String r14 = "1";
    L10:
        String r3 = r19.o();
        if (com.larus.utils.o0.d(r19.e()) == false) goto L13;
        String r6 = "1";
    L14:
        RecommendFrom r1 = r19.a;
        if (r1 == null) goto L17;
        String r10 = r1.b;
    L18:
        if (r1 == null) goto L20;
        String r9 = r1.a;
    L21:
        w3.a(r3, "click_check", null, r6, null, null, r9, r10, null, null, null, r14, null, r18, 113908);
        return;
    L20:
        r9 = null;
        goto L21
    L17:
        r10 = null;
        goto L18
    L13:
        r6 = TriggerSendLoading.NO_LOADING;
        goto L14
    L9:
        r14 = TriggerSendLoading.NO_LOADING;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        LarusPageBotDiscoverListBinding r11 = this.e;
        LifecycleOwner r0 = null;
        if (r11 == null) goto L28;
        final RecyclerView r1 = r11.b;
        r1.addOnScrollListener(new BotDiscoverListFragment$setupRecyclerView$1$1$1(this));
        r11.b.setItemAnimator(null);
        if (z2.a.C0() == false) goto L18;
        Context r2 = r1.getContext();
        float r4 = 200.0f;
        if (r2 == null) goto L9;
        float r3 = com.larus.utils.i.d(r2);
    L10:
        Context r5 = r1.getContext();
        if (r5 == null) goto L14;
        r4 = c7.d(Integer.valueOf(com.larus.utils.i.d(r5)));
    L14:
        if (r4 <= 573.0f) goto L16;
        int r6 = 3;
    L17:
        int r7 = ((int) (r3 - (r1.getResources().getDimension(v19.c.b(2130971243, null, 2131166855)) * r6))) / 2;
        r1.setLayoutManager(new FastScrollGridLayoutManager(r1.getContext(), r6));
        r1.addItemDecoration(new BotDiscoverListFragment$setupRecyclerView$1$1$2(r1));
        r11.b.setBackground(ContextCompat.getDrawable(r1.getContext(), 2131243582));
        r11.b.setPadding(r7, 0, r7, 0);
    L19:
        r1.setAdapter(new ConcatAdapter(new RecyclerView.Adapter[]{X90(), Z90()}));
        r1.setHasFixedSize(true);
        r1.addOnScrollListener(new BotDiscoverListFragment$setupRecyclerView$1$1$4(this));
        Intrinsics.checkNotNull(r1);
        y6.f(r1, new b0(this), new c0(this), 0.1f, new d0(this), 49);
        Z90().f = new BotDiscoverListFragment$setupRecyclerView$1$2(this);
        r11.d.setOnRefreshListener(new e0(this));
        com.larus.utils.e1.d(r11.c, new n0(this));
        if (this.r == false) goto L27;
        LarusPageBotDiscoverListBinding r12 = this.e;
        if (r12 == null) goto L26;
        BlockBringChildSwipeRefreshLayout r13 = r12.d;
        if (r13 == null) goto L26;
        r13.setRefreshing(true);
    L26:
        aa0("refresh");
        this.r = false;
    L27:
        Unit r14 = Unit.INSTANCE;
        goto L28
    L16:
        r6 = 2;
        goto L17
    L9:
        r3 = 200.0f;
        goto L10
    L18:
        r1.setLayoutManager(new FastScrollLayoutManager(r1.getContext()));
        r1.addItemDecoration(new BotDiscoverListFragment$setupRecyclerView$1$1$3(this, r1));
    L28:
        this.u = false;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(Y90().getFilterAddedBotsFlow(), new BotDiscoverListFragment$initViewModel$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        Fragment r15 = getParentFragment();
        if (r15 == null) goto L31;
        r0 = r15.getViewLifecycleOwner();
    L31:
        if (r0 == null) goto L33;
        AccountService.a.A().observe(r0, this.y);
    L34:
        boolean r16 = HomeService.a.o();
        BotDiscoverListModel r17 = Y90();
        if (r16 == false) goto L37;
        DowngradeSource r18 = DowngradeSource.ENTER_PAGE;
    L38:
        r17.requestBannerData(r18);
        ((com.larus.im.service.q) this.k.getValue()).registerConversationChangeListener(this.p);
        return;
    L37:
        r18 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L38
    L33:
        AccountService.a.A().observeForever(this.y);
        goto L34
    }

    public static final Object S90(BotDiscoverListFragment r8, RecommendBot r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof BotDiscoverListFragment$checkAndCreateConversation$1) == false) goto L7;
        BotDiscoverListFragment$checkAndCreateConversation$1 r0 = (BotDiscoverListFragment$checkAndCreateConversation$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r5 = true;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        String r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r13 = (String) r0.L$1;
        RecommendBot r4 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L32:
        wc9.e r14 = (wc9.e) r11;
        if (r14 == null) goto L40;
        Integer r15 = r14.f;
        if (r15 == null) goto L40;
        if (r15.intValue() != 1) goto L40;
    L41:
        if (r5 == false) goto L46;
        BotDiscoverListModel r16 = r8.Y90();
        r0.L$0 = r13;
        r0.L$1 = null;
        r0.label = 3;
        if (r16.updateLocalConversationFirstMet(r13, r4, r0) != r2) goto L46;
        return r2;
    L46:
        return r13;
    L40:
        r5 = false;
        goto L41
    L17:
        r9 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L24:
        String r17 = (String) r11;
    L25:
        BotDiscoverListModel r6 = r8.Y90();
        String r7 = r9.o();
        if (r7 != null) goto L28;
        r7 = "";
    L28:
        r0.L$0 = r9;
        r0.L$1 = r17;
        r0.label = 2;
        Object r18 = r6.findConversationByBot(r7, r0);
        if (r18 == r2) goto L49;
        r4 = r9;
        r13 = r17;
        r11 = r18;
        goto L32
    L49:
        return r2;
    L18:
        ResultKt.throwOnFailure(r11);
        if (com.larus.utils.o0.d(r9.E()) == false) goto L21;
        r17 = r9.E();
        goto L25
    L21:
        BotDiscoverListModel r19 = r8.Y90();
        r0.L$0 = r9;
        r0.label = 1;
        r11 = r19.createLocalConversation(r9, r0);
        if (r11 != r2) goto L24;
        return r2;
    L7:
        r0 = new BotDiscoverListFragment$checkAndCreateConversation$1(r8, r10);
        goto L8
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = getLayoutInflater().inflate(2131563001, r8, false);
        ConstraintLayout r11 = r10;
        int r0 = 2131384076;
        RecyclerView r2 = ViewBindings.findChildViewById(r10, 2131384076);
        if (r2 == null) goto L18;
        r0 = 2131384140;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131384140);
        if (r3 == null) goto L18;
        r0 = 2131384141;
        BlockBringChildSwipeRefreshLayout r4 = (BlockBringChildSwipeRefreshLayout) ViewBindings.findChildViewById(r10, 2131384141);
        if (r4 == null) goto L18;
        r0 = 2131384145;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131384145)) == null) goto L18;
        this.e = new LarusPageBotDiscoverListBinding(r11, r2, r3, r4);
        r4.setColorSchemeColors(new int[]{ContextCompat.getColor(r7.getContext(), 2131103203)});
        r4.setProgressViewOffset(false, (-i5.b()) + r4.getProgressViewStartOffset(), r4.getProgressViewEndOffset() + r4.getProgressViewStartOffset());
        LarusPageBotDiscoverListBinding r12 = this.e;
        if (r12 == null) goto L15;
        ConstraintLayout r13 = r12.a;
        if (r13 == null) goto L15;
        r13.setTag(2131377847, this);
        return r13;
    L15:
        return null;
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
