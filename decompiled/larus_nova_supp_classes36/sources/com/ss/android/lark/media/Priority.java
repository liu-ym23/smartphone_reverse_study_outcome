package com.ss.android.lark.media;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/media/Priority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Low", "Default", "Medium", "High", "Companion", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = AnchorFit.END)
public final enum Priority extends Enum<Priority> {
    public static final a Companion = null;
    public static final Priority Default = null;
    public static final Priority High = null;
    public static final Priority Low = null;
    public static final Priority Medium = null;
    public static final /* synthetic */ Priority[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Priority> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.media.Priority$a] */
    static {
        Priority r0 = new Priority("Low", 0, 0);
        Low = r0;
        Priority r1 = new Priority("Default", 1, 1);
        Default = r1;
        Priority r3 = new Priority("Medium", 2, 2);
        Medium = r3;
        Priority r5 = new Priority("High", 3, 3);
        High = r5;
        Priority[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static Priority[] values() {
        return (Priority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Priority valueOf(String r1) {
        return (Priority) r27.a.a(Priority.class, r1);
    }

    public Priority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
