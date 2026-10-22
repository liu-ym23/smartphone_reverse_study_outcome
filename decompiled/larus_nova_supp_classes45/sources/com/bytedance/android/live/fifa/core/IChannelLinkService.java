package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IChannelLinkService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/fifa/core/IChannelLinkService$ReleaseReason;", "", "Normal", "AudioSwitchClose", "RoomEnd", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ReleaseReason extends Enum<ReleaseReason> {
        public static final ReleaseReason AudioSwitchClose = null;
        public static final ReleaseReason Normal = null;
        public static final ReleaseReason RoomEnd = null;
        public static final /* synthetic */ ReleaseReason[] a = null;

        static {
            ReleaseReason r1 = new ReleaseReason("Normal", 0);
            Normal = r1;
            ReleaseReason r2 = new ReleaseReason("AudioSwitchClose", 1);
            AudioSwitchClose = r2;
            ReleaseReason r3 = new ReleaseReason("RoomEnd", 2);
            RoomEnd = r3;
            a = new ReleaseReason[]{r1, r2, r3};
        }

        public static ReleaseReason valueOf(String r1) {
            return (ReleaseReason) a.a(ReleaseReason.class, r1);
        }

        public static ReleaseReason[] values() {
            return (ReleaseReason[]) a.clone();
        }

        public ReleaseReason(String r1, int r2) {
            super(r1, r2);
        }
    }
}
