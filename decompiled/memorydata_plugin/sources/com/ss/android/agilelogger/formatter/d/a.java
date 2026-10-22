package com.ss.android.agilelogger.formatter.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15014a;

    public a() {
        this.f15014a = "Thread: ";
    }

    @Override // com.ss.android.agilelogger.formatter.a
    public /* synthetic */ String a(Object r3) {
        return a((Thread) ZeusTransformUtils.preCheckCast(r3, Thread.class, "com.obric.memorydata.plugin"));
    }

    public String a(Thread r2) {
        StringBuffer r1 = new StringBuffer();
        r1.append("Thread: ");
        r1.append(r2.getName());
        return r1.toString();
    }
}
