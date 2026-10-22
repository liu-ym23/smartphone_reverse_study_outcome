package com.ss.android.lark.chat.entity.chatter;

import com.ss.android.lark.chat.export.entity.chatter.IChatterDesc;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatterDescription implements IChatterDesc, Serializable {
    private static final long serialVersionUID = 9045855193516368048L;
    public String description;
    public long descriptionId;
    public Type type;

    public static final enum Type extends Enum<Type> {
        public static final Type BUSINESS = null;
        public static final Type DEFAULT = null;
        public static final Type LEAVE = null;
        public static final Type MEETING = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("DEFAULT", 0, 0);
            DEFAULT = r0;
            Type r1 = new Type("BUSINESS", 1, 1);
            BUSINESS = r1;
            Type r3 = new Type("LEAVE", 2, 2);
            LEAVE = r3;
            Type r5 = new Type("MEETING", 3, 3);
            MEETING = r5;
            a = new Type[]{r0, r1, r3, r5};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Type r0) {
            return r0.value;
        }

        public static Type valueOf(int r1) {
            if (r1 != 0) goto L5;
            return DEFAULT;
        L5:
            if (r1 != 1) goto L8;
            return BUSINESS;
        L8:
            if (r1 != 2) goto L11;
            return LEAVE;
        L11:
            if (r1 == 3) goto L18;
            return null;
        L18:
            return MEETING;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.IChatterDesc
    public IChatterDesc.Type getType() {
        IChatterDesc.Type.a r0 = IChatterDesc.Type.Companion;
        int r1 = Type.access$000(this.type);
        r0.getClass();
        if (r1 != 0) goto L6;
        return IChatterDesc.Type.DEFAULT;
    L6:
        if (r1 != 1) goto L9;
        return IChatterDesc.Type.BUSINESS;
    L9:
        if (r1 != 2) goto L12;
        return IChatterDesc.Type.LEAVE;
    L12:
        if (r1 == 3) goto L19;
        return null;
    L19:
        return IChatterDesc.Type.MEETING;
    }

    public ChatterDescription() {
        this.description = BuildConfig.FLAVOR;
        this.type = Type.DEFAULT;
        this.descriptionId = 0;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.IChatterDesc
    public String getContent() {
        return this.description;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof ChatterDescription) == true) goto L11;
        return false;
    L11:
        ChatterDescription r6 = (ChatterDescription) r5;
        if (r6.type == this.type) goto L14;
        return false;
    L14:
        if (r6.description.equals(this.description) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public ChatterDescription(String r1, Type r2) {
        this.description = r1;
        this.type = r2;
        this.descriptionId = 0;
    }

    public ChatterDescription(String r1, Type r2, long r3) {
        this.description = r1;
        this.type = r2;
        this.descriptionId = r3;
    }
}
