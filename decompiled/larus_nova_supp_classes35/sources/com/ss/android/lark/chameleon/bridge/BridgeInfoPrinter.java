package com.ss.android.lark.chameleon.bridge;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002J6\u0010\b\u001a\u00020\t2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\f2\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/BridgeInfoPrinter;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "getLength", BuildConfig.FLAVOR, "param", "printInfo", BuildConfig.FLAVOR, "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", ChameleonOpenTracker.ParamKey.RESULT, "printLengthInfo", "extraMessage", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BridgeInfoPrinter {
    private final String TAG;

    public BridgeInfoPrinter() {
        this.TAG = "BridgeInfoPrinter";
    }

    private final int getLength(Object r2) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        if ((r2 instanceof String) == false) goto L8;
        return ((String) r2).length();
    L8:
        if ((r2 instanceof JSONObject) == false) goto L12;
        return ((JSONObject) r2).toString().length();
    L12:
        if ((r2 instanceof JsonObject) == false) goto L16;
        return JsonUtils.INSTANCE.toJsonString(r2).length();
    L16:
        return r2.toString().length();
    }

    private final void printLengthInfo(Object r7, String r8) {
        if ((r7 instanceof HashMap) == false) goto L9;
        Iterator r0 = ((HashMap) r7).keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        Object r2 = ((Map) r7).get(r1);
        Log.i(this.TAG, r8 + "key: " + r1 + "--value length: " + getLength(r2));
        goto L6
    L14:
        return;
    L9:
        if ((r7 instanceof String) == false) goto L13;
        Log.i(this.TAG, r8 + ((String) r7).length());
        return;
    }

    public final void printInfo(HashMap<String, Object> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, ChameleonOpenTracker.ParamKey.RESULT);
    L9:
        th = move-exception;
        Log.e(this.TAG, th.toString());
        return;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (r4.length() <= 2097152) goto L15;
        printLengthInfo(r3, "param before serialize ");     // Catch: Throwable -> L9
        printLengthInfo(r4, "param after serialize ");     // Catch: Throwable -> L9
        return;
    }
}
