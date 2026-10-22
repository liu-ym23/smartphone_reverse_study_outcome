package com.larus.trace.audioattachment;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.trace.CopyContentTypeString;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b;\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bA¨\u0006B"}, d2 = {"Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Result;", "", "stage", "Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;", CopyContentTypeString.CODE, "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "", "<init>", "(Ljava/lang/String;ILcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;ILjava/lang/String;)V", "getStage", "()Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;", "getCode", "()I", "getReason", "()Ljava/lang/String;", "SELECTED", "VALIDATED", "WITHOUT_DURATION", "EMPTY_URL", "EMPTY_DATA", "UNSUPPORTED_TYPE", "OVERSIZE", "OVER_DURATION", "COUNT_EXCEEDED", "INSUFFICIENT_STORAGE", "MIXED_TYPE", "VALIDATION_UNKNOWN", "CACHED", "REMOTE_CACHE_SKIPPED", "COPY_FAILED", "SOURCE_UNAVAILABLE", "CACHE_UNKNOWN", "UPLOAD_DISPATCHED", "UPLOADER_UNAVAILABLE", "UPLOAD_MODEL_FAILED", "INVALID_SOURCE", "DISPATCH_UNKNOWN", "FULL_UPLOAD", "FAST_UPLOAD", "ARTIFACT_CACHE", "DRIVE_REUSE", "HISTORY_REUSE", "PRECHECK_MISS", "PRECHECK_FALLBACK", "READY", "AUTH_FAILED", "NETWORK_UNAVAILABLE", "UPLOAD_FAILED", "TOKEN_EXHAUSTED", "REGISTER_FAILED", "UPLOAD_TIMEOUT", "USER_CANCELED", "LEAVE_CANCELED", "ARTIFACT_MISSING", "RESOURCE_UNKNOWN", "SEND_DISPATCHED", "SENT", "ENCODE_FAILED", "LOCAL_MESSAGE_MISSING", "IM_SDK_FAILED", "BUSINESS_REJECTED", "CONNECTION_UNAVAILABLE", "PAIRED_MESSAGE_FAILED", "SEND_TIMEOUT", "SEND_UNKNOWN", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AudioAttachmentUploadEvent$Result extends Enum<AudioAttachmentUploadEvent$Result> {
    public static final AudioAttachmentUploadEvent$Result ARTIFACT_CACHE = null;
    public static final AudioAttachmentUploadEvent$Result ARTIFACT_MISSING = null;
    public static final AudioAttachmentUploadEvent$Result AUTH_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result BUSINESS_REJECTED = null;
    public static final AudioAttachmentUploadEvent$Result CACHED = null;
    public static final AudioAttachmentUploadEvent$Result CACHE_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result CONNECTION_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result COPY_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result COUNT_EXCEEDED = null;
    public static final AudioAttachmentUploadEvent$Result DISPATCH_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result DRIVE_REUSE = null;
    public static final AudioAttachmentUploadEvent$Result EMPTY_DATA = null;
    public static final AudioAttachmentUploadEvent$Result EMPTY_URL = null;
    public static final AudioAttachmentUploadEvent$Result ENCODE_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result FAST_UPLOAD = null;
    public static final AudioAttachmentUploadEvent$Result FULL_UPLOAD = null;
    public static final AudioAttachmentUploadEvent$Result HISTORY_REUSE = null;
    public static final AudioAttachmentUploadEvent$Result IM_SDK_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result INSUFFICIENT_STORAGE = null;
    public static final AudioAttachmentUploadEvent$Result INVALID_SOURCE = null;
    public static final AudioAttachmentUploadEvent$Result LEAVE_CANCELED = null;
    public static final AudioAttachmentUploadEvent$Result LOCAL_MESSAGE_MISSING = null;
    public static final AudioAttachmentUploadEvent$Result MIXED_TYPE = null;
    public static final AudioAttachmentUploadEvent$Result NETWORK_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result OVERSIZE = null;
    public static final AudioAttachmentUploadEvent$Result OVER_DURATION = null;
    public static final AudioAttachmentUploadEvent$Result PAIRED_MESSAGE_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result PRECHECK_FALLBACK = null;
    public static final AudioAttachmentUploadEvent$Result PRECHECK_MISS = null;
    public static final AudioAttachmentUploadEvent$Result READY = null;
    public static final AudioAttachmentUploadEvent$Result REGISTER_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result REMOTE_CACHE_SKIPPED = null;
    public static final AudioAttachmentUploadEvent$Result RESOURCE_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result SELECTED = null;
    public static final AudioAttachmentUploadEvent$Result SEND_DISPATCHED = null;
    public static final AudioAttachmentUploadEvent$Result SEND_TIMEOUT = null;
    public static final AudioAttachmentUploadEvent$Result SEND_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result SENT = null;
    public static final AudioAttachmentUploadEvent$Result SOURCE_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result TOKEN_EXHAUSTED = null;
    public static final AudioAttachmentUploadEvent$Result UNSUPPORTED_TYPE = null;
    public static final AudioAttachmentUploadEvent$Result UPLOADER_UNAVAILABLE = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_DISPATCHED = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_MODEL_FAILED = null;
    public static final AudioAttachmentUploadEvent$Result UPLOAD_TIMEOUT = null;
    public static final AudioAttachmentUploadEvent$Result USER_CANCELED = null;
    public static final AudioAttachmentUploadEvent$Result VALIDATED = null;
    public static final AudioAttachmentUploadEvent$Result VALIDATION_UNKNOWN = null;
    public static final AudioAttachmentUploadEvent$Result WITHOUT_DURATION = null;
    public static final /* synthetic */ AudioAttachmentUploadEvent$Result[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;
    private final String reason;
    private final AudioAttachmentUploadEvent$Stage stage;

    public static EnumEntries<AudioAttachmentUploadEvent$Result> getEntries() {
        return b;
    }

    static {
        AudioAttachmentUploadEvent$Result r6 = new AudioAttachmentUploadEvent$Result("SELECTED", 0, AudioAttachmentUploadEvent$Stage.SELECTED, 0, "selected");
        SELECTED = r6;
        AudioAttachmentUploadEvent$Stage r1 = AudioAttachmentUploadEvent$Stage.VALIDATION;
        AudioAttachmentUploadEvent$Result r0 = new AudioAttachmentUploadEvent$Result("VALIDATED", 1, r1, 0, "validated");
        VALIDATED = r0;
        AudioAttachmentUploadEvent$Result r2 = new AudioAttachmentUploadEvent$Result("WITHOUT_DURATION", 2, r1, 0, "validated_without_duration");
        WITHOUT_DURATION = r2;
        AudioAttachmentUploadEvent$Result r3 = new AudioAttachmentUploadEvent$Result("EMPTY_URL", 3, r1, 1001, "empty_url");
        EMPTY_URL = r3;
        AudioAttachmentUploadEvent$Result r4 = new AudioAttachmentUploadEvent$Result("EMPTY_DATA", 4, r1, 1002, "empty_data");
        EMPTY_DATA = r4;
        AudioAttachmentUploadEvent$Result r5 = new AudioAttachmentUploadEvent$Result("UNSUPPORTED_TYPE", 5, r1, 1003, "unsupported_type");
        UNSUPPORTED_TYPE = r5;
        AudioAttachmentUploadEvent$Result r7 = new AudioAttachmentUploadEvent$Result("OVERSIZE", 6, r1, 1004, "oversize");
        OVERSIZE = r7;
        AudioAttachmentUploadEvent$Result r8 = new AudioAttachmentUploadEvent$Result("OVER_DURATION", 7, r1, 1005, "over_duration");
        OVER_DURATION = r8;
        AudioAttachmentUploadEvent$Result r9 = new AudioAttachmentUploadEvent$Result("COUNT_EXCEEDED", 8, r1, 1006, "count_exceeded");
        COUNT_EXCEEDED = r9;
        AudioAttachmentUploadEvent$Result r16 = new AudioAttachmentUploadEvent$Result("INSUFFICIENT_STORAGE", 9, r1, 1007, "insufficient_storage");
        INSUFFICIENT_STORAGE = r16;
        AudioAttachmentUploadEvent$Result r17 = new AudioAttachmentUploadEvent$Result("MIXED_TYPE", 10, r1, 1008, "mixed_type_rejected");
        MIXED_TYPE = r17;
        AudioAttachmentUploadEvent$Result r18 = new AudioAttachmentUploadEvent$Result("VALIDATION_UNKNOWN", 11, r1, 1099, "validation_unknown");
        VALIDATION_UNKNOWN = r18;
        AudioAttachmentUploadEvent$Stage r25 = AudioAttachmentUploadEvent$Stage.CACHE;
        AudioAttachmentUploadEvent$Result r10 = new AudioAttachmentUploadEvent$Result("CACHED", 12, r25, 0, "cached");
        CACHED = r10;
        AudioAttachmentUploadEvent$Result r19 = new AudioAttachmentUploadEvent$Result("REMOTE_CACHE_SKIPPED", 13, r25, 0, "skipped_remote_resource");
        REMOTE_CACHE_SKIPPED = r19;
        AudioAttachmentUploadEvent$Result r20 = new AudioAttachmentUploadEvent$Result("COPY_FAILED", 14, r25, 2001, "copy_file_failed");
        COPY_FAILED = r20;
        AudioAttachmentUploadEvent$Result r21 = new AudioAttachmentUploadEvent$Result("SOURCE_UNAVAILABLE", 15, r25, 2002, "source_unavailable");
        SOURCE_UNAVAILABLE = r21;
        AudioAttachmentUploadEvent$Result r22 = new AudioAttachmentUploadEvent$Result("CACHE_UNKNOWN", 16, r25, 2099, "cache_unknown");
        CACHE_UNKNOWN = r22;
        AudioAttachmentUploadEvent$Stage r11 = AudioAttachmentUploadEvent$Stage.UPLOAD;
        AudioAttachmentUploadEvent$Result r12 = new AudioAttachmentUploadEvent$Result("UPLOAD_DISPATCHED", 17, r11, 0, "dispatched");
        UPLOAD_DISPATCHED = r12;
        AudioAttachmentUploadEvent$Result r13 = new AudioAttachmentUploadEvent$Result("UPLOADER_UNAVAILABLE", 18, r11, 3001, "uploader_unavailable");
        UPLOADER_UNAVAILABLE = r13;
        AudioAttachmentUploadEvent$Result r14 = new AudioAttachmentUploadEvent$Result("UPLOAD_MODEL_FAILED", 19, r11, 3002, "upload_model_failed");
        UPLOAD_MODEL_FAILED = r14;
        AudioAttachmentUploadEvent$Result r15 = new AudioAttachmentUploadEvent$Result("INVALID_SOURCE", 20, r11, 3003, "invalid_upload_source");
        INVALID_SOURCE = r15;
        AudioAttachmentUploadEvent$Result r110 = new AudioAttachmentUploadEvent$Result("DISPATCH_UNKNOWN", 21, r11, 3099, "dispatch_unknown");
        DISPATCH_UNKNOWN = r110;
        AudioAttachmentUploadEvent$Stage r32 = AudioAttachmentUploadEvent$Stage.PATH;
        AudioAttachmentUploadEvent$Result r111 = new AudioAttachmentUploadEvent$Result("FULL_UPLOAD", 22, r32, 0, "full_upload");
        FULL_UPLOAD = r111;
        AudioAttachmentUploadEvent$Result r23 = new AudioAttachmentUploadEvent$Result("FAST_UPLOAD", 23, r32, 0, "fast_upload_hit");
        FAST_UPLOAD = r23;
        AudioAttachmentUploadEvent$Result r24 = new AudioAttachmentUploadEvent$Result("ARTIFACT_CACHE", 24, r32, 0, "artifact_cache_hit");
        ARTIFACT_CACHE = r24;
        AudioAttachmentUploadEvent$Result r26 = new AudioAttachmentUploadEvent$Result("DRIVE_REUSE", 25, r32, 0, "drive_resource_reused");
        DRIVE_REUSE = r26;
        AudioAttachmentUploadEvent$Result r33 = new AudioAttachmentUploadEvent$Result("HISTORY_REUSE", 26, r32, 0, "history_resource_reused");
        HISTORY_REUSE = r33;
        AudioAttachmentUploadEvent$Result r34 = new AudioAttachmentUploadEvent$Result("PRECHECK_MISS", 27, r32, 0, "precheck_miss");
        PRECHECK_MISS = r34;
        AudioAttachmentUploadEvent$Result r35 = new AudioAttachmentUploadEvent$Result("PRECHECK_FALLBACK", 28, r32, 0, "precheck_failed_fallback");
        PRECHECK_FALLBACK = r35;
        AudioAttachmentUploadEvent$Stage r42 = AudioAttachmentUploadEvent$Stage.READY;
        AudioAttachmentUploadEvent$Result r27 = new AudioAttachmentUploadEvent$Result("READY", 29, r42, 0, "ready");
        READY = r27;
        AudioAttachmentUploadEvent$Result r36 = new AudioAttachmentUploadEvent$Result("AUTH_FAILED", 30, r42, 4001, "auth_failed");
        AUTH_FAILED = r36;
        AudioAttachmentUploadEvent$Result r37 = new AudioAttachmentUploadEvent$Result("NETWORK_UNAVAILABLE", 31, r42, 4002, "network_unavailable");
        NETWORK_UNAVAILABLE = r37;
        AudioAttachmentUploadEvent$Result r38 = new AudioAttachmentUploadEvent$Result("UPLOAD_FAILED", 32, r42, 4003, "upload_failed");
        UPLOAD_FAILED = r38;
        AudioAttachmentUploadEvent$Result r39 = new AudioAttachmentUploadEvent$Result("TOKEN_EXHAUSTED", 33, r42, 4004, "token_expired_retry_exhausted");
        TOKEN_EXHAUSTED = r39;
        AudioAttachmentUploadEvent$Result r40 = new AudioAttachmentUploadEvent$Result("REGISTER_FAILED", 34, r42, 4005, "resource_register_failed");
        REGISTER_FAILED = r40;
        AudioAttachmentUploadEvent$Result r41 = new AudioAttachmentUploadEvent$Result("UPLOAD_TIMEOUT", 35, r42, 4006, "upload_timeout");
        UPLOAD_TIMEOUT = r41;
        AudioAttachmentUploadEvent$Result r43 = new AudioAttachmentUploadEvent$Result("USER_CANCELED", 36, r42, 4007, "canceled_by_user");
        USER_CANCELED = r43;
        AudioAttachmentUploadEvent$Result r44 = new AudioAttachmentUploadEvent$Result("LEAVE_CANCELED", 37, r42, 4008, "canceled_by_leave_chat");
        LEAVE_CANCELED = r44;
        AudioAttachmentUploadEvent$Result r45 = new AudioAttachmentUploadEvent$Result("ARTIFACT_MISSING", 38, r42, 4009, "artifact_missing");
        ARTIFACT_MISSING = r45;
        AudioAttachmentUploadEvent$Result r46 = new AudioAttachmentUploadEvent$Result("RESOURCE_UNKNOWN", 39, r42, 4099, "resource_unknown");
        RESOURCE_UNKNOWN = r46;
        AudioAttachmentUploadEvent$Result r28 = new AudioAttachmentUploadEvent$Result("SEND_DISPATCHED", 40, AudioAttachmentUploadEvent$Stage.SEND, 0, "dispatched");
        SEND_DISPATCHED = r28;
        AudioAttachmentUploadEvent$Stage r29 = AudioAttachmentUploadEvent$Stage.SENT;
        AudioAttachmentUploadEvent$Result r210 = new AudioAttachmentUploadEvent$Result("SENT", 41, r29, 0, "sent");
        SENT = r210;
        AudioAttachmentUploadEvent$Result r30 = new AudioAttachmentUploadEvent$Result("ENCODE_FAILED", 42, r29, 5001, "message_encode_failed");
        ENCODE_FAILED = r30;
        AudioAttachmentUploadEvent$Result r31 = new AudioAttachmentUploadEvent$Result("LOCAL_MESSAGE_MISSING", 43, r29, 5002, "local_message_missing");
        LOCAL_MESSAGE_MISSING = r31;
        AudioAttachmentUploadEvent$Result r310 = new AudioAttachmentUploadEvent$Result("IM_SDK_FAILED", 44, r29, 5003, "im_sdk_failed");
        IM_SDK_FAILED = r310;
        AudioAttachmentUploadEvent$Result r47 = new AudioAttachmentUploadEvent$Result("BUSINESS_REJECTED", 45, r29, 5004, "business_rejected");
        BUSINESS_REJECTED = r47;
        AudioAttachmentUploadEvent$Result r53 = new AudioAttachmentUploadEvent$Result("CONNECTION_UNAVAILABLE", 46, r29, 5005, "connection_unavailable");
        CONNECTION_UNAVAILABLE = r53;
        AudioAttachmentUploadEvent$Result r54 = new AudioAttachmentUploadEvent$Result("PAIRED_MESSAGE_FAILED", 47, r29, 5006, "paired_message_failed");
        PAIRED_MESSAGE_FAILED = r54;
        AudioAttachmentUploadEvent$Result r55 = new AudioAttachmentUploadEvent$Result("SEND_TIMEOUT", 48, r29, 5007, "send_timeout");
        SEND_TIMEOUT = r55;
        AudioAttachmentUploadEvent$Result r56 = new AudioAttachmentUploadEvent$Result("SEND_UNKNOWN", 49, r29, 5099, "im_send_unknown");
        SEND_UNKNOWN = r56;
        AudioAttachmentUploadEvent$Result[] r112 = {r6, r0, r2, r3, r4, r5, r7, r8, r9, r16, r17, r18, r10, r19, r20, r21, r22, r12, r13, r14, r15, r110, r111, r23, r24, r26, r33, r34, r35, r27, r36, r37, r38, r39, r40, r41, r43, r44, r45, r46, r28, r210, r30, r31, r310, r47, r53, r54, r55, r56};
        a = r112;
        b = EnumEntriesKt.enumEntries(r112);
    }

    public static AudioAttachmentUploadEvent$Result[] values() {
        return (AudioAttachmentUploadEvent$Result[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getReason() {
        return this.reason;
    }

    public final AudioAttachmentUploadEvent$Stage getStage() {
        return this.stage;
    }

    public static AudioAttachmentUploadEvent$Result valueOf(String r1) {
        return (AudioAttachmentUploadEvent$Result) a.a(AudioAttachmentUploadEvent$Result.class, r1);
    }

    public AudioAttachmentUploadEvent$Result(String r1, int r2, AudioAttachmentUploadEvent$Stage r3, int r4, String r5) {
        super(r1, r2);
        this.stage = r3;
        this.code = r4;
        this.reason = r5;
    }
}
