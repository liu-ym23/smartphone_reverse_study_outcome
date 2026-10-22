package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010*\u001a\u00020)J\b\u0010/\u001a\u000200H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/UIConfig;", "Ljava/io/Serializable;", "<init>", "()V", "header", "Lcom/ss/android/lark/inline/ai/api/creationai/Header;", "getHeader", "()Lcom/ss/android/lark/inline/ai/api/creationai/Header;", "setHeader", "(Lcom/ss/android/lark/inline/ai/api/creationai/Header;)V", "label", "Lcom/ss/android/lark/inline/ai/api/creationai/Label;", "getLabel", "()Lcom/ss/android/lark/inline/ai/api/creationai/Label;", "setLabel", "(Lcom/ss/android/lark/inline/ai/api/creationai/Label;)V", "recommend", "Lcom/ss/android/lark/inline/ai/api/creationai/Recommend;", "getRecommend", "()Lcom/ss/android/lark/inline/ai/api/creationai/Recommend;", "setRecommend", "(Lcom/ss/android/lark/inline/ai/api/creationai/Recommend;)V", "footer", "Lcom/ss/android/lark/inline/ai/api/creationai/Footer;", "getFooter", "()Lcom/ss/android/lark/inline/ai/api/creationai/Footer;", "setFooter", "(Lcom/ss/android/lark/inline/ai/api/creationai/Footer;)V", "buttonGroups", "Lcom/ss/android/lark/inline/ai/api/creationai/ButtonGroups;", "getButtonGroups", "()Lcom/ss/android/lark/inline/ai/api/creationai/ButtonGroups;", "setButtonGroups", "(Lcom/ss/android/lark/inline/ai/api/creationai/ButtonGroups;)V", "input", "Lcom/ss/android/lark/inline/ai/api/creationai/Input;", "getInput", "()Lcom/ss/android/lark/inline/ai/api/creationai/Input;", "setInput", "(Lcom/ss/android/lark/inline/ai/api/creationai/Input;)V", "lock", "", "getLock", "()Ljava/lang/Boolean;", "setLock", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UIConfig implements Serializable {
    private ButtonGroups buttonGroups;
    private Footer footer;
    private Header header;
    private Input input;
    private Label label;
    private Boolean lock;
    private Recommend recommend;

    /* JADX INFO: renamed from: getLock, reason: collision with other method in class */
    public final boolean m826getLock() {
        Boolean r0 = this.lock;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public String toString() {
        return "UIConfig(header=" + this.header + ", label=" + this.label + ", recommend=" + this.recommend + ", footer=" + this.footer + ", buttonGroups=" + this.buttonGroups + ", input=" + this.input + ", lock=" + this.lock + ')';
    }

    public UIConfig() {
        this.lock = Boolean.TRUE;
    }

    public final ButtonGroups getButtonGroups() {
        return this.buttonGroups;
    }

    public final Footer getFooter() {
        return this.footer;
    }

    public final Header getHeader() {
        return this.header;
    }

    public final Input getInput() {
        return this.input;
    }

    public final Label getLabel() {
        return this.label;
    }

    public final Recommend getRecommend() {
        return this.recommend;
    }

    public final Boolean getLock() {
        return this.lock;
    }

    public final void setButtonGroups(ButtonGroups r1) {
        this.buttonGroups = r1;
    }

    public final void setFooter(Footer r1) {
        this.footer = r1;
    }

    public final void setHeader(Header r1) {
        this.header = r1;
    }

    public final void setInput(Input r1) {
        this.input = r1;
    }

    public final void setLabel(Label r1) {
        this.label = r1;
    }

    public final void setLock(Boolean r1) {
        this.lock = r1;
    }

    public final void setRecommend(Recommend r1) {
        this.recommend = r1;
    }
}
