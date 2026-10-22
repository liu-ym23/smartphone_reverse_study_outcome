package com.tom_roush.pdfbox.pdmodel.interactive.b.a;

import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tom_roush.pdfbox.a.b f16291a;

    public b() {
    }

    public b(i r1) {
        this.f16291a = r1;
    }

    public b(o r1) {
        this.f16291a = r1;
    }

    public String a() {
        if (ZeusTransformUtils.instanceOf(this.f16291a, o.class) == false) goto L6;
        return ((o) ZeusTransformUtils.preCheckCast(this.f16291a, o.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(this.f16291a, i.class) == true) goto L11;
        return null;
    L11:
        return ((i) ZeusTransformUtils.preCheckCast(this.f16291a, i.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.f16291a;
    }
}
