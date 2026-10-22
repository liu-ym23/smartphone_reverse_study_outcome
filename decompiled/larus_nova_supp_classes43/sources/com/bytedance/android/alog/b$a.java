package com.bytedance.android.alog;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b$a implements FilenameFilter {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ Pattern b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    @Override // java.io.FilenameFilter
    public final boolean accept(File r10, String r11) {
        this.a.add(r11);
        Matcher r0 = this.b.matcher(r11);
        if (r0.find() == true) goto L5;
    L21:
        return false;
    L5:
        if (r0.groupCount() != 1) goto L21;
        String r1 = r0.group(1);
        if (r1 != null) goto L10;
        return false;
    L10:
        long r12 = CastLongProtector.parseLong(r1);
        if (r12 <= 0) goto L21;
        if (r12 > this.c) goto L21;
        long r13 = new PolarisFileWrapper(r10, r11).lastModified();
        if (r13 <= 0) goto L21;
        if (r13 < this.d) goto L21;
        return true;
    }

    public b$a(ArrayList r1, Pattern r10, long r11, long r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
