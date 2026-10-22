package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoRequest;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoResponse;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfficeExternalContactRepository {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(OfficeExternalContactRepository$pushNewContactBadgeListeners$2.INSTANCE);
        b = LazyKt.lazy(OfficeExternalContactRepository$pushContactListeners$2.INSTANCE);
    }

    public static SdkSender.d a(boolean r2, GetContactsScene r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        GetContactsDoubaoRequest.Builder r0 = new GetContactsDoubaoRequest.Builder();
        if (r2 == false) goto L5;
        r0.strategy(SyncDataStrategy.LOCAL);
    L6:
        r0.scene(r3);
        Command r4 = Command.GET_CONTACTS_DOUBAO;
        final ProtoAdapter r5 = GetContactsDoubaoResponse.ADAPTER;
        return SdkSender.syncSendMayError(r4, r0, new a(r5));
    L5:
        r0.strategy(SyncDataStrategy.FORCE_SERVER);
        goto L6
    }
}
