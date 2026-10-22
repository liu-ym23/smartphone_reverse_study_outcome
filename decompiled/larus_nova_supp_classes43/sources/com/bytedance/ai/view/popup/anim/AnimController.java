package com.bytedance.ai.view.popup.anim;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnimController {
    public AnimProcessType a;
    public AnimProcessType b;
    public String c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/view/popup/anim/AnimController$AnimProcessType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "DOING", "DONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;
        public static final /* synthetic */ AnimProcessType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AnimProcessType> getEntries() {
            return b;
        }

        static {
            AnimProcessType r0 = new AnimProcessType("NONE", 0);
            NONE = r0;
            AnimProcessType r1 = new AnimProcessType("DOING", 1);
            DOING = r1;
            AnimProcessType r10 = new AnimProcessType("DONE", 2);
            DONE = r10;
            AnimProcessType[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) a.clone();
        }

        public static AnimProcessType valueOf(String r1) {
            return (AnimProcessType) r27.a.a(AnimProcessType.class, r1);
        }

        public AnimProcessType(String r1, int r10) {
            super(r1, r10);
        }
    }

    public AnimController() {
        AnimProcessType r0 = AnimProcessType.NONE;
        this.a = r0;
        this.b = r0;
    }

    public final void a(AnimProcessType r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "processType");
        if (r10 == AnimProcessType.DOING) goto L6;
        r12 = null;
    L6:
        this.c = r12;
        if (r11 == false) goto L9;
        this.a = r10;
        return;
    L9:
        this.b = r10;
    }
}
