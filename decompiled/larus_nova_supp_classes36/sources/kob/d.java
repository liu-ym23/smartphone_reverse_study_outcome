package kob;

import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.InputStateHandler;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import cya.g;
import cya.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements InputStateHandler<com.ss.android.lark.keyboard.inputstate.b> {
    public final com.ss.android.lark.keyboard.inputstate.a a;
    public final int b;

    public final g<?> a() {
        return new job.b(this.a);
    }

    public final int getCode() {
        return this.b;
    }

    public d(FlowChatKeyboardEditor.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = 4;
    }

    public final InputStateHandler.TransformResult b(h r4, h r5) {
        com.ss.android.lark.keyboard.inputstate.b r6 = (com.ss.android.lark.keyboard.inputstate.b) r5;
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r6, "to");
        if (r4.a() != 4) goto L16;
        n r0 = r4.a;
        ReEditInfo.a r1 = ReEditInfo.Companion;
        ReEditInfo r2 = (ReEditInfo) r0.a(r1);
        String r3 = null;
        if (r2 == null) goto L7;
        String r7 = r2.getMessageId();
    L8:
        ReEditInfo r8 = (ReEditInfo) ((h) r6).a.a(r1);
        if (r8 == null) goto L12;
        r3 = r8.getMessageId();
    L12:
        if (Intrinsics.areEqual(r7, r3) == true) goto L17;
        r4.a.b(com.ss.android.lark.keyboard.inputstate.b.h, Boolean.TRUE);
        return InputStateHandler.TransformResult.KeepTo;
    L17:
        return InputStateHandler.TransformResult.KeepFrom;
    L7:
        r7 = null;
        goto L8
    L16:
        return InputStateHandler.TransformResult.KeepBoth;
    }
}
