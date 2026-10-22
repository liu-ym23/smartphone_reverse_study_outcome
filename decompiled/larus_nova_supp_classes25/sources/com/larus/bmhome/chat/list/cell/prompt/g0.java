package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.bytedance.keva.Keva;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.bmhome.chat.layout.item.g3;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g0 implements View.OnClickListener {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ PromptContent c;

    public /* synthetic */ g0(PromptCell r1, Message r2, PromptContent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r24) {
        final PromptCell r2 = this.a;
        Message r0 = this.b;
        PromptContent r3 = this.c;
        String r4 = r2.I;
        if (r4 == null) goto L5;
        Keva r7 = PromptCell.Y;
        r7.storeBoolean("cur_prompt_collapse_state", false);
        r7.storeBoolean("last_prompt_message".concat(r4), true);
    L5:
        com.larus.bmhome.chat.api.q0 r5 = lf8.a.b(r2);
        if (r5 == null) goto L10;
        ChatMessageList r6 = r5.B7();
        if (r6 == null) goto L10;
        b0$a.b(r6, false, 14);
    L10:
        i1 r8 = r2.U;
        if (r8 == null) goto L96;
        PromptSpan r9 = r2.e;
        Long r10 = null;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r9 = null;
    L15:
        com.larus.bmhome.chat.api.q0 r11 = lf8.a.b(r2);
        Intrinsics.checkNotNullParameter(r0, "data");
        Intrinsics.checkNotNullParameter(r9, "span");
        Intrinsics.checkNotNullParameter(r3, "content");
        int r14 = r9.getBotViews().size();
        int r13 = r9.getSuggestViewList().size();
        FLogger.a.d("WcbSugPromptCell", "Expand button clicked， Report TIMESTAMP " + System.currentTimeMillis() + ", viewId:" + r9.getId());
        if (com.larus.bmhome.chat.bean.d.D(r0) != MessageTag.MessageTag_Unknown) goto L70;
        if (r11 == null) goto L21;
        ChatMessageList r12 = r11.B7();
        if (r12 == null) goto L21;
        Object r15 = r12.getTag(2131384073);
    L23:
        if (TypeIntrinsics.isMutableSet(r15) == false) goto L25;
        Set r16 = (Set) r15;
    L26:
        String r17 = r0.getMessageId();
        int r18 = gx9.o.a;
        Pair r19 = new Pair(r17, "onShowSuggestedPrompt");
        String r20 = com.larus.bmhome.chat.bean.d.i(r0);
        int r110 = g3.a;
        if (Intrinsics.areEqual(r20, "coco_spring_festival_2025") == false) goto L30;
        String r21 = "spring_suggest";
    L29:
        String r111 = r21;
        List<PromptContent.SuggestV2> r22 = r3.getSuggestV2();
        if (r22 == null) goto L48;
        PromptContent.SuggestV2 r23 = (PromptContent.SuggestV2) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L48;
        Integer r25 = r23.getSuggestType();
        if (r25 == null) goto L48;
        if (r25.intValue() != 5) goto L44;
        boolean r26 = true;
    L45:
        boolean r112 = true;
        if (r26 != true) goto L49;
        boolean r27 = true;
    L50:
        if (r27 == false) goto L58;
        List<PromptContent.SuggestV2> r28 = r3.getSuggestV2();
        if (r28 == null) goto L58;
        PromptContent.SuggestV2 r29 = (PromptContent.SuggestV2) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L58;
        PromptContent.SuggestV2ExtraForMultiAction r30 = r29.getSuggestV2ExtForMultiAction();
        if (r30 == null) goto L58;
        String r210 = r30.getShowFrom();
    L59:
        if (r16 != null) goto L61;
    L63:
        r112 = false;
    L64:
        if (r112 == false) goto L70;
        r16.add(r19);
        int r31 = gx9.o.a;
        String r32 = r0.getMessageId();
        if (r32 != null) goto L68;
        r32 = "";
    L68:
        gx9.o.g(r32, r0.getSenderId(), r13, r14, r111, r8.e(), r0.getSectionId(), com.larus.bmhome.chat.bean.d.x(r0).getActionBarKey(), "fold_button", r210, IAIChatControlTraceService.a.tb(r0));
        goto L70
    L61:
        if (r16.contains(r19) == true) goto L63;
    L58:
        r210 = null;
    L49:
        r27 = false;
        goto L50
    L44:
        r26 = false;
    L48:
        r112 = true;
        goto L49
    L30:
        List<PromptContent.SuggestV2> r33 = r3.getSuggestV2();
        if (r33 == null) goto L33;
        PromptContent.SuggestV2 r34 = (PromptContent.SuggestV2) CollectionsKt.firstOrNull(r33);
    L34:
        r21 = com.larus.bmhome.chat.bean.d.f1(r0, r34, null);
        goto L29
    L33:
        r34 = null;
        goto L34
    L25:
        r16 = null;
    L21:
        r15 = null;
    L70:
        if (r9.getImmerseBgColor() == null) goto L72;
        String r1 = "1";
    L73:
        int r35 = gx9.o.a;
        long r36 = r8.e();
        com.larus.bmhome.chat.trace.a r37 = IAIChatControlTraceService.a.gc(r36);
        if (r37 == null) goto L96;
        String r38 = r37.a;
        if (r38 == null) goto L79;
        Long r39 = StringsKt.toLongOrNull(r38);
    L80:
        String r40 = gx9.o.d(r36);
        String r41 = r37.g;
        if (r41 == null) goto L83;
        r10 = StringsKt.toLongOrNull(r41);
    L83:
        boolean r42 = o3.a;
        JSONObject r43 = new JSONObject();
        Intrinsics.checkNotNullParameter(r43, "params");
        if (r39 != null) goto L98;
    L88:
        if (r40 == null) goto L90;
        r43.put("chat_type", r40);     // Catch: JSONException -> L86
    L90:
        if (r10 == null) goto L92;
        r43.put("conversation_id", r10.longValue());     // Catch: JSONException -> L86
    L92:
        r43.put("is_immersive_background", r1);     // Catch: JSONException -> L86
    L95:
        TrackParams r44 = new TrackParams().merge(r43);
        by7.a r45 = new by7.a("click_suggest_prompt_fold");
        r45.a.merge(r44);
        r45.b();
    L86:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper mobShowSuggestPromptFold " + e.getLocalizedMessage());
        goto L95
    L98:
        r43.put("bot_id", r39.longValue());     // Catch: JSONException -> L86
        goto L88
    L79:
        r39 = null;
        goto L80
    L72:
        r1 = "0";
    L96:
        com.larus.utils.t0.a.post(new m0(r2));
    }
}
