package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.image.BorderPropertyFactory;
import com.ss.android.lark.coremd.facade.bizext.image.IMShowImageScene;
import com.ss.android.lark.coremd.facade.bizext.theme.IMAtThemeData;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.coremd.facade.bizext.theme.IMMediaThemeData;
import com.ss.android.lark.coremd.facade.link.IMKeyIconStrategy;
import com.ss.android.lark.coremd.facade.link.IMRichUrlIconStrategy;
import com.ss.android.lark.coremd.facade.link.IMUniversalCardIconStrategy;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkEmojiThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.BorderProperty;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/IMThemeExtend;", "it", "Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TextLayoutRenderConfigs$obtainParseTheme$1 extends Lambda implements Function2<IMThemeExtend, com.ss.android.lark.coremd.base.parse.j, Unit> {
    final /* synthetic */ boolean $applyStyleFromMe;
    final /* synthetic */ m2b.a $chatContext;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs$obtainParseTheme$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.ss.android.lark.coremd.base.parse.i, BorderProperty> {
        public AnonymousClass1(Object r8) {
            super(1, r8, BorderPropertyFactory.class, "imageThread", "imageThread(Lcom/ss/android/lark/coremd/base/parse/MarkdownParsingContext;)Lcom/ss/android/lark/widget/span/BorderProperty;", 0);
        }

        public final BorderProperty invoke(com.ss.android.lark.coremd.base.parse.i r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            ((BorderPropertyFactory) ((CallableReference) this).receiver).getClass();
            return BorderPropertyFactory.a(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((com.ss.android.lark.coremd.base.parse.i) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs$obtainParseTheme$1$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.ss.android.lark.coremd.base.parse.i, BorderProperty> {
        public AnonymousClass2(Object r8) {
            super(1, r8, BorderPropertyFactory.class, "roundBorder", "roundBorder(Lcom/ss/android/lark/coremd/base/parse/MarkdownParsingContext;)Lcom/ss/android/lark/widget/span/BorderProperty;", 0);
        }

        public final BorderProperty invoke(com.ss.android.lark.coremd.base.parse.i r4) {
            Intrinsics.checkNotNullParameter(r4, "p0");
            ((BorderPropertyFactory) ((CallableReference) this).receiver).getClass();
            Intrinsics.checkNotNullParameter(r4, "context");
            return new BorderProperty(UIUtils.getColor(r4.getContext(), 2131103351), UIHelper.dp2px(1.0f), UIHelper.dp2px(4.0f));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((com.ss.android.lark.coremd.base.parse.i) r1);
        }
    }

    public TextLayoutRenderConfigs$obtainParseTheme$1(m2b.a r1, boolean r2) {
        this.$chatContext = r1;
        this.$applyStyleFromMe = r2;
        super(2);
    }

    public final void invoke(IMThemeExtend r10, com.ss.android.lark.coremd.base.parse.j r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$chatMessageTheme");
        Intrinsics.checkNotNullParameter(r11, "it");
        com.ss.android.lark.biz.im.api.message.params.a r0 = this.$chatContext.d0(com.ss.android.lark.biz.im.api.message.params.a.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.a;
    L6:
        IMAtThemeData r2 = r10.m(r11);
        if (r1 == false) goto L10;
    L12:
        boolean r3 = false;
    L13:
        r2.l.setValue(r2, IMAtThemeData.s[0], Boolean.valueOf(r3));
        r10.d(r11).i(!this.$chatContext.e0());
        if (this.$chatContext.m() == false) goto L16;
    L19:
        IMImageThemeData r4 = r10.n(r11);
        BorderPropertyFactory r5 = BorderPropertyFactory.a;
        AnonymousClass1 r6 = new AnonymousClass1(r5);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        com.ss.android.lark.coremd.ext.c r7 = r4.q;
        KProperty<Object>[] r8 = IMImageThemeData.r;
        r7.setValue(r4, r8[4], r6);
        IMMediaThemeData r9 = r10.o(r11);
        AnonymousClass2 r12 = new AnonymousClass2(r5);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r9.k.setValue(r9, IMMediaThemeData.m[0], r12);
        IMImageThemeData r13 = r10.n(r11);
        IMShowImageScene r14 = IMShowImageScene.IMAGE_MODE_POST_DETAIL;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.o.setValue(r13, r8[2], r14);
    L20:
        float r15 = zz7.b.d().getMultiplier();
        IMAtThemeData r16 = r10.m(r11);
        r16.k(((Number) r16.i.getValue(r16, LarkAtThemeData.k[5])).floatValue() * r15);
        LarkEmojiThemeData r17 = r10.g(r11);
        r17.h(((Number) r17.e.getValue(r17, LarkEmojiThemeData.g[1])).floatValue() * r15);
        LarkLinkThemeData r18 = r10.i(r11);
        r18.n(r18.l() * r15);
        r10.l(r11).h();
        com.ss.android.lark.biz.im.api.message.params.i r19 = this.$chatContext.d0(com.ss.android.lark.biz.im.api.message.params.i.class);
        if (r19 == null) goto L31;
        boolean r20 = this.$applyStyleFromMe;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        BlockQuoteThemeData r21 = r10.c.b(r11);
        com.ss.android.lark.biz.im.api.message.params.o r22 = r19.a;
        if (r20 == false) goto L25;
        int r23 = r22.a;
    L26:
        int r24 = Integer.valueOf(r23).intValue();
        com.ss.android.lark.coremd.ext.c r25 = r21.i;
        KProperty<Object>[] r26 = BlockQuoteThemeData.j;
        r25.setValue(r21, r26[5], Integer.valueOf(r24));
        Intrinsics.checkNotNullParameter(r11, "<this>");
        BlockQuoteThemeData r27 = r10.c.b(r11);
        com.ss.android.lark.biz.im.api.message.params.o r28 = r19.b;
        if (r20 == false) goto L29;
        int r29 = r28.a;
    L30:
        r27.g.setValue(r27, r26[3], Integer.valueOf(Integer.valueOf(r29).intValue()));
        goto L31
    L29:
        r29 = r28.b;
        goto L30
    L25:
        r23 = r22.b;
    L31:
        com.ss.android.lark.coremdbiz.facade.link.parser.b r110 = r10.i(r11).k();
        r110.a();
        r110.c(IMKeyIconStrategy.b);
        r110.c(IMRichUrlIconStrategy.b);
        r110.c(IMUniversalCardIconStrategy.b);
        return;
    L16:
        if (this.$chatContext.Y() == true) goto L19;
        if (this.$chatContext.q() == false) goto L20;
    L10:
        if (this.$chatContext.h() == true) goto L12;
        r3 = true;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((IMThemeExtend) r1, (com.ss.android.lark.coremd.base.parse.j) r2);
        return Unit.INSTANCE;
    }
}
