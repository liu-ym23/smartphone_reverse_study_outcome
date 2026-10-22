package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/InlineAIErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "InlineAI_UNUSABLE_CODE", "INLINEAI_ADMINDEACTIVATED_CODE", "InlineAI_INPUT_COMPLIENCE_ERROR", "InlineAI_OUTPUT_COMPLIENCE_ERROR", "InlineAI_CROSS_REGION_ERROR", "InlineAI_CROSS_BRAND_ERROR", "InlineAI_NOPERMISSION_CODE", "Companion", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum InlineAIErrorCode extends Enum<InlineAIErrorCode> {
    public static final a Companion = null;
    public static final InlineAIErrorCode INLINEAI_ADMINDEACTIVATED_CODE = null;
    public static final InlineAIErrorCode InlineAI_CROSS_BRAND_ERROR = null;
    public static final InlineAIErrorCode InlineAI_CROSS_REGION_ERROR = null;
    public static final InlineAIErrorCode InlineAI_INPUT_COMPLIENCE_ERROR = null;
    public static final InlineAIErrorCode InlineAI_NOPERMISSION_CODE = null;
    public static final InlineAIErrorCode InlineAI_OUTPUT_COMPLIENCE_ERROR = null;
    public static final InlineAIErrorCode InlineAI_UNUSABLE_CODE = null;
    public static final /* synthetic */ InlineAIErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<InlineAIErrorCode> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.inline.ai.api.InlineAIErrorCode$a] */
    static {
        InlineAIErrorCode r0 = new InlineAIErrorCode("InlineAI_UNUSABLE_CODE", 0, -1);
        InlineAI_UNUSABLE_CODE = r0;
        InlineAIErrorCode r1 = new InlineAIErrorCode("INLINEAI_ADMINDEACTIVATED_CODE", 1, 666900005);
        INLINEAI_ADMINDEACTIVATED_CODE = r1;
        InlineAIErrorCode r3 = new InlineAIErrorCode("InlineAI_INPUT_COMPLIENCE_ERROR", 2, 13030);
        InlineAI_INPUT_COMPLIENCE_ERROR = r3;
        InlineAIErrorCode r5 = new InlineAIErrorCode("InlineAI_OUTPUT_COMPLIENCE_ERROR", 3, 13031);
        InlineAI_OUTPUT_COMPLIENCE_ERROR = r5;
        InlineAIErrorCode r7 = new InlineAIErrorCode("InlineAI_CROSS_REGION_ERROR", 4, 13020);
        InlineAI_CROSS_REGION_ERROR = r7;
        InlineAIErrorCode r9 = new InlineAIErrorCode("InlineAI_CROSS_BRAND_ERROR", 5, 13021);
        InlineAI_CROSS_BRAND_ERROR = r9;
        InlineAIErrorCode r11 = new InlineAIErrorCode("InlineAI_NOPERMISSION_CODE", 6, 4);
        InlineAI_NOPERMISSION_CODE = r11;
        InlineAIErrorCode[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static InlineAIErrorCode[] values() {
        return (InlineAIErrorCode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static InlineAIErrorCode valueOf(String r1) {
        return (InlineAIErrorCode) r27.a.a(InlineAIErrorCode.class, r1);
    }

    public InlineAIErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
