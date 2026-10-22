package rib;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public List<SearchBaseInfo> a;
    public final List<SearchBaseInfo> b;
    public final long c;
    public final boolean d;

    public static final class a {
        public List<SearchBaseInfo> a;
        public List<SearchBaseInfo> b;
        public long c;
        public boolean d;

        public final b a() {
            com.ss.android.lark.forwardv3.utils.b.d();
            List r0 = CollectionsKt.plus(this.a, this.b);
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            Object r3 = r2.next();
            String r4 = ((SearchBaseInfo) r3).getId();
            Object r5 = r1.get(r4);
            if (r5 != null) goto L8;
            r5 = new ArrayList();
            r1.put(r4, r5);
        L8:
            ((List) r5).add(r3);
            goto L4
        L9:
            ArrayList r6 = new ArrayList();
            Iterator r7 = r1.entrySet().iterator();
        L11:
            if (r7.hasNext() == false) goto L28;
            Iterator r8 = ((List) ((Map.Entry) r7.next()).getValue()).iterator();
            if (r8.hasNext() == true) goto L15;
            Object r9 = null;
        L25:
            SearchBaseInfo r10 = (SearchBaseInfo) r9;
            if (r10 == null) goto L11;
            r6.add(r10);
            goto L11
        L15:
            Object r11 = r8.next();
            if (r8.hasNext() == true) goto L18;
        L17:
            r9 = r11;
            goto L25
        L18:
            long r12 = ((SearchBaseInfo) r11).getTimeStamp();
        L19:
            Object r13 = r8.next();
            long r14 = ((SearchBaseInfo) r13).getTimeStamp();
            if (r12 >= r14) goto L23;
            r11 = r13;
            r12 = r14;
        L23:
            if (r8.hasNext() == true) goto L19;
        L28:
            List r15 = CollectionsKt.sortedWith(r6, new rib.a());
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r17 = r15.iterator();
        L30:
            if (r17.hasNext() == false) goto L32;
            SearchBaseInfo r18 = (SearchBaseInfo) r17.next();
            r16.add(TuplesKt.to(r18.getId(), Long.valueOf(r18.getTimeStamp())));
            goto L30
        L32:
            List r19 = CollectionsKt.take(r16, 30);
            Log.i("ChatPickerRecommendData", "merge_forward_list size: " + r19.size() + ", " + r19);
            Iterator r20 = r15.iterator();
        L34:
            if (r20.hasNext() == false) goto L37;
            SearchBaseInfo r21 = (SearchBaseInfo) r20.next();
            WeakReference<Message> r22 = ForwardDataUtils.a;
            Intrinsics.checkNotNullParameter(r21, "<this>");
            r21.setHeaderId(0);
            r21.setHeaderLabel(ForwardDataUtils.d);
            goto L34
        L37:
            return new b(CollectionsKt.toMutableList(CollectionsKt.take(r15, 60)), this.b, this.c, this.d);
        }

        public a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: rib.b$b, reason: collision with other inner class name */
    public static final class C0320b {
    }

    static {
    }

    public final boolean a() {
        if (CollectionUtils.isEmpty(this.b) == true) goto L5;
    L9:
        return false;
    L5:
        if (CollectionUtils.isEmpty(this.a) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.a.size() >= 3) goto L9;
        goto L8
    }

    public b(List<SearchBaseInfo> r2, List<SearchBaseInfo> r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "recentVisitData");
        Intrinsics.checkNotNullParameter(r3, "recentForwardData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
