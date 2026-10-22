package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.model.i;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class ProcessRecycleDiskCache$recoveryFromCache$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ Integer $bcmChainMapSize;
    final /* synthetic */ int $chainMapSize;
    final /* synthetic */ Ref.ObjectRef $pageBufferBtm;
    final /* synthetic */ Ref.ObjectRef $pausedInfo;
    final /* synthetic */ Ref.IntRef $singletonMapSize;
    final /* synthetic */ int $unionChainMapSize;

    public ProcessRecycleDiskCache$recoveryFromCache$1(int r1, int r10, Integer r11, Ref.IntRef r12, Ref.ObjectRef r13, Ref.ObjectRef r14) {
        this.$chainMapSize = r1;
        this.$unionChainMapSize = r10;
        this.$bcmChainMapSize = r11;
        this.$singletonMapSize = r12;
        this.$pageBufferBtm = r13;
        this.$pausedInfo = r14;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m739invoke() {
        JSONObject r0 = new JSONObject();
        r0.put("chain_map_size", this.$chainMapSize);
        r0.put("union_chain_map_size", this.$unionChainMapSize);
        r0.put("bcm_chain_map_size", this.$bcmChainMapSize);
        r0.put("singleton_chain_map_size", this.$singletonMapSize.element);
        r0.put("launch_id", com.bytedance.android.btm.impl.b.d);
        r0.put("pageBufferBtm", (BufferBtm) this.$pageBufferBtm.element);
        Lazy r1 = ProcessRecycleDiskCache.a;
        r0.put("cachedInfoStack", null);
        r0.put("pausedInfo", (i) this.$pausedInfo.element);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m739invoke();
    }
}
