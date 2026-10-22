package tj8;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.standarduikit.commonbutton.view.CommonButton;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ButtonBlock;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemButtonBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.Map;
import jc8.d;
import jc8.e;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;
import sj8.c;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public c d;
    public vj8.c e;

    public final String c() {
        return "CommonButtonBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    /* JADX WARN: Type inference failed for: r13v6, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.chat.standarduikit.commonbutton.view.CommonButton, java.lang.Object] */
    public final void g(jc8.a r13) {
        a r14 = (a) r13;
        Intrinsics.checkNotNullParameter(r14, "blockModel");
        kc8.b r0 = jc8.c.a(this, kc8.b.class);
        if (this.e == null) goto L5;
    L11:
        Intrinsics.checkNotNullParameter(r14, "bizModel");
        ButtonBlock r1 = r14.i;
        vj8.a r2 = new vj8.a(r1.getDisplayText(), r1.getIconUrl(), r1.getDarkIconUrl(), r14.j(), r14.j().getConversationId(), r14.i.getCommand(), r14.i.getMessageText(), r14.i.getExtra());
        c r15 = this.d;
        if (r15 == null) goto L45;
        vj8.c r3 = this.e;
        Intrinsics.checkNotNullParameter(r2, "vmData");
        vj8.d r4 = (vj8.d) r15.b.getValue();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "vmData");
        r4.a = r2;
        r4.b = r3;
        vj8.a r5 = ((vj8.d) r15.b.getValue()).a;
        int r6 = 0;
        if (r5 != null) goto L16;
        r5 = new vj8.a(0);
    L16:
        Map<String, String> r7 = r5.h;
        if (r7 == null) goto L19;
        String r8 = r7.get("deep_research_id");
    L20:
        StringBuilder r9 = new StringBuilder();
        Message r10 = r5.d;
        if (r10 == null) goto L23;
        String r11 = r10.getMessageId();
    L24:
        r9.append(r11);
        r9.append(':');
        r9.append(r5.a);
        r9.append(':');
        r9.append(r5.f);
        r9.append(':');
        r9.append(r8);
        final uj8.e r12 = new uj8.e(r9.toString(), r5.a, r5.b, r5.c);
        final vj8.d.a r16 = ((vj8.d) r15.b.getValue()).c;
        final ?? r17 = (CommonButton) r15.a.getValue();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r12, "input");
        Intrinsics.checkNotNullParameter(r16, "output");
        LarusBlockItemButtonBinding r18 = r17.a;
        String r19 = r12.b;
        if (o0.d(r19) == false) goto L27;
        r18.b.setVisibility(0);
        r18.b.setText(r19);
    L28:
        boolean r20 = h.a;
        if (h.a(null) == false) goto L31;
        String r21 = r12.d;
    L33:
        if (o0.d(r21) == false) goto L35;
        r18.c.setVisibility(0);
        ImageLoaderKt.u(r18.c, r21, "block_button_icon");
    L36:
        boolean r22 = r16.c();
        if (r22 == true) goto L40;
        r6 = 8;
    L40:
        r17.setVisibility(r6);
        if (r22 == false) goto L43;
        ExposeXTrackerExtKt.b(r17, new uj8.b(r12, r16));
    L43:
        e1.d(r17, new uj8.a(r16, r17));
        return;
    L35:
        r18.c.setVisibility(8);
        goto L36
    L31:
        r21 = r12.c;
        goto L33
    L27:
        r18.b.setVisibility(8);
        goto L28
    L23:
        r11 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L45:
        return;
    L5:
        if (r0 == null) goto L9;
        y r23 = r0.a;
        if (r23 == null) goto L9;
        Boolean r24 = r23.g;
    L10:
        this.e = new vj8.c(r0, r24);
    L9:
        r24 = null;
        goto L10
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        c r0 = this.d;
        if (r0 != null) goto L5;
        r0 = new c(r4.getContext());
        this.d = r0;
    L5:
        ConstraintLayout r5 = (CommonButton) r0.a.getValue();
        r5.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        return r5;
    }
}
