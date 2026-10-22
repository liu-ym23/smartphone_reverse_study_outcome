package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f3977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.material.resources.f f3978b;
    private float c;
    private boolean d;
    private WeakReference<a> e;
    private com.google.android.material.resources.d f;

    public interface a {
        int[] getState();

        boolean onStateChange(int[] r1);

        void onTextSizeChange();
    }

    public i(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f3977a = new TextPaint(1);
        this.f3978b = new AnonymousClass1(this);
        this.d = true;
        this.e = new WeakReference(null);
        a(r4);
    }

    private float a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return 0.0f;
    L7:
        return this.f3977a.measureText(r4, 0, r4.length());
    }

    static /* synthetic */ WeakReference a(i r0) {
        return r0.e;
    }

    static /* synthetic */ boolean a(i r0, boolean r1) {
        r0.d = r1;
        return r1;
    }

    public float a(String r2) {
        if (this.d == false) goto L5;
        float r3 = a(r2);
        this.c = r3;
        this.d = false;
        return r3;
    L5:
        return this.c;
    }

    public TextPaint a() {
        return this.f3977a;
    }

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f.b(r4, this.f3977a, this.f3978b);
    }

    public void a(a r3) {
        this.e = new WeakReference((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"));
    }

    public void a(com.google.android.material.resources.d r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (this.f == r4) goto L14;
        this.f = r4;
        if (r4 == null) goto L10;
        r4.c(r6, this.f3977a, this.f3978b);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.e.get(), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        TextPaint r2 = this.f3977a;
        r2.drawableState = r0.getState();
    L9:
        r4.b(r6, this.f3977a, this.f3978b);
        this.d = true;
    L10:
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.e.get(), a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        r3.onTextSizeChange();
        r3.onStateChange(r3.getState());
        return;
    L15:
        return;
    }

    public void a(boolean r1) {
        this.d = r1;
    }

    public com.google.android.material.resources.d b() {
        return this.f;
    }
}
