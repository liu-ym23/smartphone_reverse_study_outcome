package e21;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final v3 a(ILinkMicBattleInviteMessage r2) {
        if (r2 != null) goto L10;
    L5:
        String r3 = "";
    L6:
        return (v3) l97.a.a.fromJson(r3, TypesJVMKt.getJavaType(Reflection.typeOf(v3.class)));
    L9:
        return vh7.f.c(v3.class);
    L10:
        r3 = r2.getClientAttachedInfoStr();     // Catch: Exception -> L8
        if (r3 != null) goto L6;
        goto L5
    }

    public static final v3 b(e6 r2) {
        String r3 = r2.getClientAttachedInfoStr();     // Catch: Exception -> L7
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        return (v3) l97.a.a.fromJson(r3, TypesJVMKt.getJavaType(Reflection.typeOf(v3.class)));
    L8:
        return vh7.f.c(v3.class);
    }

    public static final v3 c(i6 r0) {
        if (r0 == null) goto L8;
        e6 r1 = r0.getInvite();
        if (r1 == null) goto L8;
        v3 r2 = b(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return vh7.f.c(v3.class);
    }

    public static final void d(o r3, v3 r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$putAttachedInfo");
        if (r4 != null) goto L5;
        return;
    L5:
        String r0 = r4.getPointTag();
        String r1 = null;
        if (r0 != null) goto L8;
    L13:
        String r2 = r4.getInviteMode();
        if (r2 != null) goto L16;
    L21:
        String r5 = r4.getListNum();
        if (r5 != null) goto L24;
    L29:
        String r6 = r4.getInviterConnectCnt();
        if (r6 != null) goto L32;
    L37:
        String r7 = r4.getInviterRoomStatus();
        if (r7 != null) goto L40;
    L45:
        String r8 = r4.getImprId();
        if (r8 != null) goto L48;
        return;
    L48:
        if ((!StringsKt.isBlank(r8)) == false) goto L50;
        r1 = r8;
    L50:
        if (r1 == null) goto L54;
        r3.a("request_id", r1);
        return;
    L54:
        return;
    L40:
        if ((!StringsKt.isBlank(r7)) == true) goto L43;
        r7 = null;
    L43:
        if (r7 == null) goto L45;
        r3.a("inviter_room_status", r7);
        goto L45
    L32:
        if ((!StringsKt.isBlank(r6)) == true) goto L35;
        r6 = null;
    L35:
        if (r6 == null) goto L37;
        r3.a("inviter_connect_cnt", r6);
        goto L37
    L24:
        if ((!StringsKt.isBlank(r5)) == true) goto L27;
        r5 = null;
    L27:
        if (r5 == null) goto L29;
        r3.a("list_num", r5);
        goto L29
    L16:
        if ((!StringsKt.isBlank(r2)) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L21;
        r3.a("invite_mode", r2);
        goto L21
    L8:
        if ((!StringsKt.isBlank(r0)) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r3.a("source", r0);
        goto L13
    }
}
