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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0017\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\"\u0010\u0015\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\fR0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R0\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "verifySign", "url_prefix", "Ljava/util/List;", "getUrl_prefix", "()Ljava/util/List;", "setUrl_prefix", "(Ljava/util/List;)V", "bind_effects", "getBind_effects", "setBind_effects", "collection", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "data", "value", "getEffect_list", "setEffect_list", "effect_list", "getCollection_list", "setCollection_list", "collection_list", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/util/List;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class EffectListResponse extends e<List<? extends Effect>> {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private List<? extends Effect> data;
    private String message;
    private int status_code;
    private List<String> url_prefix;

    public EffectListResponse() {
        this(null, null, null, 0, null, null, 63, null);
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
        List<? extends Effect> r4 = this.data;
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

    public /* bridge */ /* synthetic */ Object getResponseData() {
        return m1535getResponseData();
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

    public final List<Effect> getEffect_list() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public List<Effect> m1535getResponseData() {
        return getEffect_list();
    }

    public void setBind_effects(List<? extends Effect> r1) {
        this.bind_effects = r1;
    }

    public final void setCollection_list(List<? extends Effect> r1) {
        this.collection = r1;
    }

    public final void setEffect_list(List<? extends Effect> r1) {
        this.data = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public EffectListResponse(List<String> r1, List<? extends Effect> r2, List<? extends Effect> r3, int r4, String r5, List<? extends Effect> r6) {
        this.url_prefix = r1;
        this.bind_effects = r2;
        this.collection = r3;
        this.status_code = r4;
        this.message = r5;
        this.data = r6;
    }

    public /* synthetic */ EffectListResponse(List r5, List r6, List r7, int r8, String r9, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = new ArrayList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = new ArrayList();
    L8:
        List r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = new ArrayList();
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        int r1 = 0;
    L16:
        if ((r11 & 16) == 0) goto L18;
        r9 = null;
    L18:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L21;
        r10 = new ArrayList();
    L21:
        List r3 = r10;
        this(r5, r13, r0, r1, r2, r3);
        return;
    L14:
        r1 = r8;
        goto L16
    }
}
