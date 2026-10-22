package com.lynx.clay.embedding.engine.plugins.platformview;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import n5a.c;
import n5a.d;
import n5a.e;
import n5a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class InternalPlatformViewRegistry {
    public static final InternalPlatformViewRegistry e = null;
    public final Map<String, c> a;
    public final Map<String, c> b;
    public final Set<String> c;
    public final Set<String> d;

    public static final enum ViewDrawType extends Enum<ViewDrawType> {
        public static final ViewDrawType DRAWABLE = null;
        public static final ViewDrawType LOGICAL_ONLY = null;
        public static final /* synthetic */ ViewDrawType[] a = null;

        static {
            ViewDrawType r0 = new ViewDrawType("DRAWABLE", 0);
            DRAWABLE = r0;
            ViewDrawType r1 = new ViewDrawType("LOGICAL_ONLY", 1);
            LOGICAL_ONLY = r1;
            a = new ViewDrawType[]{r0, r1};
        }

        public static ViewDrawType[] values() {
            return (ViewDrawType[]) a.clone();
        }

        public static ViewDrawType valueOf(String r1) {
            return (ViewDrawType) r27.a.a(ViewDrawType.class, r1);
        }

        public ViewDrawType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        monitor-exit(this);
    }

    static {
        e = new InternalPlatformViewRegistry();
    }

    public InternalPlatformViewRegistry() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        new LinkedHashMap();
        new LinkedHashMap();
        this.c = new LinkedHashSet();
        this.d = new LinkedHashSet();
        b("input-view", new d());
        b("textarea-view", new e());
        b("x-input", new d());
        b("x-textarea", new e());
        b("x-map-marker-ng", new f());
    }

    public final synchronized void b(String r2, c r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r2.isEmpty() == true) goto L8;
        this.a.put(r2, r3);     // Catch: Throwable -> L10
        this.c.add(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        monitor-exit(this);
    }
}
