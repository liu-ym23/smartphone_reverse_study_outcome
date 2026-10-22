package com.obric.oui.texteffects.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003Jk\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006."}, d2 = {"Lcom/obric/oui/texteffects/runtime/LayerFrame;", "Lcom/obric/oui/texteffects/runtime/SampledLayerFrame;", "stageId", "", "layerId", "bindingKey", "stagePlayTimeMs", "", "alpha", "", "visibility", "blurRadius", "Lcom/obric/oui/texteffects/core/EffectValue;", "translationX", "translationY", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JFFLcom/obric/oui/texteffects/core/EffectValue;Lcom/obric/oui/texteffects/core/EffectValue;Lcom/obric/oui/texteffects/core/EffectValue;)V", "getAlpha", "()F", "getBindingKey", "()Ljava/lang/String;", "getBlurRadius", "()Lcom/obric/oui/texteffects/core/EffectValue;", "getLayerId", "getStageId", "getStagePlayTimeMs", "()J", "getTranslationX", "getTranslationY", "getVisibility", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14692b;
    private final String c;
    private final long d;
    private final float e;
    private final float f;
    private final com.obric.oui.texteffects.core.m g;
    private final com.obric.oui.texteffects.core.m h;
    private final com.obric.oui.texteffects.core.m i;

    public d(String r2, String r3, String r4, long r5, float r7, float r8, com.obric.oui.texteffects.core.m r9, com.obric.oui.texteffects.core.m r10, com.obric.oui.texteffects.core.m r11) {
        Intrinsics.checkNotNullParameter(r2, "stageId");
        Intrinsics.checkNotNullParameter(r3, "layerId");
        this.f14691a = r2;
        this.f14692b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public float a(float r3) {
        return g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public String a() {
        return this.f14691a;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public String b() {
        return this.f14692b;
    }

    public String c() {
        return this.c;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public long d() {
        return this.d;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public float e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(a(), r10.a()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(b(), r10.b()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(c(), r10.c()) == true) goto L18;
        return false;
    L18:
        if (d() == r10.d()) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(e()), Float.valueOf(r10.e())) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(Float.valueOf(f()), Float.valueOf(r10.f())) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(g(), r10.g()) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(h(), r10.h()) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(i(), r10.i()) == true) goto L35;
        return false;
    L35:
        return true;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public float f() {
        return this.f;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public com.obric.oui.texteffects.core.m g() {
        return this.g;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public com.obric.oui.texteffects.core.m h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((a().hashCode() * 31) + b().hashCode()) * 31;
        int r2 = 0;
        if (c() != null) goto L5;
        int r1 = 0;
    L6:
        int r3 = (((((((r0 + r1) * 31) + Long.hashCode(d())) * 31) + Float.hashCode(e())) * 31) + Float.hashCode(f())) * 31;
        if (g() != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r3 + r4) * 31;
        if (h() != null) goto L13;
        int r6 = 0;
    L14:
        int r7 = (r5 + r6) * 31;
        if (i() == null) goto L19;
        r2 = i().hashCode();
    L19:
        return r7 + r2;
    L13:
        r6 = h().hashCode();
        goto L14
    L9:
        r4 = g().hashCode();
        goto L10
    L5:
        r1 = c().hashCode();
        goto L6
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public com.obric.oui.texteffects.core.m i() {
        return this.i;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public Float j() {
        return g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return "LayerFrame(stageId=" + a() + ", layerId=" + b() + ", bindingKey=" + c() + ", stagePlayTimeMs=" + d() + ", alpha=" + e() + ", visibility=" + f() + ", blurRadius=" + g() + ", translationX=" + h() + ", translationY=" + i() + ')';
    }
}
