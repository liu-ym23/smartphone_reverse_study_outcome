package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements f.a {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void a() {
        g.e.a.c(Command.PUSH_FOCUS_CHATTER);
    }
}
