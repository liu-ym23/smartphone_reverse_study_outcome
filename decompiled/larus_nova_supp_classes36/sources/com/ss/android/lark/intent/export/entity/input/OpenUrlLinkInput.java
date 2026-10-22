package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/OpenUrlLinkInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "toString", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OpenUrlLinkInput extends IntentInput implements Serializable {
    private final String url;

    public String toString() {
        StringBuilder r0 = new StringBuilder("OpenUrlLinkInput(url=");
        String r1 = this.url;
        if (r1 == null) goto L6;
        String r2 = a.a(r1);
        if (r2 == null) goto L6;
    L7:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L6:
        r2 = "nil";
        goto L7
    }

    public final String getUrl() {
        return this.url;
    }

    public OpenUrlLinkInput(String r2) {
        super(IntentInput.IntentType.OPEN_URL);
        this.url = r2;
    }
}
