package com.obric.common.oea.style.scene.qsanim.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004J\n\u0010\u0015\u001a\u00020\u0016*\u00020\f¨\u0006\u0017"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/ViewUtils;", "", "()V", "clamp", "", BaseSwitches.V, "min", "max", "getRelativeLocation", "Lkotlin/Pair;", "", "view", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "rubberBand", "dis", TypedValues.Custom.S_DIMENSION, "constant", "rubberBandIfOutOfBounds", "position", "idExt", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7832a = null;

    static {
        f7832a = new d();
    }

    private d() {
    }

    public final Pair<Integer, Integer> a(View r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        int r3 = 0;
        View r0 = r4;
        int r6 = 0;
    L3:
        if (r0 == null) goto L13;
        if ((!Intrinsics.areEqual(r0, r5)) == false) goto L13;
        r3 = r3 + r0.getLeft();
        r6 = r6 + r0.getTop();
        b r1 = b.f7828a;
        ViewParent r2 = r0.getParent();
        if (r2 != null) goto L10;
    L8:
        r2 = null;
    L11:
        r0 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
        goto L3
    L10:
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L8;
    L13:
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r6));
    }
}
