package com.ss.ttvideoengine.source;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface Source {
    public static final int KEY_COST_SAVING_FIRST = 1;
    public static final int KEY_HARDWARE_DECODE_FIRST = 2;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.Source$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean isCodecStrategyValid(int r2) {
            if (r2 != 1) goto L5;
            return true;
        L5:
            if (r2 == 2) goto L10;
            return false;
        L10:
            return true;
        }

        public static boolean $default$isCodecStrategyValid(Source r0) {
            return isCodecStrategyValid(r0.codecStrategy());
        }
    }

    public static final class EncodeType {
        public static final String BYTEVC1 = "bytevc1";
        public static final String BYTEVC2 = "bytevc2";
        public static final String H264 = "h264";

        public EncodeType() {
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type DIRECT_URL_SOURCE = null;
        public static final Type VIDEO_MODEL_SOURCE = null;
        public static final Type VID_PLAY_AUTH_TOKEN_SOURCE = null;

        static {
            Type r0 = new Type("DIRECT_URL_SOURCE", 0);
            DIRECT_URL_SOURCE = r0;
            Type r1 = new Type("VID_PLAY_AUTH_TOKEN_SOURCE", 1);
            VID_PLAY_AUTH_TOKEN_SOURCE = r1;
            Type r3 = new Type("VIDEO_MODEL_SOURCE", 2);
            VIDEO_MODEL_SOURCE = r3;
            $VALUES = new Type[]{r0, r1, r3};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    int codecStrategy();

    boolean isCodecStrategyValid();

    Object tag();

    Type type();

    String vid();
}
