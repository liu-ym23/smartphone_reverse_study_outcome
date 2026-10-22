package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import me.e;
import xd.d;
import yd.f;
import yd.l;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    @Override // b.a
    public final Intent a(ComponentActivity r8, Object r10) {
        String[] r11 = (String[]) r10;
        i.f(r8, "context");
        i.f(r11, QesdkUtils.TAGS.TAG_INPUT);
        Intent r12 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r11);
        i.e(r12, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return r12;
    }

    @Override // b.a
    public final a.C0027a b(ComponentActivity r8, Object r10) {
        String[] r11 = (String[]) r10;
        i.f(r8, "context");
        i.f(r11, QesdkUtils.TAGS.TAG_INPUT);
        boolean r12 = true;
        int r13 = 0;
        if (r11.length != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L30;
        int r15 = r11.length;
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L17;
        if (androidx.core.content.a.a(r8, r11[r16]) != 0) goto L13;
        boolean r17 = true;
    L14:
        if (r17 == false) goto L15;
        r16 = r16 + 1;
        goto L9
    L15:
        r12 = false;
        goto L17
    L13:
        r17 = false;
    L17:
        if (r12 == false) goto L25;
        int r18 = l6.a.n0(r11.length);
        if (r18 >= 16) goto L21;
        r18 = 16;
    L21:
        LinkedHashMap r19 = new LinkedHashMap(r18);
        int r20 = r11.length;
    L22:
        if (r13 >= r20) goto L31;
        r19.put(r11[r13], Boolean.TRUE);
        r13 = r13 + 1;
        goto L22
    L31:
        return new a.C0027a(r19);
    L25:
        return null;
    L30:
        return new a.C0027a(l.f14120a);
    L5:
        r14 = false;
        goto L6
    }

    @Override // b.a
    public final Object c(Intent r8, int r10) {
        l r11 = l.f14120a;
        if (r10 != (-1)) goto L41;
        if (r8 == null) goto L42;
        String[] r12 = r8.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] r13 = r8.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (r13 == null) goto L40;
        if (r12 == null) goto L43;
        ArrayList r14 = new ArrayList(r13.length);
        int r15 = r13.length;
        int r16 = 0;
        int r17 = 0;
    L12:
        if (r17 >= r15) goto L18;
        if (r13[r17] != 0) goto L16;
        boolean r18 = true;
    L17:
        r14.add(Boolean.valueOf(r18));
        r17 = r17 + 1;
        goto L12
    L16:
        r18 = false;
        goto L17
    L18:
        ArrayList r19 = new ArrayList();
        int r20 = r12.length;
    L19:
        if (r16 >= r20) goto L24;
        String r21 = r12[r16];
        if (r21 == null) goto L23;
        r19.add(r21);
    L23:
        r16 = r16 + 1;
        goto L19
    L24:
        Iterator r22 = r19.iterator();
        Iterator r23 = r14.iterator();
        ArrayList r24 = new ArrayList(Math.min(f.f1(r19), f.f1(r14)));
    L26:
        if (r22.hasNext() == false) goto L31;
        if (r23.hasNext() == false) goto L31;
        r24.add(new d(r22.next(), r23.next()));
    L31:
        return e.g1(r24);
    L43:
        return r11;
    L40:
        return r11;
    L42:
        return r11;
    L41:
        return r11;
    }
}
