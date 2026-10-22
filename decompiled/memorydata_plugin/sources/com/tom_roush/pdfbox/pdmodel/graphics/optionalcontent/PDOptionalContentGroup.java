package com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent;

import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.a.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PDOptionalContentGroup extends b {

    public static final enum RenderState extends Enum<RenderState> {
        private static final /* synthetic */ RenderState[] $VALUES = null;
        public static final RenderState OFF = null;
        public static final RenderState ON = null;
        private final i name;

        static {
            RenderState r0 = new RenderState("ON", 0, i.fF);
            ON = r0;
            RenderState r1 = new RenderState("OFF", 1, i.fD);
            OFF = r1;
            $VALUES = new RenderState[]{r0, r1};
        }

        private RenderState(String r1, int r2, i r3) {
            super(r1, r2);
            this.name = r3;
        }

        public static RenderState valueOf(i r0) {
            if (r0 != null) goto L6;
            return null;
        L6:
            return valueOf(r0.a().toUpperCase());
        }

        public static RenderState valueOf(String r2) {
            return (RenderState) ZeusTransformUtils.preCheckCast(Enum.valueOf(RenderState.class, r2), RenderState.class, "com.obric.memorydata.plugin");
        }

        public static RenderState[] values() {
            return (RenderState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RenderState[].class, "com.obric.memorydata.plugin");
        }

        public i getName() {
            return this.name;
        }
    }

    public PDOptionalContentGroup(d r2) {
        super(r2);
        if (r2.l(i.iz).equals(i.fx) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Provided dictionary is not of type '" + i.fx + "'");
    }

    public String b() {
        return this.f16159a.h(i.fh);
    }

    public String toString() {
        return super.toString() + " (" + b() + ")";
    }
}
