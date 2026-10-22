package com.larus.bmhome.chat.cotdetail.component;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cotdetail.ability.CotDetailPageState;
import com.larus.bmhome.chat.cotdetail.list.ThreadMsgAdapter;
import com.larus.bmhome.interactionpanel.f1;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadData;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusPageCotDetailBinding;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 a2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010@\u001a\u00020?H\u0016J\u0010\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020?H\u0002J\b\u0010E\u001a\u00020?H\u0002J\b\u0010F\u001a\u00020?H\u0002J\u0016\u0010G\u001a\u0002062\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0=H\u0002J&\u0010J\u001a\b\u0012\u0004\u0012\u00020I0=2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020>0=2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010L\u001a\u0004\u0018\u0001092\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0=H\u0002J\b\u0010M\u001a\u00020?H\u0002J\b\u0010N\u001a\u00020?H\u0002J\u0016\u0010O\u001a\u00020?2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\u0010\u0010P\u001a\u00020?2\u0006\u0010Q\u001a\u000209H\u0002J\u0012\u0010R\u001a\u00020?2\b\b\u0002\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u000206H\u0002J\b\u0010W\u001a\u00020?H\u0016J\u0010\u0010X\u001a\u00020?2\u0006\u0010V\u001a\u000206H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016J\"\u0010[\u001a\u00020?2\u0018\u0010\\\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=\u0012\u0004\u0012\u00020?0<H\u0016J\"\u0010]\u001a\u00020?2\u0018\u0010\\\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=\u0012\u0004\u0012\u00020?0<H\u0016J\u0016\u0010^\u001a\u00020?2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\b\u0010`\u001a\u00020?H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010:\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=\u0012\u0004\u0012\u00020?0<0;X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailMessageListComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "<init>", "()V", "cotDetailFragmentAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "getCotDetailFragmentAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "cotDetailFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "binding$delegate", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "getGlobalConfig", "()Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "globalConfig$delegate", "spacing", "", "getSpacing", "()I", "setSpacing", "(I)V", "threadData", "Lcom/larus/im/bean/thread/ThreadData;", "pageExceptionComponent", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailPageExceptionAbility;", "getPageExceptionComponent", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailPageExceptionAbility;", "pageExceptionComponent$delegate", "titleComponent", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailTitleAbility;", "getTitleComponent", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailTitleAbility;", "titleComponent$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "mAdapter", "Lcom/larus/bmhome/chat/cotdetail/list/ThreadMsgAdapter;", "viewModel", "Lcom/larus/bmhome/chat/cotdetail/component/CotDetailListViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/cotdetail/component/CotDetailListViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "isUserTouch", "", "isTouchingMessageList", "lastAutoScrolledLoadingUserKey", "", "messageSnapshotListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function1;", "", "Lcom/larus/im/bean/message/Message;", "", "onAttach", "onViewCreated", "view", "Landroid/view/View;", "setupImeInsetFollowBottom", "initMessageListItemDecoration", "observeViewModel", "hasLatestBotContent", "stateList", "Lcom/larus/bmhome/chat/cotdetail/list/cellstate/base/ThreadMsgCellState;", "processMessageCellStateList", "msgList", "getLoadingUserKey", "setUpRecyclerView", "updateRecyclerView", "markCotMessageFoldStatus", "pullThreadMessageList", "threadId", "smoothScrollToBottom", "durationMs", "", "interruptThreadMessage", "interruptServer", "onRefresh", "interruptMessage", "currentThreadData", "currentMessages", "addThreadMessageSnapshotListener", "listener", "removeThreadMessageSnapshotListener", "notifyThreadMessageSnapshotChanged", "messages", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailMessageListComponent extends BaseContentWidget implements fe8.c {
    public static final /* synthetic */ int A = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final int p;
    public ThreadData q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final ThreadMsgAdapter u;
    public final com.larus.ui.arch.vm.internal.l v;
    public boolean w;
    public boolean x;
    public String y;
    public final CopyOnWriteArraySet<Function1<List<Message>, Unit>> z;

    public static final class a {
    }

    public static final class b implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final RecyclerView Y2() {
        return (RecyclerView) this.t.getValue();
    }

    public final CotDetailListViewModel h3() {
        return (CotDetailListViewModel) this.v.getValue();
    }

    public final void onDestroy() {
        this.z.clear();
        h3().clear();
        ExposureTrackerExtKt.d(getContext());
        ExposeXTrackerExtKt.d(getContext());
        Map<String, Boolean> r0 = ge8.a.a;
        ((LinkedHashMap) ge8.a.a).clear();
    }

    @Override // fe8.c
    public final void onRefresh() {
        fe8.d r0 = (fe8.d) this.r.getValue();
        if (r0 == null) goto L5;
        r0.OT(CotDetailPageState.Loading);
    L5:
        fe8.a r1 = (fe8.a) this.m.getValue();
        if (r1 == null) goto L9;
        r1.RG(new a0(this));
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fe8.c.class);
    }

    public CotDetailMessageListComponent() {
        this.m = LazyKt.lazy(new u(this));
        this.n = LazyKt.lazy(new v(this));
        this.o = LazyKt.lazy(new w(this));
        this.p = AppHost.a.getApplication().getResources().getDimensionPixelSize(2131167567);
        this.r = LazyKt.lazy(new x(this));
        this.s = LazyKt.lazy(new y(this));
        this.t = LazyKt.lazy(new z(this));
        this.u = new ThreadMsgAdapter();
        this.v = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CotDetailListViewModel.class), Reflection.getOrCreateKotlinClass(CotDetailListComponentState.class), new b(this), new c(this), d.a);
        this.z = new CopyOnWriteArraySet();
    }

    @Override // fe8.c
    public final List<Message> nL() {
        return h3().getMessageList();
    }

    @Override // fe8.c
    public final ThreadData VE() {
        return this.q;
    }

    public static void m3(CotDetailMessageListComponent r4) {
        r4.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        RecyclerView r1 = r4.Y2();     // Catch: Throwable -> L17
        if (r1 == null) goto L25;
        LinearLayoutManager r2 = r1.getLayoutManager();     // Catch: Throwable -> L17
        if ((r2 instanceof LinearLayoutManager) == false) goto L9;
        LinearLayoutManager r3 = r2;     // Catch: Throwable -> L17
    L10:
        if (r3 != null) goto L13;
        return;
    L13:
        if (r4.u.getItemCount() == 0) goto L27;
        final Context r5 = r1.getContext();     // Catch: Throwable -> L17
        final long r6 = 120;
        LinearSmoothScroller r7 = new CotDetailMessageListComponent$smoothScrollToBottom$1$scroller$1(r6, r5);     // Catch: Throwable -> L17
        r7.setTargetPosition(0);     // Catch: Throwable -> L17
        r3.startSmoothScroll(r7);     // Catch: Throwable -> L17
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L28;
        FLogger.a.i("CotDetailMessageListComponent", r9.toString());
        return;
    L28:
        return;
    L27:
        return;
    L9:
        r3 = null;
        goto L10
    L25:
        return;
    L17:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // fe8.c
    public final void KG(Function1<? super List<Message>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.z.remove(r2);
    }

    @Override // fe8.c
    public final void ZF(boolean r5) {
        com.larus.im.service.x.a.getClass();
        com.larus.im.service.x r0 = com.larus.im.service.x.a.a();
        ThreadData r1 = this.q;
        if (r1 == null) goto L5;
        String r2 = r1.getThreadId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.b(r2, h3().getMessageList(), r5, new b0());
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // fe8.c
    public final void al(f1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.z.add(r2);
        r2.invoke(nL());
    }

    public final void onViewCreated(View r18) {
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r18, "view");
        LinearLayoutManager r1 = new LinearLayoutManager(getContext());
        r1.setReverseLayout(true);
        r1.setStackFromEnd(true);
        RecyclerView r2 = Y2();
        if (r2 == null) goto L5;
        r2.setLayoutManager(r1);
        r2.setItemAnimator(null);
        r2.setAdapter(this.u);
        this.u.a = r2;
        ExposureTrackerExtKt.b(r2);
    L5:
        RecyclerView r3 = Y2();
        if (r3 == null) goto L8;
        r3.addOnScrollListener(new CotDetailMessageListComponent$setUpRecyclerView$2(this));
    L8:
        RecyclerView r4 = Y2();
        if (r4 == null) goto L11;
        r4.addOnItemTouchListener(new CotDetailMessageListComponent$setUpRecyclerView$3(this));
    L11:
        LarusPageCotDetailBinding r5 = (LarusPageCotDetailBinding) this.n.getValue();
        if (r5 == null) goto L16;
        ChatConstraintLayout r6 = r5.d;
        if (r6 == null) goto L16;
        r6.setOnBottomInsetUpdateListener(new e0(this));
    L16:
        ComponentViewModel.onEach$default(h3(), CotDetailMessageListComponent$observeViewModel$1.INSTANCE, null, new CotDetailMessageListComponent$observeViewModel$2(this, null), 2, null);
        ComponentViewModel.onEach$default(h3(), CotDetailMessageListComponent$observeViewModel$3.INSTANCE, CotDetailMessageListComponent$observeViewModel$4.INSTANCE, null, new CotDetailMessageListComponent$observeViewModel$5(this, null), 4, null);
        fe8.d r7 = (fe8.d) this.r.getValue();
        if (r7 == null) goto L19;
        r7.OT(CotDetailPageState.Loading);
    L19:
        fe8.a r8 = (fe8.a) this.m.getValue();
        if (r8 == null) goto L22;
        r8.RG(new a0(this));
    L22:
        RecyclerView.ItemDecoration r9 = new CotDetailMessageListComponent$initMessageListItemDecoration$itemDecoration$1(this);
        RecyclerView r10 = Y2();
        if (r10 == null) goto L26;
        r10.addItemDecoration(r9);
        return;
    }
}
