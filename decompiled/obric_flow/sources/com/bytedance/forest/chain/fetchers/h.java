package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.w;
import com.bytedance.geckox.p;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements com.bytedance.forest.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.iesgurd.d f4295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f4296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.forest.utils.e f4297c;
    public final String d;
    public final String e;
    public final String f;

    public h(com.bytedance.iesgurd.d r5, w r10, com.bytedance.forest.utils.e r11, String r12, String r13, String r14) {
        this.f4295a = r5;
        this.f4296b = r10;
        this.f4297c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // com.bytedance.forest.model.a
    public final InputStream a() {
        String r5 = this.f;
        String r10 = this.e;
        String r11 = this.d;
        boolean r12 = com.bytedance.forest.utils.k.f4648c.get();     // Catch: Exception -> L9
        com.bytedance.iesgurd.d r13 = this.f4295a;     // Catch: Exception -> L9
        FileInputStream r14 = r13.e;     // Catch: Exception -> L9
        if (r14 != null) goto L6;
    L11:
        String r15 = r13.d;     // Catch: Exception -> L9
        if (r15 != null) goto L14;
        return null;
    L14:
        if (r15.length() == 0) goto L33;
        File r16 = new File(r15);     // Catch: Exception -> L9
        if (p.c(r11, r10) == false) goto L27;
        if (r12 == true) goto L27;
        String r17 = p.a(r11, r10, r5);     // Catch: Exception -> L9
        File r18 = new File(StringsKt.F(r16.getAbsolutePath(), r5, r17));     // Catch: Exception -> L9
        if (r18.exists() == false) goto L25;
        this.f4296b.f4439o = true;     // Catch: Exception -> L9
        return new GkFSFileInputStream(r18);
    L25:
        return new FileInputStream(r16);
    L27:
        return new FileInputStream(r16);
    L33:
        return null;
    L6:
        if ((r14 instanceof GkFSFileInputStream) == false) goto L8;
        if (r12 == true) goto L11;
    L8:
        return r14;
    L9:
        e = move-exception;
        this.f4297c.g.a(6, ForestBuffer.TAG, true, e, "gecko_get_input_stream_error", new GeckoResBytesProvider$provideInputStream$1(this, e));
        return null;
    }

    @Override // com.bytedance.forest.model.a
    public final boolean b() {
        return true;
    }
}
