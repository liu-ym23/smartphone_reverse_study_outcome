package o4;

import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9656e;

    public /* synthetic */ e(int r8, int r10, HashMap r11, HashMap r12, HashSet r13) {
        this.f9656e = r10;
        super(r8, r13, r11, r12);
    }

    @Override // o4.a
    public final boolean c(b r8) {
        int r10 = this.f9656e;
        int r11 = this.f9647a;
        switch(r10) {
            case 0: goto L5;
            default: goto L18;
        };
    L5:
        int r12 = a();
        if (r12 < 0) goto L17;
        if (r12 > 0) goto L33;
        if (r8 == null) goto L31;
        z3.c r13 = (z3.c) r8;
        if (TextUtils.isEmpty(r13.a()) == true) goto L34;
        CRC32 r14 = new CRC32();
        r14.update(r13.a().getBytes());
        if ((r14.getValue() % 10000) >= r11) goto L17;
        return false;
    L34:
        return false;
    L31:
        return false;
    L33:
        return false;
    L17:
        return true;
    L18:
        int r15 = a();
        if (r15 < 0) goto L35;
        if (r15 > 0) goto L38;
        if (r8 == null) goto L36;
        z3.c r16 = (z3.c) r8;
        if (TextUtils.isEmpty(r16.f14201a.f14197c.f13937m.f11401i) == false) goto L27;
        return false;
    L27:
        if (TextUtils.isEmpty(r16.a()) == false) goto L30;
        return false;
    L30:
        return !l6.a.V(r16.f14201a.f14197c.f13937m.f11401i + BdimCategoryConstants.SEPARATOR_COLON + r16.a(), r11);
    L36:
        return false;
    L38:
        return false;
    L35:
        return true;
    }
}
