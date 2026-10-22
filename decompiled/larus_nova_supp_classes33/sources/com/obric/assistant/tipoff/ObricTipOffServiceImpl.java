package com.obric.assistant.tipoff;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.auth.ReportReason;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.feedback.IObricFeedbackService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016Jn\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/tipoff/ObricTipOffServiceImpl;", "Lcom/obric/assistant/tipoff/IObricTipOffService;", "<init>", "()V", "createTipOffDialog", "Landroidx/fragment/app/DialogFragment;", "params", "", "extraParams", "Lcom/obric/assistant/tipoff/ObricTipOffDialogExtraParams;", "showOmniTaskTipOffDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tipOffDialogParams", "msgList", "", "Lcom/larus/im/bean/message/Message;", "isFromDislike", "", "dislikeExtraBundle", "Landroid/os/Bundle;", "omniTaskId", "", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "showTipOffDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTipOffServiceImpl implements IObricTipOffService {

    public static final class a {
    }

    static {
    }

    public ObricTipOffServiceImpl() {
    }

    @Override // com.obric.assistant.tipoff.IObricTipOffService
    public final ObricTipOffDialogFragment b(TipOffDialogParams r4, ObricTipOffDialogExtraParams r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        ObricTipOffDialogFragment.a r0 = new ObricTipOffDialogFragment.a();
        Intrinsics.checkNotNullParameter(r4, "builder");
        r0.a = r4;
        r0.b = r5;
        ObricTipOffDialogFragment r6 = new ObricTipOffDialogFragment();
        r6.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("tip_off_params", r0.a), TuplesKt.to("obric_extra_params", r0.b)}));
        return r6;
    }

    @Override // com.obric.assistant.tipoff.IObricTipOffService
    public final boolean a(FragmentManager r14, TipOffDialogParams r15, List r16) {
        Intrinsics.checkNotNullParameter(r14, "fragmentManager");
        Intrinsics.checkNotNullParameter(r15, "tipOffDialogParams");
        Intrinsics.checkNotNullParameter(r16, "msgList");
        if (r16.isEmpty() == false) goto L5;
        return false;
    L5:
        Message r0 = (Message) CollectionsKt.last(r16);
        if (com.obric.assistant.utils.k.c(r0) == false) goto L15;
        Map r5 = r0.getExt();
        if (r5 == null) goto L10;
        String r6 = (String) r5.get("o_omni_feedback_disabled");
    L12:
        if (Intrinsics.areEqual(r6, "1") == true) goto L15;
        IObricTipOffService.a.a(this, r14, r15, r16, false, null, null, r0.getMessageId(), "bubble_tip_off_feedback", null, null, 824);
        return true;
    L10:
        r6 = null;
    L15:
        return false;
    }

    @Override // com.obric.assistant.tipoff.IObricTipOffService
    public final DialogFragment c(FragmentManager r40, TipOffDialogParams r41, List r42, boolean r43, Bundle r44, String r45, String r46, String r47, String r48, String r49) {
        String r3 = r45;
        Intrinsics.checkNotNullParameter(r40, "fragmentManager");
        Intrinsics.checkNotNullParameter(r42, "msgList");
        FLogger r0 = FLogger.a;
        StringBuilder r4 = new StringBuilder("showOmniTaskTipOffDialog: fragmentManager = ");
        r4.append(r40);
        r4.append(", msgList = ");
        r4.append(r42);
        r4.append(", isFromDislike = ");
        r4.append(r43);
        r4.append(", omniTaskId = ");
        String r5 = "";
        if (r3 != null) goto L5;
        String r6 = "";
    L6:
        r4.append(r6);
        r4.append(", feedbackMsgId = ");
        if (r46 != null) goto L9;
        String r7 = "";
    L10:
        r4.append(r7);
        r4.append(", feedbackSource = ");
        if (r47 != null) goto L13;
        String r8 = "";
    L14:
        r4.append(r8);
        r4.append(", feedbackBizType = ");
        if (r48 != null) goto L17;
        String r9 = "";
    L18:
        r4.append(r9);
        r4.append(", searchTool = ");
        if (r49 != null) goto L21;
        String r10 = "";
    L22:
        r4.append(r10);
        r0.i("ObricTipOffServiceImpl", r4.toString());
        if (r42.isEmpty() == false) goto L26;
        r0.w("ObricTipOffServiceImpl", "showOmniTaskTipOffDialog: msgList is empty");
        return null;
    L26:
        Message r11 = (Message) CollectionsKt.last(r42);
        IObricFeedbackService.a.getClass();
        boolean r12 = IObricFeedbackService.a.b(r48);
        LinkedHashSet r13 = new LinkedHashSet();
        if (r12 == true) goto L47;
        List r1 = r42;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L30:
        if (r2.hasNext() == false) goto L32;
        r14.add(com.obric.assistant.utils.k.b((Message) r2.next()));
        goto L30
    L32:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L34:
        if (r16.hasNext() == false) goto L38;
        Object r17 = r16.next();
        if (o0.d((String) r17) == false) goto L34;
        r15.add(r17);
        goto L34
    L38:
        r13.addAll(r15);
        if (r3 != null) goto L41;
    L44:
        boolean r18 = true;
    L45:
        if (r18 == true) goto L47;
        r13.add(r3);
        goto L47
    L41:
        if (r45.length() == 0) goto L44;
        r18 = false;
    L47:
        LinkedHashSet r19 = new LinkedHashSet();
        if (r12 == true) goto L79;
        Iterator r110 = r13.iterator();
    L51:
        if (r110.hasNext() == false) goto L79;
        String r111 = (String) r110.next();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L61
        IAgentAppIntentIDL r21 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L61
        if (r21 == null) goto L58;
        List r22 = r21.getOmniJournalPath(r111);     // Catch: Throwable -> L61
        if (r22 == null) goto L58;
        List r23 = CollectionsKt.filterNotNull(r22);     // Catch: Throwable -> L61
    L59:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L61
    L63:
        Throwable r112 = Result.exceptionOrNull-impl(r24);
        if (r112 == null) goto L68;
        FLogger.a.w("ObricTipOffServiceImpl", "showOmniTaskTipOffDialog: getOmniJournalPath failed: " + r112.getMessage(), r112);
    L68:
        if (Result.isSuccess-impl(r24) == false) goto L78;
        List r25 = (List) r24;
        FLogger.a.i("ObricTipOffServiceImpl", "showOmniTaskTipOffDialog: getOmniJournalPath success. omniTaskId = " + r111 + ", guiLogList = " + r25);
        List r26 = r25;
        if (r26 != null) goto L72;
    L75:
        boolean r27 = true;
    L76:
        if (r27 == true) goto L78;
        r19.addAll(r26);
        goto L78
    L72:
        if (r26.isEmpty() == true) goto L75;
        r27 = false;
    L78:
        r5 = r5;
        r110 = r110;
    L58:
        r23 = null;
    L61:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L79:
        String r28 = r5;
        FLogger.a.i("ObricTipOffServiceImpl", "showOmniTaskTipOffDialog: omniTaskIdSet = " + r13 + ", guiLogSet= " + r19);
        if (r12 == false) goto L82;
        String r114 = null;
    L94:
        if (r41 == null) goto L96;
        TipOffDialogParams r115 = r41;
    L173:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L126
        Fragment r30 = r40.findFragmentByTag("omni_task_feedback_dialog");     // Catch: Throwable -> L126
        if (r30 == null) goto L123;
        Integer r31 = Integer.valueOf(r40.beginTransaction().remove(r30).commitAllowingStateLoss());     // Catch: Throwable -> L126
    L124:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L126
    L128:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L131;
        FLogger.a.w("ObricTipOffServiceImpl", "showOmniTaskTipOffDialog: dismiss dialog failed: " + r33.getMessage(), r33);
    L131:
        IObricTipOffService r34 = (IObricTipOffService) ServiceManager.get().getService(IObricTipOffService.class);
        if (r34 == null) goto L164;
        List<ObricFeedbackReasonConfig.FeedbackReason> r35 = ObricFeedbackReasonConfig.a;
        if (r48 == null) goto L154;
        int r36 = r48.hashCode();
        if (r36 == (-906336856)) goto L151;
        if (r36 == 960552006) goto L147;
        if (r36 != 1507218089) goto L154;
        if (r48.equals("memory_delete") == false) goto L154;
        List<ObricFeedbackReasonConfig.FeedbackReason> r37 = ObricFeedbackReasonConfig.e;
    L155:
        List<ObricFeedbackReasonConfig.FeedbackReason> r38 = r37;
        ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator<T> r50 = r38.iterator();
    L157:
        if (r50.hasNext() == false) goto L159;
        ObricFeedbackReasonConfig.FeedbackReason r51 = (ObricFeedbackReasonConfig.FeedbackReason) r50.next();
        r39.add(new ReportReason(r51.getId(), AppHost.a.getApplication().getString(r51.getTextRes())));
        goto L157
    L159:
        r115.n = r39;
        AppHost.Companion r52 = AppHost.a;
        String r53 = r52.getApplication().getString(2131912632);
        if (Intrinsics.areEqual(r48, "search") == false) goto L162;
        String r116 = null;
    L163:
        ObricTipOffDialogFragment r54 = r34.b(r115, new ObricTipOffDialogExtraParams(r53, r116, r52.getApplication().getString(2131912622), r52.getApplication().getString(2131912621), r43, r44, CollectionsKt.toList(r19), r114, r46, r47, r48, r49, r11.getSenderId(), r11.getConversationId(), r11.getMessageId()));
    L165:
        if (r54 == null) goto L171;
        LandscapeRestrictionOperation r55 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r54, "omni_task_feedback_dialog", r55);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r40, r54, r55) == true) goto L171;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L172
    L170:
        r54.show(r40, "omni_task_feedback_dialog");
    L171:
        return r54;
    L162:
        r116 = r52.getApplication().getString(2131912631);
        goto L163
    L147:
        if (r48.equals("memory_operate") == false) goto L154;
        r37 = ObricFeedbackReasonConfig.d;
        goto L155
    L151:
        if (r48.equals("search") == false) goto L154;
        r37 = ObricFeedbackReasonConfig.b;
    L154:
        r37 = ObricFeedbackReasonConfig.a;
        goto L155
    L164:
        r54 = null;
        goto L165
    L123:
        r31 = null;
    L126:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L128
    L96:
        if (r42.size() <= 1) goto L98;
        int r210 = 18;
    L100:
        if (com.larus.bmhome.chat.bean.d.b0(r11) == false) goto L106;
        String r57 = com.larus.im.bean.message.a.D(r11);
        if (r57 != null) goto L109;
        r57 = r11.getMessageId();
        if (r57 != null) goto L109;
    L108:
        r57 = r28;
    L109:
        String r310 = r11.getSenderId();
        Intrinsics.checkNotNullParameter(r57, "entityId");
        TipOffDialogParams r58 = new TipOffDialogParams(r210, r57, null, null, "", "", 0, null, null, r310, null, null, null, null, null);
        if (r42.size() <= 1) goto L118;
        ArrayList r59 = new ArrayList();
        Iterator r60 = r42.iterator();
    L113:
        if (r60.hasNext() == false) goto L117;
        String r61 = ((Message) r60.next()).getMessageId();
        if (r61 == null) goto L113;
        r59.add(r61);
        goto L113
    L117:
        Intrinsics.checkNotNullParameter(r59, "batchIds");
        r58.m = r59;
    L118:
        r115 = r58;
        goto L173
    L106:
        r57 = r11.getMessageId();
        if (r57 != null) goto L109;
    L98:
        r210 = 2;
        goto L100
    L82:
        if (r3 != null) goto L84;
    L93:
        r114 = (String) CollectionsKt.firstOrNull(r13);
        goto L94
    L84:
        if (r45.length() <= 0) goto L86;
        boolean r117 = true;
    L87:
        if (r117 == true) goto L90;
        r3 = null;
    L90:
        if (r3 == null) goto L93;
        r114 = r3;
        goto L94
    L86:
        r117 = false;
        goto L87
    L21:
        r10 = r49;
        goto L22
    L17:
        r9 = r48;
        goto L18
    L13:
        r8 = r47;
        goto L14
    L9:
        r7 = r46;
        goto L10
    L5:
        r6 = r3;
        goto L6
    }
}
