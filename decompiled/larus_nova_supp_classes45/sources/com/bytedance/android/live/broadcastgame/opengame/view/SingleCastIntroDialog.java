package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/SingleCastIntroDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleCastIntroDialog extends CommonBottomDialog {
    public final String a;
    public final Function0<Unit> b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.view.SingleCastIntroDialog$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m372invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m372invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SingleCastIntroDialog a;

        public a(SingleCastIntroDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.b.invoke();
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131565681;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        String r4 = i2.a;
        i2.e((HSImageView) findViewById(2131370227), "/broadcastgame/ttlive_single_game_cast_intro1.png");
        i2.e((HSImageView) findViewById(2131370228), "/broadcastgame/ttlive_single_game_cast_intro2.png");
        ((TextView) findViewById(2131390381)).setText(this.a);
        ((TextView) findViewById(2131390381)).setOnClickListener(new a(this));
    }

    public SingleCastIntroDialog(Context r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "buttonText");
        Intrinsics.checkNotNullParameter(r4, "onConfirm");
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}
