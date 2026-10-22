package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.live.liveinteract.voicechat.radio.asr.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c<T extends g> {
    public final AtomicInteger a;
    public final SpeechEngine b;
    public volatile boolean c;
    public T d;
    public final String e;

    public static final class a {
    }

    static {
    }

    public c() {
        Intrinsics.checkNotNullParameter("AsrEngine", "name");
        this.e = "AsrEngine";
        this.a = new AtomicInteger(0);
        this.b = SpeechEngineGenerator.getInstance();
    }

    public final boolean b() {
        int r0 = this.a.get();
        if (r0 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 3) goto L8;
        return false;
    }

    public static PolarisFileWrapper a(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        PolarisFileWrapper r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        File r2 = jc1.a.b().getFilesDir();
        if (r2 != null) goto L14;
        return null;
    L14:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2, r3);
        if (r4.exists() == true) goto L24;
        r4.mkdir();     // Catch: Exception -> L21
        r1 = r4;
    L20:
        return r1;
    L24:
        return r4;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        int r0 = x8.a.a;
        x8.a.d("MultiLinkAsrEngine", this.e + ": " + r3, false);
    }

    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        int r0 = x8.a.a;
        x8.a.b("MultiLinkAsrEngine", this.e + ": " + r3, false);
    }
}
