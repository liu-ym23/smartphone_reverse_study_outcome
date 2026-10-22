package com.larus.bmhome.chat.deepresearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u009e\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020HJ\u0013\u0010I\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020HHÖ\u0001J\t\u0010M\u001a\u00020\u0004HÖ\u0001J\u0016\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020HR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\b\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019¨\u0006S"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "Lcom/larus/ui/arch/context/external/VData;", "Landroid/os/Parcelable;", "deepReSearchResourceId", "", "deepReSearchMessageId", "deepReSearchCvsId", "deepReSearchEnterMethod", "isCollectionMode", "", "deepReSearchMessage", "Lcom/larus/im/bean/message/Message;", "deepResearchBotModel", "Lcom/larus/im/bean/bot/BotModel;", "deepResearchUniqueChatKey", "", "deepResearchIsProcessResource", "deepResearchProcessDetail", "deepResearchPreviousPage", "deepResearchMobResearchId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeepReSearchResourceId", "()Ljava/lang/String;", "setDeepReSearchResourceId", "(Ljava/lang/String;)V", "getDeepReSearchMessageId", "setDeepReSearchMessageId", "getDeepReSearchCvsId", "setDeepReSearchCvsId", "getDeepReSearchEnterMethod", "setDeepReSearchEnterMethod", "()Ljava/lang/Boolean;", "setCollectionMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDeepReSearchMessage", "()Lcom/larus/im/bean/message/Message;", "setDeepReSearchMessage", "(Lcom/larus/im/bean/message/Message;)V", "getDeepResearchBotModel", "()Lcom/larus/im/bean/bot/BotModel;", "setDeepResearchBotModel", "(Lcom/larus/im/bean/bot/BotModel;)V", "getDeepResearchUniqueChatKey", "()Ljava/lang/Long;", "setDeepResearchUniqueChatKey", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDeepResearchIsProcessResource", "setDeepResearchIsProcessResource", "getDeepResearchProcessDetail", "setDeepResearchProcessDetail", "getDeepResearchPreviousPage", "setDeepResearchPreviousPage", "getDeepResearchMobResearchId", "setDeepResearchMobResearchId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepReSearchParam implements c, Parcelable {
    public static final Parcelable.Creator<DeepReSearchParam> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public Boolean e;
    public Message f;
    public BotModel g;
    public Long h;
    public Boolean i;
    public String j;
    public String k;
    public String l;

    public static final class a implements Parcelable.Creator<DeepReSearchParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DeepReSearchParam createFromParcel(Parcel r18) {
            Intrinsics.checkNotNullParameter(r18, "parcel");
            String r2 = r18.readString();
            String r3 = r18.readString();
            String r4 = r18.readString();
            String r5 = r18.readString();
            boolean r7 = false;
            if (r18.readInt() != 0) goto L6;
            Boolean r6 = null;
        L10:
            Message r10 = r18.readSerializable();
            BotModel r11 = r18.readSerializable();
            if (r18.readInt() != 0) goto L13;
            Long r12 = null;
        L15:
            if (r18.readInt() != 0) goto L18;
            Boolean r13 = null;
        L22:
            return new DeepReSearchParam(r2, r3, r4, r5, r6, r10, r11, r12, r13, r18.readString(), r18.readString(), r18.readString());
        L18:
            if (r18.readInt() == 0) goto L20;
            r7 = true;
        L20:
            r13 = Boolean.valueOf(r7);
            goto L22
        L13:
            r12 = Long.valueOf(r18.readLong());
            goto L15
        L6:
            if (r18.readInt() == 0) goto L8;
            boolean r8 = true;
        L9:
            r6 = Boolean.valueOf(r8);
            goto L10
        L8:
            r8 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final DeepReSearchParam[] newArray(int r1) {
            return new DeepReSearchParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DeepReSearchParam() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DeepReSearchParam) == true) goto L8;
        return false;
    L8:
        DeepReSearchParam r6 = (DeepReSearchParam) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Message r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        BotModel r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepReSearchParam(deepReSearchResourceId=" + this.a + ", deepReSearchMessageId=" + this.b + ", deepReSearchCvsId=" + this.c + ", deepReSearchEnterMethod=" + this.d + ", isCollectionMode=" + this.e + ", deepReSearchMessage=" + this.f + ", deepResearchBotModel=" + this.g + ", deepResearchUniqueChatKey=" + this.h + ", deepResearchIsProcessResource=" + this.i + ", deepResearchProcessDetail=" + this.j + ", deepResearchPreviousPage=" + this.k + ", deepResearchMobResearchId=" + this.l + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.a);
        r5.writeString(this.b);
        r5.writeString(this.c);
        r5.writeString(this.d);
        Boolean r7 = this.e;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        r5.writeSerializable(this.f);
        r5.writeSerializable(this.g);
        Long r8 = this.h;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Boolean r9 = this.i;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L14:
        r5.writeString(this.j);
        r5.writeString(this.k);
        r5.writeString(this.l);
        return;
    L13:
        r5.writeInt(1);
        r5.writeInt(r9.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeLong(r8.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.booleanValue() ? 1 : 0);
        goto L6
    }

    public /* synthetic */ DeepReSearchParam(int r14) {
        Boolean r9 = Boolean.FALSE;
        this(null, null, null, null, r9, null, null, null, r9, "", "", "");
    }

    public DeepReSearchParam(String r1, String r2, String r3, String r4, Boolean r5, Message r6, BotModel r7, Long r8, Boolean r9, String r10, String r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
