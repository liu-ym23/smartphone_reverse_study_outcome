package mab;

import android.content.Context;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends c {
    public String[] e;
    public final int[] f;
    public final int[] g;
    public CustomRepeatParams$DayOfWeek h;
    public Boolean i;
    public Boolean j;

    public final void c() {
        CustomRepeatParams$DayOfWeek r0 = this.h;
        if (r0 != CustomRepeatParams$DayOfWeek.MONDAY) goto L6;
        this.e = this.b.getResources().getStringArray(2130903052);
        return;
    L6:
        if (r0 != CustomRepeatParams$DayOfWeek.SATURDAY) goto L8;
        this.e = this.b.getResources().getStringArray(2130903104);
        return;
    L8:
        this.e = this.b.getResources().getStringArray(2130903109);
    }

    public final void d() {
        CustomRepeatParams$DayOfWeek r0 = this.h;
        if (r0 != CustomRepeatParams$DayOfWeek.MONDAY) goto L10;
        int r1 = 0;
    L5:
        int[] r2 = this.f;
        if (r1 >= r2.length) goto L8;
        r2[r1] = r1;
        r1 = r1 + 1;
        goto L5
    L8:
        int[] r3 = this.g;
        r3[0] = 5;
        r3[1] = 6;
        return;
    L10:
        if (r0 != CustomRepeatParams$DayOfWeek.SATURDAY) goto L16;
        int r4 = 0;
    L12:
        int[] r5 = this.f;
        if (r4 >= r5.length) goto L15;
        r5[r4] = r4 + 2;
        r4 = r4 + 1;
        goto L12
    L15:
        int[] r6 = this.g;
        r6[0] = 0;
        r6[1] = 1;
        return;
    L16:
        int r7 = 0;
    L17:
        int[] r8 = this.f;
        if (r7 >= r8.length) goto L20;
        int r9 = r7 + 1;
        r8[r7] = r9;
        r7 = r9;
        goto L17
    L20:
        int[] r10 = this.g;
        r10[0] = 0;
        r10[1] = 6;
    }

    @Override // mab.c, android.widget.Adapter
    public final int getCount() {
        if (this.e != null) goto L12;
        CustomRepeatParams$DayOfWeek r0 = this.h;
        if (r0 != CustomRepeatParams$DayOfWeek.MONDAY) goto L8;
        this.e = this.b.getResources().getStringArray(2130903052);
        goto L12
    L8:
        if (r0 != CustomRepeatParams$DayOfWeek.SATURDAY) goto L10;
        this.e = this.b.getResources().getStringArray(2130903104);
        goto L12
    L10:
        this.e = this.b.getResources().getStringArray(2130903109);
    L12:
        return this.e.length;
    }

    @Override // mab.c
    public final String a(int r3) {
        if (r3 < 0) goto L7;
        String[] r0 = this.e;
        if (r3 < r0.length) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0[r3];
    L7:
        return BuildConfig.FLAVOR;
    }

    @Override // mab.c
    public final boolean b(int r2) {
        if (r2 >= 0) goto L4;
        return false;
    L4:
        if (r2 < 7) goto L6;
        return false;
    L6:
        return this.a[r2];
    }

    public final void e(int r10) {
        if (r10 < 0) goto L67;
        boolean[] r0 = this.a;
        if (r10 >= r0.length) goto L68;
        boolean r1 = !r0[r10];
        r0[r10] = r1;
        boolean r3 = false;
        if (r10 != 7) goto L16;
        int[] r11 = this.f;
        int r2 = this.c;
        int r4 = r11.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L41;
        int r6 = r11[r5];
        if (this.j.booleanValue() == false) goto L13;
        if (r6 != r2) goto L13;
    L14:
        r5 = r5 + 1;
    L13:
        this.a[r6] = r1;
    L41:
        if (this.i.booleanValue() == false) goto L53;
        int r12 = 0;
    L44:
        boolean[] r7 = this.a;
        if (r12 >= r7.length) goto L50;
        if (r7[r12] == true) goto L51;
        r12 = r12 + 1;
    L51:
        if (r3 == false) goto L53;
        r7[this.c] = true;
        goto L53
    L50:
        r3 = true;
    L53:
        notifyDataSetChanged();
        return;
    L16:
        if (r10 != 8) goto L25;
        int[] r13 = this.g;
        int r8 = this.c;
        int r9 = r13.length;
        int r14 = 0;
    L18:
        if (r14 >= r9) goto L41;
        int r15 = r13[r14];
        if (this.j.booleanValue() == false) goto L23;
        if (r15 != r8) goto L23;
    L24:
        r14 = r14 + 1;
    L23:
        this.a[r15] = r1;
        goto L24
    L25:
        int[] r16 = this.f;
        int r17 = r16.length;
        int r18 = 0;
    L26:
        if (r18 >= r17) goto L31;
        if (this.a[r16[r18]] == false) goto L29;
        r18 = r18 + 1;
        goto L26
    L29:
        boolean r19 = false;
    L32:
        r0[7] = r19;
        boolean[] r110 = this.a;
        int[] r20 = this.g;
        int r21 = r20.length;
        int r22 = 0;
    L33:
        if (r22 >= r21) goto L38;
        if (this.a[r20[r22]] == false) goto L36;
        r22 = r22 + 1;
        goto L33
    L36:
        boolean r23 = false;
    L39:
        r110[8] = r23;
        goto L41
    L38:
        r23 = true;
        goto L39
    L31:
        r19 = true;
        goto L32
    L68:
        return;
    }

    public g(Context r2, int r3, CustomRepeatParams$DayOfWeek r4) {
        super(r2, 3, r3);
        this.f = new int[5];
        this.g = new int[2];
        Boolean r5 = Boolean.FALSE;
        this.i = r5;
        this.j = r5;
        boolean[] r6 = new boolean[this.e.length];
        this.a = r6;
        Arrays.fill(r6, false);
        this.h = r4;
        c();
        d();
    }
}
