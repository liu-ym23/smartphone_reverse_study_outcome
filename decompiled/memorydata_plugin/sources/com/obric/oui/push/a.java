package com.obric.oui.push;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/push/PushQueue;", "", "()V", "showingPush", "Lcom/obric/oui/push/OPush;", "getShowingPush", "setShowingPush", "", "newPush", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0772a f14411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy<a> f14412b = null;

    /* JADX INFO: renamed from: com.obric.oui.push.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/oui/push/PushQueue$Companion;", "", "()V", "instance", "Lcom/obric/oui/push/PushQueue;", "getInstance", "()Lcom/obric/oui/push/PushQueue;", "instance$delegate", "Lkotlin/Lazy;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0772a {
        private C0772a() {
        }

        public /* synthetic */ C0772a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14411a = new C0772a(null);
        f14412b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) ZeusTransformUtils.preCheckCast(PushQueue$Companion$instance$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker r1) {
        this();
    }
}
