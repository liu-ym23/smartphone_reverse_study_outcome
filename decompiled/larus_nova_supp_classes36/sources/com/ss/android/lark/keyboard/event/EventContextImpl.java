package com.ss.android.lark.keyboard.event;

import android.util.SparseArray;
import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EventContextImpl implements g, h {
    public static final Factory c = null;
    public com.ss.android.lark.keyboard.b a;
    public final SparseArray<Object> b;

    public static final class Factory extends s<EventContextImpl> {
        public Factory() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    static {
        c = new Factory();
    }

    @Override // com.ss.android.lark.keyboard.event.g
    public final Object getValue() {
        d r0 = com.ss.android.lark.keyboard.base.f.a.b;
        Intrinsics.checkNotNullParameter(r0, TabAppInfo.IMAGE_JSON_KEY);
        SparseArray<Object> r1 = this.b;
        int r2 = r0.hashCode();
        return r1.get(r2 ^ (r2 >>> 16));
    }

    @Override // com.ss.android.lark.keyboard.event.g
    public final com.ss.android.lark.keyboard.b n() {
        com.ss.android.lark.keyboard.b r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public EventContextImpl() {
        this.b = new SparseArray();
    }

    @Override // com.ss.android.lark.keyboard.event.h
    public final void a(Object r3) {
        Intrinsics.checkNotNullParameter(com.ss.android.lark.keyboard.base.f.a.b, "$receiver");
        b(r3);
    }

    public final void b(Object r4) {
        d r0 = com.ss.android.lark.keyboard.base.f.a.b;
        Intrinsics.checkNotNullParameter(r0, TabAppInfo.IMAGE_JSON_KEY);
        SparseArray<Object> r1 = this.b;
        int r2 = r0.hashCode();
        r1.put(r2 ^ (r2 >>> 16), r4);
    }
}
