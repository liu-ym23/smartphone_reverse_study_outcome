package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Callable<FlutterLoader.b> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ FlutterLoader c;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public FlutterLoader.b call() {
        FlutterLoader r0 = this.c;
        return FlutterLoader.d(this.a, r0.e, this.b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ FlutterLoader.b call() throws Exception {
        return call();
    }

    public c(FlutterLoader r1, Context r2, JSONObject r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
