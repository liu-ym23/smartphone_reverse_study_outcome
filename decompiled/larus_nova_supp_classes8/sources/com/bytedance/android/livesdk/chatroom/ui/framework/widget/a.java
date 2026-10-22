package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.platform.depend.Properties;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ AnchorEffectFilterWidget a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.a$a, reason: collision with other inner class name */
    public static final class RunnableC0018a implements Runnable {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.a$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0019a implements View.OnClickListener {
            public final /* synthetic */ RunnableC0018a a;
            public final /* synthetic */ View b;
            public final /* synthetic */ View c;

            public ViewOnClickListenerC0019a(RunnableC0018a r1, View r2, View r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                View r3 = this.a.a.a.Fj();
                if (r3 == null) goto L5;
                r3.setVisibility(8);
            L5:
                View r4 = this.b;
                if (r4 == null) goto L8;
                r4.setVisibility(8);
            L8:
                View r5 = this.c;
                if (r5 == null) goto L11;
                r5.setVisibility(8);
            L11:
                View r6 = this.a.a.a.Fj();
                if (r6 == null) goto L15;
                r6.setClickable(false);
                return;
            }
        }

        public RunnableC0018a(a r1) {
            this.a = r1;
        }

        public final void a() {
            com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.a.a.a;
            TextView r1 = null;
            if (r0 == null) goto L5;
            View r2 = r0.b8();
        L6:
            com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = this.a.a.a;
            if (r3 == null) goto L9;
            View r4 = r3.g8();
        L10:
            TTLiveSDKContext.getHostService().d().pref().setBoolean(Properties.HAS_SHOW_FILTER_GUIDE, true);
            View r5 = this.a.a.Fj();
            if (r5 == null) goto L13;
            r5.setVisibility(0);
        L13:
            if (r2 == null) goto L15;
            r2.setVisibility(0);
        L15:
            if (r4 == null) goto L17;
            r4.setVisibility(0);
        L17:
            com.bytedance.android.livesdk.chatroom.ui.framework.d r6 = this.a.a.a;
            if (r6 == null) goto L20;
            r1 = r6.gp();
        L20:
            if (r1 == null) goto L22;
            r1.setText(s1.B(2131922543));
        L22:
            View r7 = this.a.a.Fj();
            if (r7 == null) goto L25;
            r7.setClickable(true);
        L25:
            View r8 = this.a.a.Fj();
            if (r8 == null) goto L29;
            r8.setOnClickListener(new ViewOnClickListenerC0019a(this, r2, r4));
            return;
        L29:
            return;
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(AnchorEffectFilterWidget r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a.b;
        if (r0 == null) goto L5;
        LiveMode r1 = r0.getLiveMode();
    L6:
        if (r1 == null) goto L14;
        boolean r2 = true;
        if (r1.isUsingCamera() != true) goto L14;
        if (com.bytedance.android.livesdk.utils.p.a() == true) goto L14;
        if (TTLiveSDKContext.getHostService().d().pref().getBoolean(Properties.HAS_SHOW_FILTER_GUIDE) == true) goto L14;
    L16:
        if (AnchorEffectFilterWidget.wq(this.a) == null) goto L23;
        if (r2 == false) goto L25;
        FragmentActivity r3 = AnchorEffectFilterWidget.wq(this.a);
        if (r3 == null) goto L24;
        r3.runOnUiThread(new RunnableC0018a(this));
        return;
    L24:
        return;
    L25:
        return;
    L23:
        return;
    L14:
        r2 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
