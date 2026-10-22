package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/album/FastSendFromShowType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "EVERY_COLD_LAUNCH", "FIRST_COLD_LAUNCH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum FastSendFromShowType extends Enum<FastSendFromShowType> {
    public static final FastSendFromShowType EVERY_COLD_LAUNCH = null;
    public static final FastSendFromShowType FIRST_COLD_LAUNCH = null;
    public static final /* synthetic */ FastSendFromShowType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<FastSendFromShowType> getEntries() {
        return b;
    }

    static {
        FastSendFromShowType r0 = new FastSendFromShowType("EVERY_COLD_LAUNCH", 0, 0);
        EVERY_COLD_LAUNCH = r0;
        FastSendFromShowType r1 = new FastSendFromShowType("FIRST_COLD_LAUNCH", 1, 1);
        FIRST_COLD_LAUNCH = r1;
        FastSendFromShowType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static FastSendFromShowType[] values() {
        return (FastSendFromShowType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static FastSendFromShowType valueOf(String r1) {
        return (FastSendFromShowType) a.a(FastSendFromShowType.class, r1);
    }

    public FastSendFromShowType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
