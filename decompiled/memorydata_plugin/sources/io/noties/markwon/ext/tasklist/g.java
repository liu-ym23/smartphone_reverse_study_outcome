package io.noties.markwon.ext.tasklist;

import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.i;
import io.noties.markwon.t;
import io.noties.markwon.w;

/* JADX INFO: loaded from: classes6.dex */
public class g implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f16540a;

    public g(Drawable r1) {
        this.f16540a = r1;
    }

    @Override // io.noties.markwon.w
    public Object a(i r5, t r6) {
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.memorydata.plugin");
        return new f(r5.a(), this.f16540a, ((Boolean) ZeusTransformUtils.preCheckCast(e.f16537a.a(r7, false), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    }
}
