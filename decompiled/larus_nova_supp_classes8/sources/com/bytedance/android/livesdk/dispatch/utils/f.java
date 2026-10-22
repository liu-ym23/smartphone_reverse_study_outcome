package com.bytedance.android.livesdk.dispatch.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r3, String r4, String r5, IBaseCallbackSchemaHandler.SchemaCallback r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "outerCallback");
        ILiveActionHandler r1 = k.n(IRoomService.class).actionHandler();
        Uri r7 = UriProtector.parse("sslocal://webcast_dispatch/" + r4 + '?' + r5);
        Intrinsics.checkNotNullParameter(r4, "path");
        r1.handle(r3, r7, new e(r6, r4));
    }
}
