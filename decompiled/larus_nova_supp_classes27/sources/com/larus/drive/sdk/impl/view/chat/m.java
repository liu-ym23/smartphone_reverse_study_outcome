package com.larus.drive.sdk.impl.view.chat;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements DriveFloatChatContainer.c {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final va8.r a() {
        return (va8.r) this.e.getValue();
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final g0 b() {
        return (g0) this.a.getValue();
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final com.larus.bmhome.chat.component.bottom.core.speaker.l c() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.d.getValue();
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final r79.a d() {
        return (r79.a) this.g.getValue();
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final r79.b e() {
        return (r79.b) this.f.getValue();
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.b.getValue();
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.c
    public final ICoreInputAbility v0() {
        return (ICoreInputAbility) this.c.getValue();
    }

    public m(final DriveFloatChatContainer r2) {
        this.a = LazyKt.lazy(new f(r2));
        this.b = LazyKt.lazy(new g(r2));
        this.c = LazyKt.lazy(new h(r2));
        this.d = LazyKt.lazy(new i(r2));
        this.e = LazyKt.lazy(new j(r2));
        this.f = LazyKt.lazy(new k(r2));
        this.g = LazyKt.lazy(new l(r2));
    }
}
