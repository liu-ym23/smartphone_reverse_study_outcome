package com.larus.audio.call.tracer;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.call.f;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AudioFileSaver {
    public final String a;
    public final boolean b;
    public final String c;
    public final Map<String, FileOutputStream> d;
    public final Map<String, File> e;
    public final Map<String, Long> f;
    public final Set<String> g;
    public Long h;
    public final String i;
    public final ExecutorCoroutineDispatcher j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    public final String e() {
        if (this.b == false) goto L6;
        return f.d().c.e;
    L6:
        return f.d().c.c;
    }

    public final void i() {
        g(new AudioFileSaver$release$1(this, null));
    }

    public static long d(File r11) {
        long r1 = 0;
        if (r11.isDirectory() == true) goto L5;
        return 0;
    L5:
        File[] r12 = r11.listFiles();
        int r0 = 0;
        if (r12 != null) goto L8;
        r12 = new File[0];
    L8:
        int r3 = r12.length;
    L9:
        if (r0 >= r3) goto L19;
        File r4 = r12[r0];
        if (r4.isDirectory() == false) goto L13;
        Intrinsics.checkNotNull(r4);
        long r5 = d(r4);
    L15:
        if (r5 <= (Long.MAX_VALUE - r1)) goto L17;
        r1 = Long.MAX_VALUE;
    L18:
        r0 = r0 + 1;
        goto L9
    L17:
        r1 = r1 + r5;
        goto L18
    L13:
        r5 = r4.length();
        goto L15
    L19:
        return r1;
    }

    public final void g(Function2 r8) {
        BuildersKt.launch$default((CoroutineScope) this.k.getValue(), null, null, r8, 3, null);
    }

    public AudioFileSaver(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.a = r2;
        this.b = r3;
        this.c = "AudioFileSaver";
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashSet();
        this.i = f.d().c.d;
        Intrinsics.checkNotNullParameter("avkit#dump", "name");
        this.j = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new q68.e("avkit#dump")));
        this.k = LazyKt.lazy(new com.larus.audio.call.tracer.a(this));
    }

    public static boolean f(File r4, PolarisFileWrapper r5) {
        return StringsKt.startsWith$default(r4.getAbsolutePath(), StringsKt.trimEnd(r5.getAbsolutePath(), new char[]{File.separatorChar}) + File.separator, false, 2, null);
    }

    public final void h(String r4, String r5) {
        if (this.g.add(r5 + ':' + r4) == false) goto L6;
        com.larus.audio.call.util.e.a.w(this.c, "skip audio dump because " + r5 + " quota is reached");
        return;
    }

    public static final String b(AudioFileSaver r0, int r1, String r2) {
        r0.getClass();
        switch(r1) {
            case 0: goto L25;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            case 14: goto L32;
            case 15: goto L31;
            case 16: goto L30;
            case 17: goto L4;
            case 18: goto L29;
            case 19: goto L28;
            case 20: goto L27;
            default: goto L4;
        };
    L4:
        return null;
    L27:
        return r0.e() + File.separator + r2 + "_backtrace_record.pcm";
    L28:
        return r0.e() + File.separator + r2 + "_audio_track.pcm";
    L29:
        return r0.e() + File.separator + r2 + "_backtrace_aec_out.pcm";
    L30:
        return f.d().c.h + File.separator + r2 + "_si_play_merge.pcm";
    L31:
        return f.d().c.h + File.separator + r2 + "_si_play_right.pcm";
    L32:
        return f.d().c.h + File.separator + r2 + "_si_play_left.pcm";
    L33:
        return r0.e() + File.separator + r2 + "_opus_record_send.pcm";
    L34:
        return r0.e() + File.separator + r2 + "_first_frame.pcm";
    L35:
        return r0.i + File.separator + "stream_player_" + r2 + ".pcm";
    L36:
        return r0.e() + File.separator + r2 + "_play_processed_with_silent.pcm";
    L37:
        return r0.e() + File.separator + r2 + "_play_raw_with_silent.pcm";
    L38:
        return r0.e() + File.separator + r2 + "_play_processed.pcm";
    L39:
        return r0.e() + File.separator + r2 + "_all_tts_raw.pcm";
    L40:
        return r0.e() + File.separator + r2 + "_produce_empty.pcm";
    L41:
        return r0.e() + File.separator + r2 + "_play_raw.pcm";
    L42:
        return r0.e() + File.separator + r2 + "_ref.pcm";
    L43:
        return r0.e() + File.separator + r2 + "_all_tts.pcm";
    L44:
        return r0.e() + File.separator + r2 + "_play.pcm";
    L45:
        return r0.e() + File.separator + r2 + "_tts.pcm";
    L25:
        return r0.e() + File.separator + r2 + "_mic.pcm";
    }

    public final void j(int r8, byte[] r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        if (this.b == false) goto L5;
    L7:
        g(new AudioFileSaver$startSavingFile$1(r10, r8, this, r9, null));
        return;
    L5:
        if (c78.a.a == true) goto L7;
    }

    public final void k(int r8, byte[] r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        g(new AudioFileSaver$startSavingFileForO$1(r10, r8, this, r9, null));
    }

    public static final boolean a(AudioFileSaver r16, String r17, File r19, int r110) {
        r16.getClass();
        com.larus.audio.call.d r3 = f.d().c;
        Long r4 = (Long) ((LinkedHashMap) r16.f).get(r17);
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L6:
        boolean r6 = r16.b;
        if (r6 == true) goto L19;
        long r13 = r3.i;
        if (r13 > 0) goto L11;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L19;
        r16.h(r17, "file");
    L37:
        return false;
    L11:
        if (r13 == Long.MAX_VALUE) goto L16;
        if (r5 <= (r13 - ((long) r110))) goto L16;
        r7 = true;
    L19:
        if (r6 == false) goto L21;
    L38:
        return true;
    L21:
        if (f(r19, new PolarisFileWrapper(r16.e())) == false) goto L38;
        Long r8 = r16.h;
        if (r8 == null) goto L25;
        long r9 = r8.longValue();
    L26:
        long r11 = r3.j;
        if (r11 > 0) goto L29;
    L34:
        boolean r2 = false;
    L35:
        if (r2 == false) goto L38;
        r16.h(r17, "session");
        goto L37
    L29:
        if (r11 == Long.MAX_VALUE) goto L34;
        if (r9 <= (r11 - ((long) r110))) goto L34;
        r2 = true;
        goto L35
    L25:
        r9 = d(new PolarisFileWrapper(r16.e()));
        r16.h = Long.valueOf(r9);
        goto L26
    L5:
        r5 = r19.length();
        goto L6
    }

    public static final void c(AudioFileSaver r9, String r10, File r11, int r12) {
        Map<String, Long> r0 = r9.f;
        Long r1 = (Long) ((LinkedHashMap) r0).get(r10);
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        long r3 = r12;
        long r5 = Long.MAX_VALUE;
        if (r3 <= (Long.MAX_VALUE - r2)) goto L9;
        long r4 = Long.MAX_VALUE;
    L10:
        r0.put(r10, Long.valueOf(r4));
        if (f(r11, new PolarisFileWrapper(r9.e())) == false) goto L22;
        Long r13 = r9.h;
        if (r13 == null) goto L15;
        long r14 = r13.longValue();
    L17:
        if (r3 > (Long.MAX_VALUE - r14)) goto L20;
        r5 = r14 + r3;
    L20:
        r9.h = Long.valueOf(r5);
        return;
    L15:
        r14 = 0;
        goto L17
    L22:
        return;
    L9:
        r4 = r2 + r3;
        goto L10
    L5:
        r2 = r11.length();
        goto L6
    }
}
