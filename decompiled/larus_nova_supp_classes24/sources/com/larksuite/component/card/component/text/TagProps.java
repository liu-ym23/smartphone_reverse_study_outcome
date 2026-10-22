package com.larksuite.component.card.component.text;

import android.text.TextUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001b\u001a\u00020\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/text/TagProps;", "Lcom/larksuite/component/card/component/text/TextStyle;", "content", "", "tagBGColorToken", "tagStyle", "textDecoration", "", "originalTextSize", "", "index", "textSize", "textColorToken", "textBGColorToken", "align", "maxLines", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getTagBGColorToken", "getTagStyle", "getTextDecoration", "()Ljava/util/List;", "getOriginalTextSize", "()I", "getIndex", "isInTable", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TagProps extends TextStyle {
    private final String content;
    private final int index;
    private final int originalTextSize;
    private final String tagBGColorToken;
    private final String tagStyle;
    private final List<String> textDecoration;

    public TagProps() {
        this(null, null, null, null, 0, 0, 0, null, null, null, 0, 2047, null);
    }

    public final boolean isInTable() {
        return TextUtils.equals("table", this.tagStyle);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final String getTagBGColorToken() {
        return this.tagBGColorToken;
    }

    public final String getTagStyle() {
        return this.tagStyle;
    }

    public final List<String> getTextDecoration() {
        return this.textDecoration;
    }

    public TagProps(String r8, String r9, String r10, List<String> r11, int r12, int r13, int r14, String r15, String r16, String r17, int r19) {
        super(r14, r15, r16, r17, r19);
        this.content = r8;
        this.tagBGColorToken = r9;
        this.tagStyle = r10;
        this.textDecoration = r11;
        this.originalTextSize = r12;
        this.index = r13;
    }

    public /* synthetic */ TagProps(String r13, String r14, String r15, List r16, int r17, int r19, int r110, String r20, String r21, String r22, int r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        List r5 = null;
    L18:
        int r7 = 14;
        if ((r24 & 16) == 0) goto L21;
        int r6 = 14;
    L23:
        if ((r24 & 32) == 0) goto L25;
        int r8 = -1;
    L27:
        if ((r24 & 64) != 0) goto L31;
        r7 = r110;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & 512) != 0) goto L43;
        r2 = r22;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        int r0 = 1;
    L46:
        this(r1, r3, r4, r5, r6, r8, r7, r9, r10, r2, r0);
        return;
    L45:
        r0 = r23;
        goto L46
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L25:
        r8 = r19;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L18
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
