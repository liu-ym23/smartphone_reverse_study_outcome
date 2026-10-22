package com.larus.bmhome.view.actionbar.custom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/ActionBarShowFrom;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DIRECT_SHOW", "PLUS_PANNEL", "CLEAR_MEMORY", "PLUS_PANNEL_SLIDE", "SLIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarShowFrom extends Enum<ActionBarShowFrom> {
    public static final ActionBarShowFrom CLEAR_MEMORY = null;
    public static final ActionBarShowFrom DIRECT_SHOW = null;
    public static final ActionBarShowFrom PLUS_PANNEL = null;
    public static final ActionBarShowFrom PLUS_PANNEL_SLIDE = null;
    public static final ActionBarShowFrom SLIDE = null;
    public static final /* synthetic */ ActionBarShowFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<ActionBarShowFrom> getEntries() {
        return b;
    }

    static {
        ActionBarShowFrom r0 = new ActionBarShowFrom("DIRECT_SHOW", 0, "direct_show");
        DIRECT_SHOW = r0;
        ActionBarShowFrom r1 = new ActionBarShowFrom("PLUS_PANNEL", 1, "plus_pannel");
        PLUS_PANNEL = r1;
        ActionBarShowFrom r2 = new ActionBarShowFrom("CLEAR_MEMORY", 2, "clear_memory");
        CLEAR_MEMORY = r2;
        ActionBarShowFrom r4 = new ActionBarShowFrom("PLUS_PANNEL_SLIDE", 3, "plus_pannel_slide");
        PLUS_PANNEL_SLIDE = r4;
        ActionBarShowFrom r6 = new ActionBarShowFrom("SLIDE", 4, "slide");
        SLIDE = r6;
        ActionBarShowFrom[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static ActionBarShowFrom[] values() {
        return (ActionBarShowFrom[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ActionBarShowFrom valueOf(String r1) {
        return (ActionBarShowFrom) r27.a.a(ActionBarShowFrom.class, r1);
    }

    public ActionBarShowFrom(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
