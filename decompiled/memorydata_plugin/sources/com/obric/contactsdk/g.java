package com.obric.contactsdk;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/contactsdk/HandlerUtils;", "", "()V", "TAG", "", "handlerIO", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "getHandler", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f7856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HandlerThread f7857b = null;
    private static Handler c;

    static {
        f7856a = new g();
        HandlerThread r0 = new HandlerThread("HandlerUtils");
        f7857b = r0;
        r0.start();
        c = new Handler(r0.getLooper());
    }

    private g() {
    }

    public final Handler a() {
        return c;
    }
}
