package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.ss.android.lark.log.Log;
import kotlin.UInt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final int a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        Lark_markdown_renderKt.ffiReleaseMovableDocumentForClient-WZ4Q5Ns(this.a);     // Catch: Throwable -> L11
        this.b = true;     // Catch: Throwable -> L11
        Log.d("MovableDocumentReleaseHandle", "release movable document, docId: " + UInt.toString-impl(this.a));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public d(int r1) {
        this.a = r1;
    }
}
