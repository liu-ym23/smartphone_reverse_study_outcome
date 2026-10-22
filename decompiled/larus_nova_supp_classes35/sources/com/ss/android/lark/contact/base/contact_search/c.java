package com.ss.android.lark.contact.base.contact_search;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.SearchUserByContactPointRequest;
import com.bytedance.lark.pb.contact.v1.SearchUserByContactPointResponse;
import com.bytedance.lark.pb.contact.v1.SendUserInvitationResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends BaseModel implements a {
    public c() {
    }

    @Override // com.ss.android.lark.contact.base.contact_search.a
    public final <T> void x3(String r8, IGetDataCallback<T> r9) {
        int r0 = com.ss.android.lark.contact.base.service.d.a;
        UIGetDataCallback r2 = getCallbackManager().wrapAndAddGetDataCallback(r9);
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Command r10 = Command.SEARCH_USER_BY_CONTACT_POINT;
        SearchUserByContactPointRequest.Builder r11 = new SearchUserByContactPointRequest.Builder().contact_content(r8);
        InvApmUtils.GetDataCallback r1 = new InvApmUtils.GetDataCallback(r2, "ug_invite_external_orientation_search", null, 4, null);
        final ProtoAdapter r3 = SearchUserByContactPointResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r10, r11, r1, new com.ss.android.lark.contact.base.service.h(r3));
    }

    @Override // com.ss.android.lark.contact.base.contact_search.a
    public final void w4(String r2, boolean r3, IGetDataCallback<SendUserInvitationResponse> r4) {
        int r0 = com.ss.android.lark.contact.base.service.d.a;
        com.ss.android.lark.contact.base.service.d.e(r2, r3, getCallbackManager().wrapAndAddGetDataCallback(r4));
    }
}
