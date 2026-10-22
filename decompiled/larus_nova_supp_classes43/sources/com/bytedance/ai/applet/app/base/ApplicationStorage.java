package com.bytedance.ai.applet.app.base;

import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface ApplicationStorage {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/applet/app/base/ApplicationStorage$StorageError;", "", MessageIndication.MESSAGE_TYPE_MSG, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "EXCEED_ITEM_MAX_SIZE", "EXCEED_TOTAL_MAX_SIZE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StorageError extends Enum<StorageError> {
        public static final StorageError EXCEED_ITEM_MAX_SIZE = null;
        public static final StorageError EXCEED_TOTAL_MAX_SIZE = null;
        public static final /* synthetic */ StorageError[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String msg;

        public static EnumEntries<StorageError> getEntries() {
            return b;
        }

        static {
            StorageError r0 = new StorageError("EXCEED_ITEM_MAX_SIZE", 0, "exceed storage item max size");
            EXCEED_ITEM_MAX_SIZE = r0;
            StorageError r1 = new StorageError("EXCEED_TOTAL_MAX_SIZE", 1, "total storage size exceeded");
            EXCEED_TOTAL_MAX_SIZE = r1;
            StorageError[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static StorageError[] values() {
            return (StorageError[]) a.clone();
        }

        public final String getMsg() {
            return this.msg;
        }

        public static StorageError valueOf(String r1) {
            return (StorageError) r27.a.a(StorageError.class, r1);
        }

        public StorageError(String r1, int r10, String r11) {
            super(r1, r10);
            this.msg = r11;
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ai.applet.app.base.ApplicationStorage$a$a, reason: collision with other inner class name */
        public static final class C0015a extends a {
            public final StorageError a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0015a) == true) goto L9;
                return false;
            L9:
                if (this.a == ((C0015a) r10).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Failure(error=" + this.a + ')';
            }

            public C0015a(StorageError r10) {
                Intrinsics.checkNotNullParameter(r10, IHostStyleUIDepend.TOAST_TYPE_ERROR);
                this.a = r10;
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b {
        public final List<String> a;
        public final int b;
        public final int c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "StorageInfo(keys=" + this.a + ", currentSize=" + this.b + ", limitSize=" + this.c + ')';
        }

        public b(List r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "keys");
            this.a = r10;
            this.b = r11;
            this.c = CalDavException.MAX_EXCERPT_SIZE;
        }
    }

    a b(String r1, String r10);

    void clear();

    String get(String r1);

    b getInfo();

    void remove(String r1);
}
