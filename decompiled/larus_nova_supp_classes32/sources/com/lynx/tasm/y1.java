package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y1 extends TemplateData {
    public final Map<String, Object> a;

    @Override // com.lynx.tasm.TemplateData
    public final boolean checkIsLegalData() {
        return true;
    }

    @Override // com.lynx.tasm.TemplateData
    public final void flush() {
    }

    @Override // com.lynx.tasm.TemplateData
    public final long getNativePtr() {
        return 0;
    }

    @Override // com.lynx.tasm.TemplateData
    public final TemplateData deepClone() {
        return new y1(this.a);
    }

    @Override // com.lynx.tasm.TemplateData
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.lynx.tasm.TemplateData
    public final TemplateData shallowClone() {
        TraceEvent.beginSection("TemplateData.ShallowClone");
        y1 r1 = new y1(this.a);
        TraceEvent.endSection("TemplateData.ShallowClone");
        return r1;
    }

    @Override // com.lynx.tasm.TemplateData
    public final Map<Object, Object> toMap() {
        return this.a;
    }

    public y1(Map<String, Object> r1) {
        this.a = r1;
        markReadOnly();
    }

    @Override // com.lynx.tasm.TemplateData
    public final void markState(String r2) {
        LLog.e("LynxTemplateData", "markState is not supported for static-page data");
    }

    @Override // com.lynx.tasm.TemplateData
    public final void updateWithTemplateData(TemplateData r2) {
        LLog.e("LynxTemplateData", "updateWithTemplateData is not supported for static-page data");
    }
}
