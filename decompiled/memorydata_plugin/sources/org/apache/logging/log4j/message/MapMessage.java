package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.util.IndexedReadOnlyStringMap;
import org.apache.logging.log4j.util.IndexedStringMap;
import org.apache.logging.log4j.util.MultiFormatStringBuilderFormattable;
import org.apache.logging.log4j.util.SortedArrayStringMap;
import org.apache.logging.log4j.util.r;
import org.apache.logging.log4j.util.u;

/* JADX INFO: loaded from: classes6.dex */
public class MapMessage<M extends MapMessage<M, V>, V> implements MultiFormatStringBuilderFormattable {
    private static final long serialVersionUID = -5031471831131487120L;
    private final IndexedStringMap data;

    /* JADX INFO: renamed from: org.apache.logging.log4j.message.MapMessage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17888a = null;

        static {
            int[] r0 = new int[MapFormat.values().length];
            f17888a = r0;
            r0[MapFormat.XML.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f17888a[MapFormat.JSON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f17888a[MapFormat.JAVA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f17888a[MapFormat.JAVA_UNQUOTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum MapFormat extends Enum<MapFormat> {
        private static final /* synthetic */ MapFormat[] $VALUES = null;
        public static final MapFormat JAVA = null;
        public static final MapFormat JAVA_UNQUOTED = null;
        public static final MapFormat JSON = null;
        public static final MapFormat XML = null;

        static {
            MapFormat r0 = new MapFormat("XML", 0);
            XML = r0;
            MapFormat r1 = new MapFormat("JSON", 1);
            JSON = r1;
            MapFormat r3 = new MapFormat("JAVA", 2);
            JAVA = r3;
            MapFormat r5 = new MapFormat("JAVA_UNQUOTED", 3);
            JAVA_UNQUOTED = r5;
            $VALUES = new MapFormat[]{r0, r1, r3, r5};
        }

        private MapFormat(String r1, int r2) {
            super(r1, r2);
        }

        public static MapFormat lookupIgnoreCase(String r2) {
            MapFormat r0 = XML;
            if (r0.name().equalsIgnoreCase(r2) == true) goto L16;
            MapFormat r1 = JSON;
            if (r1.name().equalsIgnoreCase(r2) == true) goto L17;
            MapFormat r3 = JAVA;
            if (r3.name().equalsIgnoreCase(r2) == true) goto L18;
            MapFormat r4 = JAVA_UNQUOTED;
            if (r4.name().equalsIgnoreCase(r2) == true) goto L19;
            return null;
        L19:
            return r4;
        L18:
            return r3;
        L17:
            return r1;
        L16:
            return r0;
        }

        public static String[] names() {
            return new String[]{XML.name(), JSON.name(), JAVA.name(), JAVA_UNQUOTED.name()};
        }

        public static MapFormat valueOf(String r2) {
            return (MapFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapFormat.class, r2), MapFormat.class, "com.obric.memorydata.plugin");
        }

        public static MapFormat[] values() {
            return (MapFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapFormat[].class, "com.obric.memorydata.plugin");
        }
    }

    public MapMessage() {
        this.data = new SortedArrayStringMap();
    }

    public MapMessage(int r2) {
        this.data = new SortedArrayStringMap(r2);
    }

    public MapMessage(Map<String, V> r3) {
        this.data = new SortedArrayStringMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private void asJava(StringBuilder r4, boolean r5) {
        r4.append('{');
        int r0 = 0;
    L4:
        if (r0 >= this.data.size()) goto L14;
        if (r0 <= 0) goto L7;
        r4.append(", ");
    L7:
        r4.append(this.data.getKeyAt(r0)).append('=');
        if (r5 == false) goto L10;
        r4.append(Typography.quote);
    L10:
        g.a(this.data.getValueAt(r0), r4);
        if (r5 == false) goto L13;
        r4.append(Typography.quote);
    L13:
        r0 = r0 + 1;
        goto L4
    L14:
        r4.append('}');
    }

    private StringBuilder format(MapFormat r2, StringBuilder r3) {
        if (r2 != null) goto L4;
    L3:
        appendMap(r3);
    L17:
        return r3;
    L4:
        int r4 = AnonymousClass1.f17888a[r2.ordinal()];
        if (r4 != 1) goto L7;
        asXml(r3);
        goto L17
    L7:
        if (r4 != 2) goto L9;
        asJson(r3);
        goto L17
    L9:
        if (r4 != 3) goto L11;
        asJava(r3);
        goto L17
    L11:
        if (r4 != 4) goto L3;
        asJavaUnquoted(r3);
        goto L17
    }

    private MapFormat getFormat(String[] r3) {
        if (r3 != null) goto L5;
    L14:
        return null;
    L5:
        if (r3.length == 0) goto L14;
        int r0 = 0;
    L9:
        if (r0 >= r3.length) goto L14;
        MapFormat r1 = MapFormat.lookupIgnoreCase(r3[r0]);
        if (r1 != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r1;
    }

    public void appendMap(StringBuilder r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.data.size()) goto L8;
        if (r0 <= 0) goto L7;
        r4.append(' ');
    L7:
        r4.append(this.data.getKeyAt(r0)).append('=').append(Typography.quote);
        g.a(this.data.getValueAt(r0), r4);
        r4.append(Typography.quote);
        r0 = r0 + 1;
        goto L4
    }

    public void asJava(StringBuilder r2) {
        asJava(r2, true);
    }

    public void asJavaUnquoted(StringBuilder r2) {
        asJava(r2, false);
    }

    public void asJson(StringBuilder r1) {
        MapMessageJsonFormatter.format(r1, this.data);
    }

    public String asString() {
        return format((MapFormat) ZeusTransformUtils.preCheckCast(null, MapFormat.class, "com.obric.memorydata.plugin"), new StringBuilder()).toString();
    }

    public String asString(String r3) {
        return format((MapFormat) ZeusTransformUtils.preCheckCast(org.apache.logging.log4j.util.d.a(MapFormat.class, r3), MapFormat.class, "com.obric.memorydata.plugin"), new StringBuilder()).toString();
    L5:
        return asString();
    }

    public void asXml(StringBuilder r4) {
        r4.append("<Map>\n");
        int r0 = 0;
    L4:
        if (r0 >= this.data.size()) goto L6;
        r4.append("  <Entry key=\"").append(this.data.getKeyAt(r0)).append("\">");
        int r1 = r4.length();
        g.a(this.data.getValueAt(r0), r4);
        r.c(r4, r1);
        r4.append("</Entry>\n");
        r0 = r0 + 1;
        goto L4
    L6:
        r4.append("</Map>");
    }

    public void clear() {
        this.data.clear();
    }

    public boolean containsKey(String r1) {
        return this.data.containsKey(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        MapMessage r4 = (MapMessage) ZeusTransformUtils.preCheckCast(r3, MapMessage.class, "com.obric.memorydata.plugin");
        return this.data.equals(r4.data);
    L13:
        return false;
    }

    public <CV> void forEach(org.apache.logging.log4j.util.a<String, ? super CV> r3) {
        org.apache.logging.log4j.util.a<String, ? super V> r4 = (org.apache.logging.log4j.util.a) ZeusTransformUtils.wrapperContextForParams(r3, org.apache.logging.log4j.util.a.class, "com.obric.memorydata.plugin");
        this.data.forEach(r4);
    }

    public <CV, S> void forEach(u<String, ? super CV, S> r3, S r4) {
        u<String, ? super V, S> r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        this.data.forEach(r5, r4);
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r4) {
        format((MapFormat) ZeusTransformUtils.preCheckCast(null, MapFormat.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.apache.logging.log4j.util.MultiFormatStringBuilderFormattable
    public void formatTo(String[] r1, StringBuilder r2) {
        format(getFormat(r1), r2);
    }

    public String get(String r1) {
        return g.a(this.data.getValue(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, V> getData() {
        TreeMap r0 = new TreeMap();
        int r1 = 0;
    L4:
        if (r1 >= this.data.size()) goto L7;
        r0.put(this.data.getKeyAt(r1), this.data.getValueAt(r1));
        r1 = r1 + 1;
        goto L4
    L7:
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return "";
    }

    @Override // org.apache.logging.log4j.message.MultiformatMessage
    public String[] getFormats() {
        return MapFormat.names();
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        return asString();
    }

    @Override // org.apache.logging.log4j.message.MultiformatMessage
    public String getFormattedMessage(String[] r2) {
        return format(getFormat(r2), new StringBuilder()).toString();
    }

    public IndexedReadOnlyStringMap getIndexedReadOnlyStringMap() {
        return this.data;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        Object[] r0 = new Object[this.data.size()];
        int r1 = 0;
    L4:
        if (r1 >= this.data.size()) goto L6;
        r0[r1] = this.data.getValueAt(r1);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public M newInstance(Map<String, V> r2) {
        return (M) new MapMessage((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }

    public void put(String r2, String r3) {
        if (r3 == null) goto L6;
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, r3);
        return;
    L6:
        throw new IllegalArgumentException("No value provided for key " + r2);
    }

    public void putAll(Map<String, String> r6) {
        Iterator r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.data.putValue((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), r0.getValue());
        goto L4
    }

    public String remove(String r2) {
        String r0 = get(r2);
        this.data.remove(r2);
        return r0;
    }

    public String toKey(String r1) {
        return r1;
    }

    public String toString() {
        return asString();
    }

    public void validate(String r1, byte r2) {
    }

    public void validate(String r1, char r2) {
    }

    public void validate(String r1, double r2) {
    }

    public void validate(String r1, float r2) {
    }

    public void validate(String r1, int r2) {
    }

    public void validate(String r1, long r2) {
    }

    public void validate(String r1, Object r2) {
    }

    public void validate(String r1, String r2) {
    }

    public void validate(String r1, short r2) {
    }

    public void validate(String r1, boolean r2) {
    }

    public M with(String r2, byte r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Byte.valueOf(r3));
        return this;
    }

    public M with(String r2, char r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Character.valueOf(r3));
        return this;
    }

    public M with(String r2, double r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Double.valueOf(r3));
        return this;
    }

    public M with(String r2, float r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Float.valueOf(r3));
        return this;
    }

    public M with(String r2, int r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Integer.valueOf(r3));
        return this;
    }

    public M with(String r2, long r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Long.valueOf(r3));
        return this;
    }

    public M with(String r2, Object r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, r3);
        return this;
    }

    public M with(String r1, String r2) {
        put(toKey(r1), r2);
        return this;
    }

    public M with(String r2, short r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Short.valueOf(r3));
        return this;
    }

    public M with(String r2, boolean r3) {
        String r4 = toKey(r2);
        validate(r4, r3);
        this.data.putValue(r4, Boolean.valueOf(r3));
        return this;
    }
}
