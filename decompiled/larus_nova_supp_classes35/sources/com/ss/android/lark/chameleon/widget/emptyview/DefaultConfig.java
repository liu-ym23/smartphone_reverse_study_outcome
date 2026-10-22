package com.ss.android.lark.chameleon.widget.emptyview;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/widget/emptyview/DefaultConfig;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "default", "Lkotlin/Function0;", "Lcom/ss/android/lark/chameleon/widget/emptyview/Config;", "getDefault", "()Lkotlin/jvm/functions/Function0;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultConfig {
    private final Context context;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final Function0<Config> f0default;

    public final Context getContext() {
        return this.context;
    }

    public final Function0<Config> getDefault() {
        return this.f0default;
    }

    public DefaultConfig(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.f0default = new DefaultConfig$default$1(this);
    }
}
