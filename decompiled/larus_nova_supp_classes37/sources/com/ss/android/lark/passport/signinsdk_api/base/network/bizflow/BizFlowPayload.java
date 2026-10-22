package com.ss.android.lark.passport.signinsdk_api.base.network.bizflow;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\u001f\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlowPayload;", "Ljava/io/Serializable;", "uuid", "", "bizFlow", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;", "networkBizFlowInfo", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/NetworkBizFlowInfo;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/NetworkBizFlowInfo;)V", "getUuid", "()Ljava/lang/String;", "getBizFlow", "()Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;", "getNetworkBizFlowInfo", "()Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/NetworkBizFlowInfo;", "mExtra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "putExtra", "", "key", "obj", "getExtra", "T", "(Ljava/lang/String;)Ljava/io/Serializable;", "toString", "Companion", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class BizFlowPayload implements Serializable {
    public static final a Companion = null;
    public static final String EMPTY_UUID = "empty_uuid";
    public static final String KEY_BIZ_FLOW_PAYLOAD = "passport_biz_flow_payload";
    public static final String KEY_NAME = "passport_biz_flow_name";
    public static final String TAG = "Passport_BizFlowPayload";
    public static final BizFlowPayload a = null;
    public static final BizFlowPayload b = null;
    private final BizFlow bizFlow;
    private final HashMap<String, Serializable> mExtra;
    private final NetworkBizFlowInfo networkBizFlowInfo;
    private final String uuid;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BizFlowPayload a(BizFlow r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "bizFlow");
            if (r4 != null) goto L5;
            r4 = r3.getDomainPolicy().getDomain();
        L5:
            Log.i(BizFlowPayload.TAG, "create bizFlowPayload: bizFlow: " + r3.getName() + " - " + r3.getDomainPolicy().getClass().getSimpleName() + ": " + r3.getDomainPolicy().getDomain() + ", final domain: " + r4 + " fgOpen: " + r3.isFgOpen());
            return new BizFlowPayload(UUID.randomUUID().toString(), r3, new NetworkBizFlowInfo(r4), null);
        }
    }

    public /* synthetic */ BizFlowPayload(String r1, BizFlow r2, NetworkBizFlowInfo r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    @JvmStatic
    public static final BizFlowPayload create(BizFlow r1, String r2) {
        Companion.getClass();
        return a.a(r1, r2);
    }

    static {
        Companion = new a();
        BizFlowPayload r0 = new BizFlowPayload(EMPTY_UUID, EmptyBizFlow.INSTANCE, com.ss.android.lark.passport.signinsdk_api.base.network.bizflow.a.a);
        a = r0;
        b = r0;
    }

    public static final BizFlowPayload getEMPTY() {
        Companion.getClass();
        return access$getEMPTY$cp();
    }

    public static final BizFlowPayload getMAKE_SURE_NO_USE() {
        Companion.getClass();
        return access$getMAKE_SURE_NO_USE$cp();
    }

    public final String toString() {
        return "BizFlowPayload: bizFlow: " + this.bizFlow + ", NetworkInfo: " + this.networkBizFlowInfo.getDomain() + ": uuid: " + this.uuid;
    }

    public static final /* synthetic */ BizFlowPayload access$getEMPTY$cp() {
        return a;
    }

    public static final /* synthetic */ BizFlowPayload access$getMAKE_SURE_NO_USE$cp() {
        return b;
    }

    public final BizFlow getBizFlow() {
        return this.bizFlow;
    }

    public final NetworkBizFlowInfo getNetworkBizFlowInfo() {
        return this.networkBizFlowInfo;
    }

    public final String getUuid() {
        return this.uuid;
    }

    @JvmStatic
    public static final BizFlowPayload create(BizFlow r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "bizFlow");
        return a.a(r1, null);
    }

    public final <T extends Serializable> T getExtra(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Serializable r4 = this.mExtra.get(r3);     // Catch: Throwable -> L9
        if ((r4 instanceof Serializable) == false) goto L6;
        Serializable r5 = r4;     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r0 = r6;
    L16:
        return (T) r0;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void putExtra(String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 == null) goto L6;
        Serializable r4 = this.mExtra.put(r2, r3);
        return;
    }

    public BizFlowPayload(String r1, BizFlow r2, NetworkBizFlowInfo r3) {
        this.uuid = r1;
        this.bizFlow = r2;
        this.networkBizFlowInfo = r3;
        this.mExtra = new HashMap();
    }
}
