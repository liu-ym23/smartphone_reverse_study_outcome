package com.larus.bmhome.chat.feedback;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.applet.aibridge.feedback.TriggerFeedbackMethod;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.spi.IAIChatService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J,\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/feedback/ChatFeedbackServiceImpl;", "Lcom/larus/bmhome/chat/feedback/IChatFeedbackService;", "<init>", "()V", "triggerFeedback", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "messageID", "", "tagList", "", "Lcom/larus/bmhome/chat/feedback/TriggerFeedbackTagBean;", "contentHint", "callback", "Lcom/larus/bmhome/chat/feedback/TriggerFeedbackCallback;", "convertToFeedbackMeta", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatFeedbackServiceImpl implements IChatFeedbackService {
    public ChatFeedbackServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.feedback.IChatFeedbackService
    public final void a(Fragment r6, final FragmentManager r7, String r8, final List r9, String r10, final TriggerFeedbackMethod.handle.1.1 r11) {
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r7, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, "contentHint");
        Intrinsics.checkNotNullParameter(r11, "callback");
        r7.setFragmentResultListener("dislikeDialogClose", r6, new a(r9, r11, r7));
        IAIChatService.Companion r12 = IAIChatService.a;
        Fragment r13 = null;
        if (r9 == null) goto L8;
        ArrayList r0 = new ArrayList();
        Iterator r14 = r9.iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        c r1 = (c) r14.next();
        r0.add(new FeedbackMeta(r1.c(), r1.a(), r1.b()));
    L9:
        Bundle r15 = com.larus.utils.f.c(new Pair[0]);
        r15.putString("message_id", r8);
        Unit r16 = Unit.INSTANCE;
        Fragment r17 = r12.k7(r0, r10, r15);
        if ((r17 instanceof Fragment) == false) goto L12;
        r13 = r17;
    L12:
        LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "feedback", r18);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r13, r18) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L16:
        r17.show(r7, "feedback");
        return;
    L22:
        return;
    L8:
        r0 = null;
        goto L9
    }
}
