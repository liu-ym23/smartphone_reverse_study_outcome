package com.obric.oui.texteffects.preset;

import com.obric.oui.texteffects.core.CharacterOrder;
import com.obric.oui.texteffects.core.CharacterRangeUnit;
import com.obric.oui.texteffects.core.c;
import com.obric.oui.texteffects.core.d;
import com.obric.oui.texteffects.core.e;
import com.obric.oui.texteffects.core.f;
import com.obric.oui.texteffects.core.g;
import com.obric.oui.texteffects.core.h;
import com.obric.oui.texteffects.core.i;
import com.obric.oui.texteffects.core.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0012\u0013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/texteffects/preset/AnimatedCharacterSpanPerformanceScenario;", "", "displayName", "", "sampleText", "config", "Lcom/obric/oui/texteffects/preset/AnimatedCharacterSpanPerformanceScenario$ScenarioConfig;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/obric/oui/texteffects/preset/AnimatedCharacterSpanPerformanceScenario$ScenarioConfig;)V", "getDisplayName", "()Ljava/lang/String;", "getSampleText", "buildSpec", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "Baseline15", "LongText60", "WideShape30", "MultiProperty30", "Stress60", "Companion", "ScenarioConfig", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AnimatedCharacterSpanPerformanceScenario extends Enum<AnimatedCharacterSpanPerformanceScenario> {
    private static final /* synthetic */ AnimatedCharacterSpanPerformanceScenario[] $VALUES = null;
    public static final AnimatedCharacterSpanPerformanceScenario Baseline15 = null;
    public static final a Companion = null;
    public static final long DurationMs = 1250;
    public static final AnimatedCharacterSpanPerformanceScenario LongText60 = null;
    public static final AnimatedCharacterSpanPerformanceScenario MultiProperty30 = null;
    private static final i OffsetEasing = null;
    private static final float OffsetEndRatio = 1.0f;
    private static final float OffsetStartRatio = -0.4f;
    private static final i PropertyShapeEasing = null;
    private static final float ScaleStart = 0.98f;
    public static final AnimatedCharacterSpanPerformanceScenario Stress60 = null;
    private static final float TranslationXDp = 6.0f;
    private static final float TranslationYDp = 8.0f;
    public static final AnimatedCharacterSpanPerformanceScenario WideShape30 = null;
    private final b config;
    private final String displayName;
    private final String sampleText;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/preset/AnimatedCharacterSpanPerformanceScenario$Companion;", "", "()V", "DurationMs", "", "OffsetEasing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "getOffsetEasing", "()Lcom/obric/oui/texteffects/core/EasingSpec;", "OffsetEndRatio", "", "OffsetStartRatio", "PropertyShapeEasing", "getPropertyShapeEasing", "ScaleStart", "TranslationXDp", "TranslationYDp", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/texteffects/preset/AnimatedCharacterSpanPerformanceScenario$ScenarioConfig;", "", "alphaEnabled", "", "translationXEnabled", "translationYEnabled", "scaleEnabled", "shapeRange", "", "(ZZZZF)V", "getAlphaEnabled", "()Z", "getScaleEnabled", "getShapeRange", "()F", "getTranslationXEnabled", "getTranslationYEnabled", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f14642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14643b;
        private final boolean c;
        private final boolean d;
        private final float e;

        public b(boolean r1, boolean r2, boolean r3, boolean r4, float r5) {
            this.f14642a = r1;
            this.f14643b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final boolean a() {
            return this.f14642a;
        }

        public final boolean b() {
            return this.f14643b;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final float e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f14642a == r6.f14642a) goto L12;
            return false;
        L12:
            if (this.f14643b == r6.f14643b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            boolean r0 = this.f14642a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f14643b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.d;
            if (r10 == true) goto L16;
            r1 = r10;
        L16:
            return ((r9 + r1) * 31) + Float.hashCode(this.e);
        }

        public String toString() {
            return "ScenarioConfig(alphaEnabled=" + this.f14642a + ", translationXEnabled=" + this.f14643b + ", translationYEnabled=" + this.c + ", scaleEnabled=" + this.d + ", shapeRange=" + this.e + ')';
        }
    }

    private static final /* synthetic */ AnimatedCharacterSpanPerformanceScenario[] $values() {
        return new AnimatedCharacterSpanPerformanceScenario[]{Baseline15, LongText60, WideShape30, MultiProperty30, Stress60};
    }

    static {
        Baseline15 = new AnimatedCharacterSpanPerformanceScenario("Baseline15", 0, "Baseline_15", "AnimatedSpanDBG", new b(true, true, false, true, 1.0f));
        LongText60 = new AnimatedCharacterSpanPerformanceScenario("LongText60", 1, "LongText_60", "AnimatedCharacterSpan benchmark long text scene for sixty chars.", new b(true, false, true, true, 1.0f));
        WideShape30 = new AnimatedCharacterSpanPerformanceScenario("WideShape30", 2, "WideShape_30", "Animated Character Span Wide!", new b(true, false, true, true, 6.0f));
        MultiProperty30 = new AnimatedCharacterSpanPerformanceScenario("MultiProperty30", 3, "MultiProperty_30", "Animated Character Span Props!", new b(true, true, true, true, 1.0f));
        Stress60 = new AnimatedCharacterSpanPerformanceScenario("Stress60", 4, "Stress_60", "AnimatedCharacterSpan stress scene with wide shape and all props", new b(true, true, true, true, 6.0f));
        $VALUES = $values();
        Companion = new a(null);
        OffsetEasing = (i) ZeusTransformUtils.preCheckCast(i.c.f14603a, i.class, "com.obric.memorydata.plugin");
        PropertyShapeEasing = (i) ZeusTransformUtils.preCheckCast(new i.a(0, 0.0f, 0.4f), i.class, "com.obric.memorydata.plugin");
    }

    private AnimatedCharacterSpanPerformanceScenario(String r1, int r2, String r3, String r4, b r5) {
        super(r1, r2);
        this.displayName = r3;
        this.sampleText = r4;
        this.config = r5;
    }

    public static final /* synthetic */ i access$getOffsetEasing$cp() {
        return OffsetEasing;
    }

    public static final /* synthetic */ i access$getPropertyShapeEasing$cp() {
        return PropertyShapeEasing;
    }

    public static AnimatedCharacterSpanPerformanceScenario valueOf(String r2) {
        return (AnimatedCharacterSpanPerformanceScenario) ZeusTransformUtils.preCheckCast(Enum.valueOf(AnimatedCharacterSpanPerformanceScenario.class, r2), AnimatedCharacterSpanPerformanceScenario.class, "com.obric.memorydata.plugin");
    }

    public static AnimatedCharacterSpanPerformanceScenario[] values() {
        return (AnimatedCharacterSpanPerformanceScenario[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AnimatedCharacterSpanPerformanceScenario[].class, "com.obric.memorydata.plugin");
    }

    public final d buildSpec() {
        h r8 = new h(this.config.e(), CharacterRangeUnit.TextWidthPercent, PropertyShapeEasing);
        CharacterOrder r14 = CharacterOrder.StartToEnd;
        if (this.config.a() == false) goto L5;
        float r2 = 0.0f;
    L6:
        f r7 = new f(r2, 1.0f, null, 4, null);
        i r11 = OffsetEasing;
        e r15 = new e(r7, new g(OffsetStartRatio, 1.0f, r11), r8);
        if (this.config.b() == false) goto L9;
        float r3 = 6.0f;
    L10:
        com.obric.oui.texteffects.core.b r16 = new com.obric.oui.texteffects.core.b(new c((m) ZeusTransformUtils.preCheckCast(new m.a(r3), m.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(new m.a(0.0f), m.class, "com.obric.memorydata.plugin"), null, 4, null), null, new g(OffsetStartRatio, 1.0f, r11), r8, 2, null);
        if (this.config.c() == false) goto L13;
        float r4 = 8.0f;
    L14:
        com.obric.oui.texteffects.core.b r17 = new com.obric.oui.texteffects.core.b(new c((m) ZeusTransformUtils.preCheckCast(new m.a(r4), m.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(new m.a(0.0f), m.class, "com.obric.memorydata.plugin"), null, 4, null), null, new g(OffsetStartRatio, 1.0f, r11), r8, 2, null);
        if (this.config.d() == false) goto L17;
        float r5 = 0.98f;
    L19:
        return new d(0, DurationMs, r14, r15, r16, r17, null, null, new e(new f(r5, 1.0f, null, 4, null), new g(OffsetStartRatio, 1.0f, r11), r8), 192, null);
    L17:
        r5 = 1.0f;
        goto L19
    L13:
        r4 = 0.0f;
        goto L14
    L9:
        r3 = 0.0f;
        goto L10
    L5:
        r2 = 1.0f;
        goto L6
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getSampleText() {
        return this.sampleText;
    }
}
