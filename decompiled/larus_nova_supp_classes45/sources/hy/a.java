package hy;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.anchorlink.network.LinkCrossRoomApi;
import com.bytedance.android.live.anchorlink.usercenter.ListUpdateType;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkMicIdInfo;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.ha1;
import com.bytedance.android.livesdk.config.ja1;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnterContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLinkedListChangeContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import gm2.i;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements hy.e, l {
    public final List<AnchorLinkUser> a;
    public final List<AnchorLinkUser> b;
    public final CopyOnWriteArrayList<User> c;
    public final CopyOnWriteArrayList<User> d;
    public final ArrayList<AnchorLinkUser> e;
    public final ArrayList<AnchorLinkUser> f;
    public final LruCache<String, AnchorLinkUser> g;
    public final CompositeDisposable h;
    public final ArrayList<hy.f.b> i;
    public final vlc.d j;
    public final boolean k;
    public final Room l;
    public final hy.h m;
    public b n;
    public final hy.g o;
    public final int p;

    /* JADX INFO: renamed from: hy.a$a, reason: collision with other inner class name */
    public static final class C0237a {
    }

    public static final class b {
        public final ListUpdateType a;
        public final String b;
        public final int c;
        public final String d;
        public final long e;
        public final long f;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L18;
            b r7 = (b) r6;
            if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
            return false;
        L14:
            if (this.e == r7.e) goto L16;
            return false;
        L16:
            if (this.f == r7.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            ListUpdateType r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (((r3 + r5) * 31) + this.c) * 31;
            String r7 = this.d;
            if (r7 == null) goto L13;
            r1 = r7.hashCode();
        L13:
            int r8 = (r6 + r1) * 31;
            long r9 = this.e;
            int r11 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
            long r12 = this.f;
            return r11 + ((int) (r12 ^ (r12 >>> 32)));
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RefreshInfo(type=" + this.a + ", extra=" + this.b + ", scene=" + this.c + ", logId=" + this.d + ", version=" + this.e + ", timestamp=" + this.f + ")";
        }

        public final ListUpdateType getType() {
            return this.a;
        }

        public b(ListUpdateType r4, String r5, int r6, String r7, long r8, int r11) {
            if ((r11 & 2) == 0) goto L6;
            r5 = "";
        L6:
            if ((r11 & 4) == 0) goto L9;
            r6 = 0;
        L9:
            if ((r11 & 8) == 0) goto L11;
            r7 = "";
        L11:
            long r1 = 0;
            if ((r11 & 16) == 0) goto L15;
            r8 = 0;
        L15:
            if ((r11 & 32) == 0) goto L17;
            r1 = System.currentTimeMillis();
        L17:
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "extra");
            Intrinsics.checkNotNullParameter(r7, "logId");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            if (r2 == null) goto L6;
            r2.printStackTrace();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            if (r2 == null) goto L6;
            r2.printStackTrace();
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public g(a r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r12) {
            Response r13 = (Response) r12;
            if (r13 == null) goto L78;
            com.bytedance.android.livesdk.message.linker.a r0 = (com.bytedance.android.livesdk.message.linker.a) ((BaseResponse) r13).data;
            if (r0 == null) goto L112;
            List<AnchorLinkUser> r1 = r0.b();
            if (r1 == null) goto L113;
            this.a.m.l(this.b, r1, ((BaseResponse) r13).logId);
            a r2 = this.a;
            ListUpdateType r3 = ListUpdateType.LIST_API;
            String r4 = this.b;
            int r5 = r2.p;
            String r14 = ((BaseResponse) r13).logId;
            if (r14 != null) goto L11;
            r14 = "";
        L11:
            r2.n = new b(r3, r4, r5, r14, 0, 48);
            int r15 = this.c;
            if (r15 == 1) goto L14;
            if (r15 == 4) goto L14;
        L29:
            int r16 = this.c;
            if (r16 == 2) goto L32;
            if (r16 == 4) goto L32;
        L59:
            if (this.c != 4) goto L114;
            this.a.e.clear();
            ArrayList<AnchorLinkUser> r17 = this.a.e;
            ArrayList r6 = new ArrayList();
            Iterator<T> r7 = r1.iterator();
        L62:
            if (r7.hasNext() == false) goto L72;
            T r8 = r7.next();
            AnchorLinkUser r9 = (AnchorLinkUser) r8;
            if (r9.getStatus() != 2) goto L66;
        L69:
            boolean r11 = true;
        L70:
            if (r11 == false) goto L62;
            r6.add(r8);
            goto L62
        L66:
            if (r9.getStatus() == 1) goto L69;
            r11 = false;
            goto L70
        L72:
            r17.addAll(CollectionsKt.sortedWith(r6, new hy.c()));
            Iterator<hy.f.b> r18 = this.a.i.iterator();
        L74:
            if (r18.hasNext() == false) goto L115;
            hy.f.b r19 = r18.next();
            if (r19 == null) goto L74;
            a r21 = this.a;
            r19.b(r21.p, r21.e);
            goto L74
        L115:
            return;
        L114:
            return;
        L32:
            Iterator r110 = ((CopyOnWriteArrayList) this.a.a).iterator();
        L34:
            if (r110.hasNext() == false) goto L40;
            AnchorLinkUser r22 = (AnchorLinkUser) r110.next();
            LruCache<String, AnchorLinkUser> r23 = this.a.g;
            IBaseUser r24 = r22.getUser();
            if (r24 == null) goto L38;
            String r25 = r24.getIdString();
        L39:
            r23.put(r25, r22);
            goto L34
        L38:
            r25 = null;
            goto L39
        L40:
            ((CopyOnWriteArrayList) this.a.a).clear();
            ArrayList r26 = new ArrayList();
            Iterator<T> r111 = r1.iterator();
        L42:
            if (r111.hasNext() == false) goto L49;
            T r27 = r111.next();
            if (((AnchorLinkUser) r27).getStatus() != 2) goto L46;
            boolean r28 = true;
        L47:
            if (r28 == false) goto L42;
            r26.add(r27);
            goto L42
        L46:
            r28 = false;
            goto L47
        L49:
            List r112 = CollectionsKt.toMutableList(r26);
            if (r112.size() <= 1) goto L52;
            CollectionsKt.sortWith(r112, new hy.b());
        L52:
            CopyOnWriteArrayList r29 = (CopyOnWriteArrayList) this.a.a;
            r29.addAll(r112);
            Iterator<hy.f.b> r113 = this.a.i.iterator();
        L54:
            if (r113.hasNext() == false) goto L59;
            hy.f.b r31 = r113.next();
            if (r31 == null) goto L54;
            a r32 = this.a;
            r31.d(r32.p, r32.a);
        L14:
            ((CopyOnWriteArrayList) this.a.b).clear();
            List<AnchorLinkUser> r114 = this.a.b;
            ArrayList r33 = new ArrayList();
            Iterator<T> r34 = r1.iterator();
        L16:
            if (r34.hasNext() == false) goto L23;
            T r35 = r34.next();
            if (((AnchorLinkUser) r35).getStatus() != 1) goto L20;
            boolean r36 = true;
        L21:
            if (r36 == false) goto L16;
            r33.add(r35);
            goto L16
        L20:
            r36 = false;
            goto L21
        L23:
            ((CopyOnWriteArrayList) r114).addAll(r33);
            Iterator<hy.f.b> r115 = this.a.i.iterator();
        L25:
            if (r115.hasNext() == false) goto L29;
            hy.f.b r37 = r115.next();
            if (r37 == null) goto L25;
            a r38 = this.a;
            int r39 = r38.p;
            List<AnchorLinkUser> r41 = r38.b;
            r1.size();
            r37.a(r39, r41);
            goto L25
        L113:
            return;
        L112:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public h(a r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            if (Intrinsics.areEqual(this.b, "multi_anchor_link_widget_create") == true) goto L5;
            return;
        L5:
            if ((r4 instanceof ApiServerException) == true) goto L7;
            r4 = null;
        L7:
            ApiServerException r5 = (ApiServerException) r4;
            if (r5 != null) goto L10;
        L11:
            this.a.b(this.c, "request_failed_retry");
            return;
        L10:
            if (r5.getErrorCode() != 31001) goto L11;
        }
    }

    static {
    }

    @Override // hy.f
    public final void attach() {
        vlc.d r0 = this.j;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINKER.getIntType(), this);
    L5:
        vlc.d r1 = this.j;
        if (r1 == null) goto L9;
        r1.addMessageListener(MessageType.PIX_ACTIVITY_MESSAGE.getIntType(), this);
        return;
    }

    @Override // hy.e
    public final int c() {
        if ((!this.a.isEmpty()) == true) goto L5;
        return 1;
    L5:
        return ((CopyOnWriteArrayList) this.a).size();
    }

    @Override // hy.e
    public final List<AnchorLinkUser> d() {
        return CollectionsKt.toList(this.e);
    }

    @Override // hy.e
    public final void j() {
        n("CLEAR List", null, null);
        this.n = new b(ListUpdateType.CLEAR, "clearList", this.p, null, 0, 56);
        this.e.clear();
        this.d.clear();
        ((CopyOnWriteArrayList) this.a).clear();
        this.c.clear();
    }

    public final long m() {
        return this.o.getChannelId();
    }

    @Override // hy.f
    public final void r0() {
        ALogger.e("ttlive_anchor_link_users", "onEnterForeground channelId=" + m() + ' ' + this.n);
        i r0 = new i();
        if (m() != 0) goto L5;
        return;
    L5:
        r0.type = 100102;
        r0.senderUserId = k.n(IMiddlewareUserService.class).user().n();
        LiveData r1 = ey.a.a();
        if (r1 == null) goto L11;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L11;
        String r3 = r2.e;
        if (r3 == null) goto L11;
    L12:
        r0.senderInteractIdStr = r3;
        r0.targetUserId = "0";
        r0.targetInteractId = "0";
        r0.targetInteractIdStr = "0";
        this.h.add(((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).sendSignalV3(m(), GsonProtectorUtils.toJson(GsonHelper.get(), r0), null, this.p).compose(RxUtil.rxSchedulerHelper()).subscribe(e.a, f.a));
        return;
    L11:
        r3 = "";
        goto L12
    }

    @Override // hy.f
    public final void v() {
        ALogger.e("ttlive_anchor_link_users", "onEnterBackground channelId=" + m() + ' ' + this.n);
        i r0 = new i();
        if (m() != 0) goto L5;
        return;
    L5:
        LiveData r1 = ey.a.a();
        String r2 = null;
        if (r1 == null) goto L8;
        ey.f r3 = (ey.f) r1.getValue();
    L9:
        r0.type = 100101;
        r0.senderUserId = k.n(IMiddlewareUserService.class).user().n().toString();
        if (r3 == null) goto L12;
        r2 = r3.e;
    L12:
        r0.senderInteractIdStr = r2;
        r0.targetUserId = "0";
        r0.targetInteractId = "0";
        r0.targetInteractIdStr = "0";
        this.h.add(((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).sendSignalV3(m(), GsonProtectorUtils.toJson(GsonHelper.get(), r0), null, this.p).compose(RxUtil.rxSchedulerHelper()).subscribe(c.a, d.a));
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // hy.f
    public final List<AnchorLinkUser> a() {
        return this.b;
    }

    @Override // hy.e
    public final List<User> getInviteeList() {
        return this.c;
    }

    @Override // hy.f
    public final List<AnchorLinkUser> getOnlineUserList() {
        return this.a;
    }

    @Override // hy.e
    public final boolean N(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        AnchorLinkUser r0 = hy.d.a(this.a);
        if (r0 == null) goto L7;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L7;
        String r3 = r1.getIdString();
    L9:
        return Intrinsics.areEqual(r2, r3);
    L7:
        r3 = null;
        goto L9
    }

    @Override // hy.e
    public final void clear(boolean r11) {
        n("CLEAR and callback", null, null);
        this.n = new b(ListUpdateType.CLEAR, "clear", this.p, null, 0, 56);
        ((CopyOnWriteArrayList) this.b).clear();
        ((CopyOnWriteArrayList) this.a).clear();
        this.e.clear();
        Iterator<hy.f.b> r12 = this.i.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        hy.f.b r0 = r12.next();
        r0.a(this.p, this.b);
        r0.d(this.p, this.a);
        r0.b(this.p, this.e);
        goto L4
    }

    @Override // hy.e
    public final void e(User r5) {
        Intrinsics.checkNotNullParameter(r5, "user");
        Iterator<User> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        User r1 = r0.next();
        if (TextUtils.isEmpty(r5.getCastSecUid()) == true) goto L11;
        if (TextUtils.equals(r1.getCastSecUid(), r5.getCastSecUid()) == false) goto L11;
        return;
    L11:
        if (q0.a(r5.getIdString()) == false) goto L4;
        if (Intrinsics.areEqual(r1.getIdString(), r5.getIdString()) == false) goto L4;
        return;
    L15:
        this.c.add(r5);
        ALogger.i("ttlive_anchor_link_users", "scene=" + this.p + " addInvitee " + r5);
        Iterator<hy.f.b> r6 = this.i.iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        hy.f.b r2 = r6.next();
        if (r2 == null) goto L17;
        r2.c(this.p, this.c);
        goto L17
    }

    @Override // hy.e
    public final AnchorLinkUser g(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<T> r1 = this.a.iterator();
    L7:
        if (r1.hasNext() == false) goto L23;
        AnchorLinkUser r2 = (AnchorLinkUser) r1.next();
        if (r2.getAnchorLinkMicIdInfo() == null) goto L7;
        AnchorLinkMicIdInfo r3 = r2.getAnchorLinkMicIdInfo();
        if (r3 == null) goto L13;
        String r4 = r3.mainLinkMicId;
    L15:
        if (TextUtils.equals(r5, r4) == true) goto L22;
        AnchorLinkMicIdInfo r6 = r2.getAnchorLinkMicIdInfo();
        if (r6 == null) goto L19;
        String r7 = r6.backupLinkMicId;
    L21:
        if (TextUtils.equals(r5, r7) == false) goto L7;
    L19:
        r7 = null;
    L22:
        return r2;
    L13:
        r4 = null;
        goto L15
    L23:
        return null;
    }

    @Override // hy.f
    public final void h(hy.f.a r2) {
        ArrayList<hy.f.b> r0 = this.i;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r0).remove(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // hy.f
    public final void i(hy.f.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.i.add(r2);
    }

    @Override // hy.e
    public final void k(User r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        this.c.remove(r4);
        Iterator<hy.f.b> r5 = this.i.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        hy.f.b r0 = r5.next();
        if (r0 == null) goto L4;
        r0.c(this.p, this.c);
        goto L4
    }

    public final void onMessage(tlc.d r27) {
        if (r27 != null) goto L6;
        return;
    L6:
        if ((r27 instanceof if) == false) goto L216;
        if r1 = (if) r27;
        if (r1.mScene == this.p) goto L11;
        return;
    L11:
        if (this.k == true) goto L13;
    L26:
        int r2 = r1.getMType();
        List<AnchorLinkUser> r9 = null;
        String r11 = "null";
        if (r2 != 6) goto L29;
        StringBuilder r3 = new StringBuilder("receive LINKER_ENTER uid=");
        LinkerEnterContent r4 = r1.mEnter;
        if (r4 == null) goto L166;
        String r5 = r4.getUserIdString();
    L167:
        r3.append(r5);
        String r6 = r3.toString();
        LinkerEnterContent r7 = r1.mEnter;
        if (r7 == null) goto L170;
        List<AnchorLinkUser> r8 = r7.getMLinkUsers();
    L171:
        n(r6, r1, r8);
        LinkerEnterContent r12 = r1.mEnter;
        if (r12 == null) goto L174;
        Long r13 = Long.valueOf(r12.getVersion());
    L175:
        LinkerEnterContent r14 = r1.mEnter;
        if (r14 == null) goto L178;
        List r15 = r14.getMLinkUsers();
    L180:
        if (l(r13, r15) == true) goto L182;
        return;
    L182:
        hy.h r16 = this.m;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r1, "msg");
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("msg_id", Long.valueOf(r1.getMessageId3()));
        r17.put("msg_scene", Integer.valueOf(r1.mScene));
        r17.put("msg_linker_id", Long.valueOf(r1.getLinkerId()));
        LinkerEnterContent r18 = r1.mEnter;
        if (r18 == null) goto L191;
        o0.a r19 = o0.a;
        String r21 = r18.getUserIdString();
        r19.getClass();
        r17.put("enter_uid", o0.a.f(r21));
        List r22 = r18.getMLinkUsers();
        if (r22 == null) goto L190;
        String r23 = hy.d.b(r22);
        if (r23 == null) goto L190;
        r11 = r23;
    L190:
        r17.put("list_user", r11);
        r17.put("list_version", Long.valueOf(r18.getVersion()));
    L191:
        LinkerEnterContent r24 = r1.mEnter;
        if (r24 == null) goto L194;
        List r25 = r24.getMLinkUsers();
    L195:
        hy.h.n(r17, r25);
        if (r16.c == false) goto L198;
        r16.o("receive_linker_enter_msg", r17);
    L199:
        ListUpdateType r110 = ListUpdateType.ENTER_MSG;
        StringBuilder r26 = new StringBuilder("enter=");
        LinkerEnterContent r28 = r1.mEnter;
        if (r28 == null) goto L202;
        String r29 = r28.getUserIdString();
    L203:
        r26.append(r29);
        String r210 = r26.toString();
        int r31 = this.p;
        String r211 = String.valueOf(r1.getMessageId3());
        LinkerEnterContent r32 = r1.mEnter;
        if (r32 == null) goto L206;
        long r212 = r32.getVersion();
    L207:
        this.n = new b(r110, r210, r31, r211, r212, 32);
        LinkerEnterContent r33 = r1.mEnter;
        if (r33 == null) goto L210;
        List<AnchorLinkUser> r34 = r33.getMLinkUsers();
    L211:
        o(r34, "ENTER_MSG", null);
        return;
    L210:
        r34 = null;
        goto L211
    L206:
        r212 = 0;
        goto L207
    L202:
        r29 = null;
        goto L203
    L198:
        b0 r35 = b0.o();
        r35.getClass();
        com.bytedance.android.live.core.log.g.n(r16.a, "receive_linker_enter_msg " + r17);
        goto L199
    L194:
        r25 = null;
        goto L195
    L178:
        r15 = null;
        goto L180
    L174:
        r13 = null;
        goto L175
    L170:
        r8 = null;
        goto L171
    L166:
        r5 = null;
        goto L167
    L29:
        if (r2 == 7) goto L93;
        if (r2 == 10) goto L90;
        if (r2 != 11) goto L224;
        ILinkerLinkedListChangeContent r36 = r1.getMLinkedListChange();
        if ((r36 instanceof LinkerLinkedListChangeContent) == true) goto L36;
        r36 = null;
    L36:
        LinkerLinkedListChangeContent r37 = (LinkerLinkedListChangeContent) r36;
        if (r37 == null) goto L41;
        List r38 = r37.getMLinkUsers();
        if (r38 == null) goto L41;
        List<AnchorLinkUser> r39 = jm2.a.a(r38);
    L42:
        n("receive LINKER_LINKED_CHANGE", r1, r39);
        if (r37 == null) goto L45;
        Long r41 = Long.valueOf(r37.getVersion());
    L46:
        if (r37 == null) goto L50;
        List r42 = r37.getMLinkUsers();
        if (r42 == null) goto L50;
        List r43 = jm2.a.a(r42);
    L52:
        if (l(r41, r43) == true) goto L54;
        return;
    L54:
        ListUpdateType r111 = ListUpdateType.LINKED_CHANGE_MSG;
        int r44 = this.p;
        String r213 = String.valueOf(r1.getMessageId3());
        if (r37 == null) goto L57;
        long r214 = r37.getVersion();
    L58:
        this.n = new b(r111, "", r44, r213, r214, 32);
        hy.h r45 = this.m;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r1, "msg");
        LinkedHashMap r46 = new LinkedHashMap();
        r46.put("msg_id", Long.valueOf(r1.getMessageId3()));
        r46.put("msg_scene", Integer.valueOf(r1.mScene));
        r46.put("msg_linker_id", Long.valueOf(r1.getLinkerId()));
        ILinkerLinkedListChangeContent r47 = r1.getMLinkedListChange();
        if ((r47 instanceof LinkerLinkedListChangeContent) == true) goto L61;
        r47 = null;
    L61:
        LinkerLinkedListChangeContent r48 = (LinkerLinkedListChangeContent) r47;
        if (r48 == null) goto L72;
        List r49 = r48.getMLinkUsers();
        if (r49 == null) goto L71;
        List r51 = jm2.a.a(r49);
        if (r51 == null) goto L71;
        String r52 = hy.d.b(r51);
        if (r52 == null) goto L71;
        r11 = r52;
    L71:
        r46.put("list_user", r11);
        r46.put("list_version", Long.valueOf(r48.getVersion()));
    L72:
        ILinkerLinkedListChangeContent r53 = r1.getMLinkedListChange();
        if ((r53 instanceof LinkerLinkedListChangeContent) == true) goto L75;
        r53 = null;
    L75:
        LinkerLinkedListChangeContent r54 = (LinkerLinkedListChangeContent) r53;
        if (r54 == null) goto L80;
        List r55 = r54.getMLinkUsers();
        if (r55 == null) goto L80;
        List r56 = jm2.a.a(r55);
    L81:
        hy.h.n(r46, r56);
        if (r45.c == false) goto L84;
        r45.o("receive_link_list_change_msg", r46);
    L85:
        if (r37 == null) goto L89;
        List r57 = r37.getMLinkUsers();
        if (r57 == null) goto L89;
        r9 = jm2.a.a(r57);
    L89:
        o(r9, "LINKED_CHANGE", r1);
        return;
    L84:
        b0 r58 = b0.o();
        r58.getClass();
        com.bytedance.android.live.core.log.g.n(r45.a, "receive_link_list_change_msg " + r46);
    L80:
        r56 = null;
        goto L81
    L57:
        r214 = 0;
    L50:
        r43 = null;
        goto L52
    L45:
        r41 = null;
    L41:
        r39 = null;
        goto L42
    L224:
        return;
    L90:
        n("receive LINKER_WAITING_CHANGE", r1, null);
        if (this.k == false) goto L218;
        b(4, "receive_link_message_10");
        return;
    L218:
        return;
    L93:
        StringBuilder r59 = new StringBuilder("receive LINKER_LEAVE uid=");
        LinkerLeaveContent r61 = r1.mLeave;
        if (r61 == null) goto L96;
        String r62 = r61.getUserIdStr();
    L97:
        r59.append(r62);
        r59.append(' ');
        String r63 = r59.toString();
        LinkerLeaveContent r64 = r1.mLeave;
        if (r64 == null) goto L100;
        List<AnchorLinkUser> r65 = r64.getMLinkUsers();
    L101:
        n(r63, r1, r65);
        hy.h r66 = this.m;
        r66.getClass();
        Intrinsics.checkNotNullParameter(r1, "msg");
        LinkedHashMap r67 = new LinkedHashMap();
        r67.put("msg_id", Long.valueOf(r1.getMessageId3()));
        r67.put("msg_scene", Integer.valueOf(r1.mScene));
        r67.put("msg_linker_id", Long.valueOf(r1.getLinkerId()));
        LinkerLeaveContent r68 = r1.mLeave;
        if (r68 == null) goto L110;
        r67.put("list_version", Long.valueOf(r68.getVersion()));
        o0.a r69 = o0.a;
        String r71 = r68.getUserIdStr();
        r69.getClass();
        r67.put("leave_uid", o0.a.f(r71));
        List r72 = r68.getMLinkUsers();
        if (r72 == null) goto L109;
        String r73 = hy.d.b(r72);
        if (r73 == null) goto L109;
        r11 = r73;
    L109:
        r67.put("list_user", r11);
    L110:
        LinkerLeaveContent r74 = r1.mLeave;
        if (r74 == null) goto L113;
        List r75 = r74.getMLinkUsers();
    L114:
        hy.h.n(r67, r75);
        if (r66.c == false) goto L117;
        r66.o("receive_linker_leave_msg", r67);
    L119:
        if (((Boolean) ha1.a.getValue()).booleanValue() == false) goto L128;
        Iterator r76 = ((CopyOnWriteArrayList) this.a).iterator();
    L122:
        if (r76.hasNext() == false) goto L129;
        AnchorLinkUser r77 = (AnchorLinkUser) r76.next();
        LruCache<String, AnchorLinkUser> r78 = this.g;
        IBaseUser r79 = r77.getUser();
        if (r79 == null) goto L126;
        String r81 = r79.getIdString();
    L127:
        r78.put(r81, r77);
        goto L122
    L126:
        r81 = null;
    L129:
        boolean r82 = this.k;
        if (r82 == false) goto L155;
        if (r82 == false) goto L141;
        LiveData r83 = ey.a.a();
        if (r83 == null) goto L139;
        ey.f r84 = (ey.f) r83.getValue();
        if (r84 == null) goto L139;
        if (r84.d == 4) goto L141;
    L139:
        if (m() != 0) goto L141;
        boolean r85 = true;
    L142:
        if (r85 == false) goto L145;
        ALogger.e("ttlive_anchor_link_users", "intercept LINKER_LEAVE queryLinkList");
        return;
    L145:
        if (((Boolean) ja1.a.getValue()).booleanValue() == false) goto L154;
        ListUpdateType r112 = ListUpdateType.LEAVE_MSG;
        StringBuilder r86 = new StringBuilder("leave=");
        LinkerLeaveContent r87 = r1.mLeave;
        if (r87 == null) goto L149;
        String r88 = r87.getUserIdStr();
    L150:
        r86.append(r88);
        this.n = new b(r112, r86.toString(), this.p, String.valueOf(r1.getMessageId3()), 0, 48);
        LinkerLeaveContent r89 = r1.mLeave;
        if (r89 == null) goto L153;
        r9 = r89.getMLinkUsers();
    L153:
        o(r9, "LEAVE_MSG", r1);
        return;
    L149:
        r88 = null;
        goto L150
    L154:
        b(4, "receive_link_message_7");
        return;
    L141:
        r85 = false;
        goto L142
    L155:
        ListUpdateType r113 = ListUpdateType.LEAVE_MSG;
        StringBuilder r91 = new StringBuilder("leave=");
        LinkerLeaveContent r92 = r1.mLeave;
        if (r92 == null) goto L158;
        String r93 = r92.getUserIdStr();
    L159:
        r91.append(r93);
        this.n = new b(r113, r91.toString(), this.p, String.valueOf(r1.getMessageId3()), 0, 48);
        LinkerLeaveContent r94 = r1.mLeave;
        if (r94 == null) goto L162;
        r9 = r94.getMLinkUsers();
    L162:
        o(r9, "LEAVE_MSG", r1);
        return;
    L158:
        r93 = null;
        goto L159
    L128:
        this.f.clear();
        this.f.addAll(this.a);
        goto L129
    L117:
        b0 r95 = b0.o();
        r95.getClass();
        com.bytedance.android.live.core.log.g.n(r66.a, "receive_linker_leave_msg " + r67);
        goto L119
    L113:
        r75 = null;
        goto L114
    L100:
        r65 = null;
        goto L101
    L96:
        r62 = null;
        goto L97
    L13:
        if (r1.getLinkerId() == m()) goto L26;
        if (r1.getMType() == 6) goto L24;
        if (r1.getMType() == 7) goto L24;
        if (r1.getMType() == 11) goto L24;
        if (r1.getMType() != 10) goto L26;
    L24:
        if (m() == 0) goto L26;
        r1.getLinkerId();
        goto L26
    }

    public a(DataCenter r11, hy.g r12) {
        Intrinsics.checkNotNullParameter(r11, "mDataCenter");
        Intrinsics.checkNotNullParameter(r12, "channelIdGetter");
        this.o = r12;
        this.p = 17;
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new LruCache(15);
        this.h = new CompositeDisposable();
        this.i = new ArrayList();
        this.j = (vlc.d) r11.get("data_message_manager");
        boolean r0 = ((Boolean) r11.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.k = r0;
        Room r13 = (Room) r11.get("data_room", new Room());
        this.l = r13;
        this.m = new hy.h(r13, r0, r12);
        this.n = new b(ListUpdateType.NONE, null, 0, null, 0, 62);
    }

    @Override // hy.f
    public final void b(int r18, String r19) {
        Intrinsics.checkNotNullParameter(r19, "reqSrc");
        ALogger.w("ttlive_anchor_link_users", "queryLinkList channelId:" + m() + " status:" + r18 + " reqSrc:" + r19 + " scene=" + this.p);
        if (m() != 0) goto L5;
        return;
    L5:
        System.currentTimeMillis();
        LinkCrossRoomApi r2 = (LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class);
        long r3 = m();
        long r5 = r18;
        int r11 = this.p;
        boolean r12 = !this.k;
        Room r9 = this.l;
        if (r9 == null) goto L8;
        Long r13 = Long.valueOf(r9.id);
    L9:
        this.h.add(r2.getLinkAnchorList(r3, r5, 0, -1, r11, r12, r19, r13.longValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r19, r18), new h(this, r19, r18)));
        return;
    L8:
        r13 = null;
        goto L9
    }

    @Override // hy.e
    public final AnchorLinkUser f(String r8, boolean r9) {
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L3:
        boolean r2 = false;
        String r4 = null;
        if (r0.hasNext() == false) goto L38;
        AnchorLinkUser r1 = (AnchorLinkUser) r0.next();
        if (TextUtils.equals(r8, r1.getInteractId()) == true) goto L7;
        if (r9 == false) goto L3;
        if (r1.getAnchorLinkMicIdInfo() == null) goto L3;
        if (r8 != null) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == true) goto L3;
        AnchorLinkMicIdInfo r3 = r1.getAnchorLinkMicIdInfo();
        if (r3 == null) goto L24;
        String r5 = r3.mainLinkMicId;
    L26:
        if (TextUtils.equals(r8, r5) == true) goto L32;
        AnchorLinkMicIdInfo r6 = r1.getAnchorLinkMicIdInfo();
        if (r6 == null) goto L31;
        r4 = r6.backupLinkMicId;
    L31:
        if (TextUtils.equals(r8, r4) == false) goto L3;
    L32:
        AnchorLinkUser r11 = jm2.a.d(r1);
        if (r11 == null) goto L37;
        return r11;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L24:
        r5 = null;
        goto L26
    L18:
        if (r8.length() != 0) goto L20;
    L7:
        AnchorLinkUser r12 = jm2.a.d(r1);
        if (r12 == null) goto L12;
        return r12;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L38:
        Iterator r7 = ((CopyOnWriteArrayList) this.b).iterator();
    L40:
        if (r7.hasNext() == false) goto L71;
        AnchorLinkUser r13 = (AnchorLinkUser) r7.next();
        if (TextUtils.equals(r8, r13.getInteractId()) == true) goto L43;
        if (r9 == false) goto L40;
        if (r13.getAnchorLinkMicIdInfo() == null) goto L40;
        if (r8 != null) goto L49;
    L52:
        boolean r14 = true;
    L53:
        if (r14 == true) goto L40;
        AnchorLinkMicIdInfo r15 = r13.getAnchorLinkMicIdInfo();
        if (r15 == null) goto L57;
        String r16 = r15.mainLinkMicId;
    L59:
        if (TextUtils.equals(r8, r16) == true) goto L66;
        AnchorLinkMicIdInfo r17 = r13.getAnchorLinkMicIdInfo();
        if (r17 == null) goto L63;
        String r18 = r17.backupLinkMicId;
    L65:
        if (TextUtils.equals(r8, r18) == false) goto L40;
    L63:
        r18 = null;
    L66:
        ALogger.e("ttlive_anchor_link_users", "getLinkUserByInteractId from waitingList " + r13.toSimpleString());
        hy.h r19 = this.m;
        String r21 = r13.toSimpleString();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r21, "linkUserInfo");
        LinkedHashMap r22 = new LinkedHashMap();
        if (r8 != null) goto L69;
        r8 = "null";
    L69:
        r22.put("link_mic_id", r8);
        r22.put("link_user", r21);
        Intrinsics.checkNotNullParameter(r22, "params");
        r22.putAll(r19.m());
        r22.put("channel_id", Long.valueOf(r19.e.getChannelId()));
        r19.o("get_link_user_from_waiting_list_link_mic_id", r22);
        return r13;
    L57:
        r16 = null;
        goto L59
    L49:
        if (r8.length() == 0) goto L52;
        r14 = false;
        goto L53
    L43:
        return r13;
    L71:
        return null;
    }

    @Override // hy.f
    public final AnchorLinkUser getGuestInfo(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L3:
        boolean r2 = true;
        String r4 = null;
        if (r0.hasNext() == false) goto L22;
        AnchorLinkUser r1 = (AnchorLinkUser) r0.next();
        if (TextUtils.isEmpty(r13) == true) goto L11;
        if (TextUtils.equals(r13, r1.getInteractId()) == false) goto L11;
        return r1;
    L11:
        if (r12.length() > 0) goto L14;
        r2 = false;
    L14:
        if (r2 == false) goto L3;
        if (r1 == null) goto L20;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L20;
        r4 = r3.getIdString();
    L20:
        if (Intrinsics.areEqual(r12, r4) == false) goto L3;
        return r1;
    L22:
        Iterator r5 = ((CopyOnWriteArrayList) this.b).iterator();
    L24:
        if (r5.hasNext() == false) goto L43;
        AnchorLinkUser r6 = (AnchorLinkUser) r5.next();
        if (TextUtils.isEmpty(r13) == true) goto L31;
        if (TextUtils.equals(r13, r6.getInteractId()) == false) goto L31;
        return r6;
    L31:
        if (r12.length() <= 0) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == false) goto L24;
        if (r6 == null) goto L39;
        IBaseUser r8 = r6.getUser();
        if (r8 == null) goto L39;
        String r9 = r8.getIdString();
    L41:
        if (Intrinsics.areEqual(r12, r9) == false) goto L24;
        return r6;
    L39:
        r9 = null;
        goto L41
    L33:
        r7 = false;
        goto L34
    L43:
        Map<String, AnchorLinkUser> r11 = this.g.snapshot();
        if (r11 == null) goto L49;
        List r14 = new ArrayList(r11.size());
        Iterator<Map.Entry<String, AnchorLinkUser>> r15 = r11.entrySet().iterator();
    L47:
        if (r15.hasNext() == false) goto L50;
        r14.add(r15.next().getValue());
    L50:
        Iterator r16 = r14.iterator();
    L52:
        if (r16.hasNext() == false) goto L73;
        AnchorLinkUser r17 = (AnchorLinkUser) r16.next();
        if (TextUtils.isEmpty(r13) == true) goto L60;
        if (TextUtils.equals(r13, r17.getInteractId()) == false) goto L60;
        ALogger.w("ttlive_anchor_link_users", "get linkUser " + r13 + " from cacheList " + r17 + ' ' + hy.d.b(r14));
        return r17;
    L60:
        if (r12.length() <= 0) goto L62;
        boolean r18 = true;
    L63:
        if (r18 == false) goto L52;
        if (r17 == null) goto L68;
        IBaseUser r19 = r17.getUser();
        if (r19 == null) goto L68;
        String r21 = r19.getIdString();
    L70:
        if (Intrinsics.areEqual(r12, r21) == false) goto L52;
        ALogger.w("ttlive_anchor_link_users", "get linkUser " + r12 + " from cacheList " + r17 + ' ' + hy.d.b(r14));
        return r17;
    L68:
        r21 = null;
        goto L70
    L62:
        r18 = false;
        goto L63
    L73:
        return null;
    L49:
        r14 = CollectionsKt.emptyList();
        goto L50
    }

    public final boolean l(Long r7, List r8) {
        if (this.k == false) goto L26;
        if (r7 == null) goto L26;
        if (r7.longValue() == 0) goto L26;
        if (this.n.getType().isVersionMsg() == false) goto L26;
        if (this.n.e <= r7.longValue()) goto L26;
        StringBuilder r9 = new StringBuilder();
        r9.append(((CopyOnWriteArrayList) this.a).size());
        r9.append("->");
        if (r8 == null) goto L15;
        Integer r0 = Integer.valueOf(r8.size());
    L16:
        r9.append(r0);
        String r11 = r9.toString();
        long r2 = this.n.e;
        if (r8 != null) goto L19;
    L22:
        boolean r12 = true;
    L23:
        if (r12 == false) goto L26;
        ALogger.e("ttlive_anchor_link_users", "not consume old version list " + r11);
        return false;
    L19:
        if (r8.size() != ((CopyOnWriteArrayList) this.a).size()) goto L22;
        r12 = false;
        goto L23
    L15:
        r0 = null;
    L26:
        return true;
    }

    public final void n(String r5, if r6, List<AnchorLinkUser> r7) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r5);
        String r8 = "";
        if (r6 == null) goto L6;
        Intrinsics.checkNotNullParameter(r6, "$this$anchorLinkBaseInfoStr");
        String r9 = "(msgId=" + r6.getMessageId3() + " linkerId=" + r6.getLinkerId() + " scene=" + r6.mScene + ')';
        if (r9 == null) goto L6;
    L7:
        r0.append(r9);
        r0.append("  ");
        if (r7 == null) goto L13;
        String r11 = hy.d.b(r7);
        if (r11 == null) goto L13;
        r8 = r11;
    L13:
        r0.append(r8);
        r0.append(" last:");
        r0.append(this.n);
        ALogger.w("ttlive_anchor_link_users", r0.toString());
        return;
    L6:
        r9 = "";
        goto L7
    }

    public final void o(List<AnchorLinkUser> r11, String r12, if r13) {
        ((CopyOnWriteArrayList) this.a).clear();
        if (r11 == null) goto L5;
        ((CopyOnWriteArrayList) this.a).addAll(r11);
    L5:
        Iterator<hy.f.b> r0 = this.i.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().d(this.p, this.a);
        goto L7
    L9:
        List<AnchorLinkUser> r1 = this.b;
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((CopyOnWriteArrayList) r1).iterator();
    L10:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L35;
        Object r5 = r3.next();
        AnchorLinkUser r6 = (AnchorLinkUser) r5;
        Object r7 = null;
        if (r11 == null) goto L29;
        Iterator<T> r8 = r11.iterator();
    L16:
        if (r8.hasNext() == false) goto L28;
        Object r9 = r8.next();
        IBaseUser r14 = ((AnchorLinkUser) r9).getUser();
        if (r14 == null) goto L20;
        String r15 = r14.getIdString();
    L21:
        IBaseUser r16 = r6.getUser();
        if (r16 == null) goto L24;
        String r17 = r16.getIdString();
    L26:
        if (Intrinsics.areEqual(r15, r17) == false) goto L16;
        r7 = r9;
        goto L28
    L24:
        r17 = null;
        goto L26
    L20:
        r15 = null;
    L28:
        r7 = (AnchorLinkUser) r7;
    L29:
        if (r7 != null) goto L32;
        r4 = false;
    L32:
        if (r4 == false) goto L10;
        r2.add(r5);
        goto L10
    L35:
        if ((!r2.isEmpty()) == false) goto L37;
        ((CopyOnWriteArrayList) this.b).removeAll(r2);
        ALogger.w("ttlive_anchor_link_users", r12 + " ALREADY linkedUserInWaitingList: " + hy.d.b(r2));
    L37:
        this.e.clear();
        this.e.addAll(this.a);
        this.e.addAll(this.b);
        ALogger.w("ttlive_anchor_link_users", "updateList " + r12 + " waiting: " + hy.d.b(this.b) + " online:" + hy.d.b(this.a));
        hy.h r18 = this.m;
        List<AnchorLinkUser> r19 = this.a;
        if (r13 == null) goto L41;
        String r110 = r13.toString();
        if (r110 == null) goto L41;
    L42:
        r18.l(r12, r19, r110);
        Iterator<hy.f.b> r111 = this.i.iterator();
    L44:
        if (r111.hasNext() == false) goto L46;
        r111.next().b(this.p, this.e);
        goto L44
    L46:
        return;
    L41:
        r110 = "";
        goto L42
    }
}
