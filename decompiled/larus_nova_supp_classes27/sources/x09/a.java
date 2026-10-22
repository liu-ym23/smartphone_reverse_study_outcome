package x09;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements c {
    public final Bundle a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
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
        return "FlowCommonVenueArgumentData(arguments=" + this.a + ')';
    }

    public final String a() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("action_bar_key");
    }

    public final Integer b() {
        Bundle r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.containsKey("biz_scene") == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r0.getInt("biz_scene"));
    }

    public final String c() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    }

    public a(Bundle r1) {
        this.a = r1;
    }

    public final List<d> d(String r8) {
        List r9 = StringsKt.split$default(r8, new String[]{"_"}, false, 0, 6, null);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((String) r10.next()).toString());
        goto L4
    L6:
        ArrayList r11 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        int r2 = 0;
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        if (((String) r3).length() <= 0) goto L12;
        r2 = 1;
    L12:
        if (r2 == 0) goto L7;
        r11.add(r3);
        goto L7
    L14:
        ArrayList r4 = new ArrayList();
        int r5 = ProgressionUtilKt.getProgressionLastElement(0, r11.size() - 1, 2);
        if (r5 < 0) goto L31;
    L16:
        int r6 = r2 + 1;
        if (r6 >= r11.size()) goto L31;
        String r7 = (String) ListProtector.get(r11, r2);
        String r12 = (String) ListProtector.get(r11, r6);
        Float r13 = StringsKt.toFloatOrNull(r7);
        if (r13 == null) goto L29;
        float r14 = r13.floatValue();
        if (r14 < 0.0f) goto L29;
        if (r14 > 1.0f) goto L29;
        String r15 = b.a(r12);
        if (r15 == null) goto L29;
        r4.add(new d(r15, r14));
    L29:
        if (r2 == r5) goto L31;
        r2 = r2 + 2;
    L31:
        return r4;
    }
}
