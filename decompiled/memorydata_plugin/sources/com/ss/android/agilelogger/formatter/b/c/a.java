package com.ss.android.agilelogger.formatter.b.c;

import com.ss.android.agilelogger.utils.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.agilelogger.formatter.a
    public /* synthetic */ String a(Object r3) {
        return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public String a(Throwable r1) {
        return c.a(r1);
    }
}
