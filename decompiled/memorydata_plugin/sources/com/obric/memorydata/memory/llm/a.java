package com.obric.memorydata.memory.llm;

import com.obric.memorydata.dc.PageContextRequest;
import com.obric.memorydata.memory.x;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.sdk.memory.State;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016JB\u0010\u0011\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/llm/LLMCloudMemoryBuildStrategy;", "Lcom/obric/memorydata/memory/strategy/MemoryBuildStrategy;", "<init>", "()V", "build", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "", "", "trackingEvent", "Lcom/obric/memorydata/memory/strategy/MemoryTrackingEvent;", "memorySourceInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "eval", "", "retryBuild", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.memory.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0506a f10277a = null;
    private static final Lazy<a> c = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.llm.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/llm/LLMCloudMemoryBuildStrategy$Companion;", "", "<init>", "()V", "instance", "Lcom/obric/memorydata/memory/llm/LLMCloudMemoryBuildStrategy;", "getInstance", "()Lcom/obric/memorydata/memory/llm/LLMCloudMemoryBuildStrategy;", "instance$delegate", "Lkotlin/Lazy;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0506a {
        private C0506a() {
        }

        public /* synthetic */ C0506a(DefaultConstructorMarker r1) {
            this();
        }

        public final a a() {
            return (a) ZeusTransformUtils.preCheckCast(a.a().getValue(), a.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f10277a = new C0506a(null);
        c = LazyKt.lazy($$Lambda$a$TBiqUrn6mfGk4Ecg9rNjhcaEi0w.INSTANCE);
    }

    public a() {
    }

    public static final /* synthetic */ Lazy a() {
        return c;
    }

    private static final Unit a(com.obric.memorydata.memory.memoryentity.f r4, com.obric.memorydata.memory.memoryentity.f r5, com.obric.memorydata.middleware.api.logging.g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        r6.a("memory_source_info", r4);
        r6.a("product_type", Integer.valueOf(r5.a()));
        boolean r1 = false;
        if (r5.d() != null) goto L14;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.l(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == false) goto L14;
        boolean r9 = false;
    L15:
        r6.a("has_image", Boolean.valueOf(r9));
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.v(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L18;
    L21:
        boolean r11 = true;
    L22:
        r6.a("has_text", Boolean.valueOf(!r11));
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.k(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L25;
    L26:
        r1 = true;
    L27:
        r6.a("has_chat_history", Boolean.valueOf(!r1));
        return Unit.INSTANCE;
    L25:
        if (r12.length() != 0) goto L27;
    L18:
        if (r10.length() == 0) goto L21;
        r11 = false;
        goto L22
    L7:
        if (r7.length() == 0) goto L10;
        r8 = false;
    L14:
        r9 = true;
        goto L15
    }

    private static final Unit a(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "operationId");
        x.a(x.f11587a, r11, State.BEGIN, null, null, r10, null, 32, null);
        return Unit.INSTANCE;
    }

    private static final a b() {
        return new a();
    }

    /* JADX INFO: renamed from: lambda$5_rpl6Cye46fqrOG6oM-8wXlC1U, reason: not valid java name */
    public static /* synthetic */ Unit m736lambda$5_rpl6Cye46fqrOG6oM8wXlC1U(com.obric.memorydata.memory.memoryentity.f r0, com.obric.memorydata.memory.memoryentity.f r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$9TLdb9lV7klTqNrpYlfOuyua2U4(boolean r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ a lambda$TBiqUrn6mfGk4Ecg9rNjhcaEi0w() {
        return b();
    }

    @Override // com.obric.memorydata.memory.e.a
    public Pair<List<MemoryLLMBuildHelperV2.a>, Map<String, Object>> a(com.obric.memorydata.memory.e.b r23, final com.obric.memorydata.memory.memoryentity.f r24, boolean r25) {
        com.obric.memorydata.memory.e.b r0 = (com.obric.memorydata.memory.e.b) ZeusTransformUtils.wrapperContextForParams(r23, com.obric.memorydata.memory.e.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, "memorySourceInfo");
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.tracker.g.b.class) == false) goto L5;
        com.obric.memorydata.memory.tracker.g.b r2 = (com.obric.memorydata.memory.tracker.g.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.tracker.g.b.class, "com.obric.memorydata.plugin");
    L6:
        o r7 = b.a(Integer.valueOf(r24.a()));
        com.obric.memorydata.middleware.api.logging.e r3 = com.obric.memorydata.middleware.api.logging.e.a(r24.n(), r7.a(), null, "build", 2, null);
        final boolean r1 = false;
        if (r24.d() != null) goto L42;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r24.v(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L42;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r24.w(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L42;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r24.k(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L27;
    L30:
        boolean r10 = true;
    L31:
        if (r10 == false) goto L42;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r24.l(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L35;
    L38:
        boolean r12 = true;
    L39:
        if (r12 == false) goto L42;
        o.a(r7, "记忆构建输入为空", "input_prepare_failed", "source_input_empty", null, r3, null, 40, null);
        return new Pair(null, MapsKt.emptyMap());
    L35:
        if (r11.length() == 0) goto L38;
        r12 = false;
        goto L39
    L27:
        if (r9.length() == 0) goto L30;
        r10 = false;
        goto L31
    L19:
        if (r6.length() == 0) goto L22;
        r8 = false;
        goto L23
    L11:
        if (r4.length() == 0) goto L14;
        r5 = false;
    L42:
        o.a(r7, "记忆构建已开始", "build_start", r3, new $$Lambda$a$5_rpl6Cye46fqrOG6oM8wXlC1U(r24, r24), null, 16, null);
        c r13 = r24.q();
        if (r13 == null) goto L46;
        String r14 = r13.a();
        if (r14 == null) goto L46;
    L47:
        String r15 = r14;
        if (r25 == false) goto L50;
    L60:
        com.obric.memorydata.dc.a r16 = r24.p();
        if (r16 == null) goto L63;
    L72:
        com.obric.memorydata.dc.a r17 = r16;
    L74:
        return (Pair) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new LLMCloudMemoryBuildStrategy$build$1$3(r24, r2, r3, r24, r17, r25, r7, r13, r15, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Pair.class, "com.obric.memorydata.plugin");
    L63:
        if (r24.a() != 8) goto L65;
    L71:
        r17 = null;
        goto L74
    L65:
        if (r24.a() == 7) goto L71;
        if (r24.f() == null) goto L71;
        if (r24.g() == true) goto L71;
        r16 = com.obric.memorydata.dc.b.f9848a.a(new PageContextRequest(r24.f(), 0, 2, null));
        goto L72
    L50:
        if (r24.a() == 3) goto L60;
        int r18 = r24.a();
        if (r18 != 9) goto L54;
    L56:
        r1 = true;
    L57:
        if (r13 == null) goto L59;
        r13.c(new $$Lambda$a$9TLdb9lV7klTqNrpYlfOuyua2U4(r1));
        goto L60
    L59:
        x.a(x.f11587a, r15, State.BEGIN, null, null, r1, null, 32, null);
        goto L60
    L54:
        if (r18 == 10) goto L56;
    L46:
        r14 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        goto L47
    L5:
        r2 = null;
        goto L6
    }
}
