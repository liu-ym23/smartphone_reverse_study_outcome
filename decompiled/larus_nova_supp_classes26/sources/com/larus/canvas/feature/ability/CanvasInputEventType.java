package com.larus.canvas.feature.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/canvas/feature/ability/CanvasInputEventType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "EVENT_CLICK_SEND_BUTTON", "EVENT_FINISH_SPEAK", "EVENT_FINISH_PASTE_AND_SEND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasInputEventType extends Enum<CanvasInputEventType> {
    public static final CanvasInputEventType EVENT_CLICK_SEND_BUTTON = null;
    public static final CanvasInputEventType EVENT_FINISH_PASTE_AND_SEND = null;
    public static final CanvasInputEventType EVENT_FINISH_SPEAK = null;
    public static final CanvasInputEventType NONE = null;
    public static final /* synthetic */ CanvasInputEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CanvasInputEventType> getEntries() {
        return b;
    }

    static {
        CanvasInputEventType r0 = new CanvasInputEventType("NONE", 0);
        NONE = r0;
        CanvasInputEventType r1 = new CanvasInputEventType("EVENT_CLICK_SEND_BUTTON", 1);
        EVENT_CLICK_SEND_BUTTON = r1;
        CanvasInputEventType r3 = new CanvasInputEventType("EVENT_FINISH_SPEAK", 2);
        EVENT_FINISH_SPEAK = r3;
        CanvasInputEventType r5 = new CanvasInputEventType("EVENT_FINISH_PASTE_AND_SEND", 3);
        EVENT_FINISH_PASTE_AND_SEND = r5;
        CanvasInputEventType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static CanvasInputEventType[] values() {
        return (CanvasInputEventType[]) a.clone();
    }

    public static CanvasInputEventType valueOf(String r1) {
        return (CanvasInputEventType) a.a(CanvasInputEventType.class, r1);
    }

    public CanvasInputEventType(String r1, int r2) {
        super(r1, r2);
    }
}
