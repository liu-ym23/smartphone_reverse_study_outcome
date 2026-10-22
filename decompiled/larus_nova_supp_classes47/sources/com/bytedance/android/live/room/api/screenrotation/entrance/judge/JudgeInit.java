package com.bytedance.android.live.room.api.screenrotation.entrance.judge;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class JudgeInit {
    static {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.room.api.screenrotation.entrance.judge.JudgeInit$provideLandEntranceJudges$$inlined$apply$lambda$1] */
    @JvmStatic
    public static final List<com.bytedance.android.live.room.api.screenrotation.entrance.a> a(final RoomContext r2, final DataCenter r3) {
        if (r2 == null) goto L4;
        ArrayList r0 = new ArrayList();
        ?? r1 = new JudgeInit$provideLandEntranceJudges$$inlined$apply$lambda$1(r2, r3);
        r1.invoke(r0, JudgeInit$provideLandEntranceJudges$1$2.INSTANCE);
        r1.invoke(r0, JudgeInit$provideLandEntranceJudges$1$3.INSTANCE);
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.room.api.screenrotation.entrance.judge.JudgeInit$provideSensorJudges$$inlined$apply$lambda$1] */
    @JvmStatic
    public static final List<com.bytedance.android.live.room.api.screenrotation.entrance.a> b(final RoomContext r3, final DataCenter r4, final Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "playFragArgs");
        if (r3 == null) goto L5;
        ArrayList r0 = new ArrayList();
        new JudgeInit$provideSensorJudges$$inlined$apply$lambda$1(r3, r4, r5).invoke(r0, new JudgeInit$provideSensorJudges$$inlined$apply$lambda$2(r3, r4, r5));
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }
}
