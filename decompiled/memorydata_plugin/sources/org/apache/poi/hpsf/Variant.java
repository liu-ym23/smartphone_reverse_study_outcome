package org.apache.poi.hpsf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class Variant {
    public static final Integer LENGTH_0 = null;
    public static final Integer LENGTH_2 = null;
    public static final Integer LENGTH_4 = null;
    public static final Integer LENGTH_8 = null;
    public static final Integer LENGTH_UNKNOWN = null;
    public static final Integer LENGTH_VARIABLE = null;
    private static final Object[][] NUMBER_TO_NAME_LIST = null;
    private static final Map<Long, Integer> numberToLength = null;
    private static final Map<Long, String> numberToName = null;

    static {
        LENGTH_UNKNOWN = -2;
        LENGTH_VARIABLE = -1;
        LENGTH_0 = 0;
        LENGTH_2 = 2;
        LENGTH_4 = 4;
        LENGTH_8 = 8;
        Object[][] r10 = {new Object[]{0L, "VT_EMPTY", 0}, new Object[]{1L, "VT_NULL", -2}, new Object[]{2L, "VT_I2", 2}, new Object[]{3L, "VT_I4", 4}, new Object[]{4L, "VT_R4", 4}, new Object[]{5L, "VT_R8", 8}, new Object[]{6L, "VT_CY", -2}, new Object[]{7L, "VT_DATE", -2}, new Object[]{8L, "VT_BSTR", -2}, new Object[]{9L, "VT_DISPATCH", -2}, new Object[]{10L, "VT_ERROR", -2}, new Object[]{11L, "VT_BOOL", -2}, new Object[]{12L, "VT_VARIANT", -2}, new Object[]{13L, "VT_UNKNOWN", -2}, new Object[]{14L, "VT_DECIMAL", -2}, new Object[]{16L, "VT_I1", -2}, new Object[]{17L, "VT_UI1", -2}, new Object[]{18L, "VT_UI2", -2}, new Object[]{19L, "VT_UI4", -2}, new Object[]{20L, "VT_I8", -2}, new Object[]{21L, "VT_UI8", -2}, new Object[]{22L, "VT_INT", -2}, new Object[]{23L, "VT_UINT", -2}, new Object[]{24L, "VT_VOID", -2}, new Object[]{25L, "VT_HRESULT", -2}, new Object[]{26L, "VT_PTR", -2}, new Object[]{27L, "VT_SAFEARRAY", -2}, new Object[]{28L, "VT_CARRAY", -2}, new Object[]{29L, "VT_USERDEFINED", -2}, new Object[]{30L, "VT_LPSTR", -1}, new Object[]{31L, "VT_LPWSTR", -2}, new Object[]{64L, "VT_FILETIME", 8}, new Object[]{65L, "VT_BLOB", -2}, new Object[]{66L, "VT_STREAM", -2}, new Object[]{67L, "VT_STORAGE", -2}, new Object[]{68L, "VT_STREAMED_OBJECT", -2}, new Object[]{69L, "VT_STORED_OBJECT", -2}, new Object[]{70L, "VT_BLOB_OBJECT", -2}, new Object[]{71L, "VT_CF", -2}, new Object[]{72L, "VT_CLSID", -2}};
        NUMBER_TO_NAME_LIST = r10;
        HashMap r0 = new HashMap(r10.length, 1.0f);
        HashMap r1 = new HashMap(r10.length, 1.0f);
        int r3 = r10.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        Object[] r6 = r10[r5];
        r0.put((Long) ZeusTransformUtils.preCheckCast(r6[0], Long.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r6[1], String.class, "com.obric.memorydata.plugin"));
        r1.put((Long) ZeusTransformUtils.preCheckCast(r6[0], Long.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r6[2], Integer.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L3
    L5:
        numberToName = Collections.unmodifiableMap(r0);
        numberToLength = Collections.unmodifiableMap(r1);
    }

    public static String getVariantName(long r6) {
        if ((r6 & 4096) == 0) goto L6;
        r6 = r6 - 4096;
        String r0 = "Vector of ";
    L12:
        String r7 = r0 + ((String) ZeusTransformUtils.preCheckCast(numberToName.get(Long.valueOf(r6)), String.class, "com.obric.memorydata.plugin"));
        if (r7.isEmpty() == false) goto L17;
        return "unknown variant type";
    L17:
        return r7;
    L6:
        if ((r6 & PlaybackStateCompat.ACTION_PLAY_FROM_URI) == 0) goto L9;
        r6 = r6 - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        r0 = "Array of ";
        goto L12
    L9:
        if ((r6 & 16384) == 0) goto L11;
        r6 = r6 - 16384;
        r0 = "ByRef of ";
        goto L12
    L11:
        r0 = "";
        goto L12
    }
}
