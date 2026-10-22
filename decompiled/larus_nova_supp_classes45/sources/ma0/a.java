package ma0;

import java.util.LinkedHashMap;
import java.util.Stack;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public a() {
    }

    public static String a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "str");
        Stack r0 = new Stack();
        int r1 = r11.length();
        String r6 = "";
        int r4 = 0;
        boolean r5 = false;
    L3:
        if (r4 >= r1) goto L51;
        if (r5 == false) goto L6;
        r5 = false;
    L49:
        r4 = r4 + 1;
        goto L3
    L6:
        char r7 = r11.charAt(r4);
        if (r7 == '&') goto L34;
        if (r7 == '|') goto L24;
        if (r7 != '(') goto L11;
        r0.push(Character.valueOf(r7));
        goto L49
    L11:
        if (r7 == ')') goto L14;
        r6 = r6 + r7;
    L14:
        if (r0.empty() == true) goto L49;
        Character r8 = (Character) r0.pop();
        if (r8 == null) goto L21;
        if (r8.charValue() == '(') goto L49;
    L21:
        r6 = r6 + r8;
    L24:
        if (r0.isEmpty() == true) goto L25;
        Character r9 = (Character) r0.pop();
        if (r9 == null) goto L32;
        if (r9.charValue() != '(') goto L32;
        r0.push(r9);
        r0.push(Character.valueOf(r7));
    L48:
        r5 = true;
    L32:
        r6 = r6 + r9;
        goto L24
    L25:
        r0.push(Character.valueOf(r7));
    L34:
        if (r0.isEmpty() == true) goto L35;
        Character r12 = (Character) r0.peek();
        if (r12 != null) goto L40;
    L41:
        if (r12 == null) goto L46;
        if (r12.charValue() != '|') goto L46;
    L47:
        r0.push(Character.valueOf(r7));
    L46:
        r0.pop();
        r6 = r6 + r12;
        goto L34
    L40:
        if (r12.charValue() == '(') goto L47;
    L35:
        r0.push(Character.valueOf(r7));
    L51:
        if (r0.empty() == true) goto L54;
        r6 = r6 + ((Character) r0.pop());
        goto L51
    L54:
        return new Regex("\\s").replace(r6, "");
    }

    public static boolean b(String r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r12, "suffix");
        Intrinsics.checkNotNullParameter(r13, "call");
        Stack r0 = new Stack();
        LinkedHashMap r1 = new LinkedHashMap();
        int r3 = r12.length();     // Catch: Exception -> L120
        int r4 = 0;
    L4:
        boolean r5 = true;
        if (r4 >= r3) goto L111;
        char r6 = r12.charAt(r4);     // Catch: Exception -> L120
        if (r6 != '&') goto L9;
        String r7 = (String) r0.pop();     // Catch: Exception -> L120
        String r8 = (String) r0.pop();     // Catch: Exception -> L120
        if (r1.containsKey(r7) == false) goto L81;
        if (r1.containsKey(r8) == false) goto L71;
        Boolean r9 = (Boolean) r1.get(r7);     // Catch: Exception -> L120
        Boolean r11 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r14 = Intrinsics.areEqual(r9, r11);     // Catch: Exception -> L120
        boolean r15 = Intrinsics.areEqual((Boolean) r1.get(r8), r11);     // Catch: Exception -> L120
        String r16 = r7 + "and" + r8;     // Catch: Exception -> L120
        if (r14 == false) goto L69;
        if (r15 == false) goto L69;
    L70:
        r1.put(r16, Boolean.valueOf(r5));     // Catch: Exception -> L120
    L108:
        r0.push(r7 + "and" + r8);     // Catch: Exception -> L120
    L109:
        r4 = r4 + 1;     // Catch: Exception -> L120
    L69:
        r5 = false;
        goto L70
    L71:
        boolean r17 = Intrinsics.areEqual((Boolean) r1.get(r7), Boolean.TRUE);     // Catch: Exception -> L120
        if (r17 == false) goto L79;
        boolean r18 = ((Boolean) r13.invoke(r8)).booleanValue();     // Catch: Exception -> L120
        String r19 = r7 + "and" + r8;     // Catch: Exception -> L120
        if (r17 == false) goto L77;
        if (r18 == false) goto L77;
    L78:
        r1.put(r19, Boolean.valueOf(r5));     // Catch: Exception -> L120
        r1.put(r8, Boolean.valueOf(r18));     // Catch: Exception -> L120
    L77:
        r5 = false;
        goto L78
    L79:
        r1.put(r7 + "and" + r8, Boolean.valueOf(r17));     // Catch: Exception -> L120
        goto L108
    L81:
        if (r1.containsKey(r8) == true) goto L83;
        boolean r21 = ((Boolean) r13.invoke(r7)).booleanValue();     // Catch: Exception -> L120
        r1.put(r7, Boolean.valueOf(r21));     // Catch: Exception -> L120
        if (r21 == false) goto L107;
        boolean r110 = ((Boolean) r13.invoke(r8)).booleanValue();     // Catch: Exception -> L120
        String r111 = r7 + "and" + r8;     // Catch: Exception -> L120
        if (r21 == false) goto L105;
        if (r110 == false) goto L105;
    L106:
        r1.put(r111, Boolean.valueOf(r5));     // Catch: Exception -> L120
        r1.put(r8, Boolean.valueOf(r110));     // Catch: Exception -> L120
    L105:
        r5 = false;
        goto L106
    L107:
        r1.put(r7 + "and" + r8, Boolean.valueOf(r21));     // Catch: Exception -> L120
        goto L108
    L83:
        if (r1.containsKey(r7) == false) goto L90;
        Boolean r22 = (Boolean) r1.get(r7);     // Catch: Exception -> L120
        Boolean r112 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r23 = Intrinsics.areEqual(r22, r112);     // Catch: Exception -> L120
        boolean r113 = Intrinsics.areEqual((Boolean) r1.get(r8), r112);     // Catch: Exception -> L120
        String r114 = r7 + "and" + r8;     // Catch: Exception -> L120
        if (r23 == false) goto L88;
        if (r113 == false) goto L88;
    L89:
        r1.put(r114, Boolean.valueOf(r5));     // Catch: Exception -> L120
    L88:
        r5 = false;
        goto L89
    L90:
        boolean r24 = Intrinsics.areEqual((Boolean) r1.get(r8), Boolean.TRUE);     // Catch: Exception -> L120
        if (r24 == false) goto L98;
        boolean r115 = ((Boolean) r13.invoke(r7)).booleanValue();     // Catch: Exception -> L120
        String r116 = r7 + "and" + r8;     // Catch: Exception -> L120
        if (r115 == false) goto L96;
        if (r24 == false) goto L96;
    L97:
        r1.put(r116, Boolean.valueOf(r5));     // Catch: Exception -> L120
        r1.put(r7, Boolean.valueOf(r115));     // Catch: Exception -> L120
    L96:
        r5 = false;
        goto L97
    L98:
        r1.put(r7 + "and" + r8, Boolean.valueOf(r24));     // Catch: Exception -> L120
        goto L108
    L9:
        if (r6 == '|') goto L11;
        r0.push(String.valueOf(r6));     // Catch: Exception -> L120
        goto L109
    L11:
        String r25 = (String) r0.pop();     // Catch: Exception -> L120
        String r26 = (String) r0.pop();     // Catch: Exception -> L120
        if (r1.containsKey(r25) == false) goto L32;
        if (r1.containsKey(r26) == false) goto L22;
        Boolean r27 = (Boolean) r1.get(r25);     // Catch: Exception -> L120
        Boolean r117 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r28 = Intrinsics.areEqual(r27, r117);     // Catch: Exception -> L120
        boolean r118 = Intrinsics.areEqual((Boolean) r1.get(r26), r117);     // Catch: Exception -> L120
        String r119 = r25 + "or" + r26;     // Catch: Exception -> L120
        if (r28 == true) goto L21;
        if (r118 == true) goto L21;
        r5 = false;
    L21:
        r1.put(r119, Boolean.valueOf(r5));     // Catch: Exception -> L120
    L59:
        r0.push(r25 + "or" + r26);     // Catch: Exception -> L120
        goto L109
    L22:
        boolean r29 = Intrinsics.areEqual((Boolean) r1.get(r25), Boolean.TRUE);     // Catch: Exception -> L120
        if (r29 == false) goto L25;
        r1.put(r25 + "or" + r26, Boolean.valueOf(r29));     // Catch: Exception -> L120
        goto L59
    L25:
        boolean r120 = ((Boolean) r13.invoke(r26)).booleanValue();     // Catch: Exception -> L120
        String r121 = r25 + "or" + r26;     // Catch: Exception -> L120
        if (r29 == true) goto L30;
        if (r120 == true) goto L30;
        r5 = false;
    L30:
        r1.put(r121, Boolean.valueOf(r5));     // Catch: Exception -> L120
        r1.put(r26, Boolean.valueOf(r120));     // Catch: Exception -> L120
        goto L59
    L32:
        if (r1.containsKey(r26) == true) goto L34;
        boolean r31 = ((Boolean) r13.invoke(r25)).booleanValue();     // Catch: Exception -> L120
        r1.put(r25, Boolean.valueOf(r31));     // Catch: Exception -> L120
        if (r31 == false) goto L53;
        r1.put(r25 + "or" + r26, Boolean.valueOf(r31));     // Catch: Exception -> L120
        goto L59
    L53:
        boolean r122 = ((Boolean) r13.invoke(r26)).booleanValue();     // Catch: Exception -> L120
        String r123 = r25 + "or" + r26;     // Catch: Exception -> L120
        if (r31 == true) goto L58;
        if (r122 == true) goto L58;
        r5 = false;
    L58:
        r1.put(r123, Boolean.valueOf(r5));     // Catch: Exception -> L120
        r1.put(r26, Boolean.valueOf(r122));     // Catch: Exception -> L120
        goto L59
    L34:
        if (r1.containsKey(r25) == false) goto L41;
        Boolean r32 = (Boolean) r1.get(r25);     // Catch: Exception -> L120
        Boolean r124 = Boolean.TRUE;     // Catch: Exception -> L120
        boolean r33 = Intrinsics.areEqual(r32, r124);     // Catch: Exception -> L120
        boolean r125 = Intrinsics.areEqual((Boolean) r1.get(r26), r124);     // Catch: Exception -> L120
        String r126 = r25 + "or" + r26;     // Catch: Exception -> L120
        if (r33 == true) goto L40;
        if (r125 == true) goto L40;
        r5 = false;
    L40:
        r1.put(r126, Boolean.valueOf(r5));     // Catch: Exception -> L120
        goto L59
    L41:
        boolean r34 = Intrinsics.areEqual((Boolean) r1.get(r26), Boolean.TRUE);     // Catch: Exception -> L120
        if (r34 == false) goto L44;
        r1.put(r25 + "or" + r26, Boolean.valueOf(r34));     // Catch: Exception -> L120
        goto L59
    L44:
        boolean r127 = ((Boolean) r13.invoke(r25)).booleanValue();     // Catch: Exception -> L120
        String r128 = r25 + "or" + r26;     // Catch: Exception -> L120
        if (r127 == true) goto L49;
        if (r34 == true) goto L49;
        r5 = false;
    L49:
        r1.put(r128, Boolean.valueOf(r5));     // Catch: Exception -> L120
        r1.put(r25, Boolean.valueOf(r127));     // Catch: Exception -> L120
        goto L59
    L111:
        if (r0.empty() == false) goto L113;
        return false;
    L113:
        if (r0.size() > 1) goto L127;
        String r129 = (String) r0.pop();     // Catch: Exception -> L120
        if (r1.containsKey(r129) == false) goto L119;
        return Intrinsics.areEqual((Boolean) r1.get(r129), Boolean.TRUE);
    L119:
        return ((Boolean) r13.invoke(r129)).booleanValue();
    L127:
        return false;
    L129:
        return false;
    }
}
