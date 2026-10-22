package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.image.entity.EncryptImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static Object b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r1 = r3.a;
        if (r1 != null) goto L8;
    L13:
        String r2 = r3.b;
        if (r2 != null) goto L16;
        return null;
    L16:
        if ((!StringsKt.isBlank(r2)) == true) goto L19;
        r2 = null;
    L19:
        if (r2 != null) goto L22;
        return null;
    L22:
        return new EncryptImage(r2, r3.c, r3.d);
    L8:
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        return r1;
    }

    public static String c(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r3) {
        String r0 = r3.a;
        if (r0 != null) goto L5;
    L11:
        String r4 = r3.b;
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

    public static List a(FragmentActivity r11, List r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "images");
        ArrayList r0 = new ArrayList();
        Iterator r13 = r12.iterator();
        int r1 = 0;
    L4:
        if (r13.hasNext() == false) goto L42;
        Object r2 = r13.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g) r2;
        Pair r5 = null;
        if (r4 == null) goto L39;
        a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r6 = r4.a;
        if (r6 == null) goto L14;
    L16:
        if (r6 != null) goto L18;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r7 = r4.b;
    L19:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r8 = r4.b;
        if (r8 == null) goto L24;
        r6 = r8;
    L24:
        if (r7 != null) goto L26;
        MmAINoteImagePreviewHelper$createBitmapProvider$1 r9 = null;
    L27:
        if (r6 != null) goto L29;
        MmAINoteImagePreviewHelper$createBitmapProvider$1 r10 = null;
    L30:
        if (r7 == null) goto L32;
        String r14 = c(r7);
    L33:
        if (r6 == null) goto L35;
        String r15 = c(r6);
    L36:
        com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.d r16 = new com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.d(new com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.c(r9, r10, r14, r15));
    L37:
        if (r16 == null) goto L39;
        r5 = TuplesKt.to(Integer.valueOf(r1), r16);
        goto L39
    L35:
        r15 = null;
        goto L36
    L32:
        r14 = null;
        goto L33
    L29:
        r10 = new MmAINoteImagePreviewHelper$createBitmapProvider$1(r6, r11, r11.getApplicationContext(), null);
        goto L30
    L26:
        r9 = new MmAINoteImagePreviewHelper$createBitmapProvider$1(r7, r11, r11.getApplicationContext(), null);
        goto L27
    L18:
        r7 = r6;
        goto L19
    L14:
        if (r4.b != null) goto L16;
        r16 = null;
    L39:
        if (r5 == null) goto L41;
        r0.add(r5);
    L41:
        r1 = r3;
        goto L4
    L42:
        return r0;
    }
}
