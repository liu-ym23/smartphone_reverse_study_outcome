package com.bytedance.android.live.openplatform.impl.miniappaudience.api.response;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("open.private.im_api.ShowPrivateMsgEntranceResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/api/response/a;", "", "", "statusCode", "I", "getStatusCode", "()I", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "text", "i", "nickName", "g", "desc", "c", "avatar", "a", "identity", "f", "schema", "h", "enterText", "d", "", "bdpLogExtra", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "extra", "e", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("avatar")
    protected String avatar;

    @SerializedName("bdp_log_extra")
    protected Map<String, String> bdpLogExtra;

    @SerializedName("desc")
    protected String desc;

    @SerializedName("enter_text")
    protected String enterText;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("identity")
    protected String identity;

    @SerializedName("nick_name")
    protected String nickName;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("status_code")
    protected int statusCode;

    @SerializedName("status_msg")
    protected String statusMsg;

    @SerializedName("text")
    protected String text;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L28;
        a r4 = (a) r3;
        if (this.statusCode == r4.statusCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r4.statusMsg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.identity, r4.identity) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.enterText, r4.enterText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bdpLogExtra, r4.bdpLogExtra) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
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
        String r5 = this.text;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.nickName;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.desc;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.avatar;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.identity;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.schema;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.enterText;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        Map<String, String> r26 = this.bdpLogExtra;
        if (r26 == null) goto L37;
        int r27 = r26.hashCode();
    L38:
        int r28 = (r25 + r27) * 31;
        Map<String, String> r29 = this.extra;
        if (r29 == null) goto L42;
        r2 = r29.hashCode();
    L42:
        return r28 + r2;
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
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
        return "ShowPrivateMsgEntranceResponse(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", text=" + this.text + ", nickName=" + this.nickName + ", desc=" + this.desc + ", avatar=" + this.avatar + ", identity=" + this.identity + ", schema=" + this.schema + ", enterText=" + this.enterText + ", bdpLogExtra=" + this.bdpLogExtra + ", extra=" + this.extra + ")";
    }

    public a() {
        this.statusCode = 0;
        this.statusMsg = null;
        this.text = null;
        this.nickName = null;
        this.desc = null;
        this.avatar = null;
        this.identity = null;
        this.schema = null;
        this.enterText = null;
        this.bdpLogExtra = null;
        this.extra = null;
    }

    public final String a() {
        return this.avatar;
    }

    public final Map<String, String> b() {
        return this.bdpLogExtra;
    }

    public final String c() {
        return this.desc;
    }

    public final String d() {
        return this.enterText;
    }

    public final Map<String, String> e() {
        return this.extra;
    }

    public final String f() {
        return this.identity;
    }

    public final String g() {
        return this.nickName;
    }

    public final String h() {
        return this.schema;
    }

    public final String i() {
        return this.text;
    }

    public a(g r15) {
        this.bdpLogExtra = new HashMap();
        this.extra = new HashMap();
        long r0 = r15.c();
        boolean r3 = false;
    L3:
        int r4 = r15.f();
        String r7 = null;
        if (r4 == (-1)) goto L52;
        if (r4 != 11) goto L8;
        this.enterText = am3.h.c(r15);
        goto L3
    L8:
        if (r4 == 110) goto L35;
        switch(r4) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        long r12 = r15.c();
        String r5 = null;
    L12:
        int r8 = r15.f();
        if (r8 == (-1)) goto L19;
        if (r8 != 1) goto L15;
        r7 = am3.h.c(r15);
        goto L12
    L15:
        if (r8 != 2) goto L16;
        r5 = am3.h.c(r15);
        goto L12
    L16:
        am3.h.e(r15);
        goto L12
    L19:
        r15.d(r12);
        Map<String, String> r6 = this.bdpLogExtra;
        if (r7 == null) goto L26;
        if (r5 == null) goto L24;
    L22:
        r6.put(r7, r5);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L27:
        this.schema = am3.h.c(r15);
        goto L3
    L28:
        this.identity = am3.h.c(r15);
        goto L3
    L29:
        this.desc = am3.h.c(r15);
        goto L3
    L30:
        this.nickName = am3.h.c(r15);
        goto L3
    L31:
        this.avatar = am3.h.c(r15);
        goto L3
    L32:
        this.text = am3.h.c(r15);
        goto L3
    L33:
        this.statusMsg = am3.h.c(r15);
        goto L3
    L34:
        this.statusCode = (int) r15.j();
        r3 = r3 | true;
        goto L3
    L10:
        am3.h.e(r15);
        goto L3
    L35:
        long r13 = r15.c();
        r5 = null;
    L36:
        int r9 = r15.f();
        if (r9 == (-1)) goto L43;
        if (r9 != 1) goto L39;
        r7 = am3.h.c(r15);
        goto L36
    L39:
        if (r9 != 2) goto L40;
        r5 = am3.h.c(r15);
        goto L36
    L40:
        am3.h.e(r15);
        goto L36
    L43:
        r15.d(r13);
        r6 = this.extra;
        if (r7 == null) goto L50;
        if (r5 != null) goto L22;
        throw new IllegalStateException("Value must not be null");
    L50:
        throw new IllegalStateException("Key must not be null");
    L52:
        r15.d(r0);
        if ((r3 & true) == true) goto L56;
        this.statusCode = 0;
    L56:
        if (this.statusMsg != null) goto L59;
        this.statusMsg = null;
    L59:
        if (this.text != null) goto L62;
        this.text = null;
    L62:
        if (this.nickName != null) goto L65;
        this.nickName = null;
    L65:
        if (this.desc != null) goto L68;
        this.desc = null;
    L68:
        if (this.avatar != null) goto L71;
        this.avatar = null;
    L71:
        if (this.identity != null) goto L74;
        this.identity = null;
    L74:
        if (this.schema != null) goto L77;
        this.schema = null;
    L77:
        if (this.enterText != null) goto L80;
        this.enterText = null;
    L80:
        if (this.bdpLogExtra != null) goto L83;
        this.bdpLogExtra = null;
    L83:
        if (this.extra != null) goto L134;
        this.extra = null;
        return;
    }
}
