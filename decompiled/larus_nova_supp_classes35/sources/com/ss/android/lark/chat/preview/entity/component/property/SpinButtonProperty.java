package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.preview.entity.component.Direction;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Item;
import com.ss.android.lark.export.entity.preview.Items;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/SpinButtonProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "icon", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "items", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/Item;", "selectedIndex", BuildConfig.FLAVOR, "direction", "Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/util/List;Ljava/lang/Long;Lcom/ss/android/lark/chat/preview/entity/component/Direction;)V", "getIcon", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setIcon", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getSelectedIndex", "()Ljava/lang/Long;", "setSelectedIndex", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDirection", "()Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "setDirection", "(Lcom/ss/android/lark/chat/preview/entity/component/Direction;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpinButtonProperty extends BaseProperty {
    private Direction direction;
    private ImageSet icon;
    private List<Item> items;
    private Long selectedIndex;

    public SpinButtonProperty() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        ImageSet r1 = this.icon;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        List<Item> r5 = this.items;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.selectedIndex;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        Direction r11 = this.direction;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
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

    public final Direction getDirection() {
        return this.direction;
    }

    public final ImageSet getIcon() {
        return this.icon;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final Long getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpinButtonProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        SpinButtonProperty r6 = (SpinButtonProperty) r5;
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedIndex, r6.selectedIndex) == true) goto L21;
        return false;
    L21:
        if (this.direction == r6.direction) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L36;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        ImageSet r3 = null;
        Long r4 = null;
        ArrayList<Item> r7 = null;
        r7 = null;
        if (r1 == ComponentAttribute.icon.getValue()) goto L9;
        if (r1 == ComponentAttribute.items.getValue()) goto L15;
        if (r1 == ComponentAttribute.selected_index.getValue()) goto L23;
        if (r1 != ComponentAttribute.direction.getValue()) goto L6;
        Direction.a r2 = Direction.Companion;
        PreviewData r8 = r0.getValue();
        if (r8 == null) goto L34;
        Integer r9 = r8.getInt();
        if (r9 == null) goto L34;
        int r10 = r9.intValue();
    L35:
        r2.getClass();
        this.direction = Direction.a.a(r10);
    L34:
        r10 = 0;
        goto L35
    L23:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L26;
        r4 = r11.getLong();
    L26:
        this.selectedIndex = r4;
        goto L6
    L15:
        PreviewData r12 = r0.getValue();
        if (r12 == null) goto L20;
        Items r13 = r12.getItems();
        if (r13 == null) goto L20;
        r7 = r13.getItems();
    L20:
        this.items = r7;
        goto L6
    L9:
        PreviewData r14 = r0.getValue();
        if (r14 == null) goto L12;
        r3 = r14.getImageSet();
    L12:
        this.icon = r3;
        goto L6
    }

    public final void setDirection(Direction r1) {
        this.direction = r1;
    }

    public final void setIcon(ImageSet r1) {
        this.icon = r1;
    }

    public final void setItems(List<Item> r1) {
        this.items = r1;
    }

    public final void setSelectedIndex(Long r1) {
        this.selectedIndex = r1;
    }

    public SpinButtonProperty(ImageSet r2, List<Item> r3, Long r4, Direction r5) {
        super(Type.SPIN_BUTTON);
        this.icon = r2;
        this.items = r3;
        this.selectedIndex = r4;
        this.direction = r5;
    }

    public /* synthetic */ SpinButtonProperty(ImageSet r3, List r4, Long r5, Direction r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0L;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = Direction.LTR;
    L14:
        this(r3, r4, r5, r6);
    }
}
