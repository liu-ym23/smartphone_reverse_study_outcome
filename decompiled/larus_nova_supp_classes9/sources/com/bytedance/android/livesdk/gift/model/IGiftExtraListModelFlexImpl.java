package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.GiftExtraResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftExtraListModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/o1;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/p1;", "giftExtras", "Ljava/util/List;", "getGiftExtras", "()Ljava/util/List;", "setGiftExtras", "(Ljava/util/List;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/k2;", "pageExtra", "Ljava/util/Map;", "getPageExtra", "()Ljava/util/Map;", "setPageExtra", "(Ljava/util/Map;)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/IGiftSceneConfigFlexImpl;", "sceneConfigMap$delegate", "Ljava/lang/Object;", "getSceneConfigMap", "sceneConfigMap", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftExtraListModelFlexImpl extends FlexModelBase<o1> implements o1, vh7.h {

    @SerializedName("scene_config")
    protected Map<String, IGiftSceneConfigFlexImpl> _$$sceneConfigMap;

    @SerializedName("gift_extra")
    protected List<? extends p1> giftExtras;

    @SerializedName("page_extra")
    protected Map<Long, ? extends k2> pageExtra;

    public IGiftExtraListModelFlexImpl() {
        super(o1.class);
        this.giftExtras = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
        this._$$sceneConfigMap = $defaultValue_sceneConfigMap$();
        this.pageExtra = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final Map<String, IGiftSceneConfigFlexImpl> $defaultValue_sceneConfigMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.gift.model.o1, com.bytedance.android.livesdk.gift.model.n1
    public List<p1> getGiftExtras() {
        return this.giftExtras;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o1, com.bytedance.android.livesdk.gift.model.n1
    public Map<Long, k2> getPageExtra() {
        return this.pageExtra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o1, com.bytedance.android.livesdk.gift.model.n1
    public final Map<String, IGiftSceneConfigFlexImpl> getSceneConfigMap() {
        return this._$$sceneConfigMap;
    }

    public IGiftExtraListModelFlexImpl(am3.g r18) {
        super(o1.class);
        this.giftExtras = new ArrayList();
        this._$$sceneConfigMap = new HashMap();
        this.pageExtra = new HashMap();
        setThreadSafe(false);
        long r2 = r18.c();
    L3:
        int r4 = r18.f();
        if (r4 == (-1)) goto L45;
        am3.g.a r7 = decodeExtensionFields(r4, r18);
        if (r4 != 2) goto L7;
        this.giftExtras.add(vh7.f.a(r18, p1.class));
        goto L3
    L7:
        Object r13 = null;
        if (r4 == 3) goto L28;
        if (r4 != 4) goto L11;
        long r14 = r18.c();
        Object r5 = null;
    L13:
        int r8 = r18.f();
        if (r8 == (-1)) goto L20;
        if (r8 != 1) goto L16;
        r13 = Long.valueOf(r18.j());
        goto L13
    L16:
        if (r8 != 2) goto L17;
        r5 = vh7.f.a(r18, k2.class);
        goto L13
    L17:
        am3.h.e(r18);
        goto L13
    L20:
        r18.d(r14);
        Map r6 = this.pageExtra;
        if (r13 == null) goto L27;
        if (r5 == null) goto L25;
    L39:
        r6.put(r13, r5);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.d(r7, r18);
        goto L3
    L28:
        long r15 = r18.c();
        r5 = null;
    L29:
        int r9 = r18.f();
        if (r9 == (-1)) goto L36;
        if (r9 != 1) goto L32;
        r13 = am3.h.c(r18);
        goto L29
    L32:
        if (r9 != 2) goto L33;
        r5 = new IGiftSceneConfigFlexImpl(r18);
        goto L29
    L33:
        am3.h.e(r18);
        goto L29
    L36:
        r18.d(r15);
        r6 = this._$$sceneConfigMap;
        if (r13 == null) goto L43;
        if (r5 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L45:
        r18.d(r2);
        setThreadSafe(true);
        if (this.giftExtras.isEmpty() == false) goto L49;
        this.giftExtras = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    L49:
        if (this._$$sceneConfigMap != null) goto L52;
        this._$$sceneConfigMap = $defaultValue_sceneConfigMap$();
    L52:
        if (this.pageExtra != null) goto L87;
        this.pageExtra = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
        return;
    }

    public void setGiftExtras(List<? extends p1> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftExtras = r2;
    }

    public void setPageExtra(Map<Long, ? extends k2> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageExtra = r2;
    }
}
