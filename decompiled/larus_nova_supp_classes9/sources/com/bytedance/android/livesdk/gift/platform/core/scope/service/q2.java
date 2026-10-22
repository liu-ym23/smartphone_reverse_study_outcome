package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.message.model.q6;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface q2 extends com.bytedance.android.scope.o {

    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;

        public a(String r3, String r4, int r5, boolean r6, int r7, String r8, int r9) {
            if ((r9 & 4) == 0) goto L6;
            r5 = 0;
        L6:
            if ((r9 & 8) == 0) goto L9;
            r6 = false;
        L9:
            if ((r9 & 16) == 0) goto L12;
            r7 = 0;
        L12:
            if ((r9 & 32) == 0) goto L14;
            r8 = BuildConfig.FLAVOR;
        L14:
            Intrinsics.checkNotNullParameter(r8, "eventSessionId");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    PublishSubject<a> K5();

    PublishSubject<String> X4();

    q6 Y9();

    PublishSubject<a> bh();

    com.bytedance.android.livesdk.gift.model.x1 getGiftPanelTopBar();

    String getScene();

    PublishSubject rj();

    PublishSubject<Unit> w5();
}
