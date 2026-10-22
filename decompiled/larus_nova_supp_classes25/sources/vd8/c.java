package vd8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final Message c(List r4) {
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Object r0 = r5.next();
        Message r2 = ((xc8.b) r0).getMessage();
        if (g(r2) == false) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
    L14:
        xc8.b r1 = (xc8.b) r0;
        if (r1 != null) goto L17;
        return null;
    L17:
        return r1.getMessage();
    L8:
        if (com.larus.bmhome.chat.bean.d.G0(r2) == false) goto L10;
        r3 = true;
        goto L11
    L13:
        r0 = null;
        goto L14
    }

    public static final String d(Message r3) {
        String r0 = r3.getMessageId();
        if (r0 != null) goto L5;
    L11:
        String r4 = r3.getLocalMessageId();
        if (r4 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r4)) == true) goto L16;
        return null;
    L16:
        return r4;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    }

    public static final boolean e(Message r1) {
        if (com.larus.bmhome.chat.bean.d.I0(r1) == false) goto L5;
    L9:
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.j0(r1) == false) goto L9;
        int r0 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r1, "message");
        if (com.larus.im.bean.message.a.w0(r1) == true) goto L9;
        return true;
    }

    public static final boolean g(Message r4) {
        if (b0.f(r4) == true) goto L15;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r1 = r4.getBusinessExt();
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = (String) r1.get("original_message_id");
    L8:
        if (r3 != null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r5 = r4.getBusinessExt();
        if (r5 == null) goto L12;
        r2 = (String) r5.get("original_local_message_id");
    L12:
        if (r2 != null) goto L15;
        return false;
    L7:
        r3 = null;
    L15:
        return true;
    }

    public static final Set j(Message r5) {
        Set r0 = SetsKt.createSetBuilder();
        String r1 = r5.getMessageId();
        String r2 = null;
        boolean r3 = true;
        if (r1 != null) goto L5;
    L10:
        String r4 = r5.getLocalMessageId();
        if (r4 != null) goto L13;
    L18:
        String r6 = r5.getReplyId();
        if (r6 == null) goto L31;
        if ((!StringsKt.isBlank(r6)) == true) goto L23;
    L25:
        r3 = false;
    L26:
        if (r3 == false) goto L28;
        r2 = r6;
    L28:
        if (r2 == null) goto L31;
        r0.add(r2);
        goto L31
    L23:
        if (Intrinsics.areEqual(r6, "0") == true) goto L25;
    L31:
        return SetsKt.build(r0);
    L13:
        if ((!StringsKt.isBlank(r4)) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        r0.add(r4);
        goto L18
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r0.add(r1);
        goto L10
    }

    public static final Message a(List r3, String r4) {
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if (i(((xc8.b) r0).getMessage(), r4) == false) goto L4;
    L9:
        xc8.b r1 = (xc8.b) r0;
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.getMessage();
    L8:
        r0 = null;
        goto L9
    }

    public static final boolean b(List r4, Set r5) {
        List r6 = r4;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L29;
        Message r0 = ((xc8.b) r7.next()).getMessage();
        if (CollectionsKt.contains(r5, r0.getReplyId()) == true) goto L13;
    L19:
        boolean r1 = false;
    L20:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (g(r0) == true) goto L19;
        if (com.larus.bmhome.chat.bean.d.G0(r0) == true) goto L19;
        if (e(r0) == false) goto L19;
        r1 = true;
        goto L20
    L29:
        return false;
    L5:
        if (r6.isEmpty() == false) goto L7;
        return false;
    }

    public static final boolean f(List<? extends xc8.b> r2, Set<String> r3) {
        List<? extends xc8.b> r4 = r2;
        if ((r4 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (h(((xc8.b) r5.next()).getMessage(), r3) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r4.isEmpty() == false) goto L7;
        return false;
    }

    public static final boolean h(Message r2, Set<String> r3) {
        if (CollectionsKt.contains(r3, r2.getReplyId()) == true) goto L5;
        return false;
    L5:
        if (g(r2) == false) goto L7;
        return false;
    L7:
        if (com.larus.bmhome.chat.bean.d.G0(r2) == false) goto L9;
        return false;
    L9:
        if (com.larus.bmhome.chat.bean.d.I0(r2) == false) goto L11;
        return false;
    L11:
        if (com.larus.bmhome.chat.bean.d.f0(r2) == true) goto L38;
        String r4 = com.larus.im.bean.message.a.K(r2);
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == true) goto L30;
        String r6 = com.larus.im.bean.message.a.O(r2);
        if (r6 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == true) goto L30;
        if ((!((ArrayList) com.larus.im.bean.message.a.A(r2)).isEmpty()) == true) goto L30;
        boolean r8 = false;
    L31:
        if (r8 == false) goto L39;
        return true;
    L39:
        return false;
    L22:
        if ((!StringsKt.isBlank(r6)) != true) goto L24;
        r7 = true;
    L30:
        r8 = true;
        goto L31
    L15:
        if ((!StringsKt.isBlank(r4)) != true) goto L17;
        r5 = true;
        goto L18
    L38:
        return false;
    }

    public static final boolean i(Message r1, String r2) {
        if (Intrinsics.areEqual(r1.getMessageId(), r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1.getLocalMessageId(), r2) == true) goto L8;
        return false;
    }
}
