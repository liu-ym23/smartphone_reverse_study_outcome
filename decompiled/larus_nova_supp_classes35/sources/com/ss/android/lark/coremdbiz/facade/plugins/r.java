package com.ss.android.lark.coremdbiz.facade.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.ImageThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import com.ss.android.lark.widget.light.image.LKUILightTextImageLoader;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class r implements com.ss.android.lark.coremd.base.parse.g {
    public r() {
    }

    public static com.ss.android.lark.widget.span.v e(final com.ss.android.lark.coremd.impl.parse.i r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        LarkImageThemeData r0 = (LarkImageThemeData) LarkThemeExtend.m.b(new LarkImagePlugin$prepareImageSpan$imageThemeData$1(r9));
        LarkImageExtend.a r1 = LarkImageExtend.g;
        int r2 = ((Number) r1.b(new LarkImagePlugin$prepareImageSpan$nodeWidth$1(r9))).intValue();
        int r3 = ((Number) r1.b(new LarkImagePlugin$prepareImageSpan$nodeHeight$1(r9))).intValue();
        String r4 = (String) r1.b(new LarkImagePlugin$prepareImageSpan$fsUnit$1(r9));
        ByteString r5 = (ByteString) r1.b(new LarkImagePlugin$prepareImageSpan$crypto$1(r9));
        int r6 = ((Number) LarkContextExtend.s.b(new LarkImagePlugin$prepareImageSpan$draftResourceSource$1(r9))).intValue();
        com.ss.android.lark.coremd.base.parse.a.b r7 = ((com.ss.android.lark.coremd.base.parse.a) r0.e.getValue(r0, ImageThemeData.f[1])).a(r9, r2, r3);
        com.ss.android.lark.widget.span.v.c r8 = new com.ss.android.lark.widget.span.v.c();
        Map r10 = LKUILightTextImageLoader.a;
        com.ss.android.lark.widget.span.v.a r11 = LKUILightTextImageLoader.b();
        if (r11 == null) goto L5;
        r8.j = r11;
    L5:
        r8.a = r7.a;
        r8.b = r7.b;
        r8.o = r4;
        r8.n = r5;
        r8.p = r6;
        com.ss.android.lark.coremd.ext.c r12 = r0.k;
        KProperty<Object>[] r13 = LarkImageThemeData.l;
        ((Number) r12.getValue(r0, r13[4])).intValue();
        com.ss.android.lark.widget.span.v r14 = r8.a(r9.getContext(), ((v7b.l) r9.d).j);
        ((com.ss.android.lark.widget.span.n) r14).a = UIUtils.dp2px(r9.getContext(), r0.i());
        ((com.ss.android.lark.widget.span.n) r14).c = UIUtils.dp2px(r9.getContext(), r0.j());
        ((com.ss.android.lark.widget.span.n) r14).d = UIUtils.dp2px(r9.getContext(), r0.h());
        ((com.ss.android.lark.widget.span.n) r14).b = UIUtils.dp2px(r9.getContext(), ((Number) r0.i.getValue(r0, r13[2])).floatValue());
        r14.u = new q(r9, r14);
        Intrinsics.checkNotNull(r14);
        return r14;
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.l.class, new p());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.l.class, new o(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }
}
