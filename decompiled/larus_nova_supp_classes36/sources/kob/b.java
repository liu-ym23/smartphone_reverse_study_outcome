package kob;

import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.InputStateHandler;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import cya.g;
import cya.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements InputStateHandler<cya.b> {
    public final com.ss.android.lark.keyboard.inputstate.a a;
    public final int b;

    public final g<?> a() {
        return new job.a(this.a);
    }

    public final int getCode() {
        return this.b;
    }

    public b(FlowChatKeyboardEditor.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = 1;
    }

    public final InputStateHandler.TransformResult b(h r4, h r5) {
        cya.b r6 = (cya.b) r5;
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r6, "to");
        int r0 = r4.a();
        if (r0 != 1) goto L5;
        a.a(r4, this.a, r6, true);
        return InputStateHandler.TransformResult.KeepFrom;
    L5:
        if (r0 != 2) goto L7;
        a.a(r4, this.a, r6, true);
        return InputStateHandler.TransformResult.KeepFrom;
    L7:
        if (r0 != 4) goto L9;
        a.a(r4, this.a, r6, true);
        return InputStateHandler.TransformResult.KeepFrom;
    L9:
        if (r0 == 8) goto L15;
        if (r0 == 16) goto L23;
        return InputStateHandler.TransformResult.KeepBoth;
    L23:
        return InputStateHandler.TransformResult.KeepTo;
    L15:
        if (Intrinsics.areEqual(((h) r6).a.a(com.ss.android.lark.keyboard.inputstate.d.j), Boolean.TRUE) == false) goto L17;
        a.b(r4, this.a, r6, true);
        return InputStateHandler.TransformResult.KeepTo;
    L17:
        a.a(r4, this.a, r6, true);
        return InputStateHandler.TransformResult.KeepFrom;
    }
}
