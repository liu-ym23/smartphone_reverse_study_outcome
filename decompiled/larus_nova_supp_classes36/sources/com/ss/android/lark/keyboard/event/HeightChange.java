package com.ss.android.lark.keyboard.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class HeightChange implements q, s.b {
    public static final Factory b = null;
    public int a;

    public static final class Factory extends s<HeightChange> {
        public Factory() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    static {
        b = new Factory();
    }

    public HeightChange() {
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return "HeightChange {" + this.a + '}';
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.lark.keyboard.event.s.b
    public final void recycle() {
        Factory r0 = b;
        if (r0.b.size() >= 3) goto L6;
        r0.b.add((T) this);
        return;
    }
}
