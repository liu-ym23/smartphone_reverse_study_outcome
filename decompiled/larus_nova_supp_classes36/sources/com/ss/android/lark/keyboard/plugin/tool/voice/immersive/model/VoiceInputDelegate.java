package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import com.ss.android.lark.audio.voiceinput.CancelAsrTimeoutState;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.VoiceInputService;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import com.ss.android.lark.audio.voiceinput.p;
import com.ss.android.lark.audio.voiceinput.processor.VoiceDataProcessDispatcher;
import com.ss.android.lark.audio.voiceinput.q;
import com.ss.android.lark.audio.voiceinput.s;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceInputDelegate {
    public static final /* synthetic */ int p = 0;
    public VoiceInputService a;
    public final CopyOnWriteArrayList<q> b;
    public String c;
    public final AtomicInteger d;
    public com.ss.android.lark.audio.voiceinput.j e;
    public com.ss.android.lark.audio.voiceinput.i f;
    public boolean g;
    public UserSearchAndMatchStrategy h;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.a i;
    public final com.ss.android.lark.audio.voiceinput.k j;
    public final com.ss.android.lark.audio.voiceinput.l k;
    public g l;
    public String m;
    public final c n;
    public final VoiceInputDelegate$_asrResultListenerWrapper$1 o;

    public static final class a {
    }

    public static final class b implements KeyboardVoiceModule.b {
        public b() {
        }
    }

    public static final class c implements com.ss.android.lark.audio.voiceinput.j {
        public final /* synthetic */ VoiceInputDelegate a;

        public final void c() {
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        public final void d() {
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.d();
            return;
        }

        public c(VoiceInputDelegate r1) {
            this.a = r1;
        }

        public final void b(s r4) {
            Intrinsics.checkNotNullParameter(r4, "voiceRecordEntity");
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.b(r4);
        L5:
            q r1 = (q) CollectionsKt.lastOrNull(this.a.b);
            if (r1 == null) goto L22;
            VoiceInputDelegate r2 = this.a;
            r1.a = r4;
            VoiceInputService r5 = r2.a;
            String r3 = null;
            if (r5 == null) goto L12;
            VoiceDataProcessDispatcher r6 = r5.c;
            if (r6 == null) goto L12;
            String r7 = r6.i();
        L13:
            r1.c = r7;
            VoiceInputService r8 = r2.a;
            if (r8 == null) goto L16;
            com.ss.android.lark.audio.voiceinput.utils.a r9 = r8.d;
        L17:
            r1.b = r9;
            if (r8 == null) goto L20;
            r3 = r8.k;
        L20:
            r1.h = r3;
            return;
        L16:
            r9 = null;
        L12:
            r7 = null;
            goto L13
        }

        public final void e(s r4) {
            Intrinsics.checkNotNullParameter(r4, "voiceRecordEntity");
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.e(r4);
        L5:
            q r1 = (q) CollectionsKt.lastOrNull(this.a.b);
            if (r1 == null) goto L22;
            VoiceInputDelegate r2 = this.a;
            r1.a = r4;
            VoiceInputService r5 = r2.a;
            String r3 = null;
            if (r5 == null) goto L12;
            VoiceDataProcessDispatcher r6 = r5.c;
            if (r6 == null) goto L12;
            String r7 = r6.i();
        L13:
            r1.c = r7;
            VoiceInputService r8 = r2.a;
            if (r8 == null) goto L16;
            com.ss.android.lark.audio.voiceinput.utils.a r9 = r8.d;
        L17:
            r1.b = r9;
            if (r8 == null) goto L20;
            r3 = r8.k;
        L20:
            r1.h = r3;
            return;
        L16:
            r9 = null;
        L12:
            r7 = null;
            goto L13
        }

        public final void g(s r4) {
            Intrinsics.checkNotNullParameter(r4, "voiceRecordEntity");
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.g(r4);
        L5:
            q r1 = (q) CollectionsKt.lastOrNull(this.a.b);
            if (r1 == null) goto L22;
            VoiceInputDelegate r2 = this.a;
            r1.a = r4;
            VoiceInputService r5 = r2.a;
            String r3 = null;
            if (r5 == null) goto L12;
            VoiceDataProcessDispatcher r6 = r5.c;
            if (r6 == null) goto L12;
            String r7 = r6.i();
        L13:
            r1.c = r7;
            VoiceInputService r8 = r2.a;
            if (r8 == null) goto L16;
            com.ss.android.lark.audio.voiceinput.utils.a r9 = r8.d;
        L17:
            r1.b = r9;
            if (r8 == null) goto L20;
            r3 = r8.k;
        L20:
            r1.h = r3;
            return;
        L16:
            r9 = null;
        L12:
            r7 = null;
            goto L13
        }

        public final void a(int r2, boolean r3) {
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }

        public final void f(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorMsg");
            com.ss.android.lark.audio.voiceinput.j r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.f(r2, r3);
            return;
        }
    }

    static {
    }

    public final void c() {
        this.d.set(0);
        this.b.clear();
        VoiceInputService r0 = this.a;
        if (r0 == null) goto L11;
        com.ss.android.lark.audio.voiceinput.d r3 = r0.b;
        if (r3 == null) goto L7;
        r3.h.a();
        r3.a.onDestroy();
    L7:
        VoiceDataProcessDispatcher r4 = r0.c;
        if (r4 == null) goto L10;
        r4.onDestroy();
    L10:
        r0.g();
        r0.g = AsrSessionState.AsrSessionIdle;
        r0.h = null;
        r0.i = 0;
    L11:
        UserSearchAndMatchStrategy r1 = this.h;
        if (r1 == null) goto L14;
        r1.c();
    L14:
        this.a = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.l = null;
    }

    public final String d() {
        q r0 = (q) CollectionsKt.firstOrNull(this.b);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.VoiceInputDelegate$_asrResultListenerWrapper$1] */
    public VoiceInputDelegate() {
        this.b = new CopyOnWriteArrayList();
        this.c = "";
        this.d = new AtomicInteger(0);
        this.i = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.a();
        this.j = new com.ss.android.lark.audio.voiceinput.k();
        this.k = new com.ss.android.lark.audio.voiceinput.l();
        this.m = "";
        this.n = new c(this);
        this.o = new VoiceInputDelegate$_asrResultListenerWrapper$1(this);
        new b();
    }

    public static boolean f(String r1) {
        if (Intrinsics.areEqual(r1, VoiceInputScene.EnterpriseAnswer.toString()) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, VoiceInputScene.CcmComment.toString()) == true) goto L8;
        return false;
    }

    public final void b(boolean r3) {
        if (r3 == false) goto L4;
        this.d.set(0);
        this.b.clear();
        this.c = "";
        return;
    L4:
        Iterator<T> r4 = this.b.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        q r0 = (q) r4.next();
        r0.b = null;
        r0.a = null;
        goto L6
    }

    public final boolean g(p r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "voiceInputMode");
        if (KeyboardVoiceFGUtils.a.f() == true) goto L5;
    L6:
        if (r6 == null) goto L8;
        this.c = r6;
    L8:
        this.b.clear();
        this.d.set(0);
    L9:
        q r0 = (q) CollectionsKt.lastOrNull(this.b);
        if (r0 == null) goto L12;
        r0.g = r6;
    L12:
        this.b.add(new q(0));
        q r1 = (q) CollectionsKt.lastOrNull(this.b);
        if (r1 == null) goto L15;
        r1.f = r6;
    L15:
        this.d.incrementAndGet();
        VoiceInputService r7 = this.a;
        if (r7 == null) goto L26;
        r7.j = null;
        r7.f = null;
        VoiceDataProcessDispatcher r2 = r7.c;
        if (r2 == null) goto L20;
        r2.b();
    L20:
        r7.d.c();
        r7.h = null;
        r7.i = 0;
        if (r7.e(r4, this.i.b(), r5) == true) goto L23;
        return false;
    L23:
        r7.b(CancelAsrTimeoutState.CancelByReset, false, null);
        KeyboardVoiceModule.a().getVcDependency().b();
        return true;
    L26:
        return true;
    L5:
        if (r4.a == VoiceInputMode.SecondVoice) goto L9;
        goto L6
    }

    public final Pair<RichText, SpannableStringBuilder> a(String r2, List<com.ss.android.lark.audio.voiceinput.a> r3, int r4, Function2<? super String, ? super Integer, ? extends SpannableStringBuilder> r5) {
        UserSearchAndMatchStrategy r0 = this.h;
        if (r0 == null) goto L6;
        return r0.a(r2, r3, r4, r5);
    L6:
        return new Pair(new RichText(), null);
    }

    public final void e(CoroutineScope r21, final IAudioService r22, com.ss.android.lark.audio.voiceinput.service.l r23, com.ss.android.lark.audio.voiceinput.service.o r24, com.ss.android.lark.audio.voiceinput.h r25, String r26, String r27, String r28, String r29, boolean r30, boolean r31, boolean r32, boolean r33, com.ss.android.lark.audio.voiceinput.j r34, com.ss.android.lark.audio.voiceinput.i r35, KeyboardVoiceModule.b r36, final Function1<? super ChatChatter, String> r37, final Function4<? super String, ? super String, ? super String, ? super Boolean, ? extends ccb.d> r38, VoiceInputSpeechScene r39, boolean r40) {
        final VoiceInputDelegate r0 = this;
        Intrinsics.checkNotNullParameter(r21, "viewModelScope");
        Intrinsics.checkNotNullParameter(r22, "audioService");
        Intrinsics.checkNotNullParameter(r23, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r24, "speechRecognitionEventPush");
        Intrinsics.checkNotNullParameter(r25, "audioResourceMutex");
        Intrinsics.checkNotNullParameter(r26, "appLocale");
        Intrinsics.checkNotNullParameter(r27, "chatId");
        Intrinsics.checkNotNullParameter(r28, "scene");
        Intrinsics.checkNotNullParameter(r29, "psdaToken");
        Intrinsics.checkNotNullParameter(r34, "voiceRecordListener");
        Intrinsics.checkNotNullParameter(r35, "voiceDataAsrListener");
        Intrinsics.checkNotNullParameter(r36, "vcMeetingStatsListener");
        if (r0.a != null) goto L5;
        VoiceInputService r2 = new VoiceInputService(new com.ss.android.lark.audio.voiceinput.processor.h(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r0.n, r0.o, r39, r40));
        r2.d();
        r0 = this;
        r0.a = r2;
    L5:
        r0.e = r34;
        r0.f = r35;
        r0.g = r31;
        r0.m = r28;
        if (r31 == true) goto L8;
        return;
    L8:
        if (r27.length() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        MatchMode r3 = MatchMode.ServerMode;
    L14:
        boolean r4 = f(r0.m);
        r0.h = new UserSearchAndMatchStrategy(r21, r27, new VoiceInputDelegate$init$2(r37), new VoiceInputDelegate$init$3(r38), new VoiceInputDelegate$init$4(r0), new VoiceInputDelegate$init$5(r22), r3, r4);
        return;
    L13:
        r3 = MatchMode.ServerWithClientMode;
        goto L14
    L10:
        r1 = false;
        goto L11
    }
}
