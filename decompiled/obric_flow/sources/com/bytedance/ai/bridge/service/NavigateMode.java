package com.bytedance.ai.bridge.service;

import java.util.LinkedHashMap;
import k2.d;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/bridge/service/NavigateMode;", "", "k2/d", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIHostMapDepend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IHostMapDepend.kt\ncom/bytedance/ai/bridge/service/NavigateMode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,63:1\n8578#2,2:64\n8838#2,4:66\n*S KotlinDebug\n*F\n+ 1 IHostMapDepend.kt\ncom/bytedance/ai/bridge/service/NavigateMode\n*L\n11#1:64,2\n11#1:66,4\n*E\n"})
public final enum NavigateMode extends Enum<NavigateMode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f2079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f2080c = null;
    public static final NavigateMode d = null;
    public static final NavigateMode e = null;
    public static final /* synthetic */ NavigateMode[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2081a;

    static {
        int r5 = 0;
        NavigateMode r10 = new NavigateMode("DRIVING", 0, "driving");
        d = r10;
        NavigateMode r11 = new NavigateMode("TRANSIT", 1, "transit");
        NavigateMode r12 = new NavigateMode("WALKING", 2, "walking");
        NavigateMode r13 = new NavigateMode("RIDING", 3, "riding");
        e = r13;
        NavigateMode[] r14 = {r10, r11, r12, r13};
        f = r14;
        EnumEntriesKt.enumEntries(r14);
        f2079b = new d();
        NavigateMode[] r15 = values();
        LinkedHashMap r16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r15.length), 16));
        int r17 = r15.length;
    L3:
        if (r5 >= r17) goto L5;
        NavigateMode r18 = r15[r5];
        r16.put(r18.f2081a, r18);
        r5 = r5 + 1;
        goto L3
    L5:
        f2080c = r16;
    }

    public NavigateMode(String r5, int r10, String r11) {
        super(r5, r10);
        this.f2081a = r11;
    }

    public static NavigateMode valueOf(String r5) {
        return (NavigateMode) Enum.valueOf(NavigateMode.class, r5);
    }

    public static NavigateMode[] values() {
        return (NavigateMode[]) f.clone();
    }
}
