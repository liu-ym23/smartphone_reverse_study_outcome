package com.larksuite.component.card.component.text;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/card/component/text/PersonProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "person", "Lcom/larksuite/component/card/component/text/Person;", "showAvatar", "", "showName", "type", "", "containerPadding", "Lcom/larksuite/component/card/component/text/ContainerPadding;", "textSize", "", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Lcom/larksuite/component/card/component/text/Person;ZZLjava/lang/String;Lcom/larksuite/component/card/component/text/ContainerPadding;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getPerson", "()Lcom/larksuite/component/card/component/text/Person;", "getShowAvatar", "()Z", "getShowName", "getType", "()Ljava/lang/String;", "getContainerPadding", "()Lcom/larksuite/component/card/component/text/ContainerPadding;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonProps extends PlainTextProps {
    private final ContainerPadding containerPadding;
    private final Person person;
    private final boolean showAvatar;
    private final boolean showName;
    private final String type;

    public PersonProps() {
        this(null, false, false, null, null, null, null, null, null, null, 0, 2047, null);
    }

    public final ContainerPadding getContainerPadding() {
        return this.containerPadding;
    }

    public final Person getPerson() {
        return this.person;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final boolean getShowName() {
        return this.showName;
    }

    public final String getType() {
        return this.type;
    }

    public PersonProps(Person r9, boolean r10, boolean r11, String r12, ContainerPadding r13, Integer r14, String r15, String r16, List<String> r17, String r19, int r110) {
        Intrinsics.checkNotNullParameter(r19, "content");
        super(r14, r15, r16, r17, r19, r110);
        this.person = r9;
        this.showAvatar = r10;
        this.showName = r11;
        this.type = r12;
        this.containerPadding = r13;
    }

    public /* synthetic */ PersonProps(Person r12, boolean r13, boolean r14, String r15, ContainerPadding r16, Integer r17, String r19, String r110, List r20, String r21, int r22, int r23, DefaultConstructorMarker r24) {
        List r2 = null;
        if ((r23 & 1) == 0) goto L5;
        Person r1 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r23 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        ContainerPadding r6 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        Integer r7 = 14;
    L27:
        if ((r23 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r23 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r23 & 256) != 0) goto L39;
        r2 = r20;
    L39:
        if ((r23 & 512) == 0) goto L41;
        String r10 = "";
    L43:
        if ((r23 & 1024) == 0) goto L45;
        int r0 = LKUIToast.DURATION_MAX;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2, r10, r0);
        return;
    L45:
        r0 = r22;
        goto L46
    L41:
        r10 = r21;
        goto L43
    L33:
        r9 = r110;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
