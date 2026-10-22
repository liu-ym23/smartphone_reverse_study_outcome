package com.obric.oui.orecyclerview.base;

import android.view.MotionEvent;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/orecyclerview/base/VelocityTracker;", "", "addMovement", "", "event", "Landroid/view/MotionEvent;", "clear", "computeCurrentVelocity", "units", "", "maxVelocity", "", "getXVelocity", OaidModel.KEY_ID, "getYVelocity", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface i {
    float a(int r1);

    void a();

    void a(int r1, float r2);

    void a(MotionEvent r1);

    float b(int r1);
}
