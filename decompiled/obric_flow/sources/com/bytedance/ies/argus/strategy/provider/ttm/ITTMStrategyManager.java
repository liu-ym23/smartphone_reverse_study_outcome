package com.bytedance.ies.argus.strategy.provider.ttm;

import fb.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "", "", "hasInit", "()Z", "setup", "Lfb/a;", "getStrategyProvider", "()Lfb/a;", "", "codeString", "", "nativeExtendFuncAddress", "processTTMRuleByteCodeLong", "(Ljava/lang/String;J)J", "", "code", "parseTTMRuleByteCode", "([BJ)J", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ITTMStrategyManager {
    a getStrategyProvider();

    boolean hasInit();

    long parseTTMRuleByteCode(byte[] r5, long r10);

    long processTTMRuleByteCodeLong(String r5, long r10);

    boolean setup();
}
