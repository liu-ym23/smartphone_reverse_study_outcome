package com.google.protobuf;

import com.bytedance.crash.entity.EventBody;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER = null;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] r10 = new char[80];
        INDENT_BUFFER = r10;
        Arrays.fill(r10, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int r10, StringBuilder r11) {
    L2:
        if (r10 <= 0) goto L8;
        char[] r12 = INDENT_BUFFER;
        if (r10 <= r12.length) goto L6;
        int r13 = r12.length;
    L7:
        r11.append(r12, 0, r13);
        r10 = r10 - r13;
        goto L2
    L6:
        r13 = r10;
        goto L7
    }

    private static boolean isDefaultValue(Object r10) {
        if ((r10 instanceof Boolean) == false) goto L7;
        return !((Boolean) r10).booleanValue();
    L7:
        if ((r10 instanceof Integer) == false) goto L14;
        if (((Integer) r10).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((r10 instanceof Float) == false) goto L21;
        if (Float.floatToRawIntBits(((Float) r10).floatValue()) != 0) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((r10 instanceof Double) == false) goto L28;
        if (Double.doubleToRawLongBits(((Double) r10).doubleValue()) != 0) goto L26;
        return true;
    L26:
        return false;
    L28:
        if ((r10 instanceof String) == false) goto L33;
        Object r11 = "";
    L31:
        return r10.equals(r11);
    L33:
        if ((r10 instanceof ByteString) == false) goto L36;
        r11 = ByteString.EMPTY;
        goto L31
    L36:
        if ((r10 instanceof MessageLite) == false) goto L43;
        if (r10 != ((MessageLite) r10).getDefaultInstanceForType()) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r10 instanceof java.lang.Enum) == true) goto L45;
        return false;
    L45:
        if (((java.lang.Enum) r10).ordinal() != 0) goto L48;
        return true;
    L48:
        return false;
    }

    private static String pascalCaseToSnakeCase(String r10) {
        if (r10.isEmpty() == false) goto L5;
        return r10;
    L5:
        StringBuilder r11 = new StringBuilder();
        r11.append(Character.toLowerCase(r10.charAt(0)));
        int r12 = 1;
    L7:
        if (r12 >= r10.length()) goto L13;
        char r13 = r10.charAt(r12);
        if (Character.isUpperCase(r13) == false) goto L11;
        r11.append("_");
    L11:
        r11.append(Character.toLowerCase(r13));
        r12 = r12 + 1;
        goto L7
    L13:
        return r11.toString();
    }

    static void printField(StringBuilder r10, int r11, String r12, Object r13) {
        if ((r13 instanceof List) == false) goto L10;
        Iterator r14 = ((List) r13).iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        printField(r10, r11, r12, r14.next());
        goto L6
    L8:
        return;
    L10:
        if ((r13 instanceof Map) == false) goto L16;
        Iterator r15 = ((Map) r13).entrySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        printField(r10, r11, r12, (Map.Entry) r15.next());
        goto L13
    L15:
        return;
    L16:
        r10.append('\n');
        indent(r11, r10);
        r10.append(pascalCaseToSnakeCase(r12));
        if ((r13 instanceof String) == false) goto L21;
        r10.append(": \"");
        String r16 = TextFormatEscaper.escapeText((String) r13);
    L19:
        r10.append(r16);
        r10.append(Typography.quote);
        return;
    L21:
        if ((r13 instanceof ByteString) == false) goto L24;
        r10.append(": \"");
        r16 = TextFormatEscaper.escapeBytes((ByteString) r13);
        goto L19
    L24:
        if ((r13 instanceof GeneratedMessageLite) == false) goto L28;
        r10.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) r13, r10, r11 + 2);
    L26:
        r10.append("\n");
        indent(r11, r10);
        r10.append("}");
        return;
    L28:
        if ((r13 instanceof Map.Entry) == false) goto L30;
        r10.append(" {");
        Map.Entry r17 = (Map.Entry) r13;
        int r18 = r11 + 2;
        printField(r10, r18, "key", r17.getKey());
        printField(r10, r18, EventBody.KEY_VALUE, r17.getValue());
        goto L26
    L30:
        r10.append(": ");
        r10.append(r13);
    }

    private static void reflectivePrintWithIndent(MessageLite r16, StringBuilder r17, int r18) {
        HashSet r10 = new HashSet();
        HashMap r11 = new HashMap();
        TreeMap r12 = new TreeMap();
        java.lang.reflect.Method[] r13 = r16.getClass().getDeclaredMethods();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        int r19 = 3;
        if (r15 >= r14) goto L27;
        java.lang.reflect.Method r110 = r13[r15];
        if (Modifier.isStatic(r110.getModifiers()) == true) goto L26;
        if (r110.getName().length() < 3) goto L26;
        if (r110.getName().startsWith("set") == false) goto L15;
        r10.add(r110.getName());
        goto L26
    L15:
        if (Modifier.isPublic(r110.getModifiers()) == false) goto L26;
        if (r110.getParameterTypes().length != 0) goto L26;
        if (r110.getName().startsWith("has") == false) goto L24;
        r11.put(r110.getName(), r110);
        goto L26
    L24:
        if (r110.getName().startsWith("get") == false) goto L26;
        r12.put(r110.getName(), r110);
    L26:
        r15 = r15 + 1;
        goto L3
    L27:
        Iterator r20 = r12.entrySet().iterator();
    L29:
        if (r20.hasNext() == false) goto L74;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = ((String) r21.getKey()).substring(r19);
        if (r22.endsWith(LIST_SUFFIX) == false) goto L42;
        if (r22.endsWith(BUILDER_LIST_SUFFIX) == true) goto L42;
        if (r22.equals(LIST_SUFFIX) == true) goto L42;
        java.lang.reflect.Method r111 = (java.lang.reflect.Method) r21.getValue();
        if (r111 == null) goto L42;
        if (r111.getReturnType().equals(List.class) == false) goto L42;
        printField(r17, r18, r22.substring(0, r22.length() - 4), GeneratedMessageLite.invokeOrDie(r111, r16, new Object[0]));
        r19 = 3;
    L42:
        if (r22.endsWith(MAP_SUFFIX) == true) goto L44;
    L54:
        int r112 = 3;
        if (r10.contains("set" + r22) == true) goto L58;
    L56:
        r19 = r112;
        goto L29
    L58:
        if (r22.endsWith(BYTES_SUFFIX) == true) goto L60;
    L62:
        java.lang.reflect.Method r23 = (java.lang.reflect.Method) r21.getValue();
        java.lang.reflect.Method r113 = (java.lang.reflect.Method) r11.get("has" + r22);
        if (r23 == null) goto L56;
        Object r24 = GeneratedMessageLite.invokeOrDie(r23, r16, new Object[0]);
        if (r113 == null) goto L67;
        boolean r114 = ((Boolean) GeneratedMessageLite.invokeOrDie(r113, r16, new Object[0])).booleanValue();
    L71:
        if (r114 == false) goto L56;
        printField(r17, r18, r22, r24);
        goto L56
    L67:
        if (isDefaultValue(r24) == true) goto L69;
        r114 = true;
        goto L71
    L69:
        r114 = false;
        goto L71
    L60:
        if (r12.containsKey("get" + r22.substring(0, r22.length() - 5)) == false) goto L62;
    L44:
        if (r22.equals(MAP_SUFFIX) == true) goto L54;
        java.lang.reflect.Method r115 = (java.lang.reflect.Method) r21.getValue();
        if (r115 == null) goto L54;
        if (r115.getReturnType().equals(Map.class) == false) goto L54;
        if (r115.isAnnotationPresent(Deprecated.class) == true) goto L54;
        if (Modifier.isPublic(r115.getModifiers()) == false) goto L54;
        r112 = 3;
        printField(r17, r18, r22.substring(0, r22.length() - 3), GeneratedMessageLite.invokeOrDie(r115, r16, new Object[0]));
        goto L56
    L74:
        if ((r16 instanceof GeneratedMessageLite.ExtendableMessage) == false) goto L79;
        Iterator<Map.Entry<T, Object>> r25 = ((GeneratedMessageLite.ExtendableMessage) r16).extensions.iterator();
    L77:
        if (r25.hasNext() == false) goto L79;
        Map.Entry r26 = (Map.Entry) r25.next();
        printField(r17, r18, "[" + ((GeneratedMessageLite.ExtensionDescriptor) r26.getKey()).getNumber() + "]", r26.getValue());
    L79:
        UnknownFieldSetLite r27 = ((GeneratedMessageLite) r16).unknownFields;
        if (r27 == null) goto L103;
        r27.printWithIndent(r17, r18);
        return;
    }

    static String toString(MessageLite r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append("# ");
        r12.append(r11);
        reflectivePrintWithIndent(r10, r12, 0);
        return r12.toString();
    }
}
