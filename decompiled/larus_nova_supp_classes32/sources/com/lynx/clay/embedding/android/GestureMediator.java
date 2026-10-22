package com.lynx.clay.embedding.android;

import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.lynx.clay.embedding.engine.FlutterEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class GestureMediator {
    public final FlutterView a;
    public final FlutterEngine b;
    public final b c;
    public VelocityTracker d;
    public boolean e;
    public final int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public GestureMediateState p;
    public boolean q;

    public static final enum GestureMediateState extends Enum<GestureMediateState> {
        public static final GestureMediateState BLOCKING_MEDIATING = null;
        public static final GestureMediateState IDLE = null;
        public static final GestureMediateState INNER_WIN = null;
        public static final GestureMediateState MEDIATING = null;
        public static final GestureMediateState OUTER_WIN = null;
        public static final /* synthetic */ GestureMediateState[] a = null;

        static {
            GestureMediateState r0 = new GestureMediateState("IDLE", 0);
            IDLE = r0;
            GestureMediateState r1 = new GestureMediateState("MEDIATING", 1);
            MEDIATING = r1;
            GestureMediateState r3 = new GestureMediateState("BLOCKING_MEDIATING", 2);
            BLOCKING_MEDIATING = r3;
            GestureMediateState r5 = new GestureMediateState("INNER_WIN", 3);
            INNER_WIN = r5;
            GestureMediateState r7 = new GestureMediateState("OUTER_WIN", 4);
            OUTER_WIN = r7;
            a = new GestureMediateState[]{r0, r1, r3, r5, r7};
        }

        public static GestureMediateState[] values() {
            return (GestureMediateState[]) a.clone();
        }

        public static GestureMediateState valueOf(String r1) {
            return (GestureMediateState) r27.a.a(GestureMediateState.class, r1);
        }

        public GestureMediateState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureMediateState.values().length];
            a = r0;
            r0[GestureMediateState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[GestureMediateState.MEDIATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[GestureMediateState.OUTER_WIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[GestureMediateState.INNER_WIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[GestureMediateState.BLOCKING_MEDIATING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final void a(GestureMediateState r3) {
        if (this.p != r3) goto L5;
        return;
    L5:
        this.p = r3;
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L8;
    L17:
        this.a.getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L8:
        if (r4 == 2) goto L17;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L14;
    L16:
        this.a.getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L14:
        if (r4 == 5) goto L16;
    }

    public GestureMediator(FlutterView r3, FlutterEngine r4, b r5) {
        this.e = false;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.n = 0;
        this.o = 0;
        this.p = GestureMediateState.IDLE;
        this.q = false;
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.f = ViewConfiguration.get(r3.getContext()).getScaledTouchSlop();
    }
}
