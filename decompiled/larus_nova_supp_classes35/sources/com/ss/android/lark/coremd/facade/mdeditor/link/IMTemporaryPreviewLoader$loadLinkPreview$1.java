package com.ss.android.lark.coremd.facade.mdeditor.link;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMTemporaryPreviewLoader$loadLinkPreview$1 extends Lambda implements Function1<IGetDataCallback<UrlInlinePreviewEntity>, Unit> {
    final /* synthetic */ n $link;

    public IMTemporaryPreviewLoader$loadLinkPreview$1(n r1) {
        this.$link = r1;
        super(1);
    }

    public final void invoke(IGetDataCallback<UrlInlinePreviewEntity> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        KeyboardBaseModule.a().getUrlInlineFromContent(this.$link.j, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IGetDataCallback) r1);
        return Unit.INSTANCE;
    }
}
