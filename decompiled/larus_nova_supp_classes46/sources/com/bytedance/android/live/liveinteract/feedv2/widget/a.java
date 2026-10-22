package com.bytedance.android.live.liveinteract.feedv2.widget;

import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LivePreviewMultiLinkCommonWidget a;

    public a(LivePreviewMultiLinkCommonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List r3 = (List) r2;
        IPreviewMultiLinkOuterConfigProvider r4 = this.a.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r4.notifyKtvComponentUpdateLocation();
    }
}
