package defpackage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\fJ8\u0010\r\u001a\u00020\t2\u001a\u0010\u000e\u001a\u0016\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u000fj\u0002`\u00100\u000fj\u0002`\u00112\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\fJ\"\u0010\u0012\u001a\u0016\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u000fj\u0002`\u00100\u000fj\u0002`\u00112\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00060\u000fj\u0002`\u00102\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\n\u001a\u00020\u0006H\u0002J \u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00060\u000fj\u0002`\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002J.\u0010\u0017\u001a\u00020\t2\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u00060\u000fj\u0002`\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\fH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"LExpressionEvaluator;", "", "<init>", "()V", "operators", "", "", "", "evaluate", "", "expression", "variables", "", "evaluateByRpn", "statements", "", "LRpnExpress;", "LStatementsRpnExpress;", "compile", "compileExpress", "tokenize", "toRPN", "tokens", "evaluateRPN", "rpn", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f87a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f88b = null;

    static {
        f87a = new b();
        f88b = MapsKt.mapOf(new Pair[]{TuplesKt.to(Marker.ANY_NON_NULL_MARKER, 1), TuplesKt.to("-", 1), TuplesKt.to("*", 2), TuplesKt.to("/", 2), TuplesKt.to("=", 0), TuplesKt.to(">", 0), TuplesKt.to("<", 0), TuplesKt.to(">=", 0), TuplesKt.to("<=", 0)});
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<String> a(List<String> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Stack r1 = new Stack();
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L53;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.toDoubleOrNull(r2) != null) goto L51;
        if (new Regex("[a-zA-Z]+").matches((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L51;
        if (Intrinsics.areEqual(r2, "(") == true) goto L12;
        if (Intrinsics.areEqual(r2, ")") == false) goto L26;
    L16:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if (Intrinsics.areEqual(r1.peek(), "(") == true) goto L21;
        Object r3 = r1.pop();
        Intrinsics.checkNotNullExpressionValue(r3, "pop(...)");
        r10.add(r3);
    L21:
        if (r1.isEmpty() == true) goto L24;
        r1.pop();
        goto L4
    L24:
        throw new IllegalArgumentException("括号不匹配：缺少左括号");
    L26:
        if (Intrinsics.areEqual(r2, "?") == true) goto L12;
        if (Intrinsics.areEqual(r2, ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L41;
    L31:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L36;
        if (Intrinsics.areEqual(r1.peek(), "?") == true) goto L36;
        Object r4 = r1.pop();
        Intrinsics.checkNotNullExpressionValue(r4, "pop(...)");
        r10.add(r4);
    L36:
        if (r1.isEmpty() == true) goto L39;
        r1.pop();
        r1.push("?");
        goto L4
    L39:
        throw new IllegalArgumentException("三元运算符错误：缺少匹配的 '?'");
    L41:
        if (f88b.containsKey(r2) == false) goto L50;
    L43:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        Map<String, Integer> r5 = f88b;
        if (r5.containsKey(r1.peek()) == false) goto L12;
        Integer r6 = r5.get(r1.peek());
        Intrinsics.checkNotNull(r6);
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue();
        Integer r12 = r5.get(r2);
        Intrinsics.checkNotNull(r12);
        if (r7 < ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue()) goto L12;
        Object r13 = r1.pop();
        Intrinsics.checkNotNullExpressionValue(r13, "pop(...)");
        r10.add(r13);
        goto L43
    L50:
        throw new IllegalArgumentException("未知标识符: " + r2);
    L12:
        r1.push(r2);
    L51:
        Boolean.valueOf(r10.add(r2));
    L53:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L61;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r1.pop(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r14, "(") == true) goto L60;
        if (Intrinsics.areEqual(r14, ")") == true) goto L60;
        Intrinsics.checkNotNull(r14);
        r10.add(r14);
    L60:
        throw new IllegalArgumentException("括号不匹配");
    L61:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v28, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v43, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Double] */
    private final double b(List<String> r13, Map<String, Double> r14) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        Stack r16 = new Stack();
        Iterator r17 = r12.iterator();
    L3:
        boolean r2 = true;
        if (r17.hasNext() == false) goto L165;
        ?? r1 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.toDoubleOrNull(r1) == null) goto L9;
        r1 = Double.valueOf(Double.parseDouble(r1));
    L8:
        r16.push(r1);
        goto L3
    L9:
        double r5 = 0.0d;
        if (f88b.containsKey(r1) == false) goto L115;
        if (Intrinsics.areEqual(r1, "=") == false) goto L35;
        if (r16.size() < 2) goto L33;
        Object r3 = r16.pop();
        Object r4 = r16.pop();
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L31;
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L21;
        double r6 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L25:
        r15.put(r4, Double.valueOf(r6));
        r1 = Double.valueOf(r6);
        goto L8
    L21:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L29;
        Double r7 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r3), Double.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L27;
        r6 = r7.doubleValue();
        goto L25
    L27:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")));
    L29:
        throw new IllegalArgumentException("赋值运算错误：右操作数无效");
    L31:
        throw new IllegalArgumentException("赋值运算错误：左操作数不是变量名");
    L33:
        throw new IllegalArgumentException("表达式错误：赋值运算缺少操作数");
    L35:
        if (r16.size() < 2) goto L113;
        Object r8 = r16.pop();
        Object r9 = r16.pop();
        if (ZeusTransformUtils.instanceOf(r9, Double.class) == false) goto L40;
        double r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L45:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L48;
        double r11 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L52:
        int r18 = r1.hashCode();
        if (r18 == 42) goto L99;
        if (r18 == 43) goto L96;
        if (r18 == 45) goto L93;
        if (r18 == 47) goto L90;
        if (r18 == 60) goto L84;
        if (r18 == 62) goto L79;
        if (r18 == 1921) goto L74;
        if (r18 != 1983) goto L103;
        if (r1.equals(">=") == false) goto L103;
        if (r10 >= r11) goto L87;
    L88:
        r1 = Double.valueOf(r5);
    L87:
        r5 = 1.0d;
    L103:
        throw new IllegalArgumentException("未知运算符: " + r1);
    L74:
        if (r1.equals("<=") == false) goto L103;
        if (r10 > r11) goto L88;
    L79:
        if (r1.equals(">") == false) goto L103;
        if (r10 <= r11) goto L88;
    L84:
        if (r1.equals("<") == false) goto L103;
        if (r10 >= r11) goto L88;
    L90:
        if (r1.equals("/") == false) goto L103;
        double r19 = r10 / r11;
    L101:
        r1 = Double.valueOf(r19);
        goto L8
    L93:
        if (r1.equals("-") == false) goto L103;
        r19 = r10 - r11;
        goto L101
    L96:
        if (r1.equals(Marker.ANY_NON_NULL_MARKER) == false) goto L103;
        r19 = r10 + r11;
        goto L101
    L99:
        if (r1.equals("*") == false) goto L103;
        r19 = r10 * r11;
        goto L101
    L48:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L107;
        Double r20 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r8), Double.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L105;
        r11 = r20.doubleValue();
        goto L52
    L105:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin")));
    L107:
        throw new IllegalArgumentException("运算错误：右操作数无效");
    L40:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L111;
        Double r21 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r9), Double.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L109;
        r10 = r21.doubleValue();
        goto L45
    L109:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin")));
    L111:
        throw new IllegalArgumentException("运算错误：左操作数无效");
    L113:
        throw new IllegalArgumentException("表达式错误：运算符 " + r1 + " 缺少操作数");
    L115:
        if (Intrinsics.areEqual(r1, "?") == false) goto L8;
        if (r16.size() < 3) goto L163;
        Object r22 = r16.pop();
        Object r23 = r16.pop();
        Object r24 = r16.pop();
        if (ZeusTransformUtils.instanceOf(r24, Double.class) == false) goto L122;
        double r25 = ((Number) ZeusTransformUtils.preCheckCast(r24, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L127:
        if (ZeusTransformUtils.instanceOf(r23, Double.class) == false) goto L130;
        double r26 = ((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L135:
        if (ZeusTransformUtils.instanceOf(r22, Double.class) == false) goto L138;
        double r27 = ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L143:
        if (r25 == 0.0d) goto L146;
        r2 = false;
    L146:
        if (r2 == false) goto L149;
        r26 = r27;
    L149:
        r1 = Double.valueOf(r26);
        goto L8
    L138:
        if (ZeusTransformUtils.instanceOf(r22, String.class) == false) goto L153;
        Double r28 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r22), Double.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L151;
        r27 = r28.doubleValue();
        goto L143
    L151:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.memorydata.plugin")));
    L153:
        throw new IllegalArgumentException("三元运算符错误：假分支无效");
    L130:
        if (ZeusTransformUtils.instanceOf(r23, String.class) == false) goto L157;
        Double r29 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r23), Double.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L155;
        r26 = r29.doubleValue();
        goto L135
    L155:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.memorydata.plugin")));
    L157:
        throw new IllegalArgumentException("三元运算符错误：真分支无效");
    L122:
        if (ZeusTransformUtils.instanceOf(r24, String.class) == false) goto L161;
        Double r30 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r24), Double.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L159;
        r25 = r30.doubleValue();
        goto L127
    L159:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.memorydata.plugin")));
    L161:
        throw new IllegalArgumentException("三元运算符错误：条件无效");
    L163:
        throw new IllegalArgumentException("三元运算符错误：缺少操作数");
    L165:
        if (r16.size() != 1) goto L180;
        Object r110 = r16.pop();
        if (ZeusTransformUtils.instanceOf(r110, Double.class) == false) goto L170;
        return ((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L170:
        if (ZeusTransformUtils.instanceOf(r110, String.class) == false) goto L178;
        Double r111 = (Double) ZeusTransformUtils.preCheckCast(r15.get(r110), Double.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L176;
        return r111.doubleValue();
    L176:
        throw new IllegalArgumentException("未定义变量: " + ((String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin")));
    L178:
        throw new IllegalArgumentException("表达式错误：结果无效");
    L180:
        throw new IllegalArgumentException("表达式错误：堆栈中存在多个结果");
    }

    private final List<String> b(String r1) {
        return a(c(r1));
    }

    private final List<String> c(String r11) {
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r11.length()) goto L75;
        char r2 = r11.charAt(r1);
        if ('0' > r2) goto L9;
        if (r2 >= ':') goto L9;
        boolean r6 = true;
    L10:
        String r8 = "";
        if (r6 == true) goto L64;
        if (r2 == '.') goto L64;
        if ('a' > r2) goto L18;
        if (r2 >= '{') goto L18;
        boolean r3 = true;
    L19:
        if (r3 == true) goto L59;
        if ('A' <= r2) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == true) goto L59;
        if (r2 != '+') goto L31;
    L49:
        if (r2 == '>') goto L51;
        if (r2 == '<') goto L51;
    L56:
        r10.add(String.valueOf(r2));
    L57:
        r1 = r1 + 1;
    L51:
        int r5 = r1 + 1;
        if (r5 >= r11.length()) goto L56;
        if (r11.charAt(r5) != '=') goto L56;
        r10.add(new StringBuilder().append(r2).append('=').toString());
        r1 = r5;
        goto L57
    L31:
        if (r2 == '-') goto L49;
        if (r2 == '*') goto L49;
        if (r2 == '/') goto L49;
        if (r2 == '(') goto L49;
        if (r2 == ')') goto L49;
        if (r2 == '=') goto L49;
        if (r2 == '{') goto L49;
        if (r2 == '}') goto L49;
        if (r2 == '?') goto L49;
        if (r2 == ':') goto L49;
        if (r2 == '>') goto L49;
        if (r2 != '<') goto L57;
    L23:
        if (r2 >= '[') goto L25;
        r4 = true;
    L59:
        if (r1 >= r11.length()) goto L74;
        if (Character.isLetterOrDigit(r11.charAt(r1)) == false) goto L74;
        r8 = r8 + r11.charAt(r1);
        r1 = r1 + 1;
    L74:
        r10.add(r8);
    L18:
        r3 = false;
    L64:
        if (r1 >= r11.length()) goto L74;
        char r7 = r11.charAt(r1);
        if ('0' > r7) goto L69;
        if (r7 >= ':') goto L69;
        boolean r9 = true;
    L70:
        if (r9 == true) goto L73;
        if (r11.charAt(r1) != '.') goto L74;
    L73:
        r8 = r8 + r11.charAt(r1);
        r1 = r1 + 1;
    L69:
        r9 = false;
    L9:
        r6 = false;
        goto L10
    L75:
        return r10;
    }

    public final double a(List<? extends List<String>> r5, Map<String, Double> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Map<String, Double> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "statements");
        Intrinsics.checkNotNullParameter(r8, "variables");
        Iterator r9 = r7.iterator();
        double r2 = 0.0d;
    L4:
        if (r9.hasNext() == false) goto L6;
        r2 = b((List) ZeusTransformUtils.preCheckCast(r9.next(), List.class, "com.obric.memorydata.plugin"), r8);
        goto L4
    L6:
        return r2;
    }

    public final List<List<String>> a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "expression");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{";"}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L15;
        Object r2 = r13.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        r1.add(r2);
        goto L8
    L12:
        r3 = false;
        goto L13
    L15:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        List<List<String>> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        r4.add(b((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin")));
        goto L17
    L19:
        return r4;
    }
}
