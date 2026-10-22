package o;

import com.airbnb.lottie.model.DocumentData$Justification;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20363c;
    public final DocumentData$Justification d;
    public final int e;
    public final float f;
    public final float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f20364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f20365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f20366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f20367k;

    public b(String r5, String r10, float r11, DocumentData$Justification r12, int r13, float r14, float r15, int r16, int r17, float r18, boolean r19) {
        this.f20361a = r5;
        this.f20362b = r10;
        this.f20363c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f20364h = r16;
        this.f20365i = r17;
        this.f20366j = r18;
        this.f20367k = r19;
    }

    public final int hashCode() {
        int r5 = ((this.d.ordinal() + (((int) (androidx.constraintlayout.motion.widget.a.c(this.f20361a.hashCode() * 31, 31, this.f20362b) + this.f20363c)) * 31)) * 31) + this.e;
        long r10 = Float.floatToRawIntBits(this.f);
        return (((r5 * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.f20364h;
    }
}
