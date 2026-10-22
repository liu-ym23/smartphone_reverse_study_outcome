package sm8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import com.larus.im.bean.message.block.InteractionAskContent;
import com.larus.im.bean.message.block.InteractionAskIcon;
import jc8.c;
import jc8.d;
import jc8.e;
import jl8.f;
import jl8.g;
import kc8.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public GenericToolView d;

    public final String c() {
        return "QuickReplyThinkingBlockHolder";
    }

    public final void i() {
        GenericToolView r0 = this.d;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r22) {
        a r1 = (a) r22;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = c.a(this, kc8.b.class);
        InteractionAskContent r3 = r1.i;
        GenericToolView r4 = this.d;
        if (r4 == null) goto L24;
        InteractionAskIcon r5 = r3.getIcon();
        if (r5 == null) goto L7;
        String r6 = r5.getUrlLight();
    L8:
        InteractionAskIcon r7 = r3.getIcon();
        if (r7 == null) goto L11;
        String r8 = r7.getUrlDark();
    L12:
        String r9 = r3.getProcessingStatusText();
        if (((jc8.a) r1).a.isFinish() == false) goto L15;
        GenericToolViewStage r10 = GenericToolViewStage.FINISHED;
    L16:
        GenericToolViewStage r11 = r10;
        String r12 = r1.j().getMessageId();
        if (r2 == null) goto L21;
        x r13 = r2.i;
        if (r13 == null) goto L21;
        Integer r14 = r13.a;
    L22:
        r4.a(new f(r6, r8, r9, r11, null, r12, 0, r14, false, false, false, 0, 0, 0, 16208), new g(null, null));
        return;
    L21:
        r14 = null;
        goto L22
    L15:
        r10 = GenericToolViewStage.LOADING;
        goto L16
    L11:
        r8 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        GenericToolView r0 = new GenericToolView(r3.getContext(), null);
        this.d = r0;
        return r0;
    }
}
