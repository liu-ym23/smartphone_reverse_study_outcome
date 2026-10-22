package com.larus.voicecall.impl.ui.utils;

import c4a.c;
import com.bytedance.keva.Keva;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class NewThemeSwitchAvatar {
    public static final Lazy a = null;
    public static AvatarType b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/voicecall/impl/ui/utils/NewThemeSwitchAvatar$AvatarType;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BUBBLE", "NORMAL_AVATAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AvatarType extends Enum<AvatarType> {
        public static final AvatarType BUBBLE = null;
        public static final AvatarType NORMAL_AVATAR = null;
        public static final /* synthetic */ AvatarType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<AvatarType> getEntries() {
            return b;
        }

        static {
            AvatarType r0 = new AvatarType("BUBBLE", 0, 0);
            BUBBLE = r0;
            AvatarType r1 = new AvatarType("NORMAL_AVATAR", 1, 1);
            NORMAL_AVATAR = r1;
            AvatarType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static AvatarType[] values() {
            return (AvatarType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AvatarType valueOf(String r1) {
            return (AvatarType) a.a(AvatarType.class, r1);
        }

        public AvatarType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        a = LazyKt.lazy(new c());
        int r0 = ((Keva) m78.c.a.getValue()).getInt("keva_key_avatar_type", AvatarType.BUBBLE.getValue());
        AvatarType[] r1 = AvatarType.values();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        AvatarType r5 = r1[r4];
        if (r5.getValue() != r0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L12;
        r4 = r4 + 1;
    L12:
        if (r5 != null) goto L14;
        r5 = AvatarType.BUBBLE;
    L14:
        b = r5;
        return;
    L7:
        r6 = false;
        goto L8
    L11:
        r5 = null;
        goto L12
    }

    public static boolean a() {
        if (b != AvatarType.BUBBLE) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L8;
        return false;
    }
}
