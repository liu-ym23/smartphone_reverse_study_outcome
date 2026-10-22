package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends w {
    public ProcessedData C;
    public boolean D;

    public g(w r5, PostProcessRequest r10) {
        super(r5, null);
        this.C = null;
        this.D = false;
        this.f4441q = r10;
    }

    @Override // com.bytedance.forest.model.w
    public final void j() {
        ProcessedData r5 = this.C;
        if (r5 == null) goto L6;
        r5.tryLoadToMemory$forest_release(this);
        return;
    L6:
        super.j();
    }

    @Override // com.bytedance.forest.model.w
    public final byte[] k() {
        ProcessedData r5 = this.C;
        if (r5 == null) goto L7;
        return r5.provideBytes();
    L7:
        return super.k();
    }

    @Override // com.bytedance.forest.model.w
    public final InputStream l() {
        ProcessedData r5 = this.C;
        if (r5 == null) goto L7;
        return r5.provideInputStream(this);
    L7:
        return super.l();
    }

    public final Object o() {
        ProcessedData r5 = this.C;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getData();
    }

    @Override // com.bytedance.forest.model.w
    public final String toString() {
        return "{response: " + super.toString() + ", processedData:" + this.C;
    }

    public g(w r5, ProcessedData r10) {
        Request r11 = null;
        super(r5, null);
        boolean r12 = false;
        if (r10 == null) goto L5;
        this.D = true;
        d(r10);
    L6:
        this.C = r10;
        if (r10 == null) goto L9;
        r12 = true;
    L9:
        this.D = r12;
        Request r13 = r5.f4441q;
        if ((r13 instanceof PostProcessRequest) == false) goto L13;
        r11 = r13;
    L13:
        PostProcessRequest r14 = (PostProcessRequest) r11;
        if (r14 == null) goto L16;
        PostProcessRequest r15 = new PostProcessRequest(r14);
    L17:
        this.f4441q = r15;
        return;
    L16:
        Request r16 = this.f4441q;
        ForestPostProcessor.Companion.getClass();
        r15 = new PostProcessRequest(r16, new b(false, 1, null));
        goto L17
    L5:
        this.D = false;
        goto L6
    }
}
