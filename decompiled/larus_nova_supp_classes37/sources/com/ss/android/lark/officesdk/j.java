package com.ss.android.lark.officesdk;

import com.bytedance.ee.android.file.picker.lib.v2.ui.FilePickerMainFragment;
import com.ss.android.lark.bottomsheet.BottomSheetContainerFragment;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j extends i0 {
    public final o a;
    public final g b;
    public final e c;
    public final j d;

    @Override // com.ss.android.lark.profile_office.userprofile.e
    public final void a() {
    }

    public final DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
        return this.c.getHiltInternalFactoryFactory();
    }

    public final ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
        return new t(this.a, this.b, this.c, this.d);
    }

    public final void b(FilePickerMainFragment r2) {
        r2.m = this.c.f();
        r2.n = new fjb.a();
    }

    public final void c(BottomSheetContainerFragment r2) {
        r2.t = (List) this.a.s6.get();
    }

    public j(o r1, g r2, e r3) {
        this.d = this;
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
