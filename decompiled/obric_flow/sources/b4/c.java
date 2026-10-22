package b4;

import android.net.Uri;
import com.lynx.tasm.TemplateData;
import kn.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f861c;
    public final TemplateData d;
    public final d e;
    public final String f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f865k;

    public c(String r5, Uri r10, String r11, TemplateData r12, d r13, String r14, boolean r15, b r16) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "originalUri");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r13, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        Intrinsics.checkNotNullParameter("annieXCard", "enterFrom");
        this.f859a = r5;
        this.f860b = r10;
        this.f861c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f862h = r16;
        this.f864j = "";
    }

    public static c a(c r10, String r11, boolean r12, b r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r11 = r10.f859a;
    L5:
        String r5 = r11;
        Uri r15 = r10.f860b;
        if ((r14 & 512) == 0) goto L8;
        r12 = r10.g;
    L8:
        boolean r16 = r12;
        if ((r14 & 2048) == 0) goto L11;
        r13 = r10.f862h;
    L11:
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r15, "originalUri");
        String r17 = r10.f861c;
        Intrinsics.checkNotNullParameter(r17, "bid");
        d r18 = r10.e;
        Intrinsics.checkNotNullParameter(r18, "lynxViewBuilderParams");
        String r19 = r10.f;
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        Intrinsics.checkNotNullParameter("annieXCard", "enterFrom");
        TemplateData r20 = r10.d;
        return new c(r5, r15, r17, r20, r18, r19, r16, r13);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        String r5 = r11.f859a;
        if (Intrinsics.areEqual(this.f859a, r5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f860b, r11.f860b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f861c, r11.f861c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(null, null) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L36;
        return false;
    L36:
        if (this.g == r11.g) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f862h, r11.f862h) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual("annieXCard", "annieXCard") == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(null, null) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r5 = kk.a.b(this.f861c, (this.f860b.hashCode() + (this.f859a.hashCode() * 31)) * 31, 31);
        int r10 = 0;
        TemplateData r11 = this.d;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = e.a(e.a(kk.a.b(this.f, (this.e.hashCode() + ((r5 + r12) * 961)) * 31, 29791), 31, this.g), 31, false);
        b r14 = this.f862h;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return e.a((((r13 + r10) * 31) + 1270652651) * 31, 31, true);
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "AnnieXLynxModel(url=" + this.f859a + ", originalUri=" + this.f860b + ", bid=" + this.f861c + ", globalProps=" + this.d + ", extra=null, lynxViewBuilderParams=" + this.e + ", sessionId=" + this.f + ", templateData=null, template=null, isSSR=" + this.g + ", isCompactMode=false, ssrHydrateConfig=" + this.f862h + ", enterFrom=annieXCard, useXBridge3=true, compactConfig=null)";
    }
}
