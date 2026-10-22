package com.bytedance.geckox.policy.meta;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import va.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/geckox/policy/meta/MetaDataItemNew;", "Ljava/io/Serializable;", "", "lastReadTimeStamp", "", "allowUpdate", "lastCleanTimeStamp", "<init>", "(JZJ)V", "J", "getLastReadTimeStamp", "()J", "setLastReadTimeStamp", "(J)V", "Z", "getAllowUpdate", "()Z", "setAllowUpdate", "(Z)V", "getLastCleanTimeStamp", "setLastCleanTimeStamp", "Companion", "va/a", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class MetaDataItemNew implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 2;
    private boolean allowUpdate;
    private long lastCleanTimeStamp;
    private long lastReadTimeStamp;

    static {
        Companion = new a();
    }

    public MetaDataItemNew(long r5, boolean r10, long r11) {
        this.lastReadTimeStamp = r5;
        this.allowUpdate = r10;
        this.lastCleanTimeStamp = r11;
    }

    public final boolean getAllowUpdate() {
        return this.allowUpdate;
    }

    public final long getLastCleanTimeStamp() {
        return this.lastCleanTimeStamp;
    }

    public final long getLastReadTimeStamp() {
        return this.lastReadTimeStamp;
    }

    public final void setAllowUpdate(boolean r5) {
        this.allowUpdate = r5;
    }

    public final void setLastCleanTimeStamp(long r5) {
        this.lastCleanTimeStamp = r5;
    }

    public final void setLastReadTimeStamp(long r5) {
        this.lastReadTimeStamp = r5;
    }

    public /* synthetic */ MetaDataItemNew(long r10, boolean r11, long r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = true;
    L5:
        boolean r5 = r11;
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r5, r12);
    }
}
