package com.larus.dora.impl.trace;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONArray;
import p69.c;
import p69.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final Lazy<b> f = null;
    public static final int g = 0;
    public static final int h = 0;
    public final Lazy a;
    public final ConcurrentHashMap<String, JSONArray> b;
    public String c;
    public String d;
    public final SimpleDateFormat e;

    public static final class a {
    }

    static {
        f = LazyKt.lazy(new c());
        g = 1;
        h = 2;
    }

    public b() {
        this.a = LazyKt.lazy(new e());
        this.b = new ConcurrentHashMap();
        this.e = new SimpleDateFormat("HH:mm:ss.SSS");
    }
}
