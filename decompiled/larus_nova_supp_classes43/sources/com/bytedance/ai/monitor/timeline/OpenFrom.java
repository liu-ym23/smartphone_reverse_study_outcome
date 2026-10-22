package com.bytedance.ai.monitor.timeline;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/OpenFrom;", "", a.KEY_FROM, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "APPLET_MAIN_OPEN", "APPLET_VIEW_OPEN", "OLD_APPLET_MAIN_OPEN", "OLD_APPLET_VIEW_OPEN", "NATIVE", "DEBUG", "OLD_APPLET_MAIN_CREATE", "OLD_APPLET_VIEW_CREATE", "APPLET_APP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFrom extends Enum<OpenFrom> {
    public static final OpenFrom APPLET_APP = null;
    public static final OpenFrom APPLET_MAIN_OPEN = null;
    public static final OpenFrom APPLET_VIEW_OPEN = null;
    public static final OpenFrom DEBUG = null;
    public static final OpenFrom NATIVE = null;
    public static final OpenFrom OLD_APPLET_MAIN_CREATE = null;
    public static final OpenFrom OLD_APPLET_MAIN_OPEN = null;
    public static final OpenFrom OLD_APPLET_VIEW_CREATE = null;
    public static final OpenFrom OLD_APPLET_VIEW_OPEN = null;
    public static final /* synthetic */ OpenFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String from;

    public static EnumEntries<OpenFrom> getEntries() {
        return b;
    }

    static {
        OpenFrom r0 = new OpenFrom("APPLET_MAIN_OPEN", 0, "applet_main_open");
        APPLET_MAIN_OPEN = r0;
        OpenFrom r1 = new OpenFrom("APPLET_VIEW_OPEN", 1, "applet_view_open");
        APPLET_VIEW_OPEN = r1;
        OpenFrom r10 = new OpenFrom("OLD_APPLET_MAIN_OPEN", 2, "old_applet_main_open");
        OLD_APPLET_MAIN_OPEN = r10;
        OpenFrom r11 = new OpenFrom("OLD_APPLET_VIEW_OPEN", 3, "old_applet_view_open");
        OLD_APPLET_VIEW_OPEN = r11;
        OpenFrom r12 = new OpenFrom("NATIVE", 4, a.VALUE_NATIVE);
        NATIVE = r12;
        OpenFrom r13 = new OpenFrom("DEBUG", 5, "debug");
        DEBUG = r13;
        OpenFrom r14 = new OpenFrom("OLD_APPLET_MAIN_CREATE", 6, "applet_main_create");
        OLD_APPLET_MAIN_CREATE = r14;
        OpenFrom r15 = new OpenFrom("OLD_APPLET_VIEW_CREATE", 7, "applet_main_create");
        OLD_APPLET_VIEW_CREATE = r15;
        OpenFrom r16 = new OpenFrom("APPLET_APP", 8, "applet_app");
        APPLET_APP = r16;
        OpenFrom[] r17 = {r0, r1, r10, r11, r12, r13, r14, r15, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static OpenFrom[] values() {
        return (OpenFrom[]) a.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    public static OpenFrom valueOf(String r1) {
        return (OpenFrom) r27.a.a(OpenFrom.class, r1);
    }

    public OpenFrom(String r1, int r10, String r11) {
        super(r1, r10);
        this.from = r11;
    }
}
