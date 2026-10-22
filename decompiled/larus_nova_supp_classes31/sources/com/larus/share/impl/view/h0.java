package com.larus.share.impl.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.messagetransfer.IDoubaoToLarkForwardLimitService;
import com.larus.bmhome.share.ShareScene;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.share.impl.databinding.LarusShareLayoutPanelViewBinding;
import com.larus.share.impl.panel.SharePanelAdapter;
import com.larus.share.impl.panel.ShareSuggestionAdapter;
import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 extends com.larus.bmhome.share.panel.a {
    public final ShareScene a;
    public com.larus.bmhome.share.panel.h b;
    public com.larus.bmhome.share.panel.b c;
    public final Boolean d;
    public com.larus.bmhome.share.panel.d e;
    public final boolean f;
    public final List<jr9.a> g;
    public final List<jr9.a> h;
    public by7.e i;
    public final boolean j;
    public List<jr9.a> k;
    public List<jr9.e> l;
    public SharePanelAdapter m;
    public ShareSuggestionAdapter n;
    public LarusShareLayoutPanelViewBinding o;
    public final Handler p;
    public Job q;
    public final Lazy r;
    public final Lazy s;
    public List<kw9.a> t;

    public static final class a {
    }

    static {
    }

    private final String getCreationTaskId() {
        com.larus.bmhome.share.panel.h r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.E;
    L6:
        Object r2 = "";
        if (com.larus.utils.o0.d(r1) == false) goto L15;
        com.larus.bmhome.share.panel.h r3 = this.b;
        if (r3 == null) goto L25;
        String r4 = r3.E;
        if (r4 != null) goto L14;
        return "";
    L14:
        return r4;
    L25:
        return "";
    L15:
        com.larus.bmhome.share.panel.h r5 = this.b;
        if (r5 == null) goto L24;
        JSONObject r6 = r5.i;
        if (r6 == null) goto L24;
        Object r7 = r6.opt("creation_task_id");
        if (r7 == null) goto L24;
        r2 = r7;
    L24:
        return (String) r2;
    L5:
        r1 = null;
        goto L6
    }

    private final IDoubaoToLarkForwardLimitService getDoubaoForwardLimitService() {
        return (IDoubaoToLarkForwardLimitService) this.s.getValue();
    }

    private final IShareDoubaoForwardService getDoubaoForwardService() {
        return (IShareDoubaoForwardService) this.r.getValue();
    }

    private final String getSourceConversationId() {
        com.larus.bmhome.share.panel.h r0 = this.b;
        if (r0 == null) goto L11;
        String r1 = r0.B;
        if (r1 == null) goto L11;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L11;
    L29:
        return r1;
    L11:
        com.larus.bmhome.share.panel.h r2 = this.b;
        if (r2 == null) goto L20;
        wc9.e r3 = r2.a;
        if (r3 == null) goto L20;
        r1 = r3.a;
        if (r1 == null) goto L20;
        if ((!StringsKt.isBlank(r1)) == false) goto L20;
    L21:
        if (r1 != null) goto L29;
        com.larus.bmhome.share.panel.h r4 = this.b;
        if (r4 == null) goto L30;
        r1 = r4.o0;
        if (r1 != null) goto L27;
        return null;
    L27:
        if ((!StringsKt.isBlank(r1)) == true) goto L29;
        return null;
    L30:
        return null;
    L20:
        r1 = null;
        goto L21
    }

    public static boolean s() {
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.b() == false) goto L9;
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == false) goto L9;
        if (r0.a() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void b() {
        this.p.removeCallbacksAndMessages(null);
        LarusShareLayoutPanelViewBinding r0 = this.o;
        if (r0 == null) goto L9;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L9;
        r2.cancel();
    L9:
        Job r3 = this.q;
        if (r3 == null) goto L12;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L12:
        this.q = null;
        LarusShareLayoutPanelViewBinding r4 = this.o;
        if (r4 == null) goto L17;
        RecyclerView r5 = r4.c;
        if (r5 == null) goto L17;
        r5.setAdapter(null);
    L17:
        LarusShareLayoutPanelViewBinding r6 = this.o;
        if (r6 == null) goto L22;
        RecyclerView r7 = r6.f;
        if (r7 == null) goto L22;
        r7.setAdapter(null);
    L22:
        LarusShareLayoutPanelViewBinding r8 = this.o;
        if (r8 == null) goto L27;
        FrameLayout r9 = r8.d;
        if (r9 == null) goto L27;
        r9.setOnClickListener(null);
    L27:
        SharePanelAdapter r10 = this.m;
        if (r10 == null) goto L30;
        r10.A2();
    L30:
        this.m = null;
        this.n = null;
        this.k = null;
        List<jr9.e> r11 = this.l;
        if (r11 == null) goto L33;
        r11.clear();
    L33:
        this.l = null;
        this.t = CollectionsKt.emptyList();
        this.e = null;
        this.b = null;
        this.c = null;
        this.i = null;
        this.o = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        this.p.removeCallbacksAndMessages(null);
        LarusShareLayoutPanelViewBinding r0 = this.o;
        if (r0 == null) goto L9;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L9;
        r2.cancel();
    L9:
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    public final void r() {
        if (this.j == true) goto L5;
        return;
    L5:
        LarusShareLayoutPanelViewBinding r0 = this.o;
        int r1 = 0;
        if (r0 == null) goto L10;
        RecyclerView r2 = r0.c;
        if (r2 == null) goto L10;
        r2.setVisibility(0);
    L10:
        LarusShareLayoutPanelViewBinding r3 = this.o;
        if (r3 == null) goto L15;
        LinearLayout r4 = r3.b;
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        LarusShareLayoutPanelViewBinding r5 = this.o;
        if (r5 == null) goto L22;
        EditText r6 = r5.e;
        if (r6 == null) goto L22;
        Editable r7 = r6.getText();
        if (r7 == null) goto L22;
        r7.clear();
    L22:
        List<jr9.e> r8 = this.l;
        if (r8 != null) goto L25;
        return;
    L25:
        List<jr9.e> r9 = r8;
        if ((r9 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r10 = r9.iterator();
    L32:
        if (r10.hasNext() == false) goto L29;
        if (((jr9.e) r10.next()).d == false) goto L32;
        boolean r11 = true;
    L36:
        Iterator<T> r12 = r9.iterator();
    L38:
        if (r12.hasNext() == false) goto L40;
        ((jr9.e) r12.next()).d = false;
        goto L38
    L40:
        if (r11 == false) goto L44;
        ShareSuggestionAdapter r13 = this.n;
        if (r13 == null) goto L44;
        r13.setData(r8);
    L44:
        LarusShareLayoutPanelViewBinding r14 = this.o;
        if (r14 == null) goto L57;
        RecyclerView r15 = r14.f;
        if (r15 == null) goto L66;
        int r16 = r15.getChildCount();
    L50:
        if (r1 >= r16) goto L67;
        View r17 = r15.getChildAt(r1);
        if (r17 == null) goto L56;
        View r18 = r17.findViewById(2131385851);
        if (r18 == null) goto L56;
        r18.animate().cancel();
        r18.setAlpha(1.0f);
        r18.setVisibility(8);
    L56:
        r1 = r1 + 1;
        goto L50
    L67:
        return;
    L66:
        return;
    L57:
        return;
    L29:
        r11 = false;
        goto L36
    L28:
        if (r9.isEmpty() == false) goto L30;
        goto L29
    }

    public final void o() {
        this.t = CollectionsKt.emptyList();
        List<jr9.e> r0 = this.l;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        ShareSuggestionAdapter r1 = this.n;
        if (r1 == null) goto L11;
        List<jr9.e> r2 = this.l;
        if (r2 != null) goto L10;
        r2 = new ArrayList();
    L10:
        r1.setData(r2);
    L11:
        LarusShareLayoutPanelViewBinding r3 = this.o;
        if (r3 == null) goto L16;
        RecyclerView r4 = r3.f;
        if (r4 == null) goto L16;
        r4.setVisibility(8);
        r4.requestLayout();
    L16:
        LarusShareLayoutPanelViewBinding r5 = this.o;
        if (r5 == null) goto L26;
        LinearLayout r6 = r5.b;
        if (r6 == null) goto L26;
        boolean r7 = true;
        if (r6.getVisibility() != 0) goto L23;
        boolean r8 = true;
    L24:
        if (r8 != true) goto L26;
    L27:
        if (r7 == false) goto L39;
        LarusShareLayoutPanelViewBinding r9 = this.o;
        if (r9 == null) goto L33;
        LinearLayout r10 = r9.b;
        if (r10 == null) goto L33;
        r10.setVisibility(8);
    L33:
        LarusShareLayoutPanelViewBinding r11 = this.o;
        if (r11 == null) goto L40;
        RecyclerView r12 = r11.c;
        if (r12 == null) goto L41;
        r12.setVisibility(0);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L23:
        r8 = false;
    L26:
        r7 = false;
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        FLogger r0 = FLogger.a;
        r0.i("SharePanelView", "onAttachedToWindow: 开始订阅 PublishInsertEvent");
        Job r1 = this.q;
        if (r1 == null) goto L7;
        boolean r3 = true;
        if (r1.isActive() != true) goto L7;
    L8:
        if (r3 == true) goto L16;
        LifecycleOwner r2 = ViewTreeLifecycleOwner.get(this);
        if (r2 != null) goto L13;
        r0.w("SharePanelView", "observePublishInsertEvent: lifecycleOwner is null, 无法订阅事件");
        return;
    L13:
        this.q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new SharePanelView$observePublishInsertEvent$1(this, null), 3, null);
        return;
    L16:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final boolean getNeedSuggestion() {
        return this.j;
    }

    public final by7.e getTrackNode() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.share.impl.view.s] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.util.ArrayList] */
    public static void e(final h0 r25) {
        List<jr9.e> r1 = r25.l;
        com.larus.bmhome.share.panel.h r2 = null;
        if (r1 == null) goto L10;
        List r3 = new ArrayList();
        Iterator r4 = ((ArrayList) r1).iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (((jr9.e) r5).d == false) goto L6;
        r3.add(r5);
    L11:
        if (r3 != 0) goto L13;
        r3 = CollectionsKt.emptyList();
    L13:
        LarusShareLayoutPanelViewBinding r6 = r25.o;
        if (r6 == null) goto L20;
        EditText r7 = r6.e;
        if (r7 == null) goto L20;
        Editable r8 = r7.getText();
        if (r8 == null) goto L20;
        String r9 = r8.toString();
    L21:
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        String r10 = StringsKt.trim(r9).toString();
        List<kw9.a> r11 = r25.t;
        final ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L24:
        boolean r14 = false;
        if (r13.hasNext() == false) goto L39;
        Object r15 = r13.next();
        kw9.a r16 = (kw9.a) r15;
        Iterable r17 = r3;
        if ((r17 instanceof Collection) == true) goto L29;
    L31:
        Iterator r18 = r17.iterator();
    L33:
        if (r18.hasNext() == false) goto L37;
        if (Intrinsics.areEqual(((jr9.e) r18.next()).a, r16.a) == false) goto L33;
        r14 = true;
    L37:
        if (r14 == false) goto L24;
        r12.add(r15);
        goto L24
    L29:
        if (((Collection) r17).isEmpty() == false) goto L31;
    L39:
        com.larus.bmhome.share.panel.b r19 = r25.c;
        if (r19 == null) goto L51;
        com.larus.bmhome.share.panel.c r20 = r19.z;
        if (r20 == null) goto L51;
        if ((!StringsKt.isBlank(r20.a)) == true) goto L46;
    L48:
        boolean r21 = false;
    L49:
        if (r21 == false) goto L51;
        com.larus.bmhome.share.panel.c r22 = r20;
    L53:
        if (r22 == null) goto L65;
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("host file forward attempt, entry=direct_contact, stage=click, selectedCount=");
        r24.append(r3.size());
        r24.append(", hasNote=");
        r24.append(!StringsKt.isBlank(r10));
        r23.i("SharePanelView", r24.toString());
        if ((!r12.isEmpty()) == false) goto L64;
        IShareDoubaoForwardService r26 = r25.getDoubaoForwardService();
        if (r26 == null) goto L60;
        r14 = r26.c(r25.getContext(), r22, r10, r12, new k0(r12, r25));
    L60:
        if (r14 == false) goto L64;
        com.larus.share.impl.e r27 = com.larus.share.impl.a.a;
        com.larus.share.impl.a.o(r25.a, "message_forward", r25.b, r25.i);
        r25.r();
        com.larus.bmhome.share.panel.d r0 = r25.e;
        if (r0 == null) goto L133;
        r0.onDismiss();
        return;
    L133:
        return;
    L64:
        t19.s.j(t19.s.a, r25.getContext(), r25.getContext().getString(2131898120), null, false, 28);
        return;
    L65:
        com.larus.bmhome.share.panel.h r28 = r25.b;
        if (r28 == null) goto L68;
        List r29 = r28.P;
    L69:
        if (r29 != null) goto L71;
        r29 = CollectionsKt.emptyList();
    L71:
        ArrayList r110 = new ArrayList();
        Iterator r30 = r29.iterator();
    L73:
        if (r30.hasNext() == false) goto L80;
        String r111 = ((Message) r30.next()).getMessageId();
        if (r111 == null) goto L77;
        Long r112 = StringsKt.toLongOrNull(r111);
    L78:
        if (r112 == null) goto L73;
        r110.add(r112);
        goto L73
    L77:
        r112 = null;
        goto L78
    L80:
        List r31 = CollectionsKt.distinct(r110);
        FLogger r113 = FLogger.a;
        StringBuilder r114 = new StringBuilder("doubao to lark forward attempt, entry=direct_contact, stage=click, selectedCount=");
        r114.append(r3.size());
        r114.append(", messageCount=");
        r114.append(r31.size());
        r114.append(", hasNote=");
        r114.append(!StringsKt.isBlank(r10));
        r113.i("SharePanelView", r114.toString());
        if ((!r3.isEmpty()) == true) goto L83;
    L112:
        r113.w("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=start, success=false, reason=invalid_selection, selectedCount=" + r3.size() + ", messageCount=" + r31.size());
        return;
    L83:
        if ((!r31.isEmpty()) == false) goto L112;
        if ((!r12.isEmpty()) == false) goto L111;
        IDoubaoToLarkForwardLimitService r32 = r25.getDoubaoForwardLimitService();
        if (r32 != null) goto L89;
    L91:
        boolean r33 = false;
    L92:
        if (r33 == false) goto L94;
        r113.i("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=validation, success=false, reason=intercepted");
        return;
    L94:
        ConcurrentHashMap<String, tx9.v0.c> r34 = tx9.v0.a;
        String r35 = r25.getSourceConversationId();
        List r36 = r31;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator r37 = r36.iterator();
    L96:
        if (r37.hasNext() == false) goto L98;
        r115.add(String.valueOf(((Number) r37.next()).longValue()));
        goto L96
    L98:
        tx9.v0.b r116 = tx9.v0.d("to_chat", r35, r115, j(r12));
        ConcurrentHashMap<String, tx9.v0.c> r38 = tx9.v0.a;
        tx9.v0.h(r116);
        com.larus.share.impl.e r39 = com.larus.share.impl.a.a;
        ShareScene r40 = r25.a;
        final com.larus.bmhome.share.panel.h r117 = r25.b;
        if (r117 == null) goto L102;
        r2 = com.larus.bmhome.share.panel.h.a(r117, new s(r117, r25, r12), null, null, null, null, null, null, -513, -1);
    L102:
        com.larus.share.impl.a.o(r40, "forward", r2, r25.i);
        IShareDoubaoForwardService r41 = r25.getDoubaoForwardService();
        if (r41 != null) goto L105;
        FLogger.a.e("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=result, success=false, reason=service_unavailable, messageCount=" + r31.size() + ", targetCount=" + r12.size());
        tx9.v0.j(r116, false, null, "forward_service_unavailable", "doubao forward service is null", 4);
    L106:
        if (r14 == false) goto L110;
        FLogger.a.i("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=request_start, success=true");
        r25.r();
        com.larus.bmhome.share.panel.d r42 = r25.e;
        if (r42 == null) goto L137;
        r42.onDismiss();
        return;
    L137:
        return;
    L110:
        FLogger.a.e("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=request_start, success=false, reason=request_rejected");
        t19.s.j(t19.s.a, r25.getContext(), r25.getContext().getString(2131898120), null, false, 28);
        return;
    L105:
        FLogger r43 = FLogger.a;
        StringBuilder r44 = new StringBuilder("doubao to lark forward attempt, entry=direct_contact, stage=send, messageCount=");
        r44.append(r31.size());
        r44.append(", targetCount=");
        r44.append(r12.size());
        r44.append(", hasNote=");
        r44.append(!StringsKt.isBlank(r10));
        r43.i("SharePanelView", r44.toString());
        r41.b(r25.getContext(), r31, r10, r12, new j0(r31, r12, r116, r25));
        r14 = true;
        goto L106
    L89:
        if (r32.a(r25.getContext(), r29) != true) goto L91;
        r33 = true;
        goto L92
    L111:
        r113.w("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=start, success=false, reason=empty_target");
        t19.s.j(t19.s.a, r25.getContext(), r25.getContext().getString(2131898120), null, false, 28);
        return;
    L68:
        r29 = null;
        goto L69
    L46:
        if ((!StringsKt.isBlank(r20.b)) == false) goto L48;
        r21 = true;
    L51:
        r22 = null;
    L20:
        r9 = null;
        goto L21
    L10:
        r3 = 0;
        goto L11
    }

    public static final /* synthetic */ String i(h0 r0) {
        return r0.getCreationTaskId();
    }

    public static List j(List r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L24;
        kw9.a r1 = (kw9.a) r7.next();
        int r3 = r1.f;
        String r4 = null;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L11;
        r4 = r1.a;
    L22:
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L11:
        if (r3 != 3) goto L22;
        String r5 = r1.d;
        if ((true ^ StringsKt.isBlank(r5)) == false) goto L16;
        r4 = r5;
    L16:
        if (r4 != null) goto L22;
        r4 = r1.a;
    L19:
        String r2 = r1.e;
        if ((true ^ StringsKt.isBlank(r2)) == false) goto L22;
        r4 = r2;
        goto L22
    L24:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r0.iterator();
    L26:
        if (r9.hasNext() == false) goto L31;
        Object r10 = r9.next();
        if ((!StringsKt.isBlank((String) r10)) == false) goto L26;
        r8.add(r10);
        goto L26
    L31:
        return CollectionsKt.distinct(r8);
    }

    public static void l(final View r3) {
        if (r3.getVisibility() == 0) goto L5;
        r3.setAlpha(0.0f);
        r3.setVisibility(0);
    L5:
        r3.animate().alpha(1.0f).setDuration(120).withEndAction(new w(r3)).start();
    }

    public static List n(List r6) {
        if (s() == true) goto L30;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L24;
        Object r1 = r7.next();
        jr9.a r2 = (jr9.a) r1;
        String r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.b();
    L13:
        if (Intrinsics.areEqual(r4, "forward") == true) goto L20;
        if (r2 == null) goto L17;
        r3 = r2.b();
    L17:
        if (Intrinsics.areEqual(r3, "message_forward") == true) goto L20;
        boolean r5 = false;
    L21:
        if (r5 == true) goto L7;
        r0.add(r1);
    L20:
        r5 = true;
        goto L21
    L11:
        r4 = null;
        goto L13
    L24:
        return r0;
    L30:
        return r6;
    }

    public static List p(jr9.c r1) {
        if (r1.a() != null) goto L7;
        return r1.c();
    L7:
        if (r1.c() == null) goto L9;
        List<jr9.a> r0 = r1.a();
        if (r0 == null) goto L16;
        List<jr9.a> r2 = r1.c();
        if (r2 != null) goto L15;
        return null;
    L15:
        return CollectionsKt.plus(r0, r2);
    L16:
        return null;
    L9:
        return r1.a();
    }

    public final void a(List<com.larus.bmhome.share.panel.j> r4) {
        Intrinsics.checkNotNullParameter(r4, "items");
        SharePanelAdapter r1 = this.m;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "items");
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r1.E2((com.larus.bmhome.share.panel.j) r5.next(), false);
        goto L6
    L8:
        r1.notifyDataSetChanged();
        return;
    }

    public void setPanelViewClickable(boolean r3) {
        if (r3 == false) goto L8;
        LarusShareLayoutPanelViewBinding r0 = this.o;
        if (r0 == null) goto L13;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L13;
        r1.setAlpha(1.0f);
    L13:
        SharePanelAdapter r2 = this.m;
        if (r2 == null) goto L17;
        r2.i = r3;
        return;
    L17:
        return;
    L8:
        LarusShareLayoutPanelViewBinding r4 = this.o;
        if (r4 == null) goto L13;
        LinearLayout r5 = r4.a;
        if (r5 == null) goto L13;
        r5.setAlpha(0.3f);
        goto L13
    }

    public final void setTrackNode(by7.e r1) {
        this.i = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(final h0 r16, final kw9.a r17) {
        Context r1 = r16.getContext();
    L3:
        ViewGroup r3 = null;
        if ((r1 instanceof Activity) == true) goto L5;
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L9:
        Activity r2 = null;
    L10:
        if (r2 == null) goto L12;
        r3 = (ViewGroup) r2.findViewById(R.id.content);
    L12:
        final ViewGroup r8 = r3;
        if (r8 == null) goto L23;
        if (r17 == null) goto L23;
        View r4 = r8.findViewWithTag("doubao_forward_success_toast");
        if (r4 == null) goto L19;
        r8.removeView(r4);
    L19:
        Context r11 = r8.getContext();
        int r6 = j19.c.c(20);
        final LinearLayout r12 = new LinearLayout(r11);
        r12.setOrientation(0);
        r12.setGravity(16);
        r12.setPadding(j19.c.c(10), 0, j19.c.c(14), 0);
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(j19.c.c(100));
        r5.setColor(v19.c.a(2130970529, r16.getContext(), 2131102529));
        r12.setBackground(r5);
        r12.setElevation(j19.c.c(8));
        r12.setClipToOutline(false);
        ImageView r7 = new ImageView(r11);
        r7.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r7.setOutlineProvider(new i0());
        r7.setClipToOutline(true);
        GradientDrawable r9 = new GradientDrawable();
        r9.setShape(1);
        r9.setColor(v19.c.a(2130970533, r16.getContext(), 2131102542));
        r7.setBackground(r9);
        r12.addView(r7, new LinearLayout.LayoutParams(r6, r6));
        IShareDoubaoForwardService r10 = r16.getDoubaoForwardService();
        if (r10 == null) goto L22;
        r10.a(r11, r7, r17, r6, r6);
    L22:
        TextView r13 = new TextView(r11);
        r13.setText(r11.getString(2131898241));
        r13.setTextColor(v19.c.a(2130972079, r16.getContext(), 2131103136));
        r13.setTextSize(14.0f);
        r13.setTypeface(Typeface.create("sans-serif-medium", 0));
        r13.setIncludeFontPadding(false);
        r13.setGravity(17);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        r14.setMarginStart(j19.c.c(8));
        Unit r15 = Unit.INSTANCE;
        r12.addView(r13, r14);
        View r18 = new View(r11);
        r18.setBackgroundColor(v19.c.a(2130972087, r16.getContext(), 2131103162));
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(1, j19.c.c(14));
        r19.setMarginStart(j19.c.c(12));
        r19.setMarginEnd(j19.c.c(12));
        r12.addView(r18, r19);
        final TextView r20 = new TextView(r11);
        r20.setText(r11.getString(2131898239));
        r20.setTextColor(v19.c.a(2130972123, r16.getContext(), 2131103203));
        r20.setTextSize(14.0f);
        r20.setTypeface(Typeface.create("sans-serif-medium", 0));
        r20.setIncludeFontPadding(false);
        r20.setGravity(17);
        r20.setOnClickListener(new x(r20, r16, r17));
        r12.addView(r20, new LinearLayout.LayoutParams(-2, -2));
        r12.setTag("doubao_forward_success_toast");
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-2, j19.c.c(36), 81);
        r21.bottomMargin = j19.c.c(158);
        r8.addView(r12, r21);
        r12.postDelayed(new v(r16, r8, r12), 4000);
        return;
    L23:
        t19.s.j(t19.s.a, r16.getContext(), r16.getContext().getString(2131898241), null, false, 28);
        return;
    L5:
        r2 = (Activity) r1;
        goto L10
    }

    public static String k(List r9, boolean r10) {
        ArrayList r0 = new ArrayList();
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L22;
        kw9.a r1 = (kw9.a) r11.next();
        int r3 = r1.f;
        if (r3 == 2) goto L9;
        if (r3 == 3) goto L9;
        boolean r4 = false;
    L10:
        String r6 = null;
        if (r4 != r10) goto L20;
        if (r3 != 3) goto L19;
        String r5 = r1.d;
        if ((true ^ StringsKt.isBlank(r5)) == false) goto L17;
        r6 = r5;
    L17:
        if (r6 != null) goto L20;
        r6 = r1.a;
        goto L20
    L19:
        r6 = r1.a;
    L20:
        if (r6 == null) goto L4;
        r0.add(r6);
    L9:
        r4 = true;
        goto L10
    L22:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r0.iterator();
    L24:
        if (r13.hasNext() == false) goto L29;
        Object r2 = r13.next();
        if ((!StringsKt.isBlank((String) r2)) == false) goto L24;
        r12.add(r2);
        goto L24
    L29:
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(r12), ",", null, null, 0, null, null, 62, null);
    }

    public final boolean c(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "channel");
        SharePanelAdapter r1 = this.m;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r4, "channel");
        return r1.E2(new com.larus.bmhome.share.panel.j(r4, r5, null), true);
    L5:
        return false;
    }

    public final void d(com.larus.bmhome.share.panel.b r2, com.larus.bmhome.share.panel.h r3) {
        Intrinsics.checkNotNullParameter(r2, "shareContent");
        this.c = r2;
        this.b = r3;
        SharePanelAdapter r4 = this.m;
        if (r4 == null) goto L6;
        r4.d = r2;
        return;
    }

    public final void m(final View r4, final View r5) {
        r4.animate().cancel();
        r5.animate().cancel();
        if (r4.getVisibility() == 0) goto L5;
    L9:
        r4.setVisibility(8);
        r4.setAlpha(1.0f);
        l(r5);
        return;
    L5:
        if (r4.getAlpha() <= 0.0f) goto L9;
        r4.animate().alpha(0.0f).setDuration(80).withEndAction(new u(r4, this, r5)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "changedView");
        super/*android.widget.FrameLayout*/.onVisibilityChanged(r5, r6);
        if (Intrinsics.areEqual(r5, this) == true) goto L5;
        return;
    L5:
        if (getVisibility() != 0) goto L37;
        r();
        if (this.j == true) goto L9;
    L13:
        o();
    L14:
        com.larus.share.impl.e r7 = com.larus.share.impl.a.a;
        com.larus.share.impl.a.r(this.a, this.b, this.i);
        List<jr9.a> r8 = this.k;
        if (r8 == null) goto L19;
        boolean r0 = true;
        if ((!((ArrayList) r8).isEmpty()) != true) goto L19;
    L20:
        if (r0 == false) goto L22;
        com.larus.share.impl.a.n(this.a, this.c, this.i, "custom");
    L23:
        List<jr9.a> r9 = this.k;
        if (r9 == null) goto L29;
        Iterator r10 = ((ArrayList) r9).iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        jr9.a r1 = (jr9.a) r10.next();
        com.larus.share.impl.e r2 = com.larus.share.impl.a.a;
        com.larus.share.impl.a.q(this.a, r1.b(), this.b, this.i);
    L29:
        LarusShareLayoutPanelViewBinding r11 = this.o;
        if (r11 == null) goto L38;
        RecyclerView r12 = r11.c;
        if (r12 == null) goto L39;
        r12.scrollToPosition(0);
        return;
    L39:
        return;
    L38:
        return;
    L22:
        com.larus.share.impl.a.l(this.a, this.c, "config is null: true", this.i);
    L19:
        r0 = false;
        goto L20
    L9:
        if (s() == false) goto L13;
        FLogger.a.i("SharePanelView", "request recent forward list");
        IShareDoubaoForwardService r13 = getDoubaoForwardService();
        if (r13 == null) goto L14;
        r13.g(new z(this), new a0(this));
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(TextView r6, h0 r7, kw9.a r8) {
        Object r9 = r6.getParent();
        ViewGroup r1 = null;
        if ((r9 instanceof View) == false) goto L5;
        View r10 = (View) r9;
    L6:
        if (r10 == null) goto L14;
        ViewParent r0 = r10.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L10;
        r1 = (ViewGroup) r0;
    L10:
        if (r1 == null) goto L14;
        r7.getClass();
        if (Intrinsics.areEqual(r10.getParent(), r1) == false) goto L14;
        r1.removeView(r10);
    L14:
        IShareDoubaoForwardService r11 = r7.getDoubaoForwardService();
        if (r11 == null) goto L19;
        boolean r12 = r11.e(r7.getContext(), r8);
        boolean r13 = true;
        if (r12 != true) goto L19;
    L20:
        if (r13 == true) goto L23;
        t19.s.j(t19.s.a, r7.getContext(), r7.getContext().getString(2131908171), null, false, 28);
        return;
    L23:
        return;
    L19:
        r13 = false;
        goto L20
    L5:
        r10 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit h(h0 r9, ImageView r10, jr9.e r11) {
        Intrinsics.checkNotNullParameter(r10, "avatarView");
        Intrinsics.checkNotNullParameter(r11, "item");
        Iterator<T> r0 = r9.t.iterator();
    L3:
        Integer r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((kw9.a) r1).a, r11.a) == false) goto L3;
    L9:
        kw9.a r6 = (kw9.a) r1;
        if (r6 == null) goto L27;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L22;
        Integer r13 = Integer.valueOf(r12.width);
        if (r13.intValue() <= 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        r2 = r13;
    L20:
        if (r2 == null) goto L22;
        int r14 = r2.intValue();
    L23:
        int r8 = r14;
        IShareDoubaoForwardService r4 = r9.getDoubaoForwardService();
        if (r4 == null) goto L27;
        r4.a(r9.getContext(), r10, r6, r8, r8);
        goto L27
    L17:
        r3 = false;
    L22:
        r14 = j19.c.c(56);
    L27:
        return Unit.INSTANCE;
    L8:
        r1 = null;
        goto L9
    }

    public static void q(final h0 r1, final boolean r2, final kw9.a r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r1.p.post(new r(r2, r1, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.view.ViewGroup, android.widget.FrameLayout, com.larus.share.impl.view.h0] */
    public h0(Context r26, ShareScene r27, com.larus.bmhome.share.panel.h r28, com.larus.bmhome.share.panel.b r29, Boolean r30, com.larus.bmhome.share.panel.d r31, boolean r32, List<jr9.a> r33, List<jr9.a> r34, by7.e r35, boolean r36) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r27, "shareScene");
        super(r26);
        this.a = r27;
        this.b = r28;
        this.c = r29;
        this.d = r30;
        this.e = r31;
        this.f = r32;
        this.g = r33;
        this.h = r34;
        this.i = r35;
        this.j = r36;
        this.p = new Handler(Looper.getMainLooper());
        this.r = LazyKt.lazy(new q());
        this.s = LazyKt.lazy(new y());
        this.t = CollectionsKt.emptyList();
        View r5 = LayoutInflater.from(getContext()).inflate(2131563125, this, false);
        addView(r5);
        int r6 = 2131375408;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131375408);
        if (r11 == null) goto L247;
        r6 = 2131384709;
        RecyclerView r12 = ViewBindings.findChildViewById(r5, 2131384709);
        if (r12 == null) goto L247;
        r6 = 2131385906;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131385906);
        if (r13 == null) goto L247;
        r6 = 2131386143;
        EditText r14 = (EditText) ViewBindings.findChildViewById(r5, 2131386143);
        if (r14 == null) goto L247;
        r6 = 2131387715;
        RecyclerView r15 = ViewBindings.findChildViewById(r5, 2131387715);
        if (r15 == null) goto L247;
        this.o = new LarusShareLayoutPanelViewBinding((LinearLayout) r5, r11, r12, r13, r14, r15);
        setVisibility(8);
        JSONObject r8 = null;
        boolean r9 = true;
        if (r33 == null) goto L15;
        List r1 = n(r33);
    L81:
        if (r1 == null) goto L83;
        List r2 = CollectionsKt.filterNotNull(r1);
    L84:
        if (r2 != null) goto L86;
        r2 = CollectionsKt.emptyList();
    L86:
        List r3 = CollectionsKt.toMutableList(r2);
        if (this.a != ShareScene.BOT_FILE_PREVIEW) goto L96;
        FlowFileProtectionService r4 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r4 != null) goto L91;
    L93:
        boolean r7 = false;
    L94:
        if (r7 == false) goto L96;
        boolean r10 = true;
    L97:
        com.larus.bmhome.share.panel.h r16 = this.b;
        if (r16 == null) goto L100;
        com.larus.bmhome.share.panel.k r17 = r16.p0;
    L102:
        if (r17 != null) goto L104;
    L114:
        FLogger.a.i("SharePanelView", "publishInsert: 未插入, publishInsert=" + r17);
    L115:
        com.larus.share.impl.util.e r18 = com.larus.share.impl.util.e.a;
        List r19 = r3;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L117:
        if (r21.hasNext() == false) goto L122;
        jr9.a r22 = (jr9.a) r21.next();
        if (r10 == false) goto L121;
        r22 = jr9.a.a(r22);
    L121:
        r20.add(r22);
        goto L117
    L122:
        boolean r23 = this.f;
        com.larus.bmhome.share.panel.h r24 = this.b;
        if (r24 == null) goto L125;
        BotModel r25 = r24.b;
    L126:
        List r37 = com.larus.share.impl.util.e.b(com.larus.share.impl.util.e.d(r18, r20, r23, r25, false, 4), this.d);
        ArrayList r110 = new ArrayList();
        Iterator r38 = ((ArrayList) r37).iterator();
    L128:
        if (r38.hasNext() == false) goto L139;
        jr9.a r39 = (jr9.a) r38.next();
        if (Intrinsics.areEqual(r39.b(), "save_image") == false) goto L132;
    L133:
        jr9.b r40 = r39.a;
        if (r40 == null) goto L136;
        jr9.b r41 = jr9.b.a(r40, false, false, 191);
    L137:
        r39.a = r41;
    L138:
        r110.add(r39);
        goto L128
    L136:
        r41 = null;
        goto L137
    L132:
        if (Intrinsics.areEqual(r39.b(), "save_video") == false) goto L138;
    L139:
        String r111 = getCreationTaskId();
        com.larus.bmhome.share.panel.h r42 = this.b;
        if (r42 == null) goto L145;
        String r43 = r42.n;
        if (r43 == null) goto L145;
        String r112 = r43;
    L146:
        if (r42 == null) goto L148;
        ?? r113 = Intrinsics.areEqual(r42.R, Boolean.TRUE);
    L149:
        com.larus.bmhome.share.panel.h r44 = this.b;
        if (r44 == null) goto L155;
        String r45 = r44.h;
        if (r45 == null) goto L155;
        String r114 = r45;
    L156:
        if (r44 != null) goto L158;
    L160:
        int r115 = 0;
    L161:
        if (r44 == null) goto L163;
        String r116 = r44.S;
    L164:
        if (r44 == null) goto L168;
        Message r46 = r44.O;
        if (r46 == null) goto L168;
        String r117 = r46.getReplyId();
    L169:
        com.larus.bmhome.share.panel.h r47 = this.b;
        if (r47 == null) goto L174;
        JSONObject r48 = r47.i;
        if (r48 == null) goto L174;
        String r118 = r48.optString("doc_id");
    L175:
        com.larus.bmhome.share.panel.h r49 = this.b;
        if (r49 == null) goto L180;
        JSONObject r50 = r49.i;
        if (r50 == null) goto L180;
        String r210 = r50.optString("rich_media_type");
    L181:
        com.larus.bmhome.share.panel.h r51 = this.b;
        if (r51 == null) goto L186;
        JSONObject r52 = r51.i;
        if (r52 == null) goto L186;
        String r119 = r52.optString("request_id");
    L187:
        com.larus.bmhome.share.panel.h r53 = this.b;
        if (r53 == null) goto L190;
        String r211 = r53.n0;
    L191:
        if (r53 == null) goto L193;
        String r212 = r53.o0;
    L194:
        if (r53 == null) goto L198;
        JSONObject r54 = r53.i;
        if (r54 == null) goto L198;
        String r213 = r54.optString("_mixed_richmedia_download_trace");
    L199:
        com.larus.bmhome.share.panel.h r55 = this.b;
        if (r55 == null) goto L202;
        r8 = r55.i;
    L202:
        List<jr9.a> r56 = com.larus.share.impl.util.e.a(r110, r111, r112, r113, r114, r115, r116, r117, r119, r118, r210, r211, r212, r213, r8);
        this.k = r56;
        if ((!((ArrayList) r56).isEmpty()) != true) goto L205;
        boolean r57 = true;
    L206:
        if (r57 == false) goto L269;
        LinearLayoutManager r58 = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView.ItemDecoration r59 = new SharePanelView$initView$itemDecoration$1(this);
        com.larus.share.impl.panel.g r60 = new SharePanelView$initView$callback$1(this);
        Context r61 = getContext();
        com.larus.bmhome.share.panel.b r120 = this.c;
        Boolean r121 = this.d;
        com.larus.bmhome.share.panel.h r122 = this.b;
        if (r122 == null) goto L219;
        wc9.e r123 = r122.a;
        if (r123 == null) goto L219;
        Integer r124 = r123.v;
        if (r124 == null) goto L219;
        int r125 = r124.intValue();
        if (r125 == 1) goto L219;
        if (r125 == 3) goto L219;
        r9 = false;
    L219:
        SharePanelAdapter r62 = new SharePanelAdapter(r61, null, r60, r120, true, r121, r9);
        this.m = r62;
        List<jr9.a> r63 = this.k;
        if (r63 != null) goto L222;
        r63 = new ArrayList();
    L222:
        r62.setData(r63);
        LarusShareLayoutPanelViewBinding r64 = this.o;
        if (r64 == null) goto L228;
        RecyclerView r65 = r64.c;
        if (r65 == null) goto L228;
        r65.setVisibility(0);
        r65.setAdapter(this.m);
        r65.setLayoutManager(r58);
        r65.addItemDecoration(r59);
    L228:
        if (this.j == false) goto L270;
        this.l = new ArrayList();
        ShareSuggestionAdapter r66 = new ShareSuggestionAdapter(getContext());
        this.n = r66;
        r66.d = new f0(this);
        List<jr9.e> r67 = this.l;
        if (r67 != null) goto L232;
        r67 = new ArrayList();
    L232:
        r66.setData(r67);
        ShareSuggestionAdapter r68 = this.n;
        if (r68 == null) goto L235;
        Function2<? super jr9.e, ? super Integer, Unit> r69 = new g0(this);
        Intrinsics.checkNotNullParameter(r69, "listener");
        r68.c = r69;
    L235:
        LarusShareLayoutPanelViewBinding r70 = this.o;
        if (r70 == null) goto L240;
        RecyclerView r71 = r70.f;
        if (r71 == null) goto L240;
        r71.setVisibility(8);
        r71.setAdapter(this.n);
        r71.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L240:
        LarusShareLayoutPanelViewBinding r72 = this.o;
        if (r72 == null) goto L271;
        FrameLayout r73 = r72.d;
        if (r73 == null) goto L272;
        r73.setOnClickListener(new c0(this));
        return;
    L272:
        return;
    L271:
        return;
    L270:
        return;
    L269:
        return;
    L205:
        r57 = false;
    L198:
        r213 = null;
        goto L199
    L193:
        r212 = null;
        goto L194
    L190:
        r211 = null;
    L186:
        r119 = null;
    L180:
        r210 = null;
    L174:
        r118 = null;
    L168:
        r117 = null;
        goto L169
    L163:
        r116 = null;
        goto L164
    L158:
        if (r44.l != true) goto L160;
        r115 = 1;
    L155:
        r114 = "";
        goto L156
    L148:
        r113 = 0;
    L145:
        r112 = "";
        goto L146
    L125:
        r25 = null;
        goto L126
    L104:
        if ((r17 instanceof com.larus.bmhome.share.panel.k.a) == true) goto L114;
        if ((r17 instanceof com.larus.bmhome.share.panel.k.b) == false) goto L109;
        String r74 = "publish";
    L112:
        if (r74 == null) goto L115;
        int r126 = Math.min(1, r3.size());
        ListProtector.add(r3, r126, new jr9.a(r74, null, 14));
        FLogger.a.i("SharePanelView", "publishInsert: 在 index=" + r126 + " 插入 channel=" + r74 + ", rawItems.size=" + r3.size());
        goto L115
    L109:
        if ((r17 instanceof com.larus.bmhome.share.panel.k.c) == false) goto L111;
        r74 = "set_private";
        goto L112
    L111:
        r74 = null;
        goto L112
    L100:
        r17 = null;
        goto L102
    L91:
        if (r4.I0() != true) goto L93;
        r7 = true;
    L96:
        r10 = false;
        goto L97
    L83:
        r2 = null;
        goto L84
    L15:
        if (r36 == true) goto L17;
    L43:
        List r75 = null;
    L44:
        if (r75 == null) goto L46;
        r1 = r75;
    L53:
        List<jr9.a> r76 = this.h;
        if (r76 == null) goto L81;
        if ((!r76.isEmpty()) == true) goto L59;
        r76 = null;
    L59:
        if (r76 == null) goto L81;
        ArrayList r77 = new ArrayList();
        Iterator r78 = r76.iterator();
    L63:
        if (r78.hasNext() == false) goto L67;
        String r127 = ((jr9.a) r78.next()).b();
        if (r127 == null) goto L63;
        r77.add(r127);
        goto L63
    L67:
        Set r79 = CollectionsKt.toSet(r77);
        List<jr9.a> r80 = r76;
        List r81 = r1;
        if (r1 != null) goto L70;
        r81 = CollectionsKt.emptyList();
    L70:
        ArrayList r82 = new ArrayList();
        Iterator r83 = r81.iterator();
    L72:
        if (r83.hasNext() == false) goto L80;
        Object r128 = r83.next();
        jr9.a r129 = (jr9.a) r128;
        Set r130 = r79;
        if (r129 == null) goto L76;
        String r131 = r129.b();
    L78:
        if (CollectionsKt.contains(r130, r131) == true) goto L72;
        r82.add(r128);
        goto L72
    L76:
        r131 = null;
        goto L78
    L80:
        r1 = CollectionsKt.plus(r80, r82);
        goto L81
    L46:
        int r84 = com.larus.share.impl.sdk.a.a;
        jr9.c r85 = com.larus.share.impl.sdk.a.a(this.a);
        if (r85 == null) goto L52;
        List r86 = p(r85);
        if (r86 == null) goto L52;
        r1 = n(r86);
    L52:
        r1 = null;
        goto L53
    L17:
        if (r27 != ShareScene.OFFICE_SHARE_CHAT) goto L43;
        if (r32 == false) goto L43;
        if (z2.a.getShareConfig().n() == false) goto L23;
        ShareScene r87 = ShareScene.MESSAGES_LINK_IMAGE;
    L24:
        jr9.c r88 = com.larus.share.impl.sdk.a.a(r87);
        if (r88 == null) goto L27;
        List r89 = p(r88);
    L28:
        if (r89 != null) goto L30;
        r89 = CollectionsKt.emptyList();
    L30:
        ArrayList r90 = new ArrayList();
        Iterator r91 = r89.iterator();
    L32:
        if (r91.hasNext() == false) goto L40;
        Object r92 = r91.next();
        jr9.a r132 = (jr9.a) r92;
        if (r132 == null) goto L36;
        String r133 = r132.b();
    L38:
        if (Intrinsics.areEqual(r133, "forward") == true) goto L32;
        r90.add(r92);
        goto L32
    L36:
        r133 = null;
        goto L38
    L40:
        r75 = r90;
        if (s() == false) goto L44;
        r75 = CollectionsKt.plus(CollectionsKt.listOf(new jr9.a("forward", null, 14)), r90);
        goto L44
    L27:
        r89 = null;
        goto L28
    L23:
        r87 = ShareScene.MESSAGES_LINK;
    L247:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
