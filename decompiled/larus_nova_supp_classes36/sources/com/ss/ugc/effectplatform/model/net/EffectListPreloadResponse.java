package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u008f\u0001\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\t¢\u0006\u0004\b1\u00102J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\f\u001a\u00020\u0007H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0014R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0014R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0014R*\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0014¨\u00063"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/EffectListPreloadResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseMessage", "getResponseData", "", "getStatusCode", "", "checkValue", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "getPreloadEffectList", "verifySign", "preloading_effect_id_list", "Ljava/util/List;", "getPreloading_effect_id_list", "()Ljava/util/List;", "data", "getData", "setData", "(Ljava/util/List;)V", "collection", "getCollection", "setCollection", "bind_effects", "getBind_effects", "setBind_effects", "url_prefix", "getUrl_prefix", "setUrl_prefix", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "preloading_model_list", "getPreloading_model_list", "setPreloading_model_list", "Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "arithmetics", "getArithmetics", "setArithmetics", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class EffectListPreloadResponse extends e<EffectListPreloadResponse> {
    private List<? extends ModelInfo> arithmetics;
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private List<? extends Effect> data;
    private String message;
    private final List<String> preloading_effect_id_list;
    private List<String> preloading_model_list;
    private int status_code;
    private List<String> url_prefix;

    public EffectListPreloadResponse getResponseData() {
        return this;
    }

    public boolean checkValue() {
        return !this.data.isEmpty();
    }

    public final List<Effect> getPreloadEffectList() {
        ArrayList r0 = new ArrayList();
        List<? extends Effect> r1 = this.data;
        if (r1 == null) goto L5;
        r0.addAll(r1);
    L5:
        List<? extends Effect> r2 = this.collection;
        if (r2 == null) goto L8;
        r0.addAll(r2);
    L8:
        List<? extends Effect> r3 = this.bind_effects;
        if (r3 == null) goto L11;
        r0.addAll(r3);
    L11:
        return r0;
    }

    public boolean verifySign() {
        List<? extends Effect> r0 = this.data;
        if (r0 == null) goto L10;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        if (b.a((Effect) r1.next()) == true) goto L6;
        return false;
    L10:
        List<? extends Effect> r2 = this.collection;
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        if (b.a((Effect) r3.next()) == true) goto L14;
        return false;
    L18:
        List<? extends Effect> r4 = this.bind_effects;
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

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1534getResponseData() {
        return getResponseData();
    }

    public final List<ModelInfo> getArithmetics() {
        return this.arithmetics;
    }

    public final List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public final List<Effect> getCollection() {
        return this.collection;
    }

    public final List<Effect> getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<String> getPreloading_effect_id_list() {
        return this.preloading_effect_id_list;
    }

    public final List<String> getPreloading_model_list() {
        return this.preloading_model_list;
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

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final void setArithmetics(List<? extends ModelInfo> r1) {
        this.arithmetics = r1;
    }

    public final void setBind_effects(List<? extends Effect> r1) {
        this.bind_effects = r1;
    }

    public final void setCollection(List<? extends Effect> r1) {
        this.collection = r1;
    }

    public final void setData(List<? extends Effect> r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setPreloading_model_list(List<String> r1) {
        this.preloading_model_list = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public final void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public EffectListPreloadResponse(List<String> r1, List<? extends Effect> r2, List<? extends Effect> r3, List<? extends Effect> r4, List<String> r5, int r6, String r7, List<String> r8, List<? extends ModelInfo> r9) {
        this.preloading_effect_id_list = r1;
        this.data = r2;
        this.collection = r3;
        this.bind_effects = r4;
        this.url_prefix = r5;
        this.status_code = r6;
        this.message = r7;
        this.preloading_model_list = r8;
        this.arithmetics = r9;
    }

    public /* synthetic */ EffectListPreloadResponse(List r10, List r11, List r12, List r13, List r14, int r15, String r16, List r17, List r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 2) == 0) goto L5;
        List r1 = new ArrayList();
    L7:
        if ((r19 & 4) == 0) goto L9;
        List r2 = new ArrayList();
    L11:
        if ((r19 & 8) == 0) goto L13;
        List r3 = new ArrayList();
    L15:
        if ((r19 & 16) == 0) goto L17;
        List r4 = new ArrayList();
    L19:
        if ((r19 & 32) == 0) goto L21;
        int r5 = 0;
    L22:
        List r7 = null;
        if ((r19 & 64) == 0) goto L25;
        String r6 = null;
    L27:
        if ((r19 & 128) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r19 & 256) != 0) goto L34;
        r7 = r18;
    L34:
        this(r10, r1, r2, r3, r4, r5, r6, r8, r7);
        return;
    L29:
        r8 = r17;
        goto L31
    L25:
        r6 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L22
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
