package zl0;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Single;
import io.reactivex.subjects.SingleSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends c {
    public final ConditionId f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ SingleSubject a;

        public a(SingleSubject r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            SingleSubject r0 = this.a;
            r0.onSuccess((Boolean) r2);
        }
    }

    @Override // zl0.c
    public final Single<Boolean> a() {
        SingleSubject r0 = SingleSubject.create();
        v61.a r1 = this.e;
        if (r1 == null) goto L9;
        v61.d r2 = r1.B();
        if (r2 == null) goto L9;
        NextLiveData r3 = r2.b;
        if (r3 == null) goto L9;
        r3.observeForever(new a(r0), true);
    L9:
        return r0;
    }

    @Override // zl0.c
    public final Object getIdentity() {
        return this.f;
    }

    public final boolean b(v61.a r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        v61.a r4 = this.e;
        if (r4 == null) goto L19;
        v61.d r5 = r4.B();
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.a != true) goto L22;
        v61.a r6 = this.e;
        if (r6 == null) goto L15;
        v61.d r7 = r6.B();
        if (r7 == null) goto L15;
        NextLiveData r8 = r7.b;
        if (r8 == null) goto L15;
        Boolean r9 = (Boolean) r8.getValue();
    L17:
        if ((!Intrinsics.areEqual(r9, Boolean.TRUE)) == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        r9 = null;
        goto L17
    L22:
        return false;
    L19:
        return false;
    }

    public i(DataCenter r1, Long r2, Integer r3, v61.a r4) {
        super(r1, r2, r3, r4);
        this.f = ConditionId.PRELOADING_RESULT_LIMIT;
    }
}
