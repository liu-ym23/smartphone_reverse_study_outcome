package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/larksuite/framework/utils/AndroidThrottle;", "Lcom/ss/android/lark/coremd/facade/mdeditor/at/IMEditorAtChatterLoader$FetchChatterRequest;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtChatterLoader$throttle$2 extends Lambda implements Function0<AndroidThrottle<com.ss.android.lark.coremd.facade.mdeditor.at.a.c>> {
    final /* synthetic */ com.ss.android.lark.coremd.facade.mdeditor.at.a this$0;

    public static final class a<T> implements AndroidThrottle.e {
        public a() {
        }

        public final void a(Collection<com.ss.android.lark.coremd.facade.mdeditor.at.a.c> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            int r3 = com.ss.android.lark.coremd.facade.mdeditor.at.a.a;
            throw null;
        }
    }

    public IMEditorAtChatterLoader$throttle$2(com.ss.android.lark.coremd.facade.mdeditor.at.a r1) {
        super(0);
    }

    public final AndroidThrottle<com.ss.android.lark.coremd.facade.mdeditor.at.a.c> invoke() {
        AndroidThrottle.a r0 = new AndroidThrottle.a();
        r0.b = 0;
        r0.a = CoreThreadPool.getNonblockingHandler();
        r0.d = new com.ss.android.lark.coremd.facade.mdeditor.at.a.b();
        r0.e = new a();
        return new AndroidThrottle(r0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1089invoke() {
        return invoke();
    }
}
