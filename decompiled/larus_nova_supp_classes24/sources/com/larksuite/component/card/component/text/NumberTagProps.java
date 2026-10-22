package com.larksuite.component.card.component.text;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/card/component/text/NumberTagProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "url", "", "originalTextSize", "", "circleSize", "tagBgColor", "textSize", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getOriginalTextSize", "()I", "getCircleSize", "getTagBgColor", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class NumberTagProps extends PlainTextProps {
    private final int circleSize;
    private final int originalTextSize;
    private final String tagBgColor;
    private final String url;

    public NumberTagProps() {
        this(null, 0, 0, null, null, null, null, null, null, 0, 1023, null);
    }

    public final int getCircleSize() {
        return this.circleSize;
    }

    public final int getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final String getTagBgColor() {
        return this.tagBgColor;
    }

    public final String getUrl() {
        return this.url;
    }

    public NumberTagProps(String r9, int r10, int r11, String r12, Integer r13, String r14, String r15, List<String> r16, String r17, int r19) {
        Intrinsics.checkNotNullParameter(r17, "content");
        super(r13, r14, r15, r16, r17, r19);
        this.url = r9;
        this.originalTextSize = r10;
        this.circleSize = r11;
        this.tagBgColor = r12;
    }

    public /* synthetic */ NumberTagProps(String r11, int r12, int r13, String r14, Integer r15, String r16, String r17, List r19, String r110, int r20, int r21, DefaultConstructorMarker r22) {
        List r2 = null;
        if ((r21 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r3 = 14;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Integer r4 = 14;
    L23:
        if ((r21 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r21 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r21 & 128) != 0) goto L35;
        r2 = r19;
    L35:
        if ((r21 & 256) == 0) goto L37;
        String r9 = "";
    L39:
        if ((r21 & 512) == 0) goto L41;
        int r0 = LKUIToast.DURATION_MAX;
    L42:
        this(r1, r3, r5, r6, r4, r7, r8, r2, r9, r0);
        return;
    L41:
        r0 = r20;
        goto L42
    L37:
        r9 = r110;
        goto L39
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r4 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
