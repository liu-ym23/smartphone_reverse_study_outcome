package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "", "view", "Landroid/view/View;", "initScale", "", "initAlpha", "flatChildViews", "", "(Landroid/view/View;FFZ)V", "getFlatChildViews", "()Z", "getInitAlpha", "()F", "getInitScale", "getView", "()Landroid/view/View;", "toString", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f7842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7843b;
    private final float c;
    private final boolean d;

    public final float a() {
        return this.f7843b;
    }

    public final float b() {
        return this.c;
    }

    public String toString() {
        return "QSAnimConfig(view: " + this.f7842a.getClass().getSimpleName() + ", initScale: " + this.f7843b + ", initAlpha: " + this.c + ", flatChildViews: " + this.d + ')';
    }
}
