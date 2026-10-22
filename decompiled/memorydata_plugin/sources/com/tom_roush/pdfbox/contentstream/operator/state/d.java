package com.tom_roush.pdfbox.contentstream.operator.state;

import android.util.Log;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class d extends com.tom_roush.pdfbox.contentstream.operator.c {
    public d() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "gs";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L14;
        com.tom_roush.pdfbox.a.b r6 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r5.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, i.class) == true) goto L7;
        return;
    L7:
        i r7 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.graphics.state.a r8 = this.f16096a.getResources().d(r7);
        if (r8 != null) goto L11;
        Log.e("PdfBox-Android", "name for 'gs' operator not found in resources: /" + r7.a());
        return;
    L11:
        r8.a(this.f16096a.g());
        return;
    L14:
        throw new MissingOperandException(r3, r5);
    }
}
