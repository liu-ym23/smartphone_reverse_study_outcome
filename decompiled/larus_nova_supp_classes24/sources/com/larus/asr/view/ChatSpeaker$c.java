package com.larus.asr.view;

import android.content.Context;
import android.view.View;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y48.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ChatSpeaker$c implements l {
    public final /* synthetic */ ChatSpeaker a;

    @Override // y48.l
    public Context getContext() {
        return this.a.getContext();
    }

    public ChatSpeaker$c(ChatSpeaker r1) {
        this.a = r1;
    }

    @Override // y48.l
    public final View a(ChatSpeakerElementKey r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        ChatSpeaker r0 = this.a;
        int r1 = ChatSpeaker.T;
        return (View) CollectionsKt.firstOrNull(r0.n6(r3));
    }
}
