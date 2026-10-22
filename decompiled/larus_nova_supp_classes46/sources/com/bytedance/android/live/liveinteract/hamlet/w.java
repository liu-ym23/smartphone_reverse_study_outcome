package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioAEDType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioVADType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w extends vb6.a {
    public final /* synthetic */ HamletAvatarWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ w a;

        public a(w r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function0<hg6.g> r0 = this.a.a.R;     // Catch: Throwable -> L12
            if (r0 == null) goto L15;
            hg6.g r1 = (hg6.g) r0.invoke();     // Catch: Throwable -> L12
            if (r1 == null) goto L19;
            ei6.a r2 = r1.V0();     // Catch: Throwable -> L12
            if (r2 == null) goto L20;
            vi6.a r3 = r2.v();     // Catch: Throwable -> L12
            if (r3 == null) goto L21;
            r3.f();     // Catch: Throwable -> L12
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public final void H1() {
        HamletAvatarContext r0 = this.a.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCleared() == true) goto L24;
        HamletAvatarContext r1 = this.a.f;
        if (r1 == null) goto L9;
        r1.setXplayAudioEnable(false);
    L9:
        HamletAvatarContext r2 = this.a.f;
        if (r2 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.isStreamRending();
        if (r3 == null) goto L16;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L16;
        HamletAvatarWidget r4 = this.a;
        r4.getClass();
        int r5 = ff0.e.a;
        String r6 = GsonProtectorUtils.toJson(GsonHelper.get(), new com.bytedance.android.live.liveinteract.hamlet.model.c());
        r4.er(r6, null);
        ff0.d r7 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "audienceBecomingGuest", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("custom_msg", String.valueOf(r6))}), 12);
    L16:
        gd1.a r8 = this.a.c;
        if (r8 == null) goto L25;
        Iterator r9 = r8.getAllCloudPlayerRtcInfo().iterator();
    L20:
        if (r9.hasNext() == false) goto L26;
        r8.enableAudio(((com.bytedance.android.live.broadcastgame.api.xplay.b) r9.next()).a, false);
        goto L20
    L26:
        return;
    L25:
        return;
    }

    public w(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void Zk(long r2, ei6.a r4) {
        Intrinsics.checkNotNullParameter(r4, "client");
        super.Zk(r2, r4);
        ALogger.i("HamletAvatar", "onRtcClientInitSuccess");
        HamletAvatarContext r3 = this.a.f;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isCleared() == true) goto L28;
        HamletAvatarContext r5 = this.a.f;
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.isRtcClientInitialized();
        if (r6 == null) goto L11;
        r6.setValue(Boolean.TRUE);
    L11:
        HamletAvatarContext r7 = HamletAvatarContext.Companion.getContext();
        if (r7 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.isMultiAvatarMode();
        if (r8 == null) goto L18;
        Boolean r9 = (Boolean) r8.getValue();
        if (r9 == null) goto L18;
        boolean r10 = r9.booleanValue();
    L19:
        if (r10 == true) goto L22;
        this.a.Nq("onRtcClientInitSuccess");
    L22:
        if (gh0.a.d() == false) goto L29;
        HamletAvatarWidget r11 = this.a;
        if (r11.C == false) goto L30;
        r11.jr();
        return;
    L30:
        return;
    L29:
        return;
    L18:
        r10 = false;
        goto L19
    }

    public final void vc(ei6.a r8, int r9, long r10, Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        super.vc(r8, r9, r10, Arrays.copyOf(r12, r12.length));
        if (r9 != 5) goto L90;
        HamletAvatarContext r11 = this.a.f;
        if (r11 != null) goto L80;
    L86:
        ALogger.i("HamletAvatar", "MSG_INFO_END_SUCCEED");
        this.a.getClass();
        return;
    L80:
        if (r11.isCleared() == true) goto L86;
        HamletAvatarContext r13 = this.a.f;
        if (r13 == null) goto L86;
        com.bytedance.live.datacontext.m<Boolean> r14 = r13.isRtcClientInitialized();
        if (r14 == null) goto L86;
        r14.setValue(Boolean.FALSE);
        goto L86
    L90:
        if (r9 == 401) goto L73;
        boolean r1 = false;
        if (r9 == 28) goto L56;
        if (r9 == 29) goto L39;
        switch(r9) {
            case 404: goto L20;
            case 405: goto L16;
            case 406: goto L13;
            default: goto L110;
        };
    L13:
        af0.a r15 = af0.a.a;
        long r16 = this.a.M;
        r15.getClass();
        long r0 = System.currentTimeMillis() - r16;
        LinkMonitorData r17 = LinkMonitorData.HamletAvatarSubMixerStartSuccess;     // Catch: Exception -> L88
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L88
        r18.put("duration", r0);     // Catch: Exception -> L88
        Unit r19 = Unit.INSTANCE;     // Catch: Exception -> L88
        af0.a.l(r17, r18);     // Catch: Exception -> L88
    L89:
        return;
    L16:
        int r20 = (int) r10;
        af0.a.a.getClass();
        LinkMonitorData r21 = LinkMonitorData.HamletAvatarSubMixerStartFail;     // Catch: Exception -> L88
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L88
        r110.put("error_code", r20);     // Catch: Exception -> L88
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L88
        af0.a.l(r21, r110);     // Catch: Exception -> L88
        goto L89
    L110:
        return;
    L20:
        if (r12.length <= 1) goto L93;
        Object r23 = r12[0];
        String r111 = (String) r12[1];
        if (r12.length <= 2) goto L27;
        Object r112 = r12[2];
        if ((r112 instanceof Boolean) == true) goto L26;
        r112 = null;
    L26:
        r1 = Intrinsics.areEqual((Boolean) r112, Boolean.TRUE);
    L31:
        if (r1 == false) goto L94;
        HamletAvatarContext r113 = this.a.f;
        if (r113 == null) goto L35;
        r113.setMainStreamServerMixedStart(Intrinsics.areEqual(r23, Integer.valueOf(LiveWrappedMixedStreamType.MIXED_STREAM_TYPE_BY_SERVER.value())));
    L35:
        com.bytedance.android.live.core.utils.i0.c().post(new a(this));
        af0.a r24 = af0.a.a;
        long r114 = this.a.L;
        r24.getClass();
        long r2 = System.currentTimeMillis() - r114;
        LinkMonitorData r25 = LinkMonitorData.HamletAvatarMainMixerSwitchSuccess;     // Catch: Exception -> L88
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L88
        r115.put("duration", r2);     // Catch: Exception -> L88
        Unit r26 = Unit.INSTANCE;     // Catch: Exception -> L88
        af0.a.l(r25, r115);     // Catch: Exception -> L88
        goto L89
    L94:
        return;
    L27:
        if (r111 != null) goto L29;
    L30:
        r1 = true;
        goto L31
    L29:
        if (r111.length() != 0) goto L31;
    L93:
        return;
    L39:
        if (r12.length != 0) goto L41;
        boolean r27 = true;
    L43:
        if ((!r27) == false) goto L95;
        HamletAvatarContext r28 = this.a.f;
        if (r28 != null) goto L47;
        return;
    L47:
        if (r28.isCleared() == true) goto L97;
        Object r29 = r12[0];
        if ((r29 instanceof LiveWrappedAudioAEDType) == false) goto L98;
        HamletAvatarContext r30 = this.a.f;
        if (r30 == null) goto L99;
        com.bytedance.live.datacontext.n<Integer> r31 = r30.getAEDState();
        if (r31 == null) goto L100;
        r31.setValue(Integer.valueOf(((LiveWrappedAudioAEDType) r29).value()));
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    L95:
        return;
    L41:
        r27 = false;
        goto L43
    L56:
        if (r12.length != 0) goto L58;
        boolean r32 = true;
    L60:
        if ((!r32) == false) goto L102;
        HamletAvatarContext r33 = this.a.f;
        if (r33 != null) goto L64;
        return;
    L64:
        if (r33.isCleared() == true) goto L104;
        Object r34 = r12[0];
        if ((r34 instanceof LiveWrappedAudioVADType) == false) goto L105;
        HamletAvatarContext r35 = this.a.f;
        if (r35 == null) goto L106;
        com.bytedance.live.datacontext.n<Integer> r36 = r35.getVADState();
        if (r36 == null) goto L107;
        r36.setValue(Integer.valueOf(((LiveWrappedAudioVADType) r34).value()));
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L102:
        return;
    L58:
        r32 = false;
        goto L60
    L73:
        if (r10 == 0) goto L109;
        int r37 = (int) r10;
        af0.a.a.getClass();
        LinkMonitorData r38 = LinkMonitorData.HamletAvatarMainMixerSwitchFail;     // Catch: Exception -> L88
        JSONObject r116 = new JSONObject();     // Catch: Exception -> L88
        r116.put("error_code", r37);     // Catch: Exception -> L88
        Unit r39 = Unit.INSTANCE;     // Catch: Exception -> L88
        af0.a.l(r38, r116);     // Catch: Exception -> L88
        goto L89
    L109:
        return;
    }
}
