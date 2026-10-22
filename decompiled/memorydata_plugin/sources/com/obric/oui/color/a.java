package com.obric.oui.color;

import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.graphic.BlendMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u0011\u001a\u00020\u0000J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0000J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/color/BlendConfig;", "", TypedValues.Custom.S_COLOR, "", "mode", "Lcom/obric/oui/graphic/BlendMode;", "(ILcom/obric/oui/graphic/BlendMode;)V", "blendMode", "(II)V", "getBlendMode", "()I", "setBlendMode", "(I)V", "getColor", "setColor", "component1", "component2", "copy", "deepCopy", "equals", "", "other", "hashCode", "toCore", "Lcom/obric/oui/color/BlendConfigCore;", "toCore$OUI_standardRelease", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0733a f13468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13469b = null;
    private int c;
    private int d;

    /* JADX INFO: renamed from: com.obric.oui.color.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J'\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J7\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001eR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/color/BlendConfig$Companion;", "", "()V", "TRANSPARENT", "Lcom/obric/oui/color/BlendConfig;", "alpha", "", "origin", "progress", "", "([Lcom/obric/oui/color/BlendConfig;F)[Lcom/obric/oui/color/BlendConfig;", "deepCopy", "configs", "([Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfig;", "fromArrayRes", "context", "Landroid/content/Context;", "arrayResId", "", "(Landroid/content/Context;I)[Lcom/obric/oui/color/BlendConfig;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;I)[Lcom/obric/oui/color/BlendConfig;", "fromIntArray", "packed", "", "([I)[Lcom/obric/oui/color/BlendConfig;", "lerp", "from", TypedValues.TransitionType.S_TO, "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;F)[Lcom/obric/oui/color/BlendConfig;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0733a {
        private C0733a() {
        }

        public /* synthetic */ C0733a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final a[] a(Resources r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "resources");
            return a(r2.getIntArray(r3));
        }

        @JvmStatic
        public final a[] a(int[] r8) {
            b[] r7 = b.a(r8);
            if (r7 != null) goto L5;
            return null;
        L5:
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.memorydata.plugin");
            int r0 = r7.length;
            int r3 = 0;
        L6:
            if (r3 >= r0) goto L8;
            b r4 = r7[r3];
            r9.add(new a(r4.a(), r4.b()));
            r3 = r3 + 1;
            goto L6
        L8:
            Object[] r10 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new a[0]);
            Objects.requireNonNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (a[]) ZeusTransformUtils.preCheckCast(r10, a[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f13468a = new C0733a(null);
        f13469b = new a(0, BlendMode.SRC_OVER);
    }

    public a(int r1, int r2) {
        this.c = r1;
        this.d = r2;
    }

    public a(int r2, BlendMode r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        this(r2, BlendMode.mapToLegacyObricBlend(r3));
    }

    @JvmStatic
    public static final a[] a(Resources r1, int r2) {
        return f13468a.a(r1, r2);
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final b c() {
        return new b(this.c, this.d);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.c) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("BlendConfig#").append(hashCode()).append("(color=");
        String r1 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.c)}, 1));
        Intrinsics.checkNotNullExpressionValue(r1, "format(this, *args)");
        return r0.append(r1).append(", blendMode=").append(this.d).append(')').toString();
    }
}
