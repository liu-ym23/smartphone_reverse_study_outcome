package com.larus.audio.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ e d;

    public /* synthetic */ j(String r1, String r2, String r3, e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r12) {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        e r3 = this.d;
        float r13 = ((Float) r12).floatValue();
        FLogger r4 = FLogger.a;
        r4.i("AudioLoadManager", "[playAudio] media request success styleId=" + r0 + " !!");
        l1.a(true);
        AudioLoadManager r7 = AudioLoadManager.a;
        IVideoController r8 = AudioLoadManager.b();
        if (r8 == null) goto L5;
        r8.c(r13);
    L5:
        StringBuilder r14 = new StringBuilder("[realPlay] access focus styleId:");
        r14.append(r0);
        r14.append(", network:");
        AppHost.Companion r9 = AppHost.a;
        r14.append(NetworkUtils.getNetworkAccessType(NetworkUtils.getNetworkTypeFast(r9.getApplication())));
        r14.append(", network_status:");
        r14.append(NetConnectionTypeProvider.a);
        r4.i("AudioLoadManager", r14.toString());
        IVideoController r15 = AudioLoadManager.b();
        if (r15 == null) goto L9;
        r15.setDirectURL(r1);
    L9:
        if (AudioLoadManager.d(r1, true) == false) goto L34;
        com.larus.audio.tts.c r16 = AudioLoadManager.b;
        if (r16 == null) goto L13;
        String r10 = r16.b(r1, r9.getApplication());
    L15:
        if (Intrinsics.areEqual(r10, r2) == false) goto L34;
        l1.f = true;
        if (r16 == null) goto L19;
        String r17 = r16.c(r9.getApplication());
    L20:
        ByteString.a r5 = ByteString.Companion;
        if (r1 != null) goto L23;
        String r11 = "";
    L24:
        r5.getClass();
        PolarisFileWrapper r6 = new PolarisFileWrapper(r17, ByteString.a.b(r11).md5().hex());
        IVideoController r19 = AudioLoadManager.b();
        if (r19 == null) goto L27;
        r19.setLocalURL(r6.getAbsolutePath());
    L27:
        IVideoController r110 = AudioLoadManager.b();
        if (r110 == null) goto L30;
        r110.p(new v(r0, r3, r1));
    L30:
        IVideoController r111 = AudioLoadManager.b();
        if (r111 == null) goto L33;
        r111.play();
    L33:
        r4.i("AudioLoadManager", "[realPlay] styleId:" + r0 + ", local audio file path : " + r6.getAbsolutePath());
    L44:
        AudioLoadManager.f("playStart", r0, r1, null);
        return Unit.INSTANCE;
    L23:
        r11 = r1;
        goto L24
    L19:
        r17 = null;
        goto L20
    L13:
        r10 = null;
    L34:
        l1.f = false;
        IVideoController r112 = AudioLoadManager.b();
        if (r112 == null) goto L37;
        r112.p(new w(r3, r0));
    L37:
        IVideoController r113 = AudioLoadManager.b();
        if (r113 == null) goto L40;
        r113.setLocalURL(r1);
    L40:
        IVideoController r114 = AudioLoadManager.b();
        if (r114 == null) goto L43;
        r114.play();
    L43:
        r4.i("AudioLoadManager", "[realPlay] styleId:" + r0 + ", play url audio url : " + r1);
        AudioLoadManager.e(r0, r1, null);
        goto L44
    }
}
