package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.SingleSubject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelOnlyBlockOnceStrategy implements e {
    public Disposable a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a a;

        public a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.a();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            ALogger.i("MorePanelDynamic", "single error: " + ((Throwable) r3));
        }
    }

    public MorePanelOnlyBlockOnceStrategy() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.e
    public final void a(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "dialogInterface");
        Intrinsics.checkNotNullParameter(r6, "requestInterface");
        ALogger.i("MorePanelDynamic", "MorePanelOnlyBlockOnceStrategy");
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        final SingleSubject r1 = SingleSubject.create();
        Disposable r2 = r1.subscribe(new a(r5), b.a);
        if (r2 == null) goto L8;
        r6.bindDisposable(r2);
        Unit r3 = Unit.INSTANCE;
    L9:
        this.a = r2;
        r6.requestData(2, new MorePanelOnlyBlockOnceStrategy$openDialog$4(r5, r1), new MorePanelOnlyBlockOnceStrategy$openDialog$5(r5, r1));
        if (r6.hasDynamicData() == false) goto L13;
        ALogger.i("MorePanelDynamic", "open direct");
        r1.onSuccess(Boolean.FALSE);
        return;
    L13:
        return;
    L8:
        r2 = null;
        goto L9
    }
}
