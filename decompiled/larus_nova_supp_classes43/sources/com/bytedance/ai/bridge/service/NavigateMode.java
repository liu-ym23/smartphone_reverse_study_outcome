package com.bytedance.ai.bridge.service;

import com.bytedance.ai.api.navi.AppletNaviType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/service/NavigateMode;", "", "mode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMode", "()Ljava/lang/String;", "DRIVING", "TRANSIT", "WALKING", "RIDING", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigateMode extends Enum<NavigateMode> {
    public static final a Companion = null;
    public static final NavigateMode DRIVING = null;
    public static final NavigateMode RIDING = null;
    public static final NavigateMode TRANSIT = null;
    public static final NavigateMode WALKING = null;
    public static final Map<String, NavigateMode> a = null;
    public static final /* synthetic */ NavigateMode[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final String mode;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<NavigateMode> getEntries() {
        return c;
    }

    static {
        int r10 = 0;
        NavigateMode r0 = new NavigateMode("DRIVING", 0, AppletNaviType.DRIVING);
        DRIVING = r0;
        NavigateMode r1 = new NavigateMode("TRANSIT", 1, AppletNaviType.TRANSIT);
        TRANSIT = r1;
        NavigateMode r11 = new NavigateMode("WALKING", 2, AppletNaviType.WALKING);
        WALKING = r11;
        NavigateMode r12 = new NavigateMode("RIDING", 3, AppletNaviType.RIDING);
        RIDING = r12;
        NavigateMode[] r13 = {r0, r1, r11, r12};
        b = r13;
        c = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
        NavigateMode[] r14 = values();
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r14.length), 16));
        int r16 = r14.length;
    L3:
        if (r10 >= r16) goto L5;
        NavigateMode r17 = r14[r10];
        r15.put(r17.mode, r17);
        r10 = r10 + 1;
        goto L3
    L5:
        a = r15;
    }

    public static NavigateMode[] values() {
        return (NavigateMode[]) b.clone();
    }

    public static final /* synthetic */ Map access$getModeMap$cp() {
        return a;
    }

    public final String getMode() {
        return this.mode;
    }

    public static NavigateMode valueOf(String r1) {
        return (NavigateMode) r27.a.a(NavigateMode.class, r1);
    }

    public NavigateMode(String r1, int r10, String r11) {
        super(r1, r10);
        this.mode = r11;
    }
}
