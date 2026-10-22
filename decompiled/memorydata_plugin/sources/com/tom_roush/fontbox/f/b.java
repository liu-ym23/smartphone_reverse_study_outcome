package com.tom_roush.fontbox.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b extends af {
    private com.tom_roush.fontbox.b.h c;

    private static class a implements com.tom_roush.fontbox.b.k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ah f15982a;

        a(ah r1) {
            this.f15982a = r1;
        }
    }

    b(ah r1) {
        super(r1);
    }

    public com.tom_roush.fontbox.b.h a() {
        return this.c;
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r3, ad r4) {
        byte[] r5 = r4.d((int) h());
        this.c = (com.tom_roush.fontbox.b.h) ZeusTransformUtils.preCheckCast(new com.tom_roush.fontbox.b.k().a(r5, new a(this.f15975b)).get(0), com.tom_roush.fontbox.b.h.class, "com.obric.memorydata.plugin");
        this.f15974a = true;
    }
}
