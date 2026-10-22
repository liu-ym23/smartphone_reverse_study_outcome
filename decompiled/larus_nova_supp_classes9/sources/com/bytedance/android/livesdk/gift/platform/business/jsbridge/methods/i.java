package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GroupLiveReceiverService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends wy0.c<d, JSONObject> {
    public final Type a;
    public final com.bytedance.android.scope.j b;
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    public final Type j() {
        return this.a;
    }

    public i(com.bytedance.android.scope.j r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(d.class));
    }

    public final Object k(vh7.j r18, CallContext r19) {
        Intrinsics.checkNotNullParameter((d) r18, "params");
        Intrinsics.checkNotNullParameter(r19, "callContext");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k r0 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k(this.b, this.c);
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        IRoomBase r4 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        i12.e r5 = i12.o.b();
        if (r5 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r6 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class));
    L6:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r7 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r6;
        i12.d r8 = i12.m.e2.a();
        if (r8 == null) goto L9;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r9 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L10:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r10 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r9;
        i12.e r11 = i12.o.b();
        if (r11 == null) goto L13;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r13 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(GiftReceiverRepoService.class));
    L14:
        GiftReceiverRepoService r14 = (GiftReceiverRepoService) r13;
        if (r7 == null) goto L17;
        boolean r15 = r7.j();
    L18:
        if (r10 == null) goto L21;
        IBaseUser r16 = r10.a;
        if (r16 == null) goto L21;
    L22:
        if (r4 == null) goto L25;
        String r17 = IRoomKt_androidKt.getAnchorId(r4);
        if (r17 == null) goto L25;
    L27:
        if (r15 == false) goto L29;
        r3.put("current_user", r17);
    L73:
        r3.put("connection_type", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getConnectionType());
        r3.put("guest_list", r0.a());
        zc6.a r1 = zc6.a.a;
        dq2.m r20 = zc6.b.b(this.b);
        if (r20 != null) goto L76;
    L78:
        dq2.v r21 = zc6.b.c(this.b);
        if (r21 != null) goto L81;
    L83:
        if (r14 != null) goto L85;
    L87:
        r3.put("is_all_mic", false);
        if (r7 != null) goto L90;
    L96:
        r3.put("enable_audience_gift_auth", false);
        if (com.bytedance.android.livesdk.gift.platform.core.manager.s.a == false) goto L99;
        r3.put("enable_guest_gift_auth", true);
    L100:
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L103;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r24 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k.class));
    L104:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k r25 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k) r24;
        if (r25 == null) goto L107;
        Boolean r26 = Boolean.valueOf(r25.g());
    L108:
        r3.put("enable_show_guest_list_panel", r26);
        if (r4 == null) goto L111;
        boolean r27 = x12.a.b(r4);
    L112:
        r3.put("is_group_live", r27);
        i12.e r28 = i12.o.b();
        if (r28 == null) goto L115;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r29 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(GroupLiveReceiverService.class));
    L116:
        GroupLiveReceiverService r30 = (GroupLiveReceiverService) r29;
        if (r30 == null) goto L119;
        boolean r31 = r30.i();
    L120:
        r3.put("is_group_live_competition", r31);
        i12.e r33 = i12.o.b();
        if (r33 == null) goto L123;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r34 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r33).a(Reflection.getOrCreateKotlinClass(sc6.b.class));
    L124:
        sc6.b r35 = (sc6.b) r34;
        if (r35 == null) goto L129;
        String r36 = r35.o1();
        if (r36 == null) goto L129;
        j01.d.b(r3, "gift_dialog_request_id", r36);
    L129:
        jy0.b.d("GetGiftGuestListDataMethod", "GetGiftGuestListDataMethod invoke " + r16.getIdString());
        if (r7 != null) goto L142;
    L135:
        boolean r37 = false;
    L136:
        r3.put("is_multi_user", r37);     // Catch: Exception -> L138
    L140:
        r2.put("data", r3);
        return r2;
    L138:
        e = move-exception;
        e.printStackTrace();
        goto L140
    L142:
        if (r7.k() != true) goto L135;
        r37 = true;
        goto L136
    L123:
        r34 = null;
        goto L124
    L119:
        r31 = false;
        goto L120
    L115:
        r29 = null;
        goto L116
    L111:
        r27 = false;
        goto L112
    L107:
        r26 = null;
        goto L108
    L103:
        r24 = null;
        goto L104
    L99:
        r3.put("enable_guest_gift_auth", false);
        goto L100
    L90:
        if (r7.g() != true) goto L96;
        r3.put("enable_all_mic", true);
        if (r15 == false) goto L96;
        if (r7.k() == true) goto L96;
        r3.put("is_all_mic", true);
        goto L96
    L85:
        if (r14.f() != true) goto L87;
        r3.put("social_scene", 20);
        goto L87
    L81:
        if (r21.f() != true) goto L83;
        r3.put("is_team_fight", true);
        jy0.b.d("GetGiftGuestListDataMethod", "GetGiftGuestListDataMethod TeamFight");
        goto L83
    L76:
        if (r20.b() != true) goto L78;
        r3.put("is_game", true);
        goto L78
    L29:
        if (r10 == null) goto L49;
        if (r14 == null) goto L48;
        List<IBaseUser> r110 = r14.k().a;
        if (r110 == null) goto L48;
        Iterator<T> r111 = r110.iterator();
    L35:
        if (r111.hasNext() == false) goto L43;
        Object r112 = r111.next();
        String r38 = ((IBaseUser) r112).getIdString();
        IBaseUser r39 = r10.a;
        if (r39 == null) goto L39;
        String r40 = r39.getIdString();
    L41:
        if (Intrinsics.areEqual(r38, r40) == false) goto L35;
    L44:
        IBaseUser r113 = (IBaseUser) r112;
        if (r113 == null) goto L48;
        if (r3.put("current_user", r113.getIdString()) != null) goto L73;
    L39:
        r40 = null;
        goto L41
    L43:
        r112 = null;
    L48:
        r3.put("current_user", r17);
        goto L73
    L49:
        i12.e r41 = i12.o.b();
        if (r41 == null) goto L52;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r43 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r41).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.class));
    L53:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r44 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y) r43;
        if (r44 == null) goto L59;
        IBaseUser r45 = r44.i();
        if (r45 == null) goto L59;
        String r46 = r45.getIdString();
        if (r46 == null) goto L59;
    L69:
        if (r46 == null) goto L72;
        r17 = r46;
    L72:
        r3.put("current_user", r17);
    L59:
        i12.e r47 = i12.o.b();
        if (r47 == null) goto L62;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r48 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r47).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x.class));
    L63:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r49 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x) r48;
        if (r49 == null) goto L68;
        IBaseUser r50 = r49.a();
        if (r50 == null) goto L68;
        r46 = r50.getIdString();
    L68:
        r46 = null;
        goto L69
    L62:
        r48 = null;
        goto L63
    L52:
        r43 = null;
    L25:
        r17 = BuildConfig.FLAVOR;
    L21:
        r16 = vh7.f.c(IBaseUser.class);
        goto L22
    L17:
        r15 = false;
        goto L18
    L13:
        r13 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
