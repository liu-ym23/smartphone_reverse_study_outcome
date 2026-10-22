package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface DeclaredMemberIndex {

    public static final class Empty implements DeclaredMemberIndex {
        public static final Empty INSTANCE = null;

        static {
            INSTANCE = new Empty();
        }

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public JavaField findFieldByName(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public /* bridge */ /* synthetic */ Collection findMethodsByName(Name r10) {
            return findMethodsByName(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public List<JavaMethod> findMethodsByName(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public JavaRecordComponent findRecordComponentByName(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public Set<Name> getFieldNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public Set<Name> getMethodNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public Set<Name> getRecordComponentNames() {
            return SetsKt.emptySet();
        }
    }

    JavaField findFieldByName(Name r10);

    Collection<JavaMethod> findMethodsByName(Name r10);

    JavaRecordComponent findRecordComponentByName(Name r10);

    Set<Name> getFieldNames();

    Set<Name> getMethodNames();

    Set<Name> getRecordComponentNames();
}
