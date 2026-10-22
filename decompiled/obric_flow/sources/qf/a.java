package qf;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f21506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioFocusRequest f21507b;

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = r5.getSystemService("audio");
        if (r10 == null) goto L7;
        this.f21506a = (AudioManager) r10;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
