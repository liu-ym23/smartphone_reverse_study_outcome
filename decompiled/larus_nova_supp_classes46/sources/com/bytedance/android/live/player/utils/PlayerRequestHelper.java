package com.bytedance.android.live.player.utils;

import com.bytedance.android.livesdkapi.model.PlayerNameValuePair;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerApi;
import com.bytedance.android.livesdkapi.roomplayer.PlayerCall;
import com.bytedance.android.livesdkapi.roomplayer.PlayerHttpResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PlayerRequestHelper {
    public static final Lazy a = null;

    public static final class a implements PlayerCall<PlayerHttpResponse> {
        public final Call<TypedInput> a;
        public final boolean b;

        public final Object execute() {
            SsResponse r1 = this.a.execute();     // Catch: Exception -> L32
            TypedByteArray r2 = (TypedInput) r1.body();     // Catch: Exception -> L32
            if (r2 != null) goto L6;
            byte[] r3 = null;
            InputStream r4 = null;
        L21:
            if (r1.raw() == null) goto L23;
            String r5 = r1.raw().getReason();     // Catch: Exception -> L32
            String r6 = r1.raw().getUrl();     // Catch: Exception -> L32
        L24:
            List r7 = r1.headers();     // Catch: Exception -> L32
            ArrayList r8 = new ArrayList();     // Catch: Exception -> L32
            Iterator r9 = r7.iterator();     // Catch: Exception -> L32
        L26:
            if (r9.hasNext() == false) goto L28;
            Header r10 = (Header) r9.next();     // Catch: Exception -> L32
            r8.add(new PlayerNameValuePair(r10.getName(), r10.getValue()));     // Catch: Exception -> L32
            goto L26
        L28:
            PlayerHttpResponse r11 = new PlayerHttpResponse().setUrl(r6).setStatusCode(r1.code()).setReason(r5).setHeaders(r8).setBody(r3).setStream(r4);     // Catch: Exception -> L32
            if (r2 == null) goto L39;
            r11.setMimeType(r2.mimeType());     // Catch: Exception -> L32
        L39:
            return r11;
        L23:
            r6 = "";
            r5 = "no reason";
            goto L24
        L6:
            if (this.b == false) goto L9;
            r4 = r2.in();     // Catch: Exception -> L32
            r3 = null;
            goto L21
        L9:
            if ((r2 instanceof TypedByteArray) == false) goto L11;
            r3 = r2.getBytes();     // Catch: Exception -> L32
        L18:
            r4 = null;
            goto L21
        L11:
            InputStream r12 = r2.in();     // Catch: Exception -> L32
            ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Exception -> L32
            if (r12 == null) goto L17;
            byte[] r14 = new byte[4096];     // Catch: Exception -> L32
        L14:
            int r15 = r12.read(r14);     // Catch: Exception -> L32
            if (r15 == (-1)) goto L17;
            r13.write(r14, 0, r15);     // Catch: Exception -> L32
        L17:
            r3 = r13.toByteArray();     // Catch: Exception -> L32
        L32:
            e = move-exception;
            b.b(e.toString());
            return null;
        }

        public a(Call r2) {
            Intrinsics.checkNotNullParameter(r2, "call");
            this.a = r2;
            this.b = false;
        }
    }

    static {
        a = LazyKt.lazy(PlayerRequestHelper$playerApi$2.INSTANCE);
    }

    @JvmStatic
    public static final a a(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "map");
        StringBuilder r0 = new StringBuilder("playerApi@");
        Lazy r1 = a;
        r0.append((ILivePlayerApi) r1.getValue());
        r0.append(" execute ");
        r0.append(r3);
        b.b(r0.toString());
        ILivePlayerApi r2 = (ILivePlayerApi) r1.getValue();
        if (r2 == null) goto L9;
        Call r5 = r2.get(r3, r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        return new a(r5);
    L9:
        return null;
    }
}
