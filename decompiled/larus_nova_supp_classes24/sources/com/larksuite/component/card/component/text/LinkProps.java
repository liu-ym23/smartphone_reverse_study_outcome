package com.larksuite.component.card.component.text;

import com.larksuite.component.card.component.udicon.UDIconContentProps;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/component/text/LinkProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "url", "", "androidUrl", "icon", "Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "textSize", "", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/component/udicon/UDIconContentProps;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getAndroidUrl", "getIcon", "()Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LinkProps extends PlainTextProps {
    private final String androidUrl;
    private final UDIconContentProps icon;
    private final String url;

    public LinkProps() {
        this(null, null, null, null, null, null, null, null, 0, 511, null);
    }

    public final String getAndroidUrl() {
        return this.androidUrl;
    }

    public final UDIconContentProps getIcon() {
        return this.icon;
    }

    public final String getUrl() {
        return this.url;
    }

    public LinkProps(String r9, String r10, UDIconContentProps r11, Integer r12, String r13, String r14, List<String> r15, String r16, int r17) {
        Intrinsics.checkNotNullParameter(r16, "content");
        super(r12, r13, r14, r15, r16, r17);
        this.url = r9;
        this.androidUrl = r10;
        this.icon = r11;
    }

    public /* synthetic */ LinkProps(String r10, String r11, UDIconContentProps r12, Integer r13, String r14, String r15, List r16, String r17, int r19, int r110, DefaultConstructorMarker r20) {
        List r2 = null;
        if ((r110 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        UDIconContentProps r4 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r5 = 14;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r110 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r110 & 64) != 0) goto L31;
        r2 = r16;
    L31:
        if ((r110 & 128) == 0) goto L33;
        String r8 = "";
    L35:
        if ((r110 & 256) == 0) goto L37;
        int r0 = LKUIToast.DURATION_MAX;
    L38:
        this(r1, r3, r4, r5, r6, r7, r2, r8, r0);
        return;
    L37:
        r0 = r19;
        goto L38
    L33:
        r8 = r17;
        goto L35
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
