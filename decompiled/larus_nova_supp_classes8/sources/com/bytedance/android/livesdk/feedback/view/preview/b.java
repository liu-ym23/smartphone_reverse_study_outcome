package com.bytedance.android.livesdk.feedback.view.preview;

import android.view.View;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    void a(Function0<Unit> r1);

    void b(Function0<Unit> r1);

    void c(RoomCardStruct r1);

    RoomCardStruct getRoomInfo();

    View getView();

    void startPreview();

    void stopPreview();
}
