package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function2 b;

    public i(Function1 r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        List r0 = ((CoverImageModel) r5.data).getUrlList();
        if (r0 == null) goto L15;
        boolean r1 = true;
        if ((!r0.isEmpty()) != true) goto L15;
        String r2 = ((CoverImageModel) r5.data).getUri();
        if (r2 != null) goto L9;
    L12:
        if (r1 == true) goto L15;
        this.b.invoke(((CoverImageModel) r5.data).getUri(), ListProtector.get(((CoverImageModel) r5.data).getUrlList(), 0));
        return;
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r1 = false;
    L15:
        Function1 r6 = this.a;
        if (r6 == null) goto L20;
        Unit r7 = (Unit) r6.invoke(new Throwable("uri or url list is empty"));
        return;
    }
}
