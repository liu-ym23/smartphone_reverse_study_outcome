package yd8;

import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import va8.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements td8.c {
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public b(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r8, xc8.b r9, xc8.b r10, List<xc8.b> r11) {
        Intrinsics.checkNotNullParameter(r10, "current");
        Intrinsics.checkNotNullParameter(r11, "input");
        p0 r12 = this.a.f();
        FloatChatWindowState r13 = this.a.h();
        if (r13 != null) goto L6;
        return r11;
    L6:
        if (r12 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
    L37:
        return r11;
    L13:
        if (r13 == FloatChatWindowState.Expanded) goto L37;
        Set<String> r14 = r12.a;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r11.iterator();
    L17:
        if (r3.hasNext() == false) goto L35;
        Object r4 = r3.next();
        Message r5 = ((xc8.b) r4).getMessage();
        Integer r6 = b0.c(r5);
        if (r6 != null) goto L22;
    L24:
        Set<String> r7 = r14;
        if (CollectionsKt.contains(r7, r5.getMessageId()) == false) goto L27;
    L32:
        boolean r15 = true;
    L33:
        if (r15 == false) goto L17;
        r2.add(r4);
        goto L17
    L27:
        if (CollectionsKt.contains(r7, r5.getLocalMessageId()) == true) goto L32;
        if (CollectionsKt.contains(r7, r5.getReplyId()) == true) goto L32;
        r15 = false;
        goto L33
    L22:
        if (r6.intValue() != 0) goto L24;
    L35:
        List<xc8.b> r16 = CollectionsKt.toMutableList(r2);
        FLogger.a.i("PreviewRoundMessageFilterTask", "filter preview round, before=" + r11.size() + ", after=" + r16.size() + ", queryIds=" + r12.a);
        return r16;
    L8:
        if ((!r12.a.isEmpty()) != true) goto L10;
        r1 = true;
        goto L11
    }
}
