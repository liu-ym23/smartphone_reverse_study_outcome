package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0006\u0010(\u001a\u00020\u0000JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u000200HÖ\u0001J\u0010\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010\u0000J\u000e\u00103\u001a\u00020.2\u0006\u00102\u001a\u000204J\u000e\u00103\u001a\u00020.2\u0006\u00102\u001a\u000205J\u0016\u00103\u001a\u00020.2\u0006\u00102\u001a\u0002052\u0006\u00106\u001a\u00020\u0005J\u0006\u00107\u001a\u00020*R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00069"}, d2 = {"Lcom/obric/oui/common/style/Shadow;", "", TypedValues.Custom.S_COLOR, "", "radius", "", "offsetX", "offsetY", "spread", "paint", "Landroid/graphics/Paint;", "cornerRadius", "(IFFFFLandroid/graphics/Paint;F)V", "getColor", "()I", "setColor", "(I)V", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "getOffsetX", "setOffsetX", "getOffsetY", "setOffsetY", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "getRadius", "setRadius", "getSpread", "setSpread", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "reset", "", "toString", "", BuildConfig.CHANNEL, "config", "updateFromConfig", "Lcom/obric/oui/shadow/ShadowConfig;", "Lcom/obric/oui/shadow/ShadowConfigCore;", "density", "valid", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f13496b = null;
    private int c;
    private float d;
    private float e;
    private float f;
    private float g;
    private Paint h;
    private float i;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\nH\u0007JH\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007J8\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/common/style/Shadow$Companion;", "", "()V", "NONE", "Lcom/obric/oui/common/style/Shadow;", "fromConfig", "config", "Lcom/obric/oui/shadow/ShadowConfig;", "fromConfigWithDensity", "density", "", "Lcom/obric/oui/shadow/ShadowConfigCore;", "getShadowForTransition", "", "currentScale", "startScale", "endScale", "fromShadows", "toShadows", "fraction", "setToFloatArray", "", "shadow", "floatArray", "", "toFloatParams", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final k a(com.obric.oui.shadow.a r11) {
            Intrinsics.checkNotNullParameter(r11, "config");
            k r10 = new k(r11.d(), r11.c(), r11.a(), r11.b(), r11.e(), null, 0.0f, 96, null);
            if (r10.b() <= 0.0f) goto L5;
            Paint r12 = r10.f();
            MaskFilter r0 = (MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r10.b(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin");
        L6:
            r12.setMaskFilter(r0);
            return r10;
        L5:
            r12 = r10.f();
            r0 = null;
            goto L6
        }

        @JvmStatic
        public final k a(com.obric.oui.shadow.a r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "config");
            return a(r2.f(), r3);
        }

        @JvmStatic
        public final k a(com.obric.oui.shadow.b r11, float r12) {
            Intrinsics.checkNotNullParameter(r11, "config");
            k r10 = new k(r11.d(), com.obric.oui.common.util.h.a(r11.c(), r12), com.obric.oui.common.util.h.a(r11.a(), r12), com.obric.oui.common.util.h.a(r11.b(), r12), com.obric.oui.common.util.h.a(r11.e(), r12), null, 0.0f, 96, null);
            if (r10.b() <= 0.0f) goto L5;
            Paint r13 = r10.f();
            MaskFilter r14 = (MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r10.b(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin");
        L6:
            r13.setMaskFilter(r14);
            return r10;
        L5:
            r13 = r10.f();
            r14 = null;
            goto L6
        }

        @JvmStatic
        public final List<k> a(float r3, float r4, float r5, List<k> r6, List<k> r7) {
            List<k> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            List<k> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            if (r5 != r4) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return r8;
        L9:
            return a((r3 - r4) / (r5 - r4), r8, r9);
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final List<k> a(float r18, List<k> r19, List<k> r20) {
            List<k> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
            if (Float.isInfinite(r18) == false) goto L5;
        L7:
            boolean r3 = false;
        L9:
            if (r3 == false) goto L11;
            float r4 = r18;
        L12:
            float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
            if (r0 == null) goto L27;
            if (r2 != null) goto L16;
            return r0;
        L16:
            if (r0.size() != r2.size()) goto L29;
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Iterator r6 = r1.iterator();
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            ArrayList r8 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r1, 10), CollectionsKt.collectionSizeOrDefault((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), 10)));
        L19:
            if (r6.hasNext() == false) goto L24;
            if (r7.hasNext() == false) goto L24;
            Object r9 = r6.next();
            k r10 = (k) ZeusTransformUtils.preCheckCast(r7.next(), k.class, "com.obric.memorydata.plugin");
            k r11 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.memorydata.plugin");
            r8.add(new k(com.obric.oui.c.b.a(r5, r11.a(), r10.a()), com.obric.oui.c.b.b(r11.b(), r10.b(), r5), com.obric.oui.c.b.b(r11.c(), r10.c(), r5), com.obric.oui.c.b.b(r11.d(), r10.d(), r5), com.obric.oui.c.b.b(r11.e(), r10.e(), r5), null, 0.0f, 96, null));
        L24:
            return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        L29:
            return r0;
        L27:
            return r0;
        L11:
            r4 = 0.0f;
            goto L12
        L5:
            if (Float.isNaN(r18) == true) goto L7;
            r3 = true;
            goto L9
        }
    }

    static {
        f13495a = new a(null);
        f13496b = new k(0, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
    }

    public k(int r2, float r3, float r4, float r5, float r6, Paint r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "paint");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }

    public /* synthetic */ k(int r11, float r12, float r13, float r14, float r15, Paint r16, float r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        Paint r8 = new Paint(1);
    L7:
        if ((r18 & 64) == 0) goto L9;
        float r9 = 0.0f;
    L10:
        this(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    @JvmStatic
    public static final k b(com.obric.oui.shadow.a r1) {
        return f13495a.a(r1);
    }

    @JvmStatic
    public static final k b(com.obric.oui.shadow.b r1, float r2) {
        return f13495a.a(r1, r2);
    }

    public final int a() {
        return this.c;
    }

    public final void a(float r1) {
        this.d = r1;
    }

    public final void a(int r1) {
        this.c = r1;
    }

    public final void a(com.obric.oui.shadow.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        a(r2.f());
    }

    public final void a(com.obric.oui.shadow.b r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.c = r3.d();
        this.e = r3.a();
        this.f = r3.b();
        this.g = r3.e();
        if (this.d != r3.c()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        float r4 = r3.c();
        this.d = r4;
        if (r4 <= 0.0f) goto L10;
        this.h.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(this.d, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        this.h.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(com.obric.oui.shadow.b r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.c = r3.d();
        this.e = com.obric.oui.common.util.h.a(r3.a(), r4);
        this.f = com.obric.oui.common.util.h.a(r3.b(), r4);
        this.g = r3.e();
        if (this.d != (r3.c() * r4)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        float r5 = r3.c() * r4;
        this.d = r5;
        if (r5 <= 0.0f) goto L10;
        this.h.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(this.d, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        this.h.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final float b() {
        return this.d;
    }

    public final void b(float r1) {
        this.e = r1;
    }

    public final float c() {
        return this.e;
    }

    public final void c(float r1) {
        this.f = r1;
    }

    public final float d() {
        return this.f;
    }

    public final void d(float r1) {
        this.g = r1;
    }

    public final float e() {
        return this.g;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
        k r4 = (k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin");
        if (this.c == ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).c) goto L16;
        return false;
    L16:
        if (this.d != ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).d) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L22;
        return false;
    L22:
        if (this.e != ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).e) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == true) goto L28;
        return false;
    L28:
        if (this.f != ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).f) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == true) goto L34;
        return false;
    L34:
        if (this.g != ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).g) goto L36;
        boolean r9 = true;
    L37:
        if (r9 == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.h, ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).h) == true) goto L43;
        return false;
    L43:
        if (this.i != ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).i) goto L45;
        boolean r10 = true;
    L46:
        if (r10 == true) goto L48;
        return false;
    L48:
        return true;
    L45:
        r10 = false;
        goto L46
    L36:
        r9 = false;
        goto L37
    L30:
        r8 = false;
        goto L31
    L24:
        r6 = false;
        goto L25
    L18:
        r5 = false;
        goto L19
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public final Paint f() {
        return this.h;
    }

    public final float g() {
        return this.i;
    }

    public final boolean h() {
        if (this.e != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return true;
    L8:
        if (this.f != 0.0f) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        if (this.d != 0.0f) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
        return true;
    L18:
        if (this.g != 0.0f) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        return true;
    L24:
        return false;
    L20:
        r4 = false;
        goto L21
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Float.hashCode(this.i);
    }

    public final void i() {
        this.c = 0;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.i = 0.0f;
        this.h.setMaskFilter(null);
    }

    public final k j() {
        int r1 = this.c;
        float r2 = this.d;
        float r3 = this.e;
        float r4 = this.f;
        float r5 = this.g;
        Paint r6 = new Paint(this.h);
        r6.set(f());
        Unit r0 = Unit.INSTANCE;
        return new k(r1, r2, r3, r4, r5, r6, this.i);
    }

    public String toString() {
        return "Shadow(color=" + this.c + ", radius=" + this.d + ", offsetX=" + this.e + ", offsetY=" + this.f + ", spread=" + this.g + ", paint=" + this.h + ", cornerRadius=" + this.i + ')';
    }

    public final void update(k r3) {
        if (r3 == null) goto L12;
        this.c = r3.c;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        float r0 = this.d;
        float r4 = r3.d;
        if (r0 != r4) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L14;
        this.d = r4;
        if (r4 <= 0.0f) goto L11;
        this.h.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(this.d, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        this.h.setMaskFilter(null);
        return;
    L14:
        return;
    L6:
        r1 = false;
        goto L7
    L12:
        i();
    }
}
