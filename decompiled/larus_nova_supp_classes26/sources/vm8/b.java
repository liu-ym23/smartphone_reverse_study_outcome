package vm8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.chat.standarduikit.realname.view.RealNameVerifiedView;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import jc8.d;
import jc8.e;
import kotlin.jvm.internal.Intrinsics;
import um8.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public c d;

    public final String c() {
        return "RealNameVerifiedBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View, android.widget.TextView, com.larus.bmhome.chat.standarduikit.realname.view.RealNameVerifiedView, java.lang.Object] */
    public final void g(jc8.a r8) {
        a r9 = (a) r8;
        Intrinsics.checkNotNullParameter(r9, "blockModel");
        ym8.a r0 = new ym8.a(r9.j());
        c r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L7;
        AppCompatTextView r3 = (RealNameVerifiedView) r1.c.getValue();
        if (r3 == null) goto L7;
        Context r4 = r3.getContext();
    L8:
        wm8.b r10 = new wm8.b(r4, jc8.c.a(this, kc8.b.class));
        c r5 = this.d;
        if (r5 == null) goto L57;
        Intrinsics.checkNotNullParameter(r0, "vmData");
        ym8.c r6 = (ym8.c) r5.b.getValue();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "vmData");
        r6.c = r0;
        r6.d = r10;
        boolean r11 = r6.a(r0.a);
        r6.b = r11;
        ym8.a r7 = r6.c;
        if (r7 == null) goto L55;
        Message r12 = r7.a;
        if (r12 == null) goto L55;
        wm8.a r13 = r6.d;
        if (r13 == null) goto L55;
        if (r11 == true) goto L20;
        String r14 = r13.c();
        if (o0.d(r14) == false) goto L53;
        ym8.a r15 = r6.c;
        if (r15 == null) goto L38;
        Message r16 = r15.a;
        if (r16 == null) goto L38;
        String r17 = r16.getMessageId();
    L40:
        if (Intrinsics.areEqual(r14, r17) == false) goto L53;
        if (r13.d() == false) goto L53;
        r13.b();
        ym8.a r18 = r6.c;
        if (r18 == null) goto L48;
        Message r19 = r18.a;
        if (r19 == null) goto L48;
        String r20 = r19.getMessageId();
    L49:
        if (r20 != null) goto L51;
        r20 = "";
    L51:
        r13.h(r20);
    L48:
        r20 = null;
    L38:
        r17 = null;
    L53:
        if (Intrinsics.areEqual(r6.a, r12.getMessageId()) == false) goto L55;
        r6.b(true);
        r6.a = null;
        goto L55
    L20:
        if (r12.getMessageStatusLocal() != 20) goto L55;
        if (r13.e(r12) == false) goto L55;
        if (r13.i(r12) == false) goto L55;
        Map r21 = r12.getExt();
        if (r21 == null) goto L29;
        r2 = (String) r21.get("need_auth_identity");
    L29:
        if (Intrinsics.areEqual(r2, "1") == false) goto L55;
        r6.a = r12.getMessageId();
    L55:
        ym8.c r22 = (ym8.c) r5.b.getValue();
        r22.getClass();
        boolean r23 = r22.b;
        xm8.a r24 = new xm8.a(r23);
        final xm8.b r25 = (xm8.b) ((ym8.c) r5.b.getValue()).e.getValue();
        ?? r26 = (RealNameVerifiedView) r5.c.getValue();
        r26.getClass();
        Intrinsics.checkNotNullParameter(r24, "input");
        Intrinsics.checkNotNullParameter(r25, "output");
        FLogger.a.i("RealNameVerifiedView", "bindData, input: " + r23 + "===" + r26.getHeight());
        e1.y(r26, r23 ^ true);
        e1.d(r26, new xm8.c(r25));
        r26.removeOnAttachStateChangeListener(r26.a);
        xm8.d r27 = new xm8.d(r25);
        r26.a = r27;
        r26.addOnAttachStateChangeListener(r27);
        return;
    L57:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        c r0 = new c(r4.getContext());
        this.d = r0;
        ViewGroup.LayoutParams r5 = new ViewGroup.MarginLayoutParams(-1, i5.c0());
        AppCompatTextView r1 = (RealNameVerifiedView) r0.c.getValue();
        r1.setLayoutParams(r5);
        return r1;
    }
}
