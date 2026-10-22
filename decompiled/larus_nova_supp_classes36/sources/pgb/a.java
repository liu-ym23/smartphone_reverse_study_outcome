package pgb;

import com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final v a;

    /* JADX INFO: renamed from: pgb.a$a, reason: collision with other inner class name */
    public static final class C0310a {
    }

    static {
    }

    public a(v r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.a = r2;
    }

    public final void a(String r3, SocialGalleryRecallProvider.observer.1 r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        Log.e("MediaPreviewObserverManager", "registerMessageRecallObserver error, chatId is empty");
        return;
    L9:
        this.a.V().W1(r4, r3, new b(r3, r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b(String r2, SocialGalleryRecallProvider.observer.1 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        Log.e("MediaPreviewObserverManager", "unRegisterMessageRecallObserver error, chatId is empty");
        return;
    L9:
        this.a.V().V(r3, r2);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
