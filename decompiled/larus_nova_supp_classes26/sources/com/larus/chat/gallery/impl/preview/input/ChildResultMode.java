package com.larus.chat.gallery.impl.preview.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/input/ChildResultMode;", "", "<init>", "(Ljava/lang/String;I)V", "APPEND", "ALBUM_APPEND", "EDIT_REPLACE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChildResultMode extends Enum<ChildResultMode> {
    public static final ChildResultMode ALBUM_APPEND = null;
    public static final ChildResultMode APPEND = null;
    public static final ChildResultMode EDIT_REPLACE = null;
    public static final /* synthetic */ ChildResultMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChildResultMode> getEntries() {
        return b;
    }

    static {
        ChildResultMode r0 = new ChildResultMode("APPEND", 0);
        APPEND = r0;
        ChildResultMode r1 = new ChildResultMode("ALBUM_APPEND", 1);
        ALBUM_APPEND = r1;
        ChildResultMode r3 = new ChildResultMode("EDIT_REPLACE", 2);
        EDIT_REPLACE = r3;
        ChildResultMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ChildResultMode[] values() {
        return (ChildResultMode[]) a.clone();
    }

    public static ChildResultMode valueOf(String r1) {
        return (ChildResultMode) r27.a.a(ChildResultMode.class, r1);
    }

    public ChildResultMode(String r1, int r2) {
        super(r1, r2);
    }
}
