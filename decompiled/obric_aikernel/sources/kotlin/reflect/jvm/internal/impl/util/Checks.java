package kotlin.reflect.jvm.internal.impl.util;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class Checks {
    private final Function1<FunctionDescriptor, String> additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection<Name> nameList;
    private final Regex regex;

    public Checks(Collection<Name> r10, Check[] r11, Function1<? super FunctionDescriptor, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "nameList");
        Intrinsics.checkNotNullParameter(r11, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        this(null, null, r10, r12, (Check[]) Arrays.copyOf(r11, r11.length));
    }

    public /* synthetic */ Checks(Collection r10, Check[] r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = AnonymousClass4.INSTANCE;
    L5:
        this(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name r10, Regex r11, Collection<Name> r12, Function1<? super FunctionDescriptor, String> r13, Check... r14) {
        this.name = r10;
        this.regex = r11;
        this.nameList = r12;
        this.additionalCheck = r13;
        this.checks = r14;
    }

    public Checks(Name r10, Check[] r11, Function1<? super FunctionDescriptor, String> r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        this(r10, null, null, r12, (Check[]) Arrays.copyOf(r11, r11.length));
    }

    public /* synthetic */ Checks(Name r10, Check[] r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = AnonymousClass2.INSTANCE;
    L5:
        this(r10, r11, r12);
    }

    public Checks(Regex r10, Check[] r11, Function1<? super FunctionDescriptor, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "regex");
        Intrinsics.checkNotNullParameter(r11, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        this(null, r10, null, r12, (Check[]) Arrays.copyOf(r11, r11.length));
    }

    public /* synthetic */ Checks(Regex r10, Check[] r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = AnonymousClass3.INSTANCE;
    L5:
        this(r10, r11, r12);
    }

    public final CheckResult checkAll(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        Check[] r11 = this.checks;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = r11[r13].invoke(r10);
        if (r14 != null) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return new CheckResult.IllegalSignature(r14);
    L9:
        String r15 = this.additionalCheck.invoke(r10);
        if (r15 == null) goto L14;
        return new CheckResult.IllegalSignature(r15);
    L14:
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public final boolean isApplicable(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        if (this.name == null) goto L8;
        if (Intrinsics.areEqual(r10.getName(), this.name) == true) goto L8;
        return false;
    L8:
        if (this.regex == null) goto L12;
        String r11 = r10.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r11, "functionDescriptor.name.asString()");
        if (this.regex.matches(r11) == true) goto L12;
        return false;
    L12:
        Collection<Name> r12 = this.nameList;
        if (r12 != null) goto L15;
        return true;
    L15:
        if (r12.contains(r10.getName()) == true) goto L19;
        return false;
    L19:
        return true;
    }
}
