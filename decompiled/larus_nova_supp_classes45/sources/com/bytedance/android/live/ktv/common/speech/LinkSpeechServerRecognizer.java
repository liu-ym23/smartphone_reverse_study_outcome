package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.MusicInterval;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import fd2.h0;
import fd2.t;
import fd2.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LinkSpeechServerRecognizer extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> implements v {
    public static final Set<String> K = null;
    public final Lazy A;
    public Disposable B;
    public AudienceLyricsRecognizer C;
    public com.bytedance.android.live.ktv.common.model.api.j D;
    public final CompositeDisposable E;
    public boolean F;
    public String G;
    public rb0.b H;
    public boolean I;
    public final LyricFontHelper J;
    public SpeechLyricsView a;
    public boolean b;
    public com.bytedance.android.live.pushstream.d c;
    public ei6.a d;
    public e e;
    public SpeechEngine f;
    public long g;
    public SpeechEngine h;
    public long i;
    public final CompositeDisposable j;
    public Disposable k;
    public Disposable l;
    public Disposable m;
    public LyricComponentImplManager n;
    public k o;
    public t p;
    public final Lazy q;
    public final ArrayBlockingQueue<byte[]> r;
    public final AtomicInteger s;
    public final AtomicBoolean t;
    public final AtomicBoolean u;
    public boolean v;
    public boolean w;
    public final Map<String, String> x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkSpeechServerRecognizer a;

        public b(LinkSpeechServerRecognizer r1) {
            this.a = r1;
        }

        public final void accept(Object r27) {
            if (((h0) r27).a == false) goto L179;
            com.bytedance.android.live.ktv.common.model.api.j r2 = new com.bytedance.android.live.ktv.common.model.api.j();
            r2.s(6874972841490515969L);
            r2.q(6815073757028157452L);
            r2.p(202544130L);
            Boolean r0 = Boolean.FALSE;
            r2.k(r0);
            r2.t(2);
            r2.r();
            MusicInterval r4 = new MusicInterval();
            r4.setStartMs(20856);
            r4.setDurationMs(37455);
            Unit r5 = Unit.INSTANCE;
            r2.o(CollectionsKt.listOf(r4));
            r2.l();
            r2.n();
            r2.m();
            LinkSpeechServerRecognizer r6 = this.a;
            r6.v = true;
            com.bytedance.android.livesdk.chatroom.o r7 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r7 == null) goto L9;
            com.bytedance.live.datacontext.j r8 = r7.getLiveStream();
            if (r8 == null) goto L9;
            com.bytedance.android.live.pushstream.d r9 = (com.bytedance.android.live.pushstream.d) r8.getValue();
        L10:
            r6.c = r9;
            LinkSpeechServerRecognizer r11 = this.a;
            long r16 = System.currentTimeMillis();
            r11.getClass();
            com.bytedance.android.live.ktv.common.model.api.j r12 = r11.D;     // Catch: JSONException -> L176
            String r13 = r2.a();     // Catch: JSONException -> L176
            String r14 = r2.c();     // Catch: JSONException -> L176
            Boolean r18 = r2.i();     // Catch: JSONException -> L176
            if (r18 == null) goto L14;
            boolean r3 = r18.booleanValue();     // Catch: JSONException -> L176
        L15:
            Boolean r19 = r2.j();     // Catch: JSONException -> L176
            if (r19 == null) goto L18;
            boolean r15 = r19.booleanValue();     // Catch: JSONException -> L176
        L21:
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
            Long r21 = com.bytedance.android.live.liveinteract.utils.a.a;     // Catch: JSONException -> L176
            StringBuilder r17 = new StringBuilder("currentSimGroupIdV3=");     // Catch: JSONException -> L176
            if (r12 == null) goto L25;
            Long r22 = r12.f();     // Catch: JSONException -> L176
        L26:
            r17.append(r22);     // Catch: JSONException -> L176
            r17.append("\nnewSimGroupIdV3=");     // Catch: JSONException -> L176
            r17.append(r2.f());     // Catch: JSONException -> L176
            r17.append(", isFilter=");     // Catch: JSONException -> L176
            r17.append(r3);     // Catch: JSONException -> L176
            r17.append(", isNonVal=");     // Catch: JSONException -> L176
            r17.append(r15);     // Catch: JSONException -> L176
            r17.append(", songID=");     // Catch: JSONException -> L176
            r17.append(r2.h());     // Catch: JSONException -> L176
            r17.append(", hasLyric=");     // Catch: JSONException -> L176
            if (r2.a(r2.c()) == true) goto L29;
        L31:
            boolean r23 = false;
        L32:
            r17.append(r23);     // Catch: JSONException -> L176
            r17.append('\n');     // Catch: JSONException -> L176
            String r24 = r17.toString();     // Catch: JSONException -> L176
            String r25 = com.bytedance.android.live.liveinteract.utils.a.n;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.n = r24;     // Catch: JSONException -> L176
            if (r25 == r24) goto L37;
            Function0 r26 = com.bytedance.android.live.liveinteract.utils.a.p;     // Catch: JSONException -> L176
            if (r26 == null) goto L37;
            Unit r28 = (Unit) r26.invoke();     // Catch: JSONException -> L176
            goto L37
        L29:
            if ((!Intrinsics.areEqual(r2.c(), "null")) == false) goto L31;
            r23 = true;
            goto L32
        L25:
            r22 = null;
        L37:
            if (r12 == null) goto L39;
            Long r29 = r12.f();     // Catch: JSONException -> L176
        L41:
            if ((!Intrinsics.areEqual(r29, r2.f())) == false) goto L73;
            Long r31 = com.bytedance.android.live.liveinteract.utils.a.a;     // Catch: JSONException -> L176
            Long r32 = r2.f();     // Catch: JSONException -> L176
            Long r33 = com.bytedance.android.live.liveinteract.utils.a.a;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.a = r32;     // Catch: JSONException -> L176
            if (r33 == r32) goto L47;
            Function0 r34 = com.bytedance.android.live.liveinteract.utils.a.p;     // Catch: JSONException -> L176
            if (r34 == null) goto L47;
            Unit r35 = (Unit) r34.invoke();     // Catch: JSONException -> L176
        L47:
            Boolean r36 = Boolean.valueOf(r3);     // Catch: JSONException -> L176
            Boolean r37 = com.bytedance.android.live.liveinteract.utils.a.g;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.g = r36;     // Catch: JSONException -> L176
            if (r37 == r36) goto L52;
            Function0 r38 = com.bytedance.android.live.liveinteract.utils.a.p;     // Catch: JSONException -> L176
            if (r38 == null) goto L52;
            Unit r39 = (Unit) r38.invoke();     // Catch: JSONException -> L176
        L52:
            Boolean r41 = Boolean.valueOf(r15);     // Catch: JSONException -> L176
            Boolean r42 = com.bytedance.android.live.liveinteract.utils.a.i;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.i = r41;     // Catch: JSONException -> L176
            if (r42 == r41) goto L57;
            Function0 r43 = com.bytedance.android.live.liveinteract.utils.a.p;     // Catch: JSONException -> L176
            if (r43 == null) goto L57;
            Unit r44 = (Unit) r43.invoke();     // Catch: JSONException -> L176
        L57:
            Long r45 = r2.h();     // Catch: JSONException -> L176
            if (r45 == null) goto L60;
            String r46 = String.valueOf(r45.longValue());     // Catch: JSONException -> L176
        L61:
            com.bytedance.android.live.liveinteract.utils.a.g(r46);     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.a(r2.g());     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.d(r2.d());     // Catch: JSONException -> L176
            if (r2.a(r13) == true) goto L64;
        L65:
            if (r3 == false) goto L73;
            if (r15 == true) goto L73;
        L67:
            Long r47 = r2.h();     // Catch: JSONException -> L176
            if (r47 == null) goto L70;
            String r48 = String.valueOf(r47.longValue());     // Catch: JSONException -> L176
        L71:
            r11.r(r48, false, r2.e(), r2.f(), 0);     // Catch: JSONException -> L176
            r11.D = r2;     // Catch: JSONException -> L176
            goto L73
        L70:
            r48 = null;
            goto L71
        L64:
            if (r2.a(r14) == true) goto L67;
        L60:
            r46 = null;
        L73:
            String r49 = r2.a();     // Catch: JSONException -> L176
            String r51 = r2.c();     // Catch: JSONException -> L176
            if (r49 == null) goto L186;
            if (r51 == null) goto L186;
            if (r49.length() != 0) goto L79;
            boolean r52 = true;
        L80:
            if (r52 == false) goto L82;
        L174:
            com.bytedance.android.live.liveinteract.utils.a.c(r0);     // Catch: JSONException -> L176
            goto L186
        L82:
            if (r51.length() != 0) goto L84;
            boolean r53 = true;
        L85:
            if (r53 == true) goto L174;
            if (Intrinsics.areEqual(r49, r13) == true) goto L174;
            if (Intrinsics.areEqual(r51, r13) == true) goto L174;
            JSONObject r1 = new JSONObject(r49);     // Catch: JSONException -> L176
            double r110 = r1.optDouble("MatchEndTime");     // Catch: JSONException -> L176
            JSONObject r54 = r1.optJSONObject("SongInfo");     // Catch: JSONException -> L176
            if (r54 == null) goto L95;
            String r55 = r54.optString("ID");     // Catch: JSONException -> L176
            if (r55 == null) goto L95;
        L96:
            String r111 = r55;
            if (r54 == null) goto L100;
            String r112 = r54.optString("SongName");     // Catch: JSONException -> L176
            if (r112 == null) goto L100;
        L101:
            if (r54 == null) goto L103;
            int r56 = r54.optInt("FullDuration");     // Catch: JSONException -> L176
        L104:
            if (r54 == null) goto L107;
            String r57 = r54.optString("ArtistName");     // Catch: JSONException -> L176
            if (r57 == null) goto L107;
        L109:
            if (r2.a(r51) == false) goto L186;
            if ((!Intrinsics.areEqual(r51, "null")) == false) goto L186;
            JSONObject r58 = new JSONObject(r51);     // Catch: JSONException -> L176
            JSONObject r59 = r58.optJSONObject("LyricUrlInfo");     // Catch: JSONException -> L176
            if (r59 == null) goto L115;
            JSONArray r61 = r59.optJSONArray("Urls");     // Catch: JSONException -> L176
        L116:
            int r62 = r58.optInt("LyricType");     // Catch: JSONException -> L176
            if (r61 == null) goto L119;
            int r63 = r61.length();     // Catch: JSONException -> L176
        L120:
            if (r63 <= 0) goto L127;
            if (r61 == null) goto L126;
            Object r64 = r61.get(0);     // Catch: JSONException -> L176
            if (r64 == null) goto L126;
            String r65 = r64.toString();     // Catch: JSONException -> L176
        L128:
            ALogger.e("LinkSpeechRecognizer", "songInfo: songId=" + r111 + ", songName=" + r112 + ", matchEndTime=" + r110 + ", url=" + r65 + "， songDuration=" + r56);     // Catch: JSONException -> L176
            if (r56 <= 0) goto L186;
            if (r65 != null) goto L132;
        L135:
            boolean r66 = true;
        L136:
            if (r66 == true) goto L186;
            if (r62 == 3) goto L142;
            int r67 = 2;
            if (r62 != 2) goto L186;
        L143:
            int r68 = r2.getType();     // Catch: JSONException -> L176
            if (r68 == r67) goto L183;
            int r69 = r56;
            int r71 = JSONObjectProtectorUtils.getInt(r1, "Similarity");     // Catch: JSONException -> L153
        L155:
            IInteractService r72 = jc1.k.f(IInteractService.class);     // Catch: JSONException -> L176
            if (r72 == null) goto L158;
            boolean r113 = r72.isAIMVStage();     // Catch: JSONException -> L176
        L159:
            if (r113 == false) goto L161;
            String r210 = r2.g();     // Catch: JSONException -> L176
        L162:
            if (r113 == false) goto L164;
            List<MusicInterval> r211 = r2.d();     // Catch: JSONException -> L176
        L165:
            if (r113 == false) goto L167;
            String r212 = r2.b();     // Catch: JSONException -> L176
        L168:
            r11.q(new k(r68, r111, r65, r110, r69, r71, r16, r112, r62, r57, r210, r211, r212));     // Catch: JSONException -> L176
            Long r73 = com.bytedance.android.live.liveinteract.utils.a.a;     // Catch: JSONException -> L176
            Integer r74 = Integer.valueOf(r71);     // Catch: JSONException -> L176
            Integer r75 = com.bytedance.android.live.liveinteract.utils.a.c;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.c = r74;     // Catch: JSONException -> L176
            if (r75 == r74) goto L173;
            Function0 r76 = com.bytedance.android.live.liveinteract.utils.a.p;     // Catch: JSONException -> L176
            if (r76 == null) goto L173;
            Unit r77 = (Unit) r76.invoke();     // Catch: JSONException -> L176
        L173:
            com.bytedance.android.live.liveinteract.utils.a.c(Boolean.TRUE);     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.g(r111);     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.d(r211);     // Catch: JSONException -> L176
            goto L186
        L167:
            r212 = null;
            goto L168
        L164:
            r211 = null;
            goto L165
        L161:
            r210 = null;
            goto L162
        L158:
            r113 = false;
        L153:
            e = e;
        L154:
            ALogger.e("LinkSpeechServerRecognizer", "parseSongInfo, Similarity json exception: " + e.getMessage());     // Catch: JSONException -> L176
            r71 = 0;
            goto L155
        L183:
            r69 = r56;
            r71 = (int) (JSONObjectProtectorUtils.getDouble(r1, "Similarity") * ((double) 100));
        L148:
            e = e;
            r69 = r56;
            goto L154
        L142:
            r67 = 2;
            goto L143
        L132:
            if (StringsKt.isBlank(r65) == true) goto L135;
            r66 = false;
        L126:
            r65 = null;
            goto L128
        L127:
            r65 = "";
            goto L128
        L119:
            r63 = 0;
            goto L120
        L115:
            r61 = null;
        L107:
            r57 = r9;
            goto L109
        L103:
            r56 = 0;
        L100:
            r112 = "";
        L95:
            r55 = "0";
            goto L96
        L84:
            r53 = false;
            goto L85
        L79:
            r52 = false;
        L186:
            return;
        L39:
            r29 = null;
            goto L41
        L18:
            r15 = false;
            goto L21
        L14:
            r3 = false;
        L176:
            e = move-exception;
            ALogger.e("LinkSpeechServerRecognizer", "parseSongInfo, json exception: " + e.getMessage());
        L9:
            r9 = null;
            goto L10
        L179:
            this.a.i();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.e("LinkSpeechServerRecognizer", "room_song_changed api error");
        }
    }

    public static final class e implements ri6.c {
        public e() {
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LinkSpeechServerRecognizer a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Ref.LongRef d;
        public final /* synthetic */ k e;
        public final /* synthetic */ int f;

        public f(LinkSpeechServerRecognizer r1, Ref.LongRef r2, int r3, Ref.LongRef r4, k r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            Ref.LongRef r9 = this.b;
            long r0 = r9.element + 55;
            r9.element = r0;
            Long r11 = com.bytedance.android.live.liveinteract.utils.a.a;
            Long r12 = Long.valueOf(r0);
            Long r1 = com.bytedance.android.live.liveinteract.utils.a.f;
            com.bytedance.android.live.liveinteract.utils.a.f = r12;
            if (r1 == r12) goto L7;
            Function0 r13 = com.bytedance.android.live.liveinteract.utils.a.p;
            if (r13 == null) goto L7;
            Unit r14 = (Unit) r13.invoke();
        L7:
            LyricComponentImplManager r15 = this.a.n;
            if (r15 == null) goto L10;
            r15.j(this.b.element);
        L10:
            long r2 = this.b.element;
            if ((r2 - this.d.element) <= this.c) goto L14;
            this.a.s(this.e, r2, 1);
            this.d.element = this.b.element;
        L14:
            if (this.b.element < this.f) goto L17;
            this.a.p();
            LinkSpeechServerRecognizer r16 = this.a;
            r16.D = null;
            r16.s(null, 0, 0);
            return;
        }
    }

    static {
        K = SetsKt.setOf("FZSongKeBenXiuKai");
    }

    public final void destroyEngine() {
        ALogger.i("LinkSpeechServerRecognizer", "destroyEngine");
        ((LinkedHashMap) this.x).clear();
        p();
        s(null, 0, 0);
        AudienceLyricsRecognizer r0 = this.C;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.b = false;
        SpeechEngine r1 = this.f;
        if (r1 == null) goto L8;
        r1.destroyEngine();
    L8:
        this.g = -1;
        this.f = null;
        SpeechEngine r4 = this.h;
        if (r4 == null) goto L11;
        r4.destroyEngine();
    L11:
        this.i = -1;
        this.h = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.J.b = null;
        this.j.clear();
        Disposable r2 = this.l;
        if (r2 != null) goto L14;
    L18:
        Disposable r3 = this.k;
        if (r3 != null) goto L21;
    L25:
        Disposable r5 = this.m;
        if (r5 != null) goto L28;
    L32:
        this.p = null;
        v();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L40;
        this.I = false;
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 == null) goto L41;
        com.bytedance.android.live.liveinteract.plantform.base.i r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L42;
        r7.T4(this);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L28:
        if (r5.isDisposed() == true) goto L32;
        Disposable r8 = this.m;
        if (r8 == null) goto L32;
        r8.dispose();
        goto L32
    L21:
        if (r3.isDisposed() == true) goto L25;
        Disposable r9 = this.k;
        if (r9 == null) goto L25;
        r9.dispose();
        goto L25
    L14:
        if (r2.isDisposed() == true) goto L18;
        Disposable r11 = this.l;
        if (r11 == null) goto L18;
        r11.dispose();
        goto L18
    }

    public final void i() {
        ALogger.i("LinkSpeechServerRecognizer", "stopRecognize");
        int r1 = mb0.h.a;
        boolean r3 = true;
        if (this.v == true) goto L6;
        r3 = false;
    L6:
        k r2 = this.o;
        if (r2 == null) goto L10;
        String r5 = r2.b;
        if (r5 == null) goto L10;
    L11:
        if (r2 == null) goto L14;
        String r6 = r2.h;
        if (r6 == null) goto L14;
    L15:
        if (r2 == null) goto L17;
        int r4 = r2.f;
    L18:
        mb0.h.b(r3, r5, r6, Integer.valueOf(r4));
        this.v = false;
        p();
        s(null, 0, 0);
        Disposable r7 = this.m;
        if (r7 != null) goto L21;
    L25:
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 10;
        this.m = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r8));
        ALogger.i("LinkSpeechServerRecognizer", "onStop");
        v();
        this.o = null;
        ((LinkedHashMap) this.x).clear();
        r("0", false, 0L, 0L, 0);
        this.D = null;
        this.H = null;
        this.G = null;
        t r0 = this.p;
        if (r0 == null) goto L28;
        r0.b("", 0);
    L28:
        Long r9 = com.bytedance.android.live.liveinteract.utils.a.a;
        com.bytedance.android.live.liveinteract.utils.a.a = null;
        if (r9 == null) goto L33;
        Function0 r11 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r11 == null) goto L33;
        Unit r12 = (Unit) r11.invoke();
    L33:
        com.bytedance.android.live.liveinteract.utils.a.g(null);
        String r13 = com.bytedance.android.live.liveinteract.utils.a.n;
        com.bytedance.android.live.liveinteract.utils.a.n = null;
        if (r13 == null) goto L38;
        Function0 r14 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r14 == null) goto L38;
        Unit r15 = (Unit) r14.invoke();
    L38:
        Integer r16 = com.bytedance.android.live.liveinteract.utils.a.c;
        com.bytedance.android.live.liveinteract.utils.a.c = null;
        if (r16 == null) goto L43;
        Function0 r17 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r17 == null) goto L43;
        Unit r18 = (Unit) r17.invoke();
    L43:
        String r19 = com.bytedance.android.live.liveinteract.utils.a.d;
        com.bytedance.android.live.liveinteract.utils.a.d = null;
        if (r19 == null) goto L48;
        Function0 r21 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r21 == null) goto L48;
        Unit r22 = (Unit) r21.invoke();
    L48:
        com.bytedance.android.live.liveinteract.utils.a.d(null);
        Long r23 = com.bytedance.android.live.liveinteract.utils.a.f;
        com.bytedance.android.live.liveinteract.utils.a.f = null;
        if (r23 == null) goto L53;
        Function0 r24 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r24 == null) goto L53;
        Unit r25 = (Unit) r24.invoke();
    L53:
        Boolean r26 = com.bytedance.android.live.liveinteract.utils.a.g;
        com.bytedance.android.live.liveinteract.utils.a.g = null;
        if (r26 == null) goto L58;
        Function0 r27 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r27 == null) goto L58;
        Unit r28 = (Unit) r27.invoke();
    L58:
        com.bytedance.android.live.liveinteract.utils.a.b(null);
        Boolean r29 = com.bytedance.android.live.liveinteract.utils.a.i;
        com.bytedance.android.live.liveinteract.utils.a.i = null;
        if (r29 == null) goto L63;
        Function0 r31 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r31 == null) goto L63;
        Unit r32 = (Unit) r31.invoke();
    L63:
        com.bytedance.android.live.liveinteract.utils.a.a(null);
        com.bytedance.android.live.liveinteract.utils.a.c(null);
        String r33 = com.bytedance.android.live.liveinteract.utils.a.l;
        com.bytedance.android.live.liveinteract.utils.a.l = null;
        if (r33 == null) goto L68;
        Function0 r34 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r34 == null) goto L68;
        Unit r35 = (Unit) r34.invoke();
    L68:
        com.bytedance.android.live.liveinteract.utils.a.e(null);
        com.bytedance.android.live.liveinteract.utils.a.f(null);
        Function0 r36 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r36 == null) goto L72;
        Unit r37 = (Unit) r36.invoke();
        return;
    L72:
        return;
    L21:
        if (r7.isDisposed() == true) goto L25;
        Disposable r38 = this.m;
        if (r38 == null) goto L25;
        r38.dispose();
        goto L25
    L17:
        r4 = 0;
    L14:
        r6 = "";
    L10:
        r5 = "";
        goto L11
    }

    public final void initEngine() {
        if (this.b == true) goto L56;
        this.b = true;
        SpeechEngine r0 = SpeechEngineGenerator.getInstance();
        Integer r3 = null;
        if (r0 == null) goto L30;
        this.h = r0;
        this.i = r0.createEngine();
        SpeechEngine r1 = this.h;
        if (r1 == null) goto L10;
        r1.setOptionString("log_level", "TRACE");
    L10:
        SpeechEngine r2 = this.h;
        if (r2 == null) goto L13;
        r2.setOptionString("debug_path", "");
    L13:
        SpeechEngine r4 = this.h;
        if (r4 == null) goto L16;
        r4.setOptionString("engine_name", "coversong");
    L16:
        SpeechEngine r5 = this.h;
        if (r5 == null) goto L19;
        Integer r6 = Integer.valueOf(r5.initEngine());
    L20:
        if (r6 != null) goto L23;
    L24:
        ALogger.i("LinkSpeechServerRecognizer", "init cover engine error, ret = " + r6);
        goto L30
    L23:
        if (r6.intValue() != 0) goto L24;
        SpeechEngine r7 = this.h;
        if (r7 == null) goto L28;
        Integer r8 = Integer.valueOf(r7.resetEngine(this.i));
    L29:
        ALogger.i("LinkSpeechServerRecognizer", "reset cover engine, ret = " + r8);
        goto L30
    L28:
        r8 = null;
        goto L29
    L19:
        r6 = null;
    L30:
        SpeechEngine r9 = SpeechEngineGenerator.getInstance();
        if (r9 == null) goto L56;
        this.f = r9;
        this.g = r9.createEngine();
        SpeechEngine r11 = this.f;
        if (r11 == null) goto L36;
        r11.setOptionString("log_level", "TRACE");
    L36:
        SpeechEngine r12 = this.f;
        if (r12 == null) goto L39;
        r12.setOptionString("debug_path", "");
    L39:
        SpeechEngine r13 = this.f;
        if (r13 == null) goto L42;
        r13.setOptionString("engine_name", "afp");
    L42:
        SpeechEngine r14 = this.f;
        if (r14 == null) goto L45;
        Integer r15 = Integer.valueOf(r14.initEngine());
    L46:
        if (r15 != null) goto L49;
    L50:
        ALogger.i("LinkSpeechServerRecognizer", "init fp engine error, ret = " + r15);
        goto L56
    L49:
        if (r15.intValue() != 0) goto L50;
        SpeechEngine r16 = this.f;
        if (r16 == null) goto L54;
        r3 = Integer.valueOf(r16.resetEngine(this.g));
    L54:
        ALogger.i("LinkSpeechServerRecognizer", "reset fp engine, ret = " + r3);
        goto L56
    L45:
        r15 = null;
    L56:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L62;
        IInteractService r17 = jc1.k.f(IInteractService.class);
        if (r17 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.base.i r18 = r17.getLinkUserInfoCenter();
        if (r18 == null) goto L62;
        r18.Q4(this);
    L62:
        this.E.add(xs2.b.a().b(h0.class).subscribe(new b(this)));
    }

    public final void p() {
        ALogger.i("LinkSpeechServerRecognizer", "anchor hideLyrics");
        Disposable r0 = this.l;
        if (r0 != null) goto L5;
    L9:
        LyricComponentImplManager r1 = this.n;
        if (r1 == null) goto L14;
        jg4.f r2 = r1.g.d;
        if (r2 == null) goto L14;
        r2.reset();
    L14:
        t r3 = this.p;
        if (r3 == null) goto L17;
        r3.a();
    L17:
        this.w = false;
        SpeechLyricsView r4 = this.a;
        if (r4 == null) goto L22;
        TextView r5 = r4.getAiTipsTextView();
        if (r5 == null) goto L22;
        r5.setVisibility(8);
    L22:
        SpeechLyricsView r6 = this.a;
        if (r6 == null) goto L27;
        ImageView r7 = r6.getAiTagView();
        if (r7 == null) goto L27;
        r7.setVisibility(8);
    L27:
        this.o = null;
        this.J.b = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r8 = this.l;
        if (r8 == null) goto L9;
        r8.dispose();
        goto L9
    }

    public final void t() {
        SpeechLyricsView r0 = this.a;
        ImageView r1 = null;
        if (r0 == null) goto L5;
        TextView r2 = r0.getAiTipsTextView();
    L6:
        SpeechLyricsView r3 = this.a;
        if (r3 == null) goto L9;
        r1 = r3.getAiTagView();
    L9:
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        if (r1 == null) goto L14;
        r1.setVisibility(8);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void v() {
        Disposable r0 = this.B;
        if (r0 != null) goto L5;
    L9:
        this.B = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r1 = this.B;
        if (r1 == null) goto L9;
        r1.dispose();
        goto L9
    }

    public LinkSpeechServerRecognizer() {
        this.j = new CompositeDisposable();
        this.q = LazyKt.lazy(LinkSpeechServerRecognizer$maxBufferSize$2.INSTANCE);
        this.r = new ArrayBlockingQueue(3072);
        this.s = new AtomicInteger(0);
        this.t = new AtomicBoolean(true);
        this.u = new AtomicBoolean(true);
        this.x = new LinkedHashMap();
        this.y = LazyKt.lazy(LinkSpeechServerRecognizer$enableGuestStream$2.INSTANCE);
        this.z = LazyKt.lazy(new LinkSpeechServerRecognizer$halfMaxBufferSize$2(this));
        this.A = LazyKt.lazy(LinkSpeechServerRecognizer$enableResultCheck$2.INSTANCE);
        this.E = new CompositeDisposable();
        this.J = new LyricFontHelper();
    }

    public final boolean c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L12;
        AudienceLyricsRecognizer r0 = this.C;
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.f != true) goto L10;
        return true;
    L12:
        return this.w;
    }

    public final boolean h() {
        return this.v;
    }

    public final void f(ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ALogger.i("LinkSpeechServerRecognizer", "detachLyricsView");
        r3.removeView(this.a);
    }

    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ALogger.i("LinkSpeechServerRecognizer", "setRecognizeResultListener");
        this.p = r4;
        AudienceLyricsRecognizer r1 = this.C;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r1.j = r4;
        return;
    }

    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r9) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getCurrentUiLayout());
    L6:
        if (r1 != null) goto L9;
    L10:
        if (r1 != null) goto L13;
    L14:
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.intValue() == 27) goto L19;
        return;
    L19:
        boolean r2 = false;
        if (r9 == null) goto L30;
        Iterator<T> r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L30;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r11.next();
        if (r3.getUserPosition() != 0) goto L23;
        if (r3.getLinkType() != 1) goto L23;
        r2 = true;
    L30:
        if (this.I == r2) goto L50;
        rb0.b r12 = this.H;
        this.I = r2;
        if (r2 == false) goto L34;
        long r4 = com.bytedance.android.live.ktv.common.util.a.a().getRoomId();
        this.E.add(((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).roomSongChanged(r4, "", false, null, null, 2).subscribe(com.bytedance.android.live.ktv.common.speech.f.a, g.a));
        return;
    L34:
        if (r12 == null) goto L36;
        r(String.valueOf(r12.a), r12.b, r12.c, r12.d, 1);
        return;
    L36:
        IInteractService r13 = jc1.k.f(IInteractService.class);
        if (r13 != null) goto L39;
        return;
    L39:
        if (r13.isAIMVStage() != true) goto L54;
        r("0", false, null, null, 1);
        return;
    L54:
        return;
    L50:
        return;
    L13:
        if (r1.intValue() == 21) goto L19;
    L9:
        if (r1.intValue() == 30) goto L19;
    L5:
        r1 = null;
        goto L6
    }

    public final void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        AudienceLyricsRecognizer r0 = this.C;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void q(k r8) {
        if (this.v == true) goto L5;
        return;
    L5:
        Disposable r0 = this.m;
        if (r0 != null) goto L8;
    L12:
        ALogger.i("LinkSpeechServerRecognizer", "recognizeSuccess, songName: " + r8.h + ", similarity: " + r8.f);
        u(r8, (System.currentTimeMillis() - r8.g) + ((long) (r8.d * ((double) 1000))), r8.e * 1000);
        String r1 = r8.c;
        String r2 = r8.b;
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        String r3 = n.c(r1, r2);
        Objects.toString(this.n);
        LyricComponentImplManager r4 = this.n;
        if (r4 == null) goto L18;
        LyricsDisplayConfig r5 = r4.f;
    L19:
        Objects.toString(r5);
        LyricComponentImplManager r6 = this.n;
        if (r6 == null) goto L26;
        LyricsDisplayConfig r7 = r6.f;
        if (r7 == null) goto L26;
        this.J.a(r8.m, r7);
        jg4.j r9 = n.a(r8.c, r3, r7);
        r9.d = r8.i;
        LyricComponentImplManager r11 = this.n;
        if (r11 == null) goto L26;
        r11.d(r9);
    L26:
        t();
        t r12 = this.p;
        if (r12 == null) goto L29;
        r12.c();
    L29:
        this.w = true;
        String r13 = s1.B(2131918191);
        if (PadConfigUtils.c() == true) goto L32;
        f2.c(r13, 0);
    L32:
        JSONObject r14 = new JSONObject();
        r14.put("toast", r13);
        JSONObject r15 = new JSONObject();
        r15.put("song_recognition_result", r14);
        ei6.a r16 = this.d;
        if (r16 == null) goto L37;
        si6.b r17 = r16.b();
        if (r17 == null) goto L37;
        r17.n(bj6.a.b(this.d), r15.toString());
    L37:
        String r18 = r8.b;
        int r19 = r8.getType();
        HashMap r21 = new HashMap();
        r21.put("is_recognition_success", GamePromoteDataContext.GAME_TYPE_MOBILE);
        if (r19 != 0) goto L40;
        String r22 = "fp";
    L41:
        r21.put("recognition_type", r22);
        if (r18 != null) goto L44;
    L47:
        boolean r23 = true;
    L48:
        if (r23 == true) goto L50;
        r21.put("recognition_song_id", r18);
    L50:
        r21.putAll(this.x);
        j0.l().sendLog("livesdk_anchor_ai_lyric_recognition", r21, new Object[]{IRoom.class});
        this.o = r8;
        if (this.F == true) goto L53;
        return;
    L53:
        if (((Boolean) this.y.getValue()).booleanValue() == true) goto L55;
        return;
    L55:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L62;
        t r24 = this.p;
        if (r24 == null) goto L63;
        r24.d(true);
        return;
    L63:
        return;
    L62:
        return;
    L44:
        if (r18.length() == 0) goto L47;
        r23 = false;
        goto L48
    L40:
        r22 = "cover";
        goto L41
    L18:
        r5 = null;
        goto L19
    L8:
        if (r0.isDisposed() == true) goto L12;
        Disposable r25 = this.m;
        if (r25 == null) goto L12;
        r25.dispose();
        goto L12
    }

    public final void j(ei6.a r6, com.bytedance.android.live.pushstream.d r7, kd2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "recognitionParams");
        ALogger.i("LinkSpeechServerRecognizer", "startRecognize, maxBufferSize: " + ((Number) this.q.getValue()).intValue() + ", isRetry: " + r8.c + ", interactId: " + r8.e);
        int r0 = mb0.h.a;
        mb0.h.a(((Number) this.q.getValue()).intValue(), r8.c, r8.e, r8.d);
        this.v = true;
        if (r8.c == true) goto L5;
        this.o = null;
    L5:
        this.t.set(true);
        this.u.set(true);
        this.s.set(0);
        this.r.clear();
        this.c = r7;
        this.d = r6;
        ((LinkedHashMap) this.x).clear();
        this.F = r8.d;
        this.G = r8.e;
        this.e = new e();
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L11;
        if (r8.d == false) goto L11;
        LiveWrappedAudioFrameCallbackMethod r9 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_RECORD;
    L14:
        if (r6 == null) goto L19;
        ri6.b r11 = r6.r();
        if (r11 == null) goto L19;
        r11.i(r9, LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_8000, LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO, this.e);
    L19:
        if (r8.c == true) goto L22;
        ALogger.i("LinkSpeechServerRecognizer", "onStart");
        v();
        this.B = Observable.interval(KtvSettingHelper.A().o(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r8), i.a);
        return;
    L22:
        return;
    L11:
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L13;
        r9 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_REMOTE_USER;
        goto L14
    L13:
        r9 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_MIXED;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(k r11, long r12, int r14) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        int r1 = 0;
        if (r0 == null) goto L5;
        boolean r2 = r0.isAIMVStage();
    L6:
        final JSONObject r4 = new JSONObject();
        if (r11 == null) goto L13;
        r4.put("lyrics_url", r11.c);
        r4.put("song_id", r11.b);
        r4.put("play_time", r12);
        r4.put("duration", r11.e);
        r4.put("song_title", r11.h);
        r4.put("lyric_type", r11.i);
        if (r2 == false) goto L13;
        if (r2.a(r11.m) == false) goto L13;
        r4.put("font_info", r11.m);
    L13:
        r4.put("state", r14);
        String r15 = this.G;
        if (r15 == null) goto L16;
        r4.put("singer_linkmic_id", r15);
    L16:
        if (r11 == null) goto L21;
        String r16 = r11.k;
        if (r16 == null) goto L21;
        if (r4.put("emo_tag", r16) == null) goto L21;
    L23:
        if (r11 == null) goto L38;
        List<MusicInterval> r3 = r11.l;
        if (r3 == null) goto L38;
        Iterator<T> r5 = r3.iterator();
        String r6 = "";
        int r7 = 0;
    L28:
        if (r5.hasNext() == false) goto L36;
        MusicInterval r8 = (MusicInterval) r5.next();
        r6 = r6 + '[' + r8.getStartMs() + ',' + n8.a(r8) + "], ";
        long r9 = r8.getStartMs();
        long r13 = n8.a(r8);
        if (r9 > r12) goto L28;
        if (r13 < r12) goto L28;
        r7 = 1;
        goto L28
    L36:
        if (r4.put("refrain", r7) == null) goto L39;
    L40:
        boolean r17 = r7;
        t r18 = this.p;
        if (r18 == null) goto L48;
        if (r11 == null) goto L44;
        String r19 = r11.k;
    L45:
        if (r17 != 1) goto L47;
        r1 = 1;
    L47:
        r18.b(r19, Integer.valueOf(r1));
        goto L48
    L44:
        r19 = null;
    L48:
        com.bytedance.android.live.pushstream.d r21 = this.c;
        if (r21 == null) goto L51;
        r21.c1("music_recognition_result", r4, 1, false, false);
    L51:
        Long r110 = com.bytedance.android.live.liveinteract.utils.a.a;
        com.bytedance.android.live.liveinteract.utils.a.b(Boolean.valueOf(r17));
        return;
    L39:
        new LinkSpeechServerRecognizer$sendSei$5(r4);
    L38:
        r7 = 0;
    L21:
        new LinkSpeechServerRecognizer$sendSei$3(r4);
        goto L23
    L5:
        r2 = false;
        goto L6
    }

    public final void u(k r8, long r9, int r11) {
        Ref.LongRef r2 = new Ref.LongRef();
        r2.element = ((long) KtvSettingHelper.A().l()) + r9;
        Disposable r0 = this.l;
        if (r0 != null) goto L5;
    L9:
        int r3 = KtvSettingHelper.A().m();
        Ref.LongRef r4 = new Ref.LongRef();
        r4.element = 0;
        ALogger.e("LinkSpeechServerRecognizer", "startTimer, currentProgress=" + r9 + ", progress=" + r2.element + ", songDuration=" + r11);
        this.l = du2.a.b(0, 55, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r2, r3, r4, r8, r11));
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r1 = this.l;
        if (r1 == null) goto L9;
        r1.dispose();
        goto L9
    }

    public final void o(Context r22, ConstraintLayout r23, boolean r24, int r25) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "parent");
        ALogger.i("LinkSpeechServerRecognizer", "attachLyricsView, lyricsContainerView=" + this.a);
        ConstraintLayout r5 = this.a;
        TextView r6 = null;
        if (r5 == null) goto L11;
        ViewParent r7 = r5.getParent();
        if ((r7 instanceof ViewGroup) == true) goto L7;
        r7 = null;
    L7:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L10;
        r8.removeView(this.a);
    L10:
        this.a = null;
    L11:
        this.a = new SpeechLyricsView(r22, null, 6, 0);
        ViewGroup.LayoutParams r9 = new ConstraintLayout.LayoutParams(-1, -1);
        r23.addView(this.a);
        ((ConstraintLayout.LayoutParams) r9).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r9).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r9).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r9).bottomToBottom = 0;
        ConstraintLayout r2 = this.a;
        if (r2 == null) goto L14;
        r2.setLayoutParams(r9);
    L14:
        this.J.b = null;
        SpeechLyricsView r3 = this.a;
        if (r3 == null) goto L17;
        ViewPainter r4 = r3.getLyricsView();
    L19:
        if (r4 == null) goto L33;
        r4.setVisibility(0);
        ViewGroup.LayoutParams r11 = r4.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == true) goto L23;
        r11 = null;
    L23:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r12 == null) goto L26;
        ((ViewGroup.MarginLayoutParams) r12).height = UtilityKotlinExtentionsKt.i(48);
    L26:
        r4.setLayoutParams(r12);
        LyricsDisplayConfig r13 = new LyricsDisplayConfig();
        float r14 = UtilityKotlinExtentionsKt.h(16.0f);
        r13.a();
        r13.j = Float.valueOf(0.0f);
        r13.l.setTextSize(r14);
        r13.k.setTextSize(r14);
        r13.i.setTextSize(r14);
        r13.g = 2;
        if (r25 == 30) goto L31;
        if (r25 == 26) goto L31;
        Paint.Align r15 = Paint.Align.LEFT;
    L32:
        r13.e(r15, 1);
        Paint.FontMetrics r16 = r13.l.getFontMetrics();
        float r17 = (UtilityKotlinExtentionsKt.i(24) + r14) / 2.0f;
        r13.q = new LinearGradient(0.0f, r17 + r16.ascent, 0.0f, r17 + r16.descent, ColorProtector.parseColor("#FFFFE267"), ColorProtector.parseColor("#FFFF994F"), Shader.TileMode.CLAMP);
        r13.h.b = 0.0f;
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r4, "painter");
        Intrinsics.checkNotNullParameter(r22, "context");
        this.n = new LyricComponentImplManager(r22, r13, new com.bytedance.component.lyric.a(r22, r4));
    L31:
        r15 = Paint.Align.CENTER;
    L33:
        SpeechLyricsView r1 = this.a;
        if (r1 == null) goto L36;
        r6 = r1.getAiTipsTextView();
    L36:
        if (r25 == 30) goto L41;
        if (r25 == 26) goto L41;
        if (r6 == null) goto L43;
        r6.setGravity(19);
    L43:
        k r18 = this.o;
        if (r18 == null) goto L58;
        u(r18, (System.currentTimeMillis() - r18.g) + ((long) (r18.d * ((double) 1000))), r18.e * 1000);
        String r19 = r18.c;
        String r21 = r18.b;
        if (r21 != null) goto L49;
        r21 = "";
    L49:
        String r26 = n.c(r19, r21);
        LyricComponentImplManager r27 = this.n;
        if (r27 == null) goto L56;
        LyricsDisplayConfig r28 = r27.f;
        if (r28 == null) goto L56;
        this.J.a(r18.m, r28);
        jg4.j r29 = n.a(r18.c, r26, r28);
        r29.d = r18.i;
        LyricComponentImplManager r31 = this.n;
        if (r31 == null) goto L56;
        r31.d(r29);
    L56:
        t();
    L58:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L68;
        this.C = new AudienceLyricsRecognizer(this.n, this.p, this.a, r24, true);
        Disposable r32 = this.k;
        if (r32 != null) goto L62;
    L66:
        this.k = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.ktv.common.speech.e(this));
        return;
    L62:
        if (r32.isDisposed() == true) goto L66;
        Disposable r33 = this.k;
        if (r33 == null) goto L66;
        r33.dispose();
        goto L66
    L68:
        return;
    L41:
        if (r6 == null) goto L43;
        r6.setGravity(17);
        goto L43
    L17:
        r4 = null;
        goto L19
    }

    public final void r(String r11, boolean r12, Long r13, Long r14, int r15) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.isAIMVStage();
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        if (r11 != null) goto L10;
        return;
    L10:
        rb0.b r2 = new rb0.b();
        r2.a = Long.valueOf(CastLongProtector.parseLong(r11));
        r2.b = r12;
        r2.c = r13;
        r2.d = r14;
        this.H = r2;
        if (this.I == false) goto L13;
        return;
    L13:
        long r3 = com.bytedance.android.live.ktv.common.util.a.a().getRoomId();
        this.E.add(((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).roomSongChanged(r3, r11, r12, r13, r14, r15).subscribe(c.a, d.a));
        return;
    L5:
        r1 = false;
        goto L6
    }
}
