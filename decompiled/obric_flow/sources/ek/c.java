package ek;

import ai.p;
import android.net.LocalSocket;
import android.util.Base64;
import android.util.Log;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.lynx.tasm.behavior.x0;
import dk.e;
import dk.f;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements dk.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zm.c f16825a;

    public c(zm.c r5) {
        this.f16825a = r5;
    }

    public static String b(dk.d r5, String r10) {
        ArrayList r11 = (ArrayList) r5.f16659a;
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10.equals(r11.get(r13)) == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return (String) ((ArrayList) r5.f16660b).get(r13);
    L9:
        return null;
    }

    @Override // dk.b
    public final boolean a(com.lynx.animax.player.b r10, dk.d r11, e r12) {
        if ("websocket".equalsIgnoreCase(b(r11, Constant.UPDATE_PATH)) == true) goto L5;
    L32:
        r12.f16662c = LynxErrorCode.LYNX_ERROR_CODE_CANVAS;
        r12.d = "Not Implemented";
        r12.e = p.d("Not a supported WebSocket upgrade request\n", "text/plain");
        return true;
    L5:
        if (Constant.UPDATE_PATH.equals(b(r11, "Connection")) == false) goto L32;
        if ("13".equals(b(r11, "Sec-WebSocket-Version")) == false) goto L32;
        r12.f16662c = 101;
        r12.d = "Switching Protocols";
        ArrayList r5 = (ArrayList) r12.f16659a;
        r5.add(Constant.UPDATE_PATH);
        ArrayList r13 = (ArrayList) r12.f16660b;
        r13.add("websocket");
        r5.add("Connection");
        r13.add(Constant.UPDATE_PATH);
        r12.e = null;
        String r14 = b(r11, "Sec-WebSocket-Key");
        if (r14 != null) goto L36;
    L21:
        ck.a r15 = ((ck.b) r10.f9658c).b();
        OutputStream r16 = ((LocalSocket) r10.f9657b).getOutputStream();
        x0.d(r12, new f(new BufferedOutputStream(r16)));
        d r17 = new d(r15, r16, this.f16825a);
        if (r17.d.getAndSet(true) == true) goto L37;
        zm.c r18 = r17.f16828c;
        r18.getClass();
        Log.d("ChromeDevtoolsServer", "onOpen: ");
        ((bk.c) r18.f23470b).c(r17);
    L37:
        r17.f16826a.l(r17.f);     // Catch: IOException -> L26 EOFException -> L29
    L39:
        return false;
    L29:
        r17.c("EOF while reading");
        return false;
    L26:
        e = move-exception;
        r17.c(null);
        throw e;
    L36:
        String r19 = r14.concat(WebSocketProtocol.ACCEPT_MAGIC);     // Catch: NoSuchAlgorithmException -> L14
        MessageDigest r20 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L14
        int r21 = b.f16824a;     // Catch: NoSuchAlgorithmException -> L14
        r20.update(r19.getBytes("UTF-8"));     // Catch: NoSuchAlgorithmException -> L14
        String r22 = Base64.encodeToString(r20.digest(), 2);     // Catch: NoSuchAlgorithmException -> L14
        r5.add("Sec-WebSocket-Accept");
        r13.add(r22);
        goto L21
    L16:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: NoSuchAlgorithmException -> L14
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
