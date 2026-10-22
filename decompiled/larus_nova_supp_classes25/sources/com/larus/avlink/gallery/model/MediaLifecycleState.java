package com.larus.avlink.gallery.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/avlink/gallery/model/MediaLifecycleState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DOWNLOAD", "DOWNLOADED_TEMP", "PROCESSING", "PROCESSED", "SYNCING_TO_SYSTEM_ALBUM", "COMPLETED", "FAILED", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MediaLifecycleState extends Enum<MediaLifecycleState> {
    public static final MediaLifecycleState COMPLETED = null;
    public static final a Companion = null;
    public static final MediaLifecycleState DOWNLOAD = null;
    public static final MediaLifecycleState DOWNLOADED_TEMP = null;
    public static final MediaLifecycleState FAILED = null;
    public static final MediaLifecycleState PROCESSED = null;
    public static final MediaLifecycleState PROCESSING = null;
    public static final MediaLifecycleState SYNCING_TO_SYSTEM_ALBUM = null;
    public static final /* synthetic */ MediaLifecycleState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MediaLifecycleState> getEntries() {
        return b;
    }

    static {
        MediaLifecycleState r0 = new MediaLifecycleState("DOWNLOAD", 0, 0);
        DOWNLOAD = r0;
        MediaLifecycleState r1 = new MediaLifecycleState("DOWNLOADED_TEMP", 1, 1);
        DOWNLOADED_TEMP = r1;
        MediaLifecycleState r3 = new MediaLifecycleState("PROCESSING", 2, 2);
        PROCESSING = r3;
        MediaLifecycleState r5 = new MediaLifecycleState("PROCESSED", 3, 3);
        PROCESSED = r5;
        MediaLifecycleState r7 = new MediaLifecycleState("SYNCING_TO_SYSTEM_ALBUM", 4, 4);
        SYNCING_TO_SYSTEM_ALBUM = r7;
        MediaLifecycleState r9 = new MediaLifecycleState("COMPLETED", 5, 5);
        COMPLETED = r9;
        MediaLifecycleState r11 = new MediaLifecycleState("FAILED", 6, 99);
        FAILED = r11;
        MediaLifecycleState[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static MediaLifecycleState[] values() {
        return (MediaLifecycleState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MediaLifecycleState valueOf(String r1) {
        return (MediaLifecycleState) r27.a.a(MediaLifecycleState.class, r1);
    }

    public MediaLifecycleState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
