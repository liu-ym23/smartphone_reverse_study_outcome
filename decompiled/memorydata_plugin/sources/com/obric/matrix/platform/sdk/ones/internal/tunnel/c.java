package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH&J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixEventObserver;", "Landroid/database/ContentObserver;", "myPath", "", "notifyForDescendants", "", "handler", "Landroid/os/Handler;", "(Ljava/lang/String;ZLandroid/os/Handler;)V", "myUri", "Landroid/net/Uri;", "getMyUri", "()Landroid/net/Uri;", "myUri$delegate", "Lkotlin/Lazy;", "registered", "handleContentChange", "", "uri", "onChange", "selfChange", "register", "context", "Landroid/content/Context;", "unregister", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class c extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8115a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8116b;
    private final boolean c;
    private final Lazy d;
    private volatile boolean e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixEventObserver$Companion;", "", "()V", "BROADCAST_PROVIDER_AUTHORITY", "", "TAG", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8115a = new a(null);
    }

    public c(String r2, boolean r3, Handler r4) {
        Intrinsics.checkNotNullParameter(r2, "myPath");
        super(r4);
        this.f8116b = r2;
        this.c = r3;
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MatrixEventObserver$myUri$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ c(String r1, boolean r2, Handler r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    private final Uri a() {
        Object r2 = this.d.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-myUri>(...)");
        return (Uri) ZeusTransformUtils.preCheckCast(r2, Uri.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String a(c r0) {
        return r0.f8116b;
    }

    public abstract void a(Uri r1);

    @Override // android.database.ContentObserver
    public void onChange(boolean r6, Uri r7) {
        super.onChange(r6, r7);
        if (r7 != null) goto L5;
    L13:
        com.obric.matrix.platform.sdk.ones.internal.b.b.c("MatrixEventObserver", "onChange, ignore! uri: [" + r7 + "], registered: [" + this.e + ']', null, 4, null);
        return;
    L5:
        if (this.e == false) goto L13;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("MatrixEventObserver", "onChange, uri: [" + r7 + ']', null, 4, null);
        a(r7);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixEventObserver", "onChange, error! myUri: " + a() + ", uri Changed: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
