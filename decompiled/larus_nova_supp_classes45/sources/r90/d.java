package r90;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements c {
    public static final Integer[] d = null;
    public Map<String, Integer> a;
    public final String[] b;
    public List<String> c;

    public static final class a {
    }

    static {
        d = new Integer[]{Integer.valueOf(R.drawable.im_e1), Integer.valueOf(R.drawable.im_e2), Integer.valueOf(R.drawable.im_e3), Integer.valueOf(R.drawable.im_e4), Integer.valueOf(R.drawable.im_e5), Integer.valueOf(R.drawable.im_e6), Integer.valueOf(R.drawable.im_e7), Integer.valueOf(R.drawable.im_e8), Integer.valueOf(R.drawable.im_e9), Integer.valueOf(R.drawable.im_e10), Integer.valueOf(R.drawable.im_e11), Integer.valueOf(R.drawable.im_e12), Integer.valueOf(R.drawable.im_e13), Integer.valueOf(R.drawable.im_e14), Integer.valueOf(R.drawable.im_e15), Integer.valueOf(R.drawable.im_e16), Integer.valueOf(R.drawable.im_e17), Integer.valueOf(R.drawable.im_e18), Integer.valueOf(R.drawable.im_e19), Integer.valueOf(R.drawable.im_e20), Integer.valueOf(R.drawable.im_e21), Integer.valueOf(R.drawable.im_e22), Integer.valueOf(R.drawable.im_e23), Integer.valueOf(R.drawable.im_e24), Integer.valueOf(R.drawable.im_e25), Integer.valueOf(R.drawable.im_e26), Integer.valueOf(R.drawable.im_e27), Integer.valueOf(R.drawable.im_e28), Integer.valueOf(R.drawable.im_e29), Integer.valueOf(R.drawable.im_e30)};
    }

    public final void e() {
        String[] r0 = this.b;
        if (r0 != null) goto L5;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        if (this.a != null) goto L46;
        this.c = new ArrayList();
        String[] r3 = this.b;
        Intrinsics.checkNotNull(r3);
        this.a = new HashMap(r3.length);
        String[] r2 = this.b;
        Intrinsics.checkNotNull(r2);
        int r4 = r2.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L47;
        String r6 = r2[r5];
        if (TextUtils.isEmpty(r6) == true) goto L38;
        int r7 = b.a;
        if (TextUtils.isEmpty(r6) == false) goto L23;
        String[] r8 = null;
    L24:
        if (r8 == null) goto L38;
        if (r8.length < 2) goto L38;
        int r9 = CastIntegerProtector.parseInt(r8[0]);
        Map<String, Integer> r11 = this.a;
        Intrinsics.checkNotNull(r11);
        String r12 = r8[1];
        int r13 = r9 - 1;
        if (r13 >= 0) goto L31;
    L33:
        int r14 = 0;
    L34:
        ((HashMap) r11).put(r12, Integer.valueOf(r14));
        List<String> r15 = this.c;
        Intrinsics.checkNotNull(r15);
        if (((ArrayList) r15).size() != r9) goto L37;
        List<String> r16 = this.c;
        Intrinsics.checkNotNull(r16);
        ListProtector.set(r16, r13, r8[1]);
        goto L38
    L37:
        List<String> r17 = this.c;
        Intrinsics.checkNotNull(r17);
        ((ArrayList) r17).add(r8[1]);
        goto L38
    L31:
        if (r13 >= 30) goto L33;
        r14 = d[r13].intValue();
        goto L34
    L23:
        r8 = r6.split("\\|", 2);
    L38:
        r5 = r5 + 1;
        goto L16
    L47:
        return;
    L46:
        return;
    L5:
        if (r0.length != 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == true) goto L11;
        r1 = false;
        goto L12
    L7:
        r18 = false;
        goto L8
    }

    @Override // r90.c
    public final int c() {
        e();
        List<String> r0 = this.c;
        Intrinsics.checkNotNull(r0);
        return ((ArrayList) r0).size();
    }

    public d(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String[] r0 = this.b;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L11:
        if (r1 == false) goto L14;
        this.b = r4.getResources().getStringArray(2130903057);
        return;
    L14:
        return;
    L5:
        if (r0.length != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = false;
        goto L11
    L7:
        r2 = false;
        goto L8
    }

    @Override // r90.c
    public final List b(List r5) {
        if (r5 == null) goto L4;
        e();
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        String r1 = (String) r6.next();
        if (f(r1) <= 0) goto L7;
        r0.add(r1);
        goto L7
    L12:
        if (r0.size() >= 8) goto L21;
        List<String> r7 = this.c;
        Intrinsics.checkNotNull(r7);
        Iterator r8 = ((ArrayList) r7).iterator();
    L15:
        if (r8.hasNext() == false) goto L21;
        String r2 = (String) r8.next();
        if (r0.contains(r2) == true) goto L20;
        r0.add(r2);
    L20:
        if (r0.size() < 8) goto L15;
    L21:
        ArrayList r9 = new ArrayList();
        Iterator r3 = r0.iterator();
    L23:
        if (r3.hasNext() == false) goto L25;
        String r4 = (String) r3.next();
        BaseEmoji r11 = new BaseEmoji();
        r11.setDescription(r4);
        r11.setIconId(f(r4));
        r9.add(r11);
        goto L23
    L25:
        return r9;
    L4:
        return new ArrayList();
    }

    @Override // r90.c
    public final List d(int r7) {
        ArrayList r0 = new ArrayList();
        int r8 = r7 + 0;
        int r2 = 0;
    L3:
        if (r2 >= r8) goto L17;
        BaseEmoji r3 = new BaseEmoji();
        e();
        List<String> r4 = this.c;
        if (r4 != null) goto L7;
    L9:
        String r5 = "";
    L10:
        r3.setDescription(r5);
        if (r2 >= 0) goto L13;
    L15:
        int r6 = 0;
    L16:
        r3.setIconId(r6);
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L13:
        if (r2 >= 30) goto L15;
        r6 = d[r2].intValue();
        goto L16
    L7:
        if (r2 >= ((ArrayList) r4).size()) goto L9;
        r5 = (String) ListProtector.get(r4, r2);
        goto L10
    L17:
        return r0;
    }

    public final int f(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return 0;
    L5:
        e();
        Map<String, Integer> r0 = this.a;
        Intrinsics.checkNotNull(r0);
        Integer r4 = (Integer) ((HashMap) r0).get(r3);
        if (r4 != null) goto L8;
        return 0;
    L8:
        return r4.intValue();
    }

    @Override // r90.c
    public final Drawable a(Context r2, String r3) {
        if (r2 == null) goto L14;
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L16;
        int r4 = f(r3);
        if (r4 > 0) goto L13;
        return null;
    L13:
        return r2.getResources().getDrawable(r4);
    L16:
        return null;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    L14:
        return null;
    }
}
