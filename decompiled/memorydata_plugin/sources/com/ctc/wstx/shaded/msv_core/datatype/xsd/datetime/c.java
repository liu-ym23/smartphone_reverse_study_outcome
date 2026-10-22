package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f3576a = null;

    static {
        f3576a = new c();
    }

    private c() {
    }

    public static String a(String r1, Calendar r2) {
        return f3576a.a(r1, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public /* bridge */ /* synthetic */ String a(String r1, Object r2) {
        return super.a(r1, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public Calendar a(Object r2) {
        return (Calendar) ZeusTransformUtils.preCheckCast(r2, Calendar.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void a(Object r3, StringBuffer r4) {
        int r2 = ((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin")).get(1);
        if (r2 > 0) goto L5;
        String r5 = Integer.toString(1 - r2);
    L7:
        if (r5.length() >= 4) goto L9;
        r5 = "0" + r5;
        goto L7
    L9:
        if (r2 > 0) goto L11;
        r5 = "-" + r5;
    L11:
        r4.append(r5);
        return;
    L5:
        r5 = Integer.toString(r2);
        goto L7
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void b(Object r3, StringBuffer r4) {
        a(((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin")).get(2) + 1, r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void c(Object r3, StringBuffer r4) {
        a(((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin")).get(5), r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void d(Object r3, StringBuffer r4) {
        a(((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin")).get(11), r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void e(Object r3, StringBuffer r4) {
        a(((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin")).get(12), r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.a
    public void f(Object r3, StringBuffer r4) {
        Calendar r5 = (Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin");
        a(r5.get(13), r4);
        if (r5.isSet(14) == false) goto L13;
        int r2 = r5.get(14);
        if (r2 == 0) goto L14;
        String r6 = Integer.toString(r2);
    L8:
        if (r6.length() >= 3) goto L10;
        r6 = "0" + r6;
        goto L8
    L10:
        r4.append('.');
        r4.append(r6);
        return;
    L14:
        return;
    }
}
