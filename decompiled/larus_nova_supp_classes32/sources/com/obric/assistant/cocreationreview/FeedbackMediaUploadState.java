package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/cocreationreview/FeedbackMediaUploadState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "READY", "UPLOADING", "UPLOADED", "FAILED", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackMediaUploadState extends Enum<FeedbackMediaUploadState> {
    public static final FeedbackMediaUploadState FAILED = null;
    public static final FeedbackMediaUploadState READY = null;
    public static final FeedbackMediaUploadState UPLOADED = null;
    public static final FeedbackMediaUploadState UPLOADING = null;
    public static final /* synthetic */ FeedbackMediaUploadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedbackMediaUploadState> getEntries() {
        return b;
    }

    static {
        FeedbackMediaUploadState r0 = new FeedbackMediaUploadState("READY", 0);
        READY = r0;
        FeedbackMediaUploadState r1 = new FeedbackMediaUploadState("UPLOADING", 1);
        UPLOADING = r1;
        FeedbackMediaUploadState r3 = new FeedbackMediaUploadState("UPLOADED", 2);
        UPLOADED = r3;
        FeedbackMediaUploadState r5 = new FeedbackMediaUploadState("FAILED", 3);
        FAILED = r5;
        FeedbackMediaUploadState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static FeedbackMediaUploadState[] values() {
        return (FeedbackMediaUploadState[]) a.clone();
    }

    public static FeedbackMediaUploadState valueOf(String r1) {
        return (FeedbackMediaUploadState) r27.a.a(FeedbackMediaUploadState.class, r1);
    }

    public FeedbackMediaUploadState(String r1, int r2) {
        super(r1, r2);
    }
}
