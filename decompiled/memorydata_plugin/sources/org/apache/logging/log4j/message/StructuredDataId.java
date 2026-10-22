package org.apache.logging.log4j.message;

import com.bytedance.bdinstall.Api;
import java.io.Serializable;
import org.apache.logging.log4j.util.q;
import org.apache.logging.log4j.util.s;

/* JADX INFO: loaded from: classes6.dex */
public class StructuredDataId implements Serializable, q {
    private static final String AT_SIGN = "@";
    private static final int MAX_LENGTH = 32;
    public static final StructuredDataId META = null;
    public static final StructuredDataId ORIGIN = null;
    public static final String RESERVED = "-1";
    public static final StructuredDataId TIME_QUALITY = null;
    private static final long serialVersionUID = -8252896346202183738L;
    private final String enterpriseNumber;
    private final String name;
    private final String[] optional;
    private final String[] required;

    static {
        TIME_QUALITY = new StructuredDataId("timeQuality", null, new String[]{"tzKnown", "isSynced", "syncAccuracy"});
        ORIGIN = new StructuredDataId("origin", null, new String[]{"ip", "enterpriseId", "software", "swVersion"});
        META = new StructuredDataId("meta", null, new String[]{"sequenceId", "sysUpTime", Api.KEY_LANGUAGE});
    }

    public StructuredDataId(String r3) {
        this(r3, null, null, 32);
    }

    public StructuredDataId(String r2, int r3) {
        this(r2, null, null, r3);
    }

    @Deprecated
    public StructuredDataId(String r7, int r8, String[] r9, String[] r10) {
        this(r7, String.valueOf(r8), r9, r10, 32);
    }

    @Deprecated
    public StructuredDataId(String r7, int r8, String[] r9, String[] r10, int r11) {
        this(r7, String.valueOf(r8), r9, r10, r11);
    }

    public StructuredDataId(String r7, String r8, String[] r9, String[] r10) {
        this(r7, r8, r9, r10, 32);
    }

    public StructuredDataId(String r3, String r4, String[] r5, String[] r6, int r7) {
        if (r3 == null) goto L22;
        if (r3.contains(AT_SIGN) == true) goto L20;
        if (RESERVED.equals(r4) == true) goto L18;
        this.name = r3;
        this.enterpriseNumber = r4;
        String r8 = r3 + AT_SIGN + r4;
        if (r7 > 0) goto L11;
    L15:
        this.required = r5;
        this.optional = r6;
        return;
    L11:
        if (r8.length() <= r7) goto L15;
        throw new IllegalArgumentException("Length of id exceeds maximum of " + r7 + " characters: " + r8);
    L18:
        throw new IllegalArgumentException("No enterprise number was supplied");
    L20:
        throw new IllegalArgumentException("Structured id name cannot contain an " + s.a(AT_SIGN));
    L22:
        throw new IllegalArgumentException("No structured id name was supplied");
    }

    public StructuredDataId(String r2, String[] r3, String[] r4) {
        this(r2, r3, r4, 32);
    }

    public StructuredDataId(String r4, String[] r5, String[] r6, int r7) {
        if (r4 == null) goto L11;
        if (r7 > 0) goto L7;
        r7 = 32;
    L7:
        if (r4.length() > r7) goto L10;
        int r8 = r4.indexOf(AT_SIGN);
    L12:
        if (r8 <= 0) goto L14;
        this.name = r4.substring(0, r8);
        String r9 = r4.substring(r8 + 1).trim();
    L15:
        this.enterpriseNumber = r9;
        this.required = r5;
        this.optional = r6;
        return;
    L14:
        this.name = r4;
        r9 = RESERVED;
        goto L15
    L10:
        throw new IllegalArgumentException(String.format("Length of id %s exceeds maximum of %d characters", new Object[]{r4, Integer.valueOf(r7)}));
    L11:
        r8 = -1;
        goto L12
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r2) {
        if (isReserved() == false) goto L5;
        String r1 = this.name;
    L6:
        r2.append(r1);
        return;
    L5:
        r2 = r2.append(this.name).append(AT_SIGN);
        r1 = this.enterpriseNumber;
        goto L6
    }

    public String getEnterpriseNumber() {
        return this.enterpriseNumber;
    }

    public String getName() {
        return this.name;
    }

    public String[] getOptional() {
        return this.optional;
    }

    public String[] getRequired() {
        return this.required;
    }

    public boolean isReserved() {
        return RESERVED.equals(this.enterpriseNumber);
    }

    @Deprecated
    public StructuredDataId makeId(String r1, int r2) {
        return makeId(r1, String.valueOf(r2));
    }

    public StructuredDataId makeId(String r3, String r4) {
        if (RESERVED.equals(r4) == false) goto L5;
        return this;
    L5:
        String r0 = this.name;
        String[] r1 = null;
        if (r0 == null) goto L8;
        r1 = this.required;
        String[] r2 = this.optional;
        r3 = r0;
    L10:
        return new StructuredDataId(r3, r4, r1, r2);
    L8:
        r2 = null;
        goto L10
    }

    public StructuredDataId makeId(StructuredDataId r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return makeId(r2.getName(), r2.getEnterpriseNumber());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.name.length() + 10);
        formatTo(r0);
        return r0.toString();
    }
}
