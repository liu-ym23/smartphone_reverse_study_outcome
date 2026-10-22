package com.ss.android.lark.officesdk.minutes.api.fileupload.depend;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/depend/RecordingDownloadType;", "", "<init>", "(Ljava/lang/String;I)V", "Origin", "Cover", "Preview", "Image", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum RecordingDownloadType extends Enum<RecordingDownloadType> {
    public static final RecordingDownloadType Cover = null;
    public static final RecordingDownloadType Image = null;
    public static final RecordingDownloadType Origin = null;
    public static final RecordingDownloadType Preview = null;
    public static final /* synthetic */ RecordingDownloadType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecordingDownloadType> getEntries() {
        return b;
    }

    static {
        RecordingDownloadType r0 = new RecordingDownloadType("Origin", 0);
        Origin = r0;
        RecordingDownloadType r1 = new RecordingDownloadType("Cover", 1);
        Cover = r1;
        RecordingDownloadType r3 = new RecordingDownloadType("Preview", 2);
        Preview = r3;
        RecordingDownloadType r5 = new RecordingDownloadType("Image", 3);
        Image = r5;
        RecordingDownloadType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static RecordingDownloadType[] values() {
        return (RecordingDownloadType[]) a.clone();
    }

    public static RecordingDownloadType valueOf(String r1) {
        return (RecordingDownloadType) a.a(RecordingDownloadType.class, r1);
    }

    public RecordingDownloadType(String r1, int r2) {
        super(r1, r2);
    }
}
