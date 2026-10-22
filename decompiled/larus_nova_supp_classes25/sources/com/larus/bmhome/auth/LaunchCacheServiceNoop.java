package com.larus.bmhome.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/auth/LaunchCacheServiceNoop;", "Lcom/larus/bmhome/auth/ILaunchCacheService;", "<init>", "()V", "lastCachedLaunchInfo", "Lcom/larus/bmhome/auth/LaunchInfo;", "getLastCachedLaunchInfo", "()Lcom/larus/bmhome/auth/LaunchInfo;", "lastCachedConversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "getLastCachedConversationInfo", "()Lcom/larus/im/bean/conversation/Conversation;", "originCachedLaunchInfo", "getOriginCachedLaunchInfo", "getColdStartTtsType", "", "lastTouristModeInfo", "Lcom/larus/bmhome/auth/TouristModeInfo;", "getLastTouristModeInfo", "()Lcom/larus/bmhome/auth/TouristModeInfo;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LaunchCacheServiceNoop implements ILaunchCacheService {
    public LaunchCacheServiceNoop() {
    }

    public final e b() {
        return null;
    }

    public final LaunchInfo c() {
        return null;
    }

    public final LaunchInfo d() {
        return null;
    }

    public final i1 e() {
        return null;
    }

    public final int a() {
        return ColdStartTtsType.INVALID.getType();
    }
}
