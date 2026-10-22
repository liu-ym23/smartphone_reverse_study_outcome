package cn.nubia.neopush.commons;

/* JADX INFO: loaded from: classes.dex */
public class BuildConfig {
    private static /* synthetic */ int[] $SWITCH_TABLE$cn$nubia$neopush$commons$BuildConfig$Builder = null;
    public static Builder CONFIG = null;
    public static String CONTROL_APP_ID = "";
    public static String CONTROL_APP_KEY = "";
    public static String UPGRADE_APP_KEY = "";
    public static String UPGRADE_SECRECT_KEY = "";
    public static String UPLOAD_SDK_VERSION;

    public static final enum Builder extends Enum<Builder> {
        private static final /* synthetic */ Builder[] ENUM$VALUES = null;
        public static final Builder RELEASE = null;
        public static final Builder TEST_DEV = null;
        public static final Builder TEST_INTERGRATION = null;

        static {
            Builder r5 = new Builder("TEST_DEV", 0);
            TEST_DEV = r5;
            Builder r10 = new Builder("TEST_INTERGRATION", 1);
            TEST_INTERGRATION = r10;
            Builder r11 = new Builder("RELEASE", 2);
            RELEASE = r11;
            ENUM$VALUES = new Builder[]{r5, r10, r11};
        }

        private Builder(String r5, int r10) {
            super(r5, r10);
        }

        public static Builder valueOf(String r5) {
            return (Builder) Enum.valueOf(Builder.class, r5);
        }

        public static Builder[] values() {
            Builder[] r5 = ENUM$VALUES;
            int r10 = r5.length;
            Builder[] r11 = new Builder[r10];
            System.arraycopy(r5, 0, r11, 0, r10);
            return r11;
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$cn$nubia$neopush$commons$BuildConfig$Builder() {
        int[] r5 = $SWITCH_TABLE$cn$nubia$neopush$commons$BuildConfig$Builder;
        if (r5 == null) goto L5;
        return r5;
    L5:
        int[] r10 = new int[Builder.values().length];
        r10[Builder.RELEASE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L14:
        r10[Builder.TEST_DEV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L18:
        r10[Builder.TEST_INTERGRATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L9:
        $SWITCH_TABLE$cn$nubia$neopush$commons$BuildConfig$Builder = r10;
        return r10;
    }

    static {
        CONFIG = Builder.RELEASE;
        int r5 = $SWITCH_TABLE$cn$nubia$neopush$commons$BuildConfig$Builder()[CONFIG.ordinal()];
        if (r5 != 1) goto L5;
        CONTROL_APP_ID = "1000000000000000";
        CONTROL_APP_KEY = "10101010101010101010101010101010";
        UPLOAD_SDK_VERSION = "https://push-route-dev.nubia.com/upload_sdk_version.zte";
        return;
    L5:
        if (r5 != 2) goto L7;
        CONTROL_APP_ID = "1000000000000000";
        CONTROL_APP_KEY = "10101010101010101010101010101010";
        UPLOAD_SDK_VERSION = "https://push-route-test.nubia.com/upload_sdk_version.zte";
        return;
    L7:
        if (r5 != 3) goto L15;
        CONTROL_APP_ID = "343144";
        CONTROL_APP_KEY = "a30219a6f1aa487e9d7c779495a72371";
        UPLOAD_SDK_VERSION = "https://push-route.nubia.com/upload_sdk_version.zte";
        return;
    }

    public BuildConfig() {
    }

    public static boolean isDebug() {
        return !CONFIG.equals(Builder.RELEASE);
    }

    public static void setIsDebug(boolean r5) {
        if (r5 == true) goto L4;
        CONFIG = Builder.RELEASE;
    L5:
        int r10 = $SWITCH_TABLE$cn$nubia$neopush$commons$BuildConfig$Builder()[CONFIG.ordinal()];
        if (r10 != 1) goto L8;
        CONTROL_APP_ID = "1000000000000000";
        CONTROL_APP_KEY = "10101010101010101010101010101010";
        UPLOAD_SDK_VERSION = "https://push-route-dev.nubia.com/upload_sdk_version.zte";
        return;
    L8:
        if (r10 != 2) goto L10;
        CONTROL_APP_ID = "1000000000000000";
        CONTROL_APP_KEY = "10101010101010101010101010101010";
        UPLOAD_SDK_VERSION = "https://push-route-test.nubia.com/upload_sdk_version.zte";
        return;
    L10:
        if (r10 != 3) goto L18;
        CONTROL_APP_ID = "343144";
        CONTROL_APP_KEY = "a30219a6f1aa487e9d7c779495a72371";
        UPLOAD_SDK_VERSION = "https://push-route.nubia.com/upload_sdk_version.zte";
        return;
    L18:
        return;
    L4:
        CONFIG = Builder.TEST_INTERGRATION;
        goto L5
    }
}
