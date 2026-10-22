package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Ba\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\"\u0010\n\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR0\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001f¨\u00062"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseMessage", "getResponseData", "", "getStatusCode", "", "checkValue", "verifySign", "has_more", "Z", "getHas_more", "()Z", "setHas_more", "(Z)V", "cursor", "I", "getCursor", "()I", "setCursor", "(I)V", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "effects", "Ljava/util/List;", "collection", "bind_effects", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "status_code", "getStatus_code", "setStatus_code", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "value", "getEffect_list", "setEffect_list", "effect_list", "getCollection_list", "setCollection_list", "collection_list", "<init>", "(ZILjava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class SearchEffectResponse extends e<SearchEffectResponse> {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private boolean has_more;
    private String message;
    private int status_code;

    public SearchEffectResponse() {
        this(false, 0, null, null, null, 0, null, 127, null);
    }

    public SearchEffectResponse getResponseData() {
        return this;
    }

    public boolean verifySign() {
        List<? extends Effect> r0 = this.collection;
        if (r0 == null) goto L10;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        if (b.a((Effect) r1.next()) == true) goto L6;
        return false;
    L10:
        List<Effect> r2 = getBind_effects();
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        if (b.a((Effect) r3.next()) == true) goto L14;
        return false;
    L18:
        List<? extends Effect> r4 = this.effects;
        if (r4 == null) goto L26;
        Iterator<T> r5 = r4.iterator();
    L22:
        if (r5.hasNext() == false) goto L37;
        if (b.a((Effect) r5.next()) == true) goto L22;
        return false;
    L37:
        return true;
    L26:
        return true;
    }

    public boolean checkValue() {
        return !getEffect_list().isEmpty();
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1561getResponseData() {
        return getResponseData();
    }

    public String getResponseMessage() {
        return getMessage();
    }

    public int getStatusCode() {
        return getStatus_code();
    }

    public List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public final List<Effect> getCollection_list() {
        return this.collection;
    }

    public int getCursor() {
        return this.cursor;
    }

    public final List<Effect> getEffect_list() {
        return this.effects;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public void setBind_effects(List<? extends Effect> r1) {
        this.bind_effects = r1;
    }

    public final void setCollection_list(List<? extends Effect> r1) {
        this.collection = r1;
    }

    public void setCursor(int r1) {
        this.cursor = r1;
    }

    public final void setEffect_list(List<? extends Effect> r1) {
        this.effects = r1;
    }

    public void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public SearchEffectResponse(boolean r1, int r2, List<? extends Effect> r3, List<? extends Effect> r4, List<? extends Effect> r5, int r6, String r7) {
        this.has_more = r1;
        this.cursor = r2;
        this.effects = r3;
        this.collection = r4;
        this.bind_effects = r5;
        this.status_code = r6;
        this.message = r7;
    }

    public /* synthetic */ SearchEffectResponse(boolean r6, int r7, List r8, List r9, List r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
        int r0 = 0;
        if ((r13 & 1) == 0) goto L5;
        boolean r15 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r13 & 4) == 0) goto L13;
        r8 = new ArrayList();
    L13:
        List r2 = r8;
        if ((r13 & 8) == 0) goto L16;
        r9 = new ArrayList();
    L16:
        List r3 = r9;
        if ((r13 & 16) == 0) goto L19;
        r10 = new ArrayList();
    L19:
        List r4 = r10;
        if ((r13 & 32) != 0) goto L24;
        r0 = r11;
    L24:
        if ((r13 & 64) == 0) goto L26;
        r12 = null;
    L26:
        String r16 = r12;
        this(r15, r1, r2, r3, r4, r0, r16);
        return;
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
