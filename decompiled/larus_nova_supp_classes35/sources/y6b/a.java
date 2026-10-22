package y6b;

import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.CotDisplayModel;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.entity.message.AIInfo;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.entity.message.MessageSenderAppInfo;
import com.ss.android.lark.chat.entity.message.MessageSourceDisplayPolicy;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.widget.richtext.i;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v5b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T extends v5b.a<?>> implements v5b.c<T> {
    public CotContent a;
    public CotDisplayModel b;

    /* JADX INFO: renamed from: y6b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0322a<C extends v5b.a<?>, T extends a<C>, B extends AbstractC0322a<C, ? extends T, ? extends B>> {
        public boolean A;
        public boolean B;
        public ValidateIMFileResult C;
        public Map<Integer, Message.DisabledAction.Behavior> D;
        public MessageStreamStatus E;
        public long F;
        public boolean G;
        public com.ss.android.lark.chat.entity.message.Message.SourceType H;
        public String I;
        public String J;
        public MessageSourceDisplayPolicy K;
        public MessageSenderAppInfo L;
        public AIInfo M;
        public Map<String, MessageLink> N;
        public CotContent O;
        public CotDisplayModel P;
        public Map<Class<?>, ? extends Object> Q;
        public String a;
        public String b;
        public com.ss.android.lark.chat.entity.message.Message.Type c;
        public String d;
        public String e;
        public final String f;
        public boolean g;
        public boolean h;
        public boolean i;
        public int j;
        public long k;
        public int l;
        public int m;
        public boolean n;
        public com.ss.android.lark.chat.entity.message.Message.Status o;
        public SendStatus p;
        public y6b.b q;
        public List<? extends ReactionInfo> r;
        public C s;
        public Pin t;
        public boolean u;
        public boolean v;
        public String w;
        public int x;
        public MessageDLPState y;
        public MessageSecurityESCReviewExtra z;

        public AbstractC0322a() {
            this.a = BuildConfig.FLAVOR;
            this.b = BuildConfig.FLAVOR;
            this.c = com.ss.android.lark.chat.entity.message.Message.Type.UNKNOWN;
            this.d = BuildConfig.FLAVOR;
            this.e = BuildConfig.FLAVOR;
            this.f = BuildConfig.FLAVOR;
            this.o = com.ss.android.lark.chat.entity.message.Message.Status.NORMAL;
            this.p = SendStatus.SUCCESS;
            this.w = BuildConfig.FLAVOR;
            this.D = MapsKt.emptyMap();
            this.E = MessageStreamStatus.Unknown;
        }

        public final com.ss.android.lark.chat.entity.message.Message.Type getType() {
            return this.c;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "cId");
            this.b = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            this.d = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(v5b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "contentVO");
            this.s = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fromId");
            this.e = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "id");
            this.a = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void f(com.ss.android.lark.chat.entity.message.Message.Type r2) {
            Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
            this.c = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[com.ss.android.lark.chat.entity.message.Message.Type.values().length];
            r0[com.ss.android.lark.chat.entity.message.Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[com.ss.android.lark.chat.entity.message.Message.Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[com.ss.android.lark.chat.entity.message.Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[com.ss.android.lark.chat.entity.message.Message.Type.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[com.ss.android.lark.chat.entity.message.Message.Type.MERGE_FORWARD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[com.ss.android.lark.chat.entity.message.Message.Type.TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[com.ss.android.lark.chat.entity.message.Message.Type.POST.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public a() {
    }

    public abstract int A();

    public abstract List<ReactionInfo> B();

    public abstract int C();

    public abstract y6b.b D();

    public abstract com.ss.android.lark.chat.entity.message.Message.RecallerIdentity E();

    public abstract String F();

    public abstract SendStatus G();

    public abstract boolean H();

    public abstract String I();

    public abstract com.ss.android.lark.chat.entity.message.Message.SourceType J();

    public abstract com.ss.android.lark.chat.entity.message.Message.Status K();

    public abstract MessageStreamStatus L();

    public abstract String M();

    public abstract ValidateIMFileResult N();

    public abstract boolean O();

    public abstract boolean P();

    public abstract boolean R();

    public abstract boolean S();

    public abstract boolean U();

    public abstract boolean V(long r1);

    @Override // v5b.c, v5b.d
    public abstract com.ss.android.lark.chat.entity.message.Message.Type getType();

    public abstract long o();

    public abstract int q();

    public abstract int r();

    public abstract MessageDLPState t();

    public abstract MessageEditInfo u();

    public abstract MessageSecurityESCReviewExtra v();

    public abstract Map<Class<?>, Object> w();

    public abstract MessageFoldDetail x();

    public abstract String y();

    public abstract Map<String, MessageLink> z();

    public final String s() {
        CotContent r0 = this.a;
        Integer r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        CotEvent r2 = (CotEvent) CollectionsKt.lastOrNull(r0.getEvents());
        StringBuilder r3 = new StringBuilder();
        r3.append(r0.getCotId());
        r3.append('|');
        r3.append(r0.getEvents().size());
        r3.append('|');
        r3.append(r0.getStatus());
        r3.append('|');
        r3.append(r0.getViolated());
        r3.append('|');
        r3.append(r0.getCotEventsIncomplete());
        r3.append('|');
        if (r2 == null) goto L8;
        String r4 = r2.getEventId();
    L9:
        r3.append(r4);
        r3.append('|');
        if (r2 == null) goto L12;
        Long r5 = Long.valueOf(r2.getTimestamp());
    L13:
        r3.append(r5);
        r3.append('|');
        if (r2 == null) goto L18;
        String r6 = r2.getContent();
        if (r6 == null) goto L18;
        r1 = Integer.valueOf(r6.hashCode());
    L18:
        r3.append(r1);
        return r3.toString();
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public final int hashCode() {
        String r0 = getId();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = getChatId();
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = getcId();
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    @Override // v5b.c
    public final boolean isPreMessage() {
        return Intrinsics.areEqual(getId(), getcId());
    }

    @Override // v5b.c
    public final boolean l() {
        if (CollectionUtils.isEmpty(B()) == false) goto L5;
        return false;
    L5:
        List<ReactionInfo> r0 = B();
        Intrinsics.checkNotNull(r0);
        Iterator<ReactionInfo> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        if (r1.next().getReaction().getCount() <= 0) goto L7;
        return true;
    L12:
        return false;
    }

    public final List<String> p() {
        T r0 = b();
        if ((r0 instanceof FileContentVO) == false) goto L6;
        List r1 = CollectionsKt.listOfNotNull(((FileContentVO) r0).e());
    L24:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L26:
        if (r3.hasNext() == false) goto L30;
        Object r4 = r3.next();
        if ((!StringsKt.isBlank((String) r4)) == false) goto L26;
        r2.add(r4);
        goto L26
    L30:
        return r2;
    L6:
        if ((r0 instanceof ImageContentVO) == false) goto L9;
        r1 = CollectionsKt.listOfNotNull((String) ((ImageContentVO) r0).j.getValue());
        goto L24
    L9:
        if ((r0 instanceof MediaContentVO) == false) goto L12;
        r1 = CollectionsKt.listOfNotNull((String) ((MediaContentVO) r0).b.getValue());
        goto L24
    L12:
        if ((r0 instanceof com.ss.android.lark.chat.base.view.vo.message.a) == false) goto L15;
        r1 = CollectionsKt.listOfNotNull(((com.ss.android.lark.chat.base.view.vo.message.a) r0).e());
        goto L24
    L15:
        if ((r0 instanceof BaseTextContentVO) == false) goto L23;
        BaseTextContentVO r5 = (BaseTextContentVO) r0;
        List r6 = i.k(r5.g());
        ArrayList<File> r7 = r5.f();
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        String r10 = ((File) r9.next()).key;
        if (r10 == null) goto L18;
        r8.add(r10);
        goto L18
    L22:
        r1 = CollectionsKt.plus(r6, r8);
        goto L24
    L23:
        r1 = CollectionsKt.emptyList();
        goto L24
    }

    public final boolean Q(a<?> r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (Intrinsics.areEqual(this, r2) == false) goto L6;
    L7:
        return true;
    L6:
        if (Intrinsics.areEqual(getcId(), r2.getcId()) == false) goto L8;
        goto L7
    }

    @Override // v5b.c
    public final <T> T n(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clz");
        Map<Class<?>, Object> r0 = w();
        if (r0 == null) goto L8;
        T r3 = (T) r0.get(r2);
        if (r3 == null) goto L10;
        return r3;
    L10:
        return null;
    L8:
        return null;
    }

    public final boolean T(Map<Integer, Message.DisabledAction.Behavior> r6, Map<Integer, Message.DisabledAction.Behavior> r7) {
        Intrinsics.checkNotNullParameter(r6, "action1");
        Intrinsics.checkNotNullParameter(r7, "action2");
        if (r6.size() == r7.size()) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Message.DisabledAction.Behavior>> r8 = r6.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        Map.Entry<Integer, Message.DisabledAction.Behavior> r0 = r8.next();
        int r1 = r0.getKey().intValue();
        Message.DisabledAction.Behavior r2 = r0.getValue();
        Message.DisabledAction.Behavior r3 = r7.get(Integer.valueOf(r1));
        if (r3 == null) goto L14;
        if (r2.display_mode != r3.display_mode) goto L14;
        if (Intrinsics.areEqual(r2.code, r3.code) == true) goto L7;
    L14:
        return false;
    L15:
        return true;
    }
}
