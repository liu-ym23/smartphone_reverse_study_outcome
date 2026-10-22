package com.larus.bmhome.tipoff;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b-\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001IBÇ\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010C\u001a\u00020\u0003J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001f\"\u0004\b2\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006J"}, d2 = {"Lcom/larus/bmhome/tipoff/TipOffDialogParams;", "Landroid/os/Parcelable;", "reportType", "", "entityId", "", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "fromPage", "conversationId", "serverIndex", "reportSource", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "isImmerse", "botId", "commonMobParam", "successReportToastString", "batchIds", "", "overrideReportReason", "Lcom/larus/bmhome/auth/ReportReason;", "extra", "", "<init>", "(ILjava/lang/String;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getReportType", "()I", "setReportType", "(I)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setRecommendFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "getFromPage", "setFromPage", "getConversationId", "setConversationId", "getServerIndex", "setServerIndex", "getReportSource", "setReportSource", "getSearchMobParam", "()Lcom/larus/platform/model/SearchMobParam;", "setSearchMobParam", "(Lcom/larus/platform/model/SearchMobParam;)V", "setImmerse", "getBotId", "setBotId", "getCommonMobParam", "setCommonMobParam", "getSuccessReportToastString", "setSuccessReportToastString", "getBatchIds", "()Ljava/util/List;", "setBatchIds", "(Ljava/util/List;)V", "getOverrideReportReason", "setOverrideReportReason", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Builder", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TipOffDialogParams implements Parcelable {
    public static final Parcelable.Creator<TipOffDialogParams> CREATOR = null;
    public final int a;
    public final String b;
    public RecommendFrom c;
    public String d;
    public String e;
    public String f;
    public int g;
    public SearchMobParam h;
    public String i;
    public final String j;
    public String k;
    public String l;
    public List<String> m;
    public List<com.larus.bmhome.auth.ReportReason> n;
    public Map<String, String> o;

    public static final class a implements Parcelable.Creator<TipOffDialogParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TipOffDialogParams createFromParcel(Parcel r22) {
            Intrinsics.checkNotNullParameter(r22, "parcel");
            int r3 = r22.readInt();
            String r4 = r22.readString();
            RecommendFrom r5 = r22.readParcelable(TipOffDialogParams.class.getClassLoader());
            String r6 = r22.readString();
            String r7 = r22.readString();
            String r8 = r22.readString();
            int r9 = r22.readInt();
            SearchMobParam r10 = r22.readParcelable(TipOffDialogParams.class.getClassLoader());
            String r11 = r22.readString();
            String r12 = r22.readString();
            String r13 = r22.readString();
            String r14 = r22.readString();
            ArrayList<String> r15 = r22.createStringArrayList();
            if (r22.readInt() != 0) goto L5;
            ArrayList r1 = null;
        L10:
            if (r22.readInt() != 0) goto L12;
            ArrayList r17 = r1;
            LinkedHashMap r0 = null;
        L17:
            return new TipOffDialogParams(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r0);
        L12:
            int r2 = r22.readInt();
            LinkedHashMap r16 = new LinkedHashMap(r2);
            int r18 = 0;
        L13:
            if (r18 == r2) goto L15;
            int r19 = r2;
            ArrayList r110 = r1;
            r16.put(r22.readString(), r22.readString());
            r18 = r18 + 1;
            r2 = r19;
            r1 = r110;
            goto L13
        L15:
            r17 = r1;
            r0 = r16;
            goto L17
        L5:
            int r20 = r22.readInt();
            ArrayList r21 = new ArrayList(r20);
            int r111 = 0;
        L6:
            if (r111 == r20) goto L8;
            int r23 = r20;
            r21.add(r22.readParcelable(TipOffDialogParams.class.getClassLoader()));
            r111 = r111 + 1;
            r20 = r23;
            goto L6
        L8:
            r1 = r21;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final TipOffDialogParams[] newArray(int r1) {
            return new TipOffDialogParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeInt(this.a);
        r5.writeString(this.b);
        r5.writeParcelable(this.c, r6);
        r5.writeString(this.d);
        r5.writeString(this.e);
        r5.writeString(this.f);
        r5.writeInt(this.g);
        r5.writeParcelable(this.h, r6);
        r5.writeString(this.i);
        r5.writeString(this.j);
        r5.writeString(this.k);
        r5.writeString(this.l);
        r5.writeStringList(this.m);
        List<com.larus.bmhome.auth.ReportReason> r0 = this.n;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L9:
        Map<String, String> r7 = this.o;
        if (r7 != null) goto L12;
        r5.writeInt(0);
        return;
    L12:
        r5.writeInt(1);
        r5.writeInt(r7.size());
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Map.Entry<String, String> r1 = r8.next();
        r5.writeString(r1.getKey());
        r5.writeString(r1.getValue());
        goto L14
    L19:
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<com.larus.bmhome.auth.ReportReason> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r5.writeParcelable((Parcelable) r2.next(), r6);
        goto L7
    }

    public TipOffDialogParams(int r1, String r2, RecommendFrom r3, String r4, String r5, String r6, int r7, SearchMobParam r8, String r9, String r10, String r11, String r12, List<String> r13, List<com.larus.bmhome.auth.ReportReason> r14, Map<String, String> r15) {
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
        this.m = r13;
        this.n = r14;
        this.o = r15;
    }
}
