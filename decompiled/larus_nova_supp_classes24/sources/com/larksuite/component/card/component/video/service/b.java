package com.larksuite.component.card.component.video.service;

import com.bytedance.lark.pb.media.v1.GetFileStateByUrlResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b<T> implements SdkSender.IParser {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (GetFileStateByUrlResponse) GetFileStateByUrlResponse.ADAPTER.decode(r3);
    L4:
        th = move-exception;
        StringBuilder r0 = new StringBuilder();
        WeakReference<CardVideoServiceImpl> r1 = CardVideoServiceImpl.c;
        r0.append(CardVideoServiceImpl.a.a(this.a));
        r0.append(" GET_FILE_STATE_BY_URL decode error");
        Log.e("CardVideoService", r0.toString(), th);
        return null;
    }
}
