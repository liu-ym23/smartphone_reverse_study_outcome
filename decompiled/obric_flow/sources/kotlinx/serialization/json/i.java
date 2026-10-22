package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19407c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f19409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f19410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f19411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f19412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f19413m;

    public i(boolean r5, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, String r15, boolean r16, boolean r17, String r18, boolean r19, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r15, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(r18, "classDiscriminator");
        this.f19405a = r5;
        this.f19406b = r10;
        this.f19407c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f19408h = r16;
        this.f19409i = r17;
        this.f19410j = r18;
        this.f19411k = r19;
        this.f19412l = r110;
        this.f19413m = r111;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("JsonConfiguration(encodeDefaults=");
        r5.append(this.f19405a);
        r5.append(", ignoreUnknownKeys=");
        r5.append(this.f19406b);
        r5.append(", isLenient=");
        r5.append(this.f19407c);
        r5.append(", allowStructuredMapKeys=");
        r5.append(this.d);
        r5.append(", prettyPrint=");
        r5.append(this.e);
        r5.append(", explicitNulls=");
        r5.append(this.f);
        r5.append(", prettyPrintIndent='");
        r5.append(this.g);
        r5.append("', coerceInputValues=");
        r5.append(this.f19408h);
        r5.append(", useArrayPolymorphism=");
        r5.append(this.f19409i);
        r5.append(", classDiscriminator='");
        r5.append(this.f19410j);
        r5.append("', allowSpecialFloatingPointValues=");
        r5.append(this.f19411k);
        r5.append(", useAlternativeNames=");
        r5.append(this.f19412l);
        r5.append(", namingStrategy=null, decodeEnumsCaseInsensitive=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f19413m, ')');
    }
}
