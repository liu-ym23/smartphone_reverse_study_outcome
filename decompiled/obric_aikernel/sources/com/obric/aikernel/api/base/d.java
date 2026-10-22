package com.obric.aikernel.api.base;

import com.obric.aikernel.middleware.api.alog.ALogManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.obric.aikernel.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g1<Boolean> f4437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w<Unit> f4438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f4439c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public d() {
        this.f4437a = q1.a(Boolean.TRUE);
        this.f4438b = y.b(null, 1, null);
        this.f4439c = new LinkedHashSet();
    }

    public static final /* synthetic */ Set a(d r10) {
        return r10.f4439c;
    }

    public static final /* synthetic */ w b(d r10) {
        return r10.f4438b;
    }

    public void c() {
        ALogManager.INSTANCE.setAlogConsumer();
    }

    protected void d(boolean r10) {
    }
}
