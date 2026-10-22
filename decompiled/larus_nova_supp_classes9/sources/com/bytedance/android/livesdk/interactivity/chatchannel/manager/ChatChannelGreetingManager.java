package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChatChannelGreetingManager implements s22.c, vlc.l {
    public static final /* synthetic */ int v = 0;
    public final int a;
    public final int b;
    public final long c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;
    public long k;
    public final Lazy l;
    public s22.a m;
    public final Lazy n;
    public final CompositeDisposable o;
    public final b[] p;
    public b q;
    public final s22.e r;
    public final DataCenter s;
    public final RoomContext t;
    public final Context u;

    public static final class a {
    }

    public static final class b {
        public final ContainerType a;
        public final ViewGroup b;
        public final s22.c.a c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            ContainerType r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            ViewGroup r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            s22.c.a r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ContainerInfo(type=" + this.a + ", container=" + this.b + ", callback=" + this.c + ")";
        }

        public final ContainerType getType() {
            return this.a;
        }

        public b(ContainerType r2, ViewGroup r3, s22.c.a r4) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ChatChannelGreetingManager a;
        public final /* synthetic */ b b;

        public c(ChatChannelGreetingManager r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (Intrinsics.areEqual(this.a.q, this.b) == true) goto L5;
        L11:
            boolean r0 = false;
        L12:
            this.a.j("loadContainer shouldShowEmojiEntry=" + r0 + " canShow=" + this.a.d() + " disabled=" + this.a.g + " showing=" + this.a.f);
            if (r0 == false) goto L16;
            this.a.k();
            return;
        L16:
            return;
        L5:
            if (this.a.d() == false) goto L11;
            ChatChannelGreetingManager r1 = this.a;
            if (r1.g == true) goto L11;
            if (r1.f == true) goto L11;
            r0 = true;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final LinearLayout e() {
        return (LinearLayout) this.d.getValue();
    }

    public final Runnable f() {
        return (Runnable) this.n.getValue();
    }

    public final Handler h() {
        return (Handler) this.l.getValue();
    }

    public final boolean d() {
        s22.a r0 = this.m;
        if (r0 == null) goto L5;
        long r1 = r0.o();
    L7:
        if ((r1 - System.currentTimeMillis()) <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = -1;
        goto L7
    }

    @Override // s22.c
    public final boolean isShowing() {
        if (this.g == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f == false) goto L7;
        return true;
    }

    public final void k() {
        s22.e r0 = ChatChannelUtils.b(this.t);
        if (r0 == null) goto L45;
        s22.b r1 = r0.getEmojiManager();
        if (r1 == null) goto L46;
        final List<IMEmoji> r2 = r1.getEmojiList();
        if (r2 != null) goto L9;
        return;
    L9:
        if ((!r2.isEmpty()) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L49;
        b r3 = this.q;
        if (r3 == null) goto L19;
        s22.c.a r4 = r3.c;
        if (r4 == null) goto L19;
        int r5 = r4.U9();
    L20:
        j("availableWidth=" + r5);
        final int r6 = Math.min(r5 / (this.a + this.b), Math.min(4, r2.size()));
        if (r6 > 0) goto L23;
        j("show IMEmoji failed. emojiListSize=" + r2.size() + ". availableWidth=" + r5);
        m(false);
        return;
    L23:
        if (this.h == true) goto L25;
    L28:
        this.h = true;
        this.i = r6;
        Iterator r7 = ((List) this.e.getValue()).iterator();
        int r8 = 0;
    L30:
        if (r7.hasNext() == false) goto L39;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        ImageView r11 = (ImageView) r9;
        if (r8 >= r6) goto L37;
        final IMEmoji r13 = (IMEmoji) ListProtector.get(r2, r8);
        UtilityKotlinExtentionsKt.w(r11);
        ImageUtil.loadImage(r11, r13.getStaticUrl(), 0);
        r11.setOnClickListener(x0.a(new ChatChannelGreetingManager$showEmojiEntry$$inlined$forEachIndexed$lambda$1(r13, this, r6, r2)));
        r3.c(r11, r13.getDisplayName(), true);
    L38:
        r8 = r10;
        goto L30
    L37:
        UtilityKotlinExtentionsKt.t(r11);
        r11.setOnClickListener(null);
        goto L38
    L39:
        j("show " + r6 + " emoji");
        m(true);
        return;
    L25:
        if (this.i != r6) goto L28;
        j("emojiLoaded and num did not change");
        m(true);
        return;
    L19:
        r5 = 0;
        goto L20
    L49:
        return;
    L46:
        return;
    }

    public static int g(ContainerType r2) {
        int r3 = o.a[r2.ordinal()];
        if (r3 != 1) goto L5;
    L6:
        return 0;
    L5:
        if (r3 != 2) goto L6;
        return 1;
    }

    @Override // s22.c
    public final void a(ContainerType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        StringBuilder r0 = new StringBuilder("onAvailableWidthChange. type=");
        r0.append(r4);
        r0.append(" curType=");
        b r1 = this.q;
        ContainerType r2 = null;
        if (r1 == null) goto L5;
        ContainerType r3 = r1.getType();
    L6:
        r0.append(r3);
        r0.append(" showing=");
        r0.append(this.f);
        j(r0.toString());
        b r5 = this.q;
        if (r5 == null) goto L9;
        r2 = r5.getType();
    L9:
        if (r2 == r4) goto L11;
        return;
    L11:
        if (this.f == false) goto L15;
        k();
        return;
    L15:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // s22.c
    public final void b(ContainerType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        j("unregister " + r4);
        int r5 = g(r4);
        b[] r0 = this.p;
        b r1 = r0[r5];
        if (r1 != null) goto L5;
        return;
    L5:
        r0[r5] = null;
        if (Intrinsics.areEqual(this.q, r1) == false) goto L9;
        m(false);
        r1.b.removeView(e());
        this.q = null;
        return;
    }

    public final void i(b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        b r0 = this.q;
        if (r0 == null) goto L7;
        m(false);
        r0.b.removeView(e());
    L7:
        r3.b.addView(e());
        this.q = r3;
        h().post(new c(this, r3));
    }

    public final void j(String r2) {
        ALogger.i("ChatChannelGreetingManager", r2);
    }

    public final void l(Long r6) {
        if (this.g == true) goto L28;
        StringBuilder r0 = new StringBuilder("[tryShowGreetingEmoji],channelId:");
        r0.append(r6);
        r0.append(",currentChannelId:");
        s22.a r1 = this.m;
        Long r2 = null;
        if (r1 == null) goto L7;
        Long r3 = Long.valueOf(r1.getChannelId());
    L8:
        r0.append(r3);
        r0.append(",showing:");
        r0.append(this.f);
        r0.append(",canShow:");
        r0.append(d());
        j(r0.toString());
        s22.a r4 = this.m;
        if (r4 == null) goto L12;
        r2 = Long.valueOf(r4.getChannelId());
    L12:
        if (Intrinsics.areEqual(r6, r2) == true) goto L14;
    L26:
        j("[tryShowGreetingEmoji], can not show");
        h().removeCallbacks(f());
        return;
    L14:
        if (this.f == true) goto L26;
        if (d() == false) goto L26;
        if (this.h == true) goto L20;
        j("tryShowGreetingEmoji,call showEmojiEntry()");
        k();
    L21:
        j("tryShowGreetingEmoji,call showEmojiEntry()");
        h().removeCallbacks(f());
        Handler r7 = h();
        Runnable r5 = f();
        s22.a r8 = this.m;
        if (r8 == null) goto L24;
        long r9 = r8.o();
    L25:
        r7.postDelayed(r5, r9 - System.currentTimeMillis());
        return;
    L24:
        r9 = -1;
        goto L25
    L20:
        j("tryShowGreetingEmoji,updateEmojiContainerVisibility");
        m(true);
        goto L21
    L7:
        r3 = null;
        goto L8
    }

    public final void m(boolean r3) {
        j("[updateEmojiContainerVisibility] toVisible=" + r3 + ", showing=" + this.f);
        if (this.f != r3) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
    L10:
        if (r3 == true) goto L12;
    L15:
        this.f = r3;
        LinearLayout r0 = e();
        if (r3 == false) goto L18;
        int r1 = 0;
    L19:
        r0.setVisibility(r1);
        b r2 = this.q;
        if (r2 == null) goto L24;
        s22.c.a r4 = r2.c;
        if (r4 == null) goto L24;
        r4.q7(r3);
    L24:
        if (r3 == false) goto L27;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_hello_emoji_panel_show", null);
        return;
    L27:
        return;
    L18:
        r1 = 8;
        goto L19
    L12:
        if (this.q != null) goto L15;
        j("[updateIMEmojiContainerVisibility] visible but not attached");
        return;
    L7:
        if (this.g == false) goto L10;
        j("[updateIMEmojiContainerVisibility] visible but cannot show");
    }

    public final void onMessage(tlc.d r7) {
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) == false) goto L31;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b r0 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) r7;
        if (r0.isFromFirstRequest() == true) goto L24;
        boolean r2 = true;
        if (r0.getType() != 1) goto L24;
        if (r0.getUser() == null) goto L24;
        User r1 = r0.getUser();
        String r3 = null;
        if (r1 == null) goto L13;
        String r4 = r1.getCastSecUid();
    L14:
        IUserService r5 = jc1.k.f(IUserService.class);
        if (r5 == null) goto L22;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L22;
        IUser r8 = r6.b();
        if (r8 == null) goto L22;
        Intrinsics.checkNotNullParameter(r8, "$this$secUidExt");
        r3 = r8.getCastSecUid();
    L22:
        if ((!Intrinsics.areEqual(r4, r3)) == false) goto L24;
    L25:
        if (r2 == false) goto L32;
        long r9 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o.a((BaseMessage) r7);
        s22.a r10 = this.r.getChannel(r9);
        if (r10 == null) goto L29;
        r10.l(System.currentTimeMillis() + this.c);
    L29:
        j("[onUserAccess],channelId:" + r9);
        l(Long.valueOf(r9));
        return;
    L32:
        return;
    L13:
        r4 = null;
    L24:
        r2 = false;
        goto L25
    }

    @Override // s22.c
    public final void c(ContainerType r3, ViewGroup r4, s22.c.a r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "callback");
        j("register " + r3);
        int r0 = g(r3);
        if (this.p[r0] == null) goto L6;
        j("GreetingManager: register " + r3 + " twice");
        return;
    L6:
        b r1 = new b(r3, r4, r5);
        this.p[r0] = r1;
        com.bytedance.live.datacontext.m<Boolean> r6 = ChatChannelUtils.e(this.t);
        if (r6 != null) goto L9;
    L11:
        ContainerType r7 = ChatChannelUtils.a(this.t);
    L12:
        if (r3 != r7) goto L15;
        i(r1);
        return;
    L15:
        return;
    L9:
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L11;
        r7 = ContainerType.MultiTab;
        goto L12
    }

    public ChatChannelGreetingManager(s22.e r2, DataCenter r3, RoomContext r4, Context r5) {
        Intrinsics.checkNotNullParameter(r2, "channelManager");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.r = r2;
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.a = UtilityKotlinExtentionsKt.i(34);
        this.b = UtilityKotlinExtentionsKt.i(4);
        boolean r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.a;
        this.c = ((long) com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.h) * 1000;
        this.d = LazyKt.lazy(new ChatChannelGreetingManager$emojiContainer$2(this));
        this.e = LazyKt.lazy(new ChatChannelGreetingManager$emojiViews$2(this));
        this.g = true;
        this.k = -1;
        this.l = LazyKt.lazy(ChatChannelGreetingManager$mainHandler$2.INSTANCE);
        this.n = LazyKt.lazy(new ChatChannelGreetingManager$endRunnable$2(this));
        this.o = new CompositeDisposable();
        b[] r7 = new b[2];
        int r8 = 0;
    L3:
        if (r8 >= 2) goto L5;
        r7[r8] = null;
        r8 = r8 + 1;
        goto L3
    L5:
        this.p = r7;
    }
}
