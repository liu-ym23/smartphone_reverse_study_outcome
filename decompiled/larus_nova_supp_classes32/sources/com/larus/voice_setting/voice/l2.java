package com.larus.voice_setting.voice;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.InputDialog;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.dialog.CreateUgcVoiceDialog;
import com.larus.voice_setting.voice.dialog.UgcVoiceInfoEditDialog;
import com.larus.voice_setting.voice.dialog.v2.UgcVoiceContainerDialog;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l2 {
    public static String a;
    public static final Keva b = null;

    public static final class a implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ SpeakerVoice a;
        public final /* synthetic */ o2 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public final void confirm() {
            UgcVoiceLoader r0 = UgcVoiceLoader.a;
            SpeakerVoice r1 = this.a;
            o2 r2 = this.b;
            boolean r3 = false;
            if (r2 != null) goto L5;
        L7:
            boolean r4 = this.c;
            BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestDeleteVoice$1(r1, r3, r4, null), 3, null);
            com.larus.voice_setting.voice.base.g1 r5 = com.larus.voice_setting.voice.base.g1.a;
            String r6 = this.d;
            Intrinsics.checkNotNullParameter(r6, "enterFrom");
            com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
            JSONObject r8 = new JSONObject();
            r8.put("enter_from", r6);
            r8.put("current_page", r6);
            Unit r9 = Unit.INSTANCE;
            r7.reportEvent("complete_delete_own_voice", r8);
            return;
        L5:
            if (r2.c != 1) goto L7;
            r3 = true;
            goto L7
        }

        public a(SpeakerVoice r1, o2 r2, boolean r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public b() {
        }

        public final void cancel() {
        }
    }

    public static final class c implements com.larus.common_ui.dialog.y0 {
        public final /* synthetic */ SpeakerVoice a;
        public final /* synthetic */ o2 b;
        public final /* synthetic */ String c;

        public final void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "text");
            if (Intrinsics.areEqual(r10, this.a.getName()) == true) goto L11;
            UgcVoiceLoader r0 = UgcVoiceLoader.a;
            SpeakerVoice r1 = this.a;
            o2 r2 = this.b;
            boolean r3 = false;
            if (r2 != null) goto L7;
        L9:
            Intrinsics.checkNotNullParameter(r10, "voiceName");
            BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestEditVoiceName$1(r1, r3, r10, null), 3, null);
            com.larus.voice_setting.voice.base.g1 r11 = com.larus.voice_setting.voice.base.g1.a;
            String r12 = this.c;
            Intrinsics.checkNotNullParameter(r12, "enterFrom");
            com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
            JSONObject r5 = new JSONObject();
            r5.put("enter_from", r12);
            Unit r13 = Unit.INSTANCE;
            r4.reportEvent("complete_change_own_voice_name", r5);
            return;
        L7:
            if (r2.c != 1) goto L9;
            r3 = true;
            goto L9
        }

        public c(SpeakerVoice r1, o2 r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public l2() {
    }

    static {
        a = NameKeys.UnloadStrategy_No_Strategy;
        Keva r1 = Keva.getRepo("UgcVoiceProvider");
        b = r1;
        AccountService r2 = AccountService.a;
        if (r2.isLogin().booleanValue() == false) goto L16;
        a = "voice_authorize_".concat(r2.getUserId());
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L9;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L9;
        Boolean r5 = Boolean.valueOf(r4.I1());
    L10:
        FLogger.a.i("UgcVoiceProvider", "[init] authorized = " + r5 + ", key = " + a);
        String r0 = a;
        if (r5 == null) goto L13;
        boolean r6 = r5.booleanValue();
    L14:
        r1.storeBoolean(r0, r6);
        return;
    L13:
        r6 = false;
    L9:
        r5 = null;
        goto L10
    }

    public static IconItem c() {
        t2a.c.a.getClass();
        t2a.c.a();
        s2a.a r0 = t2a.c.d;
        if (r0 == null) goto L8;
        List<IconItem> r1 = r0.a();
        if (r1 == null) goto L8;
        List r2 = CollectionsKt.filterNotNull(r1);
        if (r2 == null) goto L8;
    L12:
        if (r2 == null) goto L17;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L18;
        IconItem r6 = (IconItem) r5.next();
        r4.add(new IconItem(r6.getUri(), r6.getUrl()));
    L18:
        if (r4 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        return null;
    L26:
        IconItem r8 = (IconItem) CollectionsKt.random(r4, Random.Default);
        FLogger.a.i("UgcVoiceLoader", "icon:" + r8.getUrl());
        return r8;
    L20:
        if (r4.isEmpty() == true) goto L23;
        r7 = false;
        goto L24
    L17:
        r4 = null;
    L8:
        FLogger.a.i("VoiceMaterialRepo", "[getVoiceIconList]: get from audio config");
        AudioUserConfig r9 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r9 == null) goto L11;
        r2 = r9.getUgcVoiceIconList();
        goto L12
    L11:
        r2 = null;
        goto L12
    }

    public static boolean d() {
        String r0 = "voice_authorize_".concat(AccountService.a.getUserId());
        if (Intrinsics.areEqual(r0, a) == true) goto L5;
        FLogger.a.i("UgcVoiceProvider", "[isAuthorized] key = " + r0);
        a = r0;
    L5:
        Keva r1 = b;
        if (r1.contains(a) == true) goto L19;
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L12;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L12;
        Boolean r4 = Boolean.valueOf(r3.I1());
    L13:
        FLogger.a.i("UgcVoiceProvider", "[isAuthorized] authorized = " + r4);
        String r5 = a;
        if (r4 == null) goto L16;
        boolean r6 = r4.booleanValue();
    L17:
        r1.storeBoolean(r5, r6);
        goto L19
    L16:
        r6 = false;
    L12:
        r4 = null;
    L19:
        return r1.getBoolean(a, false);
    }

    public static void b(FragmentManager r2) {
        CreateUgcVoiceDialog r0 = null;
        if (r2 == null) goto L5;
        Fragment r3 = r2.findFragmentByTag("CreateUgcVoiceDialog");
    L7:
        if ((r3 instanceof CreateUgcVoiceDialog) == false) goto L9;
        r0 = (CreateUgcVoiceDialog) r3;
    L9:
        if (r0 == null) goto L19;
        r0.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L20;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public static String a(Context r14, List r15) {
        FLogger.a.i("UgcVoiceProvider", "[createDefaultVoiceName] list:" + r15);
        String r0 = AccountService.a.getNickname();
        boolean r3 = false;
        if (r14 != null) goto L5;
    L12:
        String r16 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        int r1 = 2;
        if (r15 == null) goto L39;
        Iterator r17 = r15.iterator();
        int r4 = 2;
        boolean r5 = false;
    L17:
        if (r17.hasNext() == false) goto L38;
        SpeakerVoice r6 = ((o2) r17.next()).a;
        if (r6 == null) goto L25;
        String r7 = r6.getName();
        if (r7 == null) goto L25;
        if (StringsKt.startsWith$default(r7, r16, false, 2, null) != true) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L17;
        String r9 = r6.getName();
        if (r9 == null) goto L36;
        List r10 = StringsKt.split$default(r9, new String[]{" "}, false, 0, 6, null);
        if (r10 == null) goto L36;
        String r11 = (String) CollectionsKt.last(r10);
        if (r11 == null) goto L36;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L36;
        int r13 = r12.intValue();
    L37:
        r4 = Math.max(r4, r13 + 1);
        r5 = true;
    L36:
        r13 = 0;
    L25:
        r8 = false;
        goto L26
    L38:
        r1 = r4;
        r3 = r5;
    L39:
        if (r3 == false) goto L42;
        r16 = r16 + ' ' + r1;
    L42:
        FLogger.a.i("UgcVoiceProvider", "[createDefaultVoiceName] name: " + r16);
        return r16;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == false) goto L10;
        r0 = r14.getString(2131905646);
    L10:
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        r16 = String.format(r14.getString(2131911069), Arrays.copyOf(new Object[]{r0}, 1));
        if (r16 != null) goto L13;
    L7:
        r18 = false;
        goto L8
    }

    public static void h(Context r7, FragmentManager r8, o2 r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, "enterFrom");
        boolean r1 = false;
        if (z2.a.I2() == false) goto L27;
        SpeakerVoice r11 = r9.a;
        if (r11 == null) goto L44;
        UgcVoiceInfoEditDialog r12 = new UgcVoiceInfoEditDialog();
        IconItem r0 = r11.getIcon();
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 == null) goto L11;
        String r2 = r0.getUrl();
        if (r2 == null) goto L11;
    L12:
        r12.j = r2;
        IconItem r4 = r11.getIcon();
        if (r4 == null) goto L18;
        String r5 = r4.getUri();
        if (r5 == null) goto L18;
        r3 = r5;
    L18:
        r12.k = r3;
        r12.m = r11.getName();
        if (r11.getPrivateStatus() != 1) goto L21;
        r1 = true;
    L21:
        r12.n = r1;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r12.o = r11.getId();
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r12, r13) == true) goto L45;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L25:
        r12.show(r8, null);
        return;
    L45:
        return;
    L11:
        r2 = NameKeys.UnloadStrategy_No_Strategy;
        goto L12
    L44:
        return;
    L27:
        if (r7 != null) goto L29;
        return;
    L29:
        SpeakerVoice r6 = r9.a;
        if (r6 == null) goto L46;
        List r14 = CollectionsKt.emptyList();
        Boolean r15 = Boolean.TRUE;
        String r16 = r7.getString(2131911105);
        Intrinsics.checkNotNullParameter(r16, "title");
        String r17 = r6.getName();
        c r18 = new c(r6, r9, r10);
        Intrinsics.checkNotNullParameter(r18, "listener");
        InputDialog r19 = new InputDialog();
        r19.e = r15;
        r19.f = r16;
        r19.g = r17;
        r19.k = null;
        r19.l = r18;
        r19.m = null;
        r19.n = null;
        r19.h = 50;
        r19.i = r14;
        r19.j = false;
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, null, r20);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r19, r20) == true) goto L47;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L36:
        r19.show(r8, null);
        return;
    L47:
        return;
    }

    public static void g(Context r5, FragmentManager r6, o2 r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        Intrinsics.checkNotNullParameter(r8, "enterFrom");
        if (r7 == null) goto L37;
        SpeakerVoice r0 = r7.a;
        if (r0 == null) goto L38;
        CommonDialog.a r1 = new CommonDialog.a();
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r5 == null) goto L11;
        String r3 = r5.getString(2131901609);
        if (r3 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r3, "title");
        r1.a = r3;
        if (r5 == null) goto L16;
        String r4 = r5.getString(2131901608);
        if (r4 == null) goto L16;
    L17:
        Intrinsics.checkNotNullParameter(r4, "message");
        r1.i = r4;
        a r10 = new a(r0, r7, r9, r8);
        if (r5 == null) goto L21;
        String r11 = r5.getString(2131901586);
        if (r11 == null) goto L21;
    L22:
        CommonDialog.a.f(r1, r10, r11, false, 12);
        b r12 = new b();
        if (r5 == null) goto L28;
        String r13 = r5.getString(2131901585);
        if (r13 == null) goto L28;
        r2 = r13;
    L28:
        CommonDialog.a.e(r1, r12, r2, 4);
        CommonDialog r14 = r1.a();
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, null, r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r14, r15) == true) goto L39;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L32:
        r14.show(r6, null);
        return;
    L39:
        return;
    L21:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L12
    L38:
        return;
    }

    public static void e(FragmentManager r3, String r4, String r5, SearchMobParam r6, String r7, String r8, Function2 r9) {
        CreateUgcVoiceDialog r0 = new CreateUgcVoiceDialog();
        r0.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_title", r4), TuplesKt.to("create_enter_from", r5), TuplesKt.to("key_language", r8), TuplesKt.to("argSearchMobParam", r6), TuplesKt.to("argBotId", r7)}));
        r0.l = r9;
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "CreateUgcVoiceDialog", r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r10) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r0.show(r3, "CreateUgcVoiceDialog");
        return;
    }

    public static void f(FragmentManager r23, String r24, String r25, SearchMobParam r26, String r27, String r28, Function2 r29, boolean r30, String r31, boolean r32, String r33, String r34, int r35) {
        String r1 = r24;
        if ((r35 & 8) == 0) goto L5;
        SearchMobParam r8 = null;
    L7:
        if ((r35 & 16) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r35 & 32) != 0) goto L13;
        String r11 = r28;
    L18:
        if ((r35 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L20;
        boolean r7 = false;
    L21:
        Intrinsics.checkNotNullParameter(r23, "fragmentManager");
        Intrinsics.checkNotNullParameter(r25, "enterFrom");
        Intrinsics.checkNotNullParameter(r11, "language");
        Intrinsics.checkNotNullParameter(r29, "voiceCheckSuccess");
        Intrinsics.checkNotNullParameter(r31, "enterMethod");
        Intrinsics.checkNotNullParameter(r33, "clickFrom");
        Intrinsics.checkNotNullParameter(r34, "trackParamsStr");
        SearchMobParam r17 = r8;
        if (AudioServiceDelegate.a.getAudioConfig().o("voice_clone", "clone_button", true) == false) goto L30;
        f2a.c r0 = com.larus.voice_setting.voice.utils.k.a.b("CANNOT show create voice dialog because of downgrade");
        LinkedHashMap r12 = new LinkedHashMap();
        f2a.f r2 = new f2a.f("title");
        if (r1 != null) goto L26;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        r12.put(r2, r1);
        r12.put(new f2a.f("enter_from"), r25);
        f2a.f r3 = f2a.f.e;
        if (r10 != null) goto L29;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L29:
        r12.put(r3, r10);
        r12.put(new f2a.f("language"), r11);
        r12.put(new f2a.f("disable_animation"), Boolean.valueOf(r7));
        r12.put(f2a.f.u, r31);
        r12.put(new f2a.f("track_params"), r34);
        r12.put(new f2a.f("click_from"), r33);
        r0.d(r12);
        List r4 = CollectionsKt.listOf("VoiceCreate");
        f2a.g r5 = r0.c;
        r5.b = r4;
        r5.d = "UgcVoiceProvider.showCreateVoiceDialogV2";
        r5.e = r31;
        f2a.c.c(r0, null, 15);
        int r6 = y2a.a.a;
        JSONObject r9 = new JSONObject();
        r9.put("is_scheme", y2a.b.b(r32));
        r9.put("enter_method", y2a.b.a(r31));
        r9.put("result", "Fail");
        r9.put("reason", "Downgrade");
        r9.put("click_from", r33);
        y2a.a.b(r9);
        return;
    L30:
        String r13 = UUID.randomUUID().toString();
        f2a.c r14 = com.larus.voice_setting.voice.utils.k.a.b("try show create voice dialog");
        LinkedHashMap r15 = new LinkedHashMap();
        f2a.f r16 = new f2a.f("title");
        if (r1 != null) goto L33;
        String r18 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        r15.put(r16, r18);
        r15.put(new f2a.f("enter_from"), r25);
        f2a.f r19 = f2a.f.e;
        if (r10 != null) goto L37;
        String r20 = NameKeys.UnloadStrategy_No_Strategy;
    L38:
        r15.put(r19, r20);
        r15.put(new f2a.f("language"), r11);
        r15.put(new f2a.f("disable_animation"), Boolean.valueOf(r7));
        r15.put(f2a.f.u, r31);
        r15.put(new f2a.f("track_params"), r34);
        r15.put(new f2a.f("click_from"), r33);
        r14.d(r15);
        List r21 = CollectionsKt.listOf(new String[]{r13, "VoiceCreate"});
        f2a.g r110 = r14.c;
        r110.b = r21;
        r110.d = "UgcVoiceProvider.showCreateVoiceDialogV2";
        r110.e = r31;
        f2a.c.c(r14, null, 15);
        UgcVoiceContainerDialog r22 = new UgcVoiceContainerDialog();
        r22.d = r29;
        Bundle r36 = com.larus.utils.f.c(new Pair[0]);
        r36.putString("authorize_enter_from", r25);
        r36.putBoolean("key_start_show_authorize_dialog", !d());
        r36.putBoolean("key_disable_animation", r7);
        r36.putString("key_title", r1);
        r36.putString("create_enter_from", r25);
        r36.putString("key_language", r11);
        r36.putParcelable("argSearchMobParam", r17);
        r36.putString("argBotId", r10);
        r36.putString("key_enter_method", r31);
        r36.putString("key_log_trace_id", r13);
        r36.putString("track_params", r34);
        r36.putBoolean("key_from_voice_clone_scheme", r32);
        r22.setArguments(r36);
        LandscapeRestrictionOperation r37 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r22, "UgcVoiceContainerDialog", r37);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r22, r37) == false) goto L46;
    L43:
        int r38 = y2a.a.a;
        JSONObject r39 = new JSONObject();
        r39.put("is_scheme", y2a.b.b(r32));
        r39.put("enter_method", y2a.b.a(r31));
        r39.put("result", "Success");
        r39.put("click_from", r33);
        y2a.a.b(r39);
        return;
    L46:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L42:
        r22.show(r23, "UgcVoiceContainerDialog");
        goto L43
    L37:
        r20 = r10;
        goto L38
    L33:
        r18 = r1;
        goto L34
    L20:
        r7 = r30;
        goto L21
    L13:
        if (AppHost.a.isOversea() == false) goto L15;
        AppLocaleUtils.a.getClass();
        r11 = AppLocaleUtils.c().getLanguage();
        goto L18
    L15:
        r11 = "zh";
        goto L18
    L9:
        r10 = r27;
        goto L11
    L5:
        r8 = r26;
        goto L7
    }
}
