package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a {
    public volatile int a;
    public b b;
    public String c;

    public a() {
    }

    public final synchronized int a() {
        monitor-enter(this);
        this.a++;     // Catch: Throwable -> L6
        int r0 = this.a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void e() {
        this.a = 0;
        this.c = "";
    }

    public final boolean b() {
        b r0 = this.b;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.a != null) goto L7;
        return true;
    L7:
        if (r0.b == null) goto L29;
        String r2 = r0.c;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L30;
        String r1 = r0.d;
        if (r1 != null) goto L19;
    L22:
        boolean r4 = true;
    L23:
        if (r4 == true) goto L31;
        return false;
    L31:
        return true;
    L19:
        if (r1.length() == 0) goto L22;
        r4 = false;
        goto L23
    L30:
        return true;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    L29:
        return true;
    }

    public boolean c(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "strFileName");
        Intrinsics.checkNotNullParameter(r3, "cid");
        b r5 = this.b;
        if (r5 == null) goto L6;
        r5.e = r4;
    L6:
        if (b() == false) goto L9;
        Log.w("AudioRecordDataProcessor", "[onAudioRecorded] mAudioMessage is null");
        return false;
    L9:
        return true;
    }

    public void d(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "strFileName");
        Intrinsics.checkNotNullParameter(r3, "cid");
        Log.d("AudioRecordDataProcessor", "[onStartRecord]:" + r2 + '/' + r3);
    }
}
