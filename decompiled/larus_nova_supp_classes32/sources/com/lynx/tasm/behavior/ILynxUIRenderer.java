package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxUIRenderer {

    public static final enum RenderType extends Enum<RenderType> {
        public static final RenderType CLAY = null;
        public static final RenderType LYNX_UI = null;
        public static final /* synthetic */ RenderType[] a = null;

        static {
            RenderType r0 = new RenderType("LYNX_UI", 0);
            LYNX_UI = r0;
            RenderType r1 = new RenderType("CLAY", 1);
            CLAY = r1;
            a = new RenderType[]{r0, r1};
        }

        public static RenderType[] values() {
            return (RenderType[]) a.clone();
        }

        public static RenderType valueOf(String r1) {
            return (RenderType) r27.a.a(RenderType.class, r1);
        }

        public RenderType(String r1, int r2) {
            super(r1, r2);
        }
    }
}
