package kotlin.reflect.jvm.internal.impl.incremental;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class UtilsKt {
    public static final void record(LookupTracker r7, LookupLocation r8, ClassDescriptor r9, Name r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "from");
        Intrinsics.checkNotNullParameter(r9, "scopeOwner");
        Intrinsics.checkNotNullParameter(r10, DBDefinition.NAME);
        if (r7 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r11 = r8.getLocation();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r7.getRequiresPosition() == false) goto L11;
        Position r0 = r11.getPosition();
    L12:
        String r2 = r11.getFilePath();
        r7.record(r2, r0, DescriptorUtils.getFqName(r9).asString(), ScopeKind.CLASSIFIER, r10.asString());
        return;
    L11:
        r0 = Position.Companion.getNO_POSITION();
        goto L12
    }

    public static final void recordPackageLookup(LookupTracker r7, LookupLocation r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "from");
        Intrinsics.checkNotNullParameter(r9, "packageFqName");
        Intrinsics.checkNotNullParameter(r10, DBDefinition.NAME);
        if (r7 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r11 = r8.getLocation();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r7.getRequiresPosition() == false) goto L11;
        Position r0 = r11.getPosition();
    L12:
        String r2 = r11.getFilePath();
        r7.record(r2, r0, r9, ScopeKind.PACKAGE, r10);
        return;
    L11:
        r0 = Position.Companion.getNO_POSITION();
        goto L12
    }

    public static final void record(LookupTracker r1, LookupLocation r2, PackageFragmentDescriptor r3, Name r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "scopeOwner");
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        recordPackageLookup(r1, r2, r3.getFqName().asString(), r4.asString());
    }
}
