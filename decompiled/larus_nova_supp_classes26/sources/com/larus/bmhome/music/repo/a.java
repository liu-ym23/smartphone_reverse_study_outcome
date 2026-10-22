package com.larus.bmhome.music.repo;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.bmhome.music.repo.a$a, reason: collision with other inner class name */
    public static final class C0024a {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/music/repo/MediaRepo$MusicCheck;", "", "list", "", "Lcom/larus/bmhome/music/repo/MediaRepo$MusicCheck$Item;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "firstItem", "getFirstItem", "()Lcom/larus/bmhome/music/repo/MediaRepo$MusicCheck$Item;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Item", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("status_list")
        private final List<C0026b> list;

        /* JADX INFO: renamed from: com.larus.bmhome.music.repo.a$b$a, reason: collision with other inner class name */
        public static final class C0025a {
        }

        /* JADX INFO: renamed from: com.larus.bmhome.music.repo.a$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/music/repo/MediaRepo$MusicCheck$Item;", "", MusicAppletPage.KEY_SOURCE, "", "id", "", "status", "risk", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getStatus", "getRisk", "isStatusEnable", "", "()Z", "isRiskPass", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/music/repo/MediaRepo$MusicCheck$Item;", "equals", "other", "hashCode", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0026b {

            @SerializedName("id")
            private final String id;

            @SerializedName("risk_result")
            private final Integer risk;

            @SerializedName("source_from")
            private final Integer source;

            @SerializedName("status")
            private final Integer status;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0026b) == true) goto L8;
                return false;
            L8:
                C0026b r6 = (C0026b) r5;
                if (Intrinsics.areEqual(this.source, r6.source) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.status, r6.status) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.risk, r6.risk) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                Integer r0 = this.source;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                String r4 = this.id;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.status;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.risk;
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
                return "Item(source=" + this.source + ", id=" + this.id + ", status=" + this.status + ", risk=" + this.risk + ')';
            }

            public final boolean b() {
                Integer r0 = this.risk;
                if (r0 != null) goto L6;
            L8:
                return false;
            L6:
                if (r0.intValue() != 0) goto L8;
                return true;
            }

            public final boolean c() {
                Integer r0 = this.status;
                if (r0 != null) goto L6;
            L8:
                return false;
            L6:
                if (r0.intValue() != 1) goto L8;
                return true;
            }

            public C0026b() {
                this.source = null;
                this.id = null;
                this.status = null;
                this.risk = null;
            }

            public final Integer a() {
                return this.risk;
            }
        }

        static {
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.list, ((b) r4).list) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<C0026b> r0 = this.list;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "MusicCheck(list=" + this.list + ')';
        }

        public final C0026b a() {
            List<C0026b> r0 = this.list;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (C0026b) CollectionsKt.firstOrNull(r0);
        }

        public b() {
            this.list = null;
        }
    }

    static {
    }

    public a() {
    }

    public static Object a(a r3, int r4, String r5, Continuation r6) {
        r3.getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaRepo$requireCheckMusic$2(r4, r5, 1, null), r6);
    }
}
