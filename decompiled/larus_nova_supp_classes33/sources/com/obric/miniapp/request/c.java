package com.obric.miniapp.request;

import com.google.gson.JsonObject;
import d3.w;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public int a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = 2;
    }

    public static final void a(final c r3, final w r4, final String r5, final CompletableDeferred r6) {
        r3.getClass();
        JsonObject r0 = new JsonObject();
        r0.addProperty("payload", r5);
        Unit r1 = Unit.INSTANCE;
        r4.i("applet.newMemoryRequest", r0, new NewMemoryRequest$executeFunction$2(r6), new NewMemoryRequest$executeFunction$3(r3, r4, r5, r6));
    }
}
