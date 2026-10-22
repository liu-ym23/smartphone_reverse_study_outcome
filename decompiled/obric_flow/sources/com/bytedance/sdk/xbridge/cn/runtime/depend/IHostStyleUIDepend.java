package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import androidx.annotation.Keep;
import cj.d;
import cn.nubia.neopush.commons.Constant;
import gj.j;
import ji.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000  2\u00020\u0001:\u0001!J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ!\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u00020\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostStyleUIDepend;", "", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/DialogBuilder;", "dialogBuilder", "", "showDialog", "(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/DialogBuilder;)Ljava/lang/Boolean;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;", "toastBuilder", "showToast", "(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;)Ljava/lang/Boolean;", "Lcj/d;", "bridgeContext", "showLoading", "(Lcj/d;)Ljava/lang/Boolean;", "Lji/a;", "showLoadingParams", "(Lji/a;Lcj/d;)Ljava/lang/Boolean;", "hideLoading", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilder;", "actionSheetBuilder", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ShowActionSheetListener;", "showActionSheetListener", "showActionSheet", "(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilder;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ShowActionSheetListener;)Ljava/lang/Boolean;", "Landroid/app/Activity;", "activity", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PageTitleBar;", Constant.TITLE, "", "setPageNaviStyle", "(Lcj/d;Landroid/app/Activity;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PageTitleBar;)V", "Companion", "gj/j", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostStyleUIDepend {
    public static final j Companion = null;
    public static final String TOAST_TYPE_ERROR = "error";
    public static final String TOAST_TYPE_SUCCESS = "success";
    public static final String TOAST_TYPE_WARN = "warn";

    static {
        Companion = j.f17103a;
    }

    Boolean hideLoading(d r5);

    void setPageNaviStyle(d r5, Activity r10, PageTitleBar r11);

    Boolean showActionSheet(ActionSheetBuilder r5, ShowActionSheetListener r10);

    Boolean showDialog(DialogBuilder r5);

    Boolean showLoading(d r5);

    Boolean showLoading(a r5, d r10);

    Boolean showToast(ToastBuilder r5);
}
