package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import android.os.Build;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.chatmessage.ChatMessageContextResolver;
import com.ss.android.lark.coremd.facade.listeners.IMRegexParseListener;
import com.ss.android.lark.coremd.facade.plugins.a0;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageFullScreenRichTextParser2 extends j {
    public static final /* synthetic */ int c = 0;

    public MessageFullScreenRichTextParser2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static float b(int r1) {
        return r1 * zz7.b.d().getMultiplier();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.j
    public final CharSequence a(RichText r12, final q r13) {
        Intrinsics.checkNotNullParameter(r13, "config");
        s r0 = (s) r13;
        if (r12 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        if (r0.b == null) goto L15;
        final MessageFullScreenLaunchData r7 = r0.c;
        final int r3 = j.a.a(getContext(), r0.d);
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        final int r1 = 2;
    L11:
        final Chat r8 = r0.b.c;
        Message r9 = r7.getMessage();
        t9b.c r2 = t9b.c.a;
        Function2<IMContextExtend, com.ss.android.lark.coremd.base.parse.b, Unit> r10 = new MessageFullScreenRichTextParser2$parseData$parseContext$1(r3, this, r8, r13, r7);
        List<Float> r14 = com.ss.android.lark.coremd.facade.b.a;
        Intrinsics.checkNotNullParameter(t9b.c.a, "<this>");
        Intrinsics.checkNotNullParameter(r10, Keys.API_PARAM_KEY_ACTION);
        com.ss.android.lark.coremd.base.parse.b r15 = ChatMessageContextResolver.a(r8, r9);
        com.ss.android.lark.coremd.ext.g.a(r15, IMContextExtend.A, r10);
        t9b.e r4 = t9b.e.a;
        com.ss.android.lark.coremd.base.parse.j r5 = com.ss.android.lark.coremd.facade.b.a(new MessageFullScreenRichTextParser2$parseData$theme$1(r1, this));
        t9b.a r6 = t9b.a.a;
        com.ss.android.lark.richtextmd.parse.impl.b r11 = com.ss.android.lark.richtextmd.parse.ext.a.b(getContext());
        com.ss.android.lark.richtextmd.parse.ext.a.a(r11, MessageFullScreenRichTextParser2$parseData$node$1.INSTANCE);
        v7b.s r16 = r11.b(r12);
        t9b.b r17 = t9b.b.a;
        com.ss.android.lark.coremd.impl.parse.b.a r18 = t9b.b.a(getContext());
        Intrinsics.checkNotNullParameter(t9b.d.a, "<this>");
        r18.e(a0.b);
        r18.e(new i(r0.b, r12, r0.a));
        r18.b(new IMRegexParseListener());
        r18.b(new com.ss.android.lark.coremd.facade.listeners.d(MathKt.roundToInt(b(21)), null));
        r18.c(r5);
        return r18.a(r16, r15);
    L10:
        r1 = 0;
        goto L11
    L15:
        return BuildConfig.FLAVOR;
    }
}
