package io.noties.markwon.c;

import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.k;

/* JADX INFO: loaded from: classes6.dex */
public class b extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MovementMethod f16405a;

    b(MovementMethod r3) {
        this.f16405a = (MovementMethod) ZeusTransformUtils.wrapperContextForParams(r3, MovementMethod.class, "com.obric.memorydata.plugin");
    }

    public static b a(MovementMethod r2) {
        return new b((MovementMethod) ZeusTransformUtils.wrapperContextForParams(r2, MovementMethod.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r3, Spanned r4) {
        Spanned r5 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.memorydata.plugin");
        MovementMethod r6 = r3.getMovementMethod();
        MovementMethod r2 = this.f16405a;
        if (r6 == r2) goto L6;
        r3.setMovementMethod(r2);
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(k.b r2) {
        ((io.noties.markwon.core.a) ZeusTransformUtils.preCheckCast(((k.b) ZeusTransformUtils.wrapperContextForParams(r2, k.b.class, "com.obric.memorydata.plugin")).a(io.noties.markwon.core.a.class), io.noties.markwon.core.a.class, "com.obric.memorydata.plugin")).a(true);
    }
}
