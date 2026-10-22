package d0;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f16530b;

    public /* synthetic */ b0(r r5, int r10) {
        this.f16529a = r10;
        this.f16530b = r5;
    }

    @Override // d0.r
    public final /* bridge */ /* synthetic */ boolean a(Object r5) {
        switch(this.f16529a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        URL r10 = (URL) r5;
        return true;
    L6:
        String r11 = (String) r5;
        return true;
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        switch(this.f16529a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        String r13 = (String) r5;
        if (TextUtils.isEmpty(r13) == false) goto L10;
        Uri r14 = null;
    L16:
        if (r14 == null) goto L22;
        r r15 = this.f16530b;
        if (r15.a(r14) == true) goto L21;
        return null;
    L21:
        return r15.b(r14, r10, r11, r12);
    L22:
        return null;
    L10:
        if (r13.charAt(0) != '/') goto L12;
        r14 = Uri.fromFile(new File(r13));
        goto L16
    L12:
        Uri r16 = Uri.parse(r13);
        if (r16.getScheme() != null) goto L15;
        r14 = Uri.fromFile(new File(r13));
        goto L16
    L15:
        r14 = r16;
        goto L16
    L5:
        return this.f16530b.b(new g((URL) r5), r10, r11, r12);
    }
}
