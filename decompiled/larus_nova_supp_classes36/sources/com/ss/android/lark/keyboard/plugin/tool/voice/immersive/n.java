package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import android.graphics.Paint;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements Runnable {
    public final /* synthetic */ AsrInputVoiceView a;
    public final /* synthetic */ Context b;

    public n(AsrInputVoiceView r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        int r0 = com.ss.android.lark.c.a(this.a.e) + UIUtils.dp2px(this.a.d, 30.0f);
        CircularProgressDrawable r1 = new CircularProgressDrawable(this.b);
        r1.setStyle(1);
        r1.setColorSchemeColors(new int[]{UDColorUtils.getColor(this.b, 2131106521)});
        r1.setStrokeCap(Paint.Cap.ROUND);
        AsrInputVoiceView r2 = this.a;
        UDToast.a r3 = UDToast.build(r2.d);
        r3.g(AsrInputVoiceView.b6(this.a));
        r3.b.c(80, 0, r0);
        r3.b.d = 2147483647L;
        r3.e(r1);
        r2.v = r3.a();
        com.larksuite.component.universe_design.toast.c r4 = this.a.v;
        if (r4 == null) goto L5;
        r4.show();
    L5:
        Log.i("AsrInputVoiceView", "show loading toast offset:" + r0);
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
