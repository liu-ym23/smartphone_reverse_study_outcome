package com.larus.voicecall.impl.continue_talk;

import com.larus.im.service.audio.cmd.TriggerMode;
import id9.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin extends com.larus.audio.call.arch.a<com.larus.voicecall.impl.plugins.r> {
    public Job f;
    public boolean g;
    public final /* synthetic */ ChatContinuousTalkComponentViewModel h;

    public static final class a extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ ChatContinuousTalkComponentViewModel b;

        public final String g() {
            return this.a;
        }

        public final void n(com.larus.im.service.audio.z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof pf9.q) == false) goto L6;
            ChatContinuousTalkComponentViewModel.access$handleTextReply(this.b, (pf9.q) r2);
            return;
        L6:
            if ((r2 instanceof pf9.z) == false) goto L9;
            final ChatContinuousTalkComponentViewModel r3 = this.b;
            ChatContinuousTalkComponentViewModel.access$setState(r3, new f1(r3));
            return;
        L9:
            if ((r2 instanceof pf9.a0) == false) goto L14;
            final ChatContinuousTalkComponentViewModel r4 = this.b;
            ChatContinuousTalkComponentViewModel.access$setState(r4, new g1(r4));
            return;
        }

        public a(ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin r1, ChatContinuousTalkComponentViewModel r2) {
            this.b = r2;
            r1.getClass();
            this.a = "ContinuousTalkComponentBizPlugin";
        }
    }

    public final String T2() {
        return "ContinuousTalkComponentBizPlugin";
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this, this.h);
    }

    public final void b3() {
        Job r0 = this.f;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public final void e3() {
        super.e3();
        this.f = BuildersKt.launch$default(ChatContinuousTalkComponentViewModel.access$getViewModelScope(this.h), null, null, new ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1(this, null), 3, null);
    }

    public ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin(ChatContinuousTalkComponentViewModel r2, com.larus.voicecall.impl.plugins.r r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.h = r2;
        super(r3);
        this.g = true;
    }

    public static final void j3(ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin r4, int r5) {
        if (r4.g == false) goto L7;
        if (r5 != 3) goto L7;
        r4.g = false;
        return;
    L7:
        if (r5 != 5) goto L12;
        d r0 = ((com.larus.voicecall.impl.plugins.r) r4.getContext()).j();
        if (r0 == null) goto L12;
        r0.p(TriggerMode.TTS_PLAYBACK_START, new JSONObject().toString());
    L12:
        if (r5 == 2) goto L15;
        if (r5 == 3) goto L15;
        return;
    L15:
        d r6 = ((com.larus.voicecall.impl.plugins.r) r4.getContext()).j();
        if (r6 == null) goto L20;
        r6.p(TriggerMode.TTS_PLAYBACK_END, new JSONObject().toString());
        return;
    }
}
