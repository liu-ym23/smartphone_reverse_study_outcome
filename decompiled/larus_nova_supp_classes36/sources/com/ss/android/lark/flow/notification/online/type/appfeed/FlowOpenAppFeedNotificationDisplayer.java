package com.ss.android.lark.flow.notification.online.type.appfeed;

import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import qza.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowOpenAppFeedNotificationDisplayer extends AbstractNotification.AbstractNotificationDisplayer<phb.a> {
    public static final Lazy<IProfileLauncherV2> a = null;

    public static final class a {
    }

    public final class b implements AbstractNotification.AbstractNotificationDisplayer.a<phb.a> {
        public b() {
        }

        @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
        public final void a(atb.a r11) {
            final phb.a r12 = (phb.a) r11;
            Intrinsics.checkNotNullParameter(r12, "data");
            thb.a.b("FlowOpenAppFeedNotificationDisplayer", "[Flow Push notify] Open App Feed - show notification");
            ((qza.b) LarkContext.spiByDwarf(qza.b.class)).b1(LarkContext.getApplication(), new c("OpenAppFeed", r12.c, r12.a, r12.b, new FlowOpenAppFeedNotificationDisplayer$OpenAppFeedDisplayerImpl$showNotification$1$1(r12), UIHelper.getString(2131890082)));
        }
    }

    static {
        a = LazyKt.lazy(FlowOpenAppFeedNotificationDisplayer$Companion$profileLauncherInstance$2.INSTANCE);
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final AbstractNotification.AbstractNotificationDisplayer.a<phb.a> a() {
        return new b();
    }

    public FlowOpenAppFeedNotificationDisplayer() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final atb.a b(Notice r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return new com.ss.android.lark.flow.notification.online.type.appfeed.b(r2).r();
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer
    public final boolean c(Notice r4) {
        boolean r0 = shb.b.b(r4);
        thb.a.b("FlowOpenAppFeedNotificationDisplayer", "[Flow Push notify] AppFeed - Notice key = " + r4.key + "，Notice message Id = " + r4.messageId + "，Push notify :" + r0 + "; sdk = " + Boolean.valueOf(r4.shouldNotify) + "; foreground = " + AppLifecycle.a.a.h() + "; is current notifiable = " + Boolean.valueOf(r4.shouldNotify) + "; isFromBackgroundUser = " + Boolean.valueOf(r4.isFromBackgroundUser));
        return r0;
    }
}
