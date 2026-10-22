package com.larus.bmhome.chat.feedback;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.applet.aibridge.feedback.TriggerFeedbackMethod;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/feedback/IChatFeedbackService;", "", "triggerFeedback", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "messageID", "", "tagList", "", "Lcom/larus/bmhome/chat/feedback/TriggerFeedbackTagBean;", "contentHint", "callback", "Lcom/larus/bmhome/chat/feedback/TriggerFeedbackCallback;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IChatFeedbackService {
    void a(Fragment r1, FragmentManager r2, String r3, List r4, String r5, TriggerFeedbackMethod.handle.1.1 r6);
}
