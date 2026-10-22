package com.obric.assistant.component;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0003.14\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0016J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u000209H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0002J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u000209H\u0002J\b\u0010N\u001a\u000209H\u0002J\b\u0010O\u001a\u000209H\u0002J\b\u0010P\u001a\u000209H\u0002J\u0014\u0010Q\u001a\u0002092\n\u0010R\u001a\u0006\u0012\u0002\b\u00030'H\u0002J\u0014\u0010S\u001a\u0002092\n\u0010R\u001a\u0006\u0012\u0002\b\u00030'H\u0002J\n\u0010T\u001a\u0004\u0018\u00010%H\u0002J\u000e\u0010U\u001a\b\u0012\u0002\b\u0003\u0018\u00010'H\u0002J\u0018\u0010V\u001a\u00020F2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\f\u0012\b\u0012\u00060!R\u00020\u00000 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/assistant/component/ObricMessageVisibilityComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/IObricMessageVisibilityAbility;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "subscriptions", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$SubscriptionState;", "subscriptionIdGenerator", "Ljava/util/concurrent/atomic/AtomicLong;", "observedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "observedAdapter", "Lcom/larus/bmhome/chat/adapter/IMessageListAdapter;", "dispatchPosted", "", "listObserver", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingDataSourceObserver;", "Lcom/larus/bmhome/chat/bean/IMessageProvider;", "pageStateCallback", "com/obric/assistant/component/ObricMessageVisibilityComponent$pageStateCallback$1", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$pageStateCallback$1;", "scrollListener", "com/obric/assistant/component/ObricMessageVisibilityComponent$scrollListener$1", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$scrollListener$1;", "childAttachListener", "com/obric/assistant/component/ObricMessageVisibilityComponent$childAttachListener$1", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$childAttachListener$1;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onParentViewCreated", "", "onResume", "onPause", "onStop", "onDestroy", "observeMessageVisibility", "Lcom/obric/assistant/ability/ObricMessageVisibilitySubscription;", "config", "Lcom/obric/assistant/ability/ObricMessageVisibilityConfig;", "listener", "Lcom/obric/assistant/ability/ObricMessageVisibilityListener;", "scheduleVisibilityDispatch", WindowEvent.Params.REASON, "", "dispatchVisibility", "flushVisibleMessages", "collectVisibleMessageSnapshots", "", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$VisibleMessageSnapshot;", "isPageActuallyVisible", "ensureRecyclerViewObserver", "removeRecyclerViewObserver", "ensureAdapterObserver", "removeAdapterObserver", "registerAdapterObserver", "adapter", "unregisterAdapterObserver", "getMessageListView", "getMessageListAdapter", "buildMessageKey", "message", "Lcom/larus/im/bean/message/Message;", "position", "", "Companion", "SubscriptionState", "VisibleRecord", "VisibleMessageSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMessageVisibilityComponent extends ComponentFeature implements laa.g {
    public static final /* synthetic */ int w = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final CopyOnWriteArrayList<b> m;
    public final AtomicLong n;
    public RecyclerView o;
    public com.larus.bmhome.chat.adapter.i<?> p;
    public boolean q;
    public final z2 r;
    public final e s;
    public final ObricMessageVisibilityComponent$scrollListener$1 t;
    public final ObricMessageVisibilityComponent$childAttachListener$1 u;
    public final a3 v;

    public static final class a {
    }

    public final class b {
        public final long a;
        public final laa.o b;
        public final laa.q c;
        public final LinkedHashMap<String, d> d;
        public final /* synthetic */ ObricMessageVisibilityComponent e;

        public final void a() {
            Iterator<T> r0 = this.d.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Job r1 = ((d) r0.next()).c;
            if (r1 == null) goto L4;
            Job.DefaultImpls.cancel$default(r1, null, 1, null);
            goto L4
        L8:
            this.d.clear();
        }

        public final void b(String r3) {
            Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
            Iterator r0 = CollectionsKt.toList(this.d.keySet()).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            String r1 = (String) r0.next();
            Intrinsics.checkNotNull(r1);
            c(r1, r3);
            goto L4
        }

        public final void c(String r4, final String r5) {
            final d r6 = this.d.remove(r4);
            if (r6 != null) goto L5;
            return;
        L5:
            Job r0 = r6.c;
            if (r0 == null) goto L8;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L8:
            d("onMessageHidden", new c3(this, r6, r5));
        }

        public final void d(String r5, Function0<Unit> r6) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Object r7 = Result.constructor-impl(r6.invoke());     // Catch: Throwable -> L4
        L6:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L12;
            FLogger.a.e("ObricMessageVisibility", r5 + " failed, subscriptionId=" + this.a, r8);
            return;
        L12:
            return;
        L4:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L6
        }

        public b(ObricMessageVisibilityComponent r2, long r3, laa.o r5, ComplexTaskCompletedIslandVisibilityComponent.b r6) {
            Intrinsics.checkNotNullParameter(r5, "config");
            Intrinsics.checkNotNullParameter(r6, "listener");
            this.e = r2;
            this.a = r3;
            this.b = r5;
            this.c = r6;
            this.d = new LinkedHashMap();
        }
    }

    public static final class c {
        public final Message a;
        public final String b;
        public final int c;
        public final float d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "VisibleMessageSnapshot(message=" + this.a + ", messageKey=" + this.b + ", position=" + this.c + ", visibleRatio=" + this.d + ')';
        }

        public final laa.p a(long r10, String r12) {
            Intrinsics.checkNotNullParameter(r12, WindowEvent.Params.REASON);
            return new laa.p(this.a, this.b, this.c, this.d, SystemClock.elapsedRealtime() - r10, r12);
        }

        public c(Message r2, String r3, int r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "messageKey");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class d {
        public c a;
        public final long b;
        public Job c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L8;
            return false;
        L8:
            d r9 = (d) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            Job r3 = this.c;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "VisibleRecord(snapshot=" + this.a + ", firstShownAtMs=" + this.b + ", visibleForJob=" + this.c + ')';
        }

        public d(c r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            this.a = r2;
            this.b = r3;
            this.c = null;
        }
    }

    public static final class e implements hca.b {
        public final /* synthetic */ ObricMessageVisibilityComponent a;

        public e(ObricMessageVisibilityComponent r1) {
            this.a = r1;
        }

        public final void r2(boolean r2) {
            if (r2 == false) goto L4;
            ObricMessageVisibilityComponent r3 = this.a;
            int r0 = ObricMessageVisibilityComponent.w;
            r3.N2("page_change_to_chat_window");
            return;
        L4:
            ObricMessageVisibilityComponent r4 = this.a;
            int r1 = ObricMessageVisibilityComponent.w;
            r4.Y2("chat_style_changed");
        }

        public final void x1(ObricFloatChatPageState r2) {
            Intrinsics.checkNotNullParameter(r2, "pageState");
            ObricFloatChatPageData.Companion.getClass();
            if (ObricFloatChatPageData.a.d(r2) == false) goto L5;
            ObricMessageVisibilityComponent r3 = this.a;
            int r0 = ObricMessageVisibilityComponent.w;
            r3.Y2("page_visible");
            return;
        L5:
            ObricMessageVisibilityComponent r4 = this.a;
            int r1 = ObricMessageVisibilityComponent.w;
            r4.N2("page_invisible");
        }
    }

    public static final class f implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class g implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class h implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class i implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    static {
    }

    public final RecyclerView Ly() {
        laa.d r0 = (laa.d) this.k.getValue();
        if (r0 == null) goto L6;
        RecyclerView r1 = r0.Xw();
        if (r1 == null) goto L6;
        return r1;
    L6:
        va8.l r2 = (va8.l) this.l.getValue();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getMessageList();
    }

    public final com.larus.bmhome.chat.adapter.i<?> P2() {
        u7 r0 = (va8.p) this.i.getValue();
        if ((r0 instanceof u7) == false) goto L5;
        u7 r1 = r0;
    L6:
        if (r1 == null) goto L8;
        MessageAdapter r2 = r1.MF();
    L10:
        if ((r2 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L21;
        u7 r3 = (u7) this.j.getValue();
        if (r3 == null) goto L17;
        r2 = r3.MF();
    L19:
        if ((r2 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L21;
        return null;
    L17:
        r2 = null;
    L21:
        return r2;
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void X2() {
        RecyclerView r0 = this.o;
        if (r0 == null) goto L5;
        r0.removeOnScrollListener(this.t);
    L5:
        RecyclerView r1 = this.o;
        if (r1 == null) goto L8;
        r1.removeOnChildAttachStateChangeListener(this.u);
    L8:
        RecyclerView r2 = this.o;
        if (r2 == null) goto L11;
        r2.removeOnLayoutChangeListener(this.v);
    L11:
        this.o = null;
    }

    public final void onDestroy() {
        N2("component_destroy");
        laa.d r0 = (laa.d) this.k.getValue();
        if (r0 == null) goto L5;
        r0.AN(this.s);
    L5:
        X2();
        com.larus.bmhome.chat.adapter.i<?> r1 = this.p;
        if (r1 == null) goto L8;
        r1.r1(this.r);
    L8:
        this.p = null;
        Iterator<b> r2 = this.m.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r2.next().a();
        goto L10
    L12:
        this.m.clear();
    }

    public final void onPause() {
        N2("component_pause");
    }

    public final void onResume() {
        Y2("component_resume");
    }

    public final void onStop() {
        N2("component_stop");
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.assistant.component.z2] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.obric.assistant.component.ObricMessageVisibilityComponent$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.obric.assistant.component.ObricMessageVisibilityComponent$childAttachListener$1] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.component.a3] */
    public ObricMessageVisibilityComponent() {
        this.h = LazyKt.lazy(new f(this));
        this.i = LazyKt.lazy(new g(this));
        this.j = LazyKt.lazy(new h(this));
        this.k = LazyKt.lazy(new i(this));
        this.l = LazyKt.lazy(new y2(this));
        this.m = new CopyOnWriteArrayList();
        this.n = new AtomicLong(0);
        this.r = new z2(this);
        this.s = new e(this);
        this.t = new ObricMessageVisibilityComponent$scrollListener$1(this);
        this.u = new ObricMessageVisibilityComponent$childAttachListener$1(this);
        this.v = new a3(this);
    }

    public final void B2() {
        L2();
        MessageAdapter r0 = P2();
        if (r0 == null) goto L11;
        MessageAdapter r1 = this.p;
        if (r1 == r0) goto L11;
        if (r1 == null) goto L10;
        r1.r1(this.r);
    L10:
        this.p = r0;
        MessageAdapter r2 = r0;
        r2.p1(this.r);
    L11:
        laa.d r3 = (laa.d) this.k.getValue();
        if (r3 == null) goto L14;
        r3.HU(this.s);
    L14:
        Y2("parent_view_created");
    }

    public final void L2() {
        RecyclerView r0 = Ly();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.o != r0) goto L8;
        return;
    L8:
        X2();
        this.o = r0;
        r0.addOnScrollListener(this.t);
        r0.addOnChildAttachStateChangeListener(this.u);
        r0.addOnLayoutChangeListener(this.v);
    }

    public final boolean U2() {
        RecyclerView r0 = Ly();
        if (r0 != null) goto L5;
        return false;
    L5:
        Rect r2 = new Rect();
        if (((BaseComponentFeatureInternal) this).a.getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L28;
        laa.d r3 = (laa.d) this.k.getValue();
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L15;
        return false;
    L15:
        if (r0.isAttachedToWindow() == true) goto L17;
        return false;
    L17:
        if (r0.isShown() == true) goto L19;
        return false;
    L19:
        if (r0.getAlpha() > 0.0f) goto L21;
        return false;
    L21:
        if (r0.getGlobalVisibleRect(r2) == true) goto L23;
        return false;
    L23:
        if (r2.height() > 0) goto L25;
        return false;
    L25:
        if (r2.width() <= 0) goto L35;
        return true;
    L35:
        return false;
    L10:
        if (r3.isVisible() != true) goto L12;
        r4 = true;
        goto L13
    L28:
        return false;
    }

    public final void N2(String r3) {
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).b(r3);
        goto L4
    }

    public final void Y2(String r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1(this, r7, null), 2, null);
    }

    public static final void F2(ObricMessageVisibilityComponent r24, final String r25) {
        if (r24.m.isEmpty() == false) goto L6;
        return;
    L6:
        if (r24.U2() == true) goto L8;
        r24.N2(r25);
        return;
    L8:
        RecyclerView r1 = r24.Ly();
        if (r1 != null) goto L12;
        List r2 = CollectionsKt.emptyList();
    L11:
        List r9 = r2;
        Iterator<b> r10 = r24.m.iterator();
    L117:
        if (r10.hasNext() == false) goto L179;
        b r15 = r10.next();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r9, "snapshots");
        Intrinsics.checkNotNullParameter(r25, WindowEvent.Params.REASON);
        ArrayList r3 = new ArrayList();
        Iterator r0 = r9.iterator();
    L120:
        if (r0.hasNext() == false) goto L127;
        Object r4 = r0.next();
        if (((c) r4).d < r15.b.a) goto L124;
        boolean r5 = true;
    L125:
        if (r5 == false) goto L120;
        r3.add(r4);
        goto L120
    L124:
        r5 = false;
        goto L125
    L127:
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator r7 = r3.iterator();
    L129:
        if (r7.hasNext() == false) goto L131;
        Object r8 = r7.next();
        r6.put(((c) r8).b, r8);
        goto L129
    L131:
        Set<String> r11 = r15.d.keySet();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L133:
        if (r13.hasNext() == false) goto L137;
        Object r14 = r13.next();
        if ((!r6.keySet().contains((String) r14)) == false) goto L133;
        r12.add(r14);
        goto L133
    L137:
        Iterator r16 = r12.iterator();
    L139:
        if (r16.hasNext() == false) goto L141;
        String r17 = (String) r16.next();
        Intrinsics.checkNotNull(r17);
        r15.c(r17, r25);
        goto L139
    L141:
        Iterator r18 = r6.values().iterator();
    L143:
        if (r18.hasNext() == false) goto L117;
        final c r19 = (c) r18.next();
        d r20 = r15.d.get(r19.b);
        if (r20 == null) goto L146;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r20.a = r19;
        goto L143
    L146:
        final long r21 = SystemClock.elapsedRealtime();
        d r110 = new d(r19, r21);
        r15.d.put(r19.b, r110);
        final b r22 = r15;
        r15.d("onMessageShown", new d3(r22, r19, r21, r25));
        Long r111 = r15.b.b;
        if (r111 == null) goto L143;
        if (r111.longValue() < 0) goto L143;
        r110.c = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r15.e), Dispatchers.getMain(), null, new ObricMessageVisibilityComponent$SubscriptionState$showRecord$2(r111, r15, r19, r15.e, null), 2, null);
        r15 = r15;
        goto L143
    L179:
        return;
    L12:
        LinearLayoutManager r23 = r1.getLayoutManager();
        if ((r23 instanceof LinearLayoutManager) == false) goto L15;
        LinearLayoutManager r26 = r23;
    L16:
        if (r26 != null) goto L18;
        r2 = CollectionsKt.emptyList();
        goto L11
    L18:
        MessageAdapter r27 = r24.P2();
        if (r27 == null) goto L114;
        List r28 = r27.z2();
        if (r28 == null) goto L114;
        int r29 = r26.findFirstVisibleItemPosition();
        int r30 = r26.findLastVisibleItemPosition();
        if (r29 == (-1)) goto L113;
        if (r30 == (-1)) goto L113;
        if (r29 > r30) goto L113;
        LinkedHashMap r31 = new LinkedHashMap();
        if (r29 > r30) goto L112;
    L30:
        ic8.v r32 = (ic8.v) CollectionsKt.getOrNull(r28, r29);
        if (r32 == null) goto L110;
        Message r33 = r32.a();
        if (r33 == null) goto L110;
        if (com.larus.bmhome.chat.bean.d.i0(r33) == false) goto L41;
        if (com.larus.bmhome.chat.bean.d.w(r33) == true) goto L41;
    L60:
        boolean r112 = false;
    L61:
        if (r112 == false) goto L110;
        View r113 = r26.findViewByPosition(r29);
        if (r113 == null) goto L110;
        Rect r114 = new Rect();
        if (r113.isAttachedToWindow() == true) goto L69;
    L79:
        boolean r115 = false;
    L80:
        if (r115 == false) goto L110;
        float r116 = RangesKt.coerceIn(r114.height() / RangesKt.coerceAtLeast(r113.getHeight(), 1.0f), 0.0f, 1.0f);
        String r117 = r33.getMessageId();
        String r118 = "";
        if (r117 != null) goto L86;
        r117 = "";
    L86:
        if (r117.length() <= 0) goto L88;
        boolean r119 = true;
    L89:
        if (r119 == true) goto L105;
        r117 = r33.getLocalMessageId();
        if (r117 != null) goto L95;
        r117 = "";
    L95:
        if (r117.length() <= 0) goto L97;
        boolean r120 = true;
    L98:
        if (r120 == true) goto L105;
        StringBuilder r121 = new StringBuilder();
        String r122 = r33.getConversationId();
        if (r122 == null) goto L104;
        r118 = r122;
    L104:
        r121.append(r118);
        r121.append('_');
        r121.append(r33.getContentType());
        r121.append('_');
        r121.append(r29);
        r117 = r121.toString();
        goto L105
    L97:
        r120 = false;
    L105:
        c r123 = new c(r33, r117, r29, r116);
        c r34 = (c) r31.get(r117);
        if (r34 != null) goto L108;
    L109:
        r31.put(r117, r123);
        goto L110
    L108:
        if (r34.d >= r116) goto L110;
    L88:
        r119 = false;
        goto L89
    L69:
        if (r113.isShown() == false) goto L79;
        if (r113.getAlpha() <= 0.0f) goto L79;
        if (r113.getGlobalVisibleRect(r114) == false) goto L79;
        if (r114.height() <= 0) goto L79;
        if (r114.width() <= 0) goto L79;
        r115 = true;
    L41:
        if (com.larus.bmhome.chat.bean.d.T(r33) == true) goto L60;
        if (com.larus.bmhome.chat.bean.d.p0(r33) == true) goto L60;
        if (com.larus.bmhome.chat.bean.d.C0(r33) == true) goto L48;
    L50:
        MessageStatus r124 = r33.getMessageStatus();
        if (r124 != null) goto L53;
    L55:
        boolean r125 = false;
    L56:
        if (r125 == false) goto L58;
    L59:
        r112 = true;
        goto L61
    L58:
        if (com.larus.bmhome.social.userchat.model.b0.f(r33) == false) goto L60;
    L53:
        if (r124.isVisible() != true) goto L55;
        r125 = true;
        goto L56
    L48:
        if (r33.getRegenVisible() == true) goto L50;
    L110:
        if (r29 == r30) goto L112;
        r29 = r29 + 1;
    L112:
        r2 = CollectionsKt.toList(r31.values());
    L113:
        r2 = CollectionsKt.emptyList();
    L114:
        r2 = CollectionsKt.emptyList();
        goto L11
    L15:
        r26 = null;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [com.obric.assistant.component.ObricMessageVisibilityComponent$observeMessageVisibility$1] */
    public final ObricMessageVisibilityComponent$observeMessageVisibility$1 tt(laa.o r8, ComplexTaskCompletedIslandVisibilityComponent.b r9) {
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "listener");
        laa.o r5 = new laa.o(RangesKt.coerceIn(r8.a, 0.0f, 1.0f), r8.b);
        final b r10 = new b(this, this.n.incrementAndGet(), r5, r9);
        this.m.add(r10);
        Y2("observe");
        return new ObricMessageVisibilityComponent$observeMessageVisibility$1(this, r10);
    }
}
