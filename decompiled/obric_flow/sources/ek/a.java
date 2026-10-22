package ek;

import java.io.BufferedOutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f16822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16823c;
    public byte[] d;

    public final void a(BufferedOutputStream r19) {
        if (this.f16821a == false) goto L5;
        byte r5 = (byte) 128;
    L6:
        r19.write((byte) (r5 | (this.f16822b & 15)));
        long r10 = this.f16823c;
        if (r10 > 125) goto L10;
        byte[] r11 = {(byte) r10};
    L14:
        r19.write(r11, 0, r11.length);
        r19.write(this.d, 0, (int) this.f16823c);
        return;
    L10:
        if (r10 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L13;
        byte[] r12 = {126, (byte) ((r10 >> 8) & 255), (byte) (r10 & 255)};
    L12:
        r11 = r12;
        goto L14
    L13:
        r12 = new byte[]{ByteCompanionObject.MAX_VALUE, (byte) ((r10 >> 56) & 255), (byte) ((r10 >> 48) & 255), (byte) ((r10 >> 40) & 255), (byte) ((r10 >> 32) & 255), (byte) ((r10 >> 24) & 255), (byte) ((r10 >> 16) & 255), (byte) ((r10 >> 8) & 255), (byte) (r10 & 255)};
        goto L12
    L5:
        r5 = 0;
        goto L6
    }
}
