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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor r8, StorageManager r9, KotlinTypeRefiner r10, Function1<? super KotlinTypeRefiner, ? extends T> r11) {
            Intrinsics.checkNotNullParameter(r8, "classDescriptor");
            Intrinsics.checkNotNullParameter(r9, "storageManager");
            Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(r11, "scopeFactory");
            return new ScopesHolderForClass(r8, r9, r11, r10, null);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
        Companion = new Companion(null);
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor r1, StorageManager r2, Function1 r3, KotlinTypeRefiner r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ MemberScope accessor$ScopesHolderForClass$lambda0(ScopesHolderForClass r0) {
        return scopeForOwnerModule_delegate$lambda$0(r0);
    }

    public static /* synthetic */ MemberScope accessor$ScopesHolderForClass$lambda1(ScopesHolderForClass r0, KotlinTypeRefiner r1) {
        return getScope$lambda$1(r0, r1);
    }

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    private static final MemberScope scopeForOwnerModule_delegate$lambda$0(ScopesHolderForClass r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return (MemberScope) r1.scopeFactory.invoke(r1.kotlinTypeRefinerForOwnerModule);
    }

    public final T getScope(KotlinTypeRefiner r3) {
        Intrinsics.checkNotNullParameter(r3, "kotlinTypeRefiner");
        if (r3.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor)) == true) goto L7;
        return (T) getScopeForOwnerModule();
    L7:
        if (r3.isRefinementNeededForTypeConstructor(this.classDescriptor.getTypeConstructor()) == true) goto L11;
        return (T) getScopeForOwnerModule();
    L11:
        return (T) r3.getOrPutScopeForClass(this.classDescriptor, new ScopesHolderForClass$.Lambda.1(this, r3));
    }

    private static final MemberScope getScope$lambda$1(ScopesHolderForClass r1, KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$kotlinTypeRefiner");
        return (MemberScope) r1.scopeFactory.invoke(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor r1, StorageManager r2, Function1<? super KotlinTypeRefiner, ? extends T> r3, KotlinTypeRefiner r4) {
        this.classDescriptor = r1;
        this.scopeFactory = r3;
        this.kotlinTypeRefinerForOwnerModule = r4;
        this.scopeForOwnerModule$delegate = r2.createLazyValue(new ScopesHolderForClass$$Lambda$0(this));
    }
}
