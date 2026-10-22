package com.bytedance.android.livesdk.interactivity.api.publicscreen.pin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/pin/PublicScreenPinType;", BuildConfig.FLAVOR, "ROOM_INTRO", "ROOM_NOTICE", "HOVER_MESSAGE", "MENTION_CHAT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenPinType extends Enum<PublicScreenPinType> {
    public static final PublicScreenPinType HOVER_MESSAGE = null;
    public static final PublicScreenPinType MENTION_CHAT = null;
    public static final PublicScreenPinType ROOM_INTRO = null;
    public static final PublicScreenPinType ROOM_NOTICE = null;
    public static final /* synthetic */ PublicScreenPinType[] a = null;

    static {
        PublicScreenPinType r1 = new PublicScreenPinType("ROOM_INTRO", 0);
        ROOM_INTRO = r1;
        PublicScreenPinType r2 = new PublicScreenPinType("ROOM_NOTICE", 1);
        ROOM_NOTICE = r2;
        PublicScreenPinType r3 = new PublicScreenPinType("HOVER_MESSAGE", 2);
        HOVER_MESSAGE = r3;
        PublicScreenPinType r4 = new PublicScreenPinType("MENTION_CHAT", 3);
        MENTION_CHAT = r4;
        a = new PublicScreenPinType[]{r1, r2, r3, r4};
    }

    public static PublicScreenPinType valueOf(String r1) {
        return (PublicScreenPinType) a.a(PublicScreenPinType.class, r1);
    }

    public static PublicScreenPinType[] values() {
        return (PublicScreenPinType[]) a.clone();
    }

    public PublicScreenPinType(String r1, int r2) {
        super(r1, r2);
    }
}
