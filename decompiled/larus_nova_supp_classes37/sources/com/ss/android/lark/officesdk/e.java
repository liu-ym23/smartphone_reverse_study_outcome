package com.ss.android.lark.officesdk;

import com.bytedance.ee.android.file.picker.lib.v2.ui.ConfirmActivity;
import com.bytedance.ee.android.file.picker.lib.v2.ui.FilePickerMainActivity;
import com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmViewModel_HiltModules_KeyModule_ProvideFactory;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel_HiltModules_KeyModule_ProvideFactory;
import com.ss.android.lark.bottomsheet.BottomSheetContainerActivity;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.MapBuilder;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e extends a0 {
    public final o a;
    public final g b;
    public final e c;

    @Override // com.ss.android.lark.profile_office.userprofile.c
    public final void b() {
    }

    public final void c() {
    }

    public final Set<String> getViewModelKeys() {
        return SetBuilder.newSetBuilder(3).add(ConfirmViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(FilePickerViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    public final sm4.b f() {
        return new sm4.b(this.a.k6, MapBuilder.newMapBuilder(7).put("video", this.a.l6).put("excel", this.a.m6).put("word", this.a.n6).put("ppt", this.a.o6).put("pdf", this.a.p6).put("received", this.a.q6).put("other", this.a.r6).build());
    }

    public final FragmentComponentBuilder fragmentComponentBuilder() {
        return new i(this.a, this.b, this.c);
    }

    public final DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
        return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.a.a), getViewModelKeys(), Collections.emptySet(), new r(this.a, this.b));
    }

    public final ViewModelComponentBuilder getViewModelComponentBuilder() {
        return new r(this.a, this.b);
    }

    public final ViewComponentBuilder viewComponentBuilder() {
        return new p(this.a, this.b, this.c);
    }

    public final Set<String> getViewModelAssistedKeys() {
        return Collections.emptySet();
    }

    public final void a(FilePickerMainActivity r2) {
        r2.f = f();
        r2.g = new fjb.a();
    }

    public final void d(ConfirmActivity r2) {
        r2.f = f();
    }

    public final void e(BottomSheetContainerActivity r2) {
        r2.m = (List) this.a.s6.get();
    }

    public e(o r1, g r2) {
        this.c = this;
        this.a = r1;
        this.b = r2;
    }
}
