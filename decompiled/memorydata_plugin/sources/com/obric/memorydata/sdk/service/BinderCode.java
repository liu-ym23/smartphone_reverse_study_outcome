package com.obric.memorydata.sdk.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/service/BinderCode;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CONTEXT", "MEMORY", "ASSISTANT_STATE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BinderCode extends Enum<BinderCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BinderCode[] $VALUES = null;
    public static final BinderCode ASSISTANT_STATE = null;
    public static final a Companion = null;
    public static final BinderCode MEMORY = null;
    public static final BinderCode REALTIME_CONTEXT = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/service/BinderCode$Companion;", "", "<init>", "()V", "fromOrdinal", "Lcom/obric/memorydata/sdk/service/BinderCode;", "ordinal", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final BinderCode a(int r2) {
            return (BinderCode) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(BinderCode.values(), r2), BinderCode.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ BinderCode[] $values() {
        return new BinderCode[]{REALTIME_CONTEXT, MEMORY, ASSISTANT_STATE};
    }

    static {
        REALTIME_CONTEXT = new BinderCode("REALTIME_CONTEXT", 0);
        MEMORY = new BinderCode("MEMORY", 1);
        ASSISTANT_STATE = new BinderCode("ASSISTANT_STATE", 2);
        BinderCode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private BinderCode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<BinderCode> getEntries() {
        return $ENTRIES;
    }

    public static BinderCode valueOf(String r2) {
        return (BinderCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(BinderCode.class, r2), BinderCode.class, "com.obric.memorydata.plugin");
    }

    public static BinderCode[] values() {
        return (BinderCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BinderCode[].class, "com.obric.memorydata.plugin");
    }
}
