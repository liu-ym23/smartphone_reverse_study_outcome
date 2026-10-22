package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/KeyboardInputPocket;", "", "inputBoxTitle", "", "inputPlaceholder", "inputPlaceholderPrompt", "inputPlaceholderPromptForModel", "selectedModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInputBoxTitle", "()Ljava/lang/String;", "getInputPlaceholder", "getInputPlaceholderPrompt", "getInputPlaceholderPromptForModel", "getSelectedModel", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KeyboardInputPocket {

    @SerializedName("input_box_title")
    private final String inputBoxTitle;

    @SerializedName("input_placeholder")
    private final String inputPlaceholder;

    @SerializedName("input_placeholder_prompt")
    private final String inputPlaceholderPrompt;

    @SerializedName("input_placeholder_prompt_for_model")
    private final String inputPlaceholderPromptForModel;

    @SerializedName("selected_model")
    private final String selectedModel;

    public KeyboardInputPocket() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ KeyboardInputPocket copy$default(KeyboardInputPocket r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.inputBoxTitle;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.inputPlaceholder;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.inputPlaceholderPrompt;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.inputPlaceholderPromptForModel;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.selectedModel;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.inputBoxTitle;
    }

    public final String component2() {
        return this.inputPlaceholder;
    }

    public final String component3() {
        return this.inputPlaceholderPrompt;
    }

    public final String component4() {
        return this.inputPlaceholderPromptForModel;
    }

    public final String component5() {
        return this.selectedModel;
    }

    public final KeyboardInputPocket copy(String r8, String r9, String r10, String r11, String r12) {
        return new KeyboardInputPocket(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KeyboardInputPocket) == true) goto L8;
        return false;
    L8:
        KeyboardInputPocket r6 = (KeyboardInputPocket) r5;
        if (Intrinsics.areEqual(this.inputBoxTitle, r6.inputBoxTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputPlaceholder, r6.inputPlaceholder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputPlaceholderPrompt, r6.inputPlaceholderPrompt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputPlaceholderPromptForModel, r6.inputPlaceholderPromptForModel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectedModel, r6.selectedModel) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.inputBoxTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.inputPlaceholder;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.inputPlaceholderPrompt;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.inputPlaceholderPromptForModel;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.selectedModel;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KeyboardInputPocket(inputBoxTitle=" + this.inputBoxTitle + ", inputPlaceholder=" + this.inputPlaceholder + ", inputPlaceholderPrompt=" + this.inputPlaceholderPrompt + ", inputPlaceholderPromptForModel=" + this.inputPlaceholderPromptForModel + ", selectedModel=" + this.selectedModel + ')';
    }

    public final String getInputBoxTitle() {
        return this.inputBoxTitle;
    }

    public final String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    public final String getInputPlaceholderPrompt() {
        return this.inputPlaceholderPrompt;
    }

    public final String getInputPlaceholderPromptForModel() {
        return this.inputPlaceholderPromptForModel;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public KeyboardInputPocket(String r1, String r2, String r3, String r4, String r5) {
        this.inputBoxTitle = r1;
        this.inputPlaceholder = r2;
        this.inputPlaceholderPrompt = r3;
        this.inputPlaceholderPromptForModel = r4;
        this.selectedModel = r5;
    }

    public /* synthetic */ KeyboardInputPocket(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = "";
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r10 & 8) == 0) goto L17;
        r8 = null;
    L17:
        String r3 = r8;
        if ((r10 & 16) == 0) goto L20;
        String r13 = "";
    L21:
        this(r12, r1, r2, r3, r13);
        return;
    L20:
        r13 = r9;
        goto L21
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
