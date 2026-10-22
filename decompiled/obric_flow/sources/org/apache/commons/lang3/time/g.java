package org.apache.commons.lang3.time;

import java.text.ParsePosition;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20969a;

    public g(String r5) {
        this.f20969a = r5;
    }

    @Override // org.apache.commons.lang3.time.k
    public final boolean a() {
        return false;
    }

    @Override // org.apache.commons.lang3.time.k
    public final boolean b(FastDateParser r5, Calendar r10, String r11, ParsePosition r12, int r13) {
        int r14 = 0;
    L3:
        String r15 = this.f20969a;
        if (r14 >= r15.length()) goto L14;
        int r16 = r12.getIndex() + r14;
        if (r16 == r11.length()) goto L7;
        if (r15.charAt(r14) != r11.charAt(r16)) goto L11;
        r14 = r14 + 1;
        goto L3
    L11:
        r12.setErrorIndex(r16);
        return false;
    L7:
        r12.setErrorIndex(r16);
        return false;
    L14:
        r12.setIndex(r12.getIndex() + r15.length());
        return true;
    }
}
