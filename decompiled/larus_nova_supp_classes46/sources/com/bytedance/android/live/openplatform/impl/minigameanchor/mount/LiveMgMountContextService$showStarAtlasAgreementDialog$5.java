package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"signAgreement", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ x0 $dialog;
    final /* synthetic */ Function0 $onSuccess;
    final /* synthetic */ List $protocols;
    final /* synthetic */ LiveMgMountContextService this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$5 a;

        public a(LiveMgMountContextService$showStarAtlasAgreementDialog$5 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            this.a.$onSuccess.invoke();
            x0 r6 = this.a.$dialog;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
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
            Throwable r4 = (Throwable) r3;
            qo0.a.b("LiveMgMountContextService", "request signUserAgreement fail", r4);
            String r5 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r4);
            if (r5 != null) goto L5;
            r5 = s1.B(2131921004);
        L5:
            f2.c(r5, 0);
        }
    }

    public LiveMgMountContextService$showStarAtlasAgreementDialog$5(LiveMgMountContextService r1, List r2, Function0 r3, x0 r4) {
        this.this$0 = r1;
        this.$protocols = r2;
        this.$onSuccess = r3;
        this.$dialog = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m784invoke() {
        this.this$0.autoDispose(((MiniGameAnchorApi) ((LiveOpenPlatformMgClient) LiveOpenPlatformMgClient.d.getValue()).a(MiniGameAnchorApi.class)).signUserAgreement(LiveMgMountContextService$showStarAtlasAgreementDialog$4.INSTANCE.invoke(this.$protocols)).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), b.a));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m784invoke();
        return Unit.INSTANCE;
    }
}
