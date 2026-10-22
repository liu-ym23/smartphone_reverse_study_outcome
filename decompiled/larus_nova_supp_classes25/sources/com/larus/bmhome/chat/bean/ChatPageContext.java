package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.GuiContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B~\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0016\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0080\u0001\u0010$\u001a\u00020\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020&HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatPageContext;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "reqHeaderMap", "", "", "reqExt", "userContextParam", "Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "guiContext", "", "Lcom/larus/im/bean/message/GuiContext;", "Lkotlinx/parcelize/RawValue;", "bizExt", "conversationMode", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/larus/bmhome/chat/bean/ChatUserContextParam;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getReqHeaderMap", "()Ljava/util/Map;", "getReqExt", "getUserContextParam", "()Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "getGuiContext", "()Ljava/util/List;", "getBizExt", "getConversationMode", "()Ljava/lang/String;", "isNotEmpty", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatPageContext implements Parcelable, Serializable, t1a.c {
    public static final Parcelable.Creator<ChatPageContext> CREATOR = null;
    private final Map<String, String> bizExt;
    private final String conversationMode;
    private final List<GuiContext> guiContext;
    private final Map<String, String> reqExt;
    private final Map<String, String> reqHeaderMap;
    private final ChatUserContextParam userContextParam;

    public static final class a implements Parcelable.Creator<ChatPageContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPageContext createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            int r1 = 0;
            LinkedHashMap r2 = null;
            if (r13.readInt() != 0) goto L5;
            LinkedHashMap r6 = null;
        L10:
            if (r13.readInt() != 0) goto L12;
            LinkedHashMap r7 = null;
        L17:
            if (r13.readInt() != 0) goto L19;
            ChatUserContextParam r0 = null;
        L20:
            ChatUserContextParam r8 = r0;
            if (r13.readInt() != 0) goto L23;
            ArrayList r9 = null;
        L28:
            if (r13.readInt() == 0) goto L34;
            int r3 = r13.readInt();
            r2 = new LinkedHashMap(r3);
        L31:
            if (r1 == r3) goto L34;
            r2.put(r13.readString(), r13.readString());
            r1 = r1 + 1;
        L34:
            return new ChatPageContext(r6, r7, r8, r9, r2, r13.readString());
        L23:
            int r4 = r13.readInt();
            ArrayList r5 = new ArrayList(r4);
            int r10 = 0;
        L24:
            if (r10 == r4) goto L26;
            r5.add(r13.readSerializable());
            r10 = r10 + 1;
            goto L24
        L26:
            r9 = r5;
            goto L28
        L19:
            r0 = ChatUserContextParam.CREATOR.createFromParcel(r13);
            goto L20
        L12:
            int r11 = r13.readInt();
            LinkedHashMap r12 = new LinkedHashMap(r11);
            int r14 = 0;
        L13:
            if (r14 == r11) goto L15;
            r12.put(r13.readString(), r13.readString());
            r14 = r14 + 1;
            goto L13
        L15:
            r7 = r12;
            goto L17
        L5:
            int r15 = r13.readInt();
            LinkedHashMap r16 = new LinkedHashMap(r15);
            int r17 = 0;
        L6:
            if (r17 == r15) goto L8;
            r16.put(r13.readString(), r13.readString());
            r17 = r17 + 1;
            goto L6
        L8:
            r6 = r16;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPageContext[] newArray(int r1) {
            return new ChatPageContext[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatPageContext() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatPageContext copy$default(ChatPageContext r4, Map r5, Map r6, ChatUserContextParam r7, List r8, Map r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.reqHeaderMap;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.reqExt;
    L8:
        Map r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.userContextParam;
    L11:
        ChatUserContextParam r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.guiContext;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.bizExt;
    L17:
        Map r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.conversationMode;
    L20:
        Map r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Map<String, String> component1() {
        return this.reqHeaderMap;
    }

    public final Map<String, String> component2() {
        return this.reqExt;
    }

    public final ChatUserContextParam component3() {
        return this.userContextParam;
    }

    public final List<GuiContext> component4() {
        return this.guiContext;
    }

    public final Map<String, String> component5() {
        return this.bizExt;
    }

    public final String component6() {
        return this.conversationMode;
    }

    public final ChatPageContext copy(Map<String, String> r9, Map<String, String> r10, ChatUserContextParam r11, List<GuiContext> r12, Map<String, String> r13, String r14) {
        return new ChatPageContext(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatPageContext) == true) goto L8;
        return false;
    L8:
        ChatPageContext r6 = (ChatPageContext) r5;
        if (Intrinsics.areEqual(this.reqHeaderMap, r6.reqHeaderMap) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reqExt, r6.reqExt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userContextParam, r6.userContextParam) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.guiContext, r6.guiContext) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizExt, r6.bizExt) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conversationMode, r6.conversationMode) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Map<String, String> r0 = this.reqHeaderMap;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.reqExt;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ChatUserContextParam r7 = this.userContextParam;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<GuiContext> r10 = this.guiContext;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.bizExt;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.conversationMode;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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

    public String toString() {
        return "ChatPageContext(reqHeaderMap=" + this.reqHeaderMap + ", reqExt=" + this.reqExt + ", userContextParam=" + this.userContextParam + ", guiContext=" + this.guiContext + ", bizExt=" + this.bizExt + ", conversationMode=" + this.conversationMode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        Map<String, String> r0 = this.reqHeaderMap;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L9:
        Map<String, String> r1 = this.reqExt;
        if (r1 != null) goto L12;
        r6.writeInt(0);
    L16:
        ChatUserContextParam r2 = this.userContextParam;
        if (r2 != null) goto L19;
        r6.writeInt(0);
    L20:
        List<GuiContext> r8 = this.guiContext;
        if (r8 != null) goto L23;
        r6.writeInt(0);
    L27:
        Map<String, String> r9 = this.bizExt;
        if (r9 != null) goto L30;
        r6.writeInt(0);
    L34:
        r6.writeString(this.conversationMode);
        return;
    L30:
        r6.writeInt(1);
        r6.writeInt(r9.size());
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L32:
        if (r10.hasNext() == false) goto L34;
        Map.Entry<String, String> r3 = r10.next();
        r6.writeString(r3.getKey());
        r6.writeString(r3.getValue());
        goto L32
    L23:
        r6.writeInt(1);
        r6.writeInt(r8.size());
        Iterator<GuiContext> r11 = r8.iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        r6.writeSerializable((Serializable) r11.next());
        goto L25
    L19:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L20
    L12:
        r6.writeInt(1);
        r6.writeInt(r1.size());
        Iterator<Map.Entry<String, String>> r4 = r1.entrySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        Map.Entry<String, String> r5 = r4.next();
        r6.writeString(r5.getKey());
        r6.writeString(r5.getValue());
        goto L14
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.size());
        Iterator<Map.Entry<String, String>> r12 = r0.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, String> r13 = r12.next();
        r6.writeString(r13.getKey());
        r6.writeString(r13.getValue());
        goto L7
    }

    public final boolean isNotEmpty() {
        Map<String, String> r0 = this.reqHeaderMap;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L49;
        Map<String, String> r2 = this.reqExt;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L49;
        Map<String, String> r4 = this.bizExt;
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L49;
        ChatUserContextParam r6 = this.userContextParam;
        if (r6 != null) goto L29;
    L31:
        boolean r7 = false;
    L32:
        if (r7 == true) goto L49;
        List<GuiContext> r8 = this.guiContext;
        if (r8 != null) goto L36;
    L39:
        boolean r9 = true;
    L40:
        if (r9 == false) goto L49;
        String r10 = this.conversationMode;
        if (r10 != null) goto L44;
    L47:
        boolean r11 = true;
    L48:
        if (r11 == false) goto L49;
        return false;
    L44:
        if (r10.length() == 0) goto L47;
        r11 = false;
        goto L48
    L36:
        if (r8.isEmpty() == true) goto L39;
        r9 = false;
        goto L40
    L29:
        if (r6.isNotEmpty() != true) goto L31;
        r7 = true;
        goto L32
    L21:
        if (r4.isEmpty() == true) goto L24;
        r5 = false;
        goto L25
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
    L49:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final Map<String, String> getBizExt() {
        return this.bizExt;
    }

    public final String getConversationMode() {
        return this.conversationMode;
    }

    public final List<GuiContext> getGuiContext() {
        return this.guiContext;
    }

    public final Map<String, String> getReqExt() {
        return this.reqExt;
    }

    public final Map<String, String> getReqHeaderMap() {
        return this.reqHeaderMap;
    }

    public final ChatUserContextParam getUserContextParam() {
        return this.userContextParam;
    }

    public ChatPageContext(Map<String, String> r1, Map<String, String> r2, ChatUserContextParam r3, List<GuiContext> r4, Map<String, String> r5, String r6) {
        this.reqHeaderMap = r1;
        this.reqExt = r2;
        this.userContextParam = r3;
        this.guiContext = r4;
        this.bizExt = r5;
        this.conversationMode = r6;
    }

    public /* synthetic */ ChatPageContext(Map r6, Map r7, ChatUserContextParam r8, List r9, Map r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Map r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        Map r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        ChatUserContextParam r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Map r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
