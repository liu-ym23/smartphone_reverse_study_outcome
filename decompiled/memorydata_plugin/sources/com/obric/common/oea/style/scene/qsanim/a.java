package com.obric.common.oea.style.scene.qsanim;

import com.obric.common.oea.foundation.animation.c.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/ViewGroupVerticalStretchAnimHelper;", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/BaseViewGroupAnimHelper;", "rootView", "Landroid/view/ViewGroup;", "stretchStartPoint", "", "stretchFactor", "(Landroid/view/ViewGroup;FF)V", "animations", "", "", "Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "initialTranslations", "startY", "tempTranslations", "addAnimView", "", "view", "Landroid/view/View;", "animConfig", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "animateToInitialTranslations", "viewGroup", "captureChildTranslations", "stretchContinue", "y", "stretchEnd", "stretchStart", "updateChildTranslations", "dy", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends com.obric.common.oea.style.scene.qsanim.pulldown.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0382a f7827a = null;
    private final Map<String, Float> c;
    private final Map<String, Float> d;
    private final Map<String, e> e;
    private final float f;
    private final float g;

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.qsanim.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/ViewGroupVerticalStretchAnimHelper$Companion;", "", "()V", "DEFAULT_STRETCH_FACTOR", "", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0382a {
        private C0382a() {
        }

        public /* synthetic */ C0382a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7827a = new C0382a(null);
    }

    public static final /* synthetic */ Map a(a r0) {
        return r0.d;
    }

    public static final /* synthetic */ Map b(a r0) {
        return r0.c;
    }

    public static final /* synthetic */ Map c(a r0) {
        return r0.e;
    }

    public static final /* synthetic */ float d(a r0) {
        return r0.f;
    }

    public static final /* synthetic */ float e(a r0) {
        return r0.g;
    }
}
