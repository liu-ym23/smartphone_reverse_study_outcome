package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XmlDocumentProperties {
    public static final Object DOCTYPE_NAME = null;
    public static final Object DOCTYPE_PUBLIC_ID = null;
    public static final Object DOCTYPE_SYSTEM_ID = null;
    public static final Object ENCODING = null;
    public static final Object MESSAGE_DIGEST = null;
    public static final Object SOURCE_NAME = null;
    public static final Object STANDALONE = null;
    public static final Object VERSION = null;

    static {
        SOURCE_NAME = new Object();
        ENCODING = new Object();
        VERSION = new Object();
        STANDALONE = new Object();
        DOCTYPE_NAME = new Object();
        DOCTYPE_PUBLIC_ID = new Object();
        DOCTYPE_SYSTEM_ID = new Object();
        MESSAGE_DIGEST = new Object();
    }

    public XmlDocumentProperties() {
    }

    public abstract Object get(Object r1);

    public String getDoctypeName() {
        return (String) ZeusTransformUtils.preCheckCast(get(DOCTYPE_NAME), String.class, "com.obric.memorydata.plugin");
    }

    public String getDoctypePublicId() {
        return (String) ZeusTransformUtils.preCheckCast(get(DOCTYPE_PUBLIC_ID), String.class, "com.obric.memorydata.plugin");
    }

    public String getDoctypeSystemId() {
        return (String) ZeusTransformUtils.preCheckCast(get(DOCTYPE_SYSTEM_ID), String.class, "com.obric.memorydata.plugin");
    }

    public String getEncoding() {
        return (String) ZeusTransformUtils.preCheckCast(get(ENCODING), String.class, "com.obric.memorydata.plugin");
    }

    public String getSourceName() {
        return (String) ZeusTransformUtils.preCheckCast(get(SOURCE_NAME), String.class, "com.obric.memorydata.plugin");
    }

    public boolean getStandalone() {
        Object r1 = get(STANDALONE);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.toString().equalsIgnoreCase("true") == false) goto L7;
        return true;
    }

    public String getVersion() {
        return (String) ZeusTransformUtils.preCheckCast(get(VERSION), String.class, "com.obric.memorydata.plugin");
    }

    public abstract Object put(Object r1, Object r2);

    public void setDoctypeName(String r2) {
        put(DOCTYPE_NAME, r2);
    }

    public void setDoctypePublicId(String r2) {
        put(DOCTYPE_PUBLIC_ID, r2);
    }

    public void setDoctypeSystemId(String r2) {
        put(DOCTYPE_SYSTEM_ID, r2);
    }

    public void setEncoding(String r2) {
        put(ENCODING, r2);
    }

    public void setMessageDigest(byte[] r2) {
        put(MESSAGE_DIGEST, r2);
    }

    public void setSourceName(String r2) {
        put(SOURCE_NAME, r2);
    }

    public void setStandalone(boolean r2) {
        Object r0 = STANDALONE;
        if (r2 == false) goto L5;
        String r3 = "true";
    L6:
        put(r0, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void setVersion(String r2) {
        put(VERSION, r2);
    }
}
