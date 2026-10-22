package com.facebook.soloader;

import ai.j0;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DirectorySoSource extends SoSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f8464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8465b;

    public DirectorySoSource(File r5, int r10) {
        this.f8464a = r5;
        this.f8465b = r10;
        Arrays.asList(new String[0]);
    }

    public final String toString() {
        String r5 = String.valueOf(this.f8464a.getCanonicalPath());     // Catch: IOException -> L4
    L5:
        StringBuilder r10 = new StringBuilder();
        r10.append(getClass().getName());
        r10.append("[root = ");
        r10.append(r5);
        r10.append(" flags = ");
        return j0.n(r10, this.f8465b, ']');
    L4:
        r5 = this.f8464a.getName();
        goto L5
    }

    public DirectorySoSource(File r5, String[] r10) {
        this.f8464a = r5;
        this.f8465b = 2;
        Arrays.asList(r10);
    }
}
