package com.obric.memorydata.memory.ui.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerContentTransition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "WINDOW_FADE_IN", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ImageViewerContentTransition extends Enum<ImageViewerContentTransition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ImageViewerContentTransition[] $VALUES = null;
    public static final ImageViewerContentTransition NONE = null;
    public static final ImageViewerContentTransition WINDOW_FADE_IN = null;

    private static final /* synthetic */ ImageViewerContentTransition[] $values() {
        return new ImageViewerContentTransition[]{NONE, WINDOW_FADE_IN};
    }

    static {
        NONE = new ImageViewerContentTransition("NONE", 0);
        WINDOW_FADE_IN = new ImageViewerContentTransition("WINDOW_FADE_IN", 1);
        ImageViewerContentTransition[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ImageViewerContentTransition(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ImageViewerContentTransition> getEntries() {
        return $ENTRIES;
    }

    public static ImageViewerContentTransition valueOf(String r2) {
        return (ImageViewerContentTransition) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageViewerContentTransition.class, r2), ImageViewerContentTransition.class, "com.obric.memorydata.plugin");
    }

    public static ImageViewerContentTransition[] values() {
        return (ImageViewerContentTransition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageViewerContentTransition[].class, "com.obric.memorydata.plugin");
    }
}
