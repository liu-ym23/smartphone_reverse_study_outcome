package androidx.lifecycle;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a6\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00022\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\u0000\u001aI\u0010\t\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0000¢\u0006\u0002\u0010\u000f\"\u0018\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"ANDROID_VIEWMODEL_SIGNATURE", "", "Ljava/lang/Class;", "VIEWMODEL_SIGNATURE", "findMatchingConstructor", "Ljava/lang/reflect/Constructor;", ExifInterface.GPS_DIRECTION_TRUE, "modelClass", "signature", "newInstance", "Landroidx/lifecycle/ViewModel;", "constructor", TrackerImpl.PARAMS, "", "", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> r7, List<? extends Class<?>> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "modelClass");
        Intrinsics.checkNotNullParameter(r9, "signature");
        Object[] r0 = r7.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r0, "modelClass.constructors");
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L16;
        Constructor<T> r4 = (Constructor<T>) r0[r3];
        Class<?>[] r5 = r4.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r5, "constructor.parameterTypes");
        List r6 = ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(r9, r6) == true) goto L6;
        if (r9.size() != r6.size()) goto L15;
        if (r6.containsAll((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")) == false) goto L15;
        throw new UnsupportedOperationException("Class " + r7.getSimpleName() + " must have parameters in the proper order: " + r9);
    L15:
        r3 = r3 + 1;
        goto L3
    L6:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
        return r4;
    L16:
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> r3, Constructor<T> r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        Intrinsics.checkNotNullParameter(r4, "constructor");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        return (T) ZeusTransformUtils.preCheckCast(r4.newInstance(Arrays.copyOf(r5, r5.length)), ViewModel.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to access " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        e = move-exception;
        throw new RuntimeException("A " + r3 + " cannot be instantiated.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        throw new RuntimeException("An exception happened in constructor of " + r3, e.getCause());
    }
}
