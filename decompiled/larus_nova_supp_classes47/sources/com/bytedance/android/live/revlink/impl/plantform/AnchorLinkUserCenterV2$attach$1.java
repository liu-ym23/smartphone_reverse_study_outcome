package com.bytedance.android.live.revlink.impl.plantform;

import android.util.LruCache;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenuelink.usercenter.ListUpdateType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.livesdk.link.model.a6;
import com.bytedance.android.livesdk.link.model.b6;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.h6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r6;
import com.bytedance.android.livesdk.link.model.t6;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class AnchorLinkUserCenterV2$attach$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public AnchorLinkUserCenterV2$attach$1(AnchorLinkUserCenterV2 r8) {
        super(1, r8, AnchorLinkUserCenterV2.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r27) {
        Intrinsics.checkNotNullParameter(r27, "p1");
        AnchorLinkUserCenterV2 r2 = (AnchorLinkUserCenterV2) ((CallableReference) this).receiver;
        int r3 = AnchorLinkUserCenterV2.u;
        r2.getClass();
        if ((r27 instanceof h1) == false) goto L493;
        i6 r4 = (i6) ((vh7.c) r27).castTo(i6.class);
        int r5 = (int) i1.b(r4);
        if (r2.n.contains(Integer.valueOf(r5)) == true) goto L8;
        return;
    L8:
        if (r2.m == false) goto L41;
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        if (r4.getLinkerId() == r2.E()) goto L41;
        Intrinsics.checkNotNullParameter(r4, "$this$typeExt");
        int r7 = (int) r4.getType2();
        if (r7 == 6) goto L20;
        if (r7 == 7) goto L20;
        if (r7 == 11) goto L20;
        if (r7 != 10) goto L41;
    L20:
        if (r2.E() == 0) goto L26;
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        if (r4.getLinkerId() == 0) goto L26;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r6 = r2.D();
        if (r6 == null) goto L41;
        long r22 = r2.E();
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("msg_id", String.valueOf(qj.a(r4)));
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        r8.put("msg_scene", Long.valueOf(r4.getScene()));
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        r8.put("msg_linker_id", Long.valueOf(r4.getLinkerId()));
        Intrinsics.checkNotNullParameter(r4, "$this$typeExt");
        r8.put("msg_type", Long.valueOf(r4.getType2()));
        r8.put("local_channel_Id", Long.valueOf(r22));
        r6.c("list_msg_channel_id_diff_from_local", r8);
    L26:
        long r16 = 0;
        if (r2.E() != 0) goto L42;
        w r9 = r2.K();
        if (r9 == null) goto L33;
        boolean r10 = true;
        if (r9.d() != true) goto L34;
    L38:
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r12 = r2.D();
        if (r12 == null) goto L42;
        long r23 = r2.E();
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("msg_id", String.valueOf(qj.a(r4)));
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        r13.put("msg_scene", Long.valueOf(r4.getScene()));
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        r13.put("msg_linker_id", Long.valueOf(r4.getLinkerId()));
        Intrinsics.checkNotNullParameter(r4, "$this$typeExt");
        r13.put("msg_type", Long.valueOf(r4.getType2()));
        r13.put("local_channel_Id", Long.valueOf(r23));
        r12.c("invalid_channel_id_during_link", r13);
    L34:
        w r14 = r2.K();
        if (r14 == null) goto L42;
        if (r14.e() != r10) goto L42;
    L33:
        r10 = true;
    L42:
        Intrinsics.checkNotNullParameter(r4, "$this$typeExt");
        int r0 = (int) r4.getType2();
        String r15 = "null";
        if (r0 == 6) goto L344;
        String r24 = "AnchorLinkUserCenterV2 leaveUserCache put error";
        if (r0 != 7) goto L47;
        ILinkerLeaveContentBridge r17 = r4.getLeave();
        v r1 = r2.J();
        if (r1 == null) goto L261;
        r1.B(r4);
    L261:
        if (y41.f.N.b() == true) goto L440;
        Iterator r18 = ((CopyOnWriteArrayList) r2.a).iterator();
    L276:
        if (r18.hasNext() == false) goto L283;
        p r19 = (p) r18.next();
        LruCache<String, p> r20 = r2.f;
        IBaseUser r25 = r19.getUser();
        if (r25 == null) goto L281;
        String r26 = r25.getIdString();
        if (r26 == null) goto L281;
    L282:
        r20.put(r26, r19);
    L281:
        r26 = "";
    L283:
        Iterator r28 = ((CopyOnWriteArrayList) r2.a).iterator();
    L285:
        if (r28.hasNext() == false) goto L305;
        p r29 = (p) r28.next();
        IBaseUser r30 = r29.getUser();
        if (r30 == null) goto L289;
        String r32 = r30.getIdString();
    L290:
        ILinkerLeaveContentBridge r33 = r4.getLeave();
        if (r33 == null) goto L293;
        String r34 = ILinkerLeaveContentBridgeKt.getUserIdEx(r33);
    L295:
        if (Intrinsics.areEqual(r32, r34) == false) goto L285;
        com.bytedance.android.live.revlink.impl.global.c r35 = r2.s;
        if (r35 == null) goto L299;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r36 = r35.rb();
    L300:
        if (r36 == null) goto L305;
        k<com.bytedance.android.live.revlink.impl.multianchor.vm.a> r37 = r36.getAnchorLeave();
        if (r37 == null) goto L305;
        r37.post(new com.bytedance.android.live.revlink.impl.multianchor.vm.a(r29, j6.c(r4)));
        goto L305
    L299:
        r36 = null;
        goto L300
    L293:
        r34 = null;
        goto L295
    L289:
        r32 = null;
    L305:
        if (r2.m == true) goto L307;
    L309:
        ILinkerLeaveContentBridge r38 = r4.getLeave();
        if (r38 == null) goto L312;
        Long r39 = Long.valueOf(r38.getVersion());
    L313:
        g6 r40 = j6.c(r4);
        if (r40 == null) goto L318;
        List r42 = r40.getLinkUsers();
        if (r42 == null) goto L318;
        List<? extends p> r43 = CollectionsKt.toList(r42);
    L320:
        if (r2.A(r39, r43, r4, "LEAVE_MSG") == false) goto L510;
        ListUpdateType r44 = ListUpdateType.LEAVE_MSG;
        StringBuilder r45 = new StringBuilder("leave=");
        ILinkerLeaveContentBridge r46 = r4.getLeave();
        if (r46 == null) goto L325;
        String r47 = ILinkerLeaveContentBridgeKt.getUserIdEx(r46);
    L326:
        r45.append(r47);
        String r48 = r45.toString();
        String r110 = String.valueOf(qj.a(r4));
        if (r17 == null) goto L329;
        long r111 = r17.getVersion();
    L330:
        com.bytedance.android.live.revlink.impl.utils.a r49 = r2.B();
        if (r49 == null) goto L336;
        String r50 = r49.b();
        if (r50 == null) goto L336;
        String r112 = r50;
    L337:
        r2.o = new AnchorLinkUserCenterV2.b(r44, r48, r5, r112, r110, r111, 64);
        g6 r52 = j6.c(r4);
        if (r52 == null) goto L342;
        List r53 = r52.getLinkUsers();
        if (r53 == null) goto L342;
        List<? extends p> r54 = CollectionsKt.toList(r53);
    L343:
        r2.S(r54, r5, "LEAVE_MSG", r4);
        return;
    L342:
        r54 = null;
    L336:
        r112 = "";
        goto L337
    L329:
        r111 = r16;
        goto L330
    L325:
        r47 = null;
        goto L326
    L510:
        return;
    L318:
        r43 = null;
        goto L320
    L312:
        r39 = null;
        goto L313
    L307:
        if (r2.L(r5) == false) goto L309;
        jy0.b.c("ttlive_anchor_link_users_v2", "intercept LINKER_LEAVE queryLinkList", null, 4);
        return;
    L440:
        Iterator r55 = ((CopyOnWriteArrayList) r2.a).iterator();     // Catch: Throwable -> L272
    L263:
        if (r55.hasNext() == false) goto L283;
        p r56 = (p) r55.next();     // Catch: Throwable -> L272
        LruCache<String, p> r57 = r2.f;     // Catch: Throwable -> L272
        IBaseUser r113 = r56.getUser();     // Catch: Throwable -> L272
        if (r113 == null) goto L269;
        String r114 = r113.getIdString();     // Catch: Throwable -> L272
        if (r114 == null) goto L269;
    L270:
        r57.put(r114, r56);     // Catch: Throwable -> L272
    L269:
        r114 = "";
    L272:
        th = move-exception;
        jy0.b.b("ttlive_anchor_link_users_v2", r24, th);
        goto L283
    L47:
        if (r0 != 10) goto L49;
        v r58 = r2.J();
        if (r58 == null) goto L121;
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        LinkedHashMap r59 = new LinkedHashMap();
        r59.put("msg_id", String.valueOf(qj.a(r4)));
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        r59.put("msg_scene", Long.valueOf(r4.getScene()));
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        r59.put("msg_linker_id", Long.valueOf(r4.getLinkerId()));
        r6 r60 = r4.getWaitingListChange();
        if (r60 == null) goto L116;
        List r115 = r60.getLinkUsers();
        if (r115 == null) goto L115;
        List r116 = CollectionsKt.toList(r115);
        if (r116 == null) goto L115;
        String r117 = i11.a.c(r116);
        if (r117 == null) goto L115;
        r15 = r117;
    L115:
        r59.put("msg_list_user", r15);
        r59.put("list_version", Long.valueOf(r60.getVersion()));
    L118:
        if (r58.k() == false) goto L120;
        r58.b(r59);
        r58.H("receive_waiting_list_change_msg", r59);
        goto L121
    L120:
        r58.d(r59);
        int r62 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link", "receive_waiting_list_change_msg " + r59);
        goto L121
    L116:
        r59.put("content", "null");
    L121:
        v41.a r63 = v41.a.m;
        r63.getClass();
        if (((Boolean) v41.a.h.getValue(r63, v41.a.a[6])).booleanValue() == false) goto L255;
        com.bytedance.android.live.revlink.impl.global.c r64 = r2.s;
        if (r64 == null) goto L126;
        com.bytedance.android.live.revenuelink.connect.g r65 = r64.getAnchorConnectUtils();
    L127:
        if (r65 != null) goto L129;
    L131:
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        long r66 = r4.getLinkerId();
        com.bytedance.android.live.revlink.impl.global.c r67 = r2.s;
        if (r67 == null) goto L134;
        com.bytedance.android.live.revenuelink.connect.g r68 = r67.getAnchorConnectUtils();
    L135:
        if (r68 != null) goto L137;
        return;
    L137:
        if (r66 != r68.getChannelId()) goto L507;
        r6 r69 = r4.getWaitingListChange();
        if (r69 == null) goto L142;
        Long r70 = Long.valueOf(r69.getVersion());
    L143:
        r6 r72 = r4.getWaitingListChange();
        if (r72 == null) goto L148;
        List r73 = r72.getLinkUsers();
        if (r73 == null) goto L148;
        List<? extends p> r74 = CollectionsKt.toList(r73);
    L150:
        if (r2.A(r70, r74, r4, "WAITING_MSG") == false) goto L508;
        ListUpdateType r75 = ListUpdateType.WAITING_MSG;
        String r118 = String.valueOf(qj.a(r4));
        r6 r76 = r4.getWaitingListChange();
        if (r76 == null) goto L155;
        r16 = r76.getVersion();
    L155:
        com.bytedance.android.live.revlink.impl.utils.a r77 = r2.B();
        if (r77 == null) goto L161;
        String r78 = r77.b();
        if (r78 == null) goto L161;
        String r119 = r78;
    L162:
        r2.o = new AnchorLinkUserCenterV2.b(r75, "", r5, r119, r118, r16, 64);
        r6 r79 = r4.getWaitingListChange();
        if (r79 == null) goto L167;
        List r80 = r79.getLinkUsers();
        if (r80 == null) goto L167;
        List r82 = CollectionsKt.toList(r80);
    L168:
        if (r82 == null) goto L509;
        ((CopyOnWriteArrayList) r2.b).clear();
        List<p> r83 = r2.b;
        List r84 = r82;
        ArrayList r85 = new ArrayList();
        Iterator r86 = r84.iterator();
    L172:
        if (r86.hasNext() == false) goto L179;
        Object r87 = r86.next();
        if (((p) r87).getStatus() != 1) goto L176;
        boolean r120 = true;
    L177:
        if (r120 == false) goto L172;
        r85.add(r87);
        goto L172
    L176:
        r120 = false;
        goto L177
    L179:
        ((CopyOnWriteArrayList) r83).addAll(r85);
        Iterator<i11.c.b> r88 = r2.h.iterator();
    L181:
        if (r88.hasNext() == false) goto L186;
        i11.c.b r89 = r88.next();
        if (r5 == 1) goto L184;
        List<p> r90 = r2.b;
        r82.size();
        r89.a(r5, r90);
        goto L181
    L184:
        r82.size();
        r89.i(r5);
        goto L181
    L186:
        ArrayList r92 = new ArrayList(r2.a);
        ((CopyOnWriteArrayList) r2.a).clear();
        ArrayList r93 = new ArrayList();
        Iterator r94 = r84.iterator();
    L188:
        if (r94.hasNext() == false) goto L195;
        Object r95 = r94.next();
        if (((p) r95).getStatus() != 2) goto L192;
        boolean r96 = true;
    L193:
        if (r96 == false) goto L188;
        r93.add(r95);
        goto L188
    L192:
        r96 = false;
        goto L193
    L195:
        List r97 = CollectionsKt.toMutableList(r93);
        ((CopyOnWriteArrayList) r2.a).addAll(r97);
        Iterator r98 = ((ArrayList) g.a(r92, r2.a)).iterator();
    L197:
        if (r98.hasNext() == false) goto L228;
        p r99 = (p) r98.next();
        IBaseUser r100 = r99.getUser();
        if (r100 == null) goto L201;
        String r101 = r100.getIdString();
    L202:
        if (r101 != null) goto L204;
    L207:
        boolean r102 = true;
    L208:
        if (r102 == true) goto L197;
        if (y41.f.N.b() == false) goto L221;
        LruCache<String, p> r103 = r2.f;     // Catch: Throwable -> L219
        IBaseUser r104 = r99.getUser();     // Catch: Throwable -> L219
        if (r104 == null) goto L216;
        String r105 = r104.getIdString();     // Catch: Throwable -> L219
        if (r105 == null) goto L216;
    L217:
        r103.put(r105, r99);     // Catch: Throwable -> L219
    L216:
        r105 = "";
    L219:
        th = move-exception;
        String r106 = r24;
        jy0.b.b("ttlive_anchor_link_users_v2", r106, th);
    L227:
        r24 = r106;
        goto L197
    L221:
        r106 = r24;
        LruCache<String, p> r107 = r2.f;
        IBaseUser r121 = r99.getUser();
        if (r121 == null) goto L225;
        String r122 = r121.getIdString();
        if (r122 == null) goto L225;
    L226:
        r107.put(r122, r99);
    L225:
        r122 = "";
        goto L226
    L204:
        if (r101.length() == 0) goto L207;
        r102 = false;
        goto L208
    L201:
        r101 = null;
        goto L202
    L228:
        Iterator<i11.c.b> r108 = r2.h.iterator();
    L230:
        if (r108.hasNext() == false) goto L235;
        i11.c.b r109 = r108.next();
        if (r5 == 1) goto L233;
        r109.d(r5, r2.a);
        goto L230
    L233:
        r109.h(r5, r2.a);
        goto L230
    L235:
        jy0.b.f("ttlive_anchor_link_users_v2", "updateList listApi waiting: " + i11.a.c(r2.b) + " online:" + i11.a.c(r2.a), null, 4);
        r2.e.clear();
        ArrayList<p> r123 = r2.e;
        ArrayList r124 = new ArrayList();
        Iterator r125 = r84.iterator();
    L237:
        if (r125.hasNext() == false) goto L248;
        Object r126 = r125.next();
        p r127 = (p) r126;
        if (r127.getStatus() == 2) goto L245;
        if (r127.getStatus() == 1) goto L245;
        boolean r128 = false;
    L246:
        if (r128 == false) goto L237;
        r124.add(r126);
    L245:
        r128 = true;
        goto L246
    L248:
        r123.addAll(r124);
        Iterator<i11.c.b> r129 = r2.h.iterator();
    L250:
        if (r129.hasNext() == false) goto L512;
        i11.c.b r130 = r129.next();
        if (r130 == null) goto L250;
        r130.b(r5, r2.e);
        goto L250
    L512:
        return;
    L509:
        return;
    L167:
        r82 = null;
    L161:
        r119 = "";
        goto L162
    L508:
        return;
    L148:
        r74 = null;
        goto L150
    L142:
        r70 = null;
        goto L143
    L507:
        return;
    L134:
        r68 = null;
        goto L135
    L129:
        if (r65.s1() != 0) goto L131;
        return;
    L126:
        r65 = null;
        goto L127
    L255:
        if (r2.m == false) goto L496;
        r2.b(4, "receive_link_message_10");
        return;
    L496:
        return;
    L49:
        if (r0 != 11) goto L504;
        h6 r131 = r4.getLinkedListChange();
        v r132 = r2.J();
        if (r132 == null) goto L74;
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        LinkedHashMap r133 = new LinkedHashMap();
        r133.put("msg_id", String.valueOf(qj.a(r4)));
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        r133.put("msg_scene", Long.valueOf(r4.getScene()));
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        r133.put("msg_linker_id", Long.valueOf(r4.getLinkerId()));
        h6 r134 = r4.getLinkedListChange();
        if (r134 == null) goto L64;
        List r135 = r134.getLinkUsers();
        if (r135 == null) goto L63;
        List r136 = CollectionsKt.toList(r135);
        if (r136 == null) goto L63;
        String r137 = i11.a.c(r136);
        if (r137 == null) goto L63;
        r15 = r137;
    L63:
        r133.put("list_user", r15);
        r133.put("list_version", Long.valueOf(r134.getVersion()));
    L64:
        h6 r138 = r4.getLinkedListChange();
        if (r138 == null) goto L69;
        List r139 = r138.getLinkUsers();
        if (r139 == null) goto L69;
        List r140 = CollectionsKt.toList(r139);
    L70:
        v.y(r133, r140);
        r132.b(r133);
        if (r132.k() == false) goto L73;
        r132.H("receive_link_list_change_msg", r133);
        goto L74
    L73:
        r132.d(r133);
        int r141 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link", "receive_link_list_change_msg " + r133);
    L69:
        r140 = null;
    L74:
        if (r131 == null) goto L76;
        Long r142 = Long.valueOf(r131.getVersion());
    L77:
        if (r131 == null) goto L81;
        List r143 = r131.getLinkUsers();
        if (r143 == null) goto L81;
        List<? extends p> r144 = CollectionsKt.toList(r143);
    L83:
        if (r2.A(r142, r144, r4, "LINKED_CHANGE_MSG") == false) goto L505;
        ListUpdateType r145 = ListUpdateType.LINKED_CHANGE_MSG;
        String r146 = String.valueOf(qj.a(r4));
        if (r131 == null) goto L88;
        long r147 = r131.getVersion();
    L89:
        com.bytedance.android.live.revlink.impl.utils.a r148 = r2.B();
        if (r148 == null) goto L95;
        String r149 = r148.b();
        if (r149 == null) goto L95;
        String r150 = r149;
    L96:
        r2.o = new AnchorLinkUserCenterV2.b(r145, "", r5, r150, r146, r147, 64);
        if (r131 == null) goto L101;
        List r151 = r131.getLinkUsers();
        if (r151 == null) goto L101;
        List<? extends p> r152 = CollectionsKt.toList(r151);
    L102:
        r2.S(r152, r5, "LINKED_CHANGE", r4);
        return;
    L101:
        r152 = null;
    L95:
        r150 = "";
        goto L96
    L88:
        r147 = r16;
        goto L89
    L505:
        return;
    L81:
        r144 = null;
        goto L83
    L76:
        r142 = null;
        goto L77
    L504:
        return;
    L344:
        v r153 = r2.J();
        if (r153 == null) goto L368;
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        LinkedHashMap r154 = new LinkedHashMap();
        r154.put("msg_id", String.valueOf(qj.a(r4)));
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        r154.put("msg_scene", Long.valueOf(r4.getScene()));
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        r154.put("msg_linker_id", Long.valueOf(r4.getLinkerId()));
        a6 r155 = j6.b(r4);
        if (r155 == null) goto L358;
        Intrinsics.checkNotNullParameter(r155, "$this$userId");
        String r156 = r155.getUserIdString();
        if (r156 != null) goto L351;
        r156 = "";
    L351:
        r154.put("enter_uid", r156);
        List r157 = b6.a(r155);
        if (r157 == null) goto L357;
        String r158 = i11.a.d(r157);
        if (r158 == null) goto L357;
        r15 = r158;
    L357:
        r154.put("list_user", r15);
        r154.put("list_version", Long.valueOf(r155.getVersion()));
    L358:
        a6 r159 = j6.b(r4);
        if (r159 == null) goto L363;
        List r160 = b6.a(r159);
        if (r160 == null) goto L363;
        List r161 = CollectionsKt.toList(r160);
    L364:
        v.y(r154, r161);
        if (r153.k() == false) goto L367;
        r153.b(r154);
        r153.H("receive_linker_enter_msg", r154);
        goto L368
    L367:
        r153.d(r154);
        int r162 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link", "receive_linker_enter_msg " + r154);
    L363:
        r161 = null;
    L368:
        f1 r163 = r4.getEnter();
        if (r163 == null) goto L371;
        Long r164 = Long.valueOf(r163.getVersion());
    L372:
        a6 r165 = j6.b(r4);
        if (r165 == null) goto L377;
        List r166 = b6.a(r165);
        if (r166 == null) goto L377;
        List<? extends p> r167 = CollectionsKt.toList(r166);
    L379:
        if (r2.A(r164, r167, r4, "ENTER_MSG") == false) goto L511;
        ListUpdateType r168 = ListUpdateType.ENTER_MSG;
        StringBuilder r169 = new StringBuilder("enter=");
        a6 r170 = j6.b(r4);
        if (r170 == null) goto L384;
        Intrinsics.checkNotNullParameter(r170, "$this$userId");
        String r171 = r170.getUserIdString();
    L385:
        r169.append(r171);
        String r172 = r169.toString();
        String r173 = String.valueOf(qj.a(r4));
        f1 r174 = r4.getEnter();
        if (r174 == null) goto L388;
        long r175 = r174.getVersion();
    L389:
        com.bytedance.android.live.revlink.impl.utils.a r176 = r2.B();
        if (r176 == null) goto L395;
        String r177 = r176.b();
        if (r177 == null) goto L395;
        String r178 = r177;
    L396:
        r2.o = new AnchorLinkUserCenterV2.b(r168, r172, r5, r178, r173, r175, 64);
        a6 r179 = j6.b(r4);
        if (r179 == null) goto L401;
        List r180 = b6.a(r179);
        if (r180 == null) goto L401;
        List<? extends p> r181 = CollectionsKt.toList(r180);
        i6 r182 = null;
    L402:
        r2.S(r181, r5, "ENTER_MSG", r182);
        if (y41.f.N.g() == false) goto L500;
        a6 r183 = j6.b(r4);
        if (r183 == null) goto L407;
        i6 r184 = r183.getUiConfig();
    L408:
        r2.k = r184;
        ld.a r185 = r2.q;
        if (r185 == null) goto L501;
        NextLiveData r186 = r185.Ed();
        if (r186 == null) goto L502;
        t6 r187 = r2.k;
        if (r187 == null) goto L420;
        py.k r188 = r187.getRoomBgTopImage();
        if (r188 == null) goto L420;
        List r189 = r188.getUrls();
        if (r189 == null) goto L420;
        String r190 = (String) ListProtector.get(r189, 0);
        if (r190 == null) goto L420;
    L421:
        t6 r191 = r2.k;
        if (r191 == null) goto L431;
        py.k r192 = r191.getRoomBgBottomImage();
        if (r192 == null) goto L431;
        List r193 = r192.getUrls();
        if (r193 == null) goto L431;
        String r194 = (String) ListProtector.get(r193, 0);
        if (r194 == null) goto L431;
    L432:
        t6 r195 = r2.k;
        if (r195 == null) goto L437;
        py.k r196 = r195.getRoomBgTopImage();
        if (r196 == null) goto L437;
        boolean r197 = r196.isAnimated();
    L438:
        r186.setValue(new oq2.a(r190, r194, r197));
        return;
    L437:
        r197 = false;
    L431:
        r194 = d51.c.A0.j();
    L420:
        r190 = d51.c.A0.k();
        goto L421
    L502:
        return;
    L501:
        return;
    L407:
        r184 = r182;
        goto L408
    L500:
        return;
    L401:
        r182 = null;
        r181 = null;
    L395:
        r178 = "";
        goto L396
    L388:
        r175 = r16;
        goto L389
    L384:
        r171 = null;
        goto L385
    L511:
        return;
    L377:
        r167 = null;
        goto L379
    L371:
        r164 = null;
    L41:
        r16 = 0;
        goto L42
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
