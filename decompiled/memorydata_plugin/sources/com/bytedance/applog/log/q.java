package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b<j> f1645a = null;

    static {
        f1645a = new AnonymousClass1();
    }

    public q() {
    }

    public static j a() {
        return (j) ZeusTransformUtils.preCheckCast(f1645a.c(new Object[0]), j.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.log.j
    public void a(int r7, String r8, Throwable r9, Object... r10) {
        a(r7, null, r8, r9, r10);
    }

    @Override // com.bytedance.applog.log.j
    public void a(int r2, String r3, Object... r4) {
        e(r2, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.j
    public void a(int r8, List<String> r9, String r10, Throwable r11, Object... r12) {
        a(r8, 4, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), r11, r10, r12);
    }

    @Override // com.bytedance.applog.log.j
    public void a(int r8, List<String> r9, String r10, Object... r11) {
        a(r8, 2, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), null, r10, r11);
    }

    @Override // com.bytedance.applog.log.j
    public void a(String r2, Throwable r3, Object... r4) {
        a(null, r2, r3, r4);
    }

    @Override // com.bytedance.applog.log.j
    public void a(List<String> r7, String r8, Throwable r9, Object... r10) {
        a(0, (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), r8, r9, r10);
    }

    @Override // com.bytedance.applog.log.j
    public void a(List<String> r3, String r4, Object... r5) {
        a(0, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.bytedance.applog.log.j
    public void b(int r2, String r3, Object... r4) {
        a(r2, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.j
    public void b(int r8, List<String> r9, String r10, Object... r11) {
        a(r8, 1, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), null, r10, r11);
    }

    @Override // com.bytedance.applog.log.j
    public void b(String r2, Object... r3) {
        a(null, r2, r3);
    }

    @Override // com.bytedance.applog.log.j
    public void b(List<String> r3, String r4, Object... r5) {
        b(0, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.bytedance.applog.log.j
    public void c(int r2, String r3, Object... r4) {
        b(r2, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.j
    public void c(int r8, List<String> r9, String r10, Object... r11) {
        a(r8, 3, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), null, r10, r11);
    }

    @Override // com.bytedance.applog.log.j
    public void c(String r2, Object... r3) {
        b(null, r2, r3);
    }

    @Override // com.bytedance.applog.log.j
    public void c(List<String> r3, String r4, Object... r5) {
        c(0, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.bytedance.applog.log.j
    public void d(int r2, String r3, Object... r4) {
        c(r2, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.j
    public void d(int r7, List<String> r8, String r9, Object... r10) {
        a(r7, (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), r9, null, r10);
    }

    @Override // com.bytedance.applog.log.j
    public void d(String r2, Object... r3) {
        c(null, r2, r3);
    }

    @Override // com.bytedance.applog.log.j
    public void d(List<String> r3, String r4, Object... r5) {
        a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, null, r5);
    }

    @Override // com.bytedance.applog.log.j
    public void e(int r2, String r3, Object... r4) {
        d(r2, null, r3, r4);
    }

    public void e(int r8, List<String> r9, String r10, Object... r11) {
        a(r8, 0, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), null, r10, r11);
    }

    @Override // com.bytedance.applog.log.j
    public void e(String r2, Object... r3) {
        a(r2, null, r3);
    }
}
