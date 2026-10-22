package com.larus.bmhome.chat.detail.table;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.utils.s3;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.mainbot.impl.databinding.LarusFragmentTableBlockDetailBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0015H\u0003J\u001a\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0015H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/detail/table/TableBlockDetailFragment;", "Lcom/larus/bmhome/chat/detail/AbstractCommonDetailFragment;", "dependency", "Lcom/larus/bmhome/chat/detail/table/ITableBlockDependency;", "<init>", "(Lcom/larus/bmhome/chat/detail/table/ITableBlockDependency;)V", "getDependency", "()Lcom/larus/bmhome/chat/detail/table/ITableBlockDependency;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentTableBlockDetailBinding;", "eventExtra", "", "", "", "viewModel", "Lcom/larus/bmhome/chat/detail/table/TableBlockDetailViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/detail/table/TableBlockDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "enableScrollDefault", "", "getCopyContentType", "initViewModel", "initListeners", "copyTableToClipboard", "context", "Landroid/content/Context;", "tsvText", "getCurrentPageName", "getMarkDownTextViewContainer", "getMarkdownTextSize", "", "getLineSpacingMult", "autoLogEnterPage", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TableBlockDetailFragment extends AbstractCommonDetailFragment {
    public static final /* synthetic */ int E = 0;
    public final com.larus.bmhome.chat.detail.table.b A;
    public LarusFragmentTableBlockDetailBinding B;
    public Map<String, ? extends Object> C;
    public final Lazy D;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ TableBlockDetailFragment a;

        public final boolean mustInMain() {
            return true;
        }

        public a(TableBlockDetailFragment r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r2) {
            Message r3 = (Message) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            com.larus.bmhome.chat.detail.i r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.j(r3);
            return;
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(j r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public TableBlockDetailFragment() {
        this(null);
    }

    public final boolean S90() {
        return true;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final boolean Z90() {
        return true;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final String ca0() {
        return "table";
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final float da0() {
        return 1.25f;
    }

    public final String k() {
        return "table_full_screen_page";
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final ViewGroup fa0() {
        LarusFragmentTableBlockDetailBinding r0 = this.B;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final float ga0() {
        return we8.a.a(i5.o(), false);
    }

    public final void initView() {
        if (com.larus.utils.i.g(requireContext()) == false) goto L9;
        LarusFragmentTableBlockDetailBinding r0 = this.B;
        if (r0 == null) goto L15;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L16;
        int r7 = i5.q();
        int r8 = i5.q();
        int r9 = r1.getPaddingTop();
        int r10 = r1.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:,start:" + r7 + ",top:" + r9 + ",end:" + r8 + ",bottom:" + r10);
        r1.setPaddingRelative(r7, r9, r8, r10);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusFragmentTableBlockDetailBinding r2 = this.B;
        if (r2 == null) goto L18;
        ConstraintLayout r3 = r2.a;
        if (r3 == null) goto L19;
        int r11 = i5.k0();
        int r12 = i5.k0();
        int r13 = r3.getPaddingTop();
        int r14 = r3.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r3.getClass().getSimpleName() + ",source:,start:" + r11 + ",top:" + r13 + ",end:" + r12 + ",bottom:" + r14);
        r3.setPaddingRelative(r11, r13, r12, r14);
        return;
    L19:
        return;
    }

    public TableBlockDetailFragment(com.larus.bmhome.chat.detail.table.b r1) {
        super(r1);
        this.A = r1;
        this.D = LazyKt.lazy(new c(this));
    }

    public static void ha0(DialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        initView();
        super.onConfigurationChanged(r2);
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (z2.a.getMarkdownTableRenderConfig().a() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L12;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L15;
        r5.setRequestedOrientation(7);
    L15:
        Bundle r6 = getArguments();
        Map<String, ? extends Object> r0 = null;
        if (r6 == null) goto L18;
        Serializable r7 = r6.getSerializable("key_event_extra");
    L20:
        if ((r7 instanceof Map) == false) goto L22;
        r0 = (Map) r7;
    L22:
        this.C = r0;
        return;
    L18:
        r7 = null;
        goto L20
    L12:
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L15;
        r8.setRequestedOrientation(6);
        goto L15
    L5:
        if (com.larus.utils.i.g(requireContext()) == false) goto L7;
        r4 = true;
        goto L8
    }

    public static void ia0(Context r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        ClipData r4 = ClipData.newHtmlText("info", r3, s3.a(r3));
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.d0();
        i1 r1 = i1.a;
        Intrinsics.checkNotNull(r4);
        r1.i(r2, r4, "bpea-markdown-html-copy");
    L7:
        s.a.getClass();
        s.o(r2, 2131910467, false);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.detail.table.j] */
    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final void onViewCreated(View r44, Bundle r45) {
        Intrinsics.checkNotNullParameter(r44, "view");
        super.onViewCreated(r44, r45);
        ((TableBlockDetailViewModel) this.D.getValue()).getShareDetailData().observe(getViewLifecycleOwner(), new b(new j(this)));
        LarusFragmentTableBlockDetailBinding r1 = this.B;
        if (r1 == null) goto L17;
        e1.d(r1.b, new f(this));
        e1.d(r1.c, new g(this));
        e1.d(r1.e, new h(this));
        LarusFragmentTableBlockDetailBinding r2 = this.B;
        if (r2 == null) goto L16;
        AppCompatImageView r3 = r2.f;
        if (r3 == null) goto L16;
        z2.a.w3();
        if (this.g.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r3.setEnabled(false);
        float r5 = 0.5f;
    L15:
        r3.setAlpha(r5);
        com.larus.im.d.e().m(this.g, new n(r3));
        goto L16
    L14:
        r3.setEnabled(true);
        r5 = 1.0f;
        goto L15
    L11:
        r4 = false;
    L16:
        e1.d(r1.f, new i(this));
    L17:
        ri8.c r6 = ri8.c.a;
        BotModel r7 = this.m;
        String r8 = null;
        if (r7 == null) goto L20;
        String r15 = r7.getBotId();
    L21:
        ChatParam r9 = this.o;
        if (r9 == null) goto L24;
        r8 = r9.e;
    L24:
        ri8.c.n(null, null, this.g, this.h, null, "table_full_screen_page", null, null, null, null, null, "table", r15, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r8, null, null, null, null, null, null, new e(this), null, -536877101, 47);
        com.larus.im.d.e().m(this.g, new a(this));
        return;
    L20:
        r15 = null;
        goto L21
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562436, r9, false);
        int r12 = 2131362392;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131362392)) == null) goto L36;
        r12 = 2131363779;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r11, 2131363779);
        if (r2 == null) goto L36;
        r12 = 2131367953;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r11, 2131367953);
        if (r3 == null) goto L36;
        r12 = 2131379586;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131379586);
        if (r4 == null) goto L36;
        r12 = 2131384845;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r11, 2131384845);
        if (r5 == null) goto L36;
        r12 = 2131386061;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r11, 2131386061);
        if (r6 == null) goto L36;
        r12 = 2131388812;
        if (ViewBindings.findChildViewById(r11, 2131388812) == null) goto L36;
        this.B = new LarusFragmentTableBlockDetailBinding(r11, r2, r3, r4, r5, r6);
        if (z2.a.getMarkdownTableRenderConfig().b() == false) goto L23;
        LarusFragmentTableBlockDetailBinding r13 = this.B;
        if (r13 == null) goto L28;
        AppCompatImageView r14 = r13.e;
        if (r14 == null) goto L28;
        e1.x(r14);
    L28:
        LarusFragmentTableBlockDetailBinding r15 = this.B;
        if (r15 == null) goto L33;
        ConstraintLayout r16 = r15.a;
        if (r16 == null) goto L33;
        r16.setTag(2131377847, this);
        initView();
        return r16;
    L33:
        return null;
    L23:
        LarusFragmentTableBlockDetailBinding r17 = this.B;
        if (r17 == null) goto L28;
        AppCompatImageView r18 = r17.e;
        if (r18 == null) goto L28;
        e1.o(r18);
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
