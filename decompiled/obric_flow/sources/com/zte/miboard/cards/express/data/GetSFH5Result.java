package com.zte.miboard.cards.express.data;

import android.text.TextUtils;
import android.webkit.URLUtil;
import c.s0;

/* JADX INFO: loaded from: classes3.dex */
public class GetSFH5Result {
    public Data data;
    public String message;
    public int result;

    public class Data {
        public long expires;
        final /* synthetic */ GetSFH5Result this$0;
        public String url;

        public Data(GetSFH5Result r5) {
            this.this$0 = r5;
        }

        public boolean isAvailable() {
            String r5 = this.url;
            boolean r10 = s0.f1083a;
            if (TextUtils.isEmpty(r5) == false) goto L5;
            boolean r11 = false;
        L6:
            if (r11 == true) goto L8;
            return false;
        L8:
            if (this.expires <= 0) goto L12;
            return true;
        L12:
            return false;
        L5:
            r11 = URLUtil.isNetworkUrl(r5);
            goto L6
        }
    }

    public GetSFH5Result() {
    }

    public long getExpiresTimeLong() {
        Data r5 = this.data;
        if (r5 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r5.expires <= 0) goto L8;
        long r10 = System.currentTimeMillis();
        return (this.data.expires * 1000) + r10;
    }

    public boolean isAvailable() {
        if (this.result != 0) goto L9;
        Data r5 = this.data;
        if (r5 == null) goto L9;
        if (r5.isAvailable() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getClass().getSimpleName());
        r5.append("{result=");
        r5.append(this.result);
        r5.append(",message=");
        r5.append(this.message);
        r5.append(", expires=");
        Data r10 = this.data;
        if (r10 == null) goto L5;
        Long r11 = Long.valueOf(r10.expires);
    L6:
        r5.append(r11);
        r5.append("}");
        return r5.toString();
    L5:
        r11 = null;
        goto L6
    }
}
