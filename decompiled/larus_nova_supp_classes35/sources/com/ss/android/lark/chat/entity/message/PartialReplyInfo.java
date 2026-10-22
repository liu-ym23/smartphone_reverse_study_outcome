package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "Ljava/io/Serializable;", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "position", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo$PartialContentRelativePosition;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo$PartialContentRelativePosition;)V", "getContent", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setContent", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getPosition", "()Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo$PartialContentRelativePosition;", "setPosition", "(Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo$PartialContentRelativePosition;)V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "component1", "component2", "copy", "PartialContentRelativePosition", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PartialReplyInfo implements Serializable {
    private RichText content;
    private PartialContentRelativePosition position;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo$PartialContentRelativePosition;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "HEAD", "MIDDLE", "TAIL", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PartialContentRelativePosition extends Enum<PartialContentRelativePosition> {
        public static final a Companion = null;
        public static final PartialContentRelativePosition HEAD = null;
        public static final PartialContentRelativePosition MIDDLE = null;
        public static final PartialContentRelativePosition TAIL = null;
        public static final PartialContentRelativePosition UNKNOWN = null;
        public static final /* synthetic */ PartialContentRelativePosition[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static PartialContentRelativePosition a(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L18;
                if (r1 == 2) goto L17;
                if (r1 == 3) goto L16;
                return PartialContentRelativePosition.UNKNOWN;
            L16:
                return PartialContentRelativePosition.TAIL;
            L17:
                return PartialContentRelativePosition.MIDDLE;
            L18:
                return PartialContentRelativePosition.HEAD;
            L14:
                return PartialContentRelativePosition.UNKNOWN;
            }
        }

        @JvmStatic
        public static final PartialContentRelativePosition fromValue(int r1) {
            Companion.getClass();
            return a.a(r1);
        }

        public static EnumEntries<PartialContentRelativePosition> getEntries() {
            return b;
        }

        static {
            PartialContentRelativePosition r0 = new PartialContentRelativePosition("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            PartialContentRelativePosition r1 = new PartialContentRelativePosition("HEAD", 1, 1);
            HEAD = r1;
            PartialContentRelativePosition r3 = new PartialContentRelativePosition("MIDDLE", 2, 2);
            MIDDLE = r3;
            PartialContentRelativePosition r5 = new PartialContentRelativePosition("TAIL", 3, 3);
            TAIL = r5;
            PartialContentRelativePosition[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static PartialContentRelativePosition[] values() {
            return (PartialContentRelativePosition[]) a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static PartialContentRelativePosition valueOf(String r1) {
            return (PartialContentRelativePosition) r27.a.a(PartialContentRelativePosition.class, r1);
        }

        public PartialContentRelativePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    public static /* synthetic */ PartialReplyInfo copy$default(PartialReplyInfo r0, RichText r1, PartialContentRelativePosition r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.content;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.position;
    L9:
        return r0.copy(r1, r2);
    }

    public final RichText component1() {
        return this.content;
    }

    public final PartialContentRelativePosition component2() {
        return this.position;
    }

    public final PartialReplyInfo copy(RichText r2, PartialContentRelativePosition r3) {
        return new PartialReplyInfo(r2, r3);
    }

    public int hashCode() {
        RichText r0 = this.content;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        PartialContentRelativePosition r4 = this.position;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PartialReplyInfo(content=" + this.content + ", position=" + this.position + ')';
    }

    public final RichText getContent() {
        return this.content;
    }

    public final PartialContentRelativePosition getPosition() {
        return this.position;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(PartialReplyInfo.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.PartialReplyInfo");
        PartialReplyInfo r6 = (PartialReplyInfo) r5;
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L16;
        return false;
    L16:
        if (this.position == r6.position) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setContent(RichText r1) {
        this.content = r1;
    }

    public final void setPosition(PartialContentRelativePosition r1) {
        this.position = r1;
    }

    public PartialReplyInfo(RichText r1, PartialContentRelativePosition r2) {
        this.content = r1;
        this.position = r2;
    }
}
