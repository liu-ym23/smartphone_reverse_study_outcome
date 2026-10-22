package com.bytedance.android.live.profit.util;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements SingleOnSubscribe {
    public final /* synthetic */ IAssetsManager a;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.util.a$a, reason: collision with other inner class name */
    public static final class C0052a implements Action {
        public final /* synthetic */ a a;
        public final /* synthetic */ b b;

        public C0052a(a r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            this.a.a.l0(this.b);
        }
    }

    public static final class b implements IAssetsManager.b {
        public final /* synthetic */ a a;
        public final /* synthetic */ SingleEmitter b;

        public final void a() {
            this.a.a.l0(this);
            this.b.onError(new Error("failed to sync assets"));
        }

        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r2) {
            Intrinsics.checkNotNullParameter(r2, "assetsModels");
            this.a.a.l0(this);
            this.b.onSuccess(Unit.INSTANCE);
        }

        public b(a r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(IAssetsManager r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        b r0 = new b(this, r3);
        r3.setDisposable(Disposables.fromAction(new C0052a(this, r0)));
        this.a.T(r0);
    }
}
