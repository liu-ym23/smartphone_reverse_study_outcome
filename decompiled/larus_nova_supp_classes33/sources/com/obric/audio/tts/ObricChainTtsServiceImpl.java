package com.obric.audio.tts;

import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/audio/tts/ObricChainTtsServiceImpl;", "Lcom/obric/audio/tts/IObricChainTtsService;", "<init>", "()V", "startByText", "", "ttsText", "", "conversationId", "messageId", "allowDuringDora", "", "hasActiveTts", "interruptTts", WindowEvent.Params.REASON, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChainTtsServiceImpl implements IObricChainTtsService {
    public ObricChainTtsServiceImpl() {
    }

    @Override // com.obric.audio.tts.IObricChainTtsService
    public final boolean b() {
        f.a.getClass();
        q58.a r0 = f.e;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getPlayState() == AudioPlayerState.STOPPED) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.audio.tts.IObricChainTtsService
    public final void c(String r6) {
        Intrinsics.checkNotNullParameter(r6, WindowEvent.Params.REASON);
        f r1 = f.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, WindowEvent.Params.REASON);
        long r2 = f.c.incrementAndGet();
        int r0 = c68.b.a;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] interruptTts invalidate pending start latestRequestId=" + r2 + " reason=" + r6);
        r1.c(r6, true);
    }

    @Override // com.obric.audio.tts.IObricChainTtsService
    public final void a(String r17, String r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r17, "ttsText");
        Intrinsics.checkNotNullParameter(r19, "messageId");
        f r9 = f.a;
        monitor-enter(r9);
        Intrinsics.checkNotNullParameter(r17, "ttsText");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r19, "messageId");     // Catch: Throwable -> L20
        int r3 = c68.b.a;     // Catch: Throwable -> L20
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] startByText textLen=" + r17.length() + ", cid=" + r18 + ", msgId=" + r19 + ", allowDuringDora=" + r20);     // Catch: Throwable -> L20
        if (r17.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L13;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] startByText skip empty text");     // Catch: Throwable -> L20
        monitor-exit(r9);
        return;
    L13:
        if (m58.h.a != null) goto L17;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] startByText skip, audioCommonConfig is null");     // Catch: Throwable -> L20
        monitor-exit(r9);
        return;
    L17:
        long r4 = f.c.incrementAndGet();     // Catch: Throwable -> L20
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice scheduled requestId=" + r4);     // Catch: Throwable -> L20
        BuildersKt.launch$default(f.b, null, null, new ObricTtsClient$startByText$1(r4, r17, r18, r19, r20, null), 3, null);     // Catch: Throwable -> L20
        monitor-exit(r9);
        return;
    L7:
        r2 = false;
    L20:
        th = move-exception;
        throw th;
    }
}
