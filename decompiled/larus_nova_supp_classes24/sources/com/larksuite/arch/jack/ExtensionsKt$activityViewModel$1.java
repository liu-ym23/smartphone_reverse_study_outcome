package com.larksuite.arch.jack;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExtensionsKt$activityViewModel$1 extends Lambda implements Function0<String> {
    final /* synthetic */ KClass $viewModelClass;

    public ExtensionsKt$activityViewModel$1(KClass r1) {
        this.$viewModelClass = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m206invoke() {
        return JvmClassMappingKt.getJavaClass(this.$viewModelClass).getName();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m206invoke();
    }
}
