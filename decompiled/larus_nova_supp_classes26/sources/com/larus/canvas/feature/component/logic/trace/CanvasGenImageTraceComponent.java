package com.larus.canvas.feature.component.logic.trace;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ixigua.lib.track.TrackParams;
import com.larus.canvas.feature.component.logic.n2;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasGenerateData;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.CanvasPerfData;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.b1;
import ky8.i;
import my8.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010*\u001a\u00020\u0018H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020\u0017H\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00102\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u00103\u001a\u00020)H\u0016J\b\u00104\u001a\u00020\u0018H\u0016J\u0012\u00105\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0016J \u00107\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020#H\u0016J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0016J\u0018\u0010;\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u00103\u001a\u00020)H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R7\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR7\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\u001bR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020%0\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020%`\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b&\u0010\u001bR\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "<init>", "()V", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "actionbarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "getActionbarItem", "()Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "actionbarItem$delegate", "genImagePlannerAbility", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "getGenImagePlannerAbility", "()Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "genImagePlannerAbility$delegate", "statusReportedLocalIdMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getStatusReportedLocalIdMap", "()Ljava/util/HashMap;", "statusReportedLocalIdMap$delegate", "createPicResultReportedLocalIdMap", "getCreatePicResultReportedLocalIdMap", "createPicResultReportedLocalIdMap$delegate", "currentPosition", "", "curCanvasStartTime", "", "perfDataMap", "Lcom/larus/canvas/service/bean/CanvasPerfData;", "getPerfDataMap", "perfDataMap$delegate", "isPageChangedAfterReceiveImage", "", "onAttach", "onParentViewCreated", "getTaskPerfData", "localId", "onTaskStart", "task", "Lcom/larus/canvas/feature/component/logic/bean/GenImageTaskItem;", "onTaskUpdate", "onImageLoaded", "success", "mobCanvasAiGenerateCanvasLeavePage", "mobCanvasAIGenerateCanvasFinish", "clickFrom", "mobCanvasCreatePictureResult", "alreadyFailed", "time", "mobCanvasSendMessage", "mobCanvasSendMessageStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasGenImageTraceComponent extends ComponentFeature implements a {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public int m;
    public long n;
    public final Lazy o;
    public boolean p;

    public final q F2() {
        return (q) this.h.getValue();
    }

    public final n2 L2() {
        return (n2) this.j.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public CanvasGenImageTraceComponent() {
        this.h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new b(this));
        this.i = LazyKt.lazy(new c());
        this.j = LazyKt.lazy(new d(this));
        this.k = LazyKt.lazy(new e());
        this.l = LazyKt.lazy(new f());
        this.n = System.currentTimeMillis();
        this.o = LazyKt.lazy(new g());
    }

    public final void B2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CanvasGenImageTraceComponent$onParentViewCreated$1(this, null), 3, null);
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void OV() {
        n2 r0 = L2();
        if (r0 == null) goto L5;
        String r1 = Integer.valueOf(r0.PT()).toString();
    L6:
        n2 r2 = L2();
        int r3 = 0;
        if (r2 == null) goto L9;
        int r4 = r2.Jx();
    L10:
        Integer r5 = Integer.valueOf(r4);
        n2 r6 = L2();
        if (r6 == null) goto L13;
        r3 = r6.Sr();
    L13:
        Integer r7 = Integer.valueOf(r3);
        long r8 = System.currentTimeMillis();
        q r9 = F2();
        if (r9 == null) goto L16;
        long r10 = r9.x;
    L17:
        Long r11 = Long.valueOf(r8 - r10);
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.putOpt("total_cnt_canvas", r1);     // Catch: JSONException -> L20
        r12.putOpt("total_cnt_sub_canvas", r5);     // Catch: JSONException -> L20
        r12.putOpt("total_cnt_sub_canvas_success", r7);     // Catch: JSONException -> L20
        r12.putOpt("duration", r11);     // Catch: JSONException -> L20
    L22:
        TrackParams r13 = new TrackParams().merge(r12);
        by7.a r14 = new by7.a("ai_generate_canvas_leave_page");
        r14.a.merge(r13);
        r14.b();
        return;
    L20:
        e = move-exception;
        FLogger.a.e("aiGenerateCanvasLeavePage", "error: " + e.getLocalizedMessage());
        goto L22
    L16:
        r10 = 0;
        goto L17
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void Nz(ky8.f r8) {
        Intrinsics.checkNotNullParameter(r8, "task");
        if (r8.e.d == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CanvasGenImageTraceComponent$mobCanvasSendMessage$1(this, r8, null), 2, null);
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void Q90(ky8.f r12) {
        Intrinsics.checkNotNullParameter(r12, "task");
        CanvasPerfData r1 = (CanvasPerfData) ((HashMap) this.o.getValue()).get(r12.a);
        if (r1 != null) goto L5;
        return;
    L5:
        boolean r5 = true;
        String r6 = null;
        if (o0.d(r12.g()) == false) goto L67;
        CanvasPerfData r2 = (CanvasPerfData) ((HashMap) this.o.getValue()).get(r12.a);
        if (r2 == null) goto L10;
        Long r3 = r2.receiveImageDuration;
    L11:
        if (r3 != null) goto L67;
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "task");
        com.larus.ugc.perf.impl.g r4 = h.b(r12.a);
        if (r4 != null) goto L16;
    L50:
        n2 r7 = L2();
        if (r7 == null) goto L57;
        b1 r8 = r7.tx();
        if (r8 == null) goto L57;
        Pair r9 = (Pair) r8.getValue();
        if (r9 == null) goto L57;
        ky8.h r10 = (ky8.h) r9.getSecond();
    L59:
        if ((r10 instanceof ky8.f) == false) goto L61;
        ky8.f r11 = (ky8.f) r10;
    L62:
        if (r11 == null) goto L64;
        String r13 = r11.a;
    L65:
        this.p = !Intrinsics.areEqual(r13, r12.a);
        r1.receiveImageDuration = Long.valueOf(System.currentTimeMillis() - r1.getStartTime());
        goto L67
    L64:
        r13 = null;
        goto L65
    L61:
        r11 = null;
    L57:
        r10 = null;
        goto L59
    L16:
        if (r4.b("receive_image") != null) goto L50;
        r4.e(TuplesKt.to("duration", Long.valueOf(r4.a())));
        r4.e(TuplesKt.to("receive_image", Long.valueOf(System.currentTimeMillis())));
        r4.e(TuplesKt.to("scene", "receive_image"));
        CanvasInfo r14 = r12.a();
        String r15 = "";
        if (r14 == null) goto L22;
        Object r16 = r14.canvasSubId;
        if (r16 == null) goto L22;
    L23:
        r4.e(TuplesKt.to("sub_id", r16));
        CanvasInfo r17 = r12.a();
        if (r17 == null) goto L27;
        Object r18 = r17.canvasId;
        if (r18 == null) goto L27;
    L28:
        r4.e(TuplesKt.to("canvas_id", r18));
        String r19 = r12.j();
        if (r19 != null) goto L31;
        r19 = "";
    L31:
        r4.e(TuplesKt.to("task_id", r19));
        CanvasInfo r20 = r12.a();
        if (r20 == null) goto L35;
        Object r21 = r20.taskType;
        if (r21 == null) goto L35;
    L36:
        r4.e(TuplesKt.to("task_type", r21));
        List<CanvasBlock> r22 = r12.b;
        if (r22 == null) goto L45;
        CanvasBlock r23 = (CanvasBlock) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L45;
        CanvasImageBlock r24 = r23.content;
        if (r24 == null) goto L45;
        CanvasGenerateData r25 = r24.generateData;
        if (r25 == null) goto L45;
        String r26 = r25.modelName;
    L46:
        if (r26 == null) goto L49;
        r15 = r26;
    L49:
        r4.e(TuplesKt.to("model_name", r15));
        h.c(r4);
    L45:
        r26 = null;
    L35:
        r21 = "";
    L27:
        r18 = "";
    L22:
        r16 = "";
        goto L23
    L10:
        r3 = null;
    L67:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{10, 11}), r12.n()) == true) goto L69;
    L96:
        String r0 = r1.logId;
        if (r0 != null) goto L99;
    L102:
        if (r5 == false) goto L118;
        List<CanvasBlock> r27 = r12.b;
        if (r27 == null) goto L108;
        CanvasBlock r28 = (CanvasBlock) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L108;
        String r29 = r28.logId;
    L110:
        if (o0.d(r29) == false) goto L119;
        List<CanvasBlock> r110 = r12.b;
        if (r110 == null) goto L116;
        CanvasBlock r111 = (CanvasBlock) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L116;
        r6 = r111.logId;
    L116:
        r1.logId = r6;
        return;
    L119:
        return;
    L108:
        r29 = null;
        goto L110
    L118:
        return;
    L99:
        if (r0.length() == 0) goto L102;
        r5 = false;
        goto L102
    L69:
        if (r1.receiveReviewResultDuration != null) goto L96;
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "task");
        com.larus.ugc.perf.impl.g r30 = h.b(r12.a);
        if (r30 != null) goto L74;
    L95:
        r1.receiveReviewResultDuration = Long.valueOf(System.currentTimeMillis() - r1.getStartTime());
        goto L96
    L74:
        if (r30.b("receive_result") != null) goto L95;
        r30.e(TuplesKt.to("duration", Long.valueOf(r30.a())));
        r30.e(TuplesKt.to("receive_result", Long.valueOf(System.currentTimeMillis())));
        r30.e(TuplesKt.to("scene", "receive_result"));
        r30.e(TuplesKt.to("success", Integer.valueOf(r12.l() ? 1 : 0)));
        CanvasInfo r31 = r12.a();
        if (r31 == null) goto L81;
        Long r32 = r31.errCode;
        if (r32 == null) goto L81;
        long r33 = r32.longValue();
    L82:
        r30.e(TuplesKt.to("error_code", Long.valueOf(r33)));
        h.c(r30);
        String r34 = r12.a;
        boolean r35 = r12.l();
        CanvasInfo r36 = r12.a();
        if (r36 == null) goto L87;
        Long r37 = r36.errCode;
        if (r37 == null) goto L87;
        String r38 = r37.toString();
    L88:
        List<CanvasBlock> r39 = r12.b;
        if (r39 == null) goto L93;
        CanvasBlock r40 = (CanvasBlock) CollectionsKt.firstOrNull(r39);
        if (r40 == null) goto L93;
        String r41 = r40.logId;
    L94:
        h.a(r34, r35, r38, r41);
    L93:
        r41 = null;
    L87:
        r38 = null;
    L81:
        r33 = 0;
        goto L82
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final CanvasPerfData pZ(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localId");
        return (CanvasPerfData) ((HashMap) this.o.getValue()).get(r2);
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void tR(ky8.f r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "task");
        if (h.b(r10.a) != null) goto L28;
        com.larus.ugc.perf.impl.g r0 = new com.larus.ugc.perf.impl.g("canvas_generate_img");
        r0.e(TuplesKt.to("scene", "start"));
        r0.e(TuplesKt.to("local_id", r10.a));
        i r1 = r10.e;
        if (r1.d == false) goto L9;
        int r2 = 3;
    L12:
        r0.e(TuplesKt.to("input_type", Integer.valueOf(r2)));
        InstructionTab r3 = r10.e.a;
        if (r3 == null) goto L15;
        String r4 = r3.getTabLabel();
    L16:
        Object r5 = "";
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        r0.e(TuplesKt.to("instruction_tab_label", r4));
        OptionItem r6 = r10.e.b;
        if (r6 == null) goto L22;
        r5 = Long.valueOf(r6.getId());
    L22:
        r0.e(TuplesKt.to("option_id", r5));
        String r7 = r10.a;
        Intrinsics.checkNotNullParameter(r0, "tracker");
        if (TextUtils.isEmpty(r7) == true) goto L27;
        if (r7 == null) goto L27;
        com.larus.ugc.perf.impl.g r8 = (com.larus.ugc.perf.impl.g) h.b.put(r7, r0);
    L27:
        h.c(r0);
        goto L28
    L15:
        r4 = null;
        goto L16
    L9:
        if (o0.d(r1.c) == false) goto L11;
        r2 = 1;
        goto L12
    L11:
        r2 = 2;
    L28:
        HashMap r9 = (HashMap) this.o.getValue();
        String r11 = r10.a;
        CanvasPerfData r12 = new CanvasPerfData(null, null, null, null, 15, null);
        r12.setStartTime(System.currentTimeMillis());
        r9.put(r11, r12);
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void xx(String r8) {
        n2 r0 = L2();
        if (r0 == null) goto L7;
        Long r1 = r0.XF();
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        n2 r3 = L2();
        int r4 = 0;
        if (r3 == null) goto L11;
        int r5 = r3.re();
    L12:
        Integer r6 = Integer.valueOf(r5);
        n2 r7 = L2();
        if (r7 == null) goto L15;
        r4 = r7.dx();
    L15:
        Integer r9 = Integer.valueOf(r4);
        Long r10 = Long.valueOf(System.currentTimeMillis() - this.n);
        JSONObject r11 = new JSONObject();
        Intrinsics.checkNotNullParameter(r11, "params");
        r11.putOpt("canvas_id", r2);     // Catch: JSONException -> L18
        r11.putOpt("cnt_sub_canvas", r6);     // Catch: JSONException -> L18
        r11.putOpt("cnt_sub_canvas_success", r9);     // Catch: JSONException -> L18
        r11.putOpt("duration", r10);     // Catch: JSONException -> L18
        r11.putOpt("click_from", r8);     // Catch: JSONException -> L18
    L20:
        TrackParams r12 = new TrackParams().merge(r11);
        by7.a r13 = new by7.a("ai_generate_canvas_finish");
        r13.a.merge(r12);
        r13.b();
        this.n = System.currentTimeMillis();
        return;
    L18:
        e = move-exception;
        FLogger.a.e("mobAIGenerateCanvasFinish", "error: " + e.getLocalizedMessage());
        goto L20
    L11:
        r5 = 0;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void Vz(ky8.f r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "task");
        CanvasPerfData r0 = (CanvasPerfData) ((HashMap) this.o.getValue()).get(r5.a);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r5.f == true) goto L8;
        return;
    L8:
        if (r0.imageDisplayDuration == null) goto L10;
        return;
    L10:
        if (this.p == true) goto L18;
        h r1 = h.a;
        String r7 = r5.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "localId");
        com.larus.ugc.perf.impl.g r8 = h.b(r7);
        if (r8 == null) goto L18;
        if (r8.b("image_load") != null) goto L18;
        r8.e(TuplesKt.to("duration", Long.valueOf(r8.a())));
        r8.e(TuplesKt.to("image_load", Long.valueOf(System.currentTimeMillis())));
        r8.e(TuplesKt.to("success", Integer.valueOf(r6 ? 1 : 0)));
        r8.e(TuplesKt.to("error_code", 0));
        r8.e(TuplesKt.to("scene", "image_load"));
        h.c(r8);
    L18:
        r0.imageDisplayDuration = Long.valueOf(System.currentTimeMillis() - r0.getStartTime());
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void Xv(ky8.f r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "task");
        if (r11.e.d == false) goto L6;
        return;
    L6:
        if (((HashMap) this.k.getValue()).containsKey(r11.a) == false) goto L8;
        return;
    L8:
        boolean r2 = false;
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{11, 10}), r11.n()) == true) goto L20;
        CanvasInfo r0 = r11.a();
        if (r0 == null) goto L13;
        Long r1 = r0.canvasSubId;
    L14:
        if (r1 != null) goto L16;
    L17:
        r2 = true;
    L18:
        if (r2 == false) goto L20;
        return;
    L16:
        if (r1.longValue() != 0) goto L18;
    L13:
        r1 = null;
    L20:
        ((HashMap) this.k.getValue()).put(r11.a, Unit.INSTANCE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CanvasGenImageTraceComponent$mobCanvasSendMessageStatus$1(r11, r12, this, null), 2, null);
    }

    @Override // com.larus.canvas.feature.component.logic.trace.a
    public final void gp(ky8.f r15, boolean r16, long r17) {
        Intrinsics.checkNotNullParameter(r15, "task");
        if (((HashMap) this.l.getValue()).containsKey(r15.a) == false) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
    L9:
        ((HashMap) this.l.getValue()).put(r15.a, Unit.INSTANCE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CanvasGenImageTraceComponent$mobCanvasCreatePictureResult$1(this, r15, r17, r16, null), 2, null);
        return;
    L7:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{11, 10}), r15.n()) == true) goto L9;
    }
}
