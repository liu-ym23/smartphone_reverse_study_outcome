package com.larus.bmhome.music.protocol;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi;", "", "updateBigMusicMessage", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi$UpdateBigMusicRequest;", "(Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi$UpdateBigMusicRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "UpdateBigMusicRequest", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UpdateBigMusicMessageApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi$UpdateBigMusicRequest;", "", "messageId", "", "title", "coverUri", "taskId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getTitle", "getCoverUri", "getTaskId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("cover_uri")
        private final String coverUri;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private final String messageId;

        @SerializedName("task_id")
        private final String taskId;

        @SerializedName("title")
        private final String title;

        public b() {
            this(null, null, null, null, 15);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.coverUri, r6.coverUri) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.messageId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.title;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.coverUri;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.taskId;
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
            return "UpdateBigMusicRequest(messageId=" + this.messageId + ", title=" + this.title + ", coverUri=" + this.coverUri + ", taskId=" + this.taskId + ')';
        }

        public b(String r3, String r4, String r5, String r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = "";
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = null;
        L14:
            this.messageId = r3;
            this.title = r4;
            this.coverUri = r5;
            this.taskId = r6;
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/media/bigmusic/update_message")
    Object updateBigMusicMessage(@Body b r1, Continuation<? super BizResponse<Object>> r2);
}
