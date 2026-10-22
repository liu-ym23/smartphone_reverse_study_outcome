package com.obric.oui.orecyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final m f14222a = null;

    static {
        f14222a = new n();
    }

    n() {
    }

    private static float a(RecyclerView r5, View r6) {
        int r0 = r5.getChildCount();
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        View r3 = r5.getChildAt(r2);
        if (r3 == r6) goto L10;
        float r4 = ViewCompat.getElevation(r3);
        if (r4 <= r1) goto L10;
        r1 = r4;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.m
    public void a(Canvas r1, RecyclerView r2, View r3, float r4, float r5, int r6, boolean r7) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        if (r7 == false) goto L8;
        if (r3.getTag(ZeusTransformUtils.mapRes(R.id.item_touch_helper_previous_elevation, OaidModel.KEY_ID, "item_touch_helper_previous_elevation")) != null) goto L8;
        Float r0 = Float.valueOf(ViewCompat.getElevation(r3));
        ViewCompat.setElevation(r3, a(r2, r3) + 1.0f);
        r3.setTag(ZeusTransformUtils.mapRes(R.id.item_touch_helper_previous_elevation, OaidModel.KEY_ID, "item_touch_helper_previous_elevation"), r0);
    L8:
        r3.setTranslationX(r4);
        r3.setTranslationY(r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.m
    public void a(View r5) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        Object r4 = r5.getTag(ZeusTransformUtils.mapRes(R.id.item_touch_helper_previous_elevation, OaidModel.KEY_ID, "item_touch_helper_previous_elevation"));
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L7;
        ViewCompat.setElevation(r5, ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue());
    L7:
        r5.setTag(ZeusTransformUtils.mapRes(R.id.item_touch_helper_previous_elevation, OaidModel.KEY_ID, "item_touch_helper_previous_elevation"), null);
    L8:
        r5.setTranslationX(0.0f);
        r5.setTranslationY(0.0f);
    }

    @Override // com.obric.oui.orecyclerview.widget.m
    public void b(Canvas r1, RecyclerView r2, View r3, float r4, float r5, int r6, boolean r7) {
    }

    @Override // com.obric.oui.orecyclerview.widget.m
    public void b(View r1) {
    }
}
