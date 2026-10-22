package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;
import com.ss.ugc.effectplatform.task.FetchCategoryEffectCacheTask;
import com.ss.ugc.effectplatform.task.FetchCategoryEffectTask;
import com.ss.ugc.effectplatform.task.FetchCategoryInfoCacheTask;
import com.ss.ugc.effectplatform.task.FetchCategoryPagingEffectCacheTask;
import com.ss.ugc.effectplatform.task.FetchCategoryPagingEffectTask;
import com.ss.ugc.effectplatform.task.FetchDownloadedEffectListTask;
import com.ss.ugc.effectplatform.task.FetchPanelEffectListCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelEffectListTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoPagingCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoTask;
import com.ss.ugc.effectplatform.task.QueryInfoStickerListCacheTask;
import com.ss.ugc.effectplatform.task.d0;
import com.ss.ugc.effectplatform.task.d1;
import com.ss.ugc.effectplatform.task.e1;
import com.ss.ugc.effectplatform.task.o;
import com.ss.ugc.effectplatform.task.o0;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.q;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public final EffectConfig a;

    public e(EffectConfig r1) {
        this.a = r1;
    }

    public final void e(String r3, IEffectPlatformBaseListener r4) {
        String r0 = q.a();
        if (r4 == null) goto L5;
        this.a.N.b(r0, r4);
    L5:
        EffectConfig r1 = this.a;
        e0.c r5 = new FetchDownloadedEffectListTask(r1, r3, r0);
        q1 r6 = r1.D;
        if (r6 == null) goto L9;
        r6.a(r5);
        return;
    }

    public final void i(String r4, Map<String, String> r5, IEffectPlatformBaseListener<QueryCustomizedEffectsData> r6) {
        String r0 = q.a();
        this.a.N.b(r0, new a(this, r6));
        q1 r7 = this.a.D;
        if (r7 == null) goto L6;
        r7.a(new d1(this.a, r4, r0, r5));
        return;
    }

    public final void f(String r3, boolean r4, Map r5, IEffectPlatformBaseListener r6) {
        String r0 = q.a();
        this.a.N.b(r0, r6);
        if (r4 == false) goto L5;
        FetchPanelEffectListCacheTask r7 = new FetchPanelEffectListCacheTask(this.a, r3, r0);
    L6:
        q1 r8 = this.a.D;
        if (r8 == null) goto L10;
        r8.a(r7);
        return;
    L10:
        return;
    L5:
        r7 = new FetchPanelEffectListTask(this.a, r3, r5, r0);
        goto L6
    }

    public final void a(String r8, String r9, int r10, Map r11, IEffectPlatformBaseListener r12) {
        String r2 = q.a();
        if (r12 == null) goto L5;
        this.a.N.b(r2, r12);
    L5:
        o r13 = new o(this.a, r2, r8, r9, r10, r11);
        q1 r14 = this.a.D;
        if (r14 == null) goto L9;
        r14.a(r13);
        return;
    }

    public final void c(String r7, List r8, boolean r9, Map r10, IEffectPlatformBaseListener r11) {
        String r3 = q.a();
        if (r11 == null) goto L5;
        this.a.N.b(r3, r11);
    L5:
        if (r9 == false) goto L7;
        FetchCategoryInfoCacheTask r12 = new FetchCategoryInfoCacheTask(this.a, r7, r3, r8);
    L8:
        q1 r13 = this.a.D;
        if (r13 == null) goto L12;
        r13.a(r12);
        return;
    L12:
        return;
    L7:
        r12 = new d0(this.a, r7, r3, r8, r10);
        goto L8
    }

    public final void j(String r8, Integer r9, Integer r10, Map r11, boolean r12, IEffectPlatformBaseListener r13) {
        String r6 = q.a();
        if (r13 == null) goto L5;
        this.a.N.b(r6, r13);
    L5:
        if (r12 == false) goto L7;
        QueryInfoStickerListCacheTask r14 = new QueryInfoStickerListCacheTask(this.a, r8, r9, r10, r6);
    L8:
        q1 r15 = this.a.D;
        if (r15 == null) goto L12;
        r15.a(r14);
        return;
    L12:
        return;
    L7:
        r14 = new e1(this.a, r8, r9, r10, r11, r6);
        goto L8
    }

    public final void b(String r13, String r14, int r15, int r16, int r17, String r18, boolean r19, Map r20, IEffectPlatformBaseListener r21) {
        String r4 = q.a();
        if (r21 == null) goto L5;
        this.a.N.b(r4, r21);
    L5:
        if (r19 == false) goto L7;
        FetchCategoryEffectCacheTask r9 = new FetchCategoryEffectCacheTask(this.a, r13, r4, r14, r15, r16, r17);
    L8:
        q1 r1 = this.a.D;
        if (r1 == null) goto L12;
        r1.a(r9);
        return;
    L12:
        return;
    L7:
        r9 = new FetchCategoryEffectTask(this.a, r13, r4, r14, r15, r16, r17, r18, r20);
        goto L8
    }

    public final void d(String r13, String r14, int r15, int r16, int r17, String r18, boolean r19, Map r20, IEffectPlatformBaseListener r21) {
        String r4 = q.a();
        if (r21 == null) goto L5;
        this.a.N.b(r4, r21);
    L5:
        if (r19 == false) goto L7;
        FetchCategoryPagingEffectCacheTask r9 = new FetchCategoryPagingEffectCacheTask(this.a, r13, r4, r14, r15, r16, r17);
    L8:
        q1 r1 = this.a.D;
        if (r1 == null) goto L12;
        r1.a(r9);
        return;
    L12:
        return;
    L7:
        r9 = new FetchCategoryPagingEffectTask(this.a, r13, r4, r14, r15, r16, r17, r18, r20);
        goto L8
    }

    public final void g(String r13, boolean r14, String r15, int r16, int r17, boolean r18, boolean r19, Map r20, IEffectPlatformBaseListener r21) {
        String r4 = q.a();
        if (r21 == null) goto L5;
        this.a.N.b(r4, r21);
    L5:
        if (r18 == false) goto L7;
        FetchPanelInfoCacheTask r9 = new FetchPanelInfoCacheTask(this.a, r13, r4, r14, r15, r16, r17);
    L8:
        q1 r1 = this.a.D;
        if (r1 == null) goto L12;
        r1.a(r9);
        return;
    L12:
        return;
    L7:
        r9 = new FetchPanelInfoTask(this.a, r13, r4, r14, r15, r16, r17, r19, r20);
        goto L8
    }

    public final void h(String r13, String r14, int r15, int r16, int r17, String r18, boolean r19, Map r20, IEffectPlatformBaseListener r21) {
        String r4 = q.a();
        if (r21 == null) goto L5;
        this.a.N.b(r4, r21);
    L5:
        if (r19 == false) goto L7;
        FetchPanelInfoPagingCacheTask r10 = new FetchPanelInfoPagingCacheTask(this.a, r13, r4, r14, r15, r16, r17, r18);
    L8:
        q1 r1 = this.a.D;
        if (r1 == null) goto L12;
        r1.a(r10);
        return;
    L12:
        return;
    L7:
        r10 = new o0(this.a, r13, r4, r14, r15, r16, r17, r18, r20);
        goto L8
    }
}
