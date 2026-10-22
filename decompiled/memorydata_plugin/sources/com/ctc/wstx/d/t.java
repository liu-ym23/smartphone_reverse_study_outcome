package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends g {
    final com.ctc.wstx.util.o g;

    public t(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5, com.ctc.wstx.util.o r6) {
        super(r1, r2, r3, r4, r5);
        this.g = r6;
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r9) {
        return new t(this.f3492b, this.d, r9, this.e, this.f, this.g);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r7, char[] r8, int r9, int r10, boolean r11) {
        String r12 = a(r8, r9, r10, r11, this.g);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return a(r7, "Invalid notation value '" + new String(r8, r9, r10 - r9) + "': has to be one of (" + this.g + ")");
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r5, boolean r6) {
        com.ctc.wstx.g.f r7 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = b(r7, r6);
        String r1 = this.g.a(r0);
        if (r1 != null) goto L5;
        a(r7, "Invalid default value '" + r0 + "': has to be one of (" + this.g + ")");
    L5:
        if (r6 == false) goto L8;
        this.d.a(r1);
        return;
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 7;
    }
}
