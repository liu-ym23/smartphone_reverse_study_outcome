package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/BitrateStruct;", "", "GearName", "", "Bitrate", "", "QualityType", "PlayAddr", "Lcom/ss/ugc/effectplatform/model/net/UrlStruct;", "PlayAddrH265", "CodecType", "PlayAddrByteVC1", "HdrType", "HdrBit", "FPS", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/UrlStruct;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class BitrateStruct {
    public Integer Bitrate;
    public String CodecType;
    public Long FPS;
    public String GearName;
    public String HdrBit;
    public String HdrType;
    public UrlStruct PlayAddr;
    public UrlStruct PlayAddrByteVC1;
    public UrlStruct PlayAddrH265;
    public Integer QualityType;

    public BitrateStruct() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public BitrateStruct(String r1, Integer r2, Integer r3, UrlStruct r4, UrlStruct r5, String r6, UrlStruct r7, String r8, String r9, Long r10) {
        this.GearName = r1;
        this.Bitrate = r2;
        this.QualityType = r3;
        this.PlayAddr = r4;
        this.PlayAddrH265 = r5;
        this.CodecType = r6;
        this.PlayAddrByteVC1 = r7;
        this.HdrType = r8;
        this.HdrBit = r9;
        this.FPS = r10;
    }

    public /* synthetic */ BitrateStruct(String r12, Integer r13, Integer r14, UrlStruct r15, UrlStruct r16, String r17, UrlStruct r18, String r19, String r20, Long r21, int r22, DefaultConstructorMarker r23) {
        Long r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        UrlStruct r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        UrlStruct r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        UrlStruct r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
