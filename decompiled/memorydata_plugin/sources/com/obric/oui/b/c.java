package com.obric.oui.b;

import com.obric.oui.color.e;
import com.obric.oui.color.f;
import com.obric.oui.color.g;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0000J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\rJ\r\u0010\u000e\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/res/StrokeStateList;", "", "core", "Lcom/obric/oui/res/StrokeStateListCore;", "(Lcom/obric/oui/res/StrokeStateListCore;)V", "deepCopy", "getConfigForState", "Lcom/obric/oui/color/StrokeConfig;", "stateSet", "", "defaultStroke", "getDefaultStroke", "isStateful", "", "toCore", "toCore$OUI_standardRelease", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f13322b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007JP\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0007J+\u0010\u000e\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0007¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0007J\u001e\u0010\u001a\u001a\u00020\u00042\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0007J!\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0016*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0002¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/obric/oui/res/StrokeStateList$Companion;", "", "()V", "fromCore", "Lcom/obric/oui/res/StrokeStateList;", "core", "Lcom/obric/oui/res/StrokeStateListCore;", "fromCore$OUI_standardRelease", "getConfigForTransition", "Lcom/obric/oui/color/StrokeConfig;", "fromConfig", "toConfig", "progress", "", "of", "normal", "activated", "checked", "pressed", "hovered", "disabled", "states", "", "", "strokes", "([[I[Lcom/obric/oui/color/StrokeConfig;)Lcom/obric/oui/res/StrokeStateList;", "valueOf", "stroke", "Lkotlin/Pair;", "", "toCoreArray", "Lcom/obric/oui/color/StrokeConfigCore;", "([Lcom/obric/oui/color/StrokeConfig;)[Lcom/obric/oui/color/StrokeConfigCore;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ c a(a r4, e r5, e r6, e r7, e r8, e r9, e r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = null;
        L6:
            if ((r11 & 2) == 0) goto L8;
            e r13 = r5;
        L10:
            if ((r11 & 4) == 0) goto L12;
            e r0 = r13;
        L14:
            if ((r11 & 8) == 0) goto L16;
            e r1 = r5;
        L18:
            if ((r11 & 16) == 0) goto L20;
            e r2 = r5;
        L22:
            if ((r11 & 32) == 0) goto L24;
            e r3 = r5;
        L26:
            return r4.a(r5, r13, r0, r1, r2, r3);
        L24:
            r3 = r10;
            goto L26
        L20:
            r2 = r9;
            goto L22
        L16:
            r1 = r8;
            goto L18
        L12:
            r0 = r7;
            goto L14
        L8:
            r13 = r6;
            goto L10
        }

        public final c a(d r2) {
            Intrinsics.checkNotNullParameter(r2, "core");
            return new c(r2, null);
        }

        @JvmStatic
        public final c a(e r3) {
            DefaultConstructorMarker r0 = null;
            if (r3 != null) goto L5;
            f r4 = null;
        L6:
            d r5 = d.a(r4);
            Intrinsics.checkNotNullExpressionValue(r5, "valueOf(stroke?.toCore())");
            return new c(r5, r0);
        L5:
            r4 = r3.d();
            goto L6
        }

        @JvmStatic
        public final c a(e r8, e r9, e r10, e r11, e r12, e r13) {
            DefaultConstructorMarker r0 = null;
            if (r8 != null) goto L5;
            f r1 = null;
        L6:
            if (r9 != null) goto L8;
            f r2 = null;
        L9:
            if (r10 != null) goto L11;
            f r3 = null;
        L12:
            if (r11 != null) goto L14;
            f r4 = null;
        L15:
            if (r12 != null) goto L17;
            f r5 = null;
        L18:
            if (r13 != null) goto L20;
            f r6 = null;
        L21:
            d r14 = d.a(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r14, "of(\n                    …Core(),\n                )");
            return new c(r14, r0);
        L20:
            r6 = r13.d();
            goto L21
        L17:
            r5 = r12.d();
            goto L18
        L14:
            r4 = r11.d();
            goto L15
        L11:
            r3 = r10.d();
            goto L12
        L8:
            r2 = r9.d();
            goto L9
        L5:
            r1 = r8.d();
            goto L6
        }

        @JvmStatic
        public final e a(e r1, e r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "fromConfig");
            Intrinsics.checkNotNullParameter(r2, "toConfig");
            f r0 = d.a(r1.d(), r2.d(), r3);
            if (r0 != null) goto L6;
            return null;
        L6:
            return g.a(r0);
        }
    }

    static {
        f13321a = new a(null);
    }

    private c(d r1) {
        this.f13322b = r1;
    }

    public /* synthetic */ c(d r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ e a(c r0, int[] r1, e r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.a();
    L6:
        return r0.a(r1, r2);
    }

    public final e a() {
        f r0 = this.f13322b.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        return g.a(r0);
    }

    public final e a(int[] r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "stateSet");
        d r1 = this.f13322b;
        if (r3 != null) goto L5;
        f r4 = null;
    L6:
        f r5 = r1.a(r2, r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        return g.a(r5);
    L5:
        r4 = r3.d();
        goto L6
    }

    public final d b() {
        return this.f13322b;
    }
}
