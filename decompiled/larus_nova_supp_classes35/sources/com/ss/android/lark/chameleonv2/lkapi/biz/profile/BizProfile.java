package com.ss.android.lark.chameleonv2.lkapi.biz.profile;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BizProfile extends z0b.a {
    public final Lazy a;

    public static final class a {
    }

    public final class b extends AbsChameleonHandler<IBizProfile$OpenProfileRequest> {
        public final String a;
        public final /* synthetic */ BizProfile b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public b(BizProfile r1) {
            this.b = r1;
            this.a = LKAPIModules.Biz.Profile.OpenProfile.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IBizProfile$OpenProfileRequest r3, Callback r4) {
            IBizProfile$OpenProfileRequest r5 = r3;
            Intrinsics.checkNotNullParameter(r5, "req");
            Intrinsics.checkNotNullParameter(r4, "callback");
            RxScheduledExecutor.execInIO(new com.ss.android.lark.chameleonv2.lkapi.biz.profile.a(this.b, r5), new com.ss.android.lark.chameleonv2.lkapi.biz.profile.b(r4, this, r5));
            r4.success(null);
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> b() {
        return CollectionsKt.arrayListOf(new b[]{new b(this)});
    }

    public BizProfile() {
        this.a = LazyKt.lazy(new BizProfile$chatterService$2(this));
    }
}
