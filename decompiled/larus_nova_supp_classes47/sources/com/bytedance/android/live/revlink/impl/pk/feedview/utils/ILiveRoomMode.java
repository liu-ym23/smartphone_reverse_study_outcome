package com.bytedance.android.live.revlink.impl.pk.feedview.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/feedview/utils/ILiveRoomMode;", "", "", "value", "J", "getValue", "()J", "Normal", "ThirdParty", "Media", "Audio", "Screenshot", "Acquaintance", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ILiveRoomMode extends Enum<ILiveRoomMode> {
    public static final ILiveRoomMode Acquaintance = null;
    public static final ILiveRoomMode Audio = null;
    public static final ILiveRoomMode Media = null;
    public static final ILiveRoomMode Normal = null;
    public static final ILiveRoomMode Screenshot = null;
    public static final ILiveRoomMode ThirdParty = null;
    public static final /* synthetic */ ILiveRoomMode[] a = null;
    private final long value;

    static {
        ILiveRoomMode r1 = new ILiveRoomMode("Normal", 0, 0);
        Normal = r1;
        ILiveRoomMode r2 = new ILiveRoomMode("ThirdParty", 1, 1);
        ThirdParty = r2;
        ILiveRoomMode r3 = new ILiveRoomMode("Media", 2, 2);
        Media = r3;
        ILiveRoomMode r4 = new ILiveRoomMode("Audio", 3, 3);
        Audio = r4;
        ILiveRoomMode r5 = new ILiveRoomMode("Screenshot", 4, 4);
        Screenshot = r5;
        ILiveRoomMode r6 = new ILiveRoomMode("Acquaintance", 5, 5);
        Acquaintance = r6;
        a = new ILiveRoomMode[]{r1, r2, r3, r4, r5, r6};
    }

    public static ILiveRoomMode valueOf(String r1) {
        return (ILiveRoomMode) a.a(ILiveRoomMode.class, r1);
    }

    public static ILiveRoomMode[] values() {
        return (ILiveRoomMode[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public ILiveRoomMode(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
