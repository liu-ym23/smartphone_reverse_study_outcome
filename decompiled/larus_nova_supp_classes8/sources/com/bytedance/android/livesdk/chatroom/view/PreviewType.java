package com.bytedance.android.livesdk.chatroom.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/PreviewType;", "", "UNKNOWN", "SERVER_IMAGE", "VIDEO", "LOCAL_IMAGE", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewType extends Enum<PreviewType> {
    public static final PreviewType LOCAL_IMAGE = null;
    public static final PreviewType SERVER_IMAGE = null;
    public static final PreviewType UNKNOWN = null;
    public static final PreviewType VIDEO = null;
    public static final /* synthetic */ PreviewType[] a = null;

    static {
        PreviewType r1 = new PreviewType("UNKNOWN", 0);
        UNKNOWN = r1;
        PreviewType r2 = new PreviewType("SERVER_IMAGE", 1);
        SERVER_IMAGE = r2;
        PreviewType r3 = new PreviewType("VIDEO", 2);
        VIDEO = r3;
        PreviewType r4 = new PreviewType("LOCAL_IMAGE", 3);
        LOCAL_IMAGE = r4;
        a = new PreviewType[]{r1, r2, r3, r4};
    }

    public static PreviewType valueOf(String r1) {
        return (PreviewType) r27.a.a(PreviewType.class, r1);
    }

    public static PreviewType[] values() {
        return (PreviewType[]) a.clone();
    }

    public PreviewType(String r1, int r2) {
        super(r1, r2);
    }
}
