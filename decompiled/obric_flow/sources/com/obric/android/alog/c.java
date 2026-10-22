package com.obric.android.alog;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f11243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pattern f11244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f11245c;
    public final /* synthetic */ long d;

    public c(ArrayList r5, Pattern r10, long r11, long r12) {
        this.f11243a = r5;
        this.f11244b = r10;
        this.f11245c = r11;
        this.d = r12;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r10, String r11) {
        this.f11243a.add(r11);
        Matcher r5 = this.f11244b.matcher(r11);
        if (r5.find() == true) goto L5;
    L21:
        return false;
    L5:
        if (r5.groupCount() != 1) goto L21;
        String r12 = r5.group(1);
        if (r12 != null) goto L10;
        return false;
    L10:
        long r13 = Long.parseLong(r12);
        if (r13 <= 0) goto L21;
        if (r13 > this.f11245c) goto L21;
        long r14 = new File(r10, r11).lastModified();
        if (r14 <= 0) goto L21;
        if (r14 < this.d) goto L21;
        return true;
    }
}
