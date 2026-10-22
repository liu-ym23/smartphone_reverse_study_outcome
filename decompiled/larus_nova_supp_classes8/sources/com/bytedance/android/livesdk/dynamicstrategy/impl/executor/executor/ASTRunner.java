package com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.c0;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.model.z0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j40.f4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ASTRunner {
    public static final Map<String, b0> a = null;
    public static final Map<String, Object> b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/executor/executor/ASTRunner$ASTExecuteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ASTExecuteException extends RuntimeException {
        private final String message;

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public ASTExecuteException(String r1) {
            this.message = r1;
        }
    }

    public static final class a {
        public final Map<String, Object> a;
        public final Map<String, Object> b;

        public a(Map<String, ? extends Object> r1) {
            this.b = r1;
            this.a = new LinkedHashMap();
        }
    }

    public static final class a0 implements q {
        public static final a0 a = null;

        public a0() {
        }

        static {
            a = new a0();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r12, a r13) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r13, "dataContext");
            Map<String, b0> r0 = ASTRunner.a;
            Intrinsics.checkNotNullParameter("context_strategy_name", "key");
            Object r1 = ((LinkedHashMap) r13.a).get("context_strategy_name");
            if (r1 != null) goto L9;
            Map<String, Object> r14 = r13.b;
            if (r14 == null) goto L7;
            r1 = r14.get("context_strategy_name");
            goto L9
        L7:
            r1 = null;
        L9:
            if ((r1 instanceof String) == true) goto L11;
            r1 = null;
        L11:
            String r2 = (String) r1;
            Object r3 = CollectionsKt.getOrNull(r12, 0);
            if ((r3 instanceof Number) == true) goto L14;
            r3 = null;
        L14:
            Number r4 = (Number) r3;
            if (r4 == null) goto L17;
            Integer r5 = Integer.valueOf(r4.intValue());
        L18:
            Object r6 = CollectionsKt.getOrNull(r12, 1);
            if ((r6 instanceof Number) == true) goto L21;
            r6 = null;
        L21:
            Number r7 = (Number) r6;
            if (r7 == null) goto L24;
            Long r8 = Long.valueOf(r7.longValue());
        L25:
            Object r9 = CollectionsKt.getOrNull(r12, 2);
            if ((r9 instanceof Number) == true) goto L28;
            r9 = null;
        L28:
            Number r10 = (Number) r9;
            if (r10 == null) goto L31;
            Integer r11 = Integer.valueOf(r10.intValue());
        L32:
            Object r15 = CollectionsKt.getOrNull(r12, 3);
            if (r15 == null) goto L35;
            String r16 = r15.toString();
        L37:
            if ((r2 instanceof String) == true) goto L39;
        L67:
            int r17 = lu1.k.a;
            lu1.k.h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy_frequency_error"), TuplesKt.to("strategy", String.valueOf(r2)), TuplesKt.to("consecutive_times", String.valueOf(r5)), TuplesKt.to("interval_in_sec", String.valueOf(r8)), TuplesKt.to("total_times", String.valueOf(r11)), TuplesKt.to("tag", String.valueOf(r16))}), null);
            return Boolean.TRUE;
        L39:
            if ((r5 instanceof Integer) == false) goto L67;
            if ((r8 instanceof Long) == false) goto L67;
            if ((r11 instanceof Integer) == false) goto L67;
            if ((r16 instanceof String) == false) goto L67;
            com.bytedance.android.livesdk.sharedpref.e r18 = f4.x;
            z0 r19 = (z0) r18.getValue();
            if (r19 != null) goto L49;
            r19 = new z0(null);
        L49:
            Map r20 = r19.a();
            if (r20 != null) goto L52;
            r20 = new LinkedHashMap();
            r19.b(r20);
        L52:
            String r110 = r2 + '@' + r16;
            List r21 = (List) r20.get(r110);
            if (r21 != null) goto L56;
            r21 = new ArrayList();
            r20.put(r110, r21);
        L56:
            if (r21.size() >= r11.intValue()) goto L58;
            long r22 = System.currentTimeMillis() / ((long) BubbleId.PadCast);
            if (r21.size() >= r5.intValue()) goto L62;
        L65:
            r21.add(Long.valueOf(r22));
            com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
            return Boolean.TRUE;
        L62:
            if ((r22 - ((Number) ListProtector.get(r21, r21.size() - r5.intValue())).longValue()) > r8.longValue()) goto L65;
            return Boolean.FALSE;
        L58:
            return Boolean.FALSE;
        L35:
            r16 = null;
            goto L37
        L31:
            r11 = null;
            goto L32
        L24:
            r8 = null;
            goto L25
        L17:
            r5 = null;
            goto L18
        }
    }

    public static final class b implements c {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r2, Object r3, a r4) {
            Intrinsics.checkNotNullParameter(r2, "paramA");
            Intrinsics.checkNotNullParameter(r3, "paramB");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            if ((r2 instanceof Boolean) == false) goto L15;
            if ((r3 instanceof Boolean) == false) goto L15;
            if (((Boolean) r2).booleanValue() == true) goto L9;
        L11:
            boolean r5 = false;
        L13:
            return Boolean.valueOf(r5);
        L9:
            if (((Boolean) r3).booleanValue() == false) goto L11;
            r5 = true;
        L15:
            throw new ASTExecuteException("AndOperation error, param is not Boolean");
        }
    }

    public interface b0 {
        Object a(Object r1, a r2);
    }

    public interface c {
        Object a(Object r1, Object r2, a r3);
    }

    public static final class d implements c {
        public final String a;

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "operator");
            this.a = r2;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r4, Object r5, a r6) {
            Intrinsics.checkNotNullParameter(r4, "paramA");
            Intrinsics.checkNotNullParameter(r5, "paramB");
            Intrinsics.checkNotNullParameter(r6, "dataContext");
            boolean r0 = false;
            if ((r4 instanceof String) == false) goto L8;
            if ((r5 instanceof String) == false) goto L8;
            int r7 = ((String) r4).compareTo((String) r5);
        L29:
            String r8 = this.a;
            int r9 = r8.hashCode();
            if (r9 == 60) goto L64;
            if (r9 == 62) goto L60;
            if (r9 == 1084) goto L56;
            if (r9 == 1921) goto L51;
            if (r9 == 1952) goto L47;
            if (r9 != 1983) goto L70;
            if (r8.equals(">=") == false) goto L70;
            if (r7 == 0) goto L66;
            if (r7 > 0) goto L66;
        L68:
            return Boolean.valueOf(r0);
        L66:
            r0 = true;
        L70:
            throw new ASTExecuteException("CompareOperation error, unknown operator[" + this.a + ']');
        L47:
            if (r8.equals("==") == false) goto L70;
            if (r7 != 0) goto L68;
        L51:
            if (r8.equals("<=") == false) goto L70;
            if (r7 == 0) goto L66;
            if (r7 >= 0) goto L68;
        L56:
            if (r8.equals("!=") == false) goto L70;
            if (r7 == 0) goto L68;
        L60:
            if (r8.equals(">") == false) goto L70;
            if (r7 <= 0) goto L68;
        L64:
            if (r8.equals("<") == false) goto L70;
            if (r7 >= 0) goto L68;
        L8:
            if ((r4 instanceof Boolean) == false) goto L16;
            if ((r5 instanceof Boolean) == false) goto L16;
            if (Intrinsics.areEqual(r4, r5) == false) goto L14;
            r7 = 0;
            goto L29
        L14:
            r7 = -1;
        L16:
            if ((r4 instanceof Number) == false) goto L72;
            if ((r5 instanceof Number) == false) goto L72;
            Map<String, b0> r10 = ASTRunner.a;
            Number r11 = (Number) r4;
            Number r12 = (Number) r5;
            int r13 = Math.max(ASTRunner.a(r11), ASTRunner.a(r12));
            if (r13 != 2) goto L22;
            r7 = (r11.longValue() > r12.longValue() ? 1 : (r11.longValue() == r12.longValue() ? 0 : -1));
            goto L29
        L22:
            if (r13 != 3) goto L24;
            r7 = Float.compare(r11.floatValue(), r12.floatValue());
            goto L29
        L24:
            if (r13 == 4) goto L26;
            r7 = Intrinsics.compare(r11.intValue(), r12.intValue());
            goto L29
        L26:
            r7 = Double.compare(r11.doubleValue(), r12.doubleValue());
        L72:
            throw new ASTExecuteException("CompareOperation error, params can not compare, paramA is " + r4 + ", paramB is " + r5);
        }
    }

    public static final class e implements b0 {
        public static final e a = null;

        public e() {
        }

        static {
            a = new e();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            if ((r3 instanceof Double) == false) goto L6;
            return Double.valueOf(((Number) r3).doubleValue() - 1.0d);
        L6:
            if ((r3 instanceof Long) == false) goto L9;
            return Long.valueOf(((Number) r3).longValue() - 1);
        L9:
            if ((r3 instanceof Integer) == false) goto L12;
            return Integer.valueOf(((Number) r3).intValue() - 1);
        L12:
            if ((r3 instanceof Float) == false) goto L16;
            return Float.valueOf(((Number) r3).floatValue() - 1.0f);
        L16:
            throw new ASTExecuteException("DecOperation error, unknown param type[" + r3.getClass() + ']');
        }
    }

    public static final class f implements c {
        public static final f a = null;

        public f() {
        }

        static {
            a = new f();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r3, Object r4, a r5) {
            Intrinsics.checkNotNullParameter(r3, "paramA");
            Intrinsics.checkNotNullParameter(r4, "paramB");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            if ((r3 instanceof Number) == false) goto L20;
            if ((r4 instanceof Number) == false) goto L20;
            if ((!Intrinsics.areEqual(r4, 0)) == false) goto L20;
            Map<String, b0> r6 = ASTRunner.a;
            Number r7 = (Number) r3;
            Number r8 = (Number) r4;
            int r9 = Math.max(ASTRunner.a(r7), ASTRunner.a(r8));
            if (r9 == 2) goto L18;
            if (r9 == 3) goto L23;
            if (r9 == 4) goto L22;
            return Integer.valueOf(r7.intValue() / r8.intValue());
        L22:
            return Double.valueOf(r7.doubleValue() / r8.doubleValue());
        L23:
            return Float.valueOf(r7.floatValue() / r8.floatValue());
        L18:
            return Long.valueOf(r7.longValue() / r8.longValue());
        L20:
            throw new ASTExecuteException("DivOperation error, param can not calculate or is zero, paramA is " + r3 + ", paramB is " + r4);
        }
    }

    public static final class g implements b0 {
        public static final g a = null;

        public g() {
        }

        static {
            a = new g();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            if ((r3 instanceof Double) == false) goto L6;
            return Double.valueOf(((Number) r3).doubleValue() + 1.0d);
        L6:
            if ((r3 instanceof Long) == false) goto L9;
            return Long.valueOf(((Number) r3).longValue() + 1);
        L9:
            if ((r3 instanceof Integer) == false) goto L12;
            return Integer.valueOf(((Number) r3).intValue() + 1);
        L12:
            if ((r3 instanceof Float) == false) goto L16;
            return Float.valueOf(((Number) r3).floatValue() + 1.0f);
        L16:
            throw new ASTExecuteException("IncOperation error, unknown param type[" + r3.getClass() + ']');
        }
    }

    public static final class h implements q {
        public static final h a = null;

        public h() {
        }

        static {
            a = new h();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            Object r6 = CollectionsKt.getOrNull(r4, 0);
            Object r7 = CollectionsKt.getOrNull(r4, 1);
            if ((r6 instanceof List) == false) goto L8;
            if (r7 == null) goto L8;
            return Boolean.valueOf(((List) r6).contains(r7));
        L8:
            throw new ASTExecuteException("ListContainOperation error, param can not calculate, list is " + r6 + ", value is " + r7);
        }
    }

    public static final class i implements q {
        public static final i a = null;

        public i() {
        }

        static {
            a = new i();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r5, a r6) {
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r6, "dataContext");
            Object r7 = CollectionsKt.getOrNull(r5, 0);
            Integer r1 = null;
            if ((r7 instanceof List) == true) goto L5;
            r7 = null;
        L5:
            List r8 = (List) r7;
            Object r0 = CollectionsKt.getOrNull(r5, 1);
            if ((r0 instanceof Number) == true) goto L8;
            r0 = null;
        L8:
            Number r2 = (Number) r0;
            if (r2 == null) goto L11;
            r1 = Integer.valueOf(r2.intValue());
        L11:
            Object r9 = CollectionsKt.getOrNull(r5, 2);
            if (r8 == null) goto L26;
            if (r1 == null) goto L26;
            if (r9 == null) goto L26;
            if (r1.intValue() < r8.size()) goto L18;
            return r9;
        L18:
            if (r1.intValue() < 0) goto L28;
            Object r10 = ListProtector.get(r8, r1.intValue());
            if (r10 != null) goto L24;
            return r9;
        L24:
            return r10;
        L28:
            return r9;
        L26:
            throw new ASTExecuteException("ListGetOperation error, param can not calculate, list is " + r8 + ", index is " + r1 + ", defaultValue is " + r9);
        }
    }

    public static final class j implements q {
        public static final j a = null;

        public j() {
        }

        static {
            a = new j();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            Object r5 = CollectionsKt.getOrNull(r3, 0);
            if ((r5 instanceof Number) == false) goto L7;
            return Double.valueOf(Math.log10(((Number) r5).doubleValue()));
        L7:
            throw new ASTExecuteException("Log10Operation error, param can not calculate, param is " + r5);
        }
    }

    public static final class k implements q {
        public static final k a = null;

        public k() {
        }

        static {
            a = new k();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            Object r5 = CollectionsKt.getOrNull(r3, 0);
            if ((r5 instanceof Number) == false) goto L7;
            return Double.valueOf(MathKt.log2(((Number) r5).doubleValue()));
        L7:
            throw new ASTExecuteException("Log2Operation error, param can not calculate, param is " + r5);
        }
    }

    public static final class l implements q {
        public static final l a = null;

        public l() {
        }

        static {
            a = new l();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            Object r6 = CollectionsKt.getOrNull(r4, 0);
            Object r7 = CollectionsKt.getOrNull(r4, 1);
            if ((r6 instanceof Number) == false) goto L9;
            if ((r7 instanceof Number) == false) goto L9;
            return Double.valueOf(Math.log(((Number) r7).doubleValue()) / Math.log(((Number) r6).doubleValue()));
        L9:
            throw new ASTExecuteException("LogOperation error, param can not calculate, paramA is " + r6 + ", paramB is " + r7);
        }
    }

    public static final class m implements q {
        public static final m a = null;

        public m() {
        }

        static {
            a = new m();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r5, a r6) {
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r6, "dataContext");
            Object r7 = CollectionsKt.getOrNull(r5, 0);
            Object r0 = CollectionsKt.getOrNull(r5, 1);
            Object r8 = CollectionsKt.getOrNull(r5, 2);
            if ((r7 instanceof Map) == false) goto L12;
            if (r0 == null) goto L12;
            if (r8 == null) goto L12;
            Object r9 = ((Map) r7).get(r0);
            if (r9 != null) goto L10;
            return r8;
        L10:
            return r9;
        L12:
            throw new ASTExecuteException("MapGetOperation error, param can not calculate, map is " + r7 + ", key is " + r0 + ", defaultValue is " + r8);
        }
    }

    public static final class n implements q {
        public static final n a = null;

        public n() {
        }

        static {
            a = new n();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            Object r6 = CollectionsKt.getOrNull(r4, 0);
            Object r7 = CollectionsKt.getOrNull(r4, 1);
            if ((r6 instanceof Number) == false) goto L18;
            if ((r7 instanceof Number) == false) goto L18;
            Map<String, b0> r0 = ASTRunner.a;
            Number r8 = (Number) r6;
            Number r9 = (Number) r7;
            int r1 = Math.max(ASTRunner.a(r8), ASTRunner.a(r9));
            if (r1 == 2) goto L16;
            if (r1 == 3) goto L21;
            if (r1 == 4) goto L20;
            return Integer.valueOf(RangesKt.coerceAtLeast(r8.intValue(), r9.intValue()));
        L20:
            return Double.valueOf(RangesKt.coerceAtLeast(r8.doubleValue(), r9.doubleValue()));
        L21:
            return Float.valueOf(RangesKt.coerceAtLeast(r8.floatValue(), r9.floatValue()));
        L16:
            return Long.valueOf(RangesKt.coerceAtLeast(r8.longValue(), r9.longValue()));
        L18:
            throw new ASTExecuteException("MaxOperation error, param can not calculate, paramA is " + r6 + ", paramB is " + r7);
        }
    }

    public static final class o implements q {
        public static final o a = null;

        public o() {
        }

        static {
            a = new o();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            Object r6 = CollectionsKt.getOrNull(r4, 0);
            Object r7 = CollectionsKt.getOrNull(r4, 1);
            if ((r6 instanceof Number) == false) goto L18;
            if ((r7 instanceof Number) == false) goto L18;
            Map<String, b0> r0 = ASTRunner.a;
            Number r8 = (Number) r6;
            Number r9 = (Number) r7;
            int r1 = Math.max(ASTRunner.a(r8), ASTRunner.a(r9));
            if (r1 == 2) goto L16;
            if (r1 == 3) goto L21;
            if (r1 == 4) goto L20;
            return Integer.valueOf(RangesKt.coerceAtMost(r8.intValue(), r9.intValue()));
        L20:
            return Double.valueOf(RangesKt.coerceAtMost(r8.doubleValue(), r9.doubleValue()));
        L21:
            return Float.valueOf(RangesKt.coerceAtMost(r8.floatValue(), r9.floatValue()));
        L16:
            return Long.valueOf(RangesKt.coerceAtMost(r8.longValue(), r9.longValue()));
        L18:
            throw new ASTExecuteException("MinOperation error, param can not calculate, paramA is " + r6 + ", paramB is " + r7);
        }
    }

    public static final class p implements c {
        public static final p a = null;

        public p() {
        }

        static {
            a = new p();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r3, Object r4, a r5) {
            Intrinsics.checkNotNullParameter(r3, "paramA");
            Intrinsics.checkNotNullParameter(r4, "paramB");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            if ((r3 instanceof Number) == false) goto L18;
            if ((r4 instanceof Number) == false) goto L18;
            Map<String, b0> r6 = ASTRunner.a;
            Number r7 = (Number) r3;
            Number r8 = (Number) r4;
            int r9 = Math.max(ASTRunner.a(r7), ASTRunner.a(r8));
            if (r9 == 2) goto L16;
            if (r9 == 3) goto L21;
            if (r9 == 4) goto L20;
            return Integer.valueOf(r7.intValue() - r8.intValue());
        L20:
            return Double.valueOf(r7.doubleValue() - r8.doubleValue());
        L21:
            return Float.valueOf(r7.floatValue() - r8.floatValue());
        L16:
            return Long.valueOf(r7.longValue() - r8.longValue());
        L18:
            throw new ASTExecuteException("MinusOperation error, param can not calculate, paramA is " + r3 + ", paramB is " + r4);
        }
    }

    public interface q {
        Object a(List<? extends Object> r1, a r2);
    }

    public static final class r implements b0 {
        public static final r a = null;

        public r() {
        }

        static {
            a = new r();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            if ((r3 instanceof Boolean) == false) goto L7;
            return Boolean.valueOf(!((Boolean) r3).booleanValue());
        L7:
            throw new ASTExecuteException("NegateOperation error, param is not Boolean, param is " + r3);
        }
    }

    public static final class s implements b0 {
        public static final s a = null;

        public s() {
        }

        static {
            a = new s();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "param");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            if ((r3 instanceof Number) == false) goto L16;
            Map<String, b0> r5 = ASTRunner.a;
            Number r6 = (Number) r3;
            int r7 = ASTRunner.a(r6);
            if (r7 == 2) goto L14;
            if (r7 == 3) goto L19;
            if (r7 == 4) goto L18;
            return Integer.valueOf(0 - r6.intValue());
        L18:
            return Double.valueOf(((double) 0) - r6.doubleValue());
        L19:
            return Float.valueOf(0 - r6.floatValue());
        L14:
            return Long.valueOf(0 - r6.longValue());
        L16:
            throw new ASTExecuteException("NegativeSignOperation error, param can not calculate");
        }
    }

    public static final class t implements c {
        public static final t a = null;

        public t() {
        }

        static {
            a = new t();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r3, Object r4, a r5) {
            Intrinsics.checkNotNullParameter(r3, "paramA");
            Intrinsics.checkNotNullParameter(r4, "paramB");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            if ((r3 instanceof Boolean) == false) goto L16;
            if ((r4 instanceof Boolean) == false) goto L16;
            if (((Boolean) r3).booleanValue() == false) goto L9;
        L12:
            boolean r6 = true;
        L14:
            return Boolean.valueOf(r6);
        L9:
            if (((Boolean) r4).booleanValue() == true) goto L12;
            r6 = false;
        L16:
            throw new ASTExecuteException("OrOperation error, param is not Boolean, paramA is " + r3 + ", paramB is " + r4);
        }
    }

    public static final class u implements c {
        public static final u a = null;

        public u() {
        }

        static {
            a = new u();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r3, Object r4, a r5) {
            Intrinsics.checkNotNullParameter(r3, "paramA");
            Intrinsics.checkNotNullParameter(r4, "paramB");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            if ((r3 instanceof Number) == false) goto L18;
            if ((r4 instanceof Number) == false) goto L18;
            Map<String, b0> r6 = ASTRunner.a;
            Number r7 = (Number) r3;
            Number r8 = (Number) r4;
            int r9 = Math.max(ASTRunner.a(r7), ASTRunner.a(r8));
            if (r9 == 2) goto L16;
            if (r9 == 3) goto L21;
            if (r9 == 4) goto L20;
            return Integer.valueOf(r7.intValue() + r8.intValue());
        L20:
            return Double.valueOf(r7.doubleValue() + r8.doubleValue());
        L21:
            return Float.valueOf(r7.floatValue() + r8.floatValue());
        L16:
            return Long.valueOf(r7.longValue() + r8.longValue());
        L18:
            throw new ASTExecuteException("PlusOperation error, param can not calculate, paramA is " + r3 + ", paramB is " + r4);
        }
    }

    public static final class v implements b0 {
        public static final v a = null;

        public v() {
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r2, a r3) {
            Intrinsics.checkNotNullParameter(r2, "param");
            Intrinsics.checkNotNullParameter(r3, "dataContext");
            return r2;
        }

        static {
            a = new v();
        }
    }

    public static final class w implements q {
        public static final w a = null;

        public w() {
        }

        static {
            a = new w();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            Object r6 = CollectionsKt.getOrNull(r4, 0);
            Object r7 = CollectionsKt.getOrNull(r4, 1);
            if ((r6 instanceof Number) == false) goto L9;
            if ((r7 instanceof Number) == false) goto L9;
            return Double.valueOf(Math.pow(((Number) r6).doubleValue(), ((Number) r7).doubleValue()));
        L9:
            throw new ASTExecuteException("PowOperation error, param can not calculate, paramA is " + r6 + ", paramB is " + r7);
        }
    }

    public static final class x implements c {
        public static final x a = null;

        public x() {
        }

        static {
            a = new x();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r3, Object r4, a r5) {
            Intrinsics.checkNotNullParameter(r3, "paramA");
            Intrinsics.checkNotNullParameter(r4, "paramB");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            if ((r3 instanceof Number) == false) goto L20;
            if ((r4 instanceof Number) == false) goto L20;
            if ((!Intrinsics.areEqual(r4, 0)) == false) goto L20;
            Map<String, b0> r6 = ASTRunner.a;
            Number r7 = (Number) r3;
            Number r8 = (Number) r4;
            int r9 = Math.max(ASTRunner.a(r7), ASTRunner.a(r8));
            if (r9 == 2) goto L18;
            if (r9 == 3) goto L23;
            if (r9 == 4) goto L22;
            return Integer.valueOf(r7.intValue() % r8.intValue());
        L22:
            return Double.valueOf(r7.doubleValue() % r8.doubleValue());
        L23:
            return Float.valueOf(r7.floatValue() % r8.floatValue());
        L18:
            return Long.valueOf(r7.longValue() % r8.longValue());
        L20:
            throw new ASTExecuteException("RemOperation error, param can not calculate or is zero, paramA is " + r3 + ", paramB is " + r4);
        }
    }

    public static final class y implements q {
        public static final y a = null;

        public y() {
        }

        static {
            a = new y();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "dataContext");
            Object r5 = CollectionsKt.getOrNull(r3, 0);
            if ((r5 instanceof String) == false) goto L7;
            return ((String) r5).toLowerCase(Locale.ENGLISH);
        L7:
            throw new ASTExecuteException("StrToLowerOperation error, param can not calculate, param is " + r5);
        }
    }

    public static final class z implements c {
        public static final z a = null;

        public z() {
        }

        static {
            a = new z();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r3, Object r4, a r5) {
            Intrinsics.checkNotNullParameter(r3, "paramA");
            Intrinsics.checkNotNullParameter(r4, "paramB");
            Intrinsics.checkNotNullParameter(r5, "dataContext");
            if ((r3 instanceof Number) == false) goto L18;
            if ((r4 instanceof Number) == false) goto L18;
            Map<String, b0> r6 = ASTRunner.a;
            Number r7 = (Number) r3;
            Number r8 = (Number) r4;
            int r9 = Math.max(ASTRunner.a(r7), ASTRunner.a(r8));
            if (r9 == 2) goto L16;
            if (r9 == 3) goto L21;
            if (r9 == 4) goto L20;
            return Integer.valueOf(r7.intValue() * r8.intValue());
        L20:
            return Double.valueOf(r7.doubleValue() * r8.doubleValue());
        L21:
            return Float.valueOf(r7.floatValue() * r8.floatValue());
        L16:
            return Long.valueOf(r7.longValue() * r8.longValue());
        L18:
            throw new ASTExecuteException("TimesOperation error, param can not calculate, paramA is " + r3 + ", paramB is " + r4);
        }
    }

    public ASTRunner() {
    }

    static {
        a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("!", r.a), TuplesKt.to("++", g.a), TuplesKt.to("--", e.a), TuplesKt.to("+", v.a), TuplesKt.to("-", s.a)});
        b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("&&", b.a), TuplesKt.to("||", t.a), TuplesKt.to("+", u.a), TuplesKt.to("-", p.a), TuplesKt.to("*", z.a), TuplesKt.to("/", f.a), TuplesKt.to("%", x.a), TuplesKt.to("==", new d("==")), TuplesKt.to(">=", new d(">=")), TuplesKt.to(">", new d(">")), TuplesKt.to("<=", new d("<=")), TuplesKt.to("<", new d("<")), TuplesKt.to("!=", new d("!=")), TuplesKt.to("min", o.a), TuplesKt.to("max", n.a), TuplesKt.to("pow", w.a), TuplesKt.to("log", l.a), TuplesKt.to("log2", k.a), TuplesKt.to("log10", j.a), TuplesKt.to("listget", i.a), TuplesKt.to("listcontain", h.a), TuplesKt.to("mapget", m.a), TuplesKt.to("strtolower", y.a), TuplesKt.to("triggerfrequency", a0.a)});
    }

    public static final int a(Number r1) {
        if ((r1 instanceof Long) == false) goto L6;
        return 2;
    L6:
        if ((r1 instanceof Float) == false) goto L9;
        return 3;
    L9:
        if ((r1 instanceof Double) == false) goto L11;
        return 4;
    L11:
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object] */
    public static Object b(com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r7, a r8) {
        Intrinsics.checkNotNullParameter(r7, "astRuleDetail");
        Intrinsics.checkNotNullParameter(r8, "astDataContext");
        Object r3 = null;
        String r4 = null;
        Object r5 = null;
        String r6 = null;
        switch(r7.nodeType) {
            case 1: goto L133;
            case 2: goto L128;
            case 3: goto L123;
            case 4: goto L116;
            case 5: goto L97;
            case 6: goto L87;
            case 7: goto L66;
            case 8: goto L48;
            case 9: goto L29;
            case 10: goto L5;
            case 11: goto L19;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.c r9 = r7.array_node;
        if (r9 == null) goto L18;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.a> r10 = r9.nodes;
        if (r10 == null) goto L18;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.a> r11 = r10;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        r0.add(b((com.bytedance.android.livesdk.dynamicstrategy.api.entity.a) r12.next(), r8));
        goto L12
    L14:
        List r13 = CollectionsKt.toList(r0);
        if (r13 == null) goto L18;
        return r13;
    L18:
        throw new ASTExecuteException("arrayNode error, node is null");
    L19:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.r r14 = r7.map_node;
        if (r14 == null) goto L28;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.u> r15 = r14.pairs;
        if (r15 == null) goto L28;
        ?? r16 = new LinkedHashMap();
        Iterator r17 = r15.iterator();
    L25:
        if (r17.hasNext() == false) goto L149;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.u r1 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.u) r17.next();
        r16.put(r1.key, r1.value);
    L149:
        return r16;
    L28:
        throw new ASTExecuteException("mapNode error, node is null");
    L29:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.h r18 = r7.conditionNode;
        Object r2 = b(r18.condition, r8);
        if ((r2 instanceof Boolean) == true) goto L45;
        int r19 = lu1.k.a;
        Intrinsics.checkNotNullParameter("context_strategy_name", "key");
        Object r20 = ((LinkedHashMap) r8.a).get("context_strategy_name");
        if (r20 != null) goto L38;
        Map<String, Object> r21 = r8.b;
        if (r21 == null) goto L36;
        r20 = r21.get("context_strategy_name");
        goto L38
    L36:
        r20 = null;
    L38:
        if ((r20 instanceof String) == true) goto L40;
        r20 = null;
    L40:
        String r22 = (String) r20;
        if (r22 != null) goto L43;
        r22 = "unknown";
    L43:
        lu1.k.h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy_condition_error"), TuplesKt.to("strategy", r22), TuplesKt.to("condition_result", String.valueOf(r2))}), null);
    L45:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L147;
        return b(r18.then, r8);
    L147:
        return b(r18.otherwise, r8);
    L48:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.o r23 = r7.identifierNode;
        if (r23 == null) goto L61;
        String r24 = r23.value;
        if (r24 == null) goto L61;
        Intrinsics.checkNotNullParameter(r24, "key");
        Object r25 = ((LinkedHashMap) r8.a).get(r24);
        if (r25 != null) goto L58;
        Map<String, Object> r26 = r8.b;
        if (r26 == null) goto L57;
        r25 = r26.get(r24);
        goto L58
    L57:
        r25 = null;
    L58:
        if (r25 == null) goto L61;
        return r25;
    L61:
        StringBuilder r27 = new StringBuilder("identifierNode[");
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.o r28 = r7.identifierNode;
        if (r28 == null) goto L64;
        r4 = r28.value;
    L64:
        r27.append(r4);
        r27.append("] error, value is null");
        throw new ASTExecuteException(r27.toString());
    L66:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.g r29 = r7.callNode;
        ArrayList r30 = new ArrayList();
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.a> r31 = r29.arguments;
        if (r31 == null) goto L72;
        Iterator r32 = r31.iterator();
    L70:
        if (r32.hasNext() == false) goto L72;
        r30.add(b((com.bytedance.android.livesdk.dynamicstrategy.api.entity.a) r32.next(), r8));
    L72:
        Map<String, Object> r33 = b;
        String r34 = r29.caller.value;
        if (r34 == null) goto L75;
        String r35 = r34.toLowerCase(Locale.ENGLISH);
    L76:
        Object r36 = r33.get(r35);
        if ((r36 instanceof q) == false) goto L80;
        r5 = r36;
    L80:
        q r37 = (q) r5;
        if (r37 == null) goto L86;
        r16 = r37.a(r30, r8);
        if (r16 != 0) goto L149;
    L86:
        throw new ASTExecuteException("callNode error, unknown operation[" + r29.caller.value + ']');
    L75:
        r35 = null;
        goto L76
    L87:
        c0 r38 = r7.unaryNode;
        Object r39 = b(r38.node, r8);
        Map<String, b0> r40 = a;
        String r41 = r38.operator;
        if (r41 == null) goto L90;
        r6 = r41.toLowerCase(Locale.ENGLISH);
    L90:
        b0 r42 = r40.get(r6);
        if (r42 == null) goto L96;
        r16 = r42.a(r39, r8);
        if (r16 != 0) goto L149;
    L96:
        throw new ASTExecuteException("unaryNode error, unknown operation[" + r38.operator + ']');
    L97:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.e r43 = r7.binaryNode;
        Object r44 = b(r43.left, r8);
        Object r45 = b(r43.right, r8);     // Catch: Throwable -> L114
        Map<String, Object> r46 = b;
        String r47 = r43.operator;
        if (r47 == null) goto L102;
        String r48 = r47.toLowerCase(Locale.ENGLISH);
    L103:
        Object r49 = r46.get(r48);
        if ((r49 instanceof c) == false) goto L107;
        r3 = r49;
    L107:
        c r50 = (c) r3;
        if (r50 == null) goto L113;
        r16 = r50.a(r44, r45, r8);
        if (r16 != 0) goto L149;
    L113:
        throw new ASTExecuteException("binaryNode error, unknown operation[" + r43.operator + ']');
    L102:
        r48 = null;
    L114:
        th = move-exception;
        throw th;
    L116:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.b0 r51 = r7.stringNode;
        if (r51 == null) goto L122;
        String r52 = r51.value;
        if (r52 == null) goto L122;
        return r52;
    L122:
        throw new ASTExecuteException("stringNode error, node is null");
    L123:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.j r53 = r7.doubleNode;
        if (r53 == null) goto L127;
        return Double.valueOf(r53.value);
    L127:
        throw new ASTExecuteException("doubleNode error, node is null");
    L128:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.q r54 = r7.longNode;
        if (r54 == null) goto L132;
        return Long.valueOf(r54.value);
    L132:
        throw new ASTExecuteException("longNode error, node is null");
    L133:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r55 = r7.boolNode;
        if (r55 == null) goto L140;
        Boolean r56 = r55.value;
        if (r56 == null) goto L140;
        return Boolean.valueOf(r56.booleanValue());
    L140:
        throw new ASTExecuteException("boolNode error, node is null");
    L5:
        throw new ASTExecuteException("Node error, unknown node type, type is " + r7.nodeType);
    }

    public static Object c(com.bytedance.android.livesdk.dynamicstrategy.api.entity.b r11, Map r12) {
        Intrinsics.checkNotNullParameter(r11, "astStrategy");
        Intrinsics.checkNotNullParameter(r12, "stateMap");
        a r0 = new a(r12);
        String r13 = r11.a;
        Intrinsics.checkNotNullParameter("context_strategy_name", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r0.a.put("context_strategy_name", r13);
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.w> r14 = r11.e.rules;
        Object r1 = null;
        if (r14 == null) goto L29;
        Iterator<T> r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L29;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.w r4 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.w) r15.next();
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.d r5 = r4.astRule;
        if (r5 == null) goto L11;
        String r6 = r5.ruleKeyName;
        if (r6 == null) goto L11;
    L12:
        if (r5 == null) goto L6;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r7 = r5.root;
        if (r7 == null) goto L6;
        r1 = b(r7, r0);
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        r0.a.put(r6, r1);
        int r8 = lu1.k.a;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.d r9 = r4.astRule;
        if (r9 == null) goto L20;
        String r10 = r9.rule;
        if (r10 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r11, "strategy");
        Intrinsics.checkNotNullParameter(r6, "ruleName");
        Intrinsics.checkNotNullParameter(r10, "ruleValue");
        if (((ku1.b) ku1.c.a.getValue()).e() == false) goto L6;
        String r16 = String.valueOf(r1);
        if (r1 == null) goto L27;
        String r17 = Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName();
        if (r17 == null) goto L27;
    L28:
        lu1.k.g("DynamicStrategy_strategy_execute", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(LiveEndPageData.TAG_NAME, r11.a), TuplesKt.to("rule_name", r6), TuplesKt.to("rule_value", r10), TuplesKt.to("rule_result", r16), TuplesKt.to("rule_result_type", r17)}));
    L27:
        r17 = "null";
    L20:
        r10 = "";
    L11:
        r6 = "unknown_rule";
    L29:
        if (r1 == null) goto L32;
        return r1;
    L32:
        throw new ASTExecuteException("ASTRuleStrategy error, result is null");
    }
}
