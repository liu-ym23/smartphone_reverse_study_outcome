package hda;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u1 {
    public static final int a(e1 r2) {
        Integer r3 = Integer.valueOf(r2.r.size());
        if (r3.intValue() <= 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L11;
        return 1;
    L11:
        return r3.intValue();
    L5:
        r0 = false;
        goto L6
    }

    public static final com.obric.assistant.cocreationreview.d b(e1 r7) {
        Intrinsics.checkNotNullParameter(r7, "uiModel");
        int r8 = a(r7);
        if (r8 > 1) goto L7;
        return null;
    L7:
        return new com.obric.assistant.cocreationreview.d("待反馈 " + r8 + " 次", CardTemplateTagTone.WARNING, null, null, 28);
    }
}
