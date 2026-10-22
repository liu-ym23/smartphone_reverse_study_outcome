package b4b;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ i7b.a b;

    public e(b r1, i7b.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.c;     // Catch: Throwable -> L9
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");     // Catch: Throwable -> L9
        r0 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a.class);     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.t3(ScrollScene.RELOCATE_MESSAGE, this.b.b, true, true, null, null);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
