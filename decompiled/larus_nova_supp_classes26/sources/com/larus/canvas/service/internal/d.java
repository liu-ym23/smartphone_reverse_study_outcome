package com.larus.canvas.service.internal;

import com.larus.canvas.service.internal.sse.CanvasChunkReceiver;
import com.larus.canvas.service.internal.sse.StreamPullHandler;
import com.larus.canvas.service.internal.sse.f;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import ny8.j;
import ny8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends c<Unit> {
    public final k d;
    public final String e;
    public final StreamPullHandler f;
    public final a g;

    public static final class a implements j {
        public final /* synthetic */ d a;

        @Override // ny8.j
        public final void cancel() {
            StreamPullHandler r0 = this.a.f;
            Job r1 = r0.d;
            if (r1 != null) goto L5;
        L7:
            boolean r2 = false;
        L9:
            if (r2 == false) goto L15;
            Job r3 = r0.d;
            if (r3 == null) goto L13;
            Job.DefaultImpls.cancel$default(r3, null, 1, null);
        L13:
            r0.d = null;
        L15:
            if (r0.e == true) goto L18;
            r0.j.a(new f(2, null, 14));
            return;
        L18:
            return;
        L5:
            if (r1.isActive() != true) goto L7;
            r2 = true;
            goto L9
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    public d(k r5, ny8.c r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        super(null);
        this.d = r5;
        this.e = "PullCanvasBlockInfoProcessor";
        this.f = new StreamPullHandler(r5, new CanvasChunkReceiver(r5.a, r6, (CoroutineScope) this.c.getValue()));
        this.g = new a(this);
    }
}
