package com.ss.android.lark.flow.notification.online.type.reaction;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class c extends atb.b<FlowReactionNotice, rhb.a> {
    public static String h;
    public FlowReactionNotice b;
    public String c;
    public String d;
    public int e;
    public int f;
    public final Context g;

    @Override // atb.b
    public final void d() {
    }

    @Override // atb.b
    public final void e() {
    }

    @Override // atb.b
    public final void f() {
    }

    @Override // atb.b
    public final void k() {
    }

    @Override // atb.b
    public final Uri l() {
        return null;
    }

    @Override // atb.b
    public final boolean q() {
        return true;
    }

    @Override // atb.b
    public final String c() {
        FlowReactionNotice r0 = this.b;
        int r1 = r0.state;
        if (r1 != 2) goto L5;
    L9:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r0.extra.b != Notice.Extra.ChatType.GROUP) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        return UIHelper.getString(2131892060);
    L16:
        return UIHelper.getString(2131891805);
    L12:
        r2 = false;
        goto L13
    L5:
        if (r1 == 3) goto L9;
        return r0.content;
    }

    @Override // atb.b
    public final int g() {
        return ((int) (CastLongProtector.parseLong(this.b.messageId) % 10001)) * 10001;
    }

    @Override // atb.b
    public final String h() {
        return this.b.messageId;
    }

    @Override // atb.b
    public final int i() {
        int r0 = this.b.state;
        if (r0 != 1) goto L6;
        return 0;
    L6:
        if (r0 != 2) goto L8;
    L11:
        return 1;
    L8:
        if (r0 == 3) goto L11;
        return 0;
    }

    @Override // atb.b
    public final String o() {
        FlowReactionNotice r0 = this.b;
        int r1 = r0.state;
        if (r1 != 2) goto L6;
        return UIHelper.getString(2131891918);
    L6:
        if (r1 == 3) goto L13;
        String r2 = r0.title;
        if (TextUtils.isEmpty(r2) == true) goto L11;
        return r2;
    L11:
        return h;
    L13:
        return UIHelper.getString(2131891925);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final void p() {
        FlowReactionNotice r0 = (FlowReactionNotice) this.a;
        this.b = r0;
        Notice.Extra r1 = r0.extra;
        this.d = r1.e;
        this.c = r0.messageId;
        this.e = r1.k;
        if (com.ss.android.lark.notification.export.entity.a.a(r0) == false) goto L5;
        int r2 = this.b.extra.l;
    L6:
        this.f = r2;
        h = UIHelper.mustacheFormat(2131891519);
        return;
    L5:
        r2 = this.b.position;
        goto L6
    }

    @Override // atb.b
    public final String b() {
        if (x.c() == true) goto L6;
        return null;
    L6:
        return AbstractNotification.CHANNEL_TYPE.NORMAL;
    }

    @Override // atb.b
    public final String n() {
        return c();
    }

    public c(FlowReactionNotice r1) {
        super(r1);
        this.g = LarkContext.getApplication();
    }

    @Override // atb.b
    public final PendingIntent j(Intent r4) {
        int r1 = (int) SystemClock.uptimeMillis();
        if (x.a() == false) goto L5;
        int r0 = 201326592;
    L7:
        return PendingIntent.getActivity(this.g, r1, r4, r0);
    L5:
        r0 = 134217728;
        goto L7
    }
}
