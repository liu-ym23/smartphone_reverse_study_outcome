package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\b\u00105\u001a\u00020\u0003H\u0016J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\u001d\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0097\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010C\u001a\u00020\r2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018¨\u0006G"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Prompt;", "Ljava/io/Serializable;", "type", "", "id", TabAppInfo.IMAGE_JSON_KEY, "template", "icon", "", "text", "i18nKey", "originText", "rightArrow", "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "extras", "localId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getId", "setId", "getKey", "setKey", "getTemplate", "setTemplate", "getIcon", "()I", "setIcon", "(I)V", "getText", "setText", "getI18nKey", "setI18nKey", "getOriginText", "setOriginText", "getRightArrow", "()Z", "setRightArrow", "(Z)V", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getExtras", "setExtras", "getLocalId", "setLocalId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Prompt implements Serializable {
    private String extras;
    private String i18nKey;
    private int icon;
    private String id;
    private String key;
    private String localId;
    private String originText;
    private ArrayList<String> params;
    private boolean rightArrow;
    private String template;
    private String text;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Prompt copy$default(Prompt r13, String r14, String r15, String r16, String r17, int r18, String r19, String r20, String r21, boolean r22, ArrayList r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.type;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.id;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.key;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.template;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r6 = r13.icon;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.text;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.i18nKey;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.originText;
    L35:
        if ((r26 & 256) == 0) goto L37;
        boolean r10 = r13.rightArrow;
    L39:
        if ((r26 & 512) == 0) goto L41;
        ArrayList r11 = r13.params;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.extras;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.localId;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.type;
    }

    public final ArrayList<String> component10() {
        return this.params;
    }

    public final String component11() {
        return this.extras;
    }

    public final String component12() {
        return this.localId;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.key;
    }

    public final String component4() {
        return this.template;
    }

    public final int component5() {
        return this.icon;
    }

    public final String component6() {
        return this.text;
    }

    public final String component7() {
        return this.i18nKey;
    }

    public final String component8() {
        return this.originText;
    }

    public final boolean component9() {
        return this.rightArrow;
    }

    public final Prompt copy(String r15, String r16, String r17, String r18, int r19, String r20, String r21, String r22, boolean r23, ArrayList<String> r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r15, "type");
        Intrinsics.checkNotNullParameter(r16, "id");
        Intrinsics.checkNotNullParameter(r17, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r18, "template");
        Intrinsics.checkNotNullParameter(r20, "text");
        Intrinsics.checkNotNullParameter(r21, "i18nKey");
        Intrinsics.checkNotNullParameter(r22, "originText");
        Intrinsics.checkNotNullParameter(r26, "localId");
        return new Prompt(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Prompt) == true) goto L8;
        return false;
    L8:
        Prompt r6 = (Prompt) r5;
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.template, r6.template) == true) goto L21;
        return false;
    L21:
        if (this.icon == r6.icon) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.i18nKey, r6.i18nKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originText, r6.originText) == true) goto L33;
        return false;
    L33:
        if (this.rightArrow == r6.rightArrow) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.extras, r6.extras) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.localId, r6.localId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.key.hashCode()) * 31) + this.template.hashCode()) * 31) + this.icon) * 31) + this.text.hashCode()) * 31) + this.i18nKey.hashCode()) * 31) + this.originText.hashCode()) * 31;
        if (this.rightArrow == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        ArrayList<String> r3 = this.params;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.extras;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return ((r6 + r4) * 31) + this.localId.hashCode();
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "Prompt(type='" + this.type + "', id='" + this.id + "', key='" + this.key + "', template='" + this.template + "', icon=" + this.icon + ", text='" + this.text + "', i18nKey='" + this.i18nKey + "', originText='" + this.originText + "', rightArrow=" + this.rightArrow + ", extras=" + this.extras + ')';
    }

    public final String getExtras() {
        return this.extras;
    }

    public final String getI18nKey() {
        return this.i18nKey;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLocalId() {
        return this.localId;
    }

    public final String getOriginText() {
        return this.originText;
    }

    public final ArrayList<String> getParams() {
        return this.params;
    }

    public final boolean getRightArrow() {
        return this.rightArrow;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final void setExtras(String r1) {
        this.extras = r1;
    }

    public final void setI18nKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i18nKey = r2;
    }

    public final void setIcon(int r1) {
        this.icon = r1;
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setLocalId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.localId = r2;
    }

    public final void setOriginText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originText = r2;
    }

    public final void setParams(ArrayList<String> r1) {
        this.params = r1;
    }

    public final void setRightArrow(boolean r1) {
        this.rightArrow = r1;
    }

    public final void setTemplate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.template = r2;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public Prompt(String r2, String r3, String r4, String r5, int r6, String r7, String r8, String r9, boolean r10, ArrayList<String> r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r5, "template");
        Intrinsics.checkNotNullParameter(r7, "text");
        Intrinsics.checkNotNullParameter(r8, "i18nKey");
        Intrinsics.checkNotNullParameter(r9, "originText");
        Intrinsics.checkNotNullParameter(r13, "localId");
        this.type = r2;
        this.id = r3;
        this.key = r4;
        this.template = r5;
        this.icon = r6;
        this.text = r7;
        this.i18nKey = r8;
        this.originText = r9;
        this.rightArrow = r10;
        this.params = r11;
        this.extras = r12;
        this.localId = r13;
    }

    public /* synthetic */ Prompt(String r17, String r18, String r19, String r20, int r21, String r22, String r23, String r24, boolean r25, ArrayList r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r29 & 4) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r29 & 8) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r29 & 64) == 0) goto L17;
        String r10 = "";
    L19:
        if ((r29 & 512) == 0) goto L21;
        ArrayList r13 = null;
    L23:
        if ((r29 & 1024) == 0) goto L25;
        String r14 = null;
    L27:
        if ((r29 & 2048) == 0) goto L29;
        String r15 = "";
    L30:
        this(r4, r18, r6, r7, r21, r22, r10, r24, r25, r13, r14, r15);
        return;
    L29:
        r15 = r28;
        goto L30
    L25:
        r14 = r27;
        goto L27
    L21:
        r13 = r26;
        goto L23
    L17:
        r10 = r23;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }
}
