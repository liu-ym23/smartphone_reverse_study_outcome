package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements b.a {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ String b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a
    public final String getName() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a
    public final boolean a(Room r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        return ((Boolean) this.a.invoke(r2)).booleanValue();
    }

    public c(Function1 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
