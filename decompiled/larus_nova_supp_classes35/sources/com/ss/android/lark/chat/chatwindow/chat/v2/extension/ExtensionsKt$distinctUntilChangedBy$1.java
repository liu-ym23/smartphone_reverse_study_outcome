package com.ss.android.lark.chat.chatwindow.chat.v2.extension;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "from", "to", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ExtensionsKt$distinctUntilChangedBy$1 extends Lambda implements Function2<Object, Object, Boolean> {
    final /* synthetic */ Function1<Object, Object> $keySelector;

    public ExtensionsKt$distinctUntilChangedBy$1(Function1<Object, ? extends Object> r1) {
        this.$keySelector = r1;
        super(2);
    }

    public final Boolean invoke(Object r2, Object r3) {
        return Boolean.valueOf(!Intrinsics.areEqual(this.$keySelector.invoke(r2), this.$keySelector.invoke(r3)));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m440invoke(Object r1, Object r2) {
        return invoke(r1, r2);
    }
}
