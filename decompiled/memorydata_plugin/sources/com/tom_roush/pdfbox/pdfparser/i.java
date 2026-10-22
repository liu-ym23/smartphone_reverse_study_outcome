package com.tom_roush.pdfbox.pdfparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.io.g f16138a;

    i(com.tom_roush.pdfbox.io.g r3) {
        this.f16138a = (com.tom_roush.pdfbox.io.g) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.io.g.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int a() {
        return this.f16138a.read();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int a(byte[] r1) {
        return this.f16138a.read(r1);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int a(byte[] r1, int r2, int r3) {
        return this.f16138a.read(r1, r2, r3);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public void a(int r1) {
        this.f16138a.a(1);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public long b() {
        return this.f16138a.a();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public void b(byte[] r1) {
        this.f16138a.a(r1.length);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public void b(byte[] r1, int r2, int r3) {
        this.f16138a.a(r3);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public byte[] b(int r1) {
        return this.f16138a.b(r1);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int c() {
        return this.f16138a.d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f16138a.close();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public boolean d() {
        return this.f16138a.e();
    }
}
