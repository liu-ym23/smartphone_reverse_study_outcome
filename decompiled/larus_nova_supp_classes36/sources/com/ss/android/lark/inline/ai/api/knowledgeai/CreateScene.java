package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_KEYBOARD_FROM_QUOTE", "CLICK_ENTRY", "EXPLAIN_QUERY", "KEYBOARD_SEND", "KEYBOARD_RECOMMEND_QUESTION", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum CreateScene extends Enum<CreateScene> {
    public static final CreateScene CLICK_ENTRY = null;
    public static final CreateScene CREATE_KEYBOARD_FROM_QUOTE = null;
    public static final CreateScene EXPLAIN_QUERY = null;
    public static final CreateScene KEYBOARD_RECOMMEND_QUESTION = null;
    public static final CreateScene KEYBOARD_SEND = null;
    public static final /* synthetic */ CreateScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreateScene> getEntries() {
        return b;
    }

    static {
        CreateScene r0 = new CreateScene("CREATE_KEYBOARD_FROM_QUOTE", 0);
        CREATE_KEYBOARD_FROM_QUOTE = r0;
        CreateScene r1 = new CreateScene("CLICK_ENTRY", 1);
        CLICK_ENTRY = r1;
        CreateScene r3 = new CreateScene("EXPLAIN_QUERY", 2);
        EXPLAIN_QUERY = r3;
        CreateScene r5 = new CreateScene("KEYBOARD_SEND", 3);
        KEYBOARD_SEND = r5;
        CreateScene r7 = new CreateScene("KEYBOARD_RECOMMEND_QUESTION", 4);
        KEYBOARD_RECOMMEND_QUESTION = r7;
        CreateScene[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CreateScene[] values() {
        return (CreateScene[]) a.clone();
    }

    public static CreateScene valueOf(String r1) {
        return (CreateScene) r27.a.a(CreateScene.class, r1);
    }

    public CreateScene(String r1, int r2) {
        super(r1, r2);
    }
}
