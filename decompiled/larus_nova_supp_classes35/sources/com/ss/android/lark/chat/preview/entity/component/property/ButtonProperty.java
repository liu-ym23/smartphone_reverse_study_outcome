package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.preview.entity.component.Direction;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0002J\b\u0010.\u001a\u00020/H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\t\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ButtonProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "iconKey", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "text", BuildConfig.FLAVOR, "direction", "Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "actionId", "isDisable", BuildConfig.FLAVOR, "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/Direction;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getIconKey", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setIconKey", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getDirection", "()Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "setDirection", "(Lcom/ss/android/lark/chat/preview/entity/component/Direction;)V", "getActionId", "setActionId", "()Ljava/lang/Boolean;", "setDisable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonProperty extends BaseProperty {
    private String actionId;
    private Direction direction;
    private ImageSet iconKey;
    private Boolean isDisable;
    private String text;
    private UDIcon udIcon;

    public ButtonProperty() {
        this(null, null, null, null, null, null, 63, null);
    }

    public Props clone() {
        ButtonProperty r9 = new ButtonProperty(this.iconKey, this.text, this.direction, this.actionId, this.isDisable, null, 32, null);
        r9.setMarginLeft(getMarginLeft());
        r9.setMarginRight(getMarginRight());
        r9.setMarginTop(getMarginTop());
        r9.setMarginBottom(getMarginBottom());
        return r9;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        ImageSet r1 = this.iconKey;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.text;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Direction r8 = this.direction;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.actionId;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        Boolean r14 = this.isDisable;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        UDIcon r17 = this.udIcon;
        if (r17 == null) goto L26;
        r2 = r17.hashCode();
    L26:
        return r16 + r2;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final ImageSet getIconKey() {
        return this.iconKey;
    }

    public final String getText() {
        return this.text;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public final Boolean isDisable() {
        return this.isDisable;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ButtonProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        ButtonProperty r6 = (ButtonProperty) r5;
        if (Intrinsics.areEqual(this.iconKey, r6.iconKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (this.direction == r6.direction) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionId, r6.actionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isDisable, r6.isDisable) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.udIcon, r6.udIcon) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L50;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        ImageSet r3 = null;
        UDIcon r4 = null;
        Boolean r7 = null;
        String r8 = null;
        String r9 = null;
        if (r1 == ComponentAttribute.icon.getValue()) goto L9;
        if (r1 == ComponentAttribute.text.getValue()) goto L15;
        if (r1 == ComponentAttribute.direction.getValue()) goto L21;
        if (r1 == ComponentAttribute.action_id.getValue()) goto L30;
        if (r1 == ComponentAttribute.is_disable.getValue()) goto L36;
        if (r1 == ComponentAttribute.ud_icon_key.getValue()) goto L46;
        if (r1 == ComponentAttribute.ud_icon_theme_color.getValue()) goto L46;
        if (r1 != ComponentAttribute.unicode.getValue()) goto L6;
    L46:
        UDIcon r2 = this.udIcon;
        if (r2 == null) goto L49;
        r4 = r2.patchData(r0.getKey().intValue(), r0.getValue(), this.udIcon);
    L49:
        this.udIcon = r4;
        goto L6
    L36:
        PreviewData r10 = r0.getValue();
        if (r10 == null) goto L39;
        r7 = r10.getBoolean();
    L39:
        this.isDisable = r7;
        goto L6
    L30:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L33;
        r8 = r11.getString();
    L33:
        this.actionId = r8;
        goto L6
    L21:
        Direction.a r12 = Direction.Companion;
        PreviewData r13 = r0.getValue();
        if (r13 == null) goto L26;
        Integer r14 = r13.getInt();
        if (r14 == null) goto L26;
        int r15 = r14.intValue();
    L27:
        r12.getClass();
        this.direction = Direction.a.a(r15);
    L26:
        r15 = 0;
        goto L27
    L15:
        PreviewData r16 = r0.getValue();
        if (r16 == null) goto L18;
        r9 = r16.getString();
    L18:
        this.text = r9;
        goto L6
    L9:
        PreviewData r17 = r0.getValue();
        if (r17 == null) goto L12;
        r3 = r17.getImageSet();
    L12:
        this.iconKey = r3;
        goto L6
    }

    public final void setActionId(String r1) {
        this.actionId = r1;
    }

    public final void setDirection(Direction r1) {
        this.direction = r1;
    }

    public final void setDisable(Boolean r1) {
        this.isDisable = r1;
    }

    public final void setIconKey(ImageSet r1) {
        this.iconKey = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setUdIcon(UDIcon r1) {
        this.udIcon = r1;
    }

    public ButtonProperty(ImageSet r2, String r3, Direction r4, String r5, Boolean r6, UDIcon r7) {
        super(Type.BUTTON);
        this.iconKey = r2;
        this.text = r3;
        this.direction = r4;
        this.actionId = r5;
        this.isDisable = r6;
        this.udIcon = r7;
    }

    public /* synthetic */ ButtonProperty(ImageSet r6, String r7, Direction r8, String r9, Boolean r10, UDIcon r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        ImageSet r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        r8 = Direction.LTR;
    L13:
        Direction r2 = r8;
        if ((r12 & 8) == 0) goto L16;
        String r3 = null;
    L18:
        if ((r12 & 16) == 0) goto L20;
        Boolean r4 = null;
    L22:
        if ((r12 & 32) == 0) goto L24;
        UDIcon r15 = null;
    L25:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L24:
        r15 = r11;
        goto L25
    L20:
        r4 = r10;
        goto L22
    L16:
        r3 = r9;
        goto L18
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
