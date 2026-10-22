package kotlin.reflect.jvm.internal.impl.util;

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

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name r5, Regex r10, Collection<Name> r11, Function1<? super FunctionDescriptor, String> r12, Check... r13) {
        this.name = r5;
        this.regex = r10;
        this.nameList = r11;
        this.additionalCheck = r12;
        this.checks = r13;
    }

    public final CheckResult checkAll(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        Check[] r10 = this.checks;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        String r13 = r10[r12].invoke(r5);
        if (r13 != null) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return new CheckResult.IllegalSignature(r13);
    L9:
        String r14 = this.additionalCheck.invoke(r5);
        if (r14 == null) goto L14;
        return new CheckResult.IllegalSignature(r14);
    L14:
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public final boolean isApplicable(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        if (this.name == null) goto L8;
        if (Intrinsics.areEqual(r5.getName(), this.name) == true) goto L8;
        return false;
    L8:
        if (this.regex == null) goto L12;
        String r10 = r5.getName().asString();
        if (this.regex.matches(r10) == true) goto L12;
        return false;
    L12:
        Collection<Name> r11 = this.nameList;
        if (r11 != null) goto L15;
        return true;
    L15:
        if (r11.contains(r5.getName()) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public /* synthetic */ Checks(Name r5, Check[] r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = AnonymousClass2.INSTANCE;
    L5:
        this(r5, r10, r11);
    }

    public Checks(Name r10, Check[] r11, Function1<? super FunctionDescriptor, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        this(r10, null, null, r12, (Check[]) Arrays.copyOf(r11, r11.length));
    }

    public /* synthetic */ Checks(Regex r5, Check[] r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = AnonymousClass3.INSTANCE;
    L5:
        this(r5, r10, r11);
    }

    public Checks(Regex r10, Check[] r11, Function1<? super FunctionDescriptor, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "regex");
        Intrinsics.checkNotNullParameter(r11, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        this(null, r10, null, r12, (Check[]) Arrays.copyOf(r11, r11.length));
    }

    public /* synthetic */ Checks(Collection r5, Check[] r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = AnonymousClass4.INSTANCE;
    L5:
        this(r5, r10, r11);
    }

    public Checks(Collection<Name> r10, Check[] r11, Function1<? super FunctionDescriptor, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "nameList");
        Intrinsics.checkNotNullParameter(r11, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        this(null, null, r10, r12, (Check[]) Arrays.copyOf(r11, r11.length));
    }
}
