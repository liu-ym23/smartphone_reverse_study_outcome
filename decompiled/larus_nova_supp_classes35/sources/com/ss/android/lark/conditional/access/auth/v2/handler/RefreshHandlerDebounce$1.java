package com.ss.android.lark.conditional.access.auth.v2.handler;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class RefreshHandlerDebounce$1 extends Lambda implements Function1<Set<? extends String>, Unit> {
    public static final RefreshHandlerDebounce$1 INSTANCE = null;

    static {
        INSTANCE = new RefreshHandlerDebounce$1();
    }

    public RefreshHandlerDebounce$1() {
        super(1);
    }

    public final void invoke(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Set) r1);
        return Unit.INSTANCE;
    }
}
