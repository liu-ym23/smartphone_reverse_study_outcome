package com.ss.android.har.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15244a = false;

    static {
    }

    public static String a(String r2) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case 49: goto L22;
            case 50: goto L18;
            case 51: goto L14;
            case 1444: goto L10;
            case 1445: goto L6;
            default: goto L25;
        };
    L25:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        return "static";
    L28:
        return "error";
    L30:
        return "disable";
    L32:
        return "lying";
    L34:
        return "walking";
    L36:
        return "bycar";
    L6:
        if (r2.equals("-2") == false) goto L25;
        r1 = 4;
        goto L25
    L10:
        if (r2.equals(StructuredDataId.RESERVED) == false) goto L25;
        r1 = 3;
        goto L25
    L14:
        if (r2.equals("3") == false) goto L25;
        r1 = 2;
        goto L25
    L18:
        if (r2.equals("2") == false) goto L25;
        r1 = 1;
        goto L25
    L22:
        if (r2.equals("1") == false) goto L25;
        r1 = 0;
        goto L25
    }

    public static String a(Map<String, Float> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L17:
        return "0";
    L5:
        if (r7.isEmpty() == true) goto L17;
        Map.Entry r0 = null;
        Iterator r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        if (r0 == null) goto L14;
        if (((Float) ZeusTransformUtils.preCheckCast(r0.getValue(), Float.class, "com.obric.memorydata.plugin")).floatValue() >= ((Float) ZeusTransformUtils.preCheckCast(r2.getValue(), Float.class, "com.obric.memorydata.plugin")).floatValue()) goto L8;
    L14:
        r0 = r2;
        goto L8
    L15:
        if (r0 == null) goto L17;
        return (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
    }

    public static int b(String r6) {
        r6.hashCode();
        switch(r6.hashCode()) {
            case 49: goto L22;
            case 50: goto L18;
            case 51: goto L14;
            case 1444: goto L10;
            case 1445: goto L6;
            default: goto L4;
        };
    L4:
        byte r7 = -1;
    L25:
        switch(r7) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return 0;
    L27:
        return -2;
    L29:
        return -1;
    L30:
        return 3;
    L31:
        return 2;
    L32:
        return 1;
    L6:
        if (r6.equals("-2") == false) goto L33;
        r7 = 4;
        goto L25
    L33:
        r7 = -1;
        goto L25
    L10:
        if (r6.equals(StructuredDataId.RESERVED) == false) goto L34;
        r7 = 3;
        goto L25
    L34:
        r7 = -1;
        goto L25
    L14:
        if (r6.equals("3") == false) goto L35;
        r7 = 2;
        goto L25
    L35:
        r7 = -1;
        goto L25
    L18:
        if (r6.equals("2") == false) goto L36;
        r7 = 1;
        goto L25
    L36:
        r7 = -1;
        goto L25
    L22:
        if (r6.equals("1") == false) goto L37;
        r7 = 0;
        goto L25
    L37:
        r7 = -1;
        goto L25
    }
}
