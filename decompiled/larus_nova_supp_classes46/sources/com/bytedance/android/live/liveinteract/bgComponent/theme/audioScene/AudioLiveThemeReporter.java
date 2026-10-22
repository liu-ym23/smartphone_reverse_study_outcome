package com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene;

import am2.x;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.ui.p;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import je0.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\"\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u0019\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010 \u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/audioScene/AudioLiveThemeReporter;", "Lcom/bytedance/android/live/ui/p;", "", "duration", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "newTheme", "", "isChange", "", "reportThemeDuration", "calculateDuration", "theme", "fromStart", "collectDurationParams", "", "", "collectAnchorParams", "collectAudienceParams", "reportAudienceThemeThemeDuration", "reportAnchorThemeSelectDuration", "params", "", "bgType", "putLiveTypeAndFunctionTypes", "type", "putFormatType", "logThemeShowWhenEnterRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", PbRequest.SwitchType.ROOM, "getCurrentPlayModesFromRoom", "onThemeStart", "onThemeChanged", "onThemeEnd", "startTime", "J", "lastTheme", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "cachedParams", "Ljava/util/Map;", "isAnchor", "Z", "<init>", "(Z)V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioLiveThemeReporter implements p {
    public static final a Companion = null;
    private static final Lazy reporter$delegate = null;
    private final Map<String, String> cachedParams;
    private boolean isAnchor;
    private IVoiceLiveTheme lastTheme;
    private long startTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        reporter$delegate = LazyKt.lazy(AudioLiveThemeReporter$Companion$reporter$2.INSTANCE);
    }

    private final long calculateDuration() {
        if (this.startTime > 0) goto L5;
        return 0;
    L5:
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    public static final /* synthetic */ Lazy access$getReporter$cp() {
        return reporter$delegate;
    }

    public AudioLiveThemeReporter(boolean r1) {
        this.isAnchor = r1;
        this.cachedParams = new LinkedHashMap();
    }

    public static final /* synthetic */ boolean access$isAnchor$p(AudioLiveThemeReporter r0) {
        return r0.isAnchor;
    }

    private final Map<String, String> collectAnchorParams(IVoiceLiveTheme r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L6;
        String r1 = r4.getImageUri();
        if (r1 == null) goto L6;
    L7:
        r0.put("pic_uri", r1);
        if (r4 == null) goto L10;
        Long r2 = Long.valueOf(r4.getId());
    L11:
        r0.put("template_id", String.valueOf(r2));
        if (r4 == null) goto L14;
        int r3 = r4.getBgType();
    L15:
        putLiveTypeAndFunctionTypes(r0, r3, r4);
        if (r4 == null) goto L18;
        int r5 = r4.getFormatType();
    L19:
        putFormatType(r0, r5);
        r0.put("play_mode", w.a());
        return r0;
    L18:
        r5 = 0;
        goto L19
    L14:
        r3 = 2;
        goto L15
    L10:
        r2 = null;
    L6:
        r1 = "";
        goto L7
    }

    private final String getCurrentPlayModesFromRoom(IRoom r10) {
        ArrayList r0 = new ArrayList();
        if (r10 == null) goto L15;
        z5 r11 = r10.getLinkerDetail();
        if (r11 == null) goto L15;
        List r12 = r11.getPlayModes();
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        String r2 = u0.k((int) ((Number) r13.next()).longValue());
        if ((!Intrinsics.areEqual(r2, "normal")) == false) goto L10;
        r0.add(r2);
    L15:
        if (d.f() != 16) goto L18;
        r0.add("link_room");
    L18:
        if (r0.size() != 0) goto L21;
        r0.add("normal");
    L21:
        return CollectionsKt.joinToString$default(r0, ",", "[", "]", 0, null, null, 56, null);
    }

    public void onThemeChanged(IVoiceLiveTheme r10) {
        if (r10 != null) goto L5;
    L36:
        if (r10 == null) goto L39;
        r10.setChoosing(false);
        return;
    L39:
        return;
    L5:
        if (r10.getChoosing() == true) goto L36;
        if (r10.getBgType() == 2) goto L15;
        if (r10.getBgType() == 5) goto L15;
        if (r10.getBgType() == 100) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(this.lastTheme, r10) == false) goto L18;
        return;
    L18:
        if (this.isAnchor == true) goto L30;
        int r1 = r10.getBgType();
        int r4 = c.a;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("template_id", String.valueOf(r10.getId()));
        String r6 = r10.getImageUri();
        String r7 = "";
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r5.put("pic_uri", r6);
        int r8 = r10.getFormatType();
        if (r8 == 1) goto L27;
        if (r8 != 2) goto L28;
        r7 = "dynamic";
    L28:
        r5.put("pic_type", r7);
        c.d(r5, r1);
        r5.put("play_mode", w.a());
        r5.put("template_id", String.valueOf(r10.getId()));
        j0.l().sendLog("livesdk_live_theme_show", r5, new Object[]{IRoom.class, x.class});
    L34:
        reportThemeDuration(calculateDuration(), r10, true);
        this.startTime = SystemClock.elapsedRealtime();
        this.lastTheme = r10;
        collectDurationParams(r10, false);
        return;
    L27:
        r7 = "static";
        goto L28
    L30:
        if (this.lastTheme == null) goto L32;
        boolean r2 = true;
    L33:
        c.b(r10, r2, r10.getBgType());
        goto L34
    L32:
        r2 = false;
        goto L33
    }

    public void onThemeEnd(IVoiceLiveTheme r4) {
        reportThemeDuration(calculateDuration(), r4, false);
        this.lastTheme = null;
        this.startTime = 0;
        this.cachedParams.clear();
    }

    public void onThemeStart(IVoiceLiveTheme r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getBgType() == 2) goto L12;
        if (r5.getBgType() == 5) goto L12;
        if (r5.getBgType() == 100) goto L12;
        return;
    L12:
        if (this.isAnchor == true) goto L15;
        logThemeShowWhenEnterRoom(r5, r5.getBgType());
    L19:
        this.startTime = SystemClock.elapsedRealtime();
        this.lastTheme = r5;
        collectDurationParams(r5, true);
        return;
    L15:
        if (this.lastTheme == null) goto L17;
        boolean r0 = true;
    L18:
        c.b(r5, r0, r5.getBgType());
        goto L19
    L17:
        r0 = false;
        goto L18
    }

    public static final /* synthetic */ void access$setAnchor$p(AudioLiveThemeReporter r0, boolean r1) {
        r0.isAnchor = r1;
    }

    private final Map<String, String> collectAudienceParams(IVoiceLiveTheme r5, boolean r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 == null) goto L6;
        String r1 = r5.getImageUri();
        if (r1 == null) goto L6;
    L7:
        r0.put("pic_uri", r1);
        IRoom r2 = null;
        if (r5 == null) goto L10;
        Long r3 = Long.valueOf(r5.getId());
    L11:
        r0.put("template_id", String.valueOf(r3));
        if (r5 == null) goto L14;
        int r4 = r5.getBgType();
    L15:
        putLiveTypeAndFunctionTypes(r0, r4, r5);
        if (r5 == null) goto L18;
        int r7 = r5.getFormatType();
    L19:
        putFormatType(r0, r7);
        if (r6 == false) goto L25;
        m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r8 == null) goto L24;
        r2 = (IRoom) r8.getValue();
    L24:
        String r9 = getCurrentPlayModesFromRoom(r2);
    L26:
        r0.put("play_mode", r9);
        return r0;
    L25:
        r9 = w.a();
        goto L26
    L18:
        r7 = 0;
        goto L19
    L14:
        r4 = 2;
        goto L15
    L10:
        r3 = null;
    L6:
        r1 = "";
        goto L7
    }

    private final void collectDurationParams(IVoiceLiveTheme r3, boolean r4) {
        this.cachedParams.clear();
        Map<String, String> r0 = this.cachedParams;
        if (this.isAnchor == false) goto L5;
        Map<String, String> r5 = collectAnchorParams(r3);
    L6:
        r0.putAll(r5);
        return;
    L5:
        r5 = collectAudienceParams(r3, r4);
        goto L6
    }

    private final void logThemeShowWhenEnterRoom(IVoiceLiveTheme r9, int r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("template_id", String.valueOf(r9.getId()));
        String r1 = r9.getImageUri();
        String r3 = "";
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.put("pic_uri", r1);
        int r2 = r9.getFormatType();
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L13;
        r3 = "dynamic";
    L13:
        r0.put("pic_type", r3);
        r0.put("template_id", String.valueOf(r9.getId()));
        c.d(r0, r10);
        m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L16;
        IRoom r12 = (IRoom) r11.getValue();
    L17:
        r0.put("play_mode", getCurrentPlayModesFromRoom(r12));
        j0.l().sendLog("livesdk_live_theme_show", r0, new Object[]{IRoom.class, x.class});
        return;
    L16:
        r12 = null;
        goto L17
    L12:
        r3 = "static";
        goto L13
    }

    private final void putFormatType(Map<String, String> r2, int r3) {
        if (r3 != 1) goto L5;
        String r4 = "static";
    L9:
        r2.put("pic_type", r4);
        return;
    L5:
        if (r3 == 2) goto L7;
        r4 = "";
        goto L9
    L7:
        r4 = "dynamic";
        goto L9
    }

    private final void reportAnchorThemeSelectDuration(IVoiceLiveTheme r4, long r5) {
        if (r5 != 0) goto L5;
        return;
    L5:
        this.cachedParams.put("duration", "" + r5);
        Map<String, String> r6 = this.cachedParams;
        if (r4 == null) goto L8;
        Long r7 = Long.valueOf(r4.getId());
    L9:
        r6.put("template_id", String.valueOf(r7));
        j0.l().sendLog("livesdk_anchor_theme_select_duration", MapsKt.toMap(this.cachedParams), new Object[]{IRoom.class, x.class});
        return;
    L8:
        r7 = null;
        goto L9
    }

    private final void putLiveTypeAndFunctionTypes(Map<String, String> r8, int r9, IVoiceLiveTheme r10) {
        int r3 = 0;
        if (r9 != 1) goto L5;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "ktv");
        if (r10 == null) goto L41;
        r3 = r10.getPlayMode();
    L41:
        if (r3 != 0) goto L44;
        r8.put("function_type2", "ktv");
    L44:
        if (TextUtils.isEmpty(r8.get("function_type2")) == false) goto L47;
        r8.put("function_type2", ((IInteractService) k.n(IInteractService.class)).getFunctionType2());
        return;
    L47:
        return;
    L5:
        if (r9 != 2) goto L7;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "radio");
        if (r10 == null) goto L24;
        int r11 = r10.getPlayMode();
    L25:
        if (r11 != 0) goto L27;
        r8.put("function_type2", "radio");
    L27:
        m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L30;
        IRoom r13 = (IRoom) r12.getValue();
    L32:
        if (d0.h(r13) == false) goto L44;
        r8.put("function_type", "party");
        if (r10 == null) goto L36;
        r3 = r10.getPlayMode();
    L36:
        if (r3 != 0) goto L44;
        r8.put("function_type2", "party");
        goto L44
    L30:
        r13 = null;
        goto L32
    L24:
        r11 = 0;
        goto L25
    L7:
        if (r9 != 5) goto L9;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "live");
        if (r10 == null) goto L19;
        r3 = r10.getPlayMode();
    L19:
        if (r3 != 0) goto L44;
        r8.put("function_type2", "radio");
        goto L44
    L9:
        if (r9 != 100) goto L44;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "chorus");
        if (r10 == null) goto L14;
        r3 = r10.getPlayMode();
    L14:
        if (r3 != 0) goto L44;
        r8.put("function_type2", "chorus");
        goto L44
    }

    private final void reportAudienceThemeThemeDuration(long r6, IVoiceLiveTheme r8, boolean r9) {
        if (r6 != 0) goto L5;
        return;
    L5:
        Map<String, String> r0 = this.cachedParams;
        String r3 = "anchor";
        if (r9 == true) goto L13;
        if (r8 != null) goto L10;
    L12:
        r3 = "leave";
        goto L13
    L10:
        if (r8.getChangeByAnchor() != true) goto L12;
        r8.setChangeByAnchor(false);
    L13:
        r0.put("end_type", r3);
        Map<String, String> r10 = this.cachedParams;
        if (r8 == null) goto L16;
        Long r11 = Long.valueOf(r8.getId());
    L17:
        r10.put("template_id", String.valueOf(r11));
        this.cachedParams.put("duration", "" + r6);
        j0.l().sendLog("livesdk_live_theme_duration", MapsKt.toMap(this.cachedParams), new Object[]{IRoom.class, x.class});
        return;
    L16:
        r11 = null;
        goto L17
    }

    private final void reportThemeDuration(long r2, IVoiceLiveTheme r4, boolean r5) {
        if (this.isAnchor == false) goto L5;
        reportAnchorThemeSelectDuration(r4, r2);
        return;
    L5:
        reportAudienceThemeThemeDuration(r2, r4, r5);
    }
}
