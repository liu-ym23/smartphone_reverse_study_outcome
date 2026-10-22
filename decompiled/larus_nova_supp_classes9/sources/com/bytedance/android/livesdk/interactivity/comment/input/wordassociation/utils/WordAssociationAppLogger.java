package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.utils;

import c32.d;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.interactivity.api.emoji.a;
import com.bytedance.android.livesdk.interactivity.common.utils.b;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class WordAssociationAppLogger extends b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public WordAssociationAppLogger() {
    }

    public static Pair c(String r13) {
        Intrinsics.checkNotNullParameter(r13, "str");
        List r14 = GsonHelper.fromJsonArray(r13, a.class);
        ArrayList r0 = new ArrayList();
        ArrayList r9 = new ArrayList();
        Iterator r1 = r14.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r2 = ((a) r1.next()).c();
        if (r2 != null) goto L8;
        r2 = BuildConfig.FLAVOR;
    L8:
        r0.add(r2);
        goto L4
    L9:
        a r15 = (a) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L18;
        List<String> r16 = r15.e();
        if (r16 == null) goto L18;
        Iterator<T> r17 = r16.iterator();
    L15:
        if (r17.hasNext() == false) goto L18;
        r9.add((String) r17.next());
    L18:
        return new Pair(CollectionsKt.joinToString$default(r0, "|", null, null, 0, null, null, 62, null), CollectionsKt.joinToString$default(r9, "|", null, null, 0, null, null, 62, null));
    }

    @JvmStatic
    public static final void d(final d r9, final String r10, final String r11, final boolean r13, final String r14, final long r15) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "entranceType");
        Intrinsics.checkNotNullParameter(r11, "content");
        b.a("livesdk_comment_association_entrance_click", new WordAssociationAppLogger$sendAssociationEntranceClickEvent$1(r9, r10, r13, r14, r15, r11));
    }

    @JvmStatic
    public static final void e(final List<? extends d> r11, final List<String> r13, final List<String> r14, final boolean r15, final String r16, final long r17, final long r18) {
        Intrinsics.checkNotNullParameter(r11, "associationResultList");
        Intrinsics.checkNotNullParameter(r13, "entranceTypes");
        Intrinsics.checkNotNullParameter(r14, "contents");
        b.a("livesdk_comment_association_entrance_hide", new WordAssociationAppLogger$sendAssociationEntranceDismissEvent$1(r13, r15, r16, r17, r14, r18, r11));
    }

    @JvmStatic
    public static final void f(final List<? extends d> r11, final List<String> r13, final List<String> r14, final long r15, final boolean r16, final String r17, final long r18) {
        Intrinsics.checkNotNullParameter(r11, "associationResultList");
        Intrinsics.checkNotNullParameter(r13, "entranceTypes");
        Intrinsics.checkNotNullParameter(r14, "contents");
        xs2.b r0 = xs2.b.a();
        if (r0 == null) goto L5;
        r0.post(new u22.b(r13, false));
    L5:
        b.a("livesdk_comment_association_entrance_show", new WordAssociationAppLogger$sendAssociationEntranceShowEvent$1(r11, r13, r16, r17, r18, r14, r15));
    }

    public static void g(final d r10, final a r11, final String r13, final String r14, final boolean r15, final String r16, final long r17) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "fusionEmoji");
        Intrinsics.checkNotNullParameter(r13, "entranceType");
        Intrinsics.checkNotNullParameter(r14, "content");
        b.a("livesdk_comment_association_entrance_click", new WordAssociationAppLogger$sendFusionEmojiEntranceClickEvent$1(r13, r15, r16, r17, r14, r11, r10));
    }
}
