package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final StorageManager storageManager;

    public abstract ClassDataFinder getClassDataFinder();

    public abstract void initialize(DeserializationComponents r1);

    public boolean hasTopLevelClass(Name r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        MemberScope r0 = getMemberScope();
        if ((r0 instanceof DeserializedMemberScope) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeserializedMemberScope) r0).getClassNames$deserialization().contains(r3) == false) goto L7;
        return true;
    }

    public DeserializedPackageFragment(FqName r2, StorageManager r3, ModuleDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "module");
        super(r4, r2);
        this.storageManager = r3;
    }
}
