package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010 R$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010$R\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "", "component2", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component3", "()Ljava/lang/Boolean;", "component4", "data", INotificationHitPoint.NoticeType.MESSAGE, "updated", "status_code", "copy", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;Ljava/lang/String;Ljava/lang/Boolean;I)Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "equals", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;)V", "Ljava/lang/String;", "Ljava/lang/Boolean;", "getUpdated", "setUpdated", "(Ljava/lang/Boolean;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;Ljava/lang/String;Ljava/lang/Boolean;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class PanelInfoCheckedResponse extends e<PanelInfoModel> {
    private PanelInfoModel data;
    private String message;
    private int status_code;
    private Boolean updated;

    public PanelInfoCheckedResponse() {
        this(null, null, null, 0, 15, null);
    }

    private final String component2() {
        return this.message;
    }

    public static /* synthetic */ PanelInfoCheckedResponse copy$default(PanelInfoCheckedResponse r0, PanelInfoModel r1, String r2, Boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.updated;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.status_code;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final PanelInfoModel component1() {
        return this.data;
    }

    public final Boolean component3() {
        return this.updated;
    }

    public final int component4() {
        return this.status_code;
    }

    public final PanelInfoCheckedResponse copy(PanelInfoModel r2, String r3, Boolean r4, int r5) {
        return new PanelInfoCheckedResponse(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PanelInfoCheckedResponse) == false) goto L14;
        PanelInfoCheckedResponse r4 = (PanelInfoCheckedResponse) r3;
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.updated, r4.updated) == true) goto L12;
        return false;
    L12:
        if (this.status_code == r4.status_code) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        PanelInfoModel r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.updated;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + this.status_code;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PanelInfoCheckedResponse(data=" + this.data + ", message=" + this.message + ", updated=" + this.updated + ", status_code=" + this.status_code + ")";
    }

    public boolean checkValue() {
        if (Intrinsics.areEqual(this.updated, Boolean.TRUE) == true) goto L5;
        return true;
    L5:
        if (this.data != null) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean verifySign() {
        PanelInfoModel r0 = this.data;
        if (r0 == null) goto L14;
        CategoryEffectModel r1 = r0.getCategory_effects();
        if (r1 == null) goto L14;
        List<Effect> r2 = r1.getCollection();
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        if (b.a((Effect) r3.next()) == true) goto L10;
        return false;
    L14:
        PanelInfoModel r4 = this.data;
        if (r4 == null) goto L26;
        CategoryEffectModel r5 = r4.getCategory_effects();
        if (r5 == null) goto L26;
        List<Effect> r6 = r5.getBind_effects();
        if (r6 == null) goto L26;
        Iterator<T> r7 = r6.iterator();
    L22:
        if (r7.hasNext() == false) goto L26;
        if (b.a((Effect) r7.next()) == true) goto L22;
        return false;
    L26:
        PanelInfoModel r8 = this.data;
        if (r8 == null) goto L38;
        CategoryEffectModel r9 = r8.getCategory_effects();
        if (r9 == null) goto L49;
        List<Effect> r10 = r9.getCategory_effects();
        if (r10 == null) goto L50;
        Iterator<T> r11 = r10.iterator();
    L34:
        if (r11.hasNext() == false) goto L51;
        if (b.a((Effect) r11.next()) == true) goto L34;
        return false;
    L51:
        return true;
    L50:
        return true;
    L49:
        return true;
    L38:
        return true;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1544getResponseData() {
        return getResponseData();
    }

    public final PanelInfoModel getData() {
        return this.data;
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

    public final Boolean getUpdated() {
        return this.updated;
    }

    public PanelInfoModel getResponseData() {
        return this.data;
    }

    public final void setData(PanelInfoModel r1) {
        this.data = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public final void setUpdated(Boolean r1) {
        this.updated = r1;
    }

    public PanelInfoCheckedResponse(PanelInfoModel r1, String r2, Boolean r3, int r4) {
        this.data = r1;
        this.message = r2;
        this.updated = r3;
        this.status_code = r4;
    }

    public /* synthetic */ PanelInfoCheckedResponse(PanelInfoModel r2, String r3, Boolean r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = Boolean.TRUE;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
