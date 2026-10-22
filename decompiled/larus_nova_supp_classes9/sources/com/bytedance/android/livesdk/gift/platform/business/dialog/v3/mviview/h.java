package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Runnable {
    public final /* synthetic */ a5 a;
    public final /* synthetic */ GiftMVIDetailView b;

    public static final class a implements yr2.a {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void a(py.k r2) {
            Intrinsics.checkNotNullParameter(r2, "image");
            Intrinsics.checkNotNullParameter(r2, "image");
        }

        public final void b(Spannable r7, yr2.a.a r8) {
            Intrinsics.checkNotNullParameter(r7, "spannable");
            Intrinsics.checkNotNullParameter(r8, "info");
            PrivilegeEntranceInfo r9 = this.a.b.A;
            if (r9 != null) goto L5;
        L31:
            GiftMVIDetailView.v(this.a.b, r7);
            return;
        L5:
            if (r9.canShowBgPop() != true) goto L31;
            GiftMVIDetailView r10 = this.a.b;
            Disposable r0 = r10.y;
            if (r0 != null) goto L9;
        L16:
            py.k r2 = null;
            View r1 = LayoutInflater.from(r10.getContext()).inflate(2131566127, null);
            if (com.bytedance.android.live.revenue.common.e0.a() == false) goto L21;
            ViewGroup.LayoutParams r3 = r1.getLayoutParams();
            if (r3 == null) goto L33;
            r3.height = (int) fm3.e.a(r10.getContext(), 43.0f);
            r1.setLayoutParams(r3);
            goto L21
        L33:
            return;
        L21:
            View r4 = r1.findViewById(2131368901);
            if (r4 == null) goto L27;
            r4.setOnClickListener(new f(r10, r7));
            int r5 = r10.x().getMeasuredWidth();
            TextView r6 = r10.n;
            if (r6 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mDetailBtn");
        L26:
            ViewUtilsKt.d(r4, r5 + r6.getPaddingLeft());
        L27:
            TextView r11 = (TextView) r1.findViewById(2131368902);
            r11.setText(r7);
            int r13 = a3.d;
            PrivilegeEntranceInfo r14 = r10.A;
            if (r14 == null) goto L30;
            r2 = r14.getBubbleBackgroundImg();
        L30:
            a3.a.a(r11, r2, new g(r10, r1, r7), 0.0f);
            return;
        L9:
            if (r0.isDisposed() == true) goto L16;
            Disposable r15 = r10.y;
            if (r15 == null) goto L13;
            r15.dispose();
        L13:
            yo2.e r16 = r10.u;
            if (r16 == null) goto L16;
            r16.d();
            goto L16
        }
    }

    public h(a5 r1, GiftMVIDetailView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        vh6.c.b(ur2.a.class).a4(this.a, RevRenderConfig.SyncDecodeContext, new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
