package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(RichText r3) {
        Intrinsics.checkNotNullParameter(r3, "richText");
        List r0 = r3.getMarkdownIds();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L18;
        List r4 = r3.getAnchorIds();
        if (r4 == null) goto L13;
        int r5 = r4.size();
    L15:
        if (r5 < 100) goto L19;
        return true;
    L19:
        return false;
    L13:
        r5 = 0;
        goto L15
    L18:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static n a(RichText r23, n r24) {
        Intrinsics.checkNotNullParameter(r23, "richText");
        Intrinsics.checkNotNullParameter(r24, "config");
        if (p.a() == true) goto L5;
        return r24;
    L5:
        if (b(r23) == false) goto L10;
        com.ss.android.lark.coremd.base.parse.b r8 = r24.f.clone();
        com.ss.android.lark.widget.light.layout.h r1 = r24.h;
        Context r10 = r1.a;
        int r11 = r1.b;
        boolean r12 = r1.c;
        boolean r13 = r1.d;
        com.ss.android.lark.widget.light.viewstub.f r14 = r1.e;
        int r15 = r1.f;
        float r2 = r1.g;
        int r3 = r1.h;
        Layout.Alignment r4 = r1.i;
        float r5 = r1.j;
        float r6 = r1.k;
        boolean r7 = r1.l;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "spanViewCoordinator");
        Intrinsics.checkNotNullParameter(r4, "textAlignment");
        com.ss.android.lark.widget.light.layout.h r9 = new com.ss.android.lark.widget.light.layout.h(r10, r11, r12, r13, r14, r15, r2, r3, r4, r5, r6, r7, false);
        Context r16 = r24.a;
        String r17 = r24.b;
        com.ss.android.lark.richtextmd.parse.ext.b r18 = r24.c;
        List<? extends com.ss.android.lark.coremd.base.parse.g> r19 = r24.d;
        j r20 = r24.e;
        List<? extends com.ss.android.lark.coremd.base.parse.f> r21 = r24.g;
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "uniqueId");
        Intrinsics.checkNotNullParameter(r18, "richTextParseConfig");
        Intrinsics.checkNotNullParameter(r19, "markdownPlugins");
        Intrinsics.checkNotNullParameter(r20, "markdownTheme");
        Intrinsics.checkNotNullParameter(r8, "markdownContext");
        Intrinsics.checkNotNullParameter(r21, "parseListeners");
        Intrinsics.checkNotNullParameter(r9, "textLayoutBuildConfig");
        return new n(r16, r17, r18, r19, r20, r8, r21, r9);
    L10:
        return r24;
    }
}
