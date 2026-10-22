package com.lynx.tasm;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxViewClientV2 implements y7a.a {

    public static class LynxPipelineInfo {

        public static final enum LynxPipelineOrigin extends Enum<LynxPipelineOrigin> {
            public static final LynxPipelineOrigin LYNX_FIRST_SCREEN = null;
            public static final LynxPipelineOrigin LYNX_RELOAD = null;
            public static final /* synthetic */ LynxPipelineOrigin[] a = null;
            private final int origin;

            static {
                LynxPipelineOrigin r0 = new LynxPipelineOrigin("LYNX_FIRST_SCREEN", 0, 1);
                LYNX_FIRST_SCREEN = r0;
                LynxPipelineOrigin r1 = new LynxPipelineOrigin("LYNX_RELOAD", 1, 2);
                LYNX_RELOAD = r1;
                a = new LynxPipelineOrigin[]{r0, r1};
            }

            public static LynxPipelineOrigin[] values() {
                return (LynxPipelineOrigin[]) a.clone();
            }

            public int getValue() {
                return this.origin;
            }

            public static LynxPipelineOrigin valueOf(String r1) {
                return (LynxPipelineOrigin) r27.a.a(LynxPipelineOrigin.class, r1);
            }

            public LynxPipelineOrigin(String r1, int r2, int r3) {
                super(r1, r2);
                this.origin = r3;
            }
        }

        public LynxPipelineInfo() {
        }
    }

    public static class a {
    }

    public LynxViewClientV2() {
    }

    public void a(JSONObject r1) {
    }

    public void b(LynxView r1, LynxPipelineInfo r2) {
    }

    public void c() {
    }

    @Override // y7a.a
    public void onPerformanceEvent(b8a.l r1) {
    }
}
