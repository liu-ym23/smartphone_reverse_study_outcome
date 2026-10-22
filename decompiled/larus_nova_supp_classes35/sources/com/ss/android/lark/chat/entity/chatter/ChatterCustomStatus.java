package com.ss.android.lark.chat.entity.chatter;

import com.bytedance.lark.pb.basic.v1.TagColor;
import com.bytedance.lark.pb.basic.v1.TimeFormat;
import com.bytedance.lark.pb.basic.v1.TimeUnit;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0007'()*+,-BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÂ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÂ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÂ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÂ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus;", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus;", "Ljava/io/Serializable;", "title", BuildConfig.FLAVOR, "iconKey", "isNotDisturbMode", BuildConfig.FLAVOR, "effectiveInterval", "Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusEffectiveInterval;", "fsUnit", "tagInfo", "Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTagInfo;", "timeFormat", "Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTimeFormat;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusEffectiveInterval;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTagInfo;Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTimeFormat;)V", "getTitle", "getIconKey", "getEffectiveInterval", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus$IStatusEffectiveInterval;", "getTagInfo", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus$IStatusTagInfo;", "getTimeFormat", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus$IStatusTimeFormat;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "StatusEffectiveInterval", "StatusTagInfo", "StatusTimeFormat", "StatusTagColor", "StatusTimeUnit", "StatusStartEndLayout", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterCustomStatus implements Serializable {
    public static final a Companion = null;
    private final StatusEffectiveInterval effectiveInterval;
    private final String fsUnit;
    private final String iconKey;
    private final boolean isNotDisturbMode;
    private final StatusTagInfo tagInfo;
    private final StatusTimeFormat timeFormat;
    private final String title;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\t\u0010\f\u001a\u00020\u0004HÂ\u0003J\t\u0010\r\u001a\u00020\u0004HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusEffectiveInterval;", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus$IStatusEffectiveInterval;", "Ljava/io/Serializable;", "startTime", BuildConfig.FLAVOR, "endTime", "isShowEndTime", BuildConfig.FLAVOR, "<init>", "(JJZ)V", "getStartTime", "getEndTime", "component1", "component2", "component3", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StatusEffectiveInterval implements o5b.b, Serializable {
        public static final a Companion = null;
        private final long endTime;
        private final boolean isShowEndTime;
        private final long startTime;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public static /* synthetic */ StatusEffectiveInterval copy$default(StatusEffectiveInterval r6, long r7, long r9, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.startTime;
        L5:
            long r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r9 = r6.endTime;
        L8:
            long r3 = r9;
            if ((r12 & 4) == 0) goto L12;
            r11 = r6.isShowEndTime;
        L12:
            return r6.copy(r1, r3, r11);
        }

        public final StatusEffectiveInterval copy(long r8, long r10, boolean r12) {
            return new StatusEffectiveInterval(r8, r10, r12);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof StatusEffectiveInterval) == true) goto L8;
            return false;
        L8:
            StatusEffectiveInterval r9 = (StatusEffectiveInterval) r8;
            if (this.startTime == r9.startTime) goto L12;
            return false;
        L12:
            if (this.endTime == r9.endTime) goto L15;
            return false;
        L15:
            if (this.isShowEndTime == r9.isShowEndTime) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            long r0 = this.startTime;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.endTime;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            if (this.isShowEndTime == false) goto L5;
            int r4 = 1231;
        L7:
            return r2 + r4;
        L5:
            r4 = 1237;
            goto L7
        }

        public String toString() {
            return "StatusEffectiveInterval(startTime=" + this.startTime + ", endTime=" + this.endTime + ", isShowEndTime=" + this.isShowEndTime + ')';
        }

        @Override // o5b.b
        public long getEndTime() {
            return this.endTime;
        }

        @Override // o5b.b
        public long getStartTime() {
            return this.startTime;
        }

        public boolean isShowEndTime() {
            return this.isShowEndTime;
        }

        public static final /* synthetic */ long access$getEndTime$p(StatusEffectiveInterval r2) {
            return r2.endTime;
        }

        public static final /* synthetic */ long access$getStartTime$p(StatusEffectiveInterval r2) {
            return r2.startTime;
        }

        public static final /* synthetic */ boolean access$isShowEndTime$p(StatusEffectiveInterval r0) {
            return r0.isShowEndTime;
        }

        public StatusEffectiveInterval(long r1, long r3, boolean r5) {
            this.startTime = r1;
            this.endTime = r3;
            this.isShowEndTime = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusStartEndLayout;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HIDE", "NORMAL", "START_ONLY", "END_ONLY", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StatusStartEndLayout extends Enum<StatusStartEndLayout> {
        public static final a Companion = null;
        public static final StatusStartEndLayout END_ONLY = null;
        public static final StatusStartEndLayout HIDE = null;
        public static final StatusStartEndLayout NORMAL = null;
        public static final StatusStartEndLayout START_ONLY = null;
        public static final /* synthetic */ StatusStartEndLayout[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<StatusStartEndLayout> getEntries() {
            return b;
        }

        static {
            StatusStartEndLayout r0 = new StatusStartEndLayout("HIDE", 0, 0);
            HIDE = r0;
            StatusStartEndLayout r1 = new StatusStartEndLayout("NORMAL", 1, 1);
            NORMAL = r1;
            StatusStartEndLayout r3 = new StatusStartEndLayout("START_ONLY", 2, 2);
            START_ONLY = r3;
            StatusStartEndLayout r5 = new StatusStartEndLayout("END_ONLY", 3, 3);
            END_ONLY = r5;
            StatusStartEndLayout[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static StatusStartEndLayout[] values() {
            return (StatusStartEndLayout[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StatusStartEndLayout valueOf(String r1) {
            return (StatusStartEndLayout) r27.a.a(StatusStartEndLayout.class, r1);
        }

        public StatusStartEndLayout(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTagColor;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BLUE", "GRAY", "INDIGO", "WHITE", "GREEN", "TURQUOISE", "YELLOW", "LIME", "RED", "ORANGE", "PURPLE", "VIOLET", "CARMINE", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StatusTagColor extends Enum<StatusTagColor> {
        public static final StatusTagColor BLUE = null;
        public static final StatusTagColor CARMINE = null;
        public static final a Companion = null;
        public static final StatusTagColor GRAY = null;
        public static final StatusTagColor GREEN = null;
        public static final StatusTagColor INDIGO = null;
        public static final StatusTagColor LIME = null;
        public static final StatusTagColor ORANGE = null;
        public static final StatusTagColor PURPLE = null;
        public static final StatusTagColor RED = null;
        public static final StatusTagColor TURQUOISE = null;
        public static final StatusTagColor VIOLET = null;
        public static final StatusTagColor WHITE = null;
        public static final StatusTagColor YELLOW = null;
        public static final /* synthetic */ StatusTagColor[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<StatusTagColor> getEntries() {
            return b;
        }

        static {
            StatusTagColor r0 = new StatusTagColor("BLUE", 0, 0);
            BLUE = r0;
            StatusTagColor r1 = new StatusTagColor("GRAY", 1, 1);
            GRAY = r1;
            StatusTagColor r3 = new StatusTagColor("INDIGO", 2, 2);
            INDIGO = r3;
            StatusTagColor r5 = new StatusTagColor("WHITE", 3, 3);
            WHITE = r5;
            StatusTagColor r7 = new StatusTagColor("GREEN", 4, 4);
            GREEN = r7;
            StatusTagColor r9 = new StatusTagColor("TURQUOISE", 5, 5);
            TURQUOISE = r9;
            StatusTagColor r11 = new StatusTagColor("YELLOW", 6, 6);
            YELLOW = r11;
            StatusTagColor r13 = new StatusTagColor("LIME", 7, 7);
            LIME = r13;
            StatusTagColor r15 = new StatusTagColor("RED", 8, 8);
            RED = r15;
            StatusTagColor r14 = new StatusTagColor("ORANGE", 9, 9);
            ORANGE = r14;
            StatusTagColor r12 = new StatusTagColor("PURPLE", 10, 10);
            PURPLE = r12;
            StatusTagColor r10 = new StatusTagColor("VIOLET", 11, 11);
            VIOLET = r10;
            StatusTagColor r8 = new StatusTagColor("CARMINE", 12, 12);
            CARMINE = r8;
            StatusTagColor[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new a();
        }

        public static StatusTagColor[] values() {
            return (StatusTagColor[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StatusTagColor valueOf(String r1) {
            return (StatusTagColor) r27.a.a(StatusTagColor.class, r1);
        }

        public StatusTagColor(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\t\u0010\n\u001a\u00020\u0004HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÂ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTagInfo;", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus$IStatusTagInfo;", "Ljava/io/Serializable;", "isShowTag", BuildConfig.FLAVOR, "statusTagColor", "Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTagColor;", "<init>", "(ZLcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTagColor;)V", "getTagColor", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StatusTagInfo implements o5b.c, Serializable {
        public static final a Companion = null;
        private final boolean isShowTag;
        private final StatusTagColor statusTagColor;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public static /* synthetic */ StatusTagInfo copy$default(StatusTagInfo r0, boolean r1, StatusTagColor r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.isShowTag;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.statusTagColor;
        L9:
            return r0.copy(r1, r2);
        }

        public final StatusTagInfo copy(boolean r2, StatusTagColor r3) {
            Intrinsics.checkNotNullParameter(r3, "statusTagColor");
            return new StatusTagInfo(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StatusTagInfo) == true) goto L8;
            return false;
        L8:
            StatusTagInfo r6 = (StatusTagInfo) r5;
            if (this.isShowTag == r6.isShowTag) goto L12;
            return false;
        L12:
            if (this.statusTagColor == r6.statusTagColor) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            if (this.isShowTag == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.statusTagColor.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public String toString() {
            return "StatusTagInfo(isShowTag=" + this.isShowTag + ", statusTagColor=" + this.statusTagColor + ')';
        }

        public StatusTagColor getTagColor() {
            return this.statusTagColor;
        }

        public boolean isShowTag() {
            return this.isShowTag;
        }

        public static final /* synthetic */ StatusTagColor access$getStatusTagColor$p(StatusTagInfo r0) {
            return r0.statusTagColor;
        }

        public static final /* synthetic */ boolean access$isShowTag$p(StatusTagInfo r0) {
            return r0.isShowTag;
        }

        public StatusTagInfo(boolean r2, StatusTagColor r3) {
            Intrinsics.checkNotNullParameter(r3, "statusTagColor");
            this.isShowTag = r2;
            this.statusTagColor = r3;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\t\u0010\u000b\u001a\u00020\u0004HÂ\u0003J\t\u0010\f\u001a\u00020\u0006HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTimeFormat;", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus$IStatusTimeFormat;", "Ljava/io/Serializable;", "timeUnit", "Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTimeUnit;", "startEndLayout", "Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusStartEndLayout;", "<init>", "(Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTimeUnit;Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusStartEndLayout;)V", "getTimeUnit", "getStartEndLayout", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StatusTimeFormat implements o5b.d, Serializable {
        public static final a Companion = null;
        private final StatusStartEndLayout startEndLayout;
        private final StatusTimeUnit timeUnit;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public static /* synthetic */ StatusTimeFormat copy$default(StatusTimeFormat r0, StatusTimeUnit r1, StatusStartEndLayout r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.timeUnit;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.startEndLayout;
        L9:
            return r0.copy(r1, r2);
        }

        public final StatusTimeFormat copy(StatusTimeUnit r2, StatusStartEndLayout r3) {
            Intrinsics.checkNotNullParameter(r2, "timeUnit");
            Intrinsics.checkNotNullParameter(r3, "startEndLayout");
            return new StatusTimeFormat(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StatusTimeFormat) == true) goto L8;
            return false;
        L8:
            StatusTimeFormat r6 = (StatusTimeFormat) r5;
            if (this.timeUnit == r6.timeUnit) goto L12;
            return false;
        L12:
            if (this.startEndLayout == r6.startEndLayout) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.timeUnit.hashCode() * 31) + this.startEndLayout.hashCode();
        }

        public String toString() {
            return "StatusTimeFormat(timeUnit=" + this.timeUnit + ", startEndLayout=" + this.startEndLayout + ')';
        }

        public StatusStartEndLayout getStartEndLayout() {
            return this.startEndLayout;
        }

        public StatusTimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        public static final /* synthetic */ StatusStartEndLayout access$getStartEndLayout$p(StatusTimeFormat r0) {
            return r0.startEndLayout;
        }

        public static final /* synthetic */ StatusTimeUnit access$getTimeUnit$p(StatusTimeFormat r0) {
            return r0.timeUnit;
        }

        public StatusTimeFormat(StatusTimeUnit r2, StatusStartEndLayout r3) {
            Intrinsics.checkNotNullParameter(r2, "timeUnit");
            Intrinsics.checkNotNullParameter(r3, "startEndLayout");
            this.timeUnit = r2;
            this.startEndLayout = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterCustomStatus$StatusTimeUnit;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SECOND", "MINUTE", "HOUR", "DAY", "MONTH", "YEAR", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StatusTimeUnit extends Enum<StatusTimeUnit> {
        public static final a Companion = null;
        public static final StatusTimeUnit DAY = null;
        public static final StatusTimeUnit HOUR = null;
        public static final StatusTimeUnit MINUTE = null;
        public static final StatusTimeUnit MONTH = null;
        public static final StatusTimeUnit SECOND = null;
        public static final StatusTimeUnit YEAR = null;
        public static final /* synthetic */ StatusTimeUnit[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<StatusTimeUnit> getEntries() {
            return b;
        }

        static {
            StatusTimeUnit r0 = new StatusTimeUnit("SECOND", 0, 0);
            SECOND = r0;
            StatusTimeUnit r1 = new StatusTimeUnit("MINUTE", 1, 1);
            MINUTE = r1;
            StatusTimeUnit r3 = new StatusTimeUnit("HOUR", 2, 2);
            HOUR = r3;
            StatusTimeUnit r5 = new StatusTimeUnit("DAY", 3, 3);
            DAY = r5;
            StatusTimeUnit r7 = new StatusTimeUnit("MONTH", 4, 4);
            MONTH = r7;
            StatusTimeUnit r9 = new StatusTimeUnit("YEAR", 5, 5);
            YEAR = r9;
            StatusTimeUnit[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static StatusTimeUnit[] values() {
            return (StatusTimeUnit[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StatusTimeUnit valueOf(String r1) {
            return (StatusTimeUnit) r27.a.a(StatusTimeUnit.class, r1);
        }

        public StatusTimeUnit(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }

        public static ChatterCustomStatus a(com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus r16) {
            String r1 = r16.title;
            String r2 = r16.icon_key;
            boolean r3 = r16.is_not_disturb_mode.booleanValue();
            StatusEffectiveInterval.a r4 = StatusEffectiveInterval.Companion;
            com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval r5 = r16.effective_interval;
            r4.getClass();
            if (r5 == null) goto L5;
            StatusEffectiveInterval r6 = new StatusEffectiveInterval(r5.start_time.longValue(), r5.end_time.longValue(), r5.is_show_end_time.booleanValue());
        L6:
            String r7 = r16.fs_unit;
            StatusTagInfo.a r8 = StatusTagInfo.Companion;
            com.bytedance.lark.pb.basic.v1.TagInfo r9 = r16.tag_info;
            r8.getClass();
            int r10 = 0;
            if (r9 == null) goto L16;
            boolean r11 = r9.is_show_tag.booleanValue();
            StatusTagColor.a r12 = StatusTagColor.Companion;
            int r13 = r9.tag_color.getValue();
            r12.getClass();
            StatusTagColor[] r14 = StatusTagColor.values();
            int r15 = r14.length;
            int r17 = 0;
        L9:
            if (r17 >= r15) goto L14;
            StatusTagColor r18 = r14[r17];
            if (r13 == r18.getValue()) goto L15;
            r17 = r17 + 1;
        L15:
            StatusTagInfo r19 = new StatusTagInfo(r11, r18);
        L17:
            StatusTimeFormat.a r20 = StatusTimeFormat.Companion;
            TimeFormat r0 = r16.time_format;
            r20.getClass();
            if (r0 == null) goto L34;
            StatusTimeUnit.a r21 = StatusTimeUnit.Companion;
            int r110 = r0.time_unit.getValue();
            r21.getClass();
            StatusTimeUnit[] r22 = StatusTimeUnit.values();
            int r111 = r22.length;
            int r112 = 0;
        L20:
            if (r112 >= r111) goto L25;
            StatusTimeUnit r113 = r22[r112];
            if (r110 == r113.getValue()) goto L26;
            r112 = r112 + 1;
        L26:
            StatusStartEndLayout.a r23 = StatusStartEndLayout.Companion;
            int r24 = r0.start_end_layout.getValue();
            r23.getClass();
            StatusStartEndLayout[] r25 = StatusStartEndLayout.values();
            int r114 = r25.length;
        L27:
            if (r10 >= r114) goto L32;
            StatusStartEndLayout r115 = r25[r10];
            if (r24 == r115.getValue()) goto L33;
            r10 = r10 + 1;
        L33:
            StatusTimeFormat r26 = new StatusTimeFormat(r113, r115);
        L36:
            return new ChatterCustomStatus(r1, r2, r3, r6, r7, r19, r26);
        L32:
            r115 = StatusStartEndLayout.HIDE;
            goto L33
        L25:
            r113 = StatusTimeUnit.SECOND;
            goto L26
        L34:
            r26 = null;
            goto L36
        L14:
            r18 = StatusTagColor.BLUE;
            goto L15
        L16:
            r19 = null;
            goto L17
        L5:
            r6 = null;
            goto L6
        }

        @JvmStatic
        public static List b(List r3) {
            Intrinsics.checkNotNullParameter(r3, "pb");
            List r4 = r3;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus r1 = (com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus) r5.next();
            ChatterCustomStatus.Companion.getClass();
            r0.add(a(r1));
            goto L4
        L6:
            return r0;
        }

        @JvmStatic
        public static List c(List r8) {
            if (r8 == null) goto L29;
            List r9 = r8;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator r10 = r9.iterator();
        L6:
            if (r10.hasNext() == false) goto L25;
            ChatterCustomStatus r2 = (ChatterCustomStatus) r10.next();
            com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus.Builder r3 = new com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus.Builder().fs_unit(ChatterCustomStatus.access$getFsUnit$p(r2)).title(ChatterCustomStatus.access$getTitle$p(r2)).icon_key(ChatterCustomStatus.access$getIconKey$p(r2)).is_not_disturb_mode(Boolean.valueOf(ChatterCustomStatus.access$isNotDisturbMode$p(r2)));
            StatusEffectiveInterval.a r4 = StatusEffectiveInterval.Companion;
            StatusEffectiveInterval r5 = ChatterCustomStatus.access$getEffectiveInterval$p(r2);
            r4.getClass();
            if (r5 == null) goto L10;
            com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval r6 = new com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval.Builder().start_time(Long.valueOf(StatusEffectiveInterval.access$getStartTime$p(r5))).end_time(Long.valueOf(StatusEffectiveInterval.access$getEndTime$p(r5))).is_show_end_time(Boolean.valueOf(StatusEffectiveInterval.access$isShowEndTime$p(r5))).build();
        L11:
            com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus.Builder r7 = r3.effective_interval(r6);
            StatusTagInfo.a r11 = StatusTagInfo.Companion;
            StatusTagInfo r12 = ChatterCustomStatus.access$getTagInfo$p(r2);
            r11.getClass();
            if (r12 == null) goto L18;
            com.bytedance.lark.pb.basic.v1.TagInfo.Builder r13 = new com.bytedance.lark.pb.basic.v1.TagInfo.Builder().is_show_tag(Boolean.valueOf(StatusTagInfo.access$isShowTag$p(r12)));
            StatusTagColor r14 = StatusTagInfo.access$getStatusTagColor$p(r12);
            if (r14 == null) goto L16;
            int r15 = r14.getValue();
        L17:
            com.bytedance.lark.pb.basic.v1.TagInfo r16 = r13.tag_color(TagColor.fromValue(r15)).build();
        L19:
            com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus.Builder r17 = r7.tag_info(r16);
            StatusTimeFormat.a r18 = StatusTimeFormat.Companion;
            StatusTimeFormat r19 = ChatterCustomStatus.access$getTimeFormat$p(r2);
            r18.getClass();
            if (r19 == null) goto L22;
            TimeFormat r20 = new TimeFormat.Builder().time_unit(TimeUnit.fromValue(StatusTimeFormat.access$getTimeUnit$p(r19).getValue())).start_end_layout(TimeFormat.StartEndLayout.fromValue(StatusTimeFormat.access$getStartEndLayout$p(r19).getValue())).build();
        L23:
            r1.add(r17.time_format(r20).build());
            goto L6
        L22:
            r20 = null;
            goto L23
        L16:
            r15 = 0;
            goto L17
        L18:
            r16 = null;
            goto L19
        L10:
            r6 = null;
            goto L11
        L25:
            return r1;
        L29:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ChatterCustomStatus copy$default(ChatterCustomStatus r5, String r6, String r7, boolean r8, StatusEffectiveInterval r9, String r10, StatusTagInfo r11, StatusTimeFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.title;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.iconKey;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.isNotDisturbMode;
    L11:
        boolean r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.effectiveInterval;
    L14:
        StatusEffectiveInterval r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.fsUnit;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.tagInfo;
    L20:
        StatusTagInfo r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.timeFormat;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    @JvmStatic
    public static final List<ChatterCustomStatus> fromPB(List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r1) {
        Companion.getClass();
        return a.b(r1);
    }

    @JvmStatic
    public static final List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> toPB(List<ChatterCustomStatus> r1) {
        Companion.getClass();
        return a.c(r1);
    }

    public final ChatterCustomStatus copy(String r10, String r11, boolean r12, StatusEffectiveInterval r13, String r14, StatusTagInfo r15, StatusTimeFormat r16) {
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "iconKey");
        Intrinsics.checkNotNullParameter(r14, "fsUnit");
        return new ChatterCustomStatus(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatterCustomStatus) == true) goto L8;
        return false;
    L8:
        ChatterCustomStatus r6 = (ChatterCustomStatus) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconKey, r6.iconKey) == true) goto L15;
        return false;
    L15:
        if (this.isNotDisturbMode == r6.isNotDisturbMode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.effectiveInterval, r6.effectiveInterval) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fsUnit, r6.fsUnit) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tagInfo, r6.tagInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeFormat, r6.timeFormat) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.title.hashCode() * 31) + this.iconKey.hashCode()) * 31;
        if (this.isNotDisturbMode == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        StatusEffectiveInterval r3 = this.effectiveInterval;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r2 + r5) * 31) + this.fsUnit.hashCode()) * 31;
        StatusTagInfo r7 = this.tagInfo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        StatusTimeFormat r10 = this.timeFormat;
        if (r10 == null) goto L19;
        r4 = r10.hashCode();
    L19:
        return r9 + r4;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatterCustomStatus(title=" + this.title + ", iconKey=" + this.iconKey + ", isNotDisturbMode=" + this.isNotDisturbMode + ", effectiveInterval=" + this.effectiveInterval + ", fsUnit=" + this.fsUnit + ", tagInfo=" + this.tagInfo + ", timeFormat=" + this.timeFormat + ')';
    }

    public o5b.b getEffectiveInterval() {
        return this.effectiveInterval;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public o5b.c getTagInfo() {
        return this.tagInfo;
    }

    public o5b.d getTimeFormat() {
        return this.timeFormat;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isNotDisturbMode() {
        return this.isNotDisturbMode;
    }

    public static final /* synthetic */ StatusEffectiveInterval access$getEffectiveInterval$p(ChatterCustomStatus r0) {
        return r0.effectiveInterval;
    }

    public static final /* synthetic */ String access$getFsUnit$p(ChatterCustomStatus r0) {
        return r0.fsUnit;
    }

    public static final /* synthetic */ String access$getIconKey$p(ChatterCustomStatus r0) {
        return r0.iconKey;
    }

    public static final /* synthetic */ StatusTagInfo access$getTagInfo$p(ChatterCustomStatus r0) {
        return r0.tagInfo;
    }

    public static final /* synthetic */ StatusTimeFormat access$getTimeFormat$p(ChatterCustomStatus r0) {
        return r0.timeFormat;
    }

    public static final /* synthetic */ String access$getTitle$p(ChatterCustomStatus r0) {
        return r0.title;
    }

    public static final /* synthetic */ boolean access$isNotDisturbMode$p(ChatterCustomStatus r0) {
        return r0.isNotDisturbMode;
    }

    @JvmStatic
    public static final ChatterCustomStatus fromPB(com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus r1) {
        Companion.getClass();
        if (r1 != null) goto L6;
        return null;
    L6:
        return a.a(r1);
    }

    public ChatterCustomStatus(String r2, String r3, boolean r4, StatusEffectiveInterval r5, String r6, StatusTagInfo r7, StatusTimeFormat r8) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "iconKey");
        Intrinsics.checkNotNullParameter(r6, "fsUnit");
        this.title = r2;
        this.iconKey = r3;
        this.isNotDisturbMode = r4;
        this.effectiveInterval = r5;
        this.fsUnit = r6;
        this.tagInfo = r7;
        this.timeFormat = r8;
    }

    public /* synthetic */ ChatterCustomStatus(String r11, String r12, boolean r13, StatusEffectiveInterval r14, String r15, StatusTagInfo r16, StatusTimeFormat r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        StatusTagInfo r8 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        StatusTimeFormat r9 = null;
    L10:
        this(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }
}
