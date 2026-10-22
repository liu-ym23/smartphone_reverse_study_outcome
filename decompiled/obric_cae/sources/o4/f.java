package o4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9657e;

    public /* synthetic */ f(int r8, int r10, HashMap r11, HashMap r12, HashSet r13) {
        this.f9657e = r10;
        super(r8, r13, r11, r12);
    }

    @Override // o4.a
    public final boolean c(b r8) {
        switch(this.f9657e) {
            case 0: goto L5;
            default: goto L19;
        };
    L5:
        int r10 = a();
        if (r10 < 0) goto L18;
        if (r10 > 0) goto L46;
        if (r8 == null) goto L44;
        z3.c r11 = (z3.c) r8;
        if (TextUtils.isEmpty(r11.a()) == true) goto L47;
        if ((Long.parseLong(r11.a()) % 10000) >= this.f9647a) goto L18;
        return false;
    L48:
        return false;
    L47:
        return false;
    L44:
        return false;
    L46:
        return false;
    L18:
        return true;
    L19:
        int r12 = a();
        if (r12 < 0) goto L49;
        if (r12 > 0) goto L50;
        if (r8 == null) goto L51;
        z3.c r13 = (z3.c) r8;
        String r14 = r13.f14201a.f14197c.f13937m.f11401i;
        if (TextUtils.isEmpty(r14) == true) goto L52;
        r13.f14201a.f14197c.f13937m.getClass();
        if (r13.f14201a.f14197c.f13945u.f13975a <= 0) goto L32;
        String r15 = String.valueOf(r13.f14201a.f14197c.f13945u.f13975a);
    L34:
        if (TextUtils.isEmpty(r15) == true) goto L53;
        r13.f14201a.f14197c.f13937m.getClass();
        if (TextUtils.isEmpty(null) == false) goto L40;
        return false;
    L40:
        return !l6.a.V(defpackage.a.f(r14, ":null_", r15), this.f9647a);
    L53:
        return false;
    L32:
        r15 = null;
        goto L34
    L52:
        return false;
    L51:
        return false;
    L50:
        return false;
    L49:
        return true;
    }
}
