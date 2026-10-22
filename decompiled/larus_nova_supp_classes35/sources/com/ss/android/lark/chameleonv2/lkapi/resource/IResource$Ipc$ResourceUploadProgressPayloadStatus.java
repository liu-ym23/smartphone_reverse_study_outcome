package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.api.service.track.sample.BaseSampleRecorder$Scene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Ipc$ResourceUploadProgressPayloadStatus;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Pending", "Inflight", "Failed", "Success", "Queue", "Ready", "RangeFinish", "Cancel", BaseSampleRecorder$Scene.UNKNOWN, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IResource$Ipc$ResourceUploadProgressPayloadStatus extends Enum<IResource$Ipc$ResourceUploadProgressPayloadStatus> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IResource$Ipc$ResourceUploadProgressPayloadStatus[] $VALUES = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Cancel = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Failed = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Inflight = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Pending = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Queue = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus RangeFinish = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Ready = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Success = null;
    public static final IResource$Ipc$ResourceUploadProgressPayloadStatus Unknown = null;
    private final String value;

    private static final /* synthetic */ IResource$Ipc$ResourceUploadProgressPayloadStatus[] $values() {
        return new IResource$Ipc$ResourceUploadProgressPayloadStatus[]{Pending, Inflight, Failed, Success, Queue, Ready, RangeFinish, Cancel, Unknown};
    }

    public static EnumEntries<IResource$Ipc$ResourceUploadProgressPayloadStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Pending = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Pending", 0, "pending");
        Inflight = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Inflight", 1, "inflight");
        Failed = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Failed", 2, ChameleonOpenTracker.OpenResult.FAILED);
        Success = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Success", 3, ChameleonOpenTracker.OpenResult.SUCCESS);
        Queue = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Queue", 4, "queue");
        Ready = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Ready", 5, "ready");
        RangeFinish = new IResource$Ipc$ResourceUploadProgressPayloadStatus("RangeFinish", 6, "range-finish");
        Cancel = new IResource$Ipc$ResourceUploadProgressPayloadStatus("Cancel", 7, ChameleonOpenTracker.OpenResult.CANCEL);
        Unknown = new IResource$Ipc$ResourceUploadProgressPayloadStatus(BaseSampleRecorder$Scene.UNKNOWN, 8, "unknown");
        IResource$Ipc$ResourceUploadProgressPayloadStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static IResource$Ipc$ResourceUploadProgressPayloadStatus[] values() {
        return (IResource$Ipc$ResourceUploadProgressPayloadStatus[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IResource$Ipc$ResourceUploadProgressPayloadStatus valueOf(String r1) {
        return (IResource$Ipc$ResourceUploadProgressPayloadStatus) a.a(IResource$Ipc$ResourceUploadProgressPayloadStatus.class, r1);
    }

    private IResource$Ipc$ResourceUploadProgressPayloadStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
