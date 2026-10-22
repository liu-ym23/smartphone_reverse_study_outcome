package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIPageMode;", "", "scene", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;)V", "getScene", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;", "setScene", "(Lcom/ss/android/lark/inline/ai/api/knowledgeai/CreateScene;)V", "HIDE", "BOTTOM_SHEET", "KEYBOARD", "isFromKeyboard", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum KnowledgeAIPageMode extends Enum<KnowledgeAIPageMode> {
    public static final KnowledgeAIPageMode BOTTOM_SHEET = null;
    public static final KnowledgeAIPageMode HIDE = null;
    public static final KnowledgeAIPageMode KEYBOARD = null;
    public static final /* synthetic */ KnowledgeAIPageMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private CreateScene scene;

    public static EnumEntries<KnowledgeAIPageMode> getEntries() {
        return b;
    }

    public final boolean isFromKeyboard() {
        return CollectionsKt.contains(SetsKt.setOf(new CreateScene[]{CreateScene.CREATE_KEYBOARD_FROM_QUOTE, CreateScene.KEYBOARD_SEND, CreateScene.KEYBOARD_RECOMMEND_QUESTION}), this.scene);
    }

    static {
        KnowledgeAIPageMode r6 = new KnowledgeAIPageMode("HIDE", 0, null, 1, null);
        HIDE = r6;
        KnowledgeAIPageMode r0 = new KnowledgeAIPageMode("BOTTOM_SHEET", 1, CreateScene.CLICK_ENTRY);
        BOTTOM_SHEET = r0;
        KnowledgeAIPageMode r1 = new KnowledgeAIPageMode("KEYBOARD", 2, CreateScene.CREATE_KEYBOARD_FROM_QUOTE);
        KEYBOARD = r1;
        KnowledgeAIPageMode[] r2 = {r6, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static KnowledgeAIPageMode[] values() {
        return (KnowledgeAIPageMode[]) a.clone();
    }

    public final CreateScene getScene() {
        return this.scene;
    }

    public static KnowledgeAIPageMode valueOf(String r1) {
        return (KnowledgeAIPageMode) r27.a.a(KnowledgeAIPageMode.class, r1);
    }

    public final KnowledgeAIPageMode setScene(CreateScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
        return this;
    }

    /* JADX INFO: renamed from: setScene, reason: collision with other method in class */
    public final void m829setScene(CreateScene r1) {
        this.scene = r1;
    }

    public KnowledgeAIPageMode(String r1, int r2, CreateScene r3) {
        super(r1, r2);
        this.scene = r3;
    }

    public /* synthetic */ KnowledgeAIPageMode(String r1, int r2, CreateScene r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
