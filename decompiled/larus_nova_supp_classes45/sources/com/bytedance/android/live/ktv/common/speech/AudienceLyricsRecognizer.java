package com.bytedance.android.live.ktv.common.speech;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.q2;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import fd2.t;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AudienceLyricsRecognizer {
    public Disposable a;
    public String b;
    public String c;
    public long d;
    public int e;
    public boolean f;
    public final Lazy g;
    public final LyricFontHelper h;
    public final jg4.c i;
    public t j;
    public final SpeechLyricsView k;
    public final boolean l;
    public final boolean m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AudienceLyricsRecognizer a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ int c;

        public b(AudienceLyricsRecognizer r1, Ref.LongRef r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            Ref.LongRef r7 = this.b;
            long r0 = r7.element + 55;
            r7.element = r0;
            AudienceLyricsRecognizer r8 = this.a;
            r8.d = r0;
            jg4.c r9 = r8.i;
            if (r9 == null) goto L6;
            r9.j(r0);
        L6:
            if (this.b.element < this.c) goto L9;
            this.a.a();
            AudienceLyricsRecognizer r11 = this.a;
            r11.b = null;
            r11.d = 0;
            return;
        }
    }

    static {
    }

    public final void a() {
        ALogger.i("SpeechRecognitionGuest", "hide lyric");
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L9:
        jg4.c r1 = this.i;
        if (r1 == null) goto L14;
        jg4.f r2 = r1.a();
        if (r2 == null) goto L14;
        r2.reset();
    L14:
        t r3 = this.j;
        if (r3 == null) goto L17;
        r3.a();
    L17:
        SpeechLyricsView r4 = this.k;
        if (r4 == null) goto L22;
        TextView r5 = r4.getAiTipsTextView();
        if (r5 == null) goto L22;
        r5.setVisibility(8);
    L22:
        SpeechLyricsView r6 = this.k;
        if (r6 == null) goto L27;
        ImageView r7 = r6.getAiTagView();
        if (r7 == null) goto L27;
        r7.setVisibility(8);
    L27:
        this.f = false;
        this.b = null;
        this.c = null;
        this.h.b = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r8 = this.a;
        if (r8 == null) goto L9;
        r8.dispose();
        goto L9
    }

    public final void c() {
        q2 r0 = (q2) b6.F.getValue();
        SpeechLyricsView r1 = this.k;
        ImageView r2 = null;
        if (r1 == null) goto L5;
        TextView r3 = r1.getAiTipsTextView();
    L6:
        SpeechLyricsView r4 = this.k;
        if (r4 == null) goto L10;
        r2 = r4.getAiTagView();
    L10:
        if (this.m == false) goto L16;
        if (r3 == null) goto L13;
        r3.setVisibility(0);
    L13:
        if (r2 == null) goto L28;
        r2.setVisibility(8);
        return;
    L28:
        return;
    L16:
        if (Intrinsics.areEqual(r0.e(), Boolean.FALSE) == true) goto L18;
    L23:
        if (r3 == null) goto L25;
        r3.setVisibility(8);
    L25:
        if (r2 == null) goto L32;
        r2.setVisibility(0);
        return;
    L32:
        return;
    L18:
        if (this.l == true) goto L23;
        if (r3 == null) goto L21;
        r3.setVisibility(0);
    L21:
        if (r2 == null) goto L30;
        r2.setVisibility(8);
        return;
    L30:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void b(String r21) {
        Intrinsics.checkNotNullParameter(r21, "sei");
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L120;
        return;
    L120:
        LiveSeiUtil.i.getClass();     // Catch: Throwable -> L117
        JSONObject r9 = LiveSeiUtil.c(r21);     // Catch: Throwable -> L117
        if (r9.has("music_recognition_result") == false) goto L124;
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(r9, "music_recognition_result");     // Catch: Throwable -> L117
        String r11 = r5.optString("lyrics_url");     // Catch: Throwable -> L117
        String r12 = r5.optString("song_id");     // Catch: Throwable -> L117
        long r13 = r5.optLong("play_time");     // Catch: Throwable -> L117
        int r14 = r5.optInt("duration");     // Catch: Throwable -> L117
        int r15 = r5.optInt("lyric_type", 3);     // Catch: Throwable -> L117
        int r16 = r5.optInt("state");     // Catch: Throwable -> L117
        ALogger.i("SpeechRecognitionGuest", "playTime: " + r13 + ", songProgress: " + this.d + ", diff: " + (r13 - this.d) + ", isLyricsShow: " + this.f + ", state: " + r16);     // Catch: Throwable -> L117
        boolean r8 = false;
        if (this.m == false) goto L58;
        if (r5.has("singer_linkmic_id") == false) goto L36;
        String r4 = JSONObjectProtectorUtils.getString(r5, "singer_linkmic_id");     // Catch: Throwable -> L117
        String r7 = jc1.k.n(IMiddlewareUserService.class).user().n();     // Catch: Throwable -> L117
        IInteractService r17 = jc1.k.f(IInteractService.class);     // Catch: Throwable -> L117
        if (r17 == null) goto L29;
        com.bytedance.android.live.liveinteract.plantform.base.i r18 = r17.getLinkUserInfoCenter();     // Catch: Throwable -> L117
        if (r18 == null) goto L29;
        List r19 = r18.getOnlineUserList();     // Catch: Throwable -> L117
        if (r19 == null) goto L29;
        Iterator r110 = r19.iterator();     // Catch: Throwable -> L117
    L19:
        if (r110.hasNext() == false) goto L27;
        Object r111 = r110.next();     // Catch: Throwable -> L117
        IBaseUser r112 = ((ILinkPlayerInfoBridge) r111).getUser();     // Catch: Throwable -> L117
        if (r112 == null) goto L23;
        String r113 = r112.getIdString();     // Catch: Throwable -> L117
    L25:
        if (Intrinsics.areEqual(r113, r7) == false) goto L19;
    L28:
        ILinkPlayerInfoBridge r114 = (ILinkPlayerInfoBridge) r111;     // Catch: Throwable -> L117
    L30:
        t r22 = this.j;     // Catch: Throwable -> L117
        if (r22 == null) goto L40;
        if (r114 == null) goto L34;
        String r115 = r114.getInteractId();     // Catch: Throwable -> L117
    L35:
        r22.d(Intrinsics.areEqual(r4, r115));     // Catch: Throwable -> L117
        goto L40
    L34:
        r115 = null;
    L40:
        if (r5.has("refrain") == false) goto L42;
        Integer r3 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r5, "refrain"));     // Catch: Throwable -> L117
    L44:
        if (r5.has("emo_tag") == false) goto L46;
        String r2 = JSONObjectProtectorUtils.getString(r5, "emo_tag");     // Catch: Throwable -> L117
    L47:
        Long r6 = com.bytedance.android.live.liveinteract.utils.a.a;     // Catch: Throwable -> L117
        if (r3 != null) goto L51;
    L53:
        boolean r23 = false;
    L54:
        com.bytedance.android.live.liveinteract.utils.a.b(Boolean.valueOf(r23));     // Catch: Throwable -> L117
        com.bytedance.android.live.liveinteract.utils.a.a(r2);     // Catch: Throwable -> L117
        t r24 = this.j;     // Catch: Throwable -> L117
        if (r24 == null) goto L58;
        r24.b(r2, r3);     // Catch: Throwable -> L117
        goto L58
    L51:
        if (r3.intValue() != 1) goto L53;
        r23 = true;
        goto L54
    L46:
        r2 = null;
        goto L47
    L42:
        r3 = null;
        goto L44
    L23:
        r113 = null;
        goto L25
    L27:
        r111 = null;
    L29:
        r114 = null;
        goto L30
    L36:
        t r25 = this.j;     // Catch: Throwable -> L117
        if (r25 == null) goto L40;
        r25.d(false);     // Catch: Throwable -> L117
    L58:
        if (this.f == false) goto L66;
        if (r16 != 0) goto L66;
        t r0 = this.j;     // Catch: Throwable -> L117
        if (r0 == null) goto L63;
        r0.a();     // Catch: Throwable -> L117
    L63:
        a();     // Catch: Throwable -> L117
        return;
    L66:
        if (r12.length() <= 0) goto L68;
        boolean r26 = true;
    L69:
        if (r26 == false) goto L103;
        if (r11.length() <= 0) goto L73;
        boolean r27 = true;
    L74:
        if (r27 == false) goto L103;
        if ((!Intrinsics.areEqual(this.b, r12)) == true) goto L80;
        String r28 = r11;
        if ((!Intrinsics.areEqual(this.c, r28)) == false) goto L103;
    L81:
        this.b = r12;     // Catch: Throwable -> L117
        this.c = r28;     // Catch: Throwable -> L117
        com.bytedance.android.live.liveinteract.utils.a.g(r12);     // Catch: Throwable -> L117
        if (r28.length() <= 0) goto L84;
        r8 = true;
    L84:
        com.bytedance.android.live.liveinteract.utils.a.c(Boolean.valueOf(r8));     // Catch: Throwable -> L117
        d(r13, r14 * 1000);     // Catch: Throwable -> L117
        jg4.c r29 = this.i;     // Catch: Throwable -> L117
        if (r29 == null) goto L98;
        LyricsDisplayConfig r31 = r29.c();     // Catch: Throwable -> L117
        if (r31 == null) goto L98;
        if (this.m == true) goto L91;
    L95:
        jg4.j r1 = n.a(r28, n.c(r28, r12), r31);     // Catch: Throwable -> L117
        r1.d = r15;     // Catch: Throwable -> L117
        jg4.c r32 = this.i;     // Catch: Throwable -> L117
        if (r32 == null) goto L98;
        r32.d(r1);     // Catch: Throwable -> L117
        goto L98
    L91:
        if (r5.has("font_info") == false) goto L93;
        String r116 = r5.optString("font_info");     // Catch: Throwable -> L117
    L94:
        this.h.a(r116, r31);     // Catch: Throwable -> L117
        goto L95
    L93:
        r116 = null;
    L98:
        c();     // Catch: Throwable -> L117
        t r33 = this.j;     // Catch: Throwable -> L117
        if (r33 == null) goto L101;
        r33.c();     // Catch: Throwable -> L117
    L101:
        this.f = true;     // Catch: Throwable -> L117
        ALogger.i("SpeechRecognitionGuest", "show lyrics, recognizeResultListener: " + this.j);     // Catch: Throwable -> L117
        return;
    L80:
        r28 = r11;
        goto L81
    L73:
        r27 = false;
    L103:
        if (this.f == false) goto L112;
        if (Math.abs(r13 - this.d) <= 1800) goto L107;
    L108:
        int r34 = this.e + 1;     // Catch: Throwable -> L117
        this.e = r34;     // Catch: Throwable -> L117
        if (r34 <= 2) goto L126;
        d(r13, r14 * 1000);     // Catch: Throwable -> L117
        this.e = 0;     // Catch: Throwable -> L117
        return;
    L126:
        return;
    L107:
        if ((r13 - this.d) > 600) goto L108;
    L112:
        if (this.f == true) goto L114;
        return;
    L114:
        if (Math.abs(r13 - this.d) >= 1800) goto L129;
        this.e = 0;     // Catch: Throwable -> L117
        return;
    L129:
        return;
    L68:
        r26 = false;
        goto L69
    L124:
        return;
    L117:
        th = move-exception;
        ALogger.i("SpeechRecognitionGuest", "sei handle exception: " + th.getMessage());
    }

    public final void d(long r6, int r8) {
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = r6;
        Disposable r7 = this.a;
        if (r7 != null) goto L5;
    L9:
        this.a = du2.a.b(0, 55, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r0, r8));
        return;
    L5:
        if (r7.isDisposed() == true) goto L9;
        Disposable r9 = this.a;
        if (r9 == null) goto L9;
        r9.dispose();
        goto L9
    }

    public AudienceLyricsRecognizer(jg4.c r1, t r2, SpeechLyricsView r3, boolean r4, boolean r5) {
        this.i = r1;
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.g = LazyKt.lazy(AudienceLyricsRecognizer$enableLyric$2.INSTANCE);
        this.h = new LyricFontHelper();
    }
}
