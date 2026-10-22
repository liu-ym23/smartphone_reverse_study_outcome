package com.bytedance.android.live.network.impl.utils;

import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Function;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ String a;

    public e(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        Intrinsics.checkNotNullParameter((Integer) r7, "it");
        return BitmapFactory.decodeStream(new ByteArrayInputStream(((HttpResponse) ((INetworkService) jc1.k.n(INetworkService.class)).downloadFile(false, Integer.MAX_VALUE, this.a, new ArrayList(), null).execute()).getBody()));
    L5:
        e = move-exception;
        ALogger.stacktrace(6, "NinePatchUtil", e.getStackTrace());
        Logger.e("NinePatchUtil", e.getMessage());
        return null;
    }
}
