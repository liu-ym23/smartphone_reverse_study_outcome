package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements g.b {
    public final /* synthetic */ SpecialFocusPush a;

    public c(SpecialFocusPush r1) {
        this.a = r1;
    }

    public final void a(byte[] r3) {
        SpecialFocusPush r0 = this.a;
        Lazy<SpecialFocusPush> r1 = SpecialFocusPush.b;
        r0.getClass();
        PushFocusChatter r4 = (PushFocusChatter) PushFocusChatter.ADAPTER.decode(r3);     // Catch: Exception -> L5
    L7:
        UICallbackExecutor.execute(new b(r0, r4));
        return;
    L5:
        e = move-exception;
        Log.w("SpecialFocusPush", e);
        r4 = null;
        goto L7
    }
}
