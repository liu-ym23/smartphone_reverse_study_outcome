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
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor r10, StorageManager r11, KotlinTypeRefiner r12, Function1<? super KotlinTypeRefiner, ? extends T> r13) {
            Intrinsics.checkNotNullParameter(r10, "classDescriptor");
            Intrinsics.checkNotNullParameter(r11, "storageManager");
            Intrinsics.checkNotNullParameter(r12, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(r13, "scopeFactory");
            return new ScopesHolderForClass(r10, r11, r13, r12, null);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor r10, StorageManager r11, Function1<? super KotlinTypeRefiner, ? extends T> r12, KotlinTypeRefiner r13) {
        this.classDescriptor = r10;
        this.scopeFactory = r12;
        this.kotlinTypeRefinerForOwnerModule = r13;
        this.scopeForOwnerModule$delegate = r11.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor r10, StorageManager r11, Function1 r12, KotlinTypeRefiner r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefinerForOwnerModule$p(ScopesHolderForClass r10) {
        return r10.kotlinTypeRefinerForOwnerModule;
    }

    public static final /* synthetic */ Function1 access$getScopeFactory$p(ScopesHolderForClass r10) {
        return r10.scopeFactory;
    }

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    public final T getScope(final KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        if (r10.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor)) == false) goto L5;
        TypeConstructor r11 = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r11, "classDescriptor.typeConstructor");
        if (r10.isRefinementNeededForTypeConstructor(r11) == true) goto L11;
        return (T) getScopeForOwnerModule();
    L11:
        return (T) r10.getOrPutScopeForClass(this.classDescriptor, new AnonymousClass1(this, r10));
    L5:
        return (T) getScopeForOwnerModule();
    }
}
