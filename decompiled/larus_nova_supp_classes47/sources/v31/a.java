package v31;

import android.util.Base64;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenuelink.rtc.f;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.service.g;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.j;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import jy0.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rc0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements g {
    public final NextLiveData<String> a;
    public final NextLiveData<String> b;
    public j c;
    public final NextLiveData<Boolean> d;
    public final NextLiveData<Boolean> e;
    public boolean f;
    public boolean g;
    public final NextLiveData<String> h;
    public final c i;

    /* JADX INFO: renamed from: v31.a$a, reason: collision with other inner class name */
    public static final class C0333a {
    }

    static {
    }

    public final f a() {
        c r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m0();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    /* JADX INFO: renamed from: c */
    public final String mo696c() {
        return (String) this.h.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final long d() {
        NextLiveData<String> r2 = this.a;     // Catch: Throwable -> L11
        if (r2 == null) goto L14;
        String r3 = (String) r2.getValue();     // Catch: Throwable -> L11
        if (r3 == null) goto L15;
        Long r4 = StringsKt.toLongOrNull(r3);     // Catch: Throwable -> L11
        if (r4 == null) goto L16;
        return r4.longValue();
    L16:
        return -1;
    L15:
        return -1;
    L14:
        return -1;
    L17:
        return -1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final int getCloudCollaboratePanelType() {
        c r0 = this.i;
        if (r0 == null) goto L7;
        e r1 = r0.Ig();
        if (r1 == null) goto L7;
        return r1.getCloudCollaboratePanelType();
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void h() {
        JSONObject r2 = null;
        b.c("RevLinkPartnerService", "sendStartMsg hasSendStreamXStartEvent = " + this.f + ", hasReceiveStreamXRtcJoin = " + this.g, null, 4);
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.g == false) goto L20;
        this.f = true;
        this.g = false;
        c r0 = this.i;
        if (r0 == null) goto L13;
        s r1 = r0.getRevLinkCommonUtil();
        if (r1 == null) goto L13;
        String r3 = r1.c();
        if (r3 == null) goto L13;
    L14:
        JSONObject r4 = new JSONObject();
        String r5 = (String) this.b.getValue();
        if (r5 == null) goto L17;
        r2 = new JSONObject(r5);
    L17:
        r4.put("action", "update_view_display");
        r4.put(Constants.Keys.DATA, r2);
        A("director_view_stream_x_".concat(r3), r4.toString());
        JSONObject r6 = new JSONObject();
        r6.put("view_id", "group_view");
        r4.put("action", "transfer_view");
        r4.put(Constants.Keys.DATA, r6);
        A("director_view_stream_x_".concat(r3), r4.toString());
        JSONObject r7 = new JSONObject();
        r7.put("action", "start_push_stream");
        A("director_view_stream_x_".concat(r3), r7.toString());
        return;
    L13:
        r3 = "";
        goto L14
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final boolean n() {
        c r0 = this.i;
        if (r0 == null) goto L9;
        e r1 = r0.Ig();
        if (r1 == null) goto L9;
        if (r1.isInCloudCollaborate() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void reset() {
        b.c("RevLinkPartnerService", "reset", null, 4);
        this.f = false;
        this.g = false;
        this.h.postValue(null);
        this.a.setValue(null);
        this.b.setValue(null);
        NextLiveData<Boolean> r0 = this.d;
        Boolean r1 = Boolean.FALSE;
        r0.postValue(r1);
        this.e.postValue(r1);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final NextLiveData<Boolean> g() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final NextLiveData<Boolean> getBattleStatus() {
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final boolean l() {
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final NextLiveData<String> c() {
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    /* JADX INFO: renamed from: d */
    public final NextLiveData<String> mo697d() {
        return this.a;
    }

    public a(c r1) {
        this.i = r1;
        this.a = new NextLiveData();
        this.b = new NextLiveData();
        this.d = new NextLiveData();
        this.e = new NextLiveData();
        this.h = new NextLiveData();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "selfUid");
        f r0 = a();
        if (r0 == null) goto L7;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        r1.Q1("director_view_stream_x_".concat(r4));
    L7:
        f r2 = a();
        if (r2 == null) goto L12;
        i r3 = r2.getRtcManager();
        if (r3 == null) goto L12;
        r3.O0("director_view_stream_x_".concat(r4));
    L12:
        f r5 = a();
        if (r5 == null) goto L17;
        i r6 = r5.getRtcManager();
        if (r6 == null) goto L17;
        r6.Q1("group_view_stream_x_".concat(r4));
    L17:
        f r7 = a();
        if (r7 == null) goto L23;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L24;
        r8.O0("group_view_stream_x_".concat(r4));
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void f0(boolean r2) {
        ca0.i r0 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).getGiftRenderFilterWrapper();
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void j(j r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void x(boolean r3) {
        f r0 = a();
        if (r0 == null) goto L7;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        r1.x(r3);
    L7:
        j r2 = this.c;
        if (r2 == null) goto L10;
        r2.a(r3);
    L10:
        this.d.postValue(Boolean.valueOf(r3));
        if (r3 == true) goto L19;
        f r4 = a();
        if (r4 == null) goto L17;
        i r5 = r4.getRtcManager();
        if (r5 == null) goto L17;
        r5.L1();
    L17:
        this.f = false;
        this.g = false;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void A(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        f r0 = a();
        if (r0 == null) goto L8;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        r1.A(r2, r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void X0(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if (StringsKt.startsWith$default(r5, "output_view_stream_x_", false, 2, null) == true) goto L5;
        return;
    L5:
        if (StringsKt.contains$default(r6, "push_stream_connected", false, 2, null) == false) goto L14;
        f r7 = a();
        if (r7 == null) goto L11;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L11;
        r8.U();
    L11:
        mo696c();
        x(true);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void f(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "remoteUserId");
        JSONObject r0 = new JSONObject();
        r0.put("room_id", r3);
        r0.put("remote_user_id", r4);
        r0.put("stream_index", 0);
        JSONObject r5 = new JSONObject();
        r5.put("config_name", "cloud_collaborate");
        r5.put("config_info", r0);
        JSONObject r6 = new JSONObject();
        r6.put("rtc.custom_room_stream_config", r5);
        f r7 = a();
        if (r7 == null) goto L8;
        i r8 = r7.getRtcManager();
        if (r8 == null) goto L9;
        r8.B(r6);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void m(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "selfUID");
        Intrinsics.checkNotNullParameter(r10, "sei");
        JSONObject r0 = new JSONObject();
        r0.put("action", "rtmp_set_custom_sei");
        if (r10.length() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L20;
        JSONObject r2 = new JSONObject();
        JSONObject r5 = new JSONObject();
        r5.put("app_data", r10);
        f r12 = a();
        if (r12 == null) goto L13;
        i r13 = r12.getRtcManager();
        if (r13 == null) goto L13;
        int r14 = r13.getMixType();
    L15:
        if (r14 != 2) goto L17;
    L18:
        r5.put("source", "LiveCore_Android_MixStream_byte");
    L19:
        byte[] r15 = StringsKt.encodeToByteArray(r5.toString());
        int r6 = com.bytedance.revenue.platform.api.core.a.a;
        Intrinsics.checkNotNullParameter(r15, "input");
        String r7 = Base64.encodeToString(r15, 2);
        r2.put("payloadType", 100);
        r2.put("payloadSize", r15.length);
        r2.put("payload", r7);
        r2.put("onlyKeyframe", true);
        r2.put("once", false);
        r0.put(Constants.Keys.DATA, r2);
    L25:
        f r16 = a();
        if (r16 == null) goto L31;
        i r17 = r16.getRtcManager();
        if (r17 == null) goto L32;
        r17.A("director_view_stream_x_" + r9, r0.toString());
        return;
    L32:
        return;
    L31:
        return;
    L17:
        if (r14 != 3) goto L19;
    L13:
        r14 = 0;
        goto L15
    L20:
        r0.put(Constants.Keys.DATA, new JSONObject());
        c r18 = this.i;
        if (r18 == null) goto L25;
        LiveFullLinkPKMonitor r19 = r18.getLiveFullLinkPKMonitor();
        if (r19 == null) goto L25;
        LiveFullLinkPKMonitor.t(r19, "rtmp_set_custom_sei_reset", null, null, 6);
        goto L25
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void s(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "message");
        boolean r0 = false;
        if (StringsKt.contains$default(r5, "streamx_join_room", false, 2, null) == false) goto L12;
        b.c("RevLinkPartnerService", "onRoomMessageReceived streamXStartParams = " + ((String) this.b.getValue()) + ", hasReceiveStreamXRtcJoin = " + this.g, null, 4);
        this.g = true;
        String r6 = (String) this.b.getValue();
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() <= 0) goto L9;
        r0 = true;
    L9:
        if (r0 != true) goto L14;
        h();
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void k(String r2, String r3, String r4) {
        this.h.setValue(r2);
        this.a.setValue(r3);
        this.b.setValue(r4);
        f r5 = a();
        if (r5 == null) goto L8;
        i r6 = r5.getRtcManager();
        if (r6 == null) goto L9;
        r6.f();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.g
    public final void i(boolean r6, String r7, List<String> r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        b.c("RevLinkPartnerService", "enable=" + r6 + " scene=" + r7 + " lk=" + r9 + " vk=" + r10 + " path=" + r8, null, 4);
        if (r6 == true) goto L5;
        this.h.postValue(null);
        this.a.setValue(null);
    L6:
        l.a(true, r6, r7, true);
        f r12 = a();
        if (r12 == null) goto L11;
        i r13 = r12.getRtcManager();
        if (r13 == null) goto L11;
        r13.V0(r8);
    L11:
        if (r8 != null) goto L13;
    L17:
        j r14 = this.c;
        if (r14 == null) goto L20;
        r14.a(r6);
    L20:
        this.d.postValue(Boolean.valueOf(r6));
        return;
    L13:
        if ((!r8.isEmpty()) != true) goto L17;
        Intrinsics.checkNotNullParameter(r7, "scene");
        ca0.i r15 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).getGiftRenderFilterWrapper();
        if (r15 == null) goto L17;
        r15.m(r6, true, r7, true);
        goto L17
    L5:
        this.h.postValue(r9);
        this.a.setValue(r10);
        goto L6
    }
}
