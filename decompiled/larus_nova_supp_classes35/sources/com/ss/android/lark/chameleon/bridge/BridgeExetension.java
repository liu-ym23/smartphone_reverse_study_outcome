package com.ss.android.lark.chameleon.bridge;

import android.webkit.WebView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;", BuildConfig.FLAVOR, "()V", "APINAME", BuildConfig.FLAVOR, "getAPINAME", "()Ljava/lang/String;", "APINAME_DATA_DISTANCE", BuildConfig.FLAVOR, "getAPINAME_DATA_DISTANCE", "()I", "CALLBACKID", "getCALLBACKID", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getResponseJSData", "Lcom/ss/android/lark/chameleon/bridge/ResponseJsData;", "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "callbackId", Keys.API_RETURN_KEY_DATA, "extraStr", "jsDataToMessage", "Lcom/ss/android/lark/chameleon/bridge/Message;", "parse", "jsMessage", "reqAuthWith", BuildConfig.FLAVOR, "webview", "Landroid/webkit/WebView;", "msg", "shouldMonitorHandlerConsumTime", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BridgeExetension {
    private final String APINAME;
    private final int APINAME_DATA_DISTANCE;
    private final String CALLBACKID;
    private final Lazy gson$delegate;

    public ResponseJsData getResponseJSData(Status r1, String r2, Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "status");
        Intrinsics.checkNotNullParameter(r2, "callbackId");
        Intrinsics.checkNotNullParameter(r4, "extraStr");
        return null;
    }

    public boolean reqAuthWith(WebView r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "webview");
        Intrinsics.checkNotNullParameter(r3, "msg");
        return true;
    }

    public boolean shouldMonitorHandlerConsumTime() {
        return false;
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    public BridgeExetension() {
        this.CALLBACKID = "callbackID\":\"";
        this.APINAME = "\"apiName\":\"";
        this.APINAME_DATA_DISTANCE = 9;
        this.gson$delegate = LazyKt.lazy(BridgeExetension$gson$2.INSTANCE);
    }

    public final String getAPINAME() {
        return this.APINAME;
    }

    public final int getAPINAME_DATA_DISTANCE() {
        return this.APINAME_DATA_DISTANCE;
    }

    public final String getCALLBACKID() {
        return this.CALLBACKID;
    }

    public Message jsDataToMessage(String r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        Message r0 = parse(r3);     // Catch: Throwable -> L15
        String r1 = r0.getApiName();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return r0;
    L13:
        return (Message) GsonProtectorUtils.fromJson(getGson(), r3, Message.class);
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
    L16:
        return (Message) GsonProtectorUtils.fromJson(getGson(), r3, Message.class);
    }

    public final Message parse(String r10) {
        Intrinsics.checkNotNullParameter(r10, "jsMessage");
        Message r0 = new Message();
        int r1 = StringsKt.indexOf$default(r10, this.CALLBACKID, 0, false, 6, null);
        if (r1 < 0) goto L5;
        int r2 = r1 + this.CALLBACKID.length();
        r0.setCallbackID(r10.substring(r2, StringsKt.indexOf$default(r10, '\"', r2, false, 4, null)));
    L5:
        int r3 = StringsKt.indexOf$default(r10, this.APINAME, 0, false, 6, null);
        if (r3 < 0) goto L10;
        int r4 = r3 + this.APINAME.length();
        int r5 = StringsKt.indexOf$default(r10, '\"', r4, false, 4, null);
        r0.setApiName(r10.substring(r4, r5));
        int r6 = r5 + this.APINAME_DATA_DISTANCE;
        int r7 = r10.length() - 1;
        if (r6 >= r7) goto L10;
        r0.setData(r10.substring(r6, r7));
    L10:
        return r0;
    }
}
