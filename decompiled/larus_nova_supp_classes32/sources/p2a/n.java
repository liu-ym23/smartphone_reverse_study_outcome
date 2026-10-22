package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.tts.impl.ChatTitleTtsComponent;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import w2a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements f {
    public n() {
    }

    public final Object F1(f r1, String r2, Continuation<? super SpeakerVoice> r3) {
        return null;
    }

    public final void N(ChatTitleTtsComponent.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void O(ChatTitleTtsComponent.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void R(String r1, String r2) {
    }

    public final void Z() {
    }

    public final void b2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "languageCode");
    }

    public final void d1(k r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "param");
    }

    public final List<SpeakerVoice> D1() {
        return CollectionsKt.emptyList();
    }

    public final Object y2(f r7, String r8, String r9, String r10, Continuation<? super m<SpeakerVoice>> r11) {
        return new j(-1, "Ugc voice service unavailable", null, null);
    }
}
