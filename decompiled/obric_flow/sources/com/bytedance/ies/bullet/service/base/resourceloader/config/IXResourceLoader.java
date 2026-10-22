package com.bytedance.ies.bullet.service.base.resourceloader.config;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.kit.resourceloader.h;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.ies.bullet.service.base.a0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJG\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u0003R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "", "<init>", "()V", "Lcom/bytedance/ies/bullet/service/base/a0;", "input", "Lwc/g;", "config", "loadSync", "(Lcom/bytedance/ies/bullet/service/base/a0;Lwc/g;)Lcom/bytedance/ies/bullet/service/base/a0;", "Lkotlin/Function1;", "", "resolve", "", "reject", "loadAsync", "(Lcom/bytedance/ies/bullet/service/base/a0;Lwc/g;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "cancelLoad", "Lcom/bytedance/ies/bullet/kit/resourceloader/h;", NotificationCompat.CATEGORY_SERVICE, "Lcom/bytedance/ies/bullet/kit/resourceloader/h;", "getService", "()Lcom/bytedance/ies/bullet/kit/resourceloader/h;", "setService", "(Lcom/bytedance/ies/bullet/kit/resourceloader/h;)V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/bytedance/ies/bullet/kit/resourceloader/j;", "interval", "Lcom/bytedance/ies/bullet/kit/resourceloader/j;", "getInterval", "()Lcom/bytedance/ies/bullet/kit/resourceloader/j;", "setInterval", "(Lcom/bytedance/ies/bullet/kit/resourceloader/j;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public abstract class IXResourceLoader {
    private final String TAG;
    private j interval;
    public h service;

    public IXResourceLoader() {
        this.TAG = getClass().getSimpleName();
        this.interval = new j();
    }

    public abstract void cancelLoad();

    public final j getInterval() {
        return this.interval;
    }

    public final h getService() {
        h r5 = this.service;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
        return null;
    }

    public String getTAG() {
        return this.TAG;
    }

    public abstract void loadAsync(a0 r5, g r10, Function1<? super a0, Unit> r11, Function1<? super Throwable, Unit> r12);

    public abstract a0 loadSync(a0 r5, g r10);

    public final void setInterval(j r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.interval = r5;
    }

    public final void setService(h r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.service = r5;
    }
}
