package ylc;

import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncMessage;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements tlc.d {
    public final long a;
    public final long b;
    public final Long c;
    public final Integer d;
    public final String e;
    public boolean f;
    public final int g;
    public final Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> h;

    @Override // tlc.d
    public final long getDelayDispatchMs() {
        return 0;
    }

    @Override // tlc.d
    public final int getMessageFrom() {
        return -1;
    }

    @Override // tlc.d
    public final boolean isGlobalMessage() {
        return false;
    }

    @Override // tlc.d
    public final boolean needMonitor() {
        return false;
    }

    @Override // tlc.d
    public final void setConsumeTime(long r1) {
    }

    @Override // tlc.d
    public final void setDecodeEndTime(long r1) {
    }

    @Override // tlc.d
    public final void setDecodeStartTime(long r1) {
    }

    @Override // tlc.d
    public final void setEnqueueDispatchTime(long r1) {
    }

    @Override // tlc.d
    public final void setHttpSendTime(long r1) {
    }

    @Override // tlc.d
    public final void setIsInsert(boolean r1) {
    }

    @Override // tlc.d
    public final void setMessageMethod(String r1) {
    }

    @Override // tlc.d
    public final void setReceiveTime(long r1) {
    }

    @Override // tlc.d
    public final int getGeneralMessageType() {
        return this.d.intValue();
    }

    @Override // tlc.d
    public final long getMessageId() {
        return this.c.longValue();
    }

    @Override // tlc.d
    public final int getIntType() {
        return this.g;
    }

    @Override // tlc.d
    public final String getMessageMethod() {
        return this.e;
    }

    @Override // tlc.d
    public final long getRoomId() {
        return this.a;
    }

    @Override // tlc.d
    public final boolean isFromFirstRequest() {
        return this.f;
    }

    @Override // tlc.d
    public final void setIsFromFirstRequest(boolean r1) {
        this.f = r1;
    }

    public f(int r5, SdkMessage r6, WebcastRoomDataSyncMessage r7, Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r8) {
        Intrinsics.checkNotNullParameter(r6, "sdkMessage");
        Intrinsics.checkNotNullParameter(r7, "dataSyncMessage");
        Intrinsics.checkNotNullParameter(r8, "roomDataSyncs");
        this.g = r5;
        this.h = r8;
        Long r9 = r7.roomID;
        long r0 = 0;
        if (r9 == null) goto L5;
        long r2 = r9.longValue();
    L6:
        this.a = r2;
        Long r10 = r7.common.channel_id;
        if (r10 == null) goto L9;
        r0 = r10.longValue();
    L9:
        this.b = r0;
        this.c = r6.msg_id;
        this.d = r6.msg_type;
        this.e = r6.method;
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
