package com.obric.assistant.card.layout.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u001fHÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001b¨\u0006/"}, d2 = {"Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "Landroid/os/Parcelable;", "isPaused", NameKeys.UnloadStrategy_No_Strategy, "showRecentContact", "intentType", NameKeys.UnloadStrategy_No_Strategy, "intentName", "localMessageId", "ext", NameKeys.UnloadStrategy_No_Strategy, "msgExt", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()Z", "getShowRecentContact", "getIntentType", "()Ljava/lang/String;", "getIntentName", "getLocalMessageId", "getExt", "()Ljava/util/Map;", "getMsgExt", "setMsgExt", "(Ljava/util/Map;)V", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "flags", NameKeys.UnloadStrategy_No_Strategy, "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "CREATOR", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageExtraForViewHolder implements Parcelable {
    public static final a CREATOR = null;
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final Map<String, String> f;
    public final Map<String, String> g;

    public static final class a implements Parcelable.Creator<MessageExtraForViewHolder> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MessageExtraForViewHolder createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            Intrinsics.checkNotNullParameter(r13, "parcel");
            int r2 = 0;
            if (r13.readByte() == 0) goto L5;
            boolean r0 = true;
        L7:
            if (r13.readByte() == 0) goto L9;
            boolean r3 = true;
        L10:
            String r4 = r13.readString();
            String r5 = r13.readString();
            String r1 = r13.readString();
            if (r1 != null) goto L13;
            String r7 = NameKeys.UnloadStrategy_No_Strategy;
        L14:
            MessageExtraForViewHolder.CREATOR.getClass();
            int r6 = r13.readInt();
            if (r6 >= 0) goto L17;
            HashMap r14 = null;
        L28:
            boolean r8 = r0;
            String r9 = r7;
            HashMap r10 = r14;
            return new MessageExtraForViewHolder(r8, r3, r4, r5, r9, r10, null, 64);
        L17:
            HashMap r11 = new HashMap(r6);
        L18:
            if (r2 >= r6) goto L27;
            String r12 = r13.readString();
            if (r12 == null) goto L26;
            String r15 = r13.readString();
            if (r15 != null) goto L25;
            r15 = NameKeys.UnloadStrategy_No_Strategy;
        L25:
            r11.put(r12, r15);
        L26:
            r2 = r2 + 1;
            goto L18
        L27:
            r14 = r11;
            goto L28
        L13:
            r7 = r1;
            goto L14
        L9:
            r3 = false;
            goto L10
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MessageExtraForViewHolder[] newArray(int r1) {
            return new MessageExtraForViewHolder[r1];
        }

        public static final void a(a r1, Parcel r2, Map r3) {
            r1.getClass();
            if (r3 != null) goto L5;
            r2.writeInt(-1);
            return;
        L5:
            r2.writeInt(r3.size());
            Iterator r4 = r3.entrySet().iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            Map.Entry r5 = (Map.Entry) r4.next();
            String r0 = (String) r5.getKey();
            String r6 = (String) r5.getValue();
            r2.writeString(r0);
            r2.writeString(r6);
            goto L7
        }
    }

    static {
        CREATOR = new a();
    }

    public MessageExtraForViewHolder() {
        this(false, false, null, null, null, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageExtraForViewHolder) == true) goto L8;
        return false;
    L8:
        MessageExtraForViewHolder r6 = (MessageExtraForViewHolder) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L13;
        int r6 = 0;
    L14:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (((r7 + r9) * 31) + this.e.hashCode()) * 31;
        Map<String, String> r11 = this.f;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        Map<String, String> r14 = this.g;
        if (r14 == null) goto L27;
        r5 = r14.hashCode();
    L27:
        return r13 + r5;
    L21:
        r12 = r11.hashCode();
        goto L22
    L17:
        r9 = r8.hashCode();
        goto L18
    L13:
        r6 = r4.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageExtraForViewHolder(isPaused=" + this.a + ", showRecentContact=" + this.b + ", intentType=" + this.c + ", intentName=" + this.d + ", localMessageId=" + this.e + ", ext=" + this.f + ", msgExt=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeByte(this.a ? 1 : 0);
        r2.writeByte(this.b ? 1 : 0);
        r2.writeString(this.c);
        r2.writeString(this.d);
        r2.writeString(this.e);
        a r4 = CREATOR;
        a.a(r4, r2, this.f);
        a.a(r4, r2, this.g);
    }

    public MessageExtraForViewHolder(boolean r2, boolean r3, String r4, String r5, String r6, Map<String, String> r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r6, "localMessageId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ MessageExtraForViewHolder(boolean r7, boolean r8, String r9, String r10, String r11, Map r12, Map r13, int r14) {
        boolean r1 = false;
        if ((r14 & 1) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r14 & 2) != 0) goto L11;
        r1 = r8;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        String r4 = r11;
        if ((r14 & 32) == 0) goto L24;
        Map r5 = null;
    L26:
        if ((r14 & 64) == 0) goto L28;
        Map r15 = null;
    L29:
        this(r0, r1, r2, r3, r4, r5, r15);
        return;
    L28:
        r15 = r13;
        goto L29
    L24:
        r5 = r12;
        goto L26
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L5:
        r0 = r7;
        goto L7
    }
}
