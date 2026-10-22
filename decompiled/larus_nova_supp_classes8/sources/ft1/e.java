package ft1;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.mm;
import com.bytedance.android.livesdk.config.xm0;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements is2.g {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable a;
    public f b;
    public j c;
    public final String d;
    public final RoomBaseSession e;

    public static final class a {
    }

    static {
    }

    public final String businessTypeV2() {
        return "RoomCrashObserver";
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    public final String getSpm() {
        return null;
    }

    public final boolean isIgnored() {
        return false;
    }

    public final void onOrientationChangeV2(int r1) {
    }

    public final void onRoomBackgroundV2() {
    }

    public e(RoomBaseSession r2) {
        this.d = SourceType.DEFAULT;
        this.e = r2;
        this.a = new CompositeDisposable();
    }

    public final void onRoomPrepareV2(boolean r3) {
        if (r3 == false) goto L5;
        int r4 = b.a;
        ALogger.i("LiveCrashTagRecorder", hashCode() + ":room prepare");
        Map<String, String> r5 = d.a;
        d.d(hashCode());
        d.c(MapsKt.mapOf(new Pair[]{TuplesKt.to("live_sdk_entered", "false"), TuplesKt.to("live_room_source", this.d)}), hashCode());
        return;
    }

    public final void onRoomEnterV2(Room r6, ls2.a r7) {
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "enterExtra");
        Room r8 = jm2.a.e(r6);
        int r9 = b.a;
        if (mm.a.getValue().b() == false) goto L12;
        if (r8 == null) goto L12;
        RoomBaseSession r10 = this.e;
        if (r10 == null) goto L12;
        Context r11 = r10.getContext();
        if (r11 == null) goto L12;
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover create");
        if ((r11 instanceof Activity) == false) goto L12;
        j r2 = new j((Activity) r11, this.e);
        Intrinsics.checkNotNullParameter(r8, "room");
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover enter room");
        r2.b = String.valueOf(r8.id);
        r2.c = System.currentTimeMillis();
        Unit r12 = Unit.INSTANCE;
        this.c = r2;
    L12:
        ALogger.i("LiveCrashTagRecorder", hashCode() + ":room enter");
        int r13 = c.a;
        LinkedHashMap r14 = new LinkedHashMap();
        if (r8 != null) goto L93;
    L40:
        r14.put("live_sdk_entered", "true");
        Map<String, String> r0 = d.a;
        d.c(r14, hashCode());
        MiddlewareRoomContext.a r15 = MiddlewareRoomContext.Companion;
        if (r8 == null) goto L43;
        long r3 = r8.getRoomId();
    L44:
        MiddlewareRoomContext r16 = MiddlewareRoomContext.a.c(r15, null, r3, 1);
        IInteractService r17 = jc1.k.f(IInteractService.class);     // Catch: Exception -> L85
        if (r17 == null) goto L50;
        int r18 = r17.getCurrentScene();     // Catch: Exception -> L85
        if (r18 < 0) goto L50;
        d.b(String.valueOf(r18), hashCode());     // Catch: Exception -> L85
    L50:
        if (r16 == null) goto L62;
        com.bytedance.live.datacontext.j r19 = r16.getVideoTalkRoomSubScene();     // Catch: Exception -> L85
        if (r19 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r20 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r19.getValue();     // Catch: Exception -> L85
        if (r20 == null) goto L62;
        BehaviorSubject r21 = r20.a();     // Catch: Exception -> L85
        if (r21 == null) goto L62;
        Disposable r22 = r21.subscribe(new g(this));     // Catch: Exception -> L85
        if (r22 == null) goto L62;
        CompositeDisposable r1 = this.a;     // Catch: Exception -> L85
        if (r1 == null) goto L62;
        r1.add(r22);     // Catch: Exception -> L85
    L62:
        if (r16 == null) goto L74;
        com.bytedance.live.datacontext.j r23 = r16.getVoiceTalkRoomSubScene();     // Catch: Exception -> L85
        if (r23 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r24 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r23.getValue();     // Catch: Exception -> L85
        if (r24 == null) goto L74;
        BehaviorSubject r25 = r24.a();     // Catch: Exception -> L85
        if (r25 == null) goto L74;
        Disposable r26 = r25.subscribe(new h(this));     // Catch: Exception -> L85
        if (r26 == null) goto L74;
        CompositeDisposable r4 = this.a;     // Catch: Exception -> L85
        if (r4 == null) goto L74;
        r4.add(r26);     // Catch: Exception -> L85
    L74:
        if (r16 == null) goto L87;
        m r27 = r16.isMultiAnchorLinkOn();     // Catch: Exception -> L85
        if (r27 == null) goto L87;
        Observable r28 = r27.a();     // Catch: Exception -> L85
        if (r28 == null) goto L87;
        Disposable r29 = r28.subscribe(new i(this));     // Catch: Exception -> L85
        if (r29 == null) goto L87;
        CompositeDisposable r30 = this.a;     // Catch: Exception -> L85
        if (r30 == null) goto L87;
        r30.add(r29);     // Catch: Exception -> L85
    L87:
        int r31 = b.a;
        xm0 r32 = xm0.a;
        if (r32.getValue().booleanValue() == true) goto L90;
        return;
    L90:
        if (r32.getValue().booleanValue() == false) goto L98;
        f r33 = new f(this, new WeakReference(this.e));
        this.b = r33;
        Npth.registerCrashCallback(r33, CrashType.ALL);
        return;
    L98:
        return;
    L85:
        e = move-exception;
        int r34 = b.a;
        ALogger.e("LiveCrashTagRecorder", "monitor live scene error:" + e.toString());
        goto L87
    L43:
        r3 = 0;
        goto L44
    L93:
        EpisodeExtraInfo r5 = r8.getEpisodeExtra2();     // Catch: Exception -> L38
        if (r5 == null) goto L19;
        Long r35 = r5.getSeasonId();     // Catch: Exception -> L38
        if (r35 == null) goto L19;
        r14.put("live_season_id", String.valueOf(r35.longValue()));     // Catch: Exception -> L38
    L19:
        r14.put("live_room_id", String.valueOf(r8.getRoomId()));     // Catch: Exception -> L38
        r14.put("live_anchor_id", r8.getOwnerUserIdString());     // Catch: Exception -> L38
        LiveMode r36 = r8.getStreamType();     // Catch: Exception -> L38
        int r37 = h1.a;     // Catch: Exception -> L38
        r14.put("live_room_type", i1.a(r36));     // Catch: Exception -> L38
        if (r8.isPaidRoom() == false) goto L22;
        String r38 = "1";
    L23:
        r14.put("is_paidlive", r38);     // Catch: Exception -> L38
        EpisodeExtraInfo r39 = r8.getEpisodeExtra2();     // Catch: Exception -> L38
        if (r39 == null) goto L30;
        IBaseEpisodeMod r40 = r39.getMod();     // Catch: Exception -> L38
        if (r40 == null) goto L30;
        String r41 = c.a(Integer.valueOf(r40.getEpisodeStage()));     // Catch: Exception -> L38
        if (r41 == null) goto L30;
        r14.put("live_episode_stage", r41);     // Catch: Exception -> L38
    L30:
        String r42 = c.b(r8.getEpisodeExtra2());     // Catch: Exception -> L38
        if (r42 == null) goto L33;
        r14.put("live_episode_sub_type", r42);     // Catch: Exception -> L38
    L33:
        String r43 = g4.d();     // Catch: Exception -> L38
        if (r43 == null) goto L36;
        r14.put("enter_from_merge", r43);     // Catch: Exception -> L38
    L36:
        r14.put("enter_method", g4.e());     // Catch: Exception -> L38
        Unit r44 = Unit.INSTANCE;     // Catch: Exception -> L38
        goto L40
    L22:
        r38 = "0";
    L38:
        e = move-exception;
        ALogger.e("LiveCrashTag", "get room info map error:" + e.toString());
        Unit r45 = Unit.INSTANCE;
        goto L40
    }

    public final void onRoomPreloadV2(Room r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "room");
        Intrinsics.checkNotNullParameter(r1, "room");
    }

    public final void onRoomExitV2(long r1, String r3, boolean r4, Room r5, ls2.e r6, boolean r7, EndReason r8) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r8, "reason");
        if (r7 == true) goto L20;
        return;
    L20:
        j r2 = this.c;     // Catch: Exception -> L17
        if (r2 == null) goto L9;
        int r9 = b.a;     // Catch: Exception -> L17
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover exit room");     // Catch: Exception -> L17
        r2.b = "";     // Catch: Exception -> L17
    L9:
        this.c = null;     // Catch: Exception -> L17
        int r10 = b.a;     // Catch: Exception -> L17
        ALogger.i("LiveCrashTagRecorder", hashCode() + ":room exit");     // Catch: Exception -> L17
        f r11 = this.b;     // Catch: Exception -> L17
        if (r11 == null) goto L12;
        Npth.unregisterCrashCallback(r11, CrashType.ALL);     // Catch: Exception -> L17
        this.b = null;     // Catch: Exception -> L17
    L12:
        CompositeDisposable r12 = this.a;     // Catch: Exception -> L17
        if (r12 == null) goto L15;
        r12.dispose();     // Catch: Exception -> L17
    L15:
        Map<String, String> r13 = d.a;     // Catch: Exception -> L17
        d.a(hashCode());     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        int r14 = b.a;
        ALogger.e("LiveCrashTagRecorder", "exit room error:" + e.toString());
    }
}
