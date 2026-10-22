package com.larus.extension.chat_extension.impl.ltm;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.extension.chat_extension.impl.databinding.LarusLayoutChatLtmHitBinding;
import com.larus.im.bean.bot.BotUpdateType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmHitFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "currentPage", "", "previousPage", "botID", "conversationId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/larus/extension/chat_extension/impl/databinding/LarusLayoutChatLtmHitBinding;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bottomSheet", "onStart", "onViewCreated", "view", "setupText", "setupMob", "setupListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmHitFragment extends BottomSheetDialogFragment implements by7.e {
    public static final /* synthetic */ int j = 0;
    public String d;
    public String e;
    public String f;
    public String g;
    public LarusLayoutChatLtmHitBinding h;
    public View i;

    public static final class a {
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        View r0 = this.i;
        if (r0 == null) goto L7;
        BottomSheetBehavior r1 = BottomSheetBehavior.from(r0);
        r1.setSkipCollapsed(true);
        r1.setState(3);
        r1.setHideable(true);
        return;
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public ChatLtmHitFragment() {
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        this.d = r3.getString("currentPage");
        this.e = r3.getString("previousPage");
        this.f = r3.getString("botID");
        this.g = r3.getString("conversationId");
        return;
    }

    public final void onViewCreated(View r34, Bundle r35) {
        Intrinsics.checkNotNullParameter(r34, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r34, r35);
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(2131368870);
    L6:
        this.i = r1;
        String r2 = this.f;
        String r3 = this.g;
        String r4 = this.d;
        String r5 = this.e;
        boolean r6 = o3.a;
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "params");
        if (r2 != null) goto L36;
    L11:
        if (r3 == null) goto L13;
        r7.put("conversation_id", r3);     // Catch: JSONException -> L9
    L13:
        if (r4 == null) goto L15;
        r7.put("current_page", r4);     // Catch: JSONException -> L9
    L15:
        if (r5 == null) goto L19;
        r7.put("previous_page", r5);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper mobShowMemoryWelcomeWindow " + e.getLocalizedMessage());
    L19:
        TrackParams r8 = new TrackParams().merge(r7);
        by7.a r9 = new by7.a("show_memory_welcome_window");
        r9.a.merge(r8);
        r9.b();
        String r10 = this.f;
        if (r10 == null) goto L22;
        com.larus.im.d.a().updateBot(new uc9.s(BotUpdateType.MODIFY_LTM_STATUS, r10, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.FALSE, null, null, 58720252), null);
    L22:
        LarusLayoutChatLtmHitBinding r11 = this.h;
        if (r11 == null) goto L27;
        AppCompatTextView r12 = r11.f;
        if (r12 == null) goto L27;
        e1.d(r12, new j(this));
    L27:
        LarusLayoutChatLtmHitBinding r13 = this.h;
        if (r13 == null) goto L32;
        AppCompatTextView r14 = r13.g;
        if (r14 == null) goto L32;
        e1.d(r14, new k(this));
    L32:
        LarusLayoutChatLtmHitBinding r15 = this.h;
        if (r15 == null) goto L38;
        AppCompatTextView r16 = r15.h;
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        r16.setText(String.format(getString(2131907363), Arrays.copyOf(new Object[]{getString(2131894309)}, 1)));
        r15.c.setText(String.format(getString(2131907383), Arrays.copyOf(new Object[]{getString(2131894309)}, 1)));
        r15.b.setText(String.format(getString(2131907382), Arrays.copyOf(new Object[]{getString(2131894309)}, 1)));
        r15.d.setText(String.format(getString(2131907380), Arrays.copyOf(new Object[]{getString(2131894309)}, 1)));
        r15.e.setText(String.format(getString(2131907377), Arrays.copyOf(new Object[]{getString(2131894309)}, 1)));
        return;
    L38:
        return;
    L36:
        r7.put("bot_id", r2);     // Catch: JSONException -> L9
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562777, r11, false);
        int r14 = 2131375690;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r13, 2131375690);
        if (r2 == null) goto L31;
        r14 = 2131375691;
        if (ViewBindings.findChildViewById(r13, 2131375691) == null) goto L31;
        r14 = 2131375692;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r13, 2131375692);
        if (r3 == null) goto L31;
        r14 = 2131375693;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r13, 2131375693);
        if (r4 == null) goto L31;
        r14 = 2131375694;
        if (ViewBindings.findChildViewById(r13, 2131375694) == null) goto L31;
        r14 = 2131375695;
        if (ViewBindings.findChildViewById(r13, 2131375695) == null) goto L31;
        r14 = 2131375696;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r13, 2131375696);
        if (r5 == null) goto L31;
        r14 = 2131375697;
        if (ViewBindings.findChildViewById(r13, 2131375697) == null) goto L31;
        r14 = 2131375698;
        if (ViewBindings.findChildViewById(r13, 2131375698) == null) goto L31;
        r14 = 2131377787;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r13, 2131377787);
        if (r6 == null) goto L31;
        r14 = 2131384577;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r13, 2131384577);
        if (r7 == null) goto L31;
        r14 = 2131388772;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r13, 2131388772);
        if (r8 == null) goto L31;
        r14 = 2131389158;
        if (ViewBindings.findChildViewById(r13, 2131389158) == null) goto L31;
        ConstraintLayout r15 = r13;
        this.h = new LarusLayoutChatLtmHitBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
