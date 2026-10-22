package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.GetUserPrivateDescriptionsRequest;
import com.bytedance.lark.pb.contact.v1.GetUserPrivateDescriptionsResponse;
import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class e1 implements a2b.g {
    public static final /* synthetic */ int b = 0;
    public final com.bytedance.lark.rustclient.api.l a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Strategy.values().length];
            r0[Strategy.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Strategy.TRY_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Strategy.FORCE_SERVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Inject
    public e1(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // a2b.g
    public final Object a(List r10, PrivateDescriptionSource r11, Strategy r12) {
        ArrayList r0 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Long r1 = StringsKt.toLongOrNull((String) r13.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        int r14 = b.a[r12.ordinal()];
        if (r14 != 1) goto L11;
        SyncDataStrategy r15 = SyncDataStrategy.LOCAL;
    L19:
        GetUserPrivateDescriptionsRequest.Builder r2 = new GetUserPrivateDescriptionsRequest.Builder().user_ids(r0).source(GetUserPrivateDescriptionsRequest.Source.fromValue(r11.getRustValue())).sync_data_strategy(r15);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r16 = new com.bytedance.lark.rustclient.api.d(r2, GetUserPrivateDescriptionsResponse.ADAPTER, Command.GET_USER_PRIVATE_DESCRIPTIONS, null, null, null, null, 248);
        return ((com.bytedance.lark.rustclient.api.x) com.bytedance.lark.rustclient.api.t.b(this.a.h(r16).a().map(new f1(this))).blockingFirst()).c;
    L11:
        if (r14 != 2) goto L13;
        r15 = SyncDataStrategy.TRY_LOCAL;
        goto L19
    L13:
        if (r14 != 3) goto L16;
        r15 = SyncDataStrategy.FORCE_SERVER;
        goto L19
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
