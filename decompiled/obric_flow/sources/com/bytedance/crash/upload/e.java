package com.bytedance.crash.upload;

import com.bytedance.crash.CrashType;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f4105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4107c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final CrashType g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4108h;

    public e(File r5, CrashType r10) {
        this.f4106b = -1;
        this.f4107c = -1;
        this.d = false;
        this.e = false;
        this.f = false;
        this.f4105a = r5;
        this.g = r10;
        this.f4108h = r5.getName();
        this.f = cl.a.A(r5);
    }

    public e(File r5, long r10, CrashType r11) {
        this.f4107c = -1;
        this.d = false;
        this.e = false;
        this.f = false;
        this.f4105a = r5;
        this.f4106b = r10;
        this.g = r11;
        this.f4108h = r5.getName();
        this.f = cl.a.A(r5);
    }
}
