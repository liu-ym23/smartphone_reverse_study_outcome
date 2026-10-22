package com.larus.business.debug.base.audio.module;

import android.os.Handler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TTSModule {
    public final Map<String, ByteArrayOutputStream> a;
    public final Map<String, ByteArrayOutputStream> b;
    public final TTSModule$itemMap$1 c;
    public final String d;

    public final float a() {
        int r0 = q.a;
        if (f.b == true) goto L6;
        return 0.0f;
    L6:
        return f.a().getFloat("keva_dora_force_loudness", 0.0f);
    }

    public final float b() {
        int r0 = q.a;
        if (f.b == true) goto L6;
        return 0.0f;
    L6:
        return f.a().getFloat("keva_force_loudness", 0.0f);
    }

    public final String c() {
        int r0 = q.a;
        boolean r1 = false;
        if (f.b == false) goto L6;
        r1 = f.a().getBoolean("keva_loudness_dump_open", false);
    L6:
        String r2 = null;
        if (r1 == false) goto L16;
        File r3 = AppHost.a.getApplication().getExternalFilesDir(null);
        if (r3 == null) goto L12;
        String r4 = r3.getAbsolutePath();
        if (r4 == null) goto L12;
    L13:
        StringBuilder r5 = new StringBuilder();
        r5.append(r4);
        String r6 = File.separator;
        r5.append(r6);
        r5.append("audio");
        r5.append(r6);
        r5.append("loudness");
        r5.append(r6);
        r2 = r5.toString();
        PolarisFileWrapper r7 = new PolarisFileWrapper(r2);
        if (r7.exists() == true) goto L16;
        r7.mkdirs();
    L12:
        r4 = "";
    L16:
        return r2;
    }

    public final boolean e() {
        int r0 = q.a;
        if (f.b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_force_new_algo", false);
    }

    public TTSModule() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new TTSModule$itemMap$1();
        StringBuilder r0 = new StringBuilder();
        boolean r1 = AudioDebugUtil.a;
        r0.append(AudioDebugUtil.b);
        r0.append(File.separator);
        r0.append("tts_info.log");
        this.d = r0.toString();
    }

    public final a68.c d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        return (a68.c) this.c.get(r2);
    }

    public final void g(final z58.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        boolean r0 = AudioDebugUtil.a;
        Handler r1 = AudioDebugUtil.l;
        if (r1 == null) goto L8;
        r1.post(new z(r3, this));
        return;
    }

    public final void j(String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (AudioDebugUtil.a == false) goto L8;
        this.a.put(r3, new ByteArrayOutputStream());
        return;
    }

    public final void f(String r2, byte[] r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (AudioDebugUtil.a == false) goto L10;
        ByteArrayOutputStream r4 = (ByteArrayOutputStream) ((LinkedHashMap) this.a).get(r2);
        if (r4 == null) goto L11;
        r4.write(r3);
        return;
    L11:
        return;
    }

    public final void h(String r3, byte[] r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (AudioDebugUtil.a == true) goto L8;
        return;
    L8:
        if (this.b.containsKey(r3) == true) goto L10;
        this.b.put(r3, new ByteArrayOutputStream());
    L10:
        ByteArrayOutputStream r5 = (ByteArrayOutputStream) ((LinkedHashMap) this.b).get(r3);
        if (r5 == null) goto L14;
        r5.write(r4);
        return;
    }

    public final void i(final String r3, final String r4) {
        boolean r0 = AudioDebugUtil.a;
        if (AudioDebugUtil.a == true) goto L5;
        return;
    L5:
        Handler r1 = AudioDebugUtil.l;
        if (r1 == null) goto L9;
        r1.post(new y(this, r3, r4));
        return;
    }
}
