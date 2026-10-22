package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final StorageManager storageManager;

    public DeserializedPackageFragment(FqName r10, StorageManager r11, ModuleDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "module");
        super(r12, r10);
        this.storageManager = r11;
    }

    public abstract ClassDataFinder getClassDataFinder();

    public boolean hasTopLevelClass(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        MemberScope r11 = getMemberScope();
        if ((r11 instanceof DeserializedMemberScope) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeserializedMemberScope) r11).getClassNames$deserialization().contains(r10) == false) goto L7;
        return true;
    }

    public abstract void initialize(DeserializationComponents r10);
}
