package com.ss.ugc.effectplatform.model.net;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(B-\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u0006)"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "checkValue", "", "getStatusCode", "verifySign", "", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "value", "getEffect_list", "setEffect_list", "effect_list", "getCollection_effects", "setCollection_effects", "collection_effects", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "Data", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class FetchFavoriteListResponse extends e<FetchFavoriteListResponse> {
    private List<? extends Data> data;
    private String message;
    private int status_code;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\nR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "", "type", "", "effects", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection", "bind_effects", "url_prefix", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "getCollection", "setCollection", "getEffects", "setEffects", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getUrl_prefix", "setUrl_prefix", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static class Data {
        private List<? extends Effect> bind_effects;
        private List<? extends Effect> collection;
        private List<? extends Effect> effects;
        private String type;
        private List<String> url_prefix;

        public Data() {
            this(null, null, null, null, null, 31, null);
        }

        public List<Effect> getBind_effects() {
            return this.bind_effects;
        }

        public List<Effect> getCollection() {
            return this.collection;
        }

        public List<Effect> getEffects() {
            return this.effects;
        }

        public String getType() {
            return this.type;
        }

        public List<String> getUrl_prefix() {
            return this.url_prefix;
        }

        public void setBind_effects(List<? extends Effect> r1) {
            this.bind_effects = r1;
        }

        public void setCollection(List<? extends Effect> r1) {
            this.collection = r1;
        }

        public void setEffects(List<? extends Effect> r1) {
            this.effects = r1;
        }

        public void setType(String r1) {
            this.type = r1;
        }

        public void setUrl_prefix(List<String> r1) {
            this.url_prefix = r1;
        }

        public Data(String r1, List<? extends Effect> r2, List<? extends Effect> r3, List<? extends Effect> r4, List<String> r5) {
            this.type = r1;
            this.effects = r2;
            this.collection = r3;
            this.bind_effects = r4;
            this.url_prefix = r5;
        }

        public /* synthetic */ Data(String r4, List r5, List r6, List r7, List r8, int r9, DefaultConstructorMarker r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = "";
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = new ArrayList();
        L8:
            List r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = new ArrayList();
        L11:
            List r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = new ArrayList();
        L14:
            List r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = new ArrayList();
        L17:
            String r12 = r4;
            this(r12, r11, r0, r1, r8);
        }
    }

    public FetchFavoriteListResponse() {
        this(null, null, 0, 7, null);
    }

    public FetchFavoriteListResponse getResponseData() {
        return this;
    }

    public boolean checkValue() {
        List<Data> r0 = getData();
        if (r0 != null) goto L5;
        return false;
    L5:
        return !r0.isEmpty();
    }

    public final List<Effect> getCollection_effects() {
        List<Data> r0 = getData();
        if (r0 == null) goto L7;
        return ((Data) ListProtector.get(r0, 0)).getCollection();
    L7:
        return new ArrayList();
    }

    public final List<Effect> getEffect_list() {
        List<Data> r0 = getData();
        if (r0 == null) goto L7;
        return ((Data) ListProtector.get(r0, 0)).getEffects();
    L7:
        return new ArrayList();
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1537getResponseData() {
        return getResponseData();
    }

    public String getResponseMessage() {
        return getMessage();
    }

    public int getStatusCode() {
        return getStatus_code();
    }

    public boolean verifySign() {
        List<Data> r0 = getData();
        if (r0 == null) goto L31;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L46;
        Data r2 = (Data) r1.next();
        List<Effect> r3 = r2.getBind_effects();
        if (r3 == null) goto L15;
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        if (b.a((Effect) r4.next()) == true) goto L11;
        return false;
    L15:
        List<Effect> r5 = r2.getEffects();
        if (r5 == null) goto L23;
        Iterator<T> r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        if (b.a((Effect) r6.next()) == true) goto L19;
        return false;
    L23:
        List<Effect> r7 = r2.getCollection();
        if (r7 == null) goto L6;
        Iterator<T> r8 = r7.iterator();
    L27:
        if (r8.hasNext() == false) goto L6;
        if (b.a((Effect) r8.next()) == true) goto L27;
        return false;
    L46:
        return true;
    L31:
        return true;
    }

    public List<Data> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public final void setCollection_effects(List<? extends Effect> r12) {
        List<Data> r0 = getData();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        setData(CollectionsKt.arrayListOf(new Data[]{new Data(null, null, null, null, null, 31, null)}));
    L11:
        ((Data) ListProtector.get(getData(), 0)).setCollection(r12);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public void setData(List<? extends Data> r1) {
        this.data = r1;
    }

    public final void setEffect_list(List<? extends Effect> r12) {
        List<Data> r0 = getData();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        setData(CollectionsKt.arrayListOf(new Data[]{new Data(null, null, null, null, null, 31, null)}));
    L11:
        ((Data) ListProtector.get(getData(), 0)).setEffects(r12);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public FetchFavoriteListResponse(List<? extends Data> r1, String r2, int r3) {
        this.data = r1;
        this.message = r2;
        this.status_code = r3;
    }

    public /* synthetic */ FetchFavoriteListResponse(List r1, String r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = new ArrayList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = 0;
    L11:
        this(r1, r2, r3);
    }
}
