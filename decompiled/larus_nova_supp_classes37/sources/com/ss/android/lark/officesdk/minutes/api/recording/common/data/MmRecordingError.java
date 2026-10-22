package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0011\u001d\u001e\u001f !\"#$%&'()*+,-¨\u0006."}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "", "errorCode", "", "errorMsg", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "TypeDisMatch", "AlreadyRecording", "RecordingStarting", "CreateRecordingRequestFailed", "AudioPermissionDenied", "RtcServiceNotAvailable", "RecordingNotFound", "StateError", "PhoneCallBusy", "NoQuota", "BusyTooManyUsers", "TooManyUnfinishedRecording", "RecordingRtcError", "NoLocalStorageError", "MaxLimitTimeError", "InternalError", "PriorityActionFailed", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AlreadyRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AudioPermissionDenied;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$BusyTooManyUsers;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$CreateRecordingRequestFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$InternalError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$MaxLimitTimeError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoLocalStorageError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoQuota;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PhoneCallBusy;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PriorityActionFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingNotFound;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingRtcError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingStarting;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RtcServiceNotAvailable;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$StateError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TooManyUnfinishedRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TypeDisMatch;", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MmRecordingError extends Throwable {
    private final int errorCode;
    private final String errorMsg;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AlreadyRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class AlreadyRecording extends MmRecordingError {
        public static final AlreadyRecording INSTANCE = null;

        static {
            INSTANCE = new AlreadyRecording();
        }

        private AlreadyRecording() {
            super(OfficeSDKPluginErrorCode.SERVICE_NOT_REGISTERED, "already recording", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$AudioPermissionDenied;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class AudioPermissionDenied extends MmRecordingError {
        public static final AudioPermissionDenied INSTANCE = null;

        static {
            INSTANCE = new AudioPermissionDenied();
        }

        private AudioPermissionDenied() {
            super(-10003, "audio permission denied", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$BusyTooManyUsers;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class BusyTooManyUsers extends MmRecordingError {
        public static final BusyTooManyUsers INSTANCE = null;

        static {
            INSTANCE = new BusyTooManyUsers();
        }

        private BusyTooManyUsers() {
            super(220206, "busy too many users", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$CreateRecordingRequestFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class CreateRecordingRequestFailed extends MmRecordingError {
        public static final CreateRecordingRequestFailed INSTANCE = null;

        static {
            INSTANCE = new CreateRecordingRequestFailed();
        }

        private CreateRecordingRequestFailed() {
            super(OfficeSDKPluginErrorCode.PLUGIN_UNSUPPORTED, "create recording request failed", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$InternalError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class InternalError extends MmRecordingError {
        public static final InternalError INSTANCE = null;

        static {
            INSTANCE = new InternalError();
        }

        private InternalError() {
            super(OfficeSDKPluginErrorCode.OPERATION_TIMEOUT, "internal error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$MaxLimitTimeError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class MaxLimitTimeError extends MmRecordingError {
        public static final MaxLimitTimeError INSTANCE = null;

        static {
            INSTANCE = new MaxLimitTimeError();
        }

        private MaxLimitTimeError() {
            super(-10008, "max limit time error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoLocalStorageError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NoLocalStorageError extends MmRecordingError {
        public static final NoLocalStorageError INSTANCE = null;

        static {
            INSTANCE = new NoLocalStorageError();
        }

        private NoLocalStorageError() {
            super(-10007, "no local storage error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$NoQuota;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NoQuota extends MmRecordingError {
        public static final NoQuota INSTANCE = null;

        static {
            INSTANCE = new NoQuota();
        }

        private NoQuota() {
            super(220202, "vc no quota", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PhoneCallBusy;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class PhoneCallBusy extends MmRecordingError {
        public static final PhoneCallBusy INSTANCE = null;

        static {
            INSTANCE = new PhoneCallBusy();
        }

        private PhoneCallBusy() {
            super(OfficeSDKPluginErrorCode.LOAD_FAILED, "phone call busy", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$PriorityActionFailed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "code", "", "detail", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class PriorityActionFailed extends MmRecordingError {
        private final int code;
        private final String detail;

        public static /* synthetic */ PriorityActionFailed copy$default(PriorityActionFailed r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.detail;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final PriorityActionFailed copy(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "detail");
            return new PriorityActionFailed(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PriorityActionFailed) == true) goto L8;
            return false;
        L8:
            PriorityActionFailed r6 = (PriorityActionFailed) r5;
            if (this.code == r6.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.detail, r6.detail) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.code * 31) + this.detail.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "PriorityActionFailed(code=" + this.code + ", detail=" + this.detail + ')';
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDetail() {
            return this.detail;
        }

        public PriorityActionFailed(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "detail");
            super(r2, r3, null);
            this.code = r2;
            this.detail = r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingNotFound;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class RecordingNotFound extends MmRecordingError {
        public static final RecordingNotFound INSTANCE = null;

        static {
            INSTANCE = new RecordingNotFound();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof RecordingNotFound) == true) goto L9;
            return false;
        L9:
            RecordingNotFound r4 = (RecordingNotFound) r3;
            return true;
        }

        public int hashCode() {
            return -793623046;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "RecordingNotFound";
        }

        private RecordingNotFound() {
            super(OfficeSDKPluginErrorCode.DOWNLOAD_FAILED, "recording not found", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingRtcError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class RecordingRtcError extends MmRecordingError {
        public static final RecordingRtcError INSTANCE = null;

        static {
            INSTANCE = new RecordingRtcError();
        }

        private RecordingRtcError() {
            super(OfficeSDKPluginErrorCode.PLUGIN_STATE_UNAVAILABLE, "recording rtc error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RecordingStarting;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class RecordingStarting extends MmRecordingError {
        public static final RecordingStarting INSTANCE = null;

        static {
            INSTANCE = new RecordingStarting();
        }

        private RecordingStarting() {
            super(-10009, "recording starting", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$RtcServiceNotAvailable;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class RtcServiceNotAvailable extends MmRecordingError {
        public static final RtcServiceNotAvailable INSTANCE = null;

        static {
            INSTANCE = new RtcServiceNotAvailable();
        }

        private RtcServiceNotAvailable() {
            super(OfficeSDKPluginErrorCode.OPERATION_EXCEPTION, "rtc service not available", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$StateError;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class StateError extends MmRecordingError {
        public static final StateError INSTANCE = null;

        static {
            INSTANCE = new StateError();
        }

        private StateError() {
            super(OfficeSDKPluginErrorCode.INSTALL_FAILED, "state error", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TooManyUnfinishedRecording;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class TooManyUnfinishedRecording extends MmRecordingError {
        public static final TooManyUnfinishedRecording INSTANCE = null;

        static {
            INSTANCE = new TooManyUnfinishedRecording();
        }

        private TooManyUnfinishedRecording() {
            super(220207, "too many unfinished recording", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError$TypeDisMatch;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingError;", "<init>", "()V", "readResolve", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class TypeDisMatch extends MmRecordingError {
        public static final TypeDisMatch INSTANCE = null;

        static {
            INSTANCE = new TypeDisMatch();
        }

        private TypeDisMatch() {
            super(OfficeSDKPluginErrorCode.INVALID_PLUGIN_ID, "type dis match", null);
        }

        private final Object readResolve() {
            return INSTANCE;
        }
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public MmRecordingError(int r1, String r2, DefaultConstructorMarker r3) {
        super(r2);
        this.errorCode = r1;
        this.errorMsg = r2;
    }
}
