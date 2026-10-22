package mm8;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.standarduikit.miaodaartifact.view.MiaodaArtifactCardView;
import com.larus.bmhome.chat.standarduikit.miaodaartifact.viewmodel.MiaodaArtifactVMData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.BlockContent;
import jc8.c;
import jc8.d;
import jc8.e;
import kc8.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public lm8.b d;

    public final String c() {
        return "MiaodaArtifactBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r7) {
        a r8 = (a) r7;
        Intrinsics.checkNotNullParameter(r8, "blockModel");
        kc8.b r0 = c.a(this, kc8.b.class);
        Integer r1 = null;
        if (r0 == null) goto L7;
        k r2 = r0.p;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.a);
    L8:
        BlockContent r4 = ((jc8.a) r8).a.getContent();
        if (r4 == null) goto L11;
        ArtifactBlock r5 = r4.getDocBlock();
    L12:
        if (r5 == null) goto L14;
        String r6 = r5.getResourceId();
    L15:
        Message r9 = r8.j();
        if (r5 == null) goto L18;
        String r10 = r5.getTitle();
    L19:
        String r11 = "";
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        MiaodaArtifactVMData r12 = new MiaodaArtifactVMData(r9, r6, r10, r3);
        lm8.b r13 = this.d;
        if (r13 == null) goto L34;
        om8.d r14 = new om8.d();
        Intrinsics.checkNotNullParameter(r12, "vmData");
        om8.b r15 = r13.c;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r12, "vmData");
        r15.a = r12;
        r15.b = r14;
        om8.b r16 = r13.c;
        r16.getClass();
        MiaodaArtifactVMData r17 = r16.a;
        if (r17 == null) goto L30;
        String r18 = r17.c;
        if (r18 == null) goto L30;
        r11 = r18;
    L30:
        if (r17 == null) goto L32;
        r1 = r17.d;
    L32:
        nm8.c r19 = new nm8.c(r11, r1);
        om8.b r20 = r13.c;
        r20.getClass();
        ((MiaodaArtifactCardView) r13.b.getValue()).R5(r19, new om8.a(r20));
        return;
    L34:
        return;
    L18:
        r10 = null;
        goto L19
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        lm8.b r0 = new lm8.b(r3.getContext());
        this.d = r0;
        ConstraintLayout r1 = (MiaodaArtifactCardView) r0.b.getValue();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new View(r3.getContext());
    }
}
