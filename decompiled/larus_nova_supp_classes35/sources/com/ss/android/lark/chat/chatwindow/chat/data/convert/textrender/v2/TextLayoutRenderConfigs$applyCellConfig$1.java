package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkPhoneThemeData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import g3b.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/IMThemeExtend;", "it", "Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TextLayoutRenderConfigs$applyCellConfig$1 extends Lambda implements Function2<IMThemeExtend, com.ss.android.lark.coremd.base.parse.j, Unit> {
    final /* synthetic */ u $contentParam;
    final /* synthetic */ v4b.d $messageCellConfig;

    public TextLayoutRenderConfigs$applyCellConfig$1(u r1, v4b.d r2) {
        this.$contentParam = r1;
        this.$messageCellConfig = r2;
        super(2);
    }

    public final void invoke(IMThemeExtend r9, com.ss.android.lark.coremd.base.parse.j r10) {
        Intrinsics.checkNotNullParameter(r9, "$this$with");
        Intrinsics.checkNotNullParameter(r10, "it");
        IMAtThemeData r0 = r9.m(r10);
        u r1 = this.$contentParam;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        com.ss.android.lark.coremd.ext.c r4 = r0.d;
        KProperty<Object>[] r5 = LarkAtThemeData.k;
        r4.setValue(r0, r5[0], Boolean.valueOf(!r3));
        u r6 = this.$contentParam;
        if (r6 == null) goto L13;
        z9b.c r7 = r6.a.c;
        if (r7 == null) goto L13;
        IMAtThemeData r8 = r9.m(r10);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r8.j.setValue(r8, r5[6], r7);
    L13:
        u r11 = this.$contentParam;
        if (r11 == null) goto L18;
        z9b.a r12 = r11.e.a;
        if (r12 == null) goto L18;
        LarkLinkThemeData r13 = r9.i(r10);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r13.m.setValue(r13, LarkLinkThemeData.n[6], r12);
    L18:
        u r14 = this.$contentParam;
        if (r14 == null) goto L23;
        z9b.b r15 = r14.f.a;
        if (r15 == null) goto L23;
        LarkPhoneThemeData r16 = r9.k(r10);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r16.f.setValue(r16, LarkPhoneThemeData.g[2], r15);
    L23:
        v4b.d r17 = this.$messageCellConfig;
        if (r17 != null) goto L26;
    L28:
        r9.d(r10).i((!r2) & r9.d(r10).h());
        boolean r18 = r9.p(r10) & true;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r9.r.setValue(r10, IMThemeExtend.t[3], Boolean.valueOf(r18));
        return;
    L26:
        if (r17.j != true) goto L28;
        r2 = true;
        goto L28
    L5:
        if (r1.a.a == true) goto L7;
        r3 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((IMThemeExtend) r1, (com.ss.android.lark.coremd.base.parse.j) r2);
        return Unit.INSTANCE;
    }
}
