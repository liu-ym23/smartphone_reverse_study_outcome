package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static void a(String r1, JsonObject r2, com.bytedance.android.live.liveinteract.jsbridge.method.l0 r3) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "updateCallback");
        }
    }

    Integer a();

    boolean c();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    int i();

    boolean k();

    void l();

    MessageHub p();

    IRoom r();

    void updateViewInLiveBg(String r1, JsonObject r2, ih0.h r3);
}
