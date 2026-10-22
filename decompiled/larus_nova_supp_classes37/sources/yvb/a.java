package yvb;

import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public String a;
    public final d b;
    public final List<SpanInfo> c;
    public int d;
    public com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a e;
    public boolean f;

    public final String b() {
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a r0 = this.e;
        if (r0 == null) goto L9;
        StringBuilder r1 = r0.f;
        if (r1 == null) goto L9;
        String r2 = r1.toString();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return this.a;
    }

    public final void a(int r11) {
        List<SpanInfo> r0 = this.c;
        int r1 = e.a;
        int r2 = b().length();
        String r3 = b();
        d r4 = this.b;
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "style");
        r4.getClass();
        if (r11 >= 1) goto L5;
    L8:
        d.b r5 = null;
    L9:
        PrefixSpan.b r6 = new PrefixSpan.b();
        r6.b = true;
        float r8 = 5.0f;
        r6.c = UIHelper.dp2px(((r11 - 1) * 24.0f) + 5.0f);
        r6.f = UIHelper.dp2px(16.0f);
        if (r5 == null) goto L14;
        Float r9 = r5.b;
        if (r9 == null) goto L14;
        r8 = r9.floatValue();
    L18:
        r6.d = UIHelper.dp2px(r8);
        if (r5 == null) goto L23;
        Integer r10 = r5.c;
        if (r10 == null) goto L23;
        int r7 = r10.intValue();
    L27:
        r6.h = r7;
        if (r5 == null) goto L31;
        PrefixSpan.Type r12 = r5.a;
        if (r12 == null) goto L31;
    L37:
        r6.a = r12;
        PrefixInfo r13 = new PrefixInfo(r6);
        ((SpanInfo) r13).type = 12;
        ((SpanInfo) r13).start = 0;
        ((SpanInfo) r13).end = r2;
        ((SpanInfo) r13).text = r3;
        ((ArrayList) r0).add(r13);
        return;
    L31:
        if (r11 == 1) goto L35;
        if (r11 == 2) goto L34;
        PrefixSpan.Type r14 = PrefixSpan.Type.FILL_RECT;
    L36:
        r12 = r14;
        goto L37
    L34:
        r14 = PrefixSpan.Type.HOLLOW_CIRCLE;
        goto L36
    L35:
        r14 = PrefixSpan.Type.FILL_CIRCLE;
    L23:
        Integer r15 = r4.b;
        if (r15 == null) goto L26;
        r7 = r15.intValue();
        goto L27
    L26:
        LarkAppContext.Companion.getClass();
        r7 = UDColorUtils.getColor(LarkAppContext.access$getInstance$cp().getContext(), 2131106622);
    L14:
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L17;
        r8 = 3.0f;
        goto L18
    L17:
        r8 = 4.0f;
        goto L18
    L5:
        if (r11 > 3) goto L8;
        r5 = r4.d.get(Integer.valueOf(r11));
        goto L9
    }

    public a(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "sourceText");
        Intrinsics.checkNotNullParameter(r3, "style");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }
}
