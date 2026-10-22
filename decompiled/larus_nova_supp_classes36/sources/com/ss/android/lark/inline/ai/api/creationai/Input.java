package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/Input;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "writingStatus", "", "getWritingStatus", "()Ljava/lang/String;", "setWritingStatus", "(Ljava/lang/String;)V", "text", "getText", "setText", "placeholder", "getPlaceholder", "setPlaceholder", "textContentList", "Lcom/ss/android/lark/inline/ai/api/creationai/TextContentList;", "getTextContentList", "()Lcom/ss/android/lark/inline/ai/api/creationai/TextContentList;", "setTextContentList", "(Lcom/ss/android/lark/inline/ai/api/creationai/TextContentList;)V", "writingText", "getWritingText", "setWritingText", "showStopBtn", "getShowStopBtn", "setShowStopBtn", "showKeyboard", "getShowKeyboard", "()Ljava/lang/Boolean;", "setShowKeyboard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toString", "Status", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Input implements Serializable {
    private String placeholder;
    private boolean show;
    private Boolean showKeyboard;
    private boolean showStopBtn;
    private String text;
    private TextContentList textContentList;
    private String writingStatus;
    private String writingText;

    public String toString() {
        StringBuilder r0 = new StringBuilder("Input(show=");
        r0.append(this.show);
        r0.append(", writingStatus=");
        r0.append(this.writingStatus);
        r0.append(", text.length=");
        String r1 = this.text;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", placeholder=");
        r0.append(this.placeholder);
        r0.append(", writingText=");
        r0.append(this.writingText);
        r0.append(", showStopBtn=");
        r0.append(this.showStopBtn);
        r0.append(", showKeyboard=");
        r0.append(this.showKeyboard);
        r0.append(", textContentList=");
        r0.append(this.textContentList);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public Input() {
        this.writingStatus = "waiting";
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final Boolean getShowKeyboard() {
        return this.showKeyboard;
    }

    public final boolean getShowStopBtn() {
        return this.showStopBtn;
    }

    public final String getText() {
        return this.text;
    }

    public final TextContentList getTextContentList() {
        return this.textContentList;
    }

    public final String getWritingStatus() {
        return this.writingStatus;
    }

    public final String getWritingText() {
        return this.writingText;
    }

    public final void setPlaceholder(String r1) {
        this.placeholder = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setShowKeyboard(Boolean r1) {
        this.showKeyboard = r1;
    }

    public final void setShowStopBtn(boolean r1) {
        this.showStopBtn = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setTextContentList(TextContentList r1) {
        this.textContentList = r1;
    }

    public final void setWritingStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.writingStatus = r2;
    }

    public final void setWritingText(String r1) {
        this.writingText = r1;
    }
}
