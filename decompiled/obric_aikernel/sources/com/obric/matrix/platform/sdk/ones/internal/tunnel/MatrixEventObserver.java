package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MatrixEventObserver extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f5890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5891c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public MatrixEventObserver(String r10, boolean r11, Handler r12) {
        Intrinsics.checkNotNullParameter(r10, "myPath");
        super(r12);
        this.f5889a = r10;
        this.f5890b = LazyKt.lazy(new MatrixEventObserver$myUri$2(this));
    }

    public /* synthetic */ MatrixEventObserver(String r10, boolean r11, Handler r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ String a(MatrixEventObserver r10) {
        return r10.f5889a;
    }

    private final Uri b() {
        Object r10 = this.f5890b.getValue();
        Intrinsics.checkNotNullExpressionValue(r10, "<get-myUri>(...)");
        return (Uri) r10;
    }

    public abstract void c(Uri r10);

    @Override // android.database.ContentObserver
    public void onChange(boolean r10, Uri r11) {
        super.onChange(r10, r11);
        if (r11 != null) goto L5;
    L13:
        e9.b.k("MatrixEventObserver", "onChange, ignore! uri: [" + r11 + "], registered: [" + this.f5891c + ']', null, 4, null);
        return;
    L5:
        if (this.f5891c == false) goto L13;
        e9.b.b("MatrixEventObserver", "onChange, uri: [" + r11 + ']', null, 4, null);
        c(r11);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e9.b.c("MatrixEventObserver", "onChange, error! myUri: " + b() + ", uri Changed: " + r11, e);
    }
}
