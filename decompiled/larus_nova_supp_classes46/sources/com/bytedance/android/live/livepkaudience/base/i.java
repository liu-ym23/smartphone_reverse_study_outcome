package com.bytedance.android.live.livepkaudience.base;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.anchorlink.network.LinkCrossRoomApi;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserContent;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicAudienceContent;
import com.bytedance.android.live.liveinteract.multianchor.model.MicDress;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkedListUserInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListResponse;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.k9;
import com.bytedance.android.livesdk.config.sh0;
import com.bytedance.android.livesdk.config.tv0;
import com.bytedance.android.livesdk.config.uh0;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.message.model.LinkerContributeMessage;
import com.bytedance.android.livesdk.message.model.gf;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContentKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnterContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLinkedListChangeContent;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements com.bytedance.android.live.pkaudience.api.a, vlc.l {
    public final String a;
    public final int b;
    public final CopyOnWriteArrayList<LinkPlayerInfo> c;
    public final CopyOnWriteArrayList<LinkPlayerInfo> d;
    public final CopyOnWriteArrayList<LinkPlayerInfo> e;
    public final CopyOnWriteArrayList<LinkPlayerInfo> f;
    public final CopyOnWriteArrayList<LinkPlayerInfo> g;
    public final CopyOnWriteArrayList<LinkPlayerInfo> h;
    public final CopyOnWriteArrayList<LinkPlayerInfo> i;
    public final vlc.d j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final List<z> n;
    public final CompositeDisposable o;
    public final Map<Long, Long> p;
    public final Boolean q;
    public final Set<Integer> r;
    public a s;
    public long t;
    public long u;
    public final z01 v;
    public final boolean w;
    public final v x;
    public boolean y;
    public final DataCenter z;

    public static final class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L14;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            String r6 = this.c;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            String r9 = this.d;
            if (r9 == null) goto L14;
            r3 = r9.hashCode();
        L14:
            return r8 + r3;
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "RefreshInfo(timestamp=" + this.a + ", from=" + this.b + ", logId=" + this.c + ", extra=" + this.d + ")";
        }

        public a(long r2, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "from");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.network.response.a) r2, "response");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.e(this.a.a, "sendSignalV1 Background failed " + r5);
            ALogger.stacktrace(6, this.a.a, r5.getStackTrace());
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.network.response.a) r2, "response");
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ i a;

        public e(i r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            ALogger.e(this.a.a, "sendSignalV1 Foreground failed " + r5);
            ALogger.stacktrace(6, this.a.a, r5.getStackTrace());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ long b;

        public f(i r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r17) {
            Response r1 = (Response) r17;
            this.a.l = false;
            if (r1 == null) goto L178;
            com.bytedance.android.livesdk.message.linker.a r2 = (com.bytedance.android.livesdk.message.linker.a) r1.data;
            if (r2 == null) goto L218;
            Map r3 = r2.a();
            if (r3 == null) goto L219;
            this.a.c.clear();
            Iterator r4 = r3.entrySet().iterator();
        L10:
            if (r4.hasNext() == false) goto L71;
            Map.Entry r5 = (Map.Entry) r4.next();
            long r6 = ((Number) r5.getKey()).longValue();
            RoomLinkerContent r7 = (RoomLinkerContent) r5.getValue();
            CopyOnWriteArrayList<LinkPlayerInfo> r8 = this.a.c;
            if (r7 == null) goto L31;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r11 = r7.linkedUsers;
            if (r11 == null) goto L31;
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r11.iterator();
        L17:
            if (r13.hasNext() == false) goto L30;
            T r14 = r13.next();
            com.bytedance.android.livesdk.link.model.bridge.k r15 = (com.bytedance.android.livesdk.link.model.bridge.k) r14;
            if (r15.getStatus() != 2) goto L27;
            IBaseUser r16 = r15.getUser();
            if (r16 == null) goto L23;
            String r18 = r16.getIdString();
        L24:
            this.a.getClass();
            if ((!Intrinsics.areEqual(r18, i.j())) == false) goto L27;
            boolean r19 = true;
        L28:
            if (r19 == false) goto L17;
            r12.add(r14);
            goto L17
        L23:
            r18 = null;
        L27:
            r19 = false;
            goto L28
        L30:
            Long r110 = Long.valueOf(r6);
            ((com.bytedance.android.livesdk.message.linker.a) r1.data).getClass();
            List r111 = dl0.n.g(r12, r110);
        L32:
            r8.addAll(r111);
            if (r6 == this.a.n().getRoomId()) goto L10;
            this.a.d.clear();
            CopyOnWriteArrayList<LinkPlayerInfo> r9 = this.a.d;
            if (r7 == null) goto L48;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r10 = r7.linkedUsers;
            if (r10 == null) goto L48;
            ArrayList r112 = new ArrayList();
            Iterator<T> r20 = r10.iterator();
        L40:
            if (r20.hasNext() == false) goto L47;
            T r113 = r20.next();
            if (((com.bytedance.android.livesdk.link.model.bridge.k) r113).getStatus() != 2) goto L44;
            boolean r114 = true;
        L45:
            if (r114 == false) goto L40;
            r112.add(r113);
            goto L40
        L44:
            r114 = false;
            goto L45
        L47:
            Long r21 = Long.valueOf(r6);
            ((com.bytedance.android.livesdk.message.linker.a) r1.data).getClass();
            List r22 = dl0.n.g(r112, r21);
        L49:
            r9.addAll(r22);
            Iterator<LinkPlayerInfo> r23 = this.a.d.iterator();
        L51:
            if (r23.hasNext() == false) goto L10;
            LinkPlayerInfo r24 = r23.next();
            if (r24.getUser() == null) goto L61;
            IBaseUser r25 = r24.getUser();
            if (r25 == null) goto L57;
            String r26 = r25.getIdString();
        L58:
            this.a.getClass();
            if ((!Intrinsics.areEqual(r26, i.j())) == false) goto L61;
            this.a.c.add(r24);
            goto L61
        L57:
            r26 = null;
        L61:
            Iterator<LinkPlayerInfo> r27 = this.a.h.iterator();
        L63:
            if (r27.hasNext() == false) goto L67;
            LinkPlayerInfo r28 = r27.next();
            this.a.getClass();
            if (i.x(r28, r24) == false) goto L63;
        L68:
            if (r28 != null) goto L51;
            this.a.d(r24);
            goto L51
        L67:
            r28 = null;
        L48:
            r22 = CollectionsKt.emptyList();
        L31:
            r111 = CollectionsKt.emptyList();
            goto L32
        L71:
            if (this.a.q.booleanValue() == true) goto L73;
        L75:
            i r29 = this.a;
            CopyOnWriteArrayList<LinkPlayerInfo> r30 = r29.c;
            CopyOnWriteArrayList<LinkPlayerInfo> r31 = r29.d;
            long r32 = System.currentTimeMillis() - this.b;
            int r33 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            LinkedHashMap r34 = new LinkedHashMap();
            com.bytedance.android.live.liveinteract.plantform.utils.x.a(r34);
            int r35 = -1;
            if (r30 == null) goto L78;
            int r36 = r30.size();
        L79:
            r34.put("list_size", Integer.valueOf(r36));
            if (r31 == null) goto L82;
            r35 = r31.size();
        L82:
            r34.put("target_list_size", Integer.valueOf(r35));
            r34.put("duration", Long.valueOf(r32));
            StringBuilder r37 = new StringBuilder();
            if (r30 == null) goto L127;
            ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
            Iterator<LinkPlayerInfo> r38 = r30.iterator();
        L86:
            if (r38.hasNext() == false) goto L91;
            LinkPlayerInfo r39 = r38.next();
            if ((r39 instanceof ILinkPlayerInfoBridge) == true) goto L90;
            r39 = null;
        L90:
            r115.add(r39);
            goto L86
        L91:
            Iterator r40 = r115.iterator();
        L93:
            if (r40.hasNext() == false) goto L127;
            ILinkPlayerInfoBridge r41 = (ILinkPlayerInfoBridge) r40.next();
            r37.append("[uid=");
            if (r41 == null) goto L99;
            IBaseUser r42 = r41.getUser();
            if (r42 == null) goto L99;
            String r43 = r42.getIdString();
        L100:
            r37.append(r43);
            r37.append(", pos=");
            if (r41 == null) goto L103;
            Integer r44 = Integer.valueOf(r41.getUserPositionFlex());
        L104:
            r37.append(r44);
            r37.append(", silence=");
            if (r41 == null) goto L107;
            Integer r45 = Integer.valueOf(r41.getSilenceStatus());
        L108:
            r37.append(r45);
            r37.append(", linkId=");
            if (r41 == null) goto L111;
            String r46 = r41.getInteractId();
        L112:
            r37.append(r46);
            r37.append(", linkType=");
            if (r41 == null) goto L115;
            Integer r47 = Integer.valueOf(r41.getLinkType());
        L116:
            r37.append(r47);
            r37.append(", background=");
            if (r41 == null) goto L119;
            Boolean r48 = Boolean.valueOf(r41.isBackground());
        L120:
            r37.append(r48);
            r37.append(", ");
            if (r41 == null) goto L123;
            com.bytedance.android.live.liveinteract.plantform.model.o r49 = r41.getLinkedListUserInfo();
        L124:
            if (r49 == null) goto L126;
            r37.append(r41.getLinkedListUserInfo());
            r37.append(", ");
        L126:
            r37.append("] ");
            goto L93
        L123:
            r49 = null;
            goto L124
        L119:
            r48 = null;
            goto L120
        L115:
            r47 = null;
            goto L116
        L111:
            r46 = null;
            goto L112
        L107:
            r45 = null;
            goto L108
        L103:
            r44 = null;
        L99:
            r43 = null;
        L127:
            r37.append("}");
            if (r31 == null) goto L172;
            ArrayList r50 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
            Iterator<LinkPlayerInfo> r51 = r31.iterator();
        L131:
            if (r51.hasNext() == false) goto L136;
            LinkPlayerInfo r52 = r51.next();
            if ((r52 instanceof ILinkPlayerInfoBridge) == true) goto L135;
            r52 = null;
        L135:
            r50.add(r52);
            goto L131
        L136:
            Iterator r53 = r50.iterator();
        L138:
            if (r53.hasNext() == false) goto L172;
            ILinkPlayerInfoBridge r54 = (ILinkPlayerInfoBridge) r53.next();
            r37.append("[uid=");
            if (r54 == null) goto L144;
            IBaseUser r55 = r54.getUser();
            if (r55 == null) goto L144;
            String r56 = r55.getIdString();
        L145:
            r37.append(r56);
            r37.append(", pos=");
            if (r54 == null) goto L148;
            Integer r57 = Integer.valueOf(r54.getUserPositionFlex());
        L149:
            r37.append(r57);
            r37.append(", silence=");
            if (r54 == null) goto L152;
            Integer r58 = Integer.valueOf(r54.getSilenceStatus());
        L153:
            r37.append(r58);
            r37.append(", linkId=");
            if (r54 == null) goto L156;
            String r59 = r54.getInteractId();
        L157:
            r37.append(r59);
            r37.append(", linkType=");
            if (r54 == null) goto L160;
            Integer r60 = Integer.valueOf(r54.getLinkType());
        L161:
            r37.append(r60);
            r37.append(", background=");
            if (r54 == null) goto L164;
            Boolean r61 = Boolean.valueOf(r54.isBackground());
        L165:
            r37.append(r61);
            r37.append(", ");
            if (r54 == null) goto L168;
            com.bytedance.android.live.liveinteract.plantform.model.o r62 = r54.getLinkedListUserInfo();
        L169:
            if (r62 == null) goto L171;
            r37.append(r54.getLinkedListUserInfo());
            r37.append(", ");
        L171:
            r37.append("] ");
            goto L138
        L168:
            r62 = null;
            goto L169
        L164:
            r61 = null;
            goto L165
        L160:
            r60 = null;
            goto L161
        L156:
            r59 = null;
            goto L157
        L152:
            r58 = null;
            goto L153
        L148:
            r57 = null;
        L144:
            r56 = null;
        L172:
            r37.append("}");
            r34.put("msg_content", r37.toString());
            r34.put("event_name", "online_list_request");
            b0.o().j("ttlive_link", r34);
            Iterator r63 = ((ArrayList) this.a.n).iterator();
        L174:
            if (r63.hasNext() == false) goto L220;
            z r65 = (z) r63.next();
            if (r65 == null) goto L174;
            r65.onOnlineListChanged(this.a.c);
            goto L174
        L220:
            return;
        L78:
            r36 = -1;
            goto L79
        L73:
            if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L75;
            String r66 = this.a.a;
            StringBuilder r67 = new StringBuilder("queryAllOnlineList  mGuestOnlineUserList = ");
            r67.append(this.a.d);
            r67.append(", mOnlineUserList = ");
            r67.append(this.a.c);
            r67.append(", getGuestAnchorId = ");
            this.a.getClass();
            r67.append(i.j());
            ALogger.w(r66, r67.toString());
            goto L75
        L219:
            return;
        L218:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ i a;

        public g(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.l = false;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;

        public h(i r1, long r2) {
            this.a = r1;
            this.b = r2;
            this.c = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            Intrinsics.checkNotNullParameter(r8, "response");
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            String r3 = r8.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r1, r3);
            this.a.k = false;
            List<WaitingListUser> r2 = ((WaitingListResponse) r8.data).getMWaitingUserInfo();
            if (r2 == null) goto L5;
            ArrayList<LinkPlayerInfo> r4 = dl0.n.f(r2);
        L6:
            long r5 = ((WaitingListResponse) r8.data).getTotalCount();
            if (Lists.isEmpty(r4) == false) goto L9;
            this.a.e.clear();
        L10:
            com.bytedance.android.live.liveinteract.plantform.utils.x.Q(r5, this.c, false);
            i r6 = this.a;
            CopyOnWriteArrayList<LinkPlayerInfo> r9 = r6.f;
            ArrayList r10 = new ArrayList();
            Iterator<LinkPlayerInfo> r11 = r9.iterator();
        L12:
            if (r11.hasNext() == false) goto L16;
            LinkPlayerInfo r12 = r11.next();
            CopyOnWriteArrayList<LinkPlayerInfo> r13 = r6.e;
            if (i.f(r13, r12) == false) goto L12;
            r10.add(r12);
            goto L12
        L16:
            r6.f.clear();
            r6.f.addAll(r10);
            tc0.c.h().getClass();
            Iterator r14 = ((ArrayList) this.a.n).iterator();
        L18:
            if (r14.hasNext() == false) goto L20;
            ((z) r14.next()).e(this.a.e, ((WaitingListResponse) r8.data).getWaitingUser());
            goto L18
        L20:
            return;
        L9:
            this.a.e.clear();
            this.a.e.addAll(r4);
            goto L10
        L5:
            r4 = new ArrayList();
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.base.i$i, reason: collision with other inner class name */
    public static final class C0112i<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ long b;

        public C0112i(i r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r1, r5);
            this.a.getClass();
            ALogger.stacktrace(6, "ttlive_link", r5.getStackTrace());
            this.a.k = false;
        }
    }

    public static String j() {
        return jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().a();
    }

    public final void B() {
        gm2.i r0 = new gm2.i();
        r0.type = 100101;
        r0.senderUserId = jc1.k.n(IUserService.class).user().n().toString();
        r0.senderInteractIdStr = tc0.c.h().f;
        r0.targetUserId = "0";
        r0.targetInteractId = "0";
        r0.targetInteractIdStr = "0";
        ALogger.w(this.a, "sendSignalV1 onEnterBackground " + tc0.c.h().f + " ");
        this.o.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendSignalV1(n().id, GsonProtectorUtils.toJson(GsonHelper.get(), r0), null, null, "").subscribeOn(Schedulers.io()).subscribe(b.a, new c(this)));
    }

    public final void C() {
        gm2.i r0 = new gm2.i();
        r0.type = 100102;
        r0.senderUserId = jc1.k.n(IUserService.class).user().n().toString();
        r0.senderInteractIdStr = tc0.c.h().f;
        r0.targetUserId = "0";
        r0.targetInteractId = "0";
        r0.targetInteractIdStr = "0";
        ALogger.w(this.a, "sendSignalV1 onEnterForeground " + tc0.c.h().f + " ");
        this.o.add(RxCompatKt.b(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendSignalV1(n().id, GsonProtectorUtils.toJson(GsonHelper.get(), r0), null, null, "").toObservable(), new com.bytedance.android.live.core.utils.rxutils.l(5, 3000)).subscribeOn(Schedulers.io()).subscribe(d.a, new e(this)));
    }

    @Override // com.bytedance.android.live.pkaudience.api.a
    public final int b() {
        int r1 = 0;
        if (Lists.isEmpty(this.c) == false) goto L5;
        return 0;
    L5:
        Iterator<LinkPlayerInfo> r0 = this.c.iterator();
        String r2 = "";
    L7:
        if (r0.hasNext() == false) goto L28;
        LinkPlayerInfo r3 = r0.next();
        StringBuilder r5 = new StringBuilder();
        r5.append(r2);
        if (r3 == null) goto L14;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L14;
        String r6 = r4.getIdString();
        if (r6 == null) goto L14;
    L15:
        r5.append(r6);
        r5.append(" ");
        r2 = r5.toString();
        IBaseUser r7 = null;
        if (r3 == null) goto L24;
        IBaseUser r8 = r3.getUser();
        if (r8 == null) goto L20;
        String r9 = r8.getIdString();
    L22:
        if ((!Intrinsics.areEqual(r9, n().getOwnerUserIdString())) == false) goto L24;
        r1 = r1 + 1;
        goto L24
    L20:
        r9 = null;
    L24:
        if (r3 == null) goto L26;
        r7 = r3.getUser();
    L26:
        if (r7 != null) goto L7;
        ALogger.w(this.a, "user null getOnLineCount count=" + r1 + ", guestOnlineCount = " + l() + ", info=" + r3.toString());
    L14:
        r6 = "null";
        goto L15
    L28:
        int r10 = r1 - l();
        if (this.q.booleanValue() == true) goto L31;
    L34:
        return r10;
    L31:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L34;
        if (r10 <= 0) goto L34;
        ALogger.w(this.a, "getOnLineCount count=" + r1 + ", guestOnlineCount = " + l() + ", mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j() + ", mRoom.ownerUserId = " + n().getOwnerUserIdString() + ", checkUserIdStr = " + r2);
        goto L34
    }

    public final void e() {
        ALogger.w(this.a, "attach");
        vlc.d r0 = this.j;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
        this.j.addMessageListener(MessageType.LINKER.getIntType(), this);
        this.j.addMessageListener(MessageType.LINK_MIC_SIGNAL.getIntType(), this);
        this.j.addMessageListener(MessageType.LINKER_CONTRIBUTE_MESSAGE.getIntType(), this);
        this.j.addMessageListener(MessageType.LINK_MIC_POSITION.getIntType(), this);
    L5:
        this.m = true;
        H(false, "interactiveModeStart");
    }

    public final void g() {
        ALogger.w(this.a, "detach");
        if (this.q.booleanValue() == true) goto L5;
    L7:
        this.m = false;
        this.o.clear();
        this.c.clear();
        this.d.clear();
        this.g.clear();
        this.h.clear();
        ((ArrayList) this.n).clear();
        ((HashMap) this.p).clear();
        vlc.d r0 = this.j;
        if (r0 == null) goto L11;
        r0.removeMessageListener(this);
        return;
    L11:
        return;
    L5:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L7;
        ALogger.w(this.a, "detach  guestOnlineCount = " + l() + ", mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j() + ", mRoom.ownerUserId = " + n().getOwnerUserIdString() + ", ");
        goto L7
    }

    public final List<LinkPlayerInfo> h() {
        Iterator<LinkPlayerInfo> r0 = this.d.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L11;
        LinkPlayerInfo r1 = r0.next();
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L9;
        r2 = r3.getIdString();
    L9:
        if (Intrinsics.areEqual(r2, j()) == false) goto L3;
        r2 = r1;
    L11:
        LinkPlayerInfo r4 = (LinkPlayerInfo) r2;
        if (r4 != null) goto L14;
        r4 = new LinkPlayerInfo();
        r4.setInteractId(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().y());
        User r5 = new User();
        r5.setIdStr(j());
        Unit r6 = Unit.INSTANCE;
        r4.mUser = r5;
    L14:
        ArrayList r7 = new ArrayList();
        r7.addAll(this.c);
        r7.add(r4);
        return r7;
    }

    public final Pair<List<LinkPlayerInfo>, List<LinkPlayerInfo>> i() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        CopyOnWriteArrayList<LinkPlayerInfo> r2 = this.c;
        if ((!r2.isEmpty()) == false) goto L17;
        Iterator<LinkPlayerInfo> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L17;
        LinkPlayerInfo r4 = r3.next();
        IBaseUser r6 = r4.getUser();
        if (r6 == null) goto L10;
        String r7 = r6.getIdString();
    L11:
        if (r7 == null) goto L6;
        if (q0.a(r7) != true) goto L6;
        if (A(r7) == false) goto L6;
        r0.add(r4);
        goto L6
    L10:
        r7 = null;
    L17:
        CopyOnWriteArrayList<LinkPlayerInfo> r5 = this.d;
        if ((!r5.isEmpty()) == false) goto L35;
        Iterator<LinkPlayerInfo> r8 = r5.iterator();
    L21:
        if (r8.hasNext() == false) goto L35;
        LinkPlayerInfo r9 = r8.next();
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L25;
        String r11 = r10.getIdString();
    L26:
        if (r11 == null) goto L21;
        if (q0.a(r11) != true) goto L21;
        if ((!Intrinsics.areEqual(r11, j())) == false) goto L21;
        if (w(r11) == false) goto L21;
        r1.add(r9);
        goto L21
    L25:
        r11 = null;
    L35:
        return new Pair(r0, r1);
    }

    public final int l() {
        if (this.d.size() > 0) goto L7;
        return 0;
    L7:
        return this.d.size() - 1;
    }

    public final Room n() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new Room();
    }

    public final List<LinkPlayerInfo> p() {
        CopyOnWriteArrayList<LinkPlayerInfo> r0 = this.e;
        ArrayList r1 = new ArrayList();
        Iterator<LinkPlayerInfo> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        LinkPlayerInfo r3 = r2.next();
        if ((!f(this.f, r3)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public i(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        this.z = r3;
        this.a = "ttlive_link_list_pk";
        this.b = 6;
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = (vlc.d) r3.get("data_message_manager");
        this.n = new ArrayList();
        this.o = new CompositeDisposable();
        this.p = new HashMap();
        this.q = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        this.r = SetsKt.setOf(new Integer[]{4, 8});
        z01 r4 = (z01) k9.a.getValue();
        this.v = r4;
        this.w = r4.enable;
        this.x = new v();
    }

    public final boolean A(String r6) {
        Iterator<LinkPlayerInfo> r0 = this.d.iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L11;
        IBaseUser r1 = r0.next().getUser();
        if (r1 == null) goto L9;
        r3 = r1.getIdString();
    L9:
        if (Intrinsics.areEqual(r3, r6) == false) goto L3;
        return false;
    L11:
        Iterator<LinkPlayerInfo> r2 = this.c.iterator();
    L13:
        if (r2.hasNext() == false) goto L29;
        LinkPlayerInfo r4 = r2.next();
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L17;
        String r7 = r5.getIdString();
    L19:
        if (Intrinsics.areEqual(r7, r6) == false) goto L13;
        if (r4.getUser() == null) goto L13;
        IBaseUser r8 = r4.getUser();
        if (r8 == null) goto L25;
        String r9 = r8.getIdString();
    L27:
        if ((!Intrinsics.areEqual(r9, n().getOwnerUserIdString())) == false) goto L13;
        return true;
    L25:
        r9 = null;
        goto L27
    L17:
        r7 = null;
        goto L19
    L29:
        return false;
    }

    public final boolean D(if r23) {
        boolean r1 = false;
        if (r23.getMUpdateUser() != null) goto L5;
        return false;
    L5:
        ILinkerUpdateUserContent r8 = r23.getMUpdateUser();
        if (r8 != null) goto L8;
        return false;
    L8:
        List r0 = r8.getMLinkUsers();
        List<AnchorLinkUser> r2 = jm2.a.a(r0);
        Map r3 = r8.getLinkerContentMap();
        Object r10 = null;
        if (r3 == null) goto L43;
        LinkedHashMap r6 = new LinkedHashMap(MapsKt.mapCapacity(r3.size()));
        Iterator r4 = r3.entrySet().iterator();
        ArrayList r12 = null;
        boolean r11 = false;
        long r13 = 0;
    L12:
        if (r4.hasNext() == false) goto L44;
        Map.Entry r14 = (Map.Entry) r4.next();
        Map r15 = r8.getLinkerContentMap();
        if (r15 == null) goto L22;
        g2 r16 = (g2) r15.get(r14.getKey());
        if (r16 == null) goto L22;
        List r17 = r16.getLinkedUsers();
        if (r17 == null) goto L22;
        List r18 = CollectionsKt.toMutableList(r17);
        if (r18 == null) goto L22;
        Long r19 = (Long) r14.getKey();
        r8.getLinkerContentMap();
        r12 = dl0.n.g(r18, r19);
    L23:
        Map r110 = r8.getLinkerContentMap();
        if (r110 == null) goto L28;
        g2 r111 = (g2) r110.get(r14.getKey());
        if (r111 == null) goto L28;
        r13 = r111.getMVersion();
    L29:
        boolean r112 = F(r13, "onLinkerUpdate");
        if (r112 == false) goto L42;
        Map r5 = r8.getLinkerContentMap();
        if (r5 == null) goto L42;
        g2 r7 = (g2) r5.get(r14.getKey());
        if (r7 == null) goto L42;
        List r9 = r7.getLinkedUsers();
        if (r9 == null) goto L42;
        if (r9.size() <= 1) goto L42;
        if (r2 == null) goto L41;
        r2 = CollectionsKt.plus(r2, jm2.a.c(r9));
        goto L42
    L41:
        r2 = null;
    L42:
        r6.put(Unit.INSTANCE, r14.getValue());
        r11 = r112;
    L28:
        r13 = 0;
    L22:
        r12 = null;
    L44:
        Long r20 = Long.valueOf(r23.getMessageId3());
        String r21 = ILinkerUpdateUserContentKt.getToUserIdString(r8);
        String r22 = r8.toString();
        if (r0 == null) goto L47;
        Integer r24 = Integer.valueOf(r0.size());
    L48:
        com.bytedance.android.live.liveinteract.plantform.utils.x.V(r20, r21, r22, r24);
        if (ILinkerUpdateUserContentKt.isBackgroundStatusUpdate(r8) != true) goto L191;
        Iterator<LinkPlayerInfo> r25 = this.c.iterator();
    L52:
        if (r25.hasNext() == false) goto L60;
        LinkPlayerInfo r26 = r25.next();
        o0.a r27 = o0.a;
        IBaseUser r28 = r26.getUser();
        if (r28 == null) goto L56;
        String r29 = r28.getIdString();
    L57:
        String r30 = ILinkerUpdateUserContentKt.getFromUserIdString(r8);
        r27.getClass();
        if (o0.a.a(r29, r30) == false) goto L52;
    L61:
        LinkPlayerInfo r31 = r26;
        JsonObject r32 = JsonUtil.parseObject(r8.getExtra());
        if (r31 == null) goto L134;
        if (r32 == null) goto L134;
        if (r32.has("shouldUpdateAllGuestActiveStatus") == false) goto L134;
        if (Intrinsics.areEqual("1", r32.get("shouldUpdateAllGuestActiveStatus").getAsString()) == false) goto L134;
        ALogger.e(this.a, "shouldUpdateAllGuestActiveStatus, all user isBackground set to " + ILinkerUpdateUserContentKt.isBackground(r8));
        Iterator<LinkPlayerInfo> r33 = this.c.iterator();
    L70:
        if (r33.hasNext() == false) goto L116;
        LinkPlayerInfo r34 = r33.next();
        int r35 = this.c.indexOf(r34);
        LinkPlayerInfo r36 = r34.copy();
        if (ILinkerUpdateUserContentKt.isBackground(r8) == true) goto L114;
        String r113 = n().getOwnerUserIdString();
        IBaseUser r114 = r36.getUser();
        if (r114 == null) goto L76;
        String r115 = r114.getIdString();
    L78:
        if (Intrinsics.areEqual(r113, r115) == true) goto L114;
        List r116 = r8.getMLinkUsers();
        if (r116 == null) goto L106;
        Iterator r117 = r116.iterator();
    L84:
        if (r117.hasNext() == false) goto L100;
        Object r118 = r117.next();
        IBaseUser r119 = ((com.bytedance.android.livesdk.link.model.bridge.k) r118).getUser();
        if (r119 == null) goto L90;
        String r120 = r119.getIdString();
        if (r120 == null) goto L90;
        Long r121 = Long.valueOf(d5.c(r120));
    L91:
        IBaseUser r122 = r36.getUser();
        if (r122 == null) goto L96;
        String r123 = r122.getIdString();
        if (r123 == null) goto L96;
        Long r124 = Long.valueOf(d5.c(r123));
    L98:
        if (Intrinsics.areEqual(r121, r124) == false) goto L84;
    L101:
        com.bytedance.android.livesdk.link.model.bridge.k r125 = (com.bytedance.android.livesdk.link.model.bridge.k) r118;
        if (r125 == null) goto L106;
        if (r125.isBackground() != 1) goto L106;
        boolean r126 = true;
    L108:
        if (ILinkerUpdateUserContentKt.isBackground(r8) == true) goto L112;
        if (r126 == true) goto L112;
        boolean r127 = false;
    L113:
        r36.isBackground = r127;
    L115:
        this.c.set(r35, r36);
    L112:
        r127 = true;
    L96:
        r124 = null;
    L90:
        r121 = null;
        goto L91
    L100:
        r118 = null;
    L106:
        r126 = false;
        goto L108
    L76:
        r115 = null;
    L114:
        r36.isBackground = ILinkerUpdateUserContentKt.isBackground(r8);
        goto L115
    L116:
        this.y = ILinkerUpdateUserContentKt.isBackground(r8);
        this.t = r8.getVersion();
        Map r37 = r8.getLinkerContentMap();
        if (r37 == null) goto L128;
        LinkedHashMap r38 = new LinkedHashMap(MapsKt.mapCapacity(r37.size()));
        Iterator r39 = r37.entrySet().iterator();
    L120:
        if (r39.hasNext() == false) goto L128;
        Map.Entry r40 = (Map.Entry) r39.next();
        Map r41 = r8.getLinkerContentMap();
        if (r41 == null) goto L126;
        g2 r42 = (g2) r41.get(r40.getKey());
        if (r42 == null) goto L126;
        long r43 = r42.getMVersion();
    L127:
        this.u = r43;
        r38.put(Unit.INSTANCE, r40.getValue());
    L126:
        r43 = 0;
    L128:
        this.s = new a(System.currentTimeMillis(), "backgroundMsg", String.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getUpdateInfoStr(r8));
        if (this.q.booleanValue() == true) goto L131;
    L185:
        return true;
    L131:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L185;
        ALogger.w(this.a, "consumeBackgroundMsg shouldUpdateAllGuestActiveStatus mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j());
    L134:
        if (this.y == true) goto L186;
        if (r31 == null) goto L186;
        if (r31.isBackground == ILinkerUpdateUserContentKt.isBackground(r8)) goto L186;
        List r44 = r8.getMLinkUsers();
        ALogger.w(this.a, ILinkerUpdateUserContentKt.getToUserIdString(r8) + " updateBackground " + r31.isBackground + " to " + ILinkerUpdateUserContentKt.isBackground(r8));
        if (this.w == false) goto L183;
        List r45 = r44;
        if (r45 != null) goto L143;
    L144:
        r1 = true;
    L145:
        if (r1 == true) goto L183;
        Iterator r46 = r44.iterator();
    L148:
        if (r46.hasNext() == false) goto L156;
        Object r47 = r46.next();
        o0.a r128 = o0.a;
        IBaseUser r48 = ((com.bytedance.android.livesdk.link.model.bridge.k) r47).getUser();
        if (r48 == null) goto L152;
        String r49 = r48.getIdString();
    L153:
        String r129 = ILinkerUpdateUserContentKt.getToUserIdString(r8);
        r128.getClass();
        if (o0.a.a(r49, r129) == false) goto L148;
    L157:
        com.bytedance.android.livesdk.link.model.bridge.k r50 = (com.bytedance.android.livesdk.link.model.bridge.k) r47;
        if (r50 != null) goto L160;
    L164:
        boolean r51 = N(this, jm2.a.a(r44), r8.getVersion(), "backgroundMsg", r8.getLinkerContentMap());
        if (r51 == false) goto L179;
        Iterator<LinkPlayerInfo> r52 = this.d.iterator();
    L168:
        if (r52.hasNext() == false) goto L179;
        LinkPlayerInfo r53 = r52.next();
        if (r53.getUser() == null) goto L168;
        IBaseUser r54 = r53.getUser();
        if (r54 == null) goto L174;
        String r55 = r54.getIdString();
    L176:
        if ((!Intrinsics.areEqual(r55, j())) == false) goto L168;
        this.c.add(r53);
        goto L168
    L174:
        r55 = null;
    L179:
        if (this.q.booleanValue() == true) goto L181;
    L184:
        this.s = new a(System.currentTimeMillis(), "backgroundMsg", String.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getUpdateInfoStr(r8));
        goto L185
    L181:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L184;
        ALogger.w(this.a, "consumeBackgroundMsg 嘉宾退后台改成全量刷新列表 mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j() + ", updated = " + r51);
        goto L184
    L160:
        if (ILinkerUpdateUserContentKt.isBackground(r8) == false) goto L162;
        long r56 = 1;
    L163:
        r50.setBackground(r56);
        goto L164
    L162:
        r56 = 0;
        goto L163
    L152:
        r49 = null;
        goto L153
    L156:
        r47 = null;
        goto L157
    L143:
        if (r45.isEmpty() == false) goto L145;
    L183:
        int r57 = this.c.indexOf(r31);
        LinkPlayerInfo r58 = r31.copy();
        r58.isBackground = ILinkerUpdateUserContentKt.isBackground(r8);
        this.c.set(r57, r58);
    L186:
        String r59 = this.a;
        StringBuilder r60 = new StringBuilder("not consumeBackgroundMsg ");
        if (r31 == null) goto L189;
        r10 = Boolean.valueOf(r31.isBackground);
    L189:
        r60.append(r10);
        r60.append(' ');
        r60.append(this.y);
        r60.append(' ');
        r60.append(r8);
        ALogger.e(r59, r60.toString());
        return false;
    L56:
        r29 = null;
        goto L57
    L60:
        r26 = null;
        goto L61
    L191:
        List<AnchorLinkUser> r61 = r2;
        if (r61 != null) goto L194;
    L197:
        boolean r62 = true;
    L198:
        if (r62 == true) goto L239;
        Intrinsics.checkNotNull(r2);
        boolean r63 = M(r2, r8.getVersion(), "updateMsg", r8.getLinkerContentMap(), r11);
        Iterator<LinkPlayerInfo> r65 = this.c.iterator();
    L201:
        if (r65.hasNext() == false) goto L209;
        LinkPlayerInfo r66 = r65.next();
        o0.a r67 = o0.a;
        IBaseUser r68 = r66.getUser();
        if (r68 == null) goto L205;
        String r69 = r68.getIdString();
    L206:
        String r70 = ILinkerUpdateUserContentKt.getToUserIdString(r8);
        r67.getClass();
        if (o0.a.a(r69, r70) == false) goto L201;
    L210:
        LinkPlayerInfo r71 = r66;
        if (r63 == false) goto L227;
        this.d.clear();
        if (r12 == null) goto L227;
        Iterator r72 = r12.iterator();
    L216:
        if (r72.hasNext() == false) goto L227;
        LinkPlayerInfo r73 = (LinkPlayerInfo) r72.next();
        this.d.add(r73);
        Iterator<LinkPlayerInfo> r74 = this.h.iterator();
    L219:
        if (r74.hasNext() == false) goto L223;
        LinkPlayerInfo r75 = r74.next();
        if (x(r75, r73) == false) goto L219;
    L224:
        if (r75 != null) goto L216;
        d(r73);
        goto L216
    L223:
        r75 = null;
    L227:
        if (this.q.booleanValue() == true) goto L229;
    L231:
        if (r71 != null) goto L233;
    L237:
        this.s = new a(System.currentTimeMillis(), "updateMsg", String.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getUpdateInfoStr(r8));
        return true;
    L233:
        if (ILinkerUpdateUserContentKt.isMcStatusUpdate(r8) == false) goto L237;
        int r76 = ILinkerUpdateUserContentKt.getMcStatus(r8);
        if (r76 < 0) goto L237;
        r71.setMcStatus(r76);
        goto L237
    L229:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L231;
        ALogger.w(this.a, "onLinkerUpdate mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ",  updated = " + r63 + ", updatedGuest = " + r11 + ", msgId = " + r23.getMessageId3() + ", guestVersion = " + r13 + ", version = " + r8.getVersion() + ", currentVersion = " + this.t + ", currentOppoSiteVersion = " + this.u);
        goto L231
    L205:
        r69 = null;
        goto L206
    L209:
        r66 = null;
        goto L210
    L239:
        Iterator<LinkPlayerInfo> r77 = this.c.iterator();
    L241:
        if (r77.hasNext() == false) goto L250;
        LinkPlayerInfo r78 = r77.next();
        o0.a r79 = o0.a;
        IBaseUser r80 = r78.getUser();
        if (r80 == null) goto L245;
        String r81 = r80.getIdString();
    L246:
        String r82 = ILinkerUpdateUserContentKt.getToUserIdString(r8);
        r79.getClass();
        if (o0.a.a(r81, r82) == false) goto L241;
        r10 = r78;
        goto L250
    L245:
        r81 = null;
    L250:
        if (((LinkPlayerInfo) r10) != null) goto L253;
        com.bytedance.android.live.liveinteract.plantform.utils.x.W(Long.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getToUserIdString(r8), "update user not found", r8.toString(), null, q0.a(ILinkerUpdateUserContentKt.getToUserIdString(r8)), 16);
    L255:
        return false;
    L253:
        if (ILinkerUpdateUserContentKt.isSilenceStatusUpdate(r8) == false) goto L255;
        com.bytedance.android.live.liveinteract.plantform.utils.x.W(Long.valueOf(r23.getMessageId3()), ILinkerUpdateUserContentKt.getToUserIdString(r8), "fallback SilenceStatusUpdate", r8.toString(), 0, false, 32);
        goto L255
    L194:
        if (r61.isEmpty() == true) goto L197;
        r62 = false;
        goto L198
    L47:
        r24 = null;
        goto L48
    L43:
        r12 = null;
        r11 = false;
        r13 = 0;
        goto L44
    }

    public final void E(String r6) {
        if (((Boolean) uh0.a.getValue()).booleanValue() == false) goto L46;
        Iterator<LinkPlayerInfo> r0 = this.c.iterator();
    L5:
        LinkPlayerInfo r2 = null;
        if (r0.hasNext() == false) goto L10;
        LinkPlayerInfo r1 = r0.next();
        if (TextUtils.equals(r1.getInteractId(), r6) == false) goto L5;
    L11:
        LinkPlayerInfo r3 = r1;
        if (r3 == null) goto L14;
        this.c.remove(r3);
    L14:
        Iterator<LinkPlayerInfo> r4 = this.d.iterator();
    L16:
        if (r4.hasNext() == false) goto L29;
        LinkPlayerInfo r5 = r4.next();
        LinkPlayerInfo r7 = r5;
        if (TextUtils.equals(r7.getInteractId(), r6) == false) goto L26;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L22;
        String r9 = r8.getIdString();
    L23:
        boolean r10 = true;
        if ((!Intrinsics.areEqual(r9, j())) == false) goto L26;
    L27:
        if (r10 == false) goto L16;
        r2 = r5;
        goto L29
    L22:
        r9 = null;
    L26:
        r10 = false;
    L29:
        LinkPlayerInfo r11 = r2;
        if (r11 == null) goto L33;
        this.d.remove(r11);
    L33:
        if (this.q.booleanValue() == true) goto L35;
        return;
    L35:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L48;
        ALogger.w(this.a, "onUserLeave  mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", getGuestAnchorId = " + j() + ", interactId = " + r6);
        return;
    L48:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final void G(long r21) {
        if (this.l == false) goto L5;
        return;
    L5:
        if (r21 != 0) goto L7;
        return;
    L7:
        if (this.q.booleanValue() == true) goto L13;
        this.l = true;
        this.o.add(((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).getLinkAnchorList(r21, 2, 0, -1, 1, !this.q.booleanValue(), "audience_enter_room", Long.valueOf(n().id).longValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, System.currentTimeMillis()), new g(this)));
        return;
    }

    public final void J(z r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (((ArrayList) this.n).contains(r2) == true) goto L5;
        return;
    L5:
        ((ArrayList) this.n).remove(r2);
    }

    public final void K(Map<Long, ? extends RoomLinkerContent> r12) {
        if (r12 == null) goto L32;
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));
        Iterator<T> r2 = r12.entrySet().iterator();
        ArrayList r3 = null;
        ArrayList r4 = null;
    L6:
        if (r2.hasNext() == false) goto L33;
        Map.Entry r5 = (Map.Entry) r2.next();
        if (((Number) r5.getKey()).longValue() != n().id) goto L17;
        RoomLinkerContent r6 = r12.get(r5.getKey());
        if (r6 == null) goto L16;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r7 = r6.linkedUsers;
        if (r7 == null) goto L16;
        List r8 = CollectionsKt.toMutableList(r7);
        if (r8 == null) goto L16;
        r3 = dl0.n.g(r8, (Long) r5.getKey());
    L25:
        String r9 = this.a;
        StringBuilder r10 = new StringBuilder("setOnlineUserList  key = ");
        r10.append(((Number) r5.getKey()).longValue());
        r10.append(", value = ");
        RoomLinkerContent r11 = r12.get(r5.getKey());
        if (r11 == null) goto L30;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r13 = r11.linkedUsers;
        if (r13 == null) goto L30;
        String r14 = r13.toString();
    L31:
        r10.append(r14);
        ALogger.e(r9, r10.toString());
        r1.put(Unit.INSTANCE, r5.getValue());
    L30:
        r14 = null;
    L16:
        r3 = null;
        goto L25
    L17:
        RoomLinkerContent r15 = r12.get(r5.getKey());
        if (r15 == null) goto L24;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r16 = r15.linkedUsers;
        if (r16 == null) goto L24;
        List r17 = CollectionsKt.toMutableList(r16);
        if (r17 == null) goto L24;
        r4 = dl0.n.g(r17, (Long) r5.getKey());
    L24:
        r4 = null;
    L33:
        if (r3 == null) goto L35;
        this.c.addAll(r3);
    L35:
        this.d.clear();
        if (r4 == null) goto L49;
        Iterator r18 = r4.iterator();
    L39:
        if (r18.hasNext() == false) goto L49;
        LinkPlayerInfo r19 = (LinkPlayerInfo) r18.next();
        this.d.add(r19);
        Iterator<LinkPlayerInfo> r20 = this.h.iterator();
    L42:
        if (r20.hasNext() == false) goto L46;
        LinkPlayerInfo r21 = r20.next();
        if (x(r21, r19) == false) goto L42;
    L47:
        if (r21 != null) goto L39;
        d(r19);
        goto L39
    L46:
        r21 = null;
    L49:
        Iterator<LinkPlayerInfo> r110 = this.d.iterator();
    L51:
        if (r110.hasNext() == false) goto L62;
        LinkPlayerInfo r22 = r110.next();
        if (r22.getUser() == null) goto L51;
        IBaseUser r23 = r22.getUser();
        if (r23 == null) goto L57;
        String r24 = r23.getIdString();
    L59:
        if ((!Intrinsics.areEqual(r24, j())) == false) goto L51;
        this.c.add(r22);
        goto L51
    L57:
        r24 = null;
        goto L59
    L62:
        if ((!this.c.isEmpty()) == false) goto L83;
        ALogger.e(this.a, "setOnlineUserList mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j());
        return;
    L83:
        return;
    L32:
        r3 = null;
        r4 = null;
        goto L33
    }

    @Override // com.bytedance.android.live.pkaudience.api.a
    public final int O4(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Iterator<T> r0 = this.c.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        IBaseUser r3 = ((LinkPlayerInfo) r1).getUser();
        if (r3 == null) goto L8;
        String r4 = r3.getIdString();
    L10:
        if (Intrinsics.areEqual(r4, r5) == false) goto L3;
    L13:
        LinkPlayerInfo r6 = (LinkPlayerInfo) r1;
        if (r6 != null) goto L26;
        Iterator<T> r7 = this.d.iterator();
    L17:
        if (r7.hasNext() == false) goto L25;
        Object r8 = r7.next();
        IBaseUser r9 = ((LinkPlayerInfo) r8).getUser();
        if (r9 == null) goto L21;
        String r10 = r9.getIdString();
    L23:
        if (Intrinsics.areEqual(r10, r5) == false) goto L17;
        r2 = r8;
        goto L25
    L21:
        r10 = null;
    L25:
        r6 = (LinkPlayerInfo) r2;
    L26:
        if (r6 != null) goto L36;
        return -1;
    L36:
        return r6.userPosition;
    L8:
        r4 = null;
        goto L10
    L12:
        r1 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.pkaudience.api.a
    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Iterator<T> r0 = this.c.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        IBaseUser r3 = ((LinkPlayerInfo) r1).getUser();
        if (r3 == null) goto L9;
        r2 = r3.getIdString();
    L9:
        if (Intrinsics.areEqual(r2, r5) == false) goto L3;
        r2 = r1;
    L11:
        if (r2 == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final void c(z r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (((ArrayList) this.n).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.n).add(r2);
    }

    public final void d(LinkPlayerInfo r3) {
        if (this.h.size() < 3) goto L5;
        this.h.remove(0);
    L5:
        this.h.add(r3);
    }

    public final String m(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        LinkPlayerInfo r4 = k(r3, "");
        if (r4 != null) goto L5;
        return "";
    L5:
        if (r4.getUser() == null) goto L13;
        String r5 = r4.getInteractId();
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5;
    L13:
        return "";
    }

    public final void onMessage(tlc.d r35) {
        Intrinsics.checkNotNullParameter(r35, MultiLinkOpenSource.MESSAGE);
        if (this.m == true) goto L6;
        return;
    L6:
        if ((r35 instanceof xe) == false) goto L12;
        if (((int) ((xe) r35).getType2()) != 5) goto L510;
        H(false, "messageWaitingListChange");
        return;
    L510:
        return;
    L12:
        if ((r35 instanceof if) == false) goto L363;
        if r0 = (if) r35;
        if (this.r.contains(Integer.valueOf(r0.mScene)) == true) goto L16;
        return;
    L16:
        ArrayList r11 = new ArrayList(this.c);
        int r1 = r0.getMType();
        String r14 = ", version = ";
        String r15 = ", guestVersion = ";
        String r6 = ", updatedGuest = ";
        String r5 = ",  updated = ";
        if (r1 != 6) goto L19;
        String r7 = ", msgId = ";
        ArrayList r36 = r11;
        if (dl0.n.c() == false) goto L261;
    L262:
        H(false, "messageLinkUserEnter");
    L263:
        LinkerEnterContent r8 = r0.mEnter;
        if (r8 != null) goto L266;
    L265:
        boolean r2 = false;
    L340:
        if (r2 == true) goto L342;
        return;
    L342:
        Iterator r3 = r36.iterator();
    L344:
        if (r3.hasNext() == false) goto L358;
        LinkPlayerInfo r4 = (LinkPlayerInfo) r3.next();
        Iterator<LinkPlayerInfo> r9 = this.c.iterator();
    L347:
        if (r9.hasNext() == false) goto L351;
        LinkPlayerInfo r10 = r9.next();
        if (x(r10, r4) == false) goto L347;
    L352:
        if (r10 != null) goto L344;
        if (this.g.size() < this.b) goto L357;
        this.g.remove(0);
    L357:
        this.g.add(r4);
        goto L344
    L351:
        r10 = null;
        goto L352
    L358:
        ALogger.w(this.a, "message onOnlineListChanged callback mOnlineUserList = " + this.c);
        Iterator r12 = ((ArrayList) this.n).iterator();
    L360:
        if (r12.hasNext() == false) goto L511;
        ((z) r12.next()).onOnlineListChanged(this.c);
        goto L360
    L511:
        return;
    L266:
        List<AnchorLinkUser> r13 = r8.getMLinkUsers();
        Map r16 = r8.getMLinkerContentMap();
        if (r16 == null) goto L304;
        LinkedHashMap r17 = new LinkedHashMap(MapsKt.mapCapacity(r16.size()));
        Iterator r18 = r16.entrySet().iterator();
        List<AnchorLinkUser> r19 = r13;
        long r21 = 0;
        boolean r20 = false;
        ArrayList r110 = null;
    L270:
        if (r18.hasNext() == false) goto L303;
        Map.Entry r22 = (Map.Entry) r18.next();
        Iterator r111 = r18;
        Map r23 = r8.getMLinkerContentMap();
        String r24 = r7;
        if (r23 == null) goto L280;
        RoomLinkerContent r25 = (RoomLinkerContent) r23.get(r22.getKey());
        if (r25 == null) goto L280;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r26 = r25.linkedUsers;
        if (r26 == null) goto L280;
        List r27 = CollectionsKt.toMutableList(r26);
        if (r27 == null) goto L280;
        Long r28 = (Long) r22.getKey();
        r8.getMLinkerContentMap();
        r110 = dl0.n.g(r27, r28);
    L281:
        Map r29 = r8.getMLinkerContentMap();
        if (r29 == null) goto L286;
        RoomLinkerContent r30 = (RoomLinkerContent) r29.get(r22.getKey());
        if (r30 == null) goto L286;
        long r112 = r30.getVersion();
    L287:
        boolean r31 = F(r112, "onLinkerEnter");
        if (r31 == false) goto L300;
        Map r32 = r8.getMLinkerContentMap();
        if (r32 == null) goto L300;
        boolean r210 = r31;
        RoomLinkerContent r33 = (RoomLinkerContent) r32.get(r22.getKey());
        if (r33 == null) goto L301;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r34 = r33.linkedUsers;
        if (r34 == null) goto L301;
        long r211 = r112;
        if (r34.size() <= 1) goto L302;
        if (r19 == null) goto L299;
        r19 = CollectionsKt.plus(r19, jm2.a.a(r34));
        goto L302
    L299:
        r19 = null;
    L302:
        r17.put(Unit.INSTANCE, r22.getValue());
        r18 = r111;
        r20 = r210;
        r7 = r24;
        r14 = r14;
        r15 = r15;
        r21 = r211;
    L301:
        r211 = r112;
    L300:
        r210 = r31;
    L286:
        r112 = 0;
    L280:
        r110 = null;
        goto L281
    L303:
        String r212 = r7;
        String r213 = r14;
        String r214 = r15;
        boolean r113 = r20;
        List<AnchorLinkUser> r37 = r19;
        long r38 = r21;
    L305:
        Long r215 = Long.valueOf(r0.getMessageId3());
        String r216 = r8.getUserIdString();
        String r217 = r8.toString();
        Integer r39 = Integer.valueOf(r13.size());
        boolean r310 = Intrinsics.areEqual(r8.getUserIdString(), dl0.n.d());
        if (r13.isEmpty() == false) goto L308;
        String r218 = "enter linkUsers invalid";
    L309:
        com.bytedance.android.live.liveinteract.plantform.utils.x.T(r215, r216, r217, r218, r39, r310);
        List<AnchorLinkUser> r40 = r37;
        if (r40 != null) goto L312;
    L315:
        boolean r41 = true;
    L316:
        if (r41 == true) goto L265;
        Intrinsics.checkNotNull(r37);
        L(r8, r37);
        Intrinsics.checkNotNull(r37);
        long r311 = r38;
        String r114 = r212;
        boolean r42 = M(r37, r8.getVersion(), "enterMsg", r8.getMLinkerContentMap(), r113);
        if (r42 == false) goto L334;
        this.d.clear();
        if (r110 == null) goto L334;
        Iterator r43 = r110.iterator();
    L323:
        if (r43.hasNext() == false) goto L334;
        LinkPlayerInfo r44 = (LinkPlayerInfo) r43.next();
        this.d.add(r44);
        Iterator<LinkPlayerInfo> r45 = this.h.iterator();
    L326:
        if (r45.hasNext() == false) goto L330;
        LinkPlayerInfo r46 = r45.next();
        if (x(r46, r44) == false) goto L326;
    L331:
        if (r46 != null) goto L323;
        d(r44);
        goto L323
    L330:
        r46 = null;
    L334:
        if (this.q.booleanValue() == true) goto L336;
    L338:
        if (r42 == true) goto L339;
    L128:
        r2 = r42;
        goto L340
    L339:
        this.s = new a(System.currentTimeMillis(), "enterMsg", String.valueOf(r0.getMessageId3()), "enterUser=" + r8.getUserIdString());
        goto L128
    L336:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L338;
        ALogger.w(this.a, "onLinkerEnter mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ",  updated = " + r42 + ", updatedGuest = " + r113 + r114 + r0.getMessageId3() + r214 + r311 + r213 + r8.getVersion() + ", currentVersion = " + this.t + ", currentOppoSiteVersion = " + this.u);
        goto L338
    L312:
        if (r40.isEmpty() == true) goto L315;
        r41 = false;
        goto L316
    L308:
        r218 = null;
        goto L309
    L304:
        r212 = r7;
        r213 = ", version = ";
        r214 = ", guestVersion = ";
        r37 = r13;
        r38 = 0;
        r113 = false;
        r110 = null;
        goto L305
    L261:
        if (this.q.booleanValue() == false) goto L263;
    L19:
        if (r1 != 7) goto L21;
        r36 = r11;
        LinkerLeaveContent r47 = r0.mLeave;
        if (r47 == null) goto L251;
        List r48 = r47.getMLinkUsers();
        Map r49 = r47.getLinkerContentMap();
        if (r49 == null) goto L156;
        LinkedHashMap r50 = new LinkedHashMap(MapsKt.mapCapacity(r49.size()));
        Iterator r51 = r49.entrySet().iterator();
        long r115 = 0;
        ArrayList r52 = null;
    L138:
        if (r51.hasNext() == false) goto L157;
        Map.Entry r53 = (Map.Entry) r51.next();
        Map r54 = r47.getLinkerContentMap();
        if (r54 == null) goto L148;
        RoomLinkerContent r55 = (RoomLinkerContent) r54.get(r53.getKey());
        if (r55 == null) goto L148;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r56 = r55.linkedUsers;
        if (r56 == null) goto L148;
        List r57 = CollectionsKt.toMutableList(r56);
        if (r57 == null) goto L148;
        Long r58 = (Long) r53.getKey();
        r47.getLinkerContentMap();
        ArrayList r59 = dl0.n.g(r57, r58);
    L149:
        Map r60 = r47.getLinkerContentMap();
        if (r60 == null) goto L154;
        RoomLinkerContent r61 = (RoomLinkerContent) r60.get(r53.getKey());
        if (r61 == null) goto L154;
        r115 = r61.mVersion;
    L155:
        r50.put(Unit.INSTANCE, r53.getValue());
        r52 = r59;
    L154:
        r115 = 0;
    L148:
        r59 = null;
    L157:
        this.d.clear();
        if (r52 == null) goto L163;
        Iterator r62 = r52.iterator();
    L161:
        if (r62.hasNext() == false) goto L163;
        this.d.add((LinkPlayerInfo) r62.next());
    L163:
        Iterator<LinkPlayerInfo> r63 = this.c.iterator();
    L165:
        if (r63.hasNext() == false) goto L173;
        LinkPlayerInfo r65 = r63.next();
        o0.a r66 = o0.a;
        IBaseUser r67 = r65.getUser();
        if (r67 == null) goto L169;
        String r68 = r67.getIdString();
    L170:
        String r69 = r47.getUserIdStr();
        r66.getClass();
        if (o0.a.a(r68, r69) == false) goto L165;
    L174:
        boolean r70 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).getPkService().sendGuestKickOut(r47.getUserIdStr(), "");
        List r71 = r48;
        if (r71 != null) goto L177;
    L180:
        boolean r72 = true;
    L181:
        if (r72 == true) goto L232;
        boolean r73 = N(this, r48, r47.getVersion(), "leaveMsg", r47.getLinkerContentMap());
        Iterator<LinkPlayerInfo> r74 = this.d.iterator();
    L184:
        if (r74.hasNext() == false) goto L194;
        LinkPlayerInfo r75 = r74.next();
        if (r75.getUser() == null) goto L184;
        IBaseUser r76 = r75.getUser();
        if (r76 == null) goto L190;
        String r77 = r76.getIdString();
    L192:
        if ((!Intrinsics.areEqual(r77, j())) == false) goto L184;
        this.c.add(r75);
        goto L184
    L190:
        r77 = null;
        goto L192
    L194:
        Iterator<LinkPlayerInfo> r78 = this.c.iterator();
    L196:
        if (r78.hasNext() == false) goto L204;
        LinkPlayerInfo r79 = r78.next();
        o0.a r80 = o0.a;
        IBaseUser r81 = r79.getUser();
        if (r81 == null) goto L200;
        String r82 = r81.getIdString();
    L201:
        String r83 = r47.getUserIdStr();
        r80.getClass();
        if (o0.a.a(r82, r83) == false) goto L196;
    L205:
        LinkPlayerInfo r84 = r79;
        if (r84 == null) goto L208;
        this.c.remove(r84);
    L208:
        Iterator<LinkPlayerInfo> r85 = this.d.iterator();
    L210:
        if (r85.hasNext() == false) goto L218;
        LinkPlayerInfo r86 = r85.next();
        o0.a r87 = o0.a;
        IBaseUser r88 = r86.getUser();
        if (r88 == null) goto L214;
        String r89 = r88.getIdString();
    L215:
        String r90 = r47.getUserIdStr();
        r87.getClass();
        if (o0.a.a(r89, r90) == false) goto L210;
    L219:
        LinkPlayerInfo r91 = r86;
        if (r91 == null) goto L223;
        this.c.remove(r91);
    L223:
        if (this.q.booleanValue() == true) goto L225;
    L227:
        Long r219 = Long.valueOf(r0.getMessageId3());
        String r220 = r47.getUserIdStr();
        String r221 = r47.toString();
        Integer r222 = Integer.valueOf(r48.size());
        if (r84 == null) goto L230;
        String r223 = "leaved user in list";
    L231:
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(r219, r220, r221, r223, r222, false, null, 96);
        this.s = new a(System.currentTimeMillis(), "leaveMsg", String.valueOf(r0.getMessageId3()), "leaveUser=" + r47.getUserIdStr());
    L256:
        boolean r92 = true;
    L257:
        r2 = r92;
        goto L340
    L230:
        r223 = null;
        goto L231
    L225:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L227;
        ALogger.w(this.a, "onLinkerLeave mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j() + ", update = " + r73 + ", msgId = " + r0.getMessageId3());
        goto L227
    L214:
        r89 = null;
        goto L215
    L218:
        r86 = null;
        goto L219
    L200:
        r82 = null;
        goto L201
    L204:
        r79 = null;
        goto L205
    L232:
        Iterator<LinkPlayerInfo> r93 = this.c.iterator();
    L234:
        if (r93.hasNext() == false) goto L247;
        LinkPlayerInfo r94 = r93.next();
        o0.a r95 = o0.a;
        IBaseUser r96 = r94.getUser();
        if (r96 == null) goto L238;
        String r97 = r96.getIdString();
    L239:
        String r98 = r47.getUserIdStr();
        r95.getClass();
        if (o0.a.a(r97, r98) == true) goto L242;
    L244:
        boolean r99 = false;
    L245:
        if (r99 == false) goto L234;
    L248:
        LinkPlayerInfo r100 = r94;
        if (r100 != null) goto L252;
        Long r116 = Long.valueOf(r0.getMessageId3());
        String r224 = r47.getUserIdStr();
        o0.a r101 = o0.a;
        String r102 = r47.getUserIdStr();
        r101.getClass();
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(r116, r224, null, "leave user not found", null, o0.a.b(r102), null, 84);
        goto L251
    L252:
        this.c.remove(r100);
        this.t = r47.getVersion();
        if (r115 == 0) goto L255;
        this.u = r115;
    L255:
        this.s = new a(System.currentTimeMillis(), "leaveMsg", String.valueOf(r0.getMessageId3()), "fallback leaveUser=" + r47.getUserIdStr());
        com.bytedance.android.live.liveinteract.plantform.utils.x.U(Long.valueOf(r0.getMessageId3()), r47.getUserIdStr(), r47.toString(), null, null, false, null, 120);
        goto L256
    L242:
        if (o0.a.b(r47.getUserIdStr()) == false) goto L244;
        r99 = true;
        goto L245
    L238:
        r97 = null;
        goto L239
    L247:
        r94 = null;
        goto L248
    L177:
        if (r71.isEmpty() == true) goto L180;
        r72 = false;
        goto L181
    L169:
        r68 = null;
        goto L170
    L173:
        r65 = null;
        goto L174
    L156:
        r115 = 0;
        r52 = null;
    L251:
        r92 = false;
        goto L257
    L21:
        if (r1 != 11) goto L23;
        LinkerLinkedListChangeContent r103 = r0.getMLinkedListChange();
        if (r103 == null) goto L130;
        LinkerLinkedListChangeContent r117 = r103;
        boolean r104 = r117.isTimerPush();
        if (r104 == true) goto L31;
    L33:
        List r105 = r117.getMLinkUsers();
        if (r105 == null) goto L36;
        List<AnchorLinkUser> r106 = jm2.a.a(r105);
    L37:
        Map r107 = r117.getLinkerContentMap();
        if (r107 == null) goto L84;
        LinkedHashMap r108 = new LinkedHashMap(MapsKt.mapCapacity(r107.size()));
        Iterator r109 = r107.entrySet().iterator();
        List<AnchorLinkUser> r118 = r106;
        long r225 = 0;
        boolean r119 = false;
        ArrayList r226 = null;
    L41:
        if (r109.hasNext() == false) goto L83;
        Map.Entry r120 = (Map.Entry) r109.next();
        Iterator r312 = r109;
        Map r121 = r117.getLinkerContentMap();
        String r227 = r5;
        if (r121 == null) goto L51;
        RoomLinkerContent r122 = (RoomLinkerContent) r121.get(r120.getKey());
        if (r122 == null) goto L51;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r123 = r122.linkedUsers;
        if (r123 == null) goto L51;
        List r124 = jm2.a.c(r123);
        if (r124 == null) goto L51;
        Long r125 = (Long) r120.getKey();
        r117.getLinkerContentMap();
        r226 = dl0.n.g(r124, r125);
    L52:
        Map r126 = r117.getLinkerContentMap();
        if (r126 == null) goto L57;
        RoomLinkerContent r127 = (RoomLinkerContent) r126.get(r120.getKey());
        if (r127 == null) goto L57;
        long r128 = r127.mVersion;
    L58:
        boolean r129 = F(r128, "onLinkerLinkedListChange");
        r225 = r128;
        if (r129 == false) goto L81;
        Map r130 = r117.getLinkerContentMap();
        if (r130 == null) goto L81;
        RoomLinkerContent r131 = (RoomLinkerContent) r130.get(r120.getKey());
        if (r131 == null) goto L81;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r132 = r131.linkedUsers;
        if (r132 == null) goto L81;
        List r133 = jm2.a.a(r132);
        if (r133 == null) goto L81;
        if (((Boolean) sh0.a.getValue()).booleanValue() == false) goto L73;
        boolean r228 = r129;
        if (r133.isEmpty() == false) goto L75;
    L76:
        boolean r134 = false;
    L77:
        if (r134 == false) goto L82;
        if (r118 == null) goto L80;
        r118 = CollectionsKt.plus(r118, r133);
        goto L82
    L80:
        r118 = null;
    L82:
        r108.put(Unit.INSTANCE, r120.getValue());
        r109 = r312;
        r5 = r227;
        r6 = r6;
        r119 = r228;
    L75:
        r134 = true;
        goto L77
    L73:
        r228 = r129;
        if (r133.size() <= 1) goto L76;
    L81:
        r228 = r129;
    L57:
        r128 = 0;
    L51:
        r226 = null;
        goto L52
    L83:
        String r229 = r5;
        String r230 = r6;
        boolean r135 = r119;
        long r136 = r225;
    L85:
        int r137 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Long r138 = Long.valueOf(r0.getMessageId3());
        String r139 = r117.toString();
        if (r106 == null) goto L88;
        Integer r140 = Integer.valueOf(r106.size());
    L89:
        com.bytedance.android.live.liveinteract.plantform.utils.x.S(r138, r139, r140, r104, "");
        List<AnchorLinkUser> r141 = r118;
        if (r141 != null) goto L92;
    L95:
        boolean r231 = true;
    L96:
        if (r231 == false) goto L97;
    L32:
        r36 = r11;
        goto L265
    L97:
        Intrinsics.checkNotNull(r118);
        long r142 = r117.getVersion();
        if (r104 == false) goto L100;
        String r232 = "timerPushMsg";
    L101:
        r36 = r11;
        String r143 = r229;
        long r144 = r136;
        String r145 = r230;
        r42 = M(r118, r142, r232, r117.getLinkerContentMap(), r135);
        if (r42 == false) goto L118;
        this.d.clear();
        if (r226 == null) goto L118;
        Iterator r146 = r226.iterator();
    L107:
        if (r146.hasNext() == false) goto L118;
        LinkPlayerInfo r147 = (LinkPlayerInfo) r146.next();
        this.d.add(r147);
        Iterator<LinkPlayerInfo> r148 = this.h.iterator();
    L110:
        if (r148.hasNext() == false) goto L114;
        LinkPlayerInfo r149 = r148.next();
        if (x(r149, r147) == false) goto L110;
    L115:
        if (r149 != null) goto L107;
        d(r147);
        goto L107
    L114:
        r149 = null;
    L118:
        if (this.q.booleanValue() == true) goto L120;
    L122:
        if (r42 == false) goto L128;
        long r150 = System.currentTimeMillis();
        if (r104 == false) goto L126;
        String r151 = "timerPushMsg";
    L127:
        this.s = new a(r150, r151, String.valueOf(r0.getMessageId3()), null);
        goto L128
    L126:
        r151 = "linkedListChangeMsg";
        goto L127
    L120:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L122;
        ALogger.w(this.a, "onLinkerLinkedListChange  mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + r143 + r42 + r145 + r135 + ", guestVersion = " + r144 + ", version = " + r117.getVersion() + ", currentVersion = " + this.t + ", currentOppoSiteVersion = " + this.u);
        goto L122
    L100:
        r232 = "linkedListChangeMsg";
        goto L101
    L92:
        if (r141.isEmpty() == true) goto L95;
        r231 = false;
        goto L96
    L88:
        r140 = null;
        goto L89
    L84:
        r229 = ",  updated = ";
        r230 = ", updatedGuest = ";
        r118 = r106;
        r136 = 0;
        r135 = false;
        r226 = null;
        goto L85
    L36:
        r106 = null;
        goto L37
    L31:
        if (this.v.consumeTimerPush == true) goto L33;
    L130:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLinkedListChangeContent");
    L23:
        if (r1 == 12) goto L25;
        return;
    L25:
        r2 = D(r0);
        r36 = r11;
        goto L340
    L363:
        if ((r35 instanceof gf) == false) goto L396;
        gf r152 = (gf) r35;
        if (r152.getLinkMicSignal() != null) goto L367;
        return;
    L367:
        gm2.i r153 = r152.getLinkMicSignal();
        if (TextUtils.isEmpty(r153.senderInteractId) == true) goto L370;
    L432:
        String r154 = r153.senderUserId;     // Catch: NumberFormatException -> L393
        String r155 = r153.senderInteractId;     // Catch: NumberFormatException -> L393
        if (TextUtils.isEmpty(r153.senderInteractIdStr) == true) goto L376;
        r155 = r153.senderInteractIdStr;     // Catch: NumberFormatException -> L393
    L376:
        int r156 = r153.type;     // Catch: NumberFormatException -> L393
        switch(r156) {
            case 100101: goto L385;
            case 100102: goto L385;
            case 101002: goto L379;
            default: goto L503;
        };     // Catch: NumberFormatException -> L393
    L379:
        Iterator r157 = ((ArrayList) this.n).iterator();     // Catch: NumberFormatException -> L393
    L381:
        if (r157.hasNext() == false) goto L383;
        ((z) r157.next()).a(r154, r155);     // Catch: NumberFormatException -> L393
        goto L381
    L383:
        E(r155);     // Catch: NumberFormatException -> L393
        return;
    L503:
        return;
    L385:
        if (r156 != 100102) goto L387;
        boolean r158 = true;
    L388:
        Iterator r159 = ((ArrayList) this.n).iterator();     // Catch: NumberFormatException -> L393
    L390:
        if (r159.hasNext() == false) goto L512;
        ((z) r159.next()).b(r154, r155, r158);     // Catch: NumberFormatException -> L393
        goto L390
    L512:
        return;
    L387:
        r158 = false;
    L393:
        e = move-exception;
        Logger.e(e.toString());
        return;
    L370:
        if (TextUtils.isEmpty(r153.senderInteractIdStr) == false) goto L432;
        LinkedHashMap r160 = new LinkedHashMap();
        r160.put("msg_id", Long.valueOf(r152.getMessageId()));
        r160.put("content", "Both senderInteractId and senderInteractIdStr are empty!");
        b0.o().j("ttlive_link", r160);
        return;
    L396:
        if ((r35 instanceof LinkerContributeMessage) == false) goto L506;
        ArrayList r161 = new ArrayList();
        LinkerContributeMessage r162 = (LinkerContributeMessage) r35;
        List r163 = r162.getMUserContributeList();
        if (r163 == null) goto L403;
        Iterator r164 = r163.iterator();
    L401:
        if (r164.hasNext() == false) goto L403;
        r161.add(((LinkerContributeMessage.UserContribute) r164.next()).getUserIdStr());
    L403:
        Iterator r165 = ((ArrayList) this.n).iterator();
    L405:
        if (r165.hasNext() == false) goto L407;
        z r166 = (z) r165.next();
        String r167 = r162.getUserIdStr();
        long r168 = r162.getTotalScore();
        int r169 = com.bytedance.android.live.liveinteract.utils.y.a;
        String r170 = com.bytedance.android.live.liveinteract.utils.y.a(r162.getUserIdStr(), r161, r162.getMTotalScoreRealStr(), r162.getMTotalScoreStr());
        r162.getMQuickInteract();
        r166.f(r167, r168, r170);
        goto L405
    L407:
        LinkPlayerInfo r171 = k(r162.getUserIdStr(), "");
        if (r171 == null) goto L410;
        r171.setFanTicket(r162.getTotalScore());
        int r172 = com.bytedance.android.live.liveinteract.utils.y.a;
        r171.mFanTicketDisplayStr = com.bytedance.android.live.liveinteract.utils.y.a(r162.getUserIdStr(), r161, r162.getMTotalScoreRealStr(), r162.getMTotalScoreStr());
    L410:
        String r173 = r162.getUserIdStr();
        int r174 = com.bytedance.android.live.liveinteract.utils.y.a;
        String r175 = com.bytedance.android.live.liveinteract.utils.y.a(r162.getUserIdStr(), r161, r162.getMTotalScoreRealStr(), r162.getMTotalScoreStr());
        if (r175 == null) goto L424;
        List r176 = (List) this.z.get("data_online_changed_list", new ArrayList());
        Iterator r177 = r176.iterator();
    L415:
        if (r177.hasNext() == false) goto L423;
        LinkPlayerInfo r178 = (LinkPlayerInfo) r177.next();
        o0.a r179 = o0.a;
        IBaseUser r180 = r178.getUser();
        if (r180 == null) goto L419;
        String r181 = r180.getIdString();
    L420:
        r179.getClass();
        if (o0.a.a(r181, r173) == false) goto L415;
        r178.mFanTicketDisplayStr = r175;
        goto L415
    L419:
        r181 = null;
        goto L420
    L423:
        this.z.put("data_online_changed_list", new ArrayList(r176));
    L424:
        IInteractService r182 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r182 == null) goto L507;
        rj0.m r183 = r182.getVideoTalkService();
        if (r183 == null) goto L508;
        BehaviorSubject<Boolean> r184 = r183.U4();
        if (r184 == null) goto L509;
        r184.onNext(Boolean.TRUE);
        return;
    L509:
        return;
    L508:
        return;
    L507:
        return;
    }

    public final User q(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Iterator<LinkPlayerInfo> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        LinkPlayerInfo r1 = r0.next();
        if (r1 == null) goto L10;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
    L12:
        if (Intrinsics.areEqual(r4, r5) == false) goto L4;
        if (r1 == null) goto L77;
        vh7.c r6 = r1.getUser();
        if (r6 != null) goto L17;
        return null;
    L17:
        return jm2.a.e(r6);
    L77:
        return null;
    L10:
        r4 = null;
        goto L12
    L18:
        Iterator<LinkPlayerInfo> r2 = this.e.iterator();
    L20:
        if (r2.hasNext() == false) goto L34;
        LinkPlayerInfo r7 = r2.next();
        if (r7 == null) goto L26;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L26;
        String r9 = r8.getIdString();
    L28:
        if (Intrinsics.areEqual(r9, r5) == false) goto L20;
        if (r7 == null) goto L79;
        vh7.c r10 = r7.getUser();
        if (r10 != null) goto L33;
        return null;
    L33:
        return jm2.a.e(r10);
    L79:
        return null;
    L26:
        r9 = null;
        goto L28
    L34:
        Iterator<LinkPlayerInfo> r11 = this.g.iterator();
    L36:
        if (r11.hasNext() == false) goto L50;
        LinkPlayerInfo r12 = r11.next();
        if (r12 == null) goto L42;
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L42;
        String r14 = r13.getIdString();
    L44:
        if (Intrinsics.areEqual(r14, r5) == false) goto L36;
        if (r12 == null) goto L81;
        vh7.c r15 = r12.getUser();
        if (r15 != null) goto L49;
        return null;
    L49:
        return jm2.a.e(r15);
    L81:
        return null;
    L42:
        r14 = null;
        goto L44
    L50:
        Iterator<LinkPlayerInfo> r16 = this.i.iterator();
    L52:
        if (r16.hasNext() == false) goto L84;
        LinkPlayerInfo r17 = r16.next();
        if (r17 == null) goto L58;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L58;
        String r19 = r18.getIdString();
    L60:
        if (Intrinsics.areEqual(r19, r5) == false) goto L52;
        vh7.c r20 = r17.getUser();
        if (r20 != null) goto L64;
        return null;
    L64:
        return jm2.a.e(r20);
    L58:
        r19 = null;
        goto L60
    L84:
        return null;
    }

    public final String r(String r3) {
        LinkPlayerInfo r4 = k("0", r3);
        if (r4 != null) goto L5;
        return "0";
    L5:
        if (r4.getUser() == null) goto L16;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L15;
        String r6 = r5.getIdString();
        if (r6 != null) goto L13;
        return "0";
    L13:
        return r6;
    L15:
        return "0";
    L16:
        return "0";
    }

    public final int s(String r5) {
        Iterator<T> r0 = this.c.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((LinkPlayerInfo) r1).getInteractId(), r5) == false) goto L3;
    L9:
        LinkPlayerInfo r3 = (LinkPlayerInfo) r1;
        if (r3 != null) goto L18;
        Iterator<T> r4 = this.d.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(((LinkPlayerInfo) r6).getInteractId(), r5) == false) goto L13;
        r2 = r6;
    L17:
        r3 = (LinkPlayerInfo) r2;
    L18:
        if (r3 != null) goto L28;
        return -1;
    L28:
        return r3.userPosition;
    L8:
        r1 = null;
        goto L9
    }

    public final User t(String r5) {
        Iterator<LinkPlayerInfo> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        LinkPlayerInfo r1 = r0.next();
        if (r1 == null) goto L8;
        String r3 = r1.getInteractId();
    L10:
        if (Intrinsics.areEqual(r3, r5) == false) goto L4;
        if (r1 == null) goto L53;
        vh7.c r6 = r1.getUser();
        if (r6 != null) goto L15;
        return null;
    L15:
        return jm2.a.e(r6);
    L53:
        return null;
    L8:
        r3 = null;
        goto L10
    L16:
        Iterator<LinkPlayerInfo> r2 = this.d.iterator();
    L18:
        if (r2.hasNext() == false) goto L30;
        LinkPlayerInfo r4 = r2.next();
        if (r4 == null) goto L22;
        String r7 = r4.getInteractId();
    L24:
        if (Intrinsics.areEqual(r7, r5) == false) goto L18;
        if (r4 == null) goto L55;
        vh7.c r8 = r4.getUser();
        if (r8 != null) goto L29;
        return null;
    L29:
        return jm2.a.e(r8);
    L55:
        return null;
    L22:
        r7 = null;
        goto L24
    L30:
        Iterator<LinkPlayerInfo> r9 = this.e.iterator();
    L32:
        if (r9.hasNext() == false) goto L59;
        LinkPlayerInfo r10 = r9.next();
        if (r10 == null) goto L36;
        String r11 = r10.getInteractId();
    L38:
        if (Intrinsics.areEqual(r11, r5) == false) goto L32;
        if (r10 == null) goto L57;
        vh7.c r12 = r10.getUser();
        if (r12 != null) goto L43;
        return null;
    L43:
        return jm2.a.e(r12);
    L57:
        return null;
    L36:
        r11 = null;
        goto L38
    L59:
        return null;
    }

    public final boolean u(String r9) {
        Iterator<LinkPlayerInfo> r0 = this.d.iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L17;
        LinkPlayerInfo r1 = r0.next();
        if (r1 == null) goto L8;
        String r4 = r1.getInteractId();
    L10:
        if (Intrinsics.areEqual(r4, r9) == false) goto L3;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L15;
        r3 = r2.getIdString();
    L15:
        if ((!Intrinsics.areEqual(r3, j())) == false) goto L3;
        return true;
    L8:
        r4 = null;
        goto L10
    L17:
        Iterator<LinkPlayerInfo> r5 = this.h.iterator();
    L19:
        if (r5.hasNext() == false) goto L33;
        LinkPlayerInfo r6 = r5.next();
        if (r6 == null) goto L23;
        String r7 = r6.getInteractId();
    L25:
        if (Intrinsics.areEqual(r7, r9) == false) goto L19;
        IBaseUser r8 = r6.getUser();
        if (r8 == null) goto L29;
        String r10 = r8.getIdString();
    L31:
        if ((!Intrinsics.areEqual(r10, j())) == false) goto L19;
        return true;
    L29:
        r10 = null;
        goto L31
    L23:
        r7 = null;
        goto L25
    L33:
        Iterator<LinkPlayerInfo> r11 = this.g.iterator();
    L35:
        if (r11.hasNext() == false) goto L47;
        LinkPlayerInfo r12 = r11.next();
        if (r12 == null) goto L39;
        String r13 = r12.getInteractId();
    L41:
        if (Intrinsics.areEqual(r13, r9) == false) goto L35;
        IBaseUser r14 = r12.getUser();
        if (r14 == null) goto L46;
        if (r14.getLiveRoomId() == n().id) goto L35;
    L46:
        return true;
    L39:
        r13 = null;
        goto L41
    L47:
        return false;
    }

    public final boolean v(String r7) {
        Iterator<LinkPlayerInfo> r0 = this.d.iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L17;
        LinkPlayerInfo r1 = r0.next();
        if (r1 == null) goto L8;
        String r4 = r1.getInteractId();
    L10:
        if (Intrinsics.areEqual(r4, r7) == false) goto L3;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L15;
        r3 = r2.getIdString();
    L15:
        if ((!Intrinsics.areEqual(r3, j())) == false) goto L3;
        return true;
    L8:
        r4 = null;
        goto L10
    L17:
        Iterator<LinkPlayerInfo> r5 = this.c.iterator();
    L19:
        if (r5.hasNext() == false) goto L33;
        LinkPlayerInfo r6 = r5.next();
        if (r6 == null) goto L23;
        String r8 = r6.getInteractId();
    L25:
        if (Intrinsics.areEqual(r8, r7) == false) goto L19;
        IBaseUser r9 = r6.getUser();
        if (r9 == null) goto L29;
        String r10 = r9.getIdString();
    L31:
        if ((!Intrinsics.areEqual(r10, n().getOwnerUserIdString())) == false) goto L19;
        return false;
    L29:
        r10 = null;
        goto L31
    L23:
        r8 = null;
        goto L25
    L33:
        Iterator<LinkPlayerInfo> r11 = this.h.iterator();
    L35:
        if (r11.hasNext() == false) goto L49;
        LinkPlayerInfo r12 = r11.next();
        if (r12 == null) goto L39;
        String r13 = r12.getInteractId();
    L41:
        if (Intrinsics.areEqual(r13, r7) == false) goto L35;
        IBaseUser r14 = r12.getUser();
        if (r14 == null) goto L45;
        String r15 = r14.getIdString();
    L47:
        if ((!Intrinsics.areEqual(r15, j())) == false) goto L35;
        return true;
    L45:
        r15 = null;
        goto L47
    L39:
        r13 = null;
        goto L41
    L49:
        return false;
    }

    public final boolean w(String r7) {
        Iterator<LinkPlayerInfo> r0 = this.d.iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L17;
        LinkPlayerInfo r1 = r0.next();
        IBaseUser r4 = r1.getUser();
        if (r4 == null) goto L8;
        String r5 = r4.getIdString();
    L10:
        if (Intrinsics.areEqual(r5, r7) == false) goto L3;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L15;
        r3 = r2.getIdString();
    L15:
        if ((!Intrinsics.areEqual(r3, j())) == false) goto L3;
        return true;
    L8:
        r5 = null;
        goto L10
    L17:
        Iterator<LinkPlayerInfo> r6 = this.c.iterator();
    L19:
        if (r6.hasNext() == false) goto L33;
        LinkPlayerInfo r8 = r6.next();
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L23;
        String r10 = r9.getIdString();
    L25:
        if (Intrinsics.areEqual(r10, r7) == false) goto L19;
        IBaseUser r11 = r8.getUser();
        if (r11 == null) goto L29;
        String r12 = r11.getIdString();
    L31:
        if ((!Intrinsics.areEqual(r12, n().getOwnerUserIdString())) == false) goto L19;
        return false;
    L29:
        r12 = null;
        goto L31
    L23:
        r10 = null;
        goto L25
    L33:
        Iterator<LinkPlayerInfo> r13 = this.h.iterator();
    L35:
        if (r13.hasNext() == false) goto L49;
        LinkPlayerInfo r14 = r13.next();
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L39;
        String r16 = r15.getIdString();
    L41:
        if (Intrinsics.areEqual(r16, r7) == false) goto L35;
        IBaseUser r17 = r14.getUser();
        if (r17 == null) goto L45;
        String r18 = r17.getIdString();
    L47:
        if ((!Intrinsics.areEqual(r18, j())) == false) goto L35;
        return true;
    L45:
        r18 = null;
        goto L47
    L39:
        r16 = null;
        goto L41
    L49:
        return false;
    }

    public final boolean z(String r6) {
        Iterator<LinkPlayerInfo> r0 = this.d.iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L11;
        LinkPlayerInfo r1 = r0.next();
        if (r1 == null) goto L9;
        r3 = r1.getInteractId();
    L9:
        if (Intrinsics.areEqual(r3, r6) == false) goto L3;
        return false;
    L11:
        Iterator<LinkPlayerInfo> r2 = this.c.iterator();
    L13:
        if (r2.hasNext() == false) goto L29;
        LinkPlayerInfo r4 = r2.next();
        if (r4 == null) goto L17;
        String r5 = r4.getInteractId();
    L19:
        if (Intrinsics.areEqual(r5, r6) == false) goto L13;
        if (r4.getUser() == null) goto L13;
        IBaseUser r7 = r4.getUser();
        if (r7 == null) goto L25;
        String r8 = r7.getIdString();
    L27:
        if ((!Intrinsics.areEqual(r8, n().getOwnerUserIdString())) == false) goto L13;
        return true;
    L25:
        r8 = null;
        goto L27
    L17:
        r5 = null;
        goto L19
    L29:
        return false;
    }

    public static void L(LinkerEnterContent r7, List r8) {
        CityEffect r0 = r7.getMCityEffect();
        Object r1 = null;
        if (r0 == null) goto L10;
        List r2 = r0.showEffectUserIdList;
        if (r2 == null) goto L10;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        r4.add(String.valueOf(((Long) r5.next()).longValue()));
    L11:
        List r9 = r8;
        Iterator r6 = r9.iterator();
    L13:
        if (r6.hasNext() == false) goto L35;
        AnchorLinkUser r10 = (AnchorLinkUser) r6.next();
        o0.a r11 = o0.a;
        IBaseUser r12 = r10.getUser();
        if (r12 == null) goto L17;
        String r13 = r12.getIdString();
    L18:
        String r14 = r7.getUserIdString();
        r11.getClass();
        if (o0.a.a(r13, r14) == false) goto L21;
        r10.setMatchEffect(r7.getMMatchEffect());
        r10.setJoinUser(true);
    L21:
        if (r4 != null) goto L23;
    L26:
        boolean r15 = true;
    L27:
        if (r15 == true) goto L13;
        IBaseUser r16 = r10.getUser();
        if (r16 == null) goto L31;
        String r17 = r16.getIdString();
    L33:
        if (CollectionsKt.contains(r4, r17) == false) goto L13;
        r10.setShowCityEffect(true);
        r10.setCityEffect(r7.getMCityEffect());
        goto L13
    L31:
        r17 = null;
        goto L33
    L23:
        if (r4.isEmpty() == true) goto L26;
        r15 = false;
        goto L27
    L17:
        r13 = null;
        goto L18
    L35:
        Iterator r18 = r9.iterator();
    L37:
        if (r18.hasNext() == false) goto L45;
        Object r19 = r18.next();
        o0.a r20 = o0.a;
        String r21 = r7.getUserIdString();
        IBaseUser r22 = ((AnchorLinkUser) r19).getUser();
        if (r22 == null) goto L41;
        String r23 = r22.getIdString();
    L42:
        r20.getClass();
        if (o0.a.a(r21, r23) == false) goto L37;
        r1 = r19;
        goto L45
    L41:
        r23 = null;
    L45:
        AnchorLinkUser r24 = (AnchorLinkUser) r1;
        if (r24 == null) goto L60;
        r24.setApplyType(r7.getMApplyType());
        return;
    L60:
        return;
    L10:
        r4 = null;
        goto L11
    }

    public static boolean f(List r4, LinkPlayerInfo r5) {
        Iterator r6 = ((CopyOnWriteArrayList) r4).iterator();
    L4:
        if (r6.hasNext() == false) goto L22;
        LinkPlayerInfo r0 = (LinkPlayerInfo) r6.next();
        if (r0.getUser() == null) goto L4;
        IBaseUser r1 = r0.getUser();
        Long r2 = null;
        if (r1 == null) goto L12;
        String r3 = r1.getIdString();
        if (r3 == null) goto L12;
        Long r7 = Long.valueOf(d5.c(r3));
    L13:
        IBaseUser r8 = r5.getUser();
        if (r8 == null) goto L19;
        String r9 = r8.getIdString();
        if (r9 == null) goto L19;
        r2 = Long.valueOf(d5.c(r9));
    L19:
        if (Intrinsics.areEqual(r7, r2) == false) goto L4;
        return true;
    L12:
        r7 = null;
        goto L13
    L22:
        return false;
    }

    public static boolean x(LinkPlayerInfo r6, LinkPlayerInfo r7) {
        if (r6 != null) goto L4;
    L36:
        return false;
    L4:
        if (r6.getUser() == null) goto L36;
        if (r7 == null) goto L36;
        if (r7.getUser() == null) goto L36;
        if (TextUtils.isEmpty(r6.getInteractId()) == false) goto L13;
    L14:
        IBaseUser r0 = r6.getUser();
        Long r1 = null;
        if (r0 == null) goto L19;
        String r2 = r0.getIdString();
        if (r2 == null) goto L19;
        Long r3 = Long.valueOf(d5.c(r2));
    L20:
        Intrinsics.checkNotNull(r3);
        if (r3.longValue() <= 0) goto L36;
        IBaseUser r8 = r6.getUser();
        if (r8 == null) goto L27;
        String r9 = r8.getIdString();
        if (r9 == null) goto L27;
        Long r10 = Long.valueOf(d5.c(r9));
    L28:
        IBaseUser r11 = r7.getUser();
        if (r11 == null) goto L34;
        String r12 = r11.getIdString();
        if (r12 == null) goto L34;
        r1 = Long.valueOf(d5.c(r12));
    L34:
        if (Intrinsics.areEqual(r10, r1) == false) goto L36;
    L35:
        return true;
    L27:
        r10 = null;
    L19:
        r3 = null;
        goto L20
    L13:
        if (TextUtils.equals(r6.getInteractId(), r7.getInteractId()) == true) goto L35;
        goto L14
    }

    public final boolean F(long r5, String r7) {
        if (this.w == true) goto L6;
        return false;
    L6:
        if (r5 > 0) goto L8;
    L10:
        this.u = r5;
        ALogger.i(this.a, "processOppoSiteListWithVersion " + r7 + " list_version=" + r5);
        return true;
    L8:
        if (r5 >= this.u) goto L10;
        return false;
    }

    public final void H(boolean r9, String r10) {
        if (this.k == false) goto L5;
        return;
    L5:
        if (this.q.booleanValue() == false) goto L7;
    L9:
        this.k = true;
        long r11 = System.currentTimeMillis();
        this.o.add(((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getLinkWaitingList(n().id, 50, "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r11), new C0112i(this, r11)));
        return;
    L7:
        if (dl0.n.c() == true) goto L9;
    }

    @Override // com.bytedance.android.live.pkaudience.api.a
    public final /* bridge */ /* synthetic */ ILinkPlayerInfoBridge getGuestInfo(String r1, String r2) {
        return k(r1, r2);
    }

    public final LinkPlayerInfo k(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Iterator<LinkPlayerInfo> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        LinkPlayerInfo r1 = r0.next();
        if (y(r4, r5, r1) == false) goto L4;
        return r1;
    L8:
        Iterator<LinkPlayerInfo> r2 = this.d.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        LinkPlayerInfo r3 = r2.next();
        if (y(r4, r5, r3) == false) goto L10;
        return r3;
    L14:
        Iterator<LinkPlayerInfo> r6 = this.e.iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        LinkPlayerInfo r7 = r6.next();
        if (y(r4, r5, r7) == false) goto L16;
        return r7;
    L20:
        return null;
    }

    public final LinkPlayerInfo o(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Iterator<LinkPlayerInfo> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        LinkPlayerInfo r1 = r0.next();
        if (y(r4, r5, r1) == false) goto L4;
        return r1;
    L8:
        Iterator<LinkPlayerInfo> r2 = this.d.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        LinkPlayerInfo r3 = r2.next();
        if (y(r4, r5, r3) == false) goto L10;
        return r3;
    L14:
        return null;
    }

    public static boolean y(String r3, String r4, LinkPlayerInfo r5) {
        if (py.v.a(r3) == false) goto L5;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getUser() != null) goto L12;
        return false;
    L12:
        if (py.v.a(r3) == false) goto L20;
        o0.a r0 = o0.a;
        IBaseUser r2 = r5.getUser();
        if (r2 == null) goto L16;
        String r6 = r2.getIdString();
    L17:
        r0.getClass();
        if (o0.a.a(r6, r3) == false) goto L20;
    L23:
        return true;
    L16:
        r6 = null;
    L20:
        if (TextUtils.isEmpty(r4) == false) goto L22;
        return false;
    L22:
        if (TextUtils.equals(r5.getInteractId(), r4) == true) goto L23;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return false;
    }

    public final void O(String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "targetUserId");
        Iterator<LinkPlayerInfo> r6 = this.c.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        LinkPlayerInfo r0 = r6.next();
        if (y(r3, r4, r0) == false) goto L4;
        r0.silenceStatus = 3;
        return;
    }

    public final void I(List<AnchorLinkUser> r7, long r8, String r10, Map<Long, ? extends RoomLinkerContent> r11) {
        Intrinsics.checkNotNullParameter(r7, "newOnlineList");
        Intrinsics.checkNotNullParameter(r10, "api");
        if (r7.isEmpty() == false) goto L7;
        ALogger.e(this.a, "refreshOnlineUserList list is empty! version=" + r8 + " from=" + r10 + ", linkerContentMap=" + r11);
        return;
    L7:
        if (N(this, r7, r8, r10, r11) == true) goto L10;
        ALogger.e(this.a, "list not updated, from=" + r10 + " version=" + r8 + " current=" + this.t);
        return;
    L10:
        ALogger.w(this.a, "refreshList from=" + r10 + " version=" + r8 + " onOnlineListChanged callback");
        this.s = new a(System.currentTimeMillis(), r10, "", null);
        Iterator r9 = ((ArrayList) this.n).iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        ((z) r9.next()).onOnlineListChanged(this.c);
        goto L12
    }

    public static /* synthetic */ boolean N(i r7, List r8, long r9, String r11, Map r12) {
        return r7.M(r8, r9, r11, r12, false);
    }

    public final boolean M(List<AnchorLinkUser> r34, long r35, String r37, Map<Long, ? extends g2> r38, boolean r39) {
        List r7 = CollectionsKt.toMutableList(r34);
        if (this.w == true) goto L6;
        i this = this;
        r7 = r7;
        Object r24 = "listV2";
    L165:
        List r8 = r7;
    L167:
        if (r8.isEmpty() == false) goto L171;
        boolean r0 = r39;
        if (r0 == true) goto L173;
        return false;
    L173:
        if (Intrinsics.areEqual(r37, r24) == false) goto L195;
        this.c.clear();
        this.c.addAll(dl0.n.g(r34, null));
        Iterator<LinkPlayerInfo> r1 = this.c.iterator();
    L176:
        if (r1.hasNext() == false) goto L184;
        LinkPlayerInfo r6 = r1.next();
        String r9 = j();
        IBaseUser r10 = r6.getUser();
        if (r10 == null) goto L180;
        String r11 = r10.getIdString();
    L182:
        if (Intrinsics.areEqual(r9, r11) == false) goto L176;
        LinkPlayerInfo r12 = r6;
    L185:
        LinkPlayerInfo r13 = r12;
        if (r13 == null) goto L189;
        this.c.remove(r13);
    L189:
        if (this.q.booleanValue() == true) goto L191;
        return true;
    L191:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L346;
        ALogger.w(this.a, "updateOnlineList from = v2, mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", getGuestAnchorId = " + j() + ", userList = " + r8 + ", guestUpdated = " + r0);
        return true;
    L346:
        return true;
    L180:
        r11 = null;
        goto L182
    L184:
        r12 = null;
        goto L185
    L195:
        LinkPlayerInfo r3 = null;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r34.iterator();
    L197:
        if (r15.hasNext() == false) goto L283;
        AnchorLinkUser r16 = (AnchorLinkUser) r15.next();
        Iterator<LinkPlayerInfo> r17 = this.c.iterator();
    L200:
        if (r17.hasNext() == false) goto L212;
        LinkPlayerInfo r18 = r17.next();
        LinkPlayerInfo r19 = r18;
        IBaseUser r110 = r16.getUser();
        if (r110 == null) goto L204;
        Object r111 = r110.getIdString();
    L205:
        IBaseUser r112 = r19.getUser();
        if (r112 == null) goto L208;
        Object r113 = r112.getIdString();
    L210:
        if (Intrinsics.areEqual(r111, r113) == false) goto L200;
    L213:
        LinkPlayerInfo r114 = r18;
        if (r114 == null) goto L216;
        LinkPlayerInfo r2 = r114.copy();
        Intrinsics.checkNotNullParameter(r2, "$this$updateByLinkUser");
        Intrinsics.checkNotNullParameter(r16, "linkUser");
        r2.mUser = r16.getMUser();
        r2.setInteractId(r16.getMLinkmicIdStr());
        r2.setLinkStatus(r16.getMStatus());
        r2.setLinkType(r16.getMLinkType().intValue());
        r2.userPosition = r16.getMUserPosition();
        r2.silenceStatus = r16.getMSilenceStatus().intValue();
        r2.setModifyTime(r16.getMModifyTime().longValue());
        r2.setRoleType(r16.getMRoleType().intValue());
        r2.mApplyType = r16.getMApplyType();
        r2.mMatchEffect = r16.getMMatchEffect();
        r2.mCityEffect = r16.getMCityEffect();
        r2.mShowCityEffect = r16.getMShowCityEffect();
        r2.mIsJoinUser = r16.getMIsJoinUser();
        r2.mcStatus = r16.getMcStatus();
        if (((int) r16.isBackground()) != 1) goto L245;
        boolean r4 = true;
    L246:
        r2.isBackground = r4;
        k1 r5 = r16.getContent();
        if ((r5 instanceof ListUserContent) == true) goto L249;
        r5 = null;
    L249:
        ListUserContent r20 = (ListUserContent) r5;
        if (r20 == null) goto L254;
        ListUserLinkmicAudienceContent r21 = r20.mLinkmicAudienceContent;
        if (r21 == null) goto L254;
        MicDress r22 = r21.micDress;
    L255:
        r2.micDress = r22;
        k1 r23 = r16.getContent();
        if ((r23 instanceof ListUserContent) == true) goto L258;
        r23 = null;
    L258:
        ListUserContent r25 = (ListUserContent) r23;
        if (r25 == null) goto L265;
        ListUserLinkmicAudienceContent r26 = r25.mLinkmicAudienceContent;
        if (r26 == null) goto L265;
        if (r26.isEnlarged() != true) goto L265;
        boolean r27 = true;
    L266:
        r2.isEnlarged = r27;
        g0 r28 = r16.getMicPosTagInfo();
        if ((r28 instanceof MicPosTagInfo) == true) goto L269;
        r28 = null;
    L269:
        r2.micPosTagInfo = (MicPosTagInfo) r28;
        k1 r29 = r16.getContent();
        if ((r29 instanceof ListUserContent) == true) goto L272;
        r29 = null;
    L272:
        ListUserContent r30 = (ListUserContent) r29;
        if (r30 == null) goto L281;
        ListUserLinkmicAudienceContent r31 = r30.mLinkmicAudienceContent;
        if (r31 == null) goto L281;
        r2.setFanTicket(r31.getFanTicket());
        int r32 = com.bytedance.android.live.liveinteract.utils.y.a;
        IBaseUser r33 = r2.getUser();
        if (r33 == null) goto L279;
        String r36 = r33.getIdString();
    L280:
        r2.mFanTicketDisplayStr = com.bytedance.android.live.liveinteract.utils.y.a(r36, jc1.m.a(r31.rankUserIds), r31.getFanTicketRealStr(), r31.getFanTicketFuzzyStr());
        r2.isHost = r31.isHost();
        r2.appId = r31.getAppId();
        r2.clientVersion = r31.getClientVersion();
        r2.devicePlatform = r31.getDevicePlatform();
        r2.linkedListUserInfo = LinkedListUserInfo.copy(r31.getJoinChannelTime(), r31.getExpectLeaveTime(), r31.getCurrentTime());
        r2.listUserRole = r31.getListUserRole();
        r2.paidCount = r31.getPaidCount();
        r2.isAnonymous = r31.isAnonymous();
        r2.selfDisciplineDuration = r31.getSelfDisciplineDurationTime();
        goto L281
    L279:
        r36 = null;
    L281:
        r14.add(r2);
    L282:
        r3 = null;
    L265:
        r27 = false;
    L254:
        r22 = null;
        goto L255
    L245:
        r4 = false;
        goto L246
    L216:
        if (r38 == null) goto L237;
        Intrinsics.checkNotNullParameter(r38, "$this$queryRoomID");
        Intrinsics.checkNotNullParameter(r16, "linkUser");
        Iterator<Map.Entry<Long, ? extends g2>> r115 = r38.entrySet().iterator();
    L219:
        if (r115.hasNext() == false) goto L235;
        Map.Entry<Long, ? extends g2> r116 = r115.next();
        long r117 = r116.getKey().longValue();
        List r118 = r116.getValue().getLinkedUsers();
        if (r118 == null) goto L231;
        Iterator r119 = r118.iterator();
    L224:
        if (r119.hasNext() == false) goto L229;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.link.model.bridge.k) r120).getInteractId(), r16.getInteractId()) == false) goto L224;
    L230:
        com.bytedance.android.livesdk.link.model.bridge.k r40 = (com.bytedance.android.livesdk.link.model.bridge.k) r120;
    L232:
        if (r40 == null) goto L219;
    L236:
        Long r41 = Long.valueOf(r117);
    L238:
        if (r41 == null) goto L240;
        long r121 = r41.longValue();
    L241:
        r14.add(dl0.n.e(r16, r121));
        goto L282
    L240:
        r121 = 0;
        goto L241
    L229:
        r120 = null;
        goto L230
    L231:
        r40 = null;
        goto L232
    L235:
        r117 = 0;
        goto L236
    L237:
        r41 = null;
        goto L238
    L208:
        r113 = r3;
        goto L210
    L204:
        r111 = r3;
        goto L205
    L212:
        r18 = r3;
        goto L213
    L283:
        this.c.clear();
        this.c.addAll(r14);
        Iterator<LinkPlayerInfo> r42 = this.c.iterator();
    L285:
        if (r42.hasNext() == false) goto L293;
        LinkPlayerInfo r43 = r42.next();
        String r44 = j();
        IBaseUser r45 = r43.getUser();
        if (r45 == null) goto L289;
        String r46 = r45.getIdString();
    L291:
        if (Intrinsics.areEqual(r44, r46) == false) goto L285;
        LinkPlayerInfo r122 = r43;
    L294:
        LinkPlayerInfo r123 = r122;
        if (r123 == null) goto L298;
        this.c.remove(r123);
    L298:
        if (this.q.booleanValue() == true) goto L300;
        return true;
    L300:
        if (((Boolean) tv0.a.getValue()).booleanValue() == false) goto L348;
        ALogger.w(this.a, "updateOnlineList  mGuestOnlineUserList = " + this.d + ", mOnlineUserList = " + this.c + ", guestAnchorId = " + j() + ", guestUpdated = " + r0 + ", linkUsers = " + r34);
        return true;
    L348:
        return true;
    L289:
        r46 = null;
        goto L291
    L293:
        r122 = null;
        goto L294
    L171:
        r0 = r39;
        goto L173
    L6:
        if (r35 <= 0) goto L164;
        long r124 = this.t;
        if (r35 >= r124) goto L164;
        v r47 = this.x;
        CopyOnWriteArrayList<LinkPlayerInfo> r125 = this.c;
        a r48 = this.s;
        r47.getClass();
        Intrinsics.checkNotNullParameter(r37, "from");
        Intrinsics.checkNotNullParameter(r7, "linkUsers");
        Intrinsics.checkNotNullParameter(r125, "currentLinkUsers");
        if ((!Intrinsics.areEqual(r37, "listV2")) == false) goto L17;
        if (r48 == null) goto L13;
        String r126 = r48.b;
    L15:
        if (Intrinsics.areEqual(r126, "listV2") == false) goto L17;
        ALogger.w("ttlive_pk_list_version", "listV2 invalid rollback, [" + r37 + "] last=" + r48 + " current=" + r124 + ", new=" + r35);
        r7 = r7;
        r24 = "listV2";
        String r127 = ",isBg=";
        String r128 = ",mc=";
        String r49 = ",silence=";
        String r210 = ",linkType=";
    L109:
        String r211 = r128;
        String r50 = r127;
        String r51 = "[";
        String r52 = r210;
        boolean r53 = false;
    L123:
        if (this.v.interceptOldVersion == false) goto L125;
        ALogger.e(this.a, "interceptOldVersion");
        r8 = new ArrayList();
        goto L167
    L125:
        if (r53 == false) goto L165;
        ArrayList r54 = new ArrayList();
        Iterator r55 = r7.iterator();
    L128:
        if (r55.hasNext() == false) goto L152;
        AnchorLinkUser r56 = (AnchorLinkUser) r55.next();
        Iterator<LinkPlayerInfo> r57 = this.c.iterator();
    L131:
        if (r57.hasNext() == false) goto L143;
        LinkPlayerInfo r129 = r57.next();
        LinkPlayerInfo r130 = r129;
        IBaseUser r131 = r56.getUser();
        if (r131 == null) goto L135;
        String r132 = r131.getIdString();
    L136:
        IBaseUser r133 = r130.getUser();
        if (r133 == null) goto L139;
        String r134 = r133.getIdString();
    L141:
        if (Intrinsics.areEqual(r132, r134) == false) goto L131;
    L144:
        LinkPlayerInfo r135 = r129;
        if (r135 != null) goto L146;
        r54.add(r56);
        goto L128
    L146:
        r56.setStatus(r135.getLinkStatus());
        r56.setLinkType(r135.getLinkType());
        r56.setUserPosition(r135.userPosition);
        r56.setSilenceStatus(r135.silenceStatus);
        r56.setMcStatus(r135.mcStatus);
        if (r135.isBackground == false) goto L149;
        long r58 = 1;
    L150:
        r56.setBackground(r58);
        goto L128
    L149:
        r58 = 0;
        goto L150
    L139:
        r134 = null;
        goto L141
    L135:
        r132 = null;
        goto L136
    L143:
        r129 = null;
        goto L144
    L152:
        Iterator r59 = r54.iterator();
    L154:
        if (r59.hasNext() == false) goto L156;
        r7.remove((AnchorLinkUser) r59.next());
        goto L154
    L156:
        List r60 = r7;
        String r61 = this.a;
        StringBuilder r62 = new StringBuilder("correct link version data, removedUsers=");
        r62.append(r54.size());
        r62.append(", corrected list=");
        Intrinsics.checkNotNullParameter(r60, "$this$toLogString");
        StringBuilder r63 = new StringBuilder("ListUsers{size=");
        r63.append(r60.size());
        String r136 = ",";
        r63.append(",");
        Iterator r137 = r60.iterator();
    L158:
        if (r137.hasNext() == false) goto L163;
        AnchorLinkUser r138 = (AnchorLinkUser) r137.next();
        r63.append(r51);
        if (r138.getMUser() == null) goto L162;
        r63.append("id=");
        r63.append(d5.c(r138.getMUser().getIdString()));
        r63.append(r136);
    L162:
        r63.append("pos=");
        r63.append(r138.getMUserPosition());
        r63.append(r49);
        r63.append(r138.getMSilenceStatus());
        r63.append(",linkId=");
        r63.append(r138.getMLinkmicIdStr());
        r63.append(r52);
        r63.append(r138.getMLinkType());
        r63.append(r50);
        r63.append(r138.isBackground());
        r63.append(r211);
        r63.append(r138.getMcStatus());
        r63.append(",isCPos=");
        r63.append(CPositionModeUtil.isCPositionUser(r138));
        r63.append("]");
        r136 = r136;
        r60 = r60;
        goto L158
    L163:
        r7 = r60;
        r63.append("}");
        r62.append(r63.toString());
        ALogger.e(r61, r62.toString());
        goto L165
    L13:
        r126 = null;
    L17:
        r24 = "listV2";
        if (r7.size() == r125.size()) goto L20;
        ALogger.e("ttlive_pk_list_version", "checkRollback: list size diff current=" + r125.size() + " new=" + r7.size());
        String r139 = "list size diff";
    L45:
        r7 = r7;
        long r310 = r124;
        r127 = ",isBg=";
        r128 = ",mc=";
        r49 = ",silence=";
        r210 = ",linkType=";
    L104:
        if (r139.length() != 0) goto L106;
        boolean r65 = true;
    L107:
        if (r65 == false) goto L110;
        ALogger.e("ttlive_pk_list_version", "invalid rollback, [" + r37 + "] last=" + r48 + " cnt=" + r47.b);
        goto L109
    L110:
        r47.b++;
        r51 = "[";
        StringBuilder r66 = new StringBuilder(r51);
        r66.append(r37);
        r66.append("] version rollback! type=");
        r66.append(r139);
        r66.append("; cnt=");
        r66.append(r47.b);
        r66.append(", last=");
        r66.append(r48);
        r66.append(" current=");
        r211 = r128;
        long r140 = r310;
        r66.append(r140);
        r66.append(", new=");
        r50 = r127;
        r66.append(r35);
        ALogger.e("ttlive_pk_list_version", r66.toString());
        LinkedHashMap r67 = new LinkedHashMap();
        r67.put("new_list_version", Long.valueOf(r35));
        r67.put("version_diff", Long.valueOf(r140 - r35));
        r67.put("error_msg", r139);
        r67.put("from", r37);
        r67.put("current_version", Long.valueOf(r140));
        r67.put("refresh_info", String.valueOf(r48));
        if ((r47.b % r47.a) != 0) goto L114;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("fatal_list_version_rollback", r67);
    L121:
        r53 = true;
        r52 = r210;
        goto L123
    L114:
        if (hd0.c.f().h() == false) goto L121;
        if ((System.currentTimeMillis() - r47.d) <= 60000) goto L121;
        r47.d = System.currentTimeMillis();
        if (r47.c == false) goto L120;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("list_version_rollback", r67);
        goto L121
    L120:
        ALogger.w("ttlive_pk_list_version", r67.toString());
        goto L121
    L106:
        r65 = false;
        goto L107
    L20:
        int r141 = r7.size();
        int r142 = 0;
    L21:
        if (r142 >= r141) goto L102;
        AnchorLinkUser r212 = (AnchorLinkUser) ListProtector.get(r7, r142);
        Iterator<LinkPlayerInfo> r213 = r125.iterator();
    L24:
        if (r213.hasNext() == false) goto L41;
        LinkPlayerInfo r214 = r213.next();
        IBaseUser r215 = r214.getUser();
        if (r215 == null) goto L30;
        String r216 = r215.getIdString();
        if (r216 == null) goto L30;
        Long r143 = Long.valueOf(d5.c(r216));
    L31:
        IBaseUser r217 = r212.getUser();
        if (r217 == null) goto L36;
        String r218 = r217.getIdString();
        if (r218 == null) goto L36;
        Long r144 = Long.valueOf(d5.c(r218));
    L38:
        if (Intrinsics.areEqual(r143, r144) == true) goto L42;
        r141 = r141;
        r125 = r125;
    L42:
        LinkPlayerInfo r145 = r214;
        if (r145 == null) goto L44;
        IBaseUser r146 = r212.getUser();
        if (r146 == null) goto L51;
        String r147 = r146.getIdString();
        if (r147 == null) goto L51;
        Long r148 = Long.valueOf(d5.c(r147));
    L52:
        IBaseUser r219 = r145.getUser();
        if (r219 == null) goto L57;
        String r220 = r219.getIdString();
        if (r220 == null) goto L57;
        Long r68 = Long.valueOf(d5.c(r220));
    L59:
        if ((!Intrinsics.areEqual(r148, r68)) == true) goto L84;
        if (r212.getStatus() != r145.getLinkStatus()) goto L84;
        if (r212.getLinkType() != r145.getLinkType()) goto L84;
        if (r212.getUserPosition() != r145.userPosition) goto L84;
        if (r212.getSilenceStatus() != r145.silenceStatus) goto L84;
        if (r212.getMcStatus() != r145.mcStatus) goto L84;
        r310 = r124;
        if (r212.isBackground() != (r145.isBackground ? 1 : 0)) goto L85;
        k1 r69 = r212.getContent();
        if (r69 == null) goto L79;
        l1 r70 = r69.getLinkMicAudienceContent();
        if (r70 == null) goto L79;
        if (r70.isEnlarged() != true) goto L79;
        boolean r71 = true;
    L81:
        if (r71 != r145.isEnlarged) goto L85;
        r142 = r142 + 1;
        r7 = r7;
        r141 = r141;
        r125 = r125;
        r124 = r310;
    L79:
        r71 = false;
    L85:
        StringBuilder r72 = new StringBuilder("checkRollback: user diff at ");
        r72.append(r142);
        r72.append(", current=");
        StringBuilder r73 = new StringBuilder("LinkPlayerInfo{uid=");
        IBaseUser r74 = r145.getUser();
        if (r74 == null) goto L90;
        String r75 = r74.getIdString();
        if (r75 == null) goto L90;
        Object r76 = Long.valueOf(d5.c(r75));
    L91:
        r73.append(r76);
        r73.append(",linkId=");
        r73.append(r145.getInteractId());
        r73.append(",linkType=");
        r73.append(r145.getLinkType());
        r49 = ",silence=";
        r73.append(r49);
        r73.append(r145.silenceStatus);
        r73.append(",userPos=");
        r73.append(r145.userPosition);
        r128 = ",mc=";
        r73.append(r128);
        r73.append(r145.mcStatus);
        r127 = ",isBg=";
        r73.append(r127);
        r73.append(r145.isBackground);
        r73.append(", isCPos=");
        r73.append(r145.isEnlarged);
        r73.append('}');
        r72.append(r73.toString());
        r72.append(", new=");
        r72.append(v.a(r212));
        ALogger.e("ttlive_pk_list_version", r72.toString());
        if (r48 == null) goto L94;
        String r77 = r48.b;
    L96:
        if (Intrinsics.areEqual(r77, MultiLinkOpenSource.MESSAGE) == false) goto L100;
        r210 = ",linkType=";
        if (StringsKt.contains$default(r37, "Msg", false, 2, null) == false) goto L101;
        r139 = "list user diff at " + r142 + " message disorder";
    L101:
        r139 = "list user diff at " + r142;
        goto L104
    L100:
        r210 = ",linkType=";
        goto L101
    L94:
        r77 = null;
    L90:
        r76 = null;
    L84:
        r310 = r124;
    L57:
        r68 = null;
    L51:
        r148 = null;
        goto L52
    L44:
        ALogger.e("ttlive_pk_list_version", "checkRollback: newUser doesn't exist in current list, new=" + v.a(r212));
        r139 = "current list no such user " + v.a(r212);
    L36:
        r144 = null;
    L30:
        r143 = null;
        goto L31
    L41:
        r141 = r141;
        r125 = r125;
        r214 = null;
        goto L42
    L102:
        r7 = r7;
        r310 = r124;
        r127 = ",isBg=";
        r128 = ",mc=";
        r49 = ",silence=";
        r210 = ",linkType=";
        r139 = "";
    L164:
        r7 = r7;
        r24 = "listV2";
        this = this;
        this.t = r35;
        this.x.b = 0;
        ALogger.i(this.a, "processListWithVersion " + r37 + " list_version=" + r35);
        goto L165
    }
}
