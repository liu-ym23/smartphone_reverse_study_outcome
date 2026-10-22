package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import android.content.Context;
import android.os.Message;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.j;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.ChannelTrayDiffCallback;
import com.bytedance.android.livesdk.interactivity.service.messagelist.l;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChatChannelPresenter extends n<IView> implements WeakHandler.IHandler {
    public final List<p62.a> e;
    public boolean f;
    public final WeakHandler g;
    public final h h;
    public final s22.e i;
    public final CompositeDisposable j;
    public final RoomContext k;
    public final DataCenter l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        void QU(DiffUtil.DiffResult r1);

        void WP(int r1);

        /* synthetic */ Context getContext();

        void ie(int r1, int r2);

        void uS();

        void xi(List<p62.a> r1);
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatChannelPresenter a;
        public final /* synthetic */ s22.a b;

        public b(ChatChannelPresenter r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Boolean r5 = (Boolean) r4;
            p62.a r0 = ChatChannelPresenter.g0(this.a, this.b.getChannelId());
            if (r0 == null) goto L6;
            r0.a = r5.booleanValue();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ChatChannelPresenter a;
        public final /* synthetic */ s22.a b;

        public c(ChatChannelPresenter r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            User r5 = (User) r4;
            p62.a r0 = ChatChannelPresenter.g0(this.a, this.b.getChannelId());
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r0.e = r5;
        L5:
            ChatChannelPresenter.h0(this.a, this.b.getChannelId(), 1);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ChatChannelPresenter a;
        public final /* synthetic */ s22.a b;

        public d(ChatChannelPresenter r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            p62.a r0 = ChatChannelPresenter.g0(this.a, this.b.getChannelId());
            if (r0 == null) goto L5;
            r0.h = r5.longValue();
        L5:
            ChatChannelPresenter.h0(this.a, this.b.getChannelId(), 2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ChatChannelPresenter a;
        public final /* synthetic */ s22.a b;

        public e(ChatChannelPresenter r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            List<? extends User> r5 = (List) r4;
            p62.a r0 = ChatChannelPresenter.g0(this.a, this.b.getChannelId());
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r0.d = r5;
        L5:
            ChatChannelPresenter.h0(this.a, this.b.getChannelId(), 3);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ChatChannelPresenter a;
        public final /* synthetic */ s22.a b;

        public f(ChatChannelPresenter r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            p62.a r0 = ChatChannelPresenter.g0(this.a, this.b.getChannelId());
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r0.f = r5;
        L5:
            ChatChannelPresenter.h0(this.a, this.b.getChannelId(), 4);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ChatChannelPresenter a;
        public final /* synthetic */ s22.a b;

        public g(ChatChannelPresenter r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            List<? extends k> r5 = (List) r4;
            p62.a r0 = ChatChannelPresenter.g0(this.a, this.b.getChannelId());
            if (r0 == null) goto L5;
            r0.g = r5;
        L5:
            ChatChannelPresenter.h0(this.a, this.b.getChannelId(), 8);
        }
    }

    public static final class h extends s22.e.a {
        public final /* synthetic */ ChatChannelPresenter a;

        public h(ChatChannelPresenter r1) {
            this.a = r1;
        }

        @Override // s22.e.a
        public final void b(long r7) {
            Iterator r0 = ((ArrayList) this.a.e).iterator();
            int r2 = 0;
        L4:
            if (r0.hasNext() == false) goto L12;
            if (((p62.a) r0.next()).c != r7) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == true) goto L13;
            r2 = r2 + 1;
        L13:
            if (r2 < 0) goto L20;
            ListProtector.remove(this.a.e, r2);
            IView r8 = ((q46.b) this.a).a;
            if (r8 == null) goto L21;
            r8.WP(r2);
            return;
        L21:
            return;
        L20:
            return;
        L8:
            r3 = false;
            goto L9
        L12:
            r2 = -1;
            goto L13
        }

        @Override // s22.e.a
        public final void c(s22.a r10) {
            Intrinsics.checkNotNullParameter(r10, "newChatChannel");
            p62.a r0 = this.a.j0(r10);
            Iterator r1 = ((ArrayList) this.a.e).iterator();
            int r3 = 0;
        L4:
            if (r1.hasNext() == false) goto L12;
            if (((p62.a) r1.next()).c != r10.getChannelId()) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == true) goto L13;
            r3 = r3 + 1;
        L13:
            if (r3 < 0) goto L20;
            r0.k = ((p62.a) ListProtector.get(this.a.e, r3)).k;
            ListProtector.set(this.a.e, r3, r0);
            IView r11 = ((q46.b) this.a).a;
            if (r11 == null) goto L21;
            r11.ie(r3, 7);
            return;
        L21:
            return;
        L20:
            return;
        L8:
            r4 = false;
            goto L9
        L12:
            r3 = -1;
            goto L13
        }

        @Override // s22.e.a, s22.e.c
        public final void Gh(s22.a r20, int r21) {
            Intrinsics.checkNotNullParameter(r20, "channel");
            Iterator r1 = ((ArrayList) this.a.e).iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            Object r3 = r1.next();
            if (((p62.a) r3).c != r20.getChannelId()) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == false) goto L4;
        L12:
            p62.a r4 = (p62.a) r3;
            if (r4 != null) goto L15;
            return;
        L15:
            boolean r2 = r4.l;
            r4.i = r21;
            l r7 = r20.A().h.b();
            long r8 = 0;
            if (r7 == null) goto L18;
            long r9 = r7.f;
        L19:
            r4.j = r9;
            if (r4.i <= 0) goto L30;
            long r10 = r20.getChannelId();
            long r13 = r20.y();
            boolean r14 = ((Boolean) r20.v().a).booleanValue();
            FansChannelCreateInfo r11 = r20.C();
            if (r11 == null) goto L24;
            r8 = r11.getFansChannelType();
        L24:
            j r5 = new j(r10, r13, r14, r8, r20.f());
            com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r15 = ChatChannelUtils.g(this.a.k);
            if (r15 == null) goto L29;
            PublishSubject<j> r16 = r15.getRedDotStatus();
            if (r16 == null) goto L29;
            r16.onNext(r5);
        L29:
            r4.l = !r4.k;
        L31:
            boolean r17 = r4.l;
            if (r17 == false) goto L55;
            if (r2 == r17) goto L55;
            ChatChannelPresenter r18 = this.a;
            DataCenter r19 = r18.l;
            if (r19 == null) goto L55;
            if (ChatChannelUtils.k(r18.k, r19) == false) goto L55;
            s22.e r23 = ChatChannelUtils.b(this.a.k);
            if (r23 == null) goto L55;
            s22.a r24 = r23.getChannel(r4.c);
            if (r24 == null) goto L55;
            String r25 = String.valueOf(r24.y());
            FansChannelCreateInfo r26 = r24.C();
            if (r26 == null) goto L48;
            String r27 = String.valueOf(r26.getFansChannelType());
            if (r27 == null) goto L48;
            String r110 = r27;
        L50:
            if (((Boolean) r24.v().a).booleanValue() == false) goto L52;
            String r111 = "1";
        L53:
            int r28 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.b(r4.f, "top_tab", r25, r111, r110, String.valueOf(r24.getChannelId()), String.valueOf(r24.f()));
            goto L55
        L52:
            r111 = "0";
        L48:
            r110 = "0";
        L55:
            if (r4.k == false) goto L57;
            return;
        L57:
            ChatChannelPresenter r29 = this.a;
            r29.f = true;
            int r30 = ((ArrayList) r29.e).indexOf(r4);
            if (r30 <= 0) goto L68;
            IView r31 = ((q46.b) this.a).a;
            if (r31 == null) goto L69;
            r31.ie(r30, 6);
            return;
        L69:
            return;
        L68:
            return;
        L30:
            r4.l = false;
            goto L31
        L18:
            r9 = 0;
            goto L19
        L8:
            r6 = false;
            goto L9
        L11:
            r3 = null;
            goto L12
        }

        @Override // s22.e.a
        public final void a(s22.a r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "chatChannel");
            Iterator<T> r9 = this.a.e.iterator();
        L4:
            if (r9.hasNext() == false) goto L11;
            Object r0 = r9.next();
            if (((p62.a) r0).c != r7.getChannelId()) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L4;
        L12:
            if (r0 == null) goto L17;
            boolean r10 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.a;
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.p == false) goto L24;
            c(r7);
            return;
        L24:
            return;
        L17:
            p62.a r11 = this.a.j0(r7);
            ((ArrayList) this.a.e).add(r11);
            ChatChannelPresenter r13 = this.a;
            r13.k0(r13.e);
            return;
        L8:
            r1 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }
    }

    public static final class i<T> implements Comparator<T> {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((p62.a) r4).j), Long.valueOf(((p62.a) r3).j));
        }
    }

    static {
    }

    public final void detachView() {
        super.detachView();
        ((ArrayList) this.e).clear();
        this.i.removeListener(this.h);
        this.g.removeCallbacksAndMessages(null);
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        i0((IView) r1);
    }

    public final void handleMsg(Message r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.what == 10086) goto L8;
    L31:
        this.g.sendEmptyMessageDelayed(10086, 1000);
        return;
    L8:
        if (this.f == false) goto L31;
        List<p62.a> r9 = this.e;
        ArrayList r2 = new ArrayList(r9);     // Catch: Exception -> L27
        ArrayList r3 = (ArrayList) r9;     // Catch: Exception -> L27
        if (r3.size() <= 1) goto L13;
        CollectionsKt.sortWith(r3, new com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.a());     // Catch: Exception -> L27
    L13:
        Iterator r4 = r3.iterator();     // Catch: Exception -> L27
    L15:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();     // Catch: Exception -> L27
        if (((p62.a) r5).k == false) goto L15;
    L20:
        p62.a r6 = (p62.a) r5;     // Catch: Exception -> L27
        if (r6 == null) goto L23;
        r3.remove(r6);     // Catch: Exception -> L27
        ListProtector.add(r3, 0, r6);     // Catch: Exception -> L27
    L23:
        DiffUtil.DiffResult r7 = DiffUtil.calculateDiff(new ChannelTrayDiffCallback(r2, r3));     // Catch: Exception -> L27
        IView r10 = ((q46.b) this).a;     // Catch: Exception -> L27
        if (r10 == null) goto L30;
        r10.QU(r7);     // Catch: Exception -> L27
    L30:
        this.f = false;
        goto L31
    L19:
        r5 = null;
    L27:
        IView r11 = ((q46.b) this).a;
        if (r11 == null) goto L30;
        r11.xi(r9);
        goto L30
    }

    public final void i0(IView r3) {
        super.c0(r3);
        List<s22.a> r4 = this.i.getAllChannel();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(j0((s22.a) r5.next()));
        goto L4
    L6:
        ((ArrayList) this.e).addAll(r0);
        k0(this.e);
        this.g.sendEmptyMessage(10086);
        this.i.addListener(this.h);
        com.bytedance.revenue.platform.api.core.rx.f.a(p.a(this.i.getCurrentChannel(), new ChatChannelPresenter$observeCurrentChannelChange$1(this)), this.j);
    }

    public final p62.a j0(s22.a r20) {
        s22.a r2 = (s22.a) sh6.c.b((sh6.b) this.i.getCurrentChannel().getValue());
        Disposable r3 = r20.j().subscribe(new b(this, r20));
        if (r3 == null) goto L5;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.j);
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(r20.getOwner().subscribe(new c(this, r20)), this.j);
        com.bytedance.revenue.platform.api.core.rx.f.a(r20.d0().subscribe(new d(this, r20)), this.j);
        com.bytedance.revenue.platform.api.core.rx.f.a(r20.g().subscribe(new e(this, r20)), this.j);
        com.bytedance.revenue.platform.api.core.rx.f.a(r20.getChannelName().subscribe(new f(this, r20)), this.j);
        com.bytedance.revenue.platform.api.core.rx.f.a(r20.t().subscribe(new g(this, r20)), this.j);
        boolean r18 = Long.valueOf(r20.getChannelId()).equals(r2);
        boolean r6 = ((Boolean) r20.j().a).booleanValue();
        long r8 = r20.getChannelId();
        List r10 = (List) r20.g().a;
        User r11 = (User) r20.getOwner().a;
        long r14 = ((Number) r20.d0().a).longValue();
        String r13 = (String) r20.getChannelName().a;
        List r15 = (List) r20.t().a;
        SecretChatInfo r7 = r20.n();
        l r1 = r20.A().h.b();
        if (r1 == null) goto L8;
        long r4 = r1.f;
    L10:
        return new p62.a(r6, r7, r8, r10, r11, r13, r15, r14, r4, r18);
    L8:
        r4 = 0;
        goto L10
    }

    public final void k0(List<p62.a> r4) {
        ArrayList r5 = (ArrayList) r4;
        if (r5.size() <= 1) goto L5;
        CollectionsKt.sortWith(r5, new i());
    L5:
        Iterator r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((p62.a) r1).k == false) goto L7;
    L12:
        p62.a r2 = (p62.a) r1;
        if (r2 == null) goto L15;
        r5.remove(r2);
        ListProtector.add(r5, 0, r2);
    L15:
        IView r3 = ((q46.b) this).a;
        if (r3 == null) goto L22;
        r3.xi(r5);
        return;
    L22:
        return;
    L11:
        r1 = null;
        goto L12
    }

    public static final p62.a g0(ChatChannelPresenter r4, long r5) {
        Iterator r6 = ((ArrayList) r4.e).iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        if (((p62.a) r0).c != r5) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L13:
        return (p62.a) r0;
    L8:
        r1 = false;
        goto L9
    L11:
        r0 = null;
        goto L13
    }

    public static final void h0(ChatChannelPresenter r6, long r7, int r9) {
        Iterator r0 = ((ArrayList) r6.e).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (((p62.a) r0.next()).c != r7) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 < 0) goto L20;
        IView r8 = ((q46.b) r6).a;
        if (r8 == null) goto L21;
        r8.ie(r2, r9);
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }

    public ChatChannelPresenter(s22.e r2, CompositeDisposable r3, RoomContext r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r2, "chatChannelManager");
        Intrinsics.checkNotNullParameter(r3, "compositeDisposable");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.e = new ArrayList();
        this.g = new WeakHandler(this);
        this.h = new h(this);
    }
}
