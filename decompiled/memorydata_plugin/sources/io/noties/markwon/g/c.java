package io.noties.markwon.g;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f16545a;

    public c(float r1) {
        this.f16545a = r1;
    }

    public static c a(Context r2) {
        return new c(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    public int a(int r1) {
        return (int) ((r1 * this.f16545a) + 0.5f);
    }
}
