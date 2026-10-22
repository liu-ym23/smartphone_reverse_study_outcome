package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SearchContactIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "sendChat", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/intent/export/entity/output/SendChat;", "Lkotlin/collections/ArrayList;", "sendChatter", "Lcom/ss/android/lark/intent/export/entity/output/SendChatter;", "msg", "", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "getSendChat", "()Ljava/util/ArrayList;", "getSendChatter", "getMsg", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SearchContactIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<SearchContactIntentOutput> CREATOR = null;
    private final String msg;
    private final ArrayList<SendChat> sendChat;
    private final ArrayList<SendChatter> sendChatter;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<SearchContactIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SearchContactIntentOutput createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            int r0 = r6.readInt();
            ArrayList r1 = new ArrayList(r0);
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 == r0) goto L5;
            r1.add(SendChat.CREATOR.createFromParcel(r6));
            r3 = r3 + 1;
            goto L3
        L5:
            int r4 = r6.readInt();
            ArrayList r5 = new ArrayList(r4);
        L6:
            if (r2 == r4) goto L9;
            r5.add(SendChatter.CREATOR.createFromParcel(r6));
            r2 = r2 + 1;
            goto L6
        L9:
            return new SearchContactIntentOutput(r1, r5, r6.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchContactIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SearchContactIntentOutput[] newArray(int r1) {
            return new SearchContactIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchContactIntentOutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        ArrayList<SendChat> r0 = this.sendChat;
        r3.writeInt(r0.size());
        Iterator<SendChat> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().writeToParcel(r3, r4);
        goto L4
    L6:
        ArrayList<SendChatter> r2 = this.sendChatter;
        r3.writeInt(r2.size());
        Iterator<SendChatter> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r5.next().writeToParcel(r3, r4);
        goto L8
    L10:
        r3.writeString(this.msg);
    }

    public final String getMsg() {
        return this.msg;
    }

    public final ArrayList<SendChat> getSendChat() {
        return this.sendChat;
    }

    public final ArrayList<SendChatter> getSendChatter() {
        return this.sendChatter;
    }

    public SearchContactIntentOutput(ArrayList<SendChat> r2, ArrayList<SendChatter> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "sendChat");
        Intrinsics.checkNotNullParameter(r3, "sendChatter");
        super(Direction.CALLBACK_SEARCH_CONTACT, r4);
        this.sendChat = r2;
        this.sendChatter = r3;
        this.msg = r4;
    }

    public /* synthetic */ SearchContactIntentOutput(ArrayList r1, ArrayList r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
