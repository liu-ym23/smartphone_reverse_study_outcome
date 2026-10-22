package com.obric.oui.texteffects.render;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import com.obric.oui.texteffects.core.p;
import com.obric.oui.texteffects.core.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002>?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J(\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\"\u0010(\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0010H\u0002J0\u0010*\u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%J\"\u00100\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0018\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0003J \u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000bj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u00060\u0014R\u00020\u00000\u000bj\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u00060\u0014R\u00020\u0000`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u000bj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001b0\u000bj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001b`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/texteffects/render/TextEffectShaderRepository;", "", "maxBlurRadiusPx", "", "blurGranularityPx", "logTag", "", "(FFLjava/lang/String;)V", "blurFilterCache", "Lcom/obric/oui/texteffects/render/BlurMaskFilterCache;", "composeShaderCaches", "Ljava/util/HashMap;", "Lcom/obric/oui/texteffects/core/FillSpec$GradientGroup;", "Lcom/obric/oui/texteffects/render/TextEffectShaderRepository$GradientGroupComposeShaderCache;", "Lkotlin/collections/HashMap;", "fillLinearGradientCaches", "Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "Landroid/graphics/LinearGradient;", "gradientLayerShaderCaches", "Lcom/obric/oui/texteffects/core/GradientLayerSpec;", "Lcom/obric/oui/texteffects/render/TextEffectShaderRepository$GradientLayerShaderCache;", "reusableMatrix", "Landroid/graphics/Matrix;", "reusableRect", "Landroid/graphics/RectF;", "shapeGradientCaches", "Lcom/obric/oui/texteffects/core/FillSpec$ShapeMappedLinearGradient;", "Lcom/obric/oui/texteffects/render/ShapeMappedGradientCache;", "shapeMaskCaches", "Lcom/obric/oui/texteffects/core/MaskSpec$ShapeMappedLinearGradient;", "buildFillShader", "Landroid/graphics/Shader;", "fill", "Lcom/obric/oui/texteffects/core/FillSpec;", "cache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "stagePlayTimeMs", "", "textColor", "", "buildGradientGroup", "buildLinearGradient", "buildMaskShader", "mask", "Lcom/obric/oui/texteffects/core/MaskSpec;", "left", "right", "textWidthPx", "buildShapeMappedGradient", "clear", "", "clearAll", "createNormalizedLinearGradient", "colors", "", "positions", "", "getBlurMaskFilter", "Landroid/graphics/BlurMaskFilter;", "radiusPx", "updateLocalMatrix", "shader", "GradientGroupComposeShaderCache", "GradientLayerShaderCache", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14675b;
    private final com.obric.oui.texteffects.render.b c;
    private final HashMap<com.obric.oui.texteffects.core.n.c, g> d;
    private final HashMap<s.a, g> e;
    private final HashMap<com.obric.oui.texteffects.core.n.b, LinearGradient> f;
    private final HashMap<p, b> g;
    private final HashMap<com.obric.oui.texteffects.core.n.a, a> h;
    private final Matrix i;
    private final RectF j;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/texteffects/render/TextEffectShaderRepository$GradientGroupComposeShaderCache;", "", "layerCount", "", "followsTextColor", "", "logTag", "", "(IZLjava/lang/String;)V", "getFollowsTextColor", "()Z", "layerShaders", "", "Landroid/graphics/Shader;", "getLayerShaders", "()[Landroid/graphics/Shader;", "[Landroid/graphics/Shader;", "shader", "textColor", "resolve", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f14676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14677b;
        private final Shader[] c;
        private int d;
        private Shader e;

        public a(int r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "logTag");
            this.f14676a = r3;
            this.f14677b = r4;
            this.c = new Shader[r2];
            this.d = Integer.MIN_VALUE;
        }

        public final Shader a(int r8) {
            Shader r0 = this.e;
            if (r0 != null) goto L5;
        L7:
            Shader r1 = null;
            Shader[] r2 = this.c;
            int r3 = 0;
            int r4 = r2.length;
        L8:
            if (r3 >= r4) goto L15;
            Shader r5 = r2[r3];
            r3 = r3 + 1;
            if (r5 == null) goto L8;
            if (r1 == null) goto L13;
            r1 = (Shader) ZeusTransformUtils.preCheckCast(new ComposeShader(r1, r5, PorterDuff.Mode.SRC_OVER), Shader.class, "com.obric.memorydata.plugin");
            goto L8
        L13:
            r1 = r5;
            goto L8
        L15:
            this.d = r8;
            this.e = r1;
            if (r1 == null) goto L20;
            com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
            String r7 = this.f14677b;
            if (com.obric.oui.texteffects.a.a() == false) goto L20;
            Log.d(Intrinsics.stringPlus("OTextEff/", r7), "create ComposeShader group layers=" + b().length + " textColor=" + r8);
        L20:
            return r1;
        L5:
            if (this.d != r8) goto L7;
            return r0;
        }

        public final boolean a() {
            return this.f14676a;
        }

        public final Shader[] b() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/render/TextEffectShaderRepository$GradientLayerShaderCache;", "", "(Lcom/obric/oui/texteffects/render/TextEffectShaderRepository;)V", "resolvedColors", "", "shader", "Landroid/graphics/LinearGradient;", "textColor", "", "resolve", "layer", "Lcom/obric/oui/texteffects/core/GradientLayerSpec;", "left", "", "right", "resolveColors", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f14678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14679b;
        private int[] c;
        private LinearGradient d;

        public b(k r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.f14678a = r2;
            this.f14679b = Integer.MIN_VALUE;
        }

        private final int[] a(p r7, int r8) {
            if (r7.c() == false) goto L5;
            int[] r0 = this.c;
            int r1 = 0;
            if (r0 != null) goto L10;
        L8:
            r0 = null;
        L14:
            if (r0 != null) goto L18;
            r0 = new int[r7.a().length];
            k r2 = this.f14678a;
            this.c = r0;
            com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
            String r9 = k.a(r2);
            if (com.obric.oui.texteffects.a.a() == false) goto L18;
            Log.d(Intrinsics.stringPlus("OTextEff/", r9), "create resolved GradientLayer colors layer=@" + System.identityHashCode(r7) + " size=" + r7.a().length);
        L18:
            int r10 = Color.red(r8);
            int r3 = Color.green(r8);
            int r11 = Color.blue(r8);
            int r4 = r7.a().length;
        L19:
            if (r1 >= r4) goto L21;
            r0[r1] = Color.argb(Color.alpha(r7.a()[r1]), r10, r3, r11);
            r1 = r1 + 1;
            goto L19
        L21:
            return r0;
        L10:
            if (r0.length != r7.a().length) goto L12;
            boolean r5 = true;
        L13:
            if (r5 == false) goto L8;
        L12:
            r5 = false;
            goto L13
        L5:
            return r7.a();
        }

        public final LinearGradient a(p r5, int r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r5, "layer");
            if (r5.c() == false) goto L5;
            int r0 = r6;
        L6:
            LinearGradient r1 = this.d;
            if (r1 != null) goto L10;
        L8:
            r1 = null;
        L14:
            if (r1 != null) goto L16;
            r1 = k.a(this.f14678a, a(r5, r6), r5.b());
            this.f14679b = r0;
            this.d = r1;
        L16:
            k.a(this.f14678a, r1, r7, r8);
            return r1;
        L10:
            if (this.f14679b != r0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L8;
        L12:
            r3 = false;
            goto L13
        L5:
            r0 = Integer.MIN_VALUE;
            goto L6
        }
    }

    public k(float r2, float r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "logTag");
        this.f14674a = r2;
        this.f14675b = r4;
        this.c = new com.obric.oui.texteffects.render.b(r2, r3);
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new Matrix();
        this.j = new RectF();
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L6;
        Log.d(Intrinsics.stringPlus("OTextEff/", r4), "create TextEffectShaderRepository maxBlurRadiusPx=" + r2 + " blurGranularityPx=" + r3);
        return;
    }

    public static final /* synthetic */ LinearGradient a(k r0, int[] r1, float[] r2) {
        return r0.a(r1, r2);
    }

    private final LinearGradient a(m r5, com.obric.oui.texteffects.core.n.b r6) {
        if (r5.k() > 0.01f) goto L6;
        return null;
    L6:
        LinearGradient r0 = (LinearGradient) ZeusTransformUtils.preCheckCast(this.f.get(r6), LinearGradient.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        r0 = a(r6.a(), r6.b());
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.memorydata.plugin")).put(r6, r0);
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f14578a;
        String r2 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L11;
        Log.d(Intrinsics.stringPlus("OTextEff/", r2), "create fill LinearGradient colors=" + r6.a().length + " positions=" + r6.b().length);
    L11:
        Intrinsics.checkNotNullExpressionValue(r0, "fillLinearGradientCaches…\"\n            }\n        }");
        a(r0, r5.l(), r5.l() + r5.k());
        return r0;
    }

    private final LinearGradient a(m r21, com.obric.oui.texteffects.core.n.c r22, long r23) {
        if (r21.k() > 0.01f) goto L6;
        return null;
    L6:
        g r2 = (g) ZeusTransformUtils.preCheckCast(this.d.get(r22), g.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        int r3 = r22.g();
        h.a r5 = h.a(r22.a(), r22.b());
        Intrinsics.checkNotNullExpressionValue(r5, "createColorRampMapper(\n ….positions,\n            )");
        r2 = new g(r3, r5);
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r22, r2);
        com.obric.oui.texteffects.a r4 = com.obric.oui.texteffects.a.f14578a;
        String r6 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L11;
        Log.d(Intrinsics.stringPlus("OTextEff/", r6), "create shape fill cache fill=@" + System.identityHashCode(r22) + " stopCount=" + r22.g());
    L11:
        g r7 = r2;
        this.j.set(r21.l(), 0.0f, r21.l() + r21.k(), 0.0f);
        return g.a(r7, this.j, r22.c(), r22.d(), r23, r22.e(), r22.f(), r21.k(), 0.0f, 0.0f, 384, null);
    }

    private final LinearGradient a(int[] r10, float[] r11) {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        String r9 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L6;
        Log.d(Intrinsics.stringPlus("OTextEff/", r9), "create normalized LinearGradient colors=" + r10.length + " positions=" + r11.length);
    L6:
        return new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, r10, r11, Shader.TileMode.CLAMP);
    }

    private final Shader a(m r17, com.obric.oui.texteffects.core.n.a r18, int r19) {
        if (r17.k() > 0.01f) goto L5;
        return null;
    L5:
        if (r18.a().isEmpty() == true) goto L51;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.memorydata.plugin");
        Object r3 = r2.get(r18);
        if (r3 != null) goto L24;
        com.obric.oui.texteffects.a r4 = com.obric.oui.texteffects.a.f14578a;
        String r5 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L12;
        Log.d(Intrinsics.stringPlus("OTextEff/", r5), "create GradientGroupComposeShaderCache fill=@" + System.identityHashCode(r18) + " layers=" + r18.a().size());
    L12:
        int r6 = r18.a().size();
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r18.a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L15;
    L17:
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L16;
        if (((p) ZeusTransformUtils.preCheckCast(r9.next(), p.class, "com.obric.memorydata.plugin")).c() == false) goto L19;
        boolean r10 = true;
    L23:
        a r11 = new a(r6, r10, this.f14675b);
        r2.put(r18, r11);
        r3 = r11;
    L16:
        r10 = false;
        goto L23
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
    L24:
        a r7 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        if (r7.a() == false) goto L27;
        int r12 = r19;
    L28:
        int r13 = r18.a().size();
        int r14 = 0;
    L29:
        if (r14 >= r13) goto L37;
        int r15 = r14 + 1;
        p r16 = (p) ZeusTransformUtils.preCheckCast(r18.a().get(r14), p.class, "com.obric.memorydata.plugin");
        float r110 = r17.k() * r16.d();
        b r111 = (b) ZeusTransformUtils.preCheckCast(this.g.get(r16), b.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L35;
        r111 = new b(this);
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).put(r16, r111);
        com.obric.oui.texteffects.a r112 = com.obric.oui.texteffects.a.f14578a;
        String r113 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L35;
        Log.d(Intrinsics.stringPlus("OTextEff/", r113), "create GradientLayerShaderCache layer=@" + System.identityHashCode(r16) + " followTextColor=" + r16.c());
    L35:
        r7.b()[r14] = (Shader) ZeusTransformUtils.preCheckCast(r111.a(r16, r19, r110, r17.k() + r110), Shader.class, "com.obric.memorydata.plugin");
        r14 = r15;
        goto L29
    L37:
        if (r7.b().length != 1) goto L41;
        return r7.b()[0];
    L41:
        return r7.a(r12);
    L27:
        r12 = Integer.MIN_VALUE;
        goto L28
    L51:
        return null;
    }

    public static final /* synthetic */ String a(k r0) {
        return r0.f14675b;
    }

    private final void a(LinearGradient r3, float r4, float r5) {
        this.i.reset();
        this.i.setScale(RangesKt.coerceAtLeast(r5 - r4, 0.001f), 1.0f);
        this.i.postTranslate(r4, 0.0f);
        r3.setLocalMatrix(this.i);
    }

    public static final /* synthetic */ void a(k r0, LinearGradient r1, float r2, float r3) {
        r0.a(r1, r2, r3);
    }

    public final BlurMaskFilter a(float r1) {
        return this.c.a(r1);
    }

    public final Shader a(com.obric.oui.texteffects.core.n r4, m r5, long r6, int r8) {
        Intrinsics.checkNotNullParameter(r4, "fill");
        Intrinsics.checkNotNullParameter(r5, "cache");
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        String r1 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L8;
        if (com.obric.oui.texteffects.a.b() == false) goto L8;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", r1), "fill build type=" + r4.getClass().getSimpleName() + " stagePlayTimeMs=" + r6 + " textWidth=" + r5.k() + " startX=" + r5.l());
    L8:
        if (Intrinsics.areEqual(r4, com.obric.oui.texteffects.core.n.d.f14626a) == false) goto L11;
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.n.b.class) == false) goto L15;
        LinearGradient r3 = a(r5, (com.obric.oui.texteffects.core.n.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.n.b.class, "com.obric.memorydata.plugin"));
    L24:
        return (Shader) ZeusTransformUtils.preCheckCast(r3, Shader.class, "com.obric.memorydata.plugin");
    L15:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.n.c.class) == false) goto L18;
        r3 = a(r5, (com.obric.oui.texteffects.core.n.c) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.n.c.class, "com.obric.memorydata.plugin"), r6);
        goto L24
    L18:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.n.a.class) == false) goto L22;
        return a(r5, (com.obric.oui.texteffects.core.n.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.n.a.class, "com.obric.memorydata.plugin"), r8);
    L22:
        throw new NoWhenBranchMatchedException();
    }

    public final Shader a(s r19, float r20, float r21, float r22, long r23) {
        Intrinsics.checkNotNullParameter(r19, "mask");
        if (r22 > 0.01f) goto L6;
        return null;
    L6:
        this.j.set(r20, 0.0f, r21, 0.0f);
        if (ZeusTransformUtils.instanceOf(r19, s.a.class) == false) goto L16;
        g r2 = (g) ZeusTransformUtils.preCheckCast(this.e.get(r19), g.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        int r3 = ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).g();
        h.a r4 = h.a(((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).a(), ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).b());
        Intrinsics.checkNotNullExpressionValue(r4, "createColorRampMapper(\n …ns,\n                    )");
        r2 = new g(r3, r4);
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put(r19, r2);
        com.obric.oui.texteffects.a r5 = com.obric.oui.texteffects.a.f14578a;
        String r6 = this.f14675b;
        if (com.obric.oui.texteffects.a.a() == false) goto L14;
        Log.d(Intrinsics.stringPlus("OTextEff/", r6), "shapeMask cache create mask=@" + System.identityHashCode(r19) + " stopCount=" + ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).g());
    L14:
        return (Shader) ZeusTransformUtils.preCheckCast(g.a(r2, this.j, ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).c(), ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).d(), r23, ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).e(), ((s.a) ZeusTransformUtils.preCheckCast(r19, s.a.class, "com.obric.memorydata.plugin")).f(), r22, 0.0f, 0.0f, 384, null), Shader.class, "com.obric.memorydata.plugin");
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void a() {
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
    }

    public final void b() {
        a();
        this.c.a();
    }
}
