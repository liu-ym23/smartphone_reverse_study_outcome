package com.obric.oui.texteffects.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JV\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010$\u001a\u0004\u0018\u00010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006,"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ReusableLayerFrame;", "Lcom/obric/oui/texteffects/runtime/SampledLayerFrame;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "bindingKey", "", "getBindingKey", "()Ljava/lang/String;", "setBindingKey", "(Ljava/lang/String;)V", "blurRadius", "Lcom/obric/oui/texteffects/core/EffectValue;", "getBlurRadius", "()Lcom/obric/oui/texteffects/core/EffectValue;", "setBlurRadius", "(Lcom/obric/oui/texteffects/core/EffectValue;)V", "layerId", "getLayerId", "setLayerId", "stageId", "getStageId", "setStageId", "stagePlayTimeMs", "", "getStagePlayTimeMs", "()J", "setStagePlayTimeMs", "(J)V", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "visibility", "getVisibility", "setVisibility", "copyFrom", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14694b;
    private String c;
    private long d;
    private float e;
    private float f;
    private com.obric.oui.texteffects.core.m g;
    private com.obric.oui.texteffects.core.m h;
    private com.obric.oui.texteffects.core.m i;

    public e() {
        this.f14693a = "";
        this.f14694b = "";
        this.e = Float.NaN;
        this.f = Float.NaN;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public float a(float r3) {
        return g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public String a() {
        return this.f14693a;
    }

    public void a(long r1) {
        this.d = r1;
    }

    public void a(com.obric.oui.texteffects.core.m r1) {
        this.g = r1;
    }

    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14693a = r2;
    }

    public final void a(String r2, String r3, String r4, long r5, float r7, float r8, com.obric.oui.texteffects.core.m r9, com.obric.oui.texteffects.core.m r10, com.obric.oui.texteffects.core.m r11) {
        Intrinsics.checkNotNullParameter(r2, "stageId");
        Intrinsics.checkNotNullParameter(r3, "layerId");
        a(r2);
        b(r3);
        c(r4);
        a(r5);
        b(r7);
        c(r8);
        a(r9);
        b(r10);
        c(r11);
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public String b() {
        return this.f14694b;
    }

    public void b(float r1) {
        this.e = r1;
    }

    public void b(com.obric.oui.texteffects.core.m r1) {
        this.h = r1;
    }

    public void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14694b = r2;
    }

    public void c(float r1) {
        this.f = r1;
    }

    public void c(com.obric.oui.texteffects.core.m r1) {
        this.i = r1;
    }

    public void c(String r1) {
        this.c = r1;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public long d() {
        return this.d;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public float e() {
        return this.e;
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

    @Override // com.obric.oui.texteffects.runtime.g
    public com.obric.oui.texteffects.core.m i() {
        return this.i;
    }

    @Override // com.obric.oui.texteffects.runtime.g
    public Float j() {
        return g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"));
    }
}
