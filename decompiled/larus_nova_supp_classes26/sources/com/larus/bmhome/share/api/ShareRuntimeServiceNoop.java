package com.larus.bmhome.share.api;

import android.content.Context;
import android.content.Intent;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J[\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/share/api/ShareRuntimeServiceNoop;", "Lcom/larus/bmhome/share/api/IShareRuntimeService;", "<init>", "()V", "initShareRuntime", "", ShareChannel.SHARE, "context", "Landroid/content/Context;", "shareChannel", "", "shareType", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "showLoading", "", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "resultCode", "isInstalledChannel", "handleActivityResult", "requestCode", "intent", "Landroid/content/Intent;", "isChannelSupported", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareRuntimeServiceNoop implements IShareRuntimeService {
    public ShareRuntimeServiceNoop() {
    }

    public final boolean a(String r1) {
        return false;
    }

    public final void b(int r1, int r2, Intent r3) {
    }

    public final void c() {
    }

    public final boolean e(String r1, String r2) {
        return false;
    }

    public final void d(Context r1, String r2, String r3, b r4, boolean r5, com.larus.share.impl.sdk.b r6) {
        Intrinsics.checkNotNullParameter(r4, "shareContent");
        r6.invoke(2);
    }
}
