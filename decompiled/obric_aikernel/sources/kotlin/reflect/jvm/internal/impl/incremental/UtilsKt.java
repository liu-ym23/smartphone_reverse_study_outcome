package kotlin.reflect.jvm.internal.impl.incremental;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        if (r10 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r14 = r11.getLocation();
        if (r14 != null) goto L9;
        return;
    L9:
        if (r10.getRequiresPosition() == false) goto L11;
        Position r15 = r14.getPosition();
    L12:
        String r16 = r14.getFilePath();
        String r17 = DescriptorUtils.getFqName(r12).asString();
        Intrinsics.checkNotNullExpressionValue(r17, "getFqName(scopeOwner).asString()");
        ScopeKind r18 = ScopeKind.CLASSIFIER;
        String r19 = r13.asString();
        Intrinsics.checkNotNullExpressionValue(r19, "name.asString()");
        r10.record(r16, r15, r17, r18, r19);
        return;
    L11:
        r15 = Position.Companion.getNO_POSITION();
        goto L12
    }

    public static final void record(LookupTracker r10, LookupLocation r11, PackageFragmentDescriptor r12, Name r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "scopeOwner");
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        String r14 = r12.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(r14, "scopeOwner.fqName.asString()");
        String r15 = r13.asString();
        Intrinsics.checkNotNullExpressionValue(r15, "name.asString()");
        recordPackageLookup(r10, r11, r14, r15);
    }

    public static final void recordPackageLookup(LookupTracker r10, LookupLocation r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "packageFqName");
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        if (r10 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r14 = r11.getLocation();
        if (r14 != null) goto L9;
        return;
    L9:
        if (r10.getRequiresPosition() == false) goto L11;
        Position r15 = r14.getPosition();
    L12:
        String r16 = r14.getFilePath();
        r10.record(r16, r15, r12, ScopeKind.PACKAGE, r13);
        return;
    L11:
        r15 = Position.Companion.getNO_POSITION();
        goto L12
    }
}
