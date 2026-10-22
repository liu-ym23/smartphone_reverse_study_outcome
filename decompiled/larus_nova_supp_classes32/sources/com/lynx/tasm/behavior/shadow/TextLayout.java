package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxUIOwner;
import y6a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TextLayout {
    public final p a;

    public class a implements p {
        public final /* synthetic */ LynxUIOwner a;

        public a(LynxUIOwner r1) {
            this.a = r1;
        }

        @Override // y6a.p
        public final float[] c(int r2) {
            return this.a.align(r2);
        }

        @Override // y6a.p
        public final void b(int r2, ReadableCompactArrayBuffer r3) {
            this.a.dispatchLayoutBefore(r2, r3);
        }

        @Override // y6a.p
        public final float[] a(int r8, float r9, int r10, float r11, int r12, float[] r13) {
            return this.a.measureText(r8, r9, r10, r11, r12, r13);
        }
    }

    public TextLayout(LynxUIOwner r2) {
        this.a = new a(r2);
    }

    public float[] align(int r3) {
        TraceEvent.beginSection("TextLayout.align");
        float[] r4 = this.a.c(r3);
        TraceEvent.endSection("TextLayout.align");
        return r4;
    }

    public TextLayout(p r1) {
        this.a = r1;
    }

    public void dispatchLayoutBefore(int r3, ReadableCompactArrayBuffer r4) {
        TraceEvent.beginSection("TextLayout.dispatchLayoutBefore");
        this.a.b(r3, r4);
        TraceEvent.endSection("TextLayout.dispatchLayoutBefore");
    }

    public float[] measureText(int r9, float r10, int r11, float r12, int r13, float[] r14) {
        TraceEvent.beginSection("TextLayout.measureText");
        float[] r15 = this.a.a(r9, r10, r11, r12, r13, r14);
        TraceEvent.endSection("TextLayout.measureText");
        return r15;
    }
}
