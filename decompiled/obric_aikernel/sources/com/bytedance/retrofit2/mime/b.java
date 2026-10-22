package com.bytedance.retrofit2.mime;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ByteArrayOutputStream f2555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, List<String>> f2557f;

    public b() {
        this.f2555d = new ByteArrayOutputStream();
        this.f2557f = new HashMap();
        this.f2556e = false;
    }

    public b(boolean r10) {
        this.f2555d = new ByteArrayOutputStream();
        this.f2557f = new HashMap();
        this.f2556e = r10;
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public String b() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public String d() {
        this.f2554c = r4.a.c(this.f2555d.toByteArray());
        return this.f2554c;
    }

    @Override // com.bytedance.retrofit2.mime.a
    public TTRequestCompressManager.b f(String r10, String r11, boolean r12) {
        byte[] r13 = this.f2555d.toByteArray();
        if (r13 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.b r14 = TTRequestCompressManager.d(r13, r13.length, r10, r11, r12);
        if (r14 != null) goto L9;
    L12:
        return r14;
    L9:
        if (r14.f2548a == null) goto L12;
        ByteArrayOutputStream r15 = new ByteArrayOutputStream(r14.f2548a.length);
        this.f2555d = r15;
        byte[] r16 = r14.f2548a;
        r15.write(r16, 0, r16.length);
        this.f2553b = r14.f2549b;
        goto L12
    }

    @Override // com.bytedance.retrofit2.mime.a
    public boolean h() {
        byte[] r10 = this.f2555d.toByteArray();
        if (r10 != null) goto L5;
    L12:
        return false;
    L5:
        if (r10.length > 102400) goto L12;
        byte[] r11 = EncryptorUtil.a(r10, r10.length);
        if (r11 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(r11.length);
        this.f2555d = r12;
        r12.write(r11, 0, r11.length);
        this.f2552a = true;
        return true;
    }

    public void j(String r10, String r11) {
        k(r10, true, r11, true);
    }

    public void k(String r10, boolean r11, String r12, boolean r13) {
        Objects.requireNonNull(r10, ActivityLifecycle.NAME);
        Objects.requireNonNull(r12, EventBody.KEY_VALUE);
        if (this.f2555d.size() <= 0) goto L6;
        this.f2555d.write(38);
    L6:
        if (this.f2556e == false) goto L12;
        if (this.f2557f.containsKey(r10) == false) goto L10;
        this.f2557f.get(r10).add(r12);
        goto L12
    L10:
        ArrayList r14 = new ArrayList();
        r14.add(r12);
        this.f2557f.put(r10, r14);
    L12:
        if (r11 == true) goto L21;
    L14:
        if (r13 == false) goto L16;
        r12 = URLEncoder.encode(r12, "UTF-8");     // Catch: IOException -> L18
    L16:
        this.f2555d.write(r10.getBytes("UTF-8"));     // Catch: IOException -> L18
        this.f2555d.write(61);     // Catch: IOException -> L18
        this.f2555d.write(r12.getBytes("UTF-8"));     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: IOException -> L18
        goto L14
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public long length() {
        return this.f2555d.size();
    }

    @Override // com.bytedance.retrofit2.mime.a, r4.f
    public void writeTo(OutputStream r10) {
        r10.write(this.f2555d.toByteArray());
    }
}
