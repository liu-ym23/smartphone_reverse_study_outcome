package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactoryKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = null;
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = null;

    static {
        ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt.listOf(new Class[]{Application.class, SavedStateHandle.class});
        VIEWMODEL_SIGNATURE = CollectionsKt.listOf(SavedStateHandle.class);
    }

    public static final /* synthetic */ List access$getANDROID_VIEWMODEL_SIGNATURE$p() {
        return ANDROID_VIEWMODEL_SIGNATURE;
    }

    public static final /* synthetic */ List access$getVIEWMODEL_SIGNATURE$p() {
        return VIEWMODEL_SIGNATURE;
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> r10, List<? extends Class<?>> r11) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "signature");
        Object[] r12 = r10.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r12, "modelClass.constructors");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L16;
        Constructor<T> r15 = (Constructor<T>) r12[r14];
        Class<?>[] r16 = r15.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r16, "constructor.parameterTypes");
        List r17 = ArraysKt.toList(r16);
        if (Intrinsics.areEqual(r11, r17) == true) goto L6;
        if (r11.size() != r17.size()) goto L15;
        if (r17.containsAll(r11) == false) goto L15;
        throw new UnsupportedOperationException("Class " + r10.getSimpleName() + " must have parameters in the proper order: " + r11);
    L15:
        r14 = r14 + 1;
        goto L3
    L6:
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
        return r15;
    L16:
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> r10, Constructor<T> r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "params");
        return r11.newInstance(Arrays.copyOf(r12, r12.length));
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to access " + r10, e);
    L8:
        e = move-exception;
        throw new RuntimeException("A " + r10 + " cannot be instantiated.", e);
    L5:
        e = move-exception;
        throw new RuntimeException("An exception happened in constructor of " + r10, e.getCause());
    }
}
