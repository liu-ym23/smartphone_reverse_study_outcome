package dfb;

import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final d a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedActionStatus.values().length];
            r0[FeedActionStatus.END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FeedActionStatus.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public e(d r2) {
        Intrinsics.checkNotNullParameter(r2, "reseter");
        this.a = r2;
    }

    public final void a(FeedActionStatus r2, FeedActionEvent r3) {
        int r4 = a.a[r2.ordinal()];
        if (r4 != 1) goto L5;
        ThreadUtils.runOnUIThread(new f(r3, this));
        return;
    L5:
        if (r4 != 2) goto L11;
        this.a.So();
        return;
    }

    public final void b(com.ss.android.lark.feed.export.feedcard.d r3, UIFeedCard r4, FeedActionStatus r5, FeedActionEvent r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r5, "actionStatus");
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((!FeedFolderCompat.INSTANCE.getTAG().isSameFolderWith(r3.f())) == true) goto L6;
        a(r5, r6);
    L6:
        if (a.a[r5.ordinal()] == 1) goto L8;
    L11:
        a(r5, r6);
        return;
    L8:
        if (r4.isRemind() == false) goto L10;
        int r7 = qeb.a.a;
        qeb.a.C0285a.a("mute", r4);
        goto L11
    L10:
        int r8 = qeb.a.a;
        qeb.a.C0285a.a("unmute", r4);
        goto L11
    }
}
