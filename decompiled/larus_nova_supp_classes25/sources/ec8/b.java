package ec8;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.markdown.richtext.n;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper;
import com.larus.business.markdown.impl.widget.f;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements dc8.b<bd8.b> {
    public final Map<BaseCompositeTextCell<? extends xc8.b>, C0075b> a;
    public final Map<Class<?>, tg8.a> b;
    public a c;
    public a d;

    public static final class a {
        public final Integer a;
        public final List<uvc.b> b;

        public a() {
            this(null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<uvc.b> r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "CacheInfo(streamIndex=" + this.a + ", nodeList=" + this.b + ')';
        }

        public a(Integer r1, List<? extends uvc.b> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: ec8.b$b, reason: collision with other inner class name */
    public static final class C0075b {
        public final BaseCompositeTextCell<? extends xc8.b> a;
        public final xc8.b b;
        public final List<bd8.b> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0075b) == true) goto L8;
            return false;
        L8:
            C0075b r6 = (C0075b) r5;
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
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "CellContextInfo(cell=" + this.a + ", state=" + this.b + ", components=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0075b(BaseCompositeTextCell<? extends xc8.b> r2, xc8.b r3, List<? extends bd8.b> r4) {
            Intrinsics.checkNotNullParameter(r2, "cell");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "components");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
    }

    public static final class d {
        public final uvc.b a;
        public final boolean b;
        public final boolean c;

        public d() {
            this(false, 7);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            uvc.b r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            int r3 = 1231;
            if (this.b == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r2 + r4) * 31;
            if (this.c == true) goto L15;
            r3 = 1237;
        L15:
            return r5 + r3;
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "NodeInfo(node=" + this.a + ", needUpdate=" + this.b + ", isLastNode=" + this.c + ')';
        }

        public /* synthetic */ d(boolean r2, int r3) {
            if ((r3 & 2) == 0) goto L5;
            r2 = true;
        L5:
            this(null, r2, false);
        }

        public d(uvc.b r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // dc8.b
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public b() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new a(null, null);
        this.d = new a(null, null);
    }

    public final <T extends tg8.a> T d(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Object r3 = ((LinkedHashMap) this.b).get(r2);
        if ((r3 instanceof tg8.a) == true) goto L7;
        return null;
    L7:
        return (T) r3;
    }

    public final void h(String r3) {
        if (AppHost.a.isDebug() == false) goto L6;
        FLogger.a.d("TextComponentContextImpl", r3);
        return;
    }

    @Override // dc8.b
    public final void s(BaseCompositeTextCell<? extends xc8.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        this.a.remove(r2);
        if (this.a.isEmpty() == false) goto L6;
        ((LinkedHashMap) this.a).clear();
        ((LinkedHashMap) this.b).clear();
        this.c = new a(null, null);
        this.d = new a(null, null);
        return;
    }

    @Override // dc8.b
    public final boolean t(BaseCompositeTextCell<? extends xc8.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        return this.a.containsKey(r2);
    }

    public final <T extends tg8.a> void b(T r2, Class<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        if (r3.isInterface() == false) goto L10;
        if (this.b.containsKey(r3) == false) goto L7;
        this.b.remove(r3);
    L7:
        this.b.put(r3, r2);
        return;
    L10:
        throw new IllegalArgumentException("ability clazz must be an interface".toString());
    }

    public final d e(int r5, uvc.b r6, boolean r7) {
        List<uvc.b> r0 = this.d.b;
        if (r0 == null) goto L5;
        uvc.b r1 = (uvc.b) CollectionsKt.getOrNull(r0, r5);
    L6:
        List<uvc.b> r2 = this.d.b;
        if (r2 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        if (r1 != null) goto L14;
        h("getCacheInfoResult need update.[0]");
        return new d(r1, true, r8);
    L14:
        if (r7 == false) goto L16;
    L18:
        h("getCacheInfoResult should update.[2]");
        f.g(r1);
        return new d(r1, true, r8);
    L16:
        if (f.b(r6, r1) == false) goto L18;
        h("getCacheInfoResult no need update.[1]");
        return new d(r6, false, r8);
    L9:
        if (r5 != (r2.size() - 1)) goto L11;
        r8 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // dc8.b
    public final void r(BaseCompositeTextCell<? extends xc8.b> r3, xc8.b r4, List<? extends bd8.b> r5) {
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "components");
        this.a.put(r3, new C0075b(r3, r4, r5));
    }

    public final List f(Context r15, final Message r16, boolean r17, MarkwonStruct r18) {
        gw8.c.a.getClass();
        gw8.c r1 = gw8.c.a.b();
        if (r1 != null) goto L5;
        return null;
    L5:
        long r10 = System.currentTimeMillis();
        String r2 = (String) l0.a("", new ec8.a(r16));
        if (com.larus.bmhome.chat.bean.d.f0(r16) == false) goto L11;
        if (StringsKt.endsWith$default(r2, "\n\n", false, 2, null) == false) goto L11;
        r2 = r2 + 160;
    L11:
        if (z2.a.enableMessageMention() == false) goto L14;
        Regex r3 = n.a;
        r2 = n.k(r2);
    L14:
        long r12 = System.currentTimeMillis();
        uvc.b r4 = gw8.c.b.c(r1, r15, r2, !r17, null, r18, null, null, MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY);
        if (r4 != null) goto L17;
        return null;
    L17:
        long r5 = System.currentTimeMillis();
        List r0 = MarkdownMultiWidgetHelper.a(r4);
        h("getNodeList getContent:" + (r12 - r10) + " createNode:" + (r5 - r12) + " cutIntoNodeList:" + (System.currentTimeMillis() - r5));
        return r0;
    }

    public final uvc.b g(Context r4, Message r5, com.larus.bmhome.chat.list.cell.text.cells.base.c r6, boolean r7, MarkwonStruct r8) {
        Object r0 = r6.f.get("pipe_line_node");
        if ((r0 instanceof uvc.b) == false) goto L5;
        uvc.b r1 = (uvc.b) r0;
    L6:
        if (r1 == null) goto L9;
        f.g(r1);
        h("use pipe_line_node.");
        return r1;
    L9:
        h("create node to return.");
        int r9 = RangesKt.coerceAtLeast(r6.b, 0);
        List r10 = f(r4, r5, r7, r8);
        if (r10 != null) goto L12;
        return null;
    L12:
        return (uvc.b) CollectionsKt.getOrNull(r10, r9);
    L5:
        r1 = null;
        goto L6
    }
}
