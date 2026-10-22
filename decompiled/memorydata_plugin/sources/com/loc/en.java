package com.loc;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class en extends fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f5501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<String, String> f5502b;
    String c;
    byte[] h;
    private String i;

    public en() {
        this.f5501a = null;
        this.f5502b = null;
        this.c = "";
        this.h = null;
        this.i = null;
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return this.f5501a;
    }

    public final void a(Map<String, String> r3) {
        this.f5501a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void a(byte[] r1) {
        this.h = r1;
    }

    @Override // com.loc.bo
    public final Map<String, String> b() {
        return this.f5502b;
    }

    public final void b(String r1) {
        this.c = r1;
    }

    @Override // com.loc.bo
    public final String c() {
        return this.c;
    }

    public final void c(String r1) {
        this.i = r1;
    }

    @Override // com.loc.bo
    public final byte[] d() {
        return this.h;
    }

    @Override // com.loc.fs, com.loc.bo
    public final String p() {
        if (TextUtils.isEmpty(this.i) == true) goto L7;
        return this.i;
    L7:
        return super.p();
    }
}
