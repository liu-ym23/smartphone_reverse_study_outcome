package com.bytedance.android.live.livepkaudience.dialog;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PkWithAudienceAVPermissionDialog a;
    public final /* synthetic */ int b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            com.bytedance.android.livesdk.sharedpref.e r4 = b6.g;
            Boolean r0 = Boolean.valueOf(this.a);
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
        }
    }

    public p(PkWithAudienceAVPermissionDialog r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r6, boolean r7) {
        HashMap r8 = new HashMap();
        r8.put("scene", 4);
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("key", 52);
        if (r7 == false) goto L5;
        int r3 = 1;
    L6:
        r1.put("value", r3);
        r0.put(r1);
        r8.put("incremental_update", r0);
        this.a.b.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.c.id, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r7)));
        HashMap r9 = new HashMap();
        r9.put("button_type", String.valueOf(((Switch) this.a.findViewById(2131387890)).isChecked()));
        el0.j.l(r9, this.b);
        el0.j.j(r9, Integer.valueOf(this.b));
        el0.j.n(r9, Integer.valueOf(this.b));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_auto_video_button_click", r9, new Object[]{Room.class});
        return;
    L5:
        r3 = 2;
        goto L6
    }
}
