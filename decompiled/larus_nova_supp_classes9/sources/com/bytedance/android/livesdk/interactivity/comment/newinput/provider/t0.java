package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ MarkHighlightController a;

    public t0(MarkHighlightController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        this.a.j(true);
        List<com.bytedance.android.livesdk.interactivity.comment.highlight.b> r14 = this.a.r;
        if (r14 != null) goto L5;
        return;
    L5:
        if ((!r14.isEmpty()) == true) goto L8;
        r14 = null;
    L8:
        if (r14 == null) goto L38;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r1 = (com.bytedance.android.livesdk.interactivity.comment.highlight.b) ListProtector.get(r14, this.a.m.a);
        MarkHighlightController r2 = this.a;
        String r3 = String.valueOf(r1.e());
        String r4 = this.a.i();
        String r5 = String.valueOf(r1.b());
        r2.getClass();
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_highlight_publish_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("highlights_content_id", r3), TuplesKt.to("click_area", "btn"), TuplesKt.to("anchor_id", r4), TuplesKt.to("tag_name", r5)}), new Object[]{IRoom.class, am2.x.class});
        MarkHighlightController r6 = this.a;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r15 = (com.bytedance.android.livesdk.interactivity.comment.highlight.b) ListProtector.get(r14, r6.m.a);
        r6.getClass();
        List<String> r7 = r15.i();
        if (r7 == null) goto L39;
        Activity r8 = r6.w.getActivity();
        if (r8 == null) goto L40;
        ArrayList r9 = new ArrayList();
        int r10 = r7.size();
        String[] r11 = new String[r10];
        int r16 = 0;
    L16:
        if (r16 >= r10) goto L18;
        r11[r16] = BuildConfig.FLAVOR;
        r16 = r16 + 1;
        goto L16
    L18:
        ((ArrayList) r6.t).clear();
        int r17 = r7.size();
        int r18 = 0;
    L19:
        if (r18 >= r17) goto L31;
        String r19 = (String) ListProtector.get(r7, r18);
        if (r19 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == true) goto L30;
        String r111 = r6.v + File.separator + r18 + "_" + UriProtector.parse(r19).getLastPathSegment();
        r9.add(new Pair(r19, r111));
        r11[r18] = r111;
        ListProtector.add(r6.t, r18, r111);
    L30:
        r18 = r18 + 1;
        goto L19
    L23:
        if (r19.length() == 0) goto L26;
        r110 = false;
        goto L27
    L31:
        String r0 = r6.v + File.separator + System.currentTimeMillis() + "_highlight.mp4";
        ((ArrayList) r6.t).add(r0);
        r6.o = Observable.concat(Observable.create(new s0(r9)), Observable.create(new r0(r11, r0)).subscribeOn(Schedulers.io())).observeOn(AndroidSchedulers.mainThread()).subscribe(v0.a, new w0(r6), new x0(r6, r15, r0, r8));
        return;
    L40:
        return;
    L39:
        return;
    }
}
