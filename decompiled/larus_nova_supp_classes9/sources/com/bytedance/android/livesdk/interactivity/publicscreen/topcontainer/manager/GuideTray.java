package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/manager/GuideTray;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "priority", "I", "getPriority", "()I", "HotMsgGather", "BusinessMsg", "ChatCarnival", "LikeEgg", "Confront", "MatchDynamicHotMsg", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GuideTray extends Enum<GuideTray> {
    public static final GuideTray BusinessMsg = null;
    public static final GuideTray ChatCarnival = null;
    public static final GuideTray Confront = null;
    public static final GuideTray HotMsgGather = null;
    public static final GuideTray LikeEgg = null;
    public static final GuideTray MatchDynamicHotMsg = null;
    public static final /* synthetic */ GuideTray[] a = null;
    private final int priority;

    static {
        GuideTray r7 = new GuideTray("HotMsgGather", 0, 0, 1, null);
        HotMsgGather = r7;
        GuideTray r1 = new GuideTray("BusinessMsg", 1, 0, 1, null);
        BusinessMsg = r1;
        int r6 = 0;
        int r8 = 1;
        DefaultConstructorMarker r9 = null;
        GuideTray r2 = new GuideTray("ChatCarnival", 2, r6, r8, r9);
        ChatCarnival = r2;
        GuideTray r3 = new GuideTray("LikeEgg", 3, r6, r8, r9);
        LikeEgg = r3;
        GuideTray r4 = new GuideTray("Confront", 4, 100);
        Confront = r4;
        GuideTray r5 = new GuideTray("MatchDynamicHotMsg", 5, 99);
        MatchDynamicHotMsg = r5;
        a = new GuideTray[]{r7, r1, r2, r3, r4, r5};
    }

    public static GuideTray valueOf(String r1) {
        return (GuideTray) r27.a.a(GuideTray.class, r1);
    }

    public static GuideTray[] values() {
        return (GuideTray[]) a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public GuideTray(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }

    public /* synthetic */ GuideTray(String r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }
}
