package com.larus.bmhome.chat.list.cell.test;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ int c;
    public final /* synthetic */ CrowdTestSelectionCell d;

    public /* synthetic */ i(String r1, Message r2, int r3, CrowdTestSelectionCell r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        String r0 = this.a;
        Message r8 = this.b;
        int r2 = this.c;
        final BaseMessageListCell r9 = this.d;
        int r3 = CrowdTestSelectionCell.k;
        switch(r0.hashCode()) {
            case 48: goto L36;
            case 49: goto L26;
            case 50: goto L16;
            case 51: goto L6;
            default: goto L45;
        };
    L45:
        Triple r4 = new Triple(null, null, null);
    L46:
        String r7 = (String) r4.component1();
        Integer r6 = (Integer) r4.component2();
        MsgFeedbackType r5 = (MsgFeedbackType) r4.component3();
        if (r5 == null) goto L210;
        if (r6 == null) goto L210;
        LruCache r10 = ko8.a.a;
        String r11 = ((CrowdTestSelectionCell) r9).e;
        Intrinsics.checkNotNullParameter(r0, "result");
        Intrinsics.checkNotNullParameter(r8, "data");
        IAIChatControlTraceService.a.hc(r0, r8, r11, r7, null);
        FLogger.a.i("CrowdTestSelectionCell", "sendPromptSurveyClick buttonTypeString=" + r0 + ", message=" + r8.getMessageId() + ", botId=" + ((CrowdTestSelectionCell) r9).e + ", messageIdString=" + r7);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new CrowdTestSelectionCell$getReportTask$1$5(r9, r6, r5, null), 2, null);
        if (r5 != MsgFeedbackType.MsgFeedbackTypeBetter) goto L52;
    L53:
        int r12 = r6.intValue();
        Fragment r13 = lf8.a.d(r9);
        if (r13 == null) goto L210;
        FragmentManager r14 = r13.getChildFragmentManager();
        if (r14 == null) goto L210;
        DialogFragment r15 = r14.findFragmentByTag("crowdTestFeedbackDialogClose");
        if ((r15 instanceof DialogFragment) == false) goto L61;
        DialogFragment r16 = r15;
    L62:
        if (r16 != null) goto L216;
        Fragment r17 = lf8.a.d(r9);
        Intrinsics.checkNotNull(r17);
        r14.setFragmentResultListener("crowdTestFeedbackDialogClose", r17, new n(r9));
        Lazy r18 = e.a;
        Intrinsics.checkNotNullParameter(r5, "feedbackType");
        Intrinsics.checkNotNullParameter(r8, "message");
        AppHost.Companion r19 = AppHost.a;
        if (r19.isOversea() == false) goto L76;
        List r20 = CollectionsKt.plus(CollectionsKt.shuffled(CollectionsKt.listOf(new String[]{r19.getApplication().getString(2131909165), r19.getApplication().getString(2131909164), r19.getApplication().getString(2131909166), r19.getApplication().getString(2131909168), r19.getApplication().getString(2131909163)})), r19.getApplication().getString(2131909167));
        ArrayList r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L73:
        if (r22.hasNext() == false) goto L75;
        r21.add(new FeedbackMeta(r5.value, 0, (String) r22.next()));
        goto L73
    L75:
        FragmentManager r110 = r14;
        BaseMessageListCell r25 = r9;
        String r111 = null;
    L156:
        Bundle r1 = new Bundle();
        r1.putString("message_id", r8.getMessageId());
        Map r23 = r8.getExt();
        if (r23 == null) goto L159;
        String r24 = (String) r23.get("inner_log_id");
    L160:
        r1.putString("message_log_id", r24);
        Lazy r26 = e.a;
        Intrinsics.checkNotNullParameter(r0, "buttonTypeString");
        AppHost.Companion r27 = AppHost.a;
        if (r27.isOversea() == false) goto L179;
        int r28 = r0.hashCode();
        if (r28 == 48) goto L176;
        if (r28 == 49) goto L172;
        if (r28 == 51) goto L168;
    L194:
        String r29 = "";
    L196:
        r1.putString("feedback_title", r29);
        r1.putString("feedback_request_key", "crowdTestFeedbackDialogClose");
        r1.putInt("feedback_select_group_index", r12);
        r1.putBoolean("disable_copy_button", true);
        IAIChatService.Companion r30 = IAIChatService.a;
        Context r31 = lf8.a.getContext(r25);
        if (r31 == null) goto L199;
        r111 = r31.getString(2131908601);
    L199:
        DialogFragment r32 = r30.k7(r21, r111, r1);
        if (r32.isAdded() == true) goto L210;
        LandscapeRestrictionOperation r33 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L207
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r32, "crowdTestFeedbackDialogClose", r33);     // Catch: Exception -> L207
        FragmentManager r34 = r110;
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r34, r32, r33) == true) goto L210;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L211
    L205:
        r32.show(r34, "crowdTestFeedbackDialogClose");     // Catch: Exception -> L207
    L207:
        e = move-exception;
        FLogger.a.e("CrowdTestFeedbackDialog", "find feedback dialog exception: " + e);
        goto L210
    L168:
        if (r0.equals("3") == false) goto L194;
        r29 = StringsKt.replace$default(r27.getApplication().getString(2131909170), "%s", r27.getApplication().getString(2131909169), false, 4, null);
        goto L196
    L172:
        if (r0.equals("1") == false) goto L194;
        r29 = StringsKt.replace$default(r27.getApplication().getString(2131909170), "%s", r27.getApplication().getString(2131909161), false, 4, null);
        goto L196
    L176:
        if (r0.equals("0") == false) goto L194;
        r29 = StringsKt.replace$default(r27.getApplication().getString(2131909170), "%s", r27.getApplication().getString(2131909162), false, 4, null);
        goto L196
    L179:
        int r35 = r0.hashCode();
        if (r35 == 48) goto L193;
        if (r35 == 49) goto L189;
        if (r35 != 51) goto L194;
        if (r0.equals("3") == false) goto L194;
        r29 = r27.getApplication().getString(2131908620);
        Intrinsics.checkNotNull(r29);
        goto L196
    L189:
        if (r0.equals("1") == false) goto L194;
        r29 = StringsKt.replace$default(r27.getApplication().getString(2131908622), " {s_answerBad}", r27.getApplication().getString(2131908617), false, 4, null);
        goto L196
    L193:
        if (r0.equals("0") == false) goto L194;
        r29 = StringsKt.replace$default(r27.getApplication().getString(2131908622), " {s_answerBad}", r27.getApplication().getString(2131908618), false, 4, null);
        goto L196
    L159:
        r24 = r111;
        goto L160
    L76:
        r21 = new ArrayList();
        List r36 = r8.getSubListGroup();
        if (r36 == null) goto L83;
        List r37 = (List) CollectionsKt.getOrNull(r36, 0);
        if (r37 == null) goto L83;
        Message r38 = (Message) CollectionsKt.getOrNull(r37, 0);
        if (r38 == null) goto L83;
        Map r39 = r38.getExt();
    L84:
        if (r39 == null) goto L86;
        String r40 = (String) r39.get("llm_intention");
    L87:
        if (r39 == null) goto L89;
        String r41 = (String) r39.get("llm_intention_detail");
    L90:
        if (r40 != null) goto L92;
    L95:
        boolean r112 = true;
    L97:
        if (r112 == false) goto L106;
        if (r41 != null) goto L100;
    L103:
        boolean r113 = true;
    L104:
        if (r113 == false) goto L106;
        String r42 = "other";
    L107:
        Lazy r43 = e.a;
        if (((HashMap) r43.getValue()).containsKey(r42) == false) goto L110;
        String r44 = (String) ((HashMap) r43.getValue()).get(r42);
    L112:
        if (o0.d(r44) == true) goto L212;
        ArrayList r45 = null;
    L120:
        if (r45 != null) goto L122;
    L125:
        boolean r46 = true;
    L127:
        if (r46 == true) goto L129;
        r110 = r14;
        r25 = r9;
        r111 = null;
    L140:
        String r47 = AppHost.a.getApplication().getString(2131908609);
        ArrayList r48 = new ArrayList();
        Iterator r49 = r45.iterator();
    L142:
        if (r49.hasNext() == false) goto L146;
        Object r50 = r49.next();
        if (Intrinsics.areEqual((String) r50, r47) == false) goto L142;
        r48.add(r50);
        goto L142
    L146:
        ArrayList r51 = new ArrayList();
        Iterator r52 = r45.iterator();
    L148:
        if (r52.hasNext() == false) goto L152;
        Object r53 = r52.next();
        if ((!Intrinsics.areEqual((String) r53, r47)) == false) goto L148;
        r51.add(r53);
        goto L148
    L152:
        Iterator r54 = CollectionsKt.plus(CollectionsKt.shuffled(r51), r48).iterator();
    L154:
        if (r54.hasNext() == false) goto L156;
        r21.add(new FeedbackMeta(r5.value, 0, (String) r54.next()));
        goto L154
    L129:
        if (Intrinsics.areEqual(r42, "seed_main/writing") == false) goto L131;
        List r55 = CollectionsKt.listOf(new Integer[]{2131908614, 2131908604, 2131908606, 2131908613, 2131908608, 2131908611, 2131908609});
        r110 = r14;
        r25 = r9;
        r111 = null;
    L135:
        List r56 = r55;
        r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r56, 10));
        Iterator r57 = r56.iterator();
    L137:
        if (r57.hasNext() == false) goto L140;
        r45.add(AppHost.a.getApplication().getString(((Number) r57.next()).intValue()));
        goto L137
    L131:
        r110 = r14;
        r25 = r9;
        r111 = null;
        if (StringsKt.contains$default(r42, "browsing", false, 2, null) == false) goto L134;
        r55 = CollectionsKt.listOf(new Integer[]{2131908606, 2131908605, 2131908607, 2131908615, 2131908603, 2131908609});
        goto L135
    L134:
        r55 = CollectionsKt.listOf(new Integer[]{2131908612, 2131908610, 2131908607, 2131908912, 2131908606, 2131908609});
        goto L135
    L122:
        if (r45.isEmpty() == true) goto L125;
        r46 = false;
        goto L127
    L212:
        JSONArray r114 = new JSONArray(r44);     // Catch: Exception -> L115
    L116:
        r45 = new ArrayList();
        int r115 = r114.length();
        int r58 = 0;
    L117:
        if (r58 >= r115) goto L120;
        r45.add(JSONArrayProtectorUtils.getString(r114, r58));
        r58 = r58 + 1;
        r115 = r115;
    L115:
        r114 = new JSONArray("[]");
        goto L116
    L110:
        r44 = (String) ((HashMap) r43.getValue()).get("other");
        goto L112
    L100:
        if (r41.length() == 0) goto L103;
        r113 = false;
    L106:
        r42 = r40 + '/' + r41;
        goto L107
    L92:
        if (r40.length() == 0) goto L95;
        r112 = false;
        goto L97
    L89:
        r41 = null;
        goto L90
    L86:
        r40 = null;
    L83:
        r39 = null;
        goto L84
    L216:
        r16.dismiss();     // Catch: Exception -> L65
    L65:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r59 = DialogFragmentLancet.sLastShowStack;
        if (r59 == null) goto L210;
        com.bytedance.crash.d.d(r59, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L210
    L61:
        r16 = null;
        goto L62
    L52:
        if (r5 == MsgFeedbackType.MsgFeedbackTypeBothBad) goto L53;
    L210:
        return Unit.INSTANCE;
    L6:
        if (r0.equals("3") == false) goto L45;
        List r60 = r8.getSubListGroup();
        if (r60 == null) goto L13;
        List r61 = CollectionsKt.flatten(r60);
        if (r61 == null) goto L13;
        String r62 = CollectionsKt.joinToString$default(r61, ",", null, null, 0, null, new m(), 30, null);
    L14:
        r4 = new Triple(r62, Integer.valueOf(r2), MsgFeedbackType.MsgFeedbackTypeBothBad);
    L13:
        r62 = null;
        goto L14
    L16:
        if (r0.equals("2") == false) goto L45;
        List r63 = r8.getSubListGroup();
        if (r63 == null) goto L23;
        List r64 = CollectionsKt.flatten(r63);
        if (r64 == null) goto L23;
        String r65 = CollectionsKt.joinToString$default(r64, ",", null, null, 0, null, new l(), 30, null);
    L24:
        r4 = new Triple(r65, Integer.valueOf(r2), MsgFeedbackType.MsgFeedbackTypeAlmost);
    L23:
        r65 = null;
        goto L24
    L26:
        if (r0.equals("1") == false) goto L45;
        List r66 = r8.getSubListGroup();
        if (r66 == null) goto L33;
        List r67 = (List) CollectionsKt.getOrNull(r66, 1);
        if (r67 == null) goto L33;
        String r68 = CollectionsKt.joinToString$default(r67, ",", null, null, 0, null, new k(), 30, null);
    L34:
        r4 = new Triple(r68, 1, MsgFeedbackType.MsgFeedbackTypeBetter);
    L33:
        r68 = null;
        goto L34
    L36:
        if (r0.equals("0") == false) goto L45;
        List r69 = r8.getSubListGroup();
        if (r69 == null) goto L43;
        List r70 = (List) CollectionsKt.getOrNull(r69, 0);
        if (r70 == null) goto L43;
        String r71 = CollectionsKt.joinToString$default(r70, ",", null, null, 0, null, new j(), 30, null);
    L44:
        r4 = new Triple(r71, 0, MsgFeedbackType.MsgFeedbackTypeBetter);
    L43:
        r71 = null;
        goto L44
    }
}
