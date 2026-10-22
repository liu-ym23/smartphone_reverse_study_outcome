package j8;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.lynx.tasm.t;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import obric.flow.miniappwidget.m;
import obric.flow.miniappwidget.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18270b;

    public /* synthetic */ a(Object r5, Handler r10, int r11) {
        this.f18269a = r11;
        this.f18270b = r5;
        super(r10);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r5) {
        switch(this.f18269a) {
            case 0: goto L16;
            case 3: goto L7;
            default: goto L4;
        };
    L4:
        super.onChange(r5);
        return;
    L16:
        super.onChange(r5);
        b r10 = (b) this.f18270b;
        if (b.a(r10.f18272b) == false) goto L19;
        r10.openConnection(r10.e, r10.f);
        return;
    L19:
        r10.stopConnection();
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("WsChannelService", "KEY_FRONTIER_ENABLED");
    L9:
        t r11 = (t) this.f18270b;
        r11.getClass();
        boolean r12 = r11.f10962b;     // Catch: Exception -> L21
        r11.f();     // Catch: Exception -> L21
        boolean r13 = r11.f10962b;     // Catch: Exception -> L21
        if (r12 == r13) goto L24;
        s8.a r14 = (s8.a) r11.e;     // Catch: Exception -> L21
        if (r14 == null) goto L25;
        r14.c(r13);     // Catch: Exception -> L21
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r5, Uri r10) {
        switch(this.f18269a) {
            case 1: goto L12;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onChange(r5, r10);
        return;
    L6:
        String r11 = "server alive changed uri=" + r10;
        Intrinsics.checkNotNullParameter("MiniAppServerAliveObserver", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L11;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppServerAliveObserver", r11);
        ((q) this.f18270b).f20514a.invoke();
        return;
    L11:
        throw new IllegalStateException("KoinApplication has not been started");
    L12:
        m r13 = (m) this.f18270b;
        r13.getClass();
        if (r10 == null) goto L15;
        List<String> r14 = r10.getPathSegments();
    L16:
        if (r14 != null) goto L19;
        return;
    L19:
        if (r14.size() >= 2) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(r14.get(0), "applet_install_changed") == false) goto L38;
        String r15 = r14.get(1);
        String r16 = r15;
        Intrinsics.checkNotNull(r16);
        if (StringsKt.isBlank(r16) == false) goto L27;
        r15 = null;
    L27:
        String r17 = r15;
        if (r17 == null) goto L39;
        String r18 = "dispatch applet install state changed appletId=" + r17 + " uri=" + r10;
        Intrinsics.checkNotNullParameter("MiniAppInstallObserver", "tag");
        Intrinsics.checkNotNullParameter(r18, "msg");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L34;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppInstallObserver", r18);
        r13.f20502a.invoke(r17);
        return;
    L34:
        throw new IllegalStateException("KoinApplication has not been started");
    L39:
        return;
    L38:
        return;
    L15:
        r14 = null;
        goto L16
    }
}
