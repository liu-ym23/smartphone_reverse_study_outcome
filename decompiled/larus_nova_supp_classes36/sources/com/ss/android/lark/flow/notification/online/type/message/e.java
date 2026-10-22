package com.ss.android.lark.flow.notification.online.type.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends AbstractNotification.AbstractNotificationDisplayer<qhb.a> {

    public static final class a {
    }

    public static final class b<R extends atb.a> implements AbstractNotification.AbstractNotificationDisplayer.a {
        public static final b<R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
        public final void a(atb.a r11) {
            final qhb.a r12 = (qhb.a) r11;
            thb.a.b("FlowMessageNotification", "[Flow Push notify] Message - Notification display");
            ((qza.b) LarkContext.spiByDwarf(qza.b.class)).b1(LarkContext.getApplication(), new qza.c("Message", r12.c, r12.a, r12.b, new FlowMessageNotificationDisplayer$getNotificationDisplayerImpl$1$1$1(r12), ""));
        }
    }

    static {
    }

    public e() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final AbstractNotification.AbstractNotificationDisplayer.a<qhb.a> a() {
        return b.a;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final atb.a b(Notice r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        c r0 = new c(r11);
        String r1 = null;
        if (r0.c != null) goto L5;
    L58:
        thb.a.a("FlowMessageNotificationDataPacker", "messageId or getChatId is null");
        return null;
    L5:
        if (r0.d == null) goto L58;
        if (r0.e == null) goto L58;
        qhb.a r12 = new qhb.a();
        r0.a(r12);
        if (r0.r() == true) goto L12;
    L14:
        Math.max(r0.b.extra.h, 1);
    L15:
        r0.s();
        r0.r();
        Context r2 = r0.i;
        Notice r4 = r0.b;
        int r5 = shb.a.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "notice");
        String r6 = r4.extra.g;
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        Bitmap r3 = null;
    L32:
        if (r3 == null) goto L35;
        r12.c = r3;
    L35:
        if (r0.r() == false) goto L40;
        if (r0.s() == false) goto L40;
    L46:
        Notice r7 = r0.b;
        long r8 = r7.createTime;
        r12.d = r0.d;
        r12.f = r0.c;
        if (com.ss.android.lark.notification.export.entity.a.a(r7) == true) goto L50;
        r1 = r0.f;
    L50:
        r12.e = r1;
        r12.g = r0.h;
        r12.h = r0.g;
        if (AppLifecycle.a.a.h() == false) goto L61;
        if (r0.s() == true) goto L61;
        TextUtils.isEmpty(r0.b.extra.t);
    L61:
        return r12;
    L40:
        if (r0.r() == true) goto L42;
    L44:
        Math.max(r0.b.extra.h, 1);
    L45:
        UIHelper.getString(2131891516);
        goto L46
    L42:
        if (r0.s() == false) goto L44;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L17:
        if (TextUtils.isEmpty(r6) == false) goto L19;
    L25:
        r3 = BitmapFactory.decodeResource(r2.getResources(), 2131237929);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        goto L32
    L19:
        if (r4.extra.f == true) goto L25;
        int r9 = UIHelper.dp2px(48.0f);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        Notice.Extra r10 = r4.extra;     // Catch: ExecutionException -> L27 InterruptedException -> L29
        if (r10.b != Notice.Extra.ChatType.P2P) goto L23;
        String r13 = r10.c;     // Catch: ExecutionException -> L27 InterruptedException -> L29
        Intrinsics.checkNotNull(r13);     // Catch: ExecutionException -> L27 InterruptedException -> L29
    L24:
        r3 = ImageLoader.with(r2).load(AvatarImage.Builder.obtain(r6, r13, r9, r9).build()).asBitmap().centerCrop().error(2131237929).getBitmap(r9, r9);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        goto L32
    L23:
        r13 = r10.a;     // Catch: ExecutionException -> L27 InterruptedException -> L29
        Intrinsics.checkNotNull(r13);     // Catch: ExecutionException -> L27 InterruptedException -> L29
        goto L24
    L12:
        if (r0.s() == false) goto L14;
        goto L14
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final boolean c(Notice r4) {
        boolean r0 = shb.b.b(r4);
        thb.a.b("FlowMessageNotification", "[Flow Push notify] Message - Notice key = " + r4.key + "，Notice message Id = " + r4.messageId + "，Push notify :" + r0 + "; sdk = " + Boolean.valueOf(r4.shouldNotify) + "; foreground = " + AppLifecycle.a.a.h() + "; is current notifiable = " + Boolean.valueOf(r4.shouldNotify) + "; isFromBackgroundUser = " + Boolean.valueOf(r4.isFromBackgroundUser));
        return r0;
    }
}
