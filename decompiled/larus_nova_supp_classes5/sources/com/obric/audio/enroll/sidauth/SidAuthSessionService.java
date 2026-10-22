package com.obric.audio.enroll.sidauth;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SidAuthService;
import com.mammon.audiosdk.structures.SAMICoreSidAuthCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRegisterResult;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRequest;
import com.mammon.audiosdk.structures.SAMICoreSidAuthResult;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.voice.k;
import com.obric.audio.continuous_talk.s0;
import f06.b;
import f06.d;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import r68.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SidAuthSessionService implements a {
    public static final SidAuthSessionService a = null;
    public static final Lazy b = null;
    public static final CoroutineScope c = null;
    public static volatile long d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static final Object g = null;
    public static ByteArrayOutputStream h;
    public static Job i;
    public static boolean j;
    public static float[] k;

    public SidAuthSessionService() {
    }

    static {
        a = new SidAuthSessionService();
        b = LazyKt.lazy(new n());
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        g = new Object();
    }

    public static SAMICoreSidAuthCreateParameter h() {
        SAMICoreSidAuthCreateParameter r0 = new SAMICoreSidAuthCreateParameter();
        nia.a.a.getClass();
        r0.modelPath = nia.a.l().a;
        r0.dbPath = nia.a.g;
        r0.uid = nia.a.g() + '-' + obricDeviceManagerDelegate.b.getUuid();
        r0.sidModelMd5 = nia.a.l().c;
        r0.appId = String.valueOf(AppHost.a.getAppId());
        r0.sidAuthEncKeyInfo = nia.a.e(nia.a.l().b);
        return r0;
    }

    public final void b() {
        if (f == false) goto L5;
        return;
    L5:
        Object r0 = g;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (e == true) goto L12;
        monitor-exit(r0);
        return;
    L12:
        if (j == true) goto L14;
        h = new ByteArrayOutputStream();     // Catch: Throwable -> L18
    L14:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        FLogger.a.i("SidAuthSessionService", "resetCacheForNextQuery currentWkrId=" + d);
    }

    public static long e(String r8) {
        ByteArrayOutputStream r0 = h;
        if (r0 == null) goto L9;
        int r1 = r0.size();
        if (r1 >= 1920000) goto L7;
        return 0;
    L7:
        long r2 = d;
        FLogger.a.i("SidAuthSessionService", "abort auth cache reason=" + r8 + " wkrId=" + r2 + " cachedBytes=" + r1 + " maxBytes=1920000 maxDurationMs=60000");
        i(true);
        return r2;
    L9:
        return 0;
    }

    public static byte[] g(ByteArrayOutputStream r30) {
        float[] r0 = k;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.length != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return null;
    L11:
        if (r30 == null) goto L69;
        int r3 = r30.size();
        if (r3 > 0) goto L15;
        return null;
    L15:
        byte[] r5 = r30.toByteArray();
        long r6 = -1;
        long r8 = -1;
        int r10 = 0;
    L17:
        if (r10 >= r0.length) goto L59;
        byte[] r31 = r5;
        long r4 = RangesKt.coerceAtLeast((long) r0[r10], 0);
        Float r11 = ArraysKt.getOrNull(r0, r10 + 1);
        if (r11 == null) goto L21;
        Long r1 = Long.valueOf((long) r11.floatValue());
    L22:
        if (r1 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        long r12 = 32;
        long r22 = r4 * r12;
        if ((r22 % 2) == 0) goto L32;
        r22 = r22 - 1;
    L32:
        int r14 = r10;
        long r13 = r22;
        if (r7 == false) goto L35;
        int r9 = r3;
        long r15 = 0 + ((long) r9);
    L40:
        long r16 = r13 - 0;
        long r17 = r15 - 0;
        long r23 = r17 - r16;
        long r18 = (r23 * 1000) / ((long) 32000);
        if (r16 >= 0) goto L43;
    L55:
        long r25 = r16;
    L56:
        FLogger.a.i("SidAuthSessionService", "skip continuous vad segment startMs=" + r4 + " rawEndMs=" + r1 + " isOpenEnded=" + r7 + " cacheStartBytes=0 startInCache=" + r25 + " endInCache=" + r17 + " bufferSize=" + r9 + " durationMs=" + r18);
    L57:
        r6 = r6;
    L58:
        r10 = r14 + 2;
        r5 = r31;
        r3 = r9;
        r0 = r0;
        goto L17
    L43:
        if (r17 <= r16) goto L55;
        r25 = r16;
        if (r17 > r9) goto L56;
        if (r18 < 1000) goto L56;
        if (r8 >= 0) goto L51;
    L54:
        r6 = r17;
        r8 = r25;
        goto L58
    L51:
        if (r23 <= (r6 - r8)) goto L57;
    L35:
        r9 = r3;
        long r26 = r1.longValue() * r12;
        if ((r26 % 2) == 0) goto L39;
        r26 = r26 - 1;
    L39:
        r15 = RangesKt.coerceAtLeast(r26, r13);
        goto L40
    L24:
        if (r1.longValue() <= 0) goto L27;
        r7 = false;
        goto L28
    L21:
        r1 = null;
        goto L22
    L59:
        float[] r24 = r0;
        byte[] r32 = r5;
        long r20 = r6;
        if (r8 >= 0) goto L62;
    L66:
        FLogger.a.i("SidAuthSessionService", "buildContinuousCandidate no valid segment featureValuesMs=" + Arrays.toString(r24));
        return null;
    L62:
        if (r20 <= r8) goto L66;
        Intrinsics.checkNotNull(r32);
        byte[] r19 = ArraysKt.copyOfRange(r32, (int) r8, (int) r20);
        FLogger r21 = FLogger.a;
        StringBuilder r27 = new StringBuilder("buildContinuousCandidate success startMs=");
        long r110 = 32000;
        r27.append((r8 * 1000) / r110);
        r27.append(" endMs=");
        r27.append((r20 * 1000) / r110);
        r27.append(" durationMs=");
        r27.append((((long) r19.length) * 1000) / r110);
        r27.append(" cacheStartBytes=0 candidateSize=");
        r27.append(r19.length);
        r27.append(" featureValuesMs=");
        r27.append(Arrays.toString(r24));
        r21.i("SidAuthSessionService", r27.toString());
        return r19;
    L69:
        return null;
    L8:
        r2 = false;
        goto L9
    }

    public static void i(boolean r3) {
        if (r3 == false) goto L7;
        Job r4 = i;
        if (r4 == null) goto L7;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L7:
        i = null;
        e = false;
        h = null;
        d = 0;
        f = false;
        j = false;
        k = null;
    }

    public static void k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        FLogger.a.i("SidAuthSessionService", "destroyForAccountChange reason=" + r4);
        Object r5 = g;
        monitor-enter(r5);
        a.getClass();     // Catch: Throwable -> L21
        i(true);     // Catch: Throwable -> L21
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        g.a.getClass();     // Catch: Throwable -> L8
        g.a();     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L24;
        FLogger.a.e("SidAuthSessionService", "destroyForAccountChange pending clearAll failed: " + r8.getMessage());
    L24:
        m.a.getClass();     // Catch: Throwable -> L15
        m.a();     // Catch: Throwable -> L15
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L30;
        FLogger.a.e("SidAuthSessionService", "destroyForAccountChange register clear failed: " + r10.getMessage());
        return;
    L30:
        return;
    L15:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        throw th;
    }

    public static int p(SidAuthService r5) {
        SAMICoreSidAuthRegisterResult r1 = new SAMICoreSidAuthRegisterResult();
        int r6 = r5.register(r1);     // Catch: Throwable -> L12
        if (r6 != 0) goto L10;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("SidAuth register auth model success sidId=");
        r3.append(r1.sidId);
        r3.append(" voiceFingerId=");
        r3.append(r1.voiceFingerId);
        r3.append(" embedJsonLen=");
        String r4 = r1.embedJson;
        if (r4 == null) goto L8;
        int r7 = r4.length();
    L9:
        r3.append(r7);
        r2.i("SidAuthSessionService", r3.toString());
    L11:
        return r6;
    L8:
        r7 = 0;
        goto L9
    L10:
        FLogger.a.e("SidAuthSessionService", "SidAuth register auth model failed ret=" + r6);
    L12:
        th = move-exception;
        FLogger.a.e("SidAuthSessionService", "SidAuth register auth model exception: " + th.getMessage());
        return IntCompanionObject.MIN_VALUE;
    }

    public final void a(String r19) {
        if (f == false) goto L15;
        Ref.LongRef r0 = new Ref.LongRef();
        Object r1 = g;
        monitor-enter(r1);
        r0.element = d;     // Catch: Throwable -> L12
        a.getClass();     // Catch: Throwable -> L12
        i(true);     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        FLogger.a.i("SidAuthSessionService", "onSessionEnd bypass adaptive sid, wkrId=" + r0.element);
        if (r0.element == 0) goto L130;
        BuildersKt.launch$default(c, null, null, new onSessionEnd.2(r0, null), 3, null);
        return;
    L130:
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        Ref.LongRef r6 = new Ref.LongRef();
        Ref$BooleanRef r7 = new Ref$BooleanRef();
        Object r8 = g;
        monitor-enter(r8);
    L118:
        th = move-exception;
        throw th;
    L18:
        if (e == true) goto L22;
        monitor-exit(r8);
        return;
    L22:
        e = false;     // Catch: Throwable -> L118
        r6.element = d;     // Catch: Throwable -> L118
        ByteArrayOutputStream r2 = h;     // Catch: Throwable -> L118
        if (r2 == null) goto L26;
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L118
        if (r3 == null) goto L26;
    L27:
        byte[] r10 = r3;
        boolean r4 = j;     // Catch: Throwable -> L118
        r7.element = r4;     // Catch: Throwable -> L118
        if (r4 == false) goto L30;
        SidAuthSessionService r9 = a;     // Catch: Throwable -> L118
        ByteArrayOutputStream r11 = h;     // Catch: Throwable -> L118
        r9.getClass();     // Catch: Throwable -> L118
        byte[] r12 = g(r11);     // Catch: Throwable -> L118
    L31:
        a.getClass();     // Catch: Throwable -> L118
        i(true);     // Catch: Throwable -> L118
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L118
        monitor-exit(r8);
        if (r12 == null) goto L35;
        int r14 = r12.length;
    L36:
        long r15 = 32000;
        long r16 = (((long) r14) * 1000) / r15;
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("onSessionEnd wkrId=");
        r18.append(r6.element);
        r18.append(" pcmSize=");
        r18.append(r10.length);
        r18.append(" candidateSize=");
        if (r12 == null) goto L39;
        int r20 = r12.length;
    L40:
        r18.append(r20);
        r18.append(" durationMs=");
        r18.append(r16);
        r18.append(" asrTextLen=");
        if (r19 == null) goto L43;
        int r21 = r19.length();
    L44:
        r18.append(r21);
        r18.append(" isContinuousTalk=");
        r18.append(r7.element);
        r17.i("SidAuthSessionService", r18.toString());
        if (r6.element != 0) goto L49;
        r17.i("SidAuthSessionService", "onSessionEnd skip: no wkrId");
        return;
    L49:
        if (r7.element == false) goto L54;
        if (r12 != null) goto L54;
        r17.i("SidAuthSessionService", "onSessionEnd dispatch fail: no continuous vad candidate, wkrId=" + r6.element);
        BuildersKt.launch$default(c, null, null, new onSessionEnd.4(r6, null), 3, null);
        return;
    L54:
        if (r10.length != 0) goto L56;
        boolean r22 = true;
    L57:
        if (r22 == false) goto L62;
        if (r12 != null) goto L62;
        r17.i("SidAuthSessionService", "onSessionEnd skip: empty audio");
        return;
    L62:
        if (p.a(r19, "SidAuthSessionService") == true) goto L77;
        StringBuilder r23 = new StringBuilder("onSessionEnd skip auth: asr text too short, wkrId=");
        r23.append(r6.element);
        r23.append(" asrTextLen=");
        if (r19 == null) goto L66;
        int r24 = r19.length();
    L67:
        r23.append(r24);
        r23.append(" hasAsrText=");
        if (r19 != null) goto L70;
    L73:
        boolean r25 = true;
    L74:
        r23.append(!r25);
        r17.i("SidAuthSessionService", r23.toString());
        BuildersKt.launch$default(c, null, null, new onSessionEnd.5(r6, null), 3, null);
        return;
    L70:
        if (r19.length() == 0) goto L73;
        r25 = false;
        goto L74
    L66:
        r24 = 0;
        goto L67
    L77:
        if (r7.element == false) goto L81;
        if (r12 == null) goto L80;
        r17.i("SidAuthSessionService", "sliceVoicePcm by continuous vad candidate pcmSize=" + r10.length + " vadPcmSize=" + r12.length + " vadDurationMs=" + ((((long) r12.length) * 1000) / r15));
        byte[] r26 = r12;
        Ref.LongRef r110 = r6;
        Ref$BooleanRef r111 = r7;
    L109:
        long r27 = (((long) r26.length) * 1000) / r15;
        if (r19 == null) goto L112;
        int r28 = r19.length();
    L113:
        BuildersKt.launch$default(c, null, null, new onSessionEnd.6(r110, r26, r27, r111, r28, null), 3, null);
        return;
    L112:
        r28 = 0;
        goto L113
    L80:
        r17.i("SidAuthSessionService", "sliceVoicePcm continuous vad candidate unavailable, fallback to full pcm");
        r110 = r6;
        r111 = r7;
    L108:
        r26 = r10;
        goto L109
    L81:
        int r29 = q.a;
        Intrinsics.checkNotNullParameter(r10, "pcm");
        if (r10.length != 0) goto L84;
        boolean r112 = true;
    L85:
        if (r112 == false) goto L87;
        r110 = r6;
        r111 = r7;
        r26 = null;
    L105:
        if (r26 == null) goto L107;
        FLogger.a.i("SidAuthSessionService", "sliceVoicePcm by local vad pcmSize=" + r10.length + " vadPcmSize=" + r26.length + " vadDurationMs=" + ((((long) r26.length) * 1000) / r15));
        goto L109
    L107:
        FLogger.a.i("SidAuthSessionService", "sliceVoicePcm local vad unavailable, fallback to full pcm");
        goto L108
    L87:
        s0 r30 = new s0(800);
    L100:
        th = th;
        r110 = r6;
        r111 = r7;
    L128:
        FLogger.a.e("SidAuthVadAudioSlicer", "sliceLongestVoiceSegment failed: " + th.getMessage());     // Catch: Throwable -> L115
    L103:
        r26 = null;
    L104:
        r30.d();
    L115:
        th = move-exception;
        r30.d();
        throw th;
    L89:
        if (r30.c() == true) goto L91;
        r17.w("SidAuthVadAudioSlicer", "sliceLongestVoiceSegment preload failed, pcmSize=" + r10.length);     // Catch: Throwable -> L100
    L93:
        r110 = r6;
        r111 = r7;
        goto L103
    L91:
        q.a r113 = q.b(r30, r10);     // Catch: Throwable -> L100
        if (r113 == null) goto L93;
        StringBuilder r114 = new StringBuilder("sliceLongestVoiceSegment success startMs=");     // Catch: Throwable -> L100
        r110 = r6;
        r111 = r7;
        r114.append(q.a(r113.a));     // Catch: Throwable -> L98
        r114.append(" endMs=");     // Catch: Throwable -> L98
        r114.append(q.a(r113.b));     // Catch: Throwable -> L98
        r114.append(" durationMs=");     // Catch: Throwable -> L98
        r114.append(q.a(r113.d));     // Catch: Throwable -> L98
        r114.append(" pcmDurationMs=");     // Catch: Throwable -> L98
        r114.append(q.a(r10.length));     // Catch: Throwable -> L98
        r17.i("SidAuthVadAudioSlicer", r114.toString());     // Catch: Throwable -> L98
        r26 = ArraysKt.copyOfRange(r10, r113.a, r113.b);     // Catch: Throwable -> L98
    L98:
        th = th;
        goto L128
    L84:
        r112 = false;
        goto L85
    L56:
        r22 = false;
        goto L57
    L43:
        r21 = 0;
        goto L44
    L39:
        r20 = 0;
        goto L40
    L35:
        r14 = r10.length;
        goto L36
    L30:
        r12 = null;
    L26:
        r3 = new byte[0];     // Catch: Throwable -> L118
        goto L27
    }

    public final void d(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "pcm");
        if (f == false) goto L6;
        return;
    L6:
        if (e == true) goto L8;
        return;
    L8:
        if (r6.length != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L39;
        Object r1 = g;
        monitor-enter(r1);
    L32:
        th = move-exception;
        throw th;
    L16:
        if (e == true) goto L18;
    L30:
        monitor-exit(r1);
        return;
    L18:
        if (j == true) goto L30;
        ByteArrayOutputStream r2 = h;     // Catch: Throwable -> L32
        if (r2 != null) goto L24;
        monitor-exit(r1);
        return;
    L24:
        r2.write(r6, 0, r6.length);     // Catch: Throwable -> L32
        a.getClass();     // Catch: Throwable -> L32
        long r3 = e("feedAecPcm");     // Catch: Throwable -> L32
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r1);
        if (r3 == 0) goto L38;
        l(r3, "cache duration exceeds 60000ms");
        return;
    L38:
        return;
    L39:
        return;
    L10:
        r0 = false;
        goto L11
    }

    public static ContentProviderClient j(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void l(long r6, String r8) {
        BuildersKt.launch$default(c, null, null, new dispatchCacheTimeout.1(r6, r8, null), 3, null);
    }

    public static void m(long r3, String r5) {
        FLogger.a.i("SidAuthSessionService", "dispatchFail wkrId=" + r3 + " reason=" + r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        o(r3, 0);     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r4);
        if (r7 == null) goto L13;
        FLogger.a.e("SidAuthSessionService", "dispatchFail send failed: " + r7.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.StringBuilder] */
    public static void o(long r10, int r12) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Boolean.valueOf(ObricEnrollInteropDelegate.b.b()));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L10;
        FLogger r5 = FLogger.a;
        ContentProviderClient r6 = new StringBuilder("isVoiceWakeupEnabled failed: ");
        r6.append(r4.getMessage());
        r5.e("SidAuthSessionService", r6.toString());
    L10:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L14;
        r3 = r7;
    L14:
        if (((Boolean) r3).booleanValue() == true) goto L17;
        FLogger.a.i("SidAuthSessionService", "dispatchSaveAdaptiveEmbedding skip: wakeup disabled wkrId=" + r10 + " save=" + r12);
        return;
    L17:
        Unit r8 = null;
        ContentProviderClient r9 = j(AppHost.a.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L39 Exception -> L41
        if (r9 != null) goto L26;
        FLogger.a.e("SidAuthSessionService", "dispatchSaveAdaptiveEmbedding failed: provider client null");     // Catch: Exception -> L37 Throwable -> L56
        Result.constructor-impl(null);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L26:
        Bundle r13 = new Bundle();     // Catch: Exception -> L37 Throwable -> L56
        r13.putLong("wkrId", r10);     // Catch: Exception -> L37 Throwable -> L56
        r13.putInt("save", r12);     // Catch: Exception -> L37 Throwable -> L56
        Bundle r14 = r9.call("sid-auth-save-adaptive-embedding", null, r13);     // Catch: Exception -> L37 Throwable -> L56
        FLogger r15 = FLogger.a;     // Catch: Exception -> L37 Throwable -> L56
        StringBuilder r16 = new StringBuilder("dispatchSaveAdaptiveEmbedding wkrId=");     // Catch: Exception -> L37 Throwable -> L56
        r16.append(r10);     // Catch: Exception -> L37 Throwable -> L56
        r16.append(" save=");     // Catch: Exception -> L37 Throwable -> L56
        r16.append(r12);     // Catch: Exception -> L37 Throwable -> L56
        r16.append(" providerRet=");     // Catch: Exception -> L37 Throwable -> L56
        if (r14 == null) goto L29;
        Integer r17 = Integer.valueOf(r14.getInt("ret", IntCompanionObject.MIN_VALUE));     // Catch: Exception -> L37 Throwable -> L56
    L30:
        r16.append(r17);     // Catch: Exception -> L37 Throwable -> L56
        r15.i("SidAuthSessionService", r16.toString());     // Catch: Exception -> L37 Throwable -> L56
        if (Build.VERSION.SDK_INT < 24) goto L34;
        r9.close();     // Catch: Throwable -> L53
    L35:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
        return;
    L34:
        r9.release();     // Catch: Throwable -> L53
        goto L35
    L29:
        r17 = null;
    L37:
        e = e;
    L43:
        FLogger.a.e("SidAuthSessionService", "dispatchSaveAdaptiveEmbedding exception: " + e.getMessage());     // Catch: Throwable -> L56
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L53
        if (r9 != null) goto L47;
    L51:
        Result.constructor-impl(r8);     // Catch: Throwable -> L53
        return;
    L47:
        if (Build.VERSION.SDK_INT < 24) goto L49;
        r9.close();     // Catch: Throwable -> L53
    L50:
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L53
        goto L51
    L49:
        r9.release();     // Catch: Throwable -> L53
        goto L50
    L53:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L41:
        e = e;
        r9 = null;
    L39:
        th = th;
        r6 = 0;
    L70:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L66
        if (r6 != 0) goto L60;
    L64:
        Result.constructor-impl(r8);     // Catch: Throwable -> L66
    L68:
        throw th;
    L60:
        if (Build.VERSION.SDK_INT < 24) goto L62;
        r6.close();     // Catch: Throwable -> L66
    L63:
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L66
        goto L64
    L62:
        r6.release();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L56:
        th = th;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean c(long r13, boolean r15) {
        boolean r3 = false;
        if (r13 != 0) goto L63;
        return false;
    L63:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(Boolean.valueOf(ObricEnrollInteropDelegate.b.d()));     // Catch: Throwable -> L7
    L9:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L12;
        FLogger.a.e("SidAuthSessionService", "isCurrentSessionFromBreathWakeup failed: " + r4.getMessage());
    L12:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L16;
        r2 = r5;
    L16:
        if (((Boolean) r2).booleanValue() == false) goto L61;
        FLogger.a.i("SidAuthSessionService", "onSessionStart skip: breath wakeup wkrId=" + r13);
        return false;
    L61:
        Object r6 = Result.constructor-impl(Boolean.valueOf(t1.a.isBypassAdaptiveSid()));     // Catch: Throwable -> L21
    L23:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L26;
        FLogger.a.e("SidAuthSessionService", "isBypassAdaptiveSid failed: " + r7.getMessage());
    L26:
        Boolean r8 = Boolean.TRUE;
        if (Result.isFailure-impl(r6) == false) goto L29;
        r6 = r8;
    L29:
        boolean r9 = ((Boolean) r6).booleanValue();
        nia.a.a.getClass();     // Catch: Throwable -> L32
        Object r10 = Result.constructor-impl(Boolean.valueOf(nia.a.l().f));     // Catch: Throwable -> L32
    L34:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L37;
        FLogger.a.e("SidAuthSessionService", "isAuthReady failed: " + r11.getMessage());
    L37:
        Boolean r12 = Boolean.FALSE;
        if (Result.isFailure-impl(r10) == false) goto L40;
        r10 = r12;
    L40:
        boolean r14 = ((Boolean) r10).booleanValue();
        if (r9 == true) goto L43;
        if (r14 == false) goto L43;
    L44:
        Object r16 = g;
        monitor-enter(r16);
        a.getClass();     // Catch: Throwable -> L55
        i(true);     // Catch: Throwable -> L55
        d = r13;     // Catch: Throwable -> L55
        f = r3;     // Catch: Throwable -> L55
        if (r3 == false) goto L51;
        FLogger.a.i("SidAuthSessionService", "onSessionStart bypass adaptive sid, wkrId=" + r13 + " isContinuousTalk=" + r15 + " bypass=" + r9 + " authReady=" + r14);     // Catch: Throwable -> L55
        monitor-exit(r16);
        return true;
    L51:
        h = new ByteArrayOutputStream();     // Catch: Throwable -> L55
        e = true;     // Catch: Throwable -> L55
        j = r15;     // Catch: Throwable -> L55
        k = null;     // Catch: Throwable -> L55
        i = BuildersKt.launch$default(c, null, null, new startCacheTimeoutJob.1(r13, null), 3, null);     // Catch: Throwable -> L55
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r16);
        FLogger.a.i("SidAuthSessionService", "onSessionStart wkrId=" + r13 + " isContinuousTalk=" + r15);
        return true;
    L55:
        th = move-exception;
        throw th;
    L43:
        r3 = true;
    L32:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static a f(SidAuthService r5, byte[] r6, String r7) {
        SAMICoreSidAuthRequest r1 = new SAMICoreSidAuthRequest();
        r1.testAudio = r6;
        r1.threshold = 2.0d;
        SAMICoreSidAuthResult r8 = new SAMICoreSidAuthResult();
        int r9 = r5.auth(r1, r8);     // Catch: Throwable -> L9
        if (r9 == 0) goto L8;
        FLogger.a.e("SidAuthSessionService", "SidAuth auth failed attempt=" + r7 + " ret=" + r9);
        return new a(r9, null, "auth ret=" + r9 + " attempt=" + r7, 2);
    L8:
        return new a(r9, r8, null, 4);
    L9:
        th = move-exception;
        FLogger.a.e("SidAuthSessionService", "SidAuth auth exception attempt=" + r7 + ": " + th.getMessage());
        return new a(IntCompanionObject.MIN_VALUE, null, "auth exception attempt=".concat(r7), 2);
    }

    public static void n(long r2, String r4, int r5) {
        String r6 = c.a(r4, r5);
        if (r5 != 220014) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        m.a.getClass();
        m.a();
        FLogger.a.i("SidAuthSessionService", "SidAuth register audio unavailable, dispatch save=0 wkrId=" + r2 + " reason=" + r6);
    L8:
        m(r2, r6);
        return;
    L5:
        r7 = false;
        goto L6
    }
}
