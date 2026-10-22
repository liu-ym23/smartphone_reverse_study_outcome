package com.obric.assistant.spi.mediaplay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lk9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/spi/mediaplay/IMediaPlayStateChangeListener;", "", "onMusicPlayStart", "", "shouldInterruptTutor", "", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "handleInterruptedTutor", "action", "Lkotlin/Function0;", "isReset", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMediaPlayStateChangeListener {

    public static final class a {
        public static /* synthetic */ void a(MediaPlayStateChangeUtils r2) {
            r2.c(new qga.a(), true);
        }
    }

    boolean a(g r1);

    void b();

    void c(Function0<Unit> r1, boolean r2);
}
