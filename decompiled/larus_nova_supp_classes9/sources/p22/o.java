package p22;

import com.bytedance.android.livesdk.interactivity.api.settings.config.h0;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001e"}, d2 = {"Lp22/o;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isDanmakuOpen", "Z", "f", "()Z", "h", "(Z)V", BuildConfig.FLAVOR, "lineCount", "I", "d", "()I", "j", "(I)V", BuildConfig.FLAVOR, "speedCoefficient", "F", "e", "()F", "k", "(F)V", "fontSizeCoefficient", "c", "i", "alpha", "b", "g", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {
    public static final a a = null;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("font_size_coefficient")
    private float fontSizeCoefficient;

    @SerializedName("is_danmaku_open")
    private boolean isDanmakuOpen;

    @SerializedName("line_count")
    private int lineCount;

    @SerializedName("speed_coefficient")
    private float speedCoefficient;

    public static final class a {
        public a() {
        }

        public static float a(h0 r2) {
            if (r2.a() >= 20.0f) goto L5;
            return 80.0f;
        L5:
            if (r2.a() <= 100.0f) goto L8;
            return 80.0f;
        L8:
            return r2.a();
        }

        public static float b(h0 r1) {
            int r2 = r1.b();
            if (r2 != 0) goto L5;
            return 0.8f;
        L5:
            if (r2 != 1) goto L7;
            return 0.9f;
        L7:
            if (r2 != 2) goto L9;
        L15:
            return 1.0f;
        L9:
            if (r2 != 3) goto L11;
            return 1.2f;
        L11:
            if (r2 != 4) goto L15;
            return 1.4f;
        }

        public static float c(h0 r1) {
            int r2 = r1.c();
            if (r2 != 0) goto L5;
            return 0.6f;
        L5:
            if (r2 != 1) goto L7;
            return 0.8f;
        L7:
            if (r2 != 2) goto L9;
        L15:
            return 1.0f;
        L9:
            if (r2 != 3) goto L11;
            return 1.2f;
        L11:
            if (r2 != 4) goto L15;
            return 1.4f;
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L16;
        o r4 = (o) r3;
        if (this.isDanmakuOpen == r4.isDanmakuOpen) goto L8;
        return false;
    L8:
        if (this.lineCount == r4.lineCount) goto L10;
        return false;
    L10:
        if (Float.compare(this.speedCoefficient, r4.speedCoefficient) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.fontSizeCoefficient, r4.fontSizeCoefficient) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.alpha, r4.alpha) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r0 = this.isDanmakuOpen;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((((((r1 * 31) + this.lineCount) * 31) + Float.floatToIntBits(this.speedCoefficient)) * 31) + Float.floatToIntBits(this.fontSizeCoefficient)) * 31) + Float.floatToIntBits(this.alpha);
    }

    public final String toString() {
        return "SimpleDanmakuSetting(isDanmakuOpen=" + this.isDanmakuOpen + ", lineCount=" + this.lineCount + ", speedCoefficient=" + this.speedCoefficient + ", fontSizeCoefficient=" + this.fontSizeCoefficient + ", alpha=" + this.alpha + ")";
    }

    static {
        a = new a();
    }

    public final float b() {
        return this.alpha;
    }

    public final float c() {
        return this.fontSizeCoefficient;
    }

    public final int d() {
        return this.lineCount;
    }

    public final float e() {
        return this.speedCoefficient;
    }

    public final boolean f() {
        return this.isDanmakuOpen;
    }

    public static o a(o r6) {
        boolean r1 = r6.isDanmakuOpen;
        int r2 = r6.lineCount;
        float r3 = r6.speedCoefficient;
        float r4 = r6.fontSizeCoefficient;
        float r5 = r6.alpha;
        r6.getClass();
        return new o(r1, r2, r3, r4, r5);
    }

    public final void g(float r1) {
        this.alpha = r1;
    }

    public final void h(boolean r1) {
        this.isDanmakuOpen = r1;
    }

    public final void i(float r1) {
        this.fontSizeCoefficient = r1;
    }

    public final void j(int r1) {
        this.lineCount = r1;
    }

    public final void k(float r1) {
        this.speedCoefficient = r1;
    }

    public o(boolean r1, int r2, float r3, float r4, float r5) {
        this.isDanmakuOpen = r1;
        this.lineCount = r2;
        this.speedCoefficient = r3;
        this.fontSizeCoefficient = r4;
        this.alpha = r5;
    }
}
