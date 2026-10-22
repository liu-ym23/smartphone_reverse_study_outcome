package u4;

import android.content.SharedPreferences;
import d4.c;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long[][] f12464k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f12466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f12469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long[][] f12473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m4.b f12474j;

    static {
        f12464k = new long[][]{new long[]{60000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
    }

    public b(String r10, c r11, m4.b r12) {
        this.f12466b = r11;
        this.f12465a = r10;
        this.f12474j = r12;
        this.f12467c = 0;
        long r8 = System.currentTimeMillis() - r11.f6761e.getLong(r10 + "downgrade_time", 0);
        SharedPreferences r13 = r11.f6761e;
        if (r8 >= 10800000) goto L5;
        this.f12467c = r13.getInt(r10 + "downgrade_index", 0);
    L6:
        long[][] r14 = f12464k;
        this.f12473i = (long[][]) Array.newInstance(Long.TYPE, new int[]{5, r14[0].length});
        int r15 = 0;
    L7:
        if (r15 >= 5) goto L9;
        long[] r16 = r14[r15];
        System.arraycopy(r16, 0, this.f12473i[r15], 0, r16.length);
        r15 = r15 + 1;
        goto L7
    L9:
        m4.b r17 = this.f12474j;
        if (r17 == null) goto L21;
        r17.getClass();
        this.f12473i[0][2] = 2147483647L;
        r17.getClass();
        if (0 <= 0) goto L26;
        int r18 = 1;
    L14:
        long[][] r19 = this.f12473i;
        if (r18 >= r19.length) goto L27;
        if (r18 != 1) goto L19;
        r19[r18][0] = 2 * 0;
    L20:
        r18 = r18 + 1;
        goto L14
    L19:
        r19[r18][0] = r19[r18 - 1][0] * 2;
        goto L20
    L27:
        return;
    L26:
        return;
    L21:
        return;
    L5:
        r13.edit().remove(r10 + "downgrade_time").remove(r10 + "downgrade_index").apply();
        goto L6
    }

    public final String toString() {
        return "mPrefix=" + this.f12465a + ", mTableIndex=" + this.f12467c + ", mHasSendCount=" + this.f12468d + ", mHasSendPackCount=" + this.f12469e + ", mContinueSuccSendCount=" + this.f12470f + ", mLastSendTime=" + this.f12471g;
    }
}
