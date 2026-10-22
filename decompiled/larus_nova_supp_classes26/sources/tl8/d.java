package tl8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.bmhome.chat.standarduikit.fileblock.view.FileCardView;
import com.larus.bmhome.utils.z2;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LinkBlock;
import jc8.e;
import kc8.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<tl8.a> {
    public vk8.b d;
    public final Lazy e;

    public static final class a implements lc8.a {
        public a() {
        }

        public final void a(final Context r3, final FileCardVMData r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "data");
            Keva r0 = z2.a;
            String r1 = r4.t();
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            z2.b(r1, new c(r3, r4));
        }

        public final void b(Context r1, FileCardVMData r2) {
            lc8.a.a.a(r1, r2);
        }
    }

    public final String c() {
        return "LinkBlockHolder";
    }

    public d() {
        this.e = LazyKt.lazy(new b());
    }

    public final jc8.d f(jc8.a r2) {
        tl8.a r3 = (tl8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r24) {
        tl8.a r1 = (tl8.a) r24;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        Integer r3 = null;
        if (r2 == null) goto L5;
        w r4 = r2.j;
    L6:
        BlockContent r5 = ((jc8.a) r1).a.getContent();
        if (r5 == null) goto L9;
        LinkBlock r6 = r5.getLinkBlock();
    L10:
        vk8.b r7 = this.d;
        if (r7 != null) goto L13;
        return;
    L13:
        if (r6 == null) goto L16;
        String r8 = r6.name;
        if (r8 == null) goto L16;
    L21:
        String r11 = r8;
    L22:
        if (r6 == null) goto L24;
        String r9 = r6.url;
    L25:
        if (r9 != null) goto L27;
        String r12 = "";
    L28:
        if (r4 == null) goto L30;
        r3 = r4.a;
    L30:
        r7.a(new FileCardVMData(2131242369, "", "", r11, r12, "", r3, null, null, null, null, false, null, false, 32576), (a) this.e.getValue());
        return;
    L27:
        r12 = r9;
        goto L28
    L24:
        r9 = null;
    L16:
        if (r6 == null) goto L18;
        r8 = r6.url;
    L19:
        if (r8 != null) goto L21;
        r11 = "";
        goto L22
    L18:
        r8 = null;
        goto L19
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        vk8.b r0 = new vk8.b(r3.getContext());
        this.d = r0;
        ConstraintLayout r1 = (FileCardView) r0.b.getValue();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new View(r3.getContext());
    }
}
