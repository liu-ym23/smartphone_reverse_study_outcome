package org.apache.commons.math3.geometry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public abstract class VectorFormat<S extends Space> {
    private final NumberFormat format;
    private final String prefix;
    private final String separator;
    private final String suffix;
    private final String trimmedPrefix;
    private final String trimmedSeparator;
    private final String trimmedSuffix;

    public VectorFormat(String r1, String r2, String r3, NumberFormat r4) {
        this.prefix = r1;
        this.suffix = r2;
        this.separator = r3;
        this.trimmedPrefix = r1.trim();
        this.trimmedSuffix = r2.trim();
        this.trimmedSeparator = r3.trim();
        this.format = r4;
    }

    public String format(Vector<S> r4) {
        return format((Vector) ZeusTransformUtils.wrapperContextForParams(r4, Vector.class, "com.obric.memorydata.plugin"), new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(StringBuffer r5, FieldPosition r6, double... r7) {
        int r0 = 0;
        r6.setBeginIndex(0);
        r6.setEndIndex(0);
        r5.append(this.prefix);
    L4:
        if (r0 >= r7.length) goto L8;
        if (r0 <= 0) goto L7;
        r5.append(this.separator);
    L7:
        CompositeFormat.formatDouble(r7[r0], this.format, r5, r6);
        r0 = r0 + 1;
        goto L4
    L8:
        r5.append(this.suffix);
        return r5;
    }

    public abstract StringBuffer format(Vector<S> r1, StringBuffer r2, FieldPosition r3);
}
