package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.a4;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements a4 {
    public final /* synthetic */ vr1.a a;

    public m(com.bytedance.android.livesdk.vscore_impl.behavior.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a4
    public final void a(Disposable r2) {
        this.a.a(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a4
    public final void b(SkinLoadResultType r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r1, "result");
    }
}
