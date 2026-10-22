package com.obric.assistant.ability;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/ability/ObricSpecialInputScene;", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "OAUTO_GUI", "OAUTO_TIMER_TASK", "COMPLEX_TASK", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSpecialInputScene extends Enum<ObricSpecialInputScene> {
    public static final ObricSpecialInputScene COMPLEX_TASK = null;
    public static final a Companion = null;
    public static final ObricSpecialInputScene OAUTO_GUI = null;
    public static final ObricSpecialInputScene OAUTO_TIMER_TASK = null;
    public static final /* synthetic */ ObricSpecialInputScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<ObricSpecialInputScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.ability.ObricSpecialInputScene$a] */
    static {
        ObricSpecialInputScene r0 = new ObricSpecialInputScene("OAUTO_GUI", 0, "auto_gui");
        OAUTO_GUI = r0;
        ObricSpecialInputScene r1 = new ObricSpecialInputScene("OAUTO_TIMER_TASK", 1, "auto_timer_task");
        OAUTO_TIMER_TASK = r1;
        ObricSpecialInputScene r3 = new ObricSpecialInputScene("COMPLEX_TASK", 2, "complex_task");
        COMPLEX_TASK = r3;
        ObricSpecialInputScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ObricSpecialInputScene[] values() {
        return (ObricSpecialInputScene[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ObricSpecialInputScene valueOf(String r1) {
        return (ObricSpecialInputScene) r27.a.a(ObricSpecialInputScene.class, r1);
    }

    public ObricSpecialInputScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
