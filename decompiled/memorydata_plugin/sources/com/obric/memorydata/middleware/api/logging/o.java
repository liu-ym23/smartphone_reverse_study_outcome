package com.obric.memorydata.middleware.api.logging;

import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003J?\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000JX\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\b\u00142\u001b\b\u0002\u0010\u0017\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012¢\u0006\u0002\b\u0014JO\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\b\u0014Ja\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001e2\u001b\b\u0002\u0010\u0017\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012¢\u0006\u0002\b\u0014H\u0002JG\u0010\u001f\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000J \u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001eH\u0001J(\u0010!\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001eH\u0001J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u001eH\u0002J,\u0010#\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "", "rawTag", "", "biz", "component", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "withComponent", "debug", "", "message", "Lkotlin/Function0;", "context", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "fields", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/api/logging/LogFieldsBuilder;", "Lkotlin/ExtensionFunctionType;", "mainTrace", "event", "debugFields", "errorTrace", "code", "throwable", "", "emitTrace", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/memorydata/middleware/api/logging/LogFields;", "warning", "emitDebug", "emitWarning", "attachComponent", "format", "Companion", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11629b;
    private final String c;
    private final String d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/ModuleLogger$Companion;", "", "<init>", "()V", "COMPONENT_FIELD", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11628a = new a(null);
    }

    public o(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "rawTag");
        Intrinsics.checkNotNullParameter(r3, "biz");
        this.f11629b = r2;
        this.c = r3;
        this.d = r4;
    }

    public /* synthetic */ o(String r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    private final f a(f r6) {
        String r5 = this.d;
        if (r5 != null) goto L5;
        return r6;
    L5:
        g r0 = new g();
        r0.a("component", r5);
        Iterator<Map.Entry<String, String>> r7 = r6.a().entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2, "component") == true) goto L7;
        r0.a(r2, r9);
        goto L7
    L12:
        return r0.a();
    }

    static /* synthetic */ String a(o r0, String r1, e r2, f r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = null;
    L7:
        return r0.a(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: format");
    }

    private final String a(String r9, e r10, f r11, String r12) {
        m r0 = m.f11626a;
        p r1 = m.f11626a.a(this.c, r10);
        if (r12 == null) goto L5;
        String r13 = m.f11626a.c(r12);
    L7:
        return m.a(r0, r1, null, r13, m.f11626a.a(r9), a(r11), 2, null);
    L5:
        r13 = null;
        goto L7
    }

    private static final Unit a(g r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void a(o r15, String r16, String r17, e r18, Function1 r19, Function1 r20, int r21, Object r22) {
        Function1<? super g, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super g, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L17;
        if ((r21 & 4) == 0) goto L7;
        e r12 = new e(null, null, null, 7, null);
    L9:
        if ((r21 & 8) == 0) goto L11;
        r0 = $$Lambda$o$oICYvSwGELySJ_rQ6JS5buO8kQ0.INSTANCE;
    L11:
        Function1<? super g, Unit> r13 = r0;
        if ((r21 & 16) == 0) goto L14;
        r1 = null;
    L14:
        r15.a(r16, r17, r12, r13, r1);
        return;
    L7:
        r12 = r18;
        goto L9
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mainTrace");
    }

    static /* synthetic */ void a(o r10, String r11, String r12, String r13, String r14, Throwable r15, e r16, f r17, Function1 r18, int r19, Object r20) {
        Function1<? super g, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L10;
        if ((r19 & 128) == 0) goto L7;
        r0 = null;
    L7:
        r10.a(r11, r12, r13, r14, r15, r16, r17, r0);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emitTrace");
    }

    public static /* synthetic */ void a(o r13, String r14, String r15, String r16, Throwable r17, e r18, Function1 r19, int r20, Object r21) {
        Function1<? super g, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L18;
        if ((r20 & 8) == 0) goto L7;
        Throwable r6 = null;
    L9:
        if ((r20 & 16) == 0) goto L11;
        e r7 = new e(null, null, null, 7, null);
    L13:
        if ((r20 & 32) == 0) goto L15;
        r0 = $$Lambda$o$ibBIkJcjuuZ3msRMiqLopMuMlnA.INSTANCE;
    L15:
        r13.a(r14, r15, r16, r6, r7, r0);
        return;
    L11:
        r7 = r18;
        goto L13
    L7:
        r6 = r17;
        goto L9
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: errorTrace");
    }

    private final void a(String r15, String r16, String r17, String r18, Throwable r19, e r20, f r21, Function1<? super g, Unit> r22) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        p r12 = m.f11626a.a(this.c, r20);
        String r4 = m.f11626a.c(r17);
        if (r18 == null) goto L5;
        String r1 = m.f11626a.c(r18);
    L6:
        String r5 = m.f11626a.a(r16);
        String r9 = r1;
        String r6 = m.f11626a.a(r12, r4, r9, r5, f.f11616a.a());
        f r7 = a(r21);
        f r13 = r7.a(r6.length());
        if (r2 != null) goto L9;
    L11:
        f r11 = r13;
    L12:
        String r3 = m.f11626a.a(r12, r4, r1, r5, r11);
        if (Intrinsics.areEqual(r15, "error_trace") == false) goto L15;
        RunLog.INSTANCE.error(this.f11629b, r3, r19);
    L16:
        j.f11623a.a("android", r15, r5, r4, r1, r12, r13);
        return;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11629b, r3, false, 4, null);
        goto L16
    L9:
        if (AppContext.INSTANCE.isDebug() == false) goto L11;
        g r8 = new g();
        r2.invoke(r8);
        r11 = r7.a(r8.a()).a(r6.length());
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private static final Unit b(g r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$ibBIkJcjuuZ3msRMiqLopMuMlnA(g r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$oICYvSwGELySJ_rQ6JS5buO8kQ0(g r0) {
        return a(r0);
    }

    public final o a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "component");
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return this;
    L9:
        return new o(this.f11629b, this.c, r4);
    L5:
        r0 = false;
        goto L6
    }

    public final String a() {
        return this.c;
    }

    public final void a(String r10, e r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "fields");
        RunLog.INSTANCE.debug(this.f11629b, a(this, r10, r11, r12, null, 8, null));
    }

    public final void a(String r8, String r9, e r10, f r11) {
        Intrinsics.checkNotNullParameter(r8, "code");
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "fields");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11629b, a(r9, r10, r11, r8), null, 4, null);
    }

    public final void a(String r10, String r11, e r12, Function1<? super g, Unit> r13, Function1<? super g, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super g, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "event");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r15, "fields");
        g r16 = new g();
        r15.invoke(r16);
        a("main_trace", r10, r11, null, null, r12, r16.a(), r8);
    }

    public final void a(String r14, String r15, String r16, Throwable r17, e r18, Function1<? super g, Unit> r19) {
        Function1 r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "message");
        Intrinsics.checkNotNullParameter(r15, "event");
        Intrinsics.checkNotNullParameter(r16, "code");
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r0, "fields");
        g r1 = new g();
        r0.invoke(r1);
        a(this, "error_trace", r14, r15, r16, r17, r18, r1.a(), null, 128, null);
    }
}
