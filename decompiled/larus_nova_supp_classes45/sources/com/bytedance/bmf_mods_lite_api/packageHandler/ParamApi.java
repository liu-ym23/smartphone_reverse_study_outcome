package com.bytedance.bmf_mods_lite_api.packageHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ParamApi {

    /* JADX INFO: renamed from: com.bytedance.bmf_mods_lite_api.packageHandler.ParamApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$clearData(ParamApi r0) {
            return -1;
        }

        public static String $default$dump(ParamApi r0) {
            return "";
        }

        public static int $default$erase(ParamApi r0, long r1) {
            return -1;
        }

        public static long $default$getNativePtr(ParamApi r2) {
            return 0;
        }

        public static boolean $default$hasKey(ParamApi r0, long r1) {
            return false;
        }

        public static double $default$optDouble(ParamApi r0, long r1, double r3) {
            return r3;
        }

        public static double[] $default$optDoubleList(ParamApi r0, long r1, double[] r3) {
            return r3;
        }

        public static float $default$optFloat(ParamApi r0, long r1, float r3) {
            return r3;
        }

        public static float[] $default$optFloatList(ParamApi r0, long r1, float[] r3) {
            return r3;
        }

        public static int $default$optInt(ParamApi r0, long r1, int r3) {
            return r3;
        }

        public static int[] $default$optIntList(ParamApi r0, long r1, int[] r3) {
            return r3;
        }

        public static long $default$optLong(ParamApi r0, long r1, long r3) {
            return r3;
        }

        public static long[] $default$optLongList(ParamApi r0, long r1, long[] r3) {
            return r3;
        }

        public static String $default$optString(ParamApi r0, long r1, String r3) {
            return "";
        }

        public static void $default$release(ParamApi r0) {
        }

        public static int $default$setDouble(ParamApi r0, long r1, double r3) {
            return -1;
        }

        public static int $default$setDoubleList(ParamApi r0, long r1, double[] r3) {
            return -1;
        }

        public static int $default$setFloat(ParamApi r0, long r1, float r3) {
            return -1;
        }

        public static int $default$setFloatList(ParamApi r0, long r1, float[] r3) {
            return -1;
        }

        public static int $default$setInt(ParamApi r0, long r1, int r3) {
            return -1;
        }

        public static int $default$setIntList(ParamApi r0, long r1, int[] r3) {
            return -1;
        }

        public static int $default$setLong(ParamApi r0, long r1, long r3) {
            return -1;
        }

        public static int $default$setLongList(ParamApi r0, long r1, long[] r3) {
            return -1;
        }

        public static int $default$setString(ParamApi r0, long r1, String r3) {
            return -1;
        }
    }

    int clearData();

    String dump();

    int erase(long r1);

    long getNativePtr();

    boolean hasKey(long r1);

    double optDouble(long r1, double r3);

    double[] optDoubleList(long r1, double[] r3);

    float optFloat(long r1, float r3);

    float[] optFloatList(long r1, float[] r3);

    int optInt(long r1, int r3);

    int[] optIntList(long r1, int[] r3);

    long optLong(long r1, long r3);

    long[] optLongList(long r1, long[] r3);

    String optString(long r1, String r3);

    void release();

    int setDouble(long r1, double r3);

    int setDoubleList(long r1, double[] r3);

    int setFloat(long r1, float r3);

    int setFloatList(long r1, float[] r3);

    int setInt(long r1, int r3);

    int setIntList(long r1, int[] r3);

    int setLong(long r1, long r3);

    int setLongList(long r1, long[] r3);

    int setString(long r1, String r3);
}
