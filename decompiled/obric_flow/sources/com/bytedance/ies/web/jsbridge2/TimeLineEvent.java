package com.bytedance.ies.web.jsbridge2;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class TimeLineEvent implements Serializable {
    private final long elapsedTimestamp;
    private final HashMap<String, Object> extra;
    private final String label;
    private final String message;
    private final String time;
    private final long timeInMillis;

    public /* synthetic */ TimeLineEvent(t r5, s r10) {
        this(r5);
    }

    public long getElapsedTimestamp() {
        return this.elapsedTimestamp;
    }

    public HashMap<String, Object> getExtra() {
        return this.extra;
    }

    public String getLabel() {
        return this.label;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTime() {
        return this.time;
    }

    public long getTimeInMillis() {
        return this.timeInMillis;
    }

    private TimeLineEvent(t r5) {
        this.label = r5.f6307a;
        this.message = null;
        this.time = r5.f6308b;
        this.extra = r5.e;
        this.elapsedTimestamp = r5.d;
        this.timeInMillis = r5.f6309c;
    }
}
