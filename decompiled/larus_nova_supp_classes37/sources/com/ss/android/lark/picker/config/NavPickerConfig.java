package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/config/NavPickerConfig;", "Lcom/ss/android/lark/picker/config/PickerConfig;", "dependency", "Lcom/ss/android/lark/picker/Dependency;", "permissions", "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/Dependency;Lcom/ss/android/lark/picker/config/Permissions;)V", "navigationConfig", "Lcom/ss/android/lark/picker/config/NavigationConfig;", "getNavigationConfig", "()Lcom/ss/android/lark/picker/config/NavigationConfig;", "setNavigationConfig", "(Lcom/ss/android/lark/picker/config/NavigationConfig;)V", "navigation", "", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class NavPickerConfig extends PickerConfig {
    private NavigationConfig navigationConfig;

    public final NavigationConfig getNavigationConfig() {
        return this.navigationConfig;
    }

    public final void navigation(Function1<? super NavigationConfig, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        NavigationConfig r0 = new NavigationConfig();
        this.navigationConfig = r0;
        r2.invoke(r0);
    }

    public final void setNavigationConfig(NavigationConfig r1) {
        this.navigationConfig = r1;
    }

    public NavPickerConfig(Dependency r2, Permissions r3) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "permissions");
        super(r2, r3);
    }
}
