package kb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements hb8.a {
    public kb8.a a;
    public p b;
    public List<u> c;
    public boolean d;
    public final Lazy e;

    public static final class a implements n {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        @Override // kb8.n
        public final void a(int r54) {
            u r1 = (u) CollectionsKt.getOrNull(this.a.c, r54);
            String r2 = null;
            if (r1 == null) goto L5;
            Object r3 = r1.a;
        L7:
            if ((r3 instanceof TextCard) == false) goto L9;
            TextCard r4 = (TextCard) r3;
        L10:
            if (r4 == null) goto L17;
            Long r6 = r4.getId();
            if (r6 == null) goto L14;
            String r7 = r6.toString();
        L15:
            oi8.n.a r5 = new oi8.n.a(r7, r4.getUrl(), r1.d, r4.getSearchId());
        L23:
            m r8 = this.a;
            p r9 = r8.b;
            if (r9 == null) goto L42;
            if (r5 == null) goto L27;
            String r10 = r5.a;
        L28:
            if (r10 != null) goto L30;
            r10 = "";
        L30:
            if (r5 == null) goto L32;
            String r11 = r5.c;
        L33:
            kb8.a r12 = r8.a;
            if (r12 == null) goto L37;
            Message r13 = r12.a;
            if (r13 == null) goto L37;
        L38:
            if (r5 == null) goto L40;
            r2 = r5.d;
        L40:
            r9.a(r10, r11, r54, r13, r2);
            return;
        L37:
            r13 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
            goto L38
        L32:
            r11 = null;
            goto L33
        L27:
            r10 = null;
            goto L28
        L42:
            return;
        L14:
            r7 = null;
            goto L15
        L17:
            if ((r3 instanceof VideoCard) == false) goto L19;
            VideoCard r14 = (VideoCard) r3;
        L20:
            if (r14 == null) goto L22;
            r5 = new oi8.n.a(r14.getId(), r14.getMainSiteUrl(), r1.d, r14.getSearchId());
            goto L23
        L22:
            r5 = null;
            goto L23
        L19:
            r14 = null;
            goto L20
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L7
        }

        @Override // kb8.n
        public final void b(int r55) {
            u r1 = (u) CollectionsKt.getOrNull(this.a.c, r55);
            String r2 = null;
            if (r1 == null) goto L5;
            Object r3 = r1.a;
        L7:
            if ((r3 instanceof TextCard) == false) goto L9;
            TextCard r4 = (TextCard) r3;
        L10:
            if (r4 == null) goto L17;
            Long r5 = r4.getId();
            if (r5 == null) goto L14;
            String r6 = r5.toString();
        L15:
            oi8.n.a r7 = new oi8.n.a(r6, r4.getUrl(), r1.d, r4.getSearchId());
        L23:
            m r8 = this.a;
            p r9 = r8.b;
            if (r9 == null) goto L45;
            if (r7 == null) goto L27;
            String r10 = r7.a;
        L28:
            if (r10 != null) goto L30;
            r10 = "";
        L30:
            if (r7 == null) goto L32;
            String r11 = r7.c;
        L33:
            if (r7 == null) goto L35;
            String r12 = r7.b;
        L36:
            kb8.a r13 = r8.a;
            if (r13 == null) goto L40;
            Message r14 = r13.a;
            if (r14 == null) goto L40;
        L41:
            if (r7 == null) goto L43;
            r2 = r7.d;
        L43:
            r9.b(r10, r11, r12, r55, r14, r2);
            return;
        L40:
            r14 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
            goto L41
        L35:
            r12 = null;
            goto L36
        L32:
            r11 = null;
            goto L33
        L27:
            r10 = null;
            goto L28
        L45:
            return;
        L14:
            r6 = null;
            goto L15
        L17:
            if ((r3 instanceof VideoCard) == false) goto L19;
            VideoCard r15 = (VideoCard) r3;
        L20:
            if (r15 == null) goto L22;
            r7 = new oi8.n.a(r15.getId(), r15.getMainSiteUrl(), r1.d, r15.getSearchId());
            goto L23
        L22:
            r7 = null;
            goto L23
        L19:
            r15 = null;
            goto L20
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L7
        }
    }

    public m() {
        this.c = CollectionsKt.emptyList();
        this.d = true;
        this.e = LazyKt.lazy(new j(this));
    }

    @Override // hb8.a
    public final void f() {
        this.c = CollectionsKt.emptyList();
    }
}
