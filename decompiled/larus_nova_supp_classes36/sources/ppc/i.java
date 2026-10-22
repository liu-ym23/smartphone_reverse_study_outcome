package ppc;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements e {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // ppc.e
    public final boolean a(g r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        BasicDialogContentConfig r0 = r5.d.getDialogContent();
        if ((!StringsKt.isBlank(r0.c)) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L18:
        return false;
    L10:
        if (Intrinsics.areEqual(r5.d.getDialogContent().a, "doubao_profile") == true) goto L20;
        Message r6 = r5.d.getSourceMessage();
        if (r6 == null) goto L14;
        Message.Type r7 = r6.getType();
    L16:
        if (r7 != Message.Type.SHARE_USER_CARD) goto L18;
        return true;
    L14:
        r7 = null;
        goto L16
    L20:
        return true;
    L5:
        if (r0.h == null) goto L7;
        r1 = true;
        goto L8
    }

    @Override // ppc.e
    public final boolean b(g r17) {
        Intrinsics.checkNotNullParameter(r17, "context");
        BasicDialogContentConfig r1 = r17.d.getDialogContent();
        a r2 = new a(r1.b, r1.c, r1.d, r1.h);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r2, "data");
        if ((!StringsKt.isBlank(r2.a)) == false) goto L5;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        return false;
    L15:
        r17.c.setBackgroundResource(2131233983);
        View r4 = r17.getActivity().getLayoutInflater().inflate(2131568159, r17.c, false);
        ImageView r7 = (ImageView) r4.findViewById(2131370093);
        TextView r5 = (TextView) r4.findViewById(2131370094);
        TextView r14 = (TextView) r4.findViewById(2131370091);
        TextView r15 = (TextView) r4.findViewById(2131370092);
        Image r9 = r2.d;
        if (r9 == null) goto L18;
        r7.setVisibility(0);
        int r13 = y9c.d.a(40);
        Activity r6 = r17.getActivity();
        Intrinsics.checkNotNull(r7);
        com.ss.android.lark.forwardv3.utils.a.a(r6, r7, false, r9, false, true, r13, r13);
    L18:
        Intrinsics.checkNotNull(r5);
        h.a(r5, r2.a);
        Intrinsics.checkNotNull(r14);
        h.a(r14, r2.b);
        Intrinsics.checkNotNull(r15);
        h.a(r15, r2.c);
        r17.c.addView(r4);
        r17.c.setVisibility(0);
        return true;
    L5:
        if ((!StringsKt.isBlank(r2.b)) == true) goto L12;
        if ((!StringsKt.isBlank(r2.c)) == true) goto L12;
        if (r2.d != null) goto L12;
        r3 = false;
        goto L13
    }
}
