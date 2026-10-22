package com.obric.assistant.tipoff;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J|\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013H&J&\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/tipoff/IObricTipOffService;", "", "createTipOffDialog", "Landroidx/fragment/app/DialogFragment;", "params", "extraParams", "Lcom/obric/assistant/tipoff/ObricTipOffDialogExtraParams;", "showOmniTaskTipOffDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tipOffDialogParams", "msgList", "", "Lcom/larus/im/bean/message/Message;", "isFromDislike", "", "dislikeExtraBundle", "Landroid/os/Bundle;", "omniTaskId", "", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "showTipOffDialog", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTipOffService {

    public static final class a {
        public static /* synthetic */ DialogFragment a(IObricTipOffService r13, FragmentManager r14, TipOffDialogParams r15, List r16, boolean r17, Bundle r18, String r19, String r20, String r21, String r22, String r23, int r24) {
            if ((r24 & 8) == 0) goto L5;
            boolean r6 = false;
        L7:
            if ((r24 & 16) == 0) goto L9;
            Bundle r7 = null;
        L11:
            if ((r24 & 32) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r24 & 64) == 0) goto L17;
            String r9 = null;
        L19:
            if ((r24 & 128) == 0) goto L21;
            String r10 = null;
        L23:
            if ((r24 & 256) == 0) goto L25;
            String r11 = null;
        L27:
            if ((r24 & 512) == 0) goto L29;
            String r12 = null;
        L31:
            return r13.c(r14, r15, r16, r6, r7, r8, r9, r10, r11, r12);
        L29:
            r12 = r23;
            goto L31
        L25:
            r11 = r22;
            goto L27
        L21:
            r10 = r21;
            goto L23
        L17:
            r9 = r20;
            goto L19
        L13:
            r8 = r19;
            goto L15
        L9:
            r7 = r18;
            goto L11
        L5:
            r6 = r17;
            goto L7
        }
    }

    boolean a(FragmentManager r1, TipOffDialogParams r2, List r3);

    ObricTipOffDialogFragment b(TipOffDialogParams r1, ObricTipOffDialogExtraParams r2);

    DialogFragment c(FragmentManager r1, TipOffDialogParams r2, List r3, boolean r4, Bundle r5, String r6, String r7, String r8, String r9, String r10);
}
