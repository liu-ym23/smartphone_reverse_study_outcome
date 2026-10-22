package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final List<RecordingPriorityScene> a;

    public final void b() {
        a(RecordingPriorityScene.CALL_RECORD);
        Unit r0 = Unit.INSTANCE;
    }

    public final void c() {
        a(RecordingPriorityScene.D1204_CHARGING_CASE_FILE_SYNC);
        Unit r0 = Unit.INSTANCE;
    }

    public final void d() {
        a(RecordingPriorityScene.D1204_UPLOAD_WALLPAPER);
        Unit r0 = Unit.INSTANCE;
    }

    public final void e() {
        a(RecordingPriorityScene.D3200_FILE_SYNC);
        Unit r0 = Unit.INSTANCE;
    }

    public final void f() {
        a(RecordingPriorityScene.SOFTWARE_RECORDING);
        Unit r0 = Unit.INSTANCE;
    }

    public final void g() {
        a(RecordingPriorityScene.STANDALONE_AI_INTERPRETATION);
        Unit r0 = Unit.INSTANCE;
    }

    public final void h() {
        a(RecordingPriorityScene.VIDEO_CONFERENCE);
        Unit r0 = Unit.INSTANCE;
    }

    public e() {
        this.a = new ArrayList();
    }

    public final void a(RecordingPriorityScene r2) {
        this.a.add(r2);
    }
}
