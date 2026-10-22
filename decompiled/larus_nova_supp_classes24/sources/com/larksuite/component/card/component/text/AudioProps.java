package com.larksuite.component.card.component.text;

import com.larksuite.component.card.component.udicon.UDIconContentProps;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B½\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/larksuite/component/card/component/text/AudioProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "audioInfo", "Lcom/larksuite/component/card/component/text/MarkdownAudioInfo;", "audioState", "Lcom/larksuite/component/card/component/text/MarkdownAudioState;", "bgColor", "", "style", "showTime", "", "icon", "Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "originalTextSize", "", "bgHeight", "bgPadding", "Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;", "textSize", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Lcom/larksuite/component/card/component/text/MarkdownAudioInfo;Lcom/larksuite/component/card/component/text/MarkdownAudioState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larksuite/component/card/component/udicon/UDIconContentProps;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getAudioInfo", "()Lcom/larksuite/component/card/component/text/MarkdownAudioInfo;", "getAudioState", "()Lcom/larksuite/component/card/component/text/MarkdownAudioState;", "getBgColor", "()Ljava/lang/String;", "getStyle", "getShowTime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIcon", "()Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "getOriginalTextSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgHeight", "getBgPadding", "()Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioProps extends PlainTextProps {
    private final a audioInfo;
    private final MarkdownAudioState audioState;
    private final String bgColor;
    private final Integer bgHeight;
    private final MarkdownAudioBgPadding bgPadding;
    private final UDIconContentProps icon;
    private final Integer originalTextSize;
    private final Boolean showTime;
    private final String style;

    public AudioProps() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 32767, null);
    }

    public final a getAudioInfo() {
        return this.audioInfo;
    }

    public final MarkdownAudioState getAudioState() {
        return this.audioState;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final Integer getBgHeight() {
        return this.bgHeight;
    }

    public final MarkdownAudioBgPadding getBgPadding() {
        return this.bgPadding;
    }

    public final UDIconContentProps getIcon() {
        return this.icon;
    }

    public final Integer getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final Boolean getShowTime() {
        return this.showTime;
    }

    public final String getStyle() {
        return this.style;
    }

    public AudioProps(a r9, MarkdownAudioState r10, String r11, String r12, Boolean r13, UDIconContentProps r14, Integer r15, Integer r16, MarkdownAudioBgPadding r17, Integer r19, String r110, String r20, List<String> r21, String r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "content");
        super(r19, r110, r20, r21, r22, r23);
        this.audioInfo = r9;
        this.audioState = r10;
        this.bgColor = r11;
        this.style = r12;
        this.showTime = r13;
        this.icon = r14;
        this.originalTextSize = r15;
        this.bgHeight = r16;
        this.bgPadding = r17;
    }

    public /* synthetic */ AudioProps(a r16, MarkdownAudioState r17, String r19, String r110, Boolean r20, UDIconContentProps r21, Integer r22, Integer r23, MarkdownAudioBgPadding r24, Integer r25, String r26, String r27, List r29, String r210, int r30, int r31, DefaultConstructorMarker r32) {
        List r2 = null;
        if ((r31 & 1) == 0) goto L5;
        a r1 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        MarkdownAudioState r3 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Boolean r6 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        UDIconContentProps r7 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        MarkdownAudioBgPadding r10 = null;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Integer r11 = 14;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r31 & 4096) != 0) goto L55;
        r2 = r29;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        String r14 = "";
    L59:
        if ((r31 & 16384) == 0) goto L61;
        int r0 = LKUIToast.DURATION_MAX;
    L62:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2, r14, r0);
        return;
    L61:
        r0 = r30;
        goto L62
    L57:
        r14 = r210;
        goto L59
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r110;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
