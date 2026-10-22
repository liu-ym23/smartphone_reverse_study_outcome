package com.bytedance.android.livesdk.interactivity.publicscreen.framework;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements t {
    public String a;
    public boolean b;
    public long c;
    public String d;

    public final boolean canText() {
        return true;
    }

    public final m0 getBaseMessage() {
        return null;
    }

    public final long getConsumeTime() {
        return 0;
    }

    public final long getDelayDispatchMs() {
        return 0;
    }

    public final int getGeneralMessageType() {
        return 0;
    }

    public final long getHttpSendTime() {
        return 0;
    }

    public final int getIntType() {
        return 0;
    }

    public final Map<String, String> getMessageExtra() {
        return null;
    }

    public final int getMessageFrom() {
        return 0;
    }

    public final long getMessageId() {
        return 0;
    }

    public final byte[] getRawPayload() {
        return null;
    }

    public final long getReceiveTime() {
        return 0;
    }

    public final long getRoomId() {
        return 0;
    }

    public final long getTimestamp() {
        return 0;
    }

    public final boolean isCurrentRoom(long r1) {
        return true;
    }

    public final boolean isFirstHistoryMessage() {
        return false;
    }

    public final boolean isFromFirstRequest() {
        return false;
    }

    public final boolean isFromOtherIntercomRoom() {
        return false;
    }

    public final boolean isGlobalMessage() {
        return false;
    }

    public final boolean isInsert() {
        return false;
    }

    public final boolean needMonitor() {
        return false;
    }

    public final void setConsumeTime(long r1) {
    }

    public final void setDecodeEndTime(long r1) {
    }

    public final void setDecodeStartTime(long r1) {
    }

    public final void setEnqueueDispatchTime(long r1) {
    }

    public final void setHttpSendTime(long r1) {
    }

    public final void setIsFirstHistoryMessage(boolean r1) {
    }

    public final void setIsFromFirstRequest(boolean r1) {
    }

    public final void setIsInsert(boolean r1) {
    }

    public final void setReceiveTime(long r1) {
    }

    public final void setTooMuchMsg(boolean r1) {
    }

    public final boolean supportDisplayText() {
        return false;
    }

    public a() {
        this.a = "--default--";
    }

    public final String getMessageMethod() {
        return this.a;
    }

    public final String getWRDSKey() {
        return this.a;
    }

    public final String getWRDSSubKey() {
        return this.d;
    }

    public final long getWRDSVersion() {
        return this.c;
    }

    public final boolean isWRDSMessage() {
        return this.b;
    }

    public final void setMessageMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        this.a = r2;
    }

    public final void setWRDSMessage(boolean r1) {
        this.b = r1;
    }

    public final void setWRDSSubKey(String r1) {
        this.d = r1;
    }

    public final void setWRDSVersion(long r1) {
        this.c = r1;
    }
}
