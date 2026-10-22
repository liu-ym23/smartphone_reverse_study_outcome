package com.ss.android.lark.coremdbiz.facade.plugins;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.facade.plugins.a1;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v7b.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkLinkPlugin extends a1 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public LarkLinkPlugin() {
    }

    @Override // com.ss.android.lark.coremd.facade.plugins.a1, com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.n.class, new s(this));
    }

    public final Spannable g(final com.ss.android.lark.coremd.base.parse.r<v7b.n> r9, final v7b.n r10) {
        SpannableStringBuilder r6 = new SpannableStringBuilder();
        String r0 = r10.k;
        com.ss.android.lark.coremdbiz.facade.link.parser.b r1 = ((LarkLinkThemeData) LarkThemeExtend.m.b(new LarkLinkPlugin$prepareLinkSpannable$1$themeData$1(r9))).k();
        LarkLinkExtend.a r2 = LarkLinkExtend.f;
        dab.a r3 = (dab.a) r2.b(new LarkLinkPlugin$prepareLinkSpannable$1$iconInfo$1(r10));
        LinkType r4 = (LinkType) r2.b(new LarkLinkPlugin$prepareLinkSpannable$1$linkType$1(r9));
        if (r3 == null) goto L5;
        CharSequence r5 = r1.b(r9, r3);
    L6:
        if (r5 == null) goto L9;
        int r7 = r6.length();
        r6.append(r5);
        r9.a().c(r6, r7, r6.length());
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.richtext.link.inline_render", false) == true) goto L11;
        r6.append(r0);
    L29:
        if (r5 == null) goto L31;
        r6.append(" ");
    L31:
        Object r8 = r9.f().a(r9, r10);
        if (r8 == null) goto L34;
        r9.a().a(r6, r8, 0, r6.length(), 33);
    L34:
        r9.a().b(r6, r10, 0, r6.length(), 0);
        com.ss.android.lark.coremd.base.parse.w.a.a(r9.a(), r6, r10, 0, r6.length());
        return r6;
    L11:
        if (r0 != null) goto L13;
    L16:
        boolean r11 = true;
    L17:
        if (r11 == false) goto L20;
        r0 = r10.j;
    L20:
        if (r10.e == null) goto L28;
        int r12 = r6.length();
        v7b.s r13 = r10.e;
    L22:
        if (r13 == null) goto L25;
        e(r13, r6, r9);
        r13 = r13.h;
        goto L22
    L25:
        if (r6.length() != r12) goto L27;
        r6.append(r0);
    L27:
        Unit r14 = Unit.INSTANCE;
        goto L29
    L28:
        r6.append(r0);
        goto L29
    L13:
        if (r0.length() == 0) goto L16;
        r11 = false;
        goto L17
    L5:
        r5 = null;
        goto L6
    }

    public final void e(v7b.s r11, SpannableStringBuilder r12, com.ss.android.lark.coremd.base.parse.r<v7b.n> r13) {
        if ((r11 instanceof v7b.b0) == false) goto L6;
        r12.append(((v7b.b0) r11).j);
        return;
    L6:
        if ((r11 instanceof v7b.a0) == false) goto L9;
        f(this, r11, r12, r13, true, false, false, false, 112);
        return;
    L9:
        if ((r11 instanceof v7b.f) == false) goto L12;
        f(this, r11, r12, r13, false, true, false, false, 104);
        return;
    L12:
        if ((r11 instanceof e0) == false) goto L15;
        f(this, r11, r12, r13, false, false, true, false, 88);
        return;
    L15:
        if ((r11 instanceof v7b.z) == false) goto L17;
        f(this, r11, r12, r13, false, false, false, true, 56);
        return;
    L17:
        v7b.s r14 = r11.e;
    L18:
        if (r14 == null) goto L26;
        e(r14, r12, r13);
        r14 = r14.h;
        goto L18
    }

    public static void f(LarkLinkPlugin r6, v7b.s r7, SpannableStringBuilder r8, com.ss.android.lark.coremd.base.parse.r r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 8) == 0) goto L6;
        r10 = false;
    L6:
        if ((r14 & 16) == 0) goto L9;
        r11 = false;
    L9:
        if ((r14 & 32) == 0) goto L12;
        r12 = false;
    L12:
        if ((r14 & 64) == 0) goto L14;
        r13 = false;
    L14:
        r6.getClass();
        int r3 = r8.length();
        v7b.s r15 = r7.e;
    L15:
        if (r15 == null) goto L17;
        r6.e(r15, r8, r9);
        r15 = r15.h;
        goto L15
    L17:
        int r4 = r8.length();
        if (com.ss.android.lark.coremd.base.parse.k.b.h(r9.getTheme()) == false) goto L24;
        if (r4 <= r3) goto L25;
        x9b.h r2 = new x9b.h();
        r2.a = r10;
        r2.b = r11;
        r2.c = r12;
        r2.d = r13;
        r9.a().a(r8, r2, r3, r4, 33);
        return;
    L25:
        return;
    }
}
