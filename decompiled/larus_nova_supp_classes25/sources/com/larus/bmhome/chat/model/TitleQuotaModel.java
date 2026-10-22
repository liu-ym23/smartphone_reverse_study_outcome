package com.larus.bmhome.chat.model;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AndroidViewModel;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.QuotaConfig;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.o2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u001f\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J+\u0010\u001a\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010\u001f\u001a\u00020 R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/model/TitleQuotaModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "quotaStore", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getQuotaStore", "()Lcom/bytedance/keva/Keva;", "quotaStore$delegate", "Lkotlin/Lazy;", "getQuota", "Lcom/larus/bmhome/chat/model/TitleQuotaModel$GetUserGPT4QuotaData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentLocalStoredLeftQuotaSize", "", "showGPT4Quota", "", "botType", "botId", "", "(Ljava/lang/Integer;Ljava/lang/String;)Z", "showGPT4QuotaOnTitle", "showGPT4QuotaOnBanner", "isBotEnable", "config", "Lcom/larus/bmhome/auth/QuotaConfig;", "(Ljava/lang/Integer;Lcom/larus/bmhome/auth/QuotaConfig;Ljava/lang/String;)Z", "enableFreqControl", "saveCloseTimeMs", "", "Companion", "GetUserGPT4QuotaData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TitleQuotaModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final int DAY_TO_MS_CONST = 86400000;
    private static final String KEY_CLOSE_TIME = "close_time";
    public static final String KEY_LEFT_QUOTA_COUNT = "KEY_LEFT_QUOTA_COUNT";
    public static final String KEY_TOTAL_QUOTA_COUNT = "KEY_TOTAL_QUOTA_COUNT";
    private static final String TAG = "TitleQuotaModel";
    private final Lazy quotaStore$delegate;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/model/TitleQuotaModel$GetUserGPT4QuotaData;", "Landroid/os/Parcelable;", "leftQuotaSize", "", "totalQuotaSize", "<init>", "(II)V", "getLeftQuotaSize", "()I", "getTotalQuotaSize", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class GetUserGPT4QuotaData implements Parcelable {
        public static final Parcelable.Creator<GetUserGPT4QuotaData> CREATOR = null;
        public static final GetUserGPT4QuotaData a = null;

        @SerializedName("quota_left")
        private final int leftQuotaSize;

        @SerializedName("total_quota")
        private final int totalQuotaSize;

        public static final class a {
        }

        public static final class b implements Parcelable.Creator<GetUserGPT4QuotaData> {
            public b() {
            }

            @Override // android.os.Parcelable.Creator
            public final GetUserGPT4QuotaData createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new GetUserGPT4QuotaData(r3.readInt(), r3.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final GetUserGPT4QuotaData[] newArray(int r1) {
                return new GetUserGPT4QuotaData[r1];
            }
        }

        public GetUserGPT4QuotaData() {
            this(0, 0);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof GetUserGPT4QuotaData) == true) goto L8;
            return false;
        L8:
            GetUserGPT4QuotaData r6 = (GetUserGPT4QuotaData) r5;
            if (this.leftQuotaSize == r6.leftQuotaSize) goto L12;
            return false;
        L12:
            if (this.totalQuotaSize == r6.totalQuotaSize) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.leftQuotaSize * 31) + this.totalQuotaSize;
        }

        public final String toString() {
            return "GetUserGPT4QuotaData(leftQuotaSize=" + this.leftQuotaSize + ", totalQuotaSize=" + this.totalQuotaSize + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(this.leftQuotaSize);
            r1.writeInt(this.totalQuotaSize);
        }

        static {
            CREATOR = new b();
            a = new GetUserGPT4QuotaData(0, 0);
        }

        public final int a() {
            return this.leftQuotaSize;
        }

        public final int b() {
            return this.totalQuotaSize;
        }

        public GetUserGPT4QuotaData(int r1, int r2) {
            this.leftQuotaSize = r1;
            this.totalQuotaSize = r2;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.TitleQuotaModel$getQuota$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.TitleQuotaModel", f = "TitleQuotaModel.kt", i = {}, l = {MessageCellStateTransformerType.DEEP_SEARCH_PROMPT}, m = "getQuota", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TitleQuotaModel this$0;

        public AnonymousClass1(TitleQuotaModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getQuota(this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Keva yo() {
        return quotaStore_delegate$lambda$0();
    }

    private final Keva getQuotaStore() {
        return (Keva) this.quotaStore$delegate.getValue();
    }

    private static final Keva quotaStore_delegate$lambda$0() {
        return Keva.getRepo(o2.a.e(), 0);
    }

    public final int getCurrentLocalStoredLeftQuotaSize() {
        return getQuotaStore().getInt(KEY_LEFT_QUOTA_COUNT, 0);
    }

    public final void saveCloseTimeMs() {
        getQuotaStore().storeLong(KEY_CLOSE_TIME, System.currentTimeMillis());
    }

    public TitleQuotaModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.quotaStore$delegate = LazyKt.lazy(new p1());
    }

    private final boolean enableFreqControl(QuotaConfig r9) {
        if (r9 == null) goto L9;
        double r1 = r9.c();
        long r6 = getQuotaStore().getLong(KEY_CLOSE_TIME, 0);
        if (r6 != 0) goto L8;
    L6:
        return false;
    L8:
        if ((System.currentTimeMillis() - r6) > (r1 * ((double) DAY_TO_MS_CONST))) goto L6;
        return true;
    L9:
        return true;
    }

    public final Object getQuota(Continuation<? super GetUserGPT4QuotaData> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        GetUserGPT4QuotaData r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        com.larus.network.http.y r8 = (com.larus.network.http.a) r7;
        if ((r8 instanceof com.larus.network.http.y) == false) goto L20;
        r4 = (GetUserGPT4QuotaData) ((com.larus.network.http.a) r8).b;
    L20:
        if (r4 == null) goto L22;
        getQuotaStore().storeInt(KEY_LEFT_QUOTA_COUNT, r4.a());
        getQuotaStore().storeInt(KEY_TOTAL_QUOTA_COUNT, r4.b());
        FLogger.a.d(TAG, "TitleQuotaModel.getQuota updateQuotaInfo leftQuotaSize:" + r4.a() + " totalQuotaSize" + r4.b());
    L22:
        if (r4 != null) goto L25;
        Parcelable.Creator<GetUserGPT4QuotaData> r9 = GetUserGPT4QuotaData.CREATOR;
        return GetUserGPT4QuotaData.a;
    L25:
        return r4;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        TitleQuotaModel$getQuota$resp$1 r5 = new TitleQuotaModel$getQuota$resp$1(null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r10, r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    public final boolean showGPT4Quota(Integer r5, String r6) {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        QuotaConfig r2 = r1.b1();
    L9:
        if (r2 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L16;
    L18:
        return false;
    L16:
        if (isBotEnable(r5, r2, r6) == false) goto L18;
        return true;
    L11:
        if (r2.i() != true) goto L13;
        r3 = true;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean showGPT4QuotaOnBanner(Integer r3, String r4) {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        String r1 = null;
        if (r0 == null) goto L7;
        LaunchInfo r2 = r0.a;
        if (r2 == null) goto L7;
        QuotaConfig r5 = r2.b1();
    L9:
        if (showGPT4Quota(r3, r4) == false) goto L17;
        if (r5 == null) goto L13;
        r1 = r5.h();
    L13:
        if (Intrinsics.areEqual(r1, "add_new_banner") == false) goto L17;
        if (enableFreqControl(r5) == true) goto L17;
        return true;
    L17:
        return false;
    L7:
        r5 = null;
        goto L9
    }

    public final boolean showGPT4QuotaOnTitle(Integer r3, String r4) {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        String r1 = null;
        if (r0 == null) goto L7;
        LaunchInfo r2 = r0.a;
        if (r2 == null) goto L7;
        QuotaConfig r5 = r2.b1();
    L9:
        if (showGPT4Quota(r3, r4) == false) goto L15;
        if (r5 == null) goto L13;
        r1 = r5.h();
    L13:
        if (Intrinsics.areEqual(r1, "navigation_bar") == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        r5 = null;
        goto L9
    }

    private final boolean isBotEnable(Integer r4, QuotaConfig r5, String r6) {
        if (r4 == null) goto L21;
        r4.intValue();
        if (r6 != null) goto L7;
        return false;
    L7:
        if (r5 == null) goto L10;
        List r1 = r5.b();
        if (r1 == null) goto L10;
    L12:
        if (r1.contains(r6) == false) goto L14;
        return false;
    L14:
        if (r5 == null) goto L22;
        List r7 = r5.d();
        if (r7 != null) goto L18;
        return false;
    L18:
        if (r7.contains(Long.valueOf(r4.intValue())) != true) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L10:
        r1 = CollectionsKt.emptyList();
        goto L12
    L21:
        return false;
    }
}
