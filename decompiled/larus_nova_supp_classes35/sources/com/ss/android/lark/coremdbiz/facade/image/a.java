package com.ss.android.lark.coremdbiz.facade.image;

import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.coremd.base.parse.a {
    public static final a b = null;

    static {
        b = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.a
    public final com.ss.android.lark.coremd.base.parse.a.b a(final i r3, final int r4, final int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r6 = ((Number) LarkContextExtend.s.b(new LarkImageSizeProvider$provideSizeForLoadImage$maxMarkdownWidth$1(r3))).intValue();
        final Ref.FloatRef r0 = new Ref.FloatRef();
        r0.element = 1.0f;
        if (r6 <= 0) goto L9;
        if (r6 == Integer.MAX_VALUE) goto L9;
        if (r6 >= r4) goto L9;
        r0.element = r6 / r5;
    L9:
        return (com.ss.android.lark.coremd.base.parse.a.b) LarkImageExtend.g.b(new LarkImageSizeProvider$provideSizeForLoadImage$1(r4, r0, r5));
    }
}
