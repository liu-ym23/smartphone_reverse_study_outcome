package org.apache.poi.openxml4j.opc.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class ContentType {
    private static final Pattern patternParams = null;
    private static final Pattern patternTypeSubType = null;
    private static final Pattern patternTypeSubTypeParams = null;
    private final Map<String, String> parameters;
    private final String subType;
    private final String type;

    static {
        String r0 = "([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+\"?)";
        patternTypeSubType = Pattern.compile("^([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)$");
        patternTypeSubTypeParams = Pattern.compile("^([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)(;" + r0 + ")*$");
        patternParams = Pattern.compile(";" + r0);
    }

    public ContentType(String r6) {
        Matcher r0 = patternTypeSubType.matcher(r6);
        if (r0.matches() == true) goto L6;
        r0 = patternTypeSubTypeParams.matcher(r6);
    L6:
        if (r0.matches() == false) goto L18;
        if (r0.groupCount() < 2) goto L15;
        this.type = r0.group(1);
        this.subType = r0.group(2);
        this.parameters = new HashMap();
        if (r0.groupCount() < 5) goto L20;
        Matcher r7 = patternParams.matcher(r6.substring(r0.end(2)));
    L13:
        if (r7.find() == false) goto L21;
        this.parameters.put(r7.group(1), r7.group(2));
        goto L13
    L21:
        return;
    L20:
        return;
    L15:
        this.type = "";
        this.subType = "";
        this.parameters = Collections.emptyMap();
        return;
    L18:
        throw new InvalidFormatException("The specified content type '" + r6 + "' is not compliant with RFC 2616: malformed content type.");
    }

    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ContentType.class) == true) goto L5;
    L8:
        return true;
    L5:
        if (toString().equalsIgnoreCase(r2.toString()) == true) goto L8;
        return false;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, this.subType, this.parameters});
    }

    public final String toString() {
        return toString(true);
    }

    public final String toString(boolean r5) {
        StringBuilder r0 = new StringBuilder(64);
        r0.append(getType());
        r0.append('/');
        r0.append(getSubType());
        if (r5 == false) goto L9;
        Iterator<Map.Entry<String, String>> r4 = this.parameters.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.append(';');
        r0.append((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"));
        r0.append('=');
        r0.append((String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));
    L9:
        return r0.toString();
    }
}
