package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
public class StructuredDataMessage extends MapMessage<StructuredDataMessage, String> {
    private static final int HASHVAL = 31;
    private static final int MAX_LENGTH = 32;
    private static final long serialVersionUID = 1703221292892071920L;
    private StructuredDataId id;
    private final int maxLength;
    private String message;
    private String type;

    public static final enum Format extends Enum<Format> {
        private static final /* synthetic */ Format[] $VALUES = null;
        public static final Format FULL = null;
        public static final Format XML = null;

        static {
            Format r0 = new Format("XML", 0);
            XML = r0;
            Format r1 = new Format("FULL", 1);
            FULL = r1;
            $VALUES = new Format[]{r0, r1};
        }

        private Format(String r1, int r2) {
            super(r1, r2);
        }

        public static Format valueOf(String r2) {
            return (Format) ZeusTransformUtils.preCheckCast(Enum.valueOf(Format.class, r2), Format.class, "com.obric.memorydata.plugin");
        }

        public static Format[] values() {
            return (Format[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Format[].class, "com.obric.memorydata.plugin");
        }
    }

    public StructuredDataMessage() {
        this.maxLength = 32;
    }

    public StructuredDataMessage(String r2, String r3, String r4) {
        this(r2, r3, r4, 32);
    }

    public StructuredDataMessage(String r3, String r4, String r5, int r6) {
        this.id = new StructuredDataId(r3, null, null, r6);
        this.message = r4;
        this.type = r5;
        this.maxLength = r6;
    }

    public StructuredDataMessage(String r7, String r8, String r9, Map<String, String> r10) {
        this(r7, r8, r9, (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin"), 32);
    }

    public StructuredDataMessage(String r3, String r4, String r5, Map<String, String> r6, int r7) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        this.id = new StructuredDataId(r3, null, null, r7);
        this.message = r4;
        this.type = r5;
        this.maxLength = r7;
    }

    public StructuredDataMessage(StructuredDataId r2, String r3, String r4) {
        this(r2, r3, r4, 32);
    }

    public StructuredDataMessage(StructuredDataId r1, String r2, String r3, int r4) {
        this.id = r1;
        this.message = r2;
        this.type = r3;
        this.maxLength = r4;
    }

    public StructuredDataMessage(StructuredDataId r7, String r8, String r9, Map<String, String> r10) {
        this(r7, r8, r9, (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin"), 32);
    }

    public StructuredDataMessage(StructuredDataId r3, String r4, String r5, Map<String, String> r6, int r7) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        this.id = r3;
        this.message = r4;
        this.type = r5;
        this.maxLength = r7;
    }

    private StructuredDataMessage(StructuredDataMessage r3, Map<String, String> r4) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        this.id = r3.id;
        this.message = r3.message;
        this.type = r3.type;
        this.maxLength = 32;
    }

    private void asXml(StructuredDataId r3, StringBuilder r4) {
        r4.append("<StructuredData>\n");
        r4.append("<type>").append(this.type).append("</type>\n");
        r4.append("<id>").append(r3).append("</id>\n");
        super.asXml(r4);
        r4.append("\n</StructuredData>\n");
    }

    private Format getFormat(String[] r3) {
        if (r3 == null) goto L20;
        if (r3.length <= 0) goto L20;
        int r2 = 0;
    L7:
        if (r2 >= r3.length) goto L17;
        String r0 = r3[r2];
        if (Format.XML.name().equalsIgnoreCase(r0) == true) goto L11;
        if (Format.FULL.name().equalsIgnoreCase(r0) == true) goto L15;
        r2 = r2 + 1;
        goto L7
    L15:
        return Format.FULL;
    L11:
        return Format.XML;
    L17:
        return null;
    L20:
        return Format.FULL;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public String asString() {
        return asString(Format.FULL, null);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public String asString(String r3) {
        return asString((Format) ZeusTransformUtils.preCheckCast(org.apache.logging.log4j.util.d.a(Format.class, r3), Format.class, "com.obric.memorydata.plugin"), null);
    L5:
        return asString();
    }

    public final String asString(Format r2, StructuredDataId r3) {
        StringBuilder r0 = new StringBuilder();
        asString(r2, r3, r0);
        return r0.toString();
    }

    public final void asString(Format r4, StructuredDataId r5, StringBuilder r6) {
        boolean r0 = Format.FULL.equals(r4);
        if (r0 == true) goto L5;
    L8:
        StructuredDataId r2 = getId();
        if (r2 == null) goto L11;
        r5 = r2.makeId(r5);
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.getName() != null) goto L16;
        return;
    L16:
        if (Format.XML.equals(r4) == false) goto L19;
        asXml(r5, r6);
        return;
    L19:
        r6.append('[');
        r.b(r6, r5);
        r6.append(' ');
        appendMap(r6);
        r6.append(']');
        if (r0 == false) goto L26;
        String r3 = getFormat();
        if (r3 == null) goto L27;
        r6.append(' ').append(r3);
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (getType() != null) goto L7;
        return;
    L7:
        r6.append(getType()).append(' ');
        goto L8
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L38:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L38;
        StructuredDataMessage r2 = (StructuredDataMessage) ZeusTransformUtils.preCheckCast(r5, StructuredDataMessage.class, "com.obric.memorydata.plugin");
        if (super.equals(r5) == true) goto L13;
        return false;
    L13:
        String r6 = this.type;
        if (r6 == null) goto L19;
        if (r6.equals(r2.type) == false) goto L20;
    L21:
        StructuredDataId r7 = this.id;
        if (r7 == null) goto L27;
        if (r7.equals(r2.id) == false) goto L28;
    L29:
        String r4 = this.message;
        if (r4 == null) goto L35;
        if (r4.equals(r2.message) == false) goto L36;
    L37:
        return true;
    L36:
        return false;
    L35:
        if (r2.message == null) goto L37;
    L28:
        return false;
    L27:
        if (r2.id == null) goto L29;
    L20:
        return false;
    L19:
        if (r2.type == null) goto L21;
        goto L20
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r3) {
        asString(Format.FULL, null, r3);
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.util.MultiFormatStringBuilderFormattable
    public void formatTo(String[] r2, StringBuilder r3) {
        asString(getFormat(r2), null, r3);
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.message;
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.MultiformatMessage
    public String[] getFormats() {
        String[] r6 = new String[Format.values().length];
        Format[] r0 = Format.values();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r6[r3] = r0[r2].name();
        r2 = r2 + 1;
        r3 = r3 + 1;
        goto L3
    L5:
        return r6;
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        return asString(Format.FULL, null);
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.MultiformatMessage
    public String getFormattedMessage(String[] r2) {
        return asString(getFormat(r2), null);
    }

    public StructuredDataId getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        String r1 = this.type;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        StructuredDataId r5 = this.id;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.message;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public /* synthetic */ MapMessage newInstance(Map<String, String> r3) {
        return newInstance2((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    /* JADX INFO: renamed from: newInstance, reason: avoid collision after fix types in other method */
    public StructuredDataMessage newInstance2(Map<String, String> r3) {
        return new StructuredDataMessage(this, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public void setId(String r3) {
        this.id = new StructuredDataId(r3, null, null);
    }

    public void setId(StructuredDataId r1) {
        this.id = r1;
    }

    public void setMessageFormat(String r1) {
        this.message = r1;
    }

    public void setType(String r3) {
        if (r3.length() > 32) goto L7;
        this.type = r3;
        return;
    L7:
        throw new IllegalArgumentException("structured data type exceeds maximum length of 32 characters: " + r3);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public String toString() {
        return asString(null, null);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, byte r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, char r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, double r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, float r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, int r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, long r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, Object r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, String r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, short r2) {
        validateKey(r1);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String r1, boolean r2) {
        validateKey(r1);
    }

    public void validateKey(String r4) {
        if (this.maxLength > 0) goto L5;
    L9:
        int r3 = 0;
    L11:
        if (r3 >= r4.length()) goto L25;
        char r0 = r4.charAt(r3);
        if (r0 < '!') goto L24;
        if (r0 > '~') goto L24;
        if (r0 == '=') goto L24;
        if (r0 == ']') goto L24;
        if (r0 == '\"') goto L24;
        r3 = r3 + 1;
    L24:
        throw new IllegalArgumentException("Structured data keys must contain printable US ASCII charactersand may not contain a space, =, ], or \"");
    L25:
        return;
    L5:
        if (r4.length() <= this.maxLength) goto L9;
        throw new IllegalArgumentException("Structured data keys are limited to " + this.maxLength + " characters. key: " + r4);
    }
}
