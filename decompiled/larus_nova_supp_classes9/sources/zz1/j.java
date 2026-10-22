package zz1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeNewReceiverPanel;
import com.bytedance.android.livesdk.gift.platform.core.utils.b0;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oc6.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements r, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f a;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k b;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a c;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            lc6.h r8 = (lc6.h) r7;
            Intrinsics.checkNotNullParameter(r8, "resp");
            if (w.a() == true) goto L6;
            return new lc6.h();
        L6:
            if (this.a.c.j() == false) goto L23;
            lc6.h r9 = new lc6.h();
            List r0 = CollectionsKt.reversed(this.a.c.i());
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L17;
            IBaseUser r3 = (IBaseUser) r2.next();
            lc6.c r4 = new lc6.c();
            r4.c(r3.getIdString());
            Intrinsics.checkNotNullParameter(r3, "$this$realNickNameExt");
            r4.d(r3.getRealNickName());
            py.k r5 = r3.getAvatarThumbKt();
            if (r5 == null) goto L15;
            List r6 = r5.getUrls();
            if (r6 == null) goto L15;
            String r10 = (String) CollectionsKt.getOrNull(r6, 0);
        L16:
            r4.a(r10);
            r4.b(null);
            r1.add(r4);
        L15:
            r10 = null;
            goto L16
        L17:
            r9.b(r1);
            return r9;
        L23:
            return r8;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            Integer r3 = (Integer) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            lc6.o r0 = new lc6.o();
            r0.a(r3.intValue());
            return r0;
        }
    }

    public final void onStop() {
    }

    public final Observable<lc6.e> observeCurrentReceiver() {
        return this.a.f;
    }

    public final Observable<lc6.h> observeEntranceReceiverList() {
        return this.a.e.map(new a(this));
    }

    public final Observable<lc6.o> observeReceiverMode() {
        return this.b.b.map(b.a);
    }

    public final void onStart() {
        this.b.a();
    }

    public final void notifyNewReceiverPanelStatus(boolean r3) {
        uz1.a r0 = b0.b();
        if (r0 == null) goto L6;
        r0.a(new ChangeNewReceiverPanel(r3));
        return;
    }

    public j(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r4) {
        Intrinsics.checkNotNullParameter(r2, "giftPanelReceiverService");
        Intrinsics.checkNotNullParameter(r3, "giftReceiverModeService");
        Intrinsics.checkNotNullParameter(r4, "giftAllMicService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
