package com.obric.memorydata.datatransport.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0003J\b\u0010.\u001a\u00020\u0003H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001b¨\u0006/"}, d2 = {"Lcom/obric/memorydata/datatransport/entity/ConstructedCallHistoryEntity;", "Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "telephones", "", "contacts", "Lcom/obric/memorydata/datatransport/entity/ConstructedContactEntity;", "callType", "duration", "", LocationMonitorConst.TAG, "isAIPickup", "", "hasTranscript", "transcript", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;)V", "getTelephones", "()Ljava/util/List;", "getContacts", "getCallType", "()Ljava/lang/String;", "setCallType", "(Ljava/lang/String;)V", "getDuration", "()I", "setDuration", "(I)V", "getTag", "setTag", "()Z", "setAIPickup", "(Z)V", "getHasTranscript", "setHasTranscript", "getTranscript", "setTranscript", "toOriginalAppEntity", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "mapStringToCallTypeEnum", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "callTypeString", "generateEvaluationId", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f9718b;
    private final List<c> c;
    private String d;
    private int e;
    private String f;
    private boolean g;
    private boolean h;
    private String i;

    public final CallTypeEnum a(String r1) {
        if (r1 != null) goto L4;
    L22:
        return null;
    L4:
        switch(r1.hashCode()) {
            case 775246725: goto L19;
            case 775319885: goto L15;
            case 818143843: goto L11;
            case 818217003: goto L7;
            default: goto L22;
        };
    L7:
        if (r1.equals("来电未接") == false) goto L22;
        return CallTypeEnum.INCOMING_CALL_MISSED;
    L11:
        if (r1.equals("来电已接") == false) goto L22;
        return CallTypeEnum.INCOMING_CALL_ANSWERED;
    L15:
        if (r1.equals("拨出未接") == false) goto L22;
        return CallTypeEnum.OUTGOING_CALL_MISSED;
    L19:
        if (r1.equals("拨出已接") == false) goto L22;
        return CallTypeEnum.OUTGOING_CALL_ANSWERED;
    }

    @Override // com.obric.memorydata.datatransport.a.a
    public /* synthetic */ AppEntity d() {
        return (AppEntity) ZeusTransformUtils.preCheckCast(e(), AppEntity.class, "com.obric.memorydata.plugin");
    }

    public CallHistoryEntity e() {
        List<c> r0 = this.c;
        if (r0 == null) goto L9;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin")).e());
        goto L6
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L10:
        List r8 = r4;
        String r5 = a();
        if (r5 != null) goto L13;
        r5 = "0";
    L13:
        String r6 = r5;
        Long r7 = b();
        long r9 = 0;
        if (r7 == null) goto L16;
        long r10 = r7.longValue();
    L17:
        Long r11 = c();
        if (r11 == null) goto L20;
        r9 = r11.longValue();
    L20:
        long r12 = r9;
        List<String> r13 = this.f9718b;
        CallTypeEnum r14 = a(this.d);
        if (r14 != null) goto L23;
        r14 = CallTypeEnum.INCOMING_CALL_ANSWERED;
    L23:
        CallHistoryEntity r15 = new CallHistoryEntity(r6, r10, r12, r13, r8, r14, this.e);
        r15.setTag(this.f);
        r15.setAIPickup(this.g);
        r15.setHasTranscript(this.h);
        r15.setTranscript(this.i);
        return r15;
    L16:
        r10 = 0;
        goto L17
    L9:
        r4 = null;
        goto L10
    }
}
