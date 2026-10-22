package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.model.extension.GroupLiveModeEnum;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveDataKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupLiveReceiverService implements com.bytedance.android.scope.o {
    public final Lazy a;
    public boolean b;
    public final String c;
    public final yz0.g d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final IBaseUser d() {
        IBaseUser r0 = this.d.getRoom().getOwnerKt();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return vh7.f.c(IBaseUser.class);
    }

    public final boolean i() {
        IRoomBase r0 = this.d.getRoom();
        Intrinsics.checkNotNullParameter(r0, "$this$groupLiveMode");
        IGroupLiveData r1 = x12.a.a(r0);
        if (r1 == null) goto L5;
        int r2 = IGroupLiveDataKt.getCurrentGroupLiveMode(r1);
    L6:
        jy0.b.a(this.c, "calculateGroupLiveCompetition: group live mode " + r2 + ". ");
        if (x12.a.b(this.d.getRoom()) == true) goto L9;
        return false;
    L9:
        if (r2 != GroupLiveModeEnum.GroupLiveModeFactionCompetition.getValue()) goto L13;
        return true;
    L13:
        return false;
    L5:
        r2 = 0;
        goto L6
    }

    public final IBaseUser f() {
        if (i() == false) goto L13;
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = a0.b;
        KProperty[] r2 = a0.a;
        if (StringsKt.isBlank((CharSequence) ((Pair) r0.getValue(null, r2[0])).getFirst()) == false) goto L9;
        return null;
    L9:
        if ((!Intrinsics.areEqual(this.d.getRoom().getIdStr(), (String) ((Pair) r0.getValue(null, r2[0])).getFirst())) == false) goto L12;
        return null;
    L12:
        return (IBaseUser) ((Pair) r0.getValue(null, r2[0])).getSecond();
    L13:
        return null;
    }

    public GroupLiveReceiverService(yz0.g r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.d = r2;
        this.a = LazyKt.lazy(new GroupLiveReceiverService$_room$2(this));
        this.c = "GroupLiveReceiver";
    }

    public final String g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        if (i() == false) goto L9;
        if (Intrinsics.areEqual(r2, d().getIdString()) == false) goto L7;
        return "union_battle_room_owner";
    L7:
        return "union_battle_member";
    L9:
        if (Intrinsics.areEqual(r2, d().getIdString()) == false) goto L11;
        return "group_room_owner";
    L11:
        return "group_member";
    }

    public final void c(IBaseUser r5, ChangeReceiverSource r6) {
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r6, "source");
        if (i() == true) goto L5;
        return;
    L5:
        Pair r0 = new Pair(this.d.getRoom().getIdStr(), r5);
        KProperty[] r1 = a0.a;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        com.bytedance.android.scope.o r3 = null;
        a0.b.setValue(null, a0.a[0], r0);
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L8;
        com.bytedance.android.scope.m.e.getClass();
        r3 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r2).a(Reflection.getOrCreateKotlinClass(y.class));
    L8:
        y r4 = (y) r3;
        if (r4 == null) goto L12;
        r4.a(r5.getIdString(), r6);
        return;
    }

    public final String h(IRoomBase r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        if (r3 != null) goto L5;
        r3 = this.d.getRoom();
    L5:
        if (r3 == null) goto L23;
        if (x12.a.b(r3) != true) goto L23;
        Intrinsics.checkNotNullParameter(r3, "$this$groupLiveMode");
        IGroupLiveData r0 = x12.a.a(r3);
        if (r0 == null) goto L11;
        int r1 = IGroupLiveDataKt.getCurrentGroupLiveMode(r0);
    L13:
        if (r1 != GroupLiveModeEnum.GroupLiveModeFactionCompetition.getValue()) goto L19;
        if (Intrinsics.areEqual(r4, IRoomKtKt.getAnchorIdStr(r3)) == false) goto L17;
        return "union_battle_room_owner";
    L17:
        return "union_battle_member";
    L19:
        if (Intrinsics.areEqual(r4, IRoomKtKt.getAnchorIdStr(r3)) == false) goto L21;
        return "group_room_owner";
    L21:
        return "group_member";
    L11:
        r1 = 0;
    L23:
        if (Intrinsics.areEqual(r4, IRoomKtKt.getAnchorIdStr(r3)) == false) goto L25;
        return "anchor";
    L25:
        return "guest";
    }

    public final void a(Map<String, String> r7, String r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r8, "toUserId");
        if (r9 == null) goto L5;
        IRoomBase r0 = (IRoomBase) this.a.getValue();
    L6:
        if (r9 == null) goto L8;
        boolean r10 = r9.booleanValue();
    L9:
        String r2 = "1";
        if (x12.a.b((IRoomBase) this.a.getValue()) == false) goto L12;
        String r1 = "1";
    L13:
        r7.put("is_grouped_lived", r1);
        if (r10 == true) goto L29;
        i12.e r3 = i12.o.b();
        Integer r4 = null;
        if (r3 == null) goto L18;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r5 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(GiftReceiverRepoService.class));
    L19:
        GiftReceiverRepoService r6 = (GiftReceiverRepoService) r5;
        if (r6 == null) goto L28;
        j r11 = (j) ((LinkedHashMap) r6.b).get(7);
        if (r11 == null) goto L26;
        List<IBaseUser> r13 = r11.a;
        if (r13 == null) goto L26;
        int r14 = r13.size();
    L27:
        r4 = Integer.valueOf(r14);
    L26:
        r14 = 0;
    L28:
        r7.put("group_member_cnt", String.valueOf(r4));
        goto L29
    L18:
        r5 = null;
    L29:
        if (r10 == true) goto L32;
        r2 = "0";
    L32:
        r7.put("is_union_battle", r2);
        r7.put("to_user_type", h(r0, r8));
        return;
    L12:
        r1 = "0";
        goto L13
    L8:
        r10 = i();
        goto L9
    L5:
        r0 = this.d.getRoom();
        goto L6
    }
}
