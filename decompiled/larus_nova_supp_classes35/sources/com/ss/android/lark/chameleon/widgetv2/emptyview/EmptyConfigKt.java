package com.ss.android.lark.chameleon.widgetv2.emptyview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"empty", "Lcom/ss/android/lark/chameleon/widgetv2/emptyview/Config;", "build", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlin/ExtensionFunctionType;", "chameleon-base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EmptyConfigKt {
    public static final Config empty(Function1<? super Config, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "build");
        Config r0 = new Config();
        r1.invoke(r0);
        return r0;
    }
}
