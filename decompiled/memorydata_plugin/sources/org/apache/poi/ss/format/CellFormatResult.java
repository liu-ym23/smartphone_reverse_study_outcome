package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;

/* JADX INFO: loaded from: classes7.dex */
public class CellFormatResult {
    public final boolean applies;
    public final String text;
    public final Color textColor;

    public CellFormatResult(boolean r3, String r4, Color r5) {
        Color r6 = (Color) ZeusTransformUtils.wrapperContextForParams(r5, Color.class, "com.obric.memorydata.plugin");
        this.applies = r3;
        if (r4 == null) goto L11;
        this.text = r4;
        if (r3 == true) goto L8;
        r6 = null;
    L8:
        this.textColor = r6;
        return;
    L11:
        throw new IllegalArgumentException("CellFormatResult text may not be null");
    }
}
