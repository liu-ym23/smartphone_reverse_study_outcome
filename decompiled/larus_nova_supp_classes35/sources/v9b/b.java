package v9b;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.light.processor.t;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final ValidateResult a;
    public final boolean b;
    public final ValidateIMFileResult c;
    public final t.a d;

    public static final class a {
    }

    /* JADX INFO: renamed from: v9b.b$b, reason: collision with other inner class name */
    public static final class C0311b<T> implements Comparator {
        public C0311b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((String) ((Map.Entry) r1).getKey(), (String) ((Map.Entry) r2).getKey());
        }
    }

    static {
    }

    public b() {
        this(null, false, null, 15);
    }

    public final String toString() {
        return "PermissionContextData(previewValidateResult=" + this.a + ", hasPreviewPermission=" + this.b + ", validateIMFileResult=" + this.c + ", noPreviewDrawableConfig=" + this.d + ')';
    }

    public final int hashCode() {
        int r0 = a(this.a) * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        t.a r3 = this.d;
        int r4 = 0;
        if (r3 == null) goto L9;
        int r5 = r3.hashCode();
    L10:
        int r6 = (r2 + r5) * 31;
        ValidateIMFileResult r7 = this.c;
        HashMap r8 = null;
        if (r7 == null) goto L13;
        IMFileResult r9 = r7.getResultType();
    L14:
        if (r9 == null) goto L16;
        int r10 = r9.hashCode();
    L17:
        int r11 = (r6 + r10) * 31;
        ValidateIMFileResult r12 = this.c;
        if (r12 == null) goto L22;
        ValidateResult r13 = r12.getValidateResult();
        if (r13 == null) goto L22;
        r4 = a(r13);
    L22:
        int r14 = (r11 + r4) * 31;
        ValidateIMFileResult r15 = this.c;
        if (r15 == null) goto L26;
        r8 = r15.getResultMap();
    L26:
        return r14 + b(r8);
    L16:
        r10 = 0;
        goto L17
    L13:
        r9 = null;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public static int a(ValidateResult r2) {
        if (r2.getResult() != ResultType.NULL) goto L5;
        return 0;
    L5:
        if (r2.getResult() != ResultType.ALLOW) goto L8;
        return 0;
    L8:
        return r2.getResult().hashCode();
    }

    public static int b(Map r3) {
        int r1 = 1;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return 0;
    L11:
        Iterator r4 = CollectionsKt.sortedWith(r3.entrySet(), new C0311b()).iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r0 = (Map.Entry) r4.next();
        r1 = (((((r1 * 31) + ((String) r0.getKey()).hashCode()) * 31) + ((ValidateIMFileResult) r0.getValue()).getResultType().hashCode()) * 31) + a(((ValidateIMFileResult) r0.getValue()).getValidateResult());
        goto L13
    L15:
        return r1;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        HashMap r2 = null;
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.coremd.facade.bizext.context.PermissionContextData");
        b r8 = (b) r7;
        if (Intrinsics.areEqual(this.a, r8.a) == true) goto L16;
        return false;
    L16:
        if (this.b == r8.b) goto L18;
        return false;
    L18:
        ValidateIMFileResult r1 = this.c;
        int r4 = 4;
        if (r1 == null) goto L23;
        IMFileResult r5 = r1.getResultType();
        if (r5 == null) goto L23;
        int r6 = r5.getValue();
    L24:
        ValidateIMFileResult r9 = r8.c;
        if (r9 == null) goto L29;
        IMFileResult r10 = r9.getResultType();
        if (r10 == null) goto L29;
        r4 = r10.getValue();
    L29:
        if (r6 == r4) goto L31;
        return false;
    L31:
        ValidateIMFileResult r11 = this.c;
        if (r11 == null) goto L34;
        HashMap r12 = r11.getResultMap();
    L35:
        int r13 = b(r12);
        ValidateIMFileResult r14 = r8.c;
        if (r14 == null) goto L39;
        r2 = r14.getResultMap();
    L39:
        if (r13 == b(r2)) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L44;
        return false;
    L44:
        return true;
    L34:
        r12 = null;
    L23:
        r6 = 4;
        goto L24
    L8:
        r3 = null;
        goto L10
    }

    public b(ValidateResult r2, boolean r3, ValidateIMFileResult r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = new ValidateResult(ResultType.ALLOW);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        Intrinsics.checkNotNullParameter(r2, "previewValidateResult");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
    }
}
