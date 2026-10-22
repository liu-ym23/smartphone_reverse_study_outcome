package com.larus.bmhome.chat.detail.code.preview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.detail.code.l0;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.common.apphost.AppHost;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
import com.larus.platform.api.e4;
import com.larus.platform.api.u2;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.c1;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u000bH\u0002J\u000e\u00103\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u00104J\b\u00106\u001a\u00020#H\u0016J\b\u00107\u001a\u00020#H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 ¨\u0006="}, d2 = {"Lcom/larus/bmhome/chat/detail/code/preview/CodeBlockDetailPreviewComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/chat/detail/code/preview/ICodeBlockDetailPreviewAbility;", "<init>", "()V", "messageId", "", "conversationId", "codeId", "preloadCodeId", "isFromDeepResearch", "", "loadingStartTime", "", "loadingDuration", "loadingJob", "Lkotlinx/coroutines/Job;", "enterStartTime", "isPreload", "hasReportedEnterPage", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "currentLynxContainerId", "codeBlockDetailFragmentAbility", "Lcom/larus/bmhome/chat/detail/code/ICodeBlockDetailFragmentAbility;", "getCodeBlockDetailFragmentAbility", "()Lcom/larus/bmhome/chat/detail/code/ICodeBlockDetailFragmentAbility;", "codeBlockDetailFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentCodeBlockDetailBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusFragmentCodeBlockDetailBinding;", "binding$delegate", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "onResume", "onDestroy", "initPreviewFragment", "startLoading", "setPreviewTabVisibility", "visibility", "", "updatePreviewStatus", "status", "Lcom/larus/bmhome/chat/detail/code/preview/CodePreviewStatus;", "reportEnterPageEvent", "isSuccess", "getMessageIsFinish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageIsLast", "onCodeCompleted", "onRenderFail", "getCode", "getLanguage", "initLynxPreview", "createLynxView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CodeBlockDetailPreviewComponent extends BaseContentWidget implements j {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;
    public String m;
    public String n;
    public String o;
    public String p;
    public boolean q;
    public long r;
    public long s;
    public Job t;
    public long u;
    public boolean v;
    public boolean w;
    public e4 x;
    public String y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CodePreviewStatus.values().length];
            r0[CodePreviewStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CodePreviewStatus.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CodePreviewStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.detail.code.preview.j
    public final void Rj() {
        cw(CodePreviewStatus.FAIL);
    }

    public final void Y2() {
        c1 r0 = c1.a;
        if (r0.d() == true) goto L5;
        r0.f();
    L5:
        String r1 = this.y;
        if (r1 == null) goto L8;
        eh8.a.b(r1);
    L8:
        String r2 = null;
        this.y = null;
        String r3 = z2.a.getMarkdownCodeRenderConfig().h;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
        FLogger.a.w("CodeBlockDetailPreviewComponent", "createLynxView: previewLynxviewTemplateUrl is empty, skip lynx preview");
        cw(CodePreviewStatus.FAIL);
        return;
    L18:
        e4 r5 = this.x;
        if (r5 == null) goto L21;
        r5.destroy();
    L21:
        FragmentActivity r6 = s1a.a.getActivity(this);
        JSONObject r7 = new JSONObject();
        String r8 = getCode();
        final String r9 = "";
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        JSONObject r10 = r7.put("message_data", r8);
        String r11 = getLanguage();
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        e4 r12 = u2.a.a(r6, r3, r10.put("message_type", r11).toString(), 8);
        this.x = r12;
        if (r12 == null) goto L45;
        View r13 = r12.getView();
        if (r13 == null) goto L45;
        LarusFragmentCodeBlockDetailBinding r14 = d0();
        if (r14 == null) goto L45;
        FrameLayout r15 = r14.r;
        if (r15 == null) goto L45;
        if (r13.getParent() == null) goto L44;
        ViewParent r16 = r13.getParent();
        if ((r16 instanceof ViewGroup) == false) goto L41;
        ViewGroup r17 = (ViewGroup) r16;
    L42:
        if (r17 == null) goto L44;
        r17.removeView(r13);
        goto L44
    L41:
        r17 = null;
    L44:
        r15.removeAllViews();
        Resources r18 = s1a.a.getActivity(this).getResources();
        int r19 = WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()).widthPixels;
        r15.addView(r13, new FrameLayout.LayoutParams(r19, r19));
    L45:
        LarusFragmentCodeBlockDetailBinding r20 = d0();
        if (r20 == null) goto L50;
        FrameLayout r21 = r20.r;
        if (r21 == null) goto L50;
        r21.setVisibility(4);
    L50:
        e4 r22 = this.x;
        if (r22 == null) goto L53;
        r2 = r22.getContainerId();
    L53:
        if (r2 == null) goto L56;
        r9 = r2;
    L56:
        this.y = r9;
        eh8.a.a(r9, new com.larus.bmhome.chat.detail.code.preview.a(r9, this));
        return;
    L11:
        if (r3.length() == 0) goto L14;
        r4 = false;
        goto L15
    }

    public final LarusFragmentCodeBlockDetailBinding d0() {
        return (LarusFragmentCodeBlockDetailBinding) this.A.getValue();
    }

    public final l0 h3() {
        return (l0) this.z.getValue();
    }

    public final void m3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == true) goto L6;
        FLogger.a.i("CodeBlockDetailPreviewComponent", "initPreviewFragment ignored, fragment not added, codeId[" + this.o + "], messageId[" + this.m + ']');
        return;
    L6:
        List<String> r0 = ClickableMarkdownCodeView.H0;
        if (ClickableMarkdownCodeView.a.b(getLanguage()) == true) goto L77;
        String r8 = this.p;
        if (r8 == null) goto L41;
        m r1 = m.a;
        Context r10 = s1a.a.getActivity(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "targetActivity");
        Intrinsics.checkNotNullParameter(r8, "codeId");
        m.a r12 = m.b;
        if (r12 != null) goto L20;
    L39:
        Pair r2 = null;
    L40:
        if (r2 == null) goto L41;
    L42:
        View r9 = (View) r2.component1();
        CodePreviewStatus r3 = (CodePreviewStatus) r2.component2();
        if (r9 != null) goto L81;
    L62:
        AiChatHostWebService r4 = AiChatHostWebService.a;
        AbsWebFragment r5 = r4.a(null);
        if (r5 != null) goto L65;
        return;
    L65:
        r5.setArguments(r4.c(new zt8.b(UriProtector.parse(r4.b()).buildUpon().appendQueryParameter("code_id", this.o).appendQueryParameter("msg_id", this.m).appendQueryParameter("language", getLanguage()).build().toString(), false, false, null, false, 124)));
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Exception -> L72
        FragmentTransaction r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager().beginTransaction();     // Catch: Exception -> L72
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131382993) == true) goto L70;
        r6.add(2131382993, r5);     // Catch: Exception -> L72
    L70:
        r6.commit();     // Catch: Exception -> L72
        FLogger.a.i("CodeBlockDetailPreviewComponent", "initPreviewFragment, codeId[" + this.o + "], messageId[" + this.m + ']');     // Catch: Exception -> L72
        return;
    L72:
        e = move-exception;
        FLogger.a.e("CodeBlockDetailPreviewComponent", "initPreviewFragment fails, codeId[" + this.o + "], messageId[" + this.m + ']', e);
        return;
    L81:
        this.v = true;     // Catch: Exception -> L60
        Lazy r11 = i.a;     // Catch: Exception -> L60
        String r13 = this.o;     // Catch: Exception -> L60
        if (r13 == null) goto L49;
        ((Map) i.a.getValue()).remove(r13);     // Catch: Exception -> L60
    L49:
        String r14 = this.p;     // Catch: Exception -> L60
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L60
        this.o = r14;     // Catch: Exception -> L60
        Intrinsics.checkNotNullParameter(this, "ability");     // Catch: Exception -> L60
        if (r14 == null) goto L53;
        ((Map) i.a.getValue()).put(r14, this);     // Catch: Exception -> L60
    L53:
        LarusFragmentCodeBlockDetailBinding r15 = d0();     // Catch: Exception -> L60
        if (r15 == null) goto L58;
        FrameLayout r16 = r15.u;     // Catch: Exception -> L60
        if (r16 == null) goto L58;
        r16.addView(r9, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L60
    L58:
        cw(r3);     // Catch: Exception -> L60
        FLogger.a.i("CodeBlockDetailPreviewComponent", "initPreviewFragment from pool, preloadCodeId[" + this.p + "], codeId[" + this.o + "], messageId[" + this.m + ']');     // Catch: Exception -> L60
        return;
    L60:
        e = move-exception;
        FLogger.a.e("CodeBlockDetailPreviewComponent", "initPreviewFragment from pool fails, codeId[" + this.o + "], messageId[" + this.m + ']', e);
        goto L62
    L20:
        if (Intrinsics.areEqual(r12.b, r8) == false) goto L39;
        View r17 = r12.a.getView();     // Catch: Exception -> L37
        if (r17 == null) goto L25;
        ViewParent r18 = r17.getParent();     // Catch: Exception -> L37
    L27:
        if ((r18 instanceof ViewGroup) == false) goto L29;
        ViewGroup r19 = (ViewGroup) r18;     // Catch: Exception -> L37
    L30:
        if (r19 == null) goto L32;
        r19.removeView(r17);     // Catch: Exception -> L37
    L32:
        MutableContextWrapper r110 = r12.a.S90();     // Catch: Exception -> L37
        if (r110 == null) goto L35;
        r110.setBaseContext(r10);     // Catch: Exception -> L37
    L35:
        FLogger.a.i("PreloadCodeWebViewManager", "acquireWebView success, codeId[" + r8 + "], status[" + r12.f + ']');     // Catch: Exception -> L37
        r2 = new Pair(r17, r12.f);     // Catch: Exception -> L37
        goto L40
    L29:
        r19 = null;
        goto L30
    L25:
        r18 = null;
    L37:
        e = move-exception;
        FLogger.a.e("PreloadCodeWebViewManager", "acquireWebView failed, codeId[" + r8 + ']', e);
    L41:
        r2 = new Pair(null, CodePreviewStatus.LOADING);
        goto L42
    L77:
        Y2();     // Catch: Exception -> L11
        FLogger.a.i("CodeBlockDetailPreviewComponent", "initLynxPreview, codeId[" + this.o + "], messageId[" + this.m + "], language[" + getLanguage() + ']');     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        FLogger.a.e("CodeBlockDetailPreviewComponent", "initLynxPreview fails, fallback to web, codeId[" + this.o + "], messageId[" + this.m + ']', e);
        cw(CodePreviewStatus.FAIL);
    }

    public final void onDestroy() {
        Job r0 = this.t;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Lazy r1 = i.a;
        String r2 = this.o;
        if (r2 == null) goto L9;
        ((Map) i.a.getValue()).remove(r2);
    L9:
        m r3 = m.a;
        String r4 = this.o;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "codeId");
        m.a r5 = m.b;
        if (r5 == null) goto L12;
        String r6 = r5.b;
    L14:
        if (Intrinsics.areEqual(r4, r6) == false) goto L34;
        m.a r7 = m.b;
        if (r7 == null) goto L34;
        AbsWebFragment r8 = r7.a;
        if (r8 == null) goto L34;
        MutableContextWrapper r9 = r8.S90();
        if (r9 == null) goto L34;
        r9.setBaseContext(AppHost.a.getApplication());
    L34:
        e4 r10 = this.x;     // Catch: Exception -> L27
        if (r10 == null) goto L29;
        r10.destroy();     // Catch: Exception -> L27
    L29:
        this.x = null;
        String r11 = this.y;
        if (r11 == null) goto L32;
        eh8.a.b(r11);
    L32:
        this.y = null;
        return;
    L27:
        e = move-exception;
        FLogger.a.e("CodeBlockDetailPreviewComponent", "destroy lynxView exception", e);
        goto L29
    L12:
        r6 = null;
        goto L14
    }

    public final void onResume() {
        if (this.r != 0) goto L5;
        this.r = System.currentTimeMillis();
    L5:
        Job r0 = this.t;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        if ((System.currentTimeMillis() - this.r) < this.s) goto L16;
        LarusFragmentCodeBlockDetailBinding r1 = d0();
        if (r1 == null) goto L30;
        ProgressBar r2 = r1.p;
        if (r2 == null) goto L31;
        r2.setProgress(90);
        return;
    L31:
        return;
    L30:
        return;
    L16:
        if (this.q == false) goto L23;
        LarusFragmentCodeBlockDetailBinding r3 = d0();
        if (r3 == null) goto L22;
        TextView r4 = r3.q;
        if (r4 == null) goto L22;
        r4.setText(getContext().getString(2131901464));
    L22:
        this.t = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CodeBlockDetailPreviewComponent$startLoading$1(this, null), 3, null);
        return;
    L23:
        LarusFragmentCodeBlockDetailBinding r5 = d0();
        if (r5 == null) goto L28;
        TextView r6 = r5.q;
        if (r6 == null) goto L28;
        r6.setText(getContext().getString(2131900893));
    L28:
        this.t = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CodeBlockDetailPreviewComponent$startLoading$2(this, null), 3, null);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, j.class);
        this.o = String.valueOf(System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getString("key_mark_down_detail_message_id");
        if (r3 == null) goto L6;
    L7:
        this.m = r3;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r4 == null) goto L13;
        String r5 = r4.getString("key_mark_down_detail_conversation_id");
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        this.n = r2;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r6 == null) goto L16;
        String r7 = r6.getString("key_preload_code_id");
    L17:
        this.p = r7;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r8 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r8 == null) goto L20;
        boolean r9 = r8.getBoolean("key_is_from_deep_research");
    L21:
        this.q = r9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r10 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r10 == null) goto L24;
        long r11 = r10.getLong("key_deep_research_start_time");
    L25:
        this.r = r11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 == null) goto L30;
        long r12 = r0.getLong("key_deep_research_loading_duration");
        if (r12 <= 0) goto L30;
    L31:
        this.s = r12;
        Lazy r13 = i.a;
        String r14 = this.o;
        Intrinsics.checkNotNullParameter(this, "ability");
        if (r14 == null) goto L35;
        ((Map) i.a.getValue()).put(r14, this);
    L35:
        this.u = System.currentTimeMillis();
        return;
    L30:
        r12 = 10000;
        goto L31
    L24:
        r11 = 0;
        goto L25
    L20:
        r9 = false;
        goto L21
    L16:
        r7 = null;
    L6:
        r3 = "";
        goto L7
    }

    public CodeBlockDetailPreviewComponent() {
        this.m = "";
        this.n = "";
        this.o = "";
        this.z = LazyKt.lazy(new com.larus.bmhome.chat.detail.code.preview.b(this));
        this.A = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.bmhome.chat.detail.code.preview.j
    public final String getCode() {
        l0 r0 = h3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCode();
    }

    @Override // com.larus.bmhome.chat.detail.code.preview.j
    public final String getLanguage() {
        l0 r0 = h3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLanguage();
    }

    @Override // com.larus.bmhome.chat.detail.code.preview.j
    public final void qc() {
        LarusFragmentCodeBlockDetailBinding r0 = d0();
        if (r0 == null) goto L8;
        ConstraintLayout r1 = r0.f;
        if (r1 == null) goto L9;
        r1.post(new d(this));
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.detail.code.preview.j
    public final void B30(int r2) {
        LarusFragmentCodeBlockDetailBinding r0 = d0();
        if (r0 == null) goto L8;
        FrameLayout r1 = r0.t;
        if (r1 == null) goto L9;
        r1.setVisibility(r2);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.detail.code.preview.j
    public final void cw(CodePreviewStatus r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        int r7 = b.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        LarusFragmentCodeBlockDetailBinding r8 = d0();
        if (r8 == null) goto L78;
        FrameLayout r9 = r8.u;
        if (r9 == null) goto L78;
        r9.setVisibility(8);
    L78:
        LarusFragmentCodeBlockDetailBinding r10 = d0();
        if (r10 == null) goto L83;
        FrameLayout r11 = r10.r;
        if (r11 == null) goto L83;
        r11.setVisibility(8);
    L83:
        LarusFragmentCodeBlockDetailBinding r12 = d0();
        if (r12 == null) goto L88;
        ConstraintLayout r13 = r12.o;
        if (r13 == null) goto L88;
        r13.setVisibility(0);
    L88:
        LarusFragmentCodeBlockDetailBinding r14 = d0();
        if (r14 == null) goto L96;
        LinearLayout r15 = r14.l;
        if (r15 == null) goto L97;
        r15.setVisibility(8);
        return;
    L97:
        return;
    L96:
        return;
    L5:
        if (r7 != 2) goto L7;
        Job r16 = this.t;
        if (r16 == null) goto L52;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);
    L52:
        LarusFragmentCodeBlockDetailBinding r17 = d0();
        if (r17 == null) goto L57;
        FrameLayout r18 = r17.u;
        if (r18 == null) goto L57;
        r18.setVisibility(8);
    L57:
        LarusFragmentCodeBlockDetailBinding r19 = d0();
        if (r19 == null) goto L62;
        FrameLayout r20 = r19.r;
        if (r20 == null) goto L62;
        r20.setVisibility(8);
    L62:
        LarusFragmentCodeBlockDetailBinding r21 = d0();
        if (r21 == null) goto L67;
        ConstraintLayout r22 = r21.o;
        if (r22 == null) goto L67;
        r22.setVisibility(8);
    L67:
        LarusFragmentCodeBlockDetailBinding r23 = d0();
        if (r23 == null) goto L72;
        LinearLayout r24 = r23.l;
        if (r24 == null) goto L72;
        r24.setVisibility(0);
    L72:
        p3(false);
        return;
    L7:
        if (r7 != 3) goto L48;
        Job r25 = this.t;
        if (r25 == null) goto L11;
        Job.DefaultImpls.cancel$default(r25, null, 1, null);
    L11:
        List<String> r26 = ClickableMarkdownCodeView.H0;
        if (ClickableMarkdownCodeView.a.b(getLanguage()) == false) goto L23;
        LarusFragmentCodeBlockDetailBinding r27 = d0();
        if (r27 == null) goto L18;
        FrameLayout r28 = r27.r;
        if (r28 == null) goto L18;
        r28.setVisibility(0);
    L18:
        LarusFragmentCodeBlockDetailBinding r29 = d0();
        if (r29 == null) goto L33;
        FrameLayout r30 = r29.u;
        if (r30 == null) goto L33;
        r30.setVisibility(8);
    L33:
        LarusFragmentCodeBlockDetailBinding r31 = d0();
        if (r31 == null) goto L38;
        ConstraintLayout r32 = r31.o;
        if (r32 == null) goto L38;
        r32.setVisibility(8);
    L38:
        LarusFragmentCodeBlockDetailBinding r33 = d0();
        if (r33 == null) goto L43;
        LinearLayout r34 = r33.l;
        if (r34 == null) goto L43;
        r34.setVisibility(8);
    L43:
        l0 r35 = h3();
        if (r35 == null) goto L46;
        r35.ky();
    L46:
        p3(true);
        return;
    L23:
        LarusFragmentCodeBlockDetailBinding r36 = d0();
        if (r36 == null) goto L28;
        FrameLayout r37 = r36.u;
        if (r37 == null) goto L28;
        r37.setVisibility(0);
    L28:
        LarusFragmentCodeBlockDetailBinding r38 = d0();
        if (r38 == null) goto L33;
        FrameLayout r39 = r38.r;
        if (r39 == null) goto L33;
        r39.setVisibility(8);
        goto L33
    L48:
        throw new NoWhenBranchMatchedException();
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        l0 r4 = h3();
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        m3();
        return;
    L10:
        return;
    L5:
        if (r4.jW() != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void p3(boolean r15) {
        if (this.w == false) goto L5;
        return;
    L5:
        this.w = true;
        long r2 = 0;
        if (this.u <= 0) goto L8;
        r2 = System.currentTimeMillis() - this.u;
    L8:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CodeBlockDetailPreviewComponent$reportEnterPageEvent$1(this, r2, r15, null), 3, null);
    }
}
