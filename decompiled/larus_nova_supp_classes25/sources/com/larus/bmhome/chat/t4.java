package com.larus.bmhome.chat;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.auth.PluginDetailDialogFragment;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hc8.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t4 implements Function1 {
    public final /* synthetic */ View a;
    public final /* synthetic */ BotModel b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Message f;
    public final /* synthetic */ com.larus.bmhome.chat.api.q0.a g;

    public /* synthetic */ t4(View r1, BotModel r2, Message r3, String r4, String r5, Message r6, com.larus.bmhome.chat.api.q0.a r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r22) {
        View r1 = this.a;
        final BotModel r10 = this.b;
        final Message r11 = this.c;
        final String r15 = this.d;
        final String r14 = this.e;
        final Message r6 = this.f;
        final com.larus.bmhome.chat.api.q0.a r7 = this.g;
        final PluginItem r12 = (PluginItem) r22;
        MarkdownResolver r2 = MarkdownResolver.a;
        if (r12 == null) goto L34;
        final Fragment r3 = com.larus.utils.e1.k(r1);
        if (r3 == null) goto L35;
        PluginDetailDialogFragment.a r13 = new PluginDetailDialogFragment.a();
        r13.a = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r12, "pluginItem");
        r13.b = r12;
        Function1<? super PluginAuthType, Unit> r9 = new u4(r10, r15, r11, r6, r7, r12, r14);
        Intrinsics.checkNotNullParameter(r9, "authClickListener");
        r13.c = r9;
        Function0<Unit> r0 = new v4(r10, r15, r11, r12, r14);
        Intrinsics.checkNotNullParameter(r0, "closeClickListener");
        r13.e = r0;
        Function1<? super String, Unit> r4 = new w4(r3, r12, r10, r11);
        Intrinsics.checkNotNullParameter(r4, "detailClickListener");
        r13.d = r4;
        PluginDetailDialogFragment r5 = new PluginDetailDialogFragment();
        r5.e = new com.larus.bmhome.chat.auth.d(r13, r5);
        FragmentManager r8 = r3.getChildFragmentManager();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "PluginDetailDialogFragment", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r5, r16) == false) goto L32;
    L13:
        PluginManagerDelegate r17 = PluginManagerDelegate.a;
        String r18 = r10.getBotId();
        String r19 = "";
        if (r18 != null) goto L16;
        r18 = "";
    L16:
        a r20 = r17.f(r18);
        String r21 = r11.getMessageId();
        if (r21 != null) goto L19;
        r21 = "";
    L19:
        String r23 = r11.getConversationId();
        if (r23 != null) goto L22;
        r23 = "";
    L22:
        String r24 = r12.pluginName;
        if (r24 != null) goto L25;
        r24 = "";
    L25:
        String r25 = r10.getBotId();
        if (r25 == null) goto L29;
        r19 = r25;
    L29:
        PluginAuthType r26 = r17.k(r19, r15);
        com.larus.bmhome.chat.auth.b r110 = (com.larus.bmhome.chat.auth.b) r20;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r21, "messageId");
        Intrinsics.checkNotNullParameter(r23, "conversationId");
        Intrinsics.checkNotNullParameter(r24, "pluginName");
        Intrinsics.checkNotNullParameter(r15, "pluginId");
        Intrinsics.checkNotNullParameter(r14, "previousPage");
        String r111 = r24;
        String r112 = r21;
        String r113 = r23;
        r110.e("chat_detail_page", r14, r111, r15, r112, r113, r110.a, com.larus.bmhome.chat.auth.b.j(r26));
        return Unit.INSTANCE;
    L32:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L12:
        r5.show(r8, "PluginDetailDialogFragment");
        goto L13
    L35:
        return Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    }
}
