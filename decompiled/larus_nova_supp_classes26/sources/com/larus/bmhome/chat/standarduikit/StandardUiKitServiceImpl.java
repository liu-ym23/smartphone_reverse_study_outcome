package com.larus.bmhome.chat.standarduikit;

import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.standarduikit.browsercontrol.utils.BrowserControlTipDialog;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000bJ?\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/StandardUiKitServiceImpl;", "Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService;", "<init>", "()V", "createBrowserControlTipDialog", "Landroidx/fragment/app/DialogFragment;", "blockId", "", "interactionType", "", "pcGuideRequestKey", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StandardUiKitServiceImpl implements IStandardUiKitService {
    public StandardUiKitServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.standarduikit.IStandardUiKitService
    public final DialogFragment a(String r2, Integer r3, String r4, String r5, String r6) {
        int r0 = BrowserControlTipDialog.e;
        return BrowserControlTipDialog.a.a(r2, r3, r4, r5, r6);
    }
}
