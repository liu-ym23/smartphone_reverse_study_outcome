package hda;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u0 {
    public static final boolean a(e1 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((!r2.l.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!r2.j.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!r2.k.isEmpty()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final List<com.obric.assistant.cocreationreview.c> b(e1 r9) {
        Intrinsics.checkNotNullParameter(r9, "uiModel");
        if (a(r9) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c("记忆来源", CardTemplateTagTone.NEUTRAL, 2131235865, null, null, "memory_source", null, 180));
    }
}
