package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements IIMCallback<Message> {
    public final /* synthetic */ WeakReference<l> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        l r0 = this.a.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.g == this.b) goto L8;
        return;
    L8:
        r0.h = false;
        r0.i = false;
        g r2 = r0.f;
        if (r2 == null) goto L11;
        r0.m(r2);
    L11:
        kc8.b r1 = jc8.c.a(r0, kc8.b.class);
        if (r1 == null) goto L26;
        kc8.y r3 = r1.a;
        if (r3 == null) goto L27;
        Fragment r4 = r3.a;
        if (r4 != null) goto L19;
        return;
    L19:
        if (l.j(r4) == true) goto L21;
        return;
    L21:
        Context r6 = r4.getContext();
        if (r6 != null) goto L24;
        return;
    L24:
        t19.s.a.g(r6, 2131908080, false);
        FLogger.a.w("FloatingThinkBlockHolder", "loadFullMessage failed, code=" + r5.getCode());
        return;
    L27:
        return;
    }

    public final void onSuccess(Object r5) {
        Message r6 = (Message) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        l r0 = this.a.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.g != this.b) goto L53;
        boolean r1 = false;
        r0.h = false;
        g r2 = r0.f;
        if (r2 == null) goto L12;
        r0.m(r2);
    L12:
        if (Intrinsics.areEqual(r6.getMessageId(), this.c) == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r6.getConversationId(), this.d) == true) goto L16;
        return;
    L16:
        if (com.larus.bmhome.chat.bean.d.i0(r6) == false) goto L21;
        if (com.larus.bmhome.chat.bean.d.w(r6) == true) goto L21;
    L40:
        if (r1 == true) goto L42;
        return;
    L42:
        if (r6.getMessageStatusLocal() == 21) goto L44;
        return;
    L44:
        if (l.l(r6) == true) goto L54;
        r0.i = true;
        r0.o();
        return;
    L54:
        return;
    L21:
        if (com.larus.bmhome.chat.bean.d.T(r6) == true) goto L40;
        if (com.larus.bmhome.chat.bean.d.p0(r6) == true) goto L40;
        if (com.larus.bmhome.chat.bean.d.C0(r6) == true) goto L28;
    L30:
        MessageStatus r3 = r6.getMessageStatus();
        if (r3 != null) goto L33;
    L35:
        boolean r4 = false;
    L36:
        if (r4 == false) goto L38;
    L39:
        r1 = true;
        goto L40
    L38:
        if (b0.f(r6) == false) goto L40;
    L33:
        if (r3.isVisible() != true) goto L35;
        r4 = true;
        goto L36
    L28:
        if (r6.getRegenVisible() == true) goto L30;
    }

    public k(WeakReference<l> r1, int r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
