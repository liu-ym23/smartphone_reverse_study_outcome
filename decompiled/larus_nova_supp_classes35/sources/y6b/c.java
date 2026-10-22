package y6b;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.AIInfo;
import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.entity.message.MessageSenderAppInfo;
import com.ss.android.lark.chat.entity.message.MessageSourceDisplayPolicy;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.export.vo.GroupType;
import com.ss.android.lark.ding.entity.DingStatus;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v5b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T extends v5b.a<?>> extends y6b.a<T> implements y28.b<c<?>> {
    public final String A;
    public final int B;
    public final MessageEditInfo C;
    public final MessageDLPState D;
    public final MessageSecurityESCReviewExtra E;
    public final MessageSenderAppInfo E2;
    public ValidateIMFileResult F;
    public final AIInfo F2;
    public final MessageFoldDetail G;
    public final long G1;
    public final SmartReplyEntryInfo G2;
    public final boolean H;
    public final CharSequence H0;
    public final Message.SyncToChatMessageType H1;
    public final f5b.a H2;
    public final boolean I;
    public final boolean I2;
    public final Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> J;
    public final AIRecommendQuestions J2;
    public final MessageStreamStatus K;
    public boolean K2;
    public final long L;
    public final b L0;
    public final long L1;
    public boolean L2;
    public final List<String> M;
    public final boolean M1;
    public boolean M2;
    public final boolean N;
    public boolean N2;
    public final Message.SourceType O;
    public final Map<Class<?>, Object> O2;
    public final String P;
    public final int P0;
    public final boolean P1;
    public boolean P2;
    public final boolean Q;
    public String Q1;
    public boolean Q2;
    public final String R;
    public int R2;
    public final String S;
    public final Message.ThreadMessageType S1;
    public g S2;
    public final boolean T;
    public int T1;
    public boolean T2;
    public final boolean U;
    public boolean U2;
    public final DingStatus V;
    public final int V0;
    public final boolean V1;
    public boolean V2;
    public final boolean W;
    public int W2;
    public final int X;
    public int X2;
    public final boolean Y;
    public boolean Y2;
    public final long Z;
    public boolean Z2;
    public com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus a3;
    public final y6b.b b1;
    public final ChatDisplayModeSetting b2;
    public final String c;
    public final String d;
    public final String e;
    public final Message.Type f;
    public final String g;
    public final String g1;
    public List<f> g2;
    public final String h;
    public final boolean h1;
    public HashMap<Integer, String> h2;
    public boolean i;
    public final boolean j;
    public final boolean k;
    public final int k0;
    public final boolean k1;
    public int l;
    public final long m;
    public final int n;
    public final T o;
    public final int p;
    public final boolean p0;
    public final y6b.b p1;
    public final Map<String, MessageLink> p2;
    public final boolean q;
    public final Message.Status r;
    public final SendStatus s;
    public final y6b.b t;
    public final List<ReactionInfo> u;
    public final Pin v;
    public final c<T> v1;
    public final UniversalPinExtra v2;
    public final boolean w;
    public final Message.RecallerIdentity x;
    public final PartialReplyInfo x1;
    public final String x2;
    public final boolean y;
    public final c<T> y1;
    public final MessageSourceDisplayPolicy y2;
    public final boolean z;

    public static final class a<T extends v5b.a<?>> extends y6b.a.AbstractC0322a<T, c<T>, a<T>> {
        public MessageFoldDetail A0;
        public ChatDisplayModeSetting B0;
        public List<f> C0;
        public HashMap<Integer, String> D0;
        public UniversalPinExtra E0;
        public SmartReplyEntryInfo F0;
        public f5b.a G0;
        public AIRecommendQuestions H0;
        public boolean I0;
        public String R;
        public String S;
        public boolean T;
        public boolean U;
        public boolean V;
        public DingStatus W;
        public boolean X;
        public long Y;
        public int Z;
        public boolean a0;
        public CharSequence b0;
        public b c0;
        public int d0;
        public int e0;
        public int f0;
        public boolean g0;
        public y6b.b h0;
        public c<T> i0;
        public PartialReplyInfo j0;
        public c<T> k0;
        public long l0;
        public Message.SyncToChatMessageType m0;
        public long n0;
        public y6b.b o0;
        public String p0;
        public boolean q0;
        public boolean r0;
        public Message.RecallerIdentity s0;
        public boolean t0;
        public boolean u0;
        public String v0;
        public Message.ThreadMessageType w0;
        public int x0;
        public boolean y0;
        public MessageEditInfo z0;

        public final c<T> g() {
            String r2 = this.a;
            String r3 = this.b;
            Message.Type r5 = getType();
            String r4 = this.d;
            String r6 = this.e;
            String r7 = this.f;
            boolean r8 = this.g;
            boolean r9 = this.h;
            boolean r10 = this.i;
            int r11 = this.j;
            long r12 = this.k;
            int r14 = this.l;
            int r1 = this.m;
            boolean r15 = this.n;
            Message.Status r13 = this.o;
            if (r13 != null) goto L5;
            r13 = Message.Status.NORMAL;
        L5:
            Message.Status r18 = r13;
            SendStatus r16 = this.p;
            y6b.b r17 = this.q;
            List<? extends ReactionInfo> r19 = this.r;
            C r20 = this.s;
            Intrinsics.checkNotNull(r20);
            Pin r21 = this.t;
            boolean r22 = this.u;
            boolean r23 = this.v;
            MessageDLPState r24 = this.y;
            MessageSecurityESCReviewExtra r25 = this.z;
            ValidateIMFileResult r26 = this.C;
            boolean r27 = this.A;
            boolean r28 = this.B;
            Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r29 = this.D;
            String r30 = this.R;
            String r31 = this.S;
            boolean r32 = this.T;
            boolean r33 = this.U;
            boolean r34 = this.V;
            DingStatus r35 = this.W;
            int r36 = this.f0;
            boolean r37 = this.X;
            long r110 = this.Y;
            int r38 = this.Z;
            boolean r39 = this.a0;
            CharSequence r40 = this.b0;
            b r41 = this.c0;
            int r42 = this.d0;
            boolean r43 = this.q0;
            String r44 = this.p0;
            y6b.b r45 = this.o0;
            int r46 = this.e0;
            boolean r47 = this.g0;
            y6b.b r48 = this.h0;
            c<T> r49 = this.i0;
            PartialReplyInfo r50 = this.j0;
            c<T> r51 = this.k0;
            long r111 = this.l0;
            Message.SyncToChatMessageType r52 = this.m0;
            long r112 = this.n0;
            boolean r53 = this.r0;
            boolean r54 = this.t0;
            boolean r55 = this.u0;
            Message.RecallerIdentity r56 = this.s0;
            String r57 = this.v0;
            Message.ThreadMessageType r58 = this.w0;
            int r59 = this.x0;
            boolean r60 = this.y0;
            String r61 = this.w;
            int r62 = this.x;
            MessageEditInfo r63 = this.z0;
            MessageFoldDetail r64 = this.A0;
            ChatDisplayModeSetting r65 = this.B0;
            List<f> r66 = this.C0;
            HashMap<Integer, String> r67 = this.D0;
            MessageStreamStatus r68 = this.E;
            long r113 = this.F;
            Map<String, MessageLink> r69 = this.N;
            UniversalPinExtra r70 = this.E0;
            c<T> r114 = new c(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r20, r1, r15, r18, r16, r17, r19, r21, r53, r56, r22, r23, r61, r62, r63, r24, r25, r26, r64, r27, r28, r29, r68, r113, this.G, this.H, this.I, r30, r31, r32, r33, r34, r35, r47, r36, r37, r110, r38, r39, r40, r41, r42, r46, r45, r44, r43, r54, r48, r49, r50, r51, r111, r52, r112, r55, r57, r58, r59, r60, r65, r66, r67, r69, r70, this.J, this.K, this.L, this.M, this.F0, this.G0, this.H0, this.I0, this.Q);
            r114.a = this.O;
            r114.b = this.P;
            return r114;
        }

        public a() {
            this.R = BuildConfig.FLAVOR;
            this.S = BuildConfig.FLAVOR;
            this.b0 = BuildConfig.FLAVOR;
            this.B0 = ChatDisplayModeSetting.UNKNOWN;
        }
    }

    public interface b {
    }

    public c() {
        throw null;
    }

    @Override // y6b.a
    public final boolean U() {
        if (this.k0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean Z() {
        if (this.W2 < 0) goto L5;
    L7:
        return false;
    L5:
        if (isPreMessage() == true) goto L7;
        return true;
    }

    @Override // v5b.c
    public final boolean c() {
        if (this.b2 != ChatDisplayModeSetting.THREAD) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // v5b.c
    public final boolean d() {
        if (this.U2 == false) goto L7;
        return true;
    L7:
        return c();
    }

    @Override // v5b.c
    public final boolean j() {
        if (this.r != Message.Status.DELETED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // v5b.c
    public final boolean na() {
        MessageEditInfo r0 = this.C;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEdited();
    }

    public final boolean X() {
        if (isPreMessage() == false) goto L5;
        return false;
    L5:
        if (j() == false) goto L7;
        return false;
    L7:
        if (getType() != Message.Type.SYSTEM) goto L9;
        return false;
    L9:
        if (this.U == false) goto L11;
        return false;
    L11:
        if (this.G == null) goto L13;
        return false;
    L13:
        if (MessageDLPState.BLOCK != this.D) goto L15;
        return false;
    L15:
        if (this.a == null) goto L17;
        boolean r0 = true;
    L18:
        if (r0 == true) goto L27;
        return true;
    L27:
        return false;
    L17:
        r0 = false;
        goto L18
    }

    public final boolean Y() {
        if (isPreMessage() == false) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(this.Q1, this.c) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L9;
        goto L8
    }

    @Override // y6b.a
    public final int A() {
        return this.n;
    }

    @Override // y6b.a
    public final List<ReactionInfo> B() {
        return this.u;
    }

    @Override // y6b.a
    public final int C() {
        return this.X;
    }

    @Override // y6b.a
    public final y6b.b D() {
        return this.p1;
    }

    @Override // y6b.a
    public final Message.RecallerIdentity E() {
        return this.x;
    }

    @Override // y6b.a
    public final String F() {
        return this.R;
    }

    @Override // y6b.a
    public final SendStatus G() {
        return this.s;
    }

    @Override // y6b.a
    public final boolean H() {
        return this.I;
    }

    @Override // y6b.a
    public final String I() {
        return this.P;
    }

    @Override // y6b.a
    public final Message.SourceType J() {
        return this.O;
    }

    @Override // y6b.a
    public final Message.Status K() {
        return this.r;
    }

    @Override // y6b.a
    public final MessageStreamStatus L() {
        return this.K;
    }

    @Override // y6b.a
    public final String M() {
        return this.Q1;
    }

    @Override // y6b.a
    public final ValidateIMFileResult N() {
        return this.F;
    }

    @Override // y6b.a
    public final boolean O() {
        return this.z;
    }

    @Override // y6b.a
    public final boolean P() {
        return this.j;
    }

    @Override // y6b.a
    public final boolean R() {
        return this.W;
    }

    @Override // y6b.a
    public final boolean S() {
        return this.w;
    }

    @Override // v5b.c
    public final y6b.b a() {
        return this.t;
    }

    @Override // v5b.c
    public final T b() {
        return this.o;
    }

    @Override // v5b.c
    public final boolean e() {
        return this.N;
    }

    @Override // v5b.c
    public final String g() {
        return this.g;
    }

    @Override // v5b.c
    public final String getChatId() {
        return this.e;
    }

    @Override // v5b.c
    public final long getCreateTime() {
        return this.m;
    }

    @Override // v5b.c
    @GroupType
    public final int getGroupType() {
        return this.R2;
    }

    @Override // v5b.c
    public final String getId() {
        return this.c;
    }

    @Override // y6b.a, v5b.c, v5b.d
    public Message.Type getType() {
        return this.f;
    }

    @Override // v5b.c
    public final String getcId() {
        return this.d;
    }

    @Override // v5b.c
    public final boolean h() {
        return this.i;
    }

    @Override // v5b.c
    public final String i() {
        return this.S;
    }

    @Override // v5b.c
    public final HashMap<Integer, String> k() {
        return this.h2;
    }

    @Override // v5b.c
    public final boolean m() {
        return this.y;
    }

    @Override // y6b.a
    public final long o() {
        return this.L;
    }

    @Override // y6b.a
    public final int q() {
        return this.p;
    }

    @Override // y6b.a
    public final int r() {
        return this.B;
    }

    @Override // y6b.a
    public final MessageDLPState t() {
        return this.D;
    }

    @Override // y6b.a
    public final MessageEditInfo u() {
        return this.C;
    }

    @Override // y6b.a
    public final MessageSecurityESCReviewExtra v() {
        return this.E;
    }

    @Override // y6b.a
    public final Map<Class<?>, Object> w() {
        return this.O2;
    }

    @Override // y6b.a
    public final MessageFoldDetail x() {
        return this.G;
    }

    @Override // y6b.a
    public final String y() {
        return this.A;
    }

    @Override // y6b.a
    public final Map<String, MessageLink> z() {
        return this.p2;
    }

    @Override // y6b.a
    public final boolean V(long r8) {
        if (this.Y == true) goto L14;
        long r2 = this.Z;
        if (1 <= r2) goto L7;
    L9:
        boolean r9 = false;
    L10:
        if (r9 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r2 > r8) goto L9;
        r9 = true;
        goto L10
    L14:
        return true;
    }

    public final boolean W(c<?> r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (Q(r8) == true) goto L7;
    L83:
        boolean r1 = false;
    L84:
        if (r1 == true) goto L87;
        return false;
    L87:
        if (this.T == r8.T) goto L89;
        return false;
    L89:
        if (this.U == r8.U) goto L91;
        return false;
    L91:
        if (y28.a.c(this.V, r8.V) == true) goto L93;
        return false;
    L93:
        if (this.W == r8.W) goto L95;
        return false;
    L95:
        if (this.X == r8.X) goto L97;
        return false;
    L97:
        if (this.Y == r8.Y) goto L99;
        return false;
    L99:
        if (this.Z == r8.Z) goto L101;
        return false;
    L101:
        if (this.k0 == r8.k0) goto L103;
        return false;
    L103:
        if (y28.a.a(this.H0, r8.H0) == true) goto L105;
        return false;
    L105:
        if (this.P0 == r8.P0) goto L107;
        return false;
    L107:
        if (this.V0 == r8.V0) goto L109;
        return false;
    L109:
        if (this.P2 == r8.P2) goto L111;
        return false;
    L111:
        if (this.Q2 == r8.Q2) goto L113;
        return false;
    L113:
        if (this.R2 == r8.R2) goto L115;
        return false;
    L115:
        if (this.h1 == r8.h1) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.g1, r8.g1) == true) goto L119;
        return false;
    L119:
        if (y28.a.c(this.b1, r8.b1) == true) goto L121;
        return false;
    L121:
        if (y28.a.c(this.S2, r8.S2) == true) goto L123;
        return false;
    L123:
        if (y28.a.c(this.p1, r8.p1) == true) goto L125;
        return false;
    L125:
        if (y28.a.c(this.v1, r8.v1) == true) goto L127;
        return false;
    L127:
        if (Intrinsics.areEqual(this.x1, r8.x1) == true) goto L129;
        return false;
    L129:
        if (y28.a.c(this.y1, r8.y1) == true) goto L131;
        return false;
    L131:
        if (this.G1 == r8.G1) goto L133;
        return false;
    L133:
        if (this.H1 == r8.H1) goto L135;
        return false;
    L135:
        if (this.L1 == r8.L1) goto L137;
        return false;
    L137:
        if (this.V2 != r8.V2) goto L255;
        boolean r2 = this.M1;
        boolean r3 = r8.M1;
        if (r2 == r3) goto L141;
        return false;
    L141:
        if (this.W2 == r8.W2) goto L143;
        return false;
    L143:
        if (this.x != r8.x) goto L258;
        if (r2 == r3) goto L146;
        return false;
    L146:
        if (this.k1 == r8.k1) goto L148;
        return false;
    L148:
        if (this.P1 == r8.P1) goto L150;
        return false;
    L150:
        if (this.s == r8.s) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.Q1, r8.Q1) == true) goto L154;
        return false;
    L154:
        if (this.S1 == r8.S1) goto L156;
        return false;
    L156:
        if (this.T1 == r8.T1) goto L158;
        return false;
    L158:
        if (this.X2 == r8.X2) goto L160;
        return false;
    L160:
        if (this.V1 == r8.V1) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.A, r8.A) == true) goto L164;
        return false;
    L164:
        if (this.B == r8.B) goto L166;
        return false;
    L166:
        if (Intrinsics.areEqual(this.C, r8.C) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.G, r8.G) == true) goto L170;
        return false;
    L170:
        if (this.p0 == r8.p0) goto L172;
        return false;
    L172:
        if (this.Q != r8.Q) goto L273;
        MessageSecurityESCReviewExtra r4 = this.E;
        String r5 = null;
        if (r4 == null) goto L176;
        String r6 = r4.getTipText();
    L177:
        MessageSecurityESCReviewExtra r7 = r8.E;
        if (r7 == null) goto L180;
        String r9 = r7.getTipText();
    L182:
        if (Intrinsics.areEqual(r6, r9) == false) goto L274;
        MessageSecurityESCReviewExtra r10 = this.E;
        if (r10 == null) goto L186;
        String r11 = r10.getSubmitText();
    L187:
        MessageSecurityESCReviewExtra r12 = r8.E;
        if (r12 == null) goto L190;
        String r13 = r12.getSubmitText();
    L192:
        if (Intrinsics.areEqual(r11, r13) == false) goto L275;
        MessageSecurityESCReviewExtra r14 = this.E;
        if (r14 == null) goto L196;
        String r15 = r14.getFeedBackUrl();
    L197:
        MessageSecurityESCReviewExtra r16 = r8.E;
        if (r16 == null) goto L201;
        r5 = r16.getFeedBackUrl();
    L201:
        if (Intrinsics.areEqual(r15, r5) == true) goto L203;
        return false;
    L203:
        if (y28.a.b(this.g2, r8.g2) == true) goto L205;
        return false;
    L205:
        if (this.K == r8.K) goto L207;
        return false;
    L207:
        if (this.a3 != r8.a3) goto L279;
        UniversalPinExtra r17 = this.v2;
        if (r17 != null) goto L211;
    L213:
        boolean r18 = false;
    L214:
        if (r18 == true) goto L216;
        return false;
    L216:
        if (f5b.c.a(this.G2, r8.G2) == true) goto L218;
        return false;
    L218:
        if (y28.a.c(this.H2, r8.H2) == true) goto L220;
        return false;
    L220:
        if (this.I2 == r8.I2) goto L222;
        return false;
    L222:
        if (this.K2 == r8.K2) goto L224;
        return false;
    L224:
        if (this.L2 == r8.L2) goto L226;
        return false;
    L226:
        if (this.M2 != r8.M2) goto L286;
        return true;
    L286:
        return false;
    L211:
        if (r17.isContentSame(r8.v2) != true) goto L213;
        r18 = true;
        goto L214
    L279:
        return false;
    L196:
        r15 = null;
        goto L197
    L275:
        return false;
    L190:
        r13 = null;
        goto L192
    L186:
        r11 = null;
        goto L187
    L274:
        return false;
    L180:
        r9 = null;
        goto L182
    L176:
        r6 = null;
        goto L177
    L273:
        return false;
    L258:
        return false;
    L255:
        return false;
    L7:
        if (getType() != r8.getType()) goto L83;
        if (y28.a.c(this.t, r8.t) == false) goto L83;
        if (y28.a.a(this.h, r8.h) == false) goto L83;
        if (j() != r8.j()) goto L83;
        if (this.j != r8.j) goto L83;
        if (this.k != r8.k) goto L83;
        if (this.l != r8.l) goto L83;
        if (this.r != r8.r) goto L83;
        if (this.s != r8.s) goto L83;
        if (y28.a.c(this.v, r8.v) == false) goto L83;
        if (y28.a.b(this.u, r8.u) == true) goto L45;
        List<ReactionInfo> r19 = this.u;
        if (r19 != null) goto L31;
    L34:
        boolean r20 = true;
    L35:
        if (r20 == false) goto L83;
        List<ReactionInfo> r21 = r8.u;
        if (r21 != null) goto L39;
    L42:
        boolean r22 = true;
    L43:
        if (r22 == false) goto L83;
    L39:
        if (r21.isEmpty() == true) goto L42;
        r22 = false;
        goto L43
    L31:
        if (r19.isEmpty() == true) goto L34;
        r20 = false;
    L45:
        if (this.o.d(r8.o) == false) goto L83;
        if (this.y != r8.y) goto L83;
        if (this.D != r8.D) goto L83;
        if (Intrinsics.areEqual(this.F, r8.F) == false) goto L83;
        if (this.H != r8.H) goto L83;
        if (this.I != r8.I) goto L83;
        if (this.z != r8.z) goto L83;
        if (T(this.J, r8.J) == false) goto L83;
        if (this.K != r8.K) goto L83;
        if (this.L != r8.L) goto L83;
        if (this.N != r8.N) goto L83;
        if (this.O != r8.O) goto L83;
        if (Intrinsics.areEqual(this.P, r8.P) == false) goto L83;
        if (Intrinsics.areEqual(this.x2, r8.x2) == false) goto L83;
        if (this.y2 != r8.y2) goto L83;
        if (Intrinsics.areEqual(this.E2, r8.E2) == false) goto L83;
        if (Intrinsics.areEqual(this.F2, r8.F2) == false) goto L83;
        if (Intrinsics.areEqual(this.p2, r8.p2) == false) goto L83;
        if (Intrinsics.areEqual(s(), r8.s()) == false) goto L83;
        r1 = true;
        goto L84
    }

    public final /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return W((c) r1);
    }

    public final boolean isItemSame(y28.b r1) {
        return Q((c) r1);
    }

    @Override // v5b.c
    public final void f(int r2, String r3) {
        if (this.h2 != null) goto L5;
        this.h2 = new HashMap();
    L5:
        HashMap<Integer, String> r0 = this.h2;
        if (r0 == null) goto L9;
        r0.put(Integer.valueOf(r2), r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r5, String r6, String r7, Message.Type r8, String r9, String r10, boolean r11, boolean r12, boolean r13, int r14, long r15, int r17, v5b.a r18, int r19, boolean r20, Message.Status r21, SendStatus r22, y6b.b r23, List r24, Pin r25, boolean r26, Message.RecallerIdentity r27, boolean r28, boolean r29, String r30, int r31, MessageEditInfo r32, MessageDLPState r33, MessageSecurityESCReviewExtra r34, ValidateIMFileResult r35, MessageFoldDetail r36, boolean r37, boolean r38, Map r39, MessageStreamStatus r40, long r41, boolean r43, Message.SourceType r44, String r45, String r46, String r47, boolean r48, boolean r49, boolean r50, DingStatus r51, boolean r52, int r53, boolean r54, long r55, int r57, boolean r58, CharSequence r59, b r60, int r61, int r62, y6b.b r63, String r64, boolean r65, boolean r66, y6b.b r67, c r68, PartialReplyInfo r69, c r70, long r71, Message.SyncToChatMessageType r73, long r74, boolean r76, String r77, Message.ThreadMessageType r78, int r79, boolean r80, ChatDisplayModeSetting r81, List r82, HashMap r83, Map r84, UniversalPinExtra r85, String r86, MessageSourceDisplayPolicy r87, MessageSenderAppInfo r88, AIInfo r89, SmartReplyEntryInfo r90, f5b.a r91, AIRecommendQuestions r92, boolean r93, Map r94) {
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r30;
        this.B = r31;
        this.C = r32;
        this.D = r33;
        this.E = r34;
        this.F = r35;
        this.G = r36;
        this.H = r37;
        this.I = r38;
        this.J = r39;
        this.K = r40;
        this.L = r41;
        this.M = null;
        this.N = r43;
        this.O = r44;
        this.P = r45;
        this.Q = false;
        this.R = r46;
        this.S = r47;
        this.T = r48;
        this.U = r49;
        this.V = r51;
        this.W = r52;
        this.X = r53;
        this.Y = r54;
        this.Z = r55;
        this.k0 = r57;
        this.p0 = r58;
        this.H0 = r59;
        this.L0 = r60;
        this.P0 = r61;
        this.V0 = r62;
        this.b1 = r63;
        this.g1 = r64;
        this.h1 = r65;
        this.k1 = r66;
        this.p1 = r67;
        this.v1 = r68;
        this.x1 = r69;
        this.y1 = r70;
        this.G1 = r71;
        this.H1 = r73;
        this.L1 = r74;
        this.M1 = false;
        this.P1 = r76;
        this.Q1 = r77;
        this.S1 = r78;
        this.T1 = r79;
        this.V1 = r80;
        this.b2 = r81;
        this.g2 = r82;
        this.h2 = r83;
        this.p2 = r84;
        this.v2 = r85;
        this.x2 = r86;
        this.y2 = r87;
        this.E2 = r88;
        this.F2 = r89;
        this.G2 = r90;
        this.H2 = r91;
        this.I2 = false;
        this.J2 = r92;
        this.K2 = false;
        this.L2 = false;
        this.M2 = false;
        this.N2 = r93;
        this.O2 = r94;
    }
}
