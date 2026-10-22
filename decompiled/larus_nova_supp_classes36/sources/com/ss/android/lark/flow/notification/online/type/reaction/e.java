package com.ss.android.lark.flow.notification.online.type.reaction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class e extends AbstractNotification.AbstractNotificationDisplayer<rhb.a> {

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
            final rhb.a r12 = (rhb.a) r11;
            thb.a.b("FlowReactionNotificationDisplayer", "[Flow Push notify] Reaction - Notification display");
            ((qza.b) LarkContext.spiByDwarf(qza.b.class)).b1(LarkContext.getApplication(), new qza.c("Reaction", r12.c, r12.a, r12.b, new FlowReactionNotificationDisplayer$getNotificationDisplayerImpl$1$1$1(r12), ""));
        }
    }

    static {
    }

    public e() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final AbstractNotification.AbstractNotificationDisplayer.a<rhb.a> a() {
        return b.a;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final atb.a b(Notice r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        c r0 = new c((FlowReactionNotice) r9);
        FlowReactionNotice r10 = r0.b;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r2 = null;
        if (TextUtils.isEmpty(r10.messageId) == true) goto L12;
        Notice.Extra r11 = r10.extra;
        if (r11 == null) goto L7;
        String r12 = r11.a;
    L9:
        if (TextUtils.isEmpty(r12) == true) goto L12;
        boolean r13 = false;
    L13:
        if (r13 == true) goto L40;
        rhb.a r14 = new rhb.a();
        r0.a(r14);
        Notice.Extra r1 = r0.b.extra;
        if (r1.f == false) goto L18;
        Bitmap r3 = BitmapFactory.decodeResource(r0.g.getResources(), 2131237929);
    L33:
        r14.c = r3;
        FlowReactionNotice r4 = r0.b;
        r14.d = r4.extra.a;
        r14.f = r0.c;
        if (com.ss.android.lark.notification.export.entity.a.a(r4) == true) goto L37;
        r2 = r0.d;
    L37:
        r14.e = r2;
        r14.g = r0.f;
        r14.h = r0.e;
        return r14;
    L18:
        String r5 = r1.g;
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        r3 = null;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L20:
        if (TextUtils.isEmpty(r5) == true) goto L26;
        int r6 = UIHelper.dp2px(48.0f);     // Catch: ExecutionException -> L28 InterruptedException -> L30
        Notice.Extra r7 = r0.b.extra;     // Catch: ExecutionException -> L28 InterruptedException -> L30
        if (r7.b != Notice.Extra.ChatType.P2P) goto L24;
        String r8 = r7.c;     // Catch: ExecutionException -> L28 InterruptedException -> L30
    L25:
        r3 = ImageLoader.with(r0.g).load(AvatarImage.Builder.obtain(r5, r8, r6, r6).build()).asBitmap().centerCrop().error(2131237929).getBitmap(r6, r6);     // Catch: ExecutionException -> L28 InterruptedException -> L30
        goto L33
    L24:
        r8 = r7.a;     // Catch: ExecutionException -> L28 InterruptedException -> L30
        goto L25
    L26:
        r3 = BitmapFactory.decodeResource(r0.g.getResources(), 2131237929);     // Catch: ExecutionException -> L28 InterruptedException -> L30
        goto L33
    L40:
        return null;
    L7:
        r12 = null;
    L12:
        r13 = true;
        goto L13
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final boolean c(Notice r4) {
        boolean r0 = shb.b.b(r4);
        thb.a.b("FlowReactionNotificationDisplayer", "[Flow Push notify] Reaction - Notice key = " + r4.key + "，Notice message Id = " + r4.messageId + "，Push notify :" + r0 + "; sdk = " + Boolean.valueOf(r4.shouldNotify) + "; foreground = " + AppLifecycle.a.a.h() + "; is current notifiable = " + Boolean.valueOf(r4.shouldNotify) + "; isFromBackgroundUser = " + Boolean.valueOf(r4.isFromBackgroundUser));
        return r0;
    }
}
