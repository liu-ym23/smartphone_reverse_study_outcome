package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u0007\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/AddCustomizedEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "effectZipPath", "getEffectZipPath", "setEffectZipPath", "iconPath", "getIconPath", "setIconPath", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class AddCustomizedEffectResponse extends e<AddCustomizedEffectResponse> {
    private String effectZipPath;
    private String iconPath;
    private String message;
    private int status_code;

    public AddCustomizedEffectResponse() {
        this(0, null, null, null, 15, null);
    }

    public AddCustomizedEffectResponse getResponseData() {
        return this;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1528getResponseData() {
        return getResponseData();
    }

    public String getResponseMessage() {
        return getMessage();
    }

    public int getStatusCode() {
        return getStatus_code();
    }

    public String getEffectZipPath() {
        return this.effectZipPath;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public void setEffectZipPath(String r1) {
        this.effectZipPath = r1;
    }

    public void setIconPath(String r1) {
        this.iconPath = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public AddCustomizedEffectResponse(int r1, String r2, String r3, String r4) {
        this.status_code = r1;
        this.message = r2;
        this.effectZipPath = r3;
        this.iconPath = r4;
    }

    public /* synthetic */ AddCustomizedEffectResponse(int r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
