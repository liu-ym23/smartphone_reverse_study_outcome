package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/address/x;", "", "", "Lcom/bytedance/android/ec/core/address/a0;", "mainBtmList", "Ljava/util/List;", "getMainBtmList", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/address/i0;", "ruleList", "getRuleList", "Lcom/bytedance/android/ec/core/address/b0;", "btmTraceConfig", "Lcom/bytedance/android/ec/core/address/b0;", "c", "()Lcom/bytedance/android/ec/core/address/b0;", "", "virtualStackSize", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "", "useVirtualStack", "Z", "d", "()Z", "effectRequestTag", "Ljava/lang/Boolean;", "getEffectRequestTag", "()Ljava/lang/Boolean;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {
    public Map<String, a0> a;
    public i0[][] b;

    @SerializedName("btm_trace_config")
    private final b0 btmTraceConfig;

    @SerializedName("effect_request_tag")
    private final Boolean effectRequestTag;

    @SerializedName("main_btm_list")
    private final List<a0> mainBtmList;

    @SerializedName("rule_list")
    private final List<i0> ruleList;

    @SerializedName("use_virtual_stack")
    private final boolean useVirtualStack;

    @SerializedName("virtual_stack_size")
    private final Integer virtualStackSize;

    public x() {
        this(null);
    }

    public final b0 c() {
        return this.btmTraceConfig;
    }

    public final boolean d() {
        return this.useVirtualStack;
    }

    public final Integer e() {
        return this.virtualStackSize;
    }

    public x(Object r10) {
        Boolean r11 = Boolean.FALSE;
        this.mainBtmList = null;
        this.ruleList = null;
        this.btmTraceConfig = null;
        this.virtualStackSize = null;
        this.useVirtualStack = false;
        this.effectRequestTag = r11;
    }

    public final a0 a(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.a != null) goto L16;
        LinkedHashMap r1 = new LinkedHashMap();
        List<a0> r11 = this.mainBtmList;
        if (r11 == null) goto L15;
        Iterator<T> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        a0 r13 = (a0) r12.next();
        if (r13.a() == null) goto L11;
        r1.put(r13.a(), r13);
    L15:
        Unit r14 = Unit.INSTANCE;
        this.a = r1;
    L16:
        Map<String, a0> r15 = this.a;
        if (r15 != null) goto L19;
        return null;
    L19:
        return r15.get(r10);
    }

    public final Integer b(int r10, int r11) {
        if (this.b != null) goto L26;
        i0[][] r12 = new i0[3][];
        int r13 = 0;
    L5:
        if (r13 >= 3) goto L10;
        i0[] r14 = new i0[3];
        int r15 = 0;
    L7:
        if (r15 >= 3) goto L9;
        r14[r15] = null;
        r15 = r15 + 1;
        goto L7
    L9:
        r12[r13] = r14;
        r13 = r13 + 1;
        goto L5
    L10:
        List<i0> r0 = this.ruleList;
        if (r0 == null) goto L25;
        Iterator<T> r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L25;
        i0 r16 = (i0) r1.next();
        int r17 = r16.a();
        if (r17 < 0) goto L14;
        if (2 < r17) goto L14;
        int r18 = r16.b();
        if (r18 < 0) goto L14;
        if (2 < r18) goto L14;
        r12[r16.a()][r16.b()] = r16;
    L25:
        this.b = r12;
    L26:
        i0[][] r19 = this.b;
        if (r19 == null) goto L47;
        i0[] r20 = (i0[]) ArraysKt.getOrNull(r19, r10);
        if (r20 == null) goto L48;
        i0 r21 = (i0) ArraysKt.getOrNull(r20, r11);
        if (r21 != null) goto L33;
        return null;
    L33:
        return Integer.valueOf(r21.c());
    L48:
        return null;
    L47:
        return null;
    }
}
