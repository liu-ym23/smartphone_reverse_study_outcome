package com.obric.capabilitykit.entity;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContextHolder;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", DBDefinition.PACKAGE_NAME, "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "init", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityContextHolder {
    public static final EntityContextHolder INSTANCE = null;
    public static Context context;
    public static String packageName;

    static {
        INSTANCE = new EntityContextHolder();
    }

    private EntityContextHolder() {
    }

    public final Context getContext() {
        Context r0 = context;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final String getPackageName() {
        String r0 = packageName;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(DBDefinition.PACKAGE_NAME);
        return null;
    }

    public final void init(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        setContext(r2);
        setPackageName(r2.getPackageName());
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        context = r2;
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        packageName = r2;
    }
}
