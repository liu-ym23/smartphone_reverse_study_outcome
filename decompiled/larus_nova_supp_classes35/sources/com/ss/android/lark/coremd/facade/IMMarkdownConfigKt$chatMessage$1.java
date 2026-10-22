package com.ss.android.lark.coremd.facade;

import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/IMContextExtend;", "it", "Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMMarkdownConfigKt$chatMessage$1 extends Lambda implements Function2<IMContextExtend, com.ss.android.lark.coremd.base.parse.b, Unit> {
    public static final IMMarkdownConfigKt$chatMessage$1 INSTANCE = null;

    static {
        INSTANCE = new IMMarkdownConfigKt$chatMessage$1();
    }

    public IMMarkdownConfigKt$chatMessage$1() {
        super(2);
    }

    public final void invoke(IMContextExtend r2, com.ss.android.lark.coremd.base.parse.b r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((IMContextExtend) r1, (com.ss.android.lark.coremd.base.parse.b) r2);
        return Unit.INSTANCE;
    }
}
