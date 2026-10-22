package com.lynx.tasm.service;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxResourceServiceRequestParams {

    public static final enum LynxServiceScene extends Enum<LynxServiceScene> {
        public static final LynxServiceScene LYNX_CHILD_RESOURCE = null;
        public static final LynxServiceScene LYNX_COMPONENT = null;
        public static final LynxServiceScene LYNX_EXTERNAL_JS = null;
        public static final LynxServiceScene LYNX_FONT = null;
        public static final LynxServiceScene LYNX_I18N = null;
        public static final LynxServiceScene LYNX_IMAGE = null;
        public static final LynxServiceScene LYNX_LOTTIE = null;
        public static final LynxServiceScene LYNX_SVG = null;
        public static final LynxServiceScene LYNX_TEMPLATE = null;
        public static final LynxServiceScene LYNX_VIDEO = null;
        public static final LynxServiceScene OTHER = null;
        public static final LynxServiceScene PRELOAD_CONFIG = null;
        public static final LynxServiceScene WEB_CHILD_RESOURCE = null;
        public static final LynxServiceScene WEB_MAIN_RESOURCE = null;
        public static final /* synthetic */ LynxServiceScene[] a = null;

        static {
            LynxServiceScene r0 = new LynxServiceScene("LYNX_TEMPLATE", 0);
            LYNX_TEMPLATE = r0;
            LynxServiceScene r1 = new LynxServiceScene("LYNX_EXTERNAL_JS", 1);
            LYNX_EXTERNAL_JS = r1;
            LynxServiceScene r3 = new LynxServiceScene("LYNX_COMPONENT", 2);
            LYNX_COMPONENT = r3;
            LynxServiceScene r5 = new LynxServiceScene("LYNX_FONT", 3);
            LYNX_FONT = r5;
            LynxServiceScene r7 = new LynxServiceScene("LYNX_I18N", 4);
            LYNX_I18N = r7;
            LynxServiceScene r9 = new LynxServiceScene("LYNX_IMAGE", 5);
            LYNX_IMAGE = r9;
            LynxServiceScene r11 = new LynxServiceScene("LYNX_LOTTIE", 6);
            LYNX_LOTTIE = r11;
            LynxServiceScene r13 = new LynxServiceScene("LYNX_VIDEO", 7);
            LYNX_VIDEO = r13;
            LynxServiceScene r15 = new LynxServiceScene("LYNX_SVG", 8);
            LYNX_SVG = r15;
            LynxServiceScene r14 = new LynxServiceScene("LYNX_CHILD_RESOURCE", 9);
            LYNX_CHILD_RESOURCE = r14;
            LynxServiceScene r12 = new LynxServiceScene("WEB_MAIN_RESOURCE", 10);
            WEB_MAIN_RESOURCE = r12;
            LynxServiceScene r10 = new LynxServiceScene("WEB_CHILD_RESOURCE", 11);
            WEB_CHILD_RESOURCE = r10;
            LynxServiceScene r8 = new LynxServiceScene("PRELOAD_CONFIG", 12);
            PRELOAD_CONFIG = r8;
            LynxServiceScene r6 = new LynxServiceScene("OTHER", 13);
            OTHER = r6;
            a = new LynxServiceScene[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        }

        public static LynxServiceScene[] values() {
            return (LynxServiceScene[]) a.clone();
        }

        public static LynxServiceScene valueOf(String r1) {
            return (LynxServiceScene) a.a(LynxServiceScene.class, r1);
        }

        public LynxServiceScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LynxResourceServiceRequestParams() {
        LynxServiceScene r0 = LynxServiceScene.LYNX_TEMPLATE;
    }
}
