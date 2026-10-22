package com.bytedance.android.live.broadcastgame.opengame.cloudgame.model;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.opengame.openapi.OpenCloudGameMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/cloudgame/model/LiveCloudGameSceneType;", "", "", "isUnLimited", "Z", "()Z", "", "extra2Game", "Ljava/lang/String;", "getExtra2Game", "()Ljava/lang/String;", "", "scene", "I", "getScene", "()I", "Companion", "a", "TIME_UNLIMITED", "TIME_LIMITED", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveCloudGameSceneType extends Enum<LiveCloudGameSceneType> {
    public static final a Companion = null;
    public static final LiveCloudGameSceneType TIME_LIMITED = null;
    public static final LiveCloudGameSceneType TIME_UNLIMITED = null;
    public static final /* synthetic */ LiveCloudGameSceneType[] a = null;
    private final String extra2Game;
    private final boolean isUnLimited;
    private final int scene;

    public static final class a {
        public a() {
        }

        public static LiveCloudGameSceneType a(OpenCloudGameMethod r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "$this$getSceneTypeByOpenApi");
            LiveCloudGameSceneType[] r7 = LiveCloudGameSceneType.values();
            int r0 = r7.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            LiveCloudGameSceneType r3 = r7[r2];
            if (r3.isUnLimited() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L12;
            r2 = r2 + 1;
        L12:
            if (r3 == null) goto L14;
            return r3;
        L14:
            return LiveCloudGameSceneType.TIME_UNLIMITED;
        L7:
            r4 = false;
            goto L8
        L11:
            r3 = null;
            goto L12
        }
    }

    static {
        LiveCloudGameSceneType r7 = new LiveCloudGameSceneType("TIME_UNLIMITED", 0, true, GamePromoteDataContext.GAME_TYPE_MOBILE, 1);
        TIME_UNLIMITED = r7;
        LiveCloudGameSceneType r1 = new LiveCloudGameSceneType("TIME_LIMITED", 1, false, "0", 2);
        TIME_LIMITED = r1;
        a = new LiveCloudGameSceneType[]{r7, r1};
        Companion = new a();
    }

    public static LiveCloudGameSceneType valueOf(String r1) {
        return (LiveCloudGameSceneType) r27.a.a(LiveCloudGameSceneType.class, r1);
    }

    public static LiveCloudGameSceneType[] values() {
        return (LiveCloudGameSceneType[]) a.clone();
    }

    public final String getExtra2Game() {
        return this.extra2Game;
    }

    public final int getScene() {
        return this.scene;
    }

    public final boolean isUnLimited() {
        return this.isUnLimited;
    }

    public LiveCloudGameSceneType(String r1, int r2, boolean r3, String r4, int r5) {
        super(r1, r2);
        this.isUnLimited = r3;
        this.extra2Game = r4;
        this.scene = r5;
    }
}
