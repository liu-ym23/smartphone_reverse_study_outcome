package com.obric.miniapp.intent;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v {
    public static final v a = null;
    public static final Object b = null;
    public static final t c = null;
    public static IAgentAppIntentIDL d;
    public static MusicOperation$createStateListener$1 e;
    public static long f;
    public static Bundle g;

    public static final class a {
        public final boolean a;
        public final JSONObject b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "QueryResult(success=" + this.a + ", content=" + this.b + ", errorCode=" + this.c + ", errorMessage=" + this.d + ')';
        }

        public a(boolean r3, JSONObject r4, String r5, String r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = new JSONObject();
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = "";
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = "";
        L11:
            Intrinsics.checkNotNullParameter(r4, "content");
            Intrinsics.checkNotNullParameter(r5, "errorCode");
            Intrinsics.checkNotNullParameter(r6, "errorMessage");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public v() {
    }

    static {
        a = new v();
        b = new Object();
        c = new t();
        g = new Bundle();
    }

    public static boolean a(IAgentAppIntentIDL r10) {
        Object r0 = b;
        monitor-enter(r0);
        IAgentAppIntentIDL r1 = d;     // Catch: Throwable -> L51
        if (r1 == null) goto L7;
        IBinder r2 = r1.asBinder();     // Catch: Throwable -> L51
    L9:
        if (r2 == r10.asBinder()) goto L11;
    L15:
        IAgentAppIntentIDL r3 = d;     // Catch: Throwable -> L51
        MusicOperation$createStateListener$1 r4 = e;     // Catch: Throwable -> L51
        f++;     // Catch: Throwable -> L51
        d = null;     // Catch: Throwable -> L51
        e = null;     // Catch: Throwable -> L51
        g = new Bundle();     // Catch: Throwable -> L51
        c.a(null);     // Catch: Throwable -> L51
        Triple r5 = new Triple(r3, r4, Long.valueOf(f));     // Catch: Throwable -> L51
        monitor-exit(r0);
        IAgentAppIntentIDL r6 = (IAgentAppIntentIDL) r5.component1();
        IMusicStateListenerIDL r7 = (IMusicStateListenerIDL) r5.component2();
        final long r8 = ((Number) r5.component3()).longValue();
        if (r6 == null) goto L24;
        if (r7 == null) goto L24;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L22
        r6.unregisterMusicStateListener(r7);     // Catch: Throwable -> L22
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        IMusicStateListenerIDL r12 = new MusicOperation$createStateListener$1(r8);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L33
        r10.registerMusicStateListener(r12);     // Catch: Throwable -> L33
        Object r14 = b;     // Catch: Throwable -> L33
        monitor-enter(r14);     // Catch: Throwable -> L33
        d = r10;     // Catch: Throwable -> L30
        e = r12;     // Catch: Throwable -> L30
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r14);     // Catch: Throwable -> L33
        Object r16 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L33
    L36:
        if (Result.exceptionOrNull-impl(r16) == null) goto L47;
        Object r17 = b;
        monitor-enter(r17);
        long r18 = f;     // Catch: Throwable -> L48
        if (r18 != r8) goto L43;
        f = r18 + 1;     // Catch: Throwable -> L48
        d = null;     // Catch: Throwable -> L48
        e = null;     // Catch: Throwable -> L48
        g = new Bundle();     // Catch: Throwable -> L48
        c.a(null);     // Catch: Throwable -> L48
    L43:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(r17);
        r16 = Boolean.FALSE;
    L48:
        th = move-exception;
        throw th;
    L47:
        return ((Boolean) r16).booleanValue();
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L11:
        if (e == null) goto L15;
        monitor-exit(r0);
        return true;
    L7:
        r2 = null;
    L51:
        th = move-exception;
        throw th;
    }

    public static String b(Bundle r5) {
        Long r6 = Long.valueOf(r5.getLong("id", 0));
        if (r6.longValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        String r1 = null;
        if (r0 == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L12;
        r1 = r6.toString();
    L12:
        if (r1 != null) goto L15;
        return "";
    L15:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static MusicEntity[] c(JSONArray r6) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        int r2 = r6.length();     // Catch: Throwable -> L17
        MusicEntity[] r3 = new MusicEntity[r2];     // Catch: Throwable -> L17
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L15;
        JSONObject r5 = r6.optJSONObject(r4);     // Catch: Throwable -> L17
        if (r5 == null) goto L13;
        zda.a.a.getClass();     // Catch: Throwable -> L17
        AppEntity r7 = zda.a.d(r5);     // Catch: Throwable -> L17
        if ((r7 instanceof MusicEntity) == false) goto L11;
        MusicEntity r8 = (MusicEntity) r7;     // Catch: Throwable -> L17
    L12:
        if (r8 == null) goto L13;
        r3[r4] = r8;     // Catch: Throwable -> L17
        r4 = r4 + 1;     // Catch: Throwable -> L17
        goto L4
    L11:
        r8 = null;
    L13:
        r3 = null;
    L15:
        Object r9 = Result.constructor-impl(r3);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r9) == true) goto L24;
        r0 = r9;
    L24:
        return (MusicEntity[]) r0;
    L17:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public final synchronized k d(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "cardId");     // Catch: Throwable -> L30
        if (StringsKt.isBlank(r5) == false) goto L9;
        int r6 = k.d;     // Catch: Throwable -> L30
        k r7 = k.a.a("MISSING_CARD_ID", "mixture_card_id is required");     // Catch: Throwable -> L30
        monitor-exit(this);
        return r7;
    L9:
        IAgentAppIntentIDL r1 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L30
        if (r1 != null) goto L15;
        int r8 = k.d;     // Catch: Throwable -> L30
        k r9 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");     // Catch: Throwable -> L30
        monitor-exit(this);
        return r9;
    L15:
        if (a(r1) == true) goto L19;
        int r10 = k.d;     // Catch: Throwable -> L30
        k r11 = k.a.a("MUSIC_STATE_UNAVAILABLE", "music state listener is unavailable");     // Catch: Throwable -> L30
        monitor-exit(this);
        return r11;
    L19:
        t r2 = c;     // Catch: Throwable -> L30
        if (r2.b(r5) == true) goto L24;
        int r12 = k.d;     // Catch: Throwable -> L30
        k r13 = k.a.a("NOT_PLAYBACK_OWNER", "the card does not own music playback");     // Catch: Throwable -> L30
        monitor-exit(this);
        return r13;
    L24:
        int r3 = r1.pauseMusic();     // Catch: Throwable -> L30
        if (r3 != 0) goto L27;
        r2.a(r5);     // Catch: Throwable -> L30
        int r14 = k.d;     // Catch: Throwable -> L30
        k r15 = k.a.b();     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return r15;
    L27:
        int r16 = k.d;     // Catch: Throwable -> L30
        r15 = k.a.a("PAUSE_MUSIC_FAILED", "pause music failed: " + r3);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final synchronized a f(String r18) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r18, "cardId");     // Catch: Throwable -> L49
        if (StringsKt.isBlank(r18) == false) goto L8;
        a r0 = new a(false, null, "MISSING_CARD_ID", "mixture_card_id is required", 2);     // Catch: Throwable -> L49
        monitor-exit(this);
        return r0;
    L8:
        IAgentAppIntentIDL r1 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L49
        if (r1 != null) goto L14;
        a r2 = new a(false, null, "AIAGENT_UNAVAILABLE", "aiagent service is unavailable", 2);     // Catch: Throwable -> L49
        monitor-exit(this);
        return r2;
    L14:
        if (a(r1) == true) goto L18;
        a r3 = new a(false, null, "MUSIC_STATE_UNAVAILABLE", "music state listener is unavailable", 2);     // Catch: Throwable -> L49
        monitor-exit(this);
        return r3;
    L18:
        long r7 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L49
        Object r9 = b;     // Catch: Throwable -> L49
        monitor-enter(r9);     // Catch: Throwable -> L49
        Bundle r4 = new Bundle(g);     // Catch: Throwable -> L46
        t r5 = c;     // Catch: Throwable -> L46
        a.getClass();     // Catch: Throwable -> L46
        boolean r10 = false;
        Pair r6 = TuplesKt.to(r4, r5.f(r18, b(r4), r4.getBoolean("isPlaying", false), r7));     // Catch: Throwable -> L46
        monitor-exit(r9);     // Catch: Throwable -> L49
        Bundle r8 = (Bundle) r6.component1();     // Catch: Throwable -> L49
        t.b r11 = (t.b) r6.component2();     // Catch: Throwable -> L49
        boolean r12 = r8.containsKey("isPlaying");     // Catch: Throwable -> L49
        boolean r13 = r8.getBoolean("isPlaying", false);     // Catch: Throwable -> L49
        String r14 = b(r8);     // Catch: Throwable -> L49
        if (r11.b == false) goto L34;
        if (r13 == false) goto L34;
        if (Intrinsics.areEqual(r11.c, r14) == false) goto L34;
        int r15 = r8.getInt("total_time", 0);     // Catch: Throwable -> L49
        int r16 = r8.getInt("current_time", 0);     // Catch: Throwable -> L49
        long r17 = 0;
        long r19 = r8.getLong("music_info_update_time", 0);     // Catch: Throwable -> L49
        if (r15 <= 0) goto L34;
        if (r19 <= 0) goto L33;
        r17 = RangesKt.coerceAtLeast(r7 - r19, 0);     // Catch: Throwable -> L49
    L33:
        int r20 = (int) RangesKt.coerceIn(((((long) RangesKt.coerceAtLeast(r16, 0)) + r17) * 100) / ((long) r15), 0, 100);     // Catch: Throwable -> L49
    L35:
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L49
        if (r12 == false) goto L38;
    L39:
        r10 = true;
    L40:
        r110.put("available", r10);     // Catch: Throwable -> L49
        r110.put("current_id", r11.c);     // Catch: Throwable -> L49
        String r21 = r8.getString("local_message");     // Catch: Throwable -> L49
        if (r21 != null) goto L43;
        r21 = "";
    L43:
        r110.put("local_message_id", r21);     // Catch: Throwable -> L49
        r110.put("owned_by_card", r11.a);     // Catch: Throwable -> L49
        r110.put("is_playing", r11.b);     // Catch: Throwable -> L49
        r110.put("progress", r20);     // Catch: Throwable -> L49
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L49
        a r23 = new a(true, r110, null, null, 12);     // Catch: Throwable -> L49
        monitor-exit(this);
        return r23;
    L38:
        if (r11.a == false) goto L40;
    L34:
        r20 = 0;
        goto L35
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }

    public static k e(String r2, MusicEntity[] r3, int r4, String r5) {
        IAgentAppIntentIDL r0 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r0 != null) goto L7;
        int r6 = k.d;
        return k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
    L7:
        if (a(r0) == true) goto L40;
        int r7 = k.d;
        return k.a.a("MUSIC_STATE_UNAVAILABLE", "music state listener is unavailable");
    L40:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r8 = Result.constructor-impl(Integer.valueOf(r0.playMusic(r5, r3, r3[r4])));     // Catch: Throwable -> L12
    L14:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 != null) goto L35;
        int r10 = ((Number) r8).intValue();
        if (r10 != 0) goto L33;
        t r11 = c;
        String r12 = r3[r4].getId();
        long r13 = SystemClock.elapsedRealtime();
        monitor-enter(r11);
        Intrinsics.checkNotNullParameter(r2, "cardId");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r12, "musicId");     // Catch: Throwable -> L30
        if (StringsKt.isBlank(r2) == false) goto L23;
    L28:
        monitor-exit(r11);
    L29:
        int r14 = k.d;
        return k.a.b();
    L23:
        if (StringsKt.isBlank(r12) == true) goto L28;
        r11.e = r2;     // Catch: Throwable -> L30
        r11.f = r12;     // Catch: Throwable -> L30
        r11.g = r13 + r11.a;     // Catch: Throwable -> L30
        r11.e(r2);     // Catch: Throwable -> L30
        monitor-exit(r11);
    L30:
        th = move-exception;
        throw th;
    L33:
        int r15 = k.d;
        return k.a.a("PLAY_MUSIC_FAILED", "play music failed: " + r10);
    L35:
        int r16 = k.d;
        String r17 = r9.getMessage();
        if (r17 != null) goto L39;
        r17 = "play music IPC failed";
    L39:
        return k.a.a("PLAY_MUSIC_FAILED", r17);
    L12:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
