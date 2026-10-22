package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectorBizCallbackConfig;", "", "enableBizCallback", "", "bizCrashPortraits", "", "Lcom/larus/settings/provider/bootprotector/BizCrashPortraits;", "<init>", "(ZLjava/util/List;)V", "getEnableBizCallback", "()Z", "getBizCrashPortraits", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BootProtectorBizCallbackConfig {

    @SerializedName("biz_crash_portraits")
    private final List<BizCrashPortraits> bizCrashPortraits;

    @SerializedName("enable_biz_callback")
    private final boolean enableBizCallback;

    public BootProtectorBizCallbackConfig() {
        List r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootProtectorBizCallbackConfig copy$default(BootProtectorBizCallbackConfig r0, boolean r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enableBizCallback;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.bizCrashPortraits;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enableBizCallback;
    }

    public final List<BizCrashPortraits> component2() {
        return this.bizCrashPortraits;
    }

    public final BootProtectorBizCallbackConfig copy(boolean r2, List<BizCrashPortraits> r3) {
        return new BootProtectorBizCallbackConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BootProtectorBizCallbackConfig) == true) goto L8;
        return false;
    L8:
        BootProtectorBizCallbackConfig r6 = (BootProtectorBizCallbackConfig) r5;
        if (this.enableBizCallback == r6.enableBizCallback) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizCrashPortraits, r6.bizCrashPortraits) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enableBizCallback == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        List<BizCrashPortraits> r2 = this.bizCrashPortraits;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "BootProtectorBizCallbackConfig(enableBizCallback=" + this.enableBizCallback + ", bizCrashPortraits=" + this.bizCrashPortraits + ')';
    }

    public final List<BizCrashPortraits> getBizCrashPortraits() {
        return this.bizCrashPortraits;
    }

    public final boolean getEnableBizCallback() {
        return this.enableBizCallback;
    }

    public BootProtectorBizCallbackConfig(boolean r1, List<BizCrashPortraits> r2) {
        this.enableBizCallback = r1;
        this.bizCrashPortraits = r2;
    }

    public /* synthetic */ BootProtectorBizCallbackConfig(boolean r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
