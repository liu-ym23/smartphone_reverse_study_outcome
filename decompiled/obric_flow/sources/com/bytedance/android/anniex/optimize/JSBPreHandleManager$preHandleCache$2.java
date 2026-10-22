package com.bytedance.android.anniex.optimize;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/util/LruCache;", "", "", "invoke", "()Landroid/util/LruCache;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class JSBPreHandleManager$preHandleCache$2 extends Lambda implements Function0<LruCache<String, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSBPreHandleManager$preHandleCache$2 f3343a = null;

    static {
        f3343a = new JSBPreHandleManager$preHandleCache$2();
    }

    public JSBPreHandleManager$preHandleCache$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final LruCache<String, Object> invoke() {
        return new LruCache(1024);
    }
}
