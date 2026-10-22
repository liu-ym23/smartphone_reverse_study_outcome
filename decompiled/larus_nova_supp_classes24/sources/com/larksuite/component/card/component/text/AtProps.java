package com.larksuite.component.card.component.text;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/component/text/AtProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "userId", "", "textSize", "", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AtProps extends PlainTextProps {
    private final String userId;

    public AtProps() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    public final String getUserId() {
        return this.userId;
    }

    public AtProps(String r8, Integer r9, String r10, String r11, List<String> r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "content");
        super(r9, r10, r11, r12, r13, r14);
        this.userId = r8;
    }

    public /* synthetic */ AtProps(String r6, Integer r7, String r8, String r9, List r10, String r11, int r12, int r13, DefaultConstructorMarker r14) {
        List r0 = null;
        if ((r13 & 1) == 0) goto L5;
        String r15 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r7 = 14;
    L9:
        Integer r1 = r7;
        if ((r13 & 4) == 0) goto L12;
        String r2 = null;
    L14:
        if ((r13 & 8) == 0) goto L16;
        String r3 = null;
    L18:
        if ((r13 & 16) != 0) goto L22;
        r0 = r10;
    L22:
        if ((r13 & 32) == 0) goto L24;
        r11 = "";
    L24:
        String r4 = r11;
        if ((r13 & 64) == 0) goto L27;
        int r16 = LKUIToast.DURATION_MAX;
    L28:
        this(r15, r1, r2, r3, r0, r4, r16);
        return;
    L27:
        r16 = r12;
        goto L28
    L16:
        r3 = r9;
        goto L18
    L12:
        r2 = r8;
        goto L14
    L5:
        r15 = r6;
        goto L7
    }
}
