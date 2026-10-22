package lj8;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.standarduikit.codeartifact.view.CodeArtifactCardView;
import com.larus.bmhome.chat.standarduikit.codeartifact.viewmodel.CodeArtifactVMData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.BlockContent;
import jc8.c;
import jc8.d;
import jc8.e;
import kc8.k;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public kj8.b d;

    public final String c() {
        return "CodeArtifactBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r10) {
        a r11 = (a) r10;
        Intrinsics.checkNotNullParameter(r11, "blockModel");
        kc8.b r0 = c.a(this, kc8.b.class);
        Integer r1 = null;
        if (r0 == null) goto L7;
        k r2 = r0.p;
        if (r2 == null) goto L7;
        Integer r7 = Integer.valueOf(r2.a);
    L8:
        Message r3 = r11.j();
        BlockContent r4 = ((jc8.a) r11).a.getContent();
        if (r4 == null) goto L15;
        ArtifactBlock r5 = r4.getDocBlock();
        if (r5 == null) goto L15;
        String r6 = r5.getResourceId();
        if (r6 == null) goto L15;
        Long r8 = StringsKt.toLongOrNull(r6);
    L16:
        BlockContent r9 = ((jc8.a) r11).a.getContent();
        if (r9 == null) goto L21;
        ArtifactBlock r12 = r9.getDocBlock();
        if (r12 == null) goto L21;
        String r13 = r12.getTitle();
    L22:
        String r14 = "";
        if (r13 != null) goto L25;
        String r15 = "";
    L26:
        BlockContent r16 = ((jc8.a) r11).a.getContent();
        if (r16 == null) goto L31;
        ArtifactBlock r17 = r16.getDocBlock();
        if (r17 == null) goto L31;
        Integer r18 = r17.getResourceVersion();
    L32:
        CodeArtifactVMData r19 = new CodeArtifactVMData(r3, r8, r15, r18, r7);
        kj8.b r110 = this.d;
        if (r110 == null) goto L48;
        kc8.b r20 = c.a(this, kc8.b.class);
        if (r20 == null) goto L37;
        y r21 = r20.a;
    L38:
        nj8.d r22 = new nj8.d(r21);
        Intrinsics.checkNotNullParameter(r19, "vmData");
        nj8.b r23 = r110.c;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r19, "vmData");
        r23.a = r19;
        r23.b = r22;
        nj8.b r24 = r110.c;
        r24.getClass();
        CodeArtifactVMData r25 = r24.a;
        if (r25 == null) goto L44;
        String r26 = r25.c;
        if (r26 == null) goto L44;
        r14 = r26;
    L44:
        if (r25 == null) goto L46;
        r1 = r25.e;
    L46:
        mj8.c r27 = new mj8.c(r14, r1);
        nj8.b r28 = r110.c;
        r28.getClass();
        ((CodeArtifactCardView) r110.b.getValue()).R5(r27, new nj8.a(r28));
        return;
    L37:
        r21 = null;
        goto L38
    L48:
        return;
    L31:
        r18 = null;
        goto L32
    L25:
        r15 = r13;
    L21:
        r13 = null;
    L15:
        r8 = null;
    L7:
        r7 = null;
        goto L8
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        kj8.b r0 = new kj8.b(r3.getContext());
        this.d = r0;
        ConstraintLayout r1 = (CodeArtifactCardView) r0.b.getValue();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new View(r3.getContext());
    }
}
