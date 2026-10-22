package com.bytedance.android.live.profile.reportdialog;

import android.os.Message;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import q46.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends b<InterfaceC0012a> implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.reportdialog.a$a, reason: collision with other inner class name */
    public interface InterfaceC0012a extends q46.a {
        void N2(IBaseUser r1, boolean r2);

        void i7(Throwable r1);
    }

    public a() {
    }

    public final void handleMsg(Message r3) {
        if (r3.what != 0) goto L18;
        q46.a r0 = ((b) this).a;
        if (r0 != null) goto L8;
        return;
    L8:
        Object r4 = r3.obj;
        if ((r4 instanceof Exception) == false) goto L12;
        ((InterfaceC0012a) r0).i7((Exception) r4);
        return;
    L12:
        if ((r4 instanceof IBaseUser) == false) goto L14;
        ((InterfaceC0012a) r0).N2((IBaseUser) r4, false);
        return;
    L14:
        ((InterfaceC0012a) r0).i7(new Exception("unknown msg.what"));
        return;
    }
}
