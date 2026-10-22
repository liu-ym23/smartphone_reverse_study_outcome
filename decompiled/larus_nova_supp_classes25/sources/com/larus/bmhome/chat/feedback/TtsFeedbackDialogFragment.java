package com.larus.bmhome.chat.feedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.audio.bean.TtsFeedbackItem;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusFragmentTtsFeedbackBinding;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0016\u0010&\u001a\u00020\u00142\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0(H\u0002J\u0016\u0010)\u001a\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/feedback/TtsFeedbackDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentTtsFeedbackBinding;", "feedbackAdapter", "Lcom/larus/bmhome/chat/feedback/TtsFeedbackAdapter;", "isRealtime", "", "()Z", "setRealtime", "(Z)V", "params", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "setParams", "(Landroid/os/Bundle;)V", "botId", "", "feedbackSettings", "Lcom/larus/audio/bean/TtsFeedbackItem;", "onCreate", "", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getTheme", "", "onViewCreated", "view", "initRecycler", "initButton", "getFeedbackListString", "list", "", "getSubmitInfo", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TtsFeedbackDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int j = 0;
    public LarusFragmentTtsFeedbackBinding d;
    public TtsFeedbackAdapter e;
    public boolean f;
    public Bundle g;
    public String h;
    public TtsFeedbackItem i;

    public final int getTheme() {
        return 2131951931;
    }

    public TtsFeedbackDialogFragment() {
        this.h = "";
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = this.g;
        String r0 = "";
        if (r4 == null) goto L8;
        String r5 = r4.getString("bot_id", "");
        if (r5 == null) goto L8;
        r0 = r5;
    L8:
        this.h = r0;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        BottomSheetDialog r8 = getDialog();
        Object r0 = null;
        if ((r8 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r9 = r8;
    L6:
        if (r9 == null) goto L8;
        View r10 = r9.findViewById(2131368870);
    L9:
        if (r10 == null) goto L12;
        BottomSheetBehavior.from(r10).setState(3);
    L12:
        if (FeatureKitDelegate.b.w0().b() == false) goto L16;
        AudioUserConfig r11 = (AudioUserConfig) AudioServiceDelegate.a.getAudioConfig().p().getValue();
        if (r11 == null) goto L21;
        List r12 = r11.getTtsFeedbackItemList();
    L22:
        if (r12 == null) goto L56;
        Iterator r13 = r12.iterator();
    L25:
        if (r13.hasNext() == false) goto L38;
        Object r14 = r13.next();
        TtsFeedbackItem r1 = (TtsFeedbackItem) r14;
        boolean r3 = true;
        if (this.f == false) goto L31;
        if (r1.b() != 2) goto L31;
    L36:
        if (r3 == false) goto L25;
        r0 = r14;
    L31:
        if (this.f == false) goto L33;
    L35:
        r3 = false;
        goto L36
    L33:
        if (r1.b() != 1) goto L35;
    L38:
        TtsFeedbackItem r2 = (TtsFeedbackItem) r0;
        if (r2 == null) goto L56;
        this.i = r2;
        LarusFragmentTtsFeedbackBinding r15 = this.d;
        if (r15 == null) goto L46;
        TextView r16 = r15.e;
        if (r16 == null) goto L46;
        r16.setText(r2.a());
    L46:
        LarusFragmentTtsFeedbackBinding r17 = this.d;
        if (r17 == null) goto L56;
        RecyclerView r18 = r17.d;
        if (r18 == null) goto L56;
        TtsFeedbackItem r4 = this.i;
        if (r4 == null) goto L54;
        List r5 = r4.c();
        if (r5 == null) goto L54;
    L55:
        this.e = new TtsFeedbackAdapter(r5, new ArrayList());
        r18.setLayoutManager(new LinearLayoutManager(r18.getContext()));
        r18.setAdapter(this.e);
    L54:
        r5 = CollectionsKt.emptyList();
    L56:
        LarusFragmentTtsFeedbackBinding r19 = this.d;
        if (r19 == null) goto L66;
        e1.d(r19.b, new e(this));
        e1.d(r19.c, new f(this));
        return;
    L66:
        return;
    L21:
        r12 = null;
        goto L22
    L16:
        e0 r20 = (e0) AuthModelDelegate.b.e().getValue();
        if (r20 == null) goto L21;
        LaunchInfo r21 = r20.a;
        if (r21 == null) goto L21;
        r12 = r21.u1();
        goto L22
    L8:
        r10 = null;
        goto L9
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562438, r8, false);
        int r11 = 2131366984;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r10, 2131366984);
        if (r2 == null) goto L13;
        r11 = 2131367598;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131367598);
        if (r3 == null) goto L13;
        r11 = 2131384070;
        RecyclerView r4 = ViewBindings.findChildViewById(r10, 2131384070);
        if (r4 == null) goto L13;
        r11 = 2131388772;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131388772);
        if (r5 == null) goto L13;
        LinearLayout r12 = (LinearLayout) r10;
        this.d = new LarusFragmentTtsFeedbackBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
