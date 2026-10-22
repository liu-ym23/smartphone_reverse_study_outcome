package androidx.profileinstaller;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f2216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f2217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0019c f2218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f2219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v0.b[] f2222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f2223h;

    public b(AssetManager r8, Executor r10, c.InterfaceC0019c r11, String r12, File r13) {
        this.f2221f = false;
        this.f2216a = r8;
        this.f2217b = r10;
        this.f2218c = r11;
        this.f2220e = r12;
        this.f2219d = r13;
    }

    public final FileInputStream a(AssetManager r8, String r10) {
        return r8.openFd(r10).createInputStream();
    L4:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L8;
    L10:
        return null;
    L8:
        if (r11.contains("compressed") == false) goto L10;
        this.f2218c.a();
        goto L10
    }

    public final void b(int r8, IOException r10) {
        v0.a r11 = new v0.a(this, r8, 0, r10);
        this.f2217b.execute(r11);
    }
}
