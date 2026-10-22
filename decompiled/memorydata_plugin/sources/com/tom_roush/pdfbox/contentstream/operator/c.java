package com.tom_roush.pdfbox.contentstream.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tom_roush.pdfbox.contentstream.b f16096a;

    public c() {
    }

    public abstract String a();

    public void a(com.tom_roush.pdfbox.contentstream.b r1) {
        this.f16096a = r1;
    }

    public abstract void a(b r1, List<com.tom_roush.pdfbox.a.b> r2);

    public boolean a(List<com.tom_roush.pdfbox.a.b> r3, Class<?> r4) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r4, (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final com.tom_roush.pdfbox.contentstream.b getContext() {
        return this.f16096a;
    }
}
