package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f5132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f5133b;
    private boolean c;
    private boolean d;
    private boolean e;

    public f(Fragment r3) {
        this.f5132a = r3;
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        this.f5133b = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void a() {
        Fragment r0 = this.f5132a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUserVisibleHint() == false) goto L9;
        this.f5133b.onVisible();
        return;
    }

    public void a(Configuration r1) {
        Fragment r2 = this.f5132a;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.f5133b.immersionBarEnabled() == false) goto L9;
        this.f5133b.a();
    L9:
        this.f5133b.onVisible();
    }

    public void a(Bundle r1) {
        Fragment r2 = this.f5132a;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.e == true) goto L12;
        this.f5133b.onLazyBeforeView();
        this.e = true;
        return;
    }

    public void a(boolean r2) {
        Fragment r3 = this.f5132a;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getUserVisibleHint() == false) goto L21;
        if (this.e == true) goto L10;
        this.f5133b.onLazyBeforeView();
        this.e = true;
    L10:
        if (this.c == true) goto L12;
        return;
    L12:
        if (this.f5132a.getUserVisibleHint() == true) goto L14;
        return;
    L14:
        if (this.f5133b.immersionBarEnabled() == false) goto L17;
        this.f5133b.a();
    L17:
        if (this.d == true) goto L19;
        this.f5133b.onLazyAfterView();
        this.d = true;
    L19:
        this.f5133b.onVisible();
        return;
    L21:
        if (this.c == false) goto L28;
        this.f5133b.onInvisible();
        return;
    }

    public void b() {
        if (this.f5132a == null) goto L6;
        this.f5133b.onInvisible();
        return;
    }

    public void b(Bundle r2) {
        this.c = true;
        Fragment r0 = this.f5132a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.f5133b.immersionBarEnabled() == false) goto L10;
        this.f5133b.a();
    L10:
        if (this.d == true) goto L15;
        this.f5133b.onLazyAfterView();
        this.d = true;
        return;
    }

    public void b(boolean r1) {
        Fragment r0 = this.f5132a;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(!r1);
        return;
    }

    public void c() {
        Fragment r0 = this.f5132a;
        if (r0 != null) goto L5;
    L9:
        this.f5132a = null;
        this.f5133b = null;
        return;
    L5:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L9;
        if (this.f5133b.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.f5132a).destroy();
        goto L9
    }
}
