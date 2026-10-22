package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\bHÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/EffectNetListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "getResponseData", "", "getResponseMessage", "", "checkValue", "", "getStatusCode", "verifySign", "component1", "component2", "component3", "data", INotificationHitPoint.NoticeType.MESSAGE, "status_code", "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "equals", "Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/EffectChannelModel;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/EffectChannelModel;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class EffectNetListResponse extends e<EffectChannelModel> {
    private EffectChannelModel data;
    private String message;
    private int status_code;

    public EffectNetListResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ EffectNetListResponse copy$default(EffectNetListResponse r0, EffectChannelModel r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.status_code;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final EffectChannelModel component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final EffectNetListResponse copy(EffectChannelModel r2, String r3, int r4) {
        return new EffectNetListResponse(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EffectNetListResponse) == false) goto L12;
        EffectNetListResponse r4 = (EffectNetListResponse) r3;
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r4.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        EffectChannelModel r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.status_code;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "EffectNetListResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    public boolean checkValue() {
        EffectChannelModel r0 = this.data;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.checkValued();
    }

    public boolean verifySign() {
        EffectChannelModel r0 = this.data;
        if (r0 == null) goto L12;
        List r1 = r0.getEffect_list();
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        if (b.a((Effect) r2.next()) == true) goto L8;
        return false;
    L12:
        EffectChannelModel r3 = this.data;
        if (r3 == null) goto L22;
        List r4 = r3.getCollection_list();
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L31;
        if (b.a((Effect) r5.next()) == true) goto L18;
        return false;
    L31:
        return true;
    L30:
        return true;
    L22:
        return true;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1536getResponseData() {
        return getResponseData();
    }

    public final EffectChannelModel getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public String getResponseMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public EffectChannelModel getResponseData() {
        return this.data;
    }

    public final void setData(EffectChannelModel r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public EffectNetListResponse(EffectChannelModel r1, String r2, int r3) {
        this.data = r1;
        this.message = r2;
        this.status_code = r3;
    }

    public /* synthetic */ EffectNetListResponse(EffectChannelModel r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
