package n82;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.google.gson.Gson;
import fq1.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nm1.e;
import pm1.f;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean d(DataCenter r2) {
        com.bytedance.android.livesdk.chatroom.msgboard.b r0 = i(r2);
        List r1 = null;
        if (r0 == null) goto L5;
        List r3 = r0.a();
    L7:
        if (CollectionUtils.isEmpty(r3) == false) goto L15;
        com.bytedance.android.livesdk.chatroom.msgboard.b r4 = i(r2);
        if (r4 == null) goto L12;
        r1 = r4.c();
    L12:
        if (CollectionUtils.isEmpty(r1) == false) goto L15;
        return false;
    L15:
        return true;
    L5:
        r3 = null;
        goto L7
    }

    public static String f(DataCenter r3) {
        e r0 = f.c();
        if (r0 == null) goto L7;
        ReplayDataContext r1 = r0.h(r3);
        if (r1 == null) goto L7;
        j r2 = r1.getVsMsgBoardDataContext();
    L9:
        if ((r2 instanceof j) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.msgboard.a r4 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r2.getValue();
        if (r4 == null) goto L14;
    L22:
        if (r4 == null) goto L26;
        IRoom r5 = r4.getRoom();
        if (r5 == null) goto L26;
        String r6 = r5.getIdStr();
    L28:
        if (TextUtils.isEmpty(r6) == true) goto L34;
        if (r4 == null) goto L39;
        IRoom r7 = r4.getRoom();
        if (r7 != null) goto L33;
        return null;
    L33:
        return r7.getIdStr();
    L39:
        return null;
    L34:
        if (r4 == null) goto L41;
        Episode r8 = r4.getEpisode();
        if (r8 != null) goto L38;
        return null;
    L38:
        return r8.idStr;
    L41:
        return null;
    L26:
        r6 = null;
    L14:
        u r9 = r.u(r3, null, 2);
        if (r9 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.msgboard.a r10 = r9.L0();
    L19:
        if ((r10 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L21;
        r4 = null;
        goto L22
    L21:
        r4 = r10;
        goto L22
    L17:
        r10 = null;
    L7:
        r2 = null;
        goto L9
    }

    public static com.bytedance.android.livesdk.chatroom.msgboard.b i(DataCenter r3) {
        e r0 = f.c();
        if (r0 == null) goto L7;
        ReplayDataContext r1 = r0.h(r3);
        if (r1 == null) goto L7;
        j r2 = r1.getVsMsgBoardDataContext();
    L9:
        if ((r2 instanceof j) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.msgboard.a r4 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r2.getValue();
        if (r4 == null) goto L14;
    L31:
        Gson r5 = GsonHelper.get();     // Catch: Exception -> L30
        if (r4 == null) goto L26;
        String r6 = r4.getVsMsgBoardDressInfo();     // Catch: Exception -> L30
        if (r6 == null) goto L26;
    L27:
        return (com.bytedance.android.livesdk.chatroom.msgboard.b) r5.fromJson(r6, com.bytedance.android.livesdk.chatroom.msgboard.b.class);
    L26:
        r6 = BuildConfig.FLAVOR;
    L33:
        return null;
    L14:
        u r7 = r.u(r3, null, 2);
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.msgboard.a r8 = r7.L0();
    L19:
        if ((r8 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L21;
        r4 = null;
        goto L31
    L21:
        r4 = r8;
        goto L31
    L17:
        r8 = null;
    L7:
        r2 = null;
        goto L9
    }

    public static boolean a(String r6, DataCenter r7) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return true;
    L6:
        com.bytedance.android.livesdk.chatroom.msgboard.b r0 = i(r7);
        VSMsgBoardDress r1 = null;
        Object r2 = null;
        r1 = null;
        if (r0 == null) goto L21;
        List r3 = r0.a();
        if (r3 == null) goto L21;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(String.valueOf(((VSMsgBoardDress) r5).getDressId()), r6) == false) goto L12;
    L17:
        VSMsgBoardDress r8 = (VSMsgBoardDress) r5;
        if (r8 == null) goto L21;
        r1 = r8;
    L31:
        if (r1 == null) goto L33;
        String r9 = String.valueOf(r1.getEntityId());
    L35:
        return c(r9, r7);
    L33:
        r9 = BuildConfig.FLAVOR;
        goto L35
    L16:
        r5 = null;
    L21:
        if (r0 == null) goto L31;
        List r10 = r0.c();
        if (r10 == null) goto L31;
        Iterator r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        Object r13 = r11.next();
        if (Intrinsics.areEqual(String.valueOf(((VSMsgBoardDress) r13).getDressId()), r6) == false) goto L26;
        r2 = r13;
    L30:
        r1 = (VSMsgBoardDress) r2;
        goto L31
    }

    public static boolean b(VSMsgBoardDress r6, DataCenter r7) {
        if (r6 != null) goto L5;
        return true;
    L5:
        if (r6.getEntityId() > 0) goto L7;
        return true;
    L7:
        if (r6.isFree() == true) goto L40;
        e r1 = f.c();
        com.bytedance.android.livesdk.chatroom.msgboard.a r2 = null;
        if (r1 == null) goto L14;
        ReplayDataContext r3 = r1.h(r7);
        if (r3 == null) goto L14;
        j r4 = r3.getVsMsgBoardDataContext();
    L16:
        if ((r4 instanceof j) == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.msgboard.a r5 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r4.getValue();
        if (r5 == null) goto L21;
    L30:
        if (r5 == null) goto L36;
        Set r8 = r5.getPaidEntityIds();
        if (r8 == null) goto L36;
        if (r8.contains(String.valueOf(r6.getEntityId())) != true) goto L36;
        return true;
    L36:
        return false;
    L21:
        u r9 = r.u(r7, null, 2);
        if (r9 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.msgboard.a r10 = r9.L0();
    L26:
        if ((r10 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == false) goto L29;
        r2 = r10;
    L29:
        r5 = r2;
        goto L30
    L24:
        r10 = null;
    L14:
        r4 = null;
        goto L16
    L40:
        return true;
    }

    public static boolean c(String r6, DataCenter r7) {
        if (TextUtils.isEmpty(r6) == true) goto L38;
        com.bytedance.android.livesdk.chatroom.msgboard.a r4 = null;
        if (StringsKt.equals$default(r6, "0", false, 2, null) == false) goto L7;
        return true;
    L7:
        if (StringsKt.equals$default(r6, "-1", false, 2, null) == true) goto L40;
        e r0 = f.c();
        if (r0 == null) goto L14;
        ReplayDataContext r1 = r0.h(null);
        if (r1 == null) goto L14;
        j r2 = r1.getVsMsgBoardDataContext();
    L16:
        if ((r2 instanceof j) == true) goto L18;
        r2 = null;
    L18:
        if (r2 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.msgboard.a r3 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r2.getValue();
        if (r3 == null) goto L21;
    L30:
        if (r3 == null) goto L36;
        Set r8 = r3.getPaidEntityIds();
        if (r8 == null) goto L36;
        if (CollectionsKt.contains(r8, r6) != true) goto L36;
        return true;
    L36:
        return false;
    L21:
        u r9 = r.u(r7, null, 2);
        if (r9 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.msgboard.a r10 = r9.L0();
    L26:
        if ((r10 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == false) goto L29;
        r4 = r10;
    L29:
        r3 = r4;
        goto L30
    L24:
        r10 = null;
    L14:
        r2 = null;
        goto L16
    L40:
        return true;
    L38:
        return true;
    }

    public static VSMsgBoardDress e(String r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "dressId");
        com.bytedance.android.livesdk.chatroom.msgboard.b r6 = i(r5);
        Object r0 = null;
        if (r6 == null) goto L17;
        List r7 = r6.a();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(String.valueOf(((VSMsgBoardDress) r1).getDressId()), r4) == false) goto L8;
        r0 = r1;
    L13:
        return (VSMsgBoardDress) r0;
    L18:
        return null;
    L17:
        return null;
    }

    public static String g(DataCenter r3, Boolean r4) {
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        String r5 = (String) ((HashMap) nq1.d.z.getValue()).get(t.a().getCurrentUserId() + '_' + f(r3));
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return BuildConfig.FLAVOR;
    L8:
        if (a(r5, r3) == false) goto L14;
        if (r5 != null) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        return r5;
    L14:
        return BuildConfig.FLAVOR;
    }

    public static String h(DataCenter r3, Boolean r4) {
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        String r5 = (String) ((HashMap) nq1.d.y.getValue()).get(t.a().getCurrentUserId() + '_' + f(r3));
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return BuildConfig.FLAVOR;
    L8:
        if (a(r5, r3) == false) goto L14;
        if (r5 != null) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        return r5;
    L14:
        return BuildConfig.FLAVOR;
    }

    public static VSMsgBoardDress j(String r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "dressId");
        com.bytedance.android.livesdk.chatroom.msgboard.b r6 = i(r5);
        Object r0 = null;
        if (r6 == null) goto L17;
        List r7 = r6.c();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(String.valueOf(((VSMsgBoardDress) r1).getDressId()), r4) == false) goto L8;
        r0 = r1;
    L13:
        return (VSMsgBoardDress) r0;
    L18:
        return null;
    L17:
        return null;
    }

    public static int k(String r4, int r5) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L19;
        return r5;
    L19:
        if (StringsKt.startsWith$default(r4, "#", false, 2, null) == true) goto L16;
        r4 = "#" + r4;     // Catch: Exception -> L18
    L16:
        return Color.parseColor(r4);
    L21:
        return r5;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
