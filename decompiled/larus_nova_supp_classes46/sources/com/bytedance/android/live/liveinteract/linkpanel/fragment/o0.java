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
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ VideoTalkAVPermissionFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            com.bytedance.android.livesdk.sharedpref.e r4 = b6.h;
            Boolean r0 = Boolean.valueOf(this.a);
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            com.bytedance.android.live.liveinteract.linkpanel.util.m.N(this.a);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ o0 a;

        public b(o0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.e("VideoAudioPermissionSwitchDialog", "updateSetting switch_camera", r4);
            ExceptionUtils.handleException(this.a.a.getContext(), r4);
        }
    }

    public o0(VideoTalkAVPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r6, boolean r7) {
        HashMap r8 = new HashMap();
        r8.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.api.utils.a.C0018a r3 = com.bytedance.android.live.liveinteract.api.utils.a.a;
        int r4 = r2.a;
        r3.getClass();
        com.bytedance.android.live.liveinteract.api.utils.a.C0018a.b(r8, r4);
    L9:
        com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        int r9 = 1;
        if (r5 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r10 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r10.t();
        if (r11 == null) goto L23;
        List r12 = r11.b;
        if (r12 == null) goto L23;
        if (r12.contains(1) == true) goto L21;
        r12 = null;
    L21:
        if (r12 == null) goto L23;
        r8.put("play_type", "video_friend");
    L23:
        if (r7 == false) goto L25;
        String r13 = "on";
    L26:
        r8.put("button_type", r13);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_camera_permit_click", r8, new Object[]{IRoom.class});
        if (r7 == true) goto L29;
        ((Switch) this.a.aa0().findViewById(2131387890)).setChecked(false);
    L29:
        HashMap r14 = new HashMap();
        r14.put("scene", 4);
        JSONArray r15 = new JSONArray();
        JSONObject r16 = new JSONObject();
        r16.put("key", 33);
        if (r7 == true) goto L33;
        r9 = 2;
    L33:
        r16.put("value", r9);
        r15.put(r16);
        r14.put("incremental_update", r15);
        LinkApi r17 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r18 = this.a.i;
        if (r18 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L36:
        this.a.k.add(r17.updateSetting(r18.getId(), r14).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r7), new b(this)));
        return;
    L25:
        r13 = "off";
        goto L26
    }
}
