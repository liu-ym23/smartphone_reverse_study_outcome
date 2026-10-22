package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class bb extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5347b;
    private ad e;
    private Object[] f;

    public bb(Context r3, bf r4, ad r5, String r6, Object... r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.f5346a = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.f5347b = r6;
        this.e = r5;
        this.f = r7;
    }

    private String b() {
        return String.format(fx.c(this.f5347b), this.f);
    L4:
        th = move-exception;
        th.printStackTrace();
        q.b(th, "ofm", "gpj");
        return "";
    }

    @Override // com.loc.bf
    public final byte[] a(byte[] r3) {
        String r4 = fx.a(r3);
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        String r0 = b();
        String r2 = fx.a(this.e.b(fx.a(r0)));
        StringBuilder r1 = new StringBuilder();
        r1.append("{\"pinfo\":\"").append(r2).append("\",\"els\":[");
        r1.append(r4);
        r1.append("]}");
        return fx.a(r1.toString());
    }
}
