package com.bytedance.android.ec.adapter.api.handler.viewinterface.sti;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/handler/viewinterface/sti/IECExternalEntryEvent;", "", "Start", "End", "Skip", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IECExternalEntryEvent extends Enum<IECExternalEntryEvent> {
    public static final IECExternalEntryEvent End = null;
    public static final IECExternalEntryEvent Skip = null;
    public static final IECExternalEntryEvent Start = null;
    public static final /* synthetic */ IECExternalEntryEvent[] a = null;

    static {
        IECExternalEntryEvent r1 = new IECExternalEntryEvent("Start", 0);
        Start = r1;
        IECExternalEntryEvent r10 = new IECExternalEntryEvent("End", 1);
        End = r10;
        IECExternalEntryEvent r11 = new IECExternalEntryEvent("Skip", 2);
        Skip = r11;
        a = new IECExternalEntryEvent[]{r1, r10, r11};
    }

    public static IECExternalEntryEvent valueOf(String r1) {
        return (IECExternalEntryEvent) a.a(IECExternalEntryEvent.class, r1);
    }

    public static IECExternalEntryEvent[] values() {
        return (IECExternalEntryEvent[]) a.clone();
    }

    public IECExternalEntryEvent(String r1, int r10) {
        super(r1, r10);
    }
}
