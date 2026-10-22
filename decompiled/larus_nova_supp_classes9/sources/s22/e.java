package s22;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.ChannelInviteMessageItem;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface e {

    public static abstract class a implements c {
        public a() {
        }

        @Override // s22.e.c
        public final void Df() {
        }

        @Override // s22.e.c
        public final void Ij(long r1, long r3, Long r5, Long r6, Throwable r7) {
        }

        @Override // s22.e.c
        public final void Nc() {
        }

        @Override // s22.e.c
        public final void Oo() {
        }

        @Override // s22.e.c
        public final void Va(long r1) {
        }

        public abstract void a(s22.a r1, boolean r2);

        @Override // s22.e.c
        public final void a3(long r1, Throwable r3) {
        }

        public abstract void b(long r1);

        public void c(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "newChatChannel");
        }

        @Override // s22.e.c
        public final void vg(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
        }

        @Override // s22.e.c
        public final void Dm(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            a(r2, true);
        }

        @Override // s22.e.c
        public final void W5(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            a(r2, false);
        }

        @Override // s22.e.c
        public final void Y9(long r1) {
            b(r1);
        }

        @Override // s22.e.c
        public final void d8(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            a(r2, true);
        }

        @Override // s22.e.c
        public final void gf(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            a(r2, false);
        }

        @Override // s22.e.c
        public final void hb(List<? extends s22.a> r3) {
            Intrinsics.checkNotNullParameter(r3, "channels");
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            a((s22.a) r4.next(), false);
            goto L4
        }

        @Override // s22.e.c
        public final void kf(s22.a r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            c(r2);
        }

        @Override // s22.e.c
        public final void p6(long r1) {
            b(r1);
        }

        @Override // s22.e.c
        public final void t9(long r1) {
            b(r1);
        }

        @Override // s22.e.c
        public final void D9(s22.a r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r2) {
            Intrinsics.checkNotNullParameter(r1, "channel");
            a(r1, true);
        }

        @Override // s22.e.c
        public void Gh(s22.a r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "channel");
            Intrinsics.checkNotNullParameter(r1, "channel");
        }

        @Override // s22.e.c
        public final void Hh(long r2, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r4) {
            Intrinsics.checkNotNullParameter(r4, "response");
            b(r2);
        }

        @Override // s22.e.c
        public final void Rn(long r2, k r4) {
            Intrinsics.checkNotNullParameter(r4, "response");
            b(r2);
        }
    }

    public static final class b {
        public final ContainerType a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final List<String> h;
        public final boolean i;
        public final boolean j;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L26;
            b r4 = (b) r3;
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
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L18;
            return false;
        L18:
            if (this.g == r4.g) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
            return false;
        L22:
            if (this.i == r4.i) goto L24;
            return false;
        L24:
            if (this.j == r4.j) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            ContainerType r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = 1;
            ?? r6 = r4;
            if (r4 == false) goto L9;
            r6 = 1;
        L9:
            int r7 = (r3 + r6) * 31;
            boolean r8 = this.c;
            ?? r9 = r8;
            if (r8 == false) goto L12;
            r9 = 1;
        L12:
            int r10 = (r7 + r9) * 31;
            boolean r11 = this.d;
            ?? r13 = r11;
            if (r11 == false) goto L15;
            r13 = 1;
        L15:
            int r14 = (r10 + r13) * 31;
            boolean r15 = this.e;
            ?? r16 = r15;
            if (r15 == false) goto L18;
            r16 = 1;
        L18:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.f;
            ?? r19 = r18;
            if (r18 == false) goto L21;
            r19 = 1;
        L21:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.g;
            ?? r23 = r21;
            if (r21 == false) goto L24;
            r23 = 1;
        L24:
            int r24 = (r20 + r23) * 31;
            List<String> r25 = this.h;
            if (r25 == null) goto L27;
            r1 = r25.hashCode();
        L27:
            int r26 = (r24 + r1) * 31;
            boolean r27 = this.i;
            ?? r28 = r27;
            if (r27 == false) goto L30;
            r28 = 1;
        L30:
            int r29 = (r26 + r28) * 31;
            boolean r30 = this.j;
            if (r30 == true) goto L35;
            r5 = r30;
        L35:
            return r29 + r5;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(containerType=" + this.a + ", showLandscapeCreateEntry=" + this.b + ", showLandscapeDialogEntry=" + this.c + ", enableExtendHeight=" + this.d + ", hideGiftAndEnterAnim=" + this.e + ", enableMention=" + this.f + ", enableGreeting=" + this.g + ", greetingEmojiNames=" + this.h + ", enableLinkMic=" + this.i + ", showRecommendUser=" + this.j + ")";
        }

        public b(ContainerType r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, List<String> r9, boolean r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r2, "containerType");
            Intrinsics.checkNotNullParameter(r9, "greetingEmojiNames");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }
    }

    public interface c {
        void D9(s22.a r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r2);

        void Df();

        void Dm(s22.a r1);

        void Gh(s22.a r1, int r2);

        void Hh(long r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r3);

        void Ij(long r1, long r3, Long r5, Long r6, Throwable r7);

        void Nc();

        void Oo();

        void Rn(long r1, k r3);

        void Va(long r1);

        void W5(s22.a r1);

        void Y9(long r1);

        void a3(long r1, Throwable r3);

        void d8(s22.a r1);

        void gf(s22.a r1);

        void hb(List<? extends s22.a> r1);

        void kf(s22.a r1);

        void p6(long r1);

        void t9(long r1);

        void vg(s22.a r1);
    }

    void addListener(c r1);

    void addListenerFirst(c r1);

    void applyAnchorFansChannel(long r1, Long r3, Long r4, Long r5);

    boolean changeCurrentChannel(long r1);

    s22.a createChannel(RoomChannelInfo r1);

    void createChannel(com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r1);

    void deleteAnchorFansChannel(long r1);

    void dissolveChannel(long r1);

    List<s22.a> getAllChannel();

    com.bytedance.android.livesdk.interactivity.api.b getAnimManager();

    s22.a getChannel(long r1);

    Observable<Response<h>> getChannelUserList(long r1, int r3, int r4);

    b getConfig();

    com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> getCurrentChannel();

    s22.b getEmojiManager();

    s22.c getGreetingManager();

    /* JADX INFO: renamed from: getIMManager */
    d mo555getIMManager();

    Observable<Response<j>> getInviteId(long r1);

    s22.a getLatestChannel();

    f getToolbarManager();

    g getWidgetManager();

    void insertLocalMessage(y32.a r1);

    void joinAnchorFansChannel(long r1, long r3, Long r5, Long r6);

    void joinChannel(long r1);

    Observable<Response<Object>> kickOutChannel(long r1, String r3, String r4);

    void notifyChannelUnreadCountChanged(s22.a r1, int r2);

    void notifyInviteResult(long r1, List<? extends ChannelInviteMessageItem> r3);

    void onLoginSuccess();

    void onRoomDestroy(String r1);

    void onRoomEnter(RoomChannelData r1, String r2);

    void quitChannel(long r1);

    void recordChatChannelDialog(String r1, Object r2);

    void removeListener(c r1);

    void trySwitchToChannelPage(long r1, PublicScreenAreaPageChangeSource r3);

    void updateSetting(long r1, boolean r3, boolean r4);
}
