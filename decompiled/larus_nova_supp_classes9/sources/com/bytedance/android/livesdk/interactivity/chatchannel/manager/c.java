package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.syncdata.RoomChannelSyncModel;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelRtcExtInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements s22.a, vlc.l, com.bytedance.android.livesdk.log.filter.n, vlc.h {
    public static final String E = null;
    public final User A;
    public final String B;
    public final List<User> C;
    public final boolean D;
    public s22.e a;
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g b;
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g c;
    public final CompositeDisposable d;
    public final PropertyOwner<Boolean> e;
    public final PropertyOwner<String> f;
    public final PropertyOwner<List<py.k>> g;
    public final PropertyOwner<Long> h;
    public final PropertyOwner<User> i;
    public final PropertyOwner<List<User>> j;
    public final PropertyOwner<Boolean> k;
    public final PropertyOwner<Boolean> l;
    public final PropertyOwner<Boolean> m;
    public final PropertyOwner<String> n;
    public RoomChannelSyncModel o;
    public final long p;
    public final long q;
    public final long r;
    public final long s;
    public final long t;
    public long u;
    public final SecretChatInfo v;
    public final FansChannelCreateInfo w;
    public final boolean x;
    public final boolean y;
    public boolean z;

    public static final class a {
    }

    public c() {
        throw null;
    }

    static {
        E = s1.B(2131922270);
    }

    public final long B() {
        PropertyOwner<Long> r0 = this.h;
        r0.getClass();
        return ((Number) r0.a).longValue();
    }

    public final boolean c() {
        PropertyOwner<Boolean> r0 = this.e;
        r0.getClass();
        return ((Boolean) r0.a).booleanValue();
    }

    @Override // s22.a
    public final PropertyOwner d() {
        PropertyOwner<Boolean> r0 = this.l;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final PropertyOwner d0() {
        PropertyOwner<Long> r0 = this.h;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final PropertyOwner g() {
        PropertyOwner<List<User>> r0 = this.j;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final PropertyOwner getChannelName() {
        PropertyOwner<String> r0 = this.f;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final PropertyOwner getOwner() {
        PropertyOwner<User> r0 = this.i;
        r0.getClass();
        return r0;
    }

    public final String i() {
        PropertyOwner<String> r0 = this.f;
        r0.getClass();
        return (String) r0.a;
    }

    @Override // s22.a
    public final PropertyOwner j() {
        PropertyOwner<Boolean> r0 = this.k;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final boolean k() {
        if (((Boolean) this.e.a).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.D == false) goto L7;
        return true;
    }

    public final String p() {
        PropertyOwner<User> r0 = this.i;
        r0.getClass();
        String r1 = com.bytedance.android.live.base.model.user.o.a((IBaseUser) r0.a);
        if (r1 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r1;
    }

    public final String q() {
        PropertyOwner<User> r0 = this.i;
        r0.getClass();
        return ((User) r0.a).getIdStr();
    }

    @Override // s22.a
    public final PropertyOwner t() {
        PropertyOwner<List<py.k>> r0 = this.g;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final PropertyOwner v() {
        PropertyOwner<Boolean> r0 = this.e;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final boolean w() {
        if (((Boolean) this.e.a).booleanValue() == false) goto L5;
    L12:
        return true;
    L5:
        if (this.y == true) goto L7;
    L11:
        return false;
    L7:
        if (((Boolean) this.m.a).booleanValue() == false) goto L11;
        if (this.x == true) goto L11;
        goto L11
    }

    @Override // s22.a
    public final PropertyOwner z() {
        PropertyOwner<Boolean> r0 = this.m;
        r0.getClass();
        return r0;
    }

    @Override // s22.a
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g A() {
        return this.b;
    }

    @Override // s22.a
    public final FansChannelCreateInfo C() {
        return this.w;
    }

    @Override // s22.a
    public final String a() {
        return this.B;
    }

    @Override // s22.a
    public final long b() {
        return this.s;
    }

    @Override // s22.a
    public final boolean e() {
        return this.x;
    }

    @Override // s22.a
    public final long f() {
        return this.t;
    }

    @Override // s22.a
    public final long getChannelId() {
        return this.p;
    }

    @Override // s22.a
    public final long getMaxMemberCount() {
        return this.q;
    }

    @Override // s22.a
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g h() {
        return this.c;
    }

    @Override // s22.a
    public final User m() {
        return this.A;
    }

    @Override // s22.a
    public final SecretChatInfo n() {
        return this.v;
    }

    @Override // s22.a
    public final long o() {
        return this.u;
    }

    @Override // s22.a
    public final PropertyOwner<String> r() {
        return this.n;
    }

    @Override // s22.a
    public final boolean s() {
        return this.y;
    }

    public final long u() {
        return this.p;
    }

    @Override // s22.a
    public final boolean x() {
        return this.z;
    }

    @Override // s22.a
    public final long y() {
        return this.r;
    }

    public final void D(s22.e r5) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(this, "channel");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("remove item success, channelInfo is " + com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a(this));
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r1 = this.b;
        r1.getClass();
        pm0.a r2 = om0.c.c();
        if (r2 == null) goto L5;
        r2.i("MessageListManager", "MessageListManager dispose");
    L5:
        r1.f.dispose();
        r1.a.removeMessages(20113);
        r1.g.set(false);
        this.d.dispose();
        r5.mo555getIMManager().removeMessageListener(this);
        this.a = null;
    }

    @Override // s22.a
    public final void l(long r1) {
        this.u = r1;
    }

    public final void onMessage(tlc.d r8) {
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.k) == false) goto L12;
        boolean r1 = true;
        if (((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.k) r8).getRoleType() == 1) goto L9;
        r1 = false;
    L9:
        if (((Boolean) this.e.a).booleanValue() == r1) goto L41;
        this.e.a(Boolean.valueOf(r1));
        f2.b(2131915758, 0);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.k(this);
        return;
    L41:
        return;
    L12:
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o) == false) goto L15;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o r9 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o) r8;
        E(r9.getChannelName(), null, r9.G(), r9.H(), r9.P());
        return;
    L15:
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.m) == false) goto L23;
        long r0 = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.m) r8).G();
        SecretChatInfo r10 = this.v;
        if (r10 == null) goto L20;
        r10.setStatus(r0);
    L20:
        if (r0 != 2) goto L44;
        this.k.a(Boolean.FALSE);
        return;
    L44:
        return;
    L23:
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g) == false) goto L25;
    L36:
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r11 = g62.a.a(r8);
        if (r11 != null) goto L39;
        return;
    L39:
        this.b.f(r11);
        return;
    L25:
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d) == true) goto L36;
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p) == true) goto L36;
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n) == true) goto L36;
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) == true) goto L36;
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h) == true) goto L36;
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i) == true) goto L36;
    }

    public final void onFirstMessage(List<tlc.d> r10, boolean r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.a != null) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r13 = this.b;
        if (r13.b == false) goto L10;
    L13:
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
        return;
    L16:
        boolean r15 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.e;
        ArrayList r0 = new ArrayList();
        Iterator<T> r16 = r10.iterator();
    L17:
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r4 = null;
        if (r16.hasNext() == false) goto L40;
        tlc.d r3 = (tlc.d) r16.next();
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g) == false) goto L22;
    L36:
        r4 = g62.a.a(r3);
    L37:
        if (r4 == null) goto L17;
        r0.add(r4);
        goto L17
    L22:
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d) == true) goto L36;
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p) == true) goto L36;
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n) == true) goto L36;
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) == true) goto L36;
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h) == true) goto L36;
        if ((r3 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i) == false) goto L37;
        if (r15 == false) goto L37;
        r4 = g62.a.a(r3);
        goto L37
    L40:
        if (r0.isEmpty() == false) goto L42;
        return;
    L42:
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r17 = this.b;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r0, "messages");
        if (r17.f.isDisposed() == false) goto L46;
        return;
    L46:
        if (r17.b == true) goto L89;
        ArrayList r18 = new ArrayList();
        Iterator r1 = r0.iterator();
    L50:
        if (r1.hasNext() == false) goto L68;
        Object r5 = r1.next();
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r6 = (com.bytedance.android.livesdk.interactivity.service.messagelist.c) r5;
        List<com.bytedance.android.livesdk.interactivity.service.messagelist.d> r7 = r17.h.getInterceptors();
        if (r7 == null) goto L61;
        Iterator<T> r8 = r7.iterator();
    L55:
        if (r8.hasNext() == false) goto L59;
        Object r9 = r8.next();
        if (((com.bytedance.android.livesdk.interactivity.service.messagelist.d) r9).a(r6) == false) goto L55;
    L60:
        com.bytedance.android.livesdk.interactivity.service.messagelist.d r19 = (com.bytedance.android.livesdk.interactivity.service.messagelist.d) r9;
    L62:
        if (r19 != null) goto L64;
        boolean r20 = true;
    L65:
        if (r20 == false) goto L50;
        r18.add(r5);
        goto L50
    L64:
        r20 = false;
        goto L65
    L59:
        r9 = null;
        goto L60
    L61:
        r19 = null;
        goto L62
    L68:
        if (r18.isEmpty() == true) goto L90;
        r17.b = true;
        int r2 = r18.size();
        List r110 = r18;
        if (r2 <= r17.h.c().getMaxCount()) goto L73;
        r110 = CollectionsKt.takeLast(r18, r17.h.c().getMaxCount());
    L73:
        ((ArrayList) r17.d).addAll(r110);
        r17.g(new IMessageListManager.a(IMessageListManager.MessageChangeType.INIT_LIST, 0, 0, 0, null, 30));
        return;
    L90:
        return;
    L89:
        return;
    L10:
        if ((!((ArrayList) r13.d).isEmpty()) == true) goto L13;
        r14 = false;
        goto L14
    }

    public final void E(String r5, List<? extends py.k> r6, long r7, User r9, List<? extends User> r10) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L9:
        if (r6 == null) goto L16;
        if (r6.size() <= 0) goto L16;
        if ((!Intrinsics.areEqual(r6, (List) this.g.a)) == false) goto L16;
        this.g.a(r6);
    L16:
        if (r7 > 0) goto L18;
    L20:
        boolean r8 = false;
        if (r10 == null) goto L41;
        List r11 = (List) this.j.a;
        if (r10.size() != r11.size()) goto L38;
        List<? extends User> r13 = r10;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L27:
        if (r15.hasNext() == false) goto L29;
        r14.add(com.bytedance.android.live.base.model.user.o.a((User) r15.next()));
        goto L27
    L29:
        List r16 = CollectionsKt.toList(r14);
        List r17 = r11;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        r18.add(com.bytedance.android.live.base.model.user.o.a((User) r19.next()));
        goto L31
    L33:
        List r20 = CollectionsKt.toList(r18);
        if (r16.containsAll(r20) == false) goto L38;
        if (r20.containsAll(r16) == false) goto L38;
    L39:
        if (r0 == true) goto L41;
        this.j.a(r10);
        int r21 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(this, "chatChannel");
        StringBuilder r23 = new StringBuilder("update userList, channelId is ");
        r23.append(this.p);
        r23.append(", size is ");
        PropertyOwner<List<User>> r24 = this.j;
        r24.getClass();
        r23.append(((List) r24.a).size());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r23.toString());
    L38:
        r0 = false;
    L41:
        if (r9 == null) goto L51;
        User r25 = (User) this.i.a;
        if (r25 == null) goto L46;
        Intrinsics.checkNotNullParameter(r9, "$this$secUidExt");
        String r26 = r9.getCastSecUid();
        Intrinsics.checkNotNullParameter(r25, "$this$secUidExt");
        r8 = TextUtils.equals(r26, r25.getCastSecUid());
    L46:
        if (r8 == true) goto L52;
        this.i.a(r9);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.k(this);
        return;
    L52:
        return;
    L51:
        return;
    L18:
        if (r7 == ((Number) this.h.a).longValue()) goto L20;
        this.h.a(Long.valueOf(r7));
        int r27 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(this, "chatChannel");
        StringBuilder r28 = new StringBuilder("update count, channelId is ");
        r28.append(this.p);
        r28.append(", count is ");
        PropertyOwner<Long> r29 = this.h;
        r29.getClass();
        r28.append(((Number) r29.a).longValue());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r28.toString());
        goto L20
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        if ((!Intrinsics.areEqual(r5, (String) this.f.a)) == false) goto L9;
        this.f.a(r5);
        goto L9
    }

    public c(long r13, String r15, long r16, long r18, long r20, long r23, SecretChatInfo r24, FansChannelCreateInfo r25, boolean r26, boolean r27, boolean r28, User r29, RoomChannelRtcExtInfo r30, boolean r31, String r33, List r34, String r35, long r36, List r37, User r38, boolean r39, boolean r40) {
        Intrinsics.checkNotNullParameter(r15, "token");
        Intrinsics.checkNotNullParameter(r33, "channelName");
        Intrinsics.checkNotNullParameter(r34, "avatarThumb");
        Intrinsics.checkNotNullParameter(r37, "topUserList");
        Intrinsics.checkNotNullParameter(r38, "ownerUser");
        this.p = r13;
        this.q = r16;
        this.r = r18;
        this.s = r20;
        this.t = r23;
        this.u = 0;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r35;
        this.C = r37;
        this.D = r40;
        int r6 = g62.j.a;
        g62.b r7 = new g62.b();
        g62.e r8 = new g62.e();
        g62.d r9 = new g62.d();
        List r10 = CollectionsKt.mutableListOf(new com.bytedance.android.livesdk.interactivity.service.messagelist.d[]{new j62.a(), new j62.b()});
        boolean r11 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.a;
        this.b = new com.bytedance.android.livesdk.interactivity.service.messagelist.g(new g62.c(r10, r7, r9, r8, new com.bytedance.android.livesdk.interactivity.service.messagelist.l()));
        this.c = new com.bytedance.android.livesdk.interactivity.service.messagelist.g(new g62.g(new g62.f(), new g62.h(), new g62.i()));
        this.d = new CompositeDisposable();
        if (r30 == null) goto L5;
        sh6.d r14 = new sh6.d(r30);
    L6:
        new PropertyOwner(r14);
        this.e = new PropertyOwner(Boolean.valueOf(r31));
        this.f = new PropertyOwner(r33);
        this.g = new PropertyOwner(r34);
        this.h = new PropertyOwner(Long.valueOf(r36));
        this.i = new PropertyOwner(r38);
        this.j = new PropertyOwner(r37);
        this.k = new PropertyOwner(Boolean.valueOf(r39));
        this.l = new PropertyOwner(Boolean.FALSE);
        this.m = new PropertyOwner(Boolean.TRUE);
        this.n = new PropertyOwner(BuildConfig.FLAVOR);
        return;
    L5:
        r14 = sh6.a.a;
        goto L6
    }
}
