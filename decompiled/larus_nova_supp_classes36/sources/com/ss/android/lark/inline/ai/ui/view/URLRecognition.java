package com.ss.android.lark.inline.ai.ui.view;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.compat.f;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class URLRecognition {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(final String r3, IGetDataCallback<UrlInlinePreviewEntity> r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "callback");
        f.a(new URLRecognition$loadUrlPreviewFormMiddlePlatform$1(r3)).then(Dispatchers.getMain(), new URLRecognition$loadUrlPreviewFormMiddlePlatform$2(r4, null)).error(Dispatchers.getMain(), new URLRecognition$loadUrlPreviewFormMiddlePlatform$3(r4, null));
    }
}
