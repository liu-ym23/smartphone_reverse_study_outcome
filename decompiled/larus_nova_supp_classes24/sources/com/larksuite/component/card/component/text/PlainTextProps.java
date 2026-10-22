package com.larksuite.component.card.component.text;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larksuite/component/card/component/text/PlainTextProps;", "", "textSize", "", "textColor", "", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getTextSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextColor", "()Ljava/lang/String;", "getTextBgColor", "getTextDecoration", "()Ljava/util/List;", "getContent", "getMaxLines", "()I", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class PlainTextProps {
    private final String content;
    private final int maxLines;
    private final String textBgColor;
    private final String textColor;
    private final List<String> textDecoration;
    private final Integer textSize;

    public PlainTextProps() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final String getTextBgColor() {
        return this.textBgColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final List<String> getTextDecoration() {
        return this.textDecoration;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public PlainTextProps(Integer r2, String r3, String r4, List<String> r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "content");
        this.textSize = r2;
        this.textColor = r3;
        this.textBgColor = r4;
        this.textDecoration = r5;
        this.content = r6;
        this.maxLines = r7;
    }

    public /* synthetic */ PlainTextProps(Integer r5, String r6, String r7, List r8, String r9, int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = 14;
    L5:
        List r0 = null;
        if ((r11 & 2) == 0) goto L8;
        String r13 = null;
    L10:
        if ((r11 & 4) == 0) goto L12;
        String r1 = null;
    L14:
        if ((r11 & 8) != 0) goto L18;
        r0 = r8;
    L18:
        if ((r11 & 16) == 0) goto L20;
        r9 = "";
    L20:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L23;
        int r3 = LKUIToast.DURATION_MAX;
    L24:
        this(r5, r13, r1, r0, r2, r3);
        return;
    L23:
        r3 = r10;
        goto L24
    L12:
        r1 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L10
    }
}
