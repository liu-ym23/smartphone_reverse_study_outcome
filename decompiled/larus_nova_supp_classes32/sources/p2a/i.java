package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.tts.impl.ChatTitleTtsComponent;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;
import w2a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements f {
    public static final i b = null;
    public static final n c = null;

    public i() {
    }

    static {
        b = new i();
        c = new n();
    }

    public static f u() {
        b r0 = c.a;
        f r1 = c.a(Reflection.getOrCreateKotlinClass(f.class));
        if (r1 == null) goto L5;
        return r1;
    L5:
        return c;
    }

    public final List<SpeakerVoice> D1() {
        return u().D1();
    }

    public final void Z() {
        u().Z();
    }

    public final void N(ChatTitleTtsComponent.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        u().N(r2);
    }

    public final void O(ChatTitleTtsComponent.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        u().O(r2);
    }

    public final void b2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "languageCode");
        u().b2(r2);
    }

    public final void R(String r2, String r3) {
        u().R(r2, r3);
    }

    public final void d1(k r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "param");
        u().d1(r2, r3);
    }

    public final Object F1(f r2, String r3, Continuation<? super SpeakerVoice> r4) {
        return u().F1(r2, r3, r4);
    }

    public final Object y2(f r7, String r8, String r9, String r10, Continuation<? super m<SpeakerVoice>> r11) {
        return u().y2(r7, r8, r9, r10, r11);
    }
}
