package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f5136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f5137b;
    private boolean c;

    public k(Fragment r3) {
        this.f5136a = r3;
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L7;
        this.f5137b = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    private void b() {
        Fragment r0 = this.f5136a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == true) goto L7;
        return;
    L7:
        if (r0.getUserVisibleHint() == true) goto L9;
        return;
    L9:
        if (this.f5137b.immersionBarEnabled() == false) goto L15;
        this.f5137b.a();
        return;
    }

    public void a() {
        Fragment r0 = this.f5136a;
        if (r0 != null) goto L5;
    L9:
        this.f5136a = null;
        this.f5137b = null;
        return;
    L5:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L9;
        if (this.f5137b.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.f5136a).destroy();
        goto L9
    }

    public void a(Configuration r1) {
        b();
    }

    public void a(Bundle r1) {
        this.c = true;
        b();
    }

    public void a(boolean r1) {
        b();
    }

    public void b(boolean r1) {
        Fragment r0 = this.f5136a;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(!r1);
        return;
    }
}
