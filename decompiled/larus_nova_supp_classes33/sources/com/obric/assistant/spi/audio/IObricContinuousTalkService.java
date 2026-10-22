package com.obric.assistant.spi.audio;

import com.larus.bmhome.chat.component.list.d;
import kotlin.Metadata;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricContinuousTalkService;", "", "tryCloseContinuousTalk", "", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "stopImmediately", "isActive", "", "interruptTTS", "isAudioPlaying", "isTtsPlayingForMessage", "messageId", "", "interruptTtsIfPlayingForMessage", "addContinuousTtsMessageIdObserver", "observer", "Lcom/obric/assistant/spi/audio/ContinuousTtsMessageIdObserver;", "removeContinuousTtsMessageIdObserver", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricContinuousTalkService {
    boolean a(String r1);

    boolean a0();

    void b();

    void c();

    void d(d r1);

    boolean e(String r1);

    void f(b r1);

    void g(b r1);

    void h(d r1);

    boolean isActive();
}
