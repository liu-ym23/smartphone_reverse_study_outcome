package com.ss.android.lark.officesdk;

import com.bytedance.ee.android.file.picker.lib.v2.ui.view.FileInfoView;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q extends e1 {
    public final o a;
    public a b;
    public a c;

    public static final class a<T> implements Provider<T> {
        public final o a;
        public final int b;

        public final T get() {
            int r0 = this.b;
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L9;
            return (T) new wm4.a(ApplicationContextModule_ProvideContextFactory.provideContext(this.a.a));
        L9:
            throw new AssertionError(this.b);
        L11:
            return (T) new wm4.d();
        }

        public a(o r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void a(FileInfoView r6) {
        r6.d = new vm4.b(this.a.t6, MapBuilder.newMapBuilder(3).put("video_thumb", this.b).put("apk_icon", this.c).put("extension", this.a.t6).build());
    }

    public q(o r1, g r2, e r3) {
        this.a = r1;
        this.b = new a(r1, 0);
        this.c = new a(r1, 1);
    }
}
