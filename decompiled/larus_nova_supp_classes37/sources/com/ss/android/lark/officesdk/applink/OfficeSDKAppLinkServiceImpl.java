package com.ss.android.lark.officesdk.applink;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ova.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class OfficeSDKAppLinkServiceImpl implements com.ss.android.lark.officesdk.applink.a {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Inject
    public OfficeSDKAppLinkServiceImpl() {
        this.a = LazyKt.lazy(OfficeSDKAppLinkServiceImpl$appLinkService$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.applink.a
    public final boolean d9(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        return ((f) this.a.getValue()).h(r2, UriProtector.parse(r3));
    }

    @Override // com.ss.android.lark.officesdk.applink.a
    public final void q6(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        f r0 = (f) this.a.getValue();
        Uri r4 = UriProtector.parse(r3);
        monitor-enter(r0);
        r0.x(r2, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.applink.a
    public final boolean u7(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "url");
        Set<String> r2 = b.a;
        Intrinsics.checkNotNullParameter(r6, "url");
        boolean r1 = true;
        Uri r7 = b.a(r6);     // Catch: Exception -> L17
        if (r7 == null) goto L18;
        String r3 = UriProtector.getQueryParameter(r7, "link_token");     // Catch: Exception -> L17
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L18;
        Uri r8 = r7.buildUpon().scheme("lark").authority("applink").path("/client/chat/chatter/add_by_link").build();     // Catch: Exception -> L17
    L19:
        if (r8 != null) goto L34;
        return false;
    L34:
    L32:
        Log.w("OfficeSDKAppLinkService", "open group invite appLink failed");
        return false;
    L22:
        if (((f) this.a.getValue()).h(r5, r8) == true) goto L24;
        Log.w("OfficeSDKAppLinkService", "group invite appLink cannot open");     // Catch: Exception -> L32
        r1 = false;
    L39:
        return r1;
    L24:
        f r9 = (f) this.a.getValue();     // Catch: Exception -> L32
        monitor-enter(r9);     // Catch: Exception -> L32
        r9.x(r5, r8);     // Catch: Throwable -> L29
        monitor-exit(r9);     // Catch: Exception -> L32
        goto L39
    L29:
        th = move-exception;
        throw th;     // Catch: Exception -> L32
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r4 = false;
    L18:
        r8 = null;
    L17:
        Log.w("OfficeSDKGroupInviteLink", "normalize group invite link failed");
        goto L18
    }
}
