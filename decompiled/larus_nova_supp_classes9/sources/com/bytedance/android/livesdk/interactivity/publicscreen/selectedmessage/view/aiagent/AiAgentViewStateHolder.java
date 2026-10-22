package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AiAgentViewStateHolder {
    public AiAgentViewState a;
    public PublishSubject<Unit> b;
    public Disposable c;
    public l d;
    public final k e;

    public static final class a<T> implements Predicate {
        public final /* synthetic */ AiAgentViewStateHolder a;

        public a(AiAgentViewStateHolder r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            Intrinsics.checkNotNullParameter((Unit) r2, "it");
            AiAgentViewState r3 = this.a.a;
            if (r3 != AiAgentViewState.AI_AGENT_MESSAGE) goto L5;
        L8:
            return true;
        L5:
            if (r3 == AiAgentViewState.AI_AGENT_EMPTY) goto L8;
            return false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AiAgentViewStateHolder a;

        public b(AiAgentViewStateHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            if (this.a.e.a() == false) goto L6;
            this.a.a(AiAgentViewState.AI_AGENT_FOLD, AiAgentViewChangeReason.TIMEOUT);
            int r5 = ga2.d.a;
            ga2.d.a("time out, current: " + System.currentTimeMillis());
            return;
        }
    }

    public final void c() {
        PublishSubject<Unit> r0 = this.b;
        if (r0 == null) goto L5;
        r0.onNext(Unit.INSTANCE);
    L5:
        int r1 = ga2.d.a;
        ga2.d.a("resetAutoZoomOutTimer, current: " + System.currentTimeMillis());
    }

    public final void d() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
        PublishSubject<Unit> r1 = this.b;
        if (r1 != null) goto L8;
        r1 = PublishSubject.create();
        this.b = r1;
    L8:
        this.c = r1.debounce(((Number) SelectedMsgABHelper.c.getValue()).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).filter(new a(this)).subscribe(new b(this));
        c();
    }

    public AiAgentViewStateHolder(k r2) {
        Intrinsics.checkNotNullParameter(r2, "envProvider");
        this.e = r2;
        this.a = AiAgentViewState.DEFAULT;
    }

    public final void b(AiAgentViewState... r14) {
        if (ArraysKt.contains(r14, this.a) == false) goto L5;
        return;
    L5:
        if (v.a() == true) goto L8;
        int r0 = ga2.d.a;
        String r15 = "exceptStates: " + ArraysKt.joinToString$default(r14, null, null, null, 0, null, AiAgentViewStateHolder$exceptState$2.INSTANCE, 31, null) + ", current state: " + this.a.desc();
        Intrinsics.checkNotNullParameter(r15, "msg");
        ALogger.e("PSSelectedAiAgent", r15);
        return;
    L8:
        throw new RuntimeException("exceptStates: " + ArraysKt.joinToString$default(r14, null, null, null, 0, null, AiAgentViewStateHolder$exceptState$1.INSTANCE, 31, null) + ", current state: " + this.a.desc());
    }

    public final boolean a(AiAgentViewState r3, AiAgentViewChangeReason r4) {
        AiAgentViewState r0 = this.a;
        if (r0 == r3) goto L9;
        this.a = r3;
        l r1 = this.d;
        if (r1 == null) goto L11;
        r1.a(r0, r3, r4);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
