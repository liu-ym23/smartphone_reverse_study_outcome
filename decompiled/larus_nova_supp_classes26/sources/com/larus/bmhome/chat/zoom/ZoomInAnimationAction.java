package com.larus.bmhome.chat.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomInAnimationAction extends Enum<ZoomInAnimationAction> {
    public static final ZoomInAnimationAction HIDE = null;
    public static final ZoomInAnimationAction SHOW = null;
    public static final /* synthetic */ ZoomInAnimationAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ZoomInAnimationAction> getEntries() {
        return b;
    }

    static {
        ZoomInAnimationAction r0 = new ZoomInAnimationAction("SHOW", 0);
        SHOW = r0;
        ZoomInAnimationAction r1 = new ZoomInAnimationAction("HIDE", 1);
        HIDE = r1;
        ZoomInAnimationAction[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ZoomInAnimationAction[] values() {
        return (ZoomInAnimationAction[]) a.clone();
    }

    public static ZoomInAnimationAction valueOf(String r1) {
        return (ZoomInAnimationAction) a.a(ZoomInAnimationAction.class, r1);
    }

    public ZoomInAnimationAction(String r1, int r2) {
        super(r1, r2);
    }
}
