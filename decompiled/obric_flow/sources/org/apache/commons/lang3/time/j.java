package org.apache.commons.lang3.time;

import java.text.ParsePosition;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pattern f20973a;

    @Override // org.apache.commons.lang3.time.k
    public final boolean a() {
        return false;
    }

    @Override // org.apache.commons.lang3.time.k
    public final boolean b(FastDateParser r5, Calendar r10, String r11, ParsePosition r12, int r13) {
        Matcher r14 = this.f20973a.matcher(r11.substring(r12.getIndex()));
        if (r14.lookingAt() == true) goto L6;
        r12.setErrorIndex(r12.getIndex());
        return false;
    L6:
        int r15 = r12.getIndex();
        r12.setIndex(r14.end(1) + r15);
        c(r14.group(1), r10);
        return true;
    }

    public abstract void c(String r5, Calendar r10);
}
