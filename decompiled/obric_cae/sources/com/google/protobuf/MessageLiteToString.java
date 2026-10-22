package com.google.protobuf;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER = null;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] r8 = new char[80];
        INDENT_BUFFER = r8;
        Arrays.fill(r8, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int r8, StringBuilder r10) {
    L2:
        if (r8 <= 0) goto L8;
        char[] r11 = INDENT_BUFFER;
        if (r8 <= r11.length) goto L6;
        int r12 = r11.length;
    L7:
        r10.append(r11, 0, r12);
        r8 = r8 - r12;
        goto L2
    L6:
        r12 = r8;
        goto L7
    }

    private static boolean isDefaultValue(Object r8) {
        if ((r8 instanceof Boolean) == false) goto L7;
        return !((Boolean) r8).booleanValue();
    L7:
        if ((r8 instanceof Integer) == false) goto L14;
        if (((Integer) r8).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((r8 instanceof Float) == false) goto L21;
        if (Float.floatToRawIntBits(((Float) r8).floatValue()) != 0) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((r8 instanceof Double) == false) goto L28;
        if (Double.doubleToRawLongBits(((Double) r8).doubleValue()) != 0) goto L26;
        return true;
    L26:
        return false;
    L28:
        if ((r8 instanceof String) == false) goto L33;
        Object r10 = "";
    L31:
        return r8.equals(r10);
    L33:
        if ((r8 instanceof ByteString) == false) goto L36;
        r10 = ByteString.EMPTY;
        goto L31
    L36:
        if ((r8 instanceof MessageLite) == false) goto L43;
        if (r8 != ((MessageLite) r8).getDefaultInstanceForType()) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r8 instanceof java.lang.Enum) == true) goto L45;
        return false;
    L45:
        if (((java.lang.Enum) r8).ordinal() != 0) goto L48;
        return true;
    L48:
        return false;
    }

    private static String pascalCaseToSnakeCase(String r8) {
        if (r8.isEmpty() == false) goto L5;
        return r8;
    L5:
        StringBuilder r10 = new StringBuilder();
        r10.append(Character.toLowerCase(r8.charAt(0)));
        int r11 = 1;
    L7:
        if (r11 >= r8.length()) goto L13;
        char r12 = r8.charAt(r11);
        if (Character.isUpperCase(r12) == false) goto L11;
        r10.append("_");
    L11:
        r10.append(Character.toLowerCase(r12));
        r11 = r11 + 1;
        goto L7
    L13:
        return r10.toString();
    }

    public static void printField(StringBuilder r8, int r10, String r11, Object r12) {
        if ((r12 instanceof List) == false) goto L10;
        Iterator r13 = ((List) r12).iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        printField(r8, r10, r11, r13.next());
        goto L6
    L8:
        return;
    L10:
        if ((r12 instanceof Map) == false) goto L16;
        Iterator r14 = ((Map) r12).entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        printField(r8, r10, r11, (Map.Entry) r14.next());
        goto L13
    L15:
        return;
    L16:
        r8.append('\n');
        indent(r10, r8);
        r8.append(pascalCaseToSnakeCase(r11));
        if ((r12 instanceof String) == false) goto L21;
        r8.append(": \"");
        String r15 = TextFormatEscaper.escapeText((String) r12);
    L19:
        r8.append(r15);
        r8.append('\"');
        return;
    L21:
        if ((r12 instanceof ByteString) == false) goto L24;
        r8.append(": \"");
        r15 = TextFormatEscaper.escapeBytes((ByteString) r12);
        goto L19
    L24:
        if ((r12 instanceof GeneratedMessageLite) == false) goto L28;
        r8.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) r12, r8, r10 + 2);
    L26:
        r8.append("\n");
        indent(r10, r8);
        r8.append("}");
        return;
    L28:
        if ((r12 instanceof Map.Entry) == false) goto L30;
        r8.append(" {");
        Map.Entry r16 = (Map.Entry) r12;
        int r17 = r10 + 2;
        printField(r8, r17, "key", r16.getKey());
        printField(r8, r17, "value", r16.getValue());
        goto L26
    L30:
        r8.append(": ");
        r8.append(r12);
    }

    private static void reflectivePrintWithIndent(MessageLite r13, StringBuilder r14, int r15) {
        HashSet r8 = new HashSet();
        HashMap r10 = new HashMap();
        TreeMap r11 = new TreeMap();
        java.lang.reflect.Method[] r12 = r13.getClass().getDeclaredMethods();
        int r16 = r12.length;
        int r17 = 0;
    L3:
        int r18 = 3;
        if (r17 >= r16) goto L27;
        java.lang.reflect.Method r19 = r12[r17];
        if (Modifier.isStatic(r19.getModifiers()) == true) goto L26;
        if (r19.getName().length() < 3) goto L26;
        if (r19.getName().startsWith("set") == false) goto L15;
        r8.add(r19.getName());
        goto L26
    L15:
        if (Modifier.isPublic(r19.getModifiers()) == false) goto L26;
        if (r19.getParameterTypes().length != 0) goto L26;
        if (r19.getName().startsWith("has") == false) goto L24;
        r10.put(r19.getName(), r19);
        goto L26
    L24:
        if (r19.getName().startsWith("get") == false) goto L26;
        r11.put(r19.getName(), r19);
    L26:
        r17 = r17 + 1;
        goto L3
    L27:
        Iterator r20 = r11.entrySet().iterator();
    L29:
        if (r20.hasNext() == false) goto L74;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = ((String) r21.getKey()).substring(r18);
        if (r22.endsWith(LIST_SUFFIX) == false) goto L42;
        if (r22.endsWith(BUILDER_LIST_SUFFIX) == true) goto L42;
        if (r22.equals(LIST_SUFFIX) == true) goto L42;
        java.lang.reflect.Method r110 = (java.lang.reflect.Method) r21.getValue();
        if (r110 == null) goto L42;
        if (r110.getReturnType().equals(List.class) == false) goto L42;
        printField(r14, r15, r22.substring(0, r22.length() - 4), GeneratedMessageLite.invokeOrDie(r110, r13, new Object[0]));
        r18 = 3;
    L42:
        if (r22.endsWith(MAP_SUFFIX) == false) goto L54;
        if (r22.equals(MAP_SUFFIX) == true) goto L54;
        java.lang.reflect.Method r111 = (java.lang.reflect.Method) r21.getValue();
        if (r111 == null) goto L54;
        if (r111.getReturnType().equals(Map.class) == false) goto L54;
        if (r111.isAnnotationPresent(Deprecated.class) == true) goto L54;
        if (Modifier.isPublic(r111.getModifiers()) == false) goto L54;
        printField(r14, r15, r22.substring(0, r22.length() - 3), GeneratedMessageLite.invokeOrDie(r111, r13, new Object[0]));
        r18 = 3;
    L54:
        r18 = 3;
        if (r8.contains("set".concat(r22)) == false) goto L29;
        if (r22.endsWith(BYTES_SUFFIX) == false) goto L62;
        if (r11.containsKey("get" + r22.substring(0, r22.length() - 5)) == true) goto L29;
    L62:
        java.lang.reflect.Method r23 = (java.lang.reflect.Method) r21.getValue();
        java.lang.reflect.Method r112 = (java.lang.reflect.Method) r10.get("has".concat(r22));
        if (r23 == null) goto L29;
        Object r24 = GeneratedMessageLite.invokeOrDie(r23, r13, new Object[0]);
        if (r112 == null) goto L67;
        boolean r113 = ((Boolean) GeneratedMessageLite.invokeOrDie(r112, r13, new Object[0])).booleanValue();
    L71:
        if (r113 == false) goto L29;
        printField(r14, r15, r22, r24);
        goto L29
    L67:
        if (isDefaultValue(r24) == true) goto L69;
        r113 = true;
        goto L71
    L69:
        r113 = false;
        goto L71
    L74:
        if ((r13 instanceof GeneratedMessageLite.ExtendableMessage) == false) goto L79;
        Iterator<Map.Entry<T, Object>> r25 = ((GeneratedMessageLite.ExtendableMessage) r13).extensions.iterator();
    L77:
        if (r25.hasNext() == false) goto L79;
        Map.Entry r26 = (Map.Entry) r25.next();
        printField(r14, r15, android.aimedia.a.h(new StringBuilder("["), ((GeneratedMessageLite.ExtensionDescriptor) r26.getKey()).getNumber(), "]"), r26.getValue());
    L79:
        UnknownFieldSetLite r114 = ((GeneratedMessageLite) r13).unknownFields;
        if (r114 == null) goto L120;
        r114.printWithIndent(r14, r15);
        return;
    }

    public static String toString(MessageLite r8, String r10) {
        StringBuilder r11 = android.aimedia.a.k("# ", r10);
        reflectivePrintWithIndent(r8, r11, 0);
        return r11.toString();
    }
}
