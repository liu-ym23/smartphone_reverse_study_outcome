package adcpeJava.adcpe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class Constants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double f10a = 0.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Base64.Encoder f11b = null;
    public static final Base64.Decoder c = null;

    static final enum KeyType extends Enum<KeyType> {
        private static final /* synthetic */ KeyType[] $VALUES = null;
        public static final KeyType KEY_VERSION_HOUSEHOLDER = null;
        public static final KeyType KEY_VERSION_NO_MAT = null;
        public static final KeyType KEY_VERSION_QR = null;
        public static final KeyType NOT_SUPPORTED = null;

        static {
            KeyType r0 = new KeyType("NOT_SUPPORTED", 0);
            NOT_SUPPORTED = r0;
            KeyType r1 = new KeyType("KEY_VERSION_NO_MAT", 1);
            KEY_VERSION_NO_MAT = r1;
            KeyType r3 = new KeyType("KEY_VERSION_QR", 2);
            KEY_VERSION_QR = r3;
            KeyType r5 = new KeyType("KEY_VERSION_HOUSEHOLDER", 3);
            KEY_VERSION_HOUSEHOLDER = r5;
            $VALUES = new KeyType[]{r0, r1, r3, r5};
        }

        private KeyType(String r1, int r2) {
            super(r1, r2);
        }

        public static KeyType valueOf(String r2) {
            return (KeyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyType.class, r2), KeyType.class, "com.obric.memorydata.plugin");
        }

        public static KeyType[] values() {
            return (KeyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyType[].class, "com.obric.memorydata.plugin");
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static int f12a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static int f13b = 1;
        static int c = 2;
        static int d = 3;
        static int e = 3;

        static {
        }
    }

    static {
        f10a = (Math.sqrt(20.0d) * 0.5d) - 2.0d;
        f11b = Base64.getEncoder();
        c = Base64.getDecoder();
    }
}
