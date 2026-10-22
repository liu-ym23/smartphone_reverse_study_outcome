package com.larus.audio.utils;

import com.larus.audio.SoundsSource;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class x0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ String g;
    public final /* synthetic */ SoundsSource h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ String m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ String o;
    public final /* synthetic */ int p;

    public /* synthetic */ x0(String r4, boolean r5, String r6, String r7, int r8, int r9, String r10, SoundsSource r11, String r12, String r13, String r14, long r15, String r17, boolean r19, String r110, int r20) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r17;
        this.n = r19;
        this.o = r110;
        this.p = r20;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r1 = this.a;
        boolean r2 = this.b;
        String r3 = this.c;
        String r4 = this.d;
        int r5 = this.e;
        int r6 = this.f;
        String r7 = this.g;
        SoundsSource r8 = this.h;
        String r9 = this.i;
        String r10 = this.j;
        String r11 = this.k;
        long r12 = this.l;
        String r14 = this.m;
        boolean r15 = this.n;
        String r13 = this.o;
        int r16 = this.p;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r17 = null;
        if (r0 == null) goto L5;
        com.larus.home.impl.sdk.s r19 = r0.s0();
    L6:
        if (r19 == null) goto L8;
        r17 = r19.t();
    L8:
        if (r19 == null) goto L13;
        Integer r110 = r19.l();
        if (r110 == null) goto L13;
        r110.intValue();
    L13:
        if (r19 == null) goto L15;
        boolean r20 = Intrinsics.areEqual(r19.F(), Boolean.TRUE);
    L16:
        m58.s r111 = m58.h.b;
        if (r111 == null) goto L24;
        JSONObject r112 = new JSONObject();
        boolean r21 = r20;
        r112.put("is_message_generating", r2 ? 1 : 0);
        r112.put("reading_scene", r3);
        r112.put("adjust_direction", r4);
        r112.put("volume_before", r5);
        r112.put("volume_after", r6);
        r112.put("audio_id", r7);
        r112.put("reading_scene_last", r8.getKeyStr());
        r112.put("audio_id_last", r9);
        r112.put("bot_id", r10);
        r112.put("chat_type", r11);
        r112.put("bluetooth_condition", "");
        r112.put("duration", r12);
        r112.put("FW_version", r17);
        r112.put("audio_output_device_connetion", r14);
        if (r21 == false) goto L21;
        String r22 = "on";
    L22:
        r112.put("dora_adaptive_volume_settings", r22);
        r112.put("is_trigger_0_volume", r15 ? 1 : 0);
        r112.put("speaker_id", r13);
        r112.put("is_first_play_audio_after_enter_app", r16);
        Unit r23 = Unit.INSTANCE;
        r111.report(r1, r112);
        return;
    L21:
        r22 = "off";
        goto L22
    L24:
        return;
    L15:
        r20 = false;
        goto L16
    L5:
        r19 = null;
        goto L6
    }
}
