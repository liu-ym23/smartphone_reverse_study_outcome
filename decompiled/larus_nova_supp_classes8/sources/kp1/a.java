package kp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final ElementType a;
    public final jp1.b b;

    public final ElementType getType() {
        return this.a;
    }

    public a(ElementType r2, jp1.b r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "session");
        this.a = r2;
        this.b = r3;
    }
}
