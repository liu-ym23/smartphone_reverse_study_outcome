package com.bytedance.android.live.network;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.NameValuePair;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static class a {
        public String a;
        public final List<NameValuePair> b;

        public final String a() {
            if (TextUtils.isEmpty(this.a) == false) goto L12;
            return "";
        L12:
            URI r0 = b(this.a);     // Catch: Exception -> L11
            if (r0 == null) goto L14;
            return r0.getPath();
        L14:
            return "";
        L15:
            return "";
        }

        public static URI b(String r3) throws RuntimeException {
            if (r3 != null) goto L5;
        L22:
            return null;
        L5:
            if (r3.isEmpty() == true) goto L22;
            return new URI(r3);
        L9:
            return URI.create(r3.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        L12:
            if (r3.isEmpty() == true) goto L28;
            int r0 = r3.indexOf("?");     // Catch: Exception -> L19
            if (r0 <= 0) goto L17;
            r3 = r3.substring(0, r0);     // Catch: Exception -> L19
        L17:
            return URI.create(r3);
        L19:
            e = move-exception;
            throw new RuntimeException(e);
        L28:
            return null;
        }

        public a(String r1, List<NameValuePair> r2) {
            this.a = r1;
            if (r2 != null) goto L6;
            r2 = new ArrayList();
        L6:
            this.b = r2;
        }
    }
}
