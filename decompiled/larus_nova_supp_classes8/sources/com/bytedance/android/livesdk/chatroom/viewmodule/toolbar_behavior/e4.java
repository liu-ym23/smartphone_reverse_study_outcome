package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e4<T> implements Consumer {
    public final /* synthetic */ c4 a;
    public final /* synthetic */ ko0.e b;

    public e4(c4 r1, ko0.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ALogger.i(this.a.a, "small card anim end after timeout, stop anim");
        HSImageView r4 = this.a.e;
        if (r4 == null) goto L9;
        DraweeController r5 = r4.getController();
        if (r5 == null) goto L9;
        Animatable r6 = r5.getAnimatable();
        if (r6 == null) goto L9;
        r6.stop();
    L9:
        HSImageView r7 = this.a.e;
        if (r7 == null) goto L12;
        r7.setVisibility(8);
    L12:
        Function0 r8 = this.b.d;
        if (r8 == null) goto L16;
        Unit r9 = (Unit) r8.invoke();
        return;
    }
}
