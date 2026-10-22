package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public final class MurmurHash {
    private static final int DEFAULT_SEED = 0;

    private MurmurHash() {
    }

    public static int finish(int r5, int r10) {
        int r11 = r5 ^ (r10 * 4);
        int r12 = (r11 ^ (r11 >>> 16)) * (-2048144789);
        int r13 = (r12 ^ (r12 >>> 13)) * (-1028477387);
        return r13 ^ (r13 >>> 16);
    }

    public static <T> int hashCode(T[] r5, int r10) {
        int r11 = initialize(r10);
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11 = update(r11, r5[r13]);
        r13 = r13 + 1;
        goto L3
    L6:
        return finish(r11, r5.length);
    }

    public static int initialize(int r5) {
        return r5;
    }

    public static int update(int r5, int r10) {
        int r11 = r10 * (-862048943);
        int r12 = r5 ^ (((r11 >>> 17) | (r11 << 15)) * 461845907);
        return (((r12 >>> 19) | (r12 << 13)) * 5) - 430675100;
    }

    public static int initialize() {
        return initialize(0);
    }

    public static int update(int r5, Object r10) {
        if (r10 == null) goto L4;
        int r11 = r10.hashCode();
    L6:
        return update(r5, r11);
    L4:
        r11 = 0;
        goto L6
    }
}
