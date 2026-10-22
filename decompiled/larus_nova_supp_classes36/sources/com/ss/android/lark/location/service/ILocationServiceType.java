package com.ss.android.lark.location.service;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/location/service/ILocationServiceType;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "SERVICE_AMAP", "SERVICE_GOOGLE_BING", "SERVICE_GOOGLE", "SERVICE_BINGMAP", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ILocationServiceType extends Enum<ILocationServiceType> {
    public static final ILocationServiceType SERVICE_AMAP = null;
    public static final ILocationServiceType SERVICE_BINGMAP = null;
    public static final ILocationServiceType SERVICE_GOOGLE = null;
    public static final ILocationServiceType SERVICE_GOOGLE_BING = null;
    public static final /* synthetic */ ILocationServiceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int priority;

    public static EnumEntries<ILocationServiceType> getEntries() {
        return b;
    }

    static {
        ILocationServiceType r0 = new ILocationServiceType("SERVICE_AMAP", 0, 10);
        SERVICE_AMAP = r0;
        ILocationServiceType r1 = new ILocationServiceType("SERVICE_GOOGLE_BING", 1, 20);
        SERVICE_GOOGLE_BING = r1;
        ILocationServiceType r2 = new ILocationServiceType("SERVICE_GOOGLE", 2, 30);
        SERVICE_GOOGLE = r2;
        ILocationServiceType r4 = new ILocationServiceType("SERVICE_BINGMAP", 3, 40);
        SERVICE_BINGMAP = r4;
        ILocationServiceType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static ILocationServiceType[] values() {
        return (ILocationServiceType[]) a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public static ILocationServiceType valueOf(String r1) {
        return (ILocationServiceType) r27.a.a(ILocationServiceType.class, r1);
    }

    public ILocationServiceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }
}
