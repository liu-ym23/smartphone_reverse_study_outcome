package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q2 implements z<pp1.c> {
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable a;
    public yo2.e b;
    public int c;
    public final DataCenter d;
    public final Context e;
    public final View f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z
    public final void dismiss() {
        yo2.e r0 = this.b;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.b = null;
        this.a.dispose();
    }

    public final String toString() {
        return "ToolbarBubble@" + com.bytedance.android.live.core.utils.z0.c(this) + "(anchorView=" + this.f + ')';
    }

    public q2(DataCenter r2, Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "anchorView");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z
    public final void a(pp1.c r19, w r20, com.bytedance.android.livesdk.popup.manager.c r21) {
        pp1.c r14 = r19;
        Intrinsics.checkNotNullParameter(r14, "command");
        Intrinsics.checkNotNullParameter(r20, "clickCallback");
        Intrinsics.checkNotNullParameter(r21, "livePopupCallback");
        View r0 = this.f;
        Intrinsics.checkNotNullParameter(r0, "view");
        if (r0.getParent() != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L31;
        Map r2 = r14.j;
        if (r2 != null) goto L13;
        r2 = new HashMap();
    L13:
        if (r14.i != 11) goto L22;
        String r3 = (String) r2.get("prop_id");
        if (r3 == null) goto L20;
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.R3;
        Map r5 = (Map) r4.getValue();
        Boolean r6 = (Boolean) r5.get(r3);
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r7) == true) goto L20;
        r5.put(r3, r7);
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
    L20:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L31;
        long r10 = r14.e;
        View r9 = LayoutInflater.from(this.e).inflate(2131567855, null);
        TextView r15 = (TextView) r9.findViewById(2131373660);
        ImageView r11 = (ImageView) r9.findViewById(2131373659);
        View r12 = r9.findViewById(2131373726);
        final Ref.IntRef r13 = new Ref.IntRef();
        r13.element = 0;
        final Ref.IntRef r16 = new Ref.IntRef();
        r16.element = 0;
        final ToolbarBubble$show$onBackgroundReady$1 r17 = new ToolbarBubble$show$onBackgroundReady$1(this, r15, r13, r16, r14, r11, r12, r20, r9, r10, r21);
        Function0<Unit> r18 = new ToolbarBubble$show$useDefaultBackground$1(this, r13, r16, r17);
        py.k r22 = r14.f;
        if (r22 != null) goto L28;
    L30:
        r18.invoke();
        return;
    L28:
        if (r22.isValid() != true) goto L30;
        int r23 = com.bytedance.android.livesdk.chatroom.utils.a3.d;
        com.bytedance.android.livesdk.chatroom.utils.a3.a.a(r15, r14.f, new s2(r17, r18), 0.0f);
        return;
    L22:
        r8 = false;
    L31:
        dismiss();
        return;
    L5:
        if (r0.getApplicationWindowToken() == null) goto L7;
        r1 = true;
        goto L8
    }

    public static final void b(q2 r10, Map r11, int r12, String r13) {
        r10.getClass();
        String r1 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r0.getUser();
        if (r2 == null) goto L7;
        User r3 = (User) r2.getValue();
    L8:
        Pair[] r4 = new Pair[5];
        if (r3 == null) goto L11;
        String r5 = r3.getIdStr();
    L12:
        r4[0] = TuplesKt.to("user_id", r5);
        if (r3 == null) goto L17;
        py.d r6 = r3.getUserHonor();
        if (r6 == null) goto L17;
        Integer r7 = Integer.valueOf(r6.getLevel());
    L18:
        r4[1] = TuplesKt.to("privilege_level", String.valueOf(r7));
        r4[2] = TuplesKt.to("location_from", "bottom");
        r4[3] = TuplesKt.to("privilege_from", String.valueOf(r12));
        r4[4] = TuplesKt.to("bubble_show_times", String.valueOf(r10.c));
        Map r14 = MapsKt.mutableMapOf(r4);
        boolean r8 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r9 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevLinkControlService();
        if (r9 == null) goto L22;
        Map r15 = r9.q();
        if (r15 == null) goto L22;
    L23:
        r14.putAll(r15);
        if (r11 == null) goto L47;
        Iterator r16 = r11.entrySet().iterator();
    L26:
        String r17 = "";
        if (r16.hasNext() == false) goto L33;
        Map.Entry r18 = (Map.Entry) r16.next();
        Object r19 = r18.getKey();
        String r20 = (String) r18.getValue();
        if (r20 == null) goto L32;
        r17 = r20;
    L32:
        r14.put(r19, r17);
        goto L26
    L33:
        String r21 = (String) r11.get("message_type");
        if (r21 != null) goto L36;
        r21 = "";
    L36:
        r14.put("content", r21);
        if (r12 != 3) goto L42;
        String r22 = (String) r11.get("bubble_info");
        if (r22 != null) goto L41;
        r22 = "";
    L41:
        r14.put("bubble_info", r22);
    L42:
        String r110 = (String) r11.get("prop_id");
        if (r110 == null) goto L46;
        r17 = r110;
    L46:
        r14.put("prop_id", r17);
    L47:
        int r111 = r13.hashCode();
        if (r111 == 3529469) goto L56;
        if (r111 != 94750088) goto L59;
        if (r13.equals("click") == false) goto L59;
        r1 = "livesdk_room_bubble_click";
    L59:
        if (r12 != 14) goto L62;
        r14.put("message_type", "room_grouppk_matching");
    L62:
        if (r1 == null) goto L68;
        com.bytedance.android.livesdk.log.u.l().sendLog(r1, r14, new Object[]{Room.class, am2.x.class});
        return;
    L68:
        return;
    L56:
        if (r13.equals("show") == false) goto L59;
        r1 = "livesdk_room_bubble_show";
    L22:
        r15 = new HashMap();
    L17:
        r7 = null;
        goto L18
    L11:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }
}
