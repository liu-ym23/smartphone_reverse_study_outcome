package jg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    public final boolean c(t1a.b r4, Message r5, q0 r6) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.getMessageStatusLocal() != 21) goto L7;
        if (com.larus.bmhome.chat.bean.d.Q0(r5) == false) goto L7;
    L32:
        return false;
    L7:
        if (r5.getMessageStatusLocal() == 20) goto L32;
        if (r5.getMessageStatusLocal() == 23) goto L32;
        List<TextTagInfo> r7 = com.larus.bmhome.chat.bean.d.O(r5);
        if (r7 != null) goto L13;
        r7 = CollectionsKt.emptyList();
    L13:
        List<TextTagInfo> r8 = r7;
        if ((r8 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r9 = r8.iterator();
        int r10 = 0;
    L20:
        if (r9.hasNext() == false) goto L29;
        if (((TextTagInfo) r9.next()).type != TagEnum.TagEnum_Insertable.value) goto L24;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L20;
        r10 = r10 + 1;
        if (r10 >= 0) goto L20;
        CollectionsKt.throwCountOverflow();
        goto L20
    L24:
        r1 = false;
    L29:
        if (r10 == 0) goto L32;
        return true;
    L16:
        if (r8.isEmpty() == false) goto L18;
        r10 = 0;
        goto L29
    }
}
