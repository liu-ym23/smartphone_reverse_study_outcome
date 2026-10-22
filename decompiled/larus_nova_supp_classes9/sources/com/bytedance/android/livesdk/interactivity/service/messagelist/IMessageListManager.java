package com.bytedance.android.livesdk.interactivity.service.messagelist;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface IMessageListManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/messagelist/IMessageListManager$MessageChangeType;", BuildConfig.FLAVOR, "INSERT_BOTTOM", "UPDATE_BOTTOM", "REMOVE_ITEM", "UPDATE_ITEM", "INSERT_ITEM", "REMOVE_RANGE", "INIT_LIST", "RELOAD_ALL", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MessageChangeType extends Enum<MessageChangeType> {
        public static final MessageChangeType INIT_LIST = null;
        public static final MessageChangeType INSERT_BOTTOM = null;
        public static final MessageChangeType INSERT_ITEM = null;
        public static final MessageChangeType RELOAD_ALL = null;
        public static final MessageChangeType REMOVE_ITEM = null;
        public static final MessageChangeType REMOVE_RANGE = null;
        public static final MessageChangeType UPDATE_BOTTOM = null;
        public static final MessageChangeType UPDATE_ITEM = null;
        public static final /* synthetic */ MessageChangeType[] a = null;

        static {
            MessageChangeType r1 = new MessageChangeType("INSERT_BOTTOM", 0);
            INSERT_BOTTOM = r1;
            MessageChangeType r2 = new MessageChangeType("UPDATE_BOTTOM", 1);
            UPDATE_BOTTOM = r2;
            MessageChangeType r3 = new MessageChangeType("REMOVE_ITEM", 2);
            REMOVE_ITEM = r3;
            MessageChangeType r4 = new MessageChangeType("UPDATE_ITEM", 3);
            UPDATE_ITEM = r4;
            MessageChangeType r5 = new MessageChangeType("INSERT_ITEM", 4);
            INSERT_ITEM = r5;
            MessageChangeType r6 = new MessageChangeType("REMOVE_RANGE", 5);
            REMOVE_RANGE = r6;
            MessageChangeType r7 = new MessageChangeType("INIT_LIST", 6);
            INIT_LIST = r7;
            MessageChangeType r8 = new MessageChangeType("RELOAD_ALL", 7);
            RELOAD_ALL = r8;
            a = new MessageChangeType[]{r1, r2, r3, r4, r5, r6, r7, r8};
        }

        public static MessageChangeType valueOf(String r1) {
            return (MessageChangeType) r27.a.a(MessageChangeType.class, r1);
        }

        public static MessageChangeType[] values() {
            return (MessageChangeType[]) a.clone();
        }

        public MessageChangeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final MessageChangeType a;
        public final int b;
        public final int c;
        public final int d;
        public final c e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            MessageChangeType r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            c r4 = this.e;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MessageChangeEvent(type=" + this.a + ", position=" + this.b + ", rangeStart=" + this.c + ", rangeEnd=" + this.d + ", message=" + this.e + ")";
        }

        public final MessageChangeType getType() {
            return this.a;
        }

        public a(MessageChangeType r3, int r4, int r5, int r6, c r7, int r8) {
            if ((r8 & 2) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r8 & 4) == 0) goto L9;
            r5 = 0;
        L9:
            if ((r8 & 8) == 0) goto L12;
            r6 = 0;
        L12:
            if ((r8 & 16) == 0) goto L14;
            r7 = null;
        L14:
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public static final class b {
        public int a;
        public int b;
        public int c;
        public boolean d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            boolean r1 = this.d;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return r0 + r2;
        }

        public final String toString() {
            return "MessageListStatus(firstVisibleItemPosition=" + this.a + ", positionOffset=" + this.b + ", lastViewedPos=" + this.c + ", hasFullScreen=" + this.d + ")";
        }

        public b(int r1) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = false;
        }
    }

    PropertyOwner a();

    PublishSubject b();

    int c();

    com.bytedance.android.livesdk.interactivity.service.messagelist.b getConfig();

    List<c> getMessageList();
}
