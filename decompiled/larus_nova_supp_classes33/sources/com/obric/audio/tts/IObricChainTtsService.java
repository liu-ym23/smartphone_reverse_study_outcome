package com.obric.audio.tts;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/obric/audio/tts/IObricChainTtsService;", "", "startByText", "", "ttsText", "", "conversationId", "messageId", "allowDuringDora", "", "hasActiveTts", "interruptTts", WindowEvent.Params.REASON, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricChainTtsService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static IObricChainTtsService a() {
            return (IObricChainTtsService) ServiceManager.get().getService(IObricChainTtsService.class, false, false);
        }
    }

    static {
        a = a.a;
    }

    void a(String r1, String r2, String r3, boolean r4);

    boolean b();

    void c(String r1);
}
