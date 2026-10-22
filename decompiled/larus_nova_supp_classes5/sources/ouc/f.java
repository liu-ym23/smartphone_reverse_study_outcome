package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final ClassDiscriminatorMode p;

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.a + ", ignoreUnknownKeys=" + this.b + ", isLenient=" + this.c + ", allowStructuredMapKeys=" + this.d + ", prettyPrint=" + this.e + ", explicitNulls=" + this.f + ", prettyPrintIndent='" + this.g + "', coerceInputValues=" + this.h + ", useArrayPolymorphism=" + this.i + ", classDiscriminator='" + this.j + "', allowSpecialFloatingPointValues=" + this.k + ", useAlternativeNames=" + this.l + ", namingStrategy=null, decodeEnumsCaseInsensitive=" + this.m + ", allowTrailingComma=" + this.n + ", allowComments=" + this.o + ", classDiscriminatorMode=" + this.p + ')';
    }

    public f(boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, String r12, boolean r13, boolean r14, String r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, ClassDiscriminatorMode r21) {
        Intrinsics.checkNotNullParameter(r12, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(r15, "classDiscriminator");
        Intrinsics.checkNotNullParameter(r21, "classDiscriminatorMode");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
    }
}
