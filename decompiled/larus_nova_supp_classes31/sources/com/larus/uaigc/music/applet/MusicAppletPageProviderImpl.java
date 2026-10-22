package com.larus.uaigc.music.applet;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.music.widget.MusicDetailPagerFragment;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.uaigc.applet.IMusicAppletPageProvider;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/uaigc/music/applet/MusicAppletPageProviderImpl;", "Lcom/larus/uaigc/applet/IMusicAppletPageProvider;", "<init>", "()V", "createDefaultTemplateArguments", "Landroid/os/Bundle;", "createPage", "Landroidx/fragment/app/Fragment;", "url", "", "launchArguments", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicAppletPageProviderImpl implements IMusicAppletPageProvider {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MusicAppletPage.values().length];
            r0[MusicAppletPage.TEMPLATE_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MusicAppletPage.TEMPLATE_DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MusicAppletPage.CHAT_MUSIC_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public MusicAppletPageProviderImpl() {
    }

    @Override // com.larus.uaigc.applet.IMusicAppletPageProvider
    public final Bundle a() {
        AuthModelDelegate r0 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r1 = (com.larus.bmhome.chat.api.e0) r0.e().getValue();
        boolean r2 = false;
        if (r1 == null) goto L14;
        LaunchInfo r3 = r1.a;
        if (r3 == null) goto L14;
        String r4 = r3.W();
        if (r4 == null) goto L14;
        if (r4.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        String r8 = r4;
    L15:
        wc9.e r6 = (wc9.e) r0.y().getValue();
        if (r6 == null) goto L25;
        String r7 = r6.a;
        if (r7 == null) goto L25;
        if (r7.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L25;
        String r10 = r7;
    L27:
        if (r8 == null) goto L39;
        if (r10 == null) goto L39;
        IActionBarService r11 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r11 == null) goto L33;
        com.larus.bmhome.actionbar.model.z0 r12 = r11.e(1);
    L34:
        if (r12 != null) goto L37;
        FLogger.a.e("MusicAppletPageProvider", "create default music template arguments failed, actionBarItem is null");
        return null;
    L37:
        Bundle r13 = new Bundle();
        r13.putString("path", MusicAppletPage.TEMPLATE_LIST.getValue());
        r13.putString("argBotId", r8);
        r13.putString("argConversationId", r10);
        r13.putString("arg_chat_type", "default");
        r13.putString("argPreviousPage", "multi_task_manage");
        r13.putString("enter_method", "multi_task_manage");
        r13.putString("enter_from", "multi_task_manage");
        r13.putString("conversation_id", r10);
        r13.putParcelable("chat_param", new ChatParam(r10, r8, "multi_task_manage", "multi_task_manage", "default", 224));
        r13.putString("custom_action_bar_item", xt7.d.b.a(com.larus.bmhome.actionbar.model.z0.Companion.serializer(), r12));
        return r13;
    L33:
        r12 = null;
    L39:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("create default music template arguments failed, mainBotIdEmpty=");
        if (r8 != null) goto L42;
        boolean r16 = true;
    L43:
        r15.append(r16);
        r15.append(", conversationIdEmpty=");
        if (r10 != null) goto L46;
        r2 = true;
    L46:
        r15.append(r2);
        r14.e("MusicAppletPageProvider", r15.toString());
        return null;
    L42:
        r16 = false;
        goto L43
    L22:
        r9 = false;
    L25:
        r10 = null;
        goto L27
    L11:
        r5 = false;
    L14:
        r8 = null;
        goto L15
    }

    @Override // com.larus.uaigc.applet.IMusicAppletPageProvider
    public final Fragment b(String r63, Bundle r64) {
        Intrinsics.checkNotNullParameter(r63, "url");
        MusicAppletPage.a r2 = MusicAppletPage.Companion;
        int r3 = b.a[r2.a(r63, r64).ordinal()];
        if (r3 != 1) goto L5;
        int r4 = MusicTemplateAppletFragment.m;
        Intrinsics.checkNotNullParameter(r63, "url");
        MusicTemplateAppletFragment r10 = new MusicTemplateAppletFragment();
        Bundle r1 = new Bundle(r64);
        r1.putString("argument_url", r63);
        r10.setArguments(r1);
        return r10;
    L5:
        if (r3 != 2) goto L7;
    L11:
        e.a.getClass();
        MusicAppletPage r9 = r2.a(r63, r64);
        String r5 = r64.getString("data_key");
        if (r5 != null) goto L14;
        r5 = r2.query(r63, "data_key");
    L14:
        FrameLayout r11 = null;
        if (r5 != null) goto L17;
        ir8.b r12 = null;
    L25:
        if (r12 == null) goto L28;
        MusicCreationContent r0 = r12.b;
        if (r0 == null) goto L28;
    L58:
        MusicCreationContent r13 = r0;
    L60:
        if (r13 != null) goto L62;
        FLogger.a.e("MusicAppletDetailPageFactory", "music content is null");
        return null;
    L62:
        final MusicDetailPagerFragment r14 = new MusicDetailPagerFragment();
        if (r12 == null) goto L65;
        Message r6 = r12.e;
    L66:
        r14.n = r6;
        if (r12 == null) goto L71;
        com.larus.bmhome.music.player.j r15 = r12.a;
        if (r15 == null) goto L71;
        LifecycleCoroutineScope r20 = LifecycleOwnerKt.getLifecycleScope(r14);
        Message r7 = r12.e;
        kr8.n r8 = kr8.n.a;
        com.larus.bmhome.music.player.j r16 = com.larus.bmhome.music.player.j.a(r15, null, null, false, false, r20, 0, kr8.n.a(r64, r12.a, r13, r7, null, null, 48), "music_detail", true, null, null, null, false, false, r7, 50273279);
    L162:
        r14.p = r16;
        r14.o = r13;
        if (r12 == null) goto L165;
        boolean r17 = r12.d;
    L166:
        r14.q = r17;
        if (r12 == null) goto L169;
        int r18 = r12.c;
    L170:
        r14.z = r18;
        e.a.getClass();
        if (r9 == MusicAppletPage.TEMPLATE_DETAIL) goto L173;
        Function1 r19 = null;
    L174:
        r14.t = r19;
        if (r12 == null) goto L178;
        Function0 r21 = r12.g;
        if (r21 == null) goto L178;
    L179:
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r14.r = r21;
        if (r12 == null) goto L182;
        Function0 r22 = r12.h;
    L183:
        r14.u = r22;
        r14.v = new com.larus.uaigc.music.applet.b();
        r14.w = new c();
        r14.x = 2131240815;
        if (r12 == null) goto L186;
        r11 = r12.f;
    L186:
        r14.s = r11;
        r14.B = true;
        r14.C = new Bundle(r64);
        if (r12 == null) goto L201;
        Function1 r23 = r12.i;
        if (r23 == null) goto L201;
        r23.invoke(r14);
    L201:
        return r14;
    L182:
        r22 = null;
    L178:
        r21 = new com.larus.uaigc.music.applet.a();
        goto L179
    L173:
        r19 = new d(r14);
        goto L174
    L169:
        r18 = r64.getInt("init_progress", 0);
        goto L170
    L165:
        r17 = r64.getBoolean("out_pulling_finished", true);
    L71:
        e.a.getClass();
        String r24 = r64.getString("music_player_data");
        if (r24 != null) goto L74;
    L89:
        com.larus.bmhome.music.player.j r25 = null;
    L90:
        if (r25 != null) goto L92;
        com.larus.bmhome.music.player.j r44 = new com.larus.bmhome.music.player.j(null, null, null, null, null, 0, null, null, false, false, null, 0, null, null, null, false, null, null, null, false, false, null, false, false, null, null, 67108863);
    L93:
        LifecycleCoroutineScope r49 = LifecycleOwnerKt.getLifecycleScope(r14);
        if (r25 == null) goto L96;
        String r26 = r25.o();
    L97:
        if (r26 != null) goto L99;
    L102:
        boolean r27 = true;
    L103:
        if (r27 == false) goto L106;
        r26 = null;
    L106:
        if (r26 != null) goto L108;
        r26 = r13.getVid();
    L108:
        String r46 = r26;
        if (r25 == null) goto L111;
        String r28 = r25.p();
    L112:
        if (r28 != null) goto L114;
    L117:
        boolean r29 = true;
    L118:
        if (r29 == false) goto L122;
        r28 = null;
    L122:
        if (r28 != null) goto L126;
        r28 = r13.getVideoModel();
        if (r28 != null) goto L126;
        String r45 = "";
    L127:
        if (r25 == null) goto L129;
        String r30 = r25.n();
    L130:
        if (r30 != null) goto L132;
    L135:
        boolean r31 = true;
    L136:
        if (r31 == false) goto L139;
        r30 = null;
    L139:
        if (r30 != null) goto L143;
        r30 = r13.getTitle();
        if (r30 != null) goto L143;
        String r55 = "";
    L144:
        if (r25 == null) goto L146;
        String r32 = r25.f();
    L147:
        if (r32 != null) goto L149;
    L152:
        boolean r33 = true;
    L153:
        if (r33 == false) goto L156;
        r32 = null;
    L156:
        if (r32 != null) goto L160;
        r32 = r13.getChunkUrl();
        if (r32 != null) goto L160;
        String r56 = "";
    L161:
        r16 = com.larus.bmhome.music.player.j.a(r44, r45, r46, false, false, r49, 0, kr8.n.a(r64, r25, r13, null, null, null, 56), "music_detail", true, r55, r56, null, false, false, null, 66657087);
    L160:
        r56 = r32;
        goto L161
    L149:
        if (r32.length() == 0) goto L152;
        r33 = false;
        goto L153
    L146:
        r32 = null;
    L143:
        r55 = r30;
        goto L144
    L132:
        if (r30.length() == 0) goto L135;
        r31 = false;
        goto L136
    L129:
        r30 = null;
    L126:
        r45 = r28;
        goto L127
    L114:
        if (r28.length() == 0) goto L117;
        r29 = false;
        goto L118
    L111:
        r28 = null;
        goto L112
    L99:
        if (r26.length() == 0) goto L102;
        r27 = false;
        goto L103
    L96:
        r26 = null;
        goto L97
    L92:
        r44 = r25;
        goto L93
    L74:
        if (r24.length() <= 0) goto L76;
        boolean r34 = true;
    L77:
        if (r34 == true) goto L80;
        r24 = null;
    L80:
        if (r24 == null) goto L89;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L83
        Object r36 = Result.constructor-impl((com.larus.bmhome.music.player.j) com.larus.bmhome.music.protocol.a.a.fromJson(r24, com.larus.bmhome.music.player.j.class));     // Catch: Throwable -> L83
    L86:
        if (Result.isFailure-impl(r36) == false) goto L88;
        r36 = null;
    L88:
        r25 = (com.larus.bmhome.music.player.j) r36;
    L83:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L76:
        r34 = false;
        goto L77
    L65:
        r6 = null;
    L28:
        String r38 = r64.getString("music_content");
        if (r38 != null) goto L31;
    L59:
        r13 = null;
        goto L60
    L31:
        if (r38.length() <= 0) goto L33;
        boolean r39 = true;
    L34:
        if (r39 == false) goto L36;
        String r40 = r38;
    L37:
        if (r40 == null) goto L59;
        if (r9 == MusicAppletPage.TEMPLATE_DETAIL) goto L196;
    L194:
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L52
        Object r42 = Result.constructor-impl((MusicCreationContent) com.larus.bmhome.music.protocol.a.a.fromJson(r40, MusicCreationContent.class));     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r42) == false) goto L57;
        r42 = null;
    L57:
        r0 = (MusicCreationContent) r42;
    L52:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L196:
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L42
        Object r48 = Result.constructor-impl((bq8.a) com.larus.bmhome.music.protocol.a.a.fromJson(r40, bq8.a.class));     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r48) == false) goto L47;
        r48 = null;
    L47:
        r0 = (bq8.a) r48;
        if (r0 == null) goto L194;
    L42:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L36:
        r40 = null;
        goto L37
    L33:
        r39 = false;
        goto L34
    L17:
        ConcurrentHashMap r51 = ir8.a.a;
        Intrinsics.checkNotNullParameter(r5, "key");
        Object r52 = ir8.a.a.remove(r5);
        if (r52 != null) goto L20;
        r52 = null;
    L20:
        ir8.b r53 = (ir8.b) r52;
        if (r53 != null) goto L23;
        FLogger.a.e("MusicAppletDetailPageFactory", "detail data not found in cache, dataKey=".concat(r5));
    L23:
        r12 = r53;
        goto L25
    L7:
        if (r3 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }
}
