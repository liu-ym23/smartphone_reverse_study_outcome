package com.ss.android.lark.media;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/media/MediaType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Audio_Record", "Audio_Play", "Camera", "Companion", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = AnchorFit.END)
public final enum MediaType extends Enum<MediaType> {
    public static final MediaType Audio_Play = null;
    public static final MediaType Audio_Record = null;
    public static final MediaType Camera = null;
    public static final a Companion = null;
    public static final /* synthetic */ MediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MediaType> getEntries() {
        return b;
    }

    static {
        MediaType r0 = new MediaType("Audio_Record", 0, 0);
        Audio_Record = r0;
        MediaType r1 = new MediaType("Audio_Play", 1, 1);
        Audio_Play = r1;
        MediaType r3 = new MediaType("Camera", 2, 2);
        Camera = r3;
        MediaType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static MediaType[] values() {
        return (MediaType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MediaType valueOf(String r1) {
        return (MediaType) r27.a.a(MediaType.class, r1);
    }

    public MediaType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
