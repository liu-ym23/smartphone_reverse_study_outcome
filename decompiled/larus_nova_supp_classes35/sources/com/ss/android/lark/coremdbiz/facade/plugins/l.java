package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkCodeBlockThemeData;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public l() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (((LarkCodeBlockThemeData) LarkThemeExtend.m.b(new LarkCodePlugin$configureVisitor$1$themeData$1(r5))).h() == false) goto L14;
        Collection r0 = (Collection) LarkCodeBlockExtend.f.b(new LarkCodePlugin$configureVisitor$1$1(r5));
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r5.g.a();
        int r2 = r5.g.length();
        r5.g.d(com.ss.android.lark.widget.codeblock.entity.a.b());
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r2, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r5.g, r2);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r2);
        r5.g.a();
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L14:
        r5.g.d(com.ss.android.lark.widget.codeblock.entity.a.b());
    }
}
