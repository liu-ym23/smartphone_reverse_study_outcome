package com.larus.bmhome.nestedfile;

import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.bmhome.nestedfile.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0030a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            r0[FieldType.PARSE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FieldType.REVIEW_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final boolean a(EntityState r5) {
        if (r5 == null) goto L40;
        List<Integer> r1 = r5.getUpdateFields();
        if (r1 == null) goto L41;
        List<Integer> r2 = r1;
        if ((r2 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L43;
        int r4 = ((Number) r3.next()).intValue();
        FieldType.a r6 = FieldType.Companion;
        Integer r7 = Integer.valueOf(r4);
        r6.getClass();
        FieldType r8 = FieldType.a.a(r7);
        int r9 = C0030a.a[r8.ordinal()];
        if (r9 != 1) goto L17;
        FileParseState.a r10 = FileParseState.Companion;
        Integer r11 = r5.getParseState();
        r10.getClass();
        int r12 = FileParseState.FAILED.getValue();
        if (r11 != null) goto L29;
    L31:
        boolean r13 = false;
    L32:
        if (r13 == false) goto L13;
        return true;
    L29:
        if (r11.intValue() != r12) goto L31;
    L30:
        r13 = true;
        goto L32
    L17:
        if (r9 != 2) goto L31;
        FileReviewState.a r14 = FileReviewState.Companion;
        Integer r15 = r5.getReviewState();
        r14.getClass();
        int r16 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r15 == null) goto L31;
        if (r15.intValue() != r16) goto L31;
    L43:
        return false;
    L9:
        if (r2.isEmpty() == false) goto L11;
        return false;
    L41:
        return false;
    L40:
        return false;
    }
}
