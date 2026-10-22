package com.bytedance.android.live.livepkaudience.dialog;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PkWithAudienceAVPermissionDialog a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ int c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.a r7 = (com.bytedance.android.live.network.response.a) r6;
            com.bytedance.android.livesdk.sharedpref.e r8 = b6.h;
            Boolean r0 = Boolean.valueOf(this.a);
            r8.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r8, r0);
            boolean r9 = this.a;
            int r1 = el0.j.b;
            Intrinsics.checkNotNullParameter("live_chat", "connectionType");
            HashMap r2 = new HashMap();
            r2.put("connection_type", "live_chat");
            r2.put("_param_live_platfom", "live");
            r2.put("event_belong", "live");
            r2.put("event_page", "live_take_detail");
            r2.put("local_time_ms", String.valueOf(System.currentTimeMillis()));
            int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            el0.j.j(r2, Integer.valueOf(r3));
            el0.j.o(r2);
            el0.j.n(r2, Integer.valueOf(r3));
            com.bytedance.android.livesdk.log.g r4 = com.bytedance.android.livesdk.log.u.l();
            if (r9 == false) goto L5;
            String r10 = "livesdk_admin_authorization_switch_open";
        L6:
            r4.sendLog(r10, r2, new Object[]{am2.x.class, Room.class});
            return;
        L5:
            r10 = "livesdk_admin_authorization_switch_close";
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ CompoundButton b;
        public final /* synthetic */ boolean c;

        public b(q r1, CompoundButton r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.b.element = true;
            this.b.setChecked(true ^ this.c);
        }
    }

    public q(PkWithAudienceAVPermissionDialog r1, Ref.BooleanRef r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r7, boolean r8) {
        Ref.BooleanRef r0 = this.b;
        if (r0.element == false) goto L6;
        r0.element = false;
        return;
    L6:
        HashMap r1 = new HashMap();
        r1.put("live_type", "video_live");
        if (r8 == false) goto L9;
        String r2 = "on";
    L10:
        r1.put("button_type", r2);
        el0.j.n(r1, Integer.valueOf(this.c));
        int r3 = 1;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_connection_camera_permit_click", r1, new Object[]{Room.class});
        if (r8 == true) goto L13;
        ((Switch) this.a.findViewById(2131387890)).setChecked(false);
    L13:
        HashMap r4 = new HashMap();
        r4.put("scene", 4);
        JSONArray r5 = new JSONArray();
        JSONObject r6 = new JSONObject();
        r6.put("key", 33);
        if (r8 == true) goto L17;
        r3 = 2;
    L17:
        r6.put("value", r3);
        r5.put(r6);
        r4.put("incremental_update", r5);
        this.a.b.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.c.id, r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r8), new b(this, r7, r8)));
        return;
    L9:
        r2 = "off";
        goto L10
    }
}
