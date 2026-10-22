package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/Template;", "Ljava/io/Serializable;", "templateName", "", "placeHolder", TabAppInfo.IMAGE_JSON_KEY, "defaultUserInput", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTemplateName", "()Ljava/lang/String;", "setTemplateName", "(Ljava/lang/String;)V", "getPlaceHolder", "setPlaceHolder", "getKey", "setKey", "getDefaultUserInput", "setDefaultUserInput", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Template implements Serializable {
    private String defaultUserInput;
    private String key;
    private String placeHolder;
    private String templateName;

    public static /* synthetic */ Template copy$default(Template r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.templateName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.placeHolder;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.key;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.defaultUserInput;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.templateName;
    }

    public final String component2() {
        return this.placeHolder;
    }

    public final String component3() {
        return this.key;
    }

    public final String component4() {
        return this.defaultUserInput;
    }

    public final Template copy(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "templateName");
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r5, "defaultUserInput");
        return new Template(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Template) == true) goto L8;
        return false;
    L8:
        Template r6 = (Template) r5;
        if (Intrinsics.areEqual(this.templateName, r6.templateName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.placeHolder, r6.placeHolder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultUserInput, r6.defaultUserInput) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.templateName.hashCode() * 31;
        String r1 = this.placeHolder;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.key.hashCode()) * 31) + this.defaultUserInput.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Template(templateName='" + this.templateName + "', placeHolder=" + this.placeHolder + ", key='" + this.key + "')";
    }

    public final String getDefaultUserInput() {
        return this.defaultUserInput;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final void setDefaultUserInput(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.defaultUserInput = r2;
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setPlaceHolder(String r1) {
        this.placeHolder = r1;
    }

    public final void setTemplateName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templateName = r2;
    }

    public Template(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "templateName");
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r5, "defaultUserInput");
        this.templateName = r2;
        this.placeHolder = r3;
        this.key = r4;
        this.defaultUserInput = r5;
    }

    public /* synthetic */ Template(String r1, String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = "";
    L8:
        this(r1, r2, r3, r4);
    }
}
