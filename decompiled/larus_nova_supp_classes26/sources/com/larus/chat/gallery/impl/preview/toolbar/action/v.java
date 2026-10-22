package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v implements o {
    public final com.larus.chat.gallery.api.q a;

    public static final class a {
    }

    static {
    }

    public v(com.larus.chat.gallery.api.q r2) {
        Intrinsics.checkNotNullParameter(r2, "mediaSession");
        this.a = r2;
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r3, Continuation<? super Unit> r4) {
        final com.larus.chat.gallery.api.a0 r5 = this.a.Pa(r3.a.b, !this.a.Oa(r3.a.b));
        if (r5.a == false) goto L5;
        PreviewToolbarView r6 = r3.f;
        if (r6 == null) goto L10;
        r6.b(ToolbarButtonType.SELECT, new u(r5));
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
