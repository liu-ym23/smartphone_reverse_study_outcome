package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements td8.c {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r8, xc8.b r9, xc8.b r10, List<xc8.b> r11) {
        Intrinsics.checkNotNullParameter(r10, "current");
        Intrinsics.checkNotNullParameter(r11, "input");
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
        int r0 = 0;
        boolean r1 = false;
    L4:
        if (r13.hasNext() == false) goto L39;
        Object r2 = r13.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        xc8.b r4 = (xc8.b) r2;
        Message r5 = r4.getMessage();
        boolean r6 = com.larus.bmhome.chat.bean.d.V(r5);
        boolean r7 = m99.a.f(r5);
        if (r6 == false) goto L13;
        if (r7 == true) goto L13;
        if (r1 == false) goto L13;
        FLogger.a.i("Pipeline_List_AwemeVideoSuggestFilterTask", "filter aweme video suggest at index " + r8);
    L38:
        r0 = r3;
    L13:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (m99.a.f(r5) == true) goto L16;
    L20:
        boolean r14 = false;
    L21:
        if (r14 == false) goto L24;
        FLogger.a.e("Pipeline_List_AwemeVideoSuggestFilterTask", "filter aweme video summary with invalid data at index " + r8 + ", messageId = " + r5.getMessageId());
        goto L38
    L24:
        if (r5.getSourceFromAsr() == false) goto L34;
        Map r15 = r5.getBusinessExt();
        if (r15 == null) goto L28;
        String r16 = (String) r15.get("is_real_audio_text");
    L30:
        if (Intrinsics.areEqual(r16, "1") == true) goto L34;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.j(r5), "is_mock_sending") == true) goto L34;
    L36:
        r1 = false;
    L37:
        r12.add(r4);
        goto L38
    L28:
        r16 = null;
    L34:
        if (com.larus.bmhome.chat.bean.d.V(r5) == true) goto L36;
        r1 = true;
        goto L37
    L16:
        if (o0.d(r5.getMessageId()) == false) goto L20;
        if (r5.getExt() != null) goto L20;
        r14 = true;
        goto L21
    L39:
        return r12;
    }
}
