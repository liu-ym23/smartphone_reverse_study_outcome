package com.bytedance.ies.argus.strategy.provider.ttm;

import com.tiktok.ttm.TTMCore;
import gb.a;
import gb.b;
import jm.c;
import k5.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyManager;", "Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "<init>", "()V", "", "hasInit", "()Z", "setup", "Lfb/a;", "getStrategyProvider", "()Lfb/a;", "", "codeString", "", "nativeExtendFuncAddress", "processTTMRuleByteCodeLong", "(Ljava/lang/String;J)J", "", "code", "parseTTMRuleByteCode", "([BJ)J", "Lgb/b;", "strategyProvider", "Lgb/b;", "Companion", "gb/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TTMStrategyManager implements ITTMStrategyManager {
    public static final a Companion = null;
    public static final String TAG = "TTMStrategyManager";
    private final b strategyProvider;

    static {
        Companion = new a();
    }

    public TTMStrategyManager() {
        this.strategyProvider = new b();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public fb.a getStrategyProvider() {
        return this.strategyProvider;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public boolean hasInit() {
        return TTMCore.getInstance().isInit();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public long parseTTMRuleByteCode(byte[] r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "code");
        return TTMCore.getInstance().parseTTMRuleByteCode(r5, r10);
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public long processTTMRuleByteCodeLong(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "codeString");
        return TTMCore.getInstance().parseTTMRuleByteCode(r5, r10);
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public boolean setup() {
        Lazy r5 = com.bytedance.ies.argus.base.a.f5012b;
        c.b().getClass();
        d.g(TAG, "init ttm error: application is null", null, 12);
        boolean r10 = hasInit();
        if (r10 == true) goto L5;
        d.g(TAG, "ttm init failed", null, 12);
    L5:
        return r10;
    }
}
