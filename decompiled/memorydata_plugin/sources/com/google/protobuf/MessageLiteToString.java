package com.google.protobuf;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER = null;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] r0 = new char[80];
        INDENT_BUFFER = r0;
        Arrays.fill(r0, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int r3, StringBuilder r4) {
    L2:
        if (r3 <= 0) goto L8;
        char[] r0 = INDENT_BUFFER;
        if (r3 <= r0.length) goto L6;
        int r1 = r0.length;
    L7:
        r4.append(r0, 0, r1);
        r3 = r3 - r1;
        goto L2
    L6:
        r1 = r3;
        goto L7
    }

    private static boolean isDefaultValue(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L7;
        return !((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L14;
        if (((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L21;
        if (Float.floatToRawIntBits(((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin")).floatValue()) != 0) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L28;
        if (Double.doubleToRawLongBits(((Double) ZeusTransformUtils.preCheckCast(r8, Double.class, "com.obric.memorydata.plugin")).doubleValue()) != 0) goto L26;
        return true;
    L26:
        return false;
    L28:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L33;
        Object r0 = "";
    L31:
        return r8.equals(r0);
    L33:
        if (ZeusTransformUtils.instanceOf(r8, ByteString.class) == false) goto L36;
        r0 = ByteString.EMPTY;
        goto L31
    L36:
        if (ZeusTransformUtils.instanceOf(r8, MessageLite.class) == false) goto L43;
        if (r8 != ((MessageLite) ZeusTransformUtils.preCheckCast(r8, MessageLite.class, "com.obric.memorydata.plugin")).getDefaultInstanceForType()) goto L41;
        return true;
    L41:
        return false;
    L43:
        if (ZeusTransformUtils.instanceOf(r8, java.lang.Enum.class) == true) goto L45;
        return false;
    L45:
        if (((java.lang.Enum) ZeusTransformUtils.preCheckCast(r8, java.lang.Enum.class, "com.obric.memorydata.plugin")).ordinal() != 0) goto L48;
        return true;
    L48:
        return false;
    }

    private static String pascalCaseToSnakeCase(String r4) {
        if (r4.isEmpty() == false) goto L5;
        return r4;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(Character.toLowerCase(r4.charAt(0)));
        int r1 = 1;
    L7:
        if (r1 >= r4.length()) goto L13;
        char r2 = r4.charAt(r1);
        if (Character.isUpperCase(r2) == false) goto L11;
        r0.append("_");
    L11:
        r0.append(Character.toLowerCase(r2));
        r1 = r1 + 1;
        goto L7
    L13:
        return r0.toString();
    }

    static void printField(StringBuilder r4, int r5, String r6, Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, List.class) == false) goto L10;
        Iterator r8 = ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        printField(r4, r5, r6, r8.next());
        goto L6
    L8:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, Map.class) == false) goto L16;
        Iterator r9 = ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        printField(r4, r5, r6, (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L13
    L15:
        return;
    L16:
        r4.append('\n');
        indent(r5, r4);
        r4.append(pascalCaseToSnakeCase(r6));
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L21;
        StringBuilder r10 = r4.append(": \"");
        String r11 = TextFormatEscaper.escapeText((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));
    L19:
        r10.append(r11).append(Typography.quote);
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r7, ByteString.class) == false) goto L24;
        r10 = r4.append(": \"");
        r11 = TextFormatEscaper.escapeBytes((ByteString) ZeusTransformUtils.preCheckCast(r7, ByteString.class, "com.obric.memorydata.plugin"));
        goto L19
    L24:
        if (ZeusTransformUtils.instanceOf(r7, GeneratedMessageLite.class) == false) goto L28;
        r4.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r7, GeneratedMessageLite.class, "com.obric.memorydata.plugin"), r4, r5 + 2);
    L26:
        r4.append("\n");
        indent(r5, r4);
        r4.append("}");
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r7, Map.Entry.class) == false) goto L30;
        r4.append(" {");
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.memorydata.plugin");
        int r13 = r5 + 2;
        printField(r4, r13, "key", r12.getKey());
        printField(r4, r13, EventBody.KEY_VALUE, r12.getValue());
        goto L26
    L30:
        r4.append(": ").append(r7);
    }

    private static void reflectivePrintWithIndent(MessageLite r17, StringBuilder r18, int r19) {
        MessageLite r2 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r17, MessageLite.class, "com.obric.memorydata.plugin");
        HashSet r4 = new HashSet();
        HashMap r5 = new HashMap();
        TreeMap r6 = new TreeMap();
        java.lang.reflect.Method[] r7 = r2.getClass().getDeclaredMethods();
        int r8 = r7.length;
        int r10 = 0;
    L3:
        int r14 = 3;
        if (r10 >= r8) goto L27;
        java.lang.reflect.Method r15 = r7[r10];
        if (Modifier.isStatic(r15.getModifiers()) == true) goto L26;
        if (r15.getName().length() < 3) goto L26;
        if (r15.getName().startsWith("set") == false) goto L15;
        r4.add(r15.getName());
        goto L26
    L15:
        if (Modifier.isPublic(r15.getModifiers()) == false) goto L26;
        if (r15.getParameterTypes().length != 0) goto L26;
        if (r15.getName().startsWith("has") == false) goto L24;
        r5.put(r15.getName(), r15);
        goto L26
    L24:
        if (r15.getName().startsWith("get") == false) goto L26;
        r6.put(r15.getName(), r15);
    L26:
        r10 = r10 + 1;
        goto L3
    L27:
        Iterator r9 = r6.entrySet().iterator();
    L29:
        if (r9.hasNext() == false) goto L75;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = ((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin")).substring(r14);
        if (r12.endsWith("List") == false) goto L42;
        if (r12.endsWith(BUILDER_LIST_SUFFIX) == true) goto L42;
        if (r12.equals("List") == true) goto L42;
        java.lang.reflect.Method r13 = (java.lang.reflect.Method) ZeusTransformUtils.preCheckCast(r11.getValue(), java.lang.reflect.Method.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L42;
        if (r13.getReturnType().equals(List.class) == false) goto L42;
        printField(r18, r19, r12.substring(0, r12.length() - 4), GeneratedMessageLite.invokeOrDie(r13, r2, new Object[0]));
    L73:
        r14 = 3;
    L42:
        if (r12.endsWith(MAP_SUFFIX) == false) goto L54;
        if (r12.equals(MAP_SUFFIX) == true) goto L54;
        java.lang.reflect.Method r16 = (java.lang.reflect.Method) ZeusTransformUtils.preCheckCast(r11.getValue(), java.lang.reflect.Method.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L54;
        if (r16.getReturnType().equals(Map.class) == false) goto L54;
        if (r16.isAnnotationPresent(Deprecated.class) == true) goto L54;
        if (Modifier.isPublic(r16.getModifiers()) == false) goto L54;
        r14 = 3;
        printField(r18, r19, r12.substring(0, r12.length() - 3), GeneratedMessageLite.invokeOrDie(r16, r2, new Object[0]));
    L54:
        r14 = 3;
        if (r4.contains("set" + r12) == false) goto L29;
        if (r12.endsWith(BYTES_SUFFIX) == true) goto L60;
    L62:
        java.lang.reflect.Method r20 = (java.lang.reflect.Method) ZeusTransformUtils.preCheckCast(r11.getValue(), java.lang.reflect.Method.class, "com.obric.memorydata.plugin");
        java.lang.reflect.Method r110 = (java.lang.reflect.Method) ZeusTransformUtils.preCheckCast(r5.get("has" + r12), java.lang.reflect.Method.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L73;
        Object r21 = GeneratedMessageLite.invokeOrDie(r20, r2, new Object[0]);
        if (r110 == null) goto L67;
        boolean r111 = ((Boolean) ZeusTransformUtils.preCheckCast(GeneratedMessageLite.invokeOrDie(r110, r2, new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L71:
        if (r111 == false) goto L73;
        printField(r18, r19, r12, r21);
        goto L73
    L67:
        if (isDefaultValue(r21) == true) goto L69;
        r111 = true;
        goto L71
    L69:
        r111 = false;
        goto L71
    L60:
        if (r6.containsKey("get" + r12.substring(0, r12.length() - 5)) == false) goto L62;
    L75:
        if (ZeusTransformUtils.instanceOf(r2, GeneratedMessageLite.ExtendableMessage.class) == false) goto L81;
        Iterator<Map.Entry<T, Object>> r22 = ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions.iterator();
    L78:
        if (r22.hasNext() == false) goto L81;
        Map.Entry r23 = (Map.Entry) ZeusTransformUtils.preCheckCast(r22.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        printField(r18, r19, "[" + ((GeneratedMessageLite.ExtensionDescriptor) ZeusTransformUtils.preCheckCast(r23.getKey(), GeneratedMessageLite.ExtensionDescriptor.class, "com.obric.memorydata.plugin")).getNumber() + "]", r23.getValue());
    L81:
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields == null) goto L108;
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields.printWithIndent(r18, r19);
        return;
    }

    static String toString(MessageLite r2, String r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append("# ").append(r3);
        reflectivePrintWithIndent(r4, r0, 0);
        return r0.toString();
    }
}
