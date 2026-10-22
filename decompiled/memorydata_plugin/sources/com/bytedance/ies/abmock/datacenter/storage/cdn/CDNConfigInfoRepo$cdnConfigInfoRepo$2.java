package com.bytedance.ies.abmock.datacenter.storage.cdn;

import com.bytedance.ies.abmock.datacenter.f;
import com.bytedance.ies.abmock.datacenter.g;
import com.bytedance.ies.abmock.datacenter.storage.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CDNConfigInfoRepo$cdnConfigInfoRepo$2 extends Lambda implements Function0<e> {
    public static final CDNConfigInfoRepo$cdnConfigInfoRepo$2 INSTANCE = null;

    static {
        INSTANCE = new CDNConfigInfoRepo$cdnConfigInfoRepo$2();
    }

    CDNConfigInfoRepo$cdnConfigInfoRepo$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final e invoke() {
        e r2 = com.bytedance.ies.abmock.datacenter.e.a().c().j();
        if (ZeusTransformUtils.instanceOf(r2, f.class) == true) goto L5;
        Intrinsics.checkNotNullExpressionValue(r2, "repo");
        return (e) ZeusTransformUtils.preCheckCast(new g(r2), e.class, "com.obric.memorydata.plugin");
    L5:
        Intrinsics.checkNotNullExpressionValue(r2, "{\n             repo\n         }");
        return r2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ e invoke() {
        return invoke();
    }
}
