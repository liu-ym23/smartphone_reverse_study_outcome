package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemSymbol;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id", "J", "getId", "()J", "priority", "getPriority", "setPriority", "(J)V", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "area", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "getArea", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "setArea", "(Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;)V", "OPEN_PROFILE_SYMBOL", "REPLY", "PIN_COMMENT_SYMBOL", "SECRET_CHAT", "REPLY_AND_PIN_SYMBOL", "PIN_ROOMMESSAGE", "MARK_USER", "LINK_MIC", "OPEN_VIDEO_SYMBOL", "OPEN_MICROAPP_SYMBOL", "PUBLIC_SCREEN_HELPER", "PUBLIC_SCREEN_STYLE_SYMBOL", "COMMENT_CONTROL_MODE", "CREATE_CHAT_CHANNEL", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelItemSymbol extends Enum<PanelItemSymbol> {
    public static final PanelItemSymbol COMMENT_CONTROL_MODE = null;
    public static final PanelItemSymbol CREATE_CHAT_CHANNEL = null;
    public static final PanelItemSymbol LINK_MIC = null;
    public static final PanelItemSymbol MARK_USER = null;
    public static final PanelItemSymbol OPEN_MICROAPP_SYMBOL = null;
    public static final PanelItemSymbol OPEN_PROFILE_SYMBOL = null;
    public static final PanelItemSymbol OPEN_VIDEO_SYMBOL = null;
    public static final PanelItemSymbol PIN_COMMENT_SYMBOL = null;
    public static final PanelItemSymbol PIN_ROOMMESSAGE = null;
    public static final PanelItemSymbol PUBLIC_SCREEN_HELPER = null;
    public static final PanelItemSymbol PUBLIC_SCREEN_STYLE_SYMBOL = null;
    public static final PanelItemSymbol REPLY = null;
    public static final PanelItemSymbol REPLY_AND_PIN_SYMBOL = null;
    public static final PanelItemSymbol SECRET_CHAT = null;
    public static final /* synthetic */ PanelItemSymbol[] a = null;
    private PanelItemShowArea area;
    private final long id;
    private long priority;

    public static PanelItemSymbol valueOf(String r1) {
        return (PanelItemSymbol) a.a(PanelItemSymbol.class, r1);
    }

    public static PanelItemSymbol[] values() {
        return (PanelItemSymbol[]) a.clone();
    }

    static {
        PanelItemShowArea r18 = PanelItemShowArea.TOP;
        PanelItemSymbol r9 = new PanelItemSymbol("OPEN_PROFILE_SYMBOL", 0, 1, 1000, r18);
        OPEN_PROFILE_SYMBOL = r9;
        PanelItemSymbol r1 = new PanelItemSymbol("REPLY", 1, 2, 900, r18);
        REPLY = r1;
        PanelItemSymbol r2 = new PanelItemSymbol("PIN_COMMENT_SYMBOL", 2, 3, 800, r18);
        PIN_COMMENT_SYMBOL = r2;
        PanelItemSymbol r3 = new PanelItemSymbol("SECRET_CHAT", 3, 4, 700, r18);
        SECRET_CHAT = r3;
        PanelItemShowArea r4 = PanelItemShowArea.MIDDLE;
        PanelItemSymbol r5 = new PanelItemSymbol("REPLY_AND_PIN_SYMBOL", 4, 101, 1000, r4);
        REPLY_AND_PIN_SYMBOL = r5;
        PanelItemSymbol r6 = new PanelItemSymbol("PIN_ROOMMESSAGE", 5, 102, 900, r4);
        PIN_ROOMMESSAGE = r6;
        PanelItemSymbol r7 = new PanelItemSymbol("MARK_USER", 6, 103, 800, r4);
        MARK_USER = r7;
        PanelItemSymbol r8 = new PanelItemSymbol("LINK_MIC", 7, 104, 700, r4);
        LINK_MIC = r8;
        PanelItemSymbol r10 = new PanelItemSymbol("OPEN_VIDEO_SYMBOL", 8, 105, 600, r4);
        OPEN_VIDEO_SYMBOL = r10;
        PanelItemSymbol r11 = new PanelItemSymbol("OPEN_MICROAPP_SYMBOL", 9, 106, 500, r4);
        OPEN_MICROAPP_SYMBOL = r11;
        PanelItemSymbol r13 = new PanelItemSymbol("PUBLIC_SCREEN_HELPER", 10, 107, 950, r4);
        PUBLIC_SCREEN_HELPER = r13;
        PanelItemShowArea r14 = PanelItemShowArea.BOTTOM;
        PanelItemSymbol r15 = new PanelItemSymbol("PUBLIC_SCREEN_STYLE_SYMBOL", 11, 201, 1000, r14);
        PUBLIC_SCREEN_STYLE_SYMBOL = r15;
        PanelItemSymbol r16 = new PanelItemSymbol("COMMENT_CONTROL_MODE", 12, 202, 900, r14);
        COMMENT_CONTROL_MODE = r16;
        PanelItemSymbol r17 = new PanelItemSymbol("CREATE_CHAT_CHANNEL", 13, 203, 1100, r14);
        CREATE_CHAT_CHANNEL = r17;
        a = new PanelItemSymbol[]{r9, r1, r2, r3, r5, r6, r7, r8, r10, r11, r13, r15, r16, r17};
    }

    public final PanelItemShowArea getArea() {
        return this.area;
    }

    public final long getId() {
        return this.id;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final void setArea(PanelItemShowArea r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.area = r2;
    }

    public final void setPriority(long r1) {
        this.priority = r1;
    }

    public PanelItemSymbol(String r1, int r2, long r3, long r5, PanelItemShowArea r7) {
        super(r1, r2);
        this.id = r3;
        this.priority = r5;
        this.area = r7;
    }
}
