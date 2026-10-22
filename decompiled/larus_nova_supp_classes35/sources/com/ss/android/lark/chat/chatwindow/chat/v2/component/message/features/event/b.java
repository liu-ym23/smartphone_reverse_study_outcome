package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class b implements t6b.e.a {

    public static final class a extends b {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 1237;
        }

        public final String toString() {
            return "ChangeAudioPlayMode(isSpeakerMode=false)";
        }
    }

    public static final class a0 extends b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a0) == true) goto L8;
            return false;
        L8:
            a0 r6 = (a0) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OnUrlClicked(messageId=" + this.a + ", url=" + this.b + ')';
        }

        public a0(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "url");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b$b, reason: collision with other inner class name */
    public static final class C0064b extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0064b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0064b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ChangeTitleAreaVisibility(showOrHide=" + this.a + ')';
        }

        public C0064b() {
            this.a = true;
        }
    }

    public static final class b0 extends b {
        public final ChatChatter a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b0) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "P2PChatterUpdate(chatter=" + this.a + ')';
        }

        public b0(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatter");
            this.a = r2;
        }
    }

    public static final class c extends b {
        public final Chat a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ChatUpdate(chat=" + this.a + ')';
        }

        public c(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            this.a = r2;
        }
    }

    public static final class c0 extends b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c0) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c0) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "SelectedMessageChange(selectedCount=" + this.a + ')';
        }

        public c0(int r1) {
            this.a = r1;
        }
    }

    public static final class d extends b {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "FistFrameShown(time=" + this.a + ')';
        }

        public d(long r1) {
            this.a = r1;
        }
    }

    public static final class d0 extends b {
        public final ThreadTopic a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d0) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ThreadTopicUpdate(threadTopic=" + this.a + ')';
        }

        public d0(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
            this.a = r2;
        }
    }

    public static final class e extends b {
        public final y6b.c<?> a;
        public final MessageVisibleHintPointParams b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            MessageVisibleHintPointParams r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "MessageAppear(message=" + this.a + ", messageAppearParams=" + this.b + ')';
        }

        public e(y6b.c<?> r2, MessageVisibleHintPointParams r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e0 extends b {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e0) == true) goto L8;
            return false;
        L8:
            ((e0) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ToggleAudioText(messageId=null, shouldShow=false)";
        }
    }

    public static final class f extends b {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public static final class f0 extends b {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f0) == true) goto L8;
            return false;
        L8:
            ((f0) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "TranslateMessage(view=null, message=null)";
        }
    }

    public static final class g extends b {
        public final BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "MessageListDataStoreCreated(store=" + this.a + ')';
        }

        public g(BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
            this.a = r2;
        }
    }

    public static final class g0 extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((g0) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UrlInTextMessageDetected(messageId=" + this.a + ')';
        }

        public g0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            this.a = r2;
        }
    }

    public static final class h extends b {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }
    }

    public static final class i extends b {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }
    }

    public static final class j extends b {
        public final ListMode a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof j) == true) goto L9;
            return false;
        L9:
            if (this.a == ((j) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "MessageSelectModeChange(mode=" + this.a + ')';
        }

        public j(ListMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            this.a = r2;
        }
    }

    public static final class k extends b {
        public final MessageVisibleEntity a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof k) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((k) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            MessageVisibleEntity r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "MessageVisible(messageVisibleEntity=" + this.a + ')';
        }

        public k(MessageVisibleEntity r1) {
            this.a = r1;
        }
    }

    public static final class l extends b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof l) == true) goto L9;
            return false;
        L9:
            if (this.a == ((l) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "MultiSelect(adapterPosition=" + this.a + ')';
        }

        public l(int r1) {
            this.a = r1;
        }
    }

    public static final class m extends b {
        public final List<MessageInfo> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((m) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NewMessageAppended(messageList=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public m(List<? extends MessageInfo> r2) {
            Intrinsics.checkNotNullParameter(r2, "messageList");
            this.a = r2;
        }
    }

    public static final class n extends b {
        public final List<MessageInfo> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof n) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((n) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NewMessageArrived(messageList=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public n(List<? extends MessageInfo> r2) {
            Intrinsics.checkNotNullParameter(r2, "messageList");
            this.a = r2;
        }
    }

    public static final class o extends b {
        public final PhotoItem a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof o) == true) goto L8;
            return false;
        L8:
            o r6 = (o) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "OnClickEditImage(photoItem=" + this.a + ", isClickTranslated=" + this.b + ')';
        }

        public o(PhotoItem r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "photoItem");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class p extends b {
        public final View a;
        public final ActivityTransitionLauncher.LocationInfo b;
        public final PhotoItem c;
        public final boolean d;
        public final boolean e;
        public final int f;
        public final Message.SourceType g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof p) == true) goto L8;
            return false;
        L8:
            p r6 = (p) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ActivityTransitionLauncher.LocationInfo r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            PhotoItem r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            int r10 = 1231;
            if (this.d == false) goto L17;
            int r11 = 1231;
        L18:
            int r12 = (r9 + r11) * 31;
            if (this.e == true) goto L22;
            r10 = 1237;
        L22:
            int r13 = (((r12 + r10) * 31) + this.f) * 31;
            Message.SourceType r14 = this.g;
            if (r14 == null) goto L27;
            r1 = r14.hashCode();
        L27:
            return r13 + r1;
        L17:
            r11 = 1237;
            goto L18
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
            return "OnClickImage(itemView=" + this.a + ", locationInfo=" + this.b + ", photoItem=" + this.c + ", isMutePlay=" + this.d + ", isClickTranslated=" + this.e + ", fromType=" + this.f + ", sourceType=" + this.g + ')';
        }

        public p(View r1, ActivityTransitionLauncher.LocationInfo r2, PhotoItem r3, boolean r4, boolean r5, int r6, Message.SourceType r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class q extends b {
        public final View a;
        public final PhotoItem b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof q) == true) goto L8;
            return false;
        L8:
            q r6 = (q) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            PhotoItem r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            int r5 = (r3 + r1) * 31;
            if (this.c == false) goto L13;
            int r6 = 1231;
        L15:
            return r5 + r6;
        L13:
            r6 = 1237;
            goto L15
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnClickPreMedia(itemView=" + this.a + ", photoItem=" + this.b + ", isMutePlay=" + this.c + ')';
        }

        public q(View r1, PhotoItem r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class r extends b {
        public final String a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof r) == true) goto L8;
            return false;
        L8:
            r r6 = (r) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "OnClickTextCell(messageId=" + this.a + ", position=" + this.b + ')';
        }

        public r(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class s extends b {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof s) == true) goto L8;
            return false;
        L8:
            ((s) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "OnMessageBurned(messageId=null)";
        }
    }

    public static final class t extends b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof t) == true) goto L9;
            return false;
        L9:
            if (this.a == ((t) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "OnMessageCleared(firstMessagePosition=" + this.a + ')';
        }

        public t(int r1) {
            this.a = r1;
        }
    }

    public static final class u extends b {
        public final v5b.c<v5b.a<?>> a;
        public final View b;
        public final r5b.a c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof u) == true) goto L8;
            return false;
        L8:
            u r6 = (u) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            v5b.c<v5b.a<?>> r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            View r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            r5b.a r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnOpenCellTranslateMoreBtnClick(item=" + this.a + ", moreActionView=" + this.b + ", chatContext=" + this.c + ')';
        }

        public u(v5b.c r1, AppCompatImageView r2, r5b.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class v extends b {
        public final View a;
        public final String b;
        public final List<Object> c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof v) == true) goto L8;
            return false;
        L8:
            v r6 = (v) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<Object> r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((r6 + r1) * 31) + this.d;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnOpenImageClick(itemView=" + this.a + ", clickMessageId=" + this.b + ", openFeishuGalleryPreviewItemList=" + this.c + ", groupIndex=" + this.d + ')';
        }

        public v(View r1, String r2, List<? extends Object> r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class w extends b {
        public final y6b.a<?> a;
        public final String b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof w) == true) goto L8;
            return false;
        L8:
            w r6 = (w) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public final String toString() {
            return "OnReactionClick(item=" + this.a + ", reactionKey=" + this.b + ", source=" + this.c + ')';
        }

        public w(y6b.a<?> r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "reactionKey");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class x extends b {
        public final View a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof x) == true) goto L8;
            return false;
        L8:
            x r6 = (x) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnSwitchTranslateMenuClick(view=" + this.a + ", targetLanguage=" + this.b + ", messageId=" + this.c + ')';
        }

        public x(View r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class y extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof y) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((y) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "OnTranslateFeedbackClick(messageId=" + this.a + ')';
        }

        public y(String r1) {
            this.a = r1;
        }
    }

    public static final class z extends b {
        public final View a;
        public final y6b.a<v5b.a<?>> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof z) == true) goto L8;
            return false;
        L8:
            z r6 = (z) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OnTranslateShowOriginClick(itemView=" + this.a + ", messageVO=" + this.b + ')';
        }

        public z(View r2, y6b.a<v5b.a<?>> r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "messageVO");
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }
}
