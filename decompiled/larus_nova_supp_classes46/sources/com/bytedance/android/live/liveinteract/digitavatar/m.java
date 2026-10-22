package com.bytedance.android.live.liveinteract.digitavatar;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.PopupMenu;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public static final class a implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ FragmentManager c;
        public final /* synthetic */ DataCenter d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.digitavatar.m$a$a, reason: collision with other inner class name */
        public static final class RunnableC0027a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0027a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int r0 = v.a;     // Catch: Throwable -> L4
                a r1 = this.a;     // Catch: Throwable -> L4
                v.a(r1.c, DigitAvatarRecognitionDialog.RecognitionType.PHOTO, r1.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(boolean r1, boolean r2, FragmentManager r3, DataCenter r4, Function0 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r4) {
            if (jc1.k.n(IKtvService.class).isCurrentUserIsSinger() == false) goto L6;
            f2.b(2131918212, 0);
            return true;
        L6:
            int r5 = x.a;
            x.a(this.a, this.b, "photo");
            AndroidSchedulers.mainThread().scheduleDirect(new RunnableC0027a(this));
            Function0 r6 = this.e;
            if (r6 == null) goto L9;
            Unit r7 = (Unit) r6.invoke();
        L9:
            return true;
        }
    }

    public static final class b implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ FragmentManager c;
        public final /* synthetic */ DataCenter d;
        public final /* synthetic */ Function0 e;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int r0 = v.a;     // Catch: Throwable -> L4
                b r1 = this.a;     // Catch: Throwable -> L4
                v.a(r1.c, DigitAvatarRecognitionDialog.RecognitionType.CAMERA, r1.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(boolean r1, boolean r2, FragmentManager r3, DataCenter r4, Function0 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r4) {
            if (jc1.k.n(IKtvService.class).isCurrentUserIsSinger() == false) goto L6;
            f2.b(2131918212, 0);
            return true;
        L6:
            int r5 = x.a;
            x.a(this.a, this.b, "camera");
            AndroidSchedulers.mainThread().scheduleDirect(new a(this));
            Function0 r6 = this.e;
            if (r6 == null) goto L9;
            Unit r7 = (Unit) r6.invoke();
        L9:
            return true;
        }
    }

    public static final class c implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ FragmentManager c;
        public final /* synthetic */ DataCenter d;
        public final /* synthetic */ Function0 e;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int r0 = v.a;     // Catch: Throwable -> L4
                c r1 = this.a;     // Catch: Throwable -> L4
                v.a(r1.c, DigitAvatarRecognitionDialog.RecognitionType.DEFAULT, r1.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(boolean r1, boolean r2, FragmentManager r3, DataCenter r4, Function0 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r4) {
            if (jc1.k.n(IKtvService.class).isCurrentUserIsSinger() == false) goto L6;
            f2.b(2131918212, 0);
            return true;
        L6:
            int r5 = x.a;
            x.a(this.a, this.b, MultiLinkOpenSource.DEFAULT);
            AndroidSchedulers.mainThread().scheduleDirect(new a(this));
            Function0 r6 = this.e;
            if (r6 == null) goto L9;
            Unit r7 = (Unit) r6.invoke();
        L9:
            return true;
        }
    }

    public static final class d implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ Context a;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public d(Context r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r6) {
            Context r7 = this.a;
            x0.d r0 = new x0.d();
            r0.b = r7;
            r0.a = 0;
            r0.a = 4;
            r0.d = r0.b.getText(2131916217);
            a r1 = a.a;
            CharSequence r2 = r0.b.getText(2131914411);
            x0.c[] r3 = r0.g;
            x0.c r4 = r3[0];
            if (r4 != null) goto L5;
            r4 = new x0.c();
            r3[0] = r4;
        L5:
            r4.a = r2;
            r4.b = r1;
            r0.k = false;
            r0.l = false;
            x0.b.g(new x0(r0.b, r0));
            return false;
        }
    }

    public static final class e implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        public e(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r3) {
            int r4 = x.a;
            x.a(this.a, this.b, "cancel");
            return true;
        }
    }

    public m() {
    }

    static {
    }

    public static void a(Context r15, FragmentManager r16, DataCenter r17, boolean r18, Function0 r19) {
        if (r15 == null) goto L21;
        if (r16 == null) goto L22;
        if (r17 == null) goto L23;
        boolean r0 = com.bytedance.android.live.core.utils.a0.d(r17, false);
        DigitAvatarBottomRecognitionModeDialog r11 = new DigitAvatarBottomRecognitionModeDialog(r15, new a(r0, r18, r16, r17, r19), new b(r0, r18, r16, r17, r19), new c(r0, r18, r16, r17, r19), new d(r15), new e(r0, r18), r17);
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r11);
    L12:
        int r1 = x.a;
        boolean r2 = com.bytedance.android.live.core.utils.a0.d(r17, false);
        LinkedHashMap r3 = new LinkedHashMap();
        x.c(r3, r2);
        if (r18 == false) goto L15;
        String r4 = "reset";
    L16:
        r3.put("request_page", r4);
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_set_mode_show", r3, new Object[]{am2.x.class, IRoom.class});
        return;
    L15:
        r4 = "panel";
        goto L16
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L11:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L12
    L23:
        return;
    L22:
        return;
    }
}
