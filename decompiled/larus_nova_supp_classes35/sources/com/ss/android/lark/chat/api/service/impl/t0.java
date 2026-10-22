package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsRequest;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesRequest;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchRequest;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageRequest;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Request;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface t0 {
    void a(SetTranslateLanguageRequest.Builder r1, c2 r2, IGetDataCallback r3);

    void b(TranslateMessagesV3Request.Builder r1, d2 r2, IGetDataCallback r3);

    void c(GetTranslateLanguagesRequest.Builder r1, f2 r2, IGetDataCallback r3);

    void d(TranslateMessageUrlPreviewsRequest.Builder r1, e2 r2, IGetDataCallback r3);

    void e(SetAutoTranslateGlobalSwitchRequest.Builder r1, b2 r2, IGetDataCallback r3);
}
