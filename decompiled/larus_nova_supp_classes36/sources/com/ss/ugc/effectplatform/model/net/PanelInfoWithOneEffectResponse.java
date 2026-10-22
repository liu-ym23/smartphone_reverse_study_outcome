package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "", "component2", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component3", "data", INotificationHitPoint.NoticeType.MESSAGE, "status_code", "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "equals", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;)V", "Ljava/lang/String;", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class PanelInfoWithOneEffectResponse extends e<PanelInfoWithOneEffectData> {
    private PanelInfoWithOneEffectData data;
    private String message;
    private int status_code;

    public PanelInfoWithOneEffectResponse() {
        this(null, null, 0, 7, null);
    }

    private final String component2() {
        return this.message;
    }

    public static /* synthetic */ PanelInfoWithOneEffectResponse copy$default(PanelInfoWithOneEffectResponse r0, PanelInfoWithOneEffectData r1, String r2, int r3, int r4, Object r5) {
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

    public final PanelInfoWithOneEffectData component1() {
        return this.data;
    }

    public final int component3() {
        return this.status_code;
    }

    public final PanelInfoWithOneEffectResponse copy(PanelInfoWithOneEffectData r2, String r3, int r4) {
        return new PanelInfoWithOneEffectResponse(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PanelInfoWithOneEffectResponse) == false) goto L12;
        PanelInfoWithOneEffectResponse r4 = (PanelInfoWithOneEffectResponse) r3;
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
        PanelInfoWithOneEffectData r0 = this.data;
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
        return "PanelInfoWithOneEffectResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean verifySign() {
        PanelInfoWithOneEffectData r0 = this.data;
        if (r0 == null) goto L9;
        Effect r1 = r0.front_effect;
        if (r1 == null) goto L9;
        if (b.a(r1) == true) goto L9;
        return false;
    L9:
        PanelInfoWithOneEffectData r2 = this.data;
        if (r2 == null) goto L16;
        Effect r3 = r2.rear_effect;
        if (r3 == null) goto L16;
        if (b.a(r3) == true) goto L16;
        return false;
    L16:
        PanelInfoWithOneEffectData r4 = this.data;
        if (r4 == null) goto L44;
        List<CategoryEffect> r5 = r4.category_effect_list;
        if (r5 == null) goto L57;
        Iterator<T> r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L58;
        CategoryEffect r7 = (CategoryEffect) r6.next();
        Effect r8 = r7.effects;
        if (r8 != null) goto L26;
    L28:
        List<? extends Effect> r9 = r7.bind_effects;
        if (r9 == null) goto L36;
        Iterator<T> r10 = r9.iterator();
    L32:
        if (r10.hasNext() == false) goto L36;
        if (b.a((Effect) r10.next()) == true) goto L32;
        return false;
    L36:
        List<? extends Effect> r11 = r7.collection;
        if (r11 == null) goto L22;
        Iterator<T> r12 = r11.iterator();
    L40:
        if (r12.hasNext() == false) goto L22;
        if (b.a((Effect) r12.next()) == true) goto L40;
        return false;
    L26:
        if (b.a(r8) == true) goto L28;
        return false;
    L58:
        return true;
    L57:
        return true;
    L44:
        return true;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1548getResponseData() {
        return getResponseData();
    }

    public final PanelInfoWithOneEffectData getData() {
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

    public PanelInfoWithOneEffectData getResponseData() {
        return this.data;
    }

    public final void setData(PanelInfoWithOneEffectData r1) {
        this.data = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public PanelInfoWithOneEffectResponse(PanelInfoWithOneEffectData r1, String r2, int r3) {
        this.data = r1;
        this.message = r2;
        this.status_code = r3;
    }

    public /* synthetic */ PanelInfoWithOneEffectResponse(PanelInfoWithOneEffectData r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
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
