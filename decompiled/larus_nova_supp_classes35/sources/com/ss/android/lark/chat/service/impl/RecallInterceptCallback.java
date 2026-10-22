package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u001b\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/service/impl/RecallInterceptCallback;", "Lcom/larksuite/framework/callback/UIGetDataCallback;", BuildConfig.FLAVOR, "origin", "Lcom/larksuite/framework/callback/IGetDataCallback;", "<init>", "(Lcom/larksuite/framework/callback/IGetDataCallback;)V", "onSuccessed", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onErrored", Keys.API_RETURN_KEY_ERROR, "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RecallInterceptCallback extends UIGetDataCallback<String> {
    public static final a Companion = null;
    public static final int DELETE_THREAD_PERMISSION_EXPIRED = 4017;
    private static final String TAG = "RecallInterceptCallback";
    public static final int WITHDRAW_MESSAGE_EXPIRED = 4016;
    private final IGetDataCallback<String> origin;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RecallInterceptCallback() {
        IGetDataCallback r0 = null;
        this(r0, 1, r0);
    }

    public RecallInterceptCallback(IGetDataCallback<String> r1) {
        this.origin = r1;
    }

    public void onErrored(ErrorResult r3) {
        if (r3 == null) goto L12;
        IGetDataCallback<String> r0 = this.origin;
        if (r0 == null) goto L7;
        r0.onError(r3);
    L7:
        if (r3.getCode() != 4016) goto L9;
    L10:
        Log.i(TAG, "recall failed , error code is : " + r3.getCode());
        ChatAppContainerV1.a.f0().jd(true);
        return;
    L9:
        if (r3.getCode() == 4017) goto L10;
        return;
    }

    public void onSuccessed(String r2) {
        IGetDataCallback<String> r0 = this.origin;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
        onSuccessed((String) r1);
    }

    public /* synthetic */ RecallInterceptCallback(IGetDataCallback r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
