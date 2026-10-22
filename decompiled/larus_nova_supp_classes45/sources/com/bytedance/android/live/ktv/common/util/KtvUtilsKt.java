package com.bytedance.android.live.ktv.common.util;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.en;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvUtilsKt {
    public static final Lazy a = null;

    public static final boolean I(int r1, int r2) {
        if (r1 != 9) goto L6;
        if (r2 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static final Set<Long> h() {
        return (Set) a.getValue();
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, KtvUtilsKt$hasReportedIdSet$2.INSTANCE);
    }

    public static final boolean j() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
    L6:
        if (r1 != null) goto L8;
    L16:
        return false;
    L8:
        if (r1.isAdmin() != true) goto L16;
        UserAttr r2 = r1.q();
        if (r2 == null) goto L16;
        List<Integer> r3 = r2.getAdminPrivileges();
        if (r3 == null) goto L16;
        LiveRoomPermission.D.getClass();
        if (r3.contains(Integer.valueOf(LiveRoomPermission.l.a)) != true) goto L16;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean v() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.i r1 = r0.getLiveMode();
        if (r1 == null) goto L7;
        LiveMode r2 = (LiveMode) r1.getValue();
    L9:
        if (r2 != LiveMode.SCREEN_RECORD) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public static final boolean A(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportLyricWithUrl");
        return !Lists.isEmpty(r1.a.getMLyricUrlList());
    }

    public static final boolean B(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportMidiWithPath");
        return !TextUtils.isEmpty(r1.q);
    }

    public static final boolean C(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportMidiWithUrl");
        return !TextUtils.isEmpty(r1.a.getMidiUrl());
    }

    public static final boolean D(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportOriginSwitchWithPath");
        if (F(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (y(r1) == false) goto L7;
        return true;
    }

    public static final boolean E(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportOriginSwitchWithUrl");
        if (G(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (z(r1) == false) goto L7;
        return true;
    }

    public static final boolean F(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportOriginWithPath");
        return !TextUtils.isEmpty(r1.n);
    }

    public static final boolean G(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportOriginWithUrl");
        AudioInfo r2 = r1.a.getMFullTrack();
        if (r2 == null) goto L5;
        String r3 = r2.getMUrl();
    L7:
        return !TextUtils.isEmpty(r3);
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean H(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportVocalWithUrl");
        return !TextUtils.isEmpty(r1.a.getVocalUrl());
    }

    public static final void b(TextView r6) {
        if (r6 == null) goto L25;
        int r0 = r6.getMaxWidth();
        int r1 = com.bytedance.android.livesdk.m.a;
        IMiddleWareHostContext r2 = jc1.k.f(IMiddleWareHostContext.class);
        boolean r3 = false;
        if (r2 == null) goto L8;
        HostLargeFontParam r4 = r2.getHostLargeFontModeParams();
        if (r4 == null) goto L8;
        boolean r5 = r4.isLargeFontMode();
    L10:
        if (r5 == false) goto L14;
        float r7 = com.bytedance.android.livesdk.m.a() + 0.1f;
        if (r7 <= 1.0f) goto L14;
        r0 = (int) (r0 / r7);
    L14:
        IMiddleWareHostContext r8 = jc1.k.f(IMiddleWareHostContext.class);
        if (r8 == null) goto L19;
        HostLargeFontParam r9 = r8.getHostLargeFontModeParams();
        if (r9 == null) goto L19;
        r3 = r9.isViewZoomEnable();
    L19:
        if (r3 == false) goto L23;
        float r11 = com.bytedance.android.livesdk.m.b() + 0.1f;
        if (r11 <= 1.0f) goto L23;
        r0 = (int) (r0 / r11);
    L23:
        r6.setMaxWidth(r0);
        return;
    L8:
        r5 = false;
        goto L10
    }

    public static final void c(KtvMusic r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$checkInfoAndReport");
        if (h().contains(Long.valueOf(r9.getMId())) == false) goto L5;
        return;
    L5:
        AudioInfo r0 = r9.getMFullTrack();
        boolean r1 = false;
        if (r0 == null) goto L26;
        Intrinsics.checkNotNullParameter(r0, "$this$isUrlEmpty");
        String r2 = r0.getMUrl();
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 != true) goto L26;
        AudioInfo r4 = r9.getMAccompanimentTrack();
        if (r4 == null) goto L26;
        Intrinsics.checkNotNullParameter(r4, "$this$isUrlEmpty");
        String r5 = r4.getMUrl();
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 != true) goto L26;
        h().add(Long.valueOf(r9.getMId()));
        mb0.d.h(r9, MusicInfoError.SONG_FILE_MISSING);
        goto L26
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
        goto L24
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L26:
        List r7 = r9.getMLyricUrlList();
        if (r7 != null) goto L29;
    L32:
        boolean r8 = true;
    L33:
        if (r8 == false) goto L35;
        h().add(Long.valueOf(r9.getMId()));
        mb0.d.h(r9, MusicInfoError.LYRICS_FILE_MUSSING);
    L35:
        KtvMusic.Companion.getClass();
        if (KtvMusic.a.a(r9) > 0) goto L39;
        h().add(Long.valueOf(r9.getMId()));
        mb0.d.h(r9, MusicInfoError.INVALID_DURATION);
    L39:
        if (r9.getMId() > 0) goto L41;
        h().add(Long.valueOf(r9.getMId()));
        mb0.d.h(r9, MusicInfoError.INVALID_ID);
    L41:
        String r11 = r9.getMTitle();
        if (r11 != null) goto L44;
    L47:
        boolean r12 = true;
    L48:
        if (r12 == false) goto L50;
        h().add(Long.valueOf(r9.getMId()));
        mb0.d.h(r9, MusicInfoError.INVALID_TITLE);
    L50:
        AudioInfo r13 = r9.getMFullTrack();
        if (r13 == null) goto L65;
        Intrinsics.checkNotNullParameter(r13, "$this$isAudioIdInvalid");
        r13.getMAudioId();
        if (r13.getMAudioId() > 0) goto L55;
        boolean r14 = true;
    L56:
        if (r14 != true) goto L66;
        AudioInfo r15 = r9.getMAccompanimentTrack();
        if (r15 == null) goto L67;
        Intrinsics.checkNotNullParameter(r15, "$this$isAudioIdInvalid");
        r15.getMAudioId();
        if (r15.getMAudioId() > 0) goto L62;
        r1 = true;
    L62:
        if (r1 != true) goto L68;
        h().add(Long.valueOf(r9.getMId()));
        mb0.d.h(r9, MusicInfoError.INVALID_AUDIO_ID);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L55:
        r14 = false;
        goto L56
    L65:
        return;
    L44:
        if (r11.length() == 0) goto L47;
        r12 = false;
        goto L48
    L29:
        if (r7.isEmpty() == true) goto L32;
        r8 = false;
        goto L33
    }

    public static final float d(float r1) {
        return (r1 * o.a) + 0.5f;
    }

    public static final String e(long r6) {
        long r0 = 60;
        long r2 = r6 / r0;
        long r7 = r6 % r0;
        long r1 = 10;
        if (r2 < r1) goto L5;
        String r3 = String.valueOf(r2);
    L7:
        if (r7 < r1) goto L9;
        String r8 = String.valueOf(r7);
    L11:
        return s1.C(2131918232, new Object[]{r3, r8});
    L9:
        r8 = "0" + r7;
        goto L11
    L5:
        r3 = "0" + r2;
        goto L7
    }

    public static int f(int r1) {
        return jc1.a.b().getResources().getColor(r1);
    }

    public static final String g(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getFirstUrl");
        List<String> r3 = r2.getUrls();
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((!r3.isEmpty()) == true) goto L8;
        r3 = null;
    L8:
        if (r3 != null) goto L10;
        return null;
    L10:
        return (String) CollectionsKt.firstOrNull(r3);
    }

    public static final int i(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getRemoveSongType");
        if (w(r1.a) == false) goto L8;
        if (m(r1) == true) goto L8;
        return RemoveSongSource.DownloadSongFail.getValue();
    L8:
        return RemoveSongSource.UNKNOWN.getValue();
    }

    public static final py.k k(py.k r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$ifValid");
        Intrinsics.checkNotNullParameter(r5, "$this$isValide");
        String r0 = g(r5);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L11:
        if (r0 != null) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L17;
        return r5;
    L17:
        return null;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
    L7:
        r4 = false;
        goto L8
    }

    public static final boolean l(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3);
        if (r4.exists() == true) goto L14;
    L16:
        return false;
    L14:
        if (r4.isFile() == false) goto L16;
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static final boolean m(MusicPanel r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$isMusicDownloaded");
        if (z(r8) == false) goto L8;
        if (G(r8) == false) goto L8;
        boolean r0 = q(r8);
    L15:
        if (A(r8) == false) goto L17;
        boolean r2 = l(r8.l);
    L19:
        if (C(r8) == false) goto L21;
        boolean r3 = l(r8.q);
    L23:
        if (vm2.h.d() == true) goto L25;
    L27:
        boolean r4 = true;
    L28:
        int r6 = com.bytedance.android.live.ktv.common.music.download.v.a;
        boolean r9 = FileUtils.checkFileExists(com.bytedance.android.live.ktv.common.music.download.v.a.a() + File.separator + r8.a.getMId());
        if (KtvSettingHelper.f() == false) goto L38;
        if (r9 == false) goto L36;
        if (r0 == false) goto L36;
        if (r2 == false) goto L36;
        if (r3 == false) goto L36;
        if (r4 == false) goto L36;
        return true;
    L36:
        return false;
    L38:
        if (r9 == false) goto L41;
        if (r0 == false) goto L41;
        return true;
    L41:
        return false;
    L25:
        if (H(r8) == false) goto L27;
        r4 = l(r8.p);
        goto L28
    L21:
        r3 = true;
        goto L23
    L17:
        r2 = true;
    L8:
        if (z(r8) == false) goto L11;
        Intrinsics.checkNotNullParameter(r8, "$this$isRealAccompanimentFileExists");
        r0 = l(r8.o);
        goto L15
    L11:
        if (G(r8) == false) goto L13;
        Intrinsics.checkNotNullParameter(r8, "$this$isRealOriginFileExists");
        r0 = l(r8.n);
        goto L15
    L13:
        r0 = true;
        goto L15
    }

    public static final boolean n(MusicPanel r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isMusicMainResourceDownloaded");
        Intrinsics.checkNotNullParameter(r6, "$this$isRealOriginFileExists");
        if (l(r6.n) == true) goto L8;
        Intrinsics.checkNotNullParameter(r6, "$this$isRealAccompanimentFileExists");
        if (l(r6.o) == true) goto L8;
        boolean r0 = false;
    L9:
        int r4 = com.bytedance.android.live.ktv.common.music.download.v.a;
        if (FileUtils.checkFileExists(com.bytedance.android.live.ktv.common.music.download.v.a.a() + File.separator + r6.a.getMId()) == false) goto L13;
        if (r0 == false) goto L13;
        return true;
    L13:
        return false;
    L8:
        r0 = true;
        goto L9
    }

    public static final boolean o(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isOnlySupportAccompanimentWithPath");
        if (F(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (y(r1) == false) goto L7;
        return true;
    }

    public static final boolean p(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isOnlySupportOriginWithPath");
        if (F(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (y(r1) == true) goto L7;
        return true;
    }

    public static final boolean q(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isRealOriginAndAccompanimentFileExists");
        if (l(r1.n) == true) goto L5;
    L7:
        return false;
    L5:
        if (l(r1.o) == false) goto L7;
        return true;
    }

    public static final boolean w(KtvMusic r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSelf");
        OrderInfo r2 = r1.getOrderInfo();
        if (r2 == null) goto L7;
        InteractiveSongUserInfo r3 = r2.getTopUser();
        if (r3 == null) goto L7;
        String r4 = r3.getIdString();
    L9:
        return Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n());
    L7:
        r4 = null;
        goto L9
    }

    public static final boolean x(KtvMusic r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSinger");
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        OrderInfo r2 = r1.getOrderInfo();
        if (r2 == null) goto L7;
        InteractiveSongUserInfo r3 = r2.getTopUser();
        if (r3 == null) goto L7;
        String r4 = r3.getIdString();
    L9:
        return Intrinsics.areEqual(r0, r4);
    L7:
        r4 = null;
        goto L9
    }

    public static final boolean y(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportAccompanimentWithPath");
        return !TextUtils.isEmpty(r1.o);
    }

    public static final boolean z(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSupportAccompanimentWithUrl");
        AudioInfo r2 = r1.a.getMAccompanimentTrack();
        if (r2 == null) goto L5;
        String r3 = r2.getMUrl();
    L7:
        return !TextUtils.isEmpty(r3);
    L5:
        r3 = null;
        goto L7
    }

    public static final int J(en r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$parse2Int");
        return Color.rgb((int) (r2.c() * r3), (int) (r2.b() * r3), (int) (r2.a() * r3));
    }

    public static final <T> T K(List<? extends T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeGet");
        int r0 = r1.size();
        if (r2 < 0) goto L7;
        if (r0 <= r2) goto L7;
        return (T) ListProtector.get(r1, r2);
    L7:
        return null;
    }

    public static final void L(View r0, boolean r1) {
        if (r1 == false) goto L4;
        String r2 = "已收藏";
    L5:
        r3.a(r0, r2);
        return;
    L4:
        r2 = "未收藏";
        goto L5
    }

    public static final void M(View r4, long r5) {
        long r0 = 60;
        long r2 = r5 / r0;
        long r6 = r5 % r0;
        StringBuilder r1 = new StringBuilder();
        r1.append(r2);
        r1.append(20998);
        r1.append(r6);
        r1.append(31186);
        r3.a(r4, r1.toString());
    }

    public static final void a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$adaptImageScaleInLargeFontMode");
        float r0 = com.bytedance.android.livesdk.m.a();
        if (r0 <= 1.0f) goto L6;
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        int r4 = (int) (r3 * r0);
        r1.width = r4;
        r1.height = r4;
        r2.setLayoutParams(r1);
        return;
    }

    public static final boolean r(HashMap<String, ? extends py.k> r5, HashMap<String, ? extends py.k> r6) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return true;
    L7:
        if (r5 == null) goto L24;
        if (r6 == null) goto L24;
        if (r6.size() == r5.size()) goto L13;
        return false;
    L13:
        List r7 = CollectionsKt.toMutableList(r6.keySet());
        Iterator r8 = CollectionsKt.toMutableList(r5.keySet()).iterator();
        int r2 = 0;
    L15:
        if (r8.hasNext() == false) goto L23;
        Object r3 = r8.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        if ((!Intrinsics.areEqual((String) CollectionsKt.getOrNull(r7, r2), (String) r3)) == true) goto L21;
        r2 = r4;
        goto L15
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean t(KtvMusic r5, KtvMusic r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$isSameMusicForOrder");
        long r0 = r5.getMId();
        if (r6 != null) goto L5;
    L20:
        return false;
    L5:
        if (r0 != r6.getMId()) goto L20;
        OrderInfo r7 = r5.getOrderInfo();
        String r1 = null;
        if (r7 == null) goto L11;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L11;
        String r9 = r8.getIdString();
    L12:
        OrderInfo r11 = r6.getOrderInfo();
        if (r11 == null) goto L18;
        InteractiveSongUserInfo r12 = r11.getTopUser();
        if (r12 == null) goto L18;
        r1 = r12.getIdString();
    L18:
        if (Intrinsics.areEqual(r9, r1) == false) goto L20;
        return true;
    L11:
        r9 = null;
        goto L12
    }

    public static final boolean u(MusicPanel r6, MusicPanel r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$isSameMusicPanelForOrder");
        KtvMusic r2 = null;
        if (((Boolean) vm2.h.k1.getValue(null, vm2.h.a[113(0x71, float:1.58E-43)])).booleanValue() == false) goto L9;
        KtvMusic r8 = r6.a;
        if (r7 == null) goto L8;
        r2 = r7.a;
    L8:
        return t(r8, r2);
    L9:
        HashMap r0 = r6.B;
        if (r0 == null) goto L17;
        if (r7 == null) goto L13;
        HashMap r4 = r7.B;
    L15:
        if (r(r0, r4) != true) goto L17;
        boolean r1 = true;
    L18:
        boolean r5 = r6.h;
        if (r7 == null) goto L21;
        boolean r9 = r7.h;
    L22:
        if (r5 != r9) goto L24;
        boolean r11 = true;
    L25:
        KtvMusic r12 = r6.a;
        if (r7 == null) goto L28;
        r2 = r7.a;
    L28:
        boolean r13 = t(r12, r2);
        if (r1 == false) goto L33;
        if (r11 == false) goto L33;
        if (r13 == false) goto L33;
        return true;
    L33:
        return false;
    L24:
        r11 = false;
        goto L25
    L21:
        r9 = false;
        goto L22
    L13:
        r4 = null;
    L17:
        r1 = false;
        goto L18
    }

    public static final boolean s(KtvMusic r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "$this$isSameMusicForOrder");
        Intrinsics.checkNotNullParameter(r6, "otherUid");
        if (r3.getMId() != r4) goto L13;
        OrderInfo r5 = r3.getOrderInfo();
        if (r5 == null) goto L9;
        InteractiveSongUserInfo r7 = r5.getTopUser();
        if (r7 == null) goto L9;
        String r8 = r7.getIdString();
    L11:
        if (Intrinsics.areEqual(r8, r6) == false) goto L13;
        return true;
    L9:
        r8 = null;
    L13:
        return false;
    }
}
