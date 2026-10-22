package zub;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import mcb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final String[] b = null;
    public final c a;

    /* JADX INFO: renamed from: zub.a$a, reason: collision with other inner class name */
    public static final class C0208a {
    }

    static {
        b = new String[]{"lark_rtc", "feishu_rtc", "lark_pre_rtc", "feishu_pre_rtc", "lark_test_pre_rtc", "feishu_test_pre_rtc", "lark_test_gauss_rtc", "feishu_test_gauss_rtc", "lark_test_rtc", "feishu_test_rtc"};
    }

    public final String a() {
        String r0 = this.a.a("api");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        return "";
    }

    public final String b() {
        List r0 = this.a.b("vc_mm");
        String r3 = "";
        if ((!r0.isEmpty()) == true) goto L5;
        return "";
    L5:
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).envType() != 3) goto L32;
        List r1 = new Regex("\\.").split((CharSequence) ListProtector.get(r0, 0), 0);
        if (r1.isEmpty() == true) goto L17;
        ListIterator r2 = r1.listIterator(r1.size());
    L10:
        if (r2.hasPrevious() == false) goto L17;
        if (((String) r2.previous()).length() != 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L10;
        List r5 = CollectionsKt.take(r1, r2.nextIndex() + 1);
    L18:
        String[] r6 = (String[]) r5.toArray(new String[0]);
        int r7 = r6.length;
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L30;
        StringBuilder r9 = new StringBuilder();
        r9.append(r3);
        if (r8 != (r6.length - 2)) goto L27;
        StringBuilder r10 = new StringBuilder();
        r10.append(r6[r8]);
        if (StringsKt.endsWith$default(r6[r8], "-pre", false, 2, null) == false) goto L25;
        String r11 = ".";
    L26:
        r10.append(r11);
        String r12 = r10.toString();
    L28:
        r9.append(r12);
        r3 = r9.toString();
        r8 = r8 + 1;
        goto L19
    L25:
        r11 = "-pre.";
        goto L26
    L27:
        r12 = r6[r8] + '.';
        goto L28
    L30:
        return "https://" + r3.substring(0, r3.length() - 1);
    L14:
        r4 = false;
    L17:
        r5 = CollectionsKt.emptyList();
        goto L18
    L32:
        return "https://" + ((String) ListProtector.get(r0, 0));
    }

    public final String c() {
        String r0 = this.a.a("vc_mm");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        return "";
    }

    public final String d() {
        List r0 = this.a.b("vc_web");
        String r3 = "";
        if ((!r0.isEmpty()) == true) goto L5;
        return "";
    L5:
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).envType() != 3) goto L32;
        List r1 = new Regex("\\.").split((CharSequence) ListProtector.get(r0, 0), 0);
        if (r1.isEmpty() == true) goto L17;
        ListIterator r2 = r1.listIterator(r1.size());
    L10:
        if (r2.hasPrevious() == false) goto L17;
        if (((String) r2.previous()).length() != 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L10;
        List r5 = CollectionsKt.take(r1, r2.nextIndex() + 1);
    L18:
        String[] r6 = (String[]) r5.toArray(new String[0]);
        int r7 = r6.length;
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L30;
        StringBuilder r9 = new StringBuilder();
        r9.append(r3);
        if (r8 != (r6.length - 2)) goto L27;
        StringBuilder r10 = new StringBuilder();
        r10.append(r6[r8]);
        if (StringsKt.endsWith$default(r6[r8], "-pre", false, 2, null) == false) goto L25;
        String r11 = ".";
    L26:
        r10.append(r11);
        String r12 = r10.toString();
    L28:
        r9.append(r12);
        r3 = r9.toString();
        r8 = r8 + 1;
        goto L19
    L25:
        r11 = "-pre.";
        goto L26
    L27:
        r12 = r6[r8] + '.';
        goto L28
    L30:
        return "https://" + r3.substring(0, r3.length() - 1);
    L14:
        r4 = false;
    L17:
        r5 = CollectionsKt.emptyList();
        goto L18
    L32:
        return "https://" + ((String) ListProtector.get(r0, 0));
    }

    public final List<String> e() {
        List<String> r0 = this.a.b("rtc_defaultips");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<String> g() {
        return this.a.b("rtc_frontier");
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "userDomainConfig");
        this.a = r2;
    }

    public final List<String> f(String r6) {
        String[] r0 = b;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        String r3 = r0[r2];
        if (TextUtils.equals(r6, r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return this.a.b(r3);
    L10:
        return CollectionsKt.emptyList();
    }
}
