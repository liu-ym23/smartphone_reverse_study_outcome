package com.obric.assistant.omnidetailpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import com.obric.assistant.omnidetailpage.blockview.base.StopButton;
import com.obric.assistant.omnidetailpage.componment.c;
import gfa.d;
import ifa.e;
import k1a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/omnidetailpage/OmniDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/omnidetailpage/componment/IOmniDetailFragmentAbility;", "<init>", "()V", "binding", "Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "omniParam", "Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "autoLogEnterPage", "", "getCurrentPageName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "bindSystemBarInsets", "bindToVContext", "bindAction", "bindParam", "attachComponent", "showErrorPage", "showDetailPage", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDetailFragment extends TraceFragment implements c {
    public static final /* synthetic */ int g = 0;
    public ObricFragmentOmniDetailBinding e;
    public final e f;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "omni_detail_page";
    }

    @Override // com.obric.assistant.omnidetailpage.componment.c
    public final void B70() {
        ObricFragmentOmniDetailBinding r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.e.getParent() == null) goto L7;
        r0.e.inflate();
    L7:
        View r1 = r0.a.findViewById(2131368710);
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        View r2 = r0.a.findViewById(2131368710);
        if (r2 == null) goto L13;
        r2.setOnClickListener(new gfa.e(this));
    L13:
        r0.d.setVisibility(8);
        r0.b.setVisibility(8);
    }

    public OmniDetailFragment() {
        this.f = new e(null);
    }

    @Override // com.obric.assistant.omnidetailpage.componment.c
    public final ObricFragmentOmniDetailBinding e() {
        return this.e;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        s1a.a.g(this).c(this, c.class);
        s1a.a.g(this).n(this.f, e.class);
        b.a(this, new gfa.a(this));
    }

    public static final void U90(ChatConstraintLayout r3, WindowInsetsCompat r4) {
        int r5 = r4.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        if (r3.getPaddingTop() == r5) goto L6;
        r3.setPadding(r3.getPaddingLeft(), r5, r3.getPaddingRight(), r3.getPaddingBottom());
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        ObricFragmentOmniDetailBinding r4 = this.e;
        if (r4 == null) goto L11;
        final ChatConstraintLayout r5 = r4.a;
        if (r5 == null) goto L11;
        r5.setDisableBottomPadding(true);
        r5.R5();
        ViewCompat.setOnApplyWindowInsetsListener(r5, new gfa.c(r5));
        WindowInsetsCompat r6 = ViewCompat.getRootWindowInsets(r5);
        if (r6 == null) goto L10;
        U90(r5, r6);
    L10:
        r5.post(new d(r5));
    L11:
        ObricFragmentOmniDetailBinding r7 = this.e;
        if (r7 == null) goto L16;
        AppCompatImageView r8 = r7.c;
        if (r8 == null) goto L16;
        r8.setOnClickListener(new gfa.b(this));
    L16:
        e r9 = this.f;
        Bundle r10 = getArguments();
        if (r10 == null) goto L21;
        String r11 = r10.getString("resource_id");
        if (r11 == null) goto L21;
        r9.d = r11;
    L21:
        Bundle r12 = getArguments();
        if (r12 == null) goto L26;
        String r13 = r12.getString("message_id");
        if (r13 == null) goto L26;
        r9.e = r13;
    L26:
        Bundle r14 = getArguments();
        if (r14 == null) goto L31;
        String r15 = r14.getString("bot_id");
        if (r15 == null) goto L31;
        r9.f = r15;
    L31:
        Bundle r16 = getArguments();
        if (r16 == null) goto L36;
        String r17 = r16.getString("enter_method");
        if (r17 == null) goto L36;
        r9.g = r17;
    L36:
        Bundle r18 = getArguments();
        if (r18 == null) goto L42;
        String r19 = r18.getString("o_omni_instruction_type");
        if (r19 == null) goto L43;
        r9.h = r19;
        return;
    L43:
        return;
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        ChatConstraintLayout r0 = r18.inflate(2131564004, r19, false);
        int r1 = 2131362041;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131362041);
        if (r5 == null) goto L33;
        r1 = 2131363762;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r0, 2131363762);
        if (r6 == null) goto L33;
        ChatConstraintLayout r2 = r0;
        int r3 = 2131368888;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131368888);
        if (r7 == null) goto L35;
        r3 = 2131371780;
        ViewStub r8 = (ViewStub) ViewBindings.findChildViewById(r0, 2131371780);
        if (r8 == null) goto L35;
        r3 = 2131376636;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r0, 2131376636);
        if (r9 == null) goto L35;
        r3 = 2131384076;
        RecyclerView r10 = ViewBindings.findChildViewById(r0, 2131384076);
        if (r10 == null) goto L35;
        r3 = 2131386799;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r0, 2131386799);
        if (r11 == null) goto L35;
        r3 = 2131387366;
        StopButton r12 = (StopButton) ViewBindings.findChildViewById(r0, 2131387366);
        if (r12 == null) goto L35;
        r3 = 2131388279;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131388279);
        if (r13 == null) goto L35;
        r3 = 2131388881;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131388881)) == null) goto L35;
        r3 = 2131389138;
        ConstraintLayout r14 = ViewBindings.findChildViewById(r0, 2131389138);
        if (r14 == null) goto L35;
        r3 = 2131391509;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131391509);
        if (r15 == null) goto L35;
        r3 = 2131391561;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r0, 2131391561);
        if (r16 == null) goto L35;
        r3 = 2131391606;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131391606)) == null) goto L35;
        this.e = new ObricFragmentOmniDetailBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return r2;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    L33:
        r3 = r1;
        goto L35
    }
}
