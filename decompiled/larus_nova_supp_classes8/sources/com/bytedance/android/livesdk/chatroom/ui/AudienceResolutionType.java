package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/AudienceResolutionType;", "", "normal", "auto", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudienceResolutionType extends Enum<AudienceResolutionType> {
    public static final /* synthetic */ AudienceResolutionType[] a = null;
    public static final AudienceResolutionType auto = null;
    public static final AudienceResolutionType normal = null;

    static {
        AudienceResolutionType r1 = new AudienceResolutionType("normal", 0);
        normal = r1;
        AudienceResolutionType r2 = new AudienceResolutionType("auto", 1);
        auto = r2;
        a = new AudienceResolutionType[]{r1, r2};
    }

    public static AudienceResolutionType valueOf(String r1) {
        return (AudienceResolutionType) r27.a.a(AudienceResolutionType.class, r1);
    }

    public static AudienceResolutionType[] values() {
        return (AudienceResolutionType[]) a.clone();
    }

    public AudienceResolutionType(String r1, int r2) {
        super(r1, r2);
    }
}
