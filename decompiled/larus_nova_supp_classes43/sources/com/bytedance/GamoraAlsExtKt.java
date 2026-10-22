package com.bytedance;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.objectcontainer.InjectAware;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0086\b\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0001\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\b*\u00020\u0002H\u0087\b\u001a*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\b*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0001\u001a#\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003\"\f\b\u0000\u0010\u0001\u0018\u0001*\u0004\u0018\u00010\b*\u00020\u0002H\u0087\b\u001a.\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\b*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0001\u001a.\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\b2\u000e\b\u0004\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "Lcom/bytedance/objectcontainer/InjectAware;", "Lkotlin/Lazy;", "viewModel", "Ljava/lang/Class;", "clazz", "viewModelActual", "Lcom/bytedance/als/b;", "api", "apiActual", "optApi", "optApiActual", "Lkotlin/Function0;", "Landroidx/fragment/app/FragmentActivity;", "block", "lib-runtime_release"}, k = 2, mv = {1, 4, 1})
public final class GamoraAlsExtKt {
    @Deprecated(message = "use by inject() instead", replaceWith = @ReplaceWith(expression = "by inject()", imports = {}))
    public static final /* synthetic */ <T extends com.bytedance.als.b> Lazy<T> api(final Function0<? extends FragmentActivity> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(r0, new AnonymousClass1(r10));
    }

    @Deprecated(message = "use by injectOrNull() instead", replaceWith = @ReplaceWith(expression = "by injectOrNull()", imports = {}))
    public static final /* synthetic */ <T extends com.bytedance.als.b> Lazy<T> optApi(InjectAware r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$optApi");
        Intrinsics.reifiedOperationMarker(4, "T");
        return optApiActual(r10, com.bytedance.als.b.class);
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> viewModel(InjectAware r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$viewModel");
        Intrinsics.reifiedOperationMarker(4, "T");
        return viewModelActual(r10, ViewModel.class);
    }

    @Deprecated(message = "use by inject() instead", replaceWith = @ReplaceWith(expression = "by inject()", imports = {}))
    public static final /* synthetic */ <T extends com.bytedance.als.b> Lazy<T> api(InjectAware r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$api");
        Intrinsics.reifiedOperationMarker(4, "T");
        return apiActual(r10, com.bytedance.als.b.class);
    }

    public static final <T extends com.bytedance.als.b> Lazy<T> apiActual(final InjectAware r10, final Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$apiActual");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new C02191(r10, r11));
    }

    public static final <T extends com.bytedance.als.b> Lazy<T> optApiActual(final InjectAware r10, final Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$optApiActual");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new C02201(r10, r11));
    }

    public static final <T extends ViewModel> Lazy<T> viewModelActual(final InjectAware r10, final Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$viewModelActual");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new C02211(r10, r11));
    }
}
