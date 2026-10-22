package com.larus.bmhome.chat.standarduikit;

import androidx.fragment.app.DialogFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ-\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\tJ?\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService;", "", "createBrowserControlTipDialog", "Landroidx/fragment/app/DialogFragment;", "blockId", "", "interactionType", "", "pcGuideRequestKey", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IStandardUiKitService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u0010\u000bJ@\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService$Companion;", "Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService;", "<init>", "()V", "createBrowserControlTipDialog", "Landroidx/fragment/app/DialogFragment;", "blockId", "", "interactionType", "", "pcGuideRequestKey", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IStandardUiKitService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IStandardUiKitService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bmhome.chat.standarduikit.IStandardUiKitService
        public final DialogFragment a(String r7, Integer r8, String r9, String r10, String r11) {
            return this.b.a(r7, r8, r9, r10, r11);
        }

        private Companion() {
            IStandardUiKitService r0 = (IStandardUiKitService) ServiceManager.get().getService(IStandardUiKitService.class);
            if (r0 != null) goto L5;
            r0 = new StandardUiKitServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    DialogFragment a(String r1, Integer r2, String r3, String r4, String r5);
}
