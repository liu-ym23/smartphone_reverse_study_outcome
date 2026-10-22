package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends fb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5158a;

    public /* synthetic */ a(int r5) {
        this.f5158a = r5;
    }

    @Override // fb.a
    public final ArgusStrategyProviderType a() {
        switch(this.f5158a) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return ArgusStrategyProviderType.f5088l;
    L7:
        return ArgusStrategyProviderType.f5082b;
    L9:
        return ArgusStrategyProviderType.f5089m;
    L11:
        return ArgusStrategyProviderType.f5085i;
    L13:
        return ArgusStrategyProviderType.f5087k;
    L15:
        return ArgusStrategyProviderType.f5086j;
    L17:
        return ArgusStrategyProviderType.d;
    }
}
