package com.bytedance.android.live.liveinteract.voicechat.emoji.sound;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.j;
import com.bytedance.android.live.soloktv.IPlatformSoloKtvService;
import com.bytedance.android.livesdk.message.model.w8;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.Error;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import uf2.d0;
import wj0.e;
import wj0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class EmojiSoundManager {
    public static final /* synthetic */ int i = 0;
    public TTVideoEngine a;
    public boolean b;
    public com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b c;
    public final CompositeDisposable d;
    public final ArrayList<hj0.a> e;
    public final Context f;
    public final boolean g;
    public final com.bytedance.android.live.pushstream.d h;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwj0/e;", "p1", "", "invoke", "(Lwj0/e;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<e, Unit> {
        public AnonymousClass1(EmojiSoundManager r8) {
            super(1, r8, EmojiSoundManager.class, "onTalkRoomEmojiEvent", "onTalkRoomEmojiEvent(Lcom/bytedance/android/live/liveinteract/videotalk/emoji/widget/TalkRoomEmojiEvent;)V", 0);
        }

        public final void invoke(e r5) {
            Intrinsics.checkNotNullParameter(r5, "p1");
            EmojiSoundManager r0 = (EmojiSoundManager) ((CallableReference) this).receiver;
            int r1 = EmojiSoundManager.i;
            r0.getClass();
            String r2 = r5.b.emojiSoundUrl;
            com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b r3 = r0.c;
            if (r3 == null) goto L5;
            String r4 = r3.b;
        L7:
            if (Intrinsics.areEqual(r2, r4) == true) goto L9;
            return;
        L9:
            if (r5.c == false) goto L11;
            ALogger.i("emoji_sound", "intercept stop emoji sound " + r5.b.emojiName);
            return;
        L11:
            int r6 = r5.a;
            if (r6 != 2) goto L14;
        L15:
            ALogger.i("emoji_sound", "same emoji state=" + r5.a + " of " + r5.b.emojiName + " stopAudio");
            r0.f();
            return;
        L14:
            if (r6 == 3) goto L15;
            return;
        L5:
            r4 = null;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((e) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwj0/f;", "p1", "", "invoke", "(Lwj0/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<f, Unit> {
        public AnonymousClass2(EmojiSoundManager r8) {
            super(1, r8, EmojiSoundManager.class, "onTalkRoomSoundEvent", "onTalkRoomSoundEvent(Lcom/bytedance/android/live/liveinteract/videotalk/emoji/widget/TalkRoomSoundEvent;)V", 0);
        }

        public final void invoke(f r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            EmojiSoundManager r0 = (EmojiSoundManager) ((CallableReference) this).receiver;
            int r1 = EmojiSoundManager.i;
            r0.getClass();
            String r2 = r4.a;
            com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b r3 = r0.c;
            if (r3 == null) goto L5;
            String r5 = r3.a;
        L7:
            if (Intrinsics.areEqual(r2, r5) == true) goto L9;
            return;
        L9:
            if (r4.c == false) goto L11;
            ALogger.i("emoji_sound", "intercept stop emoji sound " + r4);
            return;
        L11:
            r0.f();
            return;
        L5:
            r5 = null;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((f) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.liveinteract.voicechat.emoji.sound.a {
        public final /* synthetic */ EmojiSoundManager a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.c = null;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager$b$b, reason: collision with other inner class name */
        public static final class RunnableC0107b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ Error b;

            public RunnableC0107b(b r1, Error r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                String r1 = null;
                this.a.a.c = null;
                ALogger.e("emoji_sound", "audienceAudioPlayer error " + this.b);
                int r0 = com.bytedance.android.live.liveinteract.voicechat.emoji.b.a;
                com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b r2 = this.a.a.c;
                if (r2 == null) goto L5;
                r1 = r2.b;
            L5:
                Error r3 = this.b;
                int r4 = r3.code;
                String r5 = r3.toString();
                Intrinsics.checkNotNullParameter(r5, "errorMsg");
                if (hd0.c.f().g() == true) goto L12;
                if (r1 != null) goto L10;
                r1 = "";
            L10:
                int r6 = x.a;
                Intrinsics.checkNotNullParameter(r1, "url");
                Intrinsics.checkNotNullParameter(r5, "errorMsg");
                LinkedHashMap r7 = new LinkedHashMap();
                r7.put("url", r1);
                r7.put("error_code", Integer.valueOf(r4));
                r7.put("error_msg", r5);
                x.v0("emoji_sound_error", r7);
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(EmojiSoundManager r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r2) {
            Intrinsics.checkNotNullParameter(r2, "engine");
            AndroidSchedulers.mainThread().scheduleDirect(new a(this));
            StringBuilder r3 = new StringBuilder("audience sound ");
            com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b r0 = this.a.c;
            if (r0 == null) goto L5;
            String r1 = r0.b;
        L6:
            r3.append(r1);
            r3.append(" complete");
            ALogger.i("emoji_sound", r3.toString());
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void onError(Error r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            AndroidSchedulers.mainThread().scheduleDirect(new RunnableC0107b(this, r3));
        }
    }

    public static final class d implements hj0.a {
        public d() {
        }

        @Override // hj0.a
        public final Pair<Boolean, String> a() {
            IPlatformSoloKtvService r0 = k.f(IPlatformSoloKtvService.class);
            if (r0 == null) goto L5;
            boolean r1 = r0.isInSoloKtvPage();
        L7:
            return new Pair(Boolean.valueOf(r1), "filter by SoloKtv");
        L5:
            r1 = false;
            goto L7
        }
    }

    static {
    }

    public final void c() {
        this.b = false;
        this.c = null;
        TTVideoEngine r1 = this.a;
        if (r1 == null) goto L5;
        r1.stop();
        r1.release();
        this.a = null;
    L5:
        CompositeDisposable r0 = this.d;
        if (r0 == null) goto L9;
        r0.dispose();
        return;
    }

    public final void f() {
        this.c = null;
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.stop();
        return;
    L8:
        return;
    }

    public final void a() {
        boolean r0 = this.g;
        if (r0 == false) goto L5;
    L7:
        if (r0 == false) goto L19;
        com.bytedance.android.live.pushstream.d r1 = this.h;
        if (r1 == null) goto L20;
        d0 r2 = r1.getLiveCore();
        if (r2 == null) goto L13;
        r2.createPlayer();
    L13:
        d0 r3 = this.h.getLiveCore();
        if (r3 == null) goto L16;
        r3.startAudioPlayer();
    L16:
        this.a = null;
        ALogger.i("emoji_sound", "init anchor AVPlayer");
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.a != null) goto L7;
        TTVideoEngine r4 = new TTVideoEngine(jc1.a.b(), 0);
        this.a = r4;
        r4.setListener(new b(this));
        ALogger.i("emoji_sound", "init audience TTVideoEngine");
    }

    public final void b(Context r4) {
        Object r5 = r4.getSystemService("audio");
        if (r5 == null) goto L15;
        AudioManager r6 = (AudioManager) r5;
        boolean r0 = this.b;
        if (r6.isWiredHeadsetOn() == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r0 == r1) goto L16;
        r6.setSpeakerphoneOn(this.b);
        this.b = !this.b;
        return;
    L16:
        return;
    L7:
        if (r6.isBluetoothA2dpOn() == true) goto L10;
        r1 = false;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [boolean] */
    public final void d(w8 r9) {
        Intrinsics.checkNotNullParameter(r9, "emojiMessage");
        ReadOnlyProperty r0 = vm2.d.T4;
        KProperty[] r1 = vm2.d.a;
        if (((Boolean) r0.getValue(null, r1[303(0x12f, float:4.25E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.a1.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (((Boolean) vm2.d.P4.getValue(null, r1[299(0x12b, float:4.19E-43)])).booleanValue() == false) goto L16;
        Iterator<hj0.a> r2 = this.e.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        hj0.a r3 = r2.next();
        if (((Boolean) r3.a().getFirst()).booleanValue() == false) goto L11;
        ALogger.e("emoji_sound", "filter, cause=" + ((String) r3.a().getSecond()));
        return;
    L16:
        ?? r4 = r9.isInteractEmoji();
        com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b r5 = this.c;
        if (r5 == null) goto L19;
        int r6 = r5.c;
    L20:
        if (r5 == null) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L33;
        if (r4 < r6) goto L31;
        ALogger.e("emoji_sound", "stop current sound and play interact emoji sound");
        int r8 = com.bytedance.android.live.liveinteract.voicechat.emoji.b.a;
        j r10 = r9.getDynamicEmojiFlex();
        j r11 = r9.getDynamicEmojiFlex();
        if (hd0.c.f().g() == true) goto L33;
        if (r10 == null) goto L33;
        if (r11 == null) goto L33;
        String r12 = r10.getEmojiSoundUrl();
        String r13 = r10.getEmojiName();
        String r14 = r11.getEmojiSoundUrl();
        String r15 = r11.getEmojiName();
        int r16 = x.a;
        Intrinsics.checkNotNullParameter(r12, "currentUrl");
        Intrinsics.checkNotNullParameter(r13, "currentEmoji");
        Intrinsics.checkNotNullParameter(r14, "newUrl");
        Intrinsics.checkNotNullParameter(r15, "newEmoji");
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("current_url", r12);
        r17.put("current_emoji", r13);
        r17.put("new_url", r14);
        r17.put("new_emoji", r15);
        x.v0("emoji_sound_cover_current", r17);
        goto L33
    L31:
        ALogger.e("emoji_sound", "current sound is playing, won't play");
        return;
    L33:
        j r18 = r9.getDynamicEmojiFlex();
        if (r18 == null) goto L48;
        String r19 = r18.getEmojiSoundUrl();
        if (r19 == null) goto L52;
        this.c = new com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b("defalut", r19, r6);
        ALogger.i("emoji_sound", "play emoji sound ".concat(r19));
        a();
        b(this.f);
        TTVideoEngine r20 = this.a;
        if (r20 == null) goto L49;
        r20.stop();
        r20.setDirectURL(r19);
        TTVideoEngine r21 = this.a;
        if (r21 == null) goto L50;
        r21.play();
        return;
    L50:
        return;
    L49:
        return;
    L52:
        return;
    L48:
        return;
    L22:
        r7 = false;
        goto L23
    L19:
        r6 = -1;
        goto L20
    }

    public EmojiSoundManager(Context r4, boolean r5, com.bytedance.android.live.pushstream.d r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f = r4;
        this.g = r5;
        this.h = r6;
        CompositeDisposable r7 = new CompositeDisposable();
        this.d = r7;
        ArrayList<hj0.a> r8 = new ArrayList();
        this.e = r8;
        d r9 = new d();
        Observable r0 = xs2.b.a().b(e.class).observeOn(AndroidSchedulers.mainThread());
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        r7.add(r0.subscribe(new c(r1)));
        Observable r2 = xs2.b.a().b(f.class).observeOn(AndroidSchedulers.mainThread());
        final AnonymousClass2 r3 = new AnonymousClass2(this);
        r7.add(r2.subscribe(new c(r3)));
        Intrinsics.checkNotNullParameter(r9, "filter");
        r8.add(r9);
    }

    public final void e(String r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "id");
        Intrinsics.checkNotNullParameter(r7, "url");
        if (((Boolean) vm2.d.P4.getValue(null, vm2.d.a[299(0x12b, float:4.19E-43)])).booleanValue() == false) goto L11;
        Iterator<hj0.a> r0 = this.e.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        hj0.a r3 = r0.next();
        if (((Boolean) r3.a().getFirst()).booleanValue() == false) goto L6;
        ALogger.e("emoji_sound", "filter, cause=" + ((String) r3.a().getSecond()));
        return;
    L11:
        com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b r1 = this.c;
        if (r1 == null) goto L14;
        int r4 = r1.c;
    L16:
        if (r1 == null) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L24;
        if (r8 <= r4) goto L22;
        ALogger.e("emoji_sound", "stop current sound and play interact emoji sound");
        goto L24
    L22:
        ALogger.e("emoji_sound", "current sound is playing, won't play");
        return;
    L24:
        this.c = new com.bytedance.android.live.liveinteract.voicechat.emoji.sound.b(r6, r7, r8);
        a();
        b(this.f);
        TTVideoEngine r9 = this.a;
        if (r9 == null) goto L37;
        r9.stop();
        if (StringsKt.startsWith$default(r7.toLowerCase(Locale.ROOT), "file://", false, 2, null) == false) goto L29;
        r9.setLocalURL(r7);
    L30:
        TTVideoEngine r10 = this.a;
        if (r10 == null) goto L38;
        r10.play();
        return;
    L38:
        return;
    L29:
        r9.setDirectURL(r7);
        goto L30
    L37:
        return;
    L18:
        r2 = false;
        goto L19
    L14:
        r4 = -1;
        goto L16
    }
}
