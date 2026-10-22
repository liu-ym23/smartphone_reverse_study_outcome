package com.larus.bmhome.chat.service.action;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.f3;
import tx9.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements b {
    public final a a;

    public h(a r2) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        this.a = r2;
    }

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(final wh8.a r26) {
        Intrinsics.checkNotNullParameter(r26, "data");
        com.larus.bmhome.chat.api.i r3 = this.a.a;
        if (ic8.n.p(r26.a) == false) goto L9;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), r3.a.getString(2131905448), null, false, 28);
        Function0<Unit> r1 = r3.i;
        if (r1 == null) goto L154;
        r1.invoke();
        return;
    L154:
        return;
    L9:
        if (NetworkUtils.isNetworkAvailable(r3.a.getContext()) == false) goto L146;
        wc9.e r4 = r26.a;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L20;
        ConversationModel.delete$default(this.a.b, r26.a, null, 2, null);
    L143:
        Function2<ConversationFeedActionType, wh8.a, Unit> r2 = r3.j;
        if (r2 == null) goto L147;
        r2.invoke(ConversationFeedActionType.DELETE, r26);
    L147:
        Function0<Unit> r6 = r3.i;
        if (r6 == null) goto L155;
        r6.invoke();
        return;
    L155:
        return;
    L20:
        if (ic8.n.m(r26.a) == false) goto L26;
        com.larus.bmhome.chat.api.i r7 = this.a.a;
        CommonDialog.a r8 = new CommonDialog.a();
        r8.i(r7.a.getString(2131908261));
        r8.g(r7.a.getString(2131908260));
        CommonDialog.a.f(r8, new f(this), r7.a.getString(2131901586), false, 12);
        CommonDialog.a.e(r8, new g(), r7.a.getString(2131908312), 4);
        r8.z = false;
        CommonDialog r9 = r8.a();
        FragmentManager r10 = r7.a.getChildFragmentManager();
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, null, r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r9, r11) == true) goto L143;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L151
    L25:
        r9.show(r10, null);
        goto L143
    L26:
        final com.larus.bmhome.chat.api.i r12 = this.a.a;
        int r13 = c.a;
        Intrinsics.checkNotNullParameter(r26, "data");
        if (AudioServiceDelegate.a.getAudioConfig().n(r26.b) == false) goto L29;
        String r14 = "1";
    L30:
        BotModel r15 = r26.b;
        if (r15 == null) goto L33;
        String r16 = r15.getBotId();
    L35:
        if (r16 != null) goto L37;
        r16 = "";
    L37:
        wc9.e r17 = r26.a;
        if (r17 == null) goto L40;
        String r18 = r17.a;
    L41:
        ChatControlTrace r19 = ChatControlTrace.b;
        if (r17 == null) goto L44;
        Integer r110 = r17.v;
    L45:
        String r111 = r19.g(r110, c.b(r26), c.a(r26));
        String r112 = r12.d;
        String r113 = r12.c;
        Function1<wh8.a, String> r114 = r12.h;
        if (r114 == null) goto L48;
        String r115 = (String) r114.invoke(r26);
    L49:
        String r116 = r26.e;
        if (r12.e == false) goto L52;
        String r117 = "1";
    L53:
        wc9.e r20 = r26.a;
        if (r20 == null) goto L61;
        Integer r21 = r20.t;
        if (r21 == null) goto L61;
        if (r21.intValue() != 8) goto L61;
        boolean r22 = true;
    L62:
        if (r22 == false) goto L64;
        String r23 = "archived";
    L65:
        String r24 = r23;
        JSONObject r25 = new JSONObject();
        r25.put("object_type", "chat");
        wc9.e r27 = r26.a;
        if (r27 == null) goto L77;
        String r28 = r27.I;
        if (r28 == null) goto L77;
        if (r28.length() <= 0) goto L72;
        boolean r29 = true;
    L73:
        if (r29 == true) goto L76;
        r28 = null;
    L76:
        if (r28 == null) goto L77;
    L78:
        r25.put("project_id", r28);
        f3.a(r16, r18, r111, r112, r113, r25, r115, r14, r116, r117, r24, 64);
        wc9.e r30 = r26.a;
        if (r30 == null) goto L86;
        Integer r31 = r30.j;
        if (r31 == null) goto L86;
        if (r31.intValue() != 3) goto L86;
        boolean r32 = true;
    L87:
        if (r32 == false) goto L96;
        Lazy r33 = q3.a;
        z3 r34 = q3.a();
        if (r34 == null) goto L96;
        BotModel r35 = r26.b;
        if (r35 == null) goto L96;
        final String r36 = r35.getBotId();
        if (r36 == null) goto L96;
        r34.n(new d(r36));
    L96:
        wc9.e r37 = r26.a;
        if (r37 == null) goto L104;
        Integer r38 = r37.f;
        if (r38 == null) goto L104;
        if (r38.intValue() != 1) goto L104;
        boolean r39 = true;
    L105:
        if (r39 == false) goto L111;
        ConversationModel r40 = this.a.b;
        BotModel r41 = r26.b;
        if (r41 == null) goto L109;
        String r42 = r41.getBotId();
    L110:
        r40.deleteRecommendBot(r42, new e(this, r26, r12));
    L116:
        wc9.e r43 = r26.a;
        if (r43 != null) goto L119;
    L121:
        boolean r44 = false;
    L122:
        if (r44 == true) goto L143;
        BotModel r45 = r26.b;
        if (r45 == null) goto L126;
        String r46 = r45.getBotId();
    L127:
        if (r46 != null) goto L129;
        String r118 = "";
    L130:
        String r119 = r12.d;
        BotModel r47 = r26.b;
        if (r47 == null) goto L133;
        String r48 = r47.getBgImgUrl();
    L135:
        if (o0.d(r48) == false) goto L137;
        String r120 = "1";
    L138:
        Function1<wh8.a, String> r49 = r12.h;
        if (r49 == null) goto L141;
        String r121 = (String) r49.invoke(r26);
    L142:
        w3.a(r118, r119, null, r120, null, null, r121, r26.e, null, null, null, r14, null, r12.b, 113908);
        goto L143
    L141:
        r121 = null;
        goto L142
    L137:
        r120 = "0";
        goto L138
    L133:
        r48 = null;
        goto L135
    L129:
        r118 = r46;
        goto L130
    L126:
        r46 = null;
        goto L127
    L119:
        if (ic8.n.r(r43) != true) goto L121;
        r44 = true;
        goto L122
    L109:
        r42 = null;
        goto L110
    L111:
        ConversationModel r50 = this.a.b;
        wc9.e r51 = r26.a;
        BotModel r52 = r26.b;
        if (r52 == null) goto L114;
        String r53 = r52.getBotId();
    L115:
        r50.delete(r51, r53);
        goto L116
    L114:
        r53 = null;
    L104:
        r39 = false;
    L86:
        r32 = false;
        goto L87
    L72:
        r29 = false;
    L77:
        r28 = "-";
        goto L78
    L64:
        r23 = "normal";
    L61:
        r22 = false;
        goto L62
    L52:
        r117 = "0";
        goto L53
    L48:
        r115 = null;
        goto L49
    L44:
        r110 = null;
        goto L45
    L40:
        r18 = null;
        goto L41
    L33:
        r16 = null;
        goto L35
    L29:
        r14 = "0";
        goto L30
    L13:
        if (ve8.c.a(r4) != true) goto L15;
        r5 = true;
        goto L17
    L146:
        t19.s r54 = t19.s.a;
        Context r55 = r3.a.getContext();
        r54.getClass();
        t19.s.b(r55, 2131908800, false);
        goto L147
    }
}
