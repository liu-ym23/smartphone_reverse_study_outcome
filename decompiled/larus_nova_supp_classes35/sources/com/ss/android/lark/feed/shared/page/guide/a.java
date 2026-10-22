package com.ss.android.lark.feed.shared.page.guide;

import android.app.Activity;
import android.util.Size;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import ujb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.shared.page.guide.a$a, reason: collision with other inner class name */
    public interface InterfaceC0205a {
        void onClose();

        void onConfirm();
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedTipGuideHelper$GuideType.values().length];
            r0[FeedTipGuideHelper$GuideType.BADGE_STYLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FeedTipGuideHelper$GuideType.AT_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FeedTipGuideHelper$GuideType.AT_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static void a(View r7, Activity r8, UIFeedCard.AtInfo r9, boolean r10, InterfaceC0205a r11) {
        if (r7 == null) goto L15;
        if (r9 == null) goto L15;
        if (r8 == null) goto L15;
        if (r10 == false) goto L8;
        String r0 = "all_feed_mention_all";
    L9:
        AnchorConfig r1 = new AnchorConfig(r7, AnchorConfig.AnchorGravity.START);
        MaskConfig r2 = new MaskConfig(MaskConfig.ShapeType.CIRCLE, null, new Size(12, 12), 42);
        d r3 = new d(UIUtils.getString(r7.getContext(), 2131891829), new com.ss.android.lark.feed.shared.page.guide.b(r11, r0));
        if (r10 == false) goto L12;
        String r12 = UIHelper.mustacheFormat(2131891726, "user_name", r9.getLocalizedUserName());
    L13:
        Intrinsics.checkNotNull(r12);
        ujb.c r13 = new ujb.c(r1, r2, r12, r3);
        int r14 = qjb.a.a;
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r13, "config");
        new tjb.c(new WeakReference(r8), r13).o();
        heb.a.a.getGuideDependency().c();
        return;
    L12:
        r12 = UIHelper.mustacheFormat(2131891727, "user_name", r9.getLocalizedUserName());
        goto L13
    L8:
        r0 = "all_feed_mention_you";
    L15:
        if (r11 == null) goto L18;
        r11.onClose();
        return;
    }
}
