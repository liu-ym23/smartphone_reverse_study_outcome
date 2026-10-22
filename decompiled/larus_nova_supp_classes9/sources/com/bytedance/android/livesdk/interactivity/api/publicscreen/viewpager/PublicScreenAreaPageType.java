package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageType;", BuildConfig.FLAVOR, "PublicScreen", "ChatChannel", "Square", "Empty", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenAreaPageType extends Enum<PublicScreenAreaPageType> {
    public static final PublicScreenAreaPageType ChatChannel = null;
    public static final PublicScreenAreaPageType Empty = null;
    public static final PublicScreenAreaPageType PublicScreen = null;
    public static final PublicScreenAreaPageType Square = null;
    public static final /* synthetic */ PublicScreenAreaPageType[] a = null;

    static {
        PublicScreenAreaPageType r1 = new PublicScreenAreaPageType("PublicScreen", 0);
        PublicScreen = r1;
        PublicScreenAreaPageType r2 = new PublicScreenAreaPageType("ChatChannel", 1);
        ChatChannel = r2;
        PublicScreenAreaPageType r3 = new PublicScreenAreaPageType("Square", 2);
        Square = r3;
        PublicScreenAreaPageType r4 = new PublicScreenAreaPageType("Empty", 3);
        Empty = r4;
        a = new PublicScreenAreaPageType[]{r1, r2, r3, r4};
    }

    public static PublicScreenAreaPageType valueOf(String r1) {
        return (PublicScreenAreaPageType) r27.a.a(PublicScreenAreaPageType.class, r1);
    }

    public static PublicScreenAreaPageType[] values() {
        return (PublicScreenAreaPageType[]) a.clone();
    }

    public PublicScreenAreaPageType(String r1, int r2) {
        super(r1, r2);
    }
}
