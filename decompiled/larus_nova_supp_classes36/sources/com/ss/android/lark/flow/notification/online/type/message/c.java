package com.ss.android.lark.flow.notification.online.type.message;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends atb.b<Notice, qhb.a> {
    public Notice b;
    public String c;
    public String d;
    public Notice.Extra.ChatType e;
    public String f;
    public int g;
    public int h;
    public final Context i;

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
    public final PendingIntent j(Intent r1) {
        return null;
    }

    @Override // atb.b
    public final void k() {
    }

    @Override // atb.b
    public final Uri l() {
        return null;
    }

    @Override // atb.b
    public final String c() {
        Notice r0 = this.b;
        String r1 = r0.content;
        boolean r2 = r0.extra.q;
        if (r2 == false) goto L6;
        r1 = null;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L8;
        return r1;
    L8:
        Notice r3 = this.b;
        int r4 = r3.state;
        if (r4 != 2) goto L13;
        return UIHelper.getString(2131891918);
    L13:
        if (r4 == 3) goto L15;
        String r5 = r3.content;
        if (r3.extra.f == true) goto L32;
        if (r2 == true) goto L21;
        return r5;
    L21:
        if (this.e != Notice.Extra.ChatType.GROUP) goto L28;
        if (r() == false) goto L26;
        return UIHelper.getString(2131891790);
    L26:
        return UIHelper.getString(2131892014);
    L28:
        if (r() == false) goto L31;
        return UIHelper.getString(2131892232);
    L31:
        return UIHelper.getString(2131892015);
    L32:
        return UIHelper.getString(2131891706);
    L15:
        return UIHelper.getString(2131891918);
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
        String r0 = this.b.title;
        if (r0 == null) goto L9;
        if (r0.isEmpty() == true) goto L9;
        return this.b.title;
    L9:
        return UIHelper.getString(2131891519);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final void p() {
        Notice r0 = (Notice) this.a;
        this.b = r0;
        this.c = r0.messageId;
        Notice.Extra r1 = r0.extra;
        this.d = r1.a;
        this.e = r1.b;
        Notice.Extra.ChatMode r2 = r1.d;
        this.f = r1.e;
        this.g = r1.k;
        if (com.ss.android.lark.notification.export.entity.a.a(r0) == false) goto L5;
        int r3 = this.b.extra.l;
    L6:
        this.h = r3;
        return;
    L5:
        r3 = this.b.position;
        goto L6
    }

    public final boolean r() {
        if (this.b.type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean s() {
        Notice.Extra.ChatType r0 = this.b.extra.b;
        if (r0 != null) goto L7;
        thb.a.a("FlowMessageNotificationDataPacker", "notice chat type is null！");
        return false;
    L7:
        if (r0 != Notice.Extra.ChatType.GROUP) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // atb.b
    public final String b() {
        if (r() == false) goto L6;
        return AbstractNotification.CHANNEL_TYPE.AT;
    L6:
        return AbstractNotification.CHANNEL_TYPE.NORMAL;
    }

    @Override // atb.b
    public final int g() {
        if (r() == false) goto L9;
        if (s() == false) goto L9;
        return dtb.c.b(this.b, this.c);
    L9:
        return dtb.c.b(this.b, this.d);
    }

    @Override // atb.b
    public final String n() {
        return UIHelper.getString(2131892015);
    }

    @Override // atb.b
    public final boolean q() {
        return r();
    }

    @Override // atb.b
    public final String h() {
        return this.c;
    }

    public c(Notice r1) {
        super(r1);
        this.i = LarkContext.getApplication();
    }
}
