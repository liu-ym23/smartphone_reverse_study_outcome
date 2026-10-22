package com.larksuite.arch.jack;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "VM", "Lcom/larksuite/arch/jack/JackViewModel;", "invoke", "()Lcom/larksuite/arch/jack/JackViewModel;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExtensionsKt$activityViewModel$2 extends Lambda implements Function0<JackViewModel<Object>> {
    final /* synthetic */ Function0<String> $keyFactory;
    final /* synthetic */ Fragment $this_activityViewModel;
    final /* synthetic */ KClass<JackViewModel<Object>> $viewModelClass;

    public ExtensionsKt$activityViewModel$2(Fragment r1, Function0<String> r2, KClass<JackViewModel<Object>> r3) {
        this.$this_activityViewModel = r1;
        this.$keyFactory = r2;
        this.$viewModelClass = r3;
        super(0);
    }

    public final JackViewModel<Object> invoke() {
        return (JackViewModel) ViewModelProviders.of(this.$this_activityViewModel.requireActivity(), ExtensionsKt.a).get((String) this.$keyFactory.invoke(), JvmClassMappingKt.getJavaClass(this.$viewModelClass));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m207invoke() {
        return invoke();
    }
}
