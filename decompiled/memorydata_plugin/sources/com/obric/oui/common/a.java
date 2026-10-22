package com.obric.oui.common;

import com.obric.oui.c.a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/common/SdkInit;", "", "()V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0734a f13476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f13477b;

    /* JADX INFO: renamed from: com.obric.oui.common.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/common/SdkInit$Companion;", "", "()V", "instanceCount", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0734a {
        private C0734a() {
        }

        public /* synthetic */ C0734a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13476a = new C0734a(null);
    }

    public a() {
        if (f13477b != 0) goto L5;
        b.b("SDK_INIT", "BUILD_NO: [20260914-22:10:39|release|2.0.1|f3e6f2db|20260914-21:59:02_bugfix:Fix Dialog height overflow beyond the defined max height limit]");
        com.obric.oui.a.f13270a.a();
    L5:
        f13477b++;
    }
}
