package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s2 implements com.bytedance.android.livesdk.chatroom.utils.a3.b {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ Function0 b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
        this.b.invoke();
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r3) {
        Intrinsics.checkNotNullParameter(r3, "ninePatchDrawable");
        this.a.invoke(r3, Boolean.FALSE);
    }

    public s2(Function2 r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
