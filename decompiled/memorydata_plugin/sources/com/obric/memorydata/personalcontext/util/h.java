package com.obric.memorydata.personalcontext.util;

import android.net.Uri;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/PersonalContextConstantUtil;", "", "<init>", "()V", "getEntityContentProviderUri", "Landroid/net/Uri;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12375a = null;

    static {
        f12375a = new h();
    }

    private h() {
    }

    public final Uri a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Uri r1 = Uri.parse("content://" + r2 + ".EntityContentProvider");
        Intrinsics.checkNotNullExpressionValue(r1, "parse(...)");
        return r1;
    }
}
