package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import com.ss.android.lark.widget.span.VideoImageSpan;
import com.ss.android.lark.widget.span.b;
import eab.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/span/VideoImageSpan;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMMediaExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorMediaPlugin$configureSpanFactory$1$videoSpan$1 extends Lambda implements Function1<IMMediaExtend, VideoImageSpan> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $draftResourceSource;
    final /* synthetic */ f $node;
    final /* synthetic */ o<f> $this_on;

    public IMEditorMediaPlugin$configureSpanFactory$1$videoSpan$1(f r1, int r2, Context r3, o<f> r4) {
        this.$node = r1;
        this.$draftResourceSource = r2;
        this.$context = r3;
        this.$this_on = r4;
        super(1);
    }

    public final VideoImageSpan invoke(IMMediaExtend r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$IMMediaExtend");
        if (r10.d(this.$node).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L9;
        String r3 = r10.d(this.$node);
        f r2 = this.$node;
        b.b.b r1 = new b.b.b(r3, r2.l, r2.m, r10.b(r2), r10.a(this.$node), this.$draftResourceSource);
    L10:
        String r11 = e.g(this.$node.n);
        Context r4 = this.$context;
        Intrinsics.checkNotNull(r11);
        final o<f> r5 = this.$this_on;
        VideoImageSpan r6 = new VideoImageSpan(r4, r11, r1, new IMEditorMediaPlugin$configureSpanFactory$1$videoSpan$1$span$1(r5));
        LarkThemeExtend.a r12 = LarkThemeExtend.m;
        final o<f> r7 = this.$this_on;
        LarkMediaThemeData r13 = (LarkMediaThemeData) r12.b(new IMEditorMediaPlugin$configureSpanFactory$1$videoSpan$1$mediaThemeData$1(r7));
        Context r8 = this.$context;
        c r9 = r13.e;
        KProperty<Object>[] r14 = LarkMediaThemeData.j;
        ((b) r6).m = UIUtils.dp2px(r8, ((Number) r9.getValue(r13, r14[1])).floatValue());
        ((b) r6).n = UIUtils.dp2px(this.$context, ((Number) r13.g.getValue(r13, r14[3])).floatValue());
        return r6;
    L9:
        f r15 = this.$node;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        String r16 = (String) r10.g.getValue(r15, IMMediaExtend.r[4]);
        f r17 = this.$node;
        r1 = new b.b.a(r16, r17.l, r17.m);
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMMediaExtend) r1);
    }
}
