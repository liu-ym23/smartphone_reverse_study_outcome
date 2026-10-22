package com.obric.memorydata.realtimecontext;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÂ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/realtimecontext/CompiledSceneCondition;", "", "key", "", "matcher", "Lkotlin/Function1;", "Lcom/obric/memorydata/realtimecontext/ActionRecommendViewNodeInfo;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getKey", "()Ljava/lang/String;", "matches", "node", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12476b;
    private final Function1<h, Boolean> c;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001J0\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0002J0\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bH\u0002J0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bH\u0002J0\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/realtimecontext/CompiledSceneCondition$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/realtimecontext/CompiledSceneCondition;", "key", "", EventBody.KEY_VALUE, "regexCondition", "valueProvider", "Lkotlin/Function1;", "Lcom/obric/memorydata/realtimecontext/ActionRecommendViewNodeInfo;", "minNumberCondition", "", "maxNumberCondition", "booleanCondition", "", "visibilityCondition", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final l a(String r3, Object r4, Function1<? super h, String> r5) {
            final Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            final Regex r1 = null;
            Object r6 = null;
            if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L5;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        L6:
            if (r7 == null) goto L18;
            a r8 = l.f12475a;
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L10
            Object r10 = Result.m1421constructorimpl(new Regex(r7));     // Catch: Throwable -> L10
        L13:
            if (Result.m1427isFailureimpl(r10) == true) goto L16;
            r6 = r10;
        L16:
            r1 = (Regex) ZeusTransformUtils.preCheckCast(r6, Regex.class, "com.obric.memorydata.plugin");
        L10:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L18:
            return new l(r3, new $$Lambda$l$a$XubcTWorB03tDOUD7o59nv0CKNM(r1, r2));
        L5:
            r7 = null;
            goto L6
        }

        private static final String a(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.a();
        }

        private static final boolean a(Boolean r2, Function1 r3, h r4) {
            Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "node");
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r5.invoke(r4), r2) == false) goto L7;
            return true;
        }

        private static final boolean a(Double r5, Function1 r6, h r7) {
            Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "node");
            if (r5 == null) goto L16;
            Double r9 = (Double) ZeusTransformUtils.preCheckCast(r8.invoke(r7), Double.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L7;
        L12:
            boolean r10 = false;
        L13:
            if (r10 == false) goto L16;
            return true;
        L7:
            if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).doubleValue() < r5.doubleValue()) goto L9;
            boolean r11 = true;
        L10:
            if (r11 != true) goto L12;
            r10 = true;
            goto L13
        L9:
            r11 = false;
        L16:
            return false;
        }

        private static final boolean a(Integer r1, h r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r2.g(), r1) == false) goto L7;
            return true;
        }

        private static final boolean a(Regex r3, Function1 r4, h r5) {
            Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "node");
            if (r3 == null) goto L11;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6.invoke(r5), String.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L8;
            r7 = "";
        L8:
            if (r3.matches((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) != true) goto L11;
            return true;
        L11:
            return false;
        }

        private final l b(String r4, Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L7;
            int r3 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        L5:
            final Integer r6 = Integer.valueOf(r3);
        L28:
            return new l(r4, new $$Lambda$l$a$v9xOUGFqDHUStoXr3NDyUPrbFKk(r6));
        L7:
            if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L26;
            String r7 = ((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r7, "toUpperCase(...)");
            int r1 = r7.hashCode();
            if (r1 == 2193567) goto L23;
            if (r1 == 884789133) goto L19;
            if (r1 == 1184726098) goto L16;
        L24:
            r6 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));
            goto L28
        L16:
            if (r7.equals("VISIBLE") == false) goto L24;
            r3 = 0;
            goto L5
        L19:
            if (r7.equals("INVISIBLE") == false) goto L24;
            r3 = 4;
            goto L5
        L23:
            if (r7.equals("GONE") == false) goto L24;
            r3 = 8;
            goto L5
        L26:
            r6 = null;
            goto L28
        }

        private final l b(String r2, Object r3, Function1<? super h, Double> r4) {
            final Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            final Double r5 = e.a(r3);
            return new l(r2, new $$Lambda$l$a$2XjPF2UElw3dS8r4b4NmjZId_Yw(r5, r1));
        }

        private static final String b(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.b();
        }

        private static final boolean b(Double r5, Function1 r6, h r7) {
            Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "node");
            if (r5 == null) goto L16;
            Double r9 = (Double) ZeusTransformUtils.preCheckCast(r8.invoke(r7), Double.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L7;
        L12:
            boolean r10 = false;
        L13:
            if (r10 == false) goto L16;
            return true;
        L7:
            if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).doubleValue() > r5.doubleValue()) goto L9;
            boolean r11 = true;
        L10:
            if (r11 != true) goto L12;
            r10 = true;
            goto L13
        L9:
            r11 = false;
        L16:
            return false;
        }

        private final l c(String r2, Object r3, Function1<? super h, Double> r4) {
            final Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            final Double r5 = e.a(r3);
            return new l(r2, new $$Lambda$l$a$li3rRAsjtiTTk5jS_2L3MqI4_6A(r5, r1));
        }

        private static final String c(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.c();
        }

        private final l d(String r2, Object r3, Function1<? super h, Boolean> r4) {
            final Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            final Boolean r5 = e.b(r3);
            return new l(r2, new $$Lambda$l$a$dKzCyQOnkZeF5nku11M7jImUF4(r5, r1));
        }

        private static final String d(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.d();
        }

        private static final Double e(h r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Integer r3 = r2.e();
            if (r3 != null) goto L7;
            return null;
        L7:
            return Double.valueOf(r3.intValue());
        }

        private static final Double f(h r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Integer r3 = r2.f();
            if (r3 != null) goto L7;
            return null;
        L7:
            return Double.valueOf(r3.intValue());
        }

        private static final Double g(h r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Integer r3 = r2.e();
            if (r3 != null) goto L7;
            return null;
        L7:
            return Double.valueOf(r3.intValue());
        }

        private static final Double h(h r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Integer r3 = r2.f();
            if (r3 != null) goto L7;
            return null;
        L7:
            return Double.valueOf(r3.intValue());
        }

        private static final Double i(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.t();
        }

        private static final Double j(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.u();
        }

        private static final Double k(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.t();
        }

        private static final Double l(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.u();
        }

        public static /* synthetic */ Boolean lambda$2F8aqLa5oa4yGMaGobxh_hPewCo(h r0) {
            return p(r0);
        }

        public static /* synthetic */ boolean lambda$2XjPF2UElw3dS8r4b4NmjZId_Yw(Double r0, Function1 r1, h r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ String lambda$4vdL0bP3FwpEoESRPnReQuyViJU(h r0) {
            return c(r0);
        }

        /* JADX INFO: renamed from: lambda$9e85Br21CY7j9rS0UzcI-GjyTRU, reason: not valid java name */
        public static /* synthetic */ String m1109lambda$9e85Br21CY7j9rS0UzcIGjyTRU(h r0) {
            return b(r0);
        }

        public static /* synthetic */ Boolean lambda$Bx6m3pTP4r507a48tBXD7aJsMbY(h r0) {
            return q(r0);
        }

        public static /* synthetic */ Double lambda$BywYwt9xFT1S570ke23CjhCJ2wo(h r0) {
            return l(r0);
        }

        public static /* synthetic */ Boolean lambda$E_BimycnXOWnwx21edtfwwGZs5M(h r0) {
            return r(r0);
        }

        public static /* synthetic */ Double lambda$G2EuH2yynjQYpvD9B0bW3pirygM(h r0) {
            return f(r0);
        }

        public static /* synthetic */ Boolean lambda$H57NQsV7c4d4NTWDZJXpdrc0CQE(h r0) {
            return o(r0);
        }

        public static /* synthetic */ Boolean lambda$HGynacRAjGTBWSBsnlfF8kBN3YA(h r0) {
            return v(r0);
        }

        public static /* synthetic */ Double lambda$HozQ7egq1Cq4dKAPy2CrUvIZfg8(h r0) {
            return g(r0);
        }

        /* JADX INFO: renamed from: lambda$KjrK2eVqTA-aJM-WuQElv_lsnNE, reason: not valid java name */
        public static /* synthetic */ Double m1110lambda$KjrK2eVqTAaJMWuQElv_lsnNE(h r0) {
            return h(r0);
        }

        public static /* synthetic */ Boolean lambda$R3BTBfC3C2wMGQVTAjmUQMsvT5s(h r0) {
            return w(r0);
        }

        public static /* synthetic */ boolean lambda$XubcTWorB03tDOUD7o59nv0CKNM(Regex r0, Function1 r1, h r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ boolean lambda$a3M3N5gvnxk9dzhLzQoVxHqkJPI(h r0) {
            return y(r0);
        }

        /* JADX INFO: renamed from: lambda$aAYvgWVTcDy__-lGqbWjlOwtbfY, reason: not valid java name */
        public static /* synthetic */ Boolean m1111lambda$aAYvgWVTcDy__lGqbWjlOwtbfY(h r0) {
            return m(r0);
        }

        public static /* synthetic */ Double lambda$aL6OSFNmhAVX07_FD7ZewXOVHu8(h r0) {
            return i(r0);
        }

        public static /* synthetic */ Boolean lambda$cbRmbu988CjxOEcRWDJRLhN_Ur4(h r0) {
            return t(r0);
        }

        public static /* synthetic */ Boolean lambda$ckxiETouwK9CH2IlS51QokAh7bA(h r0) {
            return x(r0);
        }

        /* JADX INFO: renamed from: lambda$dKzCyQOnkZeF5nku1-1M7jImUF4, reason: not valid java name */
        public static /* synthetic */ boolean m1112lambda$dKzCyQOnkZeF5nku11M7jImUF4(Boolean r0, Function1 r1, h r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ Boolean lambda$dPEVbvz3jlpP327RioOo43cmvrA(h r0) {
            return u(r0);
        }

        public static /* synthetic */ Double lambda$gD4FZuz0kQQTXEMiFUHuVpL_q0w(h r0) {
            return k(r0);
        }

        public static /* synthetic */ Double lambda$kVMJc5aDcStmM3uOcZ4Dk1_FEDo(h r0) {
            return j(r0);
        }

        public static /* synthetic */ String lambda$koH5Dim880167ZWd0rMq2nWjxMo(h r0) {
            return d(r0);
        }

        public static /* synthetic */ boolean lambda$li3rRAsjtiTTk5jS_2L3MqI4_6A(Double r0, Function1 r1, h r2) {
            return b(r0, r1, r2);
        }

        public static /* synthetic */ Boolean lambda$qRw_VgXsK5jKy43c6maiJ9WGgsE(h r0) {
            return s(r0);
        }

        public static /* synthetic */ Double lambda$qwMyg9F56vbgGdEObS4WLBUURGY(h r0) {
            return e(r0);
        }

        public static /* synthetic */ boolean lambda$v9xOUGFqDHUStoXr3NDyUPrbFKk(Integer r0, h r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ Boolean lambda$vMsc3WN1iO5pwnk89RVKWs0Hn1M(h r0) {
            return n(r0);
        }

        public static /* synthetic */ String lambda$xp9s09D_VxzjohdshxwkJkpc1xw(h r0) {
            return a(r0);
        }

        private static final Boolean m(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.h();
        }

        private static final Boolean n(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.i();
        }

        private static final Boolean o(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.j();
        }

        private static final Boolean p(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.k();
        }

        private static final Boolean q(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.l();
        }

        private static final Boolean r(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.m();
        }

        private static final Boolean s(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.n();
        }

        private static final Boolean t(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.o();
        }

        private static final Boolean u(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.p();
        }

        private static final Boolean v(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.q();
        }

        private static final Boolean w(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.r();
        }

        private static final Boolean x(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.s();
        }

        private static final boolean y(h r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return false;
        }

        public final l a(String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            String r0 = r3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r0, "toLowerCase(...)");
            switch(r0.hashCode()) {
                case -1964681502: goto L108;
                case -1609594047: goto L104;
                case -1346262348: goto L99;
                case -1006363674: goto L95;
                case -691041417: goto L91;
                case -440990103: goto L86;
                case -371903648: goto L82;
                case -8935421: goto L77;
                case 3355: goto L73;
                case 3079825: goto L69;
                case 3556653: goto L65;
                case 10066827: goto L61;
                case 94742904: goto L58;
                case 204392913: goto L54;
                case 285012402: goto L50;
                case 311711337: goto L46;
                case 398964322: goto L42;
                case 429934306: goto L38;
                case 742313895: goto L34;
                case 782545401: goto L30;
                case 1191572123: goto L26;
                case 1381316055: goto L22;
                case 1629011506: goto L18;
                case 1655576083: goto L14;
                case 1835636664: goto L10;
                case 1941332754: goto L6;
                default: goto L113;
            };
        L6:
            if (r0.equals("visibility") == false) goto L113;
            return b(r3, r4);
        L10:
            if (r0.equals("visibletouser") == false) goto L113;
            Function1<? super h, Boolean> r1 = $$Lambda$l$a$aAYvgWVTcDy__lGqbWjlOwtbfY.INSTANCE;
        L118:
            return d(r3, r4, r1);
        L14:
            if (r0.equals("contextclickable") == false) goto L113;
            r1 = $$Lambda$l$a$Bx6m3pTP4r507a48tBXD7aJsMbY.INSTANCE;
            goto L118
        L18:
            if (r0.equals("focusable") == false) goto L113;
            r1 = $$Lambda$l$a$E_BimycnXOWnwx21edtfwwGZs5M.INSTANCE;
            goto L118
        L22:
            if (r0.equals("minwidthratio") == false) goto L113;
            Function1<? super h, Double> r2 = $$Lambda$l$a$aL6OSFNmhAVX07_FD7ZewXOVHu8.INSTANCE;
        L117:
            return b(r3, r4, r2);
        L26:
            if (r0.equals(com.xiphias.browser.scanner.BuildConfig.FLAVOR) == false) goto L113;
            r1 = $$Lambda$l$a$dPEVbvz3jlpP327RioOo43cmvrA.INSTANCE;
            goto L118
        L30:
            if (r0.equals("minheight") == false) goto L113;
            r2 = $$Lambda$l$a$G2EuH2yynjQYpvD9B0bW3pirygM.INSTANCE;
            goto L117
        L34:
            if (r0.equals("checked") == false) goto L113;
            r1 = $$Lambda$l$a$ckxiETouwK9CH2IlS51QokAh7bA.INSTANCE;
            goto L118
        L38:
            if (r0.equals("maxwidth") == false) goto L113;
            Function1<? super h, Double> r5 = $$Lambda$l$a$HozQ7egq1Cq4dKAPy2CrUvIZfg8.INSTANCE;
        L116:
            return c(r3, r4, r5);
        L42:
            if (r0.equals("checkable") == false) goto L113;
            r1 = $$Lambda$l$a$R3BTBfC3C2wMGQVTAjmUQMsvT5s.INSTANCE;
            goto L118
        L46:
            if (r0.equals("accessibilityfocused") == false) goto L113;
            r1 = $$Lambda$l$a$cbRmbu988CjxOEcRWDJRLhN_Ur4.INSTANCE;
            goto L118
        L50:
            if (r0.equals("minheightratio") == false) goto L113;
            r2 = $$Lambda$l$a$kVMJc5aDcStmM3uOcZ4Dk1_FEDo.INSTANCE;
            goto L117
        L54:
            if (r0.equals("activated") == false) goto L113;
            r1 = $$Lambda$l$a$HGynacRAjGTBWSBsnlfF8kBN3YA.INSTANCE;
            goto L118
        L58:
            if (r0.equals("class") == false) goto L113;
        L79:
            Function1<? super h, String> r6 = $$Lambda$l$a$koH5Dim880167ZWd0rMq2nWjxMo.INSTANCE;
        L115:
            return a(r3, r4, r6);
        L61:
            if (r0.equals("maxheight") == false) goto L113;
            r5 = $$Lambda$l$a$KjrK2eVqTAaJMWuQElv_lsnNE.INSTANCE;
            goto L116
        L65:
            if (r0.equals(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == false) goto L113;
            r6 = $$Lambda$l$a$9e85Br21CY7j9rS0UzcIGjyTRU.INSTANCE;
            goto L115
        L69:
            if (r0.equals("desc") == false) goto L113;
            r6 = $$Lambda$l$a$4vdL0bP3FwpEoESRPnReQuyViJU.INSTANCE;
            goto L115
        L73:
            if (r0.equals(OaidModel.KEY_ID) == false) goto L113;
            r6 = $$Lambda$l$a$xp9s09D_VxzjohdshxwkJkpc1xw.INSTANCE;
            goto L115
        L77:
            if (r0.equals("classname") == true) goto L79;
        L82:
            if (r0.equals("maxheightratio") == false) goto L113;
            r5 = $$Lambda$l$a$BywYwt9xFT1S570ke23CjhCJ2wo.INSTANCE;
            goto L116
        L86:
            if (r0.equals("maxwidthratio") == false) goto L113;
            r5 = $$Lambda$l$a$gD4FZuz0kQQTXEMiFUHuVpL_q0w.INSTANCE;
            goto L116
        L91:
            if (r0.equals("focused") == false) goto L113;
            r1 = $$Lambda$l$a$qRw_VgXsK5jKy43c6maiJ9WGgsE.INSTANCE;
            goto L118
        L95:
            if (r0.equals("longclickable") == false) goto L113;
            r1 = $$Lambda$l$a$2F8aqLa5oa4yGMaGobxh_hPewCo.INSTANCE;
            goto L118
        L99:
            if (r0.equals("minwidth") == false) goto L113;
            r2 = $$Lambda$l$a$qwMyg9F56vbgGdEObS4WLBUURGY.INSTANCE;
            goto L117
        L104:
            if (r0.equals("enabled") == false) goto L113;
            r1 = $$Lambda$l$a$vMsc3WN1iO5pwnk89RVKWs0Hn1M.INSTANCE;
            goto L118
        L108:
            if (r0.equals("clickable") == false) goto L113;
            r1 = $$Lambda$l$a$H57NQsV7c4d4NTWDZJXpdrc0CQE.INSTANCE;
        L113:
            return new l(r3, $$Lambda$l$a$a3M3N5gvnxk9dzhLzQoVxHqkJPI.INSTANCE);
        }
    }

    static {
        f12475a = new a(null);
    }

    public l(String r3, Function1<? super h, Boolean> r4) {
        Function1<h, Boolean> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "matcher");
        this.f12476b = r3;
        this.c = r5;
    }

    public final boolean a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12476b, r6.f12476b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f12476b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CompiledSceneCondition(key=" + this.f12476b + ", matcher=" + this.c + ')';
    }
}
