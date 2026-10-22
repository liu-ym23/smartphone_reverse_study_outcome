package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilsKt {
    public static final void record(LookupTracker r10, LookupLocation r11, ClassDescriptor r12, Name r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "scopeOwner");
        Intrinsics.checkNotNullParameter(r13, "name");
        if (r10 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r14 = r11.getLocation();
        if (r14 != null) goto L9;
        return;
    L9:
        if (r10.getRequiresPosition() == false) goto L12;
        Position r5 = r14.getPosition();
    L11:
        Position r15 = r5;
        r10.record(r14.getFilePath(), r15, DescriptorUtils.getFqName(r12).asString(), ScopeKind.CLASSIFIER, r13.asString());
        return;
    L12:
        r5 = Position.Companion.getNO_POSITION();
        goto L11
    }

    public static final void recordPackageLookup(LookupTracker r10, LookupLocation r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "packageFqName");
        Intrinsics.checkNotNullParameter(r13, "name");
        if (r10 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r14 = r11.getLocation();
        if (r14 != null) goto L9;
        return;
    L9:
        if (r10.getRequiresPosition() == false) goto L12;
        Position r5 = r14.getPosition();
    L11:
        Position r15 = r5;
        r10.record(r14.getFilePath(), r15, r12, ScopeKind.PACKAGE, r13);
        return;
    L12:
        r5 = Position.Companion.getNO_POSITION();
        goto L11
    }

    public static final void record(LookupTracker r5, LookupLocation r10, PackageFragmentDescriptor r11, Name r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, "scopeOwner");
        Intrinsics.checkNotNullParameter(r12, "name");
        recordPackageLookup(r5, r10, r11.getFqName().asString(), r12.asString());
    }
}
