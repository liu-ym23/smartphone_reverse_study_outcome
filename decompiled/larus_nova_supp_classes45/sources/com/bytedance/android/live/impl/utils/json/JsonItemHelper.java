package com.bytedance.android.live.impl.utils.json;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper;", "", "()V", "DefinitionItem", "EnterRoomDurationItem", "FirstFrameLoadDurationItem", "FirstRoomPerformanceDataItem", "GiftShowDateItem", "IJsonItem", "MiniWindowLoadDurationItem", "MiniWindowShowDurationItem", "PreviewClickPvItem", "PreviewShowPvItem", "StallLiveSensitivity", "StallRecordItem", "StallRoomSensitivity", "StartLiveDataItem", "StopLiveReasonDataItem", "WatchHotroomPvItem", "WatchLiveDateItem", "WatchRoomPvItem", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JsonItemHelper {
    public static final JsonItemHelper INSTANCE = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$DefinitionItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "definitionPvList", "", "", "definitionDurationList", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getDefinitionDurationList", "()Ljava/util/List;", "setDefinitionDurationList", "(Ljava/util/List;)V", "getDefinitionPvList", "setDefinitionPvList", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DefinitionItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("definition_duration")
        private List<Long> definitionDurationList;

        @SerializedName("definition_count")
        private List<Integer> definitionPvList;

        public DefinitionItem() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DefinitionItem copy$default(DefinitionItem r0, String r1, List r2, List r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.definitionPvList;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.definitionDurationList;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.date;
        }

        public final List<Integer> component2() {
            return this.definitionPvList;
        }

        public final List<Long> component3() {
            return this.definitionDurationList;
        }

        public final DefinitionItem copy(String r2, List<Integer> r3, List<Long> r4) {
            return new DefinitionItem(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof DefinitionItem) == false) goto L12;
            DefinitionItem r4 = (DefinitionItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.definitionPvList, r4.definitionPvList) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.definitionDurationList, r4.definitionDurationList) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<Integer> r4 = this.definitionPvList;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            List<Long> r7 = this.definitionDurationList;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "DefinitionItem(date=" + this.date + ", definitionPvList=" + this.definitionPvList + ", definitionDurationList=" + this.definitionDurationList + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final List<Long> getDefinitionDurationList() {
            return this.definitionDurationList;
        }

        public final List<Integer> getDefinitionPvList() {
            return this.definitionPvList;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setDefinitionDurationList(List<Long> r1) {
            this.definitionDurationList = r1;
        }

        public final void setDefinitionPvList(List<Integer> r1) {
            this.definitionPvList = r1;
        }

        public DefinitionItem(String r1, List<Integer> r2, List<Long> r3) {
            this.date = r1;
            this.definitionPvList = r2;
            this.definitionDurationList = r3;
        }

        public /* synthetic */ DefinitionItem(String r7, List r8, List r9, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r7 = "";
        L6:
            if ((r11 & 2) == 0) goto L9;
            r8 = CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0});
        L9:
            if ((r11 & 4) == 0) goto L11;
            r9 = CollectionsKt.mutableListOf(new Long[]{0L, 0L, 0L, 0L, 0L});
        L11:
            this(r7, r8, r9);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$EnterRoomDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "enterDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getEnterDurationSum", "()J", "setEnterDurationSum", "(J)V", "getFrequency", "()I", "setFrequency", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EnterRoomDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("enter_duration_sum")
        private long enterDurationSum;
        private int frequency;

        public EnterRoomDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ EnterRoomDurationItem copy$default(EnterRoomDurationItem r0, String r1, long r2, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.enterDurationSum;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.frequency;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.enterDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final EnterRoomDurationItem copy(String r2, long r3, int r5) {
            return new EnterRoomDurationItem(r2, r3, r5);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof EnterRoomDurationItem) == false) goto L12;
            EnterRoomDurationItem r7 = (EnterRoomDurationItem) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.enterDurationSum == r7.enterDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r7.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.enterDurationSum;
            return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.frequency;
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "EnterRoomDurationItem(date=" + this.date + ", enterDurationSum=" + this.enterDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getEnterDurationSum() {
            return this.enterDurationSum;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setEnterDurationSum(long r1) {
            this.enterDurationSum = r1;
        }

        public final void setFrequency(int r1) {
            this.frequency = r1;
        }

        public EnterRoomDurationItem(String r1, long r2, int r4) {
            this.date = r1;
            this.enterDurationSum = r2;
            this.frequency = r4;
        }

        public /* synthetic */ EnterRoomDurationItem(String r1, long r2, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r1, r2, r4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$FirstFrameLoadDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "loadDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getLoadDurationSum", "()J", "setLoadDurationSum", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FirstFrameLoadDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("load_duration_sum")
        private long loadDurationSum;

        public FirstFrameLoadDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ FirstFrameLoadDurationItem copy$default(FirstFrameLoadDurationItem r0, String r1, long r2, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.loadDurationSum;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.frequency;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.loadDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final FirstFrameLoadDurationItem copy(String r2, long r3, int r5) {
            return new FirstFrameLoadDurationItem(r2, r3, r5);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof FirstFrameLoadDurationItem) == false) goto L12;
            FirstFrameLoadDurationItem r7 = (FirstFrameLoadDurationItem) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.loadDurationSum == r7.loadDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r7.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.loadDurationSum;
            return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.frequency;
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "FirstFrameLoadDurationItem(date=" + this.date + ", loadDurationSum=" + this.loadDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final long getLoadDurationSum() {
            return this.loadDurationSum;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setFrequency(int r1) {
            this.frequency = r1;
        }

        public final void setLoadDurationSum(long r1) {
            this.loadDurationSum = r1;
        }

        public FirstFrameLoadDurationItem(String r1, long r2, int r4) {
            this.date = r1;
            this.loadDurationSum = r2;
            this.frequency = r4;
        }

        public /* synthetic */ FirstFrameLoadDurationItem(String r1, long r2, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r1, r2, r4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$FirstRoomPerformanceDataItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "firstRoomPerformanceData", "Lorg/json/JSONObject;", "frequency", "", "(Ljava/lang/String;Lorg/json/JSONObject;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFirstRoomPerformanceData", "()Lorg/json/JSONObject;", "setFirstRoomPerformanceData", "(Lorg/json/JSONObject;)V", "getFrequency", "()I", "setFrequency", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FirstRoomPerformanceDataItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("first_room_performance_data")
        private JSONObject firstRoomPerformanceData;
        private int frequency;

        public FirstRoomPerformanceDataItem() {
            this(null, null, 0, 7, null);
        }

        public static /* synthetic */ FirstRoomPerformanceDataItem copy$default(FirstRoomPerformanceDataItem r0, String r1, JSONObject r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.firstRoomPerformanceData;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.frequency;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.date;
        }

        public final JSONObject component2() {
            return this.firstRoomPerformanceData;
        }

        public final int component3() {
            return this.frequency;
        }

        public final FirstRoomPerformanceDataItem copy(String r2, JSONObject r3, int r4) {
            return new FirstRoomPerformanceDataItem(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof FirstRoomPerformanceDataItem) == false) goto L12;
            FirstRoomPerformanceDataItem r4 = (FirstRoomPerformanceDataItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.firstRoomPerformanceData, r4.firstRoomPerformanceData) == true) goto L10;
            return false;
        L10:
            if (this.frequency == r4.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            JSONObject r4 = this.firstRoomPerformanceData;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.frequency;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "FirstRoomPerformanceDataItem(date=" + this.date + ", firstRoomPerformanceData=" + this.firstRoomPerformanceData + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final JSONObject getFirstRoomPerformanceData() {
            return this.firstRoomPerformanceData;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setFirstRoomPerformanceData(JSONObject r1) {
            this.firstRoomPerformanceData = r1;
        }

        public final void setFrequency(int r1) {
            this.frequency = r1;
        }

        public FirstRoomPerformanceDataItem(String r1, JSONObject r2, int r3) {
            this.date = r1;
            this.firstRoomPerformanceData = r2;
            this.frequency = r3;
        }

        public /* synthetic */ FirstRoomPerformanceDataItem(String r1, JSONObject r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = null;
        L9:
            if ((r4 & 4) == 0) goto L11;
            r3 = 0;
        L11:
            this(r1, r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$GiftShowDateItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftShowDateItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        public GiftShowDateItem() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ GiftShowDateItem copy$default(GiftShowDateItem r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.date;
        }

        public final GiftShowDateItem copy(String r2) {
            return new GiftShowDateItem(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof GiftShowDateItem) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.date, ((GiftShowDateItem) r2).date) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "GiftShowDateItem(date=" + this.date + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public GiftShowDateItem(String r1) {
            this.date = r1;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public /* synthetic */ GiftShowDateItem(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = "";
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IJsonItem {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$MiniWindowLoadDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "loadDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getLoadDurationSum", "()J", "setLoadDurationSum", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiniWindowLoadDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("load_duration_sum")
        private long loadDurationSum;

        public MiniWindowLoadDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ MiniWindowLoadDurationItem copy$default(MiniWindowLoadDurationItem r0, String r1, long r2, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.loadDurationSum;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.frequency;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.loadDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final MiniWindowLoadDurationItem copy(String r2, long r3, int r5) {
            return new MiniWindowLoadDurationItem(r2, r3, r5);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof MiniWindowLoadDurationItem) == false) goto L12;
            MiniWindowLoadDurationItem r7 = (MiniWindowLoadDurationItem) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.loadDurationSum == r7.loadDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r7.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.loadDurationSum;
            return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.frequency;
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "MiniWindowLoadDurationItem(date=" + this.date + ", loadDurationSum=" + this.loadDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final long getLoadDurationSum() {
            return this.loadDurationSum;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setFrequency(int r1) {
            this.frequency = r1;
        }

        public final void setLoadDurationSum(long r1) {
            this.loadDurationSum = r1;
        }

        public MiniWindowLoadDurationItem(String r1, long r2, int r4) {
            this.date = r1;
            this.loadDurationSum = r2;
            this.frequency = r4;
        }

        public /* synthetic */ MiniWindowLoadDurationItem(String r1, long r2, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r1, r2, r4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$MiniWindowShowDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "showDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getShowDurationSum", "()J", "setShowDurationSum", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiniWindowShowDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("show_duration_sum")
        private long showDurationSum;

        public MiniWindowShowDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ MiniWindowShowDurationItem copy$default(MiniWindowShowDurationItem r0, String r1, long r2, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.showDurationSum;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.frequency;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.showDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final MiniWindowShowDurationItem copy(String r2, long r3, int r5) {
            return new MiniWindowShowDurationItem(r2, r3, r5);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof MiniWindowShowDurationItem) == false) goto L12;
            MiniWindowShowDurationItem r7 = (MiniWindowShowDurationItem) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.showDurationSum == r7.showDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r7.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.showDurationSum;
            return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.frequency;
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "MiniWindowShowDurationItem(date=" + this.date + ", showDurationSum=" + this.showDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final long getShowDurationSum() {
            return this.showDurationSum;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setFrequency(int r1) {
            this.frequency = r1;
        }

        public final void setShowDurationSum(long r1) {
            this.showDurationSum = r1;
        }

        public MiniWindowShowDurationItem(String r1, long r2, int r4) {
            this.date = r1;
            this.showDurationSum = r2;
            this.frequency = r4;
        }

        public /* synthetic */ MiniWindowShowDurationItem(String r1, long r2, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r1, r2, r4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$PreviewClickPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "previewClickCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getPreviewClickCount", "()I", "setPreviewClickCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewClickPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("preview_click_count")
        private int previewClickCount;

        public PreviewClickPvItem() {
            String r2 = null;
            this(r2, 0, 3, r2);
        }

        public static /* synthetic */ PreviewClickPvItem copy$default(PreviewClickPvItem r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.previewClickCount;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.previewClickCount;
        }

        public final PreviewClickPvItem copy(String r2, int r3) {
            return new PreviewClickPvItem(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof PreviewClickPvItem) == false) goto L10;
            PreviewClickPvItem r4 = (PreviewClickPvItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (this.previewClickCount == r4.previewClickCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.previewClickCount;
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "PreviewClickPvItem(date=" + this.date + ", previewClickCount=" + this.previewClickCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getPreviewClickCount() {
            return this.previewClickCount;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setPreviewClickCount(int r1) {
            this.previewClickCount = r1;
        }

        public PreviewClickPvItem(String r1, int r2) {
            this.date = r1;
            this.previewClickCount = r2;
        }

        public /* synthetic */ PreviewClickPvItem(String r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$PreviewShowPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "previewShowCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getPreviewShowCount", "()I", "setPreviewShowCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewShowPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("preview_show_count")
        private int previewShowCount;

        public PreviewShowPvItem() {
            String r2 = null;
            this(r2, 0, 3, r2);
        }

        public static /* synthetic */ PreviewShowPvItem copy$default(PreviewShowPvItem r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.previewShowCount;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.previewShowCount;
        }

        public final PreviewShowPvItem copy(String r2, int r3) {
            return new PreviewShowPvItem(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof PreviewShowPvItem) == false) goto L10;
            PreviewShowPvItem r4 = (PreviewShowPvItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (this.previewShowCount == r4.previewShowCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.previewShowCount;
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "PreviewShowPvItem(date=" + this.date + ", previewShowCount=" + this.previewShowCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getPreviewShowCount() {
            return this.previewShowCount;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setPreviewShowCount(int r1) {
            this.previewShowCount = r1;
        }

        public PreviewShowPvItem(String r1, int r2) {
            this.date = r1;
            this.previewShowCount = r2;
        }

        public /* synthetic */ PreviewShowPvItem(String r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StallLiveSensitivity;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchLiveCount", "", "stallLiveCount", "(Ljava/lang/String;JJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getStallLiveCount", "()J", "setStallLiveCount", "(J)V", "getWatchLiveCount", "setWatchLiveCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StallLiveSensitivity implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("stall_live_count_more_than_watch_4s")
        private long stallLiveCount;

        @SerializedName("watch_live_count_more_than_4s")
        private long watchLiveCount;

        public StallLiveSensitivity() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ StallLiveSensitivity copy$default(StallLiveSensitivity r2, String r3, long r4, long r6, int r8, Object r9) {
            if ((r8 & 1) == 0) goto L6;
            r3 = r2.date;
        L6:
            if ((r8 & 2) == 0) goto L8;
            r4 = r2.watchLiveCount;
        L8:
            long r0 = r4;
            if ((r8 & 4) == 0) goto L11;
            r6 = r2.stallLiveCount;
        L11:
            String r5 = r3;
            return r2.copy(r5, r0, r6);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.watchLiveCount;
        }

        public final long component3() {
            return this.stallLiveCount;
        }

        public final StallLiveSensitivity copy(String r8, long r9, long r11) {
            return new StallLiveSensitivity(r8, r9, r11);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof StallLiveSensitivity) == false) goto L12;
            StallLiveSensitivity r7 = (StallLiveSensitivity) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.watchLiveCount == r7.watchLiveCount) goto L10;
            return false;
        L10:
            if (this.stallLiveCount == r7.stallLiveCount) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.watchLiveCount;
            int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
            long r4 = this.stallLiveCount;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "StallLiveSensitivity(date=" + this.date + ", watchLiveCount=" + this.watchLiveCount + ", stallLiveCount=" + this.stallLiveCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getStallLiveCount() {
            return this.stallLiveCount;
        }

        public final long getWatchLiveCount() {
            return this.watchLiveCount;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setStallLiveCount(long r1) {
            this.stallLiveCount = r1;
        }

        public final void setWatchLiveCount(long r1) {
            this.watchLiveCount = r1;
        }

        public StallLiveSensitivity(String r1, long r2, long r4) {
            this.date = r1;
            this.watchLiveCount = r2;
            this.stallLiveCount = r4;
        }

        public /* synthetic */ StallLiveSensitivity(String r5, long r6, long r8, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = "";
        L6:
            if ((r11 & 2) == 0) goto L8;
            long r2 = 0;
        L10:
            if ((r11 & 4) == 0) goto L12;
            long r13 = 0;
        L13:
            this(r5, r2, r13);
            return;
        L12:
            r13 = r8;
            goto L13
        L8:
            r2 = r6;
            goto L10
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StallRecordItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "stallVideoUiRateSum", "", "stallUiRateSum", "frequency", "", "(Ljava/lang/String;FFI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getStallUiRateSum", "()F", "setStallUiRateSum", "(F)V", "getStallVideoUiRateSum", "setStallVideoUiRateSum", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StallRecordItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("stall_ui_rate_sum")
        private float stallUiRateSum;

        @SerializedName("stall_video_ui_rate_sum")
        private float stallVideoUiRateSum;

        public StallRecordItem() {
            this(null, 0.0f, 0.0f, 0, 15, null);
        }

        public static /* synthetic */ StallRecordItem copy$default(StallRecordItem r0, String r1, float r2, float r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.stallVideoUiRateSum;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.stallUiRateSum;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.frequency;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.date;
        }

        public final float component2() {
            return this.stallVideoUiRateSum;
        }

        public final float component3() {
            return this.stallUiRateSum;
        }

        public final int component4() {
            return this.frequency;
        }

        public final StallRecordItem copy(String r2, float r3, float r4, int r5) {
            return new StallRecordItem(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof StallRecordItem) == false) goto L14;
            StallRecordItem r4 = (StallRecordItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (Float.compare(this.stallVideoUiRateSum, r4.stallVideoUiRateSum) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.stallUiRateSum, r4.stallUiRateSum) == 0) goto L12;
            return false;
        L12:
            if (this.frequency == r4.frequency) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (((((r1 * 31) + Float.floatToIntBits(this.stallVideoUiRateSum)) * 31) + Float.floatToIntBits(this.stallUiRateSum)) * 31) + this.frequency;
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "StallRecordItem(date=" + this.date + ", stallVideoUiRateSum=" + this.stallVideoUiRateSum + ", stallUiRateSum=" + this.stallUiRateSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final float getStallUiRateSum() {
            return this.stallUiRateSum;
        }

        public final float getStallVideoUiRateSum() {
            return this.stallVideoUiRateSum;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setFrequency(int r1) {
            this.frequency = r1;
        }

        public final void setStallUiRateSum(float r1) {
            this.stallUiRateSum = r1;
        }

        public final void setStallVideoUiRateSum(float r1) {
            this.stallVideoUiRateSum = r1;
        }

        public StallRecordItem(String r1, float r2, float r3, int r4) {
            this.date = r1;
            this.stallVideoUiRateSum = r2;
            this.stallUiRateSum = r3;
            this.frequency = r4;
        }

        public /* synthetic */ StallRecordItem(String r2, float r3, float r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0.0f;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0.0f;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StallRoomSensitivity;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchRoomCount", "", "stallRoomCount", "(Ljava/lang/String;JJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getStallRoomCount", "()J", "setStallRoomCount", "(J)V", "getWatchRoomCount", "setWatchRoomCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StallRoomSensitivity implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("stall_room_count_more_than_watch_4s")
        private long stallRoomCount;

        @SerializedName("watch_room_count_more_than_4s")
        private long watchRoomCount;

        public StallRoomSensitivity() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ StallRoomSensitivity copy$default(StallRoomSensitivity r2, String r3, long r4, long r6, int r8, Object r9) {
            if ((r8 & 1) == 0) goto L6;
            r3 = r2.date;
        L6:
            if ((r8 & 2) == 0) goto L8;
            r4 = r2.watchRoomCount;
        L8:
            long r0 = r4;
            if ((r8 & 4) == 0) goto L11;
            r6 = r2.stallRoomCount;
        L11:
            String r5 = r3;
            return r2.copy(r5, r0, r6);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.watchRoomCount;
        }

        public final long component3() {
            return this.stallRoomCount;
        }

        public final StallRoomSensitivity copy(String r8, long r9, long r11) {
            return new StallRoomSensitivity(r8, r9, r11);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof StallRoomSensitivity) == false) goto L12;
            StallRoomSensitivity r7 = (StallRoomSensitivity) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.watchRoomCount == r7.watchRoomCount) goto L10;
            return false;
        L10:
            if (this.stallRoomCount == r7.stallRoomCount) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.watchRoomCount;
            int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
            long r4 = this.stallRoomCount;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "StallRoomSensitivity(date=" + this.date + ", watchRoomCount=" + this.watchRoomCount + ", stallRoomCount=" + this.stallRoomCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getStallRoomCount() {
            return this.stallRoomCount;
        }

        public final long getWatchRoomCount() {
            return this.watchRoomCount;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setStallRoomCount(long r1) {
            this.stallRoomCount = r1;
        }

        public final void setWatchRoomCount(long r1) {
            this.watchRoomCount = r1;
        }

        public StallRoomSensitivity(String r1, long r2, long r4) {
            this.date = r1;
            this.watchRoomCount = r2;
            this.stallRoomCount = r4;
        }

        public /* synthetic */ StallRoomSensitivity(String r5, long r6, long r8, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = "";
        L6:
            if ((r11 & 2) == 0) goto L8;
            long r2 = 0;
        L10:
            if ((r11 & 4) == 0) goto L12;
            long r13 = 0;
        L13:
            this(r5, r2, r13);
            return;
        L12:
            r13 = r8;
            goto L13
        L8:
            r2 = r6;
            goto L10
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StartLiveDataItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "startLiveCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getStartLiveCount", "()I", "setStartLiveCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StartLiveDataItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("start_live_count")
        private int startLiveCount;

        public StartLiveDataItem() {
            String r2 = null;
            this(r2, 0, 3, r2);
        }

        public static /* synthetic */ StartLiveDataItem copy$default(StartLiveDataItem r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.startLiveCount;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.startLiveCount;
        }

        public final StartLiveDataItem copy(String r2, int r3) {
            return new StartLiveDataItem(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof StartLiveDataItem) == false) goto L10;
            StartLiveDataItem r4 = (StartLiveDataItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (this.startLiveCount == r4.startLiveCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.startLiveCount;
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "StartLiveDataItem(date=" + this.date + ", startLiveCount=" + this.startLiveCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getStartLiveCount() {
            return this.startLiveCount;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setStartLiveCount(int r1) {
            this.startLiveCount = r1;
        }

        public StartLiveDataItem(String r1, int r2) {
            this.date = r1;
            this.startLiveCount = r2;
        }

        public /* synthetic */ StartLiveDataItem(String r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StopLiveReasonDataItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "reasonCountList", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getReasonCountList", "()Ljava/util/List;", "setReasonCountList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StopLiveReasonDataItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("reason_count_list")
        private List<Integer> reasonCountList;

        /* JADX WARN: Multi-variable type inference failed */
        public StopLiveReasonDataItem() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopLiveReasonDataItem copy$default(StopLiveReasonDataItem r0, String r1, List r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.reasonCountList;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.date;
        }

        public final List<Integer> component2() {
            return this.reasonCountList;
        }

        public final StopLiveReasonDataItem copy(String r2, List<Integer> r3) {
            return new StopLiveReasonDataItem(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof StopLiveReasonDataItem) == false) goto L10;
            StopLiveReasonDataItem r4 = (StopLiveReasonDataItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.reasonCountList, r4.reasonCountList) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<Integer> r4 = this.reasonCountList;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "StopLiveReasonDataItem(date=" + this.date + ", reasonCountList=" + this.reasonCountList + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final List<Integer> getReasonCountList() {
            return this.reasonCountList;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setReasonCountList(List<Integer> r1) {
            this.reasonCountList = r1;
        }

        public StopLiveReasonDataItem(String r1, List<Integer> r2) {
            this.date = r1;
            this.reasonCountList = r2;
        }

        public /* synthetic */ StopLiveReasonDataItem(String r3, List r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r3 = "";
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0, 0, 0});
        L8:
            this(r3, r4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$WatchHotroomPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchHotroomCount", "", "watchHotroomDurationSum", "watchNotHotroomCount", "watchNotHotroomDurationSum", "(Ljava/lang/String;JJJJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getWatchHotroomCount", "()J", "setWatchHotroomCount", "(J)V", "getWatchHotroomDurationSum", "setWatchHotroomDurationSum", "getWatchNotHotroomCount", "setWatchNotHotroomCount", "getWatchNotHotroomDurationSum", "setWatchNotHotroomDurationSum", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WatchHotroomPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("watch_hotroom_count")
        private long watchHotroomCount;

        @SerializedName("watch_hotroom_duration_sum")
        private long watchHotroomDurationSum;

        @SerializedName("watch_nothotroom_count")
        private long watchNotHotroomCount;

        @SerializedName("watch_nothotroom_duration_sum")
        private long watchNotHotroomDurationSum;

        public WatchHotroomPvItem() {
            this(null, 0, 0, 0, 0, 31, null);
        }

        public static /* synthetic */ WatchHotroomPvItem copy$default(WatchHotroomPvItem r11, String r12, long r13, long r14, long r16, long r18, int r21, Object r22) {
            if ((r21 & 1) == 0) goto L5;
            String r1 = r11.date;
        L7:
            if ((r21 & 2) == 0) goto L9;
            long r2 = r11.watchHotroomCount;
        L11:
            if ((r21 & 4) == 0) goto L13;
            long r4 = r11.watchHotroomDurationSum;
        L15:
            if ((r21 & 8) == 0) goto L17;
            long r6 = r11.watchNotHotroomCount;
        L19:
            if ((r21 & 16) == 0) goto L21;
            long r8 = r11.watchNotHotroomDurationSum;
        L23:
            return r11.copy(r1, r2, r4, r6, r8);
        L21:
            r8 = r18;
            goto L23
        L17:
            r6 = r16;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r2 = r13;
            goto L11
        L5:
            r1 = r12;
            goto L7
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.watchHotroomCount;
        }

        public final long component3() {
            return this.watchHotroomDurationSum;
        }

        public final long component4() {
            return this.watchNotHotroomCount;
        }

        public final long component5() {
            return this.watchNotHotroomDurationSum;
        }

        public final WatchHotroomPvItem copy(String r12, long r13, long r15, long r17, long r19) {
            return new WatchHotroomPvItem(r12, r13, r15, r17, r19);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof WatchHotroomPvItem) == false) goto L16;
            WatchHotroomPvItem r7 = (WatchHotroomPvItem) r6;
            if (Intrinsics.areEqual(this.date, r7.date) == true) goto L8;
            return false;
        L8:
            if (this.watchHotroomCount == r7.watchHotroomCount) goto L10;
            return false;
        L10:
            if (this.watchHotroomDurationSum == r7.watchHotroomDurationSum) goto L12;
            return false;
        L12:
            if (this.watchNotHotroomCount == r7.watchNotHotroomCount) goto L14;
            return false;
        L14:
            if (this.watchNotHotroomDurationSum == r7.watchNotHotroomDurationSum) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.watchHotroomCount;
            int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
            long r4 = this.watchHotroomDurationSum;
            int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            long r6 = this.watchNotHotroomCount;
            int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
            long r8 = this.watchNotHotroomDurationSum;
            return r7 + ((int) (r8 ^ (r8 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            return "WatchHotroomPvItem(date=" + this.date + ", watchHotroomCount=" + this.watchHotroomCount + ", watchHotroomDurationSum=" + this.watchHotroomDurationSum + ", watchNotHotroomCount=" + this.watchNotHotroomCount + ", watchNotHotroomDurationSum=" + this.watchNotHotroomDurationSum + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getWatchHotroomCount() {
            return this.watchHotroomCount;
        }

        public final long getWatchHotroomDurationSum() {
            return this.watchHotroomDurationSum;
        }

        public final long getWatchNotHotroomCount() {
            return this.watchNotHotroomCount;
        }

        public final long getWatchNotHotroomDurationSum() {
            return this.watchNotHotroomDurationSum;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setWatchHotroomCount(long r1) {
            this.watchHotroomCount = r1;
        }

        public final void setWatchHotroomDurationSum(long r1) {
            this.watchHotroomDurationSum = r1;
        }

        public final void setWatchNotHotroomCount(long r1) {
            this.watchNotHotroomCount = r1;
        }

        public final void setWatchNotHotroomDurationSum(long r1) {
            this.watchNotHotroomDurationSum = r1;
        }

        public WatchHotroomPvItem(String r1, long r2, long r4, long r6, long r8) {
            this.date = r1;
            this.watchHotroomCount = r2;
            this.watchHotroomDurationSum = r4;
            this.watchNotHotroomCount = r6;
            this.watchNotHotroomDurationSum = r8;
        }

        public /* synthetic */ WatchHotroomPvItem(String r11, long r12, long r14, long r16, long r18, int r21, DefaultConstructorMarker r22) {
            if ((r21 & 1) == 0) goto L5;
            String r0 = "";
        L6:
            long r2 = 0;
            if ((r21 & 2) == 0) goto L9;
            long r4 = 0;
        L11:
            if ((r21 & 4) == 0) goto L13;
            long r6 = 0;
        L15:
            if ((r21 & 8) == 0) goto L17;
            long r8 = 0;
        L19:
            if ((r21 & 16) != 0) goto L22;
            r2 = r18;
        L22:
            this(r0, r4, r6, r8, r2);
            return;
        L17:
            r8 = r16;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r4 = r12;
            goto L11
        L5:
            r0 = r11;
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$WatchLiveDateItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WatchLiveDateItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        public WatchLiveDateItem() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ WatchLiveDateItem copy$default(WatchLiveDateItem r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.date;
        }

        public final WatchLiveDateItem copy(String r2) {
            return new WatchLiveDateItem(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof WatchLiveDateItem) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.date, ((WatchLiveDateItem) r2).date) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "WatchLiveDateItem(date=" + this.date + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public WatchLiveDateItem(String r1) {
            this.date = r1;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public /* synthetic */ WatchLiveDateItem(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = "";
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$WatchRoomPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getWatchCount", "()I", "setWatchCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WatchRoomPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("watch_count")
        private int watchCount;

        public WatchRoomPvItem() {
            String r2 = null;
            this(r2, 0, 3, r2);
        }

        public static /* synthetic */ WatchRoomPvItem copy$default(WatchRoomPvItem r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.watchCount;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.watchCount;
        }

        public final WatchRoomPvItem copy(String r2, int r3) {
            return new WatchRoomPvItem(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof WatchRoomPvItem) == false) goto L10;
            WatchRoomPvItem r4 = (WatchRoomPvItem) r3;
            if (Intrinsics.areEqual(this.date, r4.date) == true) goto L8;
            return false;
        L8:
            if (this.watchCount == r4.watchCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.date;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.watchCount;
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "WatchRoomPvItem(date=" + this.date + ", watchCount=" + this.watchCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getWatchCount() {
            return this.watchCount;
        }

        public final void setDate(String r1) {
            this.date = r1;
        }

        public final void setWatchCount(int r1) {
            this.watchCount = r1;
        }

        public WatchRoomPvItem(String r1, int r2) {
            this.date = r1;
            this.watchCount = r2;
        }

        public /* synthetic */ WatchRoomPvItem(String r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }
    }

    private JsonItemHelper() {
    }

    static {
        INSTANCE = new JsonItemHelper();
    }
}
