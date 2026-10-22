package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.o;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuCheckPayNotificationResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/ec/model/response/o;", "notifications", "Ljava/util/List;", "getNotifications", "()Ljava/util/List;", "setNotifications", "(Ljava/util/List;)V", "notification", "Lcom/bytedance/android/ec/model/response/o;", "getNotification", "()Lcom/bytedance/android/ec/model/response/o;", "setNotification", "(Lcom/bytedance/android/ec/model/response/o;)V", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuCheckPayNotificationResponse extends CommerceBaseResponse {

    @SerializedName("notification")
    private o notification;

    @SerializedName("notifications")
    private List<o> notifications;

    public SkuCheckPayNotificationResponse() {
    }

    public final o getNotification() {
        return this.notification;
    }

    public final List<o> getNotifications() {
        return this.notifications;
    }

    public final void setNotification(o r1) {
        this.notification = r1;
    }

    public final void setNotifications(List<o> r1) {
        this.notifications = r1;
    }
}
