package com.ss.android.lark.edit.keyboard.utils;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/edit/keyboard/utils/KeyboardResultReceiver;", "Landroid/os/ResultReceiver;", "receiver", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/ResultReceiver;Landroid/os/Handler;)V", "ref", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getRef", "()Ljava/lang/ref/WeakReference;", "onReceiveResult", BuildConfig.FLAVOR, "resultCode", BuildConfig.FLAVOR, "resultData", "Landroid/os/Bundle;", "edit-keyboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardResultReceiver extends ResultReceiver {
    public final WeakReference<ResultReceiver> a;

    public KeyboardResultReceiver(ResultReceiver r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        super(null);
        this.a = new WeakReference(r2);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r2, Bundle r3) {
        super.onReceiveResult(r2, r3);
        ResultReceiver r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.send(r2, r3);
        return;
    }
}
