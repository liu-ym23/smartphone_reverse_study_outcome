package com.obric.oui.texteffects.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u001fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005¨\u0006 "}, d2 = {"Lcom/obric/oui/texteffects/runtime/SampledLayerFrame;", "", "alpha", "", "getAlpha", "()F", "bindingKey", "", "getBindingKey", "()Ljava/lang/String;", "blurRadius", "Lcom/obric/oui/texteffects/core/EffectValue;", "getBlurRadius", "()Lcom/obric/oui/texteffects/core/EffectValue;", "layerId", "getLayerId", "stageId", "getStageId", "stagePlayTimeMs", "", "getStagePlayTimeMs", "()J", "translationX", "getTranslationX", "translationY", "getTranslationY", "visibility", "getVisibility", "alphaOr", "defaultValue", "visibilityOrNull", "()Ljava/lang/Float;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface g {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static float a(g r2, float r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            if (Float.isNaN(r4.e()) == false) goto L6;
            return r3;
        L6:
            return r4.e();
        }

        public static Float a(g r2) {
            g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            if (Float.isNaN(r3.f()) == false) goto L6;
            return null;
        L6:
            return Float.valueOf(r3.f());
        }
    }

    float a(float r1);

    String a();

    String b();

    long d();

    float e();

    float f();

    com.obric.oui.texteffects.core.m g();

    com.obric.oui.texteffects.core.m h();

    com.obric.oui.texteffects.core.m i();

    Float j();
}
