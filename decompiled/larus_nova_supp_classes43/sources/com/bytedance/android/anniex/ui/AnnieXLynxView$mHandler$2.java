package com.bytedance.android.anniex.ui;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class AnnieXLynxView$mHandler$2 extends Lambda implements Function0<Handler> {
    public static final AnnieXLynxView$mHandler$2 INSTANCE = null;

    static {
        INSTANCE = new AnnieXLynxView$mHandler$2();
    }

    public AnnieXLynxView$mHandler$2() {
        super(0);
    }

    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m428invoke() {
        return invoke();
    }
}
