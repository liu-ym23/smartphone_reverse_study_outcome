package com.ss.android.lark.filedetail;

import android.content.Context;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.utils.ApiUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import hfb.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileDetailModule {
    public static final com.ss.android.lark.storage.a a = null;
    public static b b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/FileDetailModule$FileDetailFrom;", BuildConfig.FLAVOR, "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FileDetailFrom {
        public static final int CHAT_HISTORY = 3;
        public static final a Companion = null;
        public static final int FAVORITES = 6;
        public static final int MAIN = 1;
        public static final int ORIGINAL_MEDIA = 8;
        public static final int PIN = 5;
        public static final int SEARCH = 4;
        public static final int THREAD = 2;
        public static final int TODO = 7;
        public static final int UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/FileDetailModule$FolderManagerFrom;", BuildConfig.FLAVOR, "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FolderManagerFrom {
        public static final int CHAT = 0;
        public static final int CHAT_HISTORY = 7;
        public static final int CHAT_TAB = 10;
        public static final int CHAT_THREAD = 1;
        public static final a Companion = null;
        public static final int FAVORITES = 4;
        public static final int MERGE_FORWARD = 5;
        public static final int PIN = 6;
        public static final int SEARCH = 8;
        public static final int THREAD = 2;
        public static final int THREAD_REPLY = 3;
        public static final int THREAD_TAB = 9;
        public static final int UNKNOWN = -1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/filedetail/FileDetailModule$NetworkType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "NO_INTERNET_CONNECTION", "CELLULAR_DATA_NETWORK", "WIFI", "valueOf", "getNumber", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType CELLULAR_DATA_NETWORK = null;
        public static final a Companion = null;
        public static final NetworkType NO_INTERNET_CONNECTION = null;
        public static final NetworkType WIFI = null;
        public static final /* synthetic */ NetworkType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static NetworkType a(int r1) {
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L13;
                if (r1 == 3) goto L11;
                return null;
            L11:
                return NetworkType.WIFI;
            L13:
                return NetworkType.CELLULAR_DATA_NETWORK;
            L15:
                return NetworkType.NO_INTERNET_CONNECTION;
            }
        }

        public static EnumEntries<NetworkType> getEntries() {
            return b;
        }

        static {
            NetworkType r0 = new NetworkType("NO_INTERNET_CONNECTION", 0, 1);
            NO_INTERNET_CONNECTION = r0;
            NetworkType r1 = new NetworkType("CELLULAR_DATA_NETWORK", 1, 2);
            CELLULAR_DATA_NETWORK = r1;
            NetworkType r4 = new NetworkType("WIFI", 2, 3);
            WIFI = r4;
            NetworkType[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new a();
        }

        public static NetworkType[] values() {
            return (NetworkType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final NetworkType valueOf(int r2) {
            Companion.getClass();
            return a.a(r2);
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) r27.a.a(NetworkType.class, r1);
        }

        public NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public static b a() {
            if (FileDetailModule.b != null) goto L6;
            FileDetailModule.b = (b) ApiUtils.getApi(b.class);
        L6:
            return FileDetailModule.b;
        }
    }

    static {
        a = new com.ss.android.lark.storage.a("Common");
    }

    public static void a(Context r1, FolderManageLaunchParams r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        ifb.a.a(r1, r2);
    }
}
