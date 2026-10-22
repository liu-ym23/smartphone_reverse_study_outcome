package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b#\b\u0086\u0081\u0002\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001*B9\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006+"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/MmRecordingUploadResponse;", "", "httpCode", "", "statusCode", "errorType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;", "rtt", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;Ljava/lang/Long;)V", "getHttpCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusCode", "getErrorType", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;", "getRtt", "()Ljava/lang/Long;", "setRtt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "SUCCESS", "INTERRUPTED", "NON_RECORDING_TYPE", "INVALID_PARAMETER", "UPLOAD_COMPLETED", "REACH_MAX_DURATION", "TENANT_KEY_DELETED", "GET_TENANT_KEY_FAILED", "ENCRYPTION_FAILED", "TOS_UPLOAD_FAILED", "ABASE_FAILED", "TRANSCODING_FAILED", "SERVER_DOWN", "NOT_LOGGED_IN", "UNAUTHORIZED", "INCORRECT_PATH", "OBJECT_DELETED", "NETWORK", "DISKCACHE_INSUFFICIENT", "UNKNOWN", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingUploadResponse extends Enum<MmRecordingUploadResponse> {
    public static final MmRecordingUploadResponse ABASE_FAILED = null;
    public static final a Companion = null;
    public static final MmRecordingUploadResponse DISKCACHE_INSUFFICIENT = null;
    public static final MmRecordingUploadResponse ENCRYPTION_FAILED = null;
    public static final MmRecordingUploadResponse GET_TENANT_KEY_FAILED = null;
    public static final MmRecordingUploadResponse INCORRECT_PATH = null;
    public static final MmRecordingUploadResponse INTERRUPTED = null;
    public static final MmRecordingUploadResponse INVALID_PARAMETER = null;
    public static final MmRecordingUploadResponse NETWORK = null;
    public static final MmRecordingUploadResponse NON_RECORDING_TYPE = null;
    public static final MmRecordingUploadResponse NOT_LOGGED_IN = null;
    public static final MmRecordingUploadResponse OBJECT_DELETED = null;
    public static final MmRecordingUploadResponse REACH_MAX_DURATION = null;
    public static final MmRecordingUploadResponse SERVER_DOWN = null;
    public static final MmRecordingUploadResponse SUCCESS = null;
    public static final MmRecordingUploadResponse TENANT_KEY_DELETED = null;
    public static final MmRecordingUploadResponse TOS_UPLOAD_FAILED = null;
    public static final MmRecordingUploadResponse TRANSCODING_FAILED = null;
    public static final MmRecordingUploadResponse UNAUTHORIZED = null;
    public static final MmRecordingUploadResponse UNKNOWN = null;
    public static final MmRecordingUploadResponse UPLOAD_COMPLETED = null;
    public static final /* synthetic */ MmRecordingUploadResponse[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final ErrorType errorType;
    private final Integer httpCode;
    private Long rtt;
    private final Integer statusCode;

    public static final class a {
        public a() {
        }

        public static MmRecordingUploadResponse a(Integer r2, Integer r3) {
            if (r2 != null) goto L5;
        L10:
            if (r2 != null) goto L13;
        L21:
            if (r2 != null) goto L24;
        L26:
            if (r2 != null) goto L29;
        L31:
            if (r2 != null) goto L34;
        L36:
            if (r2 != null) goto L39;
        L47:
            if (r2 != null) goto L50;
        L52:
            if (r2 != null) goto L55;
        L75:
            MmRecordingUploadResponse r4 = MmRecordingUploadResponse.NETWORK;
            if (Intrinsics.areEqual(r3, r4.getStatusCode()) == true) goto L106;
            MmRecordingUploadResponse r0 = MmRecordingUploadResponse.DISKCACHE_INSUFFICIENT;
            if (Intrinsics.areEqual(r3, r0.getStatusCode()) == false) goto L82;
            return r0;
        L82:
            if (NetworkUtils.d(LarkContext.getApplication()) == true) goto L85;
            return r4;
        L85:
            return MmRecordingUploadResponse.UNKNOWN;
        L106:
            return r4;
        L55:
            if (r2.intValue() != 500) goto L75;
            MmRecordingUploadResponse r5 = MmRecordingUploadResponse.TENANT_KEY_DELETED;
            if (Intrinsics.areEqual(r3, r5.getStatusCode()) == true) goto L100;
            MmRecordingUploadResponse r6 = MmRecordingUploadResponse.GET_TENANT_KEY_FAILED;
            if (Intrinsics.areEqual(r3, r6.getStatusCode()) == true) goto L101;
            MmRecordingUploadResponse r7 = MmRecordingUploadResponse.ENCRYPTION_FAILED;
            if (Intrinsics.areEqual(r3, r7.getStatusCode()) == true) goto L102;
            MmRecordingUploadResponse r8 = MmRecordingUploadResponse.TOS_UPLOAD_FAILED;
            if (Intrinsics.areEqual(r3, r8.getStatusCode()) == true) goto L103;
            MmRecordingUploadResponse r9 = MmRecordingUploadResponse.ABASE_FAILED;
            if (Intrinsics.areEqual(r3, r9.getStatusCode()) == true) goto L104;
            MmRecordingUploadResponse r10 = MmRecordingUploadResponse.TRANSCODING_FAILED;
            if (Intrinsics.areEqual(r3, r10.getStatusCode()) == false) goto L93;
            return r10;
        L93:
            return MmRecordingUploadResponse.SERVER_DOWN;
        L104:
            return r9;
        L103:
            return r8;
        L102:
            return r7;
        L101:
            return r6;
        L100:
            return r5;
        L50:
            if (r2.intValue() != 410) goto L52;
            return MmRecordingUploadResponse.OBJECT_DELETED;
        L39:
            if (r2.intValue() != 406) goto L47;
            MmRecordingUploadResponse r11 = MmRecordingUploadResponse.UPLOAD_COMPLETED;
            if (Intrinsics.areEqual(r3, r11.getStatusCode()) == true) goto L98;
            MmRecordingUploadResponse r12 = MmRecordingUploadResponse.REACH_MAX_DURATION;
            if (Intrinsics.areEqual(r3, r12.getStatusCode()) == false) goto L91;
            return r12;
        L91:
            return MmRecordingUploadResponse.UNKNOWN;
        L98:
            return r11;
        L34:
            if (r2.intValue() != 404) goto L36;
            return MmRecordingUploadResponse.INCORRECT_PATH;
        L29:
            if (r2.intValue() != 403) goto L31;
            return MmRecordingUploadResponse.UNAUTHORIZED;
        L24:
            if (r2.intValue() != 401) goto L26;
            return MmRecordingUploadResponse.NOT_LOGGED_IN;
        L13:
            if (r2.intValue() != 400) goto L21;
            MmRecordingUploadResponse r13 = MmRecordingUploadResponse.NON_RECORDING_TYPE;
            if (Intrinsics.areEqual(r3, r13.getStatusCode()) == true) goto L96;
            MmRecordingUploadResponse r14 = MmRecordingUploadResponse.INVALID_PARAMETER;
            if (Intrinsics.areEqual(r3, r14.getStatusCode()) == false) goto L87;
            return r14;
        L87:
            return MmRecordingUploadResponse.UNKNOWN;
        L96:
            return r13;
        L5:
            if (r2.intValue() != 200) goto L10;
            MmRecordingUploadResponse r15 = MmRecordingUploadResponse.INTERRUPTED;
            if (Intrinsics.areEqual(r3, r15.getStatusCode()) == false) goto L86;
            return r15;
        L86:
            return MmRecordingUploadResponse.SUCCESS;
        }
    }

    public MmRecordingUploadResponse() {
        throw null;
    }

    public static EnumEntries<MmRecordingUploadResponse> getEntries() {
        return b;
    }

    static {
        MmRecordingUploadResponse r9 = new MmRecordingUploadResponse("SUCCESS", 0, 200, 0, null, null, 12, null);
        SUCCESS = r9;
        MmRecordingUploadResponse r0 = new MmRecordingUploadResponse("INTERRUPTED", 1, 200, 1000130048, null, null, 12, null);
        INTERRUPTED = r0;
        ErrorType r2 = ErrorType.CLIENT_ERROR;
        MmRecordingUploadResponse r1 = new MmRecordingUploadResponse("NON_RECORDING_TYPE", 2, 400, 1000130040, r2, null, 8, null);
        NON_RECORDING_TYPE = r1;
        MmRecordingUploadResponse r3 = new MmRecordingUploadResponse("INVALID_PARAMETER", 3, 400, -1, r2, null, 8, null);
        INVALID_PARAMETER = r3;
        MmRecordingUploadResponse r5 = new MmRecordingUploadResponse("UPLOAD_COMPLETED", 4, 406, 1000130041, r2, null, 8, null);
        UPLOAD_COMPLETED = r5;
        MmRecordingUploadResponse r43 = new MmRecordingUploadResponse("REACH_MAX_DURATION", 5, 406, 1000130043, r2, null, 8, null);
        REACH_MAX_DURATION = r43;
        Integer r6 = Integer.valueOf(BaseField.FIELD_TYPE_NAME_CARD_PHONE);
        ErrorType r7 = ErrorType.BIZ_SERVER_ERROR;
        MmRecordingUploadResponse r4 = new MmRecordingUploadResponse("TENANT_KEY_DELETED", 6, r6, 11010, r7, null, 8, null);
        TENANT_KEY_DELETED = r4;
        MmRecordingUploadResponse r8 = new MmRecordingUploadResponse("GET_TENANT_KEY_FAILED", 7, r6, 1000130044, r7, null, 8, null);
        GET_TENANT_KEY_FAILED = r8;
        MmRecordingUploadResponse r20 = new MmRecordingUploadResponse("ENCRYPTION_FAILED", 8, r6, 1000130045, r7, null, 8, null);
        ENCRYPTION_FAILED = r20;
        MmRecordingUploadResponse r21 = new MmRecordingUploadResponse("TOS_UPLOAD_FAILED", 9, r6, 1000130046, r7, null, 8, null);
        TOS_UPLOAD_FAILED = r21;
        MmRecordingUploadResponse r22 = new MmRecordingUploadResponse("ABASE_FAILED", 10, r6, 1000130047, r7, null, 8, null);
        ABASE_FAILED = r22;
        MmRecordingUploadResponse r23 = new MmRecordingUploadResponse("TRANSCODING_FAILED", 11, r6, 1000130049, r7, null, 8, null);
        TRANSCODING_FAILED = r23;
        MmRecordingUploadResponse r24 = new MmRecordingUploadResponse("SERVER_DOWN", 12, r6, -1, r7, null, 8, null);
        SERVER_DOWN = r24;
        ErrorType r10 = ErrorType.GATEWAY_ERROR;
        MmRecordingUploadResponse r11 = new MmRecordingUploadResponse("NOT_LOGGED_IN", 13, 401, null, r10, null, 10, null);
        NOT_LOGGED_IN = r11;
        MmRecordingUploadResponse r39 = new MmRecordingUploadResponse("UNAUTHORIZED", 14, 403, null, r10, null, 10, null);
        UNAUTHORIZED = r39;
        MmRecordingUploadResponse r40 = new MmRecordingUploadResponse("INCORRECT_PATH", 15, 404, null, r10, null, 10, null);
        INCORRECT_PATH = r40;
        MmRecordingUploadResponse r41 = new MmRecordingUploadResponse("OBJECT_DELETED", 16, 410, null, r10, null, 10, null);
        OBJECT_DELETED = r41;
        Integer r33 = Integer.valueOf(OfficeSDKPluginErrorCode.SERVICE_NOT_REGISTERED);
        ErrorType r15 = ErrorType.OTHER;
        MmRecordingUploadResponse r12 = new MmRecordingUploadResponse("NETWORK", 17, -1, r33, r15, null, 8, null);
        NETWORK = r12;
        MmRecordingUploadResponse r13 = new MmRecordingUploadResponse("DISKCACHE_INSUFFICIENT", 18, null, Integer.valueOf(OfficeSDKPluginErrorCode.PLUGIN_UNSUPPORTED), r15, null, 9, null);
        DISKCACHE_INSUFFICIENT = r13;
        MmRecordingUploadResponse r14 = new MmRecordingUploadResponse("UNKNOWN", 19, null, null, null, null, 15, null);
        UNKNOWN = r14;
        MmRecordingUploadResponse[] r16 = {r9, r0, r1, r3, r5, r43, r4, r8, r20, r21, r22, r23, r24, r11, r39, r40, r41, r12, r13, r14};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
        Companion = new a();
    }

    public static MmRecordingUploadResponse[] values() {
        return (MmRecordingUploadResponse[]) a.clone();
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final Long getRtt() {
        return this.rtt;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public static MmRecordingUploadResponse valueOf(String r1) {
        return (MmRecordingUploadResponse) r27.a.a(MmRecordingUploadResponse.class, r1);
    }

    public final void setRtt(Long r1) {
        this.rtt = r1;
    }

    public MmRecordingUploadResponse(String r2, int r3, Integer r4, Integer r5, ErrorType r6, Long r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 8) == 0) goto L14;
        r7 = null;
    L14:
        super(r2, r3);
        this.httpCode = r4;
        this.statusCode = r5;
        this.errorType = r6;
        this.rtt = r7;
    }
}
