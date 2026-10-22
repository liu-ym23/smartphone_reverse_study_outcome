package k1;

import android.content.Context;
import com.bytedance.applog.c;
import com.bytedance.applog.o;
import com.bytedance.bdinstall.Level;
import o1.g;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f10031a;

    public b(c r10) {
        this.f10031a = r10;
    }

    public String[] a(Context r10, String[] r11) {
        int r12 = r11.length;
        String[] r13 = new String[r12];
        boolean r14 = this.f10031a.E();
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L8;
        r13[r15] = r11[r15];
        if (r14 == false) goto L7;
        r13[r15] = r13[r15] + "?tt_data=a";
    L7:
        r13[r15] = this.f10031a.addNetCommonParams(r10, r13[r15], true, Level.L1);
        r13[r15] = a.e(r13[r15], g.f11381c);
        r15 = r15 + 1;
        goto L3
    L8:
        return r13;
    }

    public String[] b(a1.c r10, boolean r11, h1.b r12) {
        o r13 = r10.E();
        if (r11 == false) goto L5;
        String[] r14 = r13.c();
    L6:
        if (r12 == null) goto L13;
        String[] r15 = r12.g(r14, "/service/2/app_log/");
        if (r15 == null) goto L13;
        if (r15.length <= 0) goto L13;
        r14 = r15;
    L13:
        return a(r10.w(), r14);
    L5:
        r14 = r13.d();
        goto L6
    }
}
