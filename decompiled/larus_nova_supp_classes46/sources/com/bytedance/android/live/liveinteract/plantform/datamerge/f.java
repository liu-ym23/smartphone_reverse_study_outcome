package com.bytedance.android.live.liveinteract.plantform.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPlaceHolderViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import sh0.h0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final boolean a;
    public final boolean b;
    public String c;
    public long d;
    public final long e;
    public final a f;
    public final IRoom g;
    public final DataCenter h;
    public final boolean i;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.m j;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a k;
    public final d l;
    public final eh0.b m;
    public final int n;
    public final Function0<Boolean> o;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("WindowListHelper", "firstPriorityGuestUidUpdateTask start");     // Catch: Throwable -> L4
            this.a.k.u();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a(String r7, List<tf0.e> r8, List<ch0.e> r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        Intrinsics.checkNotNullParameter(r8, "windowList");
        Intrinsics.checkNotNullParameter(r9, "linkedUserMergeDataList");
        if (this.i == true) goto L13;
        rj0.l.n2.getClass();
        rj0.l r11 = rj0.l.a.a();
        boolean r1 = true;
        if (r11 != null) goto L7;
    L8:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r12 = IVoiceChatGuestService.a.a();
        if (r12 != null) goto L11;
    L14:
        if (r1 == false) goto L38;
        Iterator r13 = ((ArrayList) r9).iterator();
    L17:
        if (r13.hasNext() == false) goto L59;
        ch0.e r14 = (ch0.e) r13.next();
        int r2 = r14.a.getUserPosition();
        if (r2 < 0) goto L17;
        if (r10 <= r2) goto L17;
        ch0.j r3 = r14.c;
        if (r3 == null) goto L25;
        int r4 = r3.d;
    L27:
        if (r4 < 0) goto L31;
        if (r10 <= r4) goto L31;
        MultiLinkGuestViewBinder.a r5 = new MultiLinkGuestViewBinder.a(r14, null, 62);
        r5.a = r4;
        ListProtector.set(r8, r4, r5);
    L31:
        if (r4 != (-1)) goto L34;
        if (r2 != 0) goto L34;
        MultiLinkGuestViewBinder.a r6 = new MultiLinkGuestViewBinder.a(r14, null, 62);
        r6.a = 0;
        ListProtector.set(r8, 0, r6);
    L34:
        if (r4 != (-1)) goto L17;
        if ((ListProtector.get(r8, r2) instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L17;
        MultiLinkGuestViewBinder.a r15 = new MultiLinkGuestViewBinder.a(r14, null, 62);
        r15.a = r2;
        ListProtector.set(r8, r2, r15);
        goto L17
    L25:
        r4 = -1;
        goto L27
    L59:
        return;
    L38:
        this.k.getClass();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a.t(r8, r9, r10);
        return;
    L11:
        if (r12.isEngineOn() == true) goto L13;
    L7:
        if (r11.isEngineOn() != true) goto L8;
    L13:
        r1 = false;
        goto L14
    }

    public final void b(List<tf0.e> r20, List<ch0.e> r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r20, "windowList");
        Intrinsics.checkNotNullParameter(r21, "linkedUserMergeDataList");
        Intrinsics.checkNotNullParameter(r23, "anchorId");
        if (this.j.getUiLayout() != 15) goto L284;
        this.k.getClass();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a.q(r20, 0);
        if ((!r20.isEmpty()) == false) goto L16;
        Object r6 = ListProtector.get(r20, 0);
        if ((r6 instanceof MultiLinkGuestViewBinder.a) == true) goto L10;
        r6 = null;
    L10:
        if (((MultiLinkGuestViewBinder.a) r6) == null) goto L16;
        Object r7 = ListProtector.remove(r20, 0);
        if (r7 == null) goto L15;
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r7;
        MultiLinkFirstUserViewBinder.a r9 = new MultiLinkFirstUserViewBinder.a(r8.k, r8.l);
        ListProtector.add(r20, 0, r9);
        MultiLinkFirstUserViewBinder.a r16 = r9;
    L17:
        boolean r10 = ((Boolean) this.o.invoke()).booleanValue();
        int r11 = ((ArrayList) r21).size();
        if (this.i == true) goto L28;
        rj0.l.n2.getClass();
        rj0.l r12 = rj0.l.a.a();
        if (r12 != null) goto L22;
    L23:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r13 = IVoiceChatGuestService.a.a();
        if (r13 != null) goto L26;
    L27:
        boolean r14 = true;
    L29:
        ArrayList r15 = (ArrayList) r20;
        MultiLinkNormalEmptyViewBinder.a r17 = this.k.g(r15.size());
        if (r14 == false) goto L43;
        if (r11 > 1) goto L33;
        r15.add(this.k.g(r15.size()));
        ArrayList r5 = r15;
        r5.add(new MultiLinkFoldButtonViewBinder.a(false, r10, r11 - 1, false, false, r17, r16));
    L49:
        if (r10 == false) goto L63;
        if ((!r20.isEmpty()) == false) goto L63;
        tf0.e r18 = (tf0.e) CollectionsKt.last(r20);
        if ((r18 instanceof MultiLinkFoldButtonViewBinder.a) == true) goto L57;
        if ((r18 instanceof MultiLinkLastEmptyViewBinder.a) == false) goto L63;
    L57:
        if (r5.size() >= r22) goto L63;
        int r3 = r22 - r5.size();
        r5.remove(r18);
        int r19 = 0;
    L59:
        if (r19 >= r3) goto L61;
        r5.add(new MultiLinkPlaceHolderViewBinder.a());
        r19 = r19 + 1;
        goto L59
    L61:
        r5.add(r18);
    L63:
        if (this.i == false) goto L114;
        List r2 = CollectionsKt.toMutableList(r21);
        if (r2.size() == 0) goto L81;
        Iterator r4 = r2.iterator();
    L68:
        if (r4.hasNext() == false) goto L76;
        Object r24 = r4.next();
        IBaseUser r25 = ((ch0.e) r24).a.getUser();
        if (r25 == null) goto L72;
        String r26 = r25.getIdString();
    L74:
        if (Intrinsics.areEqual(r26, r23) == false) goto L68;
    L77:
        ch0.e r27 = (ch0.e) r24;
        if (r27 == null) goto L81;
        r2.remove(r27);
        goto L81
    L72:
        r26 = null;
        goto L74
    L76:
        r24 = null;
    L81:
        if (r2.size() == 0) goto L114;
        CollectionsKt.sortWith(r2, new g(this));
        IBaseUser r28 = ((ch0.e) ListProtector.get(r2, 0)).a.getUser();
        String r29 = "";
        if (r28 == null) goto L86;
        String r30 = r28.getIdString();
        if (r30 == null) goto L86;
    L88:
        if ((!Intrinsics.areEqual(this.c, r30)) == false) goto L114;
        if ((System.currentTimeMillis() - this.d) >= this.e) goto L105;
        Iterator r31 = r2.iterator();
    L93:
        if (r31.hasNext() == false) goto L101;
        Object r32 = r31.next();
        IBaseUser r110 = ((ch0.e) r32).a.getUser();
        if (r110 == null) goto L97;
        String r111 = r110.getIdString();
    L99:
        if (Intrinsics.areEqual(r111, this.c) == false) goto L93;
    L102:
        ch0.e r33 = (ch0.e) r32;
        if (r33 == null) goto L105;
        ALogger.i("WindowListHelper", "updateFirstPriorityGuest return, \nfirstPriorityGuest :" + ch0.f.e(r33) + "\nnewFirstPriorityGuest :" + ch0.f.e((ch0.e) ListProtector.get(r2, 0)));
        goto L114
    L97:
        r111 = null;
        goto L99
    L101:
        r32 = null;
    L105:
        MainThreadPostUtils.d(this.f);
        MainThreadPostUtils.c(this.f, this.e);
        this.c = r30;
        this.d = System.currentTimeMillis();
        i0 r34 = j0.a(this.h);
        if (r34 == null) goto L108;
        int r35 = h0.a;
        r34.b("visible_guest_uid", this.c);
    L108:
        ALogger.i("WindowListHelper", "updateFirstPriorityGuest, firstPriorityGuest change:\n" + ch0.f.e((ch0.e) ListProtector.get(r2, 0)));
        Iterator r36 = r2.iterator();
    L110:
        if (r36.hasNext() == false) goto L112;
        r29 = r29 + ch0.f.e((ch0.e) r36.next()) + "\n";
        goto L110
    L112:
        ALogger.d("WindowListHelper", "updateFirstPriorityGuest, copyLinkedUserMergeDataList:\n" + r29);
    L86:
        r30 = "";
    L114:
        if (r10 == true) goto L116;
        Iterator<T> r1 = r20.iterator();
    L280:
        if (r1.hasNext() == false) goto L332;
        tf0.e r37 = (tf0.e) r1.next();
        if ((r37 instanceof MultiLinkGuestViewBinder.a) == false) goto L280;
        r37.j = true;
        goto L280
    L332:
        return;
    L116:
        if (this.i == true) goto L126;
        rj0.l.n2.getClass();
        rj0.l r38 = rj0.l.a.a();
        if (r38 != null) goto L120;
    L121:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r39 = IVoiceChatGuestService.a.a();
        if (r39 != null) goto L124;
    L125:
        boolean r40 = true;
    L127:
        if (r40 == false) goto L258;
        Iterator<T> r41 = r20.iterator();
        MultiLinkGuestViewBinder.a r42 = null;
        boolean r43 = true;
    L130:
        if (r41.hasNext() == false) goto L247;
        tf0.e r44 = (tf0.e) r41.next();
        if ((r44 instanceof MultiLinkFirstUserViewBinder.a) == true) goto L133;
        if ((r44 instanceof MultiLinkGuestViewBinder.a) == false) goto L130;
        ch0.j r45 = ((MultiLinkGuestViewBinder.a) r44).k.c;
        if (r45 == null) goto L139;
        boolean r46 = r45.e;
    L140:
        r44.j = r46;
        if (r46 == false) goto L143;
        r43 = false;
    L143:
        StringBuilder r47 = new StringBuilder("updateGuestVisibilityForGameDynamicWindow, visible: ");
        r47.append(r44.j);
        r47.append(", seiVisible: ");
        MultiLinkGuestViewBinder.a r48 = (MultiLinkGuestViewBinder.a) r44;
        ch0.j r49 = r48.k.c;
        if (r49 == null) goto L146;
        Boolean r50 = Boolean.valueOf(r49.e);
    L147:
        r47.append(r50);
        r47.append(", user: ");
        r47.append(r48.k.a);
        r47.append(", ");
        ALogger.d("WindowListHelper", r47.toString());
        if (this.b == false) goto L130;
        if (r43 == false) goto L130;
        if (r42 == null) goto L245;
        ch0.e r51 = r42.k;
        ch0.j r52 = r51.c;
        if (r52 != null) goto L155;
    L157:
        if (r52 != null) goto L162;
        if (r48.k.c == null) goto L162;
    L242:
        boolean r53 = false;
    L243:
        if (r53 != true) goto L245;
    L162:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r51.a) == com.bytedance.android.live.liveinteract.plantform.model.n.i(r48.k.a)) goto L165;
        r53 = com.bytedance.android.live.liveinteract.plantform.model.n.i(r42.k.a);
        goto L243
    L165:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r42.k.a) == false) goto L240;
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r48.k.a) == false) goto L240;
        int r54 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r42.d) == false) goto L222;
        d r55 = this.l;
        if (r55 == null) goto L176;
        BehaviorSubject<Map<String, Boolean>> r56 = r55.S0();
        if (r56 == null) goto L176;
        Map r57 = (Map) r56.getValue();
        if (r57 == null) goto L176;
    L177:
        eh0.b r58 = this.m;
        if (r58 == null) goto L183;
        BehaviorSubject<Map<String, Boolean>> r59 = r58.j();
        if (r59 == null) goto L183;
        Map r60 = (Map) r59.getValue();
        if (r60 == null) goto L183;
    L184:
        ch0.j r112 = r42.k.c;
        if (r112 == null) goto L187;
        String r113 = r112.a;
    L188:
        ch0.j r114 = r48.k.c;
        if (r114 == null) goto L191;
        String r115 = r114.a;
    L193:
        if (r57 == null) goto L221;
        if (r57.containsKey(r113) == false) goto L197;
        boolean r116 = Intrinsics.areEqual((Boolean) r57.get(r113), Boolean.TRUE);
    L203:
        if (r57.containsKey(r115) == false) goto L205;
        boolean r61 = Intrinsics.areEqual((Boolean) r57.get(r115), Boolean.TRUE);
    L210:
        if (r116 == false) goto L213;
        if (r61 == true) goto L213;
    L241:
        r53 = true;
    L213:
        if (r116 == true) goto L240;
        if (r61 == false) goto L240;
    L205:
        if (r60 == null) goto L217;
        if (r60.containsKey(r115) == false) goto L209;
        r61 = Intrinsics.areEqual((Boolean) r60.get(r115), Boolean.TRUE);
        goto L210
    L209:
        r61 = false;
        goto L210
    L217:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L197:
        if (r60 == null) goto L219;
        if (r60.containsKey(r113) == false) goto L201;
        r116 = Intrinsics.areEqual((Boolean) r60.get(r113), Boolean.TRUE);
        goto L203
    L201:
        r116 = false;
        goto L203
    L219:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L221:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L191:
        r115 = null;
        goto L193
    L187:
        r113 = null;
    L183:
        r60 = MapsKt.emptyMap();
    L176:
        r57 = MapsKt.emptyMap();
        goto L177
    L222:
        ch0.j r62 = r42.k.c;
        if (r62 != null) goto L225;
    L231:
        if (r62 != null) goto L233;
    L234:
        ch0.j r63 = r48.k.c;
        if (r63 == null) goto L240;
        if (r63.b != true) goto L240;
    L233:
        if (r62.b == true) goto L240;
    L225:
        if (r62.b != true) goto L231;
        ch0.j r65 = r48.k.c;
        if (r65 == null) goto L241;
        if (r65.b == true) goto L231;
    L240:
        if (r42.k.a.getJoinChannelTime() < r48.k.a.getJoinChannelTime()) goto L242;
    L155:
        if (r48.k.c != null) goto L157;
    L245:
        r42 = r48;
        goto L130
    L146:
        r50 = null;
        goto L147
    L139:
        r46 = this.a;
        goto L140
    L133:
        r44.j = true;
        goto L130
    L247:
        if (this.b == false) goto L327;
        if (r43 == false) goto L328;
        StringBuilder r66 = new StringBuilder("updateGuestVisibilityForGameDynamicWindow, show defaultGuest for audience: ");
        if (r42 == null) goto L254;
        ch0.e r67 = r42.k;
        if (r67 == null) goto L254;
        ILinkPlayerInfoBridge r68 = r67.a;
    L255:
        r66.append(r68);
        ALogger.d("WindowListHelper", r66.toString());
        if (r42 == null) goto L329;
        r42.j = true;
        return;
    L329:
        return;
    L254:
        r68 = null;
        goto L255
    L328:
        return;
    L327:
        return;
    L258:
        Iterator<T> r69 = r20.iterator();
    L260:
        if (r69.hasNext() == false) goto L331;
        tf0.e r70 = (tf0.e) r69.next();
        if ((r70 instanceof MultiLinkFirstUserViewBinder.a) == true) goto L263;
        if ((r70 instanceof MultiLinkGuestViewBinder.a) == false) goto L260;
        if (this.i == true) goto L268;
        IBaseUser r71 = ((MultiLinkGuestViewBinder.a) r70).k.a.getUser();
        if (r71 == null) goto L276;
        String r72 = r71.getIdString();
    L277:
        r70.j = Intrinsics.areEqual(r72, gh0.a.c());
        goto L260
    L276:
        r72 = null;
        goto L277
    L268:
        IBaseUser r73 = ((MultiLinkGuestViewBinder.a) r70).k.a.getUser();
        if (r73 == null) goto L271;
        String r74 = r73.getIdString();
    L272:
        r70.j = Intrinsics.areEqual(r74, this.c);
        goto L260
    L271:
        r74 = null;
        goto L272
    L263:
        r70.j = true;
        goto L260
    L331:
        return;
    L124:
        if (r39.isEngineOn() == true) goto L126;
    L120:
        if (r38.isEngineOn() != true) goto L121;
    L126:
        r40 = false;
        goto L127
    L33:
        r5 = r15;
        if (r11 != 2) goto L37;
        r5.add(new MultiLinkFoldButtonViewBinder.a(false, r10, r11 - 1, false, true, r17, r16));
        goto L49
    L37:
        if (r11 != (r22 - 1)) goto L39;
        boolean r75 = true;
    L40:
        if (r10 == true) goto L42;
        r5.add(new MultiLinkFoldButtonViewBinder.a(false, r10, r11 - 1, false, !r75, r17, r16));
        goto L49
    L42:
        r5.add(new MultiLinkFoldButtonViewBinder.a(false, r10, r11 - 1, true, false, r17, r16));
        goto L49
    L39:
        r75 = false;
        goto L40
    L43:
        r5 = r15;
        if (r11 > 1) goto L46;
        r5.add(this.k.g(r5.size()));
        r5.add(new MultiLinkFoldButtonViewBinder.a(false, r10, r11 - 1, false, false, r17, r16));
        goto L49
    L46:
        if (r11 != 2) goto L48;
        r5.add(new MultiLinkFoldButtonViewBinder.a(false, r10, r11 - 1, false, true, r17, r16));
        goto L49
    L48:
        r5.add(new MultiLinkFoldButtonViewBinder.a(true, r10, r11 - 1, true, false, r17, r16));
        goto L49
    L26:
        if (r13.isEngineOn() == true) goto L28;
    L22:
        if (r12.isEngineOn() != true) goto L23;
    L28:
        r14 = false;
        goto L29
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L16:
        r16 = null;
        goto L17
    }

    public f(IRoom r2, DataCenter r3, boolean r4, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5, com.bytedance.android.live.liveinteract.plantform.datamerge.a r6, d r7, eh0.b r8, int r9, Function0<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "windowListHelper");
        Intrinsics.checkNotNullParameter(r10, "isCurrentMicSeatFold");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        ReadOnlyProperty r11 = vm2.d.x3;
        KProperty[] r12 = vm2.d.a;
        this.a = ((Boolean) r11.getValue(null, r12[229(0xe5, float:3.21E-43)])).booleanValue();
        this.b = ((Boolean) vm2.d.y3.getValue(null, r12[230(0xe6, float:3.22E-43)])).booleanValue();
        this.c = "";
        this.e = ((Number) vm2.d.w3.getValue(null, r12[228(0xe4, float:3.2E-43)])).longValue();
        this.f = new a(this);
    }
}
