package com.larus.chat.gallery.impl.preview.toolbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarVisualStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "MEDIA_SOURCE_V4", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolbarVisualStyle extends Enum<ToolbarVisualStyle> {
    public static final ToolbarVisualStyle LEGACY = null;
    public static final ToolbarVisualStyle MEDIA_SOURCE_V4 = null;
    public static final /* synthetic */ ToolbarVisualStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ToolbarVisualStyle> getEntries() {
        return b;
    }

    static {
        ToolbarVisualStyle r0 = new ToolbarVisualStyle("LEGACY", 0);
        LEGACY = r0;
        ToolbarVisualStyle r1 = new ToolbarVisualStyle("MEDIA_SOURCE_V4", 1);
        MEDIA_SOURCE_V4 = r1;
        ToolbarVisualStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ToolbarVisualStyle[] values() {
        return (ToolbarVisualStyle[]) a.clone();
    }

    public static ToolbarVisualStyle valueOf(String r1) {
        return (ToolbarVisualStyle) r27.a.a(ToolbarVisualStyle.class, r1);
    }

    public ToolbarVisualStyle(String r1, int r2) {
        super(r1, r2);
    }
}
