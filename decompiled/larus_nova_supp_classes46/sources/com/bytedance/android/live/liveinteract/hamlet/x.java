package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements gd1.b.b {
    public final /* synthetic */ HamletAvatarWidget a;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.e r2 = (com.bytedance.android.live.network.response.e) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public x(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void onSendResult(boolean r6, int r7, String r8, String r9) {
        if (r6 == false) goto L53;
        f2.c("形象切换成功", 0);
        HamletAvatarContext r10 = this.a.f;
        DataCenter r11 = null;
        if (r10 == null) goto L8;
        com.bytedance.live.datacontext.n<Long> r12 = r10.getCurrentSelectAvatarID();
        if (r12 == null) goto L8;
        Long r13 = (Long) r12.getValue();
    L9:
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("play_layout", "avatar");
        String r0 = "0";
        if (r13 == null) goto L13;
        String r15 = String.valueOf(r13.longValue());
        if (r15 == null) goto L13;
    L14:
        r14.put("avatar_id", r15);
        IMiddlewareUserService r16 = jc1.k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L19;
        com.bytedance.android.livesdk.user.e r17 = r16.user();
        if (r17 == null) goto L19;
        String r18 = r17.n();
    L20:
        r14.put("user_id", String.valueOf(r18));
        boolean r19 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        int r3 = com.bytedance.android.live.liveinteract.plantform.commonwindow.n.a;
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().A2();
        if (r4 == null) goto L24;
        r11 = (DataCenter) r4.getValue();
    L24:
        if (com.bytedance.android.live.core.utils.a0.d(r11, false) == false) goto L26;
        String r20 = "anchor";
    L29:
        r14.put("enlarge_user_type", r20);
        r14.put("enlarge_user_id", je0.d.b0().toString());
        InteractiveSongLoggerKt.b(r14);
        com.bytedance.android.live.liveinteract.voicechat.util.k r21 = InteractiveSongLoggerKt.a();
        if (r21 == null) goto L32;
        j0 r22 = j0.l();
        int r5 = com.bytedance.android.live.liveinteract.voicechat.util.k.g;
        r22.sendLog("livesdk_guest_connection_request_song_dress_success", r21.a(r14, false), new Object[]{IRoom.class, am2.x.class});
    L32:
        HamletAvatarContext r23 = this.a.f;
        if (r23 == null) goto L39;
        com.bytedance.live.datacontext.n<Long> r24 = r23.getCurrentSelectAvatarID();
        if (r24 == null) goto L39;
        Long r25 = (Long) r24.getValue();
        if (r25 == null) goto L39;
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).notifyAvatarChange(je0.d.a0(), r25.longValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(a.a, b.a);
    L39:
        JsonObject r26 = new JsonObject();
        r26.addProperty("type", "avatar_change");
        JsonObject r27 = new JsonObject();
        HamletAvatarContext r28 = this.a.f;
        if (r28 == null) goto L49;
        com.bytedance.live.datacontext.n<Long> r29 = r28.getCurrentSelectAvatarID();
        if (r29 == null) goto L49;
        Long r30 = (Long) r29.getValue();
        if (r30 == null) goto L49;
        String r31 = String.valueOf(r30.longValue());
        if (r31 == null) goto L49;
        r0 = r31;
    L49:
        r27.addProperty("avatar_id", r0);
        Unit r32 = Unit.INSTANCE;
        r26.add("data", r27);
        ih0.b r33 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this.a).dataCenter);
        if (r33 == null) goto L54;
        r33.Dk("avatar", "avatar_event", r26, false);
        return;
    L54:
        return;
    L26:
        if (r19 == false) goto L28;
        r20 = "administrator";
        goto L29
    L28:
        r20 = "guest";
    L19:
        r18 = null;
    L13:
        r15 = "0";
    L8:
        r13 = null;
        goto L9
    }
}
