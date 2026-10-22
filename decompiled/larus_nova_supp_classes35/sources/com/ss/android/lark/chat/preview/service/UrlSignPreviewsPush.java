package com.ss.android.lark.chat.preview.service;

import com.bytedance.lark.pb.url.v1.PushUrlPreviews;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlSignPreviewsPush {
    public static final Lazy<UrlSignPreviewsPush> d = null;
    public final CopyOnWriteArrayList<d7b.a> a;
    public final b b;
    public RucketJob<PushUrlPreviews> c;

    public static final class a {
    }

    public interface b {
        @SdkPush(3837)
        RucketJob<PushUrlPreviews> pushUrlPreviews();
    }

    static {
        d = LazyKt.lazy(32, UrlSignPreviewsPush$Companion$instance$2.INSTANCE);
    }

    public UrlSignPreviewsPush() {
        this.a = new CopyOnWriteArrayList();
        this.b = (b) b38.b.a.create(b.class);
    }

    public final synchronized void a(d7b.a r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L12
        if (this.a.contains(r4) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        boolean r0 = this.a.isEmpty();     // Catch: Throwable -> L12
        this.a.add(r4);     // Catch: Throwable -> L12
        if (r0 == false) goto L10;
        this.c = RucketJob.error$default(RucketJob.then$default(this.b.pushUrlPreviews(), null, new UrlSignPreviewsPush$addPushListener$1(this, null), 1, null), null, new UrlSignPreviewsPush$addPushListener$2(null), 1, null);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
