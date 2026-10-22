package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ VideoTalkAVPermissionFragment a;
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

    public static final class b<T> implements Consumer {
        public final /* synthetic */ p0 a;

        public b(p0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.e("VideoAudioPermissionSwitchDialog", "updateSetting default_camera_control", r4);
            ExceptionUtils.handleException(this.a.a.getContext(), r4);
        }
    }

    public p0(VideoTalkAVPermissionFragment r1, int r2) {
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
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r4 = this.a.i;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L9:
        this.a.k.add(r2.updateSetting(r4.getId(), r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r7), new b(this)));
        HashMap r9 = new HashMap();
        r9.put("button_type", String.valueOf(((Switch) this.a.aa0().findViewById(2131387890)).isChecked()));
        com.bytedance.android.live.liveinteract.linkpanel.util.m.F(r9, this.b);
        com.bytedance.android.live.liveinteract.api.utils.a.C0018a r10 = com.bytedance.android.live.liveinteract.api.utils.a.a;
        int r5 = this.b;
        r10.getClass();
        com.bytedance.android.live.liveinteract.api.utils.a.C0018a.b(r9, r5);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_auto_video_button_click", r9, new Object[]{IRoom.class});
        return;
    L5:
        r3 = 2;
        goto L6
    }
}
