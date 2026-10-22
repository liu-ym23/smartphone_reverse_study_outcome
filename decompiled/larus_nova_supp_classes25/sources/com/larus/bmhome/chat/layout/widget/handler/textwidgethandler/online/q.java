package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import android.content.ClipData;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.markdown.code.share.CodeShareHelper;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.utils.s3;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;
import tx9.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q implements lw8.c {
    public final /* synthetic */ k a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ CustomMarkdownTextView e;

    public final void a(final View r52, psc.d r53) {
        Intrinsics.checkNotNullParameter(r52, "view");
        Intrinsics.checkNotNullParameter(r53, "span");
        if (r53.c == true) goto L6;
        FLogger.a.i("MarkdownTextViewWidgetHandler", "CodeCopySpanClickListener is uncompleted");
        return;
    L6:
        this.a.b = SystemClock.elapsedRealtime();
        String r4 = "table";
        String r5 = null;
        if (r53.d == false) goto L28;
        CodeShareHelper r3 = CodeShareHelper.a;
        Context r1 = r52.getContext();
        String r6 = r53.b;
        String r7 = r53.a;
        r3.getClass();
        CodeShareHelper.b(r1, r6, r7);
        if (Intrinsics.areEqual(r53.a, "table") == false) goto L67;
        ri8.c r2 = ri8.c.a;
        String r8 = this.b.getMessageId();
        Integer r12 = this.a.a.o;
        String r9 = this.b.getConversationId();
        String r10 = this.a.a.d.e;
        String r17 = this.c.getBotId();
        hf8.a r11 = this.a.a;
        if (r11.p == false) goto L13;
        String r13 = "thinking_progress";
    L14:
        String r14 = r13;
        String r15 = r53.a;
        String r16 = r11.d.d;
        if (r16 != null) goto L17;
    L25:
        String r18 = "chat";
    L26:
        ri8.c.m(null, r8, r9, null, r18, null, r12, null, r14, null, r15, r17, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r10, null, null, null, "download_table", null, null, null, null, -536874327, 61);
        return;
    L17:
        if (r16.length() <= 0) goto L19;
        boolean r19 = true;
    L20:
        if (r19 == false) goto L22;
        r5 = r16;
    L22:
        if (r5 == null) goto L25;
        r18 = r5;
        goto L26
    L19:
        r19 = false;
        goto L20
    L13:
        r13 = "within_text";
        goto L14
    L67:
        return;
    L28:
        r52.post(new p(r52));
        if (Intrinsics.areEqual(r53.a, "table") == false) goto L34;
        String r20 = k.f(this.a, r53.b);
        if (z2.a.clipTableHtmlEnabled() == false) goto L33;
        ClipData r21 = ClipData.newHtmlText("info", r20, s3.a(r20));
    L35:
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L39;
        r22.d0();
        i1 r23 = i1.a;
        Context r24 = this.d;
        Intrinsics.checkNotNull(r21);
        r23.i(r24, r21, "bpea-markdown-text-copy");
    L39:
        if (AudioServiceDelegate.a.getAudioConfig().n(this.c) == false) goto L41;
        String r25 = "1";
    L42:
        String r26 = r25;
        ArtifactBlock r27 = com.larus.im.bean.message.a.n(this.b);
        String r28 = this.c.getBotId();
        ChatParam r29 = this.a.a.d;
        String r30 = r29.e;
        String r110 = r29.c;
        String r111 = this.b.getMessageId();
        String r31 = r53.a;
        String r112 = this.b.getConversationId();
        String r113 = this.b.getSectionId();
        boolean r114 = this.a.a.r;
        by7.e r47 = by7.h.g(this.e);
        StateFlowImpl r32 = ce8.c.a;
        JSONObject r46 = new JSONObject();
        ce8.c.c(r46);
        String r210 = com.larus.bmhome.chat.bean.d.u(this.b);
        String r115 = ko8.a.d;
        String r211 = ko8.a.b;
        String r212 = ko8.a.c;
        if (Intrinsics.areEqual(r53.a, "table") == true) goto L46;
        r4 = "code";
    L46:
        String r40 = r4;
        String r33 = com.larus.im.bean.message.a.c(this.b);
        if (r27 == null) goto L49;
        String r34 = r27.getResourceId();
    L50:
        if (r27 == null) goto L52;
        String r35 = r27.getResourceId();
    L53:
        if (r27 == null) goto L57;
        Integer r36 = r27.getResourceType();
        if (r36 == null) goto L57;
        String r37 = r36.toString();
    L58:
        if (r27 == null) goto L60;
        String r38 = r27.getArtifactMetaId();
    L61:
        if (r27 == null) goto L65;
        Integer r39 = r27.getResourceType();
        if (r39 == null) goto L65;
        r5 = r39.toString();
    L65:
        String r44 = com.larus.im.bean.message.a.r(this.b);
        String r45 = com.larus.im.bean.message.a.s(this.b);
        j0.a(r28, r30, "copy_button", "chat", null, r111, r110, r115, null, 1L, r31, r112, r113, Boolean.valueOf(r114), r26, null, "bot", ChatDraftItem.TYPE_TEXT, null, null, r210, r211, r212, null, null, null, r33, r34, r35, r37, r38, r5, null, null, r40, null, null, null, r44, r45, r46, r47, null, 1678765680, 4442140);
        return;
    L60:
        r38 = null;
    L57:
        r37 = null;
        goto L58
    L52:
        r35 = null;
        goto L53
    L49:
        r34 = null;
        goto L50
    L41:
        r25 = "0";
        goto L42
    L33:
        r21 = ClipData.newPlainText("info", r20);
        goto L35
    L34:
        r21 = ClipData.newPlainText("info", r53.b);
        goto L35
    }

    public q(k r1, Message r2, BotModel r3, Context r4, CustomMarkdownTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
