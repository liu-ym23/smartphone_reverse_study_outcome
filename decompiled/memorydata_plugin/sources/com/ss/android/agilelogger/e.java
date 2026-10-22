package com.ss.android.agilelogger;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class e implements com.bytedance.android.alog.b {
    e() {
    }

    @Override // com.bytedance.android.alog.b
    public void a(String r3) {
        com.bytedance.librarian.a.a("alog", (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f14994a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("alog");
    }
}
