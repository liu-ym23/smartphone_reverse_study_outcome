package com.obric.aikernel.res.downloader;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import ib.b0;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class GeneralDownloadTask implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DownloadTask.b f4953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f4954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a0 f4955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b0 f4956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.d f4957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f4958f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public GeneralDownloadTask(DownloadTask.b r10, PackageResourceManager.PresmConfig r11, a0 r12, b0 r13) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "downloadListener");
        Intrinsics.checkNotNullParameter(r13, "monitorDepend");
        this.f4953a = r10;
        this.f4954b = r11;
        this.f4955c = r12;
        this.f4956d = r13;
        JSONObject r14 = new JSONObject();
        JSONObject r15 = new JSONObject();
        r15.put("segment_max_kb", 2048);
        r15.put("segment_mode", 1);
        r14.put("segment_config", r15);
        com.obric.aikernel.runtime.utils.d.f5417a.d("GeneralDownloadTask", "getDownloadTask: new download info for " + r10.j());
        com.ss.android.socialbase.downloader.model.d r16 = jb.f.s(r11.getContext()).T(r10.c()).l0(r10.j()).d0(r10.f()).k0(r10.i()).c0(r10.e()).R(r10.b()).Y(r10.d()).i0(r12).S(r13).U(true).h(true);
        r16.p(r14);
        this.f4957e = r16;
        this.f4958f = LazyKt.lazy(new GeneralDownloadTask$downloader$2(this));
    }

    public static final /* synthetic */ PackageResourceManager.PresmConfig j(GeneralDownloadTask r10) {
        return r10.f4954b;
    }

    private final jb.f k() {
        return (jb.f) this.f4958f.getValue();
    }

    private final void l(String r10, Integer r11, Boolean r12) {
        e r13 = i.b(this.f4953a.f(), this.f4953a.c(), this.f4953a.i());
        com.obric.aikernel.runtime.utils.d.f5417a.d("GeneralDownloadTask", i.a(r10, this.f4953a, getId(), r11, r12, r13));
    }

    static /* synthetic */ void m(GeneralDownloadTask r10, String r11, Integer r12, Boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r10.l(r11, r12, r13);
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object a(Continuation<? super k> r10) {
        if ((r10 instanceof GeneralDownloadTask$getDownloadInfos$1) == false) goto L7;
        GeneralDownloadTask$getDownloadInfos$1 r11 = (GeneralDownloadTask$getDownloadInfos$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        String r16 = "downloading";
        boolean r17 = false;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        k r18 = (k) r11.L$3;
        r16 = (String) r11.L$2;
        k r19 = (k) r11.L$1;
        k r20 = (k) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L25:
        if (((Number) r13).intValue() != 4) goto L27;
        r17 = true;
    L27:
        r18.n(r16, Boxing.boxBoolean(r17));
        r19.n("missingDownloadInfo", Boxing.boxBoolean(true));
        return r20;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        DownloadInfo r110 = this.f4957e.y();
        if (r110 == null) goto L20;
        k r21 = new k();
        r21.p(ActivityLifecycle.NAME, r110.getName());
        r21.o("speed", Boxing.boxDouble(r110.getDownloadSpeed()));
        if (r110.getStatus() != 4) goto L19;
        r17 = true;
    L19:
        r21.n("downloading", Boxing.boxBoolean(r17));
        return r21;
    L20:
        k r111 = new k();
        r111.p(ActivityLifecycle.NAME, this.f4953a.c());
        r111.o("speed", Boxing.boxInt(0));
        r11.L$0 = r111;
        r11.L$1 = r111;
        r11.L$2 = "downloading";
        r11.L$3 = r111;
        r11.label = 1;
        Object r22 = d(r11);
        if (r22 != r14) goto L23;
        return r14;
    L23:
        r20 = r111;
        r19 = r20;
        r13 = r22;
        r18 = r19;
    L7:
        r11 = new GeneralDownloadTask$getDownloadInfos$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.j
    public boolean b() {
        return new File(this.f4953a.f(), this.f4953a.c()).exists();
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object c(Continuation<? super Unit> r10) {
        m(this, CommonConsts.APM_INNER_EVENT_COST_START, null, null, 6, null);
        this.f4957e.f(null);
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object d(Continuation<? super Integer> r10) {
        return Boxing.boxInt(k().h(getId()));
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object e(Continuation<? super Unit> r10) {
        k().b(getId(), false);
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object f(Continuation<? super Unit> r10) {
        m(this, "finish", null, Boxing.boxBoolean(b()), 2, null);
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object g(Continuation<? super Unit> r10) {
        if ((r10 instanceof GeneralDownloadTask$pause$1) == false) goto L7;
        GeneralDownloadTask$pause$1 r11 = (GeneralDownloadTask$pause$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        GeneralDownloadTask this = (GeneralDownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        int r16 = ((Number) r13).intValue();
        if (r16 != (-3)) goto L20;
    L24:
        this.k().j(this.getId());
        return Unit.INSTANCE;
    L20:
        if (r16 == (-1)) goto L24;
        if (r16 == (-4)) goto L24;
        GeneralDownloadTask r17 = this;
        m(r17, "pause", Boxing.boxInt(r16), null, 4, null);
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.label = 1;
        r13 = d(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new GeneralDownloadTask$pause$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.j
    public int getId() {
        return this.f4957e.x();
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object h(Continuation<? super Integer> r10) {
        return Boxing.boxInt(this.f4957e.y().getDownloadProcess());
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object i(Continuation<? super Unit> r10) {
        if ((r10 instanceof GeneralDownloadTask$resume$1) == false) goto L7;
        GeneralDownloadTask$resume$1 r11 = (GeneralDownloadTask$resume$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        GeneralDownloadTask this = (GeneralDownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        int r16 = ((Number) r13).intValue();
        boolean r17 = i.c(r16);
        Integer r18 = Boxing.boxInt(r16);
        if (r17 == false) goto L20;
        m(this, "restart", r18, null, 4, null);
        this.k().l(this.getId());
    L22:
        return Unit.INSTANCE;
    L20:
        m(this, "resume", r18, null, 4, null);
        this.k().o(this.getId());
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.label = 1;
        r13 = d(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new GeneralDownloadTask$resume$1(this, r10);
        goto L8
    }
}
