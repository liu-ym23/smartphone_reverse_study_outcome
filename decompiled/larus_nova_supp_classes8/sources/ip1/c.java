package ip1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements lp1.a {
    public boolean a;
    public boolean b;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b c;
    public final ElementType d;
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e e;

    @Override // lp1.a
    public final void d() {
        this.b = true;
    }

    @Override // lp1.a
    public final void f() {
        this.a = false;
    }

    @Override // lp1.a
    public final boolean a() {
        return this.b;
    }

    @Override // lp1.a
    public final boolean b() {
        return this.a;
    }

    @Override // lp1.a
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b c() {
        return this.c;
    }

    @Override // lp1.a
    public final ElementType e() {
        return this.d;
    }

    @Override // lp1.a
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e getButton() {
        return this.e;
    }

    public c(ElementType r2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r3) {
        Intrinsics.checkNotNullParameter(r2, "ofElement");
        Intrinsics.checkNotNullParameter(r3, "button");
        this.d = r2;
        this.e = r3;
    }
}
