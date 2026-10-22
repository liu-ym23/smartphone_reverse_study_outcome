package com.bytedance.android.livesdk.interactivity.comment.mention;

import am2.x;
import android.text.Editable;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostUser;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MentionSectionController a;

    public i(MentionSectionController r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d r14 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d) ((BaseResponse) ((Response) r13)).data;
        if (r14 != null) goto L6;
        this.a.k.a(false);
        this.a.b.P(false);
        return;
    L6:
        if (Intrinsics.areEqual(r14.a, BuildConfig.FLAVOR) == false) goto L10;
        MentionSectionController r1 = this.a;
        if (r1.o != null) goto L10;
        r1.o = r14.a();
    L10:
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c> r15 = r14.a();
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c> r2 = r15;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        this.a.k.a(false);
        MentionSectionController r16 = this.a;
        r16.l = false;
        r16.b.P(false);
        return;
    L19:
        this.a.l = true;
        ArrayList r4 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L21:
        if (r17.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c r5 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c) r17.next();
        IBaseUser r6 = r5.a();
        if (r6 != null) goto L25;
        l r7 = null;
    L26:
        if (r7 == null) goto L21;
        r4.add(r7);
        goto L21
    L25:
        r7 = new l(r6, r5.b());
        goto L26
    L28:
        IMiddlewareHostUser r18 = TTMiddlewareLiveSDK.hostMiddlewareService().user();
        Fragment r8 = this.a.b.T();
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r10 = r4.iterator();
    L30:
        if (r10.hasNext() == false) goto L32;
        r9.add(o.a(((l) r10.next()).a));
        goto L30
    L32:
        Disposable r19 = r18.fetchMentionActiveStatusListBySecUids(r8, r9);
        if (r19 == null) goto L35;
        RxUtilKt.c(r19, this.a.r);
    L35:
        MentionSectionController r110 = this.a;
        r110.i = r4;
        EditText r11 = r110.b.a;
        if (r11 == null) goto L59;
        Editable r20 = r11.getEditableText();
        if (r20 == null) goto L59;
        MentionSpan[] r21 = (MentionSpan[]) r20.getSpans(0, r11.length(), MentionSpan.class);
        if (r21 == null) goto L59;
        ArrayList r23 = new ArrayList();
        int r24 = r21.length;
        int r25 = 0;
    L44:
        if (r25 >= r24) goto L49;
        String r26 = r21[r25].b;
        if (r26 == null) goto L48;
        r23.add(r26);
    L48:
        r25 = r25 + 1;
        goto L44
    L49:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r4.iterator();
    L51:
        if (r28.hasNext() == false) goto L55;
        Object r29 = r28.next();
        if (r23.contains(((l) r29).a.getIdString()) == false) goto L51;
        r27.add(r29);
        goto L51
    L55:
        Iterator r30 = r27.iterator();
    L57:
        if (r30.hasNext() == false) goto L59;
        ((l) r30.next()).b = true;
    L59:
        MentionListAdapter r31 = r110.q;
        r31.a = r4;
        r31.notifyDataSetChanged();
        r110.e.b(false);
        UtilityKotlinExtentionsKt.t(r110.e);
        UtilityKotlinExtentionsKt.w(r110.h);
        ArrayList r33 = new ArrayList();
        Iterator r111 = r4.iterator();
    L61:
        if (r111.hasNext() == false) goto L65;
        String r34 = ((l) r111.next()).a.getIdString();
        if (r34 == null) goto L61;
        r33.add(r34);
        goto L61
    L65:
        String r112 = CollectionsKt.joinToString$default(r33, ",", null, null, 0, null, null, 62, null);
        j0.l().sendLog("livesdk_comment_expansion_mention_list_show", MapsKt.mapOf(TuplesKt.to("user_id", r112)), new Object[]{IRoom.class, x.class});
        if (this.a.s.getVisibility() != 8) goto L93;
        MentionSectionController r113 = this.a;
        if (r113.k.a == false) goto L94;
        r113.b.P(true);
        return;
    L94:
        return;
    L93:
        return;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
        goto L17
    }
}
