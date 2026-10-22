package com.larksuite.component.card.resources;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardResource {
    public final ResourceType a;
    public final String b;
    public final String c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/resources/CardResource$ResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "AUDIO", "VIDEO", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ResourceType extends Enum<ResourceType> {
        public static final ResourceType AUDIO = null;
        public static final ResourceType VIDEO = null;
        public static final /* synthetic */ ResourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ResourceType> getEntries() {
            return b;
        }

        static {
            ResourceType r0 = new ResourceType("AUDIO", 0);
            AUDIO = r0;
            ResourceType r1 = new ResourceType("VIDEO", 1);
            VIDEO = r1;
            ResourceType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) a.clone();
        }

        public static ResourceType valueOf(String r1) {
            return (ResourceType) r27.a.a(ResourceType.class, r1);
        }

        public ResourceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardResource) == true) goto L8;
        return false;
    L8:
        CardResource r6 = (CardResource) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "CardResource(type=" + this.a + ", fileKey=" + this.b + ", path=" + this.c + ')';
    }

    public final ResourceType getType() {
        return this.a;
    }

    public CardResource(ResourceType r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "fileKey");
        Intrinsics.checkNotNullParameter(r4, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
