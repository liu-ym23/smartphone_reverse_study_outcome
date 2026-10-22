package io.noties.markwon.html;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class g {
    public g() {
    }

    public String a(j r3) {
        j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        String r4 = r2.a();
        if ("br".equals(r4) == false) goto L6;
        return "\n";
    L6:
        if ("img".equals(r4) == false) goto L13;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.e().get("alt"), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
    L11:
        return "￼";
    L10:
        if (r5.length() == 0) goto L11;
        return r5;
    L13:
        if ("iframe".equals(r4) == false) goto L15;
        return " ";
    L15:
        return null;
    }
}
