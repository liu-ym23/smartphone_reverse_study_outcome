package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.o;
import android.content.Context;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.s;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import e0c.k;
import f0c.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends c0c.b implements o {
    public final /* synthetic */ o b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<o> d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.o
    public final void H8(Context r2, AtUserGroupInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "info");
        this.b.H8(r2, r3);
    }

    @Override // a2b.o
    public final void La(Message r2) {
        this.b.La(r2);
    }

    @Override // a2b.o
    public final void c6(RichText r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "richText");
        this.b.c6(r2, r3);
    }

    @Override // a2b.o
    public final boolean isEnabled() {
        return this.b.isEnabled();
    }

    @Override // a2b.o
    public final void pe(Map<Long, UserGroupEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "userGroups");
        this.b.pe(r2);
    }

    @Override // a2b.o
    public final void w9(s.c r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.w9(r2);
    }

    @Override // a2b.o
    public final void z1(s.c r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b.z1(r2);
    }

    public f(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<o> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), o.class), o.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (o) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("UserGroupRepositoryProxy", "preparing IUserGroupRepository");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        o r6 = (o) k.b(r4.c(r5), o.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
