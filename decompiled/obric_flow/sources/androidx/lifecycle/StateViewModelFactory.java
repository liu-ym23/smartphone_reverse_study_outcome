package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "use KoinViewModelFactory")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0015\u001a\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/StateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Lorg/koin/core/scope/a;", "scope", "Lorg/koin/androidx/viewmodel/b;", "parameters", "<init>", "(Lorg/koin/core/scope/a;Lorg/koin/androidx/viewmodel/b;)V", "Landroidx/lifecycle/SavedStateHandle;", "handle", "Lkotlin/Function0;", "Lvu/a;", "Lorg/koin/core/parameter/ParametersDefinition;", "addHandle", "(Landroidx/lifecycle/SavedStateHandle;)Lkotlin/jvm/functions/Function0;", "", STGroup.DICT_KEY, "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/a;", "getScope", "()Lorg/koin/core/scope/a;", "Lorg/koin/androidx/viewmodel/b;", "getParameters", "()Lorg/koin/androidx/viewmodel/b;", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StateViewModelFactory<T extends ViewModel> extends AbstractSavedStateViewModelFactory {
    private final org.koin.androidx.viewmodel.b parameters;
    private final org.koin.core.scope.a scope;

    /* JADX INFO: renamed from: androidx.lifecycle.StateViewModelFactory$addHandle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lvu/a;", "invoke", "()Lvu/a;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends Lambda implements Function0<vu.a> {
        final /* synthetic */ vu.a $definitionParameters;
        final /* synthetic */ SavedStateHandle $handle;

        public AnonymousClass1(vu.a r5, SavedStateHandle r10) {
            this.$definitionParameters = r5;
            this.$handle = r10;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ vu.a invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final vu.a invoke2() {
            vu.a r5 = this.$definitionParameters;
            SavedStateHandle r10 = this.$handle;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r10, "value");
            r5.f22651a.add(r10);
            return r5;
        }
    }

    public StateViewModelFactory(org.koin.core.scope.a r5, org.koin.androidx.viewmodel.b r10) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r10, "parameters");
        throw null;
    }

    private final Function0<vu.a> addHandle(SavedStateHandle r5) {
        throw null;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(String r5, Class<T> r10, SavedStateHandle r11) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "handle");
        addHandle(r11);
        throw null;
    }

    public final org.koin.androidx.viewmodel.b getParameters() {
        return null;
    }

    public final org.koin.core.scope.a getScope() {
        return this.scope;
    }
}
