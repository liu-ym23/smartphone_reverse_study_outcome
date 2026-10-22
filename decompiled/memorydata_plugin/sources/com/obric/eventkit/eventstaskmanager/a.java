package com.obric.eventkit.eventstaskmanager;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventContextHolder;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8018a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f8019b;
    public static String c;

    static {
        f8018a = new a();
    }

    private a() {
    }

    public final String a() {
        String r0 = c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricMemoryConstants.KEY_PACKAGE_NAME);
        return null;
    }

    public final void a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        f8019b = r1;
    }

    public final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        c = r1;
    }

    public final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        a(r4);
        String r5 = r4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r5, "context.packageName");
        a(r5);
    }

    public final Context getContext() {
        Context r0 = f8019b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }
}
