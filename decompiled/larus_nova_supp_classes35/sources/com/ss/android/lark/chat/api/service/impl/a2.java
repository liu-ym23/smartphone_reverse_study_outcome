package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsRequest;
import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsResponse;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesRequest;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesResponse;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchRequest;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchResponse;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageRequest;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageResponse;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Request;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Response;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a2 implements t0 {
    public final com.bytedance.lark.rustclient.api.l a;

    @Inject
    public a2(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void a(SetTranslateLanguageRequest.Builder r11, c2 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMapper");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, SetTranslateLanguageResponse.ADAPTER, Command.SET_TRANSLATE_LANGUAGES_SETTING, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new y1(r12)), r13);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void b(TranslateMessagesV3Request.Builder r11, d2 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMapper");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, TranslateMessagesV3Response.ADAPTER, Command.TRANSLATE_MESSAGES_V3, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new z1(r12)), r13);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void c(GetTranslateLanguagesRequest.Builder r11, f2 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMapper");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetTranslateLanguagesResponse.ADAPTER, Command.GET_TRANSLATE_LANGUAGES_SETTING, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new w1(r12)), r13);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void d(TranslateMessageUrlPreviewsRequest.Builder r11, e2 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMapper");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, TranslateMessageUrlPreviewsResponse.ADAPTER, Command.TRANSLATE_MESSAGE_URL_PREVIEW, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new v1(r12)), r13);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void e(SetAutoTranslateGlobalSwitchRequest.Builder r11, b2 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMapper");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, SetAutoTranslateGlobalSwitchResponse.ADAPTER, Command.SET_AUTO_TRANSLATE_GLOBAL_SWITCH, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new x1(r12)), r13);
    }
}
