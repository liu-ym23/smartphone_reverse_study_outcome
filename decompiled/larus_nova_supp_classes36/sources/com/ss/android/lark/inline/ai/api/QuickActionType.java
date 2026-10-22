package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/QuickActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PromptTask", "API", "Companion", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum QuickActionType extends Enum<QuickActionType> {
    public static final QuickActionType API = null;
    public static final a Companion = null;
    public static final QuickActionType PromptTask = null;
    public static final /* synthetic */ QuickActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<QuickActionType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.inline.ai.api.QuickActionType$a] */
    static {
        QuickActionType r0 = new QuickActionType("PromptTask", 0, 0);
        PromptTask = r0;
        QuickActionType r1 = new QuickActionType("API", 1, 1);
        API = r1;
        QuickActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static QuickActionType[] values() {
        return (QuickActionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickActionType valueOf(String r1) {
        return (QuickActionType) r27.a.a(QuickActionType.class, r1);
    }

    public QuickActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
