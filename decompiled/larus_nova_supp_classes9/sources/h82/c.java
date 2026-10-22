package h82;

import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements VSInputPanelSectionContainer.b {
    public final /* synthetic */ VSMsgBoardPortraitInputDialog a;

    public c(VSMsgBoardPortraitInputDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer.b
    public final void a(VSInputSectionType r2, VSInputSectionType r3) {
        Intrinsics.checkNotNullParameter(r2, "previousType");
        Intrinsics.checkNotNullParameter(r3, "currentSectionType");
        if (r3 != VSInputSectionType.NONE) goto L5;
        this.a.dismissInputDialog();
    L5:
        VSMsgBoardPortraitInputDialog r4 = this.a;
        if (r3 != VSInputSectionType.KEYBOARD) goto L8;
        boolean r5 = true;
    L9:
        r4.j = r5;
        return;
    L8:
        r5 = false;
        goto L9
    }
}
