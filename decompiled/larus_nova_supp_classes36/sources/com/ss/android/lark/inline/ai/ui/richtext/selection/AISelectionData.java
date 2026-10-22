package com.ss.android.lark.inline.ai.ui.richtext.selection;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/selection/AISelectionData;", "Ljava/io/Serializable;", "text", "", "htmlText", "selectionMenus", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/ui/richtext/selection/SelectionMenuItem;", "Lkotlin/collections/ArrayList;", "position", "Lcom/ss/android/lark/inline/ai/ui/richtext/selection/Position;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/ss/android/lark/inline/ai/ui/richtext/selection/Position;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getHtmlText", "setHtmlText", "getSelectionMenus", "()Ljava/util/ArrayList;", "setSelectionMenus", "(Ljava/util/ArrayList;)V", "getPosition", "()Lcom/ss/android/lark/inline/ai/ui/richtext/selection/Position;", "setPosition", "(Lcom/ss/android/lark/inline/ai/ui/richtext/selection/Position;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AISelectionData implements Serializable {
    private String htmlText;
    private Position position;
    private ArrayList<SelectionMenuItem> selectionMenus;
    private String text;

    public AISelectionData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AISelectionData copy$default(AISelectionData r0, String r1, String r2, ArrayList r3, Position r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.htmlText;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.selectionMenus;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.position;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.htmlText;
    }

    public final ArrayList<SelectionMenuItem> component3() {
        return this.selectionMenus;
    }

    public final Position component4() {
        return this.position;
    }

    public final AISelectionData copy(String r2, String r3, ArrayList<SelectionMenuItem> r4, Position r5) {
        return new AISelectionData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AISelectionData) == true) goto L8;
        return false;
    L8:
        AISelectionData r6 = (AISelectionData) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.htmlText, r6.htmlText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectionMenus, r6.selectionMenus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.htmlText;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<SelectionMenuItem> r7 = this.selectionMenus;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Position r10 = this.position;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        StringBuilder r0 = new StringBuilder("AISelectionData(text=");
        String r1 = this.text;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.length());
    L6:
        r0.append(r3);
        r0.append(", htmlText=");
        String r4 = this.htmlText;
        if (r4 == null) goto L9;
        r2 = Integer.valueOf(r4.length());
    L9:
        r0.append(r2);
        r0.append(", selectionMenus=");
        r0.append(this.selectionMenus);
        r0.append(", position=");
        r0.append(this.position);
        r0.append(')');
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public final String getHtmlText() {
        return this.htmlText;
    }

    public final Position getPosition() {
        return this.position;
    }

    public final ArrayList<SelectionMenuItem> getSelectionMenus() {
        return this.selectionMenus;
    }

    public final String getText() {
        return this.text;
    }

    public final void setHtmlText(String r1) {
        this.htmlText = r1;
    }

    public final void setPosition(Position r1) {
        this.position = r1;
    }

    public final void setSelectionMenus(ArrayList<SelectionMenuItem> r1) {
        this.selectionMenus = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public AISelectionData(String r1, String r2, ArrayList<SelectionMenuItem> r3, Position r4) {
        this.text = r1;
        this.htmlText = r2;
        this.selectionMenus = r3;
        this.position = r4;
    }

    public /* synthetic */ AISelectionData(String r2, String r3, ArrayList r4, Position r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
