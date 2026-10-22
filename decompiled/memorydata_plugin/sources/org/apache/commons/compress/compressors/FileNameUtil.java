package org.apache.commons.compress.compressors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class FileNameUtil {
    private final Map<String, String> compressSuffix;
    private final String defaultExtension;
    private final int longestCompressedSuffix;
    private final int longestUncompressedSuffix;
    private final int shortestCompressedSuffix;
    private final int shortestUncompressedSuffix;
    private final Map<String, String> uncompressSuffix;

    public FileNameUtil(Map<String, String> r10, String r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        this.compressSuffix = new HashMap();
        this.uncompressSuffix = Collections.unmodifiableMap(r12);
        Iterator r13 = r12.entrySet().iterator();
        int r0 = Integer.MAX_VALUE;
        int r3 = Integer.MIN_VALUE;
        int r4 = Integer.MIN_VALUE;
        int r2 = Integer.MAX_VALUE;
    L4:
        if (r13.hasNext() == false) goto L19;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r6 = ((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin")).length();
        if (r6 <= r3) goto L8;
        r3 = r6;
    L8:
        if (r6 >= r0) goto L10;
        r0 = r6;
    L10:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.memorydata.plugin");
        int r8 = r7.length();
        if (r8 <= 0) goto L4;
        if (this.compressSuffix.containsKey(r7) == true) goto L15;
        this.compressSuffix.put(r7, (String) r5.getKey());
    L15:
        if (r8 <= r4) goto L17;
        r4 = r8;
    L17:
        if (r8 >= r2) goto L4;
        r2 = r8;
        goto L4
    L19:
        this.longestCompressedSuffix = r3;
        this.longestUncompressedSuffix = r4;
        this.shortestCompressedSuffix = r0;
        this.shortestUncompressedSuffix = r2;
        this.defaultExtension = r11;
    }
}
