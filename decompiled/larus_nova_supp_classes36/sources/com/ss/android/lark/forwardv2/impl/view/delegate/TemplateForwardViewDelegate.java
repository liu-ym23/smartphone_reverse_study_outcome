package com.ss.android.lark.forwardv2.impl.view.delegate;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.ForwardCallType;
import com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint;
import com.ss.android.lark.forwardv2.dto.template.ForwardLocation;
import com.ss.android.lark.forwardv2.e;
import com.ss.android.lark.forwardv2.impl.model.ForwardErrorResult;
import com.ss.android.lark.forwardv2.impl.statistics.AppreciablePerformance;
import com.ss.android.lark.forwardv2.impl.view.d0;
import com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.a2;
import z5c.a3;
import z5c.p3;
import z5c.r;
import z5c.t2;
import z5c.u2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TemplateForwardViewDelegate extends com.ss.android.lark.forwardv2.impl.view.delegate.a {
    public final iib.d b;
    public final iib.b c;
    public final ForwardTemplate d;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.impl.view.delegate.TemplateForwardViewDelegate$1, reason: invalid class name */
    public class AnonymousClass1 implements IGetDataCallback<List<ForwardTarget>> {
        final /* synthetic */ TemplateForwardViewDelegate this$0;
        final /* synthetic */ RichText val$additionNote;
        final /* synthetic */ BeforeForwardErrorHandle val$handler;
        final /* synthetic */ List val$searchInfoList;

        public static /* synthetic */ Boolean a(AnonymousClass1 r0, ErrorResult r1) {
            return r0.lambda$onError$0(r1);
        }

        private /* synthetic */ Boolean lambda$onError$0(ErrorResult r3) {
            this.this$0.b.L0(r3.getDisplayMsg(UIHelper.getString(2131891584)), false);
            return Boolean.TRUE;
        }

        public void onError(final ErrorResult r10) {
            int r0 = r10.getErrorCode();
            this.val$handler.a(r0, r10.getDisplayMsg(), new b(this, r10));
            Bundle r1 = this.this$0.d.g;
            if (r1 == null) goto L5;
            Message r2 = (Message) r1.getSerializable("key_message");
        L7:
            if (r2 == null) goto L9;
            hib.d r3 = e.a;
            hib.d r4 = e.a.a();
            r2.getChatId();
            r4.getTargetType();
            int r6 = -1;
        L10:
            String r5 = AppreciablePerformance.a;
            int r7 = r10.getErrorCode();
            String r8 = r10.getDebugMsg();
            if (r2 == null) goto L13;
            r2.isSecret();
        L13:
            if (r2 == null) goto L15;
            int r9 = r2.getType().getNumber();
        L16:
            int r11 = this.val$searchInfoList.size();
            if (r2 != null) goto L19;
            String r12 = "";
        L20:
            AppreciablePerformance.a.a(r7, r8, r9, r6, r11, r12);
            return;
        L19:
            r12 = r2.getId();
            goto L20
        L15:
            r9 = 0;
            goto L16
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = null;
            goto L7
        }

        public void onSuccess(List<ForwardTarget> r10) {
            ForwardHitPoint r0 = this.this$0.d.f;
            List r1 = this.val$searchInfoList;
            RichText r2 = this.val$additionNote;
            if (r2 == null) goto L5;
            String r3 = r2.getInnerText();
        L6:
            String r4 = r3;
            if (CollectionUtils.isEmpty(r1) == false) goto L9;
        L19:
            TemplateForwardViewDelegate r5 = this.this$0;
            List r6 = this.val$searchInfoList;
            String r7 = r5.d.f.b;
            if (CollectionUtils.isEmpty(r6) == false) goto L22;
        L33:
            String r8 = AppreciablePerformance.a;
            Intrinsics.checkNotNullParameter("sdk_cost", "spanKey");
            String r9 = AppreciablePerformance.a;
            if (r9 == null) goto L36;
            AppreciableKit.Companion.getInstance().spanEnd(r9, "sdk_cost");
        L36:
            this.this$0.b.L3(r10, this.val$additionNote);
            return;
        L22:
            if (CollectionUtils.isEmpty(r10) == true) goto L33;
            if (r6.size() != r10.size()) goto L33;
            int r11 = r6.size();
            int r12 = 0;
        L27:
            if (r12 >= r11) goto L33;
            ForwardTarget r13 = (ForwardTarget) ListProtector.get(r10, r12);
            if (r13.b() != 0) goto L32;
            int r14 = kib.a.a;
            String r15 = r13.a;
            Intrinsics.checkNotNullParameter(r15, "chatId");
            Intrinsics.checkNotNullParameter(r7, "source");
            Statistics.sendEvent("forward_select_chat", new JSONObject().put("find_type", "recent").put("chat_id", r15).put("source", r7));
        L32:
            r12 = r12 + 1;
            goto L27
        L9:
            if (CollectionUtils.isEmpty(r10) == true) goto L19;
            if (r1.size() != r10.size()) goto L19;
            kib.a.b.C0289a r16 = new kib.a.b.C0289a();
            r16.a = r0.f;
            Intrinsics.checkNotNullParameter(r10, "targets");
            r16.b = r10;
            ForwardCallType r17 = r0.e;
            ForwardLocation r18 = r0.d;
            kib.a.b r19 = new kib.a.b(r4, r16.a, r17, r18, r10);
            if (CollectionUtils.isEmpty(r19.a) == true) goto L19;
            if (CollectionUtils.isEmpty(r19.b) == true) goto L19;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new kib.b(r19));
            goto L19
        L5:
            r3 = "";
            goto L6
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }

        public AnonymousClass1(TemplateForwardViewDelegate r1, List r2, RichText r3, BeforeForwardErrorHandle r4) {
            this.this$0 = r1;
            this.val$searchInfoList = r2;
            this.val$additionNote = r3;
            this.val$handler = r4;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.impl.view.delegate.TemplateForwardViewDelegate$2, reason: invalid class name */
    public class AnonymousClass2 implements IGetDataCallback<com.ss.android.lark.forwardv2.impl.model.b> {
        final /* synthetic */ TemplateForwardViewDelegate this$0;
        final /* synthetic */ RichText val$additionNote;
        final /* synthetic */ List val$confirmTargets;

        public static /* synthetic */ void a(AnonymousClass2 r0, com.ss.android.lark.forwardv2.impl.model.b r1, List r2, RichText r3) {
            r0.lambda$onSuccess$0(r1, r2, r3);
        }

        public static /* synthetic */ void b(AnonymousClass2 r0, ForwardErrorResult r1, String r2) {
            r0.lambda$onError$1(r1, r2);
        }

        public void onError(ErrorResult r11) {
            final String r0 = UIHelper.getString(2131891584);
            Message r1 = this.this$0.d.g.getSerializable("key_message");
            if (r1 == null) goto L5;
            hib.d r3 = e.a;
            hib.d r4 = e.a.a();
            r1.getChatId();
            r4.getTargetType();
            int r7 = -1;
        L6:
            String r5 = AppreciablePerformance.a;
            int r6 = r11.getErrorCode();
            String r8 = r11.getDebugMsg();
            if (r1 == null) goto L9;
            r1.isSecret();
        L9:
            if (r1 != null) goto L11;
        L13:
            int r9 = 0;
        L14:
            int r10 = this.val$confirmTargets.size();
            if (r1 == null) goto L17;
            String r12 = r1.getId();
        L18:
            AppreciablePerformance.a.a(r6, r8, r9, r7, r10, r12);
            if ((r11 instanceof ForwardErrorResult) == true) goto L22;
            this.this$0.b.L0(r11.getDisplayMsg(r0), false);
            return;
        L22:
            final ForwardErrorResult r2 = (ForwardErrorResult) r11;
            if (TextUtils.isEmpty(r2.getMessage()) == true) goto L26;
            r0 = r2.getMessage();
        L26:
            if (r2.isIsDialog() == false) goto L28;
            UICallbackExecutor.execute(new c(this, r2, r0));
        L29:
            boolean r13 = zib.b.d;
            zib.b.d("v2", r11.getCode(), r11.getDebugMsg(), "");
            return;
        L28:
            this.this$0.b.L0(r11.getDisplayMsg(r0), r2.isWillClose());
            goto L29
        L17:
            r12 = "";
            goto L18
        L11:
            if (r1.getType() == null) goto L13;
            r9 = r1.getType().getNumber();
            goto L14
        L5:
            r7 = 0;
            goto L6
        }

        public void onSuccess(final com.ss.android.lark.forwardv2.impl.model.b r4) {
            final List r0 = this.val$confirmTargets;
            final RichText r1 = this.val$additionNote;
            UICallbackExecutor.execute(new d(this, r4, r0, r1));
            boolean r5 = zib.b.d;
            Intrinsics.checkNotNullParameter("v2", "forwardScene");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new zib.d("v2"));
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((com.ss.android.lark.forwardv2.impl.model.b) r1);
        }

        private /* synthetic */ void lambda$onError$1(ForwardErrorResult r3, String r4) {
            this.this$0.b.e6(r3.getTitle(), r4, r3.isWillClose());
        }

        public AnonymousClass2(TemplateForwardViewDelegate r1, List r2, RichText r3) {
            this.this$0 = r1;
            this.val$confirmTargets = r2;
            this.val$additionNote = r3;
        }

        private /* synthetic */ void lambda$onSuccess$0(com.ss.android.lark.forwardv2.impl.model.b r1, List r2, RichText r3) {
            this.this$0.b.U3(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Source.Type.values().length];
            a = r0;
            r0[Source.Type.SEARCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[Source.Type.FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[Source.Type.RECOMMEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // iib.c.a
    public final void n5() {
        this.c.a3();
        this.b.onCancelClick();
        List<SearchBaseInfo> r0 = this.c.z7();
        this.b.z6(r0);
    }

    @Override // iib.c.a
    public final boolean H2(int r2) {
        if (r2 > this.c.z7().size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // iib.c.a
    public final s5c.d O0(List<SearchBaseInfo> r8) {
        JsonArray r0 = new JsonArray();
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r1 >= r8.size()) goto L19;
        SearchBaseInfo r4 = (SearchBaseInfo) ListProtector.get(r8, r1);
        int r5 = a.a[r4.getSource().ordinal()];
        if (r5 != 1) goto L8;
        r3 = r3 + 1;
    L18:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r2 = r2 + 1;
        goto L18
    L10:
        if (r5 != 3) goto L18;
        if (this.c.R4().isEmpty() == false) goto L15;
        r0 = new JsonArray();
        goto L18
    L15:
        r0.add(Integer.valueOf(this.c.R4().indexOf(r4)));
        goto L18
    L19:
        s5c.a r9 = u2.c.a(String.valueOf(r2));
        s5c.a r6 = a3.c.a(String.valueOf(r3));
        return s5c.d.b.b(r9, t2.c.a(r0.toString())).plus(r6);
    }

    @Override // iib.c.a
    public final void T6(SearchBaseInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.b.k8(Collections.singletonList(r3));
        int r0 = kib.c.a;
        kib.c.a.a();
        b(true, r3);
        c(Collections.singletonList(r3));
    }

    public final void c(List<SearchBaseInfo> r3) {
        s5c.a r0 = r.e;
        s5c.a r1 = p3.c;
        r0.getClass();
        zib.e.a.c(s5c.d.b.b(r0, r1).plus(zib.e.a(r3)).plus(kib.c.a(this.d)));
    }

    @Override // iib.c.a
    public final void i7(SearchBaseInfo r1) {
        T6(r1);
    }

    @Override // iib.c.a
    public final void s3(int r3) {
        List<SearchBaseInfo> r0 = this.c.z7();
        if (r3 == 1) goto L5;
    L7:
        this.b.t8();
        this.b.z6(r0);
        return;
    L5:
        if (CollectionUtils.isEmpty(r0) == true) goto L7;
        this.b.k8(r0);
        c(r0);
        int r4 = kib.c.a;
        kib.c.a.a();
    }

    public final void b(boolean r12, SearchBaseInfo r13) {
        if (r13.getHeaderId() != 1) goto L5;
        String r0 = "recent";
    L6:
        String r3 = this.d.f.b;
        if (r12 == false) goto L9;
        int r14 = kib.a.a;
        Intrinsics.checkNotNullParameter(r0, "location");
        Intrinsics.checkNotNullParameter(0, "position");
        Statistics.sendEvent("message_forward_single_click", new JSONObject().put("location", r0).put("sort_position", 0).put("source", r3));
    L10:
        s5c.a r15 = r.l;
        s5c.a r1 = s5c.c.a("is_knowledge_ai_show", "false");
        com.ss.android.lark.forwardv3.utils.b.d();
        s5c.a r4 = s5c.c.a("panel_version", "integration_portrait_display");
        a2 r5 = a2.c;
        int r6 = zib.e.a;
        s5c.a r7 = r5.a(zib.e.a.a(r13));
        s5c.a r8 = s5c.c.a("list_item_number", "-1");
        s5c.d r9 = s5c.c.a("panel_type", "recommend");
        int r10 = a.a[r13.getSource().ordinal()];
        if (r10 != 1) goto L13;
        r9 = s5c.c.a("panel_type", LocationHitPoint$ResultType.SEARCH);
    L20:
        r15.getClass();
        zib.e.a.c(s5c.d.b.b(r15, r1).plus(r4).plus(r7).plus(r9).plus(r8));
        return;
    L13:
        if (r10 != 2) goto L15;
        r8 = s5c.c.a("list_item_number", "0");
        goto L20
    L15:
        if (r10 != 3) goto L20;
        r8 = s5c.c.a("list_item_number", String.valueOf(this.b.m8().indexOf(r13)));
        goto L20
    L9:
        int r16 = kib.a.a;
        Intrinsics.checkNotNullParameter(r0, "location");
        Intrinsics.checkNotNullParameter(0, "position");
        Statistics.sendEvent("message_forward_multi_click", new JSONObject().put("location", r0).put("sort_position", 0).put("source", r3));
        goto L10
    L5:
        r0 = LocationHitPoint$ResultType.SEARCH;
        goto L6
    }

    @Override // iib.c.a
    public final void e1(SearchBaseInfo r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.c.Y4(r2, r3);
        this.b.s7(this.c.z7());
        iib.d r4 = this.b;
        this.c.u3();
        r4.y8();
        b(false, r2);
    }

    @Override // iib.c.a
    public final void n1(SearchBaseInfo r1, boolean r2) {
        e1(r1, r2);
        this.b.G4(this.c.z7());
    }

    public TemplateForwardViewDelegate(d0 r1, com.ss.android.lark.forwardv2.impl.model.d r2, ForwardTemplate r3) {
        super(r1, r2);
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }

    @Override // iib.c.a
    public final void K2(Context r2, List<ForwardTarget> r3, RichText r4) {
        AnonymousClass2 r0 = new AnonymousClass2(this, r3, r4);
        this.c.L6(r2, r3, r0);
    }

    @Override // iib.c.a
    public final void i2(Context r5, List<SearchBaseInfo> r6, RichText r7) {
        BeforeForwardErrorHandle r0 = new BeforeForwardErrorHandle(r5);
        String r8 = AppreciablePerformance.a;
        Intrinsics.checkNotNullParameter("sdk_cost", "spanKey");
        String r1 = AppreciablePerformance.a;
        if (r1 == null) goto L5;
        AppreciableKit.Companion.getInstance().spanStart(r1, "sdk_cost");
    L5:
        iib.b r9 = this.c;
        r9.L1(this.d.d.d, r6, r9.m3().wrapAndAddGetDataCallback(new AnonymousClass1(this, r6, r7, r0)));
    }
}
