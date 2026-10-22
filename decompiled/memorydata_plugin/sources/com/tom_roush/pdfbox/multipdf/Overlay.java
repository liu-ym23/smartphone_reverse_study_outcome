package com.tom_roush.pdfbox.multipdf;

import com.tom_roush.pdfbox.pdmodel.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class Overlay implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<c> f16124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, Object> f16125b;
    private c c;
    private c d;
    private c e;
    private c f;
    private c g;
    private c h;

    public static final enum Position extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES = null;
        public static final Position BACKGROUND = null;
        public static final Position FOREGROUND = null;

        static {
            Position r0 = new Position("FOREGROUND", 0);
            FOREGROUND = r0;
            Position r1 = new Position("BACKGROUND", 1);
            BACKGROUND = r1;
            $VALUES = new Position[]{r0, r1};
        }

        private Position(String r1, int r2) {
            super(r1, r2);
        }

        public static Position valueOf(String r2) {
            return (Position) ZeusTransformUtils.preCheckCast(Enum.valueOf(Position.class, r2), Position.class, "com.obric.memorydata.plugin");
        }

        public static Position[] values() {
            return (Position[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Position[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c r0 = this.c;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        c r1 = this.d;
        if (r1 == null) goto L8;
        r1.close();
    L8:
        c r2 = this.e;
        if (r2 == null) goto L11;
        r2.close();
    L11:
        c r3 = this.f;
        if (r3 == null) goto L14;
        r3.close();
    L14:
        c r4 = this.g;
        if (r4 == null) goto L17;
        r4.close();
    L17:
        c r5 = this.h;
        if (r5 == null) goto L20;
        r5.close();
    L20:
        Iterator<c> r6 = this.f16124a.iterator();
    L22:
        if (r6.hasNext() == false) goto L24;
        ((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin")).close();
        goto L22
    L24:
        this.f16124a.clear();
        this.f16125b.clear();
    }
}
