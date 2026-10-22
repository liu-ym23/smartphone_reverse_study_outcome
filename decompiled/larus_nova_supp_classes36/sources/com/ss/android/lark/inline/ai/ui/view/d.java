package com.ss.android.lark.inline.ai.ui.view;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityResponse;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements SdkSender.IParser {
    public final /* synthetic */ String a;

    public d(String r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r18) {
        UrlPreviewEntity r0 = ((GenerateUrlPreviewEntityResponse) GenerateUrlPreviewEntityResponse.ADAPTER.decode(r18)).preview_entity;
        if (r0 == null) goto L8;
        Log.i("URLRecognition", "getUrlInlineFromContent success: " + r0.server_title);
        String r4 = this.a;
        String r5 = r0.server_title;
        String r1 = r0.server_icon_key;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        return new UrlInlinePreviewEntity(r4, r5, r1, 0, 0, null, null, 0, 0, null, null, 0, false);
    L8:
        Log.e("URLRecognition", "getUrlInlineFromContent err: ");
        return null;
    }
}
