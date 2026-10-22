package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001d\u0010\u0002\u001a\u0019\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u001d\u0010\b\u001a\u0019\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b2\u0015\u0010\f\u001a\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e¢\u0006\u0002\b\u000f"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "Lkotlin/ParameterName;", "name", "room", "p2", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "user", "p3", "", "battleAttachedInfo", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class InteractPkReserveView$updateAdapterItemList$1 extends FunctionReferenceImpl implements Function3<IRoom, IBaseUser, String, Unit> {
    public InteractPkReserveView$updateAdapterItemList$1(InteractPkReserveView r8) {
        super(3, r8, InteractPkReserveView.class, "notifyInvitePk", "notifyInvitePk(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;Lcom/bytedance/android/live/base/model/user/IBaseUser;Ljava/lang/String;)V", 0);
    }

    public final void invoke(IRoom r29, IBaseUser r30, String r32) {
        Intrinsics.checkNotNullParameter(r32, "p3");
        InteractPkReserveView r7 = (InteractPkReserveView) ((CallableReference) this).receiver;
        int r0 = InteractPkReserveView.j;
        r7.getClass();
        IPKLinkBizDataService r1 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r1 == null) goto L17;
        if (r29 == null) goto L6;
        long r2 = r29.getRoomId();
    L7:
        if (r30 == null) goto L10;
        String r4 = r30.getUserId();
        if (r4 == null) goto L10;
    L11:
        if (r30 == null) goto L14;
        Intrinsics.checkNotNullParameter(r30, "$this$secUidExt");
        String r5 = r30.getCastSecUid();
        if (r5 == null) goto L14;
    L15:
        IPKLinkBizDataService.b.b(r1, r29, r2, r4, r5, 0, 1, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, null, 0, null, 0, null, r32, 0, 0, null, null, null, 8063));
    L14:
        r5 = "";
    L10:
        r4 = "";
        goto L11
    L6:
        r2 = 0;
    L17:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("is_oncemore", DataType.FALSE);
        r3.put("invitee_list", "mutual_follow");
        r3.put("connection_type", "manaul_pk");
        r3.put("is_recommend_list", DataType.FALSE);
        if (r30 == null) goto L22;
        String r6 = r30.getUserId();
        if (r6 == null) goto L22;
    L23:
        r3.put("invitee_id", r6);
        r3.put("from_room_status", "live");
        r3.put("invite_mode", "routine_pk");
        com.bytedance.android.live.revlink.impl.global.c r8 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r8 == null) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r9 = r8.getLinkOptLogContext();
        if (r9 == null) goto L28;
        Intrinsics.checkNotNullParameter("pk_invite_record", "<set-?>");
        r9.c = "pk_invite_record";
    L28:
        r3.put("anchor_connection_type", "invite");
        r3.put("invite_type", "anchor");
        r3.put("source", "pk_invite_record");
        r3.put("anchor_connect_status", DataType.FALSE);
        r3.put("connection_sub_type", "");
        if (r29 == null) goto L31;
        Long r10 = Long.valueOf(IRoomKtKt.getId((IRoomBase) r29));
    L32:
        r3.put("invitee_room_id", String.valueOf(r10));
        com.bytedance.android.live.revlink.impl.global.c r12 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r12 == null) goto L41;
        w31.c r13 = r12.getPkLinkUtils();
        if (r13 == null) goto L41;
        IPKLinkBizDataService r14 = r13.g();
        if (r14 == null) goto L41;
        if (r14.getSelfHasAudienceBeforePk() == false) goto L41;
        String r15 = "audience_connection";
    L42:
        r3.put("room_status", r15);
        r3.put("is_random_match", DataType.FALSE);
        r3.put("invitee_room_status", "live");
        r3.put("invitee_connect_cnt", DataType.FALSE);
        r3.put("audience_connect_cnt", String.valueOf(n41.a.b()));
        mz0.n r16 = new mz0.n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r17.putAll(r3);
        mz0.m r18 = new mz0.m();
        com.bytedance.android.live.revlink.impl.global.c r19 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r19 == null) goto L47;
        LinkCrossRoomDataHolder r20 = r19.getLinkCrossRoomDataHolder();
        if (r20 == null) goto L47;
        r20.m(r18);
    L47:
        r18.b(LogCommon.ROOM);
        List<Object> r22 = r16.b;
        ArrayList r23 = (ArrayList) r22;
        r23.addAll(r18.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_connection_invite", r16.a, r16.b);
        r r26 = r7.g;
        if (r26 == null) goto L51;
        r26.dismiss();
        return;
    L51:
        return;
    L41:
        r15 = "live";
        goto L42
    L31:
        r10 = null;
    L22:
        r6 = r6;
        goto L23
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((IRoom) r1, (IBaseUser) r2, (String) r3);
        return Unit.INSTANCE;
    }
}
