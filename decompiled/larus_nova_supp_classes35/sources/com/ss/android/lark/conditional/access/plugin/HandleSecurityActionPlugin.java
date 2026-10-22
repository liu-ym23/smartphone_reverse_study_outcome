package com.ss.android.lark.conditional.access.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.conditional.access.auth.v2.z;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import j18.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w4c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/conditional/access/plugin/HandleSecurityActionPlugin;", "Lcom/larksuite/framework/apiplugin/AutoRegisterLKPlugin;", "<init>", "()V", "notifySecurityAlert", BuildConfig.FLAVOR, "request", "Lcom/ss/android/lark/conditional/access/plugin/HandleSecurityActionPlugin$NotifySecurityAlertRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/ss/android/lark/conditional/access/plugin/HandleSecurityActionPlugin$NotifySecurityAlertResponseModel;", "onRelease", "Companion", "NotifySecurityAlertRequestModel", "NotifySecurityAlertResponseModel", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandleSecurityActionPlugin extends i18.b {
    public static final a Companion = null;
    public static final String TAG = "SecurityPolicy_HandleSecurityActionPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/conditional/access/plugin/HandleSecurityActionPlugin$NotifySecurityAlertRequestModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "decision", BuildConfig.FLAVOR, "getDecision", "()Ljava/lang/String;", "setDecision", "(Ljava/lang/String;)V", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NotifySecurityAlertRequestModel extends LKBaseRequestModel {

        @JSONField(name = "decision")
        private String decision;

        public NotifySecurityAlertRequestModel() {
            this.decision = BuildConfig.FLAVOR;
        }

        public final String getDecision() {
            return this.decision;
        }

        public final void setDecision(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.decision = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/conditional/access/plugin/HandleSecurityActionPlugin$NotifySecurityAlertResponseModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NotifySecurityAlertResponseModel extends LKBaseResponseModel {
        public NotifySecurityAlertResponseModel() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void onRelease() {
        ScsLogger.d(TAG, "onRelease()");
    }

    public HandleSecurityActionPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"notifySecurityAlert"})
    public final void notifySecurityAlert(NotifySecurityAlertRequestModel r12, f<NotifySecurityAlertResponseModel> r13) {
        qqb.a.h("HandleSecurityActionPlugin.notifySecurityAlert");     // Catch: Throwable -> L26
        if (c.a().U() == false) goto L21;
        if (r12 == null) goto L8;
        String r14 = r12.getDecision();     // Catch: Throwable -> L26
    L9:
        String r4 = r14;
        if (r4 != null) goto L12;
    L15:
        boolean r15 = true;
    L16:
        if (r15 == false) goto L18;
        ScsLogger.c(TAG, "decision is null or empty.");     // Catch: Throwable -> L26
    L19:
        if (r13 == null) goto L24;
        r13.callback(new NotifySecurityAlertResponseModel());     // Catch: Throwable -> L26
    L24:
        qqb.a.a();
        return;
    L18:
        int r16 = ScsLogger.a;     // Catch: Throwable -> L26
        ScsLogger.d(TAG, "decision: " + r4);     // Catch: Throwable -> L26
        z.a.d(new SecurityAction(r4, null, 0, 0, 14, null), "WEB_JSB");     // Catch: Throwable -> L26
        goto L19
    L12:
        if (r4.length() == 0) goto L15;
        r15 = false;
        goto L16
    L8:
        r14 = null;
        goto L9
    L21:
        ScsLogger.d(TAG, "HandleSecurityActionPlugin.notifySecurityAlert, settings is close!");     // Catch: Throwable -> L26
        NotifySecurityAlertResponseModel r17 = new NotifySecurityAlertResponseModel();     // Catch: Throwable -> L26
        r17.setApiErrNo(o18.a.f);     // Catch: Throwable -> L26
        if (r13 == null) goto L24;
        r13.callback(r17);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        qqb.a.a();
        throw th;
    }
}
