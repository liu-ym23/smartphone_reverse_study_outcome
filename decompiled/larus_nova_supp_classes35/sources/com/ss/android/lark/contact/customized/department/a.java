package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.basic.v1.Department;
import com.bytedance.lark.pb.contact.v1.GetSubordinateDepartmentsRequestResponse;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        List r6 = ((GetSubordinateDepartmentsRequestResponse) GetSubordinateDepartmentsRequestResponse.ADAPTER.decode(r5)).departments;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Department r1 = (Department) r7.next();
        r0.add(new i(r1.name, r1.id));
        goto L4
    L6:
        return r0;
    }
}
