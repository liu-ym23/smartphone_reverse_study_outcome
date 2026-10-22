package com.larus.dora.api.model;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraSubBizType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OLA_FRIEND", "E", "G1_G2", "LORY_B", "H", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowDoraSubBizType extends Enum<FlowDoraSubBizType> {
    public static final a Companion = null;

    @SerializedName("2")
    public static final FlowDoraSubBizType E = null;

    @SerializedName("3")
    public static final FlowDoraSubBizType G1_G2 = null;

    @SerializedName("5")
    public static final FlowDoraSubBizType H = null;

    @SerializedName("4")
    public static final FlowDoraSubBizType LORY_B = null;

    @SerializedName("1")
    public static final FlowDoraSubBizType OLA_FRIEND = null;
    public static final /* synthetic */ FlowDoraSubBizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public static int a() {
            IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            Integer r1 = null;
            if (r0 == null) goto L5;
            DeviceService r2 = r0.device();
        L6:
            if (r2 == null) goto L9;
            r1 = Integer.valueOf(r2.y());
        L9:
            return b(r1);
        L5:
            r2 = null;
            goto L6
        }

        public a() {
        }

        public static int b(Integer r3) {
            boolean r0 = false;
            if (r3 != null) goto L6;
        L7:
            if (r3 != null) goto L10;
        L12:
            if (r3 != null) goto L15;
        L17:
            if (r3 != null) goto L20;
        L22:
            if (r3 != null) goto L25;
            return 0;
        L25:
            if (r3.intValue() == 17) goto L42;
            return 0;
        L42:
            return FlowDoraSubBizType.G1_G2.getValue();
        L20:
            if (r3.intValue() != 16) goto L22;
            return FlowDoraSubBizType.G1_G2.getValue();
        L15:
            if (r3.intValue() != 2) goto L17;
            return FlowDoraSubBizType.E.getValue();
        L10:
            if (r3.intValue() != 0) goto L12;
        L27:
            IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r4 == null) goto L34;
            DeviceService r5 = r4.device();
            if (r5 == null) goto L34;
            if (r5.f() != true) goto L34;
            r0 = true;
        L34:
            if (r0 == false) goto L36;
            FlowDoraSubBizType r6 = FlowDoraSubBizType.H;
        L38:
            return r6.getValue();
        L36:
            r6 = FlowDoraSubBizType.OLA_FRIEND;
            goto L38
        L6:
            if (r3.intValue() == 1) goto L27;
            goto L7
        }
    }

    public static EnumEntries<FlowDoraSubBizType> getEntries() {
        return b;
    }

    static {
        FlowDoraSubBizType r0 = new FlowDoraSubBizType("OLA_FRIEND", 0, 1);
        OLA_FRIEND = r0;
        FlowDoraSubBizType r1 = new FlowDoraSubBizType("E", 1, 2);
        E = r1;
        FlowDoraSubBizType r4 = new FlowDoraSubBizType("G1_G2", 2, 3);
        G1_G2 = r4;
        FlowDoraSubBizType r6 = new FlowDoraSubBizType("LORY_B", 3, 4);
        LORY_B = r6;
        FlowDoraSubBizType r8 = new FlowDoraSubBizType("H", 4, 5);
        H = r8;
        FlowDoraSubBizType[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static FlowDoraSubBizType[] values() {
        return (FlowDoraSubBizType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowDoraSubBizType valueOf(String r1) {
        return (FlowDoraSubBizType) r27.a.a(FlowDoraSubBizType.class, r1);
    }

    public FlowDoraSubBizType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
