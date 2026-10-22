package a0a;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import t1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements c {
    public final Bundle a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "SpringMainVenueArgumentData(arguments=" + this.a + ')';
    }

    public final String a() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("action_bar_key");
    }

    public final String b() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("enter_method");
    }

    public b(Bundle r1) {
        this.a = r1;
    }

    public final List<a> c(String r21) {
        List r0 = StringsKt.split$default(r21, new String[]{"_"}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(StringsKt.trim((String) r2.next()).toString());
        goto L4
    L6:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L7:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L14;
        Object r6 = r4.next();
        if (((String) r6).length() <= 0) goto L12;
        r5 = true;
    L12:
        if (r5 == false) goto L7;
        r3.add(r6);
        goto L7
    L14:
        ArrayList r7 = new ArrayList();
        int r8 = ProgressionUtilKt.getProgressionLastElement(0, r3.size() - 1, 2);
        if (r8 < 0) goto L45;
        int r9 = 0;
    L17:
        int r10 = r9 + 1;
        if (r10 >= r3.size()) goto L45;
        String r11 = (String) ListProtector.get(r3, r9);
        String r12 = (String) ListProtector.get(r3, r10);
        Float r13 = StringsKt.toFloatOrNull(r11);
        if (r13 == null) goto L43;
        float r14 = r13.floatValue();
        if (r14 < 0.0f) goto L43;
        if (r14 > 1.0f) goto L43;
        String r15 = StringsKt.replace$default(r12, "#", "", false, 4, null).toUpperCase(Locale.ROOT);
        if (new Regex("[0-9A-F]+").matches(r15) == false) goto L33;
        int r16 = r15.length();
        if (r16 != 3) goto L32;
        StringBuilder r17 = new StringBuilder("#");
        ArrayList r18 = new ArrayList(r15.length());
        int r19 = 0;
    L37:
        if (r19 >= r15.length()) goto L39;
        r18.add(StringsKt.repeat(String.valueOf(r15.charAt(r19)), 2));
        r19 = r19 + 1;
        goto L37
    L39:
        r17.append(CollectionsKt.joinToString$default(r18, "", null, null, 0, null, null, 62, null));
        String r20 = r17.toString();
    L40:
        if (r20 == null) goto L43;
        r7.add(new a(r20, r14));
        goto L43
    L32:
        if (r16 != 6) goto L33;
        r20 = "#".concat(r15);
    L33:
        r20 = null;
    L43:
        if (r9 == r8) goto L45;
        r9 = r9 + 2;
    L45:
        return r7;
    }
}
