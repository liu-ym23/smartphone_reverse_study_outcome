package com.larus.voicecall.impl.component.denoise;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/DenoiseUploadStatus;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AuthorizedAndEnabled", "Enable", "Close", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DenoiseUploadStatus extends Enum<DenoiseUploadStatus> {
    public static final DenoiseUploadStatus AuthorizedAndEnabled = null;
    public static final DenoiseUploadStatus Close = null;
    public static final DenoiseUploadStatus Enable = null;
    public static final /* synthetic */ DenoiseUploadStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DenoiseUploadStatus> getEntries() {
        return b;
    }

    static {
        DenoiseUploadStatus r0 = new DenoiseUploadStatus("AuthorizedAndEnabled", 0, 1);
        AuthorizedAndEnabled = r0;
        DenoiseUploadStatus r1 = new DenoiseUploadStatus("Enable", 1, 2);
        Enable = r1;
        DenoiseUploadStatus r4 = new DenoiseUploadStatus("Close", 2, 3);
        Close = r4;
        DenoiseUploadStatus[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DenoiseUploadStatus[] values() {
        return (DenoiseUploadStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DenoiseUploadStatus valueOf(String r1) {
        return (DenoiseUploadStatus) r27.a.a(DenoiseUploadStatus.class, r1);
    }

    public DenoiseUploadStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
