package com.larus.bmhome.chat.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusLayoutFragmentPluginDetailBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusLayoutFragmentPluginDetailBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "autoLogEnterPage", "", "getCurrentPageName", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PluginDetailFragment extends TraceFragment {
    public static final /* synthetic */ int f = 0;
    public LarusLayoutFragmentPluginDetailBinding e;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "PluginDetailFragment";
    }

    public PluginDetailFragment() {
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        Bundle r8 = getArguments();
        String r9 = null;
        if (r8 == null) goto L5;
        String r10 = r8.getString("bot_id", "");
    L6:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        Bundle r1 = getArguments();
        if (r1 == null) goto L11;
        String r2 = r1.getString("conversation_id", "");
    L12:
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        Bundle r3 = getArguments();
        if (r3 == null) goto L17;
        r9 = r3.getString("previous_page", "");
    L17:
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        b r11 = (b) PluginManagerDelegate.a.f(r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r9, "previousPage");
        r11.d("plugin_details", r9, r2, r11.a);
        final LarusLayoutFragmentPluginDetailBinding r12 = this.e;
        if (r12 != null) goto L22;
        return;
    L22:
        Bundle r13 = getArguments();
        if (r13 == null) goto L27;
        String r14 = r13.getString("param_plugin_icon_url", "");
        if (r14 == null) goto L27;
        r12.e.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(12)));
        ImageLoaderKt.y(r12.e, r14, "settings.avatar", new s(r12), 4);
    L27:
        Bundle r15 = getArguments();
        if (r15 == null) goto L32;
        String r16 = r15.getString("param_plugin_name", "");
        if (r16 == null) goto L32;
        r12.f.setText(r16);
    L32:
        Bundle r17 = getArguments();
        if (r17 == null) goto L37;
        String r18 = r17.getString("param_plugin_author", "");
        if (r18 == null) goto L37;
        r12.b.setText(r18);
    L37:
        Bundle r19 = getArguments();
        if (r19 == null) goto L42;
        String r20 = r19.getString("param_plugin_description", "");
        if (r20 == null) goto L42;
        r12.d.setText(r20);
    L42:
        e1.d(r12.c, new t(this));
        return;
    L11:
        r2 = null;
        goto L12
    L5:
        r10 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562821, r9, false);
        int r12 = 2131363576;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131363576);
        if (r2 == null) goto L15;
        r12 = 2131366972;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r11, 2131366972);
        if (r3 == null) goto L15;
        r12 = 2131368849;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131368849);
        if (r4 == null) goto L15;
        r12 = 2131374718;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r11, 2131374718);
        if (r5 == null) goto L15;
        r12 = 2131380593;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131380593);
        if (r6 == null) goto L15;
        ConstraintLayout r13 = r11;
        this.e = new LarusLayoutFragmentPluginDetailBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
