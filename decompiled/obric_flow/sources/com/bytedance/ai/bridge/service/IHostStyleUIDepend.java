package com.bytedance.ai.bridge.service;

import android.app.Activity;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import k2.c;
import kotlin.Metadata;
import n1.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ!\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\u00020\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostStyleUIDepend;", "", "Lcom/bytedance/ai/bridge/service/DialogBuilder;", "dialogBuilder", "", "showDialog", "(Lcom/bytedance/ai/bridge/service/DialogBuilder;)Ljava/lang/Boolean;", "Lcom/bytedance/ai/bridge/service/ToastBuilder;", "toastBuilder", "showToast", "(Lcom/bytedance/ai/bridge/service/ToastBuilder;)Ljava/lang/Boolean;", "Ln1/a;", "bridgeContext", "showLoading", "(Ln1/a;)Ljava/lang/Boolean;", "hideLoading", "Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;", "actionSheetBuilder", "Lcom/bytedance/ai/bridge/service/ShowActionSheetListener;", "showActionSheetListener", "showActionSheet", "(Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;Lcom/bytedance/ai/bridge/service/ShowActionSheetListener;)Ljava/lang/Boolean;", "Landroid/app/Activity;", "activity", "Lcom/bytedance/ai/bridge/service/PageTitleBar;", Constant.TITLE, "", "setPageNaviStyle", "(Ln1/a;Landroid/app/Activity;Lcom/bytedance/ai/bridge/service/PageTitleBar;)V", "Companion", "k2/c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHostStyleUIDepend {
    public static final c Companion = null;
    public static final String TOAST_TYPE_ERROR = "error";
    public static final String TOAST_TYPE_SUCCESS = "success";
    public static final String TOAST_TYPE_WARN = "warn";

    static {
        Companion = c.f18584a;
    }

    Boolean hideLoading(a r5);

    void setPageNaviStyle(a r5, Activity r10, PageTitleBar r11);

    Boolean showActionSheet(ActionSheetBuilder r5, ShowActionSheetListener r10);

    Boolean showDialog(DialogBuilder r5);

    Boolean showLoading(a r5);

    Boolean showToast(ToastBuilder r5);
}
