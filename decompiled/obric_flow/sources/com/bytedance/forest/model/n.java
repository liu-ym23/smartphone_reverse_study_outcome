package com.bytedance.forest.model;

import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.keva.Keva;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f4392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.forest.utils.d f4394c;
    public final /* synthetic */ w d;
    public final /* synthetic */ Map e;
    public final /* synthetic */ String f;

    public n(o r5, Ref.ObjectRef r10, com.bytedance.forest.utils.d r11, w r12, Map r13, String r14) {
        this.f4392a = r5;
        this.f4393b = r10;
        this.f4394c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        o r5 = this.f4392a;
        if (r5.f4395b == true) goto L5;
    L7:
        File r10 = new File((File) com.bytedance.forest.pollyfill.b.f4507a.getValue(), (String) this.f4393b.element);
        if (r10.exists() == false) goto L11;
        com.bytedance.forest.utils.d.b(this.f4394c, 6, "ResponseCache", "update but new file already existed", true, null, null, 48);
        return;
    L11:
        File r11 = this.f4392a.f4396c;
        if (r11 == null) goto L28;
        r11.renameTo(r10);     // Catch: Throwable -> L22
        w r12 = this.d;     // Catch: Throwable -> L22
        r12.f4443t = r10.getAbsolutePath();     // Catch: Throwable -> L22
        List r13 = com.bytedance.forest.utils.k.f4646a;     // Catch: Throwable -> L22
        Map r14 = this.e;     // Catch: Throwable -> L22
        final String r15 = com.bytedance.forest.utils.k.f4647b.toJson(r14);     // Catch: Throwable -> L22
        Keva r16 = com.bytedance.forest.utils.l.f4649a;     // Catch: Throwable -> L22
        String r17 = (String) this.f4393b.element;     // Catch: Throwable -> L22
        Keva r18 = com.bytedance.forest.utils.l.f4649a;     // Catch: Throwable -> L22
        if (r18 == null) goto L16;
        r18.storeStringJustDisk(r17, r15);     // Catch: Throwable -> L22
    L16:
        com.bytedance.forest.utils.d.c(this.f4394c, 4, "ResponseCache", null, null, new HttpResponseCache$updateFromOnline$1$$special$$inlined$let$lambda$1(r15, this), 28);     // Catch: Throwable -> L22
        this.f4392a.f4396c = r10;     // Catch: Throwable -> L22
        String r19 = this.f;     // Catch: Throwable -> L22
        if (r18 == null) goto L20;
        r18.erase(r19);     // Catch: Throwable -> L22
    L20:
        final String r20 = MD5Utils.stringToMd5(r15);     // Catch: Throwable -> L22
        com.bytedance.forest.utils.d.c(this.f4394c, 4, "ResponseCache", null, null, new HttpResponseCache$updateFromOnline$1$$special$$inlined$let$lambda$2(r20, this), 24);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        com.bytedance.forest.utils.d.b(this.f4394c, 6, "ResponseCache", "rename failed", true, th, null, 32);
        return;
    L28:
        return;
    L5:
        if (System.currentTimeMillis() <= r5.f) goto L7;
    }
}
