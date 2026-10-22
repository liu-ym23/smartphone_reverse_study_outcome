package com.obric.memorydata.memory.llm;

import android.content.Intent;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.dc.PageContextData;
import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.dc.PageContextState;
import com.obric.memorydata.memory.s;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0005J#\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/llm/PageContextMemoryCoordinator;", "", "<init>", "()V", "TAG", "", "RESULT_CACHE_TTL_MS", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "completedLinks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/dc/SourceLinkResult;", "bind", "", ObricMemoryConstants.KEY_SESSION_ID, "handle", "Lcom/obric/memorydata/dc/PageContextHandle;", "sourcePackageName", "resolve", "selectSourceLink", "result", "Lcom/obric/memorydata/dc/PageContextResult;", "selectSourceLink$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f10290b = null;
    private static final ConcurrentHashMap<String, com.obric.memorydata.dc.d> c = null;

    static {
        f10289a = new h();
        f10290b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new ConcurrentHashMap();
    }

    private h() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return c;
    }

    public final com.obric.memorydata.dc.d a(PageContextResult r3, String r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.getState() == PageContextState.SUCCESS) goto L8;
        return null;
    L8:
        PageContextData r0 = r3.getData();
        if (r0 == null) goto L11;
        String r1 = r0.getDeeplink();
    L13:
        if (at.a(r1) == false) goto L16;
        Intrinsics.checkNotNull(r1);
        return new com.obric.memorydata.dc.d(r1, MemorySourceLinkType.DEEPLINK);
    L16:
        PageContextData r2 = r3.getData();
        if (r2 == null) goto L19;
        String r5 = r2.getUrl();
    L21:
        if (at.a(r5) == false) goto L24;
        Intrinsics.checkNotNull(r5);
        return new com.obric.memorydata.dc.d(r5, "url");
    L24:
        Intent r6 = r3.getIntent();
        if (r6 != null) goto L27;
        return null;
    L27:
        s r7 = s.f10512a;
        if (r4 != null) goto L30;
        r4 = "";
    L30:
        String r8 = r7.a(r6, r4);
        if (r8 != null) goto L33;
        return null;
    L33:
        return new com.obric.memorydata.dc.d(r8, MemorySourceLinkType.INTENT);
    L19:
        r5 = null;
        goto L21
    L11:
        r1 = null;
        goto L13
    }

    public final com.obric.memorydata.dc.d a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        return (com.obric.memorydata.dc.d) ZeusTransformUtils.preCheckCast(c.get(r2), com.obric.memorydata.dc.d.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r7, com.obric.memorydata.dc.a r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_SESSION_ID);
        if (r8 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(f10290b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PageContextMemoryCoordinator$bind$1(r8, r9, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
