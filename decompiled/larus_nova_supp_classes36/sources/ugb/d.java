package ugb;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.tag.TagData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final boolean a(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        TagData r4 = r3.getTagData();
        if (r4 == null) goto L21;
        TagData.Companion.getClass();
        Iterator r5 = ((ArrayList) TagData.a.b(r4)).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r1 = r5.next();
        if (g08.b.a(((g08.a) r1).b) == false) goto L6;
    L11:
        g08.a r2 = (g08.a) r1;
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.b != 1) goto L22;
        return true;
    L22:
        return false;
    L10:
        r1 = null;
        goto L11
    L21:
        return false;
    }
}
