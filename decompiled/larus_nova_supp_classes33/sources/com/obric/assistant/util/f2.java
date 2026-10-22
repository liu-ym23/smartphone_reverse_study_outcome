package com.obric.assistant.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f2 {
    public static final ConstraintLayout a(ViewGroup r3) {
        FLogger.a.i("ViewUtils", "findInputAreaContainer: " + r3);
        if ((r3 instanceof ConstraintLayout) == true) goto L5;
        if (r3 == null) goto L16;
        Sequence r4 = ViewGroupKt.getChildren(r3);
        if (r4 == null) goto L21;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L22;
        ConstraintLayout r0 = (View) r5.next();
        if ((r0 instanceof ConstraintLayout) == false) goto L11;
        return r0;
    L22:
        return null;
    L21:
        return null;
    L16:
        return null;
    L5:
        return (ConstraintLayout) r3;
    }
}
