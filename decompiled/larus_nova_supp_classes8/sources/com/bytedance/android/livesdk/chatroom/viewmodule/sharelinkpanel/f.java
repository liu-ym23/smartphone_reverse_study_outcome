package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends l {
    public final String a;
    public final int b;
    public final String c;
    public final String d;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final boolean a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    public f() {
        this.a = "复制链接";
        this.b = 2131253034;
        this.c = "";
        this.d = "copy";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String b() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final int c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String d() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String e() {
        return this.a;
    }
}
