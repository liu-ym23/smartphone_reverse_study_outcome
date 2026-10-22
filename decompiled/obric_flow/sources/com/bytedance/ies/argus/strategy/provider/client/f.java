package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends fb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f5162a = null;

    static {
        f5162a = CollectionsKt.listOf(new String[]{"snssdk.com", "bytegecko.com", "amemv.com"});
    }

    @Override // fb.a
    public final ArgusStrategyProviderType a() {
        return ArgusStrategyProviderType.f;
    }
}
