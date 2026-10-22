package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.basic.v1.ContactInfo;
import com.bytedance.lark.pb.contact.v2.GetExternalContactListResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements SdkSender.IParser {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object parse(byte[] r5) {
        GetExternalContactListResponse r6 = (GetExternalContactListResponse) GetExternalContactListResponse.ADAPTER.decode(r5);
        if (r6 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.contact.base.entity.b r0 = new com.ss.android.lark.contact.base.entity.b();
        ArrayList r1 = new ArrayList();
        if (r6.contacts == null) goto L14;
        int r2 = 0;
    L9:
        if (r2 >= r6.contacts.size()) goto L14;
        com.ss.android.lark.contact.base.entity.a r3 = com.ss.android.lark.contact.base.entity.a.a((ContactInfo) ListProtector.get(r6.contacts, r2));
        if (r3 == null) goto L13;
        r1.add(r3);
    L13:
        r2 = r2 + 1;
    L14:
        r0.a = r1;
        r6.has_more.booleanValue();
        return r0;
    }
}
