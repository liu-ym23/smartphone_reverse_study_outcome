package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsRequest;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class d implements com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a {
    public final l a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Function1<GetUserChatWindowFieldsResponse, c> a;

        public a(Function1<? super GetUserChatWindowFieldsResponse, c> r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            x r3 = (x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (c) this.a.invoke(r3.c);
        }
    }

    @Inject
    public d(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a
    public final void a(GetUserChatWindowFieldsRequest.Builder r11, IGetDataCallback<c> r12, Function1<? super GetUserChatWindowFieldsResponse, c> r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r13, "respMapper");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetUserChatWindowFieldsResponse.ADAPTER, Command.GET_USER_CHAT_WINDOW_FIELDS, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(t.b(this.a.h(r0).a()).map(new a(r13)), r12);
    }
}
