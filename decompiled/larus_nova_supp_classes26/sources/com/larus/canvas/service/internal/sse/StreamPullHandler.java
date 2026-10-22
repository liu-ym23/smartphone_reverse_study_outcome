package com.larus.canvas.service.internal.sse;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class StreamPullHandler {
    public static final int k = 0;
    public final String a;
    public final Object b;
    public final CoroutineScope c;
    public Job d;
    public boolean e;
    public int f;
    public final long g;
    public long h;
    public int i;
    public final g j;

    public static final class a {
    }

    static {
        k = z2.a.getCreationCanvasClientConfig().b;
    }

    public final void a() {
        this.h = System.currentTimeMillis();
        this.i = 0;
        this.d = BuildersKt.launch$default(this.c, null, null, new StreamPullHandler$startChunkPull$1(this, null), 3, null);
    }

    public StreamPullHandler(Object r3, CanvasChunkReceiver r4) {
        Intrinsics.checkNotNullParameter("/creativity/canvas/generate", MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r3, "uplink");
        Intrinsics.checkNotNullParameter(r4, "dispatcher");
        this.a = "/creativity/canvas/generate";
        this.b = r3;
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f = k;
        this.g = 2000;
        this.j = new g(r4, this);
    }
}
