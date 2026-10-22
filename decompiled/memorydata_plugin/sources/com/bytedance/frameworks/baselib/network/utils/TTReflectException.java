package com.bytedance.frameworks.baselib.network.utils;

/* JADX INFO: loaded from: classes2.dex */
public class TTReflectException extends RuntimeException {
    private final String memberType;
    private final String targetClass;
    private final String targetMember;

    public TTReflectException(String r3) {
        this(r3, null, new String[0]);
    }

    public TTReflectException(String r2, Throwable r3, String... r4) {
        super(buildMessage(r2, r4), r3);
        String r5 = "unknown";
        if (r4.length <= 0) goto L5;
        String r6 = r4[0];
    L6:
        this.targetClass = r6;
        if (r4.length <= 1) goto L9;
        String r7 = r4[1];
    L10:
        this.targetMember = r7;
        if (r4.length <= 2) goto L13;
        r5 = r4[2];
    L13:
        this.memberType = r5;
        return;
    L9:
        r7 = "unknown";
        goto L10
    L5:
        r6 = "unknown";
        goto L6
    }

    private static String buildMessage(String r2, String... r3) {
        StringBuilder r0 = new StringBuilder(r2);
        if (r3 == null) goto L14;
        if (r3.length <= 0) goto L14;
        r0.append(" [TargetClass: ").append(r3[0]);
        if (r3.length <= 1) goto L10;
        r0.append(", TargetMember: ").append(r3[1]);
    L10:
        if (r3.length <= 2) goto L12;
        r0.append(", MemberType: ").append(r3[2]);
    L12:
        r0.append("]");
    L14:
        return r0.toString();
    }

    public String getMemberType() {
        return this.memberType;
    }

    public String getTargetClass() {
        return this.targetClass;
    }

    public String getTargetMember() {
        return this.targetMember;
    }
}
