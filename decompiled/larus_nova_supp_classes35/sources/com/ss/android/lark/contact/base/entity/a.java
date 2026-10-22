package com.ss.android.lark.contact.base.entity;

import com.bytedance.lark.pb.basic.v1.ContactInfo;
import com.bytedance.lark.pb.basic.v1.ContactOperation;
import com.bytedance.lark.pb.basic.v1.UserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public c a;
    public int b;

    public a() {
    }

    public static a a(ContactInfo r5) {
        c r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        a r1 = new a();
        UserInfo r2 = r5.user_info;
        if (r2 == null) goto L9;
        r0 = new c();
        r0.a = r2.avatar_key;
        r0.b = r2.user_name;
        r0.c = r2.name_py;
        r0.d = r2.tenant_name;
        r2.last_seven_day_online_minutes.intValue();
        r0.e = r2.user_id;
        r0.f = r2.tenant_id;
        r0.g = r2.alias;
        r0.h = r2.description;
        r0.i = r2.agree_time.longValue();
        r0.j = r2.is_special_focus.booleanValue();
        r0.k = r2.name_with_another_name;
        r0.l = r2.tenant_name_status;
        r0.m = r2.certification_info;
    L9:
        r1.a = r0;
        ContactOperation r6 = r5.op;
        if (r6 != ContactOperation.OPERATION_ADD) goto L13;
        int r7 = 1;
    L19:
        r1.b = r7;
        return r1;
    L13:
        if (r6 != ContactOperation.OPERATION_DELETE) goto L16;
        r7 = 2;
        goto L19
    L16:
        if (r6 != ContactOperation.OPERATION_UPDATE) goto L18;
        r7 = 3;
        goto L19
    L18:
        r7 = 0;
        goto L19
    }
}
