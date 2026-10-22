package com.bytedance.android.livesdk.gift.platform.business.dialog.v2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.livesdk.gift.model.p3;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.y0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.kmp.util.e;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.j;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public zy0.d a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001:\u0002 \u000fB\u0007¢\u0006\u0004\b1\u00102R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$b;", "groupShowUsers", "Ljava/util/List;", "getGroupShowUsers", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "descriptionStyle", "J", "getDescriptionStyle", "()J", "b", "(J)V", BuildConfig.FLAVOR, "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "g", "Lpy/k;", "backgroundImage", "Lpy/k;", "getBackgroundImage", "()Lpy/k;", "a", "(Lpy/k;)V", "groupShowScene", "getGroupShowScene", "c", BuildConfig.FLAVOR, "isLiveShow", "Z", "()Z", "e", "(Z)V", "toastText", "getToastText", "i", "serverTime", "getServerTime", "f", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("background_image")
        private k backgroundImage;

        @SerializedName("description_style")
        private long descriptionStyle;

        @SerializedName("group_show_scene")
        private long groupShowScene;

        @SerializedName("group_show_users")
        private List<C0021b> groupShowUsers;

        @SerializedName("is_live_show")
        private boolean isLiveShow;

        @SerializedName("server_time")
        private long serverTime;

        @SerializedName("sub_title")
        private String subTitle;

        @SerializedName("title")
        private String title;

        @SerializedName("toast_text")
        private String toastText;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", BuildConfig.FLAVOR, "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "a", "(Lpy/k;)V", BuildConfig.FLAVOR, "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "followerCount", "J", "getFollowerCount", "()J", "b", "(J)V", "id", "getId", "c", "secUid", "getSecUid", "e", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0020a {

            @SerializedName("avatar_thumb")
            private k avatarThumb;

            @SerializedName("follower_count")
            private long followerCount;

            @SerializedName("id")
            private String id;

            @SerializedName("nickname")
            private String nickName;

            @SerializedName("sec_uid")
            private String secUid;

            public C0020a() {
                this.id = BuildConfig.FLAVOR;
            }

            public final void a(k r1) {
                this.avatarThumb = r1;
            }

            public final void b(long r1) {
                this.followerCount = r1;
            }

            public final void c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.id = r2;
            }

            public final void d(String r1) {
                this.nickName = r1;
            }

            public final void e(String r1) {
                this.secUid = r1;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.a$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\"\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&¨\u0006C"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$b;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "simpleUser", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "getSimpleUser", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;", "l", "(Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/a$b$a;)V", BuildConfig.FLAVOR, "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "sendButtonText", "getSendButtonText", "h", BuildConfig.FLAVOR, "fanTicketCount", "J", "getFanTicketCount", "()J", "g", "(J)V", "curRoundFanTicketCount", "getCurRoundFanTicketCount", "e", "showEndTime", "getShowEndTime", "i", BuildConfig.FLAVOR, "anchorType", "I", "getAnchorType", "()I", "a", "(I)V", "Lpy/k;", "avatarBorder", "Lpy/k;", "getAvatarBorder", "()Lpy/k;", "b", "(Lpy/k;)V", "bestShowerBgImage", "getBestShowerBgImage", "c", "Lcom/bytedance/android/livesdk/gift/model/p3;", "showStatusLabel", "Lcom/bytedance/android/livesdk/gift/model/p3;", "getShowStatusLabel", "()Lcom/bytedance/android/livesdk/gift/model/p3;", "k", "(Lcom/bytedance/android/livesdk/gift/model/p3;)V", BuildConfig.FLAVOR, "isBestUser", "Z", "()Z", "d", "(Z)V", "showStatus", "getShowStatus", "j", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0021b {

            @SerializedName("identity_label")
            private int anchorType;

            @SerializedName("live_avatar_frame_image")
            private k avatarBorder;

            @SerializedName("bg_image")
            private k bestShowerBgImage;

            @SerializedName("group_show_cur_round_fan_ticket_count")
            private long curRoundFanTicketCount;

            @SerializedName("description")
            private String description;

            @SerializedName("group_show_fan_ticket_count")
            private long fanTicketCount;

            @SerializedName("is_best_shower")
            private boolean isBestUser;

            @SerializedName("send_button_text")
            private String sendButtonText;

            @SerializedName("show_end_time")
            private long showEndTime;

            @SerializedName("show_status")
            private int showStatus;

            @SerializedName("show_status_label")
            private p3 showStatusLabel;

            @SerializedName("group_show_user")
            private C0020a simpleUser;

            public C0021b() {
            }

            public final void a(int r1) {
                this.anchorType = r1;
            }

            public final void b(k r1) {
                this.avatarBorder = r1;
            }

            public final void c(k r1) {
                this.bestShowerBgImage = r1;
            }

            public final void d(boolean r1) {
                this.isBestUser = r1;
            }

            public final void e(long r1) {
                this.curRoundFanTicketCount = r1;
            }

            public final void f(String r1) {
                this.description = r1;
            }

            public final void g(long r1) {
                this.fanTicketCount = r1;
            }

            public final void h(String r1) {
                this.sendButtonText = r1;
            }

            public final void i(long r1) {
                this.showEndTime = r1;
            }

            public final void j(int r1) {
                this.showStatus = r1;
            }

            public final void k(p3 r1) {
                this.showStatusLabel = r1;
            }

            public final void l(C0020a r1) {
                this.simpleUser = r1;
            }
        }

        public b() {
            this.toastText = BuildConfig.FLAVOR;
        }

        public final void a(k r1) {
            this.backgroundImage = r1;
        }

        public final void b(long r1) {
            this.descriptionStyle = r1;
        }

        public final void c(long r1) {
            this.groupShowScene = r1;
        }

        public final void d(List<C0021b> r1) {
            this.groupShowUsers = r1;
        }

        public final void e(boolean r1) {
            this.isLiveShow = r1;
        }

        public final void f(long r1) {
            this.serverTime = r1;
        }

        public final void g(String r1) {
            this.subTitle = r1;
        }

        public final void h(String r1) {
            this.title = r1;
        }

        public final void i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.toastText = r2;
        }
    }

    static {
    }

    public final Context getContext() {
        return null;
    }

    public static b a(w0 r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        b r0 = new b();
        r0.b(r7.getDescriptionStyle());
        r0.h(r7.getTitle());
        r0.g(r7.getSubTitle());
        r0.a(r7.getBackgroundImage());
        r0.c(r7.getGroupShowScene());
        r0.e(r7.isLiveShow());
        r0.i(r7.getToastText());
        List<y0> r8 = r7.getGroupShowUsers();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        y0 r2 = (y0) r9.next();
        b.C0021b r3 = new b.C0021b();
        r3.f(r2.getDescription());
        r3.h(r2.getSendButtonText());
        r3.g(r2.getFanTicketCount());
        r3.e(r2.getCurRoundFanTicketCount());
        r3.i(r2.getShowEndTime());
        r3.a(r2.getAnchorType());
        r3.b(r2.getAvatarBorder());
        r3.c(r2.getBestShowerBgImage());
        r3.k(r2.getShowStatusLabel());
        r3.d(r2.isBestUser());
        r3.j(r2.getShowStatus());
        b.C0020a r4 = new b.C0020a();
        r4.c(r2.getGroupShowUser().getIdString());
        r4.a(r2.getGroupShowUser().getAvatarThumbKt());
        r4.d(r2.getGroupShowUser().getNickName());
        j r5 = r2.getGroupShowUser().getFollowInfo();
        if (r5 == null) goto L11;
        long r6 = r5.getFollowerCount();
    L12:
        r4.b(r6);
        r4.e(o.a(r2.getGroupShowUser()));
        Unit r10 = Unit.INSTANCE;
        r3.l(r4);
        r1.add(r3);
        goto L7
    L11:
        r6 = 0;
        goto L12
    L13:
        r0.d(r1);
        r0.f(e.b());
        return r0;
    }
}
