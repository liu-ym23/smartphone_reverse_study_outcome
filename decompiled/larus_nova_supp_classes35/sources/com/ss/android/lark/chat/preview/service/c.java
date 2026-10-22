package com.ss.android.lark.chat.preview.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements f.a {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void a() {
        g.e.a.c(Command.PUSH_PREVIEWS);
    }
}
