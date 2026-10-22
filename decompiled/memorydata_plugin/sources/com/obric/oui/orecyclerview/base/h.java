package com.obric.oui.orecyclerview.base;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/orecyclerview/base/SystemVelocityTrackerAdapter;", "Lcom/obric/oui/orecyclerview/base/VelocityTracker;", "()V", "velocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "addMovement", "", "event", "Landroid/view/MotionEvent;", "clear", "computeCurrentVelocity", "units", "", "maxVelocity", "", "getXVelocity", OaidModel.KEY_ID, "getYVelocity", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VelocityTracker f14047a;

    public h() {
        this.f14047a = VelocityTracker.obtain();
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public float a(int r1) {
        return this.f14047a.getXVelocity(r1);
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public void a() {
        this.f14047a.clear();
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public void a(int r1, float r2) {
        this.f14047a.computeCurrentVelocity(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public void a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.f14047a.addMovement(r2);
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public float b(int r1) {
        return this.f14047a.getYVelocity(r1);
    }
}
