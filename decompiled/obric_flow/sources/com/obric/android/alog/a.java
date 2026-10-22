package com.obric.android.alog;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pattern f11227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Alog f11228b;

    public a(Alog r5, Pattern r10) {
        this.f11228b = r5;
        this.f11227a = r10;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r5, String r10) {
        return this.f11227a.matcher(r10).find();
    }
}
