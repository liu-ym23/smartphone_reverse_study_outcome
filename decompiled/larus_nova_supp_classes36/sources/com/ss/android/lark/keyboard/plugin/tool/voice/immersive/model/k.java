package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.android.lark.audio.voiceinput.perf.VoiceInputAppreciablePerformance;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public final fwa.b a;
    public final b b;
    public boolean c;

    public static final class a {
    }

    public static final class b {
        public int a;
        public VoiceInputAppreciablePerformance.b b;
        public final List<Pair<String, Long>> c;

        public b() {
            this.b = new VoiceInputAppreciablePerformance.b();
            this.c = new ArrayList();
        }
    }

    static {
    }

    public final void a() {
        fwa.b r0 = this.a;
        b r1 = this.b;
        r1.getClass();
        StringBuilder r2 = new StringBuilder();
        Iterator r3 = ((ArrayList) r1.c).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Pair r4 = (Pair) r3.next();
        r2.append("(" + ((String) r4.getFirst()) + ',' + ((Number) r4.getSecond()).longValue() + ')');
        goto L4
    L6:
        ((ArrayList) r1.c).clear();
        r1.b.c();
        VoiceInputAppreciablePerformance.c r5 = r0.a("behavior_review", r2.toString());
        r5.a("is_recognize_again", Integer.valueOf(this.c ? 1 : 0));
        int r6 = AudioAsrLanguageSwitcher.i;
        r5.a("language", AudioAsrLanguageSwitcher.a.a());
        b r7 = this.b;
        ((ArrayList) r7.c).clear();
        r7.b.c();
        r7.a = 0;
        this.c = false;
    }

    public k(VoiceInputAppreciablePerformance.c r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceInputEventTracker");
        this.a = r2;
        this.b = new b();
    }
}
