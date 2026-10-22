package com.obric.oui.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0000J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\r\u0010\u0011\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/res/BlendConfigStateList;", "", "core", "Lcom/obric/oui/res/BlendConfigStateListCore;", "(Lcom/obric/oui/res/BlendConfigStateListCore;)V", "deepCopy", "getConfigForState", "", "Lcom/obric/oui/color/BlendConfig;", "stateSet", "", "defaultConfig", "([I[Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfig;", "getDefaultBlendConfig", "()[Lcom/obric/oui/color/BlendConfig;", "isStateful", "", "toCore", "toCore$OUI_standardRelease", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0729a f13317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f13318b;

    /* JADX INFO: renamed from: com.obric.oui.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J7\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJm\u0010\u0010\u001a\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u0017J/\u0010\u0010\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\tH\u0007¢\u0006\u0002\u0010\u001bJD\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\nH\u0007JU\u0010\u001d\u001a\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\"Jm\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\nH\u0007J\u001b\u0010$\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010&J)\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\t0\t*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\tH\u0002¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"Lcom/obric/oui/res/BlendConfigStateList$Companion;", "", "()V", "fromCore", "Lcom/obric/oui/res/BlendConfigStateList;", "core", "Lcom/obric/oui/res/BlendConfigStateListCore;", "fromCore$OUI_standardRelease", "getConfigForTransition", "", "Lcom/obric/oui/color/BlendConfig;", "fromConfigs", "toConfigs", "progress", "", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;F)[Lcom/obric/oui/color/BlendConfig;", "of", "normal", "activated", "checked", "pressed", "hovered", "disabled", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "states", "", "configs", "([[I[[Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "ofSimple", "ofWithOverlay", "pressedOverlay", "hoveredOverlay", "activatedOverlay", "checkedOverlay", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "ofWithOverlayArray", "valueOf", "config", "([Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "toCore2DArray", "Lcom/obric/oui/color/BlendConfigCore;", "([[Lcom/obric/oui/color/BlendConfig;)[[Lcom/obric/oui/color/BlendConfigCore;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0729a {
        private C0729a() {
        }

        public /* synthetic */ C0729a(DefaultConstructorMarker r1) {
            this();
        }

        private final com.obric.oui.color.b[][] a(com.obric.oui.color.a[][] r7) {
            Object[] r6 = (Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.memorydata.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.memorydata.plugin");
            int r1 = r6.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r8.add(com.obric.oui.color.c.a((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r6[r3], com.obric.oui.color.a[].class, "com.obric.memorydata.plugin")));
            r3 = r3 + 1;
            goto L3
        L5:
            Object[] r9 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new com.obric.oui.color.b[0][]);
            Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (com.obric.oui.color.b[][]) ZeusTransformUtils.preCheckCast(r9, com.obric.oui.color.b[][].class, "com.obric.memorydata.plugin");
        }

        public final a a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "core");
            return new a(r2, null);
        }

        @JvmStatic
        public final a a(com.obric.oui.color.a[] r2) {
            Intrinsics.checkNotNullParameter(r2, "configs");
            b r3 = b.a(com.obric.oui.color.c.a(r2));
            Intrinsics.checkNotNullExpressionValue(r3, "valueOf(configs.toCoreArray())");
            return new a(r3, null);
        }

        @JvmStatic
        public final a a(int[][] r2, com.obric.oui.color.a[][] r3) {
            Intrinsics.checkNotNullParameter(r2, "states");
            Intrinsics.checkNotNullParameter(r3, "configs");
            b r1 = b.a(r2, a(r3));
            Intrinsics.checkNotNullExpressionValue(r1, "of(states, configs.toCore2DArray())");
            return new a(r1, null);
        }

        @JvmStatic
        public final com.obric.oui.color.a[] a(com.obric.oui.color.a[] r1, com.obric.oui.color.a[] r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "fromConfigs");
            Intrinsics.checkNotNullParameter(r2, "toConfigs");
            com.obric.oui.color.b[] r0 = b.a(com.obric.oui.color.c.a(r1), com.obric.oui.color.c.a(r2), r3);
            Intrinsics.checkNotNullExpressionValue(r0, "getConfigForTransition(\n…   progress\n            )");
            return com.obric.oui.color.c.a(r0);
        }
    }

    static {
        f13317a = new C0729a(null);
    }

    private a(b r1) {
        this.f13318b = r1;
    }

    public /* synthetic */ a(b r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ com.obric.oui.color.a[] a(a r0, int[] r1, com.obric.oui.color.a[] r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.a();
    L6:
        return r0.a(r1, r2);
    }

    public final com.obric.oui.color.a[] a() {
        com.obric.oui.color.b[] r1 = this.f13318b.a();
        Intrinsics.checkNotNullExpressionValue(r1, "core.defaultBlendConfig");
        return com.obric.oui.color.c.a(r1);
    }

    public final com.obric.oui.color.a[] a(int[] r2, com.obric.oui.color.a[] r3) {
        Intrinsics.checkNotNullParameter(r2, "stateSet");
        Intrinsics.checkNotNullParameter(r3, "defaultConfig");
        com.obric.oui.color.b[] r1 = this.f13318b.a(r2, com.obric.oui.color.c.a(r3));
        Intrinsics.checkNotNullExpressionValue(r1, "core.getConfigForState(s…aultConfig.toCoreArray())");
        return com.obric.oui.color.c.a(r1);
    }

    public final b b() {
        return this.f13318b;
    }
}
