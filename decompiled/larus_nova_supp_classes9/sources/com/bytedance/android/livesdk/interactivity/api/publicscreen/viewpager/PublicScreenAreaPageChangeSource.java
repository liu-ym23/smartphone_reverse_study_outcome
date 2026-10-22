package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageChangeSource;", BuildConfig.FLAVOR, "Init", "Manual", "PublicScreenComment", "ChannelCreate", "ChannelJoin", "ChannelReplyJoin", "ChannelQuit", "ManageDialog", "SecretChat", "TabClick", "PageInvalid", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenAreaPageChangeSource extends Enum<PublicScreenAreaPageChangeSource> {
    public static final PublicScreenAreaPageChangeSource ChannelCreate = null;
    public static final PublicScreenAreaPageChangeSource ChannelJoin = null;
    public static final PublicScreenAreaPageChangeSource ChannelQuit = null;
    public static final PublicScreenAreaPageChangeSource ChannelReplyJoin = null;
    public static final PublicScreenAreaPageChangeSource Init = null;
    public static final PublicScreenAreaPageChangeSource ManageDialog = null;
    public static final PublicScreenAreaPageChangeSource Manual = null;
    public static final PublicScreenAreaPageChangeSource PageInvalid = null;
    public static final PublicScreenAreaPageChangeSource PublicScreenComment = null;
    public static final PublicScreenAreaPageChangeSource SecretChat = null;
    public static final PublicScreenAreaPageChangeSource TabClick = null;
    public static final /* synthetic */ PublicScreenAreaPageChangeSource[] a = null;

    static {
        PublicScreenAreaPageChangeSource r1 = new PublicScreenAreaPageChangeSource("Init", 0);
        Init = r1;
        PublicScreenAreaPageChangeSource r2 = new PublicScreenAreaPageChangeSource("Manual", 1);
        Manual = r2;
        PublicScreenAreaPageChangeSource r3 = new PublicScreenAreaPageChangeSource("PublicScreenComment", 2);
        PublicScreenComment = r3;
        PublicScreenAreaPageChangeSource r4 = new PublicScreenAreaPageChangeSource("ChannelCreate", 3);
        ChannelCreate = r4;
        PublicScreenAreaPageChangeSource r5 = new PublicScreenAreaPageChangeSource("ChannelJoin", 4);
        ChannelJoin = r5;
        PublicScreenAreaPageChangeSource r6 = new PublicScreenAreaPageChangeSource("ChannelReplyJoin", 5);
        ChannelReplyJoin = r6;
        PublicScreenAreaPageChangeSource r7 = new PublicScreenAreaPageChangeSource("ChannelQuit", 6);
        ChannelQuit = r7;
        PublicScreenAreaPageChangeSource r8 = new PublicScreenAreaPageChangeSource("ManageDialog", 7);
        ManageDialog = r8;
        PublicScreenAreaPageChangeSource r9 = new PublicScreenAreaPageChangeSource("SecretChat", 8);
        SecretChat = r9;
        PublicScreenAreaPageChangeSource r10 = new PublicScreenAreaPageChangeSource("TabClick", 9);
        TabClick = r10;
        PublicScreenAreaPageChangeSource r11 = new PublicScreenAreaPageChangeSource("PageInvalid", 10);
        PageInvalid = r11;
        a = new PublicScreenAreaPageChangeSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public static PublicScreenAreaPageChangeSource valueOf(String r1) {
        return (PublicScreenAreaPageChangeSource) r27.a.a(PublicScreenAreaPageChangeSource.class, r1);
    }

    public static PublicScreenAreaPageChangeSource[] values() {
        return (PublicScreenAreaPageChangeSource[]) a.clone();
    }

    public PublicScreenAreaPageChangeSource(String r1, int r2) {
        super(r1, r2);
    }
}
