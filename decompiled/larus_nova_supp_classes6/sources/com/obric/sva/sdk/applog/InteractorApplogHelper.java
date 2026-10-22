package com.obric.sva.sdk.applog;

import android.os.Bundle;
import android.util.Pair;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v48.d;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ>\u0010 \u001a\u00020\u000526\u0010!\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00050\"J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+J\u001e\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000100J\u0016\u00101\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0001J\u000e\u00103\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f¨\u00064"}, d2 = {"Lcom/obric/sva/sdk/applog/InteractorApplogHelper;", "", "<init>", "()V", "init", "", "configInfo", "Lcom/larus/applog/api/AppLogConfigInfo;", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "", "", "reportEvent", EventVerify.TYPE_EVENT_V1, "", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "getDeviceId", "getSessionId", "getUserUniqueID", "getUserID", "getOpenUDid", "addGetAppLogIdListener", "listener", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "closeETVerify", "addCommonParamInterceptor", "eventInterceptor", "Lcom/larus/applog/api/IEventInterceptor;", "removeCommonParamInterceptor", "addEventCommonParams", "key", "valueGenerator", "Lkotlin/Function0;", "putEventCommonParams", "value", "removeEventCommonParams", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class InteractorApplogHelper {
    public static final InteractorApplogHelper INSTANCE = null;

    static {
        INSTANCE = new InteractorApplogHelper();
    }

    private InteractorApplogHelper() {
    }

    public final void closeETVerify() {
        InteractorLegacyAppLogHelper.INSTANCE.closeETVerify();
    }

    public final String getDeviceId() {
        return InteractorLegacyAppLogHelper.INSTANCE.getDeviceId();
    }

    public final String getOpenUDid() {
        return InteractorLegacyAppLogHelper.INSTANCE.getOpenUDid();
    }

    public final String getSessionId() {
        return InteractorLegacyAppLogHelper.INSTANCE.getSessionId();
    }

    public final String getUserID() {
        return InteractorLegacyAppLogHelper.INSTANCE.getUserID();
    }

    public final String getUserUniqueID() {
        return InteractorLegacyAppLogHelper.INSTANCE.getUserUniqueID();
    }

    public final void openETVerify() {
        InteractorLegacyAppLogHelper.INSTANCE.openETVerify();
    }

    public final void addCommonParamInterceptor(d r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInterceptor");
        InteractorLegacyAppLogHelper.INSTANCE.addCommonParamInterceptor(r2);
    }

    public final void addGetAppLogIdListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        InteractorLegacyAppLogHelper.INSTANCE.addGetAppLogIdListener(r2);
    }

    public final void doWhenIdsReady(Function2<? super String, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        InteractorLegacyAppLogHelper.INSTANCE.doWhenIdsReady(r2);
    }

    public final void init(v48.a r2) {
        Intrinsics.checkNotNullParameter(r2, "configInfo");
        InteractorLegacyAppLogHelper.INSTANCE.init(r2);
    }

    public final void removeCommonParamInterceptor(d r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInterceptor");
        InteractorLegacyAppLogHelper.INSTANCE.removeCommonParamInterceptor(r2);
    }

    public final void removeDidListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        InteractorLegacyAppLogHelper.INSTANCE.removeDidListener(r2);
    }

    public final void removeEventCommonParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        InteractorLegacyAppLogHelper.INSTANCE.removeEventCommonParams(r2);
    }

    public final void setBDAccountCallback(Pair<Integer, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "pair");
        InteractorLegacyAppLogHelper.INSTANCE.setBDAccountCallback(r2);
    }

    public final void addEventCommonParams(String r2, Function0<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "valueGenerator");
        InteractorLegacyAppLogHelper.INSTANCE.addEventCommonParams(r2, r3);
    }

    public final void onMiscEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "logType");
        Intrinsics.checkNotNullParameter(r3, "obj");
        InteractorLegacyAppLogHelper.INSTANCE.onMiscEvent(r2, r3);
    }

    public final void putEventCommonParams(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        InteractorLegacyAppLogHelper.INSTANCE.putEventCommonParams(r2, r3);
    }

    public final void reportEvent(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, EventVerify.TYPE_EVENT_V1);
        InteractorLegacyAppLogHelper.INSTANCE.reportEvent(r2, r3);
    }

    public final void reportEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, EventVerify.TYPE_EVENT_V1);
        InteractorLegacyAppLogHelper.INSTANCE.reportEvent(r2, r3);
    }
}
