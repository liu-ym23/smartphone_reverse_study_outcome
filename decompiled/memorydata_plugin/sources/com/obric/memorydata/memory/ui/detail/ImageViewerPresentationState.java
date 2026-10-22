package com.obric.memorydata.memory.ui.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerPresentationState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "LOADING_WITH_PROGRESS", "READY", "EXITING", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ImageViewerPresentationState extends Enum<ImageViewerPresentationState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ImageViewerPresentationState[] $VALUES = null;
    public static final ImageViewerPresentationState EXITING = null;
    public static final ImageViewerPresentationState LOADING = null;
    public static final ImageViewerPresentationState LOADING_WITH_PROGRESS = null;
    public static final ImageViewerPresentationState READY = null;

    private static final /* synthetic */ ImageViewerPresentationState[] $values() {
        return new ImageViewerPresentationState[]{LOADING, LOADING_WITH_PROGRESS, READY, EXITING};
    }

    static {
        LOADING = new ImageViewerPresentationState("LOADING", 0);
        LOADING_WITH_PROGRESS = new ImageViewerPresentationState("LOADING_WITH_PROGRESS", 1);
        READY = new ImageViewerPresentationState("READY", 2);
        EXITING = new ImageViewerPresentationState("EXITING", 3);
        ImageViewerPresentationState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ImageViewerPresentationState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ImageViewerPresentationState> getEntries() {
        return $ENTRIES;
    }

    public static ImageViewerPresentationState valueOf(String r2) {
        return (ImageViewerPresentationState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageViewerPresentationState.class, r2), ImageViewerPresentationState.class, "com.obric.memorydata.plugin");
    }

    public static ImageViewerPresentationState[] values() {
        return (ImageViewerPresentationState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageViewerPresentationState[].class, "com.obric.memorydata.plugin");
    }
}
