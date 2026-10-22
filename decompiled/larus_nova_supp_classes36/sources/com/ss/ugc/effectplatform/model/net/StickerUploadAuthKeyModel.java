package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006)"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StickerUploadAuthKeyModel;", "", "session_token", "", "access_key", "secret_key", "expired_time", "current_time", "space_name", "upload_domain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_key", "()Ljava/lang/String;", "setAccess_key", "(Ljava/lang/String;)V", "getCurrent_time", "setCurrent_time", "getExpired_time", "setExpired_time", "getSecret_key", "setSecret_key", "getSession_token", "setSession_token", "getSpace_name", "setSpace_name", "getUpload_domain", "setUpload_domain", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class StickerUploadAuthKeyModel {
    private String access_key;
    private String current_time;
    private String expired_time;
    private String secret_key;
    private String session_token;
    private String space_name;
    private String upload_domain;

    public StickerUploadAuthKeyModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ StickerUploadAuthKeyModel copy$default(StickerUploadAuthKeyModel r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.session_token;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.access_key;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.secret_key;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.expired_time;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.current_time;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.space_name;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.upload_domain;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.session_token;
    }

    public final String component2() {
        return this.access_key;
    }

    public final String component3() {
        return this.secret_key;
    }

    public final String component4() {
        return this.expired_time;
    }

    public final String component5() {
        return this.current_time;
    }

    public final String component6() {
        return this.space_name;
    }

    public final String component7() {
        return this.upload_domain;
    }

    public final StickerUploadAuthKeyModel copy(String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        return new StickerUploadAuthKeyModel(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof StickerUploadAuthKeyModel) == false) goto L20;
        StickerUploadAuthKeyModel r4 = (StickerUploadAuthKeyModel) r3;
        if (Intrinsics.areEqual(this.session_token, r4.session_token) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.access_key, r4.access_key) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secret_key, r4.secret_key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expired_time, r4.expired_time) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.current_time, r4.current_time) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.space_name, r4.space_name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.upload_domain, r4.upload_domain) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.session_token;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.access_key;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.secret_key;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.expired_time;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.current_time;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.space_name;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.upload_domain;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "StickerUploadAuthKeyModel(session_token=" + this.session_token + ", access_key=" + this.access_key + ", secret_key=" + this.secret_key + ", expired_time=" + this.expired_time + ", current_time=" + this.current_time + ", space_name=" + this.space_name + ", upload_domain=" + this.upload_domain + ")";
    }

    public final String getAccess_key() {
        return this.access_key;
    }

    public final String getCurrent_time() {
        return this.current_time;
    }

    public final String getExpired_time() {
        return this.expired_time;
    }

    public final String getSecret_key() {
        return this.secret_key;
    }

    public final String getSession_token() {
        return this.session_token;
    }

    public final String getSpace_name() {
        return this.space_name;
    }

    public final String getUpload_domain() {
        return this.upload_domain;
    }

    public final void setAccess_key(String r1) {
        this.access_key = r1;
    }

    public final void setCurrent_time(String r1) {
        this.current_time = r1;
    }

    public final void setExpired_time(String r1) {
        this.expired_time = r1;
    }

    public final void setSecret_key(String r1) {
        this.secret_key = r1;
    }

    public final void setSession_token(String r1) {
        this.session_token = r1;
    }

    public final void setSpace_name(String r1) {
        this.space_name = r1;
    }

    public final void setUpload_domain(String r1) {
        this.upload_domain = r1;
    }

    public StickerUploadAuthKeyModel(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.session_token = r1;
        this.access_key = r2;
        this.secret_key = r3;
        this.expired_time = r4;
        this.current_time = r5;
        this.space_name = r6;
        this.upload_domain = r7;
    }

    public /* synthetic */ StickerUploadAuthKeyModel(String r7, String r8, String r9, String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
