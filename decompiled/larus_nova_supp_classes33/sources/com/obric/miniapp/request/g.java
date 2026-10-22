package com.obric.miniapp.request;

import com.google.gson.JsonObject;
import d3.w;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public int a;

    public static final class a {
    }

    static {
    }

    public g() {
        this.a = 2;
    }

    public static final void a(final g r9, final w r10, final long r11, final CompletableDeferred r13) {
        r9.getClass();
        JsonObject r0 = new JsonObject();
        r0.addProperty("date", Long.valueOf(r11));
        Unit r1 = Unit.INSTANCE;
        r10.i("applet.queryHolidays", r0, new QueryDayTypeRequest$executeFunction$2(r13), new QueryDayTypeRequest$executeFunction$3(r9, r10, r11, r13));
    }
}
