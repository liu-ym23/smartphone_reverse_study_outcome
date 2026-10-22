package com.bytedance.android.ec.core.hybrid.model;

import com.bytedance.android.ec.core.opt.ab.p;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB%\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\f\u001a\u00020\u0006HÖ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/model/ECPreProcessorJsbOptConfig;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "", "", "component2", com.bytedance.android.ec.core.event.a.VALUE_OPEN, "blackList", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/android/ec/core/hybrid/model/ECPreProcessorJsbOptConfig;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getOpen", "setOpen", "(Ljava/lang/Integer;)V", "Ljava/util/List;", "getBlackList", "()Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPreProcessorJsbOptConfig implements Serializable {
    public static final a Companion = null;
    public static final ECPreProcessorJsbOptConfig a = null;

    @SerializedName("black_list")
    private final List<String> blackList;

    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_OPEN)
    private Integer open;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPreProcessorJsbOptConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPreProcessorJsbOptConfig copy$default(ECPreProcessorJsbOptConfig r0, Integer r1, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.open;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.blackList;
    L9:
        return r0.copy(r1, r10);
    }

    public final Integer component1() {
        return this.open;
    }

    public final List<String> component2() {
        return this.blackList;
    }

    public final ECPreProcessorJsbOptConfig copy(Integer r10, List<String> r11) {
        return new ECPreProcessorJsbOptConfig(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ECPreProcessorJsbOptConfig) == false) goto L10;
        ECPreProcessorJsbOptConfig r11 = (ECPreProcessorJsbOptConfig) r10;
        if (Intrinsics.areEqual(this.open, r11.open) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.blackList, r11.blackList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.open;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<String> r12 = this.blackList;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "ECPreProcessorJsbOptConfig(open=" + this.open + ", blackList=" + this.blackList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new a();
        int r0 = zg.a.a;
        int r1 = p.a;
        Integer r10 = null;
        Object[] r11 = 0 == true ? 1 : 0;
        Object r12 = new ECPreProcessorJsbOptConfig(r10, r11, 3, 0 == true ? 1 : 0);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L7
        b r14 = b.b;     // Catch: Throwable -> L7
        Object r15 = jj4.a.a("ec_preprocessor_jsb_opt", ECPreProcessorJsbOptConfig.class, r12, false);     // Catch: Throwable -> L7
        if (r15 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        a = (ECPreProcessorJsbOptConfig) r15;
        return;
    L7:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r17) == true) goto L12;
        r12 = r17;
    L12:
        r15 = r12;
        goto L13
    }

    public static final /* synthetic */ ECPreProcessorJsbOptConfig access$getCONFIG$cp() {
        return a;
    }

    public final List<String> getBlackList() {
        return this.blackList;
    }

    public final Integer getOpen() {
        return this.open;
    }

    public final void setOpen(Integer r1) {
        this.open = r1;
    }

    public ECPreProcessorJsbOptConfig(Integer r1, List<String> r10) {
        this.open = r1;
        this.blackList = r10;
    }

    public /* synthetic */ ECPreProcessorJsbOptConfig(Integer r1, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, r10);
    }
}
