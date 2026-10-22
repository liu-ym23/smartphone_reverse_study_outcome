package com.larus.chat.gallery.impl.preview.input;

import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final Function0<String> a;
    public final ExecutorService b;
    public final Object c;
    public volatile Function1<? super BotModel, Unit> d;
    public volatile BotModel e;

    public static final class a {
    }

    static {
    }

    public g(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "botIdProvider");
        this.a = r2;
        this.b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BotModelCacheHelper"));
        this.c = new Object();
    }
}
