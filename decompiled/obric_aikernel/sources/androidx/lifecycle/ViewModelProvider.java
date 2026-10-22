package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nViewModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
public class ViewModelProvider {
    private final CreationExtras defaultCreationExtras;
    private final Factory factory;
    private final ViewModelStore store;

    public static class AndroidViewModelFactory extends NewInstanceFactory {

        @JvmField
        public static final CreationExtras.Key<Application> APPLICATION_KEY = null;
        public static final Companion Companion = null;
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        private static AndroidViewModelFactory sInstance;
        private final Application application;

        public static final class Companion {

            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {
                public static final ApplicationKeyImpl INSTANCE = null;

                static {
                    INSTANCE = new ApplicationKeyImpl();
                }

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner r10) {
                Intrinsics.checkNotNullParameter(r10, "owner");
                if ((r10 instanceof HasDefaultViewModelProviderFactory) == false) goto L6;
                return ((HasDefaultViewModelProviderFactory) r10).getDefaultViewModelProviderFactory();
            L6:
                return NewInstanceFactory.Companion.getInstance();
            }

            @JvmStatic
            public final AndroidViewModelFactory getInstance(Application r10) {
                Intrinsics.checkNotNullParameter(r10, "application");
                if (AndroidViewModelFactory.access$getSInstance$cp() != null) goto L5;
                AndroidViewModelFactory.access$setSInstance$cp(new AndroidViewModelFactory(r10));
            L5:
                AndroidViewModelFactory r11 = AndroidViewModelFactory.access$getSInstance$cp();
                Intrinsics.checkNotNull(r11);
                return r11;
            }
        }

        static {
            Companion = new Companion(null);
            APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        public AndroidViewModelFactory(Application r10) {
            Intrinsics.checkNotNullParameter(r10, "application");
            this(r10, 0);
        }

        private AndroidViewModelFactory(Application r10, int r11) {
            this.application = r10;
        }

        public static final /* synthetic */ AndroidViewModelFactory access$getSInstance$cp() {
            return sInstance;
        }

        public static final /* synthetic */ void access$setSInstance$cp(AndroidViewModelFactory r10) {
            sInstance = r10;
        }

        private final <T extends ViewModel> T create(Class<T> r10, Application r11) {
            if (AndroidViewModel.class.isAssignableFrom(r10) == false) goto L20;
            T r12 = r10.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{r11});     // Catch: InvocationTargetException -> L7 InstantiationException -> L10 IllegalAccessException -> L13 NoSuchMethodException -> L16
            Intrinsics.checkNotNullExpressionValue(r12, "{\n                try {\n…          }\n            }");
            return r12;
        L13:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L10:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L16:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L20:
            return (T) super.create(r10);
        }

        @JvmStatic
        public static final AndroidViewModelFactory getInstance(Application r10) {
            return Companion.getInstance(r10);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            Application r11 = this.application;
            if (r11 == null) goto L7;
            return (T) create(r10, r11);
        L7:
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r10, CreationExtras r11) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            Intrinsics.checkNotNullParameter(r11, "extras");
            if (this.application != null) goto L14;
            Application r12 = (Application) r11.get(APPLICATION_KEY);
            if (r12 == null) goto L9;
            return (T) create(r10, r12);
        L9:
            if (AndroidViewModel.class.isAssignableFrom(r10) == true) goto L13;
            return (T) super.create(r10);
        L13:
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        L14:
            return (T) create(r10);
        }
    }

    public interface Factory {
        public static final Companion Companion = null;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }

            @JvmStatic
            public final Factory from(ViewModelInitializer<?>... r10) {
                Intrinsics.checkNotNullParameter(r10, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(r10, r10.length));
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        @JvmStatic
        static Factory from(ViewModelInitializer<?>... r10) {
            return Companion.from(r10);
        }

        default <T extends ViewModel> T create(Class<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default <T extends ViewModel> T create(Class<T> r10, CreationExtras r11) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            Intrinsics.checkNotNullParameter(r11, "extras");
            return (T) create(r10);
        }
    }

    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = null;

        @JvmField
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = null;
        private static NewInstanceFactory sInstance;

        public static final class Companion {

            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {
                public static final ViewModelKeyImpl INSTANCE = null;

                static {
                    INSTANCE = new ViewModelKeyImpl();
                }

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            @JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.access$getSInstance$cp() != null) goto L5;
                NewInstanceFactory.access$setSInstance$cp(new NewInstanceFactory());
            L5:
                NewInstanceFactory r10 = NewInstanceFactory.access$getSInstance$cp();
                Intrinsics.checkNotNull(r10);
                return r10;
            }
        }

        static {
            Companion = new Companion(null);
            VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;
        }

        public NewInstanceFactory() {
        }

        public static final /* synthetic */ NewInstanceFactory access$getSInstance$cp() {
            return sInstance;
        }

        public static final /* synthetic */ void access$setSInstance$cp(NewInstanceFactory r10) {
            sInstance = r10;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            T r11 = r10.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: IllegalAccessException -> L5 InstantiationException -> L8 NoSuchMethodException -> L11
            Intrinsics.checkNotNullExpressionValue(r11, "{\n                modelC…wInstance()\n            }");     // Catch: IllegalAccessException -> L5 InstantiationException -> L8 NoSuchMethodException -> L11
            return r11;
        L5:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L8:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L11:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public OnRequeryFactory() {
        }

        public void onRequery(ViewModel r10) {
            Intrinsics.checkNotNullParameter(r10, "viewModel");
        }
    }

    @JvmOverloads
    public ViewModelProvider(ViewModelStore r10, Factory r11) {
        Intrinsics.checkNotNullParameter(r10, "store");
        Intrinsics.checkNotNullParameter(r11, "factory");
        this(r10, r11, null, 4, null);
    }

    @JvmOverloads
    public ViewModelProvider(ViewModelStore r10, Factory r11, CreationExtras r12) {
        Intrinsics.checkNotNullParameter(r10, "store");
        Intrinsics.checkNotNullParameter(r11, "factory");
        Intrinsics.checkNotNullParameter(r12, "defaultCreationExtras");
        this.store = r10;
        this.factory = r11;
        this.defaultCreationExtras = r12;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore r10, Factory r11, CreationExtras r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = CreationExtras.Empty.INSTANCE;
    L5:
        this(r10, r11, r12);
    }

    public ViewModelProvider(ViewModelStoreOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this(r10.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(r10), ViewModelProviderGetKt.defaultCreationExtras(r10));
    }

    public ViewModelProvider(ViewModelStoreOwner r10, Factory r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "factory");
        this(r10.getViewModelStore(), r11, ViewModelProviderGetKt.defaultCreationExtras(r10));
    }

    @MainThread
    public <T extends ViewModel> T get(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        String r11 = r10.getCanonicalName();
        if (r11 == null) goto L7;
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + r11, r10);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @MainThread
    public <T extends ViewModel> T get(String r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "modelClass");
        T r12 = (T) this.store.get(r10);
        if (r11.isInstance(r12) == false) goto L12;
        Object r13 = this.factory;
        if ((r13 instanceof OnRequeryFactory) == false) goto L7;
        OnRequeryFactory r14 = (OnRequeryFactory) r13;
    L8:
        if (r14 == null) goto L10;
        Intrinsics.checkNotNull(r12);
        r14.onRequery(r12);
    L10:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return r12;
    L7:
        r14 = null;
        goto L8
    L12:
        MutableCreationExtras r15 = new MutableCreationExtras(this.defaultCreationExtras);
        r15.set(NewInstanceFactory.VIEW_MODEL_KEY, r10);
        T r16 = (T) this.factory.create(r11, r15);
    L16:
        this.store.put(r10, r16);
        return r16;
    L15:
        r16 = (T) this.factory.create(r11);
        goto L16
    }
}
