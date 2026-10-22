package g58;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lark.kmp.server.pb.improto.Packet;
import com.larus.audio.audiov3.config.BusinessTypeEnum;
import com.larus.audio.call.tracer.AudioFileSaver;
import com.larus.audio.sami.IFlowSamiFactory;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.s;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ e(h r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final h r2 = this.a;
        String r0 = this.b;
        String r7 = this.c;
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L7;
        s r5 = r4.s0();
        if (r5 == null) goto L7;
        r5.g();
    L7:
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L12;
        s r8 = r6.s0();
        if (r8 == null) goto L12;
        r8.i(true);
    L12:
        r2.getClass();
        JSONObject r3 = new JSONObject();
        if (r0 != null) goto L15;
        String r9 = "";
    L16:
        r3.put("message_id", r9);
        if (r7 != null) goto L19;
        String r10 = "";
    L20:
        r3.put("bot_id", r10);
        JSONObject r11 = new JSONObject();
        r2.c = r11;
        r11.put("first_party_app_audio_asr_info", r3);
        r2.b = UUID.randomUUID().toString();
        if (z2.a.S0() == false) goto L23;
        String r14 = "ogg_opus";
        boolean r16 = true;
    L24:
        FLogger.a.i("AiAsrManager", "initConfig with format:".concat(r14));
        String r13 = r2.b;
        IRepoDispatcherService r12 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r12 == null) goto L31;
        ISettingRepoService r15 = r12.c();
        if (r15 == null) goto L31;
        String r17 = r15.S0();
        if (r17 == null) goto L31;
        String r21 = r17;
    L32:
        r2.d = new y58.a(null, r13, "0", r21, null, false, false, null, null, 0, 0, Boolean.valueOf(r16), 0, 0, false, 0, 0, r14, null, r7, null, 0, null, 247267313);
        boolean r19 = HttpExtKt.e().c;
        y58.a r20 = r2.d;
        if (r20 == null) goto L47;
        x58.a r22 = r20.C;
        if (r22 == null) goto L47;
        String r23 = r22.j;
        if (r23 == null) goto L47;
        Uri r24 = UriProtector.parse(r23);
        Uri.Builder r25 = new Uri.Builder().scheme("wss").authority("wss-fpa.doubao.com").path("/fpa/meeting/audio/ws");
        Iterator r26 = UriProtector.getQueryParameterNames(r24).iterator();
    L40:
        if (r26.hasNext() == false) goto L42;
        String r27 = (String) r26.next();
        r25.appendQueryParameter(r27, UriProtector.getQueryParameter(r24, r27));
        goto L40
    L42:
        String r29 = r25.build().toString();
        FLogger r30 = FLogger.a;
        StringBuilder r31 = new StringBuilder("taskId: ");
        y58.a r32 = r2.d;
        if (r32 == null) goto L45;
        String r33 = r32.b;
    L46:
        r31.append(r33);
        r31.append(", newUrl: ");
        r31.append(r29);
        String r34 = "AiAsrManager";
        r30.i(r34, r31.toString());
        String r110 = r29;
    L48:
        y58.a r35 = r2.d;
        if (r35 == null) goto L72;
        x58.a r36 = r35.C;
        if (r36 == null) goto L56;
        String r37 = r36.a;
        if (r37 == null) goto L56;
        String r38 = r37;
    L57:
        if (r36 == null) goto L62;
        String r39 = r36.b;
        if (r39 == null) goto L62;
        String r40 = r39;
    L63:
        x58.a r41 = m58.h.a;
        JSONObject r42 = new JSONObject();
        FLogger r43 = FLogger.a;
        StringBuilder r44 = new StringBuilder("initConfig isMinorMode=");
        AccountService r111 = AccountService.a;
        r44.append(r111.a());
        r43.i(r34, r44.toString());
        if (r111.a() == false) goto L66;
        r42.put("minor-mode", "1");
    L66:
        Unit r45 = Unit.INSTANCE;
        String r46 = m58.h.b(true, r42, 2);
        String r112 = r111.getUserId();
        String r113 = com.larus.platform.service.o.a.getDeviceId();
        Integer r114 = z2.a.p1().getSamiBusinessId();
        AppHost.Companion r115 = AppHost.a;
        String r116 = r115.getVersionName();
        int r117 = r115.getUpdateVersionCode();
        List r118 = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(Packet.DEFAULT_STATUS), 400, 800, 1600, 3200, 6400, 7400});
        int r119 = 0;
    L68:
        if (r119 >= 89) goto L70;
        r118.add(20000);
        r119 = r119 + 1;
        goto L68
    L70:
        r35.C = new x58.a(r38, r40, r46, r112, r113, r116, r117, "", r114, r110, z2.a.samiConnectTimeout(), new AudioRetransmitStrategy(new t78.a(true, CollectionsKt.toIntArray(r118), 2)), false, false, null, 8192, false, false, false, false, 1998848);
    L62:
        r40 = "";
    L56:
        r38 = "";
    L72:
        r78.c.a.getClass();
        com.larus.audio.audiov3.task.sami.v2.flow.a r47 = ((IFlowSamiFactory) ServiceManager.get().getService(IFlowSamiFactory.class)).create();
        r2.a = r47;
        n r48 = new n(r2, false, r0);
        if (r47 == null) goto L76;
        r47.i(r48);
    L76:
        if (c78.a.a == true) goto L78;
    L83:
        ((com.larus.audio.call.record.f) r2.q.getValue()).d((v58.a) r2.p.getValue(), new f(r2));
        r78.c r1 = r2.a;
        if (r1 == null) goto L90;
        y58.a r49 = r2.d;
        if (r49 == null) goto L88;
        x58.a r50 = r49.C;
    L89:
        r1.f(r50);
        goto L90
    L88:
        r50 = null;
    L90:
        r78.c r51 = r2.a;
        if (r51 == null) goto L102;
        BusinessTypeEnum r310 = BusinessTypeEnum.ASR;
        y58.a r52 = r2.d;
        if (r52 == null) goto L95;
        x58.a r311 = r52.C;
    L96:
        r51.g(r310, r311, r52, 20, r2.c, null, null);
        return;
    L95:
        r311 = null;
        goto L96
    L102:
        return;
    L78:
        if (r2.e != null) goto L83;
        r2.e = new AudioFileSaver(r2.b, false);     // Catch: Exception -> L81
    L81:
        e = move-exception;
        FLogger.a.e(r34, e.getMessage());
        goto L83
    L45:
        r33 = null;
    L47:
        r34 = "AiAsrManager";
        r110 = "";
    L31:
        r21 = "";
        goto L32
    L23:
        r14 = "raw";
        r16 = false;
        goto L24
    L19:
        r10 = r7;
        goto L20
    L15:
        r9 = r0;
        goto L16
    }
}
