package zl0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.SingleSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends c {
    public final ConditionId f;
    public Disposable g;
    public final Boolean h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SingleSubject a;

        public a(SingleSubject r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = ((z61.c) r3).a;
            if (r4 == null) goto L14;
            boolean r1 = true;
            if (r4.intValue() == 1) goto L8;
            r1 = false;
        L8:
            if (r1 == true) goto L11;
            r4 = null;
        L11:
            if (r4 == null) goto L15;
            r4.intValue();
            this.a.onSuccess(Boolean.TRUE);
            return;
        L15:
            return;
        }
    }

    @Override // zl0.c
    public final Single<Boolean> a() {
        SingleSubject r0 = SingleSubject.create();
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L17;
        o r2 = IRoomContextService.a.a(r1, this.b, 0, 2);
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.i r3 = r2.getCompositeDisposable();
        if (r3 == null) goto L17;
        CompositeDisposable r4 = (CompositeDisposable) r3.getValue();
        if (r4 == null) goto L17;
        Observable r5 = xs2.b.a().b(z61.c.class);
        if (r5 == null) goto L15;
        Disposable r6 = r5.subscribe(new a(r0));
        if (r6 == null) goto L15;
        RxUtilKt.c(r6, r4);
    L16:
        this.g = r6;
    L15:
        r6 = null;
    L17:
        return r0;
    }

    @Override // zl0.c
    public final Object getIdentity() {
        return this.f;
    }

    public final boolean b(v61.a r6) {
        Intrinsics.checkNotNullParameter(r6, "msgWindow");
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        Boolean r0 = null;
        if (r7 == null) goto L5;
        o r8 = IRoomContextService.a.a(r7, this.b, 0, 2);
    L6:
        if (r8 == null) goto L9;
        r0 = r8.isPortraitInteraction();
    L9:
        if (r8 == null) goto L15;
        com.bytedance.live.datacontext.m r9 = r8.v2();
        if (r9 == null) goto L15;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
    L17:
        if (e5.h(r0, r11) == true) goto L19;
    L21:
        Disposable r12 = this.g;
        if (r12 == null) goto L26;
        r12.dispose();
        return false;
    L26:
        return false;
    L19:
        if (Intrinsics.areEqual(this.h, Boolean.FALSE) == false) goto L21;
        return true;
    L15:
        r11 = 1;
        goto L17
    L5:
        r8 = null;
        goto L6
    }

    public m(DataCenter r1, Long r2, Integer r3, v61.a r4, Boolean r5) {
        super(r1, r2, r3, r4);
        this.h = r5;
        this.f = ConditionId.SCREEN_ORIENTATION_LIMIT;
    }
}
