package com.bytedance.android.live.hostadapter.network.ws;

import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003JE\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\rHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00062"}, d2 = {"Lcom/bytedance/android/live/hostadapter/network/ws/Config;", "", LiveSlardarConstants.EXTRA_KEY_URL, "", "context", "Landroid/content/Context;", "listener", "Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;", "pingInterval", "", "retry", "", "retryTimes", "", "(Ljava/lang/String;Landroid/content/Context;Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;JZI)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getListener", "()Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;", "setListener", "(Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;)V", "getPingInterval", "()J", "setPingInterval", "(J)V", "getRetry", "()Z", "setRetry", "(Z)V", "getRetryTimes", "()I", "setRetryTimes", "(I)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class Config {
    private Context context;
    private ILiveWsListener listener;
    private long pingInterval;
    private boolean retry;
    private int retryTimes;
    private String url;

    public static /* synthetic */ Config copy$default(Config r5, String r6, Context r7, ILiveWsListener r8, long r9, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.url;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.context;
    L8:
        Context r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.listener;
    L11:
        ILiveWsListener r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.pingInterval;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.retry;
    L17:
        boolean r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.retryTimes;
    L20:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r3, r12);
    }

    public final String component1() {
        return this.url;
    }

    public final Context component2() {
        return this.context;
    }

    public final ILiveWsListener component3() {
        return this.listener;
    }

    public final long component4() {
        return this.pingInterval;
    }

    public final boolean component5() {
        return this.retry;
    }

    public final int component6() {
        return this.retryTimes;
    }

    public final Config copy(String r11, Context r12, ILiveWsListener r13, long r14, boolean r15, int r16) {
        Intrinsics.checkNotNullParameter(r11, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "listener");
        return new Config(r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof Config) == false) goto L18;
        Config r7 = (Config) r6;
        if (Intrinsics.areEqual(this.url, r7.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.context, r7.context) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.listener, r7.listener) == true) goto L12;
        return false;
    L12:
        if (this.pingInterval == r7.pingInterval) goto L14;
        return false;
    L14:
        if (this.retry == r7.retry) goto L16;
        return false;
    L16:
        if (this.retryTimes == r7.retryTimes) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Context r4 = this.context;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ILiveWsListener r7 = this.listener;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        long r9 = this.pingInterval;
        int r11 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        boolean r12 = this.retry;
        ?? r13 = r12;
        if (r12 == false) goto L17;
        r13 = 1;
    L17:
        return ((r11 + r13) * 31) + this.retryTimes;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Config(url=" + this.url + ", context=" + this.context + ", listener=" + this.listener + ", pingInterval=" + this.pingInterval + ", retry=" + this.retry + ", retryTimes=" + this.retryTimes + ")";
    }

    public final Context getContext() {
        return this.context;
    }

    public final ILiveWsListener getListener() {
        return this.listener;
    }

    public final long getPingInterval() {
        return this.pingInterval;
    }

    public final boolean getRetry() {
        return this.retry;
    }

    public final int getRetryTimes() {
        return this.retryTimes;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final void setListener(ILiveWsListener r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.listener = r2;
    }

    public final void setPingInterval(long r1) {
        this.pingInterval = r1;
    }

    public final void setRetry(boolean r1) {
        this.retry = r1;
    }

    public final void setRetryTimes(int r1) {
        this.retryTimes = r1;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    public Config(String r2, Context r3, ILiveWsListener r4, long r5, boolean r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.url = r2;
        this.context = r3;
        this.listener = r4;
        this.pingInterval = r5;
        this.retry = r7;
        this.retryTimes = r8;
    }
}
