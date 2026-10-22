package com.larus.receive.impl.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.minor.api.IMinorService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements b {
    public static final /* synthetic */ int b = 0;
    public final List<Uri> a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.receive.impl.handler.b
    public final String getName() {
        return "ReceiveUriHandler";
    }

    public d() {
        this.a = new ArrayList();
    }

    @Override // com.larus.receive.impl.handler.b
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        FLogger.a.i("ReceiveUriHandler", "handle, currentPage:landing,uris:" + this.a);
        if (((ArrayList) this.a).isEmpty() == false) goto L8;
        if (IMinorService.a.a() == true) goto L8;
        return;
    L8:
        if ((r10 instanceof AppCompatActivity) == false) goto L10;
        AppCompatActivity r0 = (AppCompatActivity) r10;
    L11:
        if (r0 == null) goto L16;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r3 == null) goto L17;
        BuildersKt.launch$default(r3, null, null, new ReceiveUriHandler$handle$1(this, r10, "landing", null), 3, null);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        r0 = null;
        goto L11
    }

    @Override // com.larus.receive.impl.handler.b
    public final boolean b(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        ((ArrayList) this.a).clear();
        List r3 = qs9.a.b(r2);
        if (r3 == null) goto L6;
        ((ArrayList) this.a).addAll(r3);
    L6:
        return !((ArrayList) this.a).isEmpty();
    }
}
