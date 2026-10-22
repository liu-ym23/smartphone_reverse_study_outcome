package com.airbnb.lottie;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f1273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1274c;

    public /* synthetic */ j(Context r5, String r10, int r11) {
        this.f1272a = r11;
        this.f1273b = r5;
        this.f1274c = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object r5 = null;
        String r10 = this.f1274c;
        Context r11 = this.f1273b;
        switch(this.f1272a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        Activity r12 = ug.a.a(r11);
        if (r12 == null) goto L7;
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r10, "Caller " + r12.getComponentName().toShortString() + ": " + r12.hashCode(), "XView");
        r5 = Unit.INSTANCE;
    L7:
        if (r5 != null) goto L10;
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r10, "Caller unknown", "XView");
    L10:
        return Unit.INSTANCE;
    L11:
        q7.a r15 = new q7.a(r11, r10);
        ko.r r16 = (ko.r) r15.f21489c;
        String r17 = (String) r16.f18729c;
        Context r18 = (Context) r16.f18728b;     // Catch: FileNotFoundException -> L48
        File r19 = r18.getCacheDir();     // Catch: FileNotFoundException -> L48
        FileExtension r20 = FileExtension.JSON;     // Catch: FileNotFoundException -> L48
        File r21 = new File(r19, ko.r.q(r17, r20, false));     // Catch: FileNotFoundException -> L48
        if (r21.exists() == true) goto L19;
        r21 = new File(r18.getCacheDir(), ko.r.q(r17, FileExtension.ZIP, false));     // Catch: FileNotFoundException -> L48
        if (r21.exists() == true) goto L19;
        r21 = null;
    L19:
        if (r21 == null) goto L20;
        FileInputStream r22 = new FileInputStream(r21);     // Catch: FileNotFoundException -> L48
        if (r21.getAbsolutePath().endsWith(".zip") == false) goto L25;
        r20 = FileExtension.ZIP;
    L25:
        r21.getAbsolutePath();
        u.b.a();
        Pair r23 = new Pair(r20, r22);
    L26:
        if (r23 == null) goto L40;
        FileExtension r24 = (FileExtension) r23.first;
        InputStream r25 = (InputStream) r23.second;
        FileExtension r26 = FileExtension.ZIP;
        String r27 = (String) r15.f21488b;
        if (r24 != r26) goto L36;
        ZipInputStream r28 = new ZipInputStream(r25);
        a0 r29 = n.d(r28, r27);     // Catch: Throwable -> L33
        u.f.b(r28);
    L37:
        Object r30 = r29.f1247a;
        if (r30 == null) goto L40;
        r5 = (h) r30;
    L33:
        th = move-exception;
        u.f.b(r28);
        throw th;
    L36:
        r29 = n.b(r25, r27);
    L40:
        if (r5 != null) goto L55;
        u.b.a();
        return r15.g();
    L45:
        e = move-exception;
        return new a0(e);
    L55:
        return new a0(r5);
    L20:
        r23 = null;
        goto L26
    }
}
