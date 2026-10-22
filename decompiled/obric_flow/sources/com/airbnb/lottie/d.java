package com.airbnb.lottie;

import android.graphics.PathMeasure;
import android.util.Log;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.HashSet;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements y {
    @Override // com.airbnb.lottie.y
    public final void onResult(Object r5) {
        Throwable r10 = (Throwable) r5;
        PathMeasure r11 = u.f.f22191a;
        if ((r10 instanceof SocketException) == false) goto L5;
    L19:
        u.b.f22181a.getClass();
        HashSet r12 = u.a.f22180a;
        if (r12.contains("Unable to load composition.") == true) goto L24;
        Log.w("LOTTIE", "Unable to load composition.", r10);
        r12.add("Unable to load composition.");
        return;
    L24:
        return;
    L5:
        if ((r10 instanceof ClosedChannelException) == true) goto L19;
        if ((r10 instanceof InterruptedIOException) == true) goto L19;
        if ((r10 instanceof ProtocolException) == true) goto L19;
        if ((r10 instanceof SSLException) == true) goto L19;
        if ((r10 instanceof UnknownHostException) == true) goto L19;
        if ((r10 instanceof UnknownServiceException) == true) goto L19;
        throw new IllegalStateException("Unable to parse composition", r10);
    }
}
