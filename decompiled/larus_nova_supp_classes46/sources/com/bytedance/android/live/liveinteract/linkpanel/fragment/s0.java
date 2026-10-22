package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ s0 a;
        public final /* synthetic */ boolean b;

        public a(s0 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            com.bytedance.android.livesdk.sharedpref.d.e(!this.b);
            Switch r4 = (Switch) this.a.a.ja0().findViewById(2131387887);
            if (r4 == null) goto L5;
            r4.setChecked(!this.b);
        L5:
            yf0.g r5 = this.a.a.d;
            if (r5 == null) goto L9;
            r5.dismiss();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ s0 a;
        public final /* synthetic */ boolean b;

        public b(s0 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            com.bytedance.android.livesdk.sharedpref.d.e(this.b);
            ALogger.e("VideoTalkSettingFragment", "UpdateEnlargeGuestSettings error");
            yf0.g r4 = this.a.a.d;
            if (r4 == null) goto L6;
            r4.dismiss();
            return;
        }
    }

    public s0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        boolean r8 = ((Boolean) com.bytedance.android.livesdk.sharedpref.d.u.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[19])).booleanValue();
        HashMap r0 = new HashMap();
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        r2.put("key", com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER);
        if (r8 == true) goto L5;
        int r4 = 1;
    L6:
        r2.put("value", r4);
        r1.put(r2);
        r0.put("update_settings", r1);
        this.a.q.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).UpdateEnlargeGuestSettings(this.a.getRoom().getId(), r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r8), new b(this, r8)));
        HashMap r3 = new HashMap();
        if (r8 == false) goto L9;
        String r9 = "off";
    L10:
        r3.put("action_type", r9);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_liv    e_anchor_enlarge_fullscreen_setting_click", r3, new Object[]{IRoom.class});
        return;
    L9:
        r9 = "on";
        goto L10
    L5:
        r4 = 2;
        goto L6
    }
}
