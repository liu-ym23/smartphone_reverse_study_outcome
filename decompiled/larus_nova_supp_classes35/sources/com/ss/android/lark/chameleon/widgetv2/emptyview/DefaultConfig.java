package com.ss.android.lark.chameleon.widgetv2.emptyview;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/widgetv2/emptyview/DefaultConfig;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "default", "Lkotlin/Function0;", "Lcom/ss/android/lark/chameleon/widgetv2/emptyview/Config;", "getDefault", "()Lkotlin/jvm/functions/Function0;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultConfig {
    private final Context context;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final Function0<Config> f1default;

    public final Context getContext() {
        return this.context;
    }

    public final Function0<Config> getDefault() {
        return this.f1default;
    }

    public DefaultConfig(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.f1default = new DefaultConfig$default$1(this);
    }
}
