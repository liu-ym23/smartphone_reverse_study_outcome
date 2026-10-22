package com.ss.android.lark.coremd.facade.plugins;

import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMAtThemeData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public final /* synthetic */ o0 a;

    public n0(o0 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r14) {
        Intrinsics.checkNotNullParameter(r14, "it");
        String r0 = "@" + ((eab.a) r14.d).j;
        IMAtThemeData r1 = (IMAtThemeData) IMThemeExtend.s.b(new IMAtPlugin$configureVisitor$1$atThemeData$1(r14));
        boolean r2 = r1.j();
        com.ss.android.lark.coremd.ext.c r3 = r1.m;
        KProperty<Object>[] r4 = IMAtThemeData.s;
        boolean r5 = true;
        boolean r6 = ((Boolean) r3.getValue(r1, r4[1])).booleanValue();
        if (r2 == true) goto L6;
        if (r6 == true) goto L6;
        r14.g.d(r0);
        return;
    L6:
        IMAtNodeExtend.a r7 = IMAtNodeExtend.i;
        boolean r8 = ((Boolean) r7.b(new IMAtPlugin$configureVisitor$1$isAnonymous$1(r14))).booleanValue();
        boolean r9 = ((Boolean) r7.b(new IMAtPlugin$configureVisitor$1$isAtAll$1(r14))).booleanValue();
        SpannableStringBuilder r10 = new SpannableStringBuilder(r0);
        if (r6 == false) goto L11;
        if (r8 == true) goto L11;
        if (r9 == true) goto L11;
        boolean r11 = true;
    L12:
        int r12 = r14.g.length();
        r14.g.d(r10);
        if (r2 == false) goto L36;
        this.a.getClass();
        boolean r13 = ((Boolean) r1.l.getValue(r1, r4[0])).booleanValue();
        IMContextExtend.a r15 = IMContextExtend.A;
        boolean r16 = ((Boolean) r15.b(new IMAtPlugin$shouldShowAtReadDot$iaAtCurrentChatter$1(r14))).booleanValue();
        boolean r17 = ((Boolean) r15.b(new IMAtPlugin$shouldShowAtReadDot$isSendFromMe$1(r14))).booleanValue();
        boolean r18 = ((Boolean) r7.b(new IMAtPlugin$shouldShowAtReadDot$isAtOutChatter$1(r14))).booleanValue();
        if (r13 == false) goto L23;
        if (r17 == false) goto L23;
        if (r18 == true) goto L23;
        if (r9 == true) goto L23;
        if (((List) r15.b(new IMAtPlugin$checkUserIsBot$botIdList$1(r14))).contains(((eab.a) r14.d).k) == true) goto L23;
        if (r16 == true) goto L23;
    L25:
        if (r5 == false) goto L35;
        this.a.getClass();
        if (((List) r15.b(new IMAtPlugin$atHasRead$atReadUserList$1(r14))).contains(((eab.a) r14.d).k) == false) goto L29;
        int r19 = ((Number) r1.q.getValue(r1, r4[5])).intValue();
    L30:
        int r20 = UIUtils.getColor(r14.getContext(), r1.h());
        int r21 = UIUtils.getColor(r14.getContext(), r19);
        if (((List) r15.b(new IMAtPlugin$atHasRead$atReadUserList$1(r14))).contains(((eab.a) r14.d).k) == false) goto L33;
        Paint.Style r22 = Paint.Style.FILL;
    L34:
        int r23 = r14.g.length();
        String r24 = r14.g.c(r12, r23);
        r14.g.setSpan(new ncc.f(r21, r20, r22), com.ss.android.lark.coremd.utils.f.a(r24, r24.codePointCount(0, r24.length()) - 1) + r12, r23, 33);
        goto L35
    L33:
        r22 = Paint.Style.STROKE;
        goto L34
    L29:
        r19 = ((Number) r1.r.getValue(r1, r4[6])).intValue();
    L35:
        com.ss.android.lark.coremd.base.parse.s.a.c(r14.g, r12, 0, 6);
    L23:
        r5 = false;
    L36:
        if (r11 == false) goto L38;
        com.ss.android.lark.coremd.base.parse.s.a.a(r14.g, r12);
    L38:
        com.ss.android.lark.coremd.base.parse.s.a.b(r14.g, r12);
        return;
    L11:
        r11 = false;
        goto L12
    }
}
