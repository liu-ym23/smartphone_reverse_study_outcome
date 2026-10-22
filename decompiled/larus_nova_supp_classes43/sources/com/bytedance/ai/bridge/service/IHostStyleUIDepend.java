package com.bytedance.ai.bridge.service;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostStyleUIDepend;", "", "showDialog", "", "dialogBuilder", "Lcom/bytedance/ai/bridge/service/DialogBuilder;", "(Lcom/bytedance/ai/bridge/service/DialogBuilder;)Ljava/lang/Boolean;", "showToast", "toastBuilder", "Lcom/bytedance/ai/bridge/service/ToastBuilder;", "(Lcom/bytedance/ai/bridge/service/ToastBuilder;)Ljava/lang/Boolean;", "hideToast", "bridgeContext", "Lcom/bytedance/ai/bridge/context/AIBridgeContext;", "(Lcom/bytedance/ai/bridge/context/AIBridgeContext;)Ljava/lang/Boolean;", "showLoading", "hideLoading", "showActionSheet", "actionSheetBuilder", "Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;", "showActionSheetListener", "Lcom/bytedance/ai/bridge/service/ShowActionSheetListener;", "(Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;Lcom/bytedance/ai/bridge/service/ShowActionSheetListener;)Ljava/lang/Boolean;", "setPageNaviStyle", "", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "title", "Lcom/bytedance/ai/bridge/service/PageTitleBar;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostStyleUIDepend {
    public static final a Companion = null;
    public static final String TOAST_TYPE_ERROR = "error";
    public static final String TOAST_TYPE_SUCCESS = "success";
    public static final String TOAST_TYPE_WARN = "warn";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }

    Boolean hideLoading(e3.a r1);

    Boolean hideToast(e3.a r1);

    void setPageNaviStyle(e3.a r1, Activity r10, PageTitleBar r11);

    Boolean showActionSheet(ActionSheetBuilder r1, ShowActionSheetListener r10);

    Boolean showDialog(DialogBuilder r1);

    Boolean showLoading(e3.a r1);

    Boolean showToast(ToastBuilder r1);
}
