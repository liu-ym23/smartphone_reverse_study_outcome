package com.obric.oui.constraintlayout.core.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CLParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f13593a = false;

    static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE ARRAY = null;
        public static final TYPE KEY = null;
        public static final TYPE NUMBER = null;
        public static final TYPE OBJECT = null;
        public static final TYPE STRING = null;
        public static final TYPE TOKEN = null;
        public static final TYPE UNKNOWN = null;

        static {
            TYPE r0 = new TYPE("UNKNOWN", 0);
            UNKNOWN = r0;
            TYPE r1 = new TYPE("OBJECT", 1);
            OBJECT = r1;
            TYPE r3 = new TYPE("ARRAY", 2);
            ARRAY = r3;
            TYPE r5 = new TYPE("NUMBER", 3);
            NUMBER = r5;
            TYPE r7 = new TYPE("STRING", 4);
            STRING = r7;
            TYPE r9 = new TYPE("KEY", 5);
            KEY = r9;
            TYPE r11 = new TYPE("TOKEN", 6);
            TOKEN = r11;
            $VALUES = new TYPE[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static TYPE valueOf(String r2) {
            return (TYPE) ZeusTransformUtils.preCheckCast(Enum.valueOf(TYPE.class, r2), TYPE.class, "com.obric.memorydata.plugin");
        }

        public static TYPE[] values() {
            return (TYPE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TYPE[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }
}
