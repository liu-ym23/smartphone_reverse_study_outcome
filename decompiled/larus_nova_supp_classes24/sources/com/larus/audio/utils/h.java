package com.larus.audio.utils;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ String f;
    public final /* synthetic */ e g;

    public /* synthetic */ h(String r1, String r2, String r3, float r4, float r5, String r6, e r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r14) {
        final String r7 = this.a;
        final String r8 = this.b;
        String r0 = this.c;
        final float r3 = this.d;
        final float r4 = this.e;
        final String r5 = this.f;
        final e r6 = this.g;
        float r15 = ((Float) r14).floatValue();
        l1.a(true);
        FLogger r2 = FLogger.a;
        r2.i("AudioLoadManager", "[playMixAudio] media request success, try start play " + r7 + '!');
        AudioLoadManager r9 = AudioLoadManager.a;
        IVideoController r10 = AudioLoadManager.b();
        if (r10 == null) goto L6;
        r10.c(r15);
    L6:
        if (AudioLoadManager.d(r8, true) == false) goto L17;
        com.larus.audio.tts.c r16 = AudioLoadManager.b;
        String r11 = null;
        if (r16 == null) goto L10;
        String r12 = r16.b(r8, AppHost.a.getApplication());
    L12:
        if (Intrinsics.areEqual(r12, r0) == false) goto L17;
        r2.i("AudioLoadManager", "[playMixAudio] hit cache " + r7 + "!, url:" + r8);
        l1.f = true;
        StringBuilder r1 = new StringBuilder();
        if (r16 == null) goto L16;
        r11 = r16.c(AppHost.a.getApplication());
    L16:
        r1.append(r11);
        r1.append(File.separator);
        ByteString.Companion.getClass();
        r1.append(ByteString.a.b(r8).md5().hex());
        com.larus.utils.t0.b.post(new m(r1.toString(), r3, r4, r5, r6));
    L19:
        return Unit.INSTANCE;
    L10:
        r12 = null;
    L17:
        r2.i("AudioLoadManager", "[playMixAudio] not hit cache " + r7 + "!, url:" + r8);
        l1.f = false;
        AudioLoadManager.e(r7, r8, new l(r7, r8, r3, r4, r5, r6));
        goto L19
    }
}
