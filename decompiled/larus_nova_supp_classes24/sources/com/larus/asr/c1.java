package com.larus.asr;

import com.larus.asr.handsfree.HandsfreeDirectEntry;
import com.larus.asr.view.ChatSpeaker;
import com.larus.platform.model.HandsfreeExperimentConfig;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c1 implements Function2 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ ChatSpeaker b;
    public final /* synthetic */ HandsfreeDirectEntry c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ HandsfreeExperimentConfig f;

    public /* synthetic */ c1(ChatBottomSpeakerComponent r1, ChatSpeaker r2, HandsfreeDirectEntry r3, String r4, String r5, HandsfreeExperimentConfig r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r8, Object r9) {
        ChatBottomSpeakerComponent r0 = this.a;
        ChatSpeaker r1 = this.b;
        HandsfreeDirectEntry r2 = this.c;
        String r3 = this.d;
        String r4 = this.e;
        HandsfreeExperimentConfig r5 = this.f;
        boolean r6 = ((Boolean) r8).booleanValue();
        ((Boolean) r9).booleanValue();
        return ChatBottomSpeakerComponent.p3(r0, r1, r2, r3, r4, r5, r6);
    }
}
