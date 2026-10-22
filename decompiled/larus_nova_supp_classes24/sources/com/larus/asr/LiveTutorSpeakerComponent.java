package com.larus.asr;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.session.ComponentAsrSession;
import com.larus.asr.session.LiveTutorAsrOnlySession;
import com.larus.asr.session.LiveTutorAsrOnlySessionV2;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.asr.c0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import va8.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016JB\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/asr/LiveTutorSpeakerComponent;", "Lcom/larus/asr/ChatBottomSpeakerComponent;", "Lcom/larus/bmhome/ability/ILiveTutorAsrAbility;", "<init>", "()V", "onAttach", "", "handleTouchAction", "action", "", "globalX", "", "globalY", "deltaX", "deltaY", "createAsrSession", "Lkotlin/Triple;", "Lcom/larus/asr/session/IFlowAsrSession;", "", "fromTextArea", "traceInfo", "Lcom/larus/audio/asr/AsrTraceInfo;", "asrTaskId", "", "voiceInputType", "Lcom/larus/asr/VoiceInputType;", "asrOnly", "enableSpeakerHandleTouch", "setAudioVolume", "volume", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class LiveTutorSpeakerComponent extends ChatBottomSpeakerComponent implements i0 {

    public static final class a {
    }

    static {
    }

    public final boolean N70() {
        return true;
    }

    public final void y2() {
        super.y2();
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, i0.class);
    }

    public LiveTutorSpeakerComponent() {
    }

    public void ea(float r4) {
        FLogger.a.i("setAudioVolume", "volume:" + r4);
        ChatSpeaker r0 = a4();
        if (r0 == null) goto L6;
        r0.e8(LifecycleOwnerKt.getLifecycleScope(this), r4);
        return;
    }

    public Triple<com.larus.asr.session.o, Boolean, Boolean> V3(boolean r3, c0 r4, String r5, VoiceInputType r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "traceInfo");
        Intrinsics.checkNotNullParameter(r5, "asrTaskId");
        Intrinsics.checkNotNullParameter(r6, "voiceInputType");
        final com.larus.asr.session.g r8 = (com.larus.asr.session.g) ((ChatBottomSpeakerComponent) this).t.getValue();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Intrinsics.checkNotNullParameter(r6, "voiceInputType");
        if (com.larus.platform.service.z2.a.asrSessionComponentSplit() == false) goto L5;
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        Object r10 = new LiveTutorAsrOnlySessionV2(r8.a, r5, r6, new com.larus.asr.session.a(r8, r9));
        r9.element = r10;
    L7:
        if ((r10 instanceof ComponentAsrSession) == false) goto L9;
        ComponentAsrSession r11 = (ComponentAsrSession) r10;
    L10:
        r8.b = r11;
        Boolean r12 = Boolean.TRUE;
        return new Triple(r10, r12, r12);
    L9:
        r11 = null;
        goto L10
    L5:
        r10 = new LiveTutorAsrOnlySession(r8.a, r5, r6);
        goto L7
    }

    public final void pv(int r1, float r2, float r3, float r4, float r5) {
        super.pv(r1, r2, r3, r4, r5);
        FLogger r6 = FLogger.a;
        r6.e("LiveTutorSpeakerComponent", "handleTouchAction: action = " + r1);
        if (r1 != (-1)) goto L8;
        com.larus.bmhome.chat.component.bottom.core.speaker.g r7 = new com.larus.bmhome.chat.component.bottom.core.speaker.g.e("", null, 6);
        Intrinsics.checkNotNullParameter(r7, "state");
        r6.i("ChatBottomSpeakerComponent", "notifyStateChanged state: " + com.larus.bmhome.chat.component.bottom.core.speaker.g.e.class);
        com.larus.asr.session.o r8 = ((ChatBottomSpeakerComponent) this).s;
        if (r8 == null) goto L9;
        r8.oa(r7);
        return;
    L9:
        return;
    }
}
