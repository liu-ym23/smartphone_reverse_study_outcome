package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "startId", "", "lastRoomId", "", "appId", "connId", "xplayGameId", "xplayRoomId", "liveScene", "invoke"}, k = 3, mv = {1, 4, 3})
final class XplayGlobalServiceImpl$notifyAudienceAppStop$1 extends Lambda implements Function7<String, Long, String, Long, String, String, String, Unit> {
    public static final XplayGlobalServiceImpl$notifyAudienceAppStop$1 INSTANCE = null;

    static {
        INSTANCE = new XplayGlobalServiceImpl$notifyAudienceAppStop$1();
    }

    public XplayGlobalServiceImpl$notifyAudienceAppStop$1() {
        super(7);
    }

    public final void invoke(String r11, long r12, String r13, long r14, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "startId");
        Intrinsics.checkNotNullParameter(r13, "appId");
        Intrinsics.checkNotNullParameter(r16, "xplayGameId");
        Intrinsics.checkNotNullParameter(r17, "xplayRoomId");
        Intrinsics.checkNotNullParameter(r18, "liveScene");
        XplayGlobalServiceImpl.o(r11, r13, r12, r14, r16, r17);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        invoke((String) r11, ((Number) r12).longValue(), (String) r13, ((Number) r14).longValue(), (String) r15, (String) r16, (String) r17);
        return Unit.INSTANCE;
    }
}
