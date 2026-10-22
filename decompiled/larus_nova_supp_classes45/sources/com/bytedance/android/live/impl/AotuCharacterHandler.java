package com.bytedance.android.live.impl;

import com.bytedance.android.live.feature.api.IFeatureService;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AotuCharacterHandler {
    public static volatile boolean a;
    public static volatile List<String> b;
    public static volatile Function1<? super String, Unit> c;
    public static volatile a d;

    public static final class a implements z90.a.b {
        public a() {
        }

        @Override // z90.a.b
        public final <T> void a(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            boolean r4 = AotuCharacterHandler.a;
            List<String> r5 = AotuCharacterHandler.b;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.contains(r2) != true) goto L9;
            AotuCharacterHandler.c.invoke(r2);
            return;
        }
    }

    public static final class b implements z90.a.c {
        public final /* synthetic */ Function2 a;

        public b(Function2 r1) {
            this.a = r1;
        }

        @Override // z90.a.c
        public final void a(List<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "name");
            this.a.invoke(r3, Boolean.TRUE);
        }
    }

    public static final class c implements z90.a.c {
        public final /* synthetic */ Function2 a;

        public c(Function2 r1) {
            this.a = r1;
        }

        @Override // z90.a.c
        public final void a(List<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "name");
            this.a.invoke(r3, Boolean.TRUE);
        }
    }

    static {
        c = AotuCharacterHandler$updateFunc$1.INSTANCE;
        d = new a();
    }

    public static void a(Function1 r2, Function2 r3) {
        Intrinsics.checkNotNullParameter(r2, "update");
        Intrinsics.checkNotNullParameter(r3, "updateList");
        c = r2;
        if (a == false) goto L5;
        return;
    L5:
        IFeatureService r4 = (IFeatureService) k.f(IFeatureService.class);
        if (r4 == null) goto L10;
        z90.a r5 = r4.getFeatureManager();
        if (r5 == null) goto L10;
        r5.e(d, b);
    L10:
        a = true;
        IFeatureService r6 = (IFeatureService) k.f(IFeatureService.class);
        if (r6 == null) goto L16;
        z90.a r7 = r6.getFeatureManager();
        if (r7 == null) goto L17;
        r7.f(new b(r3));
        return;
    L17:
        return;
    }

    public static void b(Function1 r2, Function2 r3) {
        Intrinsics.checkNotNullParameter(r2, "update");
        Intrinsics.checkNotNullParameter(r3, "updateList");
        c = r2;
        IFeatureService r4 = (IFeatureService) k.f(IFeatureService.class);
        if (r4 == null) goto L8;
        z90.a r5 = r4.getFeatureManager();
        if (r5 == null) goto L8;
        r5.e(d, b);
    L8:
        if (a == false) goto L10;
        return;
    L10:
        a = true;
        IFeatureService r6 = (IFeatureService) k.f(IFeatureService.class);
        if (r6 == null) goto L16;
        z90.a r7 = r6.getFeatureManager();
        if (r7 == null) goto L17;
        r7.f(new c(r3));
        return;
    L17:
        return;
    }
}
