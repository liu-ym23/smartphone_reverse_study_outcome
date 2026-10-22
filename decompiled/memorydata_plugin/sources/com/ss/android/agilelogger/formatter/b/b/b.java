package com.ss.android.agilelogger.formatter.b.b;

import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class b implements c<Intent> {
    public b() {
    }

    public String a(Intent r1) {
        return com.ss.android.agilelogger.utils.b.a(r1);
    }

    @Override // com.ss.android.agilelogger.formatter.a
    public /* synthetic */ String a(Object r3) {
        return a((Intent) ZeusTransformUtils.preCheckCast(r3, Intent.class, "com.obric.memorydata.plugin"));
    }
}
