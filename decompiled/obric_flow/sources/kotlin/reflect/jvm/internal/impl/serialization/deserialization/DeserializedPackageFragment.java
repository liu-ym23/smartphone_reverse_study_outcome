package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

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

    public DeserializedPackageFragment(FqName r5, StorageManager r10, ModuleDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "module");
        super(r11, r5);
        this.storageManager = r10;
    }

    public abstract ClassDataFinder getClassDataFinder();

    public boolean hasTopLevelClass(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        MemberScope r10 = getMemberScope();
        if ((r10 instanceof DeserializedMemberScope) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeserializedMemberScope) r10).getClassNames$deserialization().contains(r5) == false) goto L7;
        return true;
    }

    public abstract void initialize(DeserializationComponents r5);
}
