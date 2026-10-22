package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final ClassDescriptor classDescriptor;
    private final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    private final Function1<KotlinTypeRefiner, T> scopeFactory;
    private final NotNullLazyValue scopeForOwnerModule$delegate;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor r10, StorageManager r11, KotlinTypeRefiner r12, Function1<? super KotlinTypeRefiner, ? extends T> r13) {
            Intrinsics.checkNotNullParameter(r10, "classDescriptor");
            Intrinsics.checkNotNullParameter(r11, "storageManager");
            Intrinsics.checkNotNullParameter(r12, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(r13, "scopeFactory");
            return new ScopesHolderForClass(r10, r11, r13, r12, null);
        }

        private Companion() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
        Companion = new Companion(null);
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor r5, StorageManager r10, Function1 r11, KotlinTypeRefiner r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefinerForOwnerModule$p(ScopesHolderForClass r5) {
        return r5.kotlinTypeRefinerForOwnerModule;
    }

    public static final /* synthetic */ Function1 access$getScopeFactory$p(ScopesHolderForClass r5) {
        return r5.scopeFactory;
    }

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    public final T getScope(final KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        if (r5.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor)) == true) goto L7;
        return (T) getScopeForOwnerModule();
    L7:
        if (r5.isRefinementNeededForTypeConstructor(this.classDescriptor.getTypeConstructor()) == true) goto L11;
        return (T) getScopeForOwnerModule();
    L11:
        return (T) r5.getOrPutScopeForClass(this.classDescriptor, new AnonymousClass1(this, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor r5, StorageManager r10, Function1<? super KotlinTypeRefiner, ? extends T> r11, KotlinTypeRefiner r12) {
        this.classDescriptor = r5;
        this.scopeFactory = r11;
        this.kotlinTypeRefinerForOwnerModule = r12;
        this.scopeForOwnerModule$delegate = r10.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }
}
