package com.ss.android.lark.officesdk;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.android.file.picker.lib.v2.data.FilePickerRepository;
import com.bytedance.ee.android.file.picker.lib.v2.data.source.doc.DocDataSource;
import com.bytedance.ee.android.file.picker.lib.v2.data.source.video.VideoDataSource;
import com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmViewModel;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel_Factory;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s extends g1 {
    public final SavedStateHandle a;
    public final o b;
    public a c;
    public a d;
    public a e;
    public a f;
    public a g;
    public a h;

    public static final class a<T> implements Provider<T> {
        public final o a;
        public final s b;
        public final int c;

        public final T get() {
            int r0 = this.c;
            if (r0 == 0) goto L26;
            if (r0 != 1) goto L7;
            s r1 = this.b;
            r1.getClass();
            sm4.b r3 = new sm4.b(r1.b.k6, MapBuilder.newMapBuilder(7).put("video", r1.b.l6).put("excel", r1.b.m6).put("word", r1.b.n6).put("ppt", r1.b.o6).put("pdf", r1.b.p6).put("received", r1.b.q6).put("other", r1.b.r6).build());
            s r2 = this.b;
            r2.getClass();
            return (T) new FilePickerViewModel(r3, new FilePickerRepository(new um4.b(MapBuilder.newMapBuilder(3).put("picker_doc", r2.d).put("picker_video", r2.e).put("picker_received", r2.f).build())), ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.a.a), this.b.a);
        L7:
            if (r0 == 2) goto L22;
            if (r0 == 3) goto L20;
            if (r0 == 4) goto L18;
            if (r0 != 5) goto L16;
            s r4 = this.b;
            r4.getClass();
            OfficeProfileModel r5 = OfficeProfileModel_Factory.newInstance();
            r5.a = (com.ss.android.lark.profile.core.di.a) r4.b.E4.get();
            return (T) new OfficeProfileViewModel(r5, (x1c.d) this.a.F4.get(), (IOfficeSDKTokenProvider) this.a.d4.get());
        L16:
            throw new AssertionError(this.c);
        L18:
            return (T) new com.bytedance.ee.android.file.picker.lib.v2.data.source.received.a(ApplicationContextModule_ProvideContextFactory.provideContext(this.a.a));
        L20:
            return (T) new VideoDataSource(ApplicationContextModule_ProvideContextFactory.provideContext(this.a.a));
        L22:
            return (T) new DocDataSource(ApplicationContextModule_ProvideContextFactory.provideContext(this.a.a));
        L26:
            return (T) new ConfirmViewModel(this.b.a);
        }

        public a(o r1, s r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
        return MapBuilder.newMapBuilder(3).put("com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmViewModel", this.c).put("com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel", this.g).put("com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel", this.h).build();
    }

    public final Map<String, Object> getHiltViewModelAssistedMap() {
        return Collections.emptyMap();
    }

    public s(o r1, g r2, SavedStateHandle r3) {
        this.b = r1;
        this.a = r3;
        this.c = new a(r1, this, 0);
        this.d = new a(r1, this, 2);
        this.e = new a(r1, this, 3);
        this.f = new a(r1, this, 4);
        this.g = new a(r1, this, 1);
        this.h = new a(r1, this, 5);
    }
}
