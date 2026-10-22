package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements Runnable {
    public final /* synthetic */ AudienceLandTopToolbarMoreDialog a;

    public g(AudienceLandTopToolbarMoreDialog r1) {
        this.a = r1;
    }

    public final void a() {
        CustomShaderRectView r0 = this.a.R;
        if (r0 == null) goto L9;
        float r4 = 2;
        LinearGradient r9 = new LinearGradient(0.0f, this.a.findViewById(2131369197).getMeasuredHeight() / r4, this.a.findViewById(2131369197).getMeasuredWidth(), this.a.findViewById(2131369197).getMeasuredHeight() / r4, new int[]{16777215, 872415231, 872415231}, new float[]{0.0f, 0.15f, 1.0f}, Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullParameter(r9, "shader");
        Paint r1 = r0.a;
        if (r1 == null) goto L7;
        r1.setShader(r9);
    L7:
        r0.invalidate();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
