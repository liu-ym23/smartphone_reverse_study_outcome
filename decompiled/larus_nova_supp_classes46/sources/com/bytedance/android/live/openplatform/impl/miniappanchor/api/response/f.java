package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("open.private.im_api.GetPrivateMsgTabInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/f;", "", "", "statusCode", "I", "b", "()I", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "tabText", "d", "tabStatus", "getTabStatus", "tabDesc", "c", "settingDesc", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("setting_desc")
    protected String settingDesc;

    @SerializedName("status_code")
    protected int statusCode;

    @SerializedName("status_msg")
    protected String statusMsg;

    @SerializedName("tab_desc")
    protected String tabDesc;

    @SerializedName("tab_status")
    protected int tabStatus;

    @SerializedName("tab_text")
    protected String tabText;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L18;
        f r4 = (f) r3;
        if (this.statusCode == r4.statusCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r4.statusMsg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabText, r4.tabText) == true) goto L12;
        return false;
    L12:
        if (this.tabStatus == r4.tabStatus) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tabDesc, r4.tabDesc) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.settingDesc, r4.settingDesc) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = this.statusCode * 31;
        String r1 = this.statusMsg;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.tabText;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.tabStatus) * 31;
        String r8 = this.tabDesc;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.settingDesc;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "GetPrivateMsgTabInfoResponse(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", tabText=" + this.tabText + ", tabStatus=" + this.tabStatus + ", tabDesc=" + this.tabDesc + ", settingDesc=" + this.settingDesc + ")";
    }

    public final boolean e() {
        if (this.tabStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public f() {
        this.statusCode = 0;
        this.statusMsg = null;
        this.tabText = null;
        this.tabStatus = 0;
        this.tabDesc = null;
        this.settingDesc = null;
    }

    public final String a() {
        return this.settingDesc;
    }

    public final int b() {
        return this.statusCode;
    }

    public final String c() {
        return this.tabDesc;
    }

    public final String d() {
        return this.tabText;
    }

    public f(am3.g r7) {
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L13;
        switch(r4) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.settingDesc = am3.h.c(r7);
        goto L3
    L8:
        this.tabStatus = r7.i();
        r3 = r3 | 2;
        goto L3
    L9:
        this.tabDesc = am3.h.c(r7);
        goto L3
    L10:
        this.tabText = am3.h.c(r7);
        goto L3
    L11:
        this.statusMsg = am3.h.c(r7);
        goto L3
    L12:
        this.statusCode = (int) r7.j();
        r3 = r3 | 1;
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L13:
        r7.d(r0);
        if ((r3 & 1) != 0) goto L17;
        this.statusCode = 0;
    L17:
        if (this.statusMsg != null) goto L20;
        this.statusMsg = null;
    L20:
        if (this.tabText != null) goto L23;
        this.tabText = null;
    L23:
        if ((r3 & 2) != 0) goto L26;
        this.tabStatus = 0;
    L26:
        if (this.tabDesc != null) goto L29;
        this.tabDesc = null;
    L29:
        if (this.settingDesc != null) goto L48;
        this.settingDesc = null;
        return;
    }
}
