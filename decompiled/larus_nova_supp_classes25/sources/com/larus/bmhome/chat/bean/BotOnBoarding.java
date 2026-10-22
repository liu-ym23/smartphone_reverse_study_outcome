package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SuggestQuestion;
import com.larus.im.bean.message.UserType;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÂ\u0003JO\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0001J\u0006\u0010'\u001a\u00020\bJ\u0013\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "Landroid/os/Parcelable;", "_prologue", "", "suggests", "", "content", "callMode", "", "messageList", "Lcom/larus/im/bean/IMMsg;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/List;)V", "getSuggests", "()Ljava/util/List;", "setSuggests", "(Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getCallMode", "()I", "prologue", "getPrologue", "getMessageList", "Lcom/larus/im/bean/message/Message;", "parseSuggestQuestions", "Lcom/larus/im/bean/message/SuggestQuestion;", "shouldFetchFirstMet", "", "getShouldFetchFirstMet", "()Z", "canUseBackUp", "getCanUseBackUp", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotOnBoarding implements Parcelable {
    public static final Parcelable.Creator<BotOnBoarding> CREATOR = null;

    @SerializedName("prologue")
    private final String _prologue;

    @SerializedName("call_mode")
    private final int callMode;

    @SerializedName("content")
    private final String content;

    @SerializedName("message_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<IMMsg> messageList;

    @SerializedName("suggests")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<String> suggests;

    public static final class a implements Parcelable.Creator<BotOnBoarding> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotOnBoarding createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r2 = r9.readString();
            ArrayList<String> r3 = r9.createStringArrayList();
            String r4 = r9.readString();
            int r5 = r9.readInt();
            if (r9.readInt() != 0) goto L5;
            ArrayList r6 = null;
        L10:
            return new BotOnBoarding(r2, r3, r4, r5, r6);
        L5:
            int r0 = r9.readInt();
            ArrayList r1 = new ArrayList(r0);
            int r7 = 0;
        L6:
            if (r7 == r0) goto L8;
            r1.add(r9.readParcelable(BotOnBoarding.class.getClassLoader()));
            r7 = r7 + 1;
            goto L6
        L8:
            r6 = r1;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final BotOnBoarding[] newArray(int r1) {
            return new BotOnBoarding[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotOnBoarding() {
        this(null, null, null, 0, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotOnBoarding) == true) goto L8;
        return false;
    L8:
        BotOnBoarding r6 = (BotOnBoarding) r5;
        if (Intrinsics.areEqual(this._prologue, r6._prologue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suggests, r6.suggests) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (this.callMode == r6.callMode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageList, r6.messageList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this._prologue;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.suggests;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.callMode) * 31;
        List<IMMsg> r10 = this.messageList;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "BotOnBoarding(_prologue=" + this._prologue + ", suggests=" + this.suggests + ", content=" + this.content + ", callMode=" + this.callMode + ", messageList=" + this.messageList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this._prologue);
        r3.writeStringList(this.suggests);
        r3.writeString(this.content);
        r3.writeInt(this.callMode);
        List<IMMsg> r0 = this.messageList;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<IMMsg> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r3.writeParcelable((Parcelable) r1.next(), r4);
        goto L7
    }

    public final List<Message> c() {
        ArrayList r1 = new ArrayList();
        List<IMMsg> r0 = this.messageList;
        if (r0 == null) goto L53;
        Iterator<T> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L53;
        IMMsg r2 = (IMMsg) r3.next();
        String r4 = r2.c();
        String r5 = "";
        if (r4 != null) goto L10;
        String r7 = "";
    L11:
        String r6 = r2.q();
        if (r6 != null) goto L14;
        String r8 = "";
    L15:
        Integer r9 = r2.b();
        boolean r10 = true;
        if (r9 == null) goto L18;
        int r13 = r9.intValue();
    L19:
        String r16 = r2.a();
        IMMsgExt r20 = r2.d();
        String r11 = r2.h();
        if (r11 != null) goto L22;
        String r21 = "";
    L23:
        String r12 = r2.i();
        if (r12 != null) goto L26;
        String r22 = "";
    L27:
        String r28 = r2.o();
        Integer r32 = r2.e();
        String r38 = r2.k();
        IMMsgExt r14 = r2.d();
        if (r14 == null) goto L34;
        String r15 = r14.getSuggestPrompt();
        if (r15 == null) goto L34;
        r5 = r15;
    L34:
        if (StringsKt.isBlank(r5) == true) goto L37;
        r10 = false;
    L37:
        if (r10 == false) goto L54;
    L45:
        Object r17 = null;
    L46:
        List r18 = (List) r17;
        ArrayList r19 = new ArrayList();
        if (r18 == null) goto L52;
        Iterator r23 = r18.iterator();
    L50:
        if (r23.hasNext() == false) goto L52;
        r19.add(new SuggestQuestion((String) r23.next()));
    L52:
        r1.add(new Message(r7, r8, null, UserType.AIBOT.value, 0, null, r13, false, null, r16, null, null, null, r20, r21, r22, 0, 0, false, r28, null, r19, null, r32, null, 0, false, 0, r38, null, false, null, null, 0, null, null, null, -279503436, 31, null));
        goto L6
    L54:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L41
        r17 = Result.constructor-impl(HttpExtKt.f.fromJson(r5, List.class));     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r17) == false) goto L46;
    L41:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L26:
        r22 = r12;
        goto L27
    L22:
        r21 = r11;
        goto L23
    L18:
        r13 = 1;
        goto L19
    L14:
        r8 = r6;
        goto L15
    L10:
        r7 = r4;
    L53:
        return r1;
    }

    public final String d() {
        List<IMMsg> r0 = this.messageList;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L15;
        String r3 = this._prologue;
        if (r3 != null) goto L28;
        return "";
    L28:
        return r3;
    L15:
        IMMsg r4 = (IMMsg) CollectionsKt.firstOrNull(this.messageList);
        if (r4 == null) goto L20;
        IMMsgExt r5 = r4.d();
        if (r5 == null) goto L20;
        r3 = r5.getBrief();
    L21:
        if (r3 != null) goto L23;
    L24:
        r1 = true;
    L25:
        if (r1 == false) goto L28;
        r3 = this._prologue;
        if (r3 != null) goto L28;
        return "";
    L23:
        if (r3.length() != 0) goto L25;
    L20:
        r3 = null;
        goto L21
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    public final int a() {
        return this.callMode;
    }

    public final String b() {
        return this.content;
    }

    public final List<String> e() {
        return this.suggests;
    }

    public /* synthetic */ BotOnBoarding(String r9, List r10, String r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r13 & 2) == 0) goto L9;
        r10 = CollectionsKt.emptyList();
    L9:
        List r4 = r10;
        if ((r13 & 4) == 0) goto L12;
        String r5 = "";
    L14:
        if ((r13 & 8) == 0) goto L16;
        int r6 = 0;
    L17:
        this(r3, r4, r5, r6, null);
        return;
    L16:
        r6 = r12;
        goto L17
    L12:
        r5 = r11;
        goto L14
    L5:
        r3 = r9;
        goto L7
    }

    public BotOnBoarding(String r1, List<String> r2, String r3, int r4, List<IMMsg> r5) {
        this._prologue = r1;
        this.suggests = r2;
        this.content = r3;
        this.callMode = r4;
        this.messageList = r5;
    }
}
