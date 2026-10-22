package com.obric.memorydata.ability.data;

import com.obric.memorydata.database.dao.MobileCellularDao;
import com.obric.memorydata.database.entity.dp;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0006\u00100\u001a\u000201J\b\u00102\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\rH\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\u0010\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u001a\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002012\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\rHÖ\u0001J\t\u0010<\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001b¨\u0006="}, d2 = {"Lcom/obric/memorydata/ability/data/MobileCellularStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "cellId", "", "<init>", "(Ljava/lang/Long;)V", "()V", "getCellId", "()Ljava/lang/Long;", "setCellId", "Ljava/lang/Long;", "dataId", "", "dataVersion", "timestamp", "lac", "getLac", "()Ljava/lang/Integer;", "setLac", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cellType", "", "getCellType", "()Ljava/lang/String;", "setCellType", "(Ljava/lang/String;)V", "rsrp", "getRsrp", "()I", "setRsrp", "(I)V", "pci", "getPci", "setPci", "carrierMcc", "getCarrierMcc", "setCarrierMcc", "carrierMnc", "getCarrierMnc", "setCarrierMnc", "carrierOperator", "getCarrierOperator", "setCarrierOperator", "carrierShortOperator", "getCarrierShortOperator", "setCarrierShortOperator", "isInvalidLac", "", "getDataId", "getDataVersion", "collectNewData", "component1", "copy", "(Ljava/lang/Long;)Lcom/obric/memorydata/ability/data/MobileCellularStandardData;", "equals", "other", "", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f8335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8336b;
    private final int c;
    private final long d;
    private Integer e;
    private String f;
    private int g;
    private int h;
    private String i;
    private String j;
    private String k;
    private String l;

    public l() {
        this(null);
    }

    public l(Long r3) {
        this.f8335a = r3;
        this.f8336b = 100000003;
        this.c = 1;
        this.d = System.currentTimeMillis();
        this.g = -1;
        this.h = -1;
        this.i = StructuredDataId.RESERVED;
        this.j = StructuredDataId.RESERVED;
    }

    public final Long a() {
        return this.f8335a;
    }

    public final void a(int r1) {
        this.g = r1;
    }

    public final void a(Integer r1) {
        this.e = r1;
    }

    public final void a(Long r1) {
        this.f8335a = r1;
    }

    public final void a(String r1) {
        this.f = r1;
    }

    public final Integer b() {
        return this.e;
    }

    public final void b(int r1) {
        this.h = r1;
    }

    public final void b(String r1) {
        this.i = r1;
    }

    public final String c() {
        return this.f;
    }

    public final void c(String r1) {
        this.j = r1;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        MobileCellularDao r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMobileCellularDao();
        int r3 = this.f8336b;
        int r4 = this.c;
        long r5 = this.d;
        Long r7 = this.f8335a;
        Intrinsics.checkNotNull(r7);
        long r8 = r7.longValue();
        Integer r9 = this.e;
        Intrinsics.checkNotNull(r9);
        int r10 = r9.intValue();
        String r11 = this.f;
        Intrinsics.checkNotNull(r11);
        int r12 = this.g;
        int r13 = this.h;
        String r14 = this.i;
        String r15 = this.j;
        String r2 = this.k;
        Intrinsics.checkNotNull(r2);
        String r0 = this.l;
        Intrinsics.checkNotNull(r0);
        return r1.insert(new dp(r3, r4, r5, r8, r10, r11, r12, r13, r14, r15, r2, r0, 0, 4096, null));
    }

    public final void d(String r1) {
        this.k = r1;
    }

    public final void e(String r1) {
        this.l = r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8335a, r6.f8335a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.f8336b;
    }

    public int hashCode() {
        Long r0 = this.f8335a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "MobileCellularStandardData(cellId=" + this.f8335a + ')';
    }
}
